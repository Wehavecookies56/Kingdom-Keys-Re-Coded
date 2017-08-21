package uk.co.wehavecookies56.kk.common.synthesis.recipe;

import net.minecraft.item.ItemStack;
import uk.co.wehavecookies56.kk.api.materials.Material;
import uk.co.wehavecookies56.kk.api.materials.MaterialRegistry;
import uk.co.wehavecookies56.kk.api.recipes.Recipe;
import uk.co.wehavecookies56.kk.common.item.ModItems;
import uk.co.wehavecookies56.kk.common.lib.Strings;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Toby on 16/07/2016.
 */
public class RecipeHiPotion extends Recipe {

    public String name;

    public RecipeHiPotion(String name) {
        this.name = name;
    }

    @Override
    public String getName () {
        return name;
    }

    @Override
    public ItemStack getResult () {
        return new ItemStack(ModItems.HiPotion);
    }

    @Override
    public Map<Material, Integer> getRequirements () {
        Map<Material, Integer> reqs = new HashMap<Material, Integer>();
        reqs.put(MaterialRegistry.get(Strings.SM_EnergyStone), 3);
        reqs.put(MaterialRegistry.get(Strings.SM_PowerStone), 1);
        reqs.put(MaterialRegistry.get(Strings.SM_BlazingStone), 1);
        reqs.put(MaterialRegistry.get(Strings.SM_MythrilShard), 2);
        return reqs;
    }

}
