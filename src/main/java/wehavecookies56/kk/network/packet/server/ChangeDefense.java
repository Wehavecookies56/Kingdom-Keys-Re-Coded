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

public class ChangeDefense extends AbstractServerMessage<ChangeDefense> {

	public ChangeDefense() {}

	int defense;
	String op;
	
	public ChangeDefense(int ammount, String operation){
		this.defense = ammount;
		this.op = operation;
	}

	@Override
	protected void read(PacketBuffer buffer) throws IOException {
		this.defense = buffer.readInt();
		this.op = buffer.readStringFromBuffer(100);
	}

	@Override
	protected void write(PacketBuffer buffer) throws IOException {
		buffer.writeInt(defense);
		buffer.writeString(op);
	}

	@Override
	public void process(EntityPlayer player, Side side) 
	{	
		if(this.op.equals("+"))
		{
			ExtendedPlayer.get(player).addDefense(defense);
		}
		else if (this.op.equals("-"))
		{
			//ExtendedPlayer.get(player).removeMp(mp);
		}
		else if (this.op.equals("="))
		{
			ExtendedPlayer.get(player).setDefense(defense);
		}
	}
}
