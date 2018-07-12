package uk.co.wehavecookies56.kk.common.entity.mobs;

import java.util.Random;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAttackMelee;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIMoveTowardsRestriction;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAIOpenDoor;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import uk.co.wehavecookies56.kk.common.KingdomKeys;
import uk.co.wehavecookies56.kk.common.core.helper.EntityHelper;
import uk.co.wehavecookies56.kk.common.core.helper.EntityHelper.MobType;
import uk.co.wehavecookies56.kk.common.entity.mobs.ai.EntityAIMinuteBomb;
import uk.co.wehavecookies56.kk.common.entity.mobs.ai.EntityAIShadow;


public class EntitySkaterBomb extends BaseEntityBomb{
	
    public EntitySkaterBomb(World worldIn){
        super(worldIn);
        this.setSize(0.6F, 1.4F);
        
    }
    @Override
    public void applyEntityAttributes(){
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.FOLLOW_RANGE).setBaseValue(35.0D);
        this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.4D);
        this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(1.0D);
        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(26.0D);
    }

    @Override
    protected void entityInit(){
        super.entityInit();
        this.getDataManager().register(EntityHelper.STATE, 0);
    }

    public EntityHelper.MobType getType(){
        return EntityHelper.MobType.HEARTLESS_EMBLEM;
    }

    
}
