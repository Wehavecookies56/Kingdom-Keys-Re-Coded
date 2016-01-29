package wehavecookies56.kk.materials;

import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import wehavecookies56.kk.api.materials.Material;
import wehavecookies56.kk.block.ModBlocks;

public class MaterialHardBlox extends Material {

	String name;

	public MaterialHardBlox (String name) {
		this.name = name;
	}

	@Override
	public String getName () {
		return name;
	}

	@Override
	public ItemStack getItem () {
		ItemStack stack = new ItemStack(ModBlocks.HardBlox);
		return stack;
	}

	@Override
	public ResourceLocation getTexture () {
		return null;
	}

}
