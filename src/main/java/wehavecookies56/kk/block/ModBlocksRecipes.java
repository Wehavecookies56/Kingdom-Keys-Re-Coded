package wehavecookies56.kk.block;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.oredict.ShapedOreRecipe;

public class ModBlocksRecipes {

	public static void init () {
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModBlocks.NormalBlox), "DS", "SD", 'D', Blocks.dirt, 'S', "stone"));

		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModBlocks.NormalBlox), "SD", "DS", 'D', Blocks.dirt, 'S', "stone"));

		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModBlocks.HardBlox), "NS", "SN", 'S', "stone", 'N', ModBlocks.NormalBlox));

		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModBlocks.HardBlox), "SN", "NS", 'S', "stone", 'N', ModBlocks.NormalBlox));

		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModBlocks.MetalBlox), "HI", "IH", 'I', "ingotIron", 'H', ModBlocks.HardBlox));

		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModBlocks.MetalBlox), "IH", "HI", 'I', "ingotIron", 'H', ModBlocks.HardBlox));

		GameRegistry.addShapedRecipe(new ItemStack(ModBlocks.BounceBlox), "NNN", "NSN", "NNN", 'S', Blocks.slime_block, 'N', ModBlocks.NormalBlox);

		GameRegistry.addShapedRecipe(new ItemStack(ModBlocks.BlastBlox), "NLN", "NTN", "NNN", 'N', ModBlocks.NormalBlox, 'L', Items.lava_bucket, 'T', Blocks.tnt);

		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModBlocks.GhostBlox), "GNG", "GRG", "GNG", 'G', "blockGlass", 'N', ModBlocks.NormalBlox, 'R', "blockRedstone"));

		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModBlocks.SynthesisTable), "HIH", "NCN", "HIH", 'H', ModBlocks.HardBlox, 'I', "ingotIron", 'N', ModBlocks.NormalBlox, 'C', Blocks.crafting_table));

	}
}
