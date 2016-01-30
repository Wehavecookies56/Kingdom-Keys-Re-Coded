package wehavecookies56.kk.entities.magic;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.init.Blocks;
import net.minecraft.util.BlockPos;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;
import wehavecookies56.kk.network.packet.PacketDispatcher;
import wehavecookies56.kk.network.packet.client.SpawnBlizzardParticles;

public class EntityBlizzard extends EntityThrowable {
	public EntityPlayer shootingEntity;

	public EntityBlizzard(World world) {
		super(world);
	}

	public EntityBlizzard(World world, EntityLivingBase entity) {
		super(world, entity);
		shootingEntity = (EntityPlayer) entity;
	}

	public EntityBlizzard(World world, double x, double y, double z) {
		super(world, x, y, z);
	}

	@Override
	protected float getGravityVelocity() {
		return 0.0F;
	}

	@Override
	public void onUpdate() {
		super.onUpdate();
		if (shootingEntity == null)
			return;
		int rotation = 0;
		if (!worldObj.isRemote)
			PacketDispatcher.sendToAllAround(new SpawnBlizzardParticles(this, 1), shootingEntity, 64.0D);
		this.rotationYaw = (rotation + 1) % 360;
		if (ticksExisted > 60)
			setDead();
	}

	@Override
	protected void onImpact(MovingObjectPosition movingObject) {
		if (!this.worldObj.isRemote) {
			boolean flag;

			if (movingObject.entityHit != null) {
				flag = movingObject.entityHit.attackEntityFrom(DamageSource.causeThrownDamage(this, getThrower()), 8);
				if (flag) {
					applyEnchantments(this.shootingEntity, movingObject.entityHit);
					if (movingObject.entityHit.isBurning())
						movingObject.entityHit.extinguish();
					else
						movingObject.entityHit.attackEntityFrom(DamageSource.magic, 4);
				}
			} else {
				flag = true;

				if (this.shootingEntity != null && this.shootingEntity instanceof EntityPlayer)
					flag = this.worldObj.getGameRules().getGameRuleBooleanValue("mobGriefing");

				if (flag) {
					BlockPos blockpos = movingObject.getBlockPos().offset(movingObject.sideHit);

					if (this.worldObj.getBlockState(blockpos).getBlock() == Blocks.water)
						this.worldObj.setBlockState(blockpos, Blocks.ice.getDefaultState());
					else if (this.worldObj.getBlockState(blockpos).getBlock() == Blocks.fire)
						this.worldObj.setBlockState(blockpos, Blocks.air.getDefaultState());
					else if (this.worldObj.getBlockState(blockpos).getBlock() == Blocks.lava)
						this.worldObj.setBlockState(blockpos, Blocks.obsidian.getDefaultState());
				}
			}
			setDead();
		}
	}

}
