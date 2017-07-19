package uk.co.wehavecookies56.kk.common.block.base;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class BlockBlox extends Block {

    protected BlockBlox (Material material, String toolClass, int level, float hardness, float resistance) {
        super(material);
        this.setHarvestLevel(toolClass, level);
        setHardness(hardness);
        setResistance(resistance);
    }
}
