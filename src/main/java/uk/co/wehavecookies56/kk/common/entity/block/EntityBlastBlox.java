package uk.co.wehavecookies56.kk.common.entity.block;

import java.util.Random;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class EntityBlastBlox extends Entity {
	/** How long the fuse is */
	public int fuse;
	private EntityLivingBase tntPlacedBy;

	public EntityBlastBlox (World par1World) {
		super(par1World);
		this.preventEntitySpawning = true;
		this.fuse = 40;
		setSize(0.98F, 0.98F);
	}

	public EntityBlastBlox (World par1World, double par2, double par4, double par6, EntityLivingBase par8EntityLivingBase) {
		this(par1World);
		setPosition(par2, par4, par6);
		float f = (float) (Math.random() * Math.PI * 2.0D);
		this.motionX = -((float) Math.sin(f)) * 0.02F;
		this.motionY = 0.20000000298023224D;
		this.motionZ = -((float) Math.cos(f)) * 0.02F;
		this.fuse = 40;
		this.prevPosX = par2;
		this.prevPosY = par4;
		this.prevPosZ = par6;
		this.tntPlacedBy = par8EntityLivingBase;
	}

	@Override
	protected void entityInit () {}

	/**
	 * returns if this entity triggers Block.onEntityWalking on the blocks they
	 * walk on. used for spiders and wolves to prevent them from trampling crops
	 */
	@Override
	protected boolean canTriggerWalking () {
		return false;
	}

	/**
	 * Returns true if other Entities should be prevented from moving through
	 * this Entity.
	 */
	@Override
	public boolean canBeCollidedWith () {
		return !this.isDead;
	}

	/**
	 * Called to update the entity's position/logic.
	 */
	@Override
	public void onUpdate () {
		this.prevPosX = this.posX;
		this.prevPosY = this.posY;
		this.prevPosZ = this.posZ;
		this.motionY -= 0.03999999910593033D;
		moveEntity(this.motionX, this.motionY, this.motionZ);
		this.motionX *= 0.9800000190734863D;
		this.motionY *= 0.9800000190734863D;
		this.motionZ *= 0.9800000190734863D;

		if (this.onGround) {
			this.motionX *= 0.699999988079071D;
			this.motionZ *= 0.699999988079071D;
			this.motionY *= -0.5D;
		}

		if (this.fuse-- <= 0) {
			setDead();

			if (!this.worldObj.isRemote) explode();
		} else
			this.worldObj.spawnParticle(EnumParticleTypes.FLAME, this.posX, this.posY, this.posZ, randomDoubleWithRange(-0.05D, 0.05D), 0.1D, randomDoubleWithRange(-0.05D, 0.005D));
	}

	double randomDoubleWithRange (double min, double max) {
		Random r = new Random();
		return min + (max - min) * r.nextDouble();
	}

	private void explode () {
		float f = 4.0F;
		this.worldObj.createExplosion(this, this.posX, this.posY, this.posZ, f, true);
	}

	/**
	 * (abstract) Protected helper method to write subclass entity data to NBT.
	 */
	@Override
	protected void writeEntityToNBT (NBTTagCompound par1NBTTagCompound) {
		par1NBTTagCompound.setByte("Fuse", (byte) this.fuse);
	}

	/**
	 * (abstract) Protected helper method to read subclass entity data from NBT.
	 */
	@Override
	protected void readEntityFromNBT (NBTTagCompound par1NBTTagCompound) {
		this.fuse = par1NBTTagCompound.getByte("Fuse");
	}

	@SideOnly (Side.CLIENT)
	public float getShadowSize () {
		return 0.0F;
	}

	/**
	 * returns null or the entityliving it was placed or ignited by
	 */
	public EntityLivingBase getTntPlacedBy () {
		return this.tntPlacedBy;
	}
}