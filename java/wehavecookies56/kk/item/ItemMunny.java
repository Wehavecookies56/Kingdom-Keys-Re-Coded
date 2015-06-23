package wehavecookies56.kk.item;

import java.util.List;

import wehavecookies56.kk.entities.ExtendedPlayer;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemMunny extends Item {

	int munny;
	
	public ItemMunny() {
		
	}
	
	@Override
	public ItemStack onItemRightClick(ItemStack itemStack, World world, EntityPlayer player) {
		if(!world.isRemote){
			ExtendedPlayer props = ExtendedPlayer.get(player);
			
			props.addMunny(10);
			System.out.println("Munny: " + props.getMunny());
		}
		return itemStack;
		
	}
	
}
