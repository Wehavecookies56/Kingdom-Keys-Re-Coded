package wehavecookies56.kk.util;

import java.util.Iterator;
import java.util.Map;
import java.util.Random;

import net.minecraft.client.Minecraft;
import net.minecraft.client.audio.PositionedSound;
import net.minecraft.client.audio.SoundHandler;
import net.minecraft.client.audio.SoundManager;
import net.minecraft.client.gui.GuiLanguage;
import net.minecraft.client.gui.GuiMainMenu;
import net.minecraft.client.gui.GuiMultiplayer;
import net.minecraft.client.gui.GuiScreenServerList;
import net.minecraft.client.gui.GuiSelectWorld;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.GuiModList;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent.ClientTickEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent.Phase;
import net.minecraftforge.fml.relauncher.ReflectionHelper;
import wehavecookies56.kk.lib.Music;
import wehavecookies56.kk.lib.Reference;

public class ClientEventHandler {
	Random rand = new Random();
	PositionedSound posSound;
	PositionedSound vanillaSound;
	ResourceLocation resLoc = new ResourceLocation(Reference.MODID, "");
	boolean[] played = { false };
	boolean[] bossBattlePlayed = { false };
	boolean[] battlePlayed = { false };
	boolean[] menuPlayed = { false, false, false, false, false, false, false, false, false };
	int interval = 100;

	int clientTick = 0;
	float volume = 1.0f;

	@SubscribeEvent (priority = EventPriority.HIGHEST)
	public void clientTick (ClientTickEvent event) {
		// System.out.println("Battle Played: "+this.battlePlayed[0]);

		clientTick++;
		if (event.phase == Phase.END) if (!(Minecraft.getMinecraft().currentScreen instanceof GuiMainMenu || Minecraft.getMinecraft().currentScreen instanceof GuiModList || Minecraft.getMinecraft().currentScreen instanceof GuiScreenServerList || Minecraft.getMinecraft().currentScreen instanceof GuiMultiplayer || Minecraft.getMinecraft().currentScreen instanceof GuiLanguage || Minecraft.getMinecraft().currentScreen instanceof GuiSelectWorld)) {
			SoundManager soundManager = ReflectionHelper.getPrivateValue(SoundHandler.class, Minecraft.getMinecraft().getSoundHandler(), "sndManager", "field_147694_f");
			Map playingSounds = ReflectionHelper.getPrivateValue(SoundManager.class, soundManager, "playingSounds", "field_148629_h");
			Iterator iter = playingSounds.keySet().iterator();

			while (iter.hasNext()) {
				Object o = iter.next();
				if (playingSounds.get(o) instanceof PositionedSound) {
					this.posSound = (PositionedSound) playingSounds.get(o);
					this.vanillaSound = (PositionedSound) playingSounds.get(o);
					this.resLoc = ReflectionHelper.getPrivateValue(PositionedSound.class, this.posSound, "positionedSoundLocation", "field_147664_a");
				}
			}

			if ("music.game".equals(resLoc.getResourcePath()) || "music.game.creative".equals(resLoc.getResourcePath())) {
				Minecraft.getMinecraft().getSoundHandler().stopSound(this.posSound);
				this.posSound = Music.lazyAfternoons;
				this.resLoc = new ResourceLocation(Reference.MODID, "");
			}
			//TODO implement this boss thing into this hard file
			if (!EventHandler.isBoss) {
				Minecraft.getMinecraft().getSoundHandler().stopSound(Music.sinisterSundown);
				this.bossBattlePlayed[0] = false;
			}
			
			if (!EventHandler.isHostiles) {
				Minecraft.getMinecraft().getSoundHandler().stopSound(Music.sinisterSundown);
				this.battlePlayed[0] = false;

				// System.out.println("Lazy afternoons");
				/*
				 * if(!Minecraft.getMinecraft().getSoundHandler().
				 * isSoundPlaying(Music.lazyAfternoons) &&
				 * !"music.game".equals(this.resLoc.getResourcePath()) &&
				 * !"music.game.creative".equals(this.resLoc.getResourcePath
				 * ())) { if(!this.played[0]){
				 * Minecraft.getMinecraft().getSoundHandler().stopSound(
				 * Music.sinisterSundown);
				 * Minecraft.getMinecraft().getSoundHandler().playSound(
				 * Music.lazyAfternoons); for(int i = 0; i < this.played.length;
				 * i++){ this.played[i] = false; } //this.played[0] = true; } }
				 */

				/*
				 * if(this.day && !this.raining) { if(this.rand.nextInt(2) == 0
				 * && !this.played[0]) {
				 * Minecraft.getMinecraft().getSoundHandler().playSound(
				 * Sounds.posDay1); for(int i = 0; i < this.played.length; i++)
				 * { this.played[i] = false; } this.played[0] = true; } else
				 * if(!this.played[1]) {
				 * Minecraft.getMinecraft().getSoundHandler().playSound(
				 * Sounds.posDay2); for(int i = 0; i < this.played.length; i++)
				 * { this.played[i] = false; } this.played[1] = true; } }
				 * //Night if(!this.day && !this.raining) {
				 * if(this.rand.nextInt(2) == 0 && !this.played[2]) {
				 * Minecraft.getMinecraft().getSoundHandler().playSound(
				 * Sounds.posNight1); for(int i = 0; i < this.played.length;
				 * i++) { this.played[i] = false; } this.played[2] = true; }
				 * else if(!this.played[3]) {
				 * Minecraft.getMinecraft().getSoundHandler().playSound(
				 * Sounds.posNight2); for(int i = 0; i < this.played.length;
				 * i++) { this.played[i] = false; } this.played[3] = true; } }
				 * //Raining if(this.raining) { if(this.rand.nextInt(2) == 0 &&
				 * !this.played[4]) {
				 * Minecraft.getMinecraft().getSoundHandler().playSound(
				 * Music.song); for(int i = 0; i < this.played.length; i++) {
				 * this.played[i] = false; } this.played[4] = true; } else
				 * if(!this.played[5]) {
				 * Minecraft.getMinecraft().getSoundHandler().playSound(
				 * Music.song); for(int i = 0; i < this.played.length; i++) {
				 * this.played[i] = false; } this.played[5] = true; } }
				 */
			} else if (EventHandler.isHostiles) if (!Minecraft.getMinecraft().getSoundHandler().isSoundPlaying(Music.sinisterSundown) && !"music.game".equals(this.resLoc.getResourcePath()) && !"music.game.creative".equals(this.resLoc.getResourcePath())) if (!this.battlePlayed[0]) {

				Minecraft.getMinecraft().getSoundHandler().playSound(Music.sinisterSundown);
				for (int i = 0; i < this.battlePlayed.length; i++)
					this.battlePlayed[i] = false;
				this.battlePlayed[0] = true;
			}
		} else {
			SoundManager soundManager = ReflectionHelper.getPrivateValue(SoundHandler.class, Minecraft.getMinecraft().getSoundHandler(), "sndManager", "field_147694_f");
			Map playingSounds = ReflectionHelper.getPrivateValue(SoundManager.class, soundManager, "playingSounds", "field_148629_h");
			Iterator iter = playingSounds.keySet().iterator();

			while (iter.hasNext()) {
				Object o = iter.next();
				if (playingSounds.get(o) instanceof PositionedSound) {
					if (((PositionedSound) playingSounds.get(o)).getSoundLocation().getResourcePath().equals("music.menu")) Minecraft.getMinecraft().getSoundHandler().stopSound(((PositionedSound) playingSounds.get(o)));
					this.posSound = (PositionedSound) playingSounds.get(o);
					this.resLoc = ReflectionHelper.getPrivateValue(PositionedSound.class, this.posSound, "positionedSoundLocation", "field_147664_a");
				}
			}

			if ("music.menu".equals(resLoc.getResourcePath())) {
				Minecraft.getMinecraft().getSoundHandler().stopSound(this.posSound);
				this.posSound = Music.dearlyBelovedKH1;
				this.resLoc = new ResourceLocation(Reference.MODID, "");
			}
			if (!Minecraft.getMinecraft().getSoundHandler().isSoundPlaying(Music.dearlyBelovedDDD) && 
				!Minecraft.getMinecraft().getSoundHandler().isSoundPlaying(Music.dearlyBelovedBBS) && 
				!Minecraft.getMinecraft().getSoundHandler().isSoundPlaying(Music.dearlyBelovedKH1) && 
				!Minecraft.getMinecraft().getSoundHandler().isSoundPlaying(Music.dearlyBelovedKH2) && 
				!Minecraft.getMinecraft().getSoundHandler().isSoundPlaying(Music.dearlyBelovedReCoM) && 
				!Minecraft.getMinecraft().getSoundHandler().isSoundPlaying(Music.dearlyBelovedCoM) && 
				!Minecraft.getMinecraft().getSoundHandler().isSoundPlaying(Music.dearlyBelovedCoded) && 
				!Minecraft.getMinecraft().getSoundHandler().isSoundPlaying(Music.dearlyBelovedDays) && 
				!Minecraft.getMinecraft().getSoundHandler().isSoundPlaying(Music.dearlyBelovedCHI) && 
				!"music.menu".equals(this.resLoc.getResourcePath())) {
				
				int r = randomWithRange(0, 8);
				if (resLoc.getResourcePath().contains("music.menu")) Minecraft.getMinecraft().getSoundHandler().stopSound(this.posSound);
				Minecraft.getMinecraft().getSoundHandler().stopSound(this.posSound);
				if (r == 0 && !this.menuPlayed[0]) {
					Minecraft.getMinecraft().getSoundHandler().playSound(Music.dearlyBelovedKH1);
					for (int i = 0; i < this.menuPlayed.length; i++)
						this.menuPlayed[i] = false;
					this.menuPlayed[0] = true;
				} else if (r == 1 && !this.menuPlayed[1]) {
					Minecraft.getMinecraft().getSoundHandler().playSound(Music.dearlyBelovedKH2);
					for (int i = 0; i < this.menuPlayed.length; i++)
						this.menuPlayed[i] = false;
					this.menuPlayed[1] = true;
				} else if (r == 2 && !this.menuPlayed[2]) {
					Minecraft.getMinecraft().getSoundHandler().playSound(Music.dearlyBelovedBBS);
					for (int i = 0; i < this.menuPlayed.length; i++)
						this.menuPlayed[i] = false;
					this.menuPlayed[2] = true;
				} else if (r == 3 && !this.menuPlayed[3]) {
					Minecraft.getMinecraft().getSoundHandler().playSound(Music.dearlyBelovedDDD);
					for (int i = 0; i < this.menuPlayed.length; i++)
						this.menuPlayed[i] = false;
					this.menuPlayed[3] = true;
				} else if (r == 4 && !this.menuPlayed[4]) {
					Minecraft.getMinecraft().getSoundHandler().playSound(Music.dearlyBelovedDays);
					for (int i = 0; i < this.menuPlayed.length; i++)
						this.menuPlayed[i] = false;
					this.menuPlayed[4] = true;
				} else if (r == 5 && !this.menuPlayed[5]) {
					Minecraft.getMinecraft().getSoundHandler().playSound(Music.dearlyBelovedCoded);
					for (int i = 0; i < this.menuPlayed.length; i++)
						this.menuPlayed[i] = false;
					this.menuPlayed[5] = true;
				} else if (r == 6 && !this.menuPlayed[6]) {
					Minecraft.getMinecraft().getSoundHandler().playSound(Music.dearlyBelovedCoM);
					for (int i = 0; i < this.menuPlayed.length; i++)
						this.menuPlayed[i] = false;
					this.menuPlayed[6] = true;
				} else if (r == 7 && !this.menuPlayed[7]) {
					Minecraft.getMinecraft().getSoundHandler().playSound(Music.dearlyBelovedReCoM);
					for (int i = 0; i < this.menuPlayed.length; i++)
						this.menuPlayed[i] = false;
					this.menuPlayed[7] = true;
				} else if (r == 8 && !this.menuPlayed[8]) {
					Minecraft.getMinecraft().getSoundHandler().playSound(Music.dearlyBelovedCHI);
					for (int i = 0; i < this.menuPlayed.length; i++)
						this.menuPlayed[i] = false;
					this.menuPlayed[8] = true;
				}
			}
		}
	}

	public static int randomWithRange (int min, int max) {
		int range = Math.abs(max - min) + 1;
		return (int) (Math.random() * range) + (min <= max ? min : max);
	}
}