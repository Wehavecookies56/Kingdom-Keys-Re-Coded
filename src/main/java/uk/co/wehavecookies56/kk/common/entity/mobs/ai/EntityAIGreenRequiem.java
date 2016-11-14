package uk.co.wehavecookies56.kk.common.entity.mobs.ai;

import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.ai.EntityAITarget;
import net.minecraft.entity.player.EntityPlayer;
import uk.co.wehavecookies56.kk.common.core.helper.EntityHelper;
import uk.co.wehavecookies56.kk.common.core.helper.EntityHelper.MobType;
import uk.co.wehavecookies56.kk.common.entity.mobs.IKHMob;
import uk.co.wehavecookies56.kk.common.network.packet.PacketDispatcher;
import uk.co.wehavecookies56.kk.common.network.packet.client.SpawnCureParticles;

public class EntityAIGreenRequiem extends EntityAITarget
{
	private final int MAX_DISTANCE_FOR_SPECIALATTACK = 256;
	private int ticksBeforeNextHeal, ticksBeforeNextMelee;
	
	public EntityAIGreenRequiem(EntityCreature creature) 
	{
		super(creature, true);
		ticksBeforeNextHeal = 20;
		ticksBeforeNextMelee = 15;
	}
	
    public boolean continueExecuting()
    { 	
    	if(this.taskOwner.getAttackTarget() != null && this.taskOwner.getDistanceSqToEntity(this.taskOwner.getAttackTarget()) < MAX_DISTANCE_FOR_SPECIALATTACK)
    	{ 
    		/*if(this.taskOwner.getDistanceSqToEntity(this.taskOwner.getAttackTarget()) < 12)
    		{
    			EntityHelper.setAnimation(this.taskOwner, 1);
    		}*/
	    	if(ticksBeforeNextHeal <= 0)
	    	{
	    		for(EntityLivingBase elb : EntityHelper.getEntitiesNear(this.taskOwner, 70))
	    			if(elb instanceof IKHMob && (((IKHMob)elb).getType() == MobType.HEARTLESS_EMBLEM || ((IKHMob)elb).getType() == MobType.HEARTLESS_PUREBLOOD)){
	    				elb.setHealth(elb.getHealth() + 5);
	    				PacketDispatcher.sendToAllAround(new SpawnCureParticles(elb,1), (EntityPlayer)this.taskOwner.getAttackTarget(), 20D);
	    				System.out.println("Healed: "+elb);
	    			}
	    		ticksBeforeNextHeal = 30 + this.taskOwner.getRNG().nextInt(10);
	    	}
	    	else
	    	{
	    		ticksBeforeNextHeal--;
	    	}
	    	
	    	return true;
    	}
    	return false;
    }
	
    public void startExecuting()
    {

    }

	public boolean shouldExecute() 
	{
		return this.taskOwner.getAttackTarget() != null && this.taskOwner.getDistanceSqToEntity(this.taskOwner.getAttackTarget()) < 1024;
	}
}
