package wehavecookies56.kk.util;

import wehavecookies56.kk.KingdomKeys;
import wehavecookies56.kk.client.gui.GuiJournal;
import wehavecookies56.kk.client.gui.GuiMenu;
import wehavecookies56.kk.client.gui.GuiMenu_Items;
import wehavecookies56.kk.client.gui.GuiReports;
import wehavecookies56.kk.lib.Strings;
import wehavecookies56.kk.network.packet.PacketDispatcher;
import wehavecookies56.kk.network.packet.server.OpenGui;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.inventory.GuiInventory;
import net.minecraft.entity.player.EntityPlayer;

public class GuiHelper {

	public static void openMenu(){
		Minecraft.getMinecraft().displayGuiScreen(new GuiMenu(Strings.Gui_Menu_Main_Title));
	}

	public static void openMenu_Items(){
		Minecraft.getMinecraft().displayGuiScreen(new GuiMenu_Items(Strings.Gui_Menu_Items_Title));
	}

	public static void openInv(int id){
		PacketDispatcher.sendToServer(new OpenGui(id));
	}

	public static void openPlayerInventory(EntityPlayer player){
		Minecraft.getMinecraft().displayGuiScreen(new GuiInventory(player));
	}

	public static void closeGui(){
		Minecraft.getMinecraft().displayGuiScreen(null);
	}

	public static void openReports(){
		Minecraft.getMinecraft().displayGuiScreen(new GuiJournal());
	}
}
