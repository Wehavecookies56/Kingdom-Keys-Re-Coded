package uk.co.wehavecookies56.kk.common.crafting;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.oredict.ShapedOreRecipe;
import uk.co.wehavecookies56.kk.common.block.ModBlocks;
import uk.co.wehavecookies56.kk.common.item.ModItems;

public class ModBlocksRecipes {

    public static void init () {
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModBlocks.NormalBlox), "DS", "SD", 'D', Blocks.DIRT, 'S', "stone"));

        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModBlocks.NormalBlox), "SD", "DS", 'D', Blocks.DIRT, 'S', "stone"));

        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModBlocks.HardBlox), "NS", "SN", 'S', "stone", 'N', ModBlocks.NormalBlox));

        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModBlocks.HardBlox), "SN", "NS", 'S', "stone", 'N', ModBlocks.NormalBlox));

        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModBlocks.MetalBlox), "HI", "IH", 'I', "ingotIron", 'H', ModBlocks.HardBlox));

        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModBlocks.MetalBlox), "IH", "HI", 'I', "ingotIron", 'H', ModBlocks.HardBlox));

        GameRegistry.addShapedRecipe(new ItemStack(ModBlocks.BounceBlox), "NNN", "NSN", "NNN", 'S', Blocks.SLIME_BLOCK, 'N', ModBlocks.NormalBlox);

        GameRegistry.addShapedRecipe(new ItemStack(ModBlocks.BlastBlox), "NLN", "NTN", "NNN", 'N', ModBlocks.NormalBlox, 'L', Items.LAVA_BUCKET, 'T', Blocks.TNT);

        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModBlocks.GhostBlox), "GNG", "GRG", "GNG", 'G', "blockGlass", 'N', ModBlocks.NormalBlox, 'R', "blockRedstone"));

        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModBlocks.SynthesisTable), "HIH", "NCN", "HIH", 'H', ModBlocks.HardBlox, 'I', "ingotIron", 'N', ModBlocks.NormalBlox, 'C', Blocks.CRAFTING_TABLE));

        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModBlocks.KKChest), "HGH", "GCG", "HGH", 'H', ModItems.Heart, 'G', Items.GOLD_INGOT, 'C', Blocks.CHEST));

        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModBlocks.Pedestal), " H ", "HBH", "BBB", 'H', ModItems.PureHeart, 'B', ModBlocks.MetalBlox));

        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModBlocks.OrgPortal), " D ", "DKD", "OOO", 'D', ModItems.DarkHeart, 'K', ModItems.KingdomHearts, 'O', Blocks.OBSIDIAN));
    }
}
