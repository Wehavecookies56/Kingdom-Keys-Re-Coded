package wehavecookies56.kk.block;

import java.util.Random;

import wehavecookies56.kk.lib.Strings;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BlockKKChest extends BlockContainer{
	protected Random rand = new Random();

	protected BlockKKChest(Material material, String toolClass, int level, float hardness, float resistance) {
		super(material);
		this.setHarvestLevel(toolClass, level);
		this.setHardness(hardness);
		this.setResistance(resistance);
	}

	@Override
	public TileEntity createNewTileEntity(World worldIn, int meta) {
		// TODO Auto-generated method stub
		return null;
	}

}
