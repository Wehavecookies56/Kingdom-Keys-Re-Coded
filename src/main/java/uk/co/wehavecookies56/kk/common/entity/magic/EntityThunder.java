package uk.co.wehavecookies56.kk.common.entity.magic;

import java.util.List;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.world.World;
import uk.co.wehavecookies56.kk.common.network.packet.PacketDispatcher;
import uk.co.wehavecookies56.kk.common.network.packet.client.SpawnThunderEntity;
import uk.co.wehavecookies56.kk.common.network.packet.client.SpawnThunderParticles;

public class EntityThunder extends Entity {

	EntityPlayer player;
	public static boolean summonLightning = false;

	public EntityThunder (World world) {
		super(world);
	}

	public EntityThunder (World world, EntityPlayer sender, double x, double y, double z) {
		super(world);
		this.posX = x;
		this.posY = y;
		this.posZ = z;
		this.player = sender;
		double distance = 3.0D;
		AxisAlignedBB aabb = player.getEntityBoundingBox().expand(3, 3, 3);
		List list = this.worldObj.getEntitiesWithinAABBExcludingEntity(player, aabb);
		if (!list.isEmpty()) for (int i = 0; i < list.size(); i++) {
			Entity e = (Entity) list.get(i);
			if (e instanceof EntityLivingBase) {
				summonLightning = true;
				if (!worldObj.isRemote) PacketDispatcher.sendToAllAround(new SpawnThunderEntity(this, 1), player, 64.0D);
				this.worldObj.addWeatherEffect((new EntityLightningBolt(this.worldObj, e.posX, e.posY, e.posZ, false)));
			}
		}
		aabb.expand(-3, -3, -3);
	}

	@Override
	public void onUpdate () {
		if (player == null) return;
		int rotation = 0;
		if (!worldObj.isRemote) PacketDispatcher.sendToAllAround(new SpawnThunderParticles(this, 1), player, 64.0D);
		double r = 2.0D;

		for (int a = 1; a <= 360; a += 7) {
			double x = this.posX + (r * Math.cos(Math.toRadians(a)));
			double z = this.posZ + (r * Math.sin(Math.toRadians(a)));

			this.worldObj.spawnParticle(EnumParticleTypes.REDSTONE, x, this.posY + 1, z, 30, 15, 0);
		}

		this.rotationYaw = (rotation + 1) % 360;
		if (ticksExisted > 30) setDead();

		if (ticksExisted < 10)
			player.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0D);
		else
			player.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.10000000149011612D);
		if (ticksExisted > 30) summonLightning = false;
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
