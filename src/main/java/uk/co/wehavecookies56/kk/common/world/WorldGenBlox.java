package uk.co.wehavecookies56.kk.common.world;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.google.common.base.Predicate;

import net.minecraft.block.state.IBlockState;
import net.minecraft.block.state.pattern.BlockMatcher;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.fml.common.IWorldGenerator;
import uk.co.wehavecookies56.kk.common.block.ModBlocks;
import uk.co.wehavecookies56.kk.common.core.handler.MainConfig;

public class WorldGenBlox implements IWorldGenerator {

    @Override
    public void generate(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator, IChunkProvider chunkProvider) {
        switch (world.provider.getDimension()) {
            case -1:
                break;
            case 0:
                if (MainConfig.worldgen.EnableWorldGen) generateSurface(world, random, chunkX * 16, chunkZ * 16);
                break;
            case 1:
                if (MainConfig.worldgen.EnableWorldGen) generateEnd(world, random, chunkX * 16, chunkZ * 16);
                break;
        }
    }

    /**
     * Method for world generation on the Overworld
     *
     * @param world
     * @param rand
     * @param chunkX
     * @param chunkZ
     */
    private void generateSurface (World world, Random rand, int chunkX, int chunkZ) {
        for (int k = 0; k < 85; k++) {
            Biome biome = world.getBiome(new BlockPos(chunkX, 0, chunkZ));
            int firstBlockXCoord = chunkX + rand.nextInt(16);
            int firstBlockZCoord = chunkZ + rand.nextInt(16);
            int quisqueY = rand.nextInt(world.getHeight() - 40) + 40;
            int OreY = rand.nextInt(100);
            BlockPos quisquePos = new BlockPos(firstBlockXCoord, quisqueY, firstBlockZCoord);
            BlockPos OrePos = new BlockPos(firstBlockXCoord, OreY, firstBlockZCoord);

            Predicate<IBlockState> predicate = new Predicate<IBlockState>() {

                @Override
                public boolean apply(IBlockState input) {
                    if (input == Blocks.STONE.getDefaultState()){
                        return true;
                    }
                    return false;
                }
            };

            new WorldGenMinable(ModBlocks.BlazingOre.getDefaultState(), 3, BlockMatcher.forBlock(Blocks.STONE)).generate(world, rand, OrePos);
            new WorldGenMinable(ModBlocks.BrightOre.getDefaultState(), 3, BlockMatcher.forBlock(Blocks.STONE)).generate(world, rand, OrePos);
            new WorldGenMinable(ModBlocks.DenseOre.getDefaultState(), 3, BlockMatcher.forBlock(Blocks.STONE)).generate(world, rand, OrePos);
            new WorldGenMinable(ModBlocks.EnergyOre.getDefaultState(), 3, BlockMatcher.forBlock(Blocks.STONE)).generate(world, rand, OrePos);
            List<Biome> coldBiomes = new ArrayList<>(BiomeDictionary.getBiomes(BiomeDictionary.Type.COLD));
            for (int i = 0; i < coldBiomes.size(); i++){
                if (biome == coldBiomes.get(i))
                    new WorldGenMinable(ModBlocks.FrostOre.getDefaultState(), 3, BlockMatcher.forBlock(Blocks.STONE)).generate(world, rand, OrePos);
            }
            new WorldGenMinable(ModBlocks.LightningOre.getDefaultState(), 3, BlockMatcher.forBlock(Blocks.STONE)).generate(world, rand, OrePos);
            new WorldGenMinable(ModBlocks.LucidOre.getDefaultState(), 3, BlockMatcher.forBlock(Blocks.STONE)).generate(world, rand, OrePos);
            new WorldGenMinable(ModBlocks.RemembranceOre.getDefaultState(), 3, BlockMatcher.forBlock(Blocks.STONE)).generate(world, rand, OrePos);
            new WorldGenMinable(ModBlocks.SerenityOre.getDefaultState(), 3, BlockMatcher.forBlock(Blocks.STONE)).generate(world, rand, OrePos);
            new WorldGenMinable(ModBlocks.TranquilOre.getDefaultState(), 3, BlockMatcher.forBlock(Blocks.STONE)).generate(world, rand, OrePos);
            new WorldGenMinable(ModBlocks.TwilightOre.getDefaultState(), 3, BlockMatcher.forBlock(Blocks.STONE)).generate(world, rand, OrePos);

            if (OreY < 20) {
                new WorldGenMinable(ModBlocks.DarkOre.getDefaultState(), 3, BlockMatcher.forBlock(Blocks.STONE)).generate(world, rand, OrePos);
                new WorldGenMinable(ModBlocks.DenseOre.getDefaultState(), 3, BlockMatcher.forBlock(Blocks.STONE)).generate(world, rand, OrePos);
                List<Biome> wetBiomes = new ArrayList<Biome>(BiomeDictionary.getBiomes(BiomeDictionary.Type.WET));
                for (int i = 0; i < wetBiomes.size(); i++) {
                    if (biome == wetBiomes.get(i))
                        new WorldGenMinable(ModBlocks.PowerOre.getDefaultState(), 3, BlockMatcher.forBlock(Blocks.STONE)).generate(world, rand, OrePos);
                }
                new WorldGenMinable(ModBlocks.StormyOre.getDefaultState(), 3, BlockMatcher.forBlock(Blocks.STONE)).generate(world, rand, OrePos);
                for (int i = 0; i < coldBiomes.size(); i++){
                    if (biome == coldBiomes.get(i))
                        new WorldGenMinable(ModBlocks.PowerOre.getDefaultState(), 3, BlockMatcher.forBlock(Blocks.STONE)).generate(world, rand, OrePos);
                }
            }
        }
        for (int k = 0; k < 10; k++) {

            int firstBlockXCoord = chunkX + rand.nextInt(16);
            int firstBlockZCoord = chunkZ + rand.nextInt(16);
            int quisqueY = rand.nextInt(world.getHeight() - 40) + 40;
            int OreY = rand.nextInt(100);
            BlockPos quisquePos = new BlockPos(firstBlockXCoord, quisqueY, firstBlockZCoord);
            BlockPos OrePos = new BlockPos(firstBlockXCoord, OreY, firstBlockZCoord);

            new WorldGenMinable(ModBlocks.NormalBlox.getDefaultState(), 10, BlockMatcher.forBlock(Blocks.GRASS)).generate(world, rand, quisquePos);
            new WorldGenMinable(ModBlocks.HardBlox.getDefaultState(), 10, BlockMatcher.forBlock(Blocks.GRASS)).generate(world, rand, quisquePos);
            new WorldGenMinable(ModBlocks.MetalBlox.getDefaultState(), 10, BlockMatcher.forBlock(Blocks.GRASS)).generate(world, rand, quisquePos);
            new WorldGenMinable(ModBlocks.DangerBlox.getDefaultState(), 10, BlockMatcher.forBlock(Blocks.GRASS)).generate(world, rand, quisquePos);
            new WorldGenMinable(ModBlocks.PrizeBlox.getDefaultState(), 4, BlockMatcher.forBlock(Blocks.DIRT)).generate(world, rand, quisquePos);
            new WorldGenMinable(ModBlocks.RarePrizeBlox.getDefaultState(), 4, BlockMatcher.forBlock(Blocks.DIRT)).generate(world, rand, quisquePos);

            new WorldGenMinable(ModBlocks.NormalBlox.getDefaultState(), 10, BlockMatcher.forBlock(Blocks.SAND)).generate(world, rand, quisquePos);
            new WorldGenMinable(ModBlocks.HardBlox.getDefaultState(), 10, BlockMatcher.forBlock(Blocks.SAND)).generate(world, rand, quisquePos);
            new WorldGenMinable(ModBlocks.MetalBlox.getDefaultState(), 10, BlockMatcher.forBlock(Blocks.SAND)).generate(world, rand, quisquePos);
            new WorldGenMinable(ModBlocks.DangerBlox.getDefaultState(), 10, BlockMatcher.forBlock(Blocks.SAND)).generate(world, rand, quisquePos);

            new WorldGenMinable(ModBlocks.NormalBlox.getDefaultState(), 10, BlockMatcher.forBlock(Blocks.DIRT)).generate(world, rand, quisquePos);
            new WorldGenMinable(ModBlocks.HardBlox.getDefaultState(), 10, BlockMatcher.forBlock(Blocks.DIRT)).generate(world, rand, quisquePos);
            new WorldGenMinable(ModBlocks.MetalBlox.getDefaultState(), 10, BlockMatcher.forBlock(Blocks.DIRT)).generate(world, rand, quisquePos);
            new WorldGenMinable(ModBlocks.DangerBlox.getDefaultState(), 10, BlockMatcher.forBlock(Blocks.DIRT)).generate(world, rand, quisquePos);
        }
    }

    /**
     * Method for world generation on the End
     *
     * @param world
     * @param rand
     * @param chunkX
     * @param chunkZ
     */
    private void generateEnd (World world, Random rand, int chunkX, int chunkZ) {
        for (int k = 0; k < 10; k++) {
            int firstBlockXCoord = chunkX + rand.nextInt(16);
            int firstBlockZCoord = chunkZ + rand.nextInt(16);
            int OreY = rand.nextInt(200);
            BlockPos OrePos = new BlockPos(firstBlockXCoord, OreY, firstBlockZCoord);

            new WorldGenMinable(ModBlocks.NormalBlox.getDefaultState(), 10, BlockMatcher.forBlock(Blocks.END_STONE)).generate(world, rand, OrePos);
            new WorldGenMinable(ModBlocks.HardBlox.getDefaultState(), 10, BlockMatcher.forBlock(Blocks.END_STONE)).generate(world, rand, OrePos);
            new WorldGenMinable(ModBlocks.MetalBlox.getDefaultState(), 10, BlockMatcher.forBlock(Blocks.END_STONE)).generate(world, rand, OrePos);
            new WorldGenMinable(ModBlocks.DangerBlox.getDefaultState(), 10, BlockMatcher.forBlock(Blocks.END_STONE)).generate(world, rand, OrePos);
            new WorldGenMinable(ModBlocks.RarePrizeBlox.getDefaultState(), 2, BlockMatcher.forBlock(Blocks.END_STONE)).generate(world, rand, OrePos);

        }
        for (int k = 0; k < 30; k++) {
            int firstBlockXCoord = chunkX + rand.nextInt(16);
            int firstBlockZCoord = chunkZ + rand.nextInt(16);
            int OreY = rand.nextInt(200);
            BlockPos OrePos = new BlockPos(firstBlockXCoord, OreY, firstBlockZCoord);

            new WorldGenMinable(ModBlocks.DarkOreE.getDefaultState(), 3, BlockMatcher.forBlock(Blocks.END_STONE)).generate(world, rand, OrePos);
            new WorldGenMinable(ModBlocks.PowerOreE.getDefaultState(), 3, BlockMatcher.forBlock(Blocks.END_STONE)).generate(world, rand, OrePos);
        }
    }
}