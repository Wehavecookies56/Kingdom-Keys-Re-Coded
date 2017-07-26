package uk.co.wehavecookies56.kk.client.sound;

import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import uk.co.wehavecookies56.kk.common.lib.Reference;

public class ModSounds {

    public static final SoundEvent
        kupo = registerSound("kupo"),
        kupoliving = registerSound("kupoliving"),
        lockon = registerSound("lockon"),
        itemget = registerSound("itemget"),
        levelup = registerSound("levelup"),
        summon = registerSound("summon"),
        alarm = registerSound("alarm"),
        unsummon = registerSound("unsummon"),
        sharpshooterbullet = registerSound("sharpshooterbullet"),
        error = registerSound("error"),
        select = registerSound("select"),
        cancel = registerSound("cancel"),
        move = registerSound("move"),
        drive = registerSound("drive"),
        antidrive = registerSound("antidrive"),
        potion = registerSound("potion"),
        savepoint = registerSound("savepoint"),
        savespawn = registerSound("savespawn"),
        Birth_by_Sleep_A_Link_to_the_Future = registerSound("records.Birth by Sleep -A Link to the Future-"),
        Darkness_of_the_Unknown = registerSound("records.Darkness of the Unknown"),
        Dearly_Beloved_Symphony_Version = registerSound("records.Dearly Beloved -Symphony Version-"),
        Dream_Drop_Distance_The_Next_Awakening = registerSound("records.Dream Drop Distance -The Next Awakening-"),
        Hikari_KINGDOM_Instrumental_Version = registerSound("records.Hikari -KINGDOM Instrumental Version-"),
        L_Oscurita_Dell_Ignoto = registerSound("records.L'Oscurita Dell'Ignoto"),
        Musique_pour_la_tristesse_de_Xion = registerSound("records.Musique pour la tristesse de Xion"),
        No_More_Bugs_Bug_Version = registerSound("records.No More Bugs -Bug Version-"),
        Organization_XIII = registerSound("records.Organization XIII"),
        Sanctuary = registerSound("records.Sanctuary"),
        Simple_And_Clean_PLANITb_Remix = registerSound("records.Simple And Clean PLANITb Remix"),
        Sinister_Sundown = registerSound("records.Sinister Sundown"),
        The_13th_Anthology = registerSound("records.The 13th Anthology")
    ;

    public static SoundEvent registerSound(String name) {
        final ResourceLocation soundID = new ResourceLocation(Reference.MODID, name);
        return new SoundEvent(soundID).setRegistryName(soundID);
    }
    @Mod.EventBusSubscriber(modid = Reference.MODID)
    public static class register {

        @SubscribeEvent
        public void registerSounds(RegistryEvent.Register<SoundEvent> event) {
            event.getRegistry().registerAll( kupo, kupoliving, lockon, itemget, levelup, summon, alarm, unsummon, sharpshooterbullet, error, select, cancel, move, drive, antidrive, potion, savepoint, savespawn, Birth_by_Sleep_A_Link_to_the_Future, Darkness_of_the_Unknown, Dearly_Beloved_Symphony_Version, Dream_Drop_Distance_The_Next_Awakening, Hikari_KINGDOM_Instrumental_Version, L_Oscurita_Dell_Ignoto, Musique_pour_la_tristesse_de_Xion, No_More_Bugs_Bug_Version, Organization_XIII, Sanctuary, Simple_And_Clean_PLANITb_Remix, Sinister_Sundown, The_13th_Anthology);
        }

    }
}
