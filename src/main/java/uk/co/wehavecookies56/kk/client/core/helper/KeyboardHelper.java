package uk.co.wehavecookies56.kk.client.core.helper;

import org.lwjgl.input.Keyboard;

import uk.co.wehavecookies56.kk.client.core.handler.InputHandler;

public class KeyboardHelper {

    // Call these to detect if a key is pressed. To add more keys, follow the
    // same format.

    public static boolean isShiftDown () {
        return Keyboard.isKeyDown(Keyboard.KEY_LSHIFT) || Keyboard.isKeyDown(Keyboard.KEY_RSHIFT);
    }

    public static boolean isControlDown () {
        return Keyboard.isKeyDown(Keyboard.KEY_LCONTROL) || Keyboard.isKeyDown(Keyboard.KEY_RCONTROL);
    }

    public static boolean isScrollActivatorDown () {
        return Keyboard.isKeyDown(InputHandler.Keybinds.SCROLL_ACTIVATOR.getKeybind().getKeyCode());
    }

}
