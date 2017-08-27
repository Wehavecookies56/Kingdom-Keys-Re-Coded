package uk.co.wehavecookies56.kk.common.world.dimension;

import java.util.Random;

import it.unimi.dsi.fastutil.longs.Long2ObjectMap;
import it.unimi.dsi.fastutil.longs.Long2ObjectOpenHashMap;
import it.unimi.dsi.fastutil.objects.ObjectIterator;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.network.play.server.SPacketEntity;
import net.minecraft.network.play.server.SPacketEntityTeleport;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.world.Teleporter;
import net.minecraft.world.WorldServer;
import uk.co.wehavecookies56.kk.common.util.Utils;
import uk.co.wehavecookies56.kk.common.world.WorldLoader;
import uk.co.wehavecookies56.kk.common.world.WorldSavedDataKingdomKeys;

/**
 * Created by Toby on 01/08/2016.
 */
public class DimensionTeleporter extends Teleporter {

    private final WorldServer worldServerInstance;
    /** A private Random() function in Teleporter */
    private final Random random;
    private final Long2ObjectMap<Teleporter.PortalPosition> destinationCoordinateCache = new Long2ObjectOpenHashMap(4096);
    private String dimension;
    private BlockPos spawn;
    
    public DimensionTeleporter(WorldServer worldIn, String dimension, BlockPos pos) {
        super(worldIn);
        this.worldServerInstance = worldIn;
        this.random = new Random(worldIn.getSeed());
        this.dimension = dimension;
        this.spawn = pos;
    }
    
    /**
     * World files teleporter
     * @param entity
     */
    public void teleport(Entity entity) {
        EntityPlayerMP playerMP = (EntityPlayerMP) entity;

        entity.setPosition(spawn.getX(), spawn.getY()+1, spawn.getZ());

        entity.motionX = entity.motionY = entity.motionZ = 0.0D;
        entity.setPosition(spawn.getX(), spawn.getY()+1, spawn.getZ());

        if (playerMP.dimension != Utils.getDimensionIDAndBlockPos(dimension).id)
            playerMP.mcServer.getPlayerList().transferPlayerToDimension(playerMP, Utils.getDimensionIDAndBlockPos(dimension).id, this);

        WorldSavedDataKingdomKeys data = WorldSavedDataKingdomKeys.get(playerMP.world);

        if (!data.isGenerated()) {
            entity.sendMessage(new TextComponentTranslation("Generating world, this will take a while..."));
            entity.sendMessage(new TextComponentTranslation("This only happens the first time you visit the world"));
            WorldLoader loader = new WorldLoader();
            loader.processAndGenerateStructureFile(dimension, playerMP.world.getMinecraftServer().getServer().getWorld(Utils.getDimensionIDAndBlockPos(dimension).id), Utils.getDimensionIDAndBlockPos(dimension).offset);
           
            entity.sendMessage(new TextComponentTranslation("World generated completed, please wait while chunks load..."));
            entity.sendMessage(new TextComponentTranslation("Expect a large performance drop while this happens")); 
            data.setGenerated(true);
        }

        entity.setPositionAndRotation(spawn.getX(), spawn.getY()+1, spawn.getZ(), 180, 0);
        entity.setPosition(spawn.getX(), spawn.getY()+1, spawn.getZ());
        entity.setPosition(spawn.getX(), spawn.getY()+1, spawn.getZ());
    }
    
    /**
     * Org portal teleporter
     * @param player
     * @param pos
     * @param dimension
     */
    public void teleport(EntityPlayer player, BlockPos pos, int dimension) {
        EntityPlayerMP playerMP = (EntityPlayerMP) player;
        playerMP.setPositionAndUpdate(pos.getX()+0.5, pos.getY(), pos.getZ()+0.5);
        playerMP.motionX = playerMP.motionY = playerMP.motionZ = 0;
        playerMP.setPositionAndUpdate(pos.getX()+0.5, pos.getY(), pos.getZ()+0.5);
        if (player.world.provider.getDimension() != dimension)
            playerMP.mcServer.getPlayerList().transferPlayerToDimension(playerMP, dimension, this);
        playerMP.setPositionAndUpdate(pos.getX()+0.5, pos.getY(), pos.getZ()+0.5);
        playerMP.connection.sendPacket(new SPacketEntityTeleport(playerMP));
        playerMP.connection.sendPacket(new SPacketEntity(playerMP.getEntityId()));
    }

    @Override
    public void placeInPortal(Entity entityIn, float rotationYaw) {
        if (worldServerInstance.provider.getDimension() == Utils.getDimensionIDAndBlockPos(dimension).id) {
            entityIn.setLocationAndAngles(entityIn.posX, entityIn.posY, entityIn.posZ, entityIn.rotationYaw, 0.0F);
            entityIn.motionX = 0.0D;
            entityIn.motionY = 0.0D;
            entityIn.motionZ = 0.0D;
        }
    }

    @Override
    public boolean placeInExistingPortal(Entity entityIn, float rotationYaw) {
        return false;
    }

    @Override
    public boolean makePortal(Entity entityIn) {
        return false;
    }

    /**
     * called periodically to remove out-of-date portal locations from the cache list. Argument par1 is a
     * WorldServer.getTotalWorldTime() value.
     */
    @Override
    public void removeStalePortalLocations(long worldTime) {
        if (worldTime % 100L == 0L) {
            long i = worldTime - 300L;
            ObjectIterator<Teleporter.PortalPosition> objectiterator = this.destinationCoordinateCache.values().iterator();

            while (objectiterator.hasNext()) {
                Teleporter.PortalPosition teleporter$portalposition = (Teleporter.PortalPosition)objectiterator.next();

                if (teleporter$portalposition == null || teleporter$portalposition.lastUpdateTime < i) {
                    objectiterator.remove();
                }
            }
        }
    }

    public class PortalPosition extends BlockPos {
        /** The worldtime at which this PortalPosition was last verified */
        public long lastUpdateTime;

        public PortalPosition(BlockPos pos, long lastUpdate) {
            super(pos.getX(), pos.getY(), pos.getZ());
            this.lastUpdateTime = lastUpdate;
        }
    }

}
