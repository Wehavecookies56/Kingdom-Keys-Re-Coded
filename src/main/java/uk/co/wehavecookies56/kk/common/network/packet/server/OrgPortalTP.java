package uk.co.wehavecookies56.kk.common.network.packet.server;

import java.io.IOException;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.network.PacketBuffer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.WorldServer;
import net.minecraftforge.fml.relauncher.Side;
import uk.co.wehavecookies56.kk.common.network.packet.AbstractMessage;
import uk.co.wehavecookies56.kk.common.world.dimension.TeleporterOrgPortal;

public class OrgPortalTP extends AbstractMessage.AbstractServerMessage<OrgPortalTP> {

    public OrgPortalTP () {}

    int dim;
    double x,y,z;

    public OrgPortalTP (int dimension, double x, double y, double z) {
    	this.dim = dimension;
        this.x = x;
        this.y = y;
        this.z = z;
    }

    @Override
    protected void read (PacketBuffer buffer) throws IOException {
    	this.dim = buffer.readInt();
        this.x = buffer.readDouble();
        this.y = buffer.readDouble();
        this.z = buffer.readDouble();
    }

    @Override
    protected void write (PacketBuffer buffer) throws IOException {
    	buffer.writeInt(dim);
        buffer.writeDouble(x);
        buffer.writeDouble(y);
        buffer.writeDouble(z);
    }

    @Override
    public void process (EntityPlayer player, Side side) {
    	//TODO dimension
    	BlockPos pos = new BlockPos(x,y,z);
    	new TeleporterOrgPortal((WorldServer) player.world).teleport(player, player.world, pos, dim);
    	
       // player.setPositionAndUpdate(x,y,z);
    }
}
