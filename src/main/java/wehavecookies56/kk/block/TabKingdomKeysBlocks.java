package wehavecookies56.kk.block;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class TabKingdomKeysBlocks extends CreativeTabs {

	public TabKingdomKeysBlocks(int index, String label) {
		super(index, label);
	}

	@Override
	@SideOnly(Side.CLIENT)
	public Item getTabIconItem() {
		return Item.getItemFromBlock(ModBlocks.NormalBlox);
	}

}
