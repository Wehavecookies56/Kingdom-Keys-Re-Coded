package uk.co.wehavecookies56.kk.common.synthesis.recipe;

import java.util.HashMap;
import java.util.Map;

import net.minecraft.item.ItemStack;
import uk.co.wehavecookies56.kk.api.materials.Material;
import uk.co.wehavecookies56.kk.api.materials.MaterialRegistry;
import uk.co.wehavecookies56.kk.api.recipes.Recipe;
import uk.co.wehavecookies56.kk.common.item.ModItems;
import uk.co.wehavecookies56.kk.common.lib.Strings;

public class RecipeYoungXehanortsKeyblade extends Recipe {

    public String name;

    public RecipeYoungXehanortsKeyblade (String name) {
        this.name = name;
    }

    @Override
    public String getName () {
        return name;
    }

    @Override
    public ItemStack getResult () {
        return new ItemStack(ModItems.Chain_YoungXehanortsKeyblade);
    }

    @Override
    public Map<Material, Integer> getRequirements () {
        Map<Material, Integer> reqs = new HashMap<Material, Integer>();
        reqs.put(MaterialRegistry.get(Strings.SM_DarkCrystal), 10);
        reqs.put(MaterialRegistry.get(Strings.SM_FrostShard), 5);
        reqs.put(MaterialRegistry.get(Strings.SM_DarkGem), 10);
        reqs.put(MaterialRegistry.get(Strings.SM_LucidCrystal), 3);
        reqs.put(MaterialRegistry.get(Strings.SM_MythrilCrystal), 3);
        return reqs;
    }

}
