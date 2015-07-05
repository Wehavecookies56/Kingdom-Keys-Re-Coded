package wehavecookies56.kk.recipes;

import static wehavecookies56.kk.recipes.RecipeRegistry.registerRecipe;

import wehavecookies56.kk.item.ModItems;

public class ModRecipes {

	public static void init(){
		registerRecipe(new RecipeAbaddonPlasma(ModItems.AbaddonPlasma.getUnlocalizedName()));
		registerRecipe(new RecipeAnguisForetellersKeyblade(ModItems.AnguisForetellersKeyblade.getUnlocalizedName()));;
		registerRecipe(new RecipeKingdomKey(ModItems.KingdomKey.getUnlocalizedName()));
		registerRecipe(new RecipeKingdomKeyD(ModItems.KingdomKeyD.getUnlocalizedName()));
	}
}
