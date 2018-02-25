package uk.co.wehavecookies56.kk.common.block.base;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyInteger;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockRenderLayer;
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
        setCreativeTab(ModBlocks.tabKingdomKeysBlocks);
        setRegistryName(name);
        setUnlocalizedName(name);
        this.setDefaultState(this.blockState.getBaseState().withProperty(VARIANT, 0));
    }

    @Override
    public void getSubBlocks(CreativeTabs tab, NonNullList<ItemStack> list) {
        if (tab == ModBlocks.tabKingdomKeysBlocks) {
        	for(int i=0;i<=15;i++) {
        		list.add(new ItemStack(this, 1, i));
        	}
        }
        super.getSubBlocks(tab, list);
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
