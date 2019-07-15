package uk.co.wehavecookies56.kk.common.block.base;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import uk.co.wehavecookies56.kk.common.block.ModBlocks;

public class BlockBlox extends Block {

    protected BlockBlox (Material material, String toolClass, int level, float hardness, float resistance, String name) {
        super(material);
        this.setHarvestLevel(toolClass, level);
        setHardness(hardness);
        setResistance(resistance);
        setCreativeTab(ModBlocks.tabKingdomKeysBlocks);
        setRegistryName(name);
        setTranslationKey(name);
    }

   
}
