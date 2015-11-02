package wehavecookies56.kk.item;

import java.util.List;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import wehavecookies56.kk.lib.Strings;
import wehavecookies56.kk.network.packet.PacketDispatcher;
import wehavecookies56.kk.network.packet.server.LevelUpDrive;
import wehavecookies56.kk.util.TextHelper;

public class ItemUpgradeWisdom extends Item
{
	public ItemUpgradeWisdom(){
		this.setMaxStackSize(1);
	}

	@Override
	public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player){
		if(world.isRemote){
			PacketDispatcher.sendToServer(new LevelUpDrive("Wisdom"));
		}
		return stack;
	}
	
	@Override
	public void addInformation(ItemStack stack, EntityPlayer playerIn, List tooltip, boolean advanced) {
		tooltip.add(TextHelper.localize(Strings.Gui_CommandMenu_Drive_Wisdom));
		super.addInformation(stack, playerIn, tooltip, advanced);
	}
}
