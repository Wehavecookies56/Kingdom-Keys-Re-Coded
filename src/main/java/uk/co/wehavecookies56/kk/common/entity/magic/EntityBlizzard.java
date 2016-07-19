package uk.co.wehavecookies56.kk.common.entity.magic;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.init.Blocks;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;
import uk.co.wehavecookies56.kk.common.network.packet.PacketDispatcher;
import uk.co.wehavecookies56.kk.common.network.packet.client.SpawnBlizzardParticles;

public class EntityBlizzard extends EntityThrowable {
	public EntityPlayer shootingEntity;

	public EntityBlizzard (World world) {
		super(world);
	}

	public EntityBlizzard (World world, EntityLivingBase entity) {
		super(world, entity);
		shootingEntity = (EntityPlayer) entity;
	}

	public EntityBlizzard (World world, double x, double y, double z) {
		super(world, x, y, z);
	}

	@Override
	protected float getGravityVelocity () {
		return 0.0F;
	}

	@Override
	public void onUpdate () {
		super.onUpdate();
		if (shootingEntity == null) return;
		int rotation = 0;
		if (!worldObj.isRemote) PacketDispatcher.sendToAllAround(new SpawnBlizzardParticles(this, 1), shootingEntity, 64.0D);
		this.rotationYaw = (rotation + 1) % 360;
		if (ticksExisted > 60) setDead();
	}

	@Override
	protected void onImpact (RayTraceResult movingObject) {
		if (!this.worldObj.isRemote) {
			boolean flag;

			if (movingObject.entityHit != null) {
				flag = movingObject.entityHit.attackEntityFrom(DamageSource.causeThrownDamage(this, getThrower()), 8);
				if (flag) {
					applyEnchantments(this.shootingEntity, movingObject.entityHit);
					if (movingObject.entityHit.isBurning())
						movingObject.entityHit.extinguish();
					else
						movingObject.entityHit.attackEntityFrom(DamageSource.causePlayerDamage(shootingEntity), DamageCalculation.getMagicDamage(shootingEntity,"normal"));
				}
			} else {
				flag = true;

				if (this.shootingEntity != null && this.shootingEntity instanceof EntityPlayer) flag = this.worldObj.getGameRules().getBoolean("mobGriefing");

				if (flag) {
					BlockPos blockpos = movingObject.getBlockPos().offset(movingObject.sideHit);

					if (this.worldObj.getBlockState(blockpos).getBlock() == Blocks.WATER)
						this.worldObj.setBlockState(blockpos, Blocks.ICE.getDefaultState());
					else if (this.worldObj.getBlockState(blockpos).getBlock() == Blocks.FIRE)
						this.worldObj.setBlockState(blockpos, Blocks.AIR.getDefaultState());
					else if (this.worldObj.getBlockState(blockpos).getBlock() == Blocks.LAVA) this.worldObj.setBlockState(blockpos, Blocks.OBSIDIAN.getDefaultState());
				}
			}
			setDead();
		}
	}

}
