package uk.co.wehavecookies56.kk.common.block;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class TabKingdomKeysBlocks extends CreativeTabs {

	public TabKingdomKeysBlocks (int index, String label) {
		super(index, label);
	}

	@Override
	@SideOnly (Side.CLIENT)
	public ItemStack getTabIconItem () {
		return new ItemStack(Item.getItemFromBlock(ModBlocks.NormalBlox));
	}

}
