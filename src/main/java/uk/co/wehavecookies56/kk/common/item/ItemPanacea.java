package uk.co.wehavecookies56.kk.common.item;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.TextFormatting;
import uk.co.wehavecookies56.kk.common.capability.ModCapabilities;
import uk.co.wehavecookies56.kk.common.item.base.ItemKKPotion;
import uk.co.wehavecookies56.kk.common.lib.Strings;

import java.util.List;

public class ItemPanacea extends ItemKKPotion {

	String potionType;

	public ItemPanacea(int food, boolean wolf, String type) {
		super(food, wolf, type, Strings.Panacea);
		setAlwaysEdible();
		this.potionType = type;
	}

	@Override
	public void potionEffect (EntityPlayer player) {
		player.clearActivePotions();
	}

	@Override
	public void addInformation(ItemStack stack, EntityPlayer playerIn, List<String> tooltip, boolean advanced) {
		tooltip.add(TextFormatting.WHITE + "Removes all potion effects");
		super.addInformation(stack, playerIn, tooltip, advanced);
	}

}