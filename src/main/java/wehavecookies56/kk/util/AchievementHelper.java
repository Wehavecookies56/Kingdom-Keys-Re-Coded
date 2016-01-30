package wehavecookies56.kk.util;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.stats.Achievement;

public class AchievementHelper {

	public static void addAchievement (EntityPlayer player, Achievement achievement) {
		player.triggerAchievement(achievement);
	}

	public static void displayAchievement (Achievement achievement) {
		Minecraft.getMinecraft().guiAchievement.displayAchievement(achievement);
	}

}
