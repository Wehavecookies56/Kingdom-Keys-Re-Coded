package uk.co.wehavecookies56.kk.common.synthesis.recipe;

import net.minecraft.item.ItemStack;
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
public class RecipeMythrilShard extends Recipe {

    public String name;

    public RecipeMythrilShard(String name) {
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
        stack.getTagCompound().setString("material", Strings.SM_MythrilShard);
        stack.getTagCompound().setString("rank", Strings.SM_Rank_C);
        return stack;
    }

    @Override
    public Map<Material, Integer> getRequirements () {
        Map<Material, Integer> reqs = new HashMap<Material, Integer>();
        reqs.put(MaterialRegistry.get(Strings.SM_DenseStone), 1);
        reqs.put(MaterialRegistry.get(Strings.SM_DenseShard), 3);
        reqs.put(MaterialRegistry.get(Strings.SM_TwilightStone), 1);
        reqs.put(MaterialRegistry.get(Strings.SM_TwilightShard), 3);
        return reqs;
    }

}
