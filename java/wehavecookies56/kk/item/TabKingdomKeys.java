package wehavecookies56.kk.item;

import java.util.List;

import wehavecookies56.kk.entities.ExtendedPlayer;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
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
	
	@Override
	public void displayAllReleventItems(List list) {
		super.displayAllReleventItems(list);
		ItemStack munny = new ItemStack(ModItems.Munny, 1);
		munny.setTagCompound(new NBTTagCompound());
		munny.getTagCompound().setInteger("amount", 1000000);
		list.add(munny);
	}
	
}
