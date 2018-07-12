package uk.co.wehavecookies56.kk.common.entity;

import io.netty.buffer.ByteBuf;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.ByteBufUtils;
import net.minecraftforge.fml.common.registry.IEntityAdditionalSpawnData;

public class EntityXPGet extends Entity implements IEntityAdditionalSpawnData{
	public final static int MAX_TICKS = 30;
	public static int entityID;
	public static String playerName;
	
	public EntityXPGet(World worldIn, EntityPlayer player, EntityLivingBase entity){
        super(worldIn);
        this.setSize(0.5F, 1);
        this.playerName = player.getDisplayNameString();
        this.entityID = entity.getEntityId();
    }
	
	public EntityXPGet(World worldIn){
        super(worldIn);
        this.setSize(0.5F, 1);
    }
 
	public void onUpdate(){
				
		if(this.ticksExisted >= MAX_TICKS) {
			this.setDead();
		}
		
		super.onUpdate();
	}

	protected void entityInit()  {}

	protected void readEntityFromNBT(NBTTagCompound compound) {}

	protected void writeEntityToNBT(NBTTagCompound compound) {}

	 @Override
	    public void readSpawnData(ByteBuf additionalData) {
	    	playerName = ByteBufUtils.readUTF8String(additionalData);
	    	entityID = additionalData.readInt();
	    }

	    @Override
	    public void writeSpawnData(ByteBuf buffer) {
	    	if(playerName == null)
	            return;
	    	
	    	ByteBufUtils.writeUTF8String(buffer, playerName);    
	    	buffer.writeInt(entityID);
	    }
	
}
