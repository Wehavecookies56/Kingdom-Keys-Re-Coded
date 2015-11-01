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

		GameRegistry.addShapedRecipe(new ItemStack(ModItems.VoidKnowledge),
				"LLL",
				"LBL",
				"LLL",
				'L', ModItems.DarkLeather, 'B', Items.book
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
		
		ItemStack DenseShard = new ItemStack(ModItems.SynthesisMaterial, 1);
		ItemStacks.createSynthesisItem(DenseShard, Strings.SM_DenseShard, "C");

		ItemStack DenseStone = new ItemStack(ModItems.SynthesisMaterial, 1);
		ItemStacks.createSynthesisItem(DenseStone, Strings.SM_DenseStone, "B");

		ItemStack DenseGem = new ItemStack(ModItems.SynthesisMaterial, 1);
		ItemStacks.createSynthesisItem(DenseGem, Strings.SM_DenseGem, "A");

		ItemStack DenseCrystal = new ItemStack(ModItems.SynthesisMaterial, 1);
		ItemStacks.createSynthesisItem(DenseCrystal, Strings.SM_DenseCrystal, "S");

		ItemStack TwilightShard = new ItemStack(ModItems.SynthesisMaterial, 1);
		ItemStacks.createSynthesisItem(TwilightShard, Strings.SM_TwilightShard, "C");

		ItemStack TwilightStone = new ItemStack(ModItems.SynthesisMaterial, 1);
		ItemStacks.createSynthesisItem(TwilightStone, Strings.SM_TwilightStone, "B");
		
		ItemStack TwilightGem = new ItemStack(ModItems.SynthesisMaterial, 1);
		ItemStacks.createSynthesisItem(TwilightGem, Strings.SM_TwilightGem, "A");
		
		ItemStack TwilightCrystal = new ItemStack(ModItems.SynthesisMaterial, 1);
		ItemStacks.createSynthesisItem(TwilightCrystal, Strings.SM_TwilightCrystal, "S");
		
		ItemStack MythrilShard = new ItemStack(ModItems.SynthesisMaterial, 1);
		ItemStacks.createSynthesisItem(MythrilShard, Strings.SM_MythrilShard, "C");
		
		ItemStack MythrilStone = new ItemStack(ModItems.SynthesisMaterial, 1);
		ItemStacks.createSynthesisItem(MythrilStone, Strings.SM_MythrilStone, "B");

		ItemStack MythrilGem = new ItemStack(ModItems.SynthesisMaterial, 1);
		ItemStacks.createSynthesisItem(MythrilGem, Strings.SM_MythrilGem, "A");
		
		ItemStack SerenityShard = new ItemStack(ModItems.SynthesisMaterial, 1);
		ItemStacks.createSynthesisItem(SerenityShard, Strings.SM_SerenityShard, "C");
		ItemStack SerenityStone = new ItemStack(ModItems.SynthesisMaterial, 1);
		ItemStacks.createSynthesisItem(SerenityStone, Strings.SM_SerenityStone, "B");
			
		ItemStack LostIllusion = new ItemStack(ModItems.SynthesisMaterial, 1);
		ItemStacks.createSynthesisItem(LostIllusion, Strings.SM_LostIllusion, "A");
		
		ItemStack ManifestIllusion = new ItemStack(ModItems.SynthesisMaterial, 1);
		ItemStacks.createSynthesisItem(ManifestIllusion, Strings.SM_ManifestIllusion, "S");
		
		GameRegistry.addShapelessRecipe(new ItemStack(ModItems.AbandonedKnowledge), ModItems.VoidKnowledge, LostIllusion);
		GameRegistry.addShapelessRecipe(new ItemStack(ModItems.DarkKnowledge), ModItems.AbandonedKnowledge, LostIllusion);
		GameRegistry.addShapelessRecipe(new ItemStack(ModItems.EclipsedKnowledge), ModItems.DarkKnowledge, LostIllusion);
		GameRegistry.addShapelessRecipe(new ItemStack(ModItems.ForgottenKnowledge), ModItems.EclipsedKnowledge, LostIllusion);
		GameRegistry.addShapelessRecipe(new ItemStack(ModItems.IlludedKnowledge), ModItems.ForgottenKnowledge, LostIllusion);
		GameRegistry.addShapelessRecipe(new ItemStack(ModItems.LostKnowledge), ModItems.IlludedKnowledge, LostIllusion);
		GameRegistry.addShapelessRecipe(new ItemStack(ModItems.ObscuredKnowledge), ModItems.LostKnowledge, LostIllusion);
		GameRegistry.addShapelessRecipe(new ItemStack(ModItems.UnknownKnowledge), ModItems.ObscuredKnowledge, LostIllusion);
		
		GameRegistry.addShapelessRecipe(MythrilShard, DenseStone, DenseShard, TwilightStone, TwilightShard);
		GameRegistry.addShapelessRecipe(MythrilStone, DenseStone, DenseShard, TwilightStone, TwilightShard, SerenityShard);
		GameRegistry.addShapelessRecipe(MythrilGem, DenseCrystal, DenseGem, TwilightCrystal, TwilightGem);
		GameRegistry.addShapelessRecipe(MythrilCrystal, DenseCrystal, DenseGem, TwilightCrystal, TwilightGem, SerenityStone);

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

		GameRegistry.addShapelessRecipe(new ItemStack(ModItems.ManifestKnowledge), ModItems.AbandonedKnowledge, ModItems.DarkKnowledge, ModItems.EclipsedKnowledge, ModItems.ForgottenKnowledge, ModItems.IlludedKnowledge, ModItems.LostKnowledge, ModItems.ObscuredKnowledge, ModItems.UnknownKnowledge, ModItems.VoidKnowledge);
		
		BrewingRecipeRegistry.addRecipe(new ItemStack(ModItems.EmptyBottle), new ItemStack(ModItems.HpOrb), new ItemStack(ModItems.Potion));
		BrewingRecipeRegistry.addRecipe(new ItemStack(ModItems.EmptyBottle), new ItemStack(ModItems.MagicOrb), new ItemStack(ModItems.Ether));
		BrewingRecipeRegistry.addRecipe(new ItemStack(ModItems.Potion), new ItemStack(ModItems.MagicOrb), new ItemStack(ModItems.Elixir));
		BrewingRecipeRegistry.addRecipe(new ItemStack(ModItems.Ether), new ItemStack(ModItems.HpOrb), new ItemStack(ModItems.Elixir));

		//TODO Hi-Potion
		//BrewingRecipeRegistry.addRecipe(new ItemStack(ModItems.EmptyPotion), new ItemStack(ModItems.Potion), new ItemStack(ModItems.HiPotion));
		//BrewingRecipeRegistry.addRecipe(new ItemStack(ModItems.Potion), new ItemStack(ModItems.HpOrb), new ItemStack(ModItems.HiPotion));
		//TODO Mega-Potion
		//BrewingRecipeRegistry.addRecipe(new ItemStack(ModItems.EmptyPotion), new ItemStack(ModItems.HiPotion), new ItemStack(ModItems.MegaPotion));
		//BrewingRecipeRegistry.addRecipe(new ItemStack(ModItems.HiPotion), new ItemStack(ModItems.HpOrb), new ItemStack(ModItems.MegaPotion));

	}
}
