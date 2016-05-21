package uk.co.wehavecookies56.kk.common.world;

import net.minecraft.item.Item;
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
		NBTTagCompound MythrilCrystal = new NBTTagCompound();
		MythrilCrystal.setString("material", Strings.SM_MythrilCrystal);
		MythrilCrystal.setString("rank", Strings.SM_Rank_S);
		LootFunction[] setMythrilCrystal = new LootFunction[] {new SetNBT(new LootCondition[0], MythrilCrystal), new SetCount(new LootCondition[0], new RandomValueRange(1, 32))};

		NBTTagCompound MythrilGem = new NBTTagCompound();
		MythrilGem.setString("material", Strings.SM_MythrilGem);
		MythrilGem.setString("rank", Strings.SM_Rank_A);
		LootFunction[] setMythrilGem = new LootFunction[] {new SetNBT(new LootCondition[0], MythrilGem), new SetCount(new LootCondition[0], new RandomValueRange(1, 32))};

		NBTTagCompound MythrilStone = new NBTTagCompound();
		MythrilStone.setString("material", Strings.SM_MythrilStone);
		MythrilStone.setString("rank", Strings.SM_Rank_B);
		LootFunction[] setMythrilStone = new LootFunction[] {new SetNBT(new LootCondition[0], MythrilStone), new SetCount(new LootCondition[0], new RandomValueRange(1, 32))};

		NBTTagCompound MythrilShard = new NBTTagCompound();
		MythrilShard.setString("material", Strings.SM_MythrilShard);
		MythrilShard.setString("rank", Strings.SM_Rank_C);
		LootFunction[] setMythrilShard = new LootFunction[] {new SetNBT(new LootCondition[0], MythrilShard), new SetCount(new LootCondition[0], new RandomValueRange(1, 32))};

		NBTTagCompound Orichalcum = new NBTTagCompound();
		MythrilCrystal.setString("material", Strings.SM_Orichalcum);
		MythrilCrystal.setString("rank", Strings.SM_Rank_A);
		LootFunction[] setOrichalcum = new LootFunction[] {new SetNBT(new LootCondition[0], Orichalcum), new SetCount(new LootCondition[0], new RandomValueRange(1, 32))};
		
		NBTTagCompound OrichalcumPlus = new NBTTagCompound();
		MythrilCrystal.setString("material", Strings.SM_OrichalcumPlus);
		MythrilCrystal.setString("rank", Strings.SM_Rank_S);
		LootFunction[] setOrichalcumPlus = new LootFunction[] {new SetNBT(new LootCondition[0], OrichalcumPlus), new SetCount(new LootCondition[0], new RandomValueRange(1, 32))};
		
		NBTTagCompound LostIllusion = new NBTTagCompound();
		MythrilCrystal.setString("material", Strings.SM_LostIllusion);
		MythrilCrystal.setString("rank", Strings.SM_Rank_S);
		LootFunction[] setLostIllusion = new LootFunction[] {new SetNBT(new LootCondition[0], LostIllusion), new SetCount(new LootCondition[0], new RandomValueRange(1, 32))};
		
		NBTTagCompound ManifestIllusion = new NBTTagCompound();
		MythrilCrystal.setString("material", Strings.SM_ManifestIllusion);
		MythrilCrystal.setString("rank", Strings.SM_Rank_A);
		LootFunction[] setManifestIllusion = new LootFunction[] {new SetNBT(new LootCondition[0], ManifestIllusion), new SetCount(new LootCondition[0], new RandomValueRange(1, 32))};
		
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
		
		if(event.getName().equals(LootTableList.CHESTS_ABANDONED_MINESHAFT))
		{
			LootFunction[] setCount = new LootFunction[]{ new SetCount(new LootCondition[0], new RandomValueRange(64, 64)) };
			LootPool main = event.getTable().getPool("main");
			main.addEntry(new LootEntryItem(ModItems.Recipe, 1, 10, new LootFunction[0], new LootCondition[0], Reference.MODID + ":" + ModItems.Recipe.getUnlocalizedName().substring(5)));
			main.addEntry(new LootEntryItem(ModItems.SynthesisMaterial, 30, 0, setMythrilCrystal, new LootCondition[0], Reference.MODID + ":" + ModItems.SynthesisMaterial.getUnlocalizedName().substring(5)));
			main.addEntry(new LootEntryItem(ModItems.SynthesisMaterial, 30, 0, setMythrilGem, new LootCondition[0], Reference.MODID + ":" + ModItems.SynthesisMaterial.getUnlocalizedName().substring(5)));
			main.addEntry(new LootEntryItem(ModItems.SynthesisMaterial, 30, 0, setMythrilStone, new LootCondition[0], Reference.MODID + ":" + ModItems.SynthesisMaterial.getUnlocalizedName().substring(5)));
			main.addEntry(new LootEntryItem(ModItems.SynthesisMaterial, 30, 0, setMythrilShard, new LootCondition[0], Reference.MODID + ":" + ModItems.SynthesisMaterial.getUnlocalizedName().substring(5)));
			main.addEntry(new LootEntryItem(ModItems.SynthesisMaterial, 30, 0, setOrichalcum, new LootCondition[0], Reference.MODID + ":" + ModItems.SynthesisMaterial.getUnlocalizedName().substring(5)));
			main.addEntry(new LootEntryItem(ModItems.SynthesisMaterial, 30, 0, setOrichalcumPlus, new LootCondition[0], Reference.MODID + ":" + ModItems.SynthesisMaterial.getUnlocalizedName().substring(5)));
			main.addEntry(new LootEntryItem(ModItems.SynthesisMaterial, 30, 0, setLostIllusion, new LootCondition[0], Reference.MODID + ":" + ModItems.SynthesisMaterial.getUnlocalizedName().substring(5)));
			main.addEntry(new LootEntryItem(ModItems.SynthesisMaterial, 30, 0, setManifestIllusion, new LootCondition[0], Reference.MODID + ":" + ModItems.SynthesisMaterial.getUnlocalizedName().substring(5)));

			event.getTable().removePool("pool1");
			event.getTable().removePool("pool2");
		}
		
		if(event.getName().equals(LootTableList.CHESTS_DESERT_PYRAMID))
		{
			LootFunction[] setCount = new LootFunction[]{ new SetCount(new LootCondition[0], new RandomValueRange(64, 64)) };
			LootPool main = event.getTable().getPool("main");
			main.addEntry(new LootEntryItem(ModItems.Recipe, 1, 10, new LootFunction[0], new LootCondition[0], Reference.MODID + ":" + ModItems.Recipe.getUnlocalizedName().substring(5)));
			main.addEntry(new LootEntryItem(ModItems.SynthesisMaterial, 30, 0, setMythrilCrystal, new LootCondition[0], Reference.MODID + ":" + ModItems.SynthesisMaterial.getUnlocalizedName().substring(5)));
			main.addEntry(new LootEntryItem(ModItems.SynthesisMaterial, 30, 0, setMythrilGem, new LootCondition[0], Reference.MODID + ":" + ModItems.SynthesisMaterial.getUnlocalizedName().substring(5)));
			main.addEntry(new LootEntryItem(ModItems.SynthesisMaterial, 30, 0, setMythrilStone, new LootCondition[0], Reference.MODID + ":" + ModItems.SynthesisMaterial.getUnlocalizedName().substring(5)));
			main.addEntry(new LootEntryItem(ModItems.SynthesisMaterial, 30, 0, setMythrilShard, new LootCondition[0], Reference.MODID + ":" + ModItems.SynthesisMaterial.getUnlocalizedName().substring(5)));
			main.addEntry(new LootEntryItem(ModItems.SynthesisMaterial, 30, 0, setOrichalcum, new LootCondition[0], Reference.MODID + ":" + ModItems.SynthesisMaterial.getUnlocalizedName().substring(5)));
			main.addEntry(new LootEntryItem(ModItems.SynthesisMaterial, 30, 0, setOrichalcumPlus, new LootCondition[0], Reference.MODID + ":" + ModItems.SynthesisMaterial.getUnlocalizedName().substring(5)));
			main.addEntry(new LootEntryItem(ModItems.SynthesisMaterial, 30, 0, setLostIllusion, new LootCondition[0], Reference.MODID + ":" + ModItems.SynthesisMaterial.getUnlocalizedName().substring(5)));
			main.addEntry(new LootEntryItem(ModItems.SynthesisMaterial, 30, 0, setManifestIllusion, new LootCondition[0], Reference.MODID + ":" + ModItems.SynthesisMaterial.getUnlocalizedName().substring(5)));

			event.getTable().removePool("pool1");
			event.getTable().removePool("pool2");	
		}
		
		if(event.getName().equals(LootTableList.CHESTS_END_CITY_TREASURE))
		{
			LootFunction[] setCount = new LootFunction[]{ new SetCount(new LootCondition[0], new RandomValueRange(64, 64)) };
			LootPool main = event.getTable().getPool("main");
			main.addEntry(new LootEntryItem(ModItems.Recipe, 1, 10, new LootFunction[0], new LootCondition[0], Reference.MODID + ":" + ModItems.Recipe.getUnlocalizedName().substring(5)));
			main.addEntry(new LootEntryItem(ModItems.SynthesisMaterial, 30, 0, setMythrilCrystal, new LootCondition[0], Reference.MODID + ":" + ModItems.SynthesisMaterial.getUnlocalizedName().substring(5)));
			main.addEntry(new LootEntryItem(ModItems.SynthesisMaterial, 30, 0, setMythrilGem, new LootCondition[0], Reference.MODID + ":" + ModItems.SynthesisMaterial.getUnlocalizedName().substring(5)));
			main.addEntry(new LootEntryItem(ModItems.SynthesisMaterial, 30, 0, setMythrilStone, new LootCondition[0], Reference.MODID + ":" + ModItems.SynthesisMaterial.getUnlocalizedName().substring(5)));
			main.addEntry(new LootEntryItem(ModItems.SynthesisMaterial, 30, 0, setMythrilShard, new LootCondition[0], Reference.MODID + ":" + ModItems.SynthesisMaterial.getUnlocalizedName().substring(5)));
			main.addEntry(new LootEntryItem(ModItems.SynthesisMaterial, 30, 0, setOrichalcum, new LootCondition[0], Reference.MODID + ":" + ModItems.SynthesisMaterial.getUnlocalizedName().substring(5)));
			main.addEntry(new LootEntryItem(ModItems.SynthesisMaterial, 30, 0, setOrichalcumPlus, new LootCondition[0], Reference.MODID + ":" + ModItems.SynthesisMaterial.getUnlocalizedName().substring(5)));
			main.addEntry(new LootEntryItem(ModItems.SynthesisMaterial, 30, 0, setLostIllusion, new LootCondition[0], Reference.MODID + ":" + ModItems.SynthesisMaterial.getUnlocalizedName().substring(5)));
			main.addEntry(new LootEntryItem(ModItems.SynthesisMaterial, 30, 0, setManifestIllusion, new LootCondition[0], Reference.MODID + ":" + ModItems.SynthesisMaterial.getUnlocalizedName().substring(5)));

			event.getTable().removePool("pool1");
			event.getTable().removePool("pool2");
		}
		
		if(event.getName().equals(LootTableList.CHESTS_IGLOO_CHEST))
		{
			LootFunction[] setCount = new LootFunction[]{ new SetCount(new LootCondition[0], new RandomValueRange(64, 64)) };
			LootPool main = event.getTable().getPool("main");
			main.addEntry(new LootEntryItem(ModItems.Recipe, 1, 10, new LootFunction[0], new LootCondition[0], Reference.MODID + ":" + ModItems.Recipe.getUnlocalizedName().substring(5)));
			main.addEntry(new LootEntryItem(ModItems.SynthesisMaterial, 30, 0, setMythrilCrystal, new LootCondition[0], Reference.MODID + ":" + ModItems.SynthesisMaterial.getUnlocalizedName().substring(5)));
			main.addEntry(new LootEntryItem(ModItems.SynthesisMaterial, 30, 0, setMythrilGem, new LootCondition[0], Reference.MODID + ":" + ModItems.SynthesisMaterial.getUnlocalizedName().substring(5)));
			main.addEntry(new LootEntryItem(ModItems.SynthesisMaterial, 30, 0, setMythrilStone, new LootCondition[0], Reference.MODID + ":" + ModItems.SynthesisMaterial.getUnlocalizedName().substring(5)));
			main.addEntry(new LootEntryItem(ModItems.SynthesisMaterial, 30, 0, setMythrilShard, new LootCondition[0], Reference.MODID + ":" + ModItems.SynthesisMaterial.getUnlocalizedName().substring(5)));
			main.addEntry(new LootEntryItem(ModItems.SynthesisMaterial, 30, 0, setOrichalcum, new LootCondition[0], Reference.MODID + ":" + ModItems.SynthesisMaterial.getUnlocalizedName().substring(5)));
			main.addEntry(new LootEntryItem(ModItems.SynthesisMaterial, 30, 0, setOrichalcumPlus, new LootCondition[0], Reference.MODID + ":" + ModItems.SynthesisMaterial.getUnlocalizedName().substring(5)));
			main.addEntry(new LootEntryItem(ModItems.SynthesisMaterial, 30, 0, setLostIllusion, new LootCondition[0], Reference.MODID + ":" + ModItems.SynthesisMaterial.getUnlocalizedName().substring(5)));
			main.addEntry(new LootEntryItem(ModItems.SynthesisMaterial, 30, 0, setManifestIllusion, new LootCondition[0], Reference.MODID + ":" + ModItems.SynthesisMaterial.getUnlocalizedName().substring(5)));

			event.getTable().removePool("pool1");
			event.getTable().removePool("pool2");
		}
		
		if(event.getName().equals(LootTableList.CHESTS_JUNGLE_TEMPLE))
		{
			LootFunction[] setCount = new LootFunction[]{ new SetCount(new LootCondition[0], new RandomValueRange(64, 64)) };
			LootPool main = event.getTable().getPool("main");
			main.addEntry(new LootEntryItem(ModItems.Recipe, 1, 10, new LootFunction[0], new LootCondition[0], Reference.MODID + ":" + ModItems.Recipe.getUnlocalizedName().substring(5)));
			main.addEntry(new LootEntryItem(ModItems.SynthesisMaterial, 30, 0, setMythrilCrystal, new LootCondition[0], Reference.MODID + ":" + ModItems.SynthesisMaterial.getUnlocalizedName().substring(5)));
			main.addEntry(new LootEntryItem(ModItems.SynthesisMaterial, 30, 0, setMythrilGem, new LootCondition[0], Reference.MODID + ":" + ModItems.SynthesisMaterial.getUnlocalizedName().substring(5)));
			main.addEntry(new LootEntryItem(ModItems.SynthesisMaterial, 30, 0, setMythrilStone, new LootCondition[0], Reference.MODID + ":" + ModItems.SynthesisMaterial.getUnlocalizedName().substring(5)));
			main.addEntry(new LootEntryItem(ModItems.SynthesisMaterial, 30, 0, setMythrilShard, new LootCondition[0], Reference.MODID + ":" + ModItems.SynthesisMaterial.getUnlocalizedName().substring(5)));
			main.addEntry(new LootEntryItem(ModItems.SynthesisMaterial, 30, 0, setOrichalcum, new LootCondition[0], Reference.MODID + ":" + ModItems.SynthesisMaterial.getUnlocalizedName().substring(5)));
			main.addEntry(new LootEntryItem(ModItems.SynthesisMaterial, 30, 0, setOrichalcumPlus, new LootCondition[0], Reference.MODID + ":" + ModItems.SynthesisMaterial.getUnlocalizedName().substring(5)));
			main.addEntry(new LootEntryItem(ModItems.SynthesisMaterial, 30, 0, setLostIllusion, new LootCondition[0], Reference.MODID + ":" + ModItems.SynthesisMaterial.getUnlocalizedName().substring(5)));
			main.addEntry(new LootEntryItem(ModItems.SynthesisMaterial, 30, 0, setManifestIllusion, new LootCondition[0], Reference.MODID + ":" + ModItems.SynthesisMaterial.getUnlocalizedName().substring(5)));

			event.getTable().removePool("pool1");
			event.getTable().removePool("pool2");
		}

		if(event.getName().equals(LootTableList.CHESTS_NETHER_BRIDGE))
		{
			LootFunction[] setCount = new LootFunction[]{ new SetCount(new LootCondition[0], new RandomValueRange(64, 64)) };
			LootPool main = event.getTable().getPool("main");
			main.addEntry(new LootEntryItem(ModItems.Recipe, 1, 10, new LootFunction[0], new LootCondition[0], Reference.MODID + ":" + ModItems.Recipe.getUnlocalizedName().substring(5)));
			main.addEntry(new LootEntryItem(ModItems.SynthesisMaterial, 30, 0, setMythrilCrystal, new LootCondition[0], Reference.MODID + ":" + ModItems.SynthesisMaterial.getUnlocalizedName().substring(5)));
			main.addEntry(new LootEntryItem(ModItems.SynthesisMaterial, 30, 0, setMythrilGem, new LootCondition[0], Reference.MODID + ":" + ModItems.SynthesisMaterial.getUnlocalizedName().substring(5)));
			main.addEntry(new LootEntryItem(ModItems.SynthesisMaterial, 30, 0, setMythrilStone, new LootCondition[0], Reference.MODID + ":" + ModItems.SynthesisMaterial.getUnlocalizedName().substring(5)));
			main.addEntry(new LootEntryItem(ModItems.SynthesisMaterial, 30, 0, setMythrilShard, new LootCondition[0], Reference.MODID + ":" + ModItems.SynthesisMaterial.getUnlocalizedName().substring(5)));
			main.addEntry(new LootEntryItem(ModItems.SynthesisMaterial, 30, 0, setOrichalcum, new LootCondition[0], Reference.MODID + ":" + ModItems.SynthesisMaterial.getUnlocalizedName().substring(5)));
			main.addEntry(new LootEntryItem(ModItems.SynthesisMaterial, 30, 0, setOrichalcumPlus, new LootCondition[0], Reference.MODID + ":" + ModItems.SynthesisMaterial.getUnlocalizedName().substring(5)));
			main.addEntry(new LootEntryItem(ModItems.SynthesisMaterial, 30, 0, setLostIllusion, new LootCondition[0], Reference.MODID + ":" + ModItems.SynthesisMaterial.getUnlocalizedName().substring(5)));
			main.addEntry(new LootEntryItem(ModItems.SynthesisMaterial, 30, 0, setManifestIllusion, new LootCondition[0], Reference.MODID + ":" + ModItems.SynthesisMaterial.getUnlocalizedName().substring(5)));

			event.getTable().removePool("pool1");
			event.getTable().removePool("pool2");
			event.getTable().removePool("pool3");
		}
		
		if(event.getName().equals(LootTableList.CHESTS_SIMPLE_DUNGEON))
		{
			// TODO Music discs
		}
		
		if(event.getName().equals(LootTableList.CHESTS_STRONGHOLD_CORRIDOR))
		{
			LootFunction[] setCount = new LootFunction[]{ new SetCount(new LootCondition[0], new RandomValueRange(64, 64)) };
			LootPool main = event.getTable().getPool("main");
			main.addEntry(new LootEntryItem(ModItems.Recipe, 1, 10, new LootFunction[0], new LootCondition[0], Reference.MODID + ":" + ModItems.Recipe.getUnlocalizedName().substring(5)));
			main.addEntry(new LootEntryItem(ModItems.SynthesisMaterial, 30, 0, setMythrilCrystal, new LootCondition[0], Reference.MODID + ":" + ModItems.SynthesisMaterial.getUnlocalizedName().substring(5)));
			main.addEntry(new LootEntryItem(ModItems.SynthesisMaterial, 30, 0, setMythrilGem, new LootCondition[0], Reference.MODID + ":" + ModItems.SynthesisMaterial.getUnlocalizedName().substring(5)));
			main.addEntry(new LootEntryItem(ModItems.SynthesisMaterial, 30, 0, setMythrilStone, new LootCondition[0], Reference.MODID + ":" + ModItems.SynthesisMaterial.getUnlocalizedName().substring(5)));
			main.addEntry(new LootEntryItem(ModItems.SynthesisMaterial, 30, 0, setMythrilShard, new LootCondition[0], Reference.MODID + ":" + ModItems.SynthesisMaterial.getUnlocalizedName().substring(5)));
			main.addEntry(new LootEntryItem(ModItems.SynthesisMaterial, 30, 0, setOrichalcum, new LootCondition[0], Reference.MODID + ":" + ModItems.SynthesisMaterial.getUnlocalizedName().substring(5)));
			main.addEntry(new LootEntryItem(ModItems.SynthesisMaterial, 30, 0, setOrichalcumPlus, new LootCondition[0], Reference.MODID + ":" + ModItems.SynthesisMaterial.getUnlocalizedName().substring(5)));
			main.addEntry(new LootEntryItem(ModItems.SynthesisMaterial, 30, 0, setLostIllusion, new LootCondition[0], Reference.MODID + ":" + ModItems.SynthesisMaterial.getUnlocalizedName().substring(5)));
			main.addEntry(new LootEntryItem(ModItems.SynthesisMaterial, 30, 0, setManifestIllusion, new LootCondition[0], Reference.MODID + ":" + ModItems.SynthesisMaterial.getUnlocalizedName().substring(5)));

			event.getTable().removePool("pool1");
			event.getTable().removePool("pool2");
		}
		
		if(event.getName().equals(LootTableList.CHESTS_STRONGHOLD_CROSSING))
		{
			LootFunction[] setCount = new LootFunction[]{ new SetCount(new LootCondition[0], new RandomValueRange(64, 64)) };
			LootPool main = event.getTable().getPool("main");
			main.addEntry(new LootEntryItem(ModItems.Recipe, 1, 10, new LootFunction[0], new LootCondition[0], Reference.MODID + ":" + ModItems.Recipe.getUnlocalizedName().substring(5)));
			main.addEntry(new LootEntryItem(ModItems.SynthesisMaterial, 30, 0, setMythrilCrystal, new LootCondition[0], Reference.MODID + ":" + ModItems.SynthesisMaterial.getUnlocalizedName().substring(5)));
			main.addEntry(new LootEntryItem(ModItems.SynthesisMaterial, 30, 0, setMythrilGem, new LootCondition[0], Reference.MODID + ":" + ModItems.SynthesisMaterial.getUnlocalizedName().substring(5)));
			main.addEntry(new LootEntryItem(ModItems.SynthesisMaterial, 30, 0, setMythrilStone, new LootCondition[0], Reference.MODID + ":" + ModItems.SynthesisMaterial.getUnlocalizedName().substring(5)));
			main.addEntry(new LootEntryItem(ModItems.SynthesisMaterial, 30, 0, setMythrilShard, new LootCondition[0], Reference.MODID + ":" + ModItems.SynthesisMaterial.getUnlocalizedName().substring(5)));
			main.addEntry(new LootEntryItem(ModItems.SynthesisMaterial, 30, 0, setOrichalcum, new LootCondition[0], Reference.MODID + ":" + ModItems.SynthesisMaterial.getUnlocalizedName().substring(5)));
			main.addEntry(new LootEntryItem(ModItems.SynthesisMaterial, 30, 0, setOrichalcumPlus, new LootCondition[0], Reference.MODID + ":" + ModItems.SynthesisMaterial.getUnlocalizedName().substring(5)));
			main.addEntry(new LootEntryItem(ModItems.SynthesisMaterial, 30, 0, setLostIllusion, new LootCondition[0], Reference.MODID + ":" + ModItems.SynthesisMaterial.getUnlocalizedName().substring(5)));
			main.addEntry(new LootEntryItem(ModItems.SynthesisMaterial, 30, 0, setManifestIllusion, new LootCondition[0], Reference.MODID + ":" + ModItems.SynthesisMaterial.getUnlocalizedName().substring(5)));

			event.getTable().removePool("pool1");
			event.getTable().removePool("pool2");
		}
		
		if(event.getName().equals(LootTableList.CHESTS_STRONGHOLD_LIBRARY))
		{
			LootFunction[] setCount = new LootFunction[]{ new SetCount(new LootCondition[0], new RandomValueRange(64, 64)) };
			LootPool main = event.getTable().getPool("main");
			main.addEntry(new LootEntryItem(ModItems.Recipe, 1, 10, new LootFunction[0], new LootCondition[0], Reference.MODID + ":" + ModItems.Recipe.getUnlocalizedName().substring(5)));
			main.addEntry(new LootEntryItem(ModItems.SynthesisMaterial, 30, 0, setMythrilCrystal, new LootCondition[0], Reference.MODID + ":" + ModItems.SynthesisMaterial.getUnlocalizedName().substring(5)));
			main.addEntry(new LootEntryItem(ModItems.SynthesisMaterial, 30, 0, setMythrilGem, new LootCondition[0], Reference.MODID + ":" + ModItems.SynthesisMaterial.getUnlocalizedName().substring(5)));
			main.addEntry(new LootEntryItem(ModItems.SynthesisMaterial, 30, 0, setMythrilStone, new LootCondition[0], Reference.MODID + ":" + ModItems.SynthesisMaterial.getUnlocalizedName().substring(5)));
			main.addEntry(new LootEntryItem(ModItems.SynthesisMaterial, 30, 0, setMythrilShard, new LootCondition[0], Reference.MODID + ":" + ModItems.SynthesisMaterial.getUnlocalizedName().substring(5)));
			main.addEntry(new LootEntryItem(ModItems.SynthesisMaterial, 30, 0, setOrichalcum, new LootCondition[0], Reference.MODID + ":" + ModItems.SynthesisMaterial.getUnlocalizedName().substring(5)));
			main.addEntry(new LootEntryItem(ModItems.SynthesisMaterial, 30, 0, setOrichalcumPlus, new LootCondition[0], Reference.MODID + ":" + ModItems.SynthesisMaterial.getUnlocalizedName().substring(5)));
			main.addEntry(new LootEntryItem(ModItems.SynthesisMaterial, 30, 0, setLostIllusion, new LootCondition[0], Reference.MODID + ":" + ModItems.SynthesisMaterial.getUnlocalizedName().substring(5)));
			main.addEntry(new LootEntryItem(ModItems.SynthesisMaterial, 30, 0, setManifestIllusion, new LootCondition[0], Reference.MODID + ":" + ModItems.SynthesisMaterial.getUnlocalizedName().substring(5)));

			event.getTable().removePool("pool1");
			event.getTable().removePool("pool2");
		}
		
		if(event.getName().equals(LootTableList.CHESTS_VILLAGE_BLACKSMITH))
		{
			LootFunction[] setCount = new LootFunction[]{ new SetCount(new LootCondition[0], new RandomValueRange(64, 64)) };
			LootPool main = event.getTable().getPool("main");
			main.addEntry(new LootEntryItem(ModItems.Recipe, 1, 10, new LootFunction[0], new LootCondition[0], Reference.MODID + ":" + ModItems.Recipe.getUnlocalizedName().substring(5)));
			main.addEntry(new LootEntryItem(ModItems.SynthesisMaterial, 30, 0, setMythrilCrystal, new LootCondition[0], Reference.MODID + ":" + ModItems.SynthesisMaterial.getUnlocalizedName().substring(5)));
			main.addEntry(new LootEntryItem(ModItems.SynthesisMaterial, 30, 0, setMythrilGem, new LootCondition[0], Reference.MODID + ":" + ModItems.SynthesisMaterial.getUnlocalizedName().substring(5)));
			main.addEntry(new LootEntryItem(ModItems.SynthesisMaterial, 30, 0, setMythrilStone, new LootCondition[0], Reference.MODID + ":" + ModItems.SynthesisMaterial.getUnlocalizedName().substring(5)));
			main.addEntry(new LootEntryItem(ModItems.SynthesisMaterial, 30, 0, setMythrilShard, new LootCondition[0], Reference.MODID + ":" + ModItems.SynthesisMaterial.getUnlocalizedName().substring(5)));
			main.addEntry(new LootEntryItem(ModItems.SynthesisMaterial, 30, 0, setOrichalcum, new LootCondition[0], Reference.MODID + ":" + ModItems.SynthesisMaterial.getUnlocalizedName().substring(5)));
			main.addEntry(new LootEntryItem(ModItems.SynthesisMaterial, 30, 0, setOrichalcumPlus, new LootCondition[0], Reference.MODID + ":" + ModItems.SynthesisMaterial.getUnlocalizedName().substring(5)));
			main.addEntry(new LootEntryItem(ModItems.SynthesisMaterial, 30, 0, setLostIllusion, new LootCondition[0], Reference.MODID + ":" + ModItems.SynthesisMaterial.getUnlocalizedName().substring(5)));
			main.addEntry(new LootEntryItem(ModItems.SynthesisMaterial, 30, 0, setManifestIllusion, new LootCondition[0], Reference.MODID + ":" + ModItems.SynthesisMaterial.getUnlocalizedName().substring(5)));

			event.getTable().removePool("pool1");
			event.getTable().removePool("pool2");
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
