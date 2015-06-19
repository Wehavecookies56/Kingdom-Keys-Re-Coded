package wehavecookies56.kk.util;

import wehavecookies56.kk.client.gui.GuiMenu;
import wehavecookies56.kk.client.gui.GuiReports;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;

public class GuiHelper {

	public static void openMenu(EntityPlayer player){
		Minecraft.getMinecraft().displayGuiScreen(new GuiMenu());
	}
	
	public static void openBook(){
		Minecraft.getMinecraft().displayGuiScreen(new GuiReports());
	}
}
