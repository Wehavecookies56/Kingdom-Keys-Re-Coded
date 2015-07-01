package wehavecookies56.kk.block;

import java.util.Random;

import wehavecookies56.kk.item.ItemStacks;
import wehavecookies56.kk.item.ModItems;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockBlazingOre extends BlockBlox {

	protected BlockBlazingOre(Material material, String toolClass, int level, float hardness, float resistance)
	{ 
			super(material, toolClass, level, hardness, resistance);
	}
	
	private Random rand = new Random();
       
    @Override
    protected boolean canSilkHarvest()
    {
            return true;
    }

    @Override
    public Item getItemDropped(IBlockState state, Random r, int fortune) 
    {
		return null;
    }

}
