package uk.co.wehavecookies56.kk.common.entity.mobs.ai;

import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.ai.EntityAITarget;
import net.minecraft.util.math.MathHelper;
import uk.co.wehavecookies56.kk.common.entity.magic.EntityBlizzard;

public class EntityAIBlueRhapsody extends EntityAITarget
{
	private final int MAX_DISTANCE_FOR_SPECIALATTACK = 256;
	private int ticksBeforeNextBlizzard, ticksBeforeNextMelee;
	
	public EntityAIBlueRhapsody(EntityCreature creature) 
	{
		super(creature, true);
		ticksBeforeNextBlizzard = 20;
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
	    	if(ticksBeforeNextBlizzard <= 0)
	    	{
	    		double d0 = this.taskOwner.getDistanceSqToEntity(this.taskOwner.getAttackTarget());
	    		float f = MathHelper.sqrt_float(MathHelper.sqrt_double(d0));
	    		double d1 = this.taskOwner.getAttackTarget().posX - this.taskOwner.posX;
	    		double d2 = this.taskOwner.getAttackTarget().getEntityBoundingBox().minY + (double)(this.taskOwner.getAttackTarget().height / 2.0F) - (this.taskOwner.posY + (double)(this.taskOwner.height / 2.0F));
	    		double d3 = this.taskOwner.getAttackTarget().posZ - this.taskOwner.posZ;

	    		EntityBlizzard esfb = new EntityBlizzard(this.taskOwner.worldObj, this.taskOwner);
	    		esfb.setThrowableHeading(d1, d2, d3, 1, 0);
	    		esfb.posY = this.taskOwner.posY + (double)(this.taskOwner.height / 2.0F) + 0.5D;
	    		this.taskOwner.worldObj.spawnEntityInWorld(esfb);
	    		ticksBeforeNextBlizzard = 30 + this.taskOwner.getRNG().nextInt(10);
	    	}
	    	else
	    	{
	    		ticksBeforeNextBlizzard--;
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
