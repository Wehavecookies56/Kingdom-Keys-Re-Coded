package wehavecookies56.kk.network.packet.server;

import java.io.IOException;

import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.network.PacketBuffer;
import net.minecraftforge.fml.relauncher.Side;
import wehavecookies56.kk.entities.ExtendedPlayer;
import wehavecookies56.kk.network.packet.AbstractMessage;
import wehavecookies56.kk.network.packet.AbstractMessage.AbstractClientMessage;
import wehavecookies56.kk.network.packet.AbstractMessage.AbstractServerMessage;

public class ChangeMaxMP extends AbstractServerMessage<ChangeMaxMP> {

	public ChangeMaxMP() {}

	int MP;
	String op;

	public ChangeMaxMP(int ammount, String operation){
		this.MP = ammount;
		this.op = operation;
	}

	@Override
	protected void read(PacketBuffer buffer) throws IOException {
		this.MP = buffer.readInt();
		this.op = buffer.readStringFromBuffer(100);
	}

	@Override
	protected void write(PacketBuffer buffer) throws IOException {
		buffer.writeInt(MP);
		buffer.writeString(op);
	}

	@Override
	public void process(EntityPlayer player, Side side)
	{
		if(this.op.equals("+"))
		{
			ExtendedPlayer.get(player).addMaxMp(MP);
		}
		else if (this.op.equals("-"))
		{
			//ExtendedPlayer.get(player).removeMp(mp);
		}
		else if (this.op.equals("="))
		{
			ExtendedPlayer.get(player).setMaxMp(MP);
		}
	}
}
