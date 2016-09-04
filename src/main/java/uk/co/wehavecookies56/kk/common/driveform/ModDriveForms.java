package uk.co.wehavecookies56.kk.common.driveform;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import uk.co.wehavecookies56.kk.api.driveforms.DriveForm;
import uk.co.wehavecookies56.kk.api.driveforms.DriveFormRegistry;
import uk.co.wehavecookies56.kk.common.lib.Strings;
import uk.co.wehavecookies56.kk.common.network.packet.PacketDispatcher;
import uk.co.wehavecookies56.kk.common.network.packet.server.AntiPoints;
import uk.co.wehavecookies56.kk.common.network.packet.server.DriveFormPacket;

public class ModDriveForms {
	
	public static DriveForm Valor, Wisdom, Limit, Master, Final, Anti;
	
	public static void init () {
		Valor = new DriveFormValor(300);
		Wisdom = new DriveFormWisdom(300);
		Limit = new DriveFormLimit(400);
		Master = new DriveFormMaster(400);
		Final = new DriveFormFinal(500);
		Anti = new DriveFormAnti(1000);
		
		DriveFormRegistry.registerDriveForm(Valor);
		DriveFormRegistry.registerDriveForm(Wisdom);
		DriveFormRegistry.registerDriveForm(Limit);
		DriveFormRegistry.registerDriveForm(Master);
		DriveFormRegistry.registerDriveForm(Final);
		DriveFormRegistry.registerDriveForm(Anti);
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
