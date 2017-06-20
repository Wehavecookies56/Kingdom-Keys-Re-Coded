package uk.co.wehavecookies56.kk.common.block;

import javax.annotation.Nullable;

import net.minecraft.block.Block;
import net.minecraft.block.BlockHorizontal;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.Mirror;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

/**
 * Created by Toby on 09/08/2016.
 */
public class BlockStationOfAwakeningDoor extends Block {

    public static final PropertyDirection FACING = BlockHorizontal.FACING;

    public BlockStationOfAwakeningDoor(String name) {
        super(Material.IRON);
        this.setDefaultState(this.blockState.getBaseState().withProperty(FACING, EnumFacing.NORTH));
        setUnlocalizedName(name);
        setCreativeTab(ModBlocks.tabKingdomKeysBlocks);
    }

    @Nullable
    @Override
    public AxisAlignedBB getCollisionBoundingBox(IBlockState blockState, IBlockAccess worldIn, BlockPos pos) {
        if(blockState.getValue(FACING) == EnumFacing.NORTH) {
            return new AxisAlignedBB(-0.4, 0.0, 0.3, 1.4, 3.0, 0.7);
        } else if (blockState.getValue(FACING) == EnumFacing.SOUTH) {
            return new AxisAlignedBB(-0.4, 0.0, 0.3, 1.4, 3.0, 0.7);
        } else if (blockState.getValue(FACING) == EnumFacing.WEST) {
            return new AxisAlignedBB(0.3, 0.0, -0.4, 0.7, 3.0, 1.4);
        } else if (blockState.getValue(FACING) == EnumFacing.EAST) {
            return new AxisAlignedBB(0.3, 0.0, -0.4, 0.7, 3.0, 1.4);
        }
        return new AxisAlignedBB(0.0, 0.0, 0.0, 1.0, 3.0, 1.0);
    }

    @SuppressWarnings("deprecation")
    @Override
    public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) {
        if(state.getValue(FACING) == EnumFacing.NORTH) {
            return new AxisAlignedBB(-0.4, 0.0, 0.3, 1.4, 3.0, 0.7);
        } else if (state.getValue(FACING) == EnumFacing.SOUTH) {
            return new AxisAlignedBB(-0.4, 0.0, 0.3, 1.4, 3.0, 0.7);
        } else if (state.getValue(FACING) == EnumFacing.WEST) {
            return new AxisAlignedBB(0.3, 0.0, -0.4, 0.7, 3.0, 1.4);
        } else if (state.getValue(FACING) == EnumFacing.EAST) {
            return new AxisAlignedBB(0.3, 0.0, -0.4, 0.7, 3.0, 1.4);
        }
        return new AxisAlignedBB(0.0, 0.0, 0.0, 1.0, 3.0, 1.0);
    }

    @Override
    public void onBlockAdded(World worldIn, BlockPos pos, IBlockState state) {
        setDefaultFacing(worldIn, pos, state);
    }

    private void setDefaultFacing(World worldIn, BlockPos pos, IBlockState state) {
        if (!worldIn.isRemote) {
            IBlockState iblockstate = worldIn.getBlockState(pos.north());
            IBlockState iblockstate1 = worldIn.getBlockState(pos.south());
            IBlockState iblockstate2 = worldIn.getBlockState(pos.west());
            IBlockState iblockstate3 = worldIn.getBlockState(pos.east());
            EnumFacing enumfacing = (EnumFacing)state.getValue(FACING);

            if (enumfacing == EnumFacing.NORTH && iblockstate.isFullBlock() && !iblockstate1.isFullBlock()) {
                enumfacing = EnumFacing.SOUTH;
            }
            else if (enumfacing == EnumFacing.SOUTH && iblockstate1.isFullBlock() && !iblockstate.isFullBlock()) {
                enumfacing = EnumFacing.NORTH;
            }
            else if (enumfacing == EnumFacing.WEST && iblockstate2.isFullBlock() && !iblockstate3.isFullBlock()) {
                enumfacing = EnumFacing.EAST;
            }
            else if (enumfacing == EnumFacing.EAST && iblockstate3.isFullBlock() && !iblockstate2.isFullBlock()) {
                enumfacing = EnumFacing.WEST;
            }

            worldIn.setBlockState(pos, state.withProperty(FACING, enumfacing), 2);
        }
    }

    @Override
    public void onBlockPlacedBy(World worldIn, BlockPos pos, IBlockState state, EntityLivingBase placer, ItemStack stack) {
        worldIn.setBlockState(pos, state.withProperty(FACING, placer.getHorizontalFacing().getOpposite()), 2);
    }

    @SideOnly(Side.CLIENT)
    public IBlockState getStateForEntityRender(IBlockState state) {
        return this.getDefaultState().withProperty(FACING, EnumFacing.NORTH);
    }

    protected BlockStateContainer createBlockState() {
        return new BlockStateContainer (this, new IProperty[] {FACING});
    }

    @Override
    public IBlockState withRotation(IBlockState state, Rotation rot) {
        return state.withProperty(FACING, rot.rotate((EnumFacing)state.getValue(FACING)));
    }

    @Override
    public IBlockState withMirror(IBlockState state, Mirror mirrorIn) {
        return state.withRotation(mirrorIn.toRotation((EnumFacing)state.getValue(FACING)));
    }

    public int getMetaFromState(IBlockState state) {
        return ((EnumFacing)state.getValue(FACING)).getIndex();
    }

    @Override
    public IBlockState getStateFromMeta(int meta) {
        EnumFacing enumfacing = EnumFacing.getFront(meta);
        if (enumfacing.getAxis() == EnumFacing.Axis.Y) enumfacing = EnumFacing.NORTH;
        return this.getDefaultState().withProperty(FACING, enumfacing);
    }

    @Override
    @SideOnly (Side.CLIENT)
    public BlockRenderLayer getBlockLayer () {
        return BlockRenderLayer.SOLID;
    }

    @SuppressWarnings("deprecation")
    @Override
    public boolean isOpaqueCube (IBlockState state) {
        return false;
    }

    @SuppressWarnings("deprecation")
    @Override
    public boolean isFullCube (IBlockState state) {
        return false;
    }

    @SuppressWarnings("deprecation")
    @Override
    public EnumBlockRenderType getRenderType(IBlockState state) {
        return EnumBlockRenderType.MODEL;
    }
}
