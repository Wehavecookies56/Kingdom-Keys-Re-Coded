package uk.co.wehavecookies56.kk.client.core.helper;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.inventory.GuiInventory;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
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

	@SideOnly(Side.CLIENT)
	public static void openMenu() {
		Minecraft.getMinecraft().displayGuiScreen(new GuiMenu());
	}

	@SideOnly(Side.CLIENT)
	public static void openMenu_Items() {
		Minecraft.getMinecraft().displayGuiScreen(new GuiMenu_Items());
	}

	@SideOnly(Side.CLIENT)
	public static void openMenu_Config() {
		Minecraft.getMinecraft().displayGuiScreen(new GuiMenu_Config(Strings.Gui_Menu_Config_Title));
	}

	@SideOnly(Side.CLIENT)
	public static void openMenu_Items_Player() {
		Minecraft.getMinecraft().displayGuiScreen(new GuiMenu_Items_Player());
	}

	public static void openInv(int id) {
		PacketDispatcher.sendToServer(new OpenGui(id));
	}

	@SideOnly(Side.CLIENT)
	public static void openPlayerInventory(EntityPlayer player) {
		Minecraft.getMinecraft().displayGuiScreen(new GuiInventory(player));
	}

	@SideOnly(Side.CLIENT)
	public static void closeGui() {
		Minecraft.getMinecraft().displayGuiScreen(null);
	}

	@SideOnly(Side.CLIENT)
	public static void openStatus() {
		Minecraft.getMinecraft().displayGuiScreen(new GuiMenu_Status(Strings.Gui_Menu_Main_Title));
	}

	@SideOnly(Side.CLIENT)
	public static void openReports() {
		Minecraft.getMinecraft().displayGuiScreen(new GuiJournal());
	}

	public static void openKKChest(EntityPlayer player, World world, BlockPos pos) {
		player.openGui(KingdomKeys.instance, GuiIDs.GUI_KKCHEST_INV, world, pos.getX(), pos.getY(), pos.getZ());
	}

	public static void openSynthesisBagS(EntityPlayer player, World world, BlockPos pos) {
		player.openGui(KingdomKeys.instance, GuiIDs.GUI_SYNTHESISBAGS_INV, world, pos.getX(), pos.getY(), pos.getZ());
	}

	@SideOnly(Side.CLIENT)
	public static void openTutorial(int num) {
		if (Minecraft.getMinecraft().player != null) {
			if (Minecraft.getMinecraft().player.hasCapability(ModCapabilities.TUTORIALS, null)) {
				if (!Minecraft.getMinecraft().player.getCapability(ModCapabilities.TUTORIALS, null).getKnownTutorial(num)) {
					Minecraft.getMinecraft().displayGuiScreen(new GuiTutorial(num));
				}
			}
		}
	}

	@SideOnly(Side.CLIENT)
	public static void openTutorial(int num, boolean b) {
		if (b)
			Minecraft.getMinecraft().displayGuiScreen(new GuiTutorial(num));
		else{
			openTutorial(num);
		}
	}

}
