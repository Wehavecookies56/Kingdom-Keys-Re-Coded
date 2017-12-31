package uk.co.wehavecookies56.kk.common.entity.magic;

import java.nio.charset.Charset;

import io.netty.buffer.ByteBuf;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.IEntityAdditionalSpawnData;
import uk.co.wehavecookies56.kk.common.capability.ModCapabilities;
import uk.co.wehavecookies56.kk.common.capability.OrganizationXIIICapability.IOrganizationXIII;
import uk.co.wehavecookies56.kk.common.network.packet.PacketDispatcher;
import uk.co.wehavecookies56.kk.common.network.packet.client.SpawnPortalParticles;
import uk.co.wehavecookies56.kk.common.network.packet.server.OrgPortalTP;

public class EntityOrgPortal extends Entity implements IEntityAdditionalSpawnData {

    //EntityPlayer caster;
    BlockPos destinationPos;
    int destinationDim;
    boolean shouldTeleport;

    public EntityOrgPortal (World world) {
        super(world);
    }

    public EntityOrgPortal (World world, EntityPlayer sender, BlockPos spawnPos, BlockPos destinationPos, int destinationDim, boolean shouldTP) {
        super(world);
        this.posX = spawnPos.getX()+0.5;
        this.posY = spawnPos.getY();
        this.posZ = spawnPos.getZ()+0.5;
        this.destinationPos = destinationPos;
        this.destinationDim = destinationDim;
        this.shouldTeleport = shouldTP;
    }
    
    
    @Override
    public void onUpdate () {
        super.onUpdate();

        if (!world.isRemote)
            PacketDispatcher.sendToAll(new SpawnPortalParticles(this.getPosition()));
        
        if (ticksExisted > 100) 
        	setDead();
    }

    @Override
    protected void entityInit() {
        // TODO Auto-generated method stub

    }

    @Override
    public void onCollideWithPlayer(EntityPlayer player) {
        if(shouldTeleport) {
	        if(!this.isEntityAlive())
	            return;
	        if(player != null){
	            if (destinationPos != null) {
	                if(destinationPos.getX()!=0 && destinationPos.getY()!=0 && destinationPos.getZ()!=0){
	                    PacketDispatcher.sendToServer(new OrgPortalTP(this.destinationDim,destinationPos.getX()+0.5, destinationPos.getY()+1, destinationPos.getZ()+0.5));
	                }
	            }
	        }
        }

        super.onCollideWithPlayer(player);
    }

    @Override
    protected void writeEntityToNBT(NBTTagCompound compound) {

    }

    @Override
    protected void readEntityFromNBT(NBTTagCompound compound) {

    }

    @Override
    public void readFromNBT(NBTTagCompound compound) {
        super.readFromNBT(compound);
    }

    @Override
    public NBTTagCompound writeToNBT(NBTTagCompound compound) {
        return super.writeToNBT(compound);
    }

    @Override
    public void readSpawnData(ByteBuf additionalData) {
    	destinationPos = new BlockPos(additionalData.readInt(),additionalData.readInt(),additionalData.readInt());
    	destinationDim = additionalData.readInt();
    	shouldTeleport = additionalData.readBoolean();
    }

    @Override
    public void writeSpawnData(ByteBuf buffer) {
    	if(destinationPos == null)
            return;
    	
        buffer.writeInt(destinationPos.getX());
        buffer.writeInt(destinationPos.getY());
        buffer.writeInt(destinationPos.getZ());
        buffer.writeInt(destinationDim);
        buffer.writeBoolean(shouldTeleport);
    }
}
