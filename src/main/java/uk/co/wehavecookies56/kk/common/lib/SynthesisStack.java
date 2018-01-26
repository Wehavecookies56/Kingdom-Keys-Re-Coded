package uk.co.wehavecookies56.kk.common.lib;

import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import uk.co.wehavecookies56.kk.common.item.ModItems;

public class SynthesisStack {

    String material;
    String rank;

    public SynthesisStack(String material, String rank) {
        this.material = material;
        this.rank = rank;
    }

    public ItemStack createStack() {
        ItemStack stack = new ItemStack(ModItems.SynthesisMaterial);
        stack.setTagCompound(new NBTTagCompound());
        stack.getTagCompound().setString("material", material);
        stack.getTagCompound().setString("rank", rank);
        return stack;
    }

}
