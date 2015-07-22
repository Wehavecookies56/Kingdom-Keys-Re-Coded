package wehavecookies56.kk.entities.magic;

import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.projectile.EntityFireball;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.init.Blocks;
import net.minecraft.util.BlockPos;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import wehavecookies56.kk.lib.Reference;

public class EntityFire extends EntityThrowable
{
	private static final ResourceLocation resourceLocation = new ResourceLocation(Reference.MODID, "textures/entities/fire.png");
    public EntityLivingBase shootingEntity;

	public EntityFire(World world) {
		super(world);
	}

	public EntityFire(World world, EntityLivingBase entity) {
		super(world, entity);
	}

	public EntityFire(World world, double x, double y, double z) {
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
		this.worldObj.spawnParticle(EnumParticleTypes.FLAME, this.posX, this.posY, this.posZ, 0.0D, 0.0D, 0.0D);
		this.rotationYaw = (rotation + 1) % 360;
		if(ticksExisted > 60){
			setDead();
		}
		super.onUpdate();
	}
	@Override
	protected void onImpact(MovingObjectPosition movingObject) {
		if (!this.worldObj.isRemote)
        {
            boolean flag;

            if (movingObject.entityHit != null)
            {
            	flag = movingObject.entityHit.attackEntityFrom(DamageSource.causeThrownDamage(this, this.getThrower()), 8);
                if (flag)
                {
                    this.func_174815_a(this.shootingEntity, movingObject.entityHit);

                    if (!movingObject.entityHit.isImmuneToFire())
                    {
                        movingObject.entityHit.setFire(5);
                    }
                }
            }
            else
            {
                flag = true;

                if (this.shootingEntity != null && this.shootingEntity instanceof EntityLiving)
                {
                    flag = this.worldObj.getGameRules().getGameRuleBooleanValue("mobGriefing");
                }

                if (flag)
                {
                    BlockPos blockpos = movingObject.func_178782_a().offset(movingObject.field_178784_b);

                    if (this.worldObj.isAirBlock(blockpos))
                    {
                        this.worldObj.setBlockState(blockpos, Blocks.fire.getDefaultState());
                    }
                }
            }

            this.setDead();
        }
	}

}
