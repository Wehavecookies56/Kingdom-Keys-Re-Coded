package uk.co.wehavecookies56.kk.common.entity.mobs.ai;

import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.ai.EntityAITarget;
import net.minecraft.init.SoundEvents;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.MathHelper;
import uk.co.wehavecookies56.kk.common.entity.magic.EntityThunder;

public class EntityAIYellowOpera extends EntityAITarget {
	private final int MAX_DISTANCE = 100;
	private int ticksBeforeNextFlame, ticksBeforeNextMelee;
	
	public EntityAIYellowOpera(EntityCreature creature) {
		super(creature, true);
		ticksBeforeNextFlame = 40;
		ticksBeforeNextMelee = 15;
	}

    @Override
    public boolean shouldContinueExecuting() {
    	if(this.taskOwner.getAttackTarget() != null && this.taskOwner.getDistanceSqToEntity(this.taskOwner.getAttackTarget()) < MAX_DISTANCE) {
    		/*if(this.taskOwner.getDistanceSqToEntity(this.taskOwner.getAttackTarget()) < 12)
    		{
    			EntityHelper.setAnimation(this.taskOwner, 1);
    		}*/
	    	if(ticksBeforeNextFlame <= 0) {
	    		double d0 = this.taskOwner.getDistanceSqToEntity(this.taskOwner.getAttackTarget());
	    		float f = MathHelper.sqrt(MathHelper.sqrt(d0));
	    		double d1 = this.taskOwner.getAttackTarget().posX - this.taskOwner.posX;
	    		double d2 = this.taskOwner.getAttackTarget().getEntityBoundingBox().minY + (double)(this.taskOwner.getAttackTarget().height / 2.0F) - (this.taskOwner.posY + (double)(this.taskOwner.height / 2.0F));
	    		double d3 = this.taskOwner.getAttackTarget().posZ - this.taskOwner.posZ;
	    		System.out.println(d2);
	    		EntityThunder esfb = new EntityThunder(this.taskOwner.world, this.taskOwner, this.taskOwner.posX, this.taskOwner.posY, this.taskOwner.posZ);
                this.taskOwner.world.playSound(null, this.taskOwner.posX, this.taskOwner.posY, this.taskOwner.posZ, SoundEvents.ENTITY_GHAST_SHOOT, SoundCategory.HOSTILE, 1.0F, 1.0F);
                esfb.posY = this.taskOwner.posY + (double)(this.taskOwner.height / 2.0F) + 0.5D;
	    		this.taskOwner.world.spawnEntity(esfb);
	    		ticksBeforeNextFlame = 30 + this.taskOwner.getRNG().nextInt(10);
	    	}
	    	else {
	    		ticksBeforeNextFlame--;
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
