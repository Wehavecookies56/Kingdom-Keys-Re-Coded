package uk.co.wehavecookies56.kk.common.entity;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.projectile.EntitySnowball;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import uk.co.wehavecookies56.kk.common.KingdomKeys;

public class EntityXPGet extends Entity{
	public final static int MAX_TICKS = 30;
	public static int xp;
	public EntityXPGet(World worldIn, float hp){
        super(worldIn);
        this.setSize(0.5F, 1);
        this.xp = (int) (hp/2);
    }
	
	public EntityXPGet(World worldIn){
        super(worldIn);
        this.setSize(0.5F, 1);
    }
 
	public void onUpdate(){
				
		if(this.ticksExisted >= MAX_TICKS) {
			this.setDead();
		}
		
		super.onUpdate();
	}

	protected void entityInit()  {}

	protected void readEntityFromNBT(NBTTagCompound compound) {}

	protected void writeEntityToNBT(NBTTagCompound compound) {}
	
}
