package uk.co.wehavecookies56.kk.common.entity.projectiles.chakrams;

import java.util.List;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.IThrowableEntity;
import uk.co.wehavecookies56.kk.common.KingdomKeys;
import uk.co.wehavecookies56.kk.common.capability.ModCapabilities;

/**
 * Created by NStel on 3/29/2017.
 */
public class EntitySizzlingEdge  extends EntityChakram {
    EntityPlayer player;

    public EntitySizzlingEdge (World world) {
        super(world);
    }

    public EntitySizzlingEdge (World world, EntityLivingBase entity) {
        super(world, entity);
        this.player = (EntityPlayer) entity;
    }

    public EntitySizzlingEdge (World world, double x, double y, double z) {
        super(world, x, y, z);
    }
}
