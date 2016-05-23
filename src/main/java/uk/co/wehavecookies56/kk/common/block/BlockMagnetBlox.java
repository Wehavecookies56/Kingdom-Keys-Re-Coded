package uk.co.wehavecookies56.kk.common.block;

import java.util.List;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyBool;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import uk.co.wehavecookies56.kk.common.block.base.BlockBlox;

public class BlockMagnetBlox extends BlockBlox {

	protected BlockMagnetBlox (Material material, String toolClass, int level, float hardness, float resistance) {
		super(material, toolClass, level, hardness, resistance);
	}

	public static final PropertyDirection PROPERTYFACING = PropertyDirection.create("facing", EnumFacing.Plane.HORIZONTAL);
	public static final PropertyBool PROPERTYON = PropertyBool.create("on");
	public static final PropertyBool PROPERTYMAGNET = PropertyBool.create("magnet");

	@Override
	public int getMetaFromState (IBlockState state) {
		EnumFacing facing = state.getValue(PROPERTYFACING);
		boolean on = state.getValue(PROPERTYON);
		boolean magnet = state.getValue(PROPERTYMAGNET);
		
		int facingbits = facing.getHorizontalIndex();

		if (on) facingbits += 4;
		if (magnet) facingbits += 8;
		return facingbits;
	}

	@Override
	public IBlockState getActualState (IBlockState state, IBlockAccess worldIn, BlockPos pos) {
		return state;
	}
/*
	@Override
	public void onEntityCollidedWithBlock(World world, BlockPos pos, IBlockState state, Entity entityIn) {
		if (!world.isRemote) updateState(world, pos);
		super.onEntityCollidedWithBlock(world, pos, state, entityIn);
	}

	@Override
	public void updateTick (World world, BlockPos pos, IBlockState state, Random rand) {
		if (!world.isRemote) updateState(world, pos);
		super.updateTick(world, pos, state, rand);
	}
	*/
	@Override
	public BlockRenderLayer getBlockLayer () {
		return BlockRenderLayer.TRANSLUCENT;
	}
	
	@Override
	public boolean isOpaqueCube (IBlockState state) {
		return false;
	}
	
	/*private void updateState (World world, BlockPos pos) {
		List list = world.getEntitiesWithinAABBExcludingEntity((Entity) null, getCollisionBoundingBox(world.getBlockState(pos), world, pos));
		if (list.isEmpty()) return;

		for (int i = 0; i < list.size(); i++) {
			Entity e = (Entity) list.get(i);

			if (e instanceof EntityLivingBase) {

				if (e instanceof EntityPlayer) {
					((EntityPlayer) e).jump();
				}
			}
		}
		world.scheduleUpdate(pos, this, tickRate(world));
	}
	*/

//	@Override
//	public void setBlockBoundsBasedOnState (IBlockAccess world, BlockPos pos) {
//		IBlockState state = world.getBlockState(pos);
//		EnumFacing facing = state.getValue(PROPERTYFACING);
//		boolean isOn = state.getValue(PROPERTYON);
//		if(state.getValue(PROPERTYMAGNET)){
//			state.getBlock().setBlockBounds(0, 0, 0, 1, 1, 1);
//		}
//		if (isOn) {
//			if (facing == EnumFacing.NORTH)
//				state.getBlock().setBlockBounds(0, 0, 0, 1, 1, 10);
//			else if (facing == EnumFacing.SOUTH)
//				state.getBlock().setBlockBounds(0, 0, 0, 1, 1, -10);
//			else if (facing == EnumFacing.EAST)
//				state.getBlock().setBlockBounds(0, 0, 0, -10, 1, 1);
//			else if (facing == EnumFacing.WEST) state.getBlock().setBlockBounds(0, 0, 0, 10, 1, 1);
//		} else
//			state.getBlock().setBlockBounds(0, 0, 0, 1, 1, 1);
//		super.setBlockBoundsBasedOnState(world, pos);
//	}

	@Override
	public void onNeighborBlockChange (World world, BlockPos pos, IBlockState state, Block neighborBlock) {
		
		if (world.isBlockPowered(pos)) {
			world.setBlockState(pos, world.getBlockState(pos).withProperty(PROPERTYON, true));
			/*
			EnumFacing facing = world.getBlockState(pos).getValue(PROPERTYFACING);
			for (int i = 1; i < 10; i++) {
				if(facing == EnumFacing.NORTH) {
					if(world.getBlockState(pos.offset(facing, i)).getBlock() == Blocks.air){
						world.setBlockState(pos.offset(facing, i), ModBlocks.MagnetBlox.getDefaultState().withProperty(PROPERTYFACING, facing.getOpposite()).withProperty(PROPERTYMAGNET, true).withProperty(PROPERTYON, false));
					}else {
						break;
					}
				}
				if(facing == EnumFacing.SOUTH) {
					if(world.getBlockState(pos.south()) == Blocks.air){
						world.setBlockState(pos, world.getBlockState(pos).withProperty(PROPERTYFACING, facing));
					}else {
						break;
					}
				}
				if(facing == EnumFacing.EAST) {
					if(world.getBlockState(pos.east()) == Blocks.air){
						world.setBlockState(pos, world.getBlockState(pos).withProperty(PROPERTYFACING, facing));
					}else {
						break;
					}
				}
				if(facing == EnumFacing.WEST) {
					if(world.getBlockState(pos.west()) == Blocks.air){
						world.setBlockState(pos, world.getBlockState(pos).withProperty(PROPERTYFACING, facing));
					}else {
						break;
					}
				}
			}
			*/
		} else {
			world.setBlockState(pos, world.getBlockState(pos).withProperty(PROPERTYON, false));
			/*
			EnumFacing facing = world.getBlockState(pos).getValue(PROPERTYFACING);
			for (int i = 1; i < 10; i++) {
				if(facing == EnumFacing.NORTH) {
					if(world.getBlockState(pos.offset(facing, i)).getBlock() == ModBlocks.MagnetBlox){
						world.setBlockState(pos.offset(facing, i), Blocks.air.getDefaultState());
					}else {
						break;
					}
				}
				if(facing == EnumFacing.SOUTH) {
					if(world.getBlockState(pos.south()) == Blocks.air){
						world.setBlockState(pos, world.getBlockState(pos).withProperty(PROPERTYFACING, facing));
					}else {
						break;
					}
				}
				if(facing == EnumFacing.EAST) {
					if(world.getBlockState(pos.east()) == Blocks.air){
						world.setBlockState(pos, world.getBlockState(pos).withProperty(PROPERTYFACING, facing));
					}else {
						break;
					}
				}
				if(facing == EnumFacing.WEST) {
					if(world.getBlockState(pos.west()) == Blocks.air){
						world.setBlockState(pos, world.getBlockState(pos).withProperty(PROPERTYFACING, facing));
					}else {
						break;
					}
				}
			}
			*/
		}
	}

	/*@Override
	public AxisAlignedBB getCollisionBoundingBox(IBlockState state, World world, BlockPos pos) {
		EnumFacing facing = state.getValue(PROPERTYFACING);
		if(state.getValue(PROPERTYMAGNET)){
			return new AxisAlignedBB(new BlockPos(0, 0, 0), new BlockPos(0, 0, 0));
		}
		if (world.isBlockPowered(pos)) {
			if (facing == EnumFacing.NORTH)
				return new AxisAlignedBB(pos.add(0, 0, 0), pos.add(1, 1, 10));
			else if (facing == EnumFacing.SOUTH)
				return new AxisAlignedBB(pos.add(0, 0, -10), pos.add(1, 1, 10));
			else if (facing == EnumFacing.EAST)
				return new AxisAlignedBB(pos.add(-10, 0, 0), pos.add(10, 1, 1));
			else if (facing == EnumFacing.WEST) return new AxisAlignedBB(pos.add(0, 0, 0), pos.add(10, 1, 1));
		} else
			return new AxisAlignedBB(pos.add(0, 0, 0), pos.add(1, 1, 1));
		return new AxisAlignedBB(pos.add(0, 0, 0), pos.add(1, 1, 1));
	}*/

	@Override
	protected BlockStateContainer createBlockState () {
		return new BlockStateContainer(this, new IProperty[] { PROPERTYFACING, PROPERTYON, PROPERTYMAGNET });
	}

	@Override
	public IBlockState onBlockPlaced (World world, BlockPos pos, EnumFacing blockFaceClickedOn, float hitX, float hitY, float hitZ, int meta, EntityLivingBase placer) {
		EnumFacing enumfacing = (placer == null) ? EnumFacing.NORTH : EnumFacing.fromAngle(placer.rotationYaw);

		return getDefaultState().withProperty(PROPERTYFACING, enumfacing).withProperty(PROPERTYON, false).withProperty(PROPERTYMAGNET, false);
	}
}
