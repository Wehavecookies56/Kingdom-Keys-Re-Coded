package wehavecookies56.kk.entities.magic;

import java.util.List;

import net.minecraft.entity.Entity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;
import wehavecookies56.kk.network.packet.PacketDispatcher;
import wehavecookies56.kk.network.packet.client.SpawnFireParticles;

public class EntityFira extends Entity
{

	EntityPlayer player;

	public EntityFira(World world){
		super(world);
	}

	public EntityFira(World world, EntityPlayer sender, double x, double y, double z, int level) {
		super(world);
		this.posX = x;
		this.posY = y;
		this.posZ = z;
		this.player = sender;
	}

	@Override
	public void onUpdate() {
		if(player == null){
			return;
		}
		int rotation = 0;

		if(!worldObj.isRemote){
			PacketDispatcher.sendToAllAround(new SpawnFireParticles(this, 2), player, 64.0D);
		}

		this.rotationYaw = (rotation + 1) % 360;
		if(ticksExisted > 15){
			setDead();
		}

		if(ticksExisted < 10){
			player.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0D);

		}else{
			player.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.10000000149011612D);
		}

		//double distance = 3.0D;
		AxisAlignedBB aabb = player.getEntityBoundingBox().expand(2, 2, 2);
		List list = this.worldObj.getEntitiesWithinAABBExcludingEntity(player, aabb);
		//TODO CHECK FOR ENTITIES AND DAMAGE THEM
		if(!list.isEmpty())
		{
			for(int i=0; i<list.size();i++)
			{
				Entity e = (Entity) list.get(i);
				e.attackEntityFrom(DamageSource.magic, 3.0F);
				e.setFire(5);
			}
		}
		aabb.contract(2, 2, 2);

		super.onUpdate();
	}


	@Override
	protected void entityInit() {

	}

	@Override
	protected void readEntityFromNBT(NBTTagCompound tagCompund) {

	}

	@Override
	protected void writeEntityToNBT(NBTTagCompound tagCompound) {

	}

	@Override
	public AxisAlignedBB getEntityBoundingBox() {

		return new AxisAlignedBB(0D, 0D, 0D, 1D, 1D, 1D);
	}

}
