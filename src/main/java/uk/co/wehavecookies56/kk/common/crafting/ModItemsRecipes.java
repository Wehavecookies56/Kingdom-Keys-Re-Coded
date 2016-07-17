package uk.co.wehavecookies56.kk.common.crafting;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.ShapedRecipes;
import net.minecraft.item.crafting.ShapelessRecipes;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.nbt.NBTTagString;
import net.minecraft.util.text.translation.I18n;
import net.minecraftforge.common.brewing.BrewingRecipeRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.oredict.RecipeSorter;
import net.minecraftforge.oredict.ShapedOreRecipe;
import net.minecraftforge.oredict.ShapelessOreRecipe;
import uk.co.wehavecookies56.kk.common.item.ItemStacks;
import uk.co.wehavecookies56.kk.common.item.ModItems;
import uk.co.wehavecookies56.kk.common.lib.Reference;
import uk.co.wehavecookies56.kk.common.lib.Strings;

public class ModItemsRecipes {

	public static void init () {
		RecipeSorter.register(Reference.MODID + ":shapelessnbt", ShapelessNBTRecipe.class, RecipeSorter.Category.SHAPELESS, "after:forge:shapelessore");
		GameRegistry.addShapedRecipe(new ItemStack(ModItems.Heart), " H ", "HSH", " H ", 'H', ModItems.DarkHeart, 'S', Blocks.SOUL_SAND);

		GameRegistry.addShapedRecipe(new ItemStack(ModItems.PureHeart), " H ", "HSH", " H ", 'H', ModItems.Heart, 'S', Blocks.SOUL_SAND);

		GameRegistry.addShapedRecipe(new ItemStack(ModItems.KingdomHearts), " H ", "HSH", " H ", 'H', ModItems.PureHeart, 'S', Blocks.SOUL_SAND);

		GameRegistry.addShapedRecipe(new ItemStack(ModItems.DarkLeather), "DDD", "DLD", "DDD", 'D', ModItems.DarkHeart, 'L', Items.LEATHER);

		// Organization XIII Robe
		GameRegistry.addShapedRecipe(new ItemStack(ModItems.OrganizationRobe_Helmet), "DHD", "I I", 'H', Items.LEATHER_HELMET, 'D', ModItems.DarkLeather, 'I', ModItems.DarkInfusedIron);

		GameRegistry.addShapedRecipe(new ItemStack(ModItems.OrganizationRobe_Chestplate), "D D", "ICI", "DDD", 'C', Items.LEATHER_CHESTPLATE, 'D', ModItems.DarkLeather, 'I', ModItems.DarkInfusedIron);

		GameRegistry.addShapedRecipe(new ItemStack(ModItems.OrganizationRobe_Leggings), "DLD", "I I", "D D", 'L', Items.LEATHER_LEGGINGS, 'D', ModItems.DarkLeather, 'I', ModItems.DarkInfusedIron);

		GameRegistry.addShapedRecipe(new ItemStack(ModItems.OrganizationRobe_Boots), "D D", "IBI", 'B', Items.LEATHER_BOOTS, 'D', ModItems.DarkLeather, 'I', ModItems.DarkInfusedIron);

		// Aqua's Keyblade Armour
		GameRegistry.addShapedRecipe(new ItemStack(ModItems.Aqua_Helmet), "SHS", "F F", 'H', Items.DIAMOND_HELMET, 'S', ModItems.StormyInfusedIron, 'F', ModItems.FrostInfusedSnowBall);

		GameRegistry.addShapedRecipe(new ItemStack(ModItems.Aqua_Chestplate), "S S", "FCF", "SSS", 'C', Items.DIAMOND_CHESTPLATE, 'S', ModItems.StormyInfusedIron, 'F', ModItems.FrostInfusedSnowBall);

		GameRegistry.addShapedRecipe(new ItemStack(ModItems.Aqua_Leggings), "SLS", "F F", "S S", 'L', Items.DIAMOND_LEGGINGS, 'S', ModItems.StormyInfusedIron, 'F', ModItems.FrostInfusedSnowBall);

		GameRegistry.addShapedRecipe(new ItemStack(ModItems.Aqua_Boots), "S S", "FBF", 'B', Items.DIAMOND_BOOTS, 'S', ModItems.StormyInfusedIron, 'F', ModItems.FrostInfusedSnowBall);

		// Ventus' Keyblade Armour
		GameRegistry.addShapedRecipe(new ItemStack(ModItems.Ventus_Helmet), "SHS", "F F", 'H', Items.DIAMOND_HELMET, 'S', ModItems.StormyInfusedIron, 'F', ModItems.LightningInfusedGold);

		GameRegistry.addShapedRecipe(new ItemStack(ModItems.Ventus_Chestplate), "S S", "FCF", "SSS", 'C', Items.DIAMOND_CHESTPLATE, 'S', ModItems.StormyInfusedIron, 'F', ModItems.LightningInfusedGold);

		GameRegistry.addShapedRecipe(new ItemStack(ModItems.Ventus_Leggings), "SLS", "F F", "S S", 'L', Items.DIAMOND_LEGGINGS, 'S', ModItems.StormyInfusedIron, 'F', ModItems.LightningInfusedGold);

		GameRegistry.addShapedRecipe(new ItemStack(ModItems.Ventus_Boots), "S S", "FBF", 'B', Items.DIAMOND_BOOTS, 'S', ModItems.StormyInfusedIron, 'F', ModItems.LightningInfusedGold);

		// Terra's Keyblade Armour
		GameRegistry.addShapedRecipe(new ItemStack(ModItems.Terra_Helmet), "SHS", "F F", 'H', Items.DIAMOND_HELMET, 'S', ModItems.DarkInfusedIron, 'F', ModItems.BlazingInfusedCoal);

		GameRegistry.addShapedRecipe(new ItemStack(ModItems.Terra_Chestplate), "S S", "FCF", "SSS", 'C', Items.DIAMOND_CHESTPLATE, 'S', ModItems.DarkInfusedIron, 'F', ModItems.BlazingInfusedCoal);

		GameRegistry.addShapedRecipe(new ItemStack(ModItems.Terra_Leggings), "SLS", "F F", "S S", 'L', Items.DIAMOND_LEGGINGS, 'S', ModItems.DarkInfusedIron, 'F', ModItems.BlazingInfusedCoal);

		GameRegistry.addShapedRecipe(new ItemStack(ModItems.Terra_Boots), "S S", "FBF", 'B', Items.DIAMOND_BOOTS, 'S', ModItems.DarkInfusedIron, 'F', ModItems.BlazingInfusedCoal);

		// Eraqus' Keyblade armour
		GameRegistry.addShapedRecipe(new ItemStack(ModItems.Eraqus_Helmet), "SHS", "F ", 'H', Items.DIAMOND_HELMET, 'S', ModItems.BrightInfusedGlowStone, 'F', ModItems.MythrilInfusedDiamond);

		GameRegistry.addShapedRecipe(new ItemStack(ModItems.Eraqus_Chestplate), "S S", "FCF", "SSS", 'C', Items.DIAMOND_CHESTPLATE, 'S', ModItems.BrightInfusedGlowStone, 'F', ModItems.MythrilInfusedDiamond);

		GameRegistry.addShapedRecipe(new ItemStack(ModItems.Eraqus_Leggings), "SLS", "F F", "S S", 'L', Items.DIAMOND_LEGGINGS, 'S', ModItems.BrightInfusedGlowStone, 'F', ModItems.MythrilInfusedDiamond);

		GameRegistry.addShapedRecipe(new ItemStack(ModItems.Eraqus_Boots), "S S", "FBF", 'B', Items.DIAMOND_BOOTS, 'S', ModItems.BrightInfusedGlowStone, 'F', ModItems.MythrilInfusedDiamond);

		ItemStack WHC56skull = new ItemStack(Items.SKULL, 1, 3);
		WHC56skull.setTagCompound(new NBTTagCompound());
		WHC56skull.getTagCompound().setTag("SkullOwner", new NBTTagString("Wehavecookies56"));
		ItemStack AAskull = new ItemStack(Items.SKULL, 1, 3);
		AAskull.setTagCompound(new NBTTagCompound());
		AAskull.getTagCompound().setTag("SkullOwner", new NBTTagString("Abelatox"));

		GameRegistry.addShapedRecipe(WHC56skull, "CCC", "CKC", "CCC", 'C', Items.COOKIE, 'K', ModItems.KingdomHearts);

		GameRegistry.addShapedRecipe(AAskull, "FFF", "FKF", "FFF", 'F', Items.BLAZE_POWDER, 'K', ModItems.KingdomHearts);

		GameRegistry.addShapedRecipe(new ItemStack(ModItems.VoidKnowledge), "LLL", "LBL", "LLL", 'L', ModItems.DarkLeather, 'B', Items.BOOK);

		GameRegistry.addShapedRecipe(new ItemStack(ModItems.SynthesisBagS), "LSL", "L L", "LLL", 'L', Items.LEATHER, 'S', Items.STRING);

		GameRegistry.addShapedRecipe(new ItemStack(ModItems.SynthesisBagM), "LSL", "LBL", "LLL", 'L', Items.LEATHER, 'S', Items.STRING, 'B', ModItems.SynthesisBagS);

		GameRegistry.addShapedRecipe(new ItemStack(ModItems.SynthesisBagL), "LSL", "LBL", "LLL", 'L', Items.LEATHER, 'S', Items.STRING, 'B', ModItems.SynthesisBagM);

		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModItems.EmptyBottle), "G G", "GBG", "GGG", 'G', "blockGlass", 'B', Items.GLASS_BOTTLE));

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

		GameRegistry.addRecipe(new ShapelessNBTRecipe(new ItemStack(ModItems.AbandonedKnowledge), ModItems.VoidKnowledge, LostIllusion));
		GameRegistry.addRecipe(new ShapelessNBTRecipe(new ItemStack(ModItems.DarkKnowledge), ModItems.AbandonedKnowledge, LostIllusion));
		GameRegistry.addRecipe(new ShapelessNBTRecipe(new ItemStack(ModItems.EclipsedKnowledge), ModItems.DarkKnowledge, LostIllusion));
		GameRegistry.addRecipe(new ShapelessNBTRecipe(new ItemStack(ModItems.ForgottenKnowledge), ModItems.EclipsedKnowledge, LostIllusion));
		GameRegistry.addRecipe(new ShapelessNBTRecipe(new ItemStack(ModItems.IlludedKnowledge), ModItems.ForgottenKnowledge, LostIllusion));
		GameRegistry.addRecipe(new ShapelessNBTRecipe(new ItemStack(ModItems.LostKnowledge), ModItems.IlludedKnowledge, LostIllusion));
		GameRegistry.addRecipe(new ShapelessNBTRecipe(new ItemStack(ModItems.ObscuredKnowledge), ModItems.LostKnowledge, LostIllusion));
		GameRegistry.addRecipe(new ShapelessNBTRecipe(new ItemStack(ModItems.UnknownKnowledge), ModItems.ObscuredKnowledge, LostIllusion));
		GameRegistry.addRecipe(new ShapelessNBTRecipe(new ItemStack(ModItems.ManifestKnowledge), ModItems.UnknownKnowledge, LostIllusion));

		GameRegistry.addRecipe(new ShapelessNBTRecipe(new ItemStack(ModItems.BlazingInfusedCoal), BlazingCrystal, Items.COAL));
		GameRegistry.addRecipe(new ShapelessNBTRecipe(new ItemStack(ModItems.FrostInfusedSnowBall), FrostCrystal, Items.SNOWBALL));
		GameRegistry.addRecipe(new ShapelessNBTRecipe(new ItemStack(ModItems.StormyInfusedIron), StormyCrystal, "ingotIron"));
		GameRegistry.addRecipe(new ShapelessNBTRecipe(new ItemStack(ModItems.MythrilInfusedDiamond), MythrilCrystal, "gemDiamond"));
		GameRegistry.addRecipe(new ShapelessNBTRecipe(new ItemStack(ModItems.LightningInfusedGold), LightningCrystal, "ingotGold"));
		GameRegistry.addRecipe(new ShapelessNBTRecipe(new ItemStack(ModItems.BrightInfusedGlowStone), BrightCrystal, "glowstone"));
		GameRegistry.addRecipe(new ShapelessNBTRecipe(new ItemStack(ModItems.DarkInfusedIron), DarkCrystal, "ingotIron"));

		GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(ModItems.IceCream), "stickWood", Items.SUGAR, Items.WATER_BUCKET, Blocks.ICE));
		GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(ModItems.IceCream), "stickWood", Items.SUGAR, Items.WATER_BUCKET, Blocks.PACKED_ICE));
		GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(ModItems.IceCream), "stickWood", Items.SUGAR, Items.POTIONITEM, Blocks.ICE));
		GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(ModItems.IceCream), "stickWood", Items.SUGAR, Items.POTIONITEM, Blocks.PACKED_ICE));

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
