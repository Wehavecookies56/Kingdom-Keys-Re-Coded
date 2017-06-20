package uk.co.wehavecookies56.kk.common.block.base;

import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import uk.co.wehavecookies56.kk.common.block.ModBlocks;
import uk.co.wehavecookies56.kk.common.block.tile.TileEntityStationOfAwakening;

/**
 * Created by Toby on 01/08/2016.
 */

public class BlockSoAStructureBlock extends BlockContainer {


    public BlockSoAStructureBlock(String name) {
        super(Material.GLASS);
        setCreativeTab(ModBlocks.tabKingdomKeysBlocks);
        setUnlocalizedName(name);
        ModBlocks.registerBlock(this, name);

    }

    @Override
    public void breakBlock(World worldIn, BlockPos pos, IBlockState state) {
        TileEntityStationOfAwakening te = (TileEntityStationOfAwakening) worldIn.getTileEntity(pos);
        if (te != null) {
            worldIn.destroyBlock(te.getPos(), false);
            worldIn.removeTileEntity(te.getPos());
        }
    }

    @Override
    public void neighborChanged(IBlockState state, World worldIn, BlockPos pos, Block blockIn, BlockPos fromPos) {
        if (worldIn.getTileEntity(pos).getBlockType() == Blocks.AIR) {
            worldIn.destroyBlock(pos, false);
            worldIn.removeTileEntity(pos);
        }
    }

    @SuppressWarnings("deprecation")
    @Override
    public boolean shouldSideBeRendered(IBlockState blockState, IBlockAccess blockAccess, BlockPos pos, EnumFacing side) {
        return false;
    }

    @SuppressWarnings("deprecation")
    @Override
    public boolean isOpaqueCube(IBlockState state) {
        return false;
    }

    @Override
    public TileEntity createNewTileEntity(World worldIn, int meta) {
        return new TileEntityStationOfAwakening();
    }
}
