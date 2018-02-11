package uk.co.wehavecookies56.kk.common.entity.mobs.multipart;

import net.minecraft.util.DamageSource;
import net.minecraft.world.World;

public interface IMultiPartEntity 
{
	World getWorld();
	
	boolean attackEntityFromPart(EntityPart dragonPart, DamageSource source, float damage);
}
