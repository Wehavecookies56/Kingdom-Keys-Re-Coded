package uk.co.wehavecookies56.kk.common.entity.mobs;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIMoveTowardsRestriction;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;
import uk.co.wehavecookies56.kk.common.core.helper.EntityHelper;
import uk.co.wehavecookies56.kk.common.core.helper.EntityHelper.MobType;
import uk.co.wehavecookies56.kk.common.entity.magic.EntityThunder;

public class EntityGreenRequiem extends BaseEntityHeartless implements IKHMob
{

	public EntityGreenRequiem(World world)
	{
		super(world);
		this.isImmuneToFire = true;
		this.tasks.addTask(0, new EntityGreenRequiemAI(this));
		this.tasks.addTask(1, new EntityAIMoveTowardsRestriction(this, 1.0D));
		this.tasks.addTask(2, new EntityAIWander(this, 1.0D));
		this.tasks.addTask(3, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
		this.tasks.addTask(4, new EntityAILookIdle(this));
		this.targetTasks.addTask(1, new EntityAINearestAttackableTarget(this, EntityPlayer.class, true));
	}

	@Override
	public void applyEntityAttributes()
	{
		super.applyEntityAttributes();
		this.getEntityAttribute(SharedMonsterAttributes.FOLLOW_RANGE).setBaseValue(35.0D);
		this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.20D);
		this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(0.0D);
		this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(40.0D);
	}

	@Override
	protected void entityInit()
	{
		super.entityInit();
		this.dataManager.register(EntityHelper.STATE, 0);
	}

	@Override
	public MobType getType()
	{
		return MobType.HEARTLESS_EMBLEM;
	}

	class EntityGreenRequiemAI extends EntityAIBase
	{
		private EntityGreenRequiem theEntity;
		private boolean canUseAttack = true;
		private int attackTimer = 5, whileAttackTimer;
		private float initialHealth;

		public EntityGreenRequiemAI(EntityGreenRequiem e)
		{
			this.theEntity = e;
		}

		public boolean shouldExecute()
		{
			if (theEntity.getAttackTarget() != null)
			{
				if (!canUseAttack)
				{
					if (attackTimer > 0)
					{
						attackTimer--;
						return false;
					} else
						return true;
				} else
					return true;
			} else
				return false;
		}

		public boolean shouldContinueExecuting()
		{
			boolean flag = canUseAttack;

			return flag;
		}

		public void startExecuting()
		{
			canUseAttack = true;
			attackTimer = 25 + world.rand.nextInt(5);
			EntityHelper.setState(theEntity, 0);
			this.theEntity.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.20D);
			whileAttackTimer = 0;
			initialHealth = theEntity.getHealth();
		}

		public void updateTask()
		{
			if (theEntity.getAttackTarget() != null && canUseAttack)
			{
				whileAttackTimer++;
				EntityLivingBase target = this.theEntity.getAttackTarget();

				if (EntityHelper.getState(theEntity) == 0)
				{
					this.theEntity.getLookHelper().setLookPositionWithEntity(target, 30F, 30F);

					if (world.rand.nextInt(100) + world.rand.nextDouble() <= 20)
					{
						EntityHelper.setState(this.theEntity, 1);

						this.theEntity.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.0D);

						if(EntityHelper.getEntitiesNear(this.theEntity, 10).size() > 0)
						{
							for (EntityLivingBase heartless : EntityHelper.getEntitiesNear(this.theEntity, 10))
							{
								if (heartless instanceof BaseEntityHeartless)
								{
									if (heartless.getHealth() < heartless.getMaxHealth() - 10)
										heartless.setHealth(heartless.getHealth() + 10);
									else if(heartless.getHealth() > heartless.getMaxHealth() - 10)
										heartless.setHealth(heartless.getMaxHealth());
	
									if(!this.theEntity.world.isRemote)
									{
										this.theEntity.world.spawnParticle(EnumParticleTypes.VILLAGER_HAPPY, heartless.posX, heartless.posY, heartless.posZ, 0.0D, 1.0D, 0.0D);
										this.theEntity.world.spawnParticle(EnumParticleTypes.VILLAGER_HAPPY, heartless.posX, heartless.posY , heartless.posZ, 0.0D, 1.0D, 0.0D);
										this.theEntity.world.spawnParticle(EnumParticleTypes.VILLAGER_HAPPY, heartless.posX, heartless.posY, heartless.posZ, 0.0D, 1.0D, 0.0D);
										this.theEntity.world.spawnParticle(EnumParticleTypes.VILLAGER_HAPPY, heartless.posX + 0.3, heartless.posY, heartless.posZ, 0.0D, 1.0D, 0.0D);
										this.theEntity.world.spawnParticle(EnumParticleTypes.VILLAGER_HAPPY, heartless.posX - 0.3, heartless.posY, heartless.posZ, 0.0D, 1.0D, 0.0D);
									}
								}
							}
						}
					}
				}

				if (EntityHelper.getState(theEntity) == 1 && whileAttackTimer > 50)
				{
					canUseAttack = false;
					EntityHelper.setState(theEntity, 0);
					this.theEntity.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.20D);
				}
			}
		}

	}
}