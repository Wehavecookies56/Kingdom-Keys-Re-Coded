package uk.co.wehavecookies56.kk.common.synthesis.material;

import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import uk.co.wehavecookies56.kk.api.materials.Material;
import uk.co.wehavecookies56.kk.common.item.ModItems;

public class MaterialMirageSplit extends Material {

    String name;

    public MaterialMirageSplit (String name) {
        this.name = name;
    }

    @Override
    public String getName () {
        return name;
    }

    @Override
    public ItemStack getItem () {
        ItemStack stack = new ItemStack(ModItems.Chain_MirageSplit);
        return stack;
    }

    @Override
    public ResourceLocation getTexture () {
        return null;
    }

}
