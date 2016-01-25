package wehavecookies56.kk.materials;

import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import wehavecookies56.kk.api.materials.Material;

public class MaterialWoodenSword extends Material {

	String name;

	public MaterialWoodenSword(String name) {
		this.name = name;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public ItemStack getItem() {
		ItemStack stack = new ItemStack(Items.wooden_sword);
		return stack;
	}

	@Override
	public ResourceLocation getTexture() {
		return null;
	}

}
