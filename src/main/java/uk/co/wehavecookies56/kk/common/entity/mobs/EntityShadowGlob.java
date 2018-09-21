package uk.co.wehavecookies56.kk.common.entity.mobs;

import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAttackMelee;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import uk.co.wehavecookies56.kk.common.core.helper.EntityHelper;
import uk.co.wehavecookies56.kk.common.core.helper.EntityHelper.MobType;
import uk.co.wehavecookies56.kk.common.entity.mobs.EntityDirePlant.EntityAIDirePlantSeed;

public class EntityShadowGlob extends BaseEntityHeartless implements IKHMob
{

	public EntityShadowGlob(World worldIn) 
	{
		super(worldIn);
		this.setSize(1F, 1F);
		this.tasks.addTask(0, new EntityAIAttackMelee(this, 0.0D, false));
		this.tasks.addTask(1, new EntityAILookIdle(this));
		this.targetTasks.addTask(0, new EntityAIHurtByTarget(this, true));
		this.targetTasks.addTask(1, new EntityAINearestAttackableTarget(this, EntityPlayer.class, true));
	}
	
    @Override
    public void applyEntityAttributes() 
    {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.FOLLOW_RANGE).setBaseValue(0.0D);
        this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.0D);
        this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(0.0D);
        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(20.0D);
        this.getEntityAttribute(SharedMonsterAttributes.KNOCKBACK_RESISTANCE).setBaseValue(1000.0D);
    }
    
    public void onUpdate()
    {
    	super.onUpdate();
    	this.renderYawOffset = 0;
    }
    
	@Override
	public boolean isAIDisabled()
	{
		return true;
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
	
}
