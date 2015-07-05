package wehavecookies56.kk.recipes;

import static wehavecookies56.kk.recipes.RecipeRegistry.registerRecipe;

import wehavecookies56.kk.item.ModItems;

public class ModRecipes {

	public static void init(){
		registerRecipe(new RecipeAbaddonPlasma(ModItems.AbaddonPlasma.getUnlocalizedName()));
		registerRecipe(new RecipeAbyssalTide(ModItems.AbyssalTide.getUnlocalizedName()));
		registerRecipe(new RecipeAllforOne(ModItems.AllforOne.getUnlocalizedName()));
		registerRecipe(new RecipeAnguisForetellersKeyblade(ModItems.AnguisForetellersKeyblade.getUnlocalizedName()));
		registerRecipe(new RecipeAstralBlast(ModItems.AstralBlast.getUnlocalizedName()));
		registerRecipe(new RecipeAubade(ModItems.Aubade.getUnlocalizedName()));
		registerRecipe(new RecipeBondofFlame(ModItems.BondofFlame.getUnlocalizedName()));
		registerRecipe(new RecipeBrightcrest(ModItems.Brightcrest.getUnlocalizedName()));
		registerRecipe(new RecipeChaosRipper(ModItems.ChaosRipper.getUnlocalizedName()));
		registerRecipe(new RecipeCircleofLife(ModItems.CircleofLife.getUnlocalizedName()));
		registerRecipe(new RecipeCounterpoint(ModItems.Counterpoint.getUnlocalizedName()));
		registerRecipe(new RecipeCrabclaw(ModItems.Crabclaw.getUnlocalizedName()));
		/*registerRecipe(new RecipeBrightcrest(ModItems.Brightcrest.getUnlocalizedName()));
		registerRecipe(new RecipeBrightcrest(ModItems.Brightcrest.getUnlocalizedName()));*/
		
		registerRecipe(new RecipeKingdomKey(ModItems.KingdomKey.getUnlocalizedName()));
		registerRecipe(new RecipeKingdomKeyD(ModItems.KingdomKeyD.getUnlocalizedName()));
	}
}
