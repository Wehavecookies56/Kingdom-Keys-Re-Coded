package wehavecookies56.kk.network.packet.server;

import java.io.IOException;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.network.PacketBuffer;
import net.minecraftforge.fml.relauncher.Side;
import wehavecookies56.kk.entities.PlayerLevel;
import wehavecookies56.kk.network.packet.AbstractMessage.AbstractClientMessage;
import wehavecookies56.kk.network.packet.AbstractMessage.AbstractServerMessage;

public class SyncStatMessagesPacket extends AbstractClientMessage<SyncStatMessagesPacket> {

	String stat;
	
	public SyncStatMessagesPacket() {}
	
	public SyncStatMessagesPacket(String stat){
		this.stat = stat;
	}
	
	@Override
	protected void read(PacketBuffer buffer) throws IOException {
		this.stat = buffer.readStringFromBuffer(3);
	}

	@Override
	protected void write(PacketBuffer buffer) throws IOException {
		buffer.writeString(this.stat);
	}

	@Override
	public void process(EntityPlayer player, Side side) {
		if(this.stat != null){
			if(this.stat.equals("clr")){
				PlayerLevel.messages.clear();
			}
			if(this.stat.equals("def")){
				PlayerLevel.messages.add("def");
			}
			if(this.stat.equals("str")){
				PlayerLevel.messages.add("str");
			}
			if(this.stat.equals("mag")){
				PlayerLevel.messages.add("mag");
			}
			if(this.stat.equals("hp")){
				PlayerLevel.messages.add("hp");
			}
		}
	}

}
