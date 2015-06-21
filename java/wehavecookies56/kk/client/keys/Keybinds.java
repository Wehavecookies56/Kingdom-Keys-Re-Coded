package wehavecookies56.kk.client.keys;

import net.minecraft.client.settings.KeyBinding;

import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;

public enum Keybinds {

	OPENMENU("key.kingdomkeys.openmenu", Keyboard.KEY_M),
	SCROLL_UP("key.kingdomkeys.scrollup", Keyboard.KEY_UP),
	SCROLL_DOWN("key.kingdomkeys.scrolldown", Keyboard.KEY_DOWN),
	ENTER("key.kingdomkeys.enter", Keyboard.KEY_RIGHT),
	BACK("key.kingdomkeys.back", Keyboard.KEY_LEFT),
	SCROLL_ACTIVATOR("key.kingdomkeys.scrollactivator", Keyboard.KEY_LMENU);
	
	private final KeyBinding keybinding;
	
	private Keybinds(String name, int defaultKey){
		keybinding = new KeyBinding(name, defaultKey, "key.categories.kingdomkeys");
	}
	
	public KeyBinding getKeybind(){
		return keybinding;
	}
	
	public boolean isPressed(){
		return keybinding.isPressed();
	}
	
}
