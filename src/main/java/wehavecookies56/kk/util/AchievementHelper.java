package wehavecookies56.kk.util;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.stats.Achievement;

public class AchievementHelper {

	public static void addAchievement(EntityPlayer player, Achievement achievement){
		player.addStat(achievement, 1);
	}

		Minecraft.getMinecraft().guiAchievement.displayAchievement(achievement);
	}

}

