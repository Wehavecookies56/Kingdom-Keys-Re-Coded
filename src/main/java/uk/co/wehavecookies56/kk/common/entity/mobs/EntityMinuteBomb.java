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


public class EntityMinuteBomb extends BaseEntityHeartless implements IKHMob
{

    public EntityMinuteBomb(World worldIn)
    {
        super(worldIn);

    }
    @Override
    public void applyEntityAttributes()
    {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.FOLLOW_RANGE).setBaseValue(35.0D);
        this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.22D);
        this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(1.0D);
        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(12.0D);
    }

    @Override
    protected void entityInit()
    {
        super.entityInit();
        this.getDataManager().register(EntityHelper.STATE, 0);
    }

    public EntityHelper.MobType getType()
    {
        return EntityHelper.MobType.HEARTLESS_EMBLEM;
    }

    public class EntityAIMinuteBomb extends EntityAIBase
    {
        private EntityMinuteBomb theEntity;
        private boolean canUseAttack = true;
        private int attackTimer = 50, whileAttackTimer;
        private double[] pivotPosToMove;

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
            if(this.theEntity.getPreviousAttackState() == EntityDarkball.SpecialAttack.DARKCLOUD)
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
                float countdown = 60;
                //this.theEntity.setPreviousAttackState(this.theEntity.getCurrentAttackState());
                //this.theEntity.setCurrentAttackState(null);
                EntityHelper.setState(theEntity, 0);
                for(Entity p : EntityHelper.getEntitiesNear(theEntity, 1.4))
                { Entity target = getAttackTarget();
                    if (target != null )
                    {

                        while (getDistanceToEntity(target) <= 2 )
                        {
                            if (countdown <= 0)
                            {
                                theEntity.getEntityWorld().createExplosion(theEntity, 1.5D,1.5D, 1.5D, 2, true);
                                canExplosionDestroyBlock() = false;
                            }

                            countdown --;
                        }
                    } // end if

                }

            }

            return flag;
        }

        public void startExecuting()
        {
            canUseAttack = true;
            attackTimer = 50;
            whileAttackTimer = 0;

            EntityHelper.setState(theEntity, 0);
        }
}
