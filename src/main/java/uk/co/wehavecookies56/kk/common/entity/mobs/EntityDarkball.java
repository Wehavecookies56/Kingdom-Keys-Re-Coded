package uk.co.wehavecookies56.kk.common.entity.mobs;

import java.util.Random;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAttackMelee;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAIOpenDoor;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import uk.co.wehavecookies56.kk.common.KingdomKeys;
import uk.co.wehavecookies56.kk.common.core.helper.EntityHelper;
import uk.co.wehavecookies56.kk.common.core.helper.EntityHelper.MobType;

public class EntityDarkball extends BaseEntityHeartless implements IKHMob 
{	
    private SpecialAttack currentAttack, previousAttack;
    
    protected final int 
    	DAMAGE_HIT = 0,
    	DAMAGE_CHARGE = 6,
    	DAMAGE_BERSERK = 5,
    	DAMAGE_DARKCLOUD = 4;
    
	public EntityDarkball(World worldIn) 
	{
		super(worldIn);
		this.setSize(1.5F, 2);
		this.tasks.addTask(0, new EntityAIAttackMelee(this, 1.0D, false));
		this.tasks.addTask(0, new EntityAIDarkballDarkCloud(this));
		this.tasks.addTask(1, new EntityAIDarkballCharge(this));
		this.tasks.addTask(1, new EntityAIDarkballBerserk(this));
		this.tasks.addTask(1, new EntityAISwimming(this));
		this.tasks.addTask(3, new EntityAIWander(this, 1.0D));
		this.tasks.addTask(4, new EntityAILookIdle(this));
		this.targetTasks.addTask(0, new EntityAIHurtByTarget(this, true));
		this.targetTasks.addTask(1, new EntityAINearestAttackableTarget(this, EntityPlayer.class, true));
	}

    @Override
    public void applyEntityAttributes() 
    {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.FOLLOW_RANGE).setBaseValue(35.0D);
        this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.22D);
        this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(1.0D);
        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(90.0D);
    }

    @Override
    protected void entityInit() 
    {
        super.entityInit();
        this.getDataManager().register(EntityHelper.STATE, 0);
    }	
	
	public MobType getType() 
	{
		return MobType.HEARTLESS_PUREBLOOD;
	}

	protected void updateAITasks()
	{
		EntityLivingBase target = this.getAttackTarget();

		if(EntityHelper.getState(this) == 3)
			this.setEntityInvulnerable(true);
		else
			this.setEntityInvulnerable(false);
		 
		super.updateAITasks();
	}
	
	public boolean attackEntityAsMob(Entity ent)
    {
		int i;
		if(EntityHelper.getState(this) == 0) i = DAMAGE_HIT;
		else if(EntityHelper.getState(this) == 1) i = DAMAGE_CHARGE;
		else if(EntityHelper.getState(this) == 2) i = DAMAGE_BERSERK;	
		else if(EntityHelper.getState(this) == 3) i = DAMAGE_HIT;
		else i = 0;
        return ent.attackEntityFrom(DamageSource.causeMobDamage(this), i);
    }
	
	
	public void setCurrentAttackState(SpecialAttack state)
	{
		this.currentAttack = state;
	}
	
	public SpecialAttack getCurrentAttackState()
	{
		return this.currentAttack;
	}
	
	public void setPreviousAttackState(SpecialAttack state)
	{
		this.previousAttack = state;
	}
	
	public SpecialAttack getPreviousAttackState()
	{
		return this.previousAttack;
	}
	
	
	
	 
	enum SpecialAttack
	{
		CHARGE,
		BERSERK,
		DARKCLOUD;
	}
	
	
	/**
	 * XXX Dark Cloud AI
	 * @author WYND
	 */
	class EntityAIDarkballDarkCloud extends EntityAIBase
	{
		private EntityDarkball theEntity;	
		private boolean canUseAttack = true;
		private int attackTimer = 50, whileAttackTimer;
		private double[] pivotPosToMove;
		
		public EntityAIDarkballDarkCloud(EntityDarkball e) 
		{
			this.theEntity = e;
		}
		
		public boolean shouldExecute() 
		{
			if(theEntity.getAttackTarget() != null && this.theEntity.getCurrentAttackState() == null)
			{
				if(!canUseAttack)
				{
					if(attackTimer > 0)
					{
						attackTimer--;
						return false;
					}
					else return prevAttackCalc();
				}
				else return prevAttackCalc();
			}
			else return false;
		}
		
		public boolean prevAttackCalc()
		{
			if(this.theEntity.getPreviousAttackState() == SpecialAttack.DARKCLOUD)
			{
				if(theEntity.rand.nextFloat() <= 0.3f) return true;
				else return false;
			}
			return true;
		}
		
	    public boolean shouldContinueExecuting()
	    {
	    	boolean flag = canUseAttack;
	    	
	    	if(!flag)
	    	{
	    		this.theEntity.setPreviousAttackState(this.theEntity.getCurrentAttackState());
	    		this.theEntity.setCurrentAttackState(null);
	    		EntityHelper.setState(theEntity, 0);
	    		for(Entity p : EntityHelper.getEntitiesNear(theEntity, 1.4))
	    		{
	    			p.attackEntityFrom(DamageSource.causeMobDamage(theEntity), theEntity.DAMAGE_DARKCLOUD);
	    		}
	    	}
	    	
	    	return flag;
	    }
	    
		public void startExecuting()
		{
			canUseAttack = true;
			attackTimer = 50;
			whileAttackTimer = 0;
			this.theEntity.setCurrentAttackState(SpecialAttack.DARKCLOUD);
			EntityHelper.setState(theEntity, 0);
		}
			
        public void updateTask()
        { 
        	if(theEntity.getAttackTarget() != null && canUseAttack)
        	{
        		whileAttackTimer++;
        		//System.out.println("darkcloud " + whileAttackTimer);
        		EntityHelper.setState(theEntity, 3);
        		EntityLivingBase target = this.theEntity.getAttackTarget();
				for (int i = 0; i < 20; i++)
				{
					double offsetX = (new Random().nextInt(5) + 1.0D + 5.0D) - 5.0D; //3
					double offsetY = (new Random().nextInt(5) + 1.0D + 5.0D) - 5.0D;
					double offsetZ = (new Random().nextInt(5) + 1.0D + 5.0D) - 5.0D;
										
        			this.theEntity.getNavigator().tryMoveToXYZ(target.getPosition().getX(), target.getPosition().getY(), target.getPosition().getZ(), 1.5D);
        	        KingdomKeys.proxy.spawnDarkSmokeParticle(
        	        		world, 
        	        		posX, 
        	        		posY + 1, 
        	        		posZ, 
        	        		0, 
        	        		0.01D, 
        	        		0, 
        	        		0.8F);
				}
        		
	    		for(Entity p : EntityHelper.getEntitiesNear(theEntity, 1))
	    			if(p == target)
	    				canUseAttack = false;
				
	            if(whileAttackTimer > 80)
	            	canUseAttack = false;
        	}
        }
		
	}
	
	
	/**
	 * XXX Berserk AI
	 * @author WYND
	 */
	class EntityAIDarkballBerserk extends EntityAIBase
	{
		private EntityDarkball theEntity;	
		private boolean canUseAttack = true;
		private int attackTimer = 70, whileAttackTimer;
		private double[] pivotPosToBerserk;
		
		public EntityAIDarkballBerserk(EntityDarkball e) 
		{
			this.theEntity = e;
		}
		
		public boolean shouldExecute() 
		{
			if(theEntity.getAttackTarget() != null && this.theEntity.getCurrentAttackState() == null && theEntity.getDistanceSqToEntity(theEntity.getAttackTarget()) < 15)
			{
				if(!canUseAttack)
				{
					if(attackTimer > 0)
					{
						attackTimer--;
						return false;
					}
					else return prevAttackCalc();
				}
				else return prevAttackCalc();
			}
			else return false;
		}
		
		public boolean prevAttackCalc()
		{
			if(this.theEntity.getPreviousAttackState() == SpecialAttack.BERSERK)
			{
				if(theEntity.rand.nextFloat() <= 0.5f) return true;
				else return false;
			}
			return true;
		}
		
	    public boolean shouldContinueExecuting()
	    {
	    	boolean flag = canUseAttack;
	    	
	    	if(!flag)
	    	{
	    		this.theEntity.setPreviousAttackState(this.theEntity.getCurrentAttackState());
	    		this.theEntity.setCurrentAttackState(null);
	    		EntityHelper.setState(theEntity, 0);
	    	}
	    	
	    	return flag;
	    }
	    
		public void startExecuting()
		{
			canUseAttack = true;
			attackTimer = 70;
			whileAttackTimer = 0;
			this.theEntity.setCurrentAttackState(SpecialAttack.BERSERK);
			EntityHelper.setState(theEntity, 0);
			pivotPosToBerserk = new double[] {theEntity.getPosition().getX(), theEntity.getPosition().getY(), theEntity.getPosition().getZ()};
		}
			
        public void updateTask()
        { 
        	if(theEntity.getAttackTarget() != null && canUseAttack)
        	{  
        		whileAttackTimer++;
        		//System.out.println("berserk " + whileAttackTimer);
        		EntityHelper.setState(theEntity, 2);
				for (int i = 0; i < 20; i++)
				{				
					double offsetX = (new Random().nextInt(5) + 1.0D + 5.0D) - 5.0D; //3
					double offsetY = (new Random().nextInt(5) + 1.0D + 5.0D) - 5.0D;
					double offsetZ = (new Random().nextInt(5) + 1.0D + 5.0D) - 5.0D;
					
					EntityLivingBase target = this.theEntity.getAttackTarget();
        			this.theEntity.getNavigator().tryMoveToXYZ(pivotPosToBerserk[0] + offsetX, pivotPosToBerserk[1] + offsetY, pivotPosToBerserk[2] + offsetZ, 5.0D);
        	        KingdomKeys.proxy.spawnDarkSmokeParticle(
        	        		world, 
        	        		posX, 
        	        		posY + 1, 
        	        		posZ, 
        	        		0, 
        	        		0.01D, 
        	        		0, 
        	        		0.5F);
				}
        		
	            if(whileAttackTimer > 40)
	            	canUseAttack = false;
        	}
        }
		
	}
	
	/**
	 * XXX Charge AI
	 * @author WYND
	 */
	class EntityAIDarkballCharge extends EntityAIBase
	{
		private EntityDarkball theEntity;	
		private boolean canUseAttack = true;
		private int attackTimer = 50, whileAttackTimer;
		private double[] posToCharge;
		private float initialHealth;
		
		public EntityAIDarkballCharge(EntityDarkball e) 
		{
			this.theEntity = e;
		}
		
		public boolean shouldExecute() 
		{
			if(theEntity.getAttackTarget() != null && this.theEntity.getCurrentAttackState() == null && theEntity.getDistanceSqToEntity(theEntity.getAttackTarget()) > 4)
			{
				if(!canUseAttack)
				{
					if(attackTimer > 0)
					{
						attackTimer--;
						return false;
					}
					else return prevAttackCalc();
				}
				else return prevAttackCalc();
			}
			else return false;
		}
		
		public boolean prevAttackCalc()
		{
			if(this.theEntity.getPreviousAttackState() == SpecialAttack.CHARGE)
			{
				if(theEntity.rand.nextFloat() <= 0.1f) return true;
				else return false;
			}
			return true;
		}
		
	    public boolean shouldContinueExecuting()
	    {
	    	boolean flag = canUseAttack;
	    	
	    	if(!flag)
	    	{
	    		this.theEntity.setPreviousAttackState(this.theEntity.getCurrentAttackState());
	    		this.theEntity.setCurrentAttackState(null);
	    		EntityHelper.setState(theEntity, 0);
	    	}
	    	
	    	return flag; //(theEntity.getAttackTarget() != null && theEntity.getDistanceSqToEntity(this.theEntity.getAttackTarget()) < 400) ||
	    }
		
		public void startExecuting()
		{
			canUseAttack = true;
			attackTimer = 50;
			whileAttackTimer = 0;
			this.theEntity.setCurrentAttackState(SpecialAttack.CHARGE);
			EntityHelper.setState(theEntity, 0);
			EntityLivingBase target = this.theEntity.getAttackTarget();
			initialHealth = theEntity.getHealth();
			
			if(target != null)
				posToCharge = new double[] {target.posX, target.posY, target.posZ};	
		}
			
        public void updateTask()
        { 
        	if(theEntity.getAttackTarget() != null && canUseAttack)
        	{
        		whileAttackTimer++;
        		//System.out.println("charge " + whileAttackTimer);
        		EntityHelper.setState(theEntity, 1);
            	EntityLivingBase target = this.theEntity.getAttackTarget();
	            this.theEntity.getNavigator().tryMoveToXYZ(posToCharge[0], posToCharge[1], posToCharge[2], 3.0D);

	            if(whileAttackTimer > 100)
	            	canUseAttack = false;
	            
	            if(theEntity.getPosition().getX() == (int)posToCharge[0] && theEntity.getPosition().getY() == (int)posToCharge[1] && theEntity.getPosition().getZ() == (int)posToCharge[2])
	            	canUseAttack = false;
	            
            	if(theEntity.getDistanceSqToEntity(this.theEntity.getAttackTarget()) < 3)
            		canUseAttack = false;
            	
            	if(initialHealth > theEntity.getHealth())
            		canUseAttack = false;
        	}
		}
	}
	
}
