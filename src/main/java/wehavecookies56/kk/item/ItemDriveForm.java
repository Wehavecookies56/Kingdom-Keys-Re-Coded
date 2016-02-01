package wehavecookies56.kk.item;

import java.util.List;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import wehavecookies56.kk.network.packet.PacketDispatcher;
import wehavecookies56.kk.network.packet.server.LevelUpDrive;
import wehavecookies56.kk.util.TextHelper;

public abstract class ItemDriveForm extends Item {

	String form;

	public ItemDriveForm (String form) {
		this.form = form;
		setMaxStackSize(1);
	}

	@Override
	public ItemStack onItemRightClick (ItemStack stack, World world, EntityPlayer player) {
		if (world.isRemote) PacketDispatcher.sendToServer(new LevelUpDrive(this.form));
		return stack;
	}

	@Override
	public void addInformation (ItemStack stack, EntityPlayer playerIn, List tooltip, boolean advanced) {
		tooltip.add(TextHelper.localize(this.form));
		super.addInformation(stack, playerIn, tooltip, advanced);
	}

	public String getDriveFormName () {
		return form;
	}

	public void setDriveFormName (String form) {
		this.form = form;
	}

}
