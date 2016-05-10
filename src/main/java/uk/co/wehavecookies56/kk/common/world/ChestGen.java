package uk.co.wehavecookies56.kk.common.world;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.storage.loot.LootEntryItem;
import net.minecraft.world.storage.loot.LootPool;
import net.minecraft.world.storage.loot.LootTableList;
import net.minecraft.world.storage.loot.RandomValueRange;
import net.minecraft.world.storage.loot.conditions.LootCondition;
import net.minecraft.world.storage.loot.functions.LootFunction;
import net.minecraft.world.storage.loot.functions.SetCount;
import net.minecraft.world.storage.loot.functions.SetNBT;
import net.minecraftforge.event.LootTableLoadEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import uk.co.wehavecookies56.kk.common.block.ModBlocks;
import uk.co.wehavecookies56.kk.common.item.ModItems;
import uk.co.wehavecookies56.kk.common.lib.Reference;
import uk.co.wehavecookies56.kk.common.lib.Strings;

public class ChestGen {
	@SubscribeEvent
	public void loadLoot(LootTableLoadEvent event) {
		// Using bonus chest to test
		if (event.getName().equals(LootTableList.CHESTS_SPAWN_BONUS_CHEST)) {
			// This page is pretty helpful for this http://minecraft.gamepedia.com/Loot_table, it's also useful to look at the vanilla loot table jsons
			// Sets the stack size to 64
			LootFunction[] setCount = new LootFunction[]{ new SetCount(new LootCondition[0], new RandomValueRange(64, 64)) };
			NBTTagCompound material = new NBTTagCompound();
			material.setString("material", Strings.SM_BlazingCrystal);
			material.setString("rank", Strings.SM_Rank_S);
			// Sets the material NBT data and creates a stack from 1 to 32 in size
			LootFunction[] setMaterialNBTAndCount = new LootFunction[] {new SetNBT(new LootCondition[0], material), new SetCount(new LootCondition[0], new RandomValueRange(1, 32))};
			// pool0 is called main
			LootPool main = event.getTable().getPool("main");
			// Adding entries for Recipes and Materials to the main loot pool, recipe has 1 weight and 10 quality, material has 30 weight and 0 quality
			main.addEntry(new LootEntryItem(ModItems.Recipe, 1, 10, new LootFunction[0], new LootCondition[0], Reference.MODID + ":" + ModItems.Recipe.getUnlocalizedName().substring(5)));
			main.addEntry(new LootEntryItem(ModItems.SynthesisMaterial, 30, 0, setMaterialNBTAndCount, new LootCondition[0], Reference.MODID + ":" + ModItems.SynthesisMaterial.getUnlocalizedName().substring(5)));
			// Removing pool1 and pool2 so nothing from those pools generate
			event.getTable().removePool("pool1");
			event.getTable().removePool("pool2");
			// Getting the last pool in the bonus chest loot pool, pool3
			LootPool pool3 = event.getTable().getPool("pool3");
			// Setting the number of rolls to 1 to 2, it's 4 by default
			pool3.setRolls(new RandomValueRange(1, 2));
			// Adding the Normal blox to pool3 with a weight of 8 and 0 quality will spawn in a stack of 64
			pool3.addEntry(new LootEntryItem(Item.getItemFromBlock(ModBlocks.NormalBlox), 8, 0, setCount, new LootCondition[0], Reference.MODID + ":" + ModBlocks.NormalBlox.getUnlocalizedName().substring(5)));
		}
		/*
		ChestGenHooks.getInfo(ChestGenHooks.BONUS_CHEST).addItem(new WeightedRandomChestContent(new ItemStack(ModItems.Recipe, 1), 1, 1, 5));
		ChestGenHooks.getInfo(ChestGenHooks.DUNGEON_CHEST).addItem(new WeightedRandomChestContent(new ItemStack(ModItems.Recipe, 1), 1, 1, 10));
		ChestGenHooks.getInfo(ChestGenHooks.MINESHAFT_CORRIDOR).addItem(new WeightedRandomChestContent(new ItemStack(ModItems.Recipe, 1), 1, 1, 5));
		ChestGenHooks.getInfo(ChestGenHooks.NETHER_FORTRESS).addItem(new WeightedRandomChestContent(new ItemStack(ModItems.Recipe, 1), 1, 1, 10));
		ChestGenHooks.getInfo(ChestGenHooks.PYRAMID_DESERT_CHEST).addItem(new WeightedRandomChestContent(new ItemStack(ModItems.Recipe, 1), 1, 1, 5));
		ChestGenHooks.getInfo(ChestGenHooks.PYRAMID_JUNGLE_CHEST).addItem(new WeightedRandomChestContent(new ItemStack(ModItems.Recipe, 1), 1, 1, 5));
		ChestGenHooks.getInfo(ChestGenHooks.PYRAMID_JUNGLE_DISPENSER).addItem(new WeightedRandomChestContent(new ItemStack(ModItems.Recipe, 1), 1, 1, 5));
		ChestGenHooks.getInfo(ChestGenHooks.STRONGHOLD_CORRIDOR).addItem(new WeightedRandomChestContent(new ItemStack(ModItems.Recipe, 1), 1, 1, 5));
		ChestGenHooks.getInfo(ChestGenHooks.STRONGHOLD_CROSSING).addItem(new WeightedRandomChestContent(new ItemStack(ModItems.Recipe, 1), 1, 1, 5));
		ChestGenHooks.getInfo(ChestGenHooks.STRONGHOLD_LIBRARY).addItem(new WeightedRandomChestContent(new ItemStack(ModItems.Recipe, 1), 1, 1, 5));
		ChestGenHooks.getInfo(ChestGenHooks.VILLAGE_BLACKSMITH).addItem(new WeightedRandomChestContent(new ItemStack(ModItems.Recipe, 1), 1, 1, 10));

		ChestGenHooks.getInfo(ChestGenHooks.BONUS_CHEST).addItem(new WeightedRandomChestContent(new ItemStack(ModItems.LevelUpValor, 1), 1, 1, 5));
		ChestGenHooks.getInfo(ChestGenHooks.DUNGEON_CHEST).addItem(new WeightedRandomChestContent(new ItemStack(ModItems.LevelUpValor, 1), 1, 1, 10));
		ChestGenHooks.getInfo(ChestGenHooks.MINESHAFT_CORRIDOR).addItem(new WeightedRandomChestContent(new ItemStack(ModItems.LevelUpValor, 1), 1, 1, 5));
		ChestGenHooks.getInfo(ChestGenHooks.NETHER_FORTRESS).addItem(new WeightedRandomChestContent(new ItemStack(ModItems.LevelUpValor, 1), 1, 1, 10));
		ChestGenHooks.getInfo(ChestGenHooks.PYRAMID_DESERT_CHEST).addItem(new WeightedRandomChestContent(new ItemStack(ModItems.LevelUpValor, 1), 1, 1, 5));
		ChestGenHooks.getInfo(ChestGenHooks.PYRAMID_JUNGLE_CHEST).addItem(new WeightedRandomChestContent(new ItemStack(ModItems.LevelUpValor, 1), 1, 1, 5));
		ChestGenHooks.getInfo(ChestGenHooks.PYRAMID_JUNGLE_DISPENSER).addItem(new WeightedRandomChestContent(new ItemStack(ModItems.LevelUpValor, 1), 1, 1, 5));
		ChestGenHooks.getInfo(ChestGenHooks.STRONGHOLD_CORRIDOR).addItem(new WeightedRandomChestContent(new ItemStack(ModItems.LevelUpValor, 1), 1, 1, 5));
		ChestGenHooks.getInfo(ChestGenHooks.STRONGHOLD_CROSSING).addItem(new WeightedRandomChestContent(new ItemStack(ModItems.LevelUpValor, 1), 1, 1, 5));
		ChestGenHooks.getInfo(ChestGenHooks.STRONGHOLD_LIBRARY).addItem(new WeightedRandomChestContent(new ItemStack(ModItems.LevelUpValor, 1), 1, 1, 5));
		ChestGenHooks.getInfo(ChestGenHooks.VILLAGE_BLACKSMITH).addItem(new WeightedRandomChestContent(new ItemStack(ModItems.LevelUpValor, 1), 1, 1, 10));

		ChestGenHooks.getInfo(ChestGenHooks.BONUS_CHEST).addItem(new WeightedRandomChestContent(new ItemStack(ModItems.LevelUpWisdom, 1), 1, 1, 5));
		ChestGenHooks.getInfo(ChestGenHooks.DUNGEON_CHEST).addItem(new WeightedRandomChestContent(new ItemStack(ModItems.LevelUpWisdom, 1), 1, 1, 10));
		ChestGenHooks.getInfo(ChestGenHooks.MINESHAFT_CORRIDOR).addItem(new WeightedRandomChestContent(new ItemStack(ModItems.LevelUpWisdom, 1), 1, 1, 5));
		ChestGenHooks.getInfo(ChestGenHooks.NETHER_FORTRESS).addItem(new WeightedRandomChestContent(new ItemStack(ModItems.LevelUpWisdom, 1), 1, 1, 10));
		ChestGenHooks.getInfo(ChestGenHooks.PYRAMID_DESERT_CHEST).addItem(new WeightedRandomChestContent(new ItemStack(ModItems.LevelUpWisdom, 1), 1, 1, 5));
		ChestGenHooks.getInfo(ChestGenHooks.PYRAMID_JUNGLE_CHEST).addItem(new WeightedRandomChestContent(new ItemStack(ModItems.LevelUpWisdom, 1), 1, 1, 5));
		ChestGenHooks.getInfo(ChestGenHooks.PYRAMID_JUNGLE_DISPENSER).addItem(new WeightedRandomChestContent(new ItemStack(ModItems.LevelUpWisdom, 1), 1, 1, 5));
		ChestGenHooks.getInfo(ChestGenHooks.STRONGHOLD_CORRIDOR).addItem(new WeightedRandomChestContent(new ItemStack(ModItems.LevelUpWisdom, 1), 1, 1, 5));
		ChestGenHooks.getInfo(ChestGenHooks.STRONGHOLD_CROSSING).addItem(new WeightedRandomChestContent(new ItemStack(ModItems.LevelUpWisdom, 1), 1, 1, 5));
		ChestGenHooks.getInfo(ChestGenHooks.STRONGHOLD_LIBRARY).addItem(new WeightedRandomChestContent(new ItemStack(ModItems.LevelUpWisdom, 1), 1, 1, 5));
		ChestGenHooks.getInfo(ChestGenHooks.VILLAGE_BLACKSMITH).addItem(new WeightedRandomChestContent(new ItemStack(ModItems.LevelUpWisdom, 1), 1, 1, 10));

		ChestGenHooks.getInfo(ChestGenHooks.BONUS_CHEST).addItem(new WeightedRandomChestContent(new ItemStack(ModItems.LevelUpLimit, 1), 1, 1, 5));
		ChestGenHooks.getInfo(ChestGenHooks.DUNGEON_CHEST).addItem(new WeightedRandomChestContent(new ItemStack(ModItems.LevelUpLimit, 1), 1, 1, 10));
		ChestGenHooks.getInfo(ChestGenHooks.MINESHAFT_CORRIDOR).addItem(new WeightedRandomChestContent(new ItemStack(ModItems.LevelUpLimit, 1), 1, 1, 5));
		ChestGenHooks.getInfo(ChestGenHooks.NETHER_FORTRESS).addItem(new WeightedRandomChestContent(new ItemStack(ModItems.LevelUpLimit, 1), 1, 1, 10));
		ChestGenHooks.getInfo(ChestGenHooks.PYRAMID_DESERT_CHEST).addItem(new WeightedRandomChestContent(new ItemStack(ModItems.LevelUpLimit, 1), 1, 1, 5));
		ChestGenHooks.getInfo(ChestGenHooks.PYRAMID_JUNGLE_CHEST).addItem(new WeightedRandomChestContent(new ItemStack(ModItems.LevelUpLimit, 1), 1, 1, 5));
		ChestGenHooks.getInfo(ChestGenHooks.PYRAMID_JUNGLE_DISPENSER).addItem(new WeightedRandomChestContent(new ItemStack(ModItems.LevelUpLimit, 1), 1, 1, 5));
		ChestGenHooks.getInfo(ChestGenHooks.STRONGHOLD_CORRIDOR).addItem(new WeightedRandomChestContent(new ItemStack(ModItems.LevelUpLimit, 1), 1, 1, 5));
		ChestGenHooks.getInfo(ChestGenHooks.STRONGHOLD_CROSSING).addItem(new WeightedRandomChestContent(new ItemStack(ModItems.LevelUpLimit, 1), 1, 1, 5));
		ChestGenHooks.getInfo(ChestGenHooks.STRONGHOLD_LIBRARY).addItem(new WeightedRandomChestContent(new ItemStack(ModItems.LevelUpLimit, 1), 1, 1, 5));
		ChestGenHooks.getInfo(ChestGenHooks.VILLAGE_BLACKSMITH).addItem(new WeightedRandomChestContent(new ItemStack(ModItems.LevelUpLimit, 1), 1, 1, 10));

		ChestGenHooks.getInfo(ChestGenHooks.BONUS_CHEST).addItem(new WeightedRandomChestContent(new ItemStack(ModItems.LevelUpMaster, 1), 1, 1, 5));
		ChestGenHooks.getInfo(ChestGenHooks.DUNGEON_CHEST).addItem(new WeightedRandomChestContent(new ItemStack(ModItems.LevelUpMaster, 1), 1, 1, 10));
		ChestGenHooks.getInfo(ChestGenHooks.MINESHAFT_CORRIDOR).addItem(new WeightedRandomChestContent(new ItemStack(ModItems.LevelUpMaster, 1), 1, 1, 5));
		ChestGenHooks.getInfo(ChestGenHooks.NETHER_FORTRESS).addItem(new WeightedRandomChestContent(new ItemStack(ModItems.LevelUpMaster, 1), 1, 1, 10));
		ChestGenHooks.getInfo(ChestGenHooks.PYRAMID_DESERT_CHEST).addItem(new WeightedRandomChestContent(new ItemStack(ModItems.LevelUpMaster, 1), 1, 1, 5));
		ChestGenHooks.getInfo(ChestGenHooks.PYRAMID_JUNGLE_CHEST).addItem(new WeightedRandomChestContent(new ItemStack(ModItems.LevelUpMaster, 1), 1, 1, 5));
		ChestGenHooks.getInfo(ChestGenHooks.PYRAMID_JUNGLE_DISPENSER).addItem(new WeightedRandomChestContent(new ItemStack(ModItems.LevelUpMaster, 1), 1, 1, 5));
		ChestGenHooks.getInfo(ChestGenHooks.STRONGHOLD_CORRIDOR).addItem(new WeightedRandomChestContent(new ItemStack(ModItems.LevelUpMaster, 1), 1, 1, 5));
		ChestGenHooks.getInfo(ChestGenHooks.STRONGHOLD_CROSSING).addItem(new WeightedRandomChestContent(new ItemStack(ModItems.LevelUpMaster, 1), 1, 1, 5));
		ChestGenHooks.getInfo(ChestGenHooks.STRONGHOLD_LIBRARY).addItem(new WeightedRandomChestContent(new ItemStack(ModItems.LevelUpMaster, 1), 1, 1, 5));
		ChestGenHooks.getInfo(ChestGenHooks.VILLAGE_BLACKSMITH).addItem(new WeightedRandomChestContent(new ItemStack(ModItems.LevelUpMaster, 1), 1, 1, 10));

		ChestGenHooks.getInfo(ChestGenHooks.BONUS_CHEST).addItem(new WeightedRandomChestContent(new ItemStack(ModItems.LevelUpFinal, 1), 1, 1, 5));
		ChestGenHooks.getInfo(ChestGenHooks.DUNGEON_CHEST).addItem(new WeightedRandomChestContent(new ItemStack(ModItems.LevelUpFinal, 1), 1, 1, 10));
		ChestGenHooks.getInfo(ChestGenHooks.MINESHAFT_CORRIDOR).addItem(new WeightedRandomChestContent(new ItemStack(ModItems.LevelUpFinal, 1), 1, 1, 5));
		ChestGenHooks.getInfo(ChestGenHooks.NETHER_FORTRESS).addItem(new WeightedRandomChestContent(new ItemStack(ModItems.LevelUpFinal, 1), 1, 1, 10));
		ChestGenHooks.getInfo(ChestGenHooks.PYRAMID_DESERT_CHEST).addItem(new WeightedRandomChestContent(new ItemStack(ModItems.LevelUpFinal, 1), 1, 1, 5));
		ChestGenHooks.getInfo(ChestGenHooks.PYRAMID_JUNGLE_CHEST).addItem(new WeightedRandomChestContent(new ItemStack(ModItems.LevelUpFinal, 1), 1, 1, 5));
		ChestGenHooks.getInfo(ChestGenHooks.PYRAMID_JUNGLE_DISPENSER).addItem(new WeightedRandomChestContent(new ItemStack(ModItems.LevelUpFinal, 1), 1, 1, 5));
		ChestGenHooks.getInfo(ChestGenHooks.STRONGHOLD_CORRIDOR).addItem(new WeightedRandomChestContent(new ItemStack(ModItems.LevelUpFinal, 1), 1, 1, 5));
		ChestGenHooks.getInfo(ChestGenHooks.STRONGHOLD_CROSSING).addItem(new WeightedRandomChestContent(new ItemStack(ModItems.LevelUpFinal, 1), 1, 1, 5));
		ChestGenHooks.getInfo(ChestGenHooks.STRONGHOLD_LIBRARY).addItem(new WeightedRandomChestContent(new ItemStack(ModItems.LevelUpFinal, 1), 1, 1, 5));
		ChestGenHooks.getInfo(ChestGenHooks.VILLAGE_BLACKSMITH).addItem(new WeightedRandomChestContent(new ItemStack(ModItems.LevelUpFinal, 1), 1, 1, 10));

		ChestGenHooks.getInfo(ChestGenHooks.DUNGEON_CHEST).addItem(new WeightedRandomChestContent(new ItemStack(ModItems.Disc_Birth_by_Sleep_A_Link_to_the_Future, 1), 1, 1, 10));
		ChestGenHooks.getInfo(ChestGenHooks.DUNGEON_CHEST).addItem(new WeightedRandomChestContent(new ItemStack(ModItems.Disc_Darkness_of_the_Unknown, 1), 1, 1, 10));
		ChestGenHooks.getInfo(ChestGenHooks.DUNGEON_CHEST).addItem(new WeightedRandomChestContent(new ItemStack(ModItems.Disc_Dearly_Beloved_Symphony_Version, 1), 1, 1, 10));
		ChestGenHooks.getInfo(ChestGenHooks.DUNGEON_CHEST).addItem(new WeightedRandomChestContent(new ItemStack(ModItems.Disc_Dream_Drop_Distance_The_Next_Awakening, 1), 1, 1, 10));
		ChestGenHooks.getInfo(ChestGenHooks.DUNGEON_CHEST).addItem(new WeightedRandomChestContent(new ItemStack(ModItems.Disc_Hikari_KINGDOM_Instrumental_Version, 1), 1, 1, 10));
		ChestGenHooks.getInfo(ChestGenHooks.DUNGEON_CHEST).addItem(new WeightedRandomChestContent(new ItemStack(ModItems.Disc_L_Oscurita_Dell_Ignoto, 1), 1, 1, 10));
		ChestGenHooks.getInfo(ChestGenHooks.DUNGEON_CHEST).addItem(new WeightedRandomChestContent(new ItemStack(ModItems.Disc_Musique_pour_la_tristesse_de_Xion, 1), 1, 1, 10));
		ChestGenHooks.getInfo(ChestGenHooks.DUNGEON_CHEST).addItem(new WeightedRandomChestContent(new ItemStack(ModItems.Disc_No_More_Bugs_Bug_Version, 1), 1, 1, 10));
		ChestGenHooks.getInfo(ChestGenHooks.DUNGEON_CHEST).addItem(new WeightedRandomChestContent(new ItemStack(ModItems.Disc_Organization_XIII, 1), 1, 1, 10));
		ChestGenHooks.getInfo(ChestGenHooks.DUNGEON_CHEST).addItem(new WeightedRandomChestContent(new ItemStack(ModItems.Disc_Sanctuary, 1), 1, 1, 10));
		ChestGenHooks.getInfo(ChestGenHooks.DUNGEON_CHEST).addItem(new WeightedRandomChestContent(new ItemStack(ModItems.Disc_Simple_And_Clean_PLANITb_Remix, 1), 1, 1, 10));
		ChestGenHooks.getInfo(ChestGenHooks.DUNGEON_CHEST).addItem(new WeightedRandomChestContent(new ItemStack(ModItems.Disc_Sinister_Sundown, 1), 1, 1, 10));
		ChestGenHooks.getInfo(ChestGenHooks.DUNGEON_CHEST).addItem(new WeightedRandomChestContent(new ItemStack(ModItems.Disc_The_13th_Anthology, 1), 1, 1, 10));
		*/
	}

}
