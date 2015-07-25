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

public class AntiPoints extends AbstractServerMessage<AntiPoints> {

	public AntiPoints() {}

	int points;
	String operation;

	public AntiPoints(int ammount, String operation){
		this.points = ammount;
		this.operation = operation;
	}

	@Override
	protected void read(PacketBuffer buffer) throws IOException {
		this.points = buffer.readInt();
		this.operation = buffer.readStringFromBuffer(100);
	}

	@Override
	protected void write(PacketBuffer buffer) throws IOException {
		buffer.writeInt(points);
		buffer.writeString(operation);
	}

	@Override
	public void process(EntityPlayer player, Side side) {
		if(this.operation.equals("+"))
		{
			ExtendedPlayer.get(player).addAntiPoints(points);	
		}
		
		else if(this.operation.equals("-"))
		{
			ExtendedPlayer.get(player).removeAntiPoints(points);
		}
	}
}
