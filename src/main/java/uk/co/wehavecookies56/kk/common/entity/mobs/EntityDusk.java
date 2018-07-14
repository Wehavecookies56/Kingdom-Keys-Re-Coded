package uk.co.wehavecookies56.kk.common.entity.mobs;

import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAttackMelee;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIMoveTowardsRestriction;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import uk.co.wehavecookies56.kk.common.core.helper.EntityHelper;
import uk.co.wehavecookies56.kk.common.core.helper.EntityHelper.MobType;
import uk.co.wehavecookies56.kk.common.entity.mobs.EntityDirePlant.EntityAIDirePlantSeed;
import uk.co.wehavecookies56.kk.common.entity.projectiles.EntitySeedBullet;

public class EntityDusk extends EntityMob implements IKHMob
{

	public EntityDusk(World worldIn)
	{
		super(worldIn);
		this.tasks.addTask(0, new EntityAIAttackMelee(this, 1.0D, false));
		this.tasks.addTask(0, new EntityAIDuskCoil(this));
		this.tasks.addTask(1, new EntityAIMoveTowardsRestriction(this, 1.0D));
		this.tasks.addTask(2, new EntityAIWander(this, 1.0D));
		this.tasks.addTask(3, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
		this.tasks.addTask(4, new EntityAILookIdle(this));
		this.targetTasks.addTask(0, new EntityAIHurtByTarget(this, true));
		this.targetTasks.addTask(1, new EntityAINearestAttackableTarget(this, EntityPlayer.class, true));
	}

	@Override
	public void applyEntityAttributes()
	{
		super.applyEntityAttributes();
		this.getEntityAttribute(SharedMonsterAttributes.FOLLOW_RANGE).setBaseValue(35.0D);
		this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.20D);
		this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(0.0D);
		this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(50.0D);
        this.getEntityAttribute(SharedMonsterAttributes.KNOCKBACK_RESISTANCE).setBaseValue(1000.0D);
	}

	@Override
	protected void entityInit()
	{
		super.entityInit();
		this.getDataManager().register(EntityHelper.STATE, 0);
	}

	@Override
	public MobType getType()
	{
		return MobType.NOBODY;
	}
	
	/**
	 * XXX Coil AI
	 * @author WYND
	 */
	class EntityAIDuskCoil extends EntityAIBase
	{
		private EntityDusk theEntity;	
		private boolean canUseAttack = true;
		private int attackTimer = 30;
		private double[] posToCharge;
		
		public EntityAIDuskCoil(EntityDusk e) 
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
			attackTimer = 40 + world.rand.nextInt(10);
			EntityHelper.setState(theEntity, 0);
			EntityLivingBase target = this.theEntity.getAttackTarget();

			if(target != null)
				posToCharge = new double[] {target.posX, target.posY, target.posZ};	
		}
			
        public void updateTask()
        { 
        	if( theEntity.getAttackTarget() != null && canUseAttack	)
        	{
        		EntityHelper.setState(theEntity, 1);
        		EntityLivingBase target = this.theEntity.getAttackTarget();

        		this.theEntity.getLookHelper().setLookPositionWithEntity(target, 30F, 30F);
        		
        		//if(world.rand.nextInt(100) + world.rand.nextDouble() <= 50)
        		//{
        			this.theEntity.getNavigator().tryMoveToXYZ(posToCharge[0], posToCharge[1], posToCharge[2], 10.0D);
        			System.out.println("@@");
        			
        		/*}
        		else
        		{
        			System.out.println("SECOND AI");
        		}*/
        		
        		canUseAttack = false;
        	}
        }
		
	}

}
