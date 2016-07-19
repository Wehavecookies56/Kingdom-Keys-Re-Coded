package uk.co.wehavecookies56.kk.common.item.base;

import java.util.List;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;
import uk.co.wehavecookies56.kk.common.core.helper.TextHelper;
import uk.co.wehavecookies56.kk.common.network.packet.PacketDispatcher;
import uk.co.wehavecookies56.kk.common.network.packet.server.LevelUpDrive;
import uk.co.wehavecookies56.kk.common.util.Utils;

public abstract class ItemDriveForm extends Item {

	String form;

	public ItemDriveForm (String form) {
		this.form = form;
		setMaxStackSize(1);
	}
	
	@Override
	public ActionResult<ItemStack> onItemRightClick(ItemStack stack, World world, EntityPlayer playerIn, EnumHand hand) {
		if (world.isRemote) PacketDispatcher.sendToServer(new LevelUpDrive(this.form));
		return new ActionResult<ItemStack>(EnumActionResult.SUCCESS, stack);
	}

	@Override
	public void addInformation (ItemStack stack, EntityPlayer playerIn, List tooltip, boolean advanced) {
		tooltip.add(Utils.translateToLocal(this.form));
		super.addInformation(stack, playerIn, tooltip, advanced);
	}

	public String getDriveFormName () {
		return form;
	}

	public void setDriveFormName (String form) {
		this.form = form;
	}

}
