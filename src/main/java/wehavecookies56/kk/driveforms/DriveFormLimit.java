package wehavecookies56.kk.driveforms;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import wehavecookies56.kk.api.driveforms.DriveForm;
import wehavecookies56.kk.entities.ExtendedPlayer;
import wehavecookies56.kk.lib.Reference;
import wehavecookies56.kk.network.packet.PacketDispatcher;
import wehavecookies56.kk.network.packet.server.ChangeDP;
import wehavecookies56.kk.util.SoundHelper;

public class DriveFormLimit extends DriveForm {

	double cost;

	public DriveFormLimit(double cost) {
		this.cost = cost;
	}

	@Override
	public String getName() {
		return "Limit";
	}

	@Override
	public ResourceLocation getTexture() {
		return new ResourceLocation(Reference.MODID, "textures/driveforms/limit.png");
	}

	@Override
	public double getCost() {
		return this.cost;
	}

	@Override
	public void initDrive(EntityPlayer player) {
		ExtendedPlayer.get(player).setDriveInUse(getName());
		ExtendedPlayer.get(player).setInDrive(true);
		Minecraft.getMinecraft().theWorld.playSound(Minecraft.getMinecraft().thePlayer.posX, Minecraft.getMinecraft().thePlayer.posY, Minecraft.getMinecraft().thePlayer.posZ, SoundHelper.Drive, 1f, 1f, false);

	}

	@Override
	public void update(EntityPlayer player) {
		if(ExtendedPlayer.get(player).cheatMode == false)
		{
			if(ExtendedPlayer.get(player).dp > 0)
			{
				ExtendedPlayer.get(player).dp -= 0.1;
				if(ExtendedPlayer.get(player).dp < 0)
				{
					ExtendedPlayer.get(player).dp = 0;
				}
			}
			else
			{
				endDrive(player);
			}
		}
	}

	@Override
	public void endDrive(EntityPlayer player) {
		ExtendedPlayer.get(player).setDP(0);
		ExtendedPlayer.get(player).setInDrive(false);
		ExtendedPlayer.get(player).setDriveInUse("none");
	}
}
