package wehavecookies56.kk.worldgen;

import java.util.Random;

import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraftforge.fml.common.IWorldGenerator;
import wehavecookies56.kk.block.ModBlocks;

public class WorldGenBlox implements IWorldGenerator{

	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider)
	{
		switch(world.provider.getDimensionId())
		{
			case 0:  generateOverworld   (world, random, chunkX * 16, chunkZ * 16);
			/*case 1:  generateEnd		 (world, random, chunkX * 16, chunkZ * 16);
			case -1: generateNether      (world, random, chunkX * 16, chunkZ * 16);*/
		}
	}
	
	 private void generateOverworld(World world, Random rand, int chunkX, int chunkZ) {
	        for (int k = 0; k < 16; k++)
	        {
	            int firstBlockXCoord = chunkX + rand.nextInt(16);
	            int firstBlockZCoord = chunkZ + rand.nextInt(16);
	            //Will be found between y = 0 and y = 20
	            int quisqueY = rand.nextInt(200);
	            BlockPos quisquePos = new BlockPos(firstBlockXCoord, quisqueY, firstBlockZCoord);
	                //The 10 as the second parameter sets the maximum vein size
	                (new WorldGenMinable(ModBlocks.NormalBlox.getDefaultState(), 10)).generate(world, rand, quisquePos);
	        }
	    }
	}