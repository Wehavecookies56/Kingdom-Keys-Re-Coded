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

public class EntityFire2 extends Entity
{

	EntityPlayer caster;

	public EntityFire2(World world){
		super(world);
	}

	public EntityFire2(World world, EntityPlayer sender, double x, double y, double z) {
		super(world);
		this.posX = x;
		this.posY = y;
		this.posZ = z;
		this.caster = sender;
	}
	
	@Override
	public void onUpdate() {
		if(caster == null){
			return;
		}
		int rotation = 0;

		double r = 1D;

		for(int a = 1; a <= 360; a+=7){
			double x = this.posX + (r * Math.cos(Math.toRadians(a)));
			double z = this.posZ + (r * Math.sin(Math.toRadians(a)));

			this.worldObj.spawnParticle(EnumParticleTypes.FLAME, x, this.posY + 1.25D, z, 0.0D, 0.0D, 0.0D);
			this.worldObj.spawnParticle(EnumParticleTypes.FLAME, x, this.posY + 1.05D, z, 0.0D, 0.0D, 0.0D);
		}

		this.rotationYaw = (rotation + 1) % 360;
		if(ticksExisted > 20){
			setDead();
		}

		if(!isDead){
			caster.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0D);
		}else{
			caster.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.10000000149011612D);
		}

		double distance = 3.0D;
		AxisAlignedBB aabb = caster.getEntityBoundingBox().expand(1, 1, 1);
		List list = this.worldObj.getEntitiesWithinAABBExcludingEntity(caster, aabb);
		//TODO CHECK FOR ENTITIES AND DAMAGE THEM
		if(!list.isEmpty())
		{
			for(int i=0; i<list.size();i++)
			{
				Entity e = (Entity) list.get(i);
				e.attackEntityFrom(DamageSource.magic, 3.0F);
				e.setFire(5);
				//((EntityLivingBase) e).knockBack(e, 3, 1, 1);
			}
		}
		aabb.contract(1, 1, 1);

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
