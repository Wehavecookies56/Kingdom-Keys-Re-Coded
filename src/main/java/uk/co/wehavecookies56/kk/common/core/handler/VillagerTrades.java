package uk.co.wehavecookies56.kk.common.core.handler;

import net.minecraft.entity.IMerchant;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.village.MerchantRecipe;
import net.minecraft.village.MerchantRecipeList;
import net.minecraftforge.fml.common.registry.VillagerRegistry;
import uk.co.wehavecookies56.kk.common.item.ModItems;

import java.util.Random;

public class VillagerTrades implements EntityVillager.ITradeList {

    @Override
    public void addMerchantRecipe(IMerchant merchant, MerchantRecipeList recipeList, Random random) {
        recipeList.add(new MerchantRecipe(new ItemStack(Items.EMERALD, 1), new ItemStack(ModItems.LevelUpMagicCure)));
    }
}
