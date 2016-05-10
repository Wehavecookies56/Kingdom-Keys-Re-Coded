package uk.co.wehavecookies56.kk.common.network.packet.server;

import java.io.IOException;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.network.PacketBuffer;
import net.minecraftforge.fml.relauncher.Side;
import uk.co.wehavecookies56.kk.api.driveforms.DriveForm;
import uk.co.wehavecookies56.kk.api.driveforms.DriveFormRegistry;
import uk.co.wehavecookies56.kk.common.capability.ModCapabilities;
import uk.co.wehavecookies56.kk.common.network.packet.AbstractMessage;
import uk.co.wehavecookies56.kk.common.network.packet.PacketDispatcher;
import uk.co.wehavecookies56.kk.common.network.packet.client.SyncDriveData;

public class DriveFormPacket extends AbstractMessage.AbstractServerMessage<DriveFormPacket> {

	public DriveFormPacket () {}

	boolean revert;
	String form;
	DriveForm df;

	public DriveFormPacket (Boolean revert) {
		this.revert = revert;
		this.form = "";
	}

	public DriveFormPacket (String driveform) {
		this.form = driveform;
		this.revert = false;
	}

	@Override
	protected void read (PacketBuffer buffer) throws IOException {
		this.form = buffer.readStringFromBuffer(100);
		this.revert = buffer.readBoolean();
	}

	@Override
	protected void write (PacketBuffer buffer) throws IOException {
		buffer.writeString(form);
		buffer.writeBoolean(revert);
	}

	@Override
	public void process (EntityPlayer player, Side side) {
		if (this.revert) {
			player.getCapability(ModCapabilities.DRIVE_STATE, null).setInDrive(false);
			player.getCapability(ModCapabilities.DRIVE_STATE, null).setActiveDriveName("none");
			if (!player.getCapability(ModCapabilities.CHEAT_MODE, null).getCheatMode()) player.getCapability(ModCapabilities.PLAYER_STATS, null).setDP(0);
			PacketDispatcher.sendTo(new SyncDriveData(player.getCapability(ModCapabilities.DRIVE_STATE, null), player.getCapability(ModCapabilities.PLAYER_STATS, null)), (EntityPlayerMP) player);
		}
		if (DriveFormRegistry.isDriveFormRegistered(form)) DriveFormRegistry.get(form).initDrive(player);
	}
}
