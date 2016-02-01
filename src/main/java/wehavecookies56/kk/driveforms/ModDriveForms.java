package wehavecookies56.kk.driveforms;

import static wehavecookies56.kk.api.driveforms.DriveFormRegistry.registerDriveForm;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import wehavecookies56.kk.api.driveforms.DriveForm;
import wehavecookies56.kk.lib.Strings;
import wehavecookies56.kk.network.packet.PacketDispatcher;
import wehavecookies56.kk.network.packet.server.AntiPoints;
import wehavecookies56.kk.network.packet.server.DriveFormPacket;

public class ModDriveForms {
	
	public static DriveForm Valor, Wisdom, Limit, Master, Final, Anti;
	
	public static void init () {
		Valor = new DriveFormValor(300);
		Wisdom = new DriveFormWisdom(300);
		Limit = new DriveFormLimit(400);
		Master = new DriveFormMaster(400);
		Final = new DriveFormFinal(500);
		Anti = new DriveFormAnti();
		
		registerDriveForm(Valor);
		registerDriveForm(Wisdom);
		registerDriveForm(Limit);
		registerDriveForm(Master);
		registerDriveForm(Final);
		registerDriveForm(Anti);
	}

	public static void getDriveForm (EntityPlayer player, World world, String drive) {
		switch (drive) {
			case Strings.Form_Valor:
				PacketDispatcher.sendToServer(new DriveFormPacket(Strings.Form_Valor));
				PacketDispatcher.sendToServer(new AntiPoints(1, "+"));
				break;
			case Strings.Form_Wisdom:
				PacketDispatcher.sendToServer(new DriveFormPacket(Strings.Form_Wisdom));
				PacketDispatcher.sendToServer(new AntiPoints(1, "+"));
				break;
			case Strings.Form_Limit:
				PacketDispatcher.sendToServer(new DriveFormPacket(Strings.Form_Limit));
				PacketDispatcher.sendToServer(new AntiPoints(1, "+"));
				break;
			case Strings.Form_Master:
				PacketDispatcher.sendToServer(new DriveFormPacket(Strings.Form_Master));
				PacketDispatcher.sendToServer(new AntiPoints(1, "+"));
				break;
			case Strings.Form_Final:
				PacketDispatcher.sendToServer(new DriveFormPacket(Strings.Form_Final));
				PacketDispatcher.sendToServer(new AntiPoints(4, "-"));
				break;
			default:
				break;
		}
	}
}
