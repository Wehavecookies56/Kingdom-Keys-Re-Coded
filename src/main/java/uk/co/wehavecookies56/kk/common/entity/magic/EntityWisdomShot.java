package uk.co.wehavecookies56.kk.common.entity.magic;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;
import uk.co.wehavecookies56.kk.common.network.packet.PacketDispatcher;
import uk.co.wehavecookies56.kk.common.network.packet.client.SpawnWisdomShotParticles;

public class EntityWisdomShot extends EntityThrowable {
    public EntityPlayer shootingEntity;

    public EntityWisdomShot (World world) {
        super(world);
    }

    public EntityWisdomShot (World world, EntityLivingBase entity) {
        super(world, entity);
        shootingEntity = (EntityPlayer) entity;
    }

    public EntityWisdomShot (World world, double x, double y, double z) {
        super(world, x, y, z);
    }

    @Override
    protected float getGravityVelocity () {
        return 0.0F;
    }

    @Override
    public void onUpdate () {
        super.onUpdate();
        if (shootingEntity == null) return;
        int rotation = 0;
        if (!world.isRemote) PacketDispatcher.sendToAllAround(new SpawnWisdomShotParticles(this), shootingEntity, 64.0D);
        this.rotationYaw = (rotation + 1) % 360;
        if (ticksExisted > 60) setDead();
    }

    @Override
    protected void onImpact (RayTraceResult movingObject) {
        if (!this.world.isRemote) {
            boolean flag;
            float dmg = (DamageCalculation.getMagicDamage(shootingEntity,1))/5;
            if(dmg < 2)
                dmg = 2;
            if (movingObject.entityHit != null) {
                flag = movingObject.entityHit.attackEntityFrom(DamageSource.causePlayerDamage(shootingEntity), dmg);

                if (flag) {
                    applyEnchantments(this.shootingEntity, movingObject.entityHit);
                    if (movingObject.entityHit.isBurning())
                        movingObject.entityHit.extinguish();
                    else
                        movingObject.entityHit.attackEntityFrom(DamageSource.causePlayerDamage(shootingEntity), dmg);
                }
            }
            setDead();
        }
    }
}