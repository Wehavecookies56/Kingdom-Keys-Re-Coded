package uk.co.wehavecookies56.kk.common.synthesis.recipe;

import net.minecraft.item.ItemStack;
import uk.co.wehavecookies56.kk.api.materials.Material;
import uk.co.wehavecookies56.kk.api.materials.MaterialRegistry;
import uk.co.wehavecookies56.kk.api.recipes.Recipe;
import uk.co.wehavecookies56.kk.common.item.ModItems;
import uk.co.wehavecookies56.kk.common.lib.Strings;

import java.util.HashMap;
import java.util.Map;

public class RecipeNightmaresEnd extends Recipe {

    public String name;

    public RecipeNightmaresEnd (String name) {
        this.name = name;
    }

    @Override
    public String getName () {
        return name;
    }

    @Override
    public ItemStack getResult () {
        return new ItemStack(ModItems.Chain_NightmaresEnd);
    }

    @Override
    public Map<Material, Integer> getRequirements () {
        Map<Material, Integer> reqs = new HashMap<Material, Integer>();
        reqs.put(MaterialRegistry.get(Strings.SM_BrightShard), 3);
        reqs.put(MaterialRegistry.get(Strings.SM_BrightStone), 2);
        reqs.put(MaterialRegistry.get(Strings.SM_BrightGem), 6);
        reqs.put(MaterialRegistry.get(Strings.SM_BrightCrystal), 4);
        reqs.put(MaterialRegistry.get(Strings.SM_Orichalcum), 1);
        return reqs;
    }

}
