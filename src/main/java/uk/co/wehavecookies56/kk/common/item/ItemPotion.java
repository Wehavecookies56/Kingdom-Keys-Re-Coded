package uk.co.wehavecookies56.kk.common.item;

import net.minecraft.entity.player.EntityPlayer;
import uk.co.wehavecookies56.kk.common.item.base.ItemKKPotion;
import uk.co.wehavecookies56.kk.common.lib.Strings;

public class ItemPotion extends ItemKKPotion {

	String potionType;

	public ItemPotion (int food, boolean wolf, String type) {
		super(food, wolf, type, "potion");
		setUnlocalizedName(Strings.Potion);
		setAlwaysEdible();
		this.potionType = type;
	}

	@Override
	public void potionEffect (EntityPlayer player) {
		player.heal(player.getMaxHealth() / 3);
	}
}