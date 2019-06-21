package uk.co.wehavecookies56.kk.common.entity.mobs;

import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAttackMelee;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;
import uk.co.wehavecookies56.kk.common.core.helper.EntityHelper;
import uk.co.wehavecookies56.kk.common.core.helper.EntityHelper.MobType;

public class EntityCreeper extends EntityMob implements IKHMob
{

	public EntityCreeper(World worldIn) 
	{
		super(worldIn);
		this.setSize(this.width, 1.5F);
		this.tasks.addTask(0, new EntityAIAttackMelee(this, 1.0D, false));
		this.tasks.addTask(0, new EntityCreeperAI(this));
		this.tasks.addTask(1, new EntityAILookIdle(this));
		this.targetTasks.addTask(0, new EntityAIHurtByTarget(this, true));
		this.targetTasks.addTask(1, new EntityAINearestAttackableTarget(this, EntityPlayer.class, true));
	}
	
    @Override
    public void applyEntityAttributes() 
    {
        super.applyEntityAttributes();
		this.getEntityAttribute(SharedMonsterAttributes.FOLLOW_RANGE).setBaseValue(35.0D);
		this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.17D);
		this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(0.0D);
		this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(40.0D);
        this.getEntityAttribute(SharedMonsterAttributes.KNOCKBACK_RESISTANCE).setBaseValue(1000.0D);
    }
    
    @Override
    protected void entityInit() 
    {
        super.entityInit();
        this.getDataManager().register(EntityHelper.STATE, 0); // Initialize this to 0 (default non-attack state)
    }
	
	public MobType getType() 
	{
		return MobType.NOBODY;
	}

	public void fall(float distance, float damageMultiplier) {}
	
	/*
	 Probably a bad idea to put 3 AIs in the same class and choosing one using a percentage...but hey...it works :D
	 */
	class EntityCreeperAI extends EntityAIBase
	{
		private EntityCreeper theEntity;	// the entity who holds this AI
		private boolean canUseAttack = true;	// true/false value to decide if we can use this ability or if the cooldown starts
		private int attackTimer = 5, whileAttackTimer; // attackTimer is the cooldown while whileAttackTimer is the amount of ticks the attack runned for
		private double[] posToFall; // an double array that holds the pos values (x,y,z) for where to drop the entity
		
		public EntityCreeperAI(EntityCreeper e) 
		{
			this.theEntity = e;
		}
		
		/*
			Should be self-explanatory but:
			- return false means this AI would not be executed, return true means it will be
			- First we check if the target is not null (most important thing cuz otherwise why would we need this AI ?)
			- we then check if the AI is usable, if yes we start the AI, otherwise we start the "cooldown"..aka this line : attackTimer--
			Assuming we return true startExecuting() will be called next
		 */
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
		
		/*
			"Legacy code" from Shadows and older entities but basically if the ability is usable it's execution is not interrupted 
		 */
	    public boolean shouldContinueExecuting()
	    {
	    	boolean flag = canUseAttack;
	    	
	    	return flag;
	    }
	    
	    /*
			This is the initialization part after each cooldown
			
			It's also where we initialize where the pos for the spear attack will be placed
	     */
		public void startExecuting()
		{
			canUseAttack = true;
			if(EntityHelper.getState(theEntity) > 2)
				attackTimer = 10 + world.rand.nextInt(5);
			else
				attackTimer = 20 + world.rand.nextInt(5);
			EntityHelper.setState(theEntity, 0);
			this.theEntity.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.17D);
			whileAttackTimer = 0;
		}
			
		/*
			The actual meat of this AI
		 */
        public void updateTask()
        { 
        	if( theEntity.getAttackTarget() != null && canUseAttack	) // Like above we check again to see if the target is still alive (maybe it died so we need to check again)
        	{
        		whileAttackTimer++;
        		EntityLivingBase target = this.theEntity.getAttackTarget(); // Creates a new variable that holds the target

        		if(EntityHelper.getState(theEntity) == 0) // if the state of the entity is 0 (meaning it does not executes any attack)
        		{
        			this.theEntity.getLookHelper().setLookPositionWithEntity(target, 30F, 30F); // we turn the entity to face the target
        		
	        		if(world.rand.nextInt(100) + world.rand.nextDouble() <= 75)	// some sort of primitive (could've looked better) percentage system..but if the random number is under or equal with 75 (so a 75% chance)
	        		{
	        			//MORPHING PHASE
	            		if(world.rand.nextInt(100) + world.rand.nextDouble() <= 50) // again but for another randomized number to see which morph to run, there's a 50/50 chance for both
	            		{
	            			//SWORD
	            			if(theEntity.getDistance(theEntity.getAttackTarget()) < 8) // for the sword one we need to check if the target is 4 blocks or less away from the entity (just because it wouldn't make much sense for a close-ranged attack to occur when the target is 5 miles away)
	            			{
		            			EntityHelper.setState(theEntity, 1); // setting the state to 1 (sword morphing)
		            			
		            			/*
		            			   Kinda optional for this one but I thought it's a nice touch...we set the movement speed and attack damage to 0
		            			   But why the attack damage ? Becase we don't want the use to be hit by the actual entity being to close (vanilla attack, which deals 1 heart)
		            			   we want to deal special damage (4 hearts) to every entity around 2 block 
		            			 */
		            			this.theEntity.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.0D);
		            			
		            			for(EntityLivingBase enemy : EntityHelper.getEntitiesNear(this.theEntity, 4))
		            				enemy.attackEntityFrom(DamageSource.causeMobDamage(this.theEntity), 8);
	            			}
	            			else
	            				updateTask();
	            		}
	            		else
	            		{
	            			//SPEAR
	            			/*
	            			 Same as with the sword, the only difference being we move the entity 4 blocks above the target location (for that sweet "falling from sky" effect)
	            			 Also deals only 3 hearts for entities around 2 blocks around it (cuz it's a spear not a sword, smaller range)
	            			 */
	            			EntityHelper.setState(theEntity, 2);
	            			this.theEntity.setPositionAndUpdate(target.posX, target.posY + 4, target.posZ);
	            			this.theEntity.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.0D);
	            			
	            			for(EntityLivingBase enemy : EntityHelper.getEntitiesNear(this.theEntity, 3))
	            				enemy.attackEntityFrom(DamageSource.causeMobDamage(this.theEntity), 6);
	            		}
	        		}
	        		else
	        		{
	        			if(theEntity.getDistance(theEntity.getAttackTarget()) < 5)
	        			{
		        			//LEG SWIPE
		        			EntityHelper.setState(theEntity, 3);
		        			
	            			this.theEntity.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.0D);
	            			
	            			for(EntityLivingBase enemy : EntityHelper.getEntitiesNear(this.theEntity, 2.5))
	            				enemy.attackEntityFrom(DamageSource.causeMobDamage(this.theEntity), 4);
	        			}
            			else
            				updateTask();
	        		}
	        		
	        	}
        		
        		if(EntityHelper.getState(theEntity) == 1 && whileAttackTimer > 20) // special check if the sword AI is active and if it's been more than 1 second since the attack started, 
        		{// did this because I want the sword attack to last 1 second and the other 2 attacks more than 1 second
        			/*
        			 	start the cooldown and reset the entity attributes
        			 */
        			canUseAttack = false;
        			EntityHelper.setState(theEntity, 0);
        			this.theEntity.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.17D);
        		}
        		else if(EntityHelper.getState(theEntity) != 1 && whileAttackTimer > 30)
        		{
            		canUseAttack = false;
            		EntityHelper.setState(theEntity, 0);
        			this.theEntity.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.17D);
        		}
        	}
        }
		
	}

}