package uk.co.wehavecookies56.kk.common.entity.projectiles;

import javax.annotation.Nonnull;

import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.init.Blocks;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;
import uk.co.wehavecookies56.kk.common.entity.magic.DamageCalculation;

public class EntityRock extends EntityThrowable {
	public final static int MAX_TICKS = 60;

    public EntityLivingBase target;
    public EntityPlayer owner;
    
    public EntityRock (World world) {
        super(world);
    }

    public EntityRock (World world, EntityLivingBase entity) {
        super(world, entity);
        target = entity;
    }

    public EntityRock (World world, EntityPlayer owner, EntityLivingBase entity, double x, double y, double z) {
        super(world, x, y, z);
        target = entity;
        this.owner = owner;
    }

    @Override
    protected float getGravityVelocity () {
        return 0.0F;
    }

    @Override
    public void onUpdate () {
        super.onUpdate();
        if (target == null) { 
        	//this.setDead();
        	return;
        }
        
        target.attackEntityFrom(DamageSource.causePlayerDamage(owner), DamageCalculation.getMagicDamage(owner, 1));
        target.motionY+=0.5;

        /*if (shootingEntity instanceof EntityPlayer) {
            if (!world.isRemote)
                PacketDispatcher.sendToAllAround(new SpawnBlizzardParticles(this, 1), (EntityPlayer) shootingEntity, 64.0D);
        }else{
            if (!world.isRemote)
                PacketDispatcher.sendToAllAround(new SpawnBlizzardParticles(this,1), dimension, this.posX, this.posY, this.posZ, 64D);
        }*/
        
        //System.out.println(world.isRemote);
       /* if(!world.isRemote) {
        	if (this.world.getBlockState(this.getPosition()).getBlock() == Blocks.WATER) 
				this.world.setBlockState(this.getPosition(), Blocks.ICE.getDefaultState());
			else if (this.world.getBlockState(this.getPosition()).getBlock() == Blocks.FIRE)
				this.world.setBlockState(this.getPosition(), Blocks.AIR.getDefaultState());
			else if (this.world.getBlockState(this.getPosition()).getBlock() == Blocks.LAVA)
				this.world.setBlockState(this.getPosition(), Blocks.OBSIDIAN.getDefaultState());
        }*/
        if(this.ticksExisted >= MAX_TICKS) {
			this.setDead();
		}
		
    }

    @Override
    protected void onImpact (@Nonnull RayTraceResult movingObject) {
        if (!this.world.isRemote) {
            if (movingObject.entityHit != null) {
                if (movingObject.entityHit.attackEntityFrom(DamageSource.causeThrownDamage(this, getThrower()), 8)) {
                    applyEnchantments(this.target, movingObject.entityHit);
                    if (movingObject.entityHit.isBurning())
                        movingObject.entityHit.extinguish();
                    else
                        if (target instanceof EntityPlayer)
                            movingObject.entityHit.attackEntityFrom(DamageSource.causePlayerDamage((EntityPlayer) target), DamageCalculation.getMagicDamage((EntityPlayer) target, 1)*DamageCalculation.blizzardMultiplier);
                        else
                            movingObject.entityHit.attackEntityFrom(DamageSource.causeMobDamage(target), 5);
                }
            } else {
                if (this.target != null) {
                    BlockPos blockpos = movingObject.getBlockPos().offset(movingObject.sideHit);
                    if (this.world.getBlockState(blockpos).getBlock() == Blocks.WATER)
                        this.world.setBlockState(blockpos, Blocks.ICE.getDefaultState());
                    else if (this.world.getBlockState(blockpos).getBlock() == Blocks.FIRE)
                        this.world.setBlockState(blockpos, Blocks.AIR.getDefaultState());
                    else if (this.world.getBlockState(blockpos).getBlock() == Blocks.LAVA) this.world.setBlockState(blockpos, Blocks.OBSIDIAN.getDefaultState());
                }
            }
            setDead();
        }
    }
}