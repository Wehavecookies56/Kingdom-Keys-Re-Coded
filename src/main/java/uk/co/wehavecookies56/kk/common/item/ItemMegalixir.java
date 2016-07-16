package uk.co.wehavecookies56.kk.common.item;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.TextFormatting;
import uk.co.wehavecookies56.kk.common.capability.ModCapabilities;
import uk.co.wehavecookies56.kk.common.item.base.ItemKKPotion;
import uk.co.wehavecookies56.kk.common.lib.Strings;

import java.util.List;

public class ItemMegalixir extends ItemKKPotion {

	String potionType;

	public ItemMegalixir(int food, boolean wolf, String type) {
		super(food, wolf, type, Strings.Megalixir);
		setAlwaysEdible();
		this.potionType = type;
	}

	@Override
	public void potionEffect (EntityPlayer player) {
		player.getCapability(ModCapabilities.PLAYER_STATS, null).addMP(player.getCapability(ModCapabilities.PLAYER_STATS, null).getMaxMP() / 2);
		player.heal(player.getMaxHealth() / 2);
	}

	@Override
	public void addInformation(ItemStack stack, EntityPlayer playerIn, List<String> tooltip, boolean advanced) {
		tooltip.add(TextFormatting.BLUE + "Restores half of your max MP (" + playerIn.getCapability(ModCapabilities.PLAYER_STATS, null).getMaxMP() / 2 + ")");
		tooltip.add(TextFormatting.GREEN + "Restores half of your max HP (" + playerIn.getMaxHealth() / 2 + ")");
		super.addInformation(stack, playerIn, tooltip, advanced);
	}

}