package uk.co.wehavecookies56.kk.common.entity.projectiles.chakrams;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

public class EntityDiveBombers extends EntityChakram {
    EntityPlayer player;

    public EntityDiveBombers(World world) {
        super(world);
    }

    public EntityDiveBombers(World world, EntityLivingBase entity) {
        super(world, entity);
        this.player = (EntityPlayer) entity;
    }

    public EntityDiveBombers(World world, double x, double y, double z) {
        super(world, x, y, z);
    }
}
