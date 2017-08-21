package uk.co.wehavecookies56.kk.common.crafting;

import net.minecraftforge.oredict.OreDictionary;
import uk.co.wehavecookies56.kk.common.block.ModBlocks;
import uk.co.wehavecookies56.kk.common.item.ModItems;

import static net.minecraftforge.oredict.OreDictionary.registerOre;

public class KKOreDictionary {

    public static void registerOres() {

        //Ores
        OreDictionary.registerOre("oreBlazing", ModBlocks.BlazingOre);
        registerOre("oreBright", ModBlocks.BrightOre);
        registerOre("oreDark", ModBlocks.DarkOre);
        registerOre("oreDark", ModBlocks.DarkOreE);
        registerOre("oreDense", ModBlocks.DenseOre);
        registerOre("oreEnergy", ModBlocks.EnergyOre);
        registerOre("oreFrost", ModBlocks.FrostOre);
        registerOre("oreLightning", ModBlocks.LightningOre);
        registerOre("oreLucid", ModBlocks.LucidOre);
        registerOre("orePower", ModBlocks.PowerOre);
        registerOre("orePower", ModBlocks.PowerOreE);
        registerOre("oreRemembrance", ModBlocks.RemembranceOre);
        registerOre("oreSerenity", ModBlocks.SerenityOre);
        registerOre("oreStormy", ModBlocks.StormyOre);
        registerOre("oreTranquil", ModBlocks.TranquilOre);
        registerOre("oreTwilight", ModBlocks.TwilightOre);

        //Records
        OreDictionary.registerOre("record", ModItems.Disc_Birth_by_Sleep_A_Link_to_the_Future);
        registerOre("record", ModItems.Disc_Darkness_of_the_Unknown);
        registerOre("record", ModItems.Disc_Dearly_Beloved_Symphony_Version);
        registerOre("record", ModItems.Disc_Dream_Drop_Distance_The_Next_Awakening);
        registerOre("record", ModItems.Disc_Hikari_KINGDOM_Instrumental_Version);
        registerOre("record", ModItems.Disc_L_Oscurita_Dell_Ignoto);
        registerOre("record", ModItems.Disc_Musique_pour_la_tristesse_de_Xion);
        registerOre("record", ModItems.Disc_No_More_Bugs_Bug_Version);
        registerOre("record", ModItems.Disc_Organization_XIII);
        registerOre("record", ModItems.Disc_Sanctuary);
        registerOre("record", ModItems.Disc_Simple_And_Clean_PLANITb_Remix);
        registerOre("record", ModItems.Disc_Sinister_Sundown);
        registerOre("record", ModItems.Disc_The_13th_Anthology);
    }

}
