package wehavecookies56.kk.entities.magic;

import java.util.List;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.world.World;

public class EntityMagnet extends Entity
{

	EntityPlayer player;

	public EntityMagnet(World world){
		super(world);
	}

	public EntityMagnet(World world, EntityPlayer sender, double x, double y, double z) {
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

		double r = 1.2D;

		for(int a = 1; a <= 360; a+=7){
			double x = this.posX + (r * Math.cos(Math.toRadians(a)));
			double z = this.posZ + (r * Math.sin(Math.toRadians(a)));

			this.worldObj.spawnParticle(EnumParticleTypes.EXPLOSION_NORMAL, x, this.posY, z, 0.0D, 1.0D, 0.0D);
			this.worldObj.spawnParticle(EnumParticleTypes.EXPLOSION_NORMAL, x, this.posY, z, 0.0D, 1.0D, 0.0D);
		}

		this.rotationYaw = (rotation + 1) % 360;
		if(ticksExisted > 30){
			setDead();
		}

		if(ticksExisted < 10){
			player.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0D);

		}else{
			player.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.10000000149011612D);
		}

		double distance = 3.0D;
		AxisAlignedBB aabb = player.getEntityBoundingBox().expand(2, 2, 2);
		List list = this.worldObj.getEntitiesWithinAABBExcludingEntity(player, aabb);
		//TODO CHECK FOR ENTITIES AND DAMAGE THEM
		if(!list.isEmpty())
		{
			for(int i=0; i<list.size();i++)
			{
				Entity e = (Entity) list.get(i);
				e.attackEntityFrom(DamageSource.magic, 1.5F);
				if(e instanceof EntityLiving){
					double d = e.posX - posX;
				    double d1;
				    for(d1 = e.posZ - posZ; d * d + d1 * d1 < 0.0001D; d1 = (Math.random() - Math.random()) * 0.01D){
				        d = (Math.random() - Math.random()) * 0.01D;
				    }
					((EntityLiving) e).knockBack(e, 0, d, d1);
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
