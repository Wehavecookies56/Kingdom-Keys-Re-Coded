package uk.co.wehavecookies56.kk.api.munny;

import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.oredict.OreDictionary;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import uk.co.wehavecookies56.kk.common.item.ModItems;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Toby on 19/07/2016.
 */
public class MunnyRegistry {

    public static Map<ItemStack, Integer> munnyValues = new HashMap<ItemStack, Integer>();

    public static Logger apiLogger = LogManager.getFormatterLogger("kkMunnyAPI");

    static {
        ItemStack BlazingShard = new ItemStack(ModItems.SynthesisMaterial);
        ItemStack BlazingStone = new ItemStack(ModItems.SynthesisMaterial);
        ItemStack BlazingGem = new ItemStack(ModItems.SynthesisMaterial);
        ItemStack BlazingCrystal = new ItemStack(ModItems.SynthesisMaterial);

        ItemStack BrightShard = new ItemStack(ModItems.SynthesisMaterial);
        ItemStack BrightStone = new ItemStack(ModItems.SynthesisMaterial);
        ItemStack BrightGem = new ItemStack(ModItems.SynthesisMaterial);
        ItemStack BrightCrystal = new ItemStack(ModItems.SynthesisMaterial);

        ItemStack DarkShard = new ItemStack(ModItems.SynthesisMaterial);
        ItemStack DarkStone = new ItemStack(ModItems.SynthesisMaterial);
        ItemStack DarkGem = new ItemStack(ModItems.SynthesisMaterial);
        ItemStack DarkCrystal = new ItemStack(ModItems.SynthesisMaterial);

        ItemStack DenseShard = new ItemStack(ModItems.SynthesisMaterial);
        ItemStack DenseStone = new ItemStack(ModItems.SynthesisMaterial);
        ItemStack DenseGem = new ItemStack(ModItems.SynthesisMaterial);
        ItemStack DenseCrystal = new ItemStack(ModItems.SynthesisMaterial);

        ItemStack EnergyShard = new ItemStack(ModItems.SynthesisMaterial);
        ItemStack EnergyStone = new ItemStack(ModItems.SynthesisMaterial);
        ItemStack EnergyGem = new ItemStack(ModItems.SynthesisMaterial);
        ItemStack EnergyCrystal = new ItemStack(ModItems.SynthesisMaterial);

        ItemStack FrostShard = new ItemStack(ModItems.SynthesisMaterial);
        ItemStack FrostStone = new ItemStack(ModItems.SynthesisMaterial);
        ItemStack FrostGem = new ItemStack(ModItems.SynthesisMaterial);
        ItemStack FrostCrystal = new ItemStack(ModItems.SynthesisMaterial);

        ItemStack LightningShard = new ItemStack(ModItems.SynthesisMaterial);
        ItemStack LightningStone = new ItemStack(ModItems.SynthesisMaterial);
        ItemStack LightningGem = new ItemStack(ModItems.SynthesisMaterial);
        ItemStack LightningCrystal = new ItemStack(ModItems.SynthesisMaterial);

        ItemStack LucidShard = new ItemStack(ModItems.SynthesisMaterial);
        ItemStack LucidStone = new ItemStack(ModItems.SynthesisMaterial);
        ItemStack LucidGem = new ItemStack(ModItems.SynthesisMaterial);
        ItemStack LucidCrystal = new ItemStack(ModItems.SynthesisMaterial);

        ItemStack MythrilShard = new ItemStack(ModItems.SynthesisMaterial);
        ItemStack MythrilStone = new ItemStack(ModItems.SynthesisMaterial);
        ItemStack MythrilGem = new ItemStack(ModItems.SynthesisMaterial);
        ItemStack MythrilCrystal = new ItemStack(ModItems.SynthesisMaterial);

        ItemStack PowerShard = new ItemStack(ModItems.SynthesisMaterial);
        ItemStack PowerStone = new ItemStack(ModItems.SynthesisMaterial);
        ItemStack PowerGem = new ItemStack(ModItems.SynthesisMaterial);
        ItemStack PowerCrystal = new ItemStack(ModItems.SynthesisMaterial);

        ItemStack RemembranceShard = new ItemStack(ModItems.SynthesisMaterial);
        ItemStack RemembranceStone = new ItemStack(ModItems.SynthesisMaterial);
        ItemStack RemembranceGem = new ItemStack(ModItems.SynthesisMaterial);
        ItemStack RemembranceCrystal = new ItemStack(ModItems.SynthesisMaterial);

        ItemStack SerenityShard = new ItemStack(ModItems.SynthesisMaterial);
        ItemStack SerenityStone = new ItemStack(ModItems.SynthesisMaterial);
        ItemStack SerenityGem = new ItemStack(ModItems.SynthesisMaterial);
        ItemStack SerenityCrystal = new ItemStack(ModItems.SynthesisMaterial);

        ItemStack StormyShard = new ItemStack(ModItems.SynthesisMaterial);
        ItemStack StormyStone = new ItemStack(ModItems.SynthesisMaterial);
        ItemStack StormyGem = new ItemStack(ModItems.SynthesisMaterial);
        ItemStack StormyCrystal = new ItemStack(ModItems.SynthesisMaterial);

        ItemStack TranquilShard = new ItemStack(ModItems.SynthesisMaterial);
        ItemStack TranquilStone = new ItemStack(ModItems.SynthesisMaterial);
        ItemStack TranquilGem = new ItemStack(ModItems.SynthesisMaterial);
        ItemStack TranquilCrystal = new ItemStack(ModItems.SynthesisMaterial);

        ItemStack TwilightShard = new ItemStack(ModItems.SynthesisMaterial);
        ItemStack TwilightStone = new ItemStack(ModItems.SynthesisMaterial);
        ItemStack TwilightGem = new ItemStack(ModItems.SynthesisMaterial);
        ItemStack TwilightCrystal = new ItemStack(ModItems.SynthesisMaterial);

        ItemStack Orichalcum = new ItemStack(ModItems.SynthesisMaterial);
        ItemStack OrichalcumPlus = new ItemStack(ModItems.SynthesisMaterial);
        ItemStack LostIllusion = new ItemStack(ModItems.SynthesisMaterial);
        ItemStack ManifestIllusion = new ItemStack(ModItems.SynthesisMaterial);

        BlazingShard.setTagCompound(new NBTTagCompound());
        BlazingShard.getTagCompound().setString("material", "sm.blazingshard");
        BlazingShard.getTagCompound().setString("rank", "sm.rank.c");

        BlazingStone.setTagCompound(new NBTTagCompound());
        BlazingStone.getTagCompound().setString("material", "sm.blazingstone");
        BlazingStone.getTagCompound().setString("rank", "sm.rank.b");

        BlazingGem.setTagCompound(new NBTTagCompound());
        BlazingGem.getTagCompound().setString("material", "sm.blazinggem");
        BlazingGem.getTagCompound().setString("rank", "sm.rank.a");

        BlazingCrystal.setTagCompound(new NBTTagCompound());
        BlazingCrystal.getTagCompound().setString("material", "sm.blazingcrystal");
        BlazingCrystal.getTagCompound().setString("rank", "sm.rank.s");

        BrightShard.setTagCompound(new NBTTagCompound());
        BrightShard.getTagCompound().setString("material", "sm.brightshard");
        BrightShard.getTagCompound().setString("rank", "sm.rank.c");

        BrightStone.setTagCompound(new NBTTagCompound());
        BrightStone.getTagCompound().setString("material", "sm.brightstone");
        BrightStone.getTagCompound().setString("rank", "sm.rank.b");

        BrightGem.setTagCompound(new NBTTagCompound());
        BrightGem.getTagCompound().setString("material", "sm.brightgem");
        BrightGem.getTagCompound().setString("rank", "sm.rank.a");

        BrightCrystal.setTagCompound(new NBTTagCompound());
        BrightCrystal.getTagCompound().setString("material", "sm.brightcrystal");
        BrightCrystal.getTagCompound().setString("rank", "sm.rank.s");

        DarkShard.setTagCompound(new NBTTagCompound());
        DarkShard.getTagCompound().setString("material", "sm.darkshard");
        DarkShard.getTagCompound().setString("rank", "sm.rank.c");

        DarkStone.setTagCompound(new NBTTagCompound());
        DarkStone.getTagCompound().setString("material", "sm.darkstone");
        DarkStone.getTagCompound().setString("rank", "sm.rank.b");

        DarkGem.setTagCompound(new NBTTagCompound());
        DarkGem.getTagCompound().setString("material", "sm.darkgem");
        DarkGem.getTagCompound().setString("rank", "sm.rank.a");

        DarkCrystal.setTagCompound(new NBTTagCompound());
        DarkCrystal.getTagCompound().setString("material", "sm.darkcrystal");
        DarkCrystal.getTagCompound().setString("rank", "sm.rank.s");

        DenseShard.setTagCompound(new NBTTagCompound());
        DenseShard.getTagCompound().setString("material", "sm.denseshard");
        DenseShard.getTagCompound().setString("rank", "sm.rank.c");

        DenseStone.setTagCompound(new NBTTagCompound());
        DenseStone.getTagCompound().setString("material", "sm.densestone");
        DenseStone.getTagCompound().setString("rank", "sm.rank.b");

        DenseGem.setTagCompound(new NBTTagCompound());
        DenseGem.getTagCompound().setString("material", "sm.densegem");
        DenseGem.getTagCompound().setString("rank", "sm.rank.a");

        DenseCrystal.setTagCompound(new NBTTagCompound());
        DenseCrystal.getTagCompound().setString("material", "sm.densecrystal");
        DenseCrystal.getTagCompound().setString("rank", "sm.rank.s");

        EnergyShard.setTagCompound(new NBTTagCompound());
        EnergyShard.getTagCompound().setString("material", "sm.energyshard");
        EnergyShard.getTagCompound().setString("rank", "sm.rank.c");

        EnergyStone.setTagCompound(new NBTTagCompound());
        EnergyStone.getTagCompound().setString("material", "sm.energystone");
        EnergyStone.getTagCompound().setString("rank", "sm.rank.b");

        EnergyGem.setTagCompound(new NBTTagCompound());
        EnergyGem.getTagCompound().setString("material", "sm.energygem");
        EnergyGem.getTagCompound().setString("rank", "sm.rank.a");

        EnergyCrystal.setTagCompound(new NBTTagCompound());
        EnergyCrystal.getTagCompound().setString("material", "sm.energycrystal");
        EnergyCrystal.getTagCompound().setString("rank", "sm.rank.s");

        FrostShard.setTagCompound(new NBTTagCompound());
        FrostShard.getTagCompound().setString("material", "sm.frostshard");
        FrostShard.getTagCompound().setString("rank", "sm.rank.c");

        FrostStone.setTagCompound(new NBTTagCompound());
        FrostStone.getTagCompound().setString("material", "sm.froststone");
        FrostStone.getTagCompound().setString("rank", "sm.rank.b");

        FrostGem.setTagCompound(new NBTTagCompound());
        FrostGem.getTagCompound().setString("material", "sm.frostgem");
        FrostGem.getTagCompound().setString("rank", "sm.rank.a");

        FrostCrystal.setTagCompound(new NBTTagCompound());
        FrostCrystal.getTagCompound().setString("material", "sm.frostcrystal");
        FrostCrystal.getTagCompound().setString("rank", "sm.rank.s");

        LightningShard.setTagCompound(new NBTTagCompound());
        LightningShard.getTagCompound().setString("material", "sm.lightningshard");
        LightningShard.getTagCompound().setString("rank", "sm.rank.c");

        LightningStone.setTagCompound(new NBTTagCompound());
        LightningStone.getTagCompound().setString("material", "sm.lightningstone");
        LightningStone.getTagCompound().setString("rank", "sm.rank.b");

        LightningGem.setTagCompound(new NBTTagCompound());
        LightningGem.getTagCompound().setString("material", "sm.lightninggem");
        LightningGem.getTagCompound().setString("rank", "sm.rank.a");

        LightningCrystal.setTagCompound(new NBTTagCompound());
        LightningCrystal.getTagCompound().setString("material", "sm.lightningcrystal");
        LightningCrystal.getTagCompound().setString("rank", "sm.rank.s");

        LucidShard.setTagCompound(new NBTTagCompound());
        LucidShard.getTagCompound().setString("material", "sm.lucidshard");
        LucidShard.getTagCompound().setString("rank", "sm.rank.c");

        LucidStone.setTagCompound(new NBTTagCompound());
        LucidStone.getTagCompound().setString("material", "sm.lucidstone");
        LucidStone.getTagCompound().setString("rank", "sm.rank.b");

        LucidGem.setTagCompound(new NBTTagCompound());
        LucidGem.getTagCompound().setString("material", "sm.lucidgem");
        LucidGem.getTagCompound().setString("rank", "sm.rank.a");

        LucidCrystal.setTagCompound(new NBTTagCompound());
        LucidCrystal.getTagCompound().setString("material", "sm.lucidcrystal");
        LucidCrystal.getTagCompound().setString("rank", "sm.rank.s");

        MythrilShard.setTagCompound(new NBTTagCompound());
        MythrilShard.getTagCompound().setString("material", "sm.mythrilshard");
        MythrilShard.getTagCompound().setString("rank", "sm.rank.c");

        MythrilStone.setTagCompound(new NBTTagCompound());
        MythrilStone.getTagCompound().setString("material", "sm.mythrilstone");
        MythrilStone.getTagCompound().setString("rank", "sm.rank.b");

        MythrilGem.setTagCompound(new NBTTagCompound());
        MythrilGem.getTagCompound().setString("material", "sm.mythrilgem");
        MythrilGem.getTagCompound().setString("rank", "sm.rank.a");

        MythrilCrystal.setTagCompound(new NBTTagCompound());
        MythrilCrystal.getTagCompound().setString("material", "sm.mythrilcrystal");
        MythrilCrystal.getTagCompound().setString("rank", "sm.rank.s");

        PowerShard.setTagCompound(new NBTTagCompound());
        PowerShard.getTagCompound().setString("material", "sm.powershard");
        PowerShard.getTagCompound().setString("rank", "sm.rank.c");

        PowerStone.setTagCompound(new NBTTagCompound());
        PowerStone.getTagCompound().setString("material", "sm.powerstone");
        PowerStone.getTagCompound().setString("rank", "sm.rank.b");

        PowerGem.setTagCompound(new NBTTagCompound());
        PowerGem.getTagCompound().setString("material", "sm.powergem");
        PowerGem.getTagCompound().setString("rank", "sm.rank.a");

        PowerCrystal.setTagCompound(new NBTTagCompound());
        PowerCrystal.getTagCompound().setString("material", "sm.powercrystal");
        PowerCrystal.getTagCompound().setString("rank", "sm.rank.s");

        RemembranceShard.setTagCompound(new NBTTagCompound());
        RemembranceShard.getTagCompound().setString("material", "sm.remembranceshard");
        RemembranceShard.getTagCompound().setString("rank", "sm.rank.c");

        RemembranceStone.setTagCompound(new NBTTagCompound());
        RemembranceStone.getTagCompound().setString("material", "sm.remembrancestone");
        RemembranceStone.getTagCompound().setString("rank", "sm.rank.b");

        RemembranceGem.setTagCompound(new NBTTagCompound());
        RemembranceGem.getTagCompound().setString("material", "sm.remembrancegem");
        RemembranceGem.getTagCompound().setString("rank", "sm.rank.a");

        RemembranceCrystal.setTagCompound(new NBTTagCompound());
        RemembranceCrystal.getTagCompound().setString("material", "sm.remembrancecrystal");
        RemembranceCrystal.getTagCompound().setString("rank", "sm.rank.s");

        SerenityShard.setTagCompound(new NBTTagCompound());
        SerenityShard.getTagCompound().setString("material", "sm.serenityshard");
        SerenityShard.getTagCompound().setString("rank", "sm.rank.c");

        SerenityStone.setTagCompound(new NBTTagCompound());
        SerenityStone.getTagCompound().setString("material", "sm.serenitystone");
        SerenityStone.getTagCompound().setString("rank", "sm.rank.b");

        SerenityGem.setTagCompound(new NBTTagCompound());
        SerenityGem.getTagCompound().setString("material", "sm.serenitygem");
        SerenityGem.getTagCompound().setString("rank", "sm.rank.a");

        SerenityCrystal.setTagCompound(new NBTTagCompound());
        SerenityCrystal.getTagCompound().setString("material", "sm.serenitycrystal");
        SerenityCrystal.getTagCompound().setString("rank", "sm.rank.s");

        StormyShard.setTagCompound(new NBTTagCompound());
        StormyShard.getTagCompound().setString("material", "sm.stormyshard");
        StormyShard.getTagCompound().setString("rank", "sm.rank.c");

        StormyStone.setTagCompound(new NBTTagCompound());
        StormyStone.getTagCompound().setString("material", "sm.stormystone");
        StormyStone.getTagCompound().setString("rank", "sm.rank.b");

        StormyGem.setTagCompound(new NBTTagCompound());
        StormyGem.getTagCompound().setString("material", "sm.stormygem");
        StormyGem.getTagCompound().setString("rank", "sm.rank.a");

        StormyCrystal.setTagCompound(new NBTTagCompound());
        StormyCrystal.getTagCompound().setString("material", "sm.stormycrystal");
        StormyCrystal.getTagCompound().setString("rank", "sm.rank.s");

        TranquilShard.setTagCompound(new NBTTagCompound());
        TranquilShard.getTagCompound().setString("material", "sm.tranquilshard");
        TranquilShard.getTagCompound().setString("rank", "sm.rank.c");

        TranquilStone.setTagCompound(new NBTTagCompound());
        TranquilStone.getTagCompound().setString("material", "sm.tranquilstone");
        TranquilStone.getTagCompound().setString("rank", "sm.rank.b");

        TranquilGem.setTagCompound(new NBTTagCompound());
        TranquilGem.getTagCompound().setString("material", "sm.tranquilgem");
        TranquilGem.getTagCompound().setString("rank", "sm.rank.a");

        TranquilCrystal.setTagCompound(new NBTTagCompound());
        TranquilCrystal.getTagCompound().setString("material", "sm.tranquilcrystal");
        TranquilCrystal.getTagCompound().setString("rank", "sm.rank.s");

        TwilightShard.setTagCompound(new NBTTagCompound());
        TwilightShard.getTagCompound().setString("material", "sm.twilightshard");
        TwilightShard.getTagCompound().setString("rank", "sm.rank.c");

        TwilightStone.setTagCompound(new NBTTagCompound());
        TwilightStone.getTagCompound().setString("material", "sm.twilightstone");
        TwilightStone.getTagCompound().setString("rank", "sm.rank.b");

        TwilightGem.setTagCompound(new NBTTagCompound());
        TwilightGem.getTagCompound().setString("material", "sm.twilightgem");
        TwilightGem.getTagCompound().setString("rank", "sm.rank.a");

        TwilightCrystal.setTagCompound(new NBTTagCompound());
        TwilightCrystal.getTagCompound().setString("material", "sm.twilightcrystal");
        TwilightCrystal.getTagCompound().setString("rank", "sm.rank.s");

        Orichalcum.setTagCompound(new NBTTagCompound());
        Orichalcum.getTagCompound().setString("material", "sm.orichalcum");
        Orichalcum.getTagCompound().setString("rank", "sm.rank.a");

        OrichalcumPlus.setTagCompound(new NBTTagCompound());
        OrichalcumPlus.getTagCompound().setString("material", "sm.orichalcum+");
        OrichalcumPlus.getTagCompound().setString("rank", "sm.rank.s");

        LostIllusion.setTagCompound(new NBTTagCompound());
        LostIllusion.getTagCompound().setString("material", "sm.lostillusion");
        LostIllusion.getTagCompound().setString("rank", "sm.rank.s");

        ManifestIllusion.setTagCompound(new NBTTagCompound());
        ManifestIllusion.getTagCompound().setString("material", "sm.manifestillusion");
        ManifestIllusion.getTagCompound().setString("rank", "sm.rank.a");

        //TODO REGISTER MORE VALUES

        addMunnyValueFromOreDict("ingotIron", 1000);
        addMunnyValueFromOreDict("ingotGold", 2000);
        addMunnyValueFromOreDict("gemDiamond", 4000);
        addMunnyValueFromOreDict("gemEmerald",  3500);

        addMunnyValue(new ItemStack(ModItems.Potion), 400);
        addMunnyValue(new ItemStack(ModItems.Ether), 400);

        addMunnyValue(new ItemStack(ModItems.WinnerStick), 10000);
        
        addMunnyValue(new ItemStack(Blocks.DIRT), 1);
        
        addMunnyValue(BlazingShard, 800);
        addMunnyValue(BlazingStone, 1600);
        addMunnyValue(BlazingGem, 3200);
        addMunnyValue(BlazingCrystal, 6400);

        addMunnyValue(BrightShard, 800);
        addMunnyValue(BrightStone, 1600);
        addMunnyValue(BrightGem, 3200);
        addMunnyValue(BrightCrystal, 6400);

        addMunnyValue(DarkShard, 800);
        addMunnyValue(DarkStone, 1600);
        addMunnyValue(DarkGem, 3200);
        addMunnyValue(DarkCrystal, 6400);

        addMunnyValue(DenseShard, 800);
        addMunnyValue(DenseStone, 1600);
        addMunnyValue(DenseGem, 3200);
        addMunnyValue(DenseCrystal, 6400);
        
        addMunnyValue(EnergyShard, 800);
        addMunnyValue(EnergyStone, 1600);
        addMunnyValue(EnergyGem, 3200);
        addMunnyValue(EnergyCrystal, 6400);

        addMunnyValue(FrostShard, 1000);
        addMunnyValue(FrostStone, 1800);
        addMunnyValue(FrostGem, 3400);
        addMunnyValue(FrostCrystal, 6600);

        addMunnyValue(LightningShard, 800);
        addMunnyValue(LightningStone, 1600);
        addMunnyValue(LightningGem, 3200);
        addMunnyValue(LightningCrystal, 6400);

        addMunnyValue(LucidShard, 800);
        addMunnyValue(LucidStone, 1600);
        addMunnyValue(LucidGem, 3200);
        addMunnyValue(LucidCrystal, 6400);

        addMunnyValue(MythrilShard, 2400);
        addMunnyValue(MythrilStone, 3000);
        addMunnyValue(MythrilGem, 4600);
        addMunnyValue(MythrilCrystal, 8800);
        
        addMunnyValue(PowerShard, 800);
        addMunnyValue(PowerStone, 1600);
        addMunnyValue(PowerGem, 3200);
        addMunnyValue(PowerCrystal, 6400);

        addMunnyValue(RemembranceShard, 800);
        addMunnyValue(RemembranceStone, 1600);
        addMunnyValue(RemembranceGem, 3200);
        addMunnyValue(RemembranceCrystal, 6400);

        addMunnyValue(SerenityShard, 800);
        addMunnyValue(SerenityStone, 1600);
        addMunnyValue(SerenityGem, 3200);
        addMunnyValue(SerenityCrystal, 6400);
        
        addMunnyValue(StormyShard, 800);
        addMunnyValue(StormyStone, 1600);
        addMunnyValue(StormyGem, 3200);
        addMunnyValue(StormyCrystal, 6400);
        
        addMunnyValue(TranquilShard, 800);
        addMunnyValue(TranquilStone, 1600);
        addMunnyValue(TranquilGem, 3200);
        addMunnyValue(TranquilCrystal, 6400);
        
        addMunnyValue(TwilightShard, 800);
        addMunnyValue(TwilightStone, 1600);
        addMunnyValue(TwilightGem, 3200);
        addMunnyValue(TwilightCrystal, 6400);
        
        addMunnyValue(Orichalcum, 10000);
        addMunnyValue(OrichalcumPlus, 15000);
        addMunnyValue(LostIllusion, 25000);
        addMunnyValue(ManifestIllusion, 20000);
        apiLogger.info(munnyValues.size() + " munny value(s) loaded");
    }

    public static boolean addMunnyValue(ItemStack item, int value) {
        if (!munnyValues.containsKey(item)) {
            munnyValues.put(item, value);
            return true;
        } else {
            apiLogger.log(Level.WARN, "Item %s has already had a munny value registered.", item.getDisplayName());
            return false;
        }
    }

    public static boolean addMunnyValueFromOreDict(String name, int value) {
        List<ItemStack> oreStacks = OreDictionary.getOres(name);
        if (oreStacks.isEmpty()) {
            return false;
        } else {
            for (int i = 0; i < oreStacks.size(); i++) {
                if (!munnyValues.containsKey(oreStacks.get(i))) {
                    munnyValues.put(oreStacks.get(i), value);
                } else {
                    apiLogger.log(Level.WARN, "Item %s has already had a munny value registered.", oreStacks.get(i).getDisplayName());
                    return false;
                }
            }
            return true;
        }
    }

}
