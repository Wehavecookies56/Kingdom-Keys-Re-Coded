package uk.co.wehavecookies56.kk.common.entity;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.projectile.EntitySnowball;
import net.minecraft.world.World;

public class EntityFlyingHeart extends EntitySnowball{
	public EntityFlyingHeart(World worldIn){
        super(worldIn);
    }
	public EntityFlyingHeart(World worldIn, double x, double y, double z) {
		super(worldIn, x, y+2, z);
	}

	@Override
	public void onUpdate(){
		//TODO make the entity move, not the render
		if(this.ticksExisted >= 30) {
			this.setDead();
		}
	}
}
