package uk.co.wehavecookies56.kk.common.core.handler.event;

import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import uk.co.wehavecookies56.kk.common.block.ModBlocks;
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

        if (event.getState().getBlock() == ModBlocks.BlazingOre) {
            int drop = Utils.randomWithRange(1, 4);
            if (drop == 1) {
                ItemStack BlazingShard = new ItemStack(ModItems.SynthesisMaterial, Utils.randomWithRange(1, 3));
                ItemStacks.createSynthesisItem(BlazingShard, Strings.SM_BlazingShard, "C");
                for (int i = 0; i < event.getFortuneLevel(); i++) {
                    fortune = Utils.randomWithRange(1, 15);
                    if (fortune < 5) event.getDrops().add(BlazingShard);
                }
                event.getDrops().add(BlazingShard);

            } else if (drop == 2) {
                ItemStack BlazingStone = new ItemStack(ModItems.SynthesisMaterial, Utils.randomWithRange(1, 3));
                ItemStacks.createSynthesisItem(BlazingStone, Strings.SM_BlazingStone, "B");
                for (int i = 0; i < event.getFortuneLevel(); i++) {
                    fortune = Utils.randomWithRange(1, 15);
                    if (fortune < 5) event.getDrops().add(BlazingStone);
                }
                event.getDrops().add(BlazingStone);

            } else if (drop == 3) {
                ItemStack BlazingGem = new ItemStack(ModItems.SynthesisMaterial, Utils.randomWithRange(1, 3));
                ItemStacks.createSynthesisItem(BlazingGem, Strings.SM_BlazingGem, "A");
                for (int i = 0; i < event.getFortuneLevel(); i++) {
                    fortune = Utils.randomWithRange(1, 15);
                    if (fortune < 5) event.getDrops().add(BlazingGem);
                }
                event.getDrops().add(BlazingGem);

            } else if (drop == 4) {
                ItemStack BlazingCrystal = new ItemStack(ModItems.SynthesisMaterial, Utils.randomWithRange(1, 3));
                ItemStacks.createSynthesisItem(BlazingCrystal, Strings.SM_BlazingCrystal, "S");
                for (int i = 0; i < event.getFortuneLevel(); i++) {
                    fortune = Utils.randomWithRange(1, 15);
                    if (fortune < 5) event.getDrops().add(BlazingCrystal);
                }
                event.getDrops().add(BlazingCrystal);
            }
        } else if (event.getState().getBlock() == ModBlocks.BrightOre) {
            int drop = Utils.randomWithRange(1, 4);
            if (drop == 1) {
                ItemStack BrightShard = new ItemStack(ModItems.SynthesisMaterial, Utils.randomWithRange(1, 3));
                ItemStacks.createSynthesisItem(BrightShard, Strings.SM_BrightShard, "C");
                for (int i = 0; i < event.getFortuneLevel(); i++) {
                    fortune = Utils.randomWithRange(1, 15);
                    if (fortune < 5) event.getDrops().add(BrightShard);
                }
                event.getDrops().add(BrightShard);
            } else if (drop == 2) {
                ItemStack BrightStone = new ItemStack(ModItems.SynthesisMaterial, Utils.randomWithRange(1, 3));
                ItemStacks.createSynthesisItem(BrightStone, Strings.SM_BrightStone, "B");
                for (int i = 0; i < event.getFortuneLevel(); i++) {
                    fortune = Utils.randomWithRange(1, 15);
                    if (fortune < 5) event.getDrops().add(BrightStone);
                }
                event.getDrops().add(BrightStone);
            } else if (drop == 3) {
                ItemStack BrightGem = new ItemStack(ModItems.SynthesisMaterial, Utils.randomWithRange(1, 3));
                ItemStacks.createSynthesisItem(BrightGem, Strings.SM_BrightGem, "A");
                for (int i = 0; i < event.getFortuneLevel(); i++) {
                    fortune = Utils.randomWithRange(1, 15);
                    if (fortune < 5) event.getDrops().add(BrightGem);
                }
                event.getDrops().add(BrightGem);
            } else if (drop == 4) {
                ItemStack BrightCrystal = new ItemStack(ModItems.SynthesisMaterial, Utils.randomWithRange(1, 3));
                ItemStacks.createSynthesisItem(BrightCrystal, Strings.SM_BrightCrystal, "S");
                for (int i = 0; i < event.getFortuneLevel(); i++) {
                    fortune = Utils.randomWithRange(1, 15);
                    if (fortune < 5) event.getDrops().add(BrightCrystal);
                }
                event.getDrops().add(BrightCrystal);
            }
        } else if (event.getState().getBlock() == ModBlocks.DarkOre) {
            int drop = Utils.randomWithRange(1, 4);
            if (drop == 1) {
                ItemStack DarkShard = new ItemStack(ModItems.SynthesisMaterial, Utils.randomWithRange(1, 3));
                ItemStacks.createSynthesisItem(DarkShard, Strings.SM_DarkShard, "C");
                for (int i = 0; i < event.getFortuneLevel(); i++) {
                    fortune = Utils.randomWithRange(1, 15);
                    if (fortune < 5) event.getDrops().add(DarkShard);
                }
                event.getDrops().add(DarkShard);
            } else if (drop == 2) {
                ItemStack DarkStone = new ItemStack(ModItems.SynthesisMaterial, Utils.randomWithRange(1, 3));
                ItemStacks.createSynthesisItem(DarkStone, Strings.SM_DarkStone, "B");
                for (int i = 0; i < event.getFortuneLevel(); i++) {
                    fortune = Utils.randomWithRange(1, 15);
                    if (fortune < 5) event.getDrops().add(DarkStone);
                }
                event.getDrops().add(DarkStone);
            } else if (drop == 3) {
                ItemStack DarkGem = new ItemStack(ModItems.SynthesisMaterial, Utils.randomWithRange(1, 3));
                ItemStacks.createSynthesisItem(DarkGem, Strings.SM_DarkGem, "A");
                for (int i = 0; i < event.getFortuneLevel(); i++) {
                    fortune = Utils.randomWithRange(1, 15);
                    if (fortune < 5) event.getDrops().add(DarkGem);
                }
                event.getDrops().add(DarkGem);
            } else if (drop == 4) {
                ItemStack DarkCrystal = new ItemStack(ModItems.SynthesisMaterial, Utils.randomWithRange(1, 3));
                ItemStacks.createSynthesisItem(DarkCrystal, Strings.SM_DarkCrystal, "S");
                for (int i = 0; i < event.getFortuneLevel(); i++) {
                    fortune = Utils.randomWithRange(1, 15);
                    if (fortune < 5) event.getDrops().add(DarkCrystal);
                }
                event.getDrops().add(DarkCrystal);
            }
        } else if (event.getState().getBlock() == ModBlocks.DarkOreE) {
            int drop = Utils.randomWithRange(1, 4);
            if (drop == 1) {
                ItemStack DarkShard = new ItemStack(ModItems.SynthesisMaterial, Utils.randomWithRange(1, 3));
                ItemStacks.createSynthesisItem(DarkShard, Strings.SM_DarkShard, "C");
                for (int i = 0; i < event.getFortuneLevel(); i++) {
                    fortune = Utils.randomWithRange(1, 15);
                    if (fortune < 5) event.getDrops().add(DarkShard);
                }
                event.getDrops().add(DarkShard);
            } else if (drop == 2) {
                ItemStack DarkStone = new ItemStack(ModItems.SynthesisMaterial, Utils.randomWithRange(1, 3));
                ItemStacks.createSynthesisItem(DarkStone, Strings.SM_DarkStone, "B");
                for (int i = 0; i < event.getFortuneLevel(); i++) {
                    fortune = Utils.randomWithRange(1, 15);
                    if (fortune < 5) event.getDrops().add(DarkStone);
                }
                event.getDrops().add(DarkStone);
            } else if (drop == 3) {
                ItemStack DarkGem = new ItemStack(ModItems.SynthesisMaterial, Utils.randomWithRange(1, 3));
                ItemStacks.createSynthesisItem(DarkGem, Strings.SM_DarkGem, "A");
                for (int i = 0; i < event.getFortuneLevel(); i++) {
                    fortune = Utils.randomWithRange(1, 15);
                    if (fortune < 5) event.getDrops().add(DarkGem);
                }
                event.getDrops().add(DarkGem);
            } else if (drop == 4) {
                ItemStack DarkCrystal = new ItemStack(ModItems.SynthesisMaterial, Utils.randomWithRange(1, 3));
                ItemStacks.createSynthesisItem(DarkCrystal, Strings.SM_DarkCrystal, "S");
                for (int i = 0; i < event.getFortuneLevel(); i++) {
                    fortune = Utils.randomWithRange(1, 15);
                    if (fortune < 5) event.getDrops().add(DarkCrystal);
                }
                event.getDrops().add(DarkCrystal);
            }
        } else if (event.getState().getBlock() == ModBlocks.DenseOre) {
            int drop = Utils.randomWithRange(1, 4);
            if (drop == 1) {
                ItemStack DenseShard = new ItemStack(ModItems.SynthesisMaterial, Utils.randomWithRange(1, 3));
                ItemStacks.createSynthesisItem(DenseShard, Strings.SM_DenseShard, "C");
                for (int i = 0; i < event.getFortuneLevel(); i++) {
                    fortune = Utils.randomWithRange(1, 15);
                    if (fortune < 5) event.getDrops().add(DenseShard);
                }
                event.getDrops().add(DenseShard);
            } else if (drop == 2) {
                ItemStack DenseStone = new ItemStack(ModItems.SynthesisMaterial, Utils.randomWithRange(1, 3));
                ItemStacks.createSynthesisItem(DenseStone, Strings.SM_DenseStone, "B");
                for (int i = 0; i < event.getFortuneLevel(); i++) {
                    fortune = Utils.randomWithRange(1, 15);
                    if (fortune < 5) event.getDrops().add(DenseStone);
                }
                event.getDrops().add(DenseStone);
            } else if (drop == 3) {
                ItemStack DenseGem = new ItemStack(ModItems.SynthesisMaterial, Utils.randomWithRange(1, 3));
                ItemStacks.createSynthesisItem(DenseGem, Strings.SM_DenseGem, "A");
                for (int i = 0; i < event.getFortuneLevel(); i++) {
                    fortune = Utils.randomWithRange(1, 15);
                    if (fortune < 5) event.getDrops().add(DenseGem);
                }
                event.getDrops().add(DenseGem);
            } else if (drop == 4) {
                ItemStack DenseCrystal = new ItemStack(ModItems.SynthesisMaterial, Utils.randomWithRange(1, 3));
                ItemStacks.createSynthesisItem(DenseCrystal, Strings.SM_DenseCrystal, "S");
                for (int i = 0; i < event.getFortuneLevel(); i++) {
                    fortune = Utils.randomWithRange(1, 15);
                    if (fortune < 5) event.getDrops().add(DenseCrystal);
                }
                event.getDrops().add(DenseCrystal);
            }
        } else if (event.getState().getBlock() == ModBlocks.EnergyOre) {
            int drop = Utils.randomWithRange(1, 4);
            if (drop == 1) {
                ItemStack EnergyShard = new ItemStack(ModItems.SynthesisMaterial, Utils.randomWithRange(1, 3));
                ItemStacks.createSynthesisItem(EnergyShard, Strings.SM_EnergyShard, "C");
                for (int i = 0; i < event.getFortuneLevel(); i++) {
                    fortune = Utils.randomWithRange(1, 15);
                    if (fortune < 5) event.getDrops().add(EnergyShard);
                }
                event.getDrops().add(EnergyShard);
            } else if (drop == 2) {
                ItemStack EnergyStone = new ItemStack(ModItems.SynthesisMaterial, Utils.randomWithRange(1, 3));
                ItemStacks.createSynthesisItem(EnergyStone, Strings.SM_EnergyStone, "B");
                for (int i = 0; i < event.getFortuneLevel(); i++) {
                    fortune = Utils.randomWithRange(1, 15);
                    if (fortune < 5) event.getDrops().add(EnergyStone);
                }
                event.getDrops().add(EnergyStone);
            } else if (drop == 3) {
                ItemStack EnergyGem = new ItemStack(ModItems.SynthesisMaterial, Utils.randomWithRange(1, 3));
                ItemStacks.createSynthesisItem(EnergyGem, Strings.SM_EnergyGem, "A");
                for (int i = 0; i < event.getFortuneLevel(); i++) {
                    fortune = Utils.randomWithRange(1, 15);
                    if (fortune < 5) event.getDrops().add(EnergyGem);
                }
                event.getDrops().add(EnergyGem);
            } else if (drop == 4) {
                ItemStack EnergyCrystal = new ItemStack(ModItems.SynthesisMaterial, Utils.randomWithRange(1, 3));
                ItemStacks.createSynthesisItem(EnergyCrystal, Strings.SM_EnergyCrystal, "S");
                for (int i = 0; i < event.getFortuneLevel(); i++) {
                    fortune = Utils.randomWithRange(1, 15);
                    if (fortune < 5) event.getDrops().add(EnergyCrystal);
                }
                event.getDrops().add(EnergyCrystal);
            }
        } else if (event.getState().getBlock() == ModBlocks.FrostOre) {
            int drop = Utils.randomWithRange(1, 4);
            if (drop == 1) {
                ItemStack FrostShard = new ItemStack(ModItems.SynthesisMaterial, Utils.randomWithRange(1, 3));
                ItemStacks.createSynthesisItem(FrostShard, Strings.SM_FrostShard, "C");
                for (int i = 0; i < event.getFortuneLevel(); i++) {
                    fortune = Utils.randomWithRange(1, 15);
                    if (fortune < 5) event.getDrops().add(FrostShard);
                }
                event.getDrops().add(FrostShard);
            } else if (drop == 2) {
                ItemStack FrostStone = new ItemStack(ModItems.SynthesisMaterial, Utils.randomWithRange(1, 3));
                ItemStacks.createSynthesisItem(FrostStone, Strings.SM_FrostStone, "B");
                for (int i = 0; i < event.getFortuneLevel(); i++) {
                    fortune = Utils.randomWithRange(1, 15);
                    if (fortune < 5) event.getDrops().add(FrostStone);
                }
                event.getDrops().add(FrostStone);
            } else if (drop == 3) {
                ItemStack FrostGem = new ItemStack(ModItems.SynthesisMaterial, Utils.randomWithRange(1, 3));
                ItemStacks.createSynthesisItem(FrostGem, Strings.SM_FrostGem, "A");
                for (int i = 0; i < event.getFortuneLevel(); i++) {
                    fortune = Utils.randomWithRange(1, 15);
                    if (fortune < 5) event.getDrops().add(FrostGem);
                }
                event.getDrops().add(FrostGem);
            } else if (drop == 4) {
                ItemStack FrostCrystal = new ItemStack(ModItems.SynthesisMaterial, Utils.randomWithRange(1, 3));
                ItemStacks.createSynthesisItem(FrostCrystal, Strings.SM_FrostCrystal, "S");
                for (int i = 0; i < event.getFortuneLevel(); i++) {
                    fortune = Utils.randomWithRange(1, 15);
                    if (fortune < 5) event.getDrops().add(FrostCrystal);
                }
                event.getDrops().add(FrostCrystal);
            }
        } else if (event.getState().getBlock() == ModBlocks.LightningOre) {
            int drop = Utils.randomWithRange(1, 4);
            if (drop == 1) {
                ItemStack LightningShard = new ItemStack(ModItems.SynthesisMaterial, Utils.randomWithRange(1, 3));
                ItemStacks.createSynthesisItem(LightningShard, Strings.SM_LightningShard, "C");
                for (int i = 0; i < event.getFortuneLevel(); i++) {
                    fortune = Utils.randomWithRange(1, 15);
                    if (fortune < 5) event.getDrops().add(LightningShard);
                }
                event.getDrops().add(LightningShard);
            } else if (drop == 2) {
                ItemStack LightningStone = new ItemStack(ModItems.SynthesisMaterial, Utils.randomWithRange(1, 3));
                ItemStacks.createSynthesisItem(LightningStone, Strings.SM_LightningStone, "B");
                for (int i = 0; i < event.getFortuneLevel(); i++) {
                    fortune = Utils.randomWithRange(1, 15);
                    if (fortune < 5) event.getDrops().add(LightningStone);
                }
                event.getDrops().add(LightningStone);
            } else if (drop == 3) {
                ItemStack LightningGem = new ItemStack(ModItems.SynthesisMaterial, Utils.randomWithRange(1, 3));
                ItemStacks.createSynthesisItem(LightningGem, Strings.SM_LightningGem, "A");
                for (int i = 0; i < event.getFortuneLevel(); i++) {
                    fortune = Utils.randomWithRange(1, 15);
                    if (fortune < 5) event.getDrops().add(LightningGem);
                }
                event.getDrops().add(LightningGem);
            } else if (drop == 4) {
                ItemStack LightningCrystal = new ItemStack(ModItems.SynthesisMaterial, Utils.randomWithRange(1, 3));
                ItemStacks.createSynthesisItem(LightningCrystal, Strings.SM_LightningCrystal, "S");
                for (int i = 0; i < event.getFortuneLevel(); i++) {
                    fortune = Utils.randomWithRange(1, 15);
                    if (fortune < 5) event.getDrops().add(LightningCrystal);
                }
                event.getDrops().add(LightningCrystal);
            }
        } else if (event.getState().getBlock() == ModBlocks.LucidOre) {
            int drop = Utils.randomWithRange(1, 4);
            if (drop == 1) {
                ItemStack LucidShard = new ItemStack(ModItems.SynthesisMaterial, Utils.randomWithRange(1, 3));
                ItemStacks.createSynthesisItem(LucidShard, Strings.SM_LucidShard, "C");
                for (int i = 0; i < event.getFortuneLevel(); i++) {
                    fortune = Utils.randomWithRange(1, 15);
                    if (fortune < 5) event.getDrops().add(LucidShard);
                }
                event.getDrops().add(LucidShard);
            } else if (drop == 2) {
                ItemStack LucidStone = new ItemStack(ModItems.SynthesisMaterial, Utils.randomWithRange(1, 3));
                ItemStacks.createSynthesisItem(LucidStone, Strings.SM_LucidStone, "B");
                for (int i = 0; i < event.getFortuneLevel(); i++) {
                    fortune = Utils.randomWithRange(1, 15);
                    if (fortune < 5) event.getDrops().add(LucidStone);
                }
                event.getDrops().add(LucidStone);
            } else if (drop == 3) {
                ItemStack LucidGem = new ItemStack(ModItems.SynthesisMaterial, Utils.randomWithRange(1, 3));
                ItemStacks.createSynthesisItem(LucidGem, Strings.SM_LucidGem, "A");
                for (int i = 0; i < event.getFortuneLevel(); i++) {
                    fortune = Utils.randomWithRange(1, 15);
                    if (fortune < 5) event.getDrops().add(LucidGem);
                }
                event.getDrops().add(LucidGem);
            } else if (drop == 4) {
                ItemStack LucidCrystal = new ItemStack(ModItems.SynthesisMaterial, Utils.randomWithRange(1, 3));
                ItemStacks.createSynthesisItem(LucidCrystal, Strings.SM_LucidCrystal, "S");
                for (int i = 0; i < event.getFortuneLevel(); i++) {
                    fortune = Utils.randomWithRange(1, 15);
                    if (fortune < 5) event.getDrops().add(LucidCrystal);
                }
                event.getDrops().add(LucidCrystal);
            }
        } else if (event.getState().getBlock() == ModBlocks.PowerOre) {
            int drop = Utils.randomWithRange(1, 4);
            if (drop == 1) {
                ItemStack PowerShard = new ItemStack(ModItems.SynthesisMaterial, Utils.randomWithRange(1, 3));
                ItemStacks.createSynthesisItem(PowerShard, Strings.SM_PowerShard, "C");
                for (int i = 0; i < event.getFortuneLevel(); i++) {
                    fortune = Utils.randomWithRange(1, 15);
                    if (fortune < 5) event.getDrops().add(PowerShard);
                }
                event.getDrops().add(PowerShard);
            } else if (drop == 2) {
                ItemStack PowerStone = new ItemStack(ModItems.SynthesisMaterial, Utils.randomWithRange(1, 3));
                ItemStacks.createSynthesisItem(PowerStone, Strings.SM_PowerStone, "B");
                for (int i = 0; i < event.getFortuneLevel(); i++) {
                    fortune = Utils.randomWithRange(1, 15);
                    if (fortune < 5) event.getDrops().add(PowerStone);
                }
                event.getDrops().add(PowerStone);
            } else if (drop == 3) {
                ItemStack PowerGem = new ItemStack(ModItems.SynthesisMaterial, Utils.randomWithRange(1, 3));
                ItemStacks.createSynthesisItem(PowerGem, Strings.SM_PowerGem, "A");
                for (int i = 0; i < event.getFortuneLevel(); i++) {
                    fortune = Utils.randomWithRange(1, 15);
                    if (fortune < 5) event.getDrops().add(PowerGem);
                }
                event.getDrops().add(PowerGem);
            } else if (drop == 4) {
                ItemStack PowerCrystal = new ItemStack(ModItems.SynthesisMaterial, Utils.randomWithRange(1, 3));
                ItemStacks.createSynthesisItem(PowerCrystal, Strings.SM_PowerCrystal, "S");
                for (int i = 0; i < event.getFortuneLevel(); i++) {
                    fortune = Utils.randomWithRange(1, 15);
                    if (fortune < 5) event.getDrops().add(PowerCrystal);
                }
                event.getDrops().add(PowerCrystal);
            }
        } else if (event.getState().getBlock() == ModBlocks.PowerOreE) {
            int drop = Utils.randomWithRange(1, 4);
            if (drop == 1) {
                ItemStack PowerShard = new ItemStack(ModItems.SynthesisMaterial, Utils.randomWithRange(1, 3));
                ItemStacks.createSynthesisItem(PowerShard, Strings.SM_PowerShard, "C");
                for (int i = 0; i < event.getFortuneLevel(); i++) {
                    fortune = Utils.randomWithRange(1, 15);
                    if (fortune < 5) event.getDrops().add(PowerShard);
                }
                event.getDrops().add(PowerShard);
            } else if (drop == 2) {
                ItemStack PowerStone = new ItemStack(ModItems.SynthesisMaterial, Utils.randomWithRange(1, 3));
                ItemStacks.createSynthesisItem(PowerStone, Strings.SM_PowerStone, "B");
                for (int i = 0; i < event.getFortuneLevel(); i++) {
                    fortune = Utils.randomWithRange(1, 15);
                    if (fortune < 5) event.getDrops().add(PowerStone);
                }
                event.getDrops().add(PowerStone);
            } else if (drop == 3) {
                ItemStack PowerGem = new ItemStack(ModItems.SynthesisMaterial, Utils.randomWithRange(1, 3));
                ItemStacks.createSynthesisItem(PowerGem, Strings.SM_PowerGem, "A");
                for (int i = 0; i < event.getFortuneLevel(); i++) {
                    fortune = Utils.randomWithRange(1, 15);
                    if (fortune < 5) event.getDrops().add(PowerGem);
                }
                event.getDrops().add(PowerGem);
            } else if (drop == 4) {
                ItemStack PowerCrystal = new ItemStack(ModItems.SynthesisMaterial, Utils.randomWithRange(1, 3));
                ItemStacks.createSynthesisItem(PowerCrystal, Strings.SM_PowerCrystal, "S");
                for (int i = 0; i < event.getFortuneLevel(); i++) {
                    fortune = Utils.randomWithRange(1, 15);
                    if (fortune < 5) event.getDrops().add(PowerCrystal);
                }
                event.getDrops().add(PowerCrystal);
            }
        } else if (event.getState().getBlock() == ModBlocks.RemembranceOre) {
            int drop = Utils.randomWithRange(1, 4);
            if (drop == 1) {
                ItemStack RemembranceShard = new ItemStack(ModItems.SynthesisMaterial, Utils.randomWithRange(1, 3));
                ItemStacks.createSynthesisItem(RemembranceShard, Strings.SM_RemembranceShard, "C");
                for (int i = 0; i < event.getFortuneLevel(); i++) {
                    fortune = Utils.randomWithRange(1, 15);
                    if (fortune < 5) event.getDrops().add(RemembranceShard);
                }
                event.getDrops().add(RemembranceShard);
            } else if (drop == 2) {
                ItemStack RemembranceStone = new ItemStack(ModItems.SynthesisMaterial, Utils.randomWithRange(1, 3));
                ItemStacks.createSynthesisItem(RemembranceStone, Strings.SM_RemembranceStone, "B");
                for (int i = 0; i < event.getFortuneLevel(); i++) {
                    fortune = Utils.randomWithRange(1, 15);
                    if (fortune < 5) event.getDrops().add(RemembranceStone);
                }
                event.getDrops().add(RemembranceStone);
            } else if (drop == 3) {
                ItemStack RemembranceGem = new ItemStack(ModItems.SynthesisMaterial, Utils.randomWithRange(1, 3));
                ItemStacks.createSynthesisItem(RemembranceGem, Strings.SM_RemembranceGem, "A");
                for (int i = 0; i < event.getFortuneLevel(); i++) {
                    fortune = Utils.randomWithRange(1, 15);
                    if (fortune < 5) event.getDrops().add(RemembranceGem);
                }
                event.getDrops().add(RemembranceGem);
            } else if (drop == 4) {
                ItemStack RemembranceCrystal = new ItemStack(ModItems.SynthesisMaterial, Utils.randomWithRange(1, 3));
                ItemStacks.createSynthesisItem(RemembranceCrystal, Strings.SM_RemembranceCrystal, "S");
                for (int i = 0; i < event.getFortuneLevel(); i++) {
                    fortune = Utils.randomWithRange(1, 15);
                    if (fortune < 5) event.getDrops().add(RemembranceCrystal);
                }
                event.getDrops().add(RemembranceCrystal);
            }
        } else if (event.getState().getBlock() == ModBlocks.SerenityOre) {
            int drop = Utils.randomWithRange(1, 4);
            if (drop == 1) {
                ItemStack SerenityShard = new ItemStack(ModItems.SynthesisMaterial, Utils.randomWithRange(1, 3));
                ItemStacks.createSynthesisItem(SerenityShard, Strings.SM_SerenityShard, "C");
                for (int i = 0; i < event.getFortuneLevel(); i++) {
                    fortune = Utils.randomWithRange(1, 15);
                    if (fortune < 5) event.getDrops().add(SerenityShard);
                }
                event.getDrops().add(SerenityShard);
            } else if (drop == 2) {
                ItemStack SerenityStone = new ItemStack(ModItems.SynthesisMaterial, Utils.randomWithRange(1, 3));
                ItemStacks.createSynthesisItem(SerenityStone, Strings.SM_SerenityStone, "B");
                for (int i = 0; i < event.getFortuneLevel(); i++) {
                    fortune = Utils.randomWithRange(1, 15);
                    if (fortune < 5) event.getDrops().add(SerenityStone);
                }
                event.getDrops().add(SerenityStone);
            } else if (drop == 3) {
                ItemStack SerenityGem = new ItemStack(ModItems.SynthesisMaterial, Utils.randomWithRange(1, 3));
                ItemStacks.createSynthesisItem(SerenityGem, Strings.SM_SerenityGem, "A");
                for (int i = 0; i < event.getFortuneLevel(); i++) {
                    fortune = Utils.randomWithRange(1, 15);
                    if (fortune < 5) event.getDrops().add(SerenityGem);
                }
                event.getDrops().add(SerenityGem);
            } else if (drop == 4) {
                ItemStack SerenityCrystal = new ItemStack(ModItems.SynthesisMaterial, Utils.randomWithRange(1, 3));
                ItemStacks.createSynthesisItem(SerenityCrystal, Strings.SM_SerenityCrystal, "S");
                for (int i = 0; i < event.getFortuneLevel(); i++) {
                    fortune = Utils.randomWithRange(1, 15);
                    if (fortune < 5) event.getDrops().add(SerenityCrystal);
                }
                event.getDrops().add(SerenityCrystal);
            }
        } else if (event.getState().getBlock() == ModBlocks.TranquilOre) {
            int drop = Utils.randomWithRange(1, 4);
            if (drop == 1) {
                ItemStack TranquilShard = new ItemStack(ModItems.SynthesisMaterial, Utils.randomWithRange(1, 3));
                ItemStacks.createSynthesisItem(TranquilShard, Strings.SM_TranquilShard, "C");
                for (int i = 0; i < event.getFortuneLevel(); i++) {
                    fortune = Utils.randomWithRange(1, 15);
                    if (fortune < 5) event.getDrops().add(TranquilShard);
                }
                event.getDrops().add(TranquilShard);
            } else if (drop == 2) {
                ItemStack TranquilStone = new ItemStack(ModItems.SynthesisMaterial, Utils.randomWithRange(1, 3));
                ItemStacks.createSynthesisItem(TranquilStone, Strings.SM_TranquilStone, "B");
                for (int i = 0; i < event.getFortuneLevel(); i++) {
                    fortune = Utils.randomWithRange(1, 15);
                    if (fortune < 5) event.getDrops().add(TranquilStone);
                }
                event.getDrops().add(TranquilStone);
            } else if (drop == 3) {
                ItemStack TranquilGem = new ItemStack(ModItems.SynthesisMaterial, Utils.randomWithRange(1, 3));
                ItemStacks.createSynthesisItem(TranquilGem, Strings.SM_TranquilGem, "A");
                for (int i = 0; i < event.getFortuneLevel(); i++) {
                    fortune = Utils.randomWithRange(1, 15);
                    if (fortune < 5) event.getDrops().add(TranquilGem);
                }
                event.getDrops().add(TranquilGem);
            } else if (drop == 4) {
                ItemStack TranquilCrystal = new ItemStack(ModItems.SynthesisMaterial, Utils.randomWithRange(1, 3));
                ItemStacks.createSynthesisItem(TranquilCrystal, Strings.SM_TranquilCrystal, "S");
                for (int i = 0; i < event.getFortuneLevel(); i++) {
                    fortune = Utils.randomWithRange(1, 15);
                    if (fortune < 5) event.getDrops().add(TranquilCrystal);
                }
                event.getDrops().add(TranquilCrystal);
            }
        } else if (event.getState().getBlock() == ModBlocks.TwilightOre) {
            int drop = Utils.randomWithRange(1, 4);
            if (drop == 1) {
                ItemStack TwilightShard = new ItemStack(ModItems.SynthesisMaterial, Utils.randomWithRange(1, 3));
                ItemStacks.createSynthesisItem(TwilightShard, Strings.SM_TwilightShard, "C");
                for (int i = 0; i < event.getFortuneLevel(); i++) {
                    fortune = Utils.randomWithRange(1, 15);
                    if (fortune < 5) event.getDrops().add(TwilightShard);
                }
                event.getDrops().add(TwilightShard);
            } else if (drop == 2) {
                ItemStack TwilightStone = new ItemStack(ModItems.SynthesisMaterial, Utils.randomWithRange(1, 3));
                ItemStacks.createSynthesisItem(TwilightStone, Strings.SM_TwilightStone, "B");
                for (int i = 0; i < event.getFortuneLevel(); i++) {
                    fortune = Utils.randomWithRange(1, 15);
                    if (fortune < 5) event.getDrops().add(TwilightStone);
                }
                event.getDrops().add(TwilightStone);
            } else if (drop == 3) {
                ItemStack TwilightGem = new ItemStack(ModItems.SynthesisMaterial, Utils.randomWithRange(1, 3));
                ItemStacks.createSynthesisItem(TwilightGem, Strings.SM_TwilightGem, "A");
                for (int i = 0; i < event.getFortuneLevel(); i++) {
                    fortune = Utils.randomWithRange(1, 15);
                    if (fortune < 5) event.getDrops().add(TwilightGem);
                }
                event.getDrops().add(TwilightGem);
            } else if (drop == 4) {
                ItemStack TwilightCrystal = new ItemStack(ModItems.SynthesisMaterial, Utils.randomWithRange(1, 3));
                ItemStacks.createSynthesisItem(TwilightCrystal, Strings.SM_TwilightCrystal, "S");
                for (int i = 0; i < event.getFortuneLevel(); i++) {
                    fortune = Utils.randomWithRange(1, 15);
                    if (fortune < 5) event.getDrops().add(TwilightCrystal);
                }
                event.getDrops().add(TwilightCrystal);
            }
        } else if (event.getState().getBlock() == ModBlocks.StormyOre) {
            int drop = Utils.randomWithRange(1, 4);
            if (drop == 1) {
                ItemStack StormyShard = new ItemStack(ModItems.SynthesisMaterial, Utils.randomWithRange(1, 3));
                ItemStacks.createSynthesisItem(StormyShard, Strings.SM_StormyShard, "C");
                for (int i = 0; i < event.getFortuneLevel(); i++) {
                    fortune = Utils.randomWithRange(1, 15);
                    if (fortune < 5) event.getDrops().add(StormyShard);
                }
                event.getDrops().add(StormyShard);
            } else if (drop == 2) {
                ItemStack StormyStone = new ItemStack(ModItems.SynthesisMaterial, Utils.randomWithRange(1, 3));
                ItemStacks.createSynthesisItem(StormyStone, Strings.SM_StormyStone, "B");
                for (int i = 0; i < event.getFortuneLevel(); i++) {
                    fortune = Utils.randomWithRange(1, 15);
                    if (fortune < 5) event.getDrops().add(StormyStone);
                }
                event.getDrops().add(StormyStone);
            } else if (drop == 3) {
                ItemStack StormyGem = new ItemStack(ModItems.SynthesisMaterial, Utils.randomWithRange(1, 3));
                ItemStacks.createSynthesisItem(StormyGem, Strings.SM_StormyGem, "A");
                for (int i = 0; i < event.getFortuneLevel(); i++) {
                    fortune = Utils.randomWithRange(1, 15);
                    if (fortune < 5) event.getDrops().add(StormyGem);
                }
                event.getDrops().add(StormyGem);
            } else if (drop == 4) {
                ItemStack StormyCrystal = new ItemStack(ModItems.SynthesisMaterial, Utils.randomWithRange(1, 3));
                ItemStacks.createSynthesisItem(StormyCrystal, Strings.SM_StormyCrystal, "S");
                for (int i = 0; i < event.getFortuneLevel(); i++) {
                    fortune = Utils.randomWithRange(1, 15);
                    if (fortune < 5) event.getDrops().add(StormyCrystal);
                }
                event.getDrops().add(StormyCrystal);
            }
        } else if (event.getState().getBlock() == ModBlocks.PrizeBlox) {
            int drop = Utils.randomWithRange(1, 29);
            ItemStack munny = new ItemStack(ModItems.Munny, 1);

            switch (drop) {
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
                    ItemStack BlazingGem = new ItemStack(ModItems.SynthesisMaterial, Utils.randomWithRange(1, 3));
                    ItemStacks.createSynthesisItem(BlazingGem, Strings.SM_BlazingShard, "C");
                    event.getDrops().add(BlazingGem);
                    break;
                case 6:
                    ItemStack BrightGem = new ItemStack(ModItems.SynthesisMaterial, Utils.randomWithRange(1, 3));
                    ItemStacks.createSynthesisItem(BrightGem, Strings.SM_BrightShard, "C");
                    event.getDrops().add(BrightGem);
                    break;
                case 7:
                    ItemStack DarkGem = new ItemStack(ModItems.SynthesisMaterial, Utils.randomWithRange(1, 3));
                    ItemStacks.createSynthesisItem(DarkGem, Strings.SM_DarkShard, "C");
                    event.getDrops().add(DarkGem);
                    break;
                case 8:
                    ItemStack DenseGem = new ItemStack(ModItems.SynthesisMaterial, Utils.randomWithRange(1, 3));
                    ItemStacks.createSynthesisItem(DenseGem, Strings.SM_DenseShard, "C");
                    event.getDrops().add(DenseGem);
                    break;
                case 9:
                    ItemStack EnergyGem = new ItemStack(ModItems.SynthesisMaterial, Utils.randomWithRange(1, 3));
                    ItemStacks.createSynthesisItem(EnergyGem, Strings.SM_EnergyShard, "C");
                    event.getDrops().add(EnergyGem);
                    break;
                case 10:
                    ItemStack FrostGem = new ItemStack(ModItems.SynthesisMaterial, Utils.randomWithRange(1, 3));
                    ItemStacks.createSynthesisItem(FrostGem, Strings.SM_FrostShard, "C");
                    event.getDrops().add(FrostGem);
                    break;
                case 11:
                    ItemStack LucidGem = new ItemStack(ModItems.SynthesisMaterial, Utils.randomWithRange(1, 3));
                    ItemStacks.createSynthesisItem(LucidGem, Strings.SM_LucidShard, "C");
                    event.getDrops().add(LucidGem);
                    break;
                case 12:
                    ItemStack PowerGem = new ItemStack(ModItems.SynthesisMaterial, Utils.randomWithRange(1, 3));
                    ItemStacks.createSynthesisItem(PowerGem, Strings.SM_PowerShard, "C");
                    event.getDrops().add(PowerGem);
                    break;
                case 13:
                    ItemStack RemembranceGem = new ItemStack(ModItems.SynthesisMaterial, Utils.randomWithRange(1, 3));
                    ItemStacks.createSynthesisItem(RemembranceGem, Strings.SM_RemembranceShard, "C");
                    event.getDrops().add(RemembranceGem);
                    break;
                case 14:
                    ItemStack SerenityGem = new ItemStack(ModItems.SynthesisMaterial, Utils.randomWithRange(1, 3));
                    ItemStacks.createSynthesisItem(SerenityGem, Strings.SM_SerenityShard, "C");
                    event.getDrops().add(SerenityGem);
                    break;
                case 15:
                    ItemStack TranquilGem = new ItemStack(ModItems.SynthesisMaterial, Utils.randomWithRange(1, 3));
                    ItemStacks.createSynthesisItem(TranquilGem, Strings.SM_TranquilShard, "C");
                    event.getDrops().add(TranquilGem);
                    break;
                case 16:
                    ItemStack TwilightGem = new ItemStack(ModItems.SynthesisMaterial, Utils.randomWithRange(1, 3));
                    ItemStacks.createSynthesisItem(TwilightGem, Strings.SM_TwilightShard, "C");
                    event.getDrops().add(TwilightGem);
                    break;
                case 17:
                    ItemStack BlazingStone = new ItemStack(ModItems.SynthesisMaterial, Utils.randomWithRange(1, 3));
                    ItemStacks.createSynthesisItem(BlazingStone, Strings.SM_BlazingStone, "B");
                    event.getDrops().add(BlazingStone);
                    break;
                case 18:
                    ItemStack BrightStone = new ItemStack(ModItems.SynthesisMaterial, Utils.randomWithRange(1, 3));
                    ItemStacks.createSynthesisItem(BrightStone, Strings.SM_BrightStone, "B");
                    event.getDrops().add(BrightStone);
                    break;
                case 19:
                    ItemStack DarkStone = new ItemStack(ModItems.SynthesisMaterial, Utils.randomWithRange(1, 3));
                    ItemStacks.createSynthesisItem(DarkStone, Strings.SM_DarkStone, "B");
                    event.getDrops().add(DarkStone);
                    break;
                case 20:
                    ItemStack DenseStone = new ItemStack(ModItems.SynthesisMaterial, Utils.randomWithRange(1, 3));
                    ItemStacks.createSynthesisItem(DenseStone, Strings.SM_DenseStone, "B");
                    event.getDrops().add(DenseStone);
                    break;
                case 21:
                    ItemStack EnergyStone = new ItemStack(ModItems.SynthesisMaterial, Utils.randomWithRange(1, 3));
                    ItemStacks.createSynthesisItem(EnergyStone, Strings.SM_EnergyStone, "B");
                    event.getDrops().add(EnergyStone);
                    break;
                case 22:
                    ItemStack FrostStone = new ItemStack(ModItems.SynthesisMaterial, Utils.randomWithRange(1, 3));
                    ItemStacks.createSynthesisItem(FrostStone, Strings.SM_FrostStone, "B");
                    event.getDrops().add(FrostStone);
                    break;
                case 23:
                    ItemStack LucidStone = new ItemStack(ModItems.SynthesisMaterial, Utils.randomWithRange(1, 3));
                    ItemStacks.createSynthesisItem(LucidStone, Strings.SM_LucidStone, "B");
                    event.getDrops().add(LucidStone);
                    break;
                case 24:
                    ItemStack PowerStone = new ItemStack(ModItems.SynthesisMaterial, Utils.randomWithRange(1, 3));
                    ItemStacks.createSynthesisItem(PowerStone, Strings.SM_PowerStone, "B");
                    event.getDrops().add(PowerStone);
                    break;
                case 25:
                    ItemStack RemembranceStone = new ItemStack(ModItems.SynthesisMaterial, Utils.randomWithRange(1, 3));
                    ItemStacks.createSynthesisItem(RemembranceStone, Strings.SM_RemembranceStone, "B");
                    event.getDrops().add(RemembranceStone);
                    break;
                case 26:
                    ItemStack SerenityStone = new ItemStack(ModItems.SynthesisMaterial, Utils.randomWithRange(1, 3));
                    ItemStacks.createSynthesisItem(SerenityStone, Strings.SM_SerenityStone, "B");
                    event.getDrops().add(SerenityStone);
                    break;
                case 27:
                    ItemStack TranquilStone = new ItemStack(ModItems.SynthesisMaterial, Utils.randomWithRange(1, 3));
                    ItemStacks.createSynthesisItem(TranquilStone, Strings.SM_TranquilStone, "B");
                    event.getDrops().add(TranquilStone);
                    break;
                case 28:
                    ItemStack TwilightStone = new ItemStack(ModItems.SynthesisMaterial, Utils.randomWithRange(1, 3));
                    ItemStacks.createSynthesisItem(TwilightStone, Strings.SM_TwilightStone, "B");
                    event.getDrops().add(TwilightStone);
                    break;
                case 29:
                    ItemStack Orichalcum = new ItemStack(ModItems.SynthesisMaterial, Utils.randomWithRange(1, 3));
                    ItemStacks.createSynthesisItem(Orichalcum, Strings.SM_Orichalcum, "A");
                    event.getDrops().add(Orichalcum);
                    break;
            }
        } else if (event.getState().getBlock() == ModBlocks.RarePrizeBlox) {
            int drop = Utils.randomWithRange(1, 38);
            ItemStack munny = new ItemStack(ModItems.Munny, 1);
            switch (drop) {
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
                    ItemStack BlazingGem = new ItemStack(ModItems.SynthesisMaterial, Utils.randomWithRange(1, 3));
                    ItemStacks.createSynthesisItem(BlazingGem, Strings.SM_BlazingGem, "A");
                    event.getDrops().add(BlazingGem);
                    break;
                case 6:
                    ItemStack BrightGem = new ItemStack(ModItems.SynthesisMaterial, Utils.randomWithRange(1, 3));
                    ItemStacks.createSynthesisItem(BrightGem, Strings.SM_BrightGem, "A");
                    event.getDrops().add(BrightGem);
                    break;
                case 7:
                    ItemStack DarkGem = new ItemStack(ModItems.SynthesisMaterial, Utils.randomWithRange(1, 3));
                    ItemStacks.createSynthesisItem(DarkGem, Strings.SM_DarkGem, "A");
                    event.getDrops().add(DarkGem);
                    break;
                case 8:
                    ItemStack DenseGem = new ItemStack(ModItems.SynthesisMaterial, Utils.randomWithRange(1, 3));
                    ItemStacks.createSynthesisItem(DenseGem, Strings.SM_DenseGem, "A");
                    event.getDrops().add(DenseGem);
                    break;
                case 9:
                    ItemStack EnergyGem = new ItemStack(ModItems.SynthesisMaterial, Utils.randomWithRange(1, 3));
                    ItemStacks.createSynthesisItem(EnergyGem, Strings.SM_EnergyGem, "A");
                    event.getDrops().add(EnergyGem);
                    break;
                case 10:
                    ItemStack FrostGem = new ItemStack(ModItems.SynthesisMaterial, Utils.randomWithRange(1, 3));
                    ItemStacks.createSynthesisItem(FrostGem, Strings.SM_FrostGem, "A");
                    event.getDrops().add(FrostGem);
                    break;
                case 11:
                    ItemStack LucidGem = new ItemStack(ModItems.SynthesisMaterial, Utils.randomWithRange(1, 3));
                    ItemStacks.createSynthesisItem(LucidGem, Strings.SM_LucidGem, "A");
                    event.getDrops().add(LucidGem);
                    break;
                case 12:
                    ItemStack PowerGem = new ItemStack(ModItems.SynthesisMaterial, Utils.randomWithRange(1, 3));
                    ItemStacks.createSynthesisItem(PowerGem, Strings.SM_PowerGem, "A");
                    event.getDrops().add(PowerGem);
                    break;
                case 13:
                    ItemStack RemembranceGem = new ItemStack(ModItems.SynthesisMaterial, Utils.randomWithRange(1, 3));
                    ItemStacks.createSynthesisItem(RemembranceGem, Strings.SM_RemembranceGem, "A");
                    event.getDrops().add(RemembranceGem);
                    break;
                case 14:
                    ItemStack SerenityGem = new ItemStack(ModItems.SynthesisMaterial, Utils.randomWithRange(1, 3));
                    ItemStacks.createSynthesisItem(SerenityGem, Strings.SM_SerenityGem, "A");
                    event.getDrops().add(SerenityGem);
                    break;
                case 15:
                    ItemStack TranquilGem = new ItemStack(ModItems.SynthesisMaterial, Utils.randomWithRange(1, 3));
                    ItemStacks.createSynthesisItem(TranquilGem, Strings.SM_TranquilGem, "A");
                    event.getDrops().add(TranquilGem);
                    break;
                case 16:
                    ItemStack TwilightGem = new ItemStack(ModItems.SynthesisMaterial, Utils.randomWithRange(1, 3));
                    ItemStacks.createSynthesisItem(TwilightGem, Strings.SM_TwilightGem, "A");
                    event.getDrops().add(TwilightGem);
                    break;
                case 17:
                    ItemStack BlazingCrystal = new ItemStack(ModItems.SynthesisMaterial, Utils.randomWithRange(1, 3));
                    ItemStacks.createSynthesisItem(BlazingCrystal, Strings.SM_BlazingCrystal, "S");
                    event.getDrops().add(BlazingCrystal);
                    break;
                case 18:
                    ItemStack BrightCrystal = new ItemStack(ModItems.SynthesisMaterial, Utils.randomWithRange(1, 3));
                    ItemStacks.createSynthesisItem(BrightCrystal, Strings.SM_BrightCrystal, "S");
                    event.getDrops().add(BrightCrystal);
                    break;
                case 19:
                    ItemStack DarkCrystal = new ItemStack(ModItems.SynthesisMaterial, Utils.randomWithRange(1, 3));
                    ItemStacks.createSynthesisItem(DarkCrystal, Strings.SM_DarkCrystal, "S");
                    event.getDrops().add(DarkCrystal);
                    break;
                case 20:
                    ItemStack DenseCrystal = new ItemStack(ModItems.SynthesisMaterial, Utils.randomWithRange(1, 3));
                    ItemStacks.createSynthesisItem(DenseCrystal, Strings.SM_DenseCrystal, "S");
                    event.getDrops().add(DenseCrystal);
                    break;
                case 21:
                    ItemStack EnergyCrystal = new ItemStack(ModItems.SynthesisMaterial, Utils.randomWithRange(1, 3));
                    ItemStacks.createSynthesisItem(EnergyCrystal, Strings.SM_EnergyCrystal, "S");
                    event.getDrops().add(EnergyCrystal);
                    break;
                case 22:
                    ItemStack FrostCrystal = new ItemStack(ModItems.SynthesisMaterial, Utils.randomWithRange(1, 3));
                    ItemStacks.createSynthesisItem(FrostCrystal, Strings.SM_FrostCrystal, "S");
                    event.getDrops().add(FrostCrystal);
                    break;
                case 23:
                    ItemStack LucidCrystal = new ItemStack(ModItems.SynthesisMaterial, Utils.randomWithRange(1, 3));
                    ItemStacks.createSynthesisItem(LucidCrystal, Strings.SM_LucidCrystal, "S");
                    event.getDrops().add(LucidCrystal);
                    break;
                case 24:
                    ItemStack PowerCrystal = new ItemStack(ModItems.SynthesisMaterial, Utils.randomWithRange(1, 3));
                    ItemStacks.createSynthesisItem(PowerCrystal, Strings.SM_PowerCrystal, "S");
                    event.getDrops().add(PowerCrystal);
                    break;
                case 25:
                    ItemStack RemembranceCrystal = new ItemStack(ModItems.SynthesisMaterial, Utils.randomWithRange(1, 3));
                    ItemStacks.createSynthesisItem(RemembranceCrystal, Strings.SM_RemembranceCrystal, "S");
                    event.getDrops().add(RemembranceCrystal);
                    break;
                case 26:
                    ItemStack SerenityCrystal = new ItemStack(ModItems.SynthesisMaterial, Utils.randomWithRange(1, 3));
                    ItemStacks.createSynthesisItem(SerenityCrystal, Strings.SM_SerenityCrystal, "S");
                    event.getDrops().add(SerenityCrystal);
                    break;
                case 27:
                    ItemStack TranquilCrystal = new ItemStack(ModItems.SynthesisMaterial, Utils.randomWithRange(1, 3));
                    ItemStacks.createSynthesisItem(TranquilCrystal, Strings.SM_TranquilCrystal, "S");
                    event.getDrops().add(TranquilCrystal);
                    break;
                case 28:
                    ItemStack TwilightCrystal = new ItemStack(ModItems.SynthesisMaterial, Utils.randomWithRange(1, 3));
                    ItemStacks.createSynthesisItem(TwilightCrystal, Strings.SM_TwilightCrystal, "S");
                    event.getDrops().add(TwilightCrystal);
                    break;
                case 29:
                    ItemStack Orichalcum = new ItemStack(ModItems.SynthesisMaterial, Utils.randomWithRange(1, 3));
                    ItemStacks.createSynthesisItem(Orichalcum, Strings.SM_Orichalcum, "A");
                    event.getDrops().add(Orichalcum);
                    break;
                case 30:
                    ItemStack OrichalcumPlus = new ItemStack(ModItems.SynthesisMaterial, Utils.randomWithRange(1, 3));
                    ItemStacks.createSynthesisItem(OrichalcumPlus, Strings.SM_OrichalcumPlus, "S");
                    event.getDrops().add(OrichalcumPlus);
                    break;
                case 32:
                    ItemStack LostIllusion = new ItemStack(ModItems.SynthesisMaterial, Utils.randomWithRange(1, 3));
                    ItemStacks.createSynthesisItem(LostIllusion, Strings.SM_LostIllusion, "S");
                    event.getDrops().add(LostIllusion);
                    break;
                case 33:
                    ItemStack ManifestIllusion = new ItemStack(ModItems.SynthesisMaterial, Utils.randomWithRange(1, 3));
                    ItemStacks.createSynthesisItem(ManifestIllusion, Strings.SM_ManifestIllusion, "S");
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
