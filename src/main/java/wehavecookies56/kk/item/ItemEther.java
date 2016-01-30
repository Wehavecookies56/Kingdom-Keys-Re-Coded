package wehavecookies56.kk.item;

import net.minecraft.entity.player.EntityPlayer;
import wehavecookies56.kk.entities.ExtendedPlayer;
import wehavecookies56.kk.lib.Strings;

public class ItemEther extends ItemKKPotion {

	String potionType;

	public ItemEther(int food, boolean wolf, String type) {
		super(food, wolf, type, "ether");
		setUnlocalizedName(Strings.Potion);
		setAlwaysEdible();
		this.potionType = type;
	}

	@Override
	public void potionEffect(EntityPlayer player) {
		ExtendedPlayer.get(player).addMp(ExtendedPlayer.get(player).getMaxMp() / 3);
	}

}