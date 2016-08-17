package uk.co.wehavecookies56.kk.common.entity.mobs.ai;

import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.ai.EntityAITarget;
import net.minecraft.entity.projectile.EntitySmallFireball;
import net.minecraft.util.math.MathHelper;

public class EntityAIRedNocturne extends EntityAITarget
{
	private final int MAX_DISTANCE_FOR_FIREBALL = 256;
	private int ticksBeforeNextFlame, ticksBeforeNextMelee;
	
	public EntityAIRedNocturne(EntityCreature creature) 
	{
		super(creature, true);
		ticksBeforeNextFlame = 20;
		ticksBeforeNextMelee = 15;
	}
	
    public boolean continueExecuting()
    { 	
    	if(this.taskOwner.getAttackTarget() != null && this.taskOwner.getDistanceSqToEntity(this.taskOwner.getAttackTarget()) < MAX_DISTANCE_FOR_FIREBALL)
    	{ 
    		/*if(this.taskOwner.getDistanceSqToEntity(this.taskOwner.getAttackTarget()) < 12)
    		{
    			EntityHelper.setAnimation(this.taskOwner, 1);
    		}*/
	    	if(ticksBeforeNextFlame <= 0)
	    	{
	    		double d0 = this.taskOwner.getDistanceSqToEntity(this.taskOwner.getAttackTarget());
	    		float f = MathHelper.sqrt_float(MathHelper.sqrt_double(d0));
	    		double d1 = this.taskOwner.getAttackTarget().posX - this.taskOwner.posX;
	    		double d2 = this.taskOwner.getAttackTarget().getEntityBoundingBox().minY + (double)(this.taskOwner.getAttackTarget().height / 2.0F) - (this.taskOwner.posY + (double)(this.taskOwner.height / 2.0F));
	    		double d3 = this.taskOwner.getAttackTarget().posZ - this.taskOwner.posZ;
	    		System.out.println(d2);
	    		EntitySmallFireball esfb = new EntitySmallFireball(this.taskOwner.worldObj, this.taskOwner, d1 + this.taskOwner.getRNG().nextGaussian(), d2, d3 + this.taskOwner.getRNG().nextGaussian());
	    		esfb.posY = this.taskOwner.posY + (double)(this.taskOwner.height / 2.0F) + 0.5D;
	    		this.taskOwner.worldObj.spawnEntityInWorld(esfb);
	    		ticksBeforeNextFlame = 30 + this.taskOwner.getRNG().nextInt(10);
	    	}
	    	else
	    	{
	    		ticksBeforeNextFlame--;
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
