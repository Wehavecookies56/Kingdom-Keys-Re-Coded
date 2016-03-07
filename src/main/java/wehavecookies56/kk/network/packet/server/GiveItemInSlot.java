package wehavecookies56.kk.network.packet.server;

import java.io.IOException;

import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.network.PacketBuffer;
import net.minecraftforge.fml.relauncher.Side;
import wehavecookies56.kk.network.packet.AbstractMessage;
import wehavecookies56.kk.network.packet.PacketDispatcher;

public class GiveItemInSlot extends AbstractMessage<GiveItemInSlot> {
	//String player;
	ItemStack itemstack;
	int slot;
	double x,y,z;
	public GiveItemInSlot () {}

	public GiveItemInSlot (ItemStack itemstack, int slot) 
	{
		//this.player = player;
		this.itemstack = itemstack;
		this.slot = slot;
		this.x = 0;
		this.y = 0;
		this.z = 0;
	}
	
	public GiveItemInSlot (ItemStack itemstack, int slot, double x, double y, double z) 
	{
		//this.player = player;
		this.itemstack = itemstack;
		this.slot = slot;
		this.x = x;
		this.y = y;
		this.z = z;
	}
	@Override
	protected void read (PacketBuffer buffer) throws IOException {
		//player = buffer.readStringFromBuffer(40);
		itemstack = buffer.readItemStackFromBuffer();
		slot = buffer.readInt();
		x = buffer.readDouble();
		y = buffer.readDouble();
		z = buffer.readDouble();
	}

	@Override
	protected void write (PacketBuffer buffer) throws IOException {
		//buffer.writeString(player);
		buffer.writeItemStackToBuffer(itemstack);
		buffer.writeInt(slot);
		buffer.writeDouble(x);
		buffer.writeDouble(y);
		buffer.writeDouble(z);
	}

	@Override
	public void process (EntityPlayer player, Side side) 
	{
		if(!player.worldObj.isRemote){
			if(slot >= 0){
				player.inventory.setInventorySlotContents(slot, itemstack);
			} else {
				player.worldObj.spawnEntityInWorld(new EntityItem(player.worldObj, x, y, z, itemstack));
			}
		}
	}
}
