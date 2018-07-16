package uk.co.wehavecookies56.kk.common.synthesis.recipe;

import java.util.HashMap;
import java.util.Map;

import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import uk.co.wehavecookies56.kk.api.materials.Material;
import uk.co.wehavecookies56.kk.api.materials.MaterialRegistry;
import uk.co.wehavecookies56.kk.api.recipes.Recipe;
import uk.co.wehavecookies56.kk.common.item.ModItems;
import uk.co.wehavecookies56.kk.common.lib.Strings;

/**
 * Created by Toby on 16/07/2016.
 */
public class RecipeMythrilGem extends Recipe {

    public String name;

    public RecipeMythrilGem(String name) {
        this.name = name;
    }

    @Override
    public String getName () {
        return name;
    }

    @Override
    public ItemStack getResult () {
        ItemStack stack = new ItemStack(ModItems.SynthesisMaterial);
        stack.setTagCompound(new NBTTagCompound());
        stack.getTagCompound().setString("material", Strings.SM_MythrilGem);
        stack.getTagCompound().setString("rank", Strings.SM_Rank_A);
        return stack;
    }

    @Override
    public Map<Material, Integer> getRequirements () {
        Map<Material, Integer> reqs = new HashMap<Material, Integer>();
        reqs.put(MaterialRegistry.get(Strings.SM_DenseCrystal), 1);
        reqs.put(MaterialRegistry.get(Strings.SM_DenseGem), 3);
        reqs.put(MaterialRegistry.get(Strings.SM_TwilightStone), 1);
        reqs.put(MaterialRegistry.get(Strings.SM_TwilightShard), 3);
        reqs.put(MaterialRegistry.get(Strings.SM_SerenityShard), 1);
        return reqs;
    }

}
