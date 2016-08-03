package uk.co.wehavecookies56.kk.common.world.dimension;

import it.unimi.dsi.fastutil.longs.Long2ObjectMap;
import it.unimi.dsi.fastutil.longs.Long2ObjectOpenHashMap;
import it.unimi.dsi.fastutil.objects.ObjectIterator;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.Blocks;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.Teleporter;
import net.minecraft.world.World;
import net.minecraft.world.WorldServer;
import uk.co.wehavecookies56.kk.common.block.ModBlocks;
import uk.co.wehavecookies56.kk.common.block.base.BlockStationOfAwakening;

import java.util.Random;

/**
 * Created by Toby on 01/08/2016.
 */
public class TeleporterDiveToTheHeart extends Teleporter {

    private final WorldServer worldServerInstance;
    /** A private Random() function in Teleporter */
    private final Random random;
    private final Long2ObjectMap<Teleporter.PortalPosition> destinationCoordinateCache = new Long2ObjectOpenHashMap(4096);

    public TeleporterDiveToTheHeart(WorldServer worldIn) {
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

        entity.setPosition(dx, dy+1, dz);

        entity.motionX = entity.motionY = entity.motionZ = 0.0D;
        entity.setPosition(dx, dy+1, dz);

        playerMP.mcServer.getPlayerList().transferPlayerToDimension(playerMP, ModDimensions.diveToTheHeartID, this);

        entity.setPosition(dx, dy+1, dz);

        int radius = 15;
        int barrierRadius = 16;
        int barrierHeight = 5;
        for(int i = 0; i<barrierHeight; i++)
        {
            for(float j = 0; j < 2 * Math.PI * barrierRadius; j += 0.5)
            {
                playerMP.worldObj.setBlockState(new BlockPos((int)Math.floor(dx + Math.sin(j) * barrierRadius), dy +i, (int)Math.floor(dz + Math.cos(j) * barrierRadius)), Blocks.BARRIER.getDefaultState());
            }
        }
        for(float i = 0; i < radius+2; i += 0.5) {
            for(float j = 0; j < 2 * Math.PI * i; j += 0.5)
            	if(i > radius)
            		playerMP.worldObj.setBlockState(new BlockPos((int)Math.floor(dx + Math.sin(j) * i), dy, (int)Math.floor(dz + Math.cos(j) * i)), Blocks.BARRIER.getDefaultState());
            	else
            		playerMP.worldObj.setBlockState(new BlockPos((int)Math.floor(dx + Math.sin(j) * i), dy, (int)Math.floor(dz + Math.cos(j) * i)), Blocks.GLOWSTONE.getDefaultState());
        }
        playerMP.worldObj.setBlockState(new BlockPos(dx+(-12), dy, dz+(-13)), ModBlocks.StationOfAwakening.getDefaultState().withProperty(BlockStationOfAwakening.VARIANT, 0));
        playerMP.worldObj.setBlockState(new BlockPos(dx+(-4), dy, dz+(-13)), ModBlocks.StationOfAwakening.getDefaultState().withProperty(BlockStationOfAwakening.VARIANT, 1));
        playerMP.worldObj.setBlockState(new BlockPos(dx+(4), dy, dz+(-13)), ModBlocks.StationOfAwakening.getDefaultState().withProperty(BlockStationOfAwakening.VARIANT, 2));
        playerMP.worldObj.setBlockState(new BlockPos(dx+(12), dy, dz+(-13)), ModBlocks.StationOfAwakening.getDefaultState().withProperty(BlockStationOfAwakening.VARIANT, 3));

        playerMP.worldObj.setBlockState(new BlockPos(dx+(-12), dy, dz+(-5)), ModBlocks.StationOfAwakening.getDefaultState().withProperty(BlockStationOfAwakening.VARIANT, 4));
        playerMP.worldObj.setBlockState(new BlockPos(dx+(-4), dy, dz+(-5)), ModBlocks.StationOfAwakening.getDefaultState().withProperty(BlockStationOfAwakening.VARIANT, 5));
        playerMP.worldObj.setBlockState(new BlockPos(dx+(4), dy, dz+(-5)), ModBlocks.StationOfAwakening.getDefaultState().withProperty(BlockStationOfAwakening.VARIANT, 6));
        playerMP.worldObj.setBlockState(new BlockPos(dx+(12), dy, dz+(-5)), ModBlocks.StationOfAwakening.getDefaultState().withProperty(BlockStationOfAwakening.VARIANT, 7));

        playerMP.worldObj.setBlockState(new BlockPos(dx+(-12), dy, dz+(3)), ModBlocks.StationOfAwakening.getDefaultState().withProperty(BlockStationOfAwakening.VARIANT, 8));
        playerMP.worldObj.setBlockState(new BlockPos(dx+(-4), dy, dz+(3)), ModBlocks.StationOfAwakening.getDefaultState().withProperty(BlockStationOfAwakening.VARIANT, 9));
        playerMP.worldObj.setBlockState(new BlockPos(dx+(4), dy, dz+(3)), ModBlocks.StationOfAwakening.getDefaultState().withProperty(BlockStationOfAwakening.VARIANT, 10));
        playerMP.worldObj.setBlockState(new BlockPos(dx+(12), dy, dz+(3)), ModBlocks.StationOfAwakening.getDefaultState().withProperty(BlockStationOfAwakening.VARIANT, 11));

        playerMP.worldObj.setBlockState(new BlockPos(dx+(-12), dy, dz+(11)), ModBlocks.StationOfAwakening.getDefaultState().withProperty(BlockStationOfAwakening.VARIANT, 12));
        playerMP.worldObj.setBlockState(new BlockPos(dx+(-4), dy, dz+(11)), ModBlocks.StationOfAwakening.getDefaultState().withProperty(BlockStationOfAwakening.VARIANT, 13));
        playerMP.worldObj.setBlockState(new BlockPos(dx+(4), dy, dz+(11)), ModBlocks.StationOfAwakening.getDefaultState().withProperty(BlockStationOfAwakening.VARIANT, 14));
        playerMP.worldObj.setBlockState(new BlockPos(dx+(12), dy, dz+(11)), ModBlocks.StationOfAwakening.getDefaultState().withProperty(BlockStationOfAwakening.VARIANT, 15));
    }

    @Override
    public void placeInPortal(Entity entityIn, float rotationYaw) {

        if (worldServerInstance.provider.getDimension() == ModDimensions.diveToTheHeartID) {

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
