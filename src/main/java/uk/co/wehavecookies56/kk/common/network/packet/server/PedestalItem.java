package uk.co.wehavecookies56.kk.common.network.packet.server;

import java.io.IOException;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.network.PacketBuffer;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.fml.relauncher.Side;
import uk.co.wehavecookies56.kk.common.block.tile.TileEntityPedestal;
import uk.co.wehavecookies56.kk.common.network.packet.AbstractMessage;
import uk.co.wehavecookies56.kk.common.network.packet.PacketDispatcher;
import uk.co.wehavecookies56.kk.common.network.packet.client.PedestalRotation;

public class PedestalItem extends AbstractMessage.AbstractServerMessage<PedestalItem> {

	public PedestalItem () {}
	BlockPos pedestalPos;
	//ItemStack item;
	char rotation;

	public PedestalItem (BlockPos pedestalPos, char rotation) {
		//this.item = item;
		this.rotation = rotation;
		this.pedestalPos = pedestalPos;
	}

	@Override
	protected void read (PacketBuffer buffer) throws IOException {
		//item = buffer.readItemStackFromBuffer();
		rotation = buffer.readChar();
		pedestalPos = buffer.readBlockPos();
	}

	@Override
	protected void write (PacketBuffer buffer) throws IOException {
		buffer.writeChar(rotation);
		//buffer.writeItemStackToBuffer(item);
		buffer.writeBlockPos(pedestalPos);
	}

	@Override
	public void process (EntityPlayer player, Side side) {
		TileEntityPedestal pedestal = (TileEntityPedestal) player.world.getTileEntity(pedestalPos);
		pedestal.setRotation(rotation);
		PacketDispatcher.sendToAll(new PedestalRotation(pedestal));
	}
}
