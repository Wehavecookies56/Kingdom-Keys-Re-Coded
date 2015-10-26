package wehavecookies56.kk.materials;

import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import wehavecookies56.kk.api.materials.Material;
import wehavecookies56.kk.item.ModItems;
import wehavecookies56.kk.lib.Reference;
import wehavecookies56.kk.lib.Strings;
import wehavecookies56.kk.util.ItemStacks;

public class MaterialLightningStone extends Material {

	String name;

	public MaterialLightningStone(String name) {
		this.name = name;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public ItemStack getItem() {
		ItemStack stack = new ItemStack(ModItems.SynthesisMaterial);
		ItemStacks.createSynthesisItem(stack, Strings.SM_LightningStone, "B");
		return stack;
	}

	@Override
	public ResourceLocation getTexture() {
		return new ResourceLocation(Reference.MODID, "textures/gui/synthesis/lightningstone.png");
	}

}
