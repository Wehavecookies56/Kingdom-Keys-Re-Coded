package wehavecookies56.kk.driveforms;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import wehavecookies56.kk.api.driveforms.DriveForm;
import wehavecookies56.kk.entities.ExtendedPlayer;
import wehavecookies56.kk.lib.Reference;

public class DriveFormWisdom extends DriveForm {

	public DriveFormWisdom() {

	}

	@Override
	public String getName() {
		return "Wisdom";
	}

	@Override
	public ResourceLocation getTexture() {
		return new ResourceLocation(Reference.MODID, "textures/driveforms/wisdom.png");
	}

	@Override
	public int getCost() {
		return 300;
	}

	@Override
	public void initDrive(EntityPlayer player) {
		ExtendedPlayer.get(player).setInDrive(true);
	}

	@Override
	public void update(EntityPlayer player) {
		System.out.println("Wisdom update: "+ ExtendedPlayer.get(player).getDP());
		ExtendedPlayer.get(player).removeDP(1);
	}

	@Override
	public void endDrive(EntityPlayer player) {
		ExtendedPlayer.get(player).setInDrive(false);
	}

}
