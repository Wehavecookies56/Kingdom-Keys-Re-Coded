package wehavecookies56.kk.client.keys;

import wehavecookies56.kk.client.gui.GuiCommandMenu;
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
					//GuiHelper.openBook();
					GuiHelper.openMenu(Minecraft.getMinecraft().thePlayer);
					break;
				case SCROLL_UP:
					if(GuiCommandMenu.submenu == GuiCommandMenu.SUB_MAIN) //Mainmenu
					{
						if(GuiCommandMenu.selected == GuiCommandMenu.ATTACK){
							GuiCommandMenu.selected = GuiCommandMenu.DRIVE;
						}else{
							GuiCommandMenu.selected++;
						}
					}

					else if(GuiCommandMenu.submenu == GuiCommandMenu.SUB_MAGIC)//InsideMagic
					{
						if(GuiCommandMenu.magicselected == GuiCommandMenu.FIRE){
							GuiCommandMenu.magicselected = GuiCommandMenu.STOP;
						}else{
							GuiCommandMenu.magicselected++;
						}
					}
					
					else if(GuiCommandMenu.submenu == GuiCommandMenu.SUB_ITEMS)//InsideItems
					{
						
					}
					
					else if(GuiCommandMenu.submenu == GuiCommandMenu.SUB_DRIVE)//InsideDrive
					{
						if(GuiCommandMenu.driveselected == GuiCommandMenu.VALOR){
							GuiCommandMenu.driveselected = GuiCommandMenu.FINAL;
						}else{
							GuiCommandMenu.driveselected--;
						}
					}
					
					break;
				case SCROLL_DOWN:
					if(GuiCommandMenu.submenu == GuiCommandMenu.SUB_MAIN) //Mainmenu
					{
						if(GuiCommandMenu.selected == GuiCommandMenu.DRIVE){
							GuiCommandMenu.selected = GuiCommandMenu.ATTACK;
						}else{
							GuiCommandMenu.selected--;
						}
					}

					else if(GuiCommandMenu.submenu == GuiCommandMenu.SUB_MAGIC)//InsideMagic
					{
						if(GuiCommandMenu.magicselected == GuiCommandMenu.STOP){
							GuiCommandMenu.magicselected = GuiCommandMenu.FIRE;
						}else{
							GuiCommandMenu.magicselected++;
						}
					}
					
					else if(GuiCommandMenu.submenu == GuiCommandMenu.SUB_ITEMS)//InsideItems
					{
						
					}
					
					else if(GuiCommandMenu.submenu == GuiCommandMenu.SUB_DRIVE)//InsideDrive
					{
						if(GuiCommandMenu.driveselected == GuiCommandMenu.FINAL){
							GuiCommandMenu.driveselected = GuiCommandMenu.VALOR;
						}else{
							GuiCommandMenu.driveselected++;
						}
					}
					break;
				
				case ENTER:
					switch(GuiCommandMenu.selected)
					{
					case GuiCommandMenu.MAGIC:
						GuiCommandMenu.magicselected = GuiCommandMenu.FIRE;
						GuiCommandMenu.submenu = GuiCommandMenu.SUB_MAGIC;
						break;
					
					case GuiCommandMenu.ITEMS:
						GuiCommandMenu.submenu = GuiCommandMenu.SUB_ITEMS;
						break;
					
					case GuiCommandMenu.DRIVE:
						GuiCommandMenu.submenu = GuiCommandMenu.SUB_DRIVE;
						break;
					}
					break;
				
				case BACK:
					if (GuiCommandMenu.submenu == GuiCommandMenu.SUB_MAIN)
					{
						GuiCommandMenu.submenu = GuiCommandMenu.SUB_MAIN;
					}
					else if (GuiCommandMenu.submenu == GuiCommandMenu.SUB_MAGIC)
					{
						GuiCommandMenu.submenu = GuiCommandMenu.SUB_MAIN;
					}
					else if (GuiCommandMenu.submenu == GuiCommandMenu.SUB_ITEMS)
					{
						GuiCommandMenu.submenu = GuiCommandMenu.SUB_MAIN;
					}
					else if (GuiCommandMenu.submenu == GuiCommandMenu.SUB_DRIVE)
					{
						GuiCommandMenu.submenu = GuiCommandMenu.SUB_MAIN;
					}
					GuiCommandMenu.magicselected = GuiCommandMenu.MAGIC;
					GuiCommandMenu.driveselected = GuiCommandMenu.DRIVE;
					break;
			}
		}
	}
}
