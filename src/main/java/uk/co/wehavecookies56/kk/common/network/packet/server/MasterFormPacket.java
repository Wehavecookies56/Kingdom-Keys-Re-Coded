package uk.co.wehavecookies56.kk.common.network.packet.server;

import java.io.IOException;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.network.PacketBuffer;
import net.minecraftforge.fml.relauncher.Side;
import uk.co.wehavecookies56.kk.common.lib.Constants;
import uk.co.wehavecookies56.kk.common.network.packet.AbstractMessage.AbstractServerMessage;

public class MasterFormPacket extends AbstractServerMessage<MasterFormPacket> {

	public MasterFormPacket () {}

	@Override
	protected void read (PacketBuffer buffer) throws IOException {

	}

	@Override
	protected void write (PacketBuffer buffer) throws IOException {

	}

	@Override
	public void process (EntityPlayer player, Side side) {
		if (player != null && player.motionY < 0) player.motionY += Constants.PLAYER_JUMP;
	}

}
