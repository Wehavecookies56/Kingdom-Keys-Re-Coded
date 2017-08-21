package uk.co.wehavecookies56.kk.common.network.packet.client;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.network.PacketBuffer;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.fml.relauncher.Side;
import uk.co.wehavecookies56.kk.common.block.tile.TileEntityPedestal;
import uk.co.wehavecookies56.kk.common.network.packet.AbstractMessage.AbstractClientMessage;

import java.io.IOException;

public class PedestalRotation extends AbstractClientMessage<PedestalRotation> {

    int rotation;
    BlockPos pos;

    public PedestalRotation() {}

    public PedestalRotation(TileEntityPedestal te) {
        this.rotation = te.getRotation();
        this.pos = te.getPos();
    }

    @Override
    protected void read(PacketBuffer buffer) throws IOException {
        this.rotation = buffer.readInt();
        this.pos = buffer.readBlockPos();
    }

    @Override
    protected void write(PacketBuffer buffer) throws IOException {
        buffer.writeInt(this.rotation);
        buffer.writeBlockPos(this.pos);
    }

    @Override
    public void process(EntityPlayer player, Side side) {
        TileEntityPedestal pedestal = (TileEntityPedestal) player.world.getTileEntity(pos);
        pedestal.rotation = rotation;
    }
}
