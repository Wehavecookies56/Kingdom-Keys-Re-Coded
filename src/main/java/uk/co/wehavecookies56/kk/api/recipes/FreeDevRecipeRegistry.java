package uk.co.wehavecookies56.kk.api.recipes;

import com.google.common.collect.ImmutableMap;
import net.minecraft.entity.player.EntityPlayer;
import uk.co.wehavecookies56.kk.common.capability.ModCapabilities;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FreeDevRecipeRegistry {

    private static Map<String, Recipe> freeDevRecipeMap = new HashMap<String, Recipe>();

    public static Map<String, Recipe> getFreeDevRecipeMap () {
        return ImmutableMap.copyOf(freeDevRecipeMap);
    }

    public static boolean registerFreeDevRecipe (Recipe recipe) {
        if (isFreeDevRecipeRegistered(recipe.getName())) return false;
        freeDevRecipeMap.put(recipe.getName(), recipe);
        return true;
    }

    public static boolean isFreeDevRecipeRegistered (Recipe recipe) {
        return isFreeDevRecipeRegistered(recipe.getName());
    }

    public static boolean isFreeDevRecipeRegistered (String name) {
        return freeDevRecipeMap.containsKey(name);
    }

    public static Recipe get (String name) {
        return freeDevRecipeMap.get(name);
    }

    public static boolean learnFreeDevRecipe (List<String> list, EntityPlayer player, String recipeName) {
        if (!isFreeDevRecipeKnown(list, recipeName)) {
            Recipe recipe = freeDevRecipeMap.get(recipeName);
            player.getCapability(ModCapabilities.SYNTHESIS_RECIPES, null).learnFreeDevRecipe(recipe);
            //AchievementHelper.addAchievement(player, ModAchievements.getRecipe);
            return true;
        }
        return false;
    }

    public static boolean isFreeDevRecipeKnown (List<String> recipeList, String name) {
        return recipeList.contains(name);
    }

}
