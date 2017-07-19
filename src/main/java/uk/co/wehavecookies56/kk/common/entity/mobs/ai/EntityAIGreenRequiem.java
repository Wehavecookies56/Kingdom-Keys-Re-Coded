package uk.co.wehavecookies56.kk.common.entity.mobs.ai;

import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.ai.EntityAITarget;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.SoundEvents;
import net.minecraft.util.SoundCategory;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import uk.co.wehavecookies56.kk.common.core.helper.EntityHelper;
import uk.co.wehavecookies56.kk.common.core.helper.EntityHelper.MobType;
import uk.co.wehavecookies56.kk.common.entity.mobs.IKHMob;
import uk.co.wehavecookies56.kk.common.network.packet.PacketDispatcher;
import uk.co.wehavecookies56.kk.common.network.packet.client.SpawnCureParticles;

public class EntityAIGreenRequiem extends EntityAITarget {
	private final int MAX_DISTANCE_FOR_SPECIALATTACK = 256;
	private int ticksBeforeNextHeal, ticksBeforeNextMelee;
	
	public EntityAIGreenRequiem(EntityCreature creature) {
		super(creature, true);
		ticksBeforeNextHeal = 100;
		ticksBeforeNextMelee = 15;
	}

	@Override
	public boolean shouldContinueExecuting() {
    	if(this.taskOwner.getAttackTarget() != null && this.taskOwner.getDistanceSqToEntity(this.taskOwner.getAttackTarget()) < MAX_DISTANCE_FOR_SPECIALATTACK) {
    		/*if(this.taskOwner.getDistanceSqToEntity(this.taskOwner.getAttackTarget()) < 12)
    		{
    			EntityHelper.setAnimation(this.taskOwner, 1);
    		}*/
	    	if(ticksBeforeNextHeal <= 0) {
	    		for(EntityLivingBase elb : EntityHelper.getEntitiesNear(this.taskOwner, 70))
	    			if(elb instanceof IKHMob && (((IKHMob)elb).getType() == MobType.HEARTLESS_EMBLEM || ((IKHMob)elb).getType() == MobType.HEARTLESS_PUREBLOOD)){
	    				elb.setHealth(elb.getHealth() + 5);
                        this.taskOwner.world.playSound(null, this.taskOwner.posX, this.taskOwner.posY, this.taskOwner.posZ, SoundEvents.ENTITY_EXPERIENCE_ORB_PICKUP, SoundCategory.HOSTILE, 0.2F, 1.0F);
                        PacketDispatcher.sendToAllAround(new SpawnCureParticles(elb,1), new NetworkRegistry.TargetPoint(this.taskOwner.dimension, this.taskOwner.posX, this.taskOwner.posY, this.taskOwner.posZ, 20));
	    			}
	    		ticksBeforeNextHeal = 100 + this.taskOwner.getRNG().nextInt(10);
	    	}
	    	else {
	    		ticksBeforeNextHeal--;
	    	}
	    	
	    	return true;
    	}
    	return false;
    }

    @Override
    public void startExecuting() {

    }

    @Override
	public boolean shouldExecute() {
		return this.taskOwner.getAttackTarget() != null && this.taskOwner.getDistanceSqToEntity(this.taskOwner.getAttackTarget()) < 1024;
	}
}
