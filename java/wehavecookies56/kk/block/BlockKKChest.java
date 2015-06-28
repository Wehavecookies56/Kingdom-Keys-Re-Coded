package wehavecookies56.kk.block;

import java.util.Random;

import wehavecookies56.kk.lib.Strings;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BlockKKChest extends BlockContainer
{

	protected Random rand = new Random();

	public BlockKKChest()
	{
		super(Material.rock);
		this.setUnlocalizedName(Strings.KKChest);
		this.setStepSound(soundTypeStone);
		this.setHardness(25.0F);
		this.setResistance(5.0F);
		this.setHarvestLevel("pickaxe", 3);
	}

	@Override
	public TileEntity createNewTileEntity(World worldIn, int meta) {
		// TODO Auto-generated method stub
		return null;
	}}
