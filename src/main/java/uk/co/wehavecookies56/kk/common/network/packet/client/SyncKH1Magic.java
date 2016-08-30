package uk.co.wehavecookies56.kk.common.network.packet.client;

import java.io.IOException;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.network.PacketBuffer;
import net.minecraftforge.fml.relauncher.Side;
import uk.co.wehavecookies56.kk.common.capability.MagicStateCapability.IMagicState;
import uk.co.wehavecookies56.kk.common.capability.ModCapabilities;
import uk.co.wehavecookies56.kk.common.network.packet.AbstractMessage.AbstractClientMessage;

public class SyncKH1Magic extends AbstractClientMessage<SyncKH1Magic> {

	private boolean kh1fire;
	
	public SyncKH1Magic() {}
	
	public SyncKH1Magic(IMagicState stats, boolean kh1Fire) {
		kh1fire = kh1Fire;
	}
	
	@Override
	protected void read(PacketBuffer buffer) throws IOException {
		kh1fire = buffer.readBoolean();
	}

	@Override
	protected void write(PacketBuffer buffer) throws IOException {
		buffer.writeBoolean(kh1fire);
	}

	@Override
	public void process(EntityPlayer player, Side side) {
		player.getCapability(ModCapabilities.MAGIC_STATE, null).setKH1Fire(kh1fire);
	}


}
