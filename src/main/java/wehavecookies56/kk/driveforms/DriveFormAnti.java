package wehavecookies56.kk.driveforms;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import wehavecookies56.kk.api.driveforms.DriveForm;
import wehavecookies56.kk.entities.ExtendedPlayer;
import wehavecookies56.kk.lib.Reference;

public class DriveFormAnti extends DriveForm {

	public DriveFormAnti() {

	}

	@Override
	public String getName() {
		return "Anti";
	}

	@Override
	public ResourceLocation getTexture() {
		return new ResourceLocation(Reference.MODID, "textures/driveforms/anti.png");
	}

	@Override
	public int getCost() {
		return ExtendedPlayer.get(Minecraft.getMinecraft().thePlayer).getDP();
	}

	@Override
	public void initDrive(EntityPlayer player) {
		ExtendedPlayer.get(player).setInDrive(true);
	}

	@Override
	public void update(EntityPlayer player) {
		System.out.println("Anti update: "+ ExtendedPlayer.get(player).getAntiPoints());
		ExtendedPlayer.get(player).removeDP(1);
	}

	@Override
	public void endDrive(EntityPlayer player) {
		ExtendedPlayer.get(player).setInDrive(false);
	}

}
