package uk.co.wehavecookies56.kk.common.item.base;

import java.util.Collections;
import java.util.List;
import java.util.Random;

import javax.annotation.Nullable;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.relauncher.Side;
import uk.co.wehavecookies56.kk.api.recipes.RecipeRegistry;
import uk.co.wehavecookies56.kk.common.capability.ModCapabilities;
import uk.co.wehavecookies56.kk.common.capability.SynthesisRecipeCapability;
import uk.co.wehavecookies56.kk.common.lib.Lists;
import uk.co.wehavecookies56.kk.common.network.packet.PacketDispatcher;
import uk.co.wehavecookies56.kk.common.network.packet.server.UseRecipe;
import uk.co.wehavecookies56.kk.common.util.Utils;

public class ItemRecipe extends ItemKKBase {

	public ItemRecipe(String name) {
		super(name);
		setMaxStackSize(1);
	}

	@Override
	public ActionResult<ItemStack> onItemRightClick(World world, EntityPlayer player, EnumHand hand) {
		if (hand == EnumHand.MAIN_HAND) {
			String[] recipes = null;
			if (FMLCommonHandler.instance().getEffectiveSide() == Side.CLIENT) {
				PacketDispatcher.sendToServer(new UseRecipe(player.getHeldItemMainhand().getTagCompound().getString("recipe1"), player.getHeldItemMainhand().getTagCompound().getString("recipe2"), player.getHeldItemMainhand().getTagCompound().getString("recipe3")));
				return ActionResult.newResult(EnumActionResult.SUCCESS, player.getHeldItemMainhand());
			} else if (FMLCommonHandler.instance().getEffectiveSide() == Side.SERVER) {
				recipes = new String[] { player.getHeldItemMainhand().getTagCompound().getString("recipe1"), player.getHeldItemMainhand().getTagCompound().getString("recipe2"), player.getHeldItemMainhand().getTagCompound().getString("recipe3") };
			}

			SynthesisRecipeCapability.ISynthesisRecipe RECIPES = player.getCapability(ModCapabilities.SYNTHESIS_RECIPES, null);

			boolean consume = false;

			for (String recipe : recipes) {
				if (RecipeRegistry.get(recipe) != null && !RecipeRegistry.isRecipeKnown(RECIPES.getKnownRecipes(), recipe)) {
					consume = true;
				}
			}

			if (consume) {
				player.getHeldItemMainhand().setCount(player.getHeldItemMainhand().getCount() - 1);
			} else {
				shuffleRecipes(player.getHeldItemMainhand(), player);
			}
		}
		return super.onItemRightClick(world, player, hand);
	}

	public void shuffleRecipes(ItemStack stack, EntityPlayer player) {
		SynthesisRecipeCapability.ISynthesisRecipe RECIPES = player.getCapability(ModCapabilities.SYNTHESIS_RECIPES, null);

		long seed = System.nanoTime();
		// Shuffles the list of recipe to increase randomness
		Collections.shuffle(Lists.recipes, new Random(seed));
		
		String Recipe1, Recipe2, Recipe3;
		
		Recipe1 = Lists.recipes.get(Utils.randomWithRange(0, Lists.recipes.size() - 1));
		
		if (RECIPES.getKnownRecipes().size() < Lists.recipes.size() - 2) {
			while (RecipeRegistry.isRecipeKnown(RECIPES.getKnownRecipes(), Recipe1)) {
				Recipe1 = Lists.recipes.get(Utils.randomWithRange(0, Lists.recipes.size() - 1));
			}
		}
		Recipe2 = Lists.recipes.get(Utils.randomWithRange(0, Lists.recipes.size() - 1));
		if (RECIPES.getKnownRecipes().size() < Lists.recipes.size() - 1) {
			while (Recipe2.equals(Recipe1) || RecipeRegistry.isRecipeKnown(RECIPES.getKnownRecipes(), Recipe2)) {
				Recipe2 = Lists.recipes.get(Utils.randomWithRange(0, Lists.recipes.size() - 1));
			}
		}
		Recipe3 = Lists.recipes.get(Utils.randomWithRange(0, Lists.recipes.size() - 1));
		if (RECIPES.getKnownRecipes().size() < Lists.recipes.size()) {
			while ((Recipe3.equals(Recipe2) || Recipe3.equals(Recipe1)) || RecipeRegistry.isRecipeKnown(RECIPES.getKnownRecipes(), Recipe3)) {
				Recipe3 = Lists.recipes.get(Utils.randomWithRange(0, Lists.recipes.size() - 1));
			}
		}

		stack.setTagCompound(new NBTTagCompound());
		stack.getTagCompound().setString("recipe1", Recipe1);
		stack.getTagCompound().setString("recipe2", Recipe2);
		stack.getTagCompound().setString("recipe3", Recipe3);
	}

	@Override
	public void onUpdate(ItemStack stack, World worldIn, Entity entityIn, int itemSlot, boolean isSelected) {
		if (!stack.hasTagCompound()) {
			shuffleRecipes(stack, (EntityPlayer) entityIn);
		}
	}

	@Override
	public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> tooltip, ITooltipFlag flagIn) {
		if (stack.hasTagCompound()) {
			String recipe1 = stack.getTagCompound().getString("recipe1");
			String recipe2 = stack.getTagCompound().getString("recipe2");
			String recipe3 = stack.getTagCompound().getString("recipe3");

			tooltip.add(Utils.translateToLocal(recipe1 + ".name"));
			tooltip.add(Utils.translateToLocal(recipe2 + ".name"));
			tooltip.add(Utils.translateToLocal(recipe3 + ".name"));
		}
	}
}
