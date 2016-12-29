package uk.co.wehavecookies56.kk.common.item;

import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;

public class ItemStacks {

	public static void createSynthesisItem (ItemStack stack, String material, String rank) {
		stack.setTagCompound(new NBTTagCompound());
		stack.getTagCompound().setString("material", material);
		stack.getTagCompound().setString("rank", rank);
	}

	public static void createMunnyStack (ItemStack stack, int amount) {
		stack.setTagCompound(new NBTTagCompound());
		stack.getTagCompound().setInteger("amount", amount);
	}

	public static void createRecipeStack (ItemStack stack, String recipe1, String recipe2, String recipe3) {
		stack.setTagCompound(new NBTTagCompound());
		stack.getTagCompound().setString("recipe1", recipe1);
		stack.getTagCompound().setString("recipe2", recipe2);
		stack.getTagCompound().setString("recipe3", recipe3);
	}
}
