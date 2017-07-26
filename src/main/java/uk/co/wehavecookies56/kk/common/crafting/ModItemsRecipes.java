package uk.co.wehavecookies56.kk.common.crafting;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagString;
import net.minecraftforge.common.brewing.BrewingRecipeRegistry;
import net.minecraftforge.energy.EnergyStorage;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.oredict.RecipeSorter;
import net.minecraftforge.oredict.ShapedOreRecipe;
import net.minecraftforge.oredict.ShapelessOreRecipe;
import uk.co.wehavecookies56.kk.common.item.ItemStacks;
import uk.co.wehavecookies56.kk.common.item.ModItems;
import uk.co.wehavecookies56.kk.common.lib.Reference;
import uk.co.wehavecookies56.kk.common.lib.Strings;
import uk.co.wehavecookies56.kk.common.synthesis.material.MaterialEnergyCrystal;
import uk.co.wehavecookies56.kk.common.synthesis.material.MaterialLucidCrystal;

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
