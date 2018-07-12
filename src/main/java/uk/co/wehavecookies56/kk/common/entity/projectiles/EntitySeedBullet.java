package uk.co.wehavecookies56.kk.common.entity.projectiles;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;

public class EntitySeedBullet extends EntityThrowable
{
	private EntityLivingBase ent;
	private int ticks = 30;
	
	public EntitySeedBullet(World world)
	{
		super(world);
	}

	public EntitySeedBullet(World world, EntityLivingBase entity)
	{
		super(world, entity);
		this.ent = (EntityLivingBase) entity;
	}

	public EntitySeedBullet(World world, double x, double y, double z)
	{
		super(world, x, y, z);
	}

    protected float getGravityVelocity () 
    {
        return 0.0F;
    }
	
	protected void onImpact(RayTraceResult result)
	{
		if(result.entityHit != null)
		{
			result.entityHit.attackEntityFrom(DamageSource.causeThrownDamage(this, ent), 6);
		}
	}

	public void onEntityUpdate()
	{			
		if(ticks <= 0)
		{
			ticks = 30;
			this.setDead();
		}
		else
			ticks--;
	}
}
