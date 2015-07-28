package wehavecookies56.kk.driveforms;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import wehavecookies56.kk.api.driveforms.DriveForm;
import wehavecookies56.kk.entities.ExtendedPlayer;
import wehavecookies56.kk.lib.Reference;
import wehavecookies56.kk.network.packet.PacketDispatcher;
import wehavecookies56.kk.network.packet.server.ChangeDP;

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
	public double getCost() {
		return 0;
	}

	@Override
	public void initDrive(EntityPlayer player) {
		ExtendedPlayer.get(player).setInDrive(true);
	}

	@Override
	public void update(EntityPlayer player) {
		System.out.println("Drive: "+ ExtendedPlayer.get(player).getDriveInUse());
		if(!ExtendedPlayer.get(player).cheatMode){
			if(ExtendedPlayer.get(player).getDP() > 0)
			{
				PacketDispatcher.sendToServer(new ChangeDP(0.01, "-"));
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
