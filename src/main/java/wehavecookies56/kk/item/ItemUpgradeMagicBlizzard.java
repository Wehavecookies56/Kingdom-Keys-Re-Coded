package wehavecookies56.kk.item;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import wehavecookies56.kk.network.packet.PacketDispatcher;
import wehavecookies56.kk.network.packet.server.magics.LevelUpMagic;

public class ItemUpgradeMagicBlizzard extends Item
{
	public ItemUpgradeMagicBlizzard()
	{
		this.setMaxStackSize(1);
	}

	@Override
	public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player) 
	{
		PacketDispatcher.sendToServer(new LevelUpMagic("Blizzard"));
		return stack;
	}
}
