package uk.co.wehavecookies56.kk.common.entity.projectiles;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import uk.co.wehavecookies56.kk.common.entity.projectiles.chakrams.EntityChakram;

public class ChakramEntity extends EntityChakram {

    EntityPlayer player;

    public ChakramEntity (World world) {
        super(world);
    }

    public ChakramEntity (World world, EntityLivingBase entity) {
        super(world, entity);
        this.player = (EntityPlayer) entity;
    }

    public ChakramEntity (World world, double x, double y, double z) {
        super(world, x, y, z);
    }
}
