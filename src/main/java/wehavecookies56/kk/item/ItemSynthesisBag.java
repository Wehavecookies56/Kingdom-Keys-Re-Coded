package wehavecookies56.kk.item;

import java.util.List;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class ItemSynthesisBag extends Item {

	public ItemSynthesisBag() {this.setMaxStackSize(1);}

	@Override
	public ItemStack onItemRightClick(ItemStack itemStackIn, net.minecraft.world.World worldIn, EntityPlayer playerIn) 
	{
		//Open gui
		return itemStackIn;
	}
	@Override
	public void addInformation(ItemStack stack, EntityPlayer playerIn, List tooltip, boolean advanced) {
		if(stack.hasTagCompound()){
			int amount = stack.getTagCompound().getInteger("amount");
			tooltip.add("By holding the synthesis bag in your inventory items will be sent into the synthesiser");
		}
	}

	@Override
	public void getSubItems(Item itemIn, CreativeTabs tab, List subItems) {
	}
}
