package wehavecookies56.kk.entities.magic;

import java.util.List;

import net.minecraft.entity.Entity;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.world.World;

public class EntityFire2 extends Entity
{

	public EntityFire2(World world) {
		super(world);
	}

	public EntityFire2(World world, double x, double y, double z) {
		super(world);
		this.posX = x;
		this.posY = y;
		this.posZ = z;
	}

	@Override
	public void onUpdate() {
		int rotation = 0;

		double r = 1D;

		for(int a = 1; a <= 360; a+=7){
			double x = this.posX + (r * Math.cos(Math.toRadians(a)));
			double z = this.posZ + (r * Math.sin(Math.toRadians(a)));

			this.worldObj.spawnParticle(EnumParticleTypes.FLAME, x, this.posY + 1.25D, z, 0.0D, 0.0D, 0.0D);
			this.worldObj.spawnParticle(EnumParticleTypes.FLAME, x, this.posY + 1.05D, z, 0.0D, 0.0D, 0.0D);
		}

		this.rotationYaw = (rotation + 1) % 360;
		if(ticksExisted > 10){
			setDead();
		}

		List list = this.worldObj.getEntitiesWithinAABBExcludingEntity(this, this.getEntityBoundingBox());
		//TODO CHECK FOR ENTITIES AND DAMAGE THEM
		if(!list.isEmpty()){
			for(int i = 0; i < list.size(); i++){
				Entity e = (Entity) list.get(i);
			}
		}

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
