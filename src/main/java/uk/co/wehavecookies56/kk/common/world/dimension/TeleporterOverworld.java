package uk.co.wehavecookies56.kk.common.world.dimension;

import java.util.Random;

import it.unimi.dsi.fastutil.longs.Long2ObjectMap;
import it.unimi.dsi.fastutil.longs.Long2ObjectOpenHashMap;
import it.unimi.dsi.fastutil.objects.ObjectIterator;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.Teleporter;
import net.minecraft.world.World;
import net.minecraft.world.WorldServer;

/**
 * Created by Toby on 01/08/2016.
 */
public class TeleporterOverworld extends Teleporter {

    private final WorldServer worldServerInstance;
    /** A private Random() function in Teleporter */
    private final Random random;
    private final Long2ObjectMap<Teleporter.PortalPosition> destinationCoordinateCache = new Long2ObjectOpenHashMap(4096);

    public TeleporterOverworld(WorldServer worldIn) {
        super(worldIn);
        this.worldServerInstance = worldIn;
        this.random = new Random(worldIn.getSeed());
    }

    public void teleport(Entity entity, World world) {
        EntityPlayerMP playerMP = (EntityPlayerMP) entity;

        int height = 3;
        int width = 16;
        int depth = 16;

        double dx = -1;
        double dy = 64;
        double dz = -1;

        entity.motionX = entity.motionY = entity.motionZ = 0.0D;
        double spawnX = world.getSpawnPoint().getX();
        double spawnY = world.getSpawnPoint().getY();
        double spawnZ = world.getSpawnPoint().getZ();
//TODO
    	entity.setPosition(spawnX, spawnY, spawnZ);
    	
//Keeps moving up the entity to avoid suffocation (Not working yet)
        while (entity.posY > 0.0D && entity.posY < 256.0D)
        {
        	entity.setPosition(entity.posX, entity.posY, entity.posZ);

            if (world.getCollisionBoxes(entity, entity.getEntityBoundingBox()).isEmpty())
            {
                break;
            }

            ++entity.posY;
        }        
        playerMP.mcServer.getPlayerList().transferPlayerToDimension(playerMP, 0, this);
    }

    @Override
    public void placeInPortal(Entity entityIn, float rotationYaw) {

        if (worldServerInstance.provider.getDimension() == 0) {

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
    public void removeStalePortalLocations(long worldTime)
    {
        if (worldTime % 100L == 0L)
        {
            long i = worldTime - 300L;
            ObjectIterator<Teleporter.PortalPosition> objectiterator = this.destinationCoordinateCache.values().iterator();

            while (objectiterator.hasNext())
            {
                Teleporter.PortalPosition teleporter$portalposition = (Teleporter.PortalPosition)objectiterator.next();

                if (teleporter$portalposition == null || teleporter$portalposition.lastUpdateTime < i)
                {
                    objectiterator.remove();
                }
            }
        }
    }

    public class PortalPosition extends BlockPos
    {
        /** The worldtime at which this PortalPosition was last verified */
        public long lastUpdateTime;

        public PortalPosition(BlockPos pos, long lastUpdate)
        {
            super(pos.getX(), pos.getY(), pos.getZ());
            this.lastUpdateTime = lastUpdate;
        }
    }

}
