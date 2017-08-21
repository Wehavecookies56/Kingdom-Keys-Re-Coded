package uk.co.wehavecookies56.kk.common.synthesis.recipe;

import net.minecraft.item.ItemStack;
import uk.co.wehavecookies56.kk.api.materials.Material;
import uk.co.wehavecookies56.kk.api.materials.MaterialRegistry;
import uk.co.wehavecookies56.kk.api.recipes.Recipe;
import uk.co.wehavecookies56.kk.common.item.ModItems;
import uk.co.wehavecookies56.kk.common.lib.Strings;

import java.util.HashMap;
import java.util.Map;

public class RecipeLostMemory extends Recipe {

    public String name;

    public RecipeLostMemory (String name) {
        this.name = name;
    }

    @Override
    public String getName () {
        return name;
    }

    @Override
    public ItemStack getResult () {
        return new ItemStack(ModItems.Chain_LostMemory);
    }

    @Override
    public Map<Material, Integer> getRequirements () {
        Map<Material, Integer> reqs = new HashMap<Material, Integer>();
        reqs.put(MaterialRegistry.get(Strings.SM_SerenityShard), 1);
        reqs.put(MaterialRegistry.get(Strings.SM_TwilightGem), 3);
        reqs.put(MaterialRegistry.get(Strings.SM_PowerStone), 2);
        reqs.put(MaterialRegistry.get(Strings.SM_MythrilGem), 3);
        return reqs;
    }

}
