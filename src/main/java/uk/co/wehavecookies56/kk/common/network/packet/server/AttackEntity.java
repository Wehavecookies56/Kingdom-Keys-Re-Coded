package uk.co.wehavecookies56.kk.common.network.packet.server;

import java.io.IOException;
import java.util.Random;

import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.EnumCreatureAttribute;
import net.minecraft.entity.IEntityMultiPart;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.boss.EntityDragonPart;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.Items;
import net.minecraft.init.MobEffects;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.ItemAxe;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.network.PacketBuffer;
import net.minecraft.network.play.server.SPacketEntityVelocity;
import net.minecraft.stats.AchievementList;
import net.minecraft.stats.StatList;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumHand;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.WorldServer;
import net.minecraftforge.fml.relauncher.Side;
import uk.co.wehavecookies56.kk.common.capability.ModCapabilities;
import uk.co.wehavecookies56.kk.common.item.base.ItemKeyblade;
import uk.co.wehavecookies56.kk.common.network.packet.AbstractMessage.AbstractServerMessage;

public class AttackEntity extends AbstractServerMessage<AttackEntity> {

	private int entityId;
	
	public AttackEntity() {}
	
	public AttackEntity(int entityId) {
		this.entityId = entityId;
	}
	
	@Override
	protected void read(PacketBuffer buffer) throws IOException {
		entityId = buffer.readInt();
	}

	@Override
	protected void write(PacketBuffer buffer) throws IOException {
		buffer.writeInt(entityId);
	}

	@Override
	public void process(EntityPlayer player, Side side) {
		Entity entity = player.worldObj.getEntityByID(entityId);
		if (entity != null)
			this.attackTargetEntityWithCurrentItem(player, entity);
	}
	
	
	/**
	 * Slightly modified {@link EntityPlayer#attackTargetEntityWithCurrentItem(Entity)} for off hand
	 * @param player The player
	 * @param targetEntity The entity to attack
	 */
	public void attackTargetEntityWithCurrentItem(EntityPlayer player, Entity targetEntity) {
        if (!net.minecraftforge.common.ForgeHooks.onPlayerAttackTarget(player, targetEntity)) return;
        if (targetEntity.canBeAttackedWithItem())
        {
        	Random rand = new Random();
            if (!targetEntity.hitByEntity(player))
            {
                float attackDamage = (float)player.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).getAttributeValue();
                attackDamage = ((ItemSword)player.getHeldItemOffhand().getItem()).getDamageVsEntity() + 4;
                float f1 = 0.0F;

                if (targetEntity instanceof EntityLivingBase)
                {
                    f1 = EnchantmentHelper.getModifierForCreature(player.getHeldItemOffhand(), ((EntityLivingBase)targetEntity).getCreatureAttribute());
                }
                else
                {
                    f1 = EnchantmentHelper.getModifierForCreature(player.getHeldItemOffhand(), EnumCreatureAttribute.UNDEFINED);
                }
                //TODO Cooldown on off hand
                //float f2 = player.getCooledAttackStrength(0.5F);
                float f2 = MathHelper.clamp_float((float) (((float)20 + 0.5) / player.getCooldownPeriod()), 0.0F, 1.0F);
                attackDamage = attackDamage * (0.2F + f2 * f2 * 0.8F);
                f1 = f1 * f2;
                player.resetCooldown();

                if (attackDamage > 0.0F || f1 > 0.0F)
                {
                    boolean flag = f2 > 0.9F;
                    boolean flag1 = false;
                    boolean flag2 = false;
                    boolean flag3 = false;
                    int i = 0;
                    i = i + EnchantmentHelper.getKnockbackModifier(player);

                    if (player.isSprinting() && flag)
                    {
                        player.worldObj.playSound((EntityPlayer)null, player.posX, player.posY, player.posZ, SoundEvents.ENTITY_PLAYER_ATTACK_KNOCKBACK, player.getSoundCategory(), 1.0F, 1.0F);
                        ++i;
                        flag1 = true;
                    }

                    flag2 = flag && player.fallDistance > 0.0F && !player.onGround && !player.isOnLadder() && !player.isInWater() && !player.isPotionActive(MobEffects.BLINDNESS) && !player.isRiding() && targetEntity instanceof EntityLivingBase;
                    flag2 = flag2 && !player.isSprinting();

                    if (flag2)
                    {
                        attackDamage *= 1.5F;
                    }

                    attackDamage = attackDamage + f1;
                    double d0 = (double)(player.distanceWalkedModified - player.prevDistanceWalkedModified);

                    if (flag && !flag2 && !flag1 && player.onGround && d0 < (double)player.getAIMoveSpeed())
                    {
                        ItemStack itemstack = player.getHeldItem(EnumHand.OFF_HAND);
                                                
                        if (itemstack != null && itemstack.getItem() instanceof ItemSword)
                        {
                            flag3 = true;
                        }
                    }

                    float f4 = 0.0F;
                    boolean flag4 = false;
                    int j = EnchantmentHelper.getFireAspectModifier(player);

                    if (targetEntity instanceof EntityLivingBase)
                    {
                        f4 = ((EntityLivingBase)targetEntity).getHealth();

                        if (j > 0 && !targetEntity.isBurning())
                        {
                            flag4 = true;
                            targetEntity.setFire(1);
                        }
                    }

                    if (player.getHeldItemOffhand() != null) {
                        if (player.getHeldItemOffhand().getItem() instanceof ItemKeyblade) {
                            attackDamage = (float)(player.getCapability(ModCapabilities.PLAYER_STATS, null).getStrength() + ((ItemKeyblade)player.getHeldItemOffhand().getItem()).getStrength());
                        }
                    }
                    double d1 = targetEntity.motionX;
                    double d2 = targetEntity.motionY;
                    double d3 = targetEntity.motionZ;
                    boolean flag5 = targetEntity.attackEntityFrom(DamageSource.causePlayerDamage(player), attackDamage);

                    if (flag5)
                    {
                        if (i > 0)
                        {
                            if (targetEntity instanceof EntityLivingBase)
                            {
                                ((EntityLivingBase)targetEntity).knockBack(player, (float)i * 0.5F, (double)MathHelper.sin(player.rotationYaw * 0.017453292F), (double)(-MathHelper.cos(player.rotationYaw * 0.017453292F)));
                            }
                            else
                            {
                                targetEntity.addVelocity((double)(-MathHelper.sin(player.rotationYaw * 0.017453292F) * (float)i * 0.5F), 0.1D, (double)(MathHelper.cos(player.rotationYaw * 0.017453292F) * (float)i * 0.5F));
                            }

                            player.motionX *= 0.6D;
                            player.motionZ *= 0.6D;
                            player.setSprinting(false);
                        }

                        if (flag3)
                        {
                            for (EntityLivingBase entitylivingbase : player.worldObj.getEntitiesWithinAABB(EntityLivingBase.class, targetEntity.getEntityBoundingBox().expand(1.0D, 0.25D, 1.0D)))
                            {
                                if (entitylivingbase != player && entitylivingbase != targetEntity && !player.isOnSameTeam(entitylivingbase) && player.getDistanceSqToEntity(entitylivingbase) < 9.0D)
                                {
                                    entitylivingbase.knockBack(player, 0.4F, (double)MathHelper.sin(player.rotationYaw * 0.017453292F), (double)(-MathHelper.cos(player.rotationYaw * 0.017453292F)));
                                    entitylivingbase.attackEntityFrom(DamageSource.causePlayerDamage(player), attackDamage);
                                }
                            }

                            player.worldObj.playSound((EntityPlayer)null, player.posX, player.posY, player.posZ, SoundEvents.ENTITY_PLAYER_ATTACK_SWEEP, player.getSoundCategory(), 1.0F, 1.0F);
                            player.spawnSweepParticles();
                        }

                        if (targetEntity instanceof EntityPlayerMP && targetEntity.velocityChanged)
                        {
                            ((EntityPlayerMP)targetEntity).connection.sendPacket(new SPacketEntityVelocity(targetEntity));
                            targetEntity.velocityChanged = false;
                            targetEntity.motionX = d1;
                            targetEntity.motionY = d2;
                            targetEntity.motionZ = d3;
                        }

                        if (flag2)
                        {
                            player.worldObj.playSound((EntityPlayer)null, player.posX, player.posY, player.posZ, SoundEvents.ENTITY_PLAYER_ATTACK_CRIT, player.getSoundCategory(), 1.0F, 1.0F);
                            player.onCriticalHit(targetEntity);
                        }

                        if (!flag2 && !flag3)
                        {
                            if (flag)
                            {
                                player.worldObj.playSound((EntityPlayer)null, player.posX, player.posY, player.posZ, SoundEvents.ENTITY_PLAYER_ATTACK_STRONG, player.getSoundCategory(), 1.0F, 1.0F);
                            }
                            else
                            {
                                player.worldObj.playSound((EntityPlayer)null, player.posX, player.posY, player.posZ, SoundEvents.ENTITY_PLAYER_ATTACK_WEAK, player.getSoundCategory(), 1.0F, 1.0F);
                            }
                        }

                        if (f1 > 0.0F)
                        {
                            player.onEnchantmentCritical(targetEntity);
                        }

                        if (!player.worldObj.isRemote && targetEntity instanceof EntityPlayer)
                        {
                            EntityPlayer entityplayer = (EntityPlayer)targetEntity;
                            ItemStack itemstack2 = player.getHeldItemOffhand();
                            ItemStack itemstack3 = entityplayer.isHandActive() ? entityplayer.getActiveItemStack() : null;

                            if (itemstack2 != null && itemstack3 != null && itemstack2.getItem() instanceof ItemAxe && itemstack3.getItem() == Items.SHIELD)
                            {
                                float f3 = 0.25F + (float)EnchantmentHelper.getEfficiencyModifier(player) * 0.05F;

                                if (flag1)
                                {
                                    f3 += 0.75F;
                                }

                                if (rand.nextFloat() < f3)
                                {
                                    entityplayer.getCooldownTracker().setCooldown(Items.SHIELD, 100);
                                    player.worldObj.setEntityState(entityplayer, (byte)30);
                                }
                            }
                        }

                        if (attackDamage >= 18.0F)
                        {
                            player.addStat(AchievementList.OVERKILL);
                        }

                        player.setLastAttacker(targetEntity);

                        if (targetEntity instanceof EntityLivingBase)
                        {
                            EnchantmentHelper.applyThornEnchantments((EntityLivingBase)targetEntity, player);
                        }

                        EnchantmentHelper.applyArthropodEnchantments(player, targetEntity);
                        ItemStack itemstack1 = player.getHeldItemOffhand();
                        Entity entity = targetEntity;

                        if (targetEntity instanceof EntityDragonPart)
                        {
                            IEntityMultiPart ientitymultipart = ((EntityDragonPart)targetEntity).entityDragonObj;

                            if (ientitymultipart instanceof EntityLivingBase)
                            {
                                entity = (EntityLivingBase)ientitymultipart;
                            }
                        }

                        if (itemstack1 != null && entity instanceof EntityLivingBase)
                        {
                            itemstack1.hitEntity((EntityLivingBase)entity, player);

                            if (itemstack1.stackSize <= 0)
                            {
                                player.setHeldItem(EnumHand.OFF_HAND, (ItemStack)null);
                            }
                        }

                        if (targetEntity instanceof EntityLivingBase)
                        {
                            float f5 = f4 - ((EntityLivingBase)targetEntity).getHealth();
                            player.addStat(StatList.DAMAGE_DEALT, Math.round(f5 * 10.0F));

                            if (j > 0)
                            {
                                targetEntity.setFire(j * 4);
                            }

                            if (player.worldObj instanceof WorldServer && f5 > 2.0F)
                            {
                                int k = (int)((double)f5 * 0.5D);
                                ((WorldServer)player.worldObj).spawnParticle(EnumParticleTypes.DAMAGE_INDICATOR, targetEntity.posX, targetEntity.posY + (double)(targetEntity.height * 0.5F), targetEntity.posZ, k, 0.1D, 0.0D, 0.1D, 0.2D, new int[0]);
                            }
                        }

                        player.addExhaustion(0.3F);
                    }
                    else
                    {
                        player.worldObj.playSound((EntityPlayer)null, player.posX, player.posY, player.posZ, SoundEvents.ENTITY_PLAYER_ATTACK_NODAMAGE, player.getSoundCategory(), 1.0F, 1.0F);

                        if (flag4)
                        {
                            targetEntity.extinguish();
                        }
                    }
                }
            }
        }
    }

}
