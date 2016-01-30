package wehavecookies56.kk.api.driveforms;

import java.util.HashMap;
import java.util.Map;

import com.google.common.collect.ImmutableMap;

import net.minecraft.entity.player.EntityPlayer;
import wehavecookies56.kk.entities.ExtendedPlayer;

public class DriveFormRegistry {

	private static Map<String, DriveForm> driveFormMap = new HashMap<String, DriveForm>();

	public static Map<String, DriveForm> getDriveFormMap () {
		return ImmutableMap.copyOf(driveFormMap);
	}

	public static boolean registerDriveForm (DriveForm driveForm) {
		if (isDriveFormRegistered(driveForm.getName())) return false;
		driveFormMap.put(driveForm.getName(), driveForm);
		return true;
	}

	public static boolean isDriveFormRegistered (DriveForm driveForm) {
		return isDriveFormRegistered(driveForm.getName());
	}

	public static boolean isDriveFormRegistered (String name) {
		return driveFormMap.containsKey(name);
	}

	public static DriveForm get (String name) {
		return driveFormMap.get(name);
	}

	public static boolean learnDriveForm (EntityPlayer player, String name) {
		if (player != null && !isDriveFormKnown(player, name)) {
			DriveForm driveForm = driveFormMap.get(name);
			ExtendedPlayer.get(player).learnDriveForm(driveForm);
			return true;
		}
		return false;
	}

	public static boolean isDriveFormKnown (EntityPlayer player, String name) {
		if (ExtendedPlayer.get(player) != null) {
			ExtendedPlayer.get(player);
			return ExtendedPlayer.driveForms.contains(name);
		}
		return false;
	}

}
