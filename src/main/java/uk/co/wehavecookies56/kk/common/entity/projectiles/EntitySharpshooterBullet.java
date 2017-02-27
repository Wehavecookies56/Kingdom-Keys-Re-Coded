package uk.co.wehavecookies56.kk.common.entity.projectiles;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.IThrowableEntity;
import uk.co.wehavecookies56.kk.common.capability.ModCapabilities;

public class EntitySharpshooterBullet extends EntityThrowable implements IThrowableEntity{
	EntityPlayer player;

	public EntitySharpshooterBullet (World world) {
		super(world);
	}

	public EntitySharpshooterBullet (World world, EntityLivingBase entity) {
		super(world, entity);
		this.player = (EntityPlayer) entity;
	}

	public EntitySharpshooterBullet (World world, double x, double y, double z) {
		super(world, x, y, z);
	}

	@Override
	protected float getGravityVelocity () {
		return 0.0F;
	}

	@Override
	public void onUpdate () {
		super.onUpdate();

		this.world.spawnParticle(EnumParticleTypes.CRIT_MAGIC, this.posX, this.posY, this.posZ, 0, 0, 0);

		if (ticksExisted > 60)
			setDead();
	}

	@Override
	protected void onImpact (RayTraceResult mop) {
		if (mop.entityHit != null) {
			if (mop.entityHit == this.getThrower()) {
				this.setDead();
				return;
			}
			float shotDamage;
			if (player.getCapability(ModCapabilities.PLAYER_STATS, null).getStrength() < 2)
				shotDamage = 2;
			else
				shotDamage = (float) ((player.getCapability(ModCapabilities.PLAYER_STATS, null).getStrength())-(player.getCapability(ModCapabilities.PLAYER_STATS, null).getStrength()));
			mop.entityHit.attackEntityFrom(DamageSource.causePlayerDamage((EntityPlayer) getThrower()), shotDamage);
			
		}
		this.setDead();
	}
	
	@Override
	public void setThrower (Entity entity) {
		
	}
}