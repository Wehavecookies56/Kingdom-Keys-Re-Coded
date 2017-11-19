package uk.co.wehavecookies56.kk.common.network.packet.server;

import java.io.IOException;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.network.PacketBuffer;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.fml.relauncher.Side;
import uk.co.wehavecookies56.kk.common.capability.ModCapabilities;
import uk.co.wehavecookies56.kk.common.entity.magic.EntityOrgPortal;
import uk.co.wehavecookies56.kk.common.network.packet.AbstractMessage;
import uk.co.wehavecookies56.kk.common.network.packet.PacketDispatcher;
import uk.co.wehavecookies56.kk.common.network.packet.client.SpawnPortalParticles;
import uk.co.wehavecookies56.kk.common.network.packet.client.SyncMagicData;
import uk.co.wehavecookies56.kk.common.network.packet.client.SyncOrgPortal;

public class OrgPortal extends AbstractMessage.AbstractServerMessage<OrgPortal> {

    public OrgPortal () {}

    BlockPos pos;
    BlockPos destPos;
    int dimension;

    public OrgPortal (BlockPos pos, BlockPos dest, int dim) {
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
        if (!player.getCapability(ModCapabilities.CHEAT_MODE, null).getCheatMode())
            player.getCapability(ModCapabilities.PLAYER_STATS, null).setMP(0);

        PacketDispatcher.sendToAllAround(new SpawnPortalParticles(pos), player, 64.0D);
        EntityOrgPortal portal = new EntityOrgPortal(player.world, player, pos, destPos, dimension, true);
        player.world.spawnEntity(portal);
        
        EntityOrgPortal destPortal = new EntityOrgPortal(player.world, player, destPos, destPos, dimension, false);
        player.world.spawnEntity(destPortal);

        
        PacketDispatcher.sendToAll(new SyncOrgPortal(pos, destPos, dimension));
        PacketDispatcher.sendTo(new SyncMagicData(player.getCapability(ModCapabilities.MAGIC_STATE, null), player.getCapability(ModCapabilities.PLAYER_STATS, null)), (EntityPlayerMP) player);

    }
}
