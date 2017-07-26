package uk.co.wehavecookies56.kk.common.crafting;

import javax.annotation.Nonnull;

import com.google.gson.JsonObject;

import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.JsonUtils;
import net.minecraftforge.common.crafting.IIngredientFactory;
import net.minecraftforge.common.crafting.JsonContext;
import uk.co.wehavecookies56.kk.common.item.ModItems;

public class SynthesisMaterialFactory implements IIngredientFactory {

    @Nonnull
    @Override
    public Ingredient parse(JsonContext context, JsonObject json) {
        final ItemStack stack = new ItemStack(ModItems.SynthesisMaterial);

        String material = JsonUtils.getString(json, "material", "");
        String rank = JsonUtils.getString(json, "rank", "");

        stack.setTagCompound(new NBTTagCompound());
        if (stack.getTagCompound() != null) {
            stack.getTagCompound().setString("material", material);
            stack.getTagCompound().setString("rank", rank);
        }
        return new IngredientNBT(stack);
    }

}
