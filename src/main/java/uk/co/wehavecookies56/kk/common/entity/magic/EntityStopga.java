package uk.co.wehavecookies56.kk.common.entity.magic;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.world.World;
import uk.co.wehavecookies56.kk.common.network.packet.PacketDispatcher;
import uk.co.wehavecookies56.kk.common.network.packet.client.SpawnStopParticles;

import java.util.List;

public class EntityStopga extends Entity {


    EntityPlayer player;
    static final int TICKS = 200;
    static final double DISTANCE = 4.0D;

    public EntityStopga (World world) {
        super(world);
    }

    public EntityStopga (World world, EntityPlayer sender, double x, double y, double z) {
        super(world);
        this.posX = x;
        this.posY = y;
        this.posZ = z;
        this.player = sender;
    }

    @Override
    public void onUpdate () {
        if (player == null)
            return;
        int rotation = 0;
        if (!world.isRemote) PacketDispatcher.sendToAllAround(new SpawnStopParticles(this, 3), player, 64.0D);

        this.rotationYaw = (rotation + 1) % 360;
        if (ticksExisted > TICKS)
            setDead();

        if (ticksExisted < 10)
            player.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0D);
        else
            player.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.10000000149011612D);

        AxisAlignedBB aabb = player.getEntityBoundingBox().expand(DISTANCE, DISTANCE, DISTANCE);
        List list = this.world.getEntitiesWithinAABBExcludingEntity(player, aabb);
        if (!list.isEmpty()){

            for (int i = 0; i < list.size(); i++) {
                Entity e = (Entity) list.get(i);

                if (e instanceof EntityLiving) {
                    if (ticksExisted < TICKS) {
                        ((EntityLivingBase) e).motionX = 0;
                        ((EntityLivingBase) e).motionY = 0;
                        ((EntityLivingBase) e).motionZ = 0;
                    }
                }
                if(e instanceof EntityPlayerMP){
                    ((EntityPlayerMP)e).getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0D);

                }
            }
        }
        aabb.expand(-DISTANCE, -DISTANCE, -DISTANCE);

        super.onUpdate();
    }

    @Override
    protected void entityInit () {

    }

    @Override
    protected void readEntityFromNBT (NBTTagCompound tagCompund) {

    }

    @Override
    protected void writeEntityToNBT (NBTTagCompound tagCompound) {

    }

    @Override
    public AxisAlignedBB getEntityBoundingBox () {

        return new AxisAlignedBB(0D, 0D, 0D, 1D, 1D, 1D);
    }

}

