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

	String form, unlocalizedName;

	public ItemDriveForm (String form, String unlocalizedName) {
		this.form = form;
		this.unlocalizedName = unlocalizedName;
		setMaxStackSize(1);
	}

	@Override
	public ItemStack onItemRightClick (ItemStack stack, World world, EntityPlayer player) {
		if (world.isRemote) PacketDispatcher.sendToServer(new LevelUpDrive(this.form));
		return stack;
	}

	@Override
	public void addInformation (ItemStack stack, EntityPlayer playerIn, List tooltip, boolean advanced) {
		tooltip.add(TextHelper.localize(this.unlocalizedName));
		super.addInformation(stack, playerIn, tooltip, advanced);
	}

	public String getDriveFormName () {
		return unlocalizedName;
	}

	public void setDriveFormName (String unlocalizedName) {
		this.unlocalizedName = unlocalizedName;
	}

}
