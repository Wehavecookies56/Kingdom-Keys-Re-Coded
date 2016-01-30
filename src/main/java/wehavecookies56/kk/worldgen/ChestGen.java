package wehavecookies56.kk.worldgen;

import net.minecraft.item.ItemStack;
import net.minecraft.util.WeightedRandomChestContent;
import net.minecraftforge.common.ChestGenHooks;
import wehavecookies56.kk.item.ModItems;

public class ChestGen {

	public static void init() {
		ChestGenHooks.getInfo(ChestGenHooks.BONUS_CHEST)
				.addItem(new WeightedRandomChestContent(new ItemStack(ModItems.Recipe, 1), 1, 1, 5));
		ChestGenHooks.getInfo(ChestGenHooks.DUNGEON_CHEST)
				.addItem(new WeightedRandomChestContent(new ItemStack(ModItems.Recipe, 1), 1, 1, 10));
		ChestGenHooks.getInfo(ChestGenHooks.MINESHAFT_CORRIDOR)
				.addItem(new WeightedRandomChestContent(new ItemStack(ModItems.Recipe, 1), 1, 1, 5));
		ChestGenHooks.getInfo(ChestGenHooks.NETHER_FORTRESS)
				.addItem(new WeightedRandomChestContent(new ItemStack(ModItems.Recipe, 1), 1, 1, 10));
		ChestGenHooks.getInfo(ChestGenHooks.PYRAMID_DESERT_CHEST)
				.addItem(new WeightedRandomChestContent(new ItemStack(ModItems.Recipe, 1), 1, 1, 5));
		ChestGenHooks.getInfo(ChestGenHooks.PYRAMID_JUNGLE_CHEST)
				.addItem(new WeightedRandomChestContent(new ItemStack(ModItems.Recipe, 1), 1, 1, 5));
		ChestGenHooks.getInfo(ChestGenHooks.PYRAMID_JUNGLE_DISPENSER)
				.addItem(new WeightedRandomChestContent(new ItemStack(ModItems.Recipe, 1), 1, 1, 5));
		ChestGenHooks.getInfo(ChestGenHooks.STRONGHOLD_CORRIDOR)
				.addItem(new WeightedRandomChestContent(new ItemStack(ModItems.Recipe, 1), 1, 1, 5));
		ChestGenHooks.getInfo(ChestGenHooks.STRONGHOLD_CROSSING)
				.addItem(new WeightedRandomChestContent(new ItemStack(ModItems.Recipe, 1), 1, 1, 5));
		ChestGenHooks.getInfo(ChestGenHooks.STRONGHOLD_LIBRARY)
				.addItem(new WeightedRandomChestContent(new ItemStack(ModItems.Recipe, 1), 1, 1, 5));
		ChestGenHooks.getInfo(ChestGenHooks.VILLAGE_BLACKSMITH)
				.addItem(new WeightedRandomChestContent(new ItemStack(ModItems.Recipe, 1), 1, 1, 10));

		ChestGenHooks.getInfo(ChestGenHooks.BONUS_CHEST)
				.addItem(new WeightedRandomChestContent(new ItemStack(ModItems.LevelUpValor, 1), 1, 1, 5));
		ChestGenHooks.getInfo(ChestGenHooks.DUNGEON_CHEST)
				.addItem(new WeightedRandomChestContent(new ItemStack(ModItems.LevelUpValor, 1), 1, 1, 10));
		ChestGenHooks.getInfo(ChestGenHooks.MINESHAFT_CORRIDOR)
				.addItem(new WeightedRandomChestContent(new ItemStack(ModItems.LevelUpValor, 1), 1, 1, 5));
		ChestGenHooks.getInfo(ChestGenHooks.NETHER_FORTRESS)
				.addItem(new WeightedRandomChestContent(new ItemStack(ModItems.LevelUpValor, 1), 1, 1, 10));
		ChestGenHooks.getInfo(ChestGenHooks.PYRAMID_DESERT_CHEST)
				.addItem(new WeightedRandomChestContent(new ItemStack(ModItems.LevelUpValor, 1), 1, 1, 5));
		ChestGenHooks.getInfo(ChestGenHooks.PYRAMID_JUNGLE_CHEST)
				.addItem(new WeightedRandomChestContent(new ItemStack(ModItems.LevelUpValor, 1), 1, 1, 5));
		ChestGenHooks.getInfo(ChestGenHooks.PYRAMID_JUNGLE_DISPENSER)
				.addItem(new WeightedRandomChestContent(new ItemStack(ModItems.LevelUpValor, 1), 1, 1, 5));
		ChestGenHooks.getInfo(ChestGenHooks.STRONGHOLD_CORRIDOR)
				.addItem(new WeightedRandomChestContent(new ItemStack(ModItems.LevelUpValor, 1), 1, 1, 5));
		ChestGenHooks.getInfo(ChestGenHooks.STRONGHOLD_CROSSING)
				.addItem(new WeightedRandomChestContent(new ItemStack(ModItems.LevelUpValor, 1), 1, 1, 5));
		ChestGenHooks.getInfo(ChestGenHooks.STRONGHOLD_LIBRARY)
				.addItem(new WeightedRandomChestContent(new ItemStack(ModItems.LevelUpValor, 1), 1, 1, 5));
		ChestGenHooks.getInfo(ChestGenHooks.VILLAGE_BLACKSMITH)
				.addItem(new WeightedRandomChestContent(new ItemStack(ModItems.LevelUpValor, 1), 1, 1, 10));

		ChestGenHooks.getInfo(ChestGenHooks.BONUS_CHEST)
				.addItem(new WeightedRandomChestContent(new ItemStack(ModItems.LevelUpWisdom, 1), 1, 1, 5));
		ChestGenHooks.getInfo(ChestGenHooks.DUNGEON_CHEST)
				.addItem(new WeightedRandomChestContent(new ItemStack(ModItems.LevelUpWisdom, 1), 1, 1, 10));
		ChestGenHooks.getInfo(ChestGenHooks.MINESHAFT_CORRIDOR)
				.addItem(new WeightedRandomChestContent(new ItemStack(ModItems.LevelUpWisdom, 1), 1, 1, 5));
		ChestGenHooks.getInfo(ChestGenHooks.NETHER_FORTRESS)
				.addItem(new WeightedRandomChestContent(new ItemStack(ModItems.LevelUpWisdom, 1), 1, 1, 10));
		ChestGenHooks.getInfo(ChestGenHooks.PYRAMID_DESERT_CHEST)
				.addItem(new WeightedRandomChestContent(new ItemStack(ModItems.LevelUpWisdom, 1), 1, 1, 5));
		ChestGenHooks.getInfo(ChestGenHooks.PYRAMID_JUNGLE_CHEST)
				.addItem(new WeightedRandomChestContent(new ItemStack(ModItems.LevelUpWisdom, 1), 1, 1, 5));
		ChestGenHooks.getInfo(ChestGenHooks.PYRAMID_JUNGLE_DISPENSER)
				.addItem(new WeightedRandomChestContent(new ItemStack(ModItems.LevelUpWisdom, 1), 1, 1, 5));
		ChestGenHooks.getInfo(ChestGenHooks.STRONGHOLD_CORRIDOR)
				.addItem(new WeightedRandomChestContent(new ItemStack(ModItems.LevelUpWisdom, 1), 1, 1, 5));
		ChestGenHooks.getInfo(ChestGenHooks.STRONGHOLD_CROSSING)
				.addItem(new WeightedRandomChestContent(new ItemStack(ModItems.LevelUpWisdom, 1), 1, 1, 5));
		ChestGenHooks.getInfo(ChestGenHooks.STRONGHOLD_LIBRARY)
				.addItem(new WeightedRandomChestContent(new ItemStack(ModItems.LevelUpWisdom, 1), 1, 1, 5));
		ChestGenHooks.getInfo(ChestGenHooks.VILLAGE_BLACKSMITH)
				.addItem(new WeightedRandomChestContent(new ItemStack(ModItems.LevelUpWisdom, 1), 1, 1, 10));

		ChestGenHooks.getInfo(ChestGenHooks.BONUS_CHEST)
				.addItem(new WeightedRandomChestContent(new ItemStack(ModItems.LevelUpLimit, 1), 1, 1, 5));
		ChestGenHooks.getInfo(ChestGenHooks.DUNGEON_CHEST)
				.addItem(new WeightedRandomChestContent(new ItemStack(ModItems.LevelUpLimit, 1), 1, 1, 10));
		ChestGenHooks.getInfo(ChestGenHooks.MINESHAFT_CORRIDOR)
				.addItem(new WeightedRandomChestContent(new ItemStack(ModItems.LevelUpLimit, 1), 1, 1, 5));
		ChestGenHooks.getInfo(ChestGenHooks.NETHER_FORTRESS)
				.addItem(new WeightedRandomChestContent(new ItemStack(ModItems.LevelUpLimit, 1), 1, 1, 10));
		ChestGenHooks.getInfo(ChestGenHooks.PYRAMID_DESERT_CHEST)
				.addItem(new WeightedRandomChestContent(new ItemStack(ModItems.LevelUpLimit, 1), 1, 1, 5));
		ChestGenHooks.getInfo(ChestGenHooks.PYRAMID_JUNGLE_CHEST)
				.addItem(new WeightedRandomChestContent(new ItemStack(ModItems.LevelUpLimit, 1), 1, 1, 5));
		ChestGenHooks.getInfo(ChestGenHooks.PYRAMID_JUNGLE_DISPENSER)
				.addItem(new WeightedRandomChestContent(new ItemStack(ModItems.LevelUpLimit, 1), 1, 1, 5));
		ChestGenHooks.getInfo(ChestGenHooks.STRONGHOLD_CORRIDOR)
				.addItem(new WeightedRandomChestContent(new ItemStack(ModItems.LevelUpLimit, 1), 1, 1, 5));
		ChestGenHooks.getInfo(ChestGenHooks.STRONGHOLD_CROSSING)
				.addItem(new WeightedRandomChestContent(new ItemStack(ModItems.LevelUpLimit, 1), 1, 1, 5));
		ChestGenHooks.getInfo(ChestGenHooks.STRONGHOLD_LIBRARY)
				.addItem(new WeightedRandomChestContent(new ItemStack(ModItems.LevelUpLimit, 1), 1, 1, 5));
		ChestGenHooks.getInfo(ChestGenHooks.VILLAGE_BLACKSMITH)
				.addItem(new WeightedRandomChestContent(new ItemStack(ModItems.LevelUpLimit, 1), 1, 1, 10));

		ChestGenHooks.getInfo(ChestGenHooks.BONUS_CHEST)
				.addItem(new WeightedRandomChestContent(new ItemStack(ModItems.LevelUpMaster, 1), 1, 1, 5));
		ChestGenHooks.getInfo(ChestGenHooks.DUNGEON_CHEST)
				.addItem(new WeightedRandomChestContent(new ItemStack(ModItems.LevelUpMaster, 1), 1, 1, 10));
		ChestGenHooks.getInfo(ChestGenHooks.MINESHAFT_CORRIDOR)
				.addItem(new WeightedRandomChestContent(new ItemStack(ModItems.LevelUpMaster, 1), 1, 1, 5));
		ChestGenHooks.getInfo(ChestGenHooks.NETHER_FORTRESS)
				.addItem(new WeightedRandomChestContent(new ItemStack(ModItems.LevelUpMaster, 1), 1, 1, 10));
		ChestGenHooks.getInfo(ChestGenHooks.PYRAMID_DESERT_CHEST)
				.addItem(new WeightedRandomChestContent(new ItemStack(ModItems.LevelUpMaster, 1), 1, 1, 5));
		ChestGenHooks.getInfo(ChestGenHooks.PYRAMID_JUNGLE_CHEST)
				.addItem(new WeightedRandomChestContent(new ItemStack(ModItems.LevelUpMaster, 1), 1, 1, 5));
		ChestGenHooks.getInfo(ChestGenHooks.PYRAMID_JUNGLE_DISPENSER)
				.addItem(new WeightedRandomChestContent(new ItemStack(ModItems.LevelUpMaster, 1), 1, 1, 5));
		ChestGenHooks.getInfo(ChestGenHooks.STRONGHOLD_CORRIDOR)
				.addItem(new WeightedRandomChestContent(new ItemStack(ModItems.LevelUpMaster, 1), 1, 1, 5));
		ChestGenHooks.getInfo(ChestGenHooks.STRONGHOLD_CROSSING)
				.addItem(new WeightedRandomChestContent(new ItemStack(ModItems.LevelUpMaster, 1), 1, 1, 5));
		ChestGenHooks.getInfo(ChestGenHooks.STRONGHOLD_LIBRARY)
				.addItem(new WeightedRandomChestContent(new ItemStack(ModItems.LevelUpMaster, 1), 1, 1, 5));
		ChestGenHooks.getInfo(ChestGenHooks.VILLAGE_BLACKSMITH)
				.addItem(new WeightedRandomChestContent(new ItemStack(ModItems.LevelUpMaster, 1), 1, 1, 10));

		ChestGenHooks.getInfo(ChestGenHooks.BONUS_CHEST)
				.addItem(new WeightedRandomChestContent(new ItemStack(ModItems.LevelUpFinal, 1), 1, 1, 5));
		ChestGenHooks.getInfo(ChestGenHooks.DUNGEON_CHEST)
				.addItem(new WeightedRandomChestContent(new ItemStack(ModItems.LevelUpFinal, 1), 1, 1, 10));
		ChestGenHooks.getInfo(ChestGenHooks.MINESHAFT_CORRIDOR)
				.addItem(new WeightedRandomChestContent(new ItemStack(ModItems.LevelUpFinal, 1), 1, 1, 5));
		ChestGenHooks.getInfo(ChestGenHooks.NETHER_FORTRESS)
				.addItem(new WeightedRandomChestContent(new ItemStack(ModItems.LevelUpFinal, 1), 1, 1, 10));
		ChestGenHooks.getInfo(ChestGenHooks.PYRAMID_DESERT_CHEST)
				.addItem(new WeightedRandomChestContent(new ItemStack(ModItems.LevelUpFinal, 1), 1, 1, 5));
		ChestGenHooks.getInfo(ChestGenHooks.PYRAMID_JUNGLE_CHEST)
				.addItem(new WeightedRandomChestContent(new ItemStack(ModItems.LevelUpFinal, 1), 1, 1, 5));
		ChestGenHooks.getInfo(ChestGenHooks.PYRAMID_JUNGLE_DISPENSER)
				.addItem(new WeightedRandomChestContent(new ItemStack(ModItems.LevelUpFinal, 1), 1, 1, 5));
		ChestGenHooks.getInfo(ChestGenHooks.STRONGHOLD_CORRIDOR)
				.addItem(new WeightedRandomChestContent(new ItemStack(ModItems.LevelUpFinal, 1), 1, 1, 5));
		ChestGenHooks.getInfo(ChestGenHooks.STRONGHOLD_CROSSING)
				.addItem(new WeightedRandomChestContent(new ItemStack(ModItems.LevelUpFinal, 1), 1, 1, 5));
		ChestGenHooks.getInfo(ChestGenHooks.STRONGHOLD_LIBRARY)
				.addItem(new WeightedRandomChestContent(new ItemStack(ModItems.LevelUpFinal, 1), 1, 1, 5));
		ChestGenHooks.getInfo(ChestGenHooks.VILLAGE_BLACKSMITH)
				.addItem(new WeightedRandomChestContent(new ItemStack(ModItems.LevelUpFinal, 1), 1, 1, 10));

		ChestGenHooks.getInfo(ChestGenHooks.DUNGEON_CHEST).addItem(new WeightedRandomChestContent(
				new ItemStack(ModItems.Disc_Birth_by_Sleep_A_Link_to_the_Future, 1), 1, 1, 10));
		ChestGenHooks.getInfo(ChestGenHooks.DUNGEON_CHEST).addItem(
				new WeightedRandomChestContent(new ItemStack(ModItems.Disc_Darkness_of_the_Unknown, 1), 1, 1, 10));
		ChestGenHooks.getInfo(ChestGenHooks.DUNGEON_CHEST).addItem(new WeightedRandomChestContent(
				new ItemStack(ModItems.Disc_Dearly_Beloved_Symphony_Version, 1), 1, 1, 10));
		ChestGenHooks.getInfo(ChestGenHooks.DUNGEON_CHEST).addItem(new WeightedRandomChestContent(
				new ItemStack(ModItems.Disc_Dream_Drop_Distance_The_Next_Awakening, 1), 1, 1, 10));
		ChestGenHooks.getInfo(ChestGenHooks.DUNGEON_CHEST).addItem(new WeightedRandomChestContent(
				new ItemStack(ModItems.Disc_Hikari_KINGDOM_Instrumental_Version, 1), 1, 1, 10));
		ChestGenHooks.getInfo(ChestGenHooks.DUNGEON_CHEST).addItem(
				new WeightedRandomChestContent(new ItemStack(ModItems.Disc_L_Oscurita_Dell_Ignoto, 1), 1, 1, 10));
		ChestGenHooks.getInfo(ChestGenHooks.DUNGEON_CHEST).addItem(new WeightedRandomChestContent(
				new ItemStack(ModItems.Disc_Musique_pour_la_tristesse_de_Xion, 1), 1, 1, 10));
		ChestGenHooks.getInfo(ChestGenHooks.DUNGEON_CHEST).addItem(
				new WeightedRandomChestContent(new ItemStack(ModItems.Disc_No_More_Bugs_Bug_Version, 1), 1, 1, 10));
		ChestGenHooks.getInfo(ChestGenHooks.DUNGEON_CHEST)
				.addItem(new WeightedRandomChestContent(new ItemStack(ModItems.Disc_Organization_XIII, 1), 1, 1, 10));
		ChestGenHooks.getInfo(ChestGenHooks.DUNGEON_CHEST)
				.addItem(new WeightedRandomChestContent(new ItemStack(ModItems.Disc_Sanctuary, 1), 1, 1, 10));
		ChestGenHooks.getInfo(ChestGenHooks.DUNGEON_CHEST).addItem(new WeightedRandomChestContent(
				new ItemStack(ModItems.Disc_Simple_And_Clean_PLANITb_Remix, 1), 1, 1, 10));
		ChestGenHooks.getInfo(ChestGenHooks.DUNGEON_CHEST)
				.addItem(new WeightedRandomChestContent(new ItemStack(ModItems.Disc_Sinister_Sundown, 1), 1, 1, 10));
		ChestGenHooks.getInfo(ChestGenHooks.DUNGEON_CHEST)
				.addItem(new WeightedRandomChestContent(new ItemStack(ModItems.Disc_The_13th_Anthology, 1), 1, 1, 10));
	}

}
