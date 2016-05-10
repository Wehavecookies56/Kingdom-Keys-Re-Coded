package uk.co.wehavecookies56.kk.common.core.helper;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.translation.I18n;

public class TextHelper {

	/**
	 * Enable Localizationizing
	 */
	public static String localize (String key) {
		return I18n.translateToLocal(key);
	}

	/**
	 * Send message in the chat with formatting
	 */
	public static void sendFormattedChatMessage (String message, TextFormatting formatting, EntityPlayer player) {
		String s = "";
		String[] m = message.split(" ");
		for (String t : m) {
			s += formatting;
			s += t;
			s += " ";
		}
		player.addChatMessage(new TextComponentString(s));
	}

	/**
	 * Send message in the chat
	 */
	public static void sendChatMessage (String message, EntityPlayer player) {
		player.addChatMessage(new TextComponentString(message));
	}
}
