package uk.co.wehavecookies56.kk.common.entity.magic;

import java.util.List;

import javax.annotation.Nonnull;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.world.World;
import uk.co.wehavecookies56.kk.common.network.packet.PacketDispatcher;
import uk.co.wehavecookies56.kk.common.network.packet.client.SpawnAeroParticles;

public class EntityAero extends Entity {

	EntityPlayer player;
	boolean driveForm;

	public EntityAero(World world) {
		super(world);
	}

	public EntityAero(World world, EntityPlayer sender, double x, double y, double z, boolean driveForm) {
		super(world);
		this.posX = x;
		this.posY = y;
		this.posZ = z;
		this.player = sender;
		this.driveForm = driveForm;
	}

	@Override
	public void onUpdate() {
		if (player == null)
			return;

		int rotation = 0;


		if (!driveForm) {			
			if (!world.isRemote)
				PacketDispatcher.sendToAllAround(new SpawnAeroParticles(this, 1), player, 64.0D);

			double r = 1.5D;

			for (int a = 1; a <= 360; a += 15) {
				double x = this.posX + (r * Math.cos(Math.toRadians(a)));
				double z = this.posZ + (r * Math.sin(Math.toRadians(a)));

				this.world.spawnParticle(EnumParticleTypes.EXPLOSION_NORMAL, x, this.posY, z, 0.0D, 0.5D, 0.0D);
			}
		}

		this.rotationYaw = (rotation + 1) % 360;
		if (ticksExisted > 30)
			setDead();

		if (ticksExisted < 10)
			player.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0D);
		else
			player.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.10000000149011612D);

		AxisAlignedBB aabb = player.getEntityBoundingBox().grow(2, 2, 2);
		List list = this.world.getEntitiesWithinAABBExcludingEntity(player, aabb);
		if (!list.isEmpty())
			for (int i = 0; i < list.size(); i++) {
				Entity e = (Entity) list.get(i);
				if (e instanceof EntityLivingBase) {
					if(!driveForm) {
						e.attackEntityFrom(DamageSource.causePlayerDamage(player), DamageCalculation.getMagicDamage(player, 1) * DamageCalculation.aeroMultiplier);
					}
					
					double d = e.posX - posX;
					double d1;
					for (d1 = e.posZ - posZ; d * d + d1 * d1 < 0.0001D; d1 = (Math.random() - Math.random()) * 0.01D)
						d = (Math.random() - Math.random()) * 0.01D;
					if(driveForm)
						((EntityLivingBase) e).knockBack(e, 1, -d, -d1);
					else
						((EntityLivingBase) e).knockBack(e, 1, d, d1);
					e.motionY *= 1.2;
				}
			}
		aabb.grow(-2, -2, -2);

		super.onUpdate();
	}

	@Override
	protected void entityInit() {

	}

	@Override
	protected void readEntityFromNBT(@Nonnull NBTTagCompound tagCompund) {

	}

	@Override
	protected void writeEntityToNBT(@Nonnull NBTTagCompound tagCompound) {

	}

	@Override
	@Nonnull
	public AxisAlignedBB getEntityBoundingBox() {
		return new AxisAlignedBB(0D, 0D, 0D, 1D, 1D, 1D);
	}

}
