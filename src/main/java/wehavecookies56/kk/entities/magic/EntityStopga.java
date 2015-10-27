package wehavecookies56.kk.entities.magic;

import java.util.List;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.world.World;
import wehavecookies56.kk.network.packet.PacketDispatcher;
import wehavecookies56.kk.network.packet.client.SpawnStopParticles;

public class EntityStopga extends Entity
{

	EntityPlayer player;

	public EntityStopga(World world){
		super(world);
	}

	public EntityStopga(World world, EntityPlayer sender, double x, double y, double z) {
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
			PacketDispatcher.sendToAllAround(new SpawnStopParticles(this,3), player, 64.0D);
		}
		double r = 3.0D;

		for(int a = 1; a <= 360; a+=15){
			double x = this.posX + (r * Math.cos(Math.toRadians(a)));
			double z = this.posZ + (r * Math.sin(Math.toRadians(a)));

			this.worldObj.spawnParticle(EnumParticleTypes.ENCHANTMENT_TABLE, x, this.posY+2, z, 0.0D, 0.5D, 0.0D);
			//this.worldObj.spawnParticle(EnumParticleTypes.EXPLOSION_NORMAL, x, this.posY, z, 0.0D, 1.0D, 0.0D);
		}

		this.rotationYaw = (rotation + 1) % 360;
		if(ticksExisted > 200){
			setDead();
		}

		if(ticksExisted < 10){
			player.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0D);

		}else{
			player.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.10000000149011612D);
		}

		double distance = 5.0D;
		AxisAlignedBB aabb = player.getEntityBoundingBox().expand(2, 2, 2);
		List list = this.worldObj.getEntitiesWithinAABBExcludingEntity(player, aabb);
		//TODO CHECK FOR ENTITIES AND DAMAGE THEM
		if(!list.isEmpty())
		{
			for(int i=0; i<list.size();i++)
			{
				Entity e = (Entity) list.get(i);
				if(e instanceof EntityLiving){
					if(ticksExisted < 200){
						((EntityLivingBase) e).setVelocity(0, 0, 0);
					}
					System.out.println(e);
				}
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
