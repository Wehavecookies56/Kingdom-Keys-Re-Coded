package uk.co.wehavecookies56.kk.common.item;

import net.minecraft.entity.player.EntityPlayer;
import uk.co.wehavecookies56.kk.common.capability.ModCapabilities;
import uk.co.wehavecookies56.kk.common.item.base.ItemKKPotion;
import uk.co.wehavecookies56.kk.common.lib.Strings;

public class ItemEther extends ItemKKPotion {

	String potionType;

	public ItemEther (int food, boolean wolf, String type) {
		super(food, wolf, type, "ether");
		setUnlocalizedName(Strings.Potion);
		setAlwaysEdible();
		this.potionType = type;
	}

	@Override
	public void potionEffect (EntityPlayer player) {
		player.getCapability(ModCapabilities.PLAYER_STATS, null).addMP(player.getCapability(ModCapabilities.PLAYER_STATS, null).getMaxMP() / 3);
	}

}