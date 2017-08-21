package uk.co.wehavecookies56.kk.common.synthesis.recipe;

import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import uk.co.wehavecookies56.kk.api.materials.Material;
import uk.co.wehavecookies56.kk.api.materials.MaterialRegistry;
import uk.co.wehavecookies56.kk.api.recipes.Recipe;
import uk.co.wehavecookies56.kk.common.item.ModItems;

import java.util.HashMap;
import java.util.Map;

public class RecipeWoodenKeyblade extends Recipe {

    public String name;

    public RecipeWoodenKeyblade (String name) {
        this.name = name;
    }

    @Override
    public String getName () {
        return name;
    }

    @Override
    public ItemStack getResult () {
        return new ItemStack(ModItems.WoodenKeyblade);
    }

    @Override
    public Map<Material, Integer> getRequirements () {
        Map<Material, Integer> reqs = new HashMap<Material, Integer>();
        reqs.put(MaterialRegistry.get(Items.WOODEN_SWORD.getUnlocalizedName()), 1);
        return reqs;
    }

}
