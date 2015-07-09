package wehavecookies56.kk.block;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyInteger;
import net.minecraft.block.state.BlockState;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumWorldBlockLayer;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import wehavecookies56.kk.lib.Properties;

public class BlockGhostBlox extends BlockBlox {

	protected BlockGhostBlox(Material material, String toolClass, int level, float hardness, float resistance) {
		super(material, toolClass, level, hardness, resistance);
	}

	public static final PropertyInteger VISIBLE = PropertyInteger.create(Properties.VISIBLE, 0, 1);

	@Override
	protected BlockState createBlockState() {

		return new BlockState(this, new IProperty[] {VISIBLE});
	}

	@Override
	public IBlockState getStateFromMeta(int meta){
		return getDefaultState().withProperty(VISIBLE, Integer.valueOf(meta));
	}

	@Override
	public int getMetaFromState(IBlockState state){
		return ((Integer)state.getValue(VISIBLE)).intValue();
	}

	@SideOnly(Side.CLIENT)
	public EnumWorldBlockLayer getBlockLayer(){
		return EnumWorldBlockLayer.CUTOUT;
	}

	@Override
	public void updateTick(World world, BlockPos pos, IBlockState state, Random rand) {
		if(world.isBlockPowered(pos)){
		}
		super.updateTick(world, pos, state, rand);
	}

	@Override
	public void onNeighborBlockChange(World world, BlockPos pos, IBlockState state, Block neighborBlock) {
		if(world.isBlockPowered(pos)){
			world.setBlockState(pos, world.getBlockState(pos).withProperty(VISIBLE, Integer.valueOf(1)));
		}else{
			world.setBlockState(pos, world.getBlockState(pos).withProperty(VISIBLE, Integer.valueOf(0)));
		}
	}

	@Override
	public boolean isOpaqueCube() {
		return false;
	}

	@Override
	public AxisAlignedBB getCollisionBoundingBox(World worldIn, BlockPos pos, IBlockState state) {
		if(((Integer)state.getValue(VISIBLE)).intValue() == 0){
			return super.getCollisionBoundingBox(worldIn, pos, state);
		}else{
			return null;
		}
	}
}
