package uk.co.wehavecookies56.kk.common.crafting;

import net.minecraft.item.ItemStack;
import net.minecraftforge.common.crafting.IngredientNBT;

import javax.annotation.Nullable;

public class IngredientSynthesisMaterial extends IngredientNBT {

    private final ItemStack stack;

    IngredientSynthesisMaterial(ItemStack stack) {
        super(stack);
        this.stack = stack;
    }

    @Override
    public boolean apply(@Nullable ItemStack input) {
        if (input == null)
            return false;
        if (ItemStack.areItemStacksEqual(this.stack, input)) {
            if (input.getItem() == stack.getItem()) {
                if (input.getTagCompound() != null && stack.getTagCompound() != null) {
                    if (input.getTagCompound().getString("material").equals(stack.getTagCompound().getString("material"))) {
                        if (input.getTagCompound().getString("rank").equals(stack.getTagCompound().getString("rank"))) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }
}