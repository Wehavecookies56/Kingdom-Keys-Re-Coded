package uk.co.wehavecookies56.kk.common.entity.mobs;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAttackMelee;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import uk.co.wehavecookies56.kk.common.core.helper.EntityHelper;
import uk.co.wehavecookies56.kk.common.core.helper.EntityHelper.MobType;
import uk.co.wehavecookies56.kk.common.entity.magic.EntityKH1Fire;
import uk.co.wehavecookies56.kk.common.entity.projectiles.EntitySeedBullet;

public class EntityDirePlant extends BaseEntityHeartless implements IKHMob
{

	public EntityDirePlant(World worldIn) 
	{
		super(worldIn);
		this.tasks.addTask(0, new EntityAIAttackMelee(this, 0.0D, false));
		this.tasks.addTask(0, new EntityAIDirePlantSeed(this));
		this.tasks.addTask(1, new EntityAILookIdle(this));
		this.targetTasks.addTask(0, new EntityAIHurtByTarget(this, true));
		this.targetTasks.addTask(1, new EntityAINearestAttackableTarget(this, EntityPlayer.class, true));
	}
	
    @Override
    public void applyEntityAttributes() 
    {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.FOLLOW_RANGE).setBaseValue(35.0D);
        this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.0D);
        this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(2.0D);
        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(40.0D);
        this.getEntityAttribute(SharedMonsterAttributes.KNOCKBACK_RESISTANCE).setBaseValue(1000.0D);
    }
    
    @Override
    protected void entityInit() 
    {
        super.entityInit();
        this.getDataManager().register(EntityHelper.STATE, 0);
    }
	
	public MobType getType() 
	{
		return MobType.HEARTLESS_EMBLEM;
	}
	
	class EntityAIDirePlantSeed extends EntityAIBase
	{
		private EntityDirePlant theEntity;	
		private boolean canUseAttack = true;
		private int attackTimer = 30;
		
		public EntityAIDirePlantSeed(EntityDirePlant e) 
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
			attackTimer = 30;
			EntityHelper.setState(theEntity, 0);
		}
			
        public void updateTask()
        { 
        	if(theEntity.getAttackTarget() != null && canUseAttack	)
        	{
        		EntityHelper.setState(theEntity, 1);
        		EntityLivingBase target = this.theEntity.getAttackTarget();

        		this.theEntity.getLookHelper().setLookPositionWithEntity(target, 30F, 30F);
        		
        		if(world.rand.nextInt(100) + 1 > EntityHelper.percentage(25, 100))
        		{
        			EntitySeedBullet seed = new EntitySeedBullet(this.theEntity.world, this.theEntity);
                    double d1 = this.theEntity.getAttackTarget().posX - this.theEntity.posX;
                    double d2 = this.theEntity.getAttackTarget().getEntityBoundingBox().minY + (double)(this.theEntity.getAttackTarget().height / 2.0F) - (this.theEntity.posY + (double)(this.theEntity.height / 2.0F));
                    double d3 = this.theEntity.getAttackTarget().posZ - this.theEntity.posZ;
        			seed.setThrowableHeading(d1, d2, d3, 1.2F, 0);
        			seed.posY = this.theEntity.posY + (double)(this.theEntity.height / 2.0F) + 0.5D;
        			this.theEntity.world.spawnEntity(seed);
        		}
        		else
        		{
        			EntitySeedBullet seed = new EntitySeedBullet(this.theEntity.world, this.theEntity);
                    double d1 = this.theEntity.getAttackTarget().posX - this.theEntity.posX;
                    double d2 = this.theEntity.getAttackTarget().getEntityBoundingBox().minY + (double)(this.theEntity.getAttackTarget().height / 2.0F) - (this.theEntity.posY + (double)(this.theEntity.height / 2.0F));
                    double d3 = this.theEntity.getAttackTarget().posZ - this.theEntity.posZ;
        			seed.setThrowableHeading(d1, d2, d3, 1.2F, 0);
        			seed.posY = this.theEntity.posY + (double)(this.theEntity.height / 2.0F) + 0.5D;
   
        			EntitySeedBullet seed1 = new EntitySeedBullet(this.theEntity.world, this.theEntity);
                    double d11 = this.theEntity.getAttackTarget().posX - this.theEntity.posX;
                    double d21 = this.theEntity.getAttackTarget().getEntityBoundingBox().minY + (double)(this.theEntity.getAttackTarget().height / 2.0F) - (this.theEntity.posY + (double)(this.theEntity.height / 2.0F));
                    double d31 = this.theEntity.getAttackTarget().posZ - this.theEntity.posZ;
        			seed1.setThrowableHeading(d11, d21, d31, 0.7F, 0);
        			seed1.posY = this.theEntity.posY + (double)(this.theEntity.height / 2.0F) + 0.5D;
        			
        			EntitySeedBullet seed11 = new EntitySeedBullet(this.theEntity.world, this.theEntity);
                    double d111 = this.theEntity.getAttackTarget().posX - this.theEntity.posX;
                    double d211 = this.theEntity.getAttackTarget().getEntityBoundingBox().minY + (double)(this.theEntity.getAttackTarget().height / 2.0F) - (this.theEntity.posY + (double)(this.theEntity.height / 2.0F));
                    double d311 = this.theEntity.getAttackTarget().posZ - this.theEntity.posZ;
        			seed11.setThrowableHeading(d111, d211, d311, 0.5F, 0);
        			seed11.posY = this.theEntity.posY + (double)(this.theEntity.height / 2.0F) + 0.5D;
     			
        			this.theEntity.world.spawnEntity(seed);
        			this.theEntity.world.spawnEntity(seed1);
        			this.theEntity.world.spawnEntity(seed11);
        		}
        		
        		canUseAttack = false;
        	}
        }
		
	}
}
