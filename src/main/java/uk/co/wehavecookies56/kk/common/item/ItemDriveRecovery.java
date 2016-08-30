package uk.co.wehavecookies56.kk.common.item;

import java.util.List;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.TextFormatting;
import uk.co.wehavecookies56.kk.common.capability.ModCapabilities;
import uk.co.wehavecookies56.kk.common.item.base.ItemKKPotion;
import uk.co.wehavecookies56.kk.common.lib.Strings;

public class ItemDriveRecovery extends ItemKKPotion {

	String potionType;

	public ItemDriveRecovery(int food, boolean wolf, String type) {
		super(food, wolf, type, Strings.DriveRecovery);
		setAlwaysEdible();
		this.potionType = type;
	}

	@Override
	public void potionEffect (EntityPlayer player) {
		player.getCapability(ModCapabilities.PLAYER_STATS, null).addDP(300);
	}

	@Override
	public void addInformation(ItemStack stack, EntityPlayer playerIn, List<String> tooltip, boolean advanced) {
		tooltip.add(TextFormatting.GOLD + "Restores 3 Drive Gauges");
		super.addInformation(stack, playerIn, tooltip, advanced);
	}

}