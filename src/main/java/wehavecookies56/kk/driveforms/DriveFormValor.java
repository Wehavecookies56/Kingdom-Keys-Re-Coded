package wehavecookies56.kk.driveforms;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.ResourceLocation;
import wehavecookies56.kk.api.driveforms.DriveForm;
import wehavecookies56.kk.entities.ExtendedPlayer;
import wehavecookies56.kk.lib.Reference;
import wehavecookies56.kk.network.packet.PacketDispatcher;
import wehavecookies56.kk.network.packet.server.ChangeDP;

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
	public double getCost() {
		return 300;
	}

	@Override
	public void initDrive(EntityPlayer player) {
		ExtendedPlayer.get(player).setInDrive(true);
	}

	@Override
	public void update(EntityPlayer player) {

		if(player.onGround && !player.isInWater())
		{
			player.motionX *= 1.3D;
			player.motionZ *= 1.3D;
		}

		if(player.motionY > 0)
		{
			player.motionY *= 1.2D;
		}
		player.addPotionEffect(new PotionEffect(Potion.damageBoost.getId(),2,2));
		if(ExtendedPlayer.get(player).getInDrive())
		{
			//System.out.println("Valor update: "+ ExtendedPlayer.get(player).getAntiPoints());
			if(ExtendedPlayer.get(player).getDP() > 1)
			{
				PacketDispatcher.sendToServer(new ChangeDP(1.0, "-"));
			}
			else
			{
				endDrive(player);
			}
		}
	}

	@Override
	public void endDrive(EntityPlayer player) {
		ExtendedPlayer.get(player).setInDrive(false);
	}

}
