package wehavecookies56.kk.driveforms;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import wehavecookies56.kk.api.driveforms.DriveForm;
import wehavecookies56.kk.entities.ExtendedPlayer;
import wehavecookies56.kk.lib.Reference;
import wehavecookies56.kk.network.packet.PacketDispatcher;
import wehavecookies56.kk.network.packet.client.SpawnDriveFormParticles;
import wehavecookies56.kk.network.packet.server.ChangeDP;
import wehavecookies56.kk.network.packet.server.MasterFormPacket;
import wehavecookies56.kk.util.SoundHelper;

public class DriveFormMaster extends DriveForm {

	double cost;

	public DriveFormMaster(double cost) {
		this.cost = cost;
	}
	int jumps = 0;
	@Override
	public String getName() {
		return "Master";
	}

	@Override
	public ResourceLocation getTexture() {
		return new ResourceLocation(Reference.MODID, "textures/driveforms/master.png");
	}

	@Override
	public double getCost() {
		return this.cost;
	}

	@Override
	public void initDrive(EntityPlayer player) {
		ExtendedPlayer.get(player).setDriveInUse(getName());
		ExtendedPlayer.get(player).setInDrive(true);
		PacketDispatcher.sendToAllAround(new SpawnDriveFormParticles(player), player, 64.0D);
		SoundHelper.playSoundAtEntity(player.worldObj, player, SoundHelper.Drive, 0.5f, 1);
	}

	@Override
	public void update(EntityPlayer player) {
		if(player.onGround && !player.isInWater()){
			player.motionX *= 1.18D;
			player.motionZ *= 1.18D;
		}
		else if(!player.onGround)
		{
			if(player.motionY > 0)
			{
				player.motionY *= 1.05D;
			}
		}

		if(player.onGround)
		{
			jumps = 0;
		}
		else
		{
			if(player.worldObj.isRemote){
				if(player.motionY < 0 && Minecraft.getMinecraft().gameSettings.keyBindJump.isPressed())
				{
					if(this.jumps<1)
					{
						this.jumps++;
						player.jump();
						PacketDispatcher.sendToServer(new MasterFormPacket());
					}
				}
			}
		}

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
