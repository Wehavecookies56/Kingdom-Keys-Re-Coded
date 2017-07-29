package uk.co.wehavecookies56.kk.common.world;

import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class KingdomKeysWorld {

    ResourceLocation worldFile;
    World world;
    int xOffset, yOffset, zOffset;
    WorldLoader loader;

    public KingdomKeysWorld(ResourceLocation worldFile, World world) {
        this.worldFile = worldFile;
        this.world = world;
        this.xOffset = 0;
        this.yOffset = 60;
        this.zOffset = 0;
        loader = new WorldLoader();
    }

    public KingdomKeysWorld(ResourceLocation worldFile, World world, int xOffset, int yOffset, int zOffset) {
        this.worldFile = worldFile;
        this.world = world;
        this.xOffset = xOffset;
        this.yOffset = yOffset;
        this.zOffset = zOffset;
        loader = new WorldLoader();
    }

    public void generate() {
        loader.processAndGenerateSchematic(worldFile, world, xOffset, yOffset, zOffset);
    }

    public BlockPos getSpawn() {
        return loader.getSpawnLocation(worldFile, world, xOffset, yOffset, zOffset);
    }

}
