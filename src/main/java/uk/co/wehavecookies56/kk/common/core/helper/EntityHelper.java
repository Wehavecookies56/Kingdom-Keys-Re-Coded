package uk.co.wehavecookies56.kk.common.core.helper;

import java.util.List;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.fml.common.registry.EntityRegistry;
import uk.co.wehavecookies56.kk.common.KingdomKeys;
import uk.co.wehavecookies56.kk.common.lib.Reference;

public class EntityHelper 
{

    public static final DataParameter<Integer> ANIMATION = EntityDataManager.<Integer>createKey(EntityMob.class, DataSerializers.VARINT);
    public static final DataParameter<Integer> STATE = EntityDataManager.<Integer>createKey(EntityMob.class, DataSerializers.VARINT);
    private static int entityID = 0;

    public static void setState(Entity e, int i) { e.getDataManager().set(STATE, i); }
    public static int getState(Entity e) { return e.getDataManager().get(STATE); }
    public static void setAnimation(Entity e, int i) { e.getDataManager().set(ANIMATION, i); }
    public static int getAnimation(Entity e) { return e.getDataManager().get(ANIMATION); }

    public static double percentage(double i, double j) {return i * (j / 100);}

    public static void registerEntity(String name, Class<? extends Entity> entity) {
        EntityRegistry.registerModEntity(new ResourceLocation(Reference.MODID, name), entity, name, entityID++, KingdomKeys.instance, 64, 3, true);
    }

    public static void registerEntity(String name, Class<? extends Entity> entity, int color1, int color2) {
        EntityRegistry.registerModEntity(new ResourceLocation(Reference.MODID, name), entity, name, entityID++, KingdomKeys.instance, 64, 3, true, color1, color2);
    }

    public static List<EntityLivingBase> getEntitiesNear(Entity e, double radius)
    {
        AxisAlignedBB aabb = new AxisAlignedBB(e.posX, e.posY, e.posZ, e.posX + 1, e.posY + 1, e.posZ + 1).grow(radius, radius, radius);
        List<EntityLivingBase> list = e.world.getEntitiesWithinAABB(EntityLivingBase.class, aabb);
        list.remove(e);
        return list;
    }

    public enum Dir {SOUTH, SOUTH_EAST, EAST, NORTH, NORTH_EAST, NORTH_WEST, WEST, SOUTH_WEST;}

    public enum MobType {HEARTLESS_PUREBLOOD, HEARTLESS_EMBLEM, NOBODY, NPC;}
    
    public static Dir get8Directions(Entity e)
    {
        switch(MathHelper.floor(e.rotationYaw * 8.0F / 360.0F + 0.5D) & 7)
        {case 0: return Dir.SOUTH; case 1: return Dir.SOUTH_WEST; case 2: return Dir.WEST; case 3: return Dir.NORTH_WEST; case 4: return Dir.NORTH; case 5: return Dir.NORTH_EAST; case 6: return Dir.EAST; case 7: return Dir.SOUTH_EAST;}
        return null;
    }

}
