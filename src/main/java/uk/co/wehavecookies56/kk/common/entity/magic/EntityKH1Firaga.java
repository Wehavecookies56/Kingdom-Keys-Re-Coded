package uk.co.wehavecookies56.kk.common.entity.magic;

import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.init.Blocks;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;
import uk.co.wehavecookies56.kk.client.core.handler.InputHandler;
import uk.co.wehavecookies56.kk.common.entity.LockOn;
import uk.co.wehavecookies56.kk.common.network.packet.PacketDispatcher;
import uk.co.wehavecookies56.kk.common.network.packet.client.SpawnKH1FireParticles;

public class EntityKH1Firaga extends EntityThrowable {
    public EntityPlayer shootingEntity;

    public EntityKH1Firaga (World world) {
        super(world);
    }

    public EntityKH1Firaga (World world, EntityLivingBase entity) {
        super(world, entity);
        shootingEntity = (EntityPlayer) entity;

    }

    public EntityKH1Firaga (World world, double x, double y, double z) {
        super(world, x, y, z);
    }

    @Override
    protected float getGravityVelocity () {
        return 0.0F;
    }

    @Override
    public void onUpdate () {
        if (shootingEntity == null) return;
        int rotation = 0;
        if (!world.isRemote)
            PacketDispatcher.sendToAllAround(new SpawnKH1FireParticles(this, 1), shootingEntity, 64.0D);
        if(LockOn.target != null) {
            EntityLiving target = (EntityLiving)InputHandler.lockOn;
            shoot(target.posX - this.posX, target.posY - this.posY + target.height, target.posZ - this.posZ, 1.5f, 0);
        }
        this.world.spawnParticle(EnumParticleTypes.FLAME, this.posX, this.posY, this.posZ, 0.0D, 0.0D, 0.0D);
        this.rotationYaw = (rotation + 1) % 360;
        if (ticksExisted > 60) setDead();
        super.onUpdate();
    }

    @Override
    protected void onImpact (RayTraceResult movingObject) {
        if (!this.world.isRemote) {
            if (movingObject.entityHit != null) {
                applyEnchantments(this.shootingEntity, movingObject.entityHit);
                if (!movingObject.entityHit.isImmuneToFire()) movingObject.entityHit.setFire(5);
                if (shootingEntity instanceof EntityPlayer)
                    movingObject.entityHit.attackEntityFrom(DamageSource.causePlayerDamage((EntityPlayer) shootingEntity), DamageCalculation.getMagicDamage((EntityPlayer) shootingEntity, 3)*DamageCalculation.fireMultiplier);
                else
                    movingObject.entityHit.attackEntityFrom(DamageSource.causeMobDamage(shootingEntity), 5);
            } else {
                if (this.shootingEntity != null)
                if (this.world.getGameRules().getBoolean("mobGriefing")) {
                    BlockPos blockpos = movingObject.getBlockPos().offset(movingObject.sideHit);
                    if (this.world.isAirBlock(blockpos))
                        this.world.setBlockState(blockpos, Blocks.FIRE.getDefaultState());
                }
            }
            setDead();
        }
    }
}
