package uk.co.wehavecookies56.kk.common.entity.mobs.ai;

import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.ai.EntityAITarget;
import uk.co.wehavecookies56.kk.common.entity.mobs.EntityDetonator;
import uk.co.wehavecookies56.kk.common.entity.mobs.EntityMinuteBomb;
import uk.co.wehavecookies56.kk.common.entity.mobs.EntitySkaterBomb;
import uk.co.wehavecookies56.kk.common.entity.mobs.EntityStormBomb;

public class EntityAIMinuteBomb extends EntityAITarget {

	private int ticksBeforeExplode;
	private float strength;

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
		ticksBeforeExplode = 50;
	}

	@Override
	public boolean shouldExecute() {
		return this.taskOwner.getAttackTarget() != null && this.taskOwner.getDistanceSqToEntity(this.taskOwner.getAttackTarget()) < 1024;
	}

	public boolean shouldContinueExecuting() {
		if (this.taskOwner.getAttackTarget() != null) {
			EntityLivingBase target = this.taskOwner.getAttackTarget();

			if (taskOwner.getDistanceToEntity(target) < 10) {
				if (ticksBeforeExplode > 0) {
					ticksBeforeExplode--;
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

	public void startExecuting() {
		ticksBeforeExplode = 60;
		// EntityHelper.setState(theEntity, 0);
	}
}
