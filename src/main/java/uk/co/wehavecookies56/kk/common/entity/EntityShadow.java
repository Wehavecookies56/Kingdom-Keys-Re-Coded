package uk.co.wehavecookies56.kk.common.entity;

import net.minecraft.block.Block;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAttackMelee;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIMoveTowardsRestriction;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import uk.co.wehavecookies56.kk.client.sound.ModSounds;

public class EntityShadow extends EntityMob {

	public EntityShadow(World par1World) {
		super(par1World);
		tasks.addTask(2, new EntityAIAttackMelee(this, 0.35D, true));
		tasks.addTask(4, new EntityAIMoveTowardsRestriction(this, 0.35D));
		tasks.addTask(5, new EntityAIWander(this, 0.35D));
		tasks.addTask(6, new EntityAILookIdle(this));
		tasks.addTask(6, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
		targetTasks.addTask(1, new EntityAIHurtByTarget(this, true));
	}

	@Override
	protected void applyEntityAttributes() {
		super.applyEntityAttributes();
		getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(4.0D);
	}

	@Override
	protected SoundEvent getAmbientSound()
	{//TODO SOUND
		return ModSounds.unsummon;
	}

	@Override
	protected SoundEvent getHurtSound()
	{
		return ModSounds.unsummon;
	}

	@Override
	protected SoundEvent getDeathSound()
	{
		return ModSounds.unsummon;
	}

	@Override
	public void onDeath(DamageSource par1DamageSource) {
		//DROP
		super.onDeath(par1DamageSource);
	}

	@Override
	protected void playStepSound(BlockPos pos, Block par4)
	{
		playSound(ModSounds.unsummon, 0.15F, 1.0F);
	}
}
