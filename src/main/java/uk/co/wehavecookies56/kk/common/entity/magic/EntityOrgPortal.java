package uk.co.wehavecookies56.kk.common.entity.magic;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.init.Blocks;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;
import uk.co.wehavecookies56.kk.common.network.packet.PacketDispatcher;
import uk.co.wehavecookies56.kk.common.network.packet.client.SpawnBlizzardParticles;
import uk.co.wehavecookies56.kk.common.network.packet.client.SpawnPortalParticles;

public class EntityOrgPortal extends Entity{
	public EntityLivingBase caster;
	BlockPos remotePos;
	public EntityOrgPortal (World world) {
		super(world);
	}

	public EntityOrgPortal (World world, EntityPlayer caster, BlockPos remotePos) {
		super(world);
		this.caster = caster;
		this.remotePos=remotePos;
	}

	@Override
	public void onUpdate () {
		super.onUpdate();
		if (caster == null)
			return;
		if (caster instanceof EntityPlayer)
		{
			if (!world.isRemote)
				PacketDispatcher.sendToAllAround(new SpawnPortalParticles(this.getPosition()), (EntityPlayer) caster, 64.0D);
		}
		if (ticksExisted > 600) setDead();
	}

	@Override
	protected void entityInit() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void readEntityFromNBT(NBTTagCompound compound) {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void writeEntityToNBT(NBTTagCompound compound) {
		// TODO Auto-generated method stub
		
	}
}
