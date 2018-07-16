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
import net.minecraft.init.SoundEvents;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;
import uk.co.wehavecookies56.kk.common.core.helper.EntityHelper;
import uk.co.wehavecookies56.kk.common.core.helper.EntityHelper.MobType;
import uk.co.wehavecookies56.kk.common.entity.magic.EntityBlizzard;
import uk.co.wehavecookies56.kk.common.entity.magic.EntityFira;
import uk.co.wehavecookies56.kk.common.entity.magic.EntityFiraga;
import uk.co.wehavecookies56.kk.common.entity.magic.EntityFire;
import uk.co.wehavecookies56.kk.common.entity.magic.EntityKH1Fira;
import uk.co.wehavecookies56.kk.common.entity.magic.EntityKH1Firaga;
import uk.co.wehavecookies56.kk.common.entity.magic.EntityKH1Fire;

public class EntityBlueRhapsody extends BaseEntityHeartless implements IKHMob
{

	public EntityBlueRhapsody(World world)
	{
		super(world);
		this.isImmuneToFire = true;
		this.tasks.addTask(0, new EntityBlueRhapsodyAI(this));
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

	public boolean attackEntityFrom(DamageSource source, float amount)
	{
		float multiplier = 1;
		if(!this.world.isRemote)
		{
			if(source.getImmediateSource() instanceof EntityKH1Fire || source.getImmediateSource() instanceof EntityKH1Fira || source.getImmediateSource() instanceof EntityKH1Firaga
					|| source.getImmediateSource() instanceof EntityFire || source.getImmediateSource() instanceof EntityFira || source.getImmediateSource() instanceof EntityFiraga)
				multiplier = 2;
		}
		return super.attackEntityFrom(source, amount * multiplier);
	}
	
	@Override
	public MobType getType()
	{
		return MobType.HEARTLESS_EMBLEM;
	}

	class EntityBlueRhapsodyAI extends EntityAIBase
	{
		private EntityBlueRhapsody theEntity;
		private boolean canUseAttack = true;
		private int attackTimer = 5, whileAttackTimer;
		
		public EntityBlueRhapsodyAI(EntityBlueRhapsody e) 
		{
			this.theEntity = e;
		}

		public boolean shouldExecute() 
		{
			if(theEntity.getAttackTarget() != null)
			{
				if(!canUseAttack)
				{
					if(attackTimer > 0)
					{
						attackTimer--;
						return false;
					}
					else return true;
				}
				else return true;
			}
			else return false;
		}

	    public boolean shouldContinueExecuting()
	    {
	    	boolean flag = canUseAttack;
	    	
	    	return flag;
	    }

		public void startExecuting()
		{
			canUseAttack = true;
			attackTimer = 20 + world.rand.nextInt(5);
			EntityHelper.setState(theEntity, 0);
			this.theEntity.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.20D);
			whileAttackTimer = 0;
		}
			
        public void updateTask()
        { 
        	if( theEntity.getAttackTarget() != null && canUseAttack	)
        	{
        		whileAttackTimer++;
        		EntityLivingBase target = this.theEntity.getAttackTarget();

        		if(EntityHelper.getState(theEntity) == 0)
        		{
        			this.theEntity.getLookHelper().setLookPositionWithEntity(target, 30F, 30F);
        		
	        		if(world.rand.nextInt(100) + world.rand.nextDouble() <= 75)
	        		{
	        			EntityHelper.setState(this.theEntity, 1);
	        			
	        			this.theEntity.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.0D);
	        			this.theEntity.getLookHelper().setLookPositionWithEntity(target, 0F, 0F);
	        			
	                    double d0 = this.theEntity.getDistanceSqToEntity(this.theEntity.getAttackTarget());
	                    float f = MathHelper.sqrt(MathHelper.sqrt(d0));
	                    double d1 = this.theEntity.getAttackTarget().posX - this.theEntity.posX;
	                    double d2 = this.theEntity.getAttackTarget().getEntityBoundingBox().minY + (double)(this.theEntity.getAttackTarget().height / 2.0F) - (this.theEntity.posY + (double)(this.theEntity.height / 2.0F));
	                    double d3 = this.theEntity.getAttackTarget().posZ - this.theEntity.posZ;
	                    EntityBlizzard esfb = new EntityBlizzard(this.theEntity.world, this.theEntity);
	                    esfb.setThrowableHeading(d1, d2, d3, 1, 0);
	                    esfb.posY = this.theEntity.posY + (double)(this.theEntity.height / 2.0F) + 0.5D;
	                    this.theEntity.world.spawnEntity(esfb);
	        		}
	        		else
	        		{
            			if(theEntity.getDistanceToEntity(theEntity.getAttackTarget()) < 8)
            			{
		        			EntityHelper.setState(this.theEntity, 2);
	
	            			this.theEntity.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.0D);
	            			
	            			for(EntityLivingBase enemy : EntityHelper.getEntitiesNear(this.theEntity, 4))
	            				enemy.attackEntityFrom(DamageSource.causeMobDamage(this.theEntity), 4);
            			}
            			else
            				this.updateTask();
	        		}
	        		
	        	}
        		
        		if(EntityHelper.getState(theEntity) == 2 && whileAttackTimer > 20)
        		{     		
        			canUseAttack = false;
        			EntityHelper.setState(theEntity, 0);
        			this.theEntity.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.20D);
        		}
        		else if(EntityHelper.getState(theEntity) == 1 && whileAttackTimer > 50)
        		{
        			canUseAttack = false;
        			EntityHelper.setState(theEntity, 0);
        			this.theEntity.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.20D);
        		}
        	}
        }
		
	}
}