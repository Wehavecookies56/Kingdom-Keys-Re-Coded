package uk.co.wehavecookies56.kk.common.world.dimension;

import net.minecraft.block.BlockFalling;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.chunk.ChunkPrimer;
import net.minecraft.world.gen.IChunkGenerator;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by Toby on 01/08/2016.
 */
public class ChunkProviderDestinyIslands implements IChunkGenerator {

    private final Random rand;
    private final World worldObj;
    private Biome[] biomesForGeneration;
    private int chunkX = 0;
    private int chunkZ = 0;

    public ChunkProviderDestinyIslands(World worldObjIn, boolean mapFeaturesEnabledIn, long seed) {
        this.rand = new Random(seed);
        this.worldObj = worldObjIn;
    }

    @Override
    public Chunk generateChunk(int x, int z) {
        this.chunkX = x; this.chunkZ = z;
        this.rand.setSeed((long)x * 341873128712L + (long)z * 132897987541L);
        ChunkPrimer chunkprimer = new ChunkPrimer();
        this.biomesForGeneration = this.worldObj.getBiomeProvider().getBiomes(this.biomesForGeneration, x * 16, z * 16, 16, 16);

        IBlockState state;

        int yOffset = 60;

        for (int xPos = 0; xPos < 16; xPos++) {
            for (int zPos = 0; zPos < 16; zPos++) {
                int top = 15 + yOffset;
                for(int depth = 1 + yOffset; depth < top; depth++)  {
                    if(depth < 14 + yOffset)
                        state = Blocks.WATER.getDefaultState();
                    else
                        state = Blocks.SAND.getDefaultState();
                    chunkprimer.setBlockState(xPos, top-depth + yOffset, zPos, state);
                }
                chunkprimer.setBlockState(xPos, 0 + yOffset, zPos, Blocks.BEDROCK.getDefaultState());
            }
        }

        Chunk chunk = new Chunk(this.worldObj, chunkprimer, x, z);
        byte[] abyte = chunk.getBiomeArray();

        for (int i = 0; i < abyte.length; ++i)
        {
            abyte[i] = (byte)Biome.getIdForBiome(this.biomesForGeneration[i]);
        }

        chunk.generateSkylightMap();
        return chunk;
    }

    @Override
    public void populate(int x, int z) {
        BlockFalling.fallInstantly = true;
        net.minecraftforge.event.ForgeEventFactory.onChunkPopulate(true, this, this.worldObj, this.rand, x, z, false);
        BlockFalling.fallInstantly = false;
    }

    @Override
    public boolean generateStructures(Chunk chunkIn, int x, int z) {
        return false;
    }

    @Override
    public List<Biome.SpawnListEntry> getPossibleCreatures(EnumCreatureType creatureType, BlockPos pos) {
        return new ArrayList<Biome.SpawnListEntry>();
    }

    @Override
    public boolean isInsideStructure(World worldIn, String structureName, BlockPos pos) {
        return false;
    }

    @Nullable
    @Override
    public BlockPos getNearestStructurePos(World worldIn, String structureName, BlockPos position, boolean findUnexplored) {
        return null;
    }

    @Override
    public void recreateStructures(Chunk chunkIn, int x, int z) {

    }
}
