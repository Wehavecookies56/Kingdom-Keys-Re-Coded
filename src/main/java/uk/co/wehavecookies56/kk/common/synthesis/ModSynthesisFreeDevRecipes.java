package uk.co.wehavecookies56.kk.common.synthesis;

import static uk.co.wehavecookies56.kk.api.recipes.FreeDevRecipeRegistry.registerFreeDevRecipe;

import uk.co.wehavecookies56.kk.common.item.ModItems;
import uk.co.wehavecookies56.kk.common.lib.Strings;
import uk.co.wehavecookies56.kk.common.synthesis.recipe.*;

/**
 * Created by Toby on 16/07/2016.
 */
public class ModSynthesisFreeDevRecipes {

    public static void init() {
        registerFreeDevRecipe(new RecipeDriveRecovery(ModItems.DriveRecovery.getTranslationKey()));
        registerFreeDevRecipe(new RecipeHighDriveRecovery(ModItems.HighDriveRecovery.getTranslationKey()));
        registerFreeDevRecipe(new RecipeMythrilShard(Strings.SM_MythrilShard));
        registerFreeDevRecipe(new RecipeMythrilStone(Strings.SM_MythrilStone));
        registerFreeDevRecipe(new RecipeMythrilGem(Strings.SM_MythrilGem));
        registerFreeDevRecipe(new RecipeMythrilCrystal(Strings.SM_MythrilCrystal));
        registerFreeDevRecipe(new RecipePotion(ModItems.Potion.getTranslationKey()));
        registerFreeDevRecipe(new RecipeHiPotion(ModItems.HiPotion.getTranslationKey()));
        registerFreeDevRecipe(new RecipeMegaPotion(ModItems.MegaPotion.getTranslationKey()));
        registerFreeDevRecipe(new RecipeEther(ModItems.Ether.getTranslationKey()));
        registerFreeDevRecipe(new RecipeMegaEther(ModItems.MegaEther.getTranslationKey()));
        registerFreeDevRecipe(new RecipeElixir(ModItems.Elixir.getTranslationKey()));
        registerFreeDevRecipe(new RecipeMegalixir(ModItems.Megalixir.getTranslationKey()));
        registerFreeDevRecipe(new RecipeDefenseBoost(ModItems.DefenseBoost.getTranslationKey()));
        registerFreeDevRecipe(new RecipePowerBoost(ModItems.PowerBoost.getTranslationKey()));
        registerFreeDevRecipe(new RecipeAPBoost(ModItems.APBoost.getTranslationKey()));
        registerFreeDevRecipe(new RecipeMagicBoost(ModItems.MagicBoost.getTranslationKey()));
        registerFreeDevRecipe(new RecipePanacea(ModItems.Panacaea.getTranslationKey()));
        registerFreeDevRecipe(new RecipeManifestIllusion(Strings.SM_ManifestIllusion));
        registerFreeDevRecipe(new RecipeLostIllusion(Strings.SM_LostIllusion));
    }

}
