package uk.co.wehavecookies56.kk.common.entity.magic;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.EnumHand;
import uk.co.wehavecookies56.kk.common.capability.ModCapabilities;
import uk.co.wehavecookies56.kk.common.item.base.ItemKeyblade;
import uk.co.wehavecookies56.kk.common.lib.Strings;

public class MagicDamage {
	public static float getMagicDamage(EntityPlayer player, String suffix)
	{
		float damage = 0;
		float finalDamage = 0;
		
		if(player.getHeldItem(EnumHand.MAIN_HAND) != null && player.getHeldItem(EnumHand.MAIN_HAND).getItem() instanceof ItemKeyblade)
		{
			damage = (float) (((ItemKeyblade) player.getHeldItem(EnumHand.MAIN_HAND).getItem()).getMagic() + player.getCapability(ModCapabilities.PLAYER_STATS, null).getMagic());
		}
		else
		{
			damage = player.getCapability(ModCapabilities.PLAYER_STATS, null).getMagic();
		}
		
		switch (player.getCapability(ModCapabilities.DRIVE_STATE, null).getActiveDriveName())
		{
		case Strings.Form_Wisdom:
			damage = damage * 2;
			break;
		case Strings.Form_Master:
			damage = (float) (damage * 2.25);
			break;
		case Strings.Form_Final:
			damage = (float) (damage * 2.5);
			break;
		}
		
		switch (suffix)
		{
		case "normal":
			finalDamage = damage;		
			break;
		case "ra":
			finalDamage = (float) (damage + (0.1 * damage));
			break;
		case "ga":
			finalDamage = (float) (damage + (0.2 * damage));
			break;
		}
		System.out.println(finalDamage);
		return finalDamage;
	}
}
