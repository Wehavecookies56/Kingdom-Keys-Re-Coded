package wehavecookies56.kk.entities.projectiles;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

public class EntityEternalFlamesProjectile extends EntityThrowable{

	int ticks;
	public EntityEternalFlamesProjectile(World world) {
		super(world);
	}

	public EntityEternalFlamesProjectile(World world, EntityLivingBase entity, int ticksExisted) {
		super(world, entity);
		this.ticks = ticksExisted;
		
	}

	public EntityEternalFlamesProjectile(World world, double x, double y, double z) {
		super(world, x, y, z);
	}
	
	@Override
	protected float getGravityVelocity() {
		return 0.0F;
	}
		
	@Override
	public void onUpdate() {
		int rotation = 0;
		this.worldObj.spawnParticle(EnumParticleTypes.FLAME, this.posX, this.posY, this.posZ, 0.0D, 0.0D, 0.0D);
		this.rotationYaw = (rotation + 1) % 360;
		if(ticksExisted > 60){
			setDead();
		}
		super.onUpdate();
	}
	@Override
	protected void onImpact(MovingObjectPosition mop) {
		if (mop.entityHit != null) {
			mop.entityHit.setFire(8);
			float shotDamage = 8;
			mop.entityHit.attackEntityFrom(DamageSource.causeThrownDamage(this, this.getThrower()), shotDamage);
			
		}

		this.worldObj.spawnParticle(EnumParticleTypes.FLAME, this.posX, this.posY, this.posZ, 0.0D, 0.0D, 0.0D);

		if (!worldObj.isRemote) {
			setDead();
		}
		
	}
}