package wehavecookies56.kk.item;

import java.util.List;

import wehavecookies56.kk.entities.ExtendedPlayer;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;

public class ItemMunny extends Item {

	int munny;
	
	public ItemMunny() {}
	
	@Override
	public ItemStack onItemRightClick(ItemStack itemStack, World world, EntityPlayer player) {
		if(!world.isRemote){
			if(itemStack.hasTagCompound()){
				ExtendedPlayer props = ExtendedPlayer.get(player);
				props.addMunny(itemStack.getTagCompound().getInteger("amount"));
				System.out.println("Munny: " + props.getMunny());
			}
			
		}
		return itemStack;
		
	}
	
	@Override
	public void addInformation(ItemStack stack, EntityPlayer playerIn, List tooltip, boolean advanced) {
		if(stack.hasTagCompound()){
			int amount = stack.getTagCompound().getInteger("amount");
			tooltip.add("" + amount);
		}
	}
	
	@Override
	public void onUpdate(ItemStack stack, World worldIn, Entity entityIn, int itemSlot, boolean isSelected) {
		
	}
	
	@Override
	public void getSubItems(Item itemIn, CreativeTabs tab, List subItems) {
		
	}
	
	public void setMunny(int munny){
		this.munny = munny;
	}
	
}
