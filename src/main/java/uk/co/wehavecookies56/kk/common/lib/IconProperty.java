package uk.co.wehavecookies56.kk.common.lib;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.IItemPropertyGetter;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import javax.annotation.Nullable;

public class IconProperty implements IItemPropertyGetter {

    @Override
    public float apply(ItemStack stack, @Nullable World worldIn, @Nullable EntityLivingBase entityIn) {
        if (worldIn == null && entityIn != null) {
            if (stack.getTagCompound() != null) {
                if (stack.getTagCompound().hasKey("material")) {
                    String material = stack.getTagCompound().getString("material");
                    switch (material) {
                        case Strings.SM_BlazingShard:       return 0.001F;
                        case Strings.SM_BlazingStone:       return 0.002F;
                        case Strings.SM_BlazingGem:         return 0.003F;
                        case Strings.SM_BlazingCrystal:     return 0.004F;
                        case Strings.SM_BrightShard:        return 0.005F;
                        case Strings.SM_BrightStone:        return 0.006F;
                        case Strings.SM_BrightGem:          return 0.007F;
                        case Strings.SM_BrightCrystal:      return 0.008F;
                        case Strings.SM_DarkShard:          return 0.009F;
                        case Strings.SM_DarkStone:          return 0.010F;
                        case Strings.SM_DarkGem:            return 0.011F;
                        case Strings.SM_DarkCrystal:        return 0.012F;
                        case Strings.SM_DenseShard:         return 0.013F;
                        case Strings.SM_DenseStone:         return 0.014F;
                        case Strings.SM_DenseGem:           return 0.015F;
                        case Strings.SM_DenseCrystal:       return 0.016F;
                        case Strings.SM_EnergyShard:        return 0.017F;
                        case Strings.SM_EnergyStone:        return 0.018F;
                        case Strings.SM_EnergyGem:          return 0.019F;
                        case Strings.SM_EnergyCrystal:      return 0.020F;
                        case Strings.SM_FrostShard:         return 0.021F;
                        case Strings.SM_FrostStone:         return 0.022F;
                        case Strings.SM_FrostGem:           return 0.023F;
                        case Strings.SM_FrostCrystal:       return 0.024F;
                        case Strings.SM_LightningShard:     return 0.025F;
                        case Strings.SM_LightningStone:     return 0.026F;
                        case Strings.SM_LightningGem:       return 0.027F;
                        case Strings.SM_LightningCrystal:   return 0.028F;
                        case Strings.SM_LucidShard:         return 0.029F;
                        case Strings.SM_LucidStone:         return 0.030F;
                        case Strings.SM_LucidGem:           return 0.031F;
                        case Strings.SM_LucidCrystal:       return 0.032F;
                        case Strings.SM_PowerShard:         return 0.033F;
                        case Strings.SM_PowerStone:         return 0.034F;
                        case Strings.SM_PowerGem:           return 0.035F;
                        case Strings.SM_PowerCrystal:       return 0.036F;
                        case Strings.SM_MythrilShard:       return 0.037F;
                        case Strings.SM_MythrilStone:       return 0.038F;
                        case Strings.SM_MythrilGem:         return 0.039F;
                        case Strings.SM_MythrilCrystal:     return 0.040F;
                        case Strings.SM_RemembranceShard:   return 0.041F;
                        case Strings.SM_RemembranceStone:   return 0.042F;
                        case Strings.SM_RemembranceGem:     return 0.043F;
                        case Strings.SM_RemembranceCrystal: return 0.044F;
                        case Strings.SM_SerenityShard:      return 0.045F;
                        case Strings.SM_SerenityStone:      return 0.046F;
                        case Strings.SM_SerenityGem:        return 0.047F;
                        case Strings.SM_SerenityCrystal:    return 0.048F;
                        case Strings.SM_TranquilShard:      return 0.049F;
                        case Strings.SM_TranquilStone:      return 0.050F;
                        case Strings.SM_TranquilGem:        return 0.051F;
                        case Strings.SM_TranquilCrystal:    return 0.052F;
                        case Strings.SM_TwilightShard:      return 0.053F;
                        case Strings.SM_TwilightStone:      return 0.054F;
                        case Strings.SM_TwilightGem:        return 0.055F;
                        case Strings.SM_TwilightCrystal:    return 0.056F;
                        case Strings.SM_Orichalcum:         return 0.057F;
                        case Strings.SM_OrichalcumPlus:     return 0.058F;
                        case Strings.SM_ManifestIllusion:   return 0.059F;
                        case Strings.SM_LostIllusion:       return 0.060F;
                        case Strings.SM_StormyShard:        return 0.061F;
                        case Strings.SM_StormyStone:        return 0.062F;
                        case Strings.SM_StormyGem:          return 0.063F;
                        case Strings.SM_StormyCrystal:      return 0.064F;
                    }
                }
            }
        }
		return 0;
	}
}
