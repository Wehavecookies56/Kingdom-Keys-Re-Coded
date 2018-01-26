package uk.co.wehavecookies56.kk.common.synthesis.recipe;

import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
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
public class RecipeManifestIllusion extends Recipe {

    public String name;

    public RecipeManifestIllusion(String name) {
        this.name = name;
    }

    @Override
    public String getName () {
        return name;
    }

    @Override
    public ItemStack getResult () {
        return ModItems.manifestIllusion.createStack();
    }

    @Override
    public Map<Material, Integer> getRequirements () {
        Map<Material, Integer> reqs = new HashMap<Material, Integer>();
        reqs.put(MaterialRegistry.get(Strings.SM_EnergyCrystal), 2);
        reqs.put(MaterialRegistry.get(Strings.SM_StormyCrystal), 2);
        reqs.put(MaterialRegistry.get(Strings.SM_TwilightCrystal), 2);
        reqs.put(MaterialRegistry.get(Strings.SM_Orichalcum), 4);
        return reqs;
    }

}
