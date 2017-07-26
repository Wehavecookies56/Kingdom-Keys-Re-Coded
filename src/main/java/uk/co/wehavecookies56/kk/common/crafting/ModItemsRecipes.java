package uk.co.wehavecookies56.kk.common.crafting;

import net.minecraft.item.ItemStack;
import net.minecraftforge.common.brewing.BrewingRecipeRegistry;
import uk.co.wehavecookies56.kk.common.item.ModItems;

public class ModItemsRecipes {

    public static void init () {

        BrewingRecipeRegistry.addRecipe(new ItemStack(ModItems.EmptyBottle), new ItemStack(ModItems.HpOrb), new ItemStack(ModItems.Potion));
        BrewingRecipeRegistry.addRecipe(new ItemStack(ModItems.EmptyBottle), new ItemStack(ModItems.MagicOrb), new ItemStack(ModItems.Ether));
        BrewingRecipeRegistry.addRecipe(new ItemStack(ModItems.Ether), new ItemStack(ModItems.MagicOrb), new ItemStack(ModItems.MegaEther));
        BrewingRecipeRegistry.addRecipe(new ItemStack(ModItems.EmptyBottle), new ItemStack(ModItems.Ether), new ItemStack(ModItems.MegaEther));
        BrewingRecipeRegistry.addRecipe(new ItemStack(ModItems.Potion), new ItemStack(ModItems.MagicOrb), new ItemStack(ModItems.Elixir));
        BrewingRecipeRegistry.addRecipe(new ItemStack(ModItems.Ether), new ItemStack(ModItems.HpOrb), new ItemStack(ModItems.Elixir));
        BrewingRecipeRegistry.addRecipe(new ItemStack(ModItems.MegaEther), new ItemStack(ModItems.HiPotion), new ItemStack(ModItems.Megalixir));
        BrewingRecipeRegistry.addRecipe(new ItemStack(ModItems.EmptyBottle), new ItemStack(ModItems.Potion), new ItemStack(ModItems.HiPotion));
        BrewingRecipeRegistry.addRecipe(new ItemStack(ModItems.Potion), new ItemStack(ModItems.HpOrb), new ItemStack(ModItems.HiPotion));
        BrewingRecipeRegistry.addRecipe(new ItemStack(ModItems.EmptyBottle), new ItemStack(ModItems.HiPotion), new ItemStack(ModItems.MegaPotion));
        BrewingRecipeRegistry.addRecipe(new ItemStack(ModItems.HiPotion), new ItemStack(ModItems.HpOrb), new ItemStack(ModItems.MegaPotion));
    }
}
