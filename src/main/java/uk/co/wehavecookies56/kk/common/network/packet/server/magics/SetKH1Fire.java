package uk.co.wehavecookies56.kk.common.network.packet.server.magics;

import java.io.IOException;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.network.PacketBuffer;
import net.minecraftforge.fml.relauncher.Side;
import uk.co.wehavecookies56.kk.common.capability.ModCapabilities;
import uk.co.wehavecookies56.kk.common.network.packet.AbstractMessage.AbstractServerMessage;

public class SetKH1Fire extends AbstractServerMessage<SetKH1Fire> {

	boolean kh1fire;

	public SetKH1Fire () {}

	public SetKH1Fire (boolean fire) {
		this.kh1fire = fire;
	}

	@Override
	protected void read (PacketBuffer buffer) throws IOException {
		kh1fire = buffer.readBoolean();
	}

	@Override
	protected void write (PacketBuffer buffer) throws IOException {
		buffer.writeBoolean(kh1fire);
	}

	@Override
	public void process (EntityPlayer player, Side side) {
		Minecraft.getMinecraft().thePlayer.getCapability(ModCapabilities.MAGIC_STATE, null).setKH1Fire(kh1fire);
	}
}
