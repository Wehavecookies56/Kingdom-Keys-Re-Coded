package wehavecookies56.kk.block;

import java.util.Random;

import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import wehavecookies56.kk.entities.ExtendedPlayer;

public class BlockSavePoint extends BlockBlox {

	protected BlockSavePoint(Material material, String toolClass, int level,
			float hardness, float resistance) {
		super(material, toolClass, level, hardness, resistance);
        this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 0.0625F, 1.0F);

	}
	public void setBlockBoundsBasedOnState(IBlockAccess worldIn, BlockPos pos)
    {
    }
	
	public void onEntityCollidedWithBlock(World worldIn, BlockPos pos, Entity entityIn)
	{
		System.out.println("Entity: "+entityIn);
		if (!worldIn.isRemote)
	    {
			if(entityIn instanceof EntityPlayer)
			{
				EntityPlayer player = (EntityPlayer) entityIn;
				player.heal(ExtendedPlayer.get(player).getHP());
			 	ExtendedPlayer.get(player).setMp(100);
	            player.addPotionEffect(new PotionEffect(Potion.saturation.id, 1, 100));
	    		((EntityPlayer) entityIn).setSpawnPoint(pos, true);

		    	if(entityIn.isSneaking())
		    	{
		    		((EntityPlayer) entityIn).setSpawnChunk(pos, true, 0);
		    		((EntityPlayer) entityIn).setSpawnPoint(pos, true);
		    	}
			}
	    }
	}
	public AxisAlignedBB getCollisionBoundingBox(World worldIn, BlockPos pos, IBlockState state)
	{
		return null;
	}
	public boolean isOpaqueCube()
    {
        return false;
    }

    public boolean isFullCube()
    {
        return false;
    }
    
    public boolean isPassable(IBlockAccess worldIn, BlockPos pos)
    {
        return true;
    }
    
    protected AxisAlignedBB getSensitiveAABB(BlockPos pos)
    {
        float f = 0.125F;
        return new AxisAlignedBB((double)((float)pos.getX() + 0.125F), (double)pos.getY(), (double)((float)pos.getZ() + 0.125F), (double)((float)(pos.getX() + 1) - 0.125F), (double)pos.getY() + 0.25D, (double)((float)(pos.getZ() + 1) - 0.125F));
    }
    
    public void setBlockBoundsForItemRender()
    {
        float f = 0.5F;
        float f1 = 0.125F;
        float f2 = 0.5F;
        this.setBlockBounds(0.0F, 0.375F, 0.0F, 1.0F, 0.625F, 1.0F);
    }
    
	@Override
	public Item getItemDropped(IBlockState state, Random r, int fortune) 
	{
		return null;
	}

}
