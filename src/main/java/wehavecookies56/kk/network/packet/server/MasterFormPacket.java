package wehavecookies56.kk.network.packet.server;

import java.io.IOException;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.network.PacketBuffer;
import net.minecraftforge.common.ForgeHooks;
import net.minecraftforge.fml.relauncher.Side;
import wehavecookies56.kk.lib.Constants;
import wehavecookies56.kk.network.packet.AbstractMessage.AbstractServerMessage;

public class MasterFormPacket extends AbstractServerMessage<MasterFormPacket> {

	public MasterFormPacket() {}

	@Override
	protected void read(PacketBuffer buffer) throws IOException {

	}

	@Override
	protected void write(PacketBuffer buffer) throws IOException {

	}

	@Override
	public void process(EntityPlayer player, Side side) {
		if(player != null && player.motionY<0){
			player.motionY += Constants.PLAYER_JUMP;
		}
	}

}
