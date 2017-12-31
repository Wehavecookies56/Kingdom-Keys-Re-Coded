package uk.co.wehavecookies56.kk.common.entity.mobs;

import net.minecraft.entity.passive.IAnimals;
import uk.co.wehavecookies56.kk.common.core.helper.EntityHelper.MobType;

public interface IKHMob extends IAnimals {
    public MobType getType();
}
