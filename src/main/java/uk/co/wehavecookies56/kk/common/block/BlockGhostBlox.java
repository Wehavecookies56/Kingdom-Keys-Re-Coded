package uk.co.wehavecookies56.kk.common.block;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.PropertyInteger;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import uk.co.wehavecookies56.kk.common.block.base.BlockBlox;
import uk.co.wehavecookies56.kk.common.lib.Properties;

public class BlockGhostBlox extends BlockBlox {

	protected BlockGhostBlox(Material material, String toolClass, int level, float hardness, float resistance, String name) {
		super(material, toolClass, level, hardness, resistance, name);
	}

	public static final PropertyInteger VISIBLE = PropertyInteger.create(Properties.VISIBLE, 0, 1);

	@Override
	protected BlockStateContainer createBlockState() {
		return new BlockStateContainer(this, VISIBLE);
	}

	@SuppressWarnings("deprecation")
	@Override
	public IBlockState getStateFromMeta(int meta) {
		return getDefaultState().withProperty(VISIBLE, meta);
	}

	@Override
	public int getMetaFromState(IBlockState state) {
		return state.getValue(VISIBLE);
	}

	@Override
	@SideOnly(Side.CLIENT)
	public BlockRenderLayer getBlockLayer() {
		return BlockRenderLayer.CUTOUT;
	}

	@SuppressWarnings("deprecation")
	@Override
	public boolean canProvidePower(IBlockState state) {
		return true;
	}

	public void updateTick(World worldIn, BlockPos pos, IBlockState state, Random rand) {
		System.out.println("hi");
	}

	@Override
	public void neighborChanged(IBlockState state, World world, BlockPos pos, Block block, BlockPos fromPos) {
		if (world.isBlockPowered(pos)) {
			world.setBlockState(pos, world.getBlockState(pos).withProperty(VISIBLE, 1));
		} else {
			world.setBlockState(pos, world.getBlockState(pos).withProperty(VISIBLE, 0));
		}

		// Detection of neighbor ghost blox
		BlockPos blockBelow = pos.down();
		if (world.getBlockState(blockBelow).getBlock() == ModBlocks.GhostBlox) {
			world.setBlockState(pos, world.getBlockState(blockBelow));
		}

	}

	@Override
	public void onBlockAdded(World world, BlockPos pos, IBlockState state) {
		if (!world.isRemote && world.getTileEntity(pos) == null)
			if (world.isBlockPowered(pos))
				world.setBlockState(pos, world.getBlockState(pos).withProperty(VISIBLE, 1));
			else
				world.setBlockState(pos, world.getBlockState(pos).withProperty(VISIBLE, 0));
		
		BlockPos blockBelow = pos.down();
		if (world.getBlockState(blockBelow).getBlock() == ModBlocks.GhostBlox) {
			world.setBlockState(pos, world.getBlockState(blockBelow));
		}
	}

	@Override
	public void onBlockPlacedBy(World world, BlockPos pos, IBlockState state, EntityLivingBase placer, ItemStack stack) {
		if (!world.isRemote && world.getTileEntity(pos) == null)
			if (world.isBlockPowered(pos))
				world.setBlockState(pos, world.getBlockState(pos).withProperty(VISIBLE, 1));
			else
				world.setBlockState(pos, world.getBlockState(pos).withProperty(VISIBLE, 0));
	}

	@Override
	public boolean isOpaqueCube(IBlockState state) {
		return false;
	}

	@Override
	public AxisAlignedBB getSelectedBoundingBox(IBlockState worldIn, World pos, BlockPos state) {
		if (worldIn.getValue(VISIBLE) == 0)
			return new AxisAlignedBB(new BlockPos(0, 0, 0), new BlockPos(1, 1, 1));
		else
			return new AxisAlignedBB(new BlockPos(0, 0, 0), new BlockPos(0, 0, 0));
	}

	@Override
	public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) {
		if (state.getValue(VISIBLE) == 0)
			return new AxisAlignedBB(new BlockPos(0, 0, 0), new BlockPos(1, 1, 1));
		else
			return new AxisAlignedBB(new BlockPos(0, 0, 0), new BlockPos(0, 0, 0));
	}
}
