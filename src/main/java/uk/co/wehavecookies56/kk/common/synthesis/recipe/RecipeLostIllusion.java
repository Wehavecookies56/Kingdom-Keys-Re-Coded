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
public class RecipeLostIllusion extends Recipe {

    public String name;

    public RecipeLostIllusion(String name) {
        this.name = name;
    }

    @Override
    public String getName () {
        return name;
    }

    @Override
    public ItemStack getResult () {
        return ModItems.lostIllusion.createStack();
    }

    @Override
    public Map<Material, Integer> getRequirements () {
        Map<Material, Integer> reqs = new HashMap<Material, Integer>();
        reqs.put(MaterialRegistry.get(Strings.SM_ManifestIllusion), 1);
        reqs.put(MaterialRegistry.get(Strings.SM_OrichalcumPlus), 1);
        reqs.put(MaterialRegistry.get(Strings.SM_RemembranceCrystal), 5);
        return reqs;
    }

}
