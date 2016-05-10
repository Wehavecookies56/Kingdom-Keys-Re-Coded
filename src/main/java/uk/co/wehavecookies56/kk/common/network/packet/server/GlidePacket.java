package uk.co.wehavecookies56.kk.common.network.packet.server;

import java.io.IOException;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.network.PacketBuffer;
import net.minecraftforge.fml.relauncher.Side;
import uk.co.wehavecookies56.kk.common.driveform.DriveFormFinal;
import uk.co.wehavecookies56.kk.common.network.packet.AbstractMessage;

public class GlidePacket extends AbstractMessage.AbstractServerMessage<GlidePacket> {

	boolean jumpHeld;

	public GlidePacket () {}

	public GlidePacket (boolean jumpHeld) {
		this.jumpHeld = jumpHeld;
	}

	@Override
	protected void read (PacketBuffer buffer) throws IOException {
		this.jumpHeld = buffer.readBoolean();
	}

	@Override
	protected void write (PacketBuffer buffer) throws IOException {
		buffer.writeBoolean(this.jumpHeld);
	}

	@Override
	public void process (EntityPlayer player, Side side) {
		DriveFormFinal.jumpHeld = this.jumpHeld;
	}

}
