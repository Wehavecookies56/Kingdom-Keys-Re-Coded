package uk.co.wehavecookies56.kk.client.core.helper;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.inventory.GuiInventory;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import uk.co.wehavecookies56.kk.client.gui.GuiJournal;
import uk.co.wehavecookies56.kk.client.gui.GuiMenu;
import uk.co.wehavecookies56.kk.client.gui.GuiMenu_Config;
import uk.co.wehavecookies56.kk.client.gui.GuiMenu_Items;
import uk.co.wehavecookies56.kk.client.gui.GuiMenu_Items_Player;
import uk.co.wehavecookies56.kk.client.gui.GuiMenu_Status;
import uk.co.wehavecookies56.kk.client.gui.GuiTutorial;
import uk.co.wehavecookies56.kk.common.KingdomKeys;
import uk.co.wehavecookies56.kk.common.capability.ModCapabilities;
import uk.co.wehavecookies56.kk.common.lib.GuiIDs;
import uk.co.wehavecookies56.kk.common.lib.Strings;
import uk.co.wehavecookies56.kk.common.network.packet.PacketDispatcher;
import uk.co.wehavecookies56.kk.common.network.packet.server.OpenGui;

public class GuiHelper {

	public static void openMenu() {
		Minecraft.getMinecraft().displayGuiScreen(new GuiMenu(Strings.Gui_Menu_Main_Title));
	}

	public static void openMenu_Items() {
		Minecraft.getMinecraft().displayGuiScreen(new GuiMenu_Items(Strings.Gui_Menu_Items_Title));
	}

	public static void openMenu_Config() {
		Minecraft.getMinecraft().displayGuiScreen(new GuiMenu_Config(Strings.Gui_Menu_Config_Title));
	}

	public static void openMenu_Items_Player() {
		Minecraft.getMinecraft().displayGuiScreen(new GuiMenu_Items_Player(Strings.Gui_Menu_Items_Title));
	}

	public static void openInv(int id) {
		PacketDispatcher.sendToServer(new OpenGui(id));
	}

	public static void openPlayerInventory(EntityPlayer player) {
		Minecraft.getMinecraft().displayGuiScreen(new GuiInventory(player));
	}

	public static void closeGui() {
		Minecraft.getMinecraft().displayGuiScreen(null);
	}

	public static void openStatus() {
		Minecraft.getMinecraft().displayGuiScreen(new GuiMenu_Status(Strings.Gui_Menu_Main_Title));
	}

	public static void openReports() {
		Minecraft.getMinecraft().displayGuiScreen(new GuiJournal());
	}

	public static void openKKChest(EntityPlayer player, World world, BlockPos pos) {
		player.openGui(KingdomKeys.instance, GuiIDs.GUI_KKCHEST_INV, world, pos.getX(), pos.getY(), pos.getZ());
	}

	public static void openSynthesisBagS(EntityPlayer player, World world, BlockPos pos) {
		player.openGui(KingdomKeys.instance, GuiIDs.GUI_SYNTHESISBAGS_INV, world, pos.getX(), pos.getY(), pos.getZ());
	}

	public static void openTutorial(int num) {
		if (Minecraft.getMinecraft().player != null) {
			if (Minecraft.getMinecraft().player.hasCapability(ModCapabilities.TUTORIALS, null)) {
				if (!Minecraft.getMinecraft().player.getCapability(ModCapabilities.TUTORIALS, null).getKnownTutorial(num)) {
					Minecraft.getMinecraft().displayGuiScreen(new GuiTutorial(num));
				}
			}
		}
	}

	public static void openTutorial(int num, boolean b) {
		if (b)
			Minecraft.getMinecraft().displayGuiScreen(new GuiTutorial(num));
		else{
			openTutorial(num);
		}
	}

}
