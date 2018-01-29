package uk.co.wehavecookies56.kk.client.core.handler;

import java.util.Random;

import net.minecraft.client.Minecraft;
import net.minecraft.client.audio.ISound;
import net.minecraft.client.audio.PositionedSoundRecord;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ITickable;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.DimensionType;
import uk.co.wehavecookies56.kk.client.sound.ModSounds;
import uk.co.wehavecookies56.kk.common.world.dimension.ModDimensions;

public class MusicHandler implements ITickable {

    private final Random rand = new Random();
    private final Minecraft mc;
    private ISound currentlyPlaying;
    private int timeUntilNextMusic = 30;

    public static SoundEvent[] menuMusic = {ModSounds.Music_Dearly_Beloved_KH1, ModSounds.Music_Dearly_Beloved_KH2, ModSounds.Music_Dearly_Beloved_BBS, ModSounds.Music_Dearly_Beloved_CHI, ModSounds.Music_Dearly_Beloved_Coded, ModSounds.Music_Dearly_Beloved_CoM, ModSounds.Music_Dearly_Beloved_Days, ModSounds.Music_Dearly_Beloved_DDD, ModSounds.Music_Dearly_Beloved_ReCoM};

    public static SoundEvent[] overworldMusic = {ModSounds.Music_Lazy_Afternoons, ModSounds.Music_Deep_Jungle, ModSounds.Music_Welcome_To_Wonderland, ModSounds.Music_A_Day_In_Agrabah, ModSounds.Music_A_Very_Small_Wish, ModSounds.Music_Destiny_Islands, ModSounds.Music_Adventures_In_The_Savannah, ModSounds.Music_The_Secret_Whispers, ModSounds.Music_The_Silent_Forest, ModSounds.Music_What_A_Surprise};

    public static SoundEvent[] netherMusic = {ModSounds.Music_The_Underworld, ModSounds.Music_Keyblade_Graveyard_Horizon, ModSounds.Music_This_Is_Halloween, ModSounds.Music_Night_In_The_Dark_Dream};

    public static SoundEvent[] endMusic = {ModSounds.Music_Mystic_Moon, ModSounds.Music_Sacred_Moon, ModSounds.Music_Sacred_Moon_Days, ModSounds.Music_Sacred_Distance};

    public static SoundEvent[] soaMusic = {ModSounds.Music_Dive_Into_The_Heart_Destati};

    public static SoundEvent[] destinyIslandsMusic = {ModSounds.Music_Destiny_Islands};

    public static SoundEvent[] traverseTownMusic = {ModSounds.Music_Traverse_Town, ModSounds.Music_Traverse_In_Trance};

    public MusicHandler(Minecraft mc) {
        this.mc = mc;
    }
    SoundEvent music;

    public boolean dimensionMusic(int dim, MusicType type, EntityPlayer player) {
        if (mc.world != null && mc.player != null) {
            if (player.dimension == dim) {
                stopAllMusicExcept(type);
                music = getRandomTrack(type);
                if (currentlyPlaying != null) {
                    if (!mc.getSoundHandler().isSoundPlaying(currentlyPlaying)) {
                        currentlyPlaying = null;
                        timeUntilNextMusic = Math.min(timeUntilNextMusic, type.delay);
                    }
                }
                timeUntilNextMusic = Math.min(timeUntilNextMusic, type.delay);

                if (currentlyPlaying == null && timeUntilNextMusic-- <= 0) {
                    playMusic(music, type);
                }
                return true;
            }
        }
        return false;
    }

    public boolean menuMusic() {
        if (mc.world == null && mc.player == null) {
            stopAllMusicExcept(MusicType.MENU);
            music = getRandomTrack(MusicType.MENU);
            if (currentlyPlaying != null) {
                if (!mc.getSoundHandler().isSoundPlaying(currentlyPlaying)) {
                    currentlyPlaying = null;
                    timeUntilNextMusic = Math.min(timeUntilNextMusic, MusicType.MENU.delay);
                }
            }
            timeUntilNextMusic = Math.min(timeUntilNextMusic, MusicType.MENU.delay);

            if (currentlyPlaying == null && timeUntilNextMusic-- <= 0) {
                playMusic(music, MusicType.MENU);
            }
            return true;
        }
        stopMusicType(MusicType.MENU);
        return false;
    }

    public void stopAllMusicExcept(MusicType type) {
        for (int i = 0; i < MusicType.values().length; i++) {
            if (MusicType.values()[i] != type) {
                stopMusicType(MusicType.values()[i]);
            }
        }
    }

    @Override
    public void update() {
        if (menuMusic());
        else if (dimensionMusic(DimensionType.OVERWORLD.getId(), MusicType.OVERWORLD, mc.player));
        else if (dimensionMusic(DimensionType.NETHER.getId(), MusicType.NETHER, mc.player));
        else if (dimensionMusic(DimensionType.THE_END.getId(), MusicType.END, mc.player));
        else if (dimensionMusic(ModDimensions.diveToTheHeartID, MusicType.SOA, mc.player));
        else if (dimensionMusic(ModDimensions.destinyIslandsID, MusicType.DESTINYISLANDS, mc.player));
        else if (dimensionMusic(ModDimensions.traverseTownID, MusicType.TRAVERSETOWN, mc.player));
        else stopMusic();
    }

    public boolean isPlaying() {
        return currentlyPlaying != null;
    }

    public ResourceLocation getCurrentlyPlaying() {
        if (isPlaying()) {
            return currentlyPlaying.getSoundLocation();
        } else {
            return null;
        }
    }

    public SoundEvent getRandomTrack(MusicType type) {
        int num = 0;
        if (type.getMusic().length != 1) {
            num = rand.nextInt(type.getMusic().length-1);
        }
        return type.getMusic()[num];
    }

    public int getTimeUntilNextMusic() {
        return timeUntilNextMusic;
    }

    public void playMusic(SoundEvent music, MusicType type) {
        currentlyPlaying = PositionedSoundRecord.getMusicRecord(music);
        for (int i = 0; i < type.getMusic().length; i++) {
            if (mc.getSoundHandler().isSoundPlaying(PositionedSoundRecord.getMusicRecord(type.getMusic()[i]))) {
                return;
            }
        }
        if (!mc.getSoundHandler().isSoundPlaying(currentlyPlaying)) {
            mc.getSoundHandler().playSound(currentlyPlaying);
        }
        timeUntilNextMusic = type.delay;
    }

    public void stopMusic() {
        if (currentlyPlaying != null) {
            mc.getSoundHandler().stopSound(currentlyPlaying);
            currentlyPlaying = null;
            timeUntilNextMusic = 0;
        }
    }

    public void stopMusicType(MusicType type) {
        if (currentlyPlaying != null) {
            for (int i = 0; i < type.getMusic().length; i++) {
                if (mc.getSoundHandler().isSoundPlaying(PositionedSoundRecord.getMusicRecord(type.getMusic()[i]))) {
                    mc.getSoundHandler().stopSound(currentlyPlaying);
                    currentlyPlaying = null;
                    timeUntilNextMusic = 0;
                }
            }
        }
    }

    public void stopSound(ISound sound) {
        mc.getSoundHandler().stopSound(sound);
    }

    public enum MusicType {
        MENU(menuMusic, 30),
        OVERWORLD(overworldMusic, 1000),
        NETHER(netherMusic, 1000),
        END(endMusic, 1000),
        SOA(soaMusic, 30),
        DESTINYISLANDS(destinyIslandsMusic, 30),
        TRAVERSETOWN(traverseTownMusic, 30);

        public SoundEvent[] music;
        int delay;

        private MusicType(SoundEvent[] music, int delay) {
            this.music = music;
            this.delay = delay;
        }

        public SoundEvent[] getMusic() {
            return music;
        }
    }

}
