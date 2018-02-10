package uk.co.wehavecookies56.kk.common.entity.mobs;

import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;
import uk.co.wehavecookies56.kk.common.core.helper.EntityHelper.MobType;
import uk.co.wehavecookies56.kk.common.entity.EntityFlyingHeart;

public class BaseEntityHeartless extends EntityMob{

    public BaseEntityHeartless(World worldIn) {
        super(worldIn);
    }

    @Override
    protected boolean isValidLightLevel() {
    	BlockPos pos = new BlockPos(posX,posY,posZ);
    	IBlockState state = world.getBlockState(pos);
        int l = state.getLightValue(world, pos);
    	return l <= 7;
    }

    @Override
    protected boolean canDespawn() {
        return true;
    }

    @Override
    public boolean isAIDisabled() {
        return false;
    }

    @Override
    public boolean getCanSpawnHere() {
        return true;
    }
    
    @Override
    public void onDeath(DamageSource cause){
    	super.onDeath(cause);
    	if(this instanceof IKHMob) {
    		if(((IKHMob)this).getType() == MobType.HEARTLESS_EMBLEM) {
		    	if(!world.isRemote) {
		    		EntityFlyingHeart heart = new EntityFlyingHeart(this.world, this.posX, this.posY-1, this.posZ);
		    		world.spawnEntity(heart);
		    	}
    		}
    	}
    	
        //heart.setThrowableHeading((double)1, (double)1, (double)1, 2, 1);

    	
    	//heart.setHeadingFromThrower(player, player.rotationPitch, player.rotationYaw, 0, 1, 0);
    	
    	/*float f = -MathHelper.sin(rotationYawIn * 0.017453292F) * MathHelper.cos(rotationPitchIn * 0.017453292F);
        float f1 = -MathHelper.sin((rotationPitchIn + pitchOffset) * 0.017453292F);
        float f2 = MathHelper.cos(rotationYawIn * 0.017453292F) * MathHelper.cos(rotationPitchIn * 0.017453292F);*/
        //heart.motionX += entityThrower.motionX;
        //heart.motionZ += entityThrower.motionZ;

       
    }
    
}
