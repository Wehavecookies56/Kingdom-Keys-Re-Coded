package wehavecookies56.kk.network.packet.server;

import java.io.IOException;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.network.PacketBuffer;
import net.minecraftforge.fml.relauncher.Side;
import wehavecookies56.kk.KingdomKeys;
import wehavecookies56.kk.network.packet.AbstractMessage.AbstractServerMessage;

public class OpenGui extends AbstractServerMessage<OpenGui> {

	private int id;

	public OpenGui() {
	}

	public OpenGui(int id) {
		this.id = id;
	}

	@Override
	protected void read(PacketBuffer buffer) throws IOException {
		id = buffer.readInt();
	}

	@Override
	protected void write(PacketBuffer buffer) throws IOException {
		buffer.writeInt(id);
	}

	@Override
	public void process(EntityPlayer player, Side side) {
		player.openGui(KingdomKeys.instance, this.id, player.worldObj, (int) player.posX, (int) player.posY,
				(int) player.posZ);
	}

}
