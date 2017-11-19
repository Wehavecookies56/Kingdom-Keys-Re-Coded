package uk.co.wehavecookies56.kk.common.network.packet.client;

import java.io.IOException;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.network.PacketBuffer;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.fml.relauncher.Side;
import uk.co.wehavecookies56.kk.common.entity.magic.EntityOrgPortal;
import uk.co.wehavecookies56.kk.common.network.packet.AbstractMessage;

public class SyncOrgPortal extends AbstractMessage.AbstractClientMessage<SyncOrgPortal> {

	BlockPos pos;
    BlockPos destPos;
    int dimension;

    public SyncOrgPortal () {}

    public SyncOrgPortal (BlockPos pos, BlockPos dest, int dim) {
        this.pos = pos;
        this.destPos = dest;
        this.dimension = dim;

    }

    @Override
    protected void read (PacketBuffer buffer) throws IOException {
    	 pos = buffer.readBlockPos();
         destPos = buffer.readBlockPos();
         dimension = buffer.readInt();
    }

    @Override
    protected void write (PacketBuffer buffer) throws IOException {
    	buffer.writeBlockPos(pos);
        buffer.writeBlockPos(destPos);
        buffer.writeInt(dimension);
    }

    @Override
    public void process (EntityPlayer player, Side side) {
    	EntityOrgPortal portal;
    	if(pos != destPos)
    		portal = new EntityOrgPortal(player.world, player, pos, destPos, dimension, true);
    	else
    		portal = new EntityOrgPortal(player.world, player, pos, destPos, dimension, false);
    	
        player.world.spawnEntity(portal);
        //player.world.spawnParticle(EnumParticleTypes.CRIT_MAGIC, this.x, this.y, this.z, 0.0D, 0.0D, 0.0D);
    }
}