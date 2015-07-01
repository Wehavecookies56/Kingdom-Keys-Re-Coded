package wehavecookies56.kk.item;

import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

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
	}
}
