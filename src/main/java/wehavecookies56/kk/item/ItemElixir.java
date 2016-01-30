package wehavecookies56.kk.item;

import net.minecraft.entity.player.EntityPlayer;
import wehavecookies56.kk.entities.ExtendedPlayer;
import wehavecookies56.kk.lib.Strings;

public class ItemElixir extends ItemKKPotion {

	String potionType;

	public ItemElixir (int food, boolean wolf, String type) {
		super(food, wolf, type, "elixir");
		setUnlocalizedName(Strings.Potion);
		setAlwaysEdible();
		this.potionType = type;
	}

	@Override
	public void potionEffect (EntityPlayer player) {
		ExtendedPlayer.get(player).addMp(ExtendedPlayer.get(player).getMaxMp() / 3);
		player.heal(player.getMaxHealth() / 3);
	}

}