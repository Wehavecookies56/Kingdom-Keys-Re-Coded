package wehavecookies56.kk.entities.magic;

import java.util.List;

import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.effect.EntityWeatherEffect;
import net.minecraft.init.Blocks;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.BlockPos;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.World;

public class EntityThunder extends EntityWeatherEffect
{
   
	//	super(worldIn, x, y, z);
    	 /** Declares which state the lightning bolt is in. Whether it's in the air, hit the ground, etc. */
        private int lightningState;
        /** A random long that is used to change the vertex of the lightning rendered in RenderLightningBolt */
        public long boltVertex;
        /** Determines the time before the EntityThunder is destroyed. It is a random integer decremented over time. */
        private int boltLivingTime;
        private static final String __OBFID = "CL_00001666";

        public EntityThunder(World worldIn, double x, double y, double z)
        {
            super(worldIn);
            this.setLocationAndAngles(x, y, z, 0.0F, 0.0F);
            this.lightningState = 2;
            this.boltVertex = this.rand.nextLong();
            this.boltLivingTime = this.rand.nextInt(3) + 1;
        }

        /**
         * Called to update the entity's position/logic.
         */
        public void onUpdate()
        {
            super.onUpdate();

            if (this.lightningState == 2)
            {
                this.worldObj.playSoundEffect(this.posX, this.posY, this.posZ, "ambient.weather.thunder", 10000.0F, 0.8F + this.rand.nextFloat() * 0.2F);
                this.worldObj.playSoundEffect(this.posX, this.posY, this.posZ, "random.explode", 2.0F, 0.5F + this.rand.nextFloat() * 0.2F);
            }

            --this.lightningState;

            if (this.lightningState < 0)
            {
                if (this.boltLivingTime == 0)
                {
                    this.setDead();
                }
                else if (this.lightningState < -this.rand.nextInt(10))
                {
                    --this.boltLivingTime;
                    this.lightningState = 1;
                    this.boltVertex = this.rand.nextLong();
                    BlockPos blockpos = new BlockPos(this);
                }
            }

            if (this.lightningState >= 0)
            {
                if (this.worldObj.isRemote)
                {
                    this.worldObj.setLastLightningBolt(2);
                }
                else
                {
                    double d0 = 3.0D;
                    List list = this.worldObj.getEntitiesWithinAABBExcludingEntity(this, new AxisAlignedBB(this.posX - d0, this.posY - d0, this.posZ - d0, this.posX + d0, this.posY + 6.0D + d0, this.posZ + d0));
                }
            }
        }

	@Override
	protected void entityInit() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void readEntityFromNBT(NBTTagCompound tagCompund) {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void writeEntityToNBT(NBTTagCompound tagCompound) {
		// TODO Auto-generated method stub
		
	}	
}
