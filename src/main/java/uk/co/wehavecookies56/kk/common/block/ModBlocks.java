package uk.co.wehavecookies56.kk.common.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import scala.tools.nsc.interpreter.Power;
import uk.co.wehavecookies56.kk.common.block.base.BlockKKOre;
import uk.co.wehavecookies56.kk.common.block.base.BlockStationOfAwakening;
import uk.co.wehavecookies56.kk.common.lib.Reference;
import uk.co.wehavecookies56.kk.common.lib.Strings;

public class ModBlocks {

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.NormalBlox)
    public static Block NormalBlox;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.HardBlox)
    public static Block HardBlox;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.MetalBlox)
    public static Block MetalBlox;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.DangerBlox)
    public static Block DangerBlox;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.BounceBlox)
    public static Block BounceBlox;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.BlastBlox)
    public static Block BlastBlox;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.PrizeBlox)
    public static Block PrizeBlox;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.RarePrizeBlox)
    public static Block RarePrizeBlox;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.GhostBlox)
    public static Block GhostBlox;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.BlazingOre)
    public static Block BlazingOre;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.BrightOre)
    public static Block BrightOre;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.DarkOre)
    public static Block DarkOre;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.DarkOreE)
    public static Block DarkOreE;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.DenseOre)
    public static Block DenseOre;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.EnergyOre)
    public static Block EnergyOre;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.FrostOre)
    public static Block FrostOre;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.LightningOre)
    public static Block LightningOre;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.LucidOre)
    public static Block LucidOre;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.PowerOre)
    public static Block PowerOre;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.PowerOreE)
    public static Block PowerOreE;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.RemembranceOre)
    public static Block RemembranceOre;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.SerenityOre)
    public static Block SerenityOre;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.StormyOre)
    public static Block StormyOre;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.TranquilOre)
    public static Block TranquilOre;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.TwilightOre)
    public static Block TwilightOre;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.SynthesisTable)
    public static Block SynthesisTable;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.KKChest)
    public static Block KKChest;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.SavePoint)
    public static Block SavePoint;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.MagnetBlox)
    public static Block MagnetBlox;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.OrgPortal)
    public static Block OrgPortal;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.StationOfAwakening)
    public static Block StationOfAwakening;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.StationOfAwakeningDoor)
    public static Block StationOfAwakeningDoor;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.Pedestal)
    public static Block Pedestal;

    public static CreativeTabs tabKingdomKeysBlocks = new TabKingdomKeysBlocks(CreativeTabs.getNextID(), Strings.tabKingdomKeysBlocks);

    @Mod.EventBusSubscriber(modid = Reference.MODID)
    public static class register {

        @SubscribeEvent
        public static void registerBlock(RegistryEvent.Register<Block> event) {
            event.getRegistry().register(new BlockNormalBlox(Material.IRON, "pickaxe", 0, 1f, 10f, Strings.NormalBlox));
            event.getRegistry().register(new BlockHardBlox(Material.IRON, "pickaxe", 1, 5f, 20f, Strings.HardBlox));
            event.getRegistry().register(new BlockMetalBlox(Material.IRON, "pickaxe", 2, 10f, 60f, Strings.MetalBlox));
            event.getRegistry().register(new BlockDangerBlox(Material.IRON, "pickaxe", 1, 1f, 1f, Strings.DangerBlox));
            event.getRegistry().register(new BlockBounceBlox(Material.IRON, "pickaxe", 0, 1f, 1f, Strings.BounceBlox));
            event.getRegistry().register(new BlockBlastBlox(Material.IRON, "pickaxe", 0, 1f, 1f, Strings.BlastBlox));
            event.getRegistry().register(new BlockPrizeBlox(Material.IRON, "pickaxe", 0, 1f, 1f, Strings.PrizeBlox));
            event.getRegistry().register(new BlockRarePrizeBlox(Material.IRON, "pickaxe", 1, 1f, 1f, Strings.RarePrizeBlox));
            event.getRegistry().register(new BlockGhostBlox(Material.CIRCUITS, "pickaxe", 1, 1f, 1f, Strings.GhostBlox));
            event.getRegistry().register(new BlockBlazingOre(Material.IRON, "pickaxe", 1, 2f, 1f, Strings.BlazingOre));
            event.getRegistry().register(new BlockBrightOre(Material.IRON, "pickaxe", 1, 2f, 1f, Strings.BrightOre));
            event.getRegistry().register(new BlockDarkOre(Material.IRON, "pickaxe", 2, 2f, 1f, Strings.DarkOre));
            event.getRegistry().register(new BlockDarkOreE(Material.IRON, "pickaxe", 2, 2f, 1f, Strings.DarkOreE));
            event.getRegistry().register(new BlockDenseOre(Material.IRON, "pickaxe", 2, 2f, 1f, Strings.DenseOre));
            event.getRegistry().register(new BlockEnergyOre(Material.IRON, "pickaxe", 1, 2f, 1f, Strings.EnergyOre));
            event.getRegistry().register(new BlockFrostOre(Material.IRON, "pickaxe", 1, 2f, 1f, Strings.FrostOre));
            event.getRegistry().register(new BlockLightningOre(Material.IRON, "pickaxe", 1, 2f, 1f, Strings.LightningOre));
            event.getRegistry().register(new BlockLucidOre(Material.IRON, "pickaxe", 1, 2f, 1f, Strings.LucidOre));
            event.getRegistry().register(new BlockPowerOre(Material.IRON, "pickaxe", 2, 2f, 1f, Strings.PowerOre));
            event.getRegistry().register(new BlockPowerOreE(Material.IRON, "pickaxe", 2, 2f, 1f, Strings.PowerOreE));
            event.getRegistry().register(new BlockRemembranceOre(Material.IRON, "pickaxe", 1, 2f, 1f, Strings.RemembranceOre));
            event.getRegistry().register(new BlockSerenityOre(Material.IRON, "pickaxe", 1, 2f, 1f, Strings.SerenityOre));
            event.getRegistry().register(new BlockTranquilOre(Material.IRON, "pickaxe", 1, 2f, 1f, Strings.TranquilOre));
            event.getRegistry().register(new BlockStormyOre(Material.IRON, "pickaxe", 2, 2f, 1f, Strings.StormyOre));
            event.getRegistry().register(new BlockTwilightOre(Material.IRON, "pickaxe", 2, 2f, 1f, Strings.TwilightOre));
            event.getRegistry().register(new BlockSynthesisTable(Material.WOOD, "axe", 0, 1, 1, Strings.SynthesisTable));
            event.getRegistry().register(new BlockKKChest(Material.ROCK, "pickaxe", 3, 20f, 5f, Strings.KKChest));
            event.getRegistry().register(new BlockSavePoint(Material.CIRCUITS, "pickaxe", 3, 20f, 5f, Strings.SavePoint));
            event.getRegistry().register(new BlockMagnetBlox(Material.IRON, "pickaxe", 0, 1f, 10f, Strings.MagnetBlox));
            event.getRegistry().register(new BlockPedestal(Material.IRON, "pickaxe", 2, 10f, 60f, Strings.Pedestal));
            event.getRegistry().register(new BlockStationOfAwakening(Strings.StationOfAwakening));
            event.getRegistry().register(new BlockStationOfAwakeningDoor(Strings.StationOfAwakeningDoor));
            event.getRegistry().register(new BlockOrgPortal(Material.IRON, "pickaxe", 0, 1f, 10f, Strings.OrgPortal));
        }

        @SubscribeEvent
        public static void registerItem(RegistryEvent.Register<Item> event) {
            event.getRegistry().register(new ItemBlock(NormalBlox).setRegistryName(NormalBlox.getRegistryName()));
            event.getRegistry().register(new ItemBlock(HardBlox).setRegistryName(HardBlox.getRegistryName()));
            event.getRegistry().register(new ItemBlock(MetalBlox).setRegistryName(MetalBlox.getRegistryName()));
            event.getRegistry().register(new ItemBlock(DangerBlox).setRegistryName(DangerBlox.getRegistryName()));
            event.getRegistry().register(new ItemBlock(BounceBlox).setRegistryName(BounceBlox.getRegistryName()));
            event.getRegistry().register(new ItemBlock(BlastBlox).setRegistryName(BlastBlox.getRegistryName()));
            event.getRegistry().register(new ItemBlock(PrizeBlox).setRegistryName(PrizeBlox.getRegistryName()));
            event.getRegistry().register(new ItemBlock(RarePrizeBlox).setRegistryName(RarePrizeBlox.getRegistryName()));
            event.getRegistry().register(new ItemBlock(GhostBlox).setRegistryName(GhostBlox.getRegistryName()));
            event.getRegistry().register(new ItemBlock(BlazingOre).setRegistryName(BlazingOre.getRegistryName()));
            event.getRegistry().register(new ItemBlock(BrightOre).setRegistryName(BrightOre.getRegistryName()));
            event.getRegistry().register(new ItemBlock(DarkOre).setRegistryName(DarkOre.getRegistryName()));
            event.getRegistry().register(new ItemBlock(DarkOreE).setRegistryName(DarkOreE.getRegistryName()));
            event.getRegistry().register(new ItemBlock(DenseOre).setRegistryName(DenseOre.getRegistryName()));
            event.getRegistry().register(new ItemBlock(EnergyOre).setRegistryName(EnergyOre.getRegistryName()));
            event.getRegistry().register(new ItemBlock(FrostOre).setRegistryName(FrostOre.getRegistryName()));
            event.getRegistry().register(new ItemBlock(LightningOre).setRegistryName(LightningOre.getRegistryName()));
            event.getRegistry().register(new ItemBlock(LucidOre).setRegistryName(LucidOre.getRegistryName()));
            event.getRegistry().register(new ItemBlock(PowerOre).setRegistryName(PowerOre.getRegistryName()));
            event.getRegistry().register(new ItemBlock(PowerOreE).setRegistryName(PowerOreE.getRegistryName()));
            event.getRegistry().register(new ItemBlock(RemembranceOre).setRegistryName(RemembranceOre.getRegistryName()));
            event.getRegistry().register(new ItemBlock(SerenityOre).setRegistryName(SerenityOre.getRegistryName()));
            event.getRegistry().register(new ItemBlock(TranquilOre).setRegistryName(TranquilOre.getRegistryName()));
            event.getRegistry().register(new ItemBlock(StormyOre).setRegistryName(StormyOre.getRegistryName()));
            event.getRegistry().register(new ItemBlock(TwilightOre).setRegistryName(TwilightOre.getRegistryName()));
            event.getRegistry().register(new ItemBlock(SynthesisTable).setRegistryName(SynthesisTable.getRegistryName()));
            event.getRegistry().register(new ItemBlock(KKChest).setRegistryName(KKChest.getRegistryName()));
            event.getRegistry().register(new ItemBlock(SavePoint).setRegistryName(SavePoint.getRegistryName()));
            event.getRegistry().register(new ItemBlock(MagnetBlox).setRegistryName(MagnetBlox.getRegistryName()));
            event.getRegistry().register(new ItemBlock(Pedestal).setRegistryName(Pedestal.getRegistryName()));
            event.getRegistry().register(new ItemBlock(StationOfAwakening).setRegistryName(StationOfAwakening.getRegistryName()));
            event.getRegistry().register(new ItemBlock(StationOfAwakeningDoor).setRegistryName(StationOfAwakeningDoor.getRegistryName()));
            event.getRegistry().register(new ItemBlock(OrgPortal).setRegistryName(OrgPortal.getRegistryName()));
        }

    }
}
