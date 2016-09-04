package uk.co.wehavecookies56.kk.common.block;

import java.util.Random;

import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.IBlockAccess;
import uk.co.wehavecookies56.kk.common.block.base.BlockKKOre;

public class BlockBrightOre extends BlockKKOre {
	protected BlockBrightOre (Material material, String toolClass, int level, float hardness, float resistance) {
		super(material, toolClass, level, hardness, resistance);
	}	
}
