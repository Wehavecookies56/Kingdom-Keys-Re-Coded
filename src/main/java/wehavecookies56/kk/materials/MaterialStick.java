package wehavecookies56.kk.materials;

import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import wehavecookies56.kk.api.materials.Material;

public class MaterialStick extends Material {

	String name;

	public MaterialStick(String name) {
		this.name = name;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public ItemStack getItem() {
		ItemStack stack = new ItemStack(Items.stick);
		return stack;
	}

	@Override
	public ResourceLocation getTexture() {
		return null;
	}

}
