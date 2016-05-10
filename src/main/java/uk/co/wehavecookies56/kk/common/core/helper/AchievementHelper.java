package uk.co.wehavecookies56.kk.common.core.helper;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.stats.Achievement;

public class AchievementHelper {

	public static void addAchievement (EntityPlayer player, Achievement achievement) {
		player.addStat(achievement);
	}

	public static void displayAchievement (Achievement achievement) {
		Minecraft.getMinecraft().guiAchievement.displayAchievement(achievement);
	}

}
