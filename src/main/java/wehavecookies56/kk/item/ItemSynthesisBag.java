package wehavecookies56.kk.item;

import java.util.List;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import wehavecookies56.kk.util.GuiHelper;

public class ItemSynthesisBag extends Item {

	public ItemSynthesisBag() {this.setMaxStackSize(1);}

	@Override
	public ItemStack onItemRightClick(ItemStack itemStackIn, net.minecraft.world.World world, EntityPlayer player) 
	{
		if (!world.isRemote)
		{
			BlockPos xyz = new BlockPos(player.posX,player.posY,player.posZ);
			GuiHelper.openSynthesisBag(player, world, xyz);
		}
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
