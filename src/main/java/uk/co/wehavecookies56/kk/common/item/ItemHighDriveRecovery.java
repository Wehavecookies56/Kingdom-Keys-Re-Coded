package uk.co.wehavecookies56.kk.common.item;

import java.util.List;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.TextFormatting;
import uk.co.wehavecookies56.kk.common.capability.ModCapabilities;
import uk.co.wehavecookies56.kk.common.item.base.ItemKKPotion;
import uk.co.wehavecookies56.kk.common.lib.Strings;

public class ItemHighDriveRecovery extends ItemKKPotion {

	String potionType;

	public ItemHighDriveRecovery(int food, boolean wolf, String type) {
		super(food, wolf, type, Strings.HighDriveRecovery);
		setAlwaysEdible();
		this.potionType = type;
	}

	@Override
	public void potionEffect (EntityPlayer player) {
		player.getCapability(ModCapabilities.PLAYER_STATS, null).addDP(player.getCapability(ModCapabilities.PLAYER_STATS, null).getMaxDP());
	}

	@Override
	public void addInformation(ItemStack stack, EntityPlayer playerIn, List<String> tooltip, boolean advanced) {
		tooltip.add(TextFormatting.GOLD + "Fully Restores the Drive Gauge");
		super.addInformation(stack, playerIn, tooltip, advanced);
	}

}