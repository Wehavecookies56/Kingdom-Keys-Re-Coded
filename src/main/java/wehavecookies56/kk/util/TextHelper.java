package wehavecookies56.kk.util;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.StatCollector;

public class TextHelper {
	/**
	 * Color Coding
	 */
	public static final String BLACK = (char) 167 + "0";
	public static final String BLUE = (char) 167 + "1";
	public static final String GREEN = (char) 167 + "2";
	public static final String TEAL = (char) 167 + "3";
	public static final String RED = (char) 167 + "4";
	public static final String PURPLE = (char) 167 + "5";
	public static final String ORANGE = (char) 167 + "6";
	public static final String LIGHT_GRAY = (char) 167 + "7";
	public static final String GRAY = (char) 167 + "8";
	public static final String LIGHT_BLUE = (char) 167 + "9";
	public static final String BRIGHT_GREEN = (char) 167 + "a";
	public static final String BRIGHT_BLUE = (char) 167 + "b";
	public static final String LIGHT_RED = (char) 167 + "c";
	public static final String PINK = (char) 167 + "d";
	public static final String YELLOW = (char) 167 + "e";
	public static final String WHITE = (char) 167 + "f";

	/**
	 * Text formatting
	 */
	public static final String OBFUSCATED = (char) 167 + "k";
	public static final String BOLD = (char) 167 + "l";
	public static final String STRIKETHROUGH = (char) 167 + "m";
	public static final String UNDERLINE = (char) 167 + "n";
	public static final String ITALIC = (char) 167 + "o";
	public static final String END = (char) 167 + "r";

	/**
	 * Enable Localizationizing
	 */
	public static String localize(String key) {
		return StatCollector.translateToLocal(key);
	}

	/**
	 * Send message in the chat with formatting
	 */
	public static void sendFormattedChatMessage(String message, EnumChatFormatting formatting, EntityPlayer player) {
		String s = "";
		String[] m = message.split(" ");
		for (String t : m) {
			s += formatting;
			s += t;
			s += " ";
		}
		player.addChatMessage(new ChatComponentText(s));
	}

	/**
	 * Send message in the chat
	 */
	public static void sendChatMessage(String message, EntityPlayer player) {
		player.addChatMessage(new ChatComponentText(message));
	}
}
