package wehavecookies56.kk.item;

import java.util.List;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import wehavecookies56.kk.client.gui.GuiCommandMenu;
import wehavecookies56.kk.entities.ExtendedPlayer;
import wehavecookies56.kk.lib.Strings;
import wehavecookies56.kk.network.packet.PacketDispatcher;
import wehavecookies56.kk.network.packet.server.LevelUpDrive;
import wehavecookies56.kk.util.TextHelper;

public class ItemUpgradeFinal extends ItemDriveForm
{
	public ItemUpgradeFinal(String form, String unlocalizedName){
		super(form, unlocalizedName);
	}
}
