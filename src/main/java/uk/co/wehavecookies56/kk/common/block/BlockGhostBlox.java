package uk.co.wehavecookies56.kk.common.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyInteger;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
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

    protected BlockGhostBlox (Material material, String toolClass, int level, float hardness, float resistance) {
        super(material, toolClass, level, hardness, resistance);
    }

    public static final PropertyInteger VISIBLE = PropertyInteger.create(Properties.VISIBLE, 0, 1);

    @Override
    protected BlockStateContainer createBlockState () {

        return new BlockStateContainer(this, new IProperty[] { VISIBLE });
    }

    @SuppressWarnings("deprecation")
    @Override
    public IBlockState getStateFromMeta (int meta) {
        return getDefaultState().withProperty(VISIBLE, Integer.valueOf(meta));
    }

    @Override
    public int getMetaFromState (IBlockState state) {
        return state.getValue(VISIBLE).intValue();
    }

    @Override
    @SideOnly (Side.CLIENT)
    public BlockRenderLayer getBlockLayer () {
        return BlockRenderLayer.CUTOUT;
    }

    @SuppressWarnings("deprecation")
    @Override
    public boolean canProvidePower(IBlockState state) {
        return true;
    }

    @Override
    public void neighborChanged(IBlockState state, World world, BlockPos pos, Block block, BlockPos fromPos) {
        //Detection of neighbor ghost blox
        if (world.getBlockState(pos.east()).getBlock() == ModBlocks.GhostBlox) {
            if (world.getBlockState(pos).getValue(VISIBLE).intValue() == 1)
                world.setBlockState(pos.east(), world.getBlockState(pos.east()).withProperty(VISIBLE, Integer.valueOf(1)));
            else
                world.setBlockState(pos.east(), world.getBlockState(pos.east()).withProperty(VISIBLE, Integer.valueOf(0)));
        }
        if (world.getBlockState(pos.west()).getBlock() == ModBlocks.GhostBlox) {
            if (world.getBlockState(pos).getValue(VISIBLE).intValue() == 1)
                world.setBlockState(pos.west(), world.getBlockState(pos.west()).withProperty(VISIBLE, Integer.valueOf(1)));
            else
                world.setBlockState(pos.west(), world.getBlockState(pos.west()).withProperty(VISIBLE, Integer.valueOf(0)));
        }
        if (world.getBlockState(pos.north()).getBlock() == ModBlocks.GhostBlox) {
            if (world.getBlockState(pos).getValue(VISIBLE).intValue() == 1)
                world.setBlockState(pos.north(), world.getBlockState(pos.north()).withProperty(VISIBLE, Integer.valueOf(1)));
            else
                world.setBlockState(pos.north(), world.getBlockState(pos.north()).withProperty(VISIBLE, Integer.valueOf(0)));
        }
        if (world.getBlockState(pos.south()).getBlock() == ModBlocks.GhostBlox) {
            if (world.getBlockState(pos).getValue(VISIBLE).intValue() == 1)
                world.setBlockState(pos.south(), world.getBlockState(pos.south()).withProperty(VISIBLE, Integer.valueOf(1)));
            else
                world.setBlockState(pos.south(), world.getBlockState(pos.south()).withProperty(VISIBLE, Integer.valueOf(0)));
        }
        if (world.isBlockPowered(pos)){
            world.setBlockState(pos, world.getBlockState(pos).withProperty(VISIBLE, Integer.valueOf(1)));
        }else{
            world.setBlockState(pos, world.getBlockState(pos).withProperty(VISIBLE, Integer.valueOf(0)));
        }
    }

    @Override
    public void onBlockAdded (World world, BlockPos pos, IBlockState state) {
        if (!world.isRemote && world.getTileEntity(pos) == null) if (world.isBlockPowered(pos))
            world.setBlockState(pos, world.getBlockState(pos).withProperty(VISIBLE, Integer.valueOf(1)));
        else
            world.setBlockState(pos, world.getBlockState(pos).withProperty(VISIBLE, Integer.valueOf(0)));
    }

    @SuppressWarnings("deprecation")
    @Override
    public boolean isOpaqueCube(IBlockState state) {
        return false;
    }

    @SuppressWarnings("deprecation")
    @Override
    public AxisAlignedBB getSelectedBoundingBox(IBlockState worldIn, World pos, BlockPos state) {
        if (worldIn.getValue(VISIBLE).intValue() == 0)
            return new AxisAlignedBB(new BlockPos(0, 0, 0), new BlockPos(1, 1, 1));
        else
            return new AxisAlignedBB(new BlockPos(0, 0, 0), new BlockPos(0, 0, 0));
    }

    @SuppressWarnings("deprecation")
    @Override
    public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) {
        if (state.getValue(VISIBLE).intValue() == 0)
            return new AxisAlignedBB(new BlockPos(0, 0, 0), new BlockPos(1, 1, 1));
        else
            return new AxisAlignedBB(new BlockPos(0, 0, 0), new BlockPos(0, 0, 0));
    }
}
