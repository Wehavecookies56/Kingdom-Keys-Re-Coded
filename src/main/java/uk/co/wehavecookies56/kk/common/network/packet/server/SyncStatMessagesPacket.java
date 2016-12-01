package uk.co.wehavecookies56.kk.common.network.packet.server;

import java.io.IOException;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.network.PacketBuffer;
import net.minecraftforge.fml.relauncher.Side;
import uk.co.wehavecookies56.kk.common.capability.ModCapabilities;
import uk.co.wehavecookies56.kk.common.capability.PlayerStatsCapability.IPlayerStats;
import uk.co.wehavecookies56.kk.common.network.packet.AbstractMessage;

public class SyncStatMessagesPacket extends AbstractMessage.AbstractClientMessage<SyncStatMessagesPacket> {

	String stat;

	public SyncStatMessagesPacket () {}

	public SyncStatMessagesPacket (String stat) {
		this.stat = stat;
	}

	@Override
	protected void read (PacketBuffer buffer) throws IOException {
		this.stat = buffer.readString(3);
	}

	@Override
	protected void write (PacketBuffer buffer) throws IOException {
		buffer.writeString(this.stat);
	}

	@Override
	public void process (EntityPlayer player, Side side) {
		if (this.stat != null) {
			IPlayerStats STATS = player.getCapability(ModCapabilities.PLAYER_STATS, null);
			if (this.stat.equals("clr")) STATS.getMessages().clear();
			if (this.stat.equals("def")) STATS.getMessages().add("def");
			if (this.stat.equals("str")) STATS.getMessages().add("str");
			if (this.stat.equals("mag")) STATS.getMessages().add("mag");
			if (this.stat.equals("hp")) STATS.getMessages().add("hp");
			if (this.stat.equals("fir")) STATS.getMessages().add("fir");
			if (this.stat.equals("bli")) STATS.getMessages().add("bli");
			if (this.stat.equals("thu")) STATS.getMessages().add("thu");
			if (this.stat.equals("cur")) STATS.getMessages().add("cur");
			if (this.stat.equals("gra")) STATS.getMessages().add("gra");
			if (this.stat.equals("aer")) STATS.getMessages().add("aer");
			if (this.stat.equals("sto")) STATS.getMessages().add("sto");
		}
	}

}
