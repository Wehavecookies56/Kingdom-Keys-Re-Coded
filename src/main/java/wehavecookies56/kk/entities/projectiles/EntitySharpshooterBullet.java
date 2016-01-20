package wehavecookies56.kk.entities.projectiles;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;
import wehavecookies56.kk.entities.ExtendedPlayer;

public class EntitySharpshooterBullet extends EntityThrowable{

	int ticks;
	EntityPlayer player;
	public EntitySharpshooterBullet(World world) {
		super(world);
	}

	public EntitySharpshooterBullet(World world, EntityLivingBase entity, int ticksExisted) {
		super(world, entity);
		this.ticks = ticksExisted;
		this.player = (EntityPlayer) entity;
	}

	public EntitySharpshooterBullet(World world, double x, double y, double z) {
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
		if(this.ticks < 10){this.ticks = 10;}
		
		if(ticksExisted > this.ticks || ticksExisted > 60){
			setDead();
		}
		super.onUpdate();
	}
	@Override
	protected void onImpact(MovingObjectPosition mop) {
		if (mop.entityHit != null) {
			mop.entityHit.setFire(8);
			float shotDamage;
			if(ExtendedPlayer.get(player).getStrength()/2 <8)
			{
				shotDamage = 8;
			}
			else
			{
				shotDamage = ExtendedPlayer.get(player).getStrength()/2;
			}
			
			mop.entityHit.attackEntityFrom(DamageSource.causeThrownDamage(this, this.getThrower()), shotDamage);
		}

		this.worldObj.spawnParticle(EnumParticleTypes.FLAME, this.posX, this.posY, this.posZ, 0.0D, 0.0D, 0.0D);

		if (!worldObj.isRemote) {
			setDead();
		}
		
	}
}