package uk.co.wehavecookies56.kk.api.recipes;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.common.collect.ImmutableMap;

import net.minecraft.entity.player.EntityPlayer;
import uk.co.wehavecookies56.kk.common.capability.ModCapabilities;

public class RecipeRegistry {

    private static Map<String, Recipe> recipeMap = new HashMap<String, Recipe>();

    public static Map<String, Recipe> getRecipeMap () {
        return ImmutableMap.copyOf(recipeMap);
    }

    public static boolean registerRecipe (Recipe recipe) {
        if (isRecipeRegistered(recipe.getName())) return false;
        recipeMap.put(recipe.getName(), recipe);
        return true;
    }

    public static boolean isRecipeRegistered (Recipe recipe) {
        return isRecipeRegistered(recipe.getName());
    }

    public static boolean isRecipeRegistered (String name) {
        return recipeMap.containsKey(name);
    }

    public static Recipe get (String name) {
        return recipeMap.get(name);
    }

    public static boolean learnRecipe (List<String> list, EntityPlayer player, String recipeName) {
        if (!isRecipeKnown(list, recipeName)) {
            Recipe recipe = recipeMap.get(recipeName);
            player.getCapability(ModCapabilities.SYNTHESIS_RECIPES, null).learnRecipe(recipe);
            return true;
        }
        return false;
    }

    public static boolean isRecipeKnown (List<String> recipeList, String name) {
        return recipeList.contains(name);
    }

}
