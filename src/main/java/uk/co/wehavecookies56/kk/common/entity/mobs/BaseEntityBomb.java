package uk.co.wehavecookies56.kk.common.entity.mobs;

import io.netty.buffer.ByteBuf;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.ai.EntityAIAttackMelee;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIMoveTowardsRestriction;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.IEntityAdditionalSpawnData;
import uk.co.wehavecookies56.kk.common.core.helper.EntityHelper.MobType;
import uk.co.wehavecookies56.kk.common.entity.mobs.ai.EntityAIMinuteBomb;

public class BaseEntityBomb extends BaseEntityHeartless implements IKHMob, IEntityAdditionalSpawnData{

	public int ticksToExplode;
	
	public BaseEntityBomb(World worldIn) {
		super(worldIn);
		this.ticksToExplode = 100;
		
		this.tasks.addTask(1, new EntityAIAttackMelee(this, 1.0D, true));
        this.tasks.addTask(5, new EntityAIMoveTowardsRestriction(this, 1.0D));
        this.tasks.addTask(7, new EntityAIWander(this, 1.0D));
        this.tasks.addTask(8, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
        this.tasks.addTask(8, new EntityAILookIdle(this));
        this.targetTasks.addTask(1, new EntityAINearestAttackableTarget(this, EntityPlayer.class, true));
        this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityAgeable.class, true));
        this.targetTasks.addTask(3, new EntityAINearestAttackableTarget(this, EntityAnimal.class, true));
        this.targetTasks.addTask(4, new EntityAIMinuteBomb(this));
	}
	
	 @Override
	public void onLivingUpdate() {

		super.onLivingUpdate();
	}

	@Override
	public MobType getType() {
		return MobType.HEARTLESS_EMBLEM;
	}

	@Override
	public void writeSpawnData(ByteBuf buffer) {
		buffer.writeInt(ticksToExplode);
		
	}

	@Override
	public void readSpawnData(ByteBuf additionalData) {
		ticksToExplode = additionalData.readInt();
		
	}

}
