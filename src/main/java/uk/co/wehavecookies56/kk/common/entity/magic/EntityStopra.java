package uk.co.wehavecookies56.kk.common.entity.magic;

import java.util.List;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.world.World;
import uk.co.wehavecookies56.kk.common.network.packet.PacketDispatcher;
import uk.co.wehavecookies56.kk.common.network.packet.client.SpawnStopParticles;

public class EntityStopra extends Entity {

	EntityPlayer player;

	public EntityStopra (World world) {
		super(world);
	}

	public EntityStopra (World world, EntityPlayer sender, double x, double y, double z) {
		super(world);
		this.posX = x;
		this.posY = y;
		this.posZ = z;
		this.player = sender;
	}

	@Override
	public void onUpdate () {
		if (player == null) return;
		int rotation = 0;
		if (!world.isRemote) PacketDispatcher.sendToAllAround(new SpawnStopParticles(this, 2), player, 64.0D);
		double r = 2.0D;

		for (int a = 1; a <= 360; a += 15) {
			double x = this.posX + (r * Math.cos(Math.toRadians(a)));
			double z = this.posZ + (r * Math.sin(Math.toRadians(a)));

			this.world.spawnParticle(EnumParticleTypes.ENCHANTMENT_TABLE, x, this.posY, z, 0.0D, 0.5D, 0.0D);
		}

		this.rotationYaw = (rotation + 1) % 360;
		if (ticksExisted > 120) setDead();

		if (ticksExisted < 10)
			player.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0D);
		else
			player.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.10000000149011612D);

		double distance = 4.0D;
		AxisAlignedBB aabb = player.getEntityBoundingBox().expand(2, 2, 2);
		List<Entity> list = this.world.getEntitiesWithinAABBExcludingEntity(player, aabb);
		if (!list.isEmpty()) list.forEach(e -> {
			if (e instanceof EntityLiving) {
				if (ticksExisted < 200) {
					((EntityLivingBase) e).motionX = 0;
					((EntityLivingBase) e).motionY = 0;
					((EntityLivingBase) e).motionZ = 0;
				}
			}
		});
		aabb.expand(-2, -2, -2);

		super.onUpdate();
	}

	@Override
	protected void entityInit () {

	}

	@Override
	protected void readEntityFromNBT (NBTTagCompound tagCompund) {

	}

	@Override
	protected void writeEntityToNBT (NBTTagCompound tagCompound) {

	}

	@Override
	public AxisAlignedBB getEntityBoundingBox () {

		return new AxisAlignedBB(0D, 0D, 0D, 1D, 1D, 1D);
	}

}
