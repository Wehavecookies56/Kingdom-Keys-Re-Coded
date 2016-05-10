package uk.co.wehavecookies56.kk.common.synthesis.material;

import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import uk.co.wehavecookies56.kk.api.materials.Material;
import uk.co.wehavecookies56.kk.common.item.ItemStacks;
import uk.co.wehavecookies56.kk.common.item.ModItems;
import uk.co.wehavecookies56.kk.common.lib.Reference;
import uk.co.wehavecookies56.kk.common.lib.Strings;

public class MaterialEnergyGem extends Material {

	String name;

	public MaterialEnergyGem (String name) {
		this.name = name;
	}

	@Override
	public String getName () {
		return name;
	}

	@Override
	public ItemStack getItem () {
		ItemStack stack = new ItemStack(ModItems.SynthesisMaterial);
		ItemStacks.createSynthesisItem(stack, Strings.SM_EnergyGem, "A");
		return stack;
	}

	@Override
	public ResourceLocation getTexture () {
		return new ResourceLocation(Reference.MODID, "textures/gui/synthesis/energygem.png");
	}

}
