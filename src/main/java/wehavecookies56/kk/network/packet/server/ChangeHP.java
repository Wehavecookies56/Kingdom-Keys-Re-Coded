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

public class ChangeHP extends AbstractServerMessage<ChangeHP> {

	public ChangeHP() {}

	int HP;
	String op;

	public ChangeHP(int ammount, String operation){
		this.HP = ammount;
		this.op = operation;
	}

	@Override
	protected void read(PacketBuffer buffer) throws IOException {
		this.HP = buffer.readInt();
		this.op = buffer.readStringFromBuffer(100);
	}

	@Override
	protected void write(PacketBuffer buffer) throws IOException {
		buffer.writeInt(HP);
		buffer.writeString(op);
	}

	@Override
	public void process(EntityPlayer player, Side side)
	{
		if(this.op.equals("+"))
		{
			ExtendedPlayer.get(player).addHP(HP);
			player.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(ExtendedPlayer.get((EntityPlayer)player).getHP()+20);
		}
		else if (this.op.equals("-"))
		{
			//ExtendedPlayer.get(player).removeMp(mp);
		}
		else if (this.op.equals("="))
		{
			ExtendedPlayer.get(player).setHP(HP);
		}
	}
}
