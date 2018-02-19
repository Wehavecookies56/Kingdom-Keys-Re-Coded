package uk.co.wehavecookies56.kk.common.entity;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.projectile.EntitySnowball;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import uk.co.wehavecookies56.kk.common.KingdomKeys;

public class EntityFlyingHeart extends Entity{
	public final static int MAX_TICKS = 30;
	public EntityFlyingHeart(World worldIn){
        super(worldIn);
        this.setSize(0.5F, 1);
    }
 
	public void onUpdate(){
		if(this.ticksExisted < MAX_TICKS - 10) {
			this.posY += 0.15;
		} else {
			KingdomKeys.proxy.spawnDarkSmokeParticle(world, posX, posY, posZ, 0, 0, 0, 0.1F);
		}
		
		if(this.ticksExisted >= MAX_TICKS) {
			this.setDead();
		}
		
		super.onUpdate();
	}

	protected void entityInit()  {}

	protected void readEntityFromNBT(NBTTagCompound compound) {}

	protected void writeEntityToNBT(NBTTagCompound compound) {}
	
}
