package wehavecookies56.kk.materials;

import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import wehavecookies56.kk.api.materials.Material;
import wehavecookies56.kk.block.ModBlocks;
import wehavecookies56.kk.item.ModItems;
import wehavecookies56.kk.lib.Reference;
import wehavecookies56.kk.lib.Strings;
import wehavecookies56.kk.util.ItemStacks;

public class MaterialMetalBlox extends Material {

	String name;

	public MaterialMetalBlox(String name) {
		this.name = name;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public ItemStack getItem() {
		ItemStack stack = new ItemStack(ModBlocks.MetalBlox);
		return stack;
	}

	@Override
	public ResourceLocation getTexture() {
		return null;
	}

}
