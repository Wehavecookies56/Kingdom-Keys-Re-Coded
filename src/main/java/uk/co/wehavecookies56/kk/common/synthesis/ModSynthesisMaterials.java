package uk.co.wehavecookies56.kk.common.synthesis;

import net.minecraft.init.Items;
import uk.co.wehavecookies56.kk.common.block.ModBlocks;
import uk.co.wehavecookies56.kk.common.item.ModItems;
import uk.co.wehavecookies56.kk.common.lib.Strings;
import uk.co.wehavecookies56.kk.common.synthesis.material.*;

import static uk.co.wehavecookies56.kk.api.materials.MaterialRegistry.registerMaterial;

public class ModSynthesisMaterials {

    public static void init () {
        registerMaterial(new MaterialBlazingShard(Strings.SM_BlazingShard));
        registerMaterial(new MaterialBlazingStone(Strings.SM_BlazingStone));
        registerMaterial(new MaterialBlazingGem(Strings.SM_BlazingGem));
        registerMaterial(new MaterialBlazingCrystal(Strings.SM_BlazingCrystal));

        registerMaterial(new MaterialBrightShard(Strings.SM_BrightShard));
        registerMaterial(new MaterialBrightStone(Strings.SM_BrightStone));
        registerMaterial(new MaterialBrightGem(Strings.SM_BrightGem));
        registerMaterial(new MaterialBrightCrystal(Strings.SM_BrightCrystal));

        registerMaterial(new MaterialDarkShard(Strings.SM_DarkShard));
        registerMaterial(new MaterialDarkStone(Strings.SM_DarkStone));
        registerMaterial(new MaterialDarkGem(Strings.SM_DarkGem));
        registerMaterial(new MaterialDarkCrystal(Strings.SM_DarkCrystal));

        registerMaterial(new MaterialDenseShard(Strings.SM_DenseShard));
        registerMaterial(new MaterialDenseStone(Strings.SM_DenseStone));
        registerMaterial(new MaterialDenseGem(Strings.SM_DenseGem));
        registerMaterial(new MaterialDenseCrystal(Strings.SM_DenseCrystal));

        registerMaterial(new MaterialEnergyShard(Strings.SM_EnergyShard));
        registerMaterial(new MaterialEnergyStone(Strings.SM_EnergyStone));
        registerMaterial(new MaterialEnergyGem(Strings.SM_EnergyGem));
        registerMaterial(new MaterialEnergyCrystal(Strings.SM_EnergyCrystal));

        registerMaterial(new MaterialFrostShard(Strings.SM_FrostShard));
        registerMaterial(new MaterialFrostStone(Strings.SM_FrostStone));
        registerMaterial(new MaterialFrostGem(Strings.SM_FrostGem));
        registerMaterial(new MaterialFrostCrystal(Strings.SM_FrostCrystal));

        registerMaterial(new MaterialLightningShard(Strings.SM_LightningShard));
        registerMaterial(new MaterialLightningStone(Strings.SM_LightningStone));
        registerMaterial(new MaterialLightningGem(Strings.SM_LightningGem));
        registerMaterial(new MaterialLightningCrystal(Strings.SM_LightningCrystal));

        registerMaterial(new MaterialLucidShard(Strings.SM_LucidShard));
        registerMaterial(new MaterialLucidStone(Strings.SM_LucidStone));
        registerMaterial(new MaterialLucidGem(Strings.SM_LucidGem));
        registerMaterial(new MaterialLucidCrystal(Strings.SM_LucidCrystal));

        registerMaterial(new MaterialMythrilShard(Strings.SM_MythrilShard));
        registerMaterial(new MaterialMythrilStone(Strings.SM_MythrilStone));
        registerMaterial(new MaterialMythrilGem(Strings.SM_MythrilGem));
        registerMaterial(new MaterialMythrilCrystal(Strings.SM_MythrilCrystal));

        registerMaterial(new MaterialPowerShard(Strings.SM_PowerShard));
        registerMaterial(new MaterialPowerStone(Strings.SM_PowerStone));
        registerMaterial(new MaterialPowerGem(Strings.SM_PowerGem));
        registerMaterial(new MaterialPowerCrystal(Strings.SM_PowerCrystal));

        registerMaterial(new MaterialRemembranceShard(Strings.SM_RemembranceShard));
        registerMaterial(new MaterialRemembranceStone(Strings.SM_RemembranceStone));
        registerMaterial(new MaterialRemembranceGem(Strings.SM_RemembranceGem));
        registerMaterial(new MaterialRemembranceCrystal(Strings.SM_RemembranceCrystal));

        registerMaterial(new MaterialSerenityShard(Strings.SM_SerenityShard));
        registerMaterial(new MaterialSerenityStone(Strings.SM_SerenityStone));
        registerMaterial(new MaterialSerenityGem(Strings.SM_SerenityGem));
        registerMaterial(new MaterialSerenityCrystal(Strings.SM_SerenityCrystal));

        registerMaterial(new MaterialStormyShard(Strings.SM_StormyShard));
        registerMaterial(new MaterialStormyStone(Strings.SM_StormyStone));
        registerMaterial(new MaterialStormyGem(Strings.SM_StormyGem));
        registerMaterial(new MaterialStormyCrystal(Strings.SM_StormyCrystal));

        registerMaterial(new MaterialTranquilShard(Strings.SM_TranquilShard));
        registerMaterial(new MaterialTranquilStone(Strings.SM_TranquilStone));
        registerMaterial(new MaterialTranquilGem(Strings.SM_TranquilGem));
        registerMaterial(new MaterialTranquilCrystal(Strings.SM_TranquilCrystal));

        registerMaterial(new MaterialTwilightShard(Strings.SM_TwilightShard));
        registerMaterial(new MaterialTwilightStone(Strings.SM_TwilightStone));
        registerMaterial(new MaterialTwilightGem(Strings.SM_TwilightGem));
        registerMaterial(new MaterialTwilightCrystal(Strings.SM_TwilightCrystal));

        registerMaterial(new MaterialOrichalcum(Strings.SM_Orichalcum));
        registerMaterial(new MaterialOrichalcumPlus(Strings.SM_OrichalcumPlus));

        registerMaterial(new MaterialLostIllusion(Strings.SM_LostIllusion));
        registerMaterial(new MaterialManifestIllusion(Strings.SM_ManifestIllusion));

        registerMaterial(new MaterialIncompleteKiBlade(ModItems.Chain_IncompleteKiblade.getUnlocalizedName()));
        registerMaterial(new MaterialNightmaresEnd(ModItems.Chain_NightmaresEnd.getUnlocalizedName()));
        registerMaterial(new MaterialMirageSplit(ModItems.Chain_MirageSplit.getUnlocalizedName()));
        registerMaterial(new MaterialStick(Items.STICK.getUnlocalizedName()));
        registerMaterial(new MaterialWoodenSword(Items.WOODEN_SWORD.getUnlocalizedName()));
        registerMaterial(new MaterialNormalBlox(ModBlocks.NormalBlox.getUnlocalizedName()));
        registerMaterial(new MaterialHardBlox(ModBlocks.HardBlox.getUnlocalizedName()));
        registerMaterial(new MaterialMetalBlox(ModBlocks.MetalBlox.getUnlocalizedName()));

    }
}
