package uk.co.wehavecookies56.kk.common.entity.mobs;

import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class BaseEntityHeartless extends EntityMob{

    public BaseEntityHeartless(World worldIn) {
        super(worldIn);
    }

    @Override
    protected boolean isValidLightLevel() {
    	BlockPos pos = new BlockPos(posX,posY,posZ);
    	IBlockState state = world.getBlockState(pos);
        int l = state.getLightValue(world, pos);
    	return l <= this.rand.nextInt(8);
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
}
