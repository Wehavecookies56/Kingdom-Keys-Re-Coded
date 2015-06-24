package wehavecookies56.kk.block;

import wehavecookies56.kk.item.ModItems;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ModBlocksRecipes {

	public static void init(){
		GameRegistry.addShapedRecipe(new ItemStack(ModBlocks.NormalBlox), 
			"DS",
			"SD",
			'D', Blocks.dirt, 'S', Blocks.stone
		);
		
		GameRegistry.addShapedRecipe(new ItemStack(ModBlocks.NormalBlox), 
			"SD",
			"DS",
			'D', Blocks.dirt, 'S', Blocks.stone
		);
		
		GameRegistry.addShapedRecipe(new ItemStack(ModBlocks.MetalBlox), 
			"HI",
			"IH",
			'I', Items.iron_ingot, 'H', ModBlocks.HardBlox
		);
		
		GameRegistry.addShapedRecipe(new ItemStack(ModBlocks.MetalBlox), 
			"IH",
			"HI",
			'I', Items.iron_ingot, 'H', ModBlocks.HardBlox
		);
		
		GameRegistry.addShapedRecipe(new ItemStack(ModBlocks.BounceBlox), 
			"NNN",
			"NSN",
			"NNN",
			'S', Blocks.slime_block, 'N', ModBlocks.NormalBlox
		);
		
		GameRegistry.addShapedRecipe(new ItemStack(ModBlocks.HardBlox), 
			"NS",
			"SN",
			'S', Blocks.stone, 'N', ModBlocks.NormalBlox
		);
		
		GameRegistry.addShapedRecipe(new ItemStack(ModBlocks.HardBlox), 
			"SN",
			"NS",
			'S', Blocks.stone, 'N', ModBlocks.NormalBlox
		);
	}
}
