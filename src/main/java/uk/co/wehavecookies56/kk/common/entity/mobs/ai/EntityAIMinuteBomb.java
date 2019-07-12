package uk.co.wehavecookies56.kk.common.entity.mobs.ai;

import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.ai.EntityAITarget;
import uk.co.wehavecookies56.kk.common.entity.mobs.BaseEntityBomb;
import uk.co.wehavecookies56.kk.common.entity.mobs.EntityDetonator;
import uk.co.wehavecookies56.kk.common.entity.mobs.EntityMinuteBomb;
import uk.co.wehavecookies56.kk.common.entity.mobs.EntitySkaterBomb;
import uk.co.wehavecookies56.kk.common.entity.mobs.EntityStormBomb;

public class EntityAIMinuteBomb extends EntityAITarget {

	private float strength;
	private BaseEntityBomb bomb;
	
	public EntityAIMinuteBomb(EntityCreature creature) {
		super(creature, true);
		if (creature instanceof EntityMinuteBomb) {
			strength = 2F;
		} else if (creature instanceof EntitySkaterBomb) {
			strength = 3F;
		} else if (creature instanceof EntityStormBomb) {
			strength = 4F;
		} else if (creature instanceof EntityDetonator) {
			strength = 5F;
		}
		
		if(creature instanceof BaseEntityBomb){
			this.bomb = (BaseEntityBomb) creature;
		}
	}

	@Override
	public boolean shouldExecute() {
		return this.taskOwner.getAttackTarget() != null && this.taskOwner.getDistanceSq(this.taskOwner.getAttackTarget()) < 1024;
	}

	public boolean shouldContinueExecuting() {
		if (this.taskOwner.getAttackTarget() != null) {
			EntityLivingBase target = this.taskOwner.getAttackTarget();

			if (taskOwner.getDistance(target) < 10) {
				if (bomb.ticksToExplode > 0) {
					bomb.ticksToExplode--;
					return true;
				} else {
					taskOwner.world.createExplosion(taskOwner, taskOwner.posX, taskOwner.posY, taskOwner.posZ, strength, false);
					taskOwner.setDead();
					return false;
				}
			}
		}
		return false;
	}

	/*public void startExecuting() {
		bomb.ticksToExplode = 60;
		// EntityHelper.setState(theEntity, 0);
	}*/
}
