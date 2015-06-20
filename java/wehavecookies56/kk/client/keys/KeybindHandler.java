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
					if(GuiCommandMenu.submenu == 0) //Mainmenu
					{
						if(GuiCommandMenu.selected == GuiCommandMenu.ATTACK){
							GuiCommandMenu.selected = GuiCommandMenu.DRIVE;
							System.out.println("up");
						}else{
							GuiCommandMenu.selected++;
						}
					}

					else if(GuiCommandMenu.submenu == 1)//InsideMagic
					{
						if(GuiCommandMenu.magicselected == GuiCommandMenu.FIRE){
							GuiCommandMenu.magicselected = GuiCommandMenu.STOP;
							System.out.println("UP MAGIC");
						}else{
							GuiCommandMenu.magicselected++;
						}
					}
					
					else if(GuiCommandMenu.submenu == 2)//InsideItems
					{
						
					}
					
					else if(GuiCommandMenu.submenu == 3)//InsideDrive
					{
						if(GuiCommandMenu.driveselected == GuiCommandMenu.VALOR){
							GuiCommandMenu.driveselected = GuiCommandMenu.FINAL;
							System.out.println("UP DRIVE");
						}else{
							GuiCommandMenu.driveselected--;
						}
					}
					
					break;
				case SCROLL_DOWN:
					if(GuiCommandMenu.submenu == 0) //Mainmenu
					{
						if(GuiCommandMenu.selected == GuiCommandMenu.DRIVE){
							GuiCommandMenu.selected = GuiCommandMenu.ATTACK;
							System.out.println("down");
						}else{
							GuiCommandMenu.selected--;
						}
					}

					else if(GuiCommandMenu.submenu == 1)//InsideMagic
					{
						if(GuiCommandMenu.magicselected == GuiCommandMenu.STOP){
							GuiCommandMenu.magicselected = GuiCommandMenu.FIRE;
							System.out.println("DOWN MAGIC");
						}else{
							GuiCommandMenu.magicselected++;
						}
					}
					
					else if(GuiCommandMenu.submenu == 2)//InsideItems
					{
						
					}
					
					else if(GuiCommandMenu.submenu == 3)//InsideDrive
					{
						if(GuiCommandMenu.driveselected == GuiCommandMenu.FINAL){
							GuiCommandMenu.driveselected = GuiCommandMenu.VALOR;
							System.out.println("DOWN DRIVE");
						}else{
							GuiCommandMenu.driveselected++;
						}
					}
					break;
				
				case ENTER:
					switch(GuiCommandMenu.selected)
					{
					case 3:
						System.out.println("magic");
						GuiCommandMenu.submenu = 1;
						break;
					
					case 2:
						System.out.println("items");
						GuiCommandMenu.submenu = 2;
						break;
					
					case 1:
						System.out.println("drive");
						GuiCommandMenu.submenu = 3;
						break;
					}
					break;
				
				case BACK:
					if (GuiCommandMenu.submenu == 0)
					{
						GuiCommandMenu.submenu = 0;
					}
					else if (GuiCommandMenu.submenu == 1)
					{
						GuiCommandMenu.submenu -= 1;
					}
					else if (GuiCommandMenu.submenu == 2)
					{
						GuiCommandMenu.submenu -= 2;
					}
					else if (GuiCommandMenu.submenu == 3)
					{
						GuiCommandMenu.submenu -= 3;
					}
					GuiCommandMenu.magicselected = -1;
					GuiCommandMenu.driveselected = -1;
					break;
			}
		}
	}
}
