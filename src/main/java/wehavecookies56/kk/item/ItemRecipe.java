package wehavecookies56.kk.item;

import java.util.Collections;
import java.util.List;
import java.util.Random;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.relauncher.Side;
import wehavecookies56.kk.api.recipes.RecipeRegistry;
import wehavecookies56.kk.entities.ExtendedPlayerRecipes;
import wehavecookies56.kk.lib.Lists;
import wehavecookies56.kk.network.packet.PacketDispatcher;
import wehavecookies56.kk.network.packet.server.UseRecipe;
import wehavecookies56.kk.util.TextHelper;

public class ItemRecipe extends Item {

	public ItemRecipe() {
		setMaxStackSize(1);
	}

	@Override
	public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player) {
		// Send packet to process the recipe registering and remove it from the
		// player's inventory
		if (FMLCommonHandler.instance().getEffectiveSide() == Side.CLIENT) {
			ExtendedPlayerRecipes.get(player);
			ExtendedPlayerRecipes.loadProxyData((player));
			PacketDispatcher.sendToServer(new UseRecipe(stack.getTagCompound().getString("recipe1"),
					stack.getTagCompound().getString("recipe2"), stack.getTagCompound().getString("recipe3")));
			return stack;
		} else if (FMLCommonHandler.instance().getEffectiveSide() == Side.SERVER) {
			String recipe1 = stack.getTagCompound().getString("recipe1");
			String recipe2 = stack.getTagCompound().getString("recipe2");
			String recipe3 = stack.getTagCompound().getString("recipe3");

			boolean consume = false;
			if (RecipeRegistry.get(recipe1) == null) {
			} else if (RecipeRegistry.isRecipeKnown(player, recipe1)) {
			} else
				consume = true;
			if (RecipeRegistry.get(recipe2) == null) {
			} else if (RecipeRegistry.isRecipeKnown(player, recipe2)) {
			} else
				consume = true;
			if (RecipeRegistry.get(recipe3) == null) {
			} else if (RecipeRegistry.isRecipeKnown(player, recipe3)) {
			} else
				consume = true;

			if (consume)
				stack.stackSize--;

		}
		return stack;
	}

	@Override
	public void onUpdate(ItemStack stack, World worldIn, Entity entityIn, int itemSlot, boolean isSelected) {
		if (!stack.hasTagCompound()) {
			long seed = System.nanoTime();
			// Shuffles the list of recipes to increase randomness
			Collections.shuffle(Lists.recipes, new Random(seed));
			String Recipe1 = Lists.recipes.get(randomWithRange(0, Lists.recipes.size() - 1));
			String Recipe2 = Lists.recipes.get(randomWithRange(0, Lists.recipes.size() - 1));
			// Generate a new random value for the second recipe until it's not
			// equal the first
			while (Recipe2.equals(Recipe1))
				Recipe2 = Lists.recipes.get(randomWithRange(0, Lists.recipes.size() - 1));
			// Generate a new random value for the third recipe until it's not
			// equal the first or the second
			String Recipe3 = Lists.recipes.get(randomWithRange(0, Lists.recipes.size() - 1));
			while (Recipe3.equals(Recipe2) || Recipe3.equals(Recipe1))
				Recipe3 = Lists.recipes.get(randomWithRange(0, Lists.recipes.size() - 1));
			// Set values to NBT data
			stack.setTagCompound(new NBTTagCompound());
			stack.getTagCompound().setString("recipe1", Recipe1);
			stack.getTagCompound().setString("recipe2", Recipe2);
			stack.getTagCompound().setString("recipe3", Recipe3);
		}

	}

	/**
	 * Generates a random number between 2 values, min and max can be swapped
	 */
	public int randomWithRange(int min, int max) {
		int range = Math.abs(max - min) + 1;
		return (int) (Math.random() * range) + (min <= max ? min : max);
	}

	@Override
	public void addInformation(ItemStack stack, EntityPlayer playerIn, List tooltip, boolean advanced) {
		// Make sure it has NBT data
		if (stack.hasTagCompound()) {
			// Get NBT data that was set
			String recipe1 = stack.getTagCompound().getString("recipe1");
			String recipe2 = stack.getTagCompound().getString("recipe2");
			String recipe3 = stack.getTagCompound().getString("recipe3");

			// Add Strings to the tooltip
			tooltip.add(TextHelper.localize(recipe1 + ".name"));
			tooltip.add(TextHelper.localize(recipe2 + ".name"));
			tooltip.add(TextHelper.localize(recipe3 + ".name"));
		}
	}
}
