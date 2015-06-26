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
    public void onBlockHarvested(World worldIn, BlockPos pos,
    		IBlockState state, EntityPlayer player) {
    	// TODO Auto-generated method stub
    	super.onBlockHarvested(worldIn, pos, state, player);
    }

/*    @Override
    public Item getItemDropped(IBlockState state, Random r, int fortune) 
    {
    	ItemStack BlazingShard = ItemStacks.BlazingShard;
    	ItemStack BlazingStone = ItemStacks.BlazingStone;
    	ItemStack BlazingGem = ItemStacks.BlazingGem;
    	ItemStack BlazingCrystal = ItemStacks.BlazingCrystal;

    	ItemStack sm=null;
    	BlazingShard.setTagCompound(new NBTTagCompound());    	
		int randomDrop;
	    randomDrop = r.nextInt(99);	    
	   
	    BlazingShard.getTagCompound().setString("material", "BlazingShard");
	    
    	if(randomDrop<=25 && randomDrop>=0)
    	{
    		sm = BlazingShard;
    	    sm.getTagCompound().setString("material", "BlazingShard");

    	    ItemStacks.createSynthesisItem(sm, "BlazingShard", "C");
	    }
    	else if(randomDrop<=50 && randomDrop>=26)
	    {
    		BlazingStone.getTagCompound().setString("material", "BlazingShard");
	    }
    	else if(randomDrop<=75 && randomDrop>=51)
    	{
    		BlazingGem.getTagCompound().setString("material", "BlazingShard");
	    }
    	else if(randomDrop<=100 && randomDrop>=76)
    	{
    		BlazingCrystal.getTagCompound().setString("material", "BlazingShard");
	    }
    	return sm.getItem();
    }*/

}
