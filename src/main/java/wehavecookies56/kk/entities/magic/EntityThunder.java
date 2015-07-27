package wehavecookies56.kk.entities.magic;

import java.util.List;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.world.World;

public class EntityThunder extends Entity
{

	EntityPlayer player;
	public static boolean summonLightning = false;

	public EntityThunder(World world){
		super(world);
	}

	public EntityThunder(World world, EntityPlayer sender, double x, double y, double z) {
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

		double r = 1.5D;

		for(int a = 1; a <= 360; a+=7){
			double x = this.posX + (r * Math.cos(Math.toRadians(a)));
			double z = this.posZ + (r * Math.sin(Math.toRadians(a)));

			this.worldObj.spawnParticle(EnumParticleTypes.REDSTONE, x, this.posY, z, 0.0D, 10.5D, 0.0D);
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
		if(ticksExisted > 30)
		{
			summonLightning = false;
		}
		super.onUpdate();
	}


	@Override
	protected void entityInit()
	{
		double distance = 3.0D;
		AxisAlignedBB aabb = player.getEntityBoundingBox().expand(3, 3, 3);
		List list = this.worldObj.getEntitiesWithinAABBExcludingEntity(player, aabb);
		//TODO CHECK FOR ENTITIES AND DAMAGE THEM
		if(!list.isEmpty())
		{
			for(int i=0; i<list.size();i++)
			{
				Entity e = (Entity) list.get(i);
				if(e instanceof EntityLiving){
					summonLightning = true;
					//Something so the player doesen't get damage
					this.worldObj.spawnEntityInWorld((new EntityLightningBolt(this.worldObj, e.posX, e.posY, e.posZ)));
				}
			}
		}
		aabb.contract(3, 3, 3);
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
