package uk.co.wehavecookies56.kk.client.sound;

import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
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
            Record_Birth_by_Sleep_A_Link_to_the_Future = registerSound("records.birth by sleep -a link to the future-"),
            Record_Darkness_of_the_Unknown = registerSound("records.darkness of the unknown"),
            Record_Dearly_Beloved_Symphony_Version = registerSound("records.dearly beloved -symphony version-"),
            Record_Dream_Drop_Distance_The_Next_Awakening = registerSound("records.dream drop distance -the next awakening-"),
            Record_Hikari_KINGDOM_Instrumental_Version = registerSound("records.hikari -kingdom instrumental version-"),
            Record_L_Oscurita_Dell_Ignoto = registerSound("records.l'oscurita dell'ignoto"),
            Record_Musique_pour_la_tristesse_de_Xion = registerSound("records.musique pour la tristesse de xion"),
            Record_No_More_Bugs_Bug_Version = registerSound("records.no more bugs -bug version-"),
            Record_Organization_XIII = registerSound("records.organization xiii"),
            Record_Sanctuary = registerSound("records.sanctuary"),
            Record_Simple_And_Clean_PLANITb_Remix = registerSound("records.simple and clean planitb remix"),
            Record_Sinister_Sundown = registerSound("records.sinister sundown"),
            Record_The_13th_Anthology = registerSound("records.the 13th anthology"),
            Music_A_Day_In_Agrabah = registerSound("music.a day in agrabah"),
            Music_A_Fight_To_The_Death = registerSound("music.a fight to the the death"),
            Music_A_Very_Small_Wish = registerSound("music.a very small wish"),
            Music_Adventures_In_The_Savannah = registerSound("music.adventures in the savannah"),
            Music_Arabian_Dream = registerSound("music.arabian dream"),
            Music_Beneath_The_Ground = registerSound("music.beneath the ground"),
            Music_Critical_Drive = registerSound("music.critical drive"),
            Music_Dark_Impetus = registerSound("music.dark impetus"),
            Music_Dearly_Beloved_BBS = registerSound("music.dearly beloved (bbs)"),
            Music_Dearly_Beloved_CHI = registerSound("music.dearly beloved (chi)"),
            Music_Dearly_Beloved_Coded = registerSound("music.dearly beloved (coded)"),
            Music_Dearly_Beloved_CoM = registerSound("music.dearly beloved (com)"),
            Music_Dearly_Beloved_Days = registerSound("music.dearly beloved (days)"),
            Music_Dearly_Beloved_DDD = registerSound("music.dearly beloved (ddd)"),
            Music_Dearly_Beloved_KH1 = registerSound("music.dearly beloved (kh1)"),
            Music_Dearly_Beloved_KH2 = registerSound("music.dearly beloved (kh2)"),
            Music_Dearly_Beloved_ReCoM = registerSound("music.dearly beloved (recom)"),
            Music_Deep_Drive = registerSound("music.deep drive"),
            Music_Deep_Drop = registerSound("music.deep drop"),
            Music_Deep_Jungle = registerSound("music.deep jungle"),
            Music_Destiny_Islands = registerSound("music.destiny islands"),
            Music_Dive_Into_The_Heart_Destati = registerSound("music.dive into the heart -destati-"),
            Music_Hand_In_Hand = registerSound("music.hand in hand"),
            Music_Happy_Holidays = registerSound("music.happy holidays!"),
            Music_Having_A_Wild_Time = registerSound("music.having a wild time"),
            Music_Keyblade_Graveyard_Horizon = registerSound("music.keyblade graveyard horizon"),
            Music_Lazy_Afternoons = registerSound("music.lazy afternoons"),
            Music_L_Impeto_Oscuro = registerSound("music.l'impeto oscuro"),
            Music_L_Oscurita_Dell_Ignoto = registerSound("music.l'oscurita dell'ignoto"),
            Music_Monstrous_Monstro = registerSound("music.monstrous monstro"),
            Music_Mystic_Moon = registerSound("music.mystic moon"),
            Music_Night_In_The_Dark_Dream = registerSound("music.night in the dark dream"),
            Music_Night_Of_Fate = registerSound("music.night of fate"),
            Music_Night_Of_Tragedy = registerSound("music.night of tragedy"),
            Music_Rage_Awakened = registerSound("music.rage awakened"),
            Music_Risky_Romp = registerSound("music.risky romp"),
            Music_Sacred_Distance = registerSound("music.sacred distance"),
            Music_Sacred_Moon_Days = registerSound("music.sacred moon (days)"),
            Music_Sacred_Moon = registerSound("music.sacred moon"),
            Music_Savannah_Pride = registerSound("music.savannah pride"),
            Music_Sinister_Sundown = registerSound("music.sinister sundown"),
            Music_Spooks_Of_Halloween_Town = registerSound("music.spooks of halloween town"),
            Music_Tension_Rising = registerSound("music.tension rising"),
            Music_The_Dread_Of_Night = registerSound("music.the dread of night"),
            Music_The_Rustling_Forest = registerSound("music.the rustling forest"),
            Music_The_Secret_Whispers = registerSound("music.the secret whispers"),
            Music_The_Silent_Forest = registerSound("music.the silent forest"),
            Music_The_Underworld = registerSound("music.the underworld"),
            Music_This_Is_Halloween = registerSound("music.this is halloween"),
            Music_To_Our_Surprise = registerSound("music.to our surprise"),
            Music_Traverse_In_Trance = registerSound("music.traverse in trance"),
            Music_Traverse_Town = registerSound("music.traverse town"),
            Music_Welcome_To_Wonderland = registerSound("music.welcome to wonderland"),
            Music_What_A_Surprise = registerSound("music.what a surprise!"),
            Music_What_Lies_Beneath = registerSound("music.what lies beneath"),
            Music_Working_Together = registerSound("music.working together")
            ;

    public static SoundEvent registerSound(String name) {
        final ResourceLocation soundID = new ResourceLocation(Reference.MODID, name);
        return new SoundEvent(soundID).setRegistryName(soundID);
    }
    @Mod.EventBusSubscriber(modid = Reference.MODID)
    public static class register {

        @SubscribeEvent
        public static void registerSounds(RegistryEvent.Register<SoundEvent> event) {
            event.getRegistry().registerAll(
                    kupo,
                    kupoliving,
                    lockon,
                    itemget,
                    levelup,
                    summon,
                    alarm,
                    unsummon,
                    sharpshooterbullet,
                    error,
                    select,
                    cancel,
                    move,
                    drive,
                    antidrive,
                    potion,
                    savepoint,
                    savespawn,
                    Record_Birth_by_Sleep_A_Link_to_the_Future,
                    Record_Darkness_of_the_Unknown,
                    Record_Dearly_Beloved_Symphony_Version,
                    Record_Dream_Drop_Distance_The_Next_Awakening,
                    Record_Hikari_KINGDOM_Instrumental_Version,
                    Record_L_Oscurita_Dell_Ignoto,
                    Record_Musique_pour_la_tristesse_de_Xion,
                    Record_No_More_Bugs_Bug_Version,
                    Record_Organization_XIII,
                    Record_Sanctuary,
                    Record_Simple_And_Clean_PLANITb_Remix,
                    Record_Sinister_Sundown,
                    Record_The_13th_Anthology,
                    Music_A_Day_In_Agrabah,
                    Music_A_Fight_To_The_Death,
                    Music_A_Very_Small_Wish,
                    Music_Adventures_In_The_Savannah,
                    Music_Arabian_Dream,
                    Music_Beneath_The_Ground,
                    Music_Critical_Drive,
                    Music_Dark_Impetus,
                    Music_Dearly_Beloved_BBS,
                    Music_Dearly_Beloved_CHI,
                    Music_Dearly_Beloved_Coded,
                    Music_Dearly_Beloved_CoM,
                    Music_Dearly_Beloved_Days,
                    Music_Dearly_Beloved_DDD,
                    Music_Dearly_Beloved_KH1,
                    Music_Dearly_Beloved_KH2,
                    Music_Dearly_Beloved_ReCoM,
                    Music_Deep_Drive,
                    Music_Deep_Drop,
                    Music_Deep_Jungle,
                    Music_Destiny_Islands,
                    Music_Dive_Into_The_Heart_Destati,
                    Music_Hand_In_Hand,
                    Music_Happy_Holidays,
                    Music_Having_A_Wild_Time,
                    Music_Keyblade_Graveyard_Horizon,
                    Music_Lazy_Afternoons,
                    Music_L_Impeto_Oscuro,
                    Music_L_Oscurita_Dell_Ignoto,
                    Music_Monstrous_Monstro,
                    Music_Mystic_Moon,
                    Music_Night_In_The_Dark_Dream,
                    Music_Night_Of_Fate,
                    Music_Night_Of_Tragedy,
                    Music_Rage_Awakened,
                    Music_Risky_Romp,
                    Music_Sacred_Distance,
                    Music_Sacred_Moon_Days,
                    Music_Sacred_Moon,
                    Music_Savannah_Pride,
                    Music_Sinister_Sundown,
                    Music_Spooks_Of_Halloween_Town,
                    Music_Tension_Rising,
                    Music_The_Dread_Of_Night,
                    Music_The_Rustling_Forest,
                    Music_The_Secret_Whispers,
                    Music_The_Silent_Forest,
                    Music_The_Underworld,
                    Music_This_Is_Halloween,
                    Music_To_Our_Surprise,
                    Music_Traverse_In_Trance,
                    Music_Traverse_Town,
                    Music_Welcome_To_Wonderland,
                    Music_What_A_Surprise,
                    Music_What_Lies_Beneath,
                    Music_Working_Together
            );
        }

    }
}
