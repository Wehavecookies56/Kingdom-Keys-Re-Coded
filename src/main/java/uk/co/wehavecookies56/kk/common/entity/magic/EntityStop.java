package uk.co.wehavecookies56.kk.common.entity.magic;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.play.server.SPacketEntityVelocity;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.world.World;
import uk.co.wehavecookies56.kk.common.network.packet.PacketDispatcher;
import uk.co.wehavecookies56.kk.common.network.packet.client.SpawnStopParticles;

import java.util.List;

public class EntityStop extends Entity {

	EntityPlayer player;

	public EntityStop (World world) {
		super(world);
	}

	public EntityStop (World world, EntityPlayer sender, double x, double y, double z) {
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
		if (!worldObj.isRemote) PacketDispatcher.sendToAllAround(new SpawnStopParticles(this, 1), player, 64.0D);
		double r = 1.5D;

		for (int a = 1; a <= 360; a += 15) {
			double x = this.posX + (r * Math.cos(Math.toRadians(a)));
			double z = this.posZ + (r * Math.sin(Math.toRadians(a)));

			this.worldObj.spawnParticle(EnumParticleTypes.ENCHANTMENT_TABLE, x, this.posY, z, 0.0D, 1D, 0.0D);
		}

		this.rotationYaw = (rotation + 1) % 360;
		if (ticksExisted > 50) setDead();

		if (ticksExisted < 10)
			player.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0D);
		else
			player.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.10000000149011612D);

		double distance = 3.0D;
		AxisAlignedBB aabb = player.getEntityBoundingBox().expand(2, 2, 2);
		List list = this.worldObj.getEntitiesWithinAABBExcludingEntity(player, aabb);
		if (!list.isEmpty()) for (int i = 0; i < list.size(); i++) {
			Entity e = (Entity) list.get(i);
			if (e instanceof EntityLiving) {
				if (ticksExisted < 50) {
					((EntityLivingBase) e).motionX = 0;
					((EntityLivingBase) e).motionY = 0;
					((EntityLivingBase) e).motionZ = 0;
				}
			}
			if (!worldObj.isRemote) {
				((EntityPlayerMP) player).connection.sendPacket(new SPacketEntityVelocity(e.getEntityId(), 0, 0, 0));
			}
			
		}
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
