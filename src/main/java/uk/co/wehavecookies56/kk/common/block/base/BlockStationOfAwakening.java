package uk.co.wehavecookies56.kk.common.block.base;

import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyInteger;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import uk.co.wehavecookies56.kk.common.block.ModBlocks;
import uk.co.wehavecookies56.kk.common.lib.Properties;

/**
 * Created by Toby on 02/08/2016.
 */
public class BlockStationOfAwakening extends Block {

    public static final IProperty<Integer> VARIANT = PropertyInteger.create(Properties.VARIANT, 0, 15);

    public BlockStationOfAwakening(String name) {
        super(Material.GLASS);
        setUnlocalizedName(name);
        setCreativeTab(ModBlocks.tabKingdomKeysBlocks);
        this.setDefaultState(this.blockState.getBaseState().withProperty(VARIANT, 0));
    }

    @Override
    public void getSubBlocks(Item itemIn, CreativeTabs tab, NonNullList<ItemStack> list) {
        list.add(new ItemStack(itemIn, 1, 0));
        list.add(new ItemStack(itemIn, 1, 1));
        list.add(new ItemStack(itemIn, 1, 2));
        list.add(new ItemStack(itemIn, 1, 3));
        list.add(new ItemStack(itemIn, 1, 4));
        list.add(new ItemStack(itemIn, 1, 5));
        list.add(new ItemStack(itemIn, 1, 6));
        list.add(new ItemStack(itemIn, 1, 7));
        list.add(new ItemStack(itemIn, 1, 8));
        list.add(new ItemStack(itemIn, 1, 9));
        list.add(new ItemStack(itemIn, 1, 10));
        list.add(new ItemStack(itemIn, 1, 11));
        list.add(new ItemStack(itemIn, 1, 12));
        list.add(new ItemStack(itemIn, 1, 13));
        list.add(new ItemStack(itemIn, 1, 14));
        list.add(new ItemStack(itemIn, 1, 15));
    }

    @Override
    public void onBlockPlacedBy (World worldIn, BlockPos pos, IBlockState state, EntityLivingBase placer, ItemStack stack) {
        worldIn.setBlockState(pos, state.withProperty(VARIANT, stack.getMetadata()), 2);
    }

    protected BlockStateContainer createBlockState() {
        return new BlockStateContainer (this, VARIANT);
    }

    @Override
    public BlockRenderLayer getBlockLayer() {
        return BlockRenderLayer.CUTOUT;
    }

    @SuppressWarnings("deprecation")
    @Override
    public boolean isOpaqueCube(IBlockState state) {
        return false;
    }

    public int getMetaFromState(IBlockState state) {
        return (state.getValue(VARIANT)).intValue();
    }

    @SuppressWarnings("deprecation")
    @Override
    public IBlockState getStateFromMeta(int meta) {
        return this.getDefaultState().withProperty(VARIANT, meta);
    }
}
