package uk.co.wehavecookies56.kk.common.entity.mobs;

import java.util.Random;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.MultiPartEntityPart;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAttackMelee;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;
import uk.co.wehavecookies56.kk.common.KingdomKeys;
import uk.co.wehavecookies56.kk.common.core.helper.EntityHelper;
import uk.co.wehavecookies56.kk.common.core.helper.EntityHelper.MobType;
import uk.co.wehavecookies56.kk.common.entity.mobs.EntityDarkball.EntityAIDarkballBerserk;
import uk.co.wehavecookies56.kk.common.entity.mobs.EntityDarkball.EntityAIDarkballCharge;
import uk.co.wehavecookies56.kk.common.entity.mobs.EntityDarkball.EntityAIDarkballDarkCloud;
import uk.co.wehavecookies56.kk.common.entity.mobs.EntityDarkball.SpecialAttack;
import uk.co.wehavecookies56.kk.common.entity.mobs.multipart.EntityPart;
import uk.co.wehavecookies56.kk.common.entity.mobs.multipart.IMultiPartEntity;
 
public class EntityLargeBody extends BaseEntityHeartless implements IMultiPartEntity, IKHMob
{
    public EntityPart[] partsArray;
    public EntityPart partBelly = new EntityPart(this, "strongzoneBelly", 0F, 0F);
    private SpecialAttack currentAttack, previousAttack;
    private int timeForNextAI = 80;
    private boolean isAngry = false;
    
    protected final int 
    	DAMAGE_HIT = 0,
    	DAMAGE_CHARGE = 6,
    	DAMAGE_MOWDOWN = 5,
    	DAMAGE_SHOCKWAVE = 4;
    
	public EntityLargeBody(World worldIn) 
	{
		super(worldIn);
		this.setSize(2, 3F);
		this.tasks.addTask(0, new EntityAIAttackMelee(this, 1.0D, false));
		this.tasks.addTask(0, new EntityAILargeBodyCharge(this));
		this.tasks.addTask(1, new EntityAILargeBodyMowdown(this));
		this.tasks.addTask(1, new EntityAISwimming(this));
		this.tasks.addTask(3, new EntityAIWander(this, 1.0D));
		this.tasks.addTask(4, new EntityAILookIdle(this));
		this.targetTasks.addTask(0, new EntityAIHurtByTarget(this, true));
		this.targetTasks.addTask(1, new EntityAINearestAttackableTarget(this, EntityPlayer.class, true));
		this.partsArray = new EntityPart[] {partBelly};
	}

    public void onLivingUpdate()
    { 
    	super.onLivingUpdate();
    	    	
    	int rotation = MathHelper.floor(this.getRotationYawHead() * 4.0F / 360.0F + 0.5D) & 3;    	
    	
        this.partBelly.width = 2.4F;
        this.partBelly.height = 2.4F;
    	
        if(this.getHealth() < this.getMaxHealth()/3)
        	this.isAngry = true;
        
    	if(this.getCurrentAttackState() == SpecialAttack.MOWDOWN)
    		this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0);
    	
    	if(this.getPreviousAttackState() != SpecialAttack.WAIT && timeForNextAI > 0)
    	{
	    	this.setCurrentAttackState(SpecialAttack.WAIT);  		
	    	this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0);
    		this.setAttackTarget(null);
	    	EntityHelper.setState(this, 10);
	    	timeForNextAI--;
    	}
    	else if(timeForNextAI <= 0)
    	{
    		this.setPreviousAttackState(SpecialAttack.WAIT);  	
    		this.setCurrentAttackState(null);  
    		if(this.isAngry)
        		this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.20);
    		else
    			this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.15);
    		EntityHelper.setState(this, 0);
    		this.setAttackTarget(null);
    		timeForNextAI = 80;
    	}
        
    	if(this.isAngry)
    	{
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
    	
    	if(EntityHelper.getState(this) != 10 || EntityHelper.getState(this) != 2)
        	newBellyPos(rotation);
    }
    
    private void newBellyPos(int rotation)
    {
    	switch(rotation)
    	{   	
    	case 0:
            this.partBelly.setPosition(this.posX, this.posY, this.posZ + 0.7);
    		break;
    	case 1:
            this.partBelly.setPosition(this.posX - 0.7, this.posY, this.posZ);
    		break;
    	case 2:
            this.partBelly.setPosition(this.posX, this.posY, this.posZ - 0.7);
    		break;
    	case 3:
            this.partBelly.setPosition(this.posX + 0.7, this.posY, this.posZ);
    		break;
    	}  	
    	this.partBelly.onUpdate();
    }
	
    public void applyEntityAttributes() 
    {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.FOLLOW_RANGE).setBaseValue(35.0D);
        this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.15D);
        this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(1.0D);
        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(20.0D);
    }

	public boolean attackEntityAsMob(Entity ent)
    {
		int i = 0;
		float j = 1;
		
		if(EntityHelper.getState(this) == 0) i = DAMAGE_HIT;
		else if(EntityHelper.getState(this) == 1) i = DAMAGE_CHARGE;
		else if(EntityHelper.getState(this) == 2) i = DAMAGE_MOWDOWN;	
		else if(EntityHelper.getState(this) == 3) i = DAMAGE_SHOCKWAVE;
		
		if(this.isAngry)	
			j = 1.5F;
		
        return ent.attackEntityFrom(DamageSource.causeMobDamage(this), i * j);
    }
    
    protected void entityInit() 
    {
        super.entityInit();
        this.getDataManager().register(EntityHelper.STATE, 0);
    }	

	public boolean attackEntityFromPart(EntityPart part, DamageSource source, float damage) 
	{				
		if(part.getPartName().contains("strongzone"))
		{
			return false;
		}
				
		this.attackEntityFrom(source, damage);
		return true;
	}	
	
	public MobType getType() 
	{
		return MobType.HEARTLESS_EMBLEM;
	}

	public World getWorld() 
	{
		return this.world;
	}

    public Entity[] getParts()
    {
        return this.partsArray;
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
		WAIT,
		CHARGE,
		MOWDOWN,
		SHOCKWAVE;
	}
	
	
	/** XXX Large Body Mowdown */
	
	class EntityAILargeBodyMowdown extends EntityAIBase
	{
		private EntityLargeBody theEntity;	
		private boolean canUseAttack = true;
		private final int ATTACK_MAX_TIMER = 50;
		private int attackTimer = ATTACK_MAX_TIMER, whileAttackTimer;
		private double[] posToCharge;
		private float initialHealth;
		
		public EntityAILargeBodyMowdown(EntityLargeBody e) 
		{
			this.theEntity = e;
		}
		
		public boolean shouldExecute() 
		{
			if(theEntity.getAttackTarget() != null && this.theEntity.getCurrentAttackState() == null && theEntity.getDistanceToEntity(theEntity.getAttackTarget()) < 5)
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
			if(this.theEntity.getPreviousAttackState() == SpecialAttack.MOWDOWN)
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
	    	
	    	return flag; //(theEntity.getAttackTarget() != null && theEntity.getDistanceSqToEntity(this.theEntity.getAttackTarget()) < 400) ||
	    }
		
		public void startExecuting()
		{
			canUseAttack = true;
			attackTimer = ATTACK_MAX_TIMER;
			whileAttackTimer = 0;
			this.theEntity.setCurrentAttackState(SpecialAttack.MOWDOWN);
			EntityHelper.setState(theEntity, 2);
			initialHealth = theEntity.getHealth();
		}
			
        public void updateTask()
        { 
        	if(theEntity.getAttackTarget() != null && canUseAttack)
        	{
        		whileAttackTimer++;
        		System.out.println("mowdown " + whileAttackTimer);

        		for(Entity t : EntityHelper.getEntitiesNear(this.theEntity, 0.2))
        		{
        			t.attackEntityFrom(DamageSource.causeMobDamage(this.theEntity), theEntity.isAngry ? this.theEntity.DAMAGE_MOWDOWN * 1.5f : this.theEntity.DAMAGE_MOWDOWN);
        		}
        		
	            if(whileAttackTimer > 40)
	            	canUseAttack = false;
	            
            	if(initialHealth > theEntity.getHealth())
            		canUseAttack = false;
        	}
		}
	}
	
	
	/** XXX Large Body Charge */
	
	class EntityAILargeBodyCharge extends EntityAIBase
	{
		private EntityLargeBody theEntity;	
		private boolean canUseAttack = true;
		private final int ATTACK_MAX_TIMER = 70;
		private int attackTimer = ATTACK_MAX_TIMER, whileAttackTimer;
		private double[] posToCharge;
		private float initialHealth;
		
		public EntityAILargeBodyCharge(EntityLargeBody e) 
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
				if(theEntity.rand.nextFloat() <= 0.2f) return true;
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
			attackTimer = ATTACK_MAX_TIMER;
			whileAttackTimer = 0;
			this.theEntity.setCurrentAttackState(SpecialAttack.CHARGE);
			System.out.println("" + this.theEntity.getCurrentAttackState());
			EntityHelper.setState(theEntity, 1);
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
            	EntityLivingBase target = this.theEntity.getAttackTarget();
	            this.theEntity.getNavigator().tryMoveToXYZ(posToCharge[0], posToCharge[1], posToCharge[2], theEntity.isAngry ? 2.3D : 2.0D);

	            if(whileAttackTimer > 70)
	            	canUseAttack = false;
	            
	            if((theEntity.getPosition().getX() == (int)posToCharge[0] && theEntity.getPosition().getY() == (int)posToCharge[1] && theEntity.getPosition().getZ() == (int)posToCharge[2])
	            		|| (theEntity.getPosition().getX() == (int)posToCharge[0] + 1 && theEntity.getPosition().getY() == (int)posToCharge[1] && theEntity.getPosition().getZ() == (int)posToCharge[2] + 1)
	            		|| (theEntity.getPosition().getX() == (int)posToCharge[0] - 1 && theEntity.getPosition().getY() == (int)posToCharge[1] && theEntity.getPosition().getZ() == (int)posToCharge[2] - 1))
	            	canUseAttack = false;
	            
            	if(theEntity.getDistanceSqToEntity(this.theEntity.getAttackTarget()) < 2)
            		canUseAttack = false;
            	
            	if(initialHealth > theEntity.getHealth())
            		canUseAttack = false;
        	}
		}
	}
}
