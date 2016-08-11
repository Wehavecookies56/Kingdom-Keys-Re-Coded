package uk.co.wehavecookies56.kk.common.item.base;

import java.util.Collections;
import java.util.List;
import java.util.Random;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.relauncher.Side;
import uk.co.wehavecookies56.kk.api.recipes.RecipeRegistry;
import uk.co.wehavecookies56.kk.common.capability.ModCapabilities;
import uk.co.wehavecookies56.kk.common.capability.SynthesisRecipeCapability;
import uk.co.wehavecookies56.kk.common.core.helper.TextHelper;
import uk.co.wehavecookies56.kk.common.lib.Lists;
import uk.co.wehavecookies56.kk.common.network.packet.PacketDispatcher;
import uk.co.wehavecookies56.kk.common.network.packet.server.UseRecipe;
import uk.co.wehavecookies56.kk.common.util.Utils;

public class ItemRecipe extends Item {

	public ItemRecipe () {
		setMaxStackSize(1);
	}

	@Override
	public ActionResult<ItemStack> onItemRightClick(ItemStack stack, World world, EntityPlayer player,
													EnumHand hand) {
		if (FMLCommonHandler.instance().getEffectiveSide() == Side.CLIENT) {
			PacketDispatcher.sendToServer(new UseRecipe(stack.getTagCompound().getString("recipe1"), stack.getTagCompound().getString("recipe2"), stack.getTagCompound().getString("recipe3")));
			return super.onItemRightClick(stack, world, player, hand);
		} else if (FMLCommonHandler.instance().getEffectiveSide() == Side.SERVER) {
			String recipe1 = stack.getTagCompound().getString("recipe1");
			String recipe2 = stack.getTagCompound().getString("recipe2");
			String recipe3 = stack.getTagCompound().getString("recipe3");

			SynthesisRecipeCapability.ISynthesisRecipe RECIPES = player.getCapability(ModCapabilities.SYNTHESIS_RECIPES, null);

			boolean consume = false;
			if (RecipeRegistry.get(recipe1) == null) {}
			else if (RecipeRegistry.isRecipeKnown(RECIPES.getKnownRecipes(), recipe1)) {}
			else
				consume = true;
			if (RecipeRegistry.get(recipe2) == null) {}
			else if (RecipeRegistry.isRecipeKnown(RECIPES.getKnownRecipes(), recipe2)) {}
			else
				consume = true;
			if (RecipeRegistry.get(recipe3) == null) {}
			else if (RecipeRegistry.isRecipeKnown(RECIPES.getKnownRecipes(), recipe3)) {}
			else
				consume = true;

			if(RecipeRegistry.isRecipeKnown(RECIPES.getKnownRecipes(), recipe1) && RecipeRegistry.isRecipeKnown(RECIPES.getKnownRecipes(), recipe2) && RecipeRegistry.isRecipeKnown(RECIPES.getKnownRecipes(), recipe3))
			{
				shuffleRecipes(stack, player);
			}
			if (consume)
			{stack.stackSize--;}

		}
		return super.onItemRightClick(stack, world, player, hand);
	}

	public void shuffleRecipes(ItemStack stack, EntityPlayer player) //TODO Test this
	{
		SynthesisRecipeCapability.ISynthesisRecipe RECIPES = player.getCapability(ModCapabilities.SYNTHESIS_RECIPES, null);

		long seed = System.nanoTime();
		// Shuffles the list of recipe to increase randomness
		Collections.shuffle(Lists.recipes, new Random(seed));
		String Recipe1, Recipe2, Recipe3;

		Recipe1 = Lists.recipes.get(Utils.randomWithRange(0, Lists.recipes.size() - 1));
		if(RECIPES.getKnownRecipes().size() < 118)
		{
			while(RecipeRegistry.isRecipeKnown(RECIPES.getKnownRecipes(), Recipe1))
				Recipe1 = Lists.recipes.get(Utils.randomWithRange(0, Lists.recipes.size() - 1));
		}
		Recipe2 = Lists.recipes.get(Utils.randomWithRange(0, Lists.recipes.size() - 1));
		if(RECIPES.getKnownRecipes().size() < 119)
		{
			while (Recipe2.equals(Recipe1) || RecipeRegistry.isRecipeKnown(RECIPES.getKnownRecipes(), Recipe2))
				Recipe2 = Lists.recipes.get(Utils.randomWithRange(0, Lists.recipes.size() - 1));
		}
		Recipe3 = Lists.recipes.get(Utils.randomWithRange(0, Lists.recipes.size() - 1));
		if(RECIPES.getKnownRecipes().size() < 120)
		{
			while ((Recipe3.equals(Recipe2) || Recipe3.equals(Recipe1)) || RecipeRegistry.isRecipeKnown(RECIPES.getKnownRecipes(), Recipe3))
				Recipe3 = Lists.recipes.get(Utils.randomWithRange(0, Lists.recipes.size() - 1));
		}


		stack.setTagCompound(new NBTTagCompound());
		stack.getTagCompound().setString("recipe1", Recipe1);
		stack.getTagCompound().setString("recipe2", Recipe2);
		stack.getTagCompound().setString("recipe3", Recipe3);
	}

	@Override
	public void onUpdate (ItemStack stack, World worldIn, Entity entityIn, int itemSlot, boolean isSelected) {
		if (!stack.hasTagCompound()) {
			shuffleRecipes(stack, (EntityPlayer) entityIn);
		}
	}

	@Override
	public void addInformation (ItemStack stack, EntityPlayer playerIn, List<String> tooltip, boolean advanced) {
		// Make sure it has NBT data
		if (stack.hasTagCompound()) {
			// Get NBT data that was set
			String recipe1 = stack.getTagCompound().getString("recipe1");
			String recipe2 = stack.getTagCompound().getString("recipe2");
			String recipe3 = stack.getTagCompound().getString("recipe3");

			// Add Strings to the tooltip
			tooltip.add(Utils.translateToLocal(recipe1 + ".name"));
			tooltip.add(Utils.translateToLocal(recipe2 + ".name"));
			tooltip.add(Utils.translateToLocal(recipe3 + ".name"));
		}
	}
}