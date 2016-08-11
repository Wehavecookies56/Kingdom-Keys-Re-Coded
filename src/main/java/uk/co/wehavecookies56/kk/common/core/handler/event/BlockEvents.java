package uk.co.wehavecookies56.kk.common.core.handler.event;

import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import uk.co.wehavecookies56.kk.common.achievement.ModAchievements;
import uk.co.wehavecookies56.kk.common.block.ModBlocks;
import uk.co.wehavecookies56.kk.common.core.helper.AchievementHelper;
import uk.co.wehavecookies56.kk.common.item.ItemStacks;
import uk.co.wehavecookies56.kk.common.item.ModItems;
import uk.co.wehavecookies56.kk.common.lib.Strings;
import uk.co.wehavecookies56.kk.common.util.Utils;

/**
 * Created by Toby on 19/07/2016.
 */
public class BlockEvents {

    @SubscribeEvent
    public void onBlockDestroyed (BlockEvent.HarvestDropsEvent event) {
        int fortune;
        if (event.isSilkTouching()) {
            return;
        }

        ItemStack BlazingShard = new ItemStack(ModItems.SynthesisMaterial, Utils.randomWithRange(1, 3));
        ItemStacks.createSynthesisItem(BlazingShard, Strings.SM_BlazingShard, "C");
        ItemStack BlazingStone = new ItemStack(ModItems.SynthesisMaterial, Utils.randomWithRange(1, 3));
        ItemStacks.createSynthesisItem(BlazingStone, Strings.SM_BlazingStone, "B");
        ItemStack BlazingGem = new ItemStack(ModItems.SynthesisMaterial, Utils.randomWithRange(1, 3));
        ItemStacks.createSynthesisItem(BlazingGem, Strings.SM_BlazingGem, "A");
        ItemStack BlazingCrystal = new ItemStack(ModItems.SynthesisMaterial, Utils.randomWithRange(1, 3));
        ItemStacks.createSynthesisItem(BlazingCrystal, Strings.SM_BlazingCrystal, "S");
        
        ItemStack BrightShard = new ItemStack(ModItems.SynthesisMaterial, Utils.randomWithRange(1, 3));
        ItemStacks.createSynthesisItem(BrightShard, Strings.SM_BrightShard, "C");
        ItemStack BrightStone = new ItemStack(ModItems.SynthesisMaterial, Utils.randomWithRange(1, 3));
        ItemStacks.createSynthesisItem(BrightStone, Strings.SM_BrightStone, "B");
        ItemStack BrightGem = new ItemStack(ModItems.SynthesisMaterial, Utils.randomWithRange(1, 3));
        ItemStacks.createSynthesisItem(BrightGem, Strings.SM_BrightGem, "A");
        ItemStack BrightCrystal = new ItemStack(ModItems.SynthesisMaterial, Utils.randomWithRange(1, 3));
        ItemStacks.createSynthesisItem(BrightCrystal, Strings.SM_BrightCrystal, "S");

        ItemStack DarkShard = new ItemStack(ModItems.SynthesisMaterial, Utils.randomWithRange(1, 3));
        ItemStacks.createSynthesisItem(DarkShard, Strings.SM_DarkShard, "C");
        ItemStack DarkStone = new ItemStack(ModItems.SynthesisMaterial, Utils.randomWithRange(1, 3));
        ItemStacks.createSynthesisItem(DarkStone, Strings.SM_DarkStone, "B");
        ItemStack DarkGem = new ItemStack(ModItems.SynthesisMaterial, Utils.randomWithRange(1, 3));
        ItemStacks.createSynthesisItem(DarkGem, Strings.SM_DarkGem, "A");
        ItemStack DarkCrystal = new ItemStack(ModItems.SynthesisMaterial, Utils.randomWithRange(1, 3));
        ItemStacks.createSynthesisItem(DarkCrystal, Strings.SM_DarkCrystal, "S");

        ItemStack DenseShard = new ItemStack(ModItems.SynthesisMaterial, Utils.randomWithRange(1, 3));
        ItemStacks.createSynthesisItem(DenseShard, Strings.SM_DenseShard, "C");
        ItemStack DenseStone = new ItemStack(ModItems.SynthesisMaterial, Utils.randomWithRange(1, 3));
        ItemStacks.createSynthesisItem(DenseStone, Strings.SM_DenseStone, "B");
        ItemStack DenseGem = new ItemStack(ModItems.SynthesisMaterial, Utils.randomWithRange(1, 3));
        ItemStacks.createSynthesisItem(DenseGem, Strings.SM_DenseGem, "A");
        ItemStack DenseCrystal = new ItemStack(ModItems.SynthesisMaterial, Utils.randomWithRange(1, 3));
        ItemStacks.createSynthesisItem(DenseCrystal, Strings.SM_DenseCrystal, "S");

        ItemStack EnergyShard = new ItemStack(ModItems.SynthesisMaterial, Utils.randomWithRange(1, 3));
        ItemStacks.createSynthesisItem(EnergyShard, Strings.SM_EnergyShard, "C");
        ItemStack EnergyStone = new ItemStack(ModItems.SynthesisMaterial, Utils.randomWithRange(1, 3));
        ItemStacks.createSynthesisItem(EnergyStone, Strings.SM_EnergyStone, "B");
        ItemStack EnergyGem = new ItemStack(ModItems.SynthesisMaterial, Utils.randomWithRange(1, 3));
        ItemStacks.createSynthesisItem(EnergyGem, Strings.SM_EnergyGem, "A");
        ItemStack EnergyCrystal = new ItemStack(ModItems.SynthesisMaterial, Utils.randomWithRange(1, 3));
        ItemStacks.createSynthesisItem(EnergyCrystal, Strings.SM_EnergyCrystal, "S");

        ItemStack FrostShard = new ItemStack(ModItems.SynthesisMaterial, Utils.randomWithRange(1, 3));
        ItemStacks.createSynthesisItem(FrostShard, Strings.SM_FrostShard, "C");
        ItemStack FrostStone = new ItemStack(ModItems.SynthesisMaterial, Utils.randomWithRange(1, 3));
        ItemStacks.createSynthesisItem(FrostStone, Strings.SM_FrostStone, "B");
        ItemStack FrostGem = new ItemStack(ModItems.SynthesisMaterial, Utils.randomWithRange(1, 3));
        ItemStacks.createSynthesisItem(FrostGem, Strings.SM_FrostGem, "A");
        ItemStack FrostCrystal = new ItemStack(ModItems.SynthesisMaterial, Utils.randomWithRange(1, 3));
        ItemStacks.createSynthesisItem(FrostCrystal, Strings.SM_FrostCrystal, "S");

        ItemStack LightningShard = new ItemStack(ModItems.SynthesisMaterial, Utils.randomWithRange(1, 3));
        ItemStacks.createSynthesisItem(LightningShard, Strings.SM_LightningShard, "C");
        ItemStack LightningStone = new ItemStack(ModItems.SynthesisMaterial, Utils.randomWithRange(1, 3));
        ItemStacks.createSynthesisItem(LightningStone, Strings.SM_LightningStone, "B");
        ItemStack LightningGem = new ItemStack(ModItems.SynthesisMaterial, Utils.randomWithRange(1, 3));
        ItemStacks.createSynthesisItem(LightningGem, Strings.SM_LightningGem, "A");
        ItemStack LightningCrystal = new ItemStack(ModItems.SynthesisMaterial, Utils.randomWithRange(1, 3));
        ItemStacks.createSynthesisItem(LightningCrystal, Strings.SM_LightningCrystal, "S");

        ItemStack LucidShard = new ItemStack(ModItems.SynthesisMaterial, Utils.randomWithRange(1, 3));
        ItemStacks.createSynthesisItem(LucidShard, Strings.SM_LucidShard, "C");
        ItemStack LucidStone = new ItemStack(ModItems.SynthesisMaterial, Utils.randomWithRange(1, 3));
        ItemStacks.createSynthesisItem(LucidStone, Strings.SM_LucidStone, "B");
        ItemStack LucidGem = new ItemStack(ModItems.SynthesisMaterial, Utils.randomWithRange(1, 3));
        ItemStacks.createSynthesisItem(LucidGem, Strings.SM_LucidGem, "A");
        ItemStack LucidCrystal = new ItemStack(ModItems.SynthesisMaterial, Utils.randomWithRange(1, 3));
        ItemStacks.createSynthesisItem(LucidCrystal, Strings.SM_LucidCrystal, "S");

        ItemStack PowerShard = new ItemStack(ModItems.SynthesisMaterial, Utils.randomWithRange(1, 3));
        ItemStacks.createSynthesisItem(PowerShard, Strings.SM_PowerShard, "C");
        ItemStack PowerStone = new ItemStack(ModItems.SynthesisMaterial, Utils.randomWithRange(1, 3));
        ItemStacks.createSynthesisItem(PowerStone, Strings.SM_PowerStone, "B");
        ItemStack PowerGem = new ItemStack(ModItems.SynthesisMaterial, Utils.randomWithRange(1, 3));
        ItemStacks.createSynthesisItem(PowerGem, Strings.SM_PowerGem, "A");
        ItemStack PowerCrystal = new ItemStack(ModItems.SynthesisMaterial, Utils.randomWithRange(1, 3));
        ItemStacks.createSynthesisItem(PowerCrystal, Strings.SM_PowerCrystal, "S");

        ItemStack RemembranceShard = new ItemStack(ModItems.SynthesisMaterial, Utils.randomWithRange(1, 3));
        ItemStacks.createSynthesisItem(RemembranceShard, Strings.SM_RemembranceShard, "C");
        ItemStack RemembranceStone = new ItemStack(ModItems.SynthesisMaterial, Utils.randomWithRange(1, 3));
        ItemStacks.createSynthesisItem(RemembranceStone, Strings.SM_RemembranceStone, "B");
        ItemStack RemembranceGem = new ItemStack(ModItems.SynthesisMaterial, Utils.randomWithRange(1, 3));
        ItemStacks.createSynthesisItem(RemembranceGem, Strings.SM_RemembranceGem, "A");
        ItemStack RemembranceCrystal = new ItemStack(ModItems.SynthesisMaterial, Utils.randomWithRange(1, 3));
        ItemStacks.createSynthesisItem(RemembranceCrystal, Strings.SM_RemembranceCrystal, "S");

        ItemStack SerenityShard = new ItemStack(ModItems.SynthesisMaterial, Utils.randomWithRange(1, 3));
        ItemStacks.createSynthesisItem(SerenityShard, Strings.SM_SerenityShard, "C");
        ItemStack SerenityStone = new ItemStack(ModItems.SynthesisMaterial, Utils.randomWithRange(1, 3));
        ItemStacks.createSynthesisItem(SerenityStone, Strings.SM_SerenityStone, "B");
        ItemStack SerenityGem = new ItemStack(ModItems.SynthesisMaterial, Utils.randomWithRange(1, 3));
        ItemStacks.createSynthesisItem(SerenityGem, Strings.SM_SerenityGem, "A");
        ItemStack SerenityCrystal = new ItemStack(ModItems.SynthesisMaterial, Utils.randomWithRange(1, 3));
        ItemStacks.createSynthesisItem(SerenityCrystal, Strings.SM_SerenityCrystal, "S");

        ItemStack TranquilShard = new ItemStack(ModItems.SynthesisMaterial, Utils.randomWithRange(1, 3));
        ItemStacks.createSynthesisItem(TranquilShard, Strings.SM_TranquilShard, "C");
        ItemStack TranquilStone = new ItemStack(ModItems.SynthesisMaterial, Utils.randomWithRange(1, 3));
        ItemStacks.createSynthesisItem(TranquilStone, Strings.SM_TranquilStone, "B");
        ItemStack TranquilGem = new ItemStack(ModItems.SynthesisMaterial, Utils.randomWithRange(1, 3));
        ItemStacks.createSynthesisItem(TranquilGem, Strings.SM_TranquilGem, "A");
        ItemStack TranquilCrystal = new ItemStack(ModItems.SynthesisMaterial, Utils.randomWithRange(1, 3));
        ItemStacks.createSynthesisItem(TranquilCrystal, Strings.SM_TranquilCrystal, "S");

        ItemStack TwilightShard = new ItemStack(ModItems.SynthesisMaterial, Utils.randomWithRange(1, 3));
        ItemStacks.createSynthesisItem(TwilightShard, Strings.SM_TwilightShard, "C");
        ItemStack TwilightStone = new ItemStack(ModItems.SynthesisMaterial, Utils.randomWithRange(1, 3));
        ItemStacks.createSynthesisItem(TwilightStone, Strings.SM_TwilightStone, "B");
        ItemStack TwilightGem = new ItemStack(ModItems.SynthesisMaterial, Utils.randomWithRange(1, 3));
        ItemStacks.createSynthesisItem(TwilightGem, Strings.SM_TwilightGem, "A");
        ItemStack TwilightCrystal = new ItemStack(ModItems.SynthesisMaterial, Utils.randomWithRange(1, 3));
        ItemStacks.createSynthesisItem(TwilightCrystal, Strings.SM_TwilightCrystal, "S");

        ItemStack StormyShard = new ItemStack(ModItems.SynthesisMaterial, Utils.randomWithRange(1, 3));
        ItemStacks.createSynthesisItem(StormyShard, Strings.SM_StormyShard, "C");
        ItemStack StormyStone = new ItemStack(ModItems.SynthesisMaterial, Utils.randomWithRange(1, 3));
        ItemStacks.createSynthesisItem(StormyStone, Strings.SM_StormyStone, "B");
        ItemStack StormyGem = new ItemStack(ModItems.SynthesisMaterial, Utils.randomWithRange(1, 3));
        ItemStacks.createSynthesisItem(StormyGem, Strings.SM_StormyGem, "A");
        ItemStack StormyCrystal = new ItemStack(ModItems.SynthesisMaterial, Utils.randomWithRange(1, 3));
        ItemStacks.createSynthesisItem(StormyCrystal, Strings.SM_StormyCrystal, "S");

        ItemStack Orichalcum = new ItemStack(ModItems.SynthesisMaterial, Utils.randomWithRange(1, 3));
        ItemStacks.createSynthesisItem(Orichalcum, Strings.SM_Orichalcum, "A");
        ItemStack OrichalcumPlus = new ItemStack(ModItems.SynthesisMaterial, Utils.randomWithRange(1, 3));
        ItemStacks.createSynthesisItem(OrichalcumPlus, Strings.SM_OrichalcumPlus, "S");

        ItemStack LostIllusion = new ItemStack(ModItems.SynthesisMaterial, Utils.randomWithRange(1, 3));
        ItemStacks.createSynthesisItem(LostIllusion, Strings.SM_LostIllusion, "S");
        ItemStack ManifestIllusion = new ItemStack(ModItems.SynthesisMaterial, Utils.randomWithRange(1, 3));
        ItemStacks.createSynthesisItem(ManifestIllusion, Strings.SM_ManifestIllusion, "A");
        
        int numberOfDrops = Utils.randomWithRange(1, 3);
     //   System.out.println("NOD: "+numberOfDrops);

        numberOfDrops += event.getFortuneLevel();
   //     System.out.println("Fortune: "+event.getFortuneLevel());
 //       System.out.println("NOD+F: "+numberOfDrops);

        if (event.getState().getBlock() == ModBlocks.BlazingOre) {
        	for(int i = 0; i<numberOfDrops; i++)
            {
                int dropAmount = Utils.randomWithRange(0, 3);
                switch (dropAmount)
                {
                case 0:
                    event.getDrops().add(BlazingShard);
                    break;
                case 1:
                    event.getDrops().add(BlazingStone);
                    break;
                case 2:
                    event.getDrops().add(BlazingGem);
                    break;
                case 3:
                    event.getDrops().add(BlazingCrystal);
                    break;
                }
            }
        } else if (event.getState().getBlock() == ModBlocks.BrightOre) {
        	for(int i = 0; i<numberOfDrops; i++)
            {
                int dropAmount = Utils.randomWithRange(0, 3);
                switch (dropAmount)
                {
                case 0:
                    event.getDrops().add(BrightShard);
                    break;
                case 1:
                    event.getDrops().add(BrightStone);
                    break;
                case 2:
                    event.getDrops().add(BrightGem);
                    break;
                case 3:
                    event.getDrops().add(BrightCrystal);
                    break;
                }
            }
        } else if (event.getState().getBlock() == ModBlocks.DarkOre) {
        	for(int i = 0; i<numberOfDrops; i++)
            {
                int dropAmount = Utils.randomWithRange(0, 3);
                switch (dropAmount)
                {
                case 0:
                    event.getDrops().add(DarkShard);
                    break;
                case 1:
                    event.getDrops().add(DarkStone);
                    break;
                case 2:
                    event.getDrops().add(DarkGem);
                    break;
                case 3:
                    event.getDrops().add(DarkCrystal);
                    break;
                }
            }
        } else if (event.getState().getBlock() == ModBlocks.DarkOreE) {
        	for(int i = 0; i<numberOfDrops; i++)
            {
                int dropAmount = Utils.randomWithRange(0, 3);
                switch (dropAmount)
                {
                case 0:
                    event.getDrops().add(DarkShard);
                    break;
                case 1:
                    event.getDrops().add(DarkStone);
                    break;
                case 2:
                    event.getDrops().add(DarkGem);
                    break;
                case 3:
                    event.getDrops().add(DarkCrystal);
                    break;
                }
            }
        } else if (event.getState().getBlock() == ModBlocks.DenseOre) {
        	for(int i = 0; i<numberOfDrops; i++)
            {
                int dropAmount = Utils.randomWithRange(0, 3);
                switch (dropAmount)
                {
                case 0:
                    event.getDrops().add(DenseShard);
                    break;
                case 1:
                    event.getDrops().add(DenseStone);
                    break;
                case 2:
                    event.getDrops().add(DenseGem);
                    break;
                case 3:
                    event.getDrops().add(DenseCrystal);
                    break;
                }
            }
        } else if (event.getState().getBlock() == ModBlocks.EnergyOre) {
        	for(int i = 0; i<numberOfDrops; i++)
            {
                int dropAmount = Utils.randomWithRange(0, 3);
                switch (dropAmount)
                {
                case 0:
                    event.getDrops().add(EnergyShard);
                    break;
                case 1:
                    event.getDrops().add(EnergyStone);
                    break;
                case 2:
                    event.getDrops().add(EnergyGem);
                    break;
                case 3:
                    event.getDrops().add(EnergyCrystal);
                    break;
                }
            }
        } else if (event.getState().getBlock() == ModBlocks.FrostOre) {
        	for(int i = 0; i<numberOfDrops; i++)
            {
                int dropAmount = Utils.randomWithRange(0, 3);
                switch (dropAmount)
                {
                case 0:
                    event.getDrops().add(FrostShard);
                    break;
                case 1:
                    event.getDrops().add(FrostStone);
                    break;
                case 2:
                    event.getDrops().add(FrostGem);
                    break;
                case 3:
                    event.getDrops().add(FrostCrystal);
                    break;
                }
            }
        } else if (event.getState().getBlock() == ModBlocks.LightningOre) {
        	for(int i = 0; i<numberOfDrops; i++)
            {
                int dropAmount = Utils.randomWithRange(0, 3);
                switch (dropAmount)
                {
                case 0:
                    event.getDrops().add(LightningShard);
                    break;
                case 1:
                    event.getDrops().add(LightningStone);
                    break;
                case 2:
                    event.getDrops().add(LightningGem);
                    break;
                case 3:
                    event.getDrops().add(LightningCrystal);
                    break;
                }
            }
        } else if (event.getState().getBlock() == ModBlocks.LucidOre) {
        	for(int i = 0; i<numberOfDrops; i++)
            {
                int dropAmount = Utils.randomWithRange(0, 3);
                switch (dropAmount)
                {
                case 0:
                    event.getDrops().add(LucidShard);
                    break;
                case 1:
                    event.getDrops().add(LucidStone);
                    break;
                case 2:
                    event.getDrops().add(LucidGem);
                    break;
                case 3:
                    event.getDrops().add(LucidCrystal);
                    break;
                }
            }
        } else if (event.getState().getBlock() == ModBlocks.PowerOre) {
        	for(int i = 0; i<numberOfDrops; i++)
            {
                int dropAmount = Utils.randomWithRange(0, 3);
                switch (dropAmount)
                {
                case 0:
                    event.getDrops().add(PowerShard);
                    break;
                case 1:
                    event.getDrops().add(PowerStone);
                    break;
                case 2:
                    event.getDrops().add(PowerGem);
                    break;
                case 3:
                    event.getDrops().add(PowerCrystal);
                    break;
                }
            }
        } else if (event.getState().getBlock() == ModBlocks.PowerOreE) {
        	for(int i = 0; i<numberOfDrops; i++)
            {
                int dropAmount = Utils.randomWithRange(0, 3);
                switch (dropAmount)
                {
                case 0:
                    event.getDrops().add(PowerShard);
                    break;
                case 1:
                    event.getDrops().add(PowerStone);
                    break;
                case 2:
                    event.getDrops().add(PowerGem);
                    break;
                case 3:
                    event.getDrops().add(PowerCrystal);
                    break;
                }
            }
        } else if (event.getState().getBlock() == ModBlocks.RemembranceOre) {
        	for(int i = 0; i<numberOfDrops; i++)
            {
                int dropAmount = Utils.randomWithRange(0, 3);
                switch (dropAmount)
                {
                case 0:
                    event.getDrops().add(RemembranceShard);
                    break;
                case 1:
                    event.getDrops().add(RemembranceStone);
                    break;
                case 2:
                    event.getDrops().add(RemembranceGem);
                    break;
                case 3:
                    event.getDrops().add(RemembranceCrystal);
                    break;
                }
            }
        } else if (event.getState().getBlock() == ModBlocks.SerenityOre) {
        	for(int i = 0; i<numberOfDrops; i++)
            {
                int dropAmount = Utils.randomWithRange(0, 3);
                switch (dropAmount)
                {
                case 0:
                    event.getDrops().add(SerenityShard);
                    break;
                case 1:
                    event.getDrops().add(SerenityStone);
                    break;
                case 2:
                    event.getDrops().add(SerenityGem);
                    break;
                case 3:
                    event.getDrops().add(SerenityCrystal);
                    break;
                }
            }
        } else if (event.getState().getBlock() == ModBlocks.TranquilOre) {
        	for(int i = 0; i<numberOfDrops; i++)
            {
                int dropAmount = Utils.randomWithRange(0, 3);
                switch (dropAmount)
                {
                case 0:
                    event.getDrops().add(TranquilShard);
                    break;
                case 1:
                    event.getDrops().add(TranquilStone);
                    break;
                case 2:
                    event.getDrops().add(TranquilGem);
                    break;
                case 3:
                    event.getDrops().add(TranquilCrystal);
                    break;
                }
            }
        } else if (event.getState().getBlock() == ModBlocks.TwilightOre) {
        	for(int i = 0; i<numberOfDrops; i++)
            {
                int dropAmount = Utils.randomWithRange(0, 3);
                switch (dropAmount)
                {
                case 0:
                    event.getDrops().add(TwilightShard);
                    break;
                case 1:
                    event.getDrops().add(TwilightStone);
                    break;
                case 2:
                    event.getDrops().add(TwilightGem);
                    break;
                case 3:
                    event.getDrops().add(TwilightCrystal);
                    break;
                }
            }
        } else if (event.getState().getBlock() == ModBlocks.StormyOre) {
        	for(int i = 0; i<numberOfDrops; i++)
            {
                int dropAmount = Utils.randomWithRange(0, 3);
                switch (dropAmount)
                {
                case 0:
                    event.getDrops().add(StormyShard);
                    break;
                case 1:
                    event.getDrops().add(StormyStone);
                    break;
                case 2:
                    event.getDrops().add(StormyGem);
                    break;
                case 3:
                    event.getDrops().add(StormyCrystal);
                    break;
                }
            }
        } else if (event.getState().getBlock() == ModBlocks.PrizeBlox) {
            AchievementHelper.addAchievement(event.getHarvester(), ModAchievements.getPrizeBlox);
        	for(int i = 0; i<numberOfDrops; i++)
        	{
        		int dropAmount = Utils.randomWithRange(1, 29);
        		
        		ItemStack munny = new ItemStack(ModItems.Munny, 1);

	            switch (dropAmount) {
	                case 1:
	                    munny.setTagCompound(new NBTTagCompound());
	                    munny.getTagCompound().setInteger("amount", 50);
	                    event.getDrops().add(munny);
	                    break;
	                case 2:
	                    munny.setTagCompound(new NBTTagCompound());
	                    munny.getTagCompound().setInteger("amount", 100);
	                    event.getDrops().add(munny);
	                    break;
	                case 3:
	                    munny.setTagCompound(new NBTTagCompound());
	                    munny.getTagCompound().setInteger("amount", 500);
	                    event.getDrops().add(munny);
	                    break;
	                case 4:
	                    munny.setTagCompound(new NBTTagCompound());
	                    munny.getTagCompound().setInteger("amount", 700);
	                    event.getDrops().add(munny);
	                    break;
	                case 5:
	                    event.getDrops().add(BlazingGem);
	                    break;
	                case 6:
	                    event.getDrops().add(BrightGem);
	                    break;
	                case 7:
	                    event.getDrops().add(DarkGem);
	                    break;
	                case 8:
	                    event.getDrops().add(DenseGem);
	                    break;
	                case 9:
	                    event.getDrops().add(EnergyGem);
	                    break;
	                case 10:
	                    event.getDrops().add(FrostGem);
	                    break;
	                case 11:
	                    event.getDrops().add(LucidGem);
	                    break;
	                case 12:
	                    event.getDrops().add(PowerGem);
	                    break;
	                case 13:
	                	event.getDrops().add(RemembranceGem);
	                    break;
	                case 14:
	                	event.getDrops().add(SerenityGem);
	                    break;
	                case 15:
	                    event.getDrops().add(TranquilGem);
	                    break;
	                case 16:
	                    event.getDrops().add(TwilightGem);
	                    break;
	                case 17:
	                    event.getDrops().add(BlazingStone);
	                    break;
	                case 18:
	                    event.getDrops().add(BrightStone);
	                    break;
	                case 19:
	                    event.getDrops().add(DarkStone);
	                    break;
	                case 20:
	                    event.getDrops().add(DenseStone);
	                    break;
	                case 21:
	                    event.getDrops().add(EnergyStone);
	                    break;
	                case 22:
	                    event.getDrops().add(FrostStone);
	                    break;
	                case 23:
	                    event.getDrops().add(LucidStone);
	                    break;
	                case 24:
	                    event.getDrops().add(PowerStone);
	                    break;
	                case 25:
	                    event.getDrops().add(RemembranceStone);
	                    break;
	                case 26:
	                    event.getDrops().add(SerenityStone);
	                    break;
	                case 27:
	                    event.getDrops().add(TranquilStone);
	                    break;
	                case 28:
	                    event.getDrops().add(TwilightStone);
	                    break;
	                case 29:
	                    event.getDrops().add(Orichalcum);
	                    break;
	            }
            }
        } else if (event.getState().getBlock() == ModBlocks.RarePrizeBlox) {
        	AchievementHelper.addAchievement(event.getHarvester(), ModAchievements.getPrizeBlox);
        	for(int i = 0; i<numberOfDrops; i++)
        	{
	        	int dropAmount = Utils.randomWithRange(1, 38);
	            ItemStack munny = new ItemStack(ModItems.Munny, 1);
	            switch (dropAmount) {
	                case 1:
	                    munny.setTagCompound(new NBTTagCompound());
	                    munny.getTagCompound().setInteger("amount", 1000);
	                    event.getDrops().add(munny);
	                    break;
	                case 2:
	                    munny.setTagCompound(new NBTTagCompound());
	                    munny.getTagCompound().setInteger("amount", 1500);
	                    event.getDrops().add(munny);
	                    break;
	                case 3:
	                    munny.setTagCompound(new NBTTagCompound());
	                    munny.getTagCompound().setInteger("amount", 2000);
	                    event.getDrops().add(munny);
	                    break;
	                case 4:
	                    munny.setTagCompound(new NBTTagCompound());
	                    munny.getTagCompound().setInteger("amount", 3000);
	                    event.getDrops().add(munny);
	                    break;
	                case 5:
	                    event.getDrops().add(BlazingGem);
	                    break;
	                case 6:
	                    event.getDrops().add(BrightGem);
	                    break;
	                case 7:
	                    event.getDrops().add(DarkGem);
	                    break;
	                case 8:
	                    event.getDrops().add(DenseGem);
	                    break;
	                case 9:
	                    event.getDrops().add(EnergyGem);
	                    break;
	                case 10:
	                    event.getDrops().add(FrostGem);
	                    break;
	                case 11:
	                    event.getDrops().add(LucidGem);
	                    break;
	                case 12:
	                    event.getDrops().add(PowerGem);
	                    break;
	                case 13:
	                    event.getDrops().add(RemembranceGem);
	                    break;
	                case 14:
	                    event.getDrops().add(SerenityGem);
	                    break;
	                case 15:
	                    event.getDrops().add(TranquilGem);
	                    break;
	                case 16:
	                    event.getDrops().add(TwilightGem);
	                    break;
	                case 17:
	                    event.getDrops().add(BlazingCrystal);
	                    break;
	                case 18:
	                    event.getDrops().add(BrightCrystal);
	                    break;
	                case 19:
	                    event.getDrops().add(DarkCrystal);
	                    break;
	                case 20:
	                    event.getDrops().add(DenseCrystal);
	                    break;
	                case 21:
	                    event.getDrops().add(EnergyCrystal);
	                    break;
	                case 22:
	                    event.getDrops().add(FrostCrystal);
	                    break;
	                case 23:
	                    event.getDrops().add(LucidCrystal);
	                    break;
	                case 24:
	                    event.getDrops().add(PowerCrystal);
	                    break;
	                case 25:
	                    event.getDrops().add(RemembranceCrystal);
	                    break;
	                case 26:
	                    event.getDrops().add(SerenityCrystal);
	                    break;
	                case 27:
	                    event.getDrops().add(TranquilCrystal);
	                    break;
	                case 28:
	                    event.getDrops().add(TwilightCrystal);
	                    break;
	                case 29:
	                    event.getDrops().add(Orichalcum);
	                    break;
	                case 30:
	                    event.getDrops().add(OrichalcumPlus);
	                    break;
	                case 32:
	                    event.getDrops().add(LostIllusion);
	                    break;
	                case 33:
	                    event.getDrops().add(ManifestIllusion);
	                    break;
	                case 34:
	                    ItemStack valorForm = new ItemStack(ModItems.LevelUpValor, 1);
	                    event.getDrops().add(valorForm);
	                    break;
	                case 35:
	                    ItemStack wisdomForm = new ItemStack(ModItems.LevelUpWisdom, 1);
	                    event.getDrops().add(wisdomForm);
	                    break;
	                case 36:
	                    ItemStack limitForm = new ItemStack(ModItems.LevelUpLimit, 1);
	                    event.getDrops().add(limitForm);
	                    break;
	                case 37:
	                    ItemStack masterForm = new ItemStack(ModItems.LevelUpMaster, 1);
	                    event.getDrops().add(masterForm);
	                    break;
	                case 38:
	                    ItemStack finalForm = new ItemStack(ModItems.LevelUpFinal, 1);
	                    event.getDrops().add(finalForm);
	                    break;
	            }
        	}
        }
    }
}
