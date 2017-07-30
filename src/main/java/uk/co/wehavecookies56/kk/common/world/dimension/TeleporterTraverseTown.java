package uk.co.wehavecookies56.kk.common.world.dimension;

import it.unimi.dsi.fastutil.longs.Long2ObjectMap;
import it.unimi.dsi.fastutil.longs.Long2ObjectOpenHashMap;
import it.unimi.dsi.fastutil.objects.ObjectIterator;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.Blocks;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.world.Teleporter;
import net.minecraft.world.World;
import net.minecraft.world.WorldServer;
import uk.co.wehavecookies56.kk.common.KingdomKeys;
import uk.co.wehavecookies56.kk.common.block.ModBlocks;
import uk.co.wehavecookies56.kk.common.block.base.BlockStationOfAwakening;
import uk.co.wehavecookies56.kk.common.lib.Reference;
import uk.co.wehavecookies56.kk.common.world.KingdomKeysWorld;
import uk.co.wehavecookies56.kk.common.world.WorldLoader;
import uk.co.wehavecookies56.kk.common.world.WorldSavedDataKingdomKeys;

import java.util.Random;

/**
 * Created by Toby on 01/08/2016.
 */
public class TeleporterTraverseTown extends Teleporter {

    private final WorldServer worldServerInstance;
    /** A private Random() function in Teleporter */
    private final Random random;
    private final Long2ObjectMap<Teleporter.PortalPosition> destinationCoordinateCache = new Long2ObjectOpenHashMap(4096);

    public TeleporterTraverseTown(WorldServer worldIn) {
        super(worldIn);
        this.worldServerInstance = worldIn;
        this.random = new Random(worldIn.getSeed());
    }

    public void teleport(Entity entity, World world) {
        EntityPlayerMP playerMP = (EntityPlayerMP) entity;

        //KingdomKeysWorld taverseTown = new KingdomKeysWorld(new ResourceLocation(Reference.MODID, "worlds/traversetown.world"), playerMP.world);

        BlockPos spawn = new BlockPos(192, 5, 161);

        entity.setPosition(spawn.getX(), spawn.getY()+1, spawn.getZ());

        entity.motionX = entity.motionY = entity.motionZ = 0.0D;
        entity.setPosition(spawn.getX(), spawn.getY()+1, spawn.getZ());

        if (playerMP.dimension != ModDimensions.traverseTownID)
            playerMP.mcServer.getPlayerList().transferPlayerToDimension(playerMP, ModDimensions.traverseTownID, this);

        WorldSavedDataKingdomKeys data = WorldSavedDataKingdomKeys.get(playerMP.world);

        if (!data.isGenerated()) {
            entity.sendMessage(new TextComponentTranslation("Generating world, this will take a while..."));
            entity.sendMessage(new TextComponentTranslation("This only happens the first time you visit the world"));
            //taverseTown.generate();
            WorldLoader loader = new WorldLoader();
            loader.processAndGenerateStructureFile(new ResourceLocation(Reference.MODID, "worlds/traversetown.world"), playerMP.world.getMinecraftServer().getServer().getWorld(ModDimensions.traverseTownID), 0, 60, 0);
            entity.sendMessage(new TextComponentTranslation("World generated completed, please wait while chunks load..."));
            entity.sendMessage(new TextComponentTranslation("Expect a large performance drop while this happens"));
            data.setGenerated(true);
        }

        entity.setPositionAndRotation(spawn.getX(), spawn.getY()+1, spawn.getZ(), 180, 0);
        entity.setPosition(spawn.getX(), spawn.getY()+1, spawn.getZ());
        entity.setPosition(spawn.getX(), spawn.getY()+1, spawn.getZ());


        //worldLoader.processAndGenerateSchematic(new ResourceLocation(Reference.MODID, "worlds/traversetown.world"), playerMP.world, 0, 0, 0);


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
