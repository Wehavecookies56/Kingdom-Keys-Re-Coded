package wehavecookies56.kk.item;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class TabKingdomKeys extends CreativeTabs {

	public TabKingdomKeys(int index, String label) {
		super(index, label);
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public Item getTabIconItem() {
		return ModItems.KingdomHearts;
	}
	
}
