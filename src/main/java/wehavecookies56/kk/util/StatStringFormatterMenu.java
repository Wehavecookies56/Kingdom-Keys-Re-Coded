package wehavecookies56.kk.util;

import org.lwjgl.input.Keyboard;

import net.minecraft.stats.IStatStringFormat;
import wehavecookies56.kk.client.input.Keybinds;

public class StatStringFormatterMenu implements IStatStringFormat {

	@Override
	public String formatString (String s) {
		try {
			return String.format(s, Keyboard.getKeyName(Keybinds.OPENMENU.getKeybind().getKeyCode()));
		} catch (Exception e) {
			return s;
		}
	}

}
