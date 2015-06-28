package wehavecookies56.kk.recipes;

import java.util.HashMap;
import java.util.Map;

import wehavecookies56.kk.entities.ExtendedPlayer;

import net.minecraft.entity.player.EntityPlayer;

import com.google.common.collect.ImmutableMap;

public class RecipeRegistry {

	private static Map<String, Recipe> recipeMap = new HashMap<String, Recipe>();

	public static Map<String, Recipe> getRecipeMap() {
		return ImmutableMap.copyOf(recipeMap);
	}

	public static boolean registerRecipe(Recipe recipe) {
		if (isRecipeRegistered(recipe.getName())) {
			return false;
		}
		recipeMap.put(recipe.getName(), recipe);
		return true;
	}

	public static boolean isRecipeRegistered(Recipe recipe) {
		return isRecipeRegistered(recipe.getName());
	}

	public static boolean isRecipeRegistered(String name) {
		return recipeMap.containsKey(name);
	}

	public static Recipe get(String name) {
		return recipeMap.get(name);
	}

	public static boolean learnrecipe(EntityPlayer player, String recipeName) {
		if (player != null && !isRecipeKnown(player, recipeName)) {
			Recipe recipe = recipeMap.get(recipeName);
			ExtendedPlayer.get(player).learnRecipe(recipe);
			return true;
		}
		return false;
	}

	public static boolean isRecipeKnown(EntityPlayer player, String name) {
		if (ExtendedPlayer.get(player) != null) {
			return ExtendedPlayer.get(player).knownRecipes.contains(name);
		}
		return false;
	}

}
