package wehavecookies56.kk.driveforms;

import static wehavecookies56.kk.api.driveforms.DriveFormRegistry.registerDriveForm;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import wehavecookies56.kk.network.packet.PacketDispatcher;
import wehavecookies56.kk.network.packet.server.AntiPoints;
import wehavecookies56.kk.network.packet.server.DriveFormPacket;

public class ModDriveForms {
	public static void init () {
		registerDriveForm(new DriveFormValor(300));
		registerDriveForm(new DriveFormWisdom(300));
		registerDriveForm(new DriveFormLimit(400));
		registerDriveForm(new DriveFormMaster(400));
		registerDriveForm(new DriveFormFinal(500));
		registerDriveForm(new DriveFormAnti());
	}

	public static void getDriveForm (EntityPlayer player, World world, String drive) {
		switch (drive) {
			case "gui.commandmenu.drive.valor":
				PacketDispatcher.sendToServer(new DriveFormPacket("Valor"));
				PacketDispatcher.sendToServer(new AntiPoints(1, "+"));
				break;
			case "gui.commandmenu.drive.wisdom":
				PacketDispatcher.sendToServer(new DriveFormPacket("Wisdom"));
				PacketDispatcher.sendToServer(new AntiPoints(1, "+"));
				break;
			case "gui.commandmenu.drive.limit":
				PacketDispatcher.sendToServer(new DriveFormPacket("Limit"));
				PacketDispatcher.sendToServer(new AntiPoints(1, "+"));
				break;
			case "gui.commandmenu.drive.master":
				PacketDispatcher.sendToServer(new DriveFormPacket("Master"));
				PacketDispatcher.sendToServer(new AntiPoints(1, "+"));
				break;
			case "gui.commandmenu.drive.final":
				PacketDispatcher.sendToServer(new DriveFormPacket("Final"));
				PacketDispatcher.sendToServer(new AntiPoints(4, "-"));
				break;
			default:
				break;
		}
	}
}
