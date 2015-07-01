package wehavecookies56.kk.util;

import net.minecraft.client.Minecraft;
import net.minecraftforge.client.event.MouseEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import wehavecookies56.kk.client.gui.GuiCommandMenu;
import wehavecookies56.kk.client.keys.Keybinds;

public class ScrollHandler {

	public static final int WHEEL_UP = -1;
	public static final int WHEEL_DOWN = 1;

	@SubscribeEvent
	@SideOnly(Side.CLIENT)
	public void OnMouseWheelScroll(MouseEvent event){
		Minecraft mc = Minecraft.getMinecraft();
		if(!mc.inGameHasFocus && !KeyboardHelper.isScrollActivatorDown()){
			event.setCanceled(false);
			return;
		}

		if(event.button == 0 && KeyboardHelper.isScrollActivatorDown()){
			switch(GuiCommandMenu.selected)
			{
			case GuiCommandMenu.ATTACK:
				Minecraft.getMinecraft().thePlayer.swingItem();
				break;
			case GuiCommandMenu.MAGIC:
				GuiCommandMenu.magicselected = GuiCommandMenu.FIRE;
				GuiCommandMenu.submenu = GuiCommandMenu.SUB_MAGIC;
				break;

			case GuiCommandMenu.ITEMS:
				//GuiCommandMenu.submenu = GuiCommandMenu.SUB_ITEMS;
				break;

			case GuiCommandMenu.DRIVE:
				GuiCommandMenu.driveselected = GuiCommandMenu.VALOR;
				GuiCommandMenu.submenu = GuiCommandMenu.SUB_DRIVE;
				break;
			}
			event.setCanceled(true);
		}

		if(event.button == 1 && KeyboardHelper.isScrollActivatorDown()){
			switch(GuiCommandMenu.submenu){
			case GuiCommandMenu.SUB_MAIN:
				GuiCommandMenu.submenu = GuiCommandMenu.SUB_MAIN;
				break;
			case GuiCommandMenu.SUB_MAGIC:
				GuiCommandMenu.submenu = GuiCommandMenu.SUB_MAIN;
				break;
			case GuiCommandMenu.SUB_ITEMS:
				GuiCommandMenu.submenu = GuiCommandMenu.SUB_MAIN;
				break;
			case GuiCommandMenu.SUB_DRIVE:
				GuiCommandMenu.submenu = GuiCommandMenu.SUB_MAIN;
				break;
			}
			GuiCommandMenu.magicselected = GuiCommandMenu.MAGIC;
			GuiCommandMenu.driveselected = GuiCommandMenu.DRIVE;
			event.setCanceled(true);
		}

		if(event.dwheel <= WHEEL_DOWN && KeyboardHelper.isScrollActivatorDown()){
			switch(GuiCommandMenu.submenu){
			case GuiCommandMenu.SUB_MAIN:
				switch(GuiCommandMenu.selected){
				case GuiCommandMenu.DRIVE:
					GuiCommandMenu.selected = GuiCommandMenu.ATTACK;
					break;
				default: 
					GuiCommandMenu.selected--;
					break;
				}
				break;
			case GuiCommandMenu.SUB_MAGIC:
				switch(GuiCommandMenu.magicselected){
				case GuiCommandMenu.STOP:
					GuiCommandMenu.magicselected = GuiCommandMenu.FIRE;
					break;
				default:
					GuiCommandMenu.magicselected--;
					break;
				}
				break;
			case GuiCommandMenu.SUB_ITEMS:
				break;
			case GuiCommandMenu.SUB_DRIVE:
				switch(GuiCommandMenu.driveselected){
				case GuiCommandMenu.FINAL:
					GuiCommandMenu.driveselected = GuiCommandMenu.VALOR;
					break;
				default:
					GuiCommandMenu.driveselected--;
					break;
				}
				break;
			}
			event.setCanceled(true);
		}
		if(event.dwheel >= WHEEL_UP && KeyboardHelper.isScrollActivatorDown()){
			switch(GuiCommandMenu.submenu){
			case GuiCommandMenu.SUB_MAIN:
				switch(GuiCommandMenu.selected){
				case GuiCommandMenu.ATTACK:
					GuiCommandMenu.selected = GuiCommandMenu.DRIVE;
					break;
				default: 
					GuiCommandMenu.selected++;
					break;
				}
				break;
			case GuiCommandMenu.SUB_MAGIC:
				switch(GuiCommandMenu.magicselected){
				case GuiCommandMenu.FIRE:
					GuiCommandMenu.magicselected = GuiCommandMenu.STOP;
					break;
				default:
					GuiCommandMenu.magicselected++;
					break;
				}
				break;
			case GuiCommandMenu.SUB_ITEMS:
				break;
			case GuiCommandMenu.SUB_DRIVE:
				switch(GuiCommandMenu.driveselected){
				case GuiCommandMenu.VALOR:
					GuiCommandMenu.driveselected = GuiCommandMenu.FINAL;
					break;
				default:
					GuiCommandMenu.driveselected++;
					break;
				}
				break;
			}
			event.setCanceled(true);
		}

	}
}
