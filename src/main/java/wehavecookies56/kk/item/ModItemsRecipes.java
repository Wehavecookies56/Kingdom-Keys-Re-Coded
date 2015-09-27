package wehavecookies56.kk.item;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagString;
import net.minecraftforge.common.brewing.BrewingRecipeRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry;
import wehavecookies56.kk.lib.Strings;
import wehavecookies56.kk.util.ItemStacks;

public class ModItemsRecipes {

	public static void init(){
		GameRegistry.addShapedRecipe(new ItemStack(ModItems.Heart),
				" H ",
				"HSH",
				" H ",
				'H', ModItems.DarkHeart, 'S', Blocks.soul_sand
				);

		GameRegistry.addShapedRecipe(new ItemStack(ModItems.PureHeart),
				" H ",
				"HSH",
				" H ",
				'H', ModItems.Heart, 'S', Blocks.soul_sand
				);

		GameRegistry.addShapedRecipe(new ItemStack(ModItems.KingdomHearts),
				" H ",
				"HSH",
				" H ",
				'H', ModItems.PureHeart, 'S', Blocks.soul_sand
				);

		GameRegistry.addShapedRecipe(new ItemStack(ModItems.DarkLeather),
				"DDD",
				"DLD",
				"DDD",
				'D', ModItems.DarkHeart, 'L', Items.leather
				);

		//Organization XIII Robe
		GameRegistry.addShapedRecipe(new ItemStack(ModItems.OrganizationRobe_Helmet),
				"DHD",
				"I I",
				'H', Items.leather_helmet, 'D', ModItems.DarkLeather, 'I', ModItems.DarkInfusedIron
				);

		GameRegistry.addShapedRecipe(new ItemStack(ModItems.OrganizationRobe_Chestplate),
				"D D",
				"ICI",
				"DDD",
				'C', Items.leather_chestplate, 'D', ModItems.DarkLeather, 'I', ModItems.DarkInfusedIron
				);

		GameRegistry.addShapedRecipe(new ItemStack(ModItems.OrganizationRobe_Leggings),
				"DLD",
				"I I",
				"D D",
				'L', Items.leather_leggings, 'D', ModItems.DarkLeather, 'I', ModItems.DarkInfusedIron
				);

		GameRegistry.addShapedRecipe(new ItemStack(ModItems.OrganizationRobe_Boots),
				"D D",
				"IBI",
				'B', Items.leather_boots, 'D', ModItems.DarkLeather, 'I', ModItems.DarkInfusedIron
				);

		//Aqua's Keyblade Armour
		GameRegistry.addShapedRecipe(new ItemStack(ModItems.Aqua_Helmet),
				"SHS",
				"F F",
				'H', Items.diamond_helmet, 'S', ModItems.StormyInfusedIron, 'F', ModItems.FrostInfusedSnowBall
				);

		GameRegistry.addShapedRecipe(new ItemStack(ModItems.Aqua_Chestplate),
				"S S",
				"FCF",
				"SSS",
				'C', Items.diamond_chestplate, 'S', ModItems.StormyInfusedIron, 'F', ModItems.FrostInfusedSnowBall
				);

		GameRegistry.addShapedRecipe(new ItemStack(ModItems.Aqua_Leggings),
				"SLS",
				"F F",
				"S S",
				'L', Items.diamond_leggings, 'S', ModItems.StormyInfusedIron, 'F', ModItems.FrostInfusedSnowBall
				);

		GameRegistry.addShapedRecipe(new ItemStack(ModItems.Aqua_Boots),
				"S S",
				"FBF",
				'B', Items.diamond_boots, 'S', ModItems.StormyInfusedIron, 'F', ModItems.FrostInfusedSnowBall
				);

		//Ventus' Keyblade Armour
		GameRegistry.addShapedRecipe(new ItemStack(ModItems.Ventus_Helmet),
				"SHS",
				"F F",
				'H', Items.diamond_helmet, 'S', ModItems.StormyInfusedIron, 'F', ModItems.LightningInfusedGold
				);

		GameRegistry.addShapedRecipe(new ItemStack(ModItems.Ventus_Chestplate),
				"S S",
				"FCF",
				"SSS",
				'C', Items.diamond_chestplate, 'S', ModItems.StormyInfusedIron, 'F', ModItems.LightningInfusedGold
				);

		GameRegistry.addShapedRecipe(new ItemStack(ModItems.Ventus_Leggings),
				"SLS",
				"F F",
				"S S",
				'L', Items.diamond_leggings, 'S', ModItems.StormyInfusedIron, 'F', ModItems.LightningInfusedGold
				);

		GameRegistry.addShapedRecipe(new ItemStack(ModItems.Ventus_Boots),
				"S S",
				"FBF",
				'B', Items.diamond_boots, 'S', ModItems.StormyInfusedIron, 'F', ModItems.LightningInfusedGold
				);

		//Terra's Keyblade Armour
		GameRegistry.addShapedRecipe(new ItemStack(ModItems.Terra_Helmet),
				"SHS",
				"F F",
				'H', Items.diamond_helmet, 'S', ModItems.DarkInfusedIron, 'F', ModItems.BlazingInfusedCoal
				);

		GameRegistry.addShapedRecipe(new ItemStack(ModItems.Terra_Chestplate),
				"S S",
				"FCF",
				"SSS",
				'C', Items.diamond_chestplate, 'S', ModItems.DarkInfusedIron, 'F', ModItems.BlazingInfusedCoal
				);

		GameRegistry.addShapedRecipe(new ItemStack(ModItems.Terra_Leggings),
				"SLS",
				"F F",
				"S S",
				'L', Items.diamond_leggings, 'S', ModItems.DarkInfusedIron, 'F', ModItems.BlazingInfusedCoal
				);

		GameRegistry.addShapedRecipe(new ItemStack(ModItems.Terra_Boots),
				"S S",
				"FBF",
				'B', Items.diamond_boots, 'S', ModItems.DarkInfusedIron, 'F', ModItems.BlazingInfusedCoal
				);

		//Eraqus' Keyblade Armour
		GameRegistry.addShapedRecipe(new ItemStack(ModItems.Eraqus_Helmet),
				"SHS",
				"F ",
				'H', Items.diamond_helmet, 'S', ModItems.BrightInfusedGlowStone, 'F', ModItems.MythrilInfusedDiamond
				);

		GameRegistry.addShapedRecipe(new ItemStack(ModItems.Eraqus_Chestplate),
				"S S",
				"FCF",
				"SSS",
				'C', Items.diamond_chestplate, 'S', ModItems.BrightInfusedGlowStone, 'F', ModItems.MythrilInfusedDiamond
				);

		GameRegistry.addShapedRecipe(new ItemStack(ModItems.Eraqus_Leggings),
				"SLS",
				"F F",
				"S S",
				'L', Items.diamond_leggings, 'S', ModItems.BrightInfusedGlowStone, 'F', ModItems.MythrilInfusedDiamond
				);

		GameRegistry.addShapedRecipe(new ItemStack(ModItems.Eraqus_Boots),
				"S S",
				"FBF",
				'B', Items.diamond_boots, 'S', ModItems.BrightInfusedGlowStone, 'F', ModItems.MythrilInfusedDiamond
				);

		ItemStack WHC56skull = new ItemStack(Items.skull, 1, 3);
		WHC56skull.setTagCompound(new NBTTagCompound());
		WHC56skull.getTagCompound().setTag("SkullOwner", new NBTTagString("Wehavecookies56"));
		ItemStack AAskull = new ItemStack(Items.skull, 1, 3);
		AAskull.setTagCompound(new NBTTagCompound());
		AAskull.getTagCompound().setTag("SkullOwner", new NBTTagString("Abelatox"));

		GameRegistry.addShapedRecipe(WHC56skull,
				"CCC",
				"CKC",
				"CCC",
				'C', Items.cookie, 'K', ModItems.KingdomHearts
				);

		GameRegistry.addShapedRecipe(AAskull,
				"FFF",
				"FEF",
				"FFF",
				'F', Items.blaze_powder, 'E', ModItems.EternalFlames
				);

		ItemStack BlazingCrystal = new ItemStack(ModItems.SynthesisMaterial, 1);
		ItemStacks.createSynthesisItem(BlazingCrystal, Strings.SM_BlazingCrystal, "S");

		ItemStack FrostCrystal = new ItemStack(ModItems.SynthesisMaterial, 1);
		ItemStacks.createSynthesisItem(FrostCrystal, Strings.SM_FrostCrystal, "S");

		ItemStack StormyCrystal = new ItemStack(ModItems.SynthesisMaterial, 1);
		ItemStacks.createSynthesisItem(StormyCrystal, Strings.SM_StormyCrystal, "S");

		ItemStack MythrilCrystal = new ItemStack(ModItems.SynthesisMaterial, 1);
		ItemStacks.createSynthesisItem(MythrilCrystal, Strings.SM_MythrilCrystal, "S");

		ItemStack LightningCrystal = new ItemStack(ModItems.SynthesisMaterial, 1);
		ItemStacks.createSynthesisItem(LightningCrystal, Strings.SM_LightningCrystal, "S");

		ItemStack BrightCrystal = new ItemStack(ModItems.SynthesisMaterial, 1);
		ItemStacks.createSynthesisItem(BrightCrystal, Strings.SM_BrightCrystal, "S");

		ItemStack DarkCrystal = new ItemStack(ModItems.SynthesisMaterial, 1);
		ItemStacks.createSynthesisItem(DarkCrystal, Strings.SM_DarkCrystal, "S");

		GameRegistry.addShapelessRecipe(new ItemStack(ModItems.BlazingInfusedCoal), BlazingCrystal, Items.coal);
		GameRegistry.addShapelessRecipe(new ItemStack(ModItems.FrostInfusedSnowBall), FrostCrystal, Items.snowball);
		GameRegistry.addShapelessRecipe(new ItemStack(ModItems.StormyInfusedIron), StormyCrystal, Items.iron_ingot);
		GameRegistry.addShapelessRecipe(new ItemStack(ModItems.MythrilInfusedDiamond), MythrilCrystal, Items.diamond);
		GameRegistry.addShapelessRecipe(new ItemStack(ModItems.LightningInfusedGold), LightningCrystal, Items.gold_ingot);
		GameRegistry.addShapelessRecipe(new ItemStack(ModItems.BrightInfusedGlowStone), BrightCrystal, Items.glowstone_dust);
		GameRegistry.addShapelessRecipe(new ItemStack(ModItems.DarkInfusedIron), DarkCrystal, Items.iron_ingot);
		
		GameRegistry.addShapelessRecipe(new ItemStack(ModItems.IceCream), Items.stick, Items.sugar, Items.water_bucket, Blocks.ice);
		GameRegistry.addShapelessRecipe(new ItemStack(ModItems.IceCream), Items.stick, Items.sugar, Items.water_bucket, Blocks.packed_ice);
		GameRegistry.addShapelessRecipe(new ItemStack(ModItems.IceCream), Items.stick, Items.sugar, Items.potionitem, Blocks.ice);
		GameRegistry.addShapelessRecipe(new ItemStack(ModItems.IceCream), Items.stick, Items.sugar, Items.potionitem, Blocks.packed_ice);

		
		BrewingRecipeRegistry.addRecipe(new ItemStack(ModItems.EmptyBottle), new ItemStack(ModItems.HpOrb), new ItemStack(ModItems.Potion));
		//TODO Hi-Potion
		//BrewingRecipeRegistry.addRecipe(new ItemStack(ModItems.EmptyPotion), new ItemStack(ModItems.Potion), new ItemStack(ModItems.HiPotion));
		//BrewingRecipeRegistry.addRecipe(new ItemStack(ModItems.Potion), new ItemStack(ModItems.HpOrb), new ItemStack(ModItems.HiPotion));
		//TODO Mega-Potion
		//BrewingRecipeRegistry.addRecipe(new ItemStack(ModItems.EmptyPotion), new ItemStack(ModItems.HiPotion), new ItemStack(ModItems.MegaPotion));
		//BrewingRecipeRegistry.addRecipe(new ItemStack(ModItems.HiPotion), new ItemStack(ModItems.HpOrb), new ItemStack(ModItems.MegaPotion));

	}
}
