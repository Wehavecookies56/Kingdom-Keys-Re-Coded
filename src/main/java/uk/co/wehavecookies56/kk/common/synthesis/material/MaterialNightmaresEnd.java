package uk.co.wehavecookies56.kk.common.synthesis.material;

import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import uk.co.wehavecookies56.kk.api.materials.Material;
import uk.co.wehavecookies56.kk.common.item.ModItems;

public class MaterialNightmaresEnd extends Material {

	String name;

	public MaterialNightmaresEnd (String name) {
		this.name = name;
	}

	@Override
	public String getName () {
		return name;
	}

	@Override
	public ItemStack getItem () {
		ItemStack stack = new ItemStack(ModItems.Chain_NightmaresEnd);
		return stack;
	}

	@Override
	public ResourceLocation getTexture () {
		return null;
	}

}
