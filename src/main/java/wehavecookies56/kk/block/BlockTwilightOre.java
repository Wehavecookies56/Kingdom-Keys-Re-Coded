package wehavecookies56.kk.block;

import java.util.Random;

import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;
import net.minecraft.util.BlockPos;
import net.minecraft.util.MathHelper;
import net.minecraft.world.IBlockAccess;

public class BlockTwilightOre extends BlockBlox {
	private Random rand = new Random();

	protected BlockTwilightOre(Material material, String toolClass, int level,
			float hardness, float resistance) {
		super(material, toolClass, level, hardness, resistance);
	}
	@Override
	public Item getItemDropped(IBlockState state, Random r, int fortune) 
	{
		return null;
	}
	@Override
	public int getExpDrop(IBlockAccess world, BlockPos pos, int fortune)
    {
    	if (this.getItemDropped(world.getBlockState(pos), rand, fortune) != Item.getItemFromBlock(this))
        {
            int i = MathHelper.getRandomIntegerInRange(rand, 2, 4);
            return i;
        }
        return 0;
    }
}
