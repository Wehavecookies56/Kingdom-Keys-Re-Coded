package uk.co.wehavecookies56.kk.common.entity.mobs.ai;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.ai.EntityAITarget;
import net.minecraft.world.World;
import uk.co.wehavecookies56.kk.common.core.helper.EntityHelper;
import uk.co.wehavecookies56.kk.common.entity.mobs.EntityDarkball;

public class EntityAIMinuteBomb extends EntityAITarget{
	
	private boolean canUseAttack = true;
	private int ticksBeforeExplode = 50;
	private double[] pivotPosToMove;
	
	public EntityAIMinuteBomb(EntityCreature creature){
        super(creature, true);
        ticksBeforeExplode = 60;
    }
	
	@Override
    public boolean shouldExecute() {
        return this.taskOwner.getAttackTarget() != null && this.taskOwner.getDistanceSqToEntity(this.taskOwner.getAttackTarget()) < 1024;
    }
	
	/*public boolean prevAttackCalc()
	{
		if(this.theEntity.getPreviousAttackState() == EntityDarkball.SpecialAttack.DARKCLOUD)
		{
			if(theEntity.rand.nextFloat() <= 0.3f) return true;
			else return false;
		}
		return true;
	}*/

	public boolean shouldContinueExecuting(){
        if(this.taskOwner.getAttackTarget() != null && this.taskOwner.getDistanceSqToEntity(this.taskOwner.getAttackTarget()) < 5) {
		
			EntityLivingBase target = this.taskOwner.getAttackTarget();
			if(taskOwner.getDistanceToEntity(target) < 5) {
				if(ticksBeforeExplode > 0){
					ticksBeforeExplode--;
				} else {
					System.out.println("Boom");
					taskOwner.world.createExplosion(taskOwner, taskOwner.posX, taskOwner.posY, taskOwner.posZ, 3F, true);
					taskOwner.setDead();
				}
			}
			return true;
		} 
		return false;
		

	}

	public void startExecuting(){
		//canUseAttack = true;
		ticksBeforeExplode = 60;
		//whileAttackTimer = 0;

		//EntityHelper.setState(theEntity, 0);
	}
}
