package uk.co.wehavecookies56.kk.common.entity.projectiles.chakrams;

import java.util.List;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.init.Blocks;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.IThrowableEntity;
import uk.co.wehavecookies56.kk.common.KingdomKeys;
import uk.co.wehavecookies56.kk.common.capability.ModCapabilities;

public class EntityChakram extends EntityThrowable implements IThrowableEntity {
	EntityPlayer player;

	public EntityChakram(World world) {
		super(world);
	}

	public EntityChakram(World world, EntityLivingBase entity) {
		super(world, entity);
		this.player = (EntityPlayer) entity;
	}

	public EntityChakram(World world, double x, double y, double z) {
		super(world, x, y, z);
	}

	@Override
	protected float getGravityVelocity() {
		return 0.0F;
	}

	boolean returning = false;

	@Override
	public void onUpdate() {
		int rotation = 0;
		KingdomKeys.proxy.spawnTestParticle(world, posX + world.rand.nextDouble() * width * 2.0F - width, posY + world.rand.nextDouble() * height,
				posZ + world.rand.nextDouble() * width * 2.0F - width, world.rand.nextGaussian() * 0.02D, world.rand.nextGaussian() * 0.02D, world.rand.nextGaussian() * 0.02D, 0.2F);
		this.rotationYaw = (rotation + 1) % 360;

		if (ticksExisted > 15) {
			setReturn();
		}

		if (ticksExisted > 60)
			setDead();
		if (this.getThrower() == null)
			setDead();

		if (returning) {
			this.rotationYaw = (rotation + 1) % 360;
			List entityTagetList = this.world.getEntitiesWithinAABB(Entity.class, this.getEntityBoundingBox().grow(1.0D, 1.0D, 1.0D));
			for (int i = 0; i < entityTagetList.size(); i++) {
				Entity entityTarget = (Entity) entityTagetList.get(i);
				if (entityTarget != null && entityTarget instanceof EntityPlayer) {
					EntityPlayer owner = (EntityPlayer) entityTarget;
					if (owner == this.getThrower()) {
						this.setDead();
					}
				}
			}
		}
		super.onUpdate();
	}

	public void setReturn() {
		returning = true;
		setThrowableHeading(this.getThrower().posX - this.posX, this.getThrower().posY - this.posY + 1.25, this.getThrower().posZ - this.posZ, 1.5f, 0);
	}

	@Override
	protected void onImpact(RayTraceResult mop) {
		if (mop.entityHit != null) {
			if (mop.entityHit == this.getThrower()) {
				this.setReturn();
				return;
			}

			float shotDamage = player.getCapability(ModCapabilities.PLAYER_STATS, null).getStrength() * 0.8 < 8 ? 8 : (float) ((player.getCapability(ModCapabilities.PLAYER_STATS, null).getStrength() * 0.8));

			mop.entityHit.attackEntityFrom(DamageSource.causePlayerDamage((EntityPlayer) getThrower()), shotDamage);
		} else {
			BlockPos blockpos = mop.getBlockPos();
			if (this.world.getBlockState(blockpos).getBlock() != Blocks.TALLGRASS) {
				this.setReturn();
			}

		}

		this.world.spawnParticle(EnumParticleTypes.FLAME, this.posX, this.posY, this.posZ, 0.0D, 0.0D, 0.0D);
	}

	@Override
	public void setThrower(Entity entity) {

	}

}
