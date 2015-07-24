package wehavecookies56.kk.driveforms;

import static wehavecookies56.kk.api.driveforms.DriveFormRegistry.*;

public class ModDriveForms 
{
	public static void init()
	{
		registerDriveForm(new DriveFormValor());
		registerDriveForm(new DriveFormWisdom());
		registerDriveForm(new DriveFormLimit());
		registerDriveForm(new DriveFormMaster());
		registerDriveForm(new DriveFormFinal());
		registerDriveForm(new DriveFormAnti());
	}
}
