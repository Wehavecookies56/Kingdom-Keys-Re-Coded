package uk.co.wehavecookies56.kk.common.entity.mobs;

import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.world.World;
import uk.co.wehavecookies56.kk.common.core.helper.EntityHelper;
import uk.co.wehavecookies56.kk.common.core.helper.EntityHelper.MobType;
import uk.co.wehavecookies56.kk.common.entity.mobs.EntityDarkball.SpecialAttack;
import uk.co.wehavecookies56.kk.common.entity.mobs.multipart.IMultiPartEntity;

public class EntityWhiteMushroom extends BaseEntityHeartless implements IKHMob
{

    private SpecialAttack currentAttack, previousAttack;
	
	public EntityWhiteMushroom(World worldIn) 
	{
		super(worldIn);
	}
	
    @Override
    public void applyEntityAttributes() 
    {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.FOLLOW_RANGE).setBaseValue(0.0D);
        this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.0D);
        this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(0.0D);
        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(0.1D);
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
		FIRE,
		BLIZZARD,
		THUNDER,
		CURE,
		GRAVITY,
		STOP,
		AERO;
	}
	
}
