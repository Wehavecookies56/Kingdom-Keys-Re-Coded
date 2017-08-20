package uk.co.wehavecookies56.kk.common.world.dimension;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.network.play.server.SPacketEntity;
import net.minecraft.network.play.server.SPacketEntityTeleport;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.Teleporter;
import net.minecraft.world.World;
import net.minecraft.world.WorldServer;

/**
 * Created by Toby on 01/08/2016.
 */
public class TeleporterOrgPortal extends Teleporter {

    public TeleporterOrgPortal(WorldServer worldIn) {
        super(worldIn);
    }

    public void teleport(EntityPlayer player, World world, BlockPos pos, int dimension) {
        EntityPlayerMP playerMP = (EntityPlayerMP) player;
        playerMP.setPositionAndUpdate(pos.getX()+0.5, pos.getY(), pos.getZ()+0.5);
        playerMP.motionX = playerMP.motionY = playerMP.motionZ = 0;
        playerMP.setPositionAndUpdate(pos.getX()+0.5, pos.getY(), pos.getZ()+0.5);
        if (world.provider.getDimension() != dimension)
            playerMP.mcServer.getPlayerList().transferPlayerToDimension(playerMP, dimension, this);
        playerMP.setPositionAndUpdate(pos.getX()+0.5, pos.getY(), pos.getZ()+0.5);
        playerMP.connection.sendPacket(new SPacketEntityTeleport(playerMP));
        playerMP.connection.sendPacket(new SPacketEntity(playerMP.getEntityId()));
    }

    @Override
    public void placeInPortal(Entity entityIn, float rotationYaw) {

    }

    @Override
    public boolean placeInExistingPortal(Entity entityIn, float rotationYaw) {
        return false;
    }

    @Override
    public boolean makePortal(Entity entityIn) {
        return false;
    }

    @Override
    public void removeStalePortalLocations(long worldTime) {

    }

}
