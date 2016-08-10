package uk.co.wehavecookies56.kk.common.entity.magic;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;
import uk.co.wehavecookies56.kk.client.core.handler.InputHandler;
import uk.co.wehavecookies56.kk.common.capability.ModCapabilities;
import uk.co.wehavecookies56.kk.common.network.packet.PacketDispatcher;
import uk.co.wehavecookies56.kk.common.network.packet.client.SpawnBlizzardParticles;
import uk.co.wehavecookies56.kk.common.network.packet.client.SpawnLockOnParticle;

public class EntityLockOn extends EntityThrowable {
	public EntityPlayer player;

	public EntityLockOn (World world) {
		super(world);
	}

	public EntityLockOn (World world, EntityLivingBase entity) {
		super(world, entity);
		player = (EntityPlayer) entity;
	}

	public EntityLockOn (World world, double x, double y, double z) {
		super(world, x, y, z);
	}

	@Override
	protected float getGravityVelocity () {
		return 0.0F;
	}

	@Override
	public void onUpdate () {
		super.onUpdate();
		if (player == null) return;
		if (!worldObj.isRemote) PacketDispatcher.sendToAllAround(new SpawnBlizzardParticles(this, 1), player, 64.0D);
		if (ticksExisted > 60) setDead();
	}

	@Override
	protected void onImpact (RayTraceResult movingObject) {
		if (!this.worldObj.isRemote) {
			Entity target;
			if (movingObject.entityHit != null) {
				target = movingObject.entityHit;
				System.out.println("Target: "+target+ "by: "+player);
				PacketDispatcher.sendTo(new SpawnLockOnParticle(target), (EntityPlayerMP) player);
				InputHandler.lockOn = target;
			}
			setDead();
		}
	}

}
