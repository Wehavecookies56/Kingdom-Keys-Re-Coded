package wehavecookies56.kk.client.keys;

import wehavecookies56.kk.util.GuiHelper;
import net.minecraft.client.Minecraft;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.InputEvent;

public class KeybindHandler {

	private Keybinds getPressedKey(){
		for(Keybinds key : Keybinds.values()){
			if(key.isPressed()) return key;
		}
		return null;
	}
	
	@SubscribeEvent
	public void handleKeyInputEvent(InputEvent.KeyInputEvent event){
		Keybinds key = getPressedKey();
		if(key != null){
			switch(key){
				case OPENMENU:
					GuiHelper.openBook();
					break;
			}
		}
	}
}
