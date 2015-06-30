package wehavecookies56.kk.entities.magic;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.projectile.EntitySnowball;
import net.minecraft.world.World;

public class EntityIce extends EntitySnowball
{
	public EntityIce(World worldIn)
    {
        super(worldIn);
        this.setSize(0.3125F, 0.3125F);
    }

}
