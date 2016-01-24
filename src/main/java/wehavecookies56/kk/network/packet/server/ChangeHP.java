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

public class ChangeHP extends AbstractServerMessage<ChangeHP> {

	public ChangeHP() {}

	double hp;
	String op;
	
	public ChangeHP(double ammount, String operation){
		this.hp = ammount;
		this.op = operation;
	}

	@Override
	protected void read(PacketBuffer buffer) throws IOException {
		this.hp = buffer.readDouble();
		this.op = buffer.readStringFromBuffer(100);
	}

	@Override
	protected void write(PacketBuffer buffer) throws IOException {
		buffer.writeDouble(hp);
		buffer.writeString(op);
	}

	@Override
	public void process(EntityPlayer player, Side side) 
	{	
		if(this.op.equals("+"))
		{
			player.heal((float) hp);
		}
		else if (this.op.equals("-"))
		{
			player.heal((float) (player.getHealth()-hp));
		}
		else if (this.op.equals("="))
		{
			player.setHealth((float) hp);
		}
	}
}
