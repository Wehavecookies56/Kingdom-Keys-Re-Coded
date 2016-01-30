package wehavecookies56.kk.client.input;

import org.lwjgl.input.Keyboard;

import net.minecraft.client.settings.KeyBinding;

public enum Keybinds {

	OPENMENU ("key.kingdomkeys.openmenu", Keyboard.KEY_M), SCROLL_UP ("key.kingdomkeys.scrollup", Keyboard.KEY_UP), SCROLL_DOWN ("key.kingdomkeys.scrolldown", Keyboard.KEY_DOWN), ENTER ("key.kingdomkeys.enter", Keyboard.KEY_RIGHT), BACK ("key.kingdomkeys.back", Keyboard.KEY_LEFT), SCROLL_ACTIVATOR ("key.kingdomkeys.scrollactivator", Keyboard.KEY_LMENU), SUMMON_KEYBLADE ("key.kingdomkeys.summonkeyblade", Keyboard.KEY_G);

	private final KeyBinding keybinding;

	private Keybinds (String name, int defaultKey) {
		keybinding = new KeyBinding(name, defaultKey, "key.categories.kingdomkeys");
	}

	public KeyBinding getKeybind () {
		return keybinding;
	}

	public boolean isPressed () {
		return keybinding.isPressed();
	}

}
