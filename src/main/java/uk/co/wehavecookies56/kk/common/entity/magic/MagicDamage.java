package uk.co.wehavecookies56.kk.common.entity.magic;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.EnumHand;
import uk.co.wehavecookies56.kk.common.capability.ModCapabilities;
import uk.co.wehavecookies56.kk.common.item.base.ItemKeyblade;

public class MagicDamage {
	public static float getMagicDamage(EntityPlayer player, String suffix)
	{
		float damage = 0;
		float finalDamage = 0;
		if(player.getHeldItem(EnumHand.MAIN_HAND).getItem() instanceof ItemKeyblade)
		{
			damage = (float) (((ItemKeyblade) player.getHeldItem(EnumHand.MAIN_HAND).getItem()).getMagic() + player.getCapability(ModCapabilities.PLAYER_STATS, null).getMagic());
		}
		else
		{
			damage = player.getCapability(ModCapabilities.PLAYER_STATS, null).getMagic();
		}
		
		switch (suffix)
		{
		case "normal":
			finalDamage = damage;		
			break;
		case "ra":
			finalDamage = damage + (10/100 * damage);
			break;
		case "ga":
			finalDamage = damage + (20/100 * damage);
			break;
		}
		return finalDamage;
	}
}
