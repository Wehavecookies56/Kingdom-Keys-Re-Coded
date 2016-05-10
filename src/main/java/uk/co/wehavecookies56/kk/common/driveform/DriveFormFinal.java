package uk.co.wehavecookies56.kk.common.driveform;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundCategory;
import uk.co.wehavecookies56.kk.api.driveforms.DriveForm;
import uk.co.wehavecookies56.kk.client.sound.ModSounds;
import uk.co.wehavecookies56.kk.common.capability.ModCapabilities;
import uk.co.wehavecookies56.kk.common.lib.Constants;
import uk.co.wehavecookies56.kk.common.lib.Reference;
import uk.co.wehavecookies56.kk.common.lib.Strings;
import uk.co.wehavecookies56.kk.common.network.packet.PacketDispatcher;
import uk.co.wehavecookies56.kk.common.network.packet.client.SpawnDriveFormParticles;
import uk.co.wehavecookies56.kk.common.network.packet.client.SyncDriveData;
import uk.co.wehavecookies56.kk.common.network.packet.server.GlidePacket;

public class DriveFormFinal extends DriveForm {

	double cost;

	public static boolean jumpHeld = false;

	public DriveFormFinal (double cost) {
		this.cost = cost;
	}

	@Override
	public String getName () {
		return Strings.Form_Final;
	}

	@Override
	public ResourceLocation getTexture () {
		return new ResourceLocation(Reference.MODID, "textures/driveform/final.png");
	}

	@Override
	public double getCost () {
		return this.cost;
	}

	@Override
	public void initDrive (EntityPlayer player) {
		player.getCapability(ModCapabilities.DRIVE_STATE, null).setActiveDriveName(getName());
		player.getCapability(ModCapabilities.DRIVE_STATE, null).setInDrive(true);
		PacketDispatcher.sendTo(new SyncDriveData(player.getCapability(ModCapabilities.DRIVE_STATE, null), player.getCapability(ModCapabilities.PLAYER_STATS, null)), (EntityPlayerMP) player);
		PacketDispatcher.sendToAllAround(new SpawnDriveFormParticles(player), player, 64.0D);
		player.worldObj.playSound((EntityPlayer)null, player.getPosition(), ModSounds.drive, SoundCategory.MASTER, 1.0f, 1.0f);
	}

	@Override
	public void update (EntityPlayer player) {
		boolean j = false;
		if(player.worldObj.isRemote)
		{
			j = Minecraft.getMinecraft().gameSettings.keyBindJump.isKeyDown();
		}
		
		if (j)
		{
			if(player.motionY > 0)
			{
				player.motionY += Constants.FINAL_JUMP;
			}
		}

		if (player.onGround && !player.isInWater()) {
			player.motionX *= 1.2D;
			player.motionZ *= 1.2D;
		} else if (player.motionY < 0) if (player.worldObj.isRemote) {
			if (Minecraft.getMinecraft().gameSettings.keyBindJump.isKeyDown()) {
				jumpHeld = true;
				System.out.println(player.getCapability(ModCapabilities.DRIVE_STATE, null).getDriveLevel(Strings.Form_Final));
				switch(player.getCapability(ModCapabilities.DRIVE_STATE, null).getDriveLevel(Strings.Form_Final))
				{
				case 0:
					player.motionY *= Constants.FINAL_GLIDE_1;
					break;
				case 1:
					player.motionY *= Constants.FINAL_GLIDE_2;
					break;
				case 2:
					player.motionY *= Constants.FINAL_GLIDE_3;
					break;
				}
				PacketDispatcher.sendToServer(new GlidePacket(jumpHeld));
			} else {
				jumpHeld = false;
				PacketDispatcher.sendToServer(new GlidePacket(jumpHeld));
			}
		} else if (jumpHeld) 
			{
				switch(player.getCapability(ModCapabilities.DRIVE_STATE, null).getDriveLevel(Strings.Form_Final))
				{
				case 0:
					player.motionY *= Constants.FINAL_GLIDE_1;
					break;
				case 1:
					player.motionY *= Constants.FINAL_GLIDE_2;
					break;
				case 2:
					player.motionY *= Constants.FINAL_GLIDE_3;
					break;
				}
			}

		if (player.getCapability(ModCapabilities.CHEAT_MODE, null).getCheatMode() == false){
			if (player.getCapability(ModCapabilities.PLAYER_STATS, null).getDP() > 0) 
			{
				player.getCapability(ModCapabilities.PLAYER_STATS, null).remDP(0.1);
				if (player.getCapability(ModCapabilities.PLAYER_STATS, null).getDP() < 0) 
				{
					player.getCapability(ModCapabilities.PLAYER_STATS, null).setDP(0);
				}
			}else{
				endDrive(player);
			}
		}
	}

	@Override
	public void endDrive (EntityPlayer player) {
		player.getCapability(ModCapabilities.PLAYER_STATS, null).setDP(0);
		player.getCapability(ModCapabilities.DRIVE_STATE, null).setInDrive(false);
		player.getCapability(ModCapabilities.DRIVE_STATE, null).setActiveDriveName("none");
		if (!player.worldObj.isRemote)
			PacketDispatcher.sendTo(new SyncDriveData(player.getCapability(ModCapabilities.DRIVE_STATE, null), player.getCapability(ModCapabilities.PLAYER_STATS, null)), (EntityPlayerMP) player);
	}

}
