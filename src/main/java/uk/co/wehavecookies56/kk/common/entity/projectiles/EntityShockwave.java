package uk.co.wehavecookies56.kk.common.entity.projectiles;

import java.util.List;

import javax.annotation.Nonnull;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.world.World;
import uk.co.wehavecookies56.kk.common.entity.magic.DamageCalculation;
import uk.co.wehavecookies56.kk.common.network.packet.PacketDispatcher;
import uk.co.wehavecookies56.kk.common.network.packet.client.SpawnAeroParticles;
import uk.co.wehavecookies56.kk.common.network.packet.client.SpawnShockwaveParticles;

public class EntityShockwave extends Entity {

    EntityPlayer player;

    public EntityShockwave (World world) {
        super(world);
    }

    public EntityShockwave (World world, EntityPlayer sender, double x, double y, double z) {
        super(world);
        this.posX = x;
        this.posY = y;
        this.posZ = z;
        this.player = sender;
    }

    @Override
    public void onUpdate () {
        if (player == null) return;
        int rotation = 0;

        if (!world.isRemote)
        	PacketDispatcher.sendToAllAround(new SpawnShockwaveParticles(this), player, 64.0D);

        this.rotationYaw = (rotation + 1) % 360;
        if (ticksExisted > 30) setDead();

        if (ticksExisted < 30)
            player.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0D);
        else
            player.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.10000000149011612D);

        byte radius = 2; 
        AxisAlignedBB originalAABB = player.getEntityBoundingBox();
        AxisAlignedBB aabb = originalAABB.expand(radius, radius, radius).expand(-radius, -radius, -radius);
        List list = this.world.getEntitiesWithinAABBExcludingEntity(player, aabb);
        if (!list.isEmpty())
        	for (int i = 0; i < list.size(); i++) {
            Entity e = (Entity) list.get(i);
            if (e instanceof EntityLivingBase) {
            	//System.out.println(e);
            	if(player.getHeldItemMainhand() != null)
            		e.attackEntityFrom(DamageSource.causePlayerDamage(player), DamageCalculation.getOrgStrengthDamage(player,player.getHeldItemMainhand())/2);//*DamageCalculation.aeroMultiplier);
                double d = e.posX - posX;
                double d1;
                for (d1 = e.posZ - posZ; d * d + d1 * d1 < 0.0001D; d1 = (Math.random() - Math.random()) * 0.01D)
                    d = (Math.random() - Math.random()) * 0.01D;
                ((EntityLivingBase) e).knockBack(e, 2, -d, -d1);
                e.motionY*=1.2;
            }
        }

        super.onUpdate();
    }

    @Override
    protected void entityInit () {

    }

    @Override
    protected void readEntityFromNBT (@Nonnull NBTTagCompound tagCompund) {

    }

    @Override
    protected void writeEntityToNBT (@Nonnull NBTTagCompound tagCompound) {

    }

    @Override
    @Nonnull
    public AxisAlignedBB getEntityBoundingBox () {
        return new AxisAlignedBB(0D, 0D, 0D, 1D, 1D, 1D);
    }

}
