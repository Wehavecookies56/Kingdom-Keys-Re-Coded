package uk.co.wehavecookies56.kk.common.core.helper;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextFormatting;

public class TextHelper {

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
		player.sendMessage(new TextComponentString(s));
	}

	/**
	 * Send message in the chat
	 */
	public static void sendChatMessage (String message, EntityPlayer player) {
		player.sendMessage(new TextComponentString(message));
	}
}
