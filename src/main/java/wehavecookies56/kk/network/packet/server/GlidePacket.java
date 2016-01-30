package wehavecookies56.kk.network.packet.server;

import java.io.IOException;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.network.PacketBuffer;
import net.minecraftforge.fml.relauncher.Side;
import wehavecookies56.kk.driveforms.DriveFormFinal;
import wehavecookies56.kk.network.packet.AbstractMessage.AbstractServerMessage;

public class GlidePacket extends AbstractServerMessage<GlidePacket> {

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
