package wehavecookies56.kk.api.driveforms;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import wehavecookies56.kk.entities.ExtendedPlayer;

public abstract class DriveForm {

	public abstract String getName();

	public abstract ResourceLocation getTexture();

	public abstract double getCost();

	public abstract void initDrive(EntityPlayer player);

	public abstract void update(EntityPlayer player);

	public abstract void endDrive(EntityPlayer player);

}
