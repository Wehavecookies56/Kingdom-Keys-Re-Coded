package wehavecookies56.kk.network.packet.server;

import java.io.IOException;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.network.PacketBuffer;
import net.minecraftforge.fml.relauncher.Side;
import wehavecookies56.kk.entities.ExtendedPlayer;
import wehavecookies56.kk.network.packet.AbstractMessage.AbstractServerMessage;

public class ChangeMagicLevel extends AbstractServerMessage<ChangeMagicLevel> {

	public ChangeMagicLevel() {}

	String magic;
	int level;
	
	public ChangeMagicLevel(String magic, int level){
		this.magic = magic;
		this.level = level;
	}

	@Override
	protected void read(PacketBuffer buffer) throws IOException {
		this.level = buffer.readInt();
		this.magic = buffer.readStringFromBuffer(100);
	}

	@Override
	protected void write(PacketBuffer buffer) throws IOException {
		buffer.writeInt(level);
		buffer.writeString(magic);
	}

	@Override
	public void process(EntityPlayer player, Side side) 
	{	
		/*if(this.magic.equals("Fire"))
		{
		}
		else if (this.magic.equals("Blizzard"))
		{
			//ExtendedPlayer.get(player).removeMp(mp);
		}
		else if (this.magic.equals("Thunder"))
		{
			ExtendedPlayer.get(player).setStrength(strength);
		}*/
		ExtendedPlayer.get(player).setMagicLevel(magic, level);
	}
}
