package uk.co.wehavecookies56.kk.common.entity.projectiles.chakrams;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

public class EntityDelayedAction extends EntityChakram {
    EntityPlayer player;

    public EntityDelayedAction(World world) {
        super(world);
    }

    public EntityDelayedAction(World world, EntityLivingBase entity) {
        super(world, entity);
        this.player = (EntityPlayer) entity;
    }

    public EntityDelayedAction(World world, double x, double y, double z) {
        super(world, x, y, z);
    }
}
