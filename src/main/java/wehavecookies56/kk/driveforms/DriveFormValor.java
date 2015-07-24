package wehavecookies56.kk.driveforms;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import wehavecookies56.kk.api.driveforms.DriveForm;
import wehavecookies56.kk.entities.ExtendedPlayer;
import wehavecookies56.kk.lib.Reference;

public class DriveFormValor extends DriveForm {

	public DriveFormValor() {

	}

	@Override
	public String getName() {
		return "Valor";
	}

	@Override
	public ResourceLocation getTexture() {
		return new ResourceLocation(Reference.MODID, "textures/driveforms/valor.png");
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
		System.out.println("Valor update: "+ ExtendedPlayer.get(Minecraft.getMinecraft().thePlayer).getInDrive());
	}

	@Override
	public void endDrive(EntityPlayer player) {
		ExtendedPlayer.get(player).setInDrive(false);
	}

}
