package wehavecookies56.kk.network.packet.server;

import java.io.IOException;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.network.PacketBuffer;
import net.minecraftforge.fml.relauncher.Side;
import wehavecookies56.kk.entities.ExtendedPlayer;
import wehavecookies56.kk.network.packet.AbstractMessage;
import wehavecookies56.kk.network.packet.AbstractMessage.AbstractClientMessage;
import wehavecookies56.kk.network.packet.AbstractMessage.AbstractServerMessage;

public class ChangeXP extends AbstractServerMessage<ChangeXP> {

	public ChangeXP() {}

	int xp;
	String op;
	
	public ChangeXP(int ammount, String operation){
		this.xp = ammount;
		this.op = operation;
	}

	@Override
	protected void read(PacketBuffer buffer) throws IOException {
		this.xp = buffer.readInt();
		this.op = buffer.readStringFromBuffer(100);
	}

	@Override
	protected void write(PacketBuffer buffer) throws IOException {
		buffer.writeInt(xp);
		buffer.writeString(op);
	}

	@Override
	public void process(EntityPlayer player, Side side) 
	{	
		if(this.op.equals("+"))
		{
			ExtendedPlayer.get(player).addXP(xp);
		}
		else if (this.op.equals("-"))
		{
			//ExtendedPlayer.get(player).removeMp(mp);
		}
		else if (this.op.equals("="))
		{
			ExtendedPlayer.get(player).setXP(xp);
		}
	}
}
