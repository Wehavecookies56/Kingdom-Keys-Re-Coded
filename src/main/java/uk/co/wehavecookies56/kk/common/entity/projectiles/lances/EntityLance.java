package uk.co.wehavecookies56.kk.common.entity.projectiles.lances;

import java.util.List;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.IThrowableEntity;
import uk.co.wehavecookies56.kk.common.KingdomKeys;
import uk.co.wehavecookies56.kk.common.capability.ModCapabilities;

public class EntityLance extends EntityThrowable {//implements IThrowableEntity {
    EntityPlayer player;

    public EntityLance (World world) {
        super(world);
    }

    public EntityLance (World world, EntityLivingBase entity) {
        super(world, entity);
        this.player = (EntityPlayer) entity;
    }

    public EntityLance (World world, double x, double y, double z) {
        super(world, x, y, z);
    }

    @Override
    protected float getGravityVelocity () {
        return 0.0F;
    }

    @Override
    public void onUpdate ()
    {
        int rotation = 0;
        //KingdomKeys.proxy.spawnTestParticle(world, posX + world.rand.nextDouble() * width * 2.0F - width, posY + world.rand.nextDouble() * height, posZ + world.rand.nextDouble() * width * 2.0F - width, world.rand.nextGaussian() * 0.02D, world.rand.nextGaussian() * 0.02D, world.rand.nextGaussian() * 0.02D, 0.2F);
        this.rotationYaw = (rotation + 1) % 360;

        /*if (ticksExisted > 15) {
            setReturn();
        }*/

        if (ticksExisted > 60) 
        	setDead();
        if (this.getThrower() == null)
        	setDead();

        super.onUpdate();
    }

    public void setAim(Entity shooter, float velocity, float inaccuracy){
        float f = -MathHelper.sin(shooter.rotationYaw * 0.017453292F) * MathHelper.cos(shooter.rotationPitch * 0.017453292F);
        float f1 = -MathHelper.sin(shooter.rotationPitch * 0.017453292F);
        float f2 = MathHelper.cos(shooter.rotationYaw * 0.017453292F) * MathHelper.cos(shooter.rotationPitch * 0.017453292F);
        this.setThrowableHeading((double)f, (double)f1, (double)f2, velocity, inaccuracy);
        this.motionX += shooter.motionX;
        this.motionZ += shooter.motionZ;

        if (!shooter.onGround)
        {
            this.motionY += shooter.motionY;
        }
    }

    @Override
    protected void onImpact (RayTraceResult mop) {
        if(mop.entityHit == null){
            
        }else{
            if (mop.entityHit == this.getThrower()) {
                this.setDead();
                return;
            }
            
            float shotDamage = player.getCapability(ModCapabilities.PLAYER_STATS, null).getStrength() * 0.8 < 8 ? 8 : (float) ((player.getCapability(ModCapabilities.PLAYER_STATS, null).getStrength() * 0.8));
          
            mop.entityHit.attackEntityFrom(DamageSource.causePlayerDamage((EntityPlayer) getThrower()), shotDamage);
        }

        this.world.spawnParticle(EnumParticleTypes.FLAME, this.posX, this.posY, this.posZ, 0.0D, 0.0D, 0.0D);
    }

   /* @Override
    public void setThrower (Entity entity) {

    }*/

}
