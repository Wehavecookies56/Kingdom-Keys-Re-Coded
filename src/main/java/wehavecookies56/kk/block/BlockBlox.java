package wehavecookies56.kk.block;

import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.util.EnumFacing;

public class BlockBlox extends Block {

	protected BlockBlox(Material material, String toolClass, int level, float hardness, float resistance) {
		super(material);
		this.setHarvestLevel(toolClass, level);
		this.setHardness(hardness);
		this.setResistance(resistance);
	}
}
