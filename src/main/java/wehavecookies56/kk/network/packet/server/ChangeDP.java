package wehavecookies56.kk.network.packet.server;

import java.io.IOException;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.network.PacketBuffer;
import net.minecraftforge.fml.relauncher.Side;
import wehavecookies56.kk.entities.ExtendedPlayer;
import wehavecookies56.kk.network.packet.AbstractMessage.AbstractServerMessage;

public class ChangeDP extends AbstractServerMessage<ChangeDP> {

	public ChangeDP() {}

	double dp;
	String op;
	
	public ChangeDP(double ammount, String operation){
		this.dp = ammount;
		this.op = operation;
	}

	@Override
	protected void read(PacketBuffer buffer) throws IOException {
		this.dp = buffer.readDouble();
		this.op = buffer.readStringFromBuffer(100);
	}

	@Override
	protected void write(PacketBuffer buffer) throws IOException {
		buffer.writeDouble(dp);
		buffer.writeString(op);
	}

	@Override
	public void process(EntityPlayer player, Side side) 
	{	
		if(this.op.equals("+"))
		{
			ExtendedPlayer.get(player).addDP(dp);

		}
		else if (this.op.equals("-"))
		{
			ExtendedPlayer.get(player).removeDP(dp);
		}
		else if (this.op.equals("="))
		{
			ExtendedPlayer.get(player).setDP(dp);
		}
	}
}
