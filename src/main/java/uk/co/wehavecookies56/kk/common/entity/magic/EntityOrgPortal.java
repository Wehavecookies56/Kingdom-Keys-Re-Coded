package uk.co.wehavecookies56.kk.common.entity.magic;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import uk.co.wehavecookies56.kk.common.capability.ModCapabilities;
import uk.co.wehavecookies56.kk.common.capability.OrganizationXIIICapability.IOrganizationXIII;
import uk.co.wehavecookies56.kk.common.network.packet.PacketDispatcher;
import uk.co.wehavecookies56.kk.common.network.packet.client.SpawnPortalParticles;
import uk.co.wehavecookies56.kk.common.network.packet.server.OrgPortalTP;

public class EntityOrgPortal extends Entity {

	EntityPlayer caster;
	//BlockPos remotePos;

	public EntityOrgPortal (World world) {
		super(world);
	}
	
	public EntityOrgPortal (World world, EntityPlayer sender, double x, double y, double z) {
		super(world);
		this.posX = x+0.5;
		this.posY = y;
		this.posZ = z+0.5;
		this.caster = sender;
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
		if (ticksExisted > 100) setDead();
	}

	@Override
	protected void entityInit() {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void onCollideWithPlayer(EntityPlayer player) {
		//System.out.println(player);
		if(!this.isEntityAlive())
			return;
		if(player != null){
			IOrganizationXIII orgXIII = player.getCapability(ModCapabilities.ORGANIZATION_XIII, null);
			player.setPositionAndUpdate(orgXIII.getPortalX()+0.5, orgXIII.getPortalY()+1, orgXIII.getPortalZ()+0.5);
			PacketDispatcher.sendToServer(new OrgPortalTP(orgXIII.getPortalX()+0.5, orgXIII.getPortalY()+1, orgXIII.getPortalZ()+0.5));
			
		}
		
		super.onCollideWithPlayer(player);
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
