package uk.co.wehavecookies56.kk.common.entity;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.projectile.EntitySnowball;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;

public class EntityFlyingHeart extends Entity
{
	
	public EntityFlyingHeart(World worldIn)
	{
        super(worldIn);
        this.setSize(0.5F, 1);
    }
 
	public void onUpdate()
	{
		this.posY += 0.15;
		
		if(this.ticksExisted >= 30) 
		{
			this.setDead();
		}
		
		super.onUpdate();
	}

	protected void entityInit()  {}

	protected void readEntityFromNBT(NBTTagCompound compound) {}

	protected void writeEntityToNBT(NBTTagCompound compound) {}
	
}
