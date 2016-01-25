package wehavecookies56.kk.driveforms;

import static wehavecookies56.kk.api.driveforms.DriveFormRegistry.registerDriveForm;

public class ModDriveForms
{
	public static void init()
	{
		registerDriveForm(new DriveFormValor(300));
		registerDriveForm(new DriveFormWisdom(300));
		registerDriveForm(new DriveFormLimit(400));
		registerDriveForm(new DriveFormMaster(400));
		registerDriveForm(new DriveFormFinal(500));
		registerDriveForm(new DriveFormAnti());
	}
}
