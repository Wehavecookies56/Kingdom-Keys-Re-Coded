package uk.co.wehavecookies56.kk.common.entity.block;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.MoverType;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import uk.co.wehavecookies56.kk.common.util.Utils;

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
		this.fuse = 60;
		this.prevPosX = par2;
		this.prevPosY = par4;
		this.prevPosZ = par6;
		this.tntPlacedBy = par8EntityLivingBase;
	}

	@Override
	protected void entityInit () {}

	@Override
	protected boolean canTriggerWalking () {
		return false;
	}

	@Override
	public boolean canBeCollidedWith () {
		return !this.isDead;
	}

	@Override
	public void onUpdate () {
		this.prevPosX = this.posX;
		this.prevPosY = this.posY;
		this.prevPosZ = this.posZ;
		this.motionY -= 0.03999999910593033D;
		move(MoverType.SELF, this.motionX, this.motionY, this.motionZ);
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

			if (!this.world.isRemote) explode();
		} else
			this.world.spawnParticle(EnumParticleTypes.FLAME, this.posX, this.posY, this.posZ, Utils.randomWithRange(-0.05D, 0.05D), 0.1D, Utils.randomWithRange(-0.05D, 0.005D));
	}

	private void explode () {
		float f = 4.0F;
		this.world.createExplosion(this, this.posX, this.posY, this.posZ, f, true);
	}

	@Override
	protected void writeEntityToNBT (NBTTagCompound par1NBTTagCompound) {
		par1NBTTagCompound.setByte("Fuse", (byte) this.fuse);
	}

	@Override
	protected void readEntityFromNBT (NBTTagCompound par1NBTTagCompound) {
		this.fuse = par1NBTTagCompound.getByte("Fuse");
	}

	@SideOnly (Side.CLIENT)
	public float getShadowSize () {
		return 0.0F;
	}

	public EntityLivingBase getTntPlacedBy () {
		return this.tntPlacedBy;
	}
}