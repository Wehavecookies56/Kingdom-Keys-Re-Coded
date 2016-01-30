package wehavecookies56.kk.network.packet.client;

import java.io.IOException;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.PacketBuffer;
import net.minecraftforge.fml.relauncher.Side;
import wehavecookies56.kk.entities.ExtendedPlayer;
import wehavecookies56.kk.network.packet.AbstractMessage.AbstractClientMessage;

public class SyncExtendedPlayer extends AbstractClientMessage<SyncExtendedPlayer> {

	private NBTTagCompound data;

	public SyncExtendedPlayer() {
	}

	public SyncExtendedPlayer(EntityPlayer player) {
		data = new NBTTagCompound();
		ExtendedPlayer.get(player).saveNBTData(data);
	}

	@Override
	protected void read(PacketBuffer buffer) throws IOException {
		data = buffer.readNBTTagCompoundFromBuffer();

	}

	@Override
	protected void write(PacketBuffer buffer) throws IOException {
		buffer.writeNBTTagCompoundToBuffer(data);

	}

	@Override
	public void process(EntityPlayer player, Side side) {
		ExtendedPlayer.get(player).loadNBTData(data);
	}

}
