package wehavecookies56.kk.api.driveforms;

import net.minecraft.util.ResourceLocation;

public abstract class DriveForm {

	public abstract String getName();

	public abstract ResourceLocation getTexture();

	public abstract int getCost();

	public abstract void initDrive();

	public abstract void update();

}
