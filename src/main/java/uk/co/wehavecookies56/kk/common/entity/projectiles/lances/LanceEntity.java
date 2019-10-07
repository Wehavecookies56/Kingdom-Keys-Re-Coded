package uk.co.wehavecookies56.kk.common.entity.projectiles.lances;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

public class LanceEntity extends EntityLance {

    EntityPlayer player;

    public LanceEntity (World world) {
        super(world);
    }

    public LanceEntity (World world, EntityLivingBase entity) {
        super(world, entity);
        this.player = (EntityPlayer) entity;
    }

    public LanceEntity (World world, double x, double y, double z) {
        super(world, x, y, z);
    }
}
