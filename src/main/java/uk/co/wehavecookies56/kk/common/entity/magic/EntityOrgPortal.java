package uk.co.wehavecookies56.kk.common.entity.magic;

import io.netty.buffer.ByteBuf;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.IEntityAdditionalSpawnData;
import uk.co.wehavecookies56.kk.common.capability.ModCapabilities;
import uk.co.wehavecookies56.kk.common.capability.OrganizationXIIICapability.IOrganizationXIII;
import uk.co.wehavecookies56.kk.common.network.packet.PacketDispatcher;
import uk.co.wehavecookies56.kk.common.network.packet.client.SpawnPortalParticles;
import uk.co.wehavecookies56.kk.common.network.packet.client.SyncOrgXIIIData;
import uk.co.wehavecookies56.kk.common.network.packet.server.OrgPortalTP;

import java.nio.charset.Charset;

public class EntityOrgPortal extends Entity implements IEntityAdditionalSpawnData {

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

	public void setCaster(EntityPlayer caster) {
		this.caster = caster;
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
		//THIS IS ON THE CLIENT
		System.out.println(caster);
		if(!this.isEntityAlive())
			return;
		if(player != null){
			if (caster != null) {
				IOrganizationXIII orgXIII = caster.getCapability(ModCapabilities.ORGANIZATION_XIII, null);
				player.setPositionAndUpdate(orgXIII.getPortalX()+0.5, orgXIII.getPortalY()+1, orgXIII.getPortalZ()+0.5);
				PacketDispatcher.sendToServer(new OrgPortalTP(orgXIII.getPortalX()+0.5, orgXIII.getPortalY()+1, orgXIII.getPortalZ()+0.5));
			}
		}
		
		super.onCollideWithPlayer(player);
	}

	@Override
	protected void writeEntityToNBT(NBTTagCompound compound) {

	}

	@Override
	protected void readEntityFromNBT(NBTTagCompound compound) {

	}

	@Override
	public void readFromNBT(NBTTagCompound compound) {
		System.out.println("TEST READ");
		super.readFromNBT(compound);
	}

	@Override
	public NBTTagCompound writeToNBT(NBTTagCompound compound) {
		System.out.println("TEST WRITE");
		return super.writeToNBT(compound);
	}

	@Override
	public void readSpawnData(ByteBuf additionalData) {
		caster = world.getPlayerEntityByName(additionalData.toString(Charset.defaultCharset()));
	}

	@Override
	public void writeSpawnData(ByteBuf buffer) {
		buffer.writeBytes(caster.getDisplayNameString().getBytes());
	}
}
