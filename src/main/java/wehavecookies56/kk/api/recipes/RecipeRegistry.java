package wehavecookies56.kk.api.recipes;

import java.util.HashMap;
import java.util.Map;

import com.google.common.collect.ImmutableMap;

import net.minecraft.entity.player.EntityPlayer;
import wehavecookies56.kk.achievements.ModAchievements;
import wehavecookies56.kk.entities.ExtendedPlayerRecipes;
import wehavecookies56.kk.util.AchievementHelper;

public class RecipeRegistry {

	private static Map<String, Recipe> recipeMap = new HashMap<String, Recipe>();

	public static Map<String, Recipe> getRecipeMap() {
		return ImmutableMap.copyOf(recipeMap);
	}

	public static boolean registerRecipe(Recipe recipe) {
		if (isRecipeRegistered(recipe.getName()))
			return false;
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
			ExtendedPlayerRecipes.get(player).learnRecipe(recipe);
			AchievementHelper.addAchievement(player, ModAchievements.getRecipe);
			return true;
		}
		return false;
	}

	public static boolean isRecipeKnown(EntityPlayer player, String name) {
		if (ExtendedPlayerRecipes.get(player) != null)
			return ExtendedPlayerRecipes.get(player).knownRecipes.contains(name);
		return false;
	}

}
