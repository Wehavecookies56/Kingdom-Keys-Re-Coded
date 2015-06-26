package wehavecookies56.kk.item;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemHpOrb extends Item
{	
	public ItemHpOrb() 
	{
		this.setMaxStackSize(65);
	}
	
	public ItemStack onItemRightClick(ItemStack item, World world, EntityPlayer entity)
	{
		if(!(entity.getHealth() == 20))
		{
			entity.heal(2);
			entity.inventory.consumeInventoryItem(ModItems.HpOrb);
		}
		return item;
	}
}
