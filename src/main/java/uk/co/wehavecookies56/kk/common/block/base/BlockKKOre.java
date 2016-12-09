package uk.co.wehavecookies56.kk.common.block.base;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.IBlockAccess;

public class BlockKKOre extends Block {

	public BlockKKOre (Material material, String toolClass, int level, float hardness, float resistance) {
		super(material);
		this.setHarvestLevel(toolClass, level);
		setHardness(hardness);
		setResistance(resistance);
	}
	private Random rand = new Random();
	
	@Override
	public Item getItemDropped (IBlockState state, Random r, int fortune) {
		return null;
	}
	
	@Override
	public int getExpDrop(IBlockState state, IBlockAccess world, BlockPos pos, int fortune) {
			return MathHelper.getInt(rand, 2, 4);
	}
}
