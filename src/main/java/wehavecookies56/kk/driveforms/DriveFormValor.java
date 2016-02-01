package wehavecookies56.kk.driveforms;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import wehavecookies56.kk.api.driveforms.DriveForm;
import wehavecookies56.kk.entities.ExtendedPlayer;
import wehavecookies56.kk.lib.Constants;
import wehavecookies56.kk.lib.Reference;
import wehavecookies56.kk.lib.Strings;
import wehavecookies56.kk.network.packet.PacketDispatcher;
import wehavecookies56.kk.network.packet.client.SpawnDriveFormParticles;
import wehavecookies56.kk.util.SoundHelper;

public class DriveFormValor extends DriveForm {

	double cost;

	public DriveFormValor (double cost) {
		this.cost = cost;
	}

	@Override
	public String getName () {
		return Strings.Form_Valor;
	}

	@Override
	public ResourceLocation getTexture () {
		return new ResourceLocation(Reference.MODID, "textures/driveforms/valor.png");
	}

	@Override
	public double getCost () {
		return this.cost;
	}

	@Override
	public void initDrive (EntityPlayer player) {
		ExtendedPlayer.get(player).setDriveInUse(getName());
		ExtendedPlayer.get(player).setInDrive(true);
		PacketDispatcher.sendToAllAround(new SpawnDriveFormParticles(player), player, 64.0D);
		SoundHelper.playSoundAtEntity(player.worldObj, player, SoundHelper.Drive, 0.5f, 1);
	}

	@Override
	public void update (EntityPlayer player) {
		if (player.onGround && !player.isInWater()) {
			player.motionX *= Constants.VALOR_SPEED;
			player.motionZ *= Constants.VALOR_SPEED;
		}

		if (player.motionY > 0) player.motionY *= Constants.VALOR_JUMP_1;

		if (ExtendedPlayer.get(player).cheatMode == false) if (ExtendedPlayer.get(player).dp > 0) {
			ExtendedPlayer.get(player).dp -= 0.1;
			if (ExtendedPlayer.get(player).dp < 0) ExtendedPlayer.get(player).dp = 0;
		} else
			endDrive(player);
	}

	@Override
	public void endDrive (EntityPlayer player) {
		ExtendedPlayer.get(player).setDP(0);
		ExtendedPlayer.get(player).setInDrive(false);
		ExtendedPlayer.get(player).setDriveInUse("none");
	}

}
