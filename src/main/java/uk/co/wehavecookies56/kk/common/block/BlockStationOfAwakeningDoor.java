package uk.co.wehavecookies56.kk.common.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockHorizontal;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import javax.annotation.Nullable;

/**
 * Created by Toby on 09/08/2016.
 */
public class BlockStationOfAwakeningDoor extends Block {

    public static final PropertyDirection FACING = BlockHorizontal.FACING;

    public BlockStationOfAwakeningDoor(String name) {
        super(Material.IRON);
        setUnlocalizedName(name);
        setCreativeTab(ModBlocks.tabKingdomKeysBlocks);
    }

    @SuppressWarnings("deprecation")
    @Nullable
    @Override
    public AxisAlignedBB getCollisionBoundingBox(IBlockState blockState, World worldIn, BlockPos pos) {
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

    public static EnumFacing getFacingFromEntity(World worldIn, BlockPos clickedBlock, EntityLivingBase entityIn) {
        return entityIn.getHorizontalFacing().getOpposite();
    }

    @Override
    public void onBlockPlacedBy (World worldIn, BlockPos pos, IBlockState state, EntityLivingBase placer, ItemStack stack) {
        worldIn.setBlockState(pos, state.withProperty(FACING, getFacingFromEntity(worldIn, pos, placer)), 2);
    }

    @Override
    public IBlockState onBlockPlaced (World worldIn, BlockPos pos, EnumFacing facing, float hitX, float hitY, float hitZ, int meta, EntityLivingBase placer) {
        return this.getDefaultState().withProperty(FACING, getFacingFromEntity(worldIn, pos, placer));
    }


    @SideOnly(Side.CLIENT)
    public IBlockState getStateForEntityRender(IBlockState state) {
        return this.getDefaultState().withProperty(FACING, EnumFacing.NORTH);
    }

    protected BlockStateContainer createBlockState() {
        return new BlockStateContainer (this, new IProperty[] {FACING});
    }

    public int getMetaFromState(IBlockState state) {
        return ((EnumFacing)state.getValue(FACING)).getIndex();
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

    @Override
    public boolean isVisuallyOpaque () {
        return false;
    }

    @SuppressWarnings("deprecation")
    @Override
    public EnumBlockRenderType getRenderType(IBlockState state) {
        return EnumBlockRenderType.MODEL;
    }
}
