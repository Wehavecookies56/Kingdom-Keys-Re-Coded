package uk.co.wehavecookies56.kk.common.network.packet.server;

import java.io.IOException;

import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.network.PacketBuffer;
import net.minecraftforge.fml.relauncher.Side;
import uk.co.wehavecookies56.kk.common.network.packet.AbstractMessage;

public class GiveItemInSlot extends AbstractMessage<GiveItemInSlot> {
    ItemStack itemstack;
    int slot;
    double x,y,z;
    boolean alreadyHasItem = false;
    public GiveItemInSlot () {}

    public GiveItemInSlot (ItemStack itemstack, int slot, boolean alreadyHasItem)
    {
        this.itemstack = itemstack;
        this.slot = slot;
        this.x = 0;
        this.y = 0;
        this.z = 0;
        this.alreadyHasItem = alreadyHasItem;
    }

    public GiveItemInSlot (ItemStack itemstack, int slot, double x, double y, double z)
    {
        this.itemstack = itemstack;
        this.slot = slot;
        this.x = x;
        this.y = y;
        this.z = z;
        this.alreadyHasItem = false;
    }
    @Override
    protected void read (PacketBuffer buffer) throws IOException {
        itemstack = buffer.readItemStack();
        slot = buffer.readInt();
        x = buffer.readDouble();
        y = buffer.readDouble();
        z = buffer.readDouble();
        alreadyHasItem = buffer.readBoolean();
    }

    @Override
    protected void write (PacketBuffer buffer) throws IOException {
        buffer.writeItemStack(itemstack);
        buffer.writeInt(slot);
        buffer.writeDouble(x);
        buffer.writeDouble(y);
        buffer.writeDouble(z);
        buffer.writeBoolean(alreadyHasItem);
    }

    @Override
    public void process (EntityPlayer player, Side side)
    {
        if(alreadyHasItem)
        {
            player.inventory.addItemStackToInventory(itemstack);
        }
        else{
            if(slot >= 0){
                player.inventory.setInventorySlotContents(slot, itemstack);
            } else {
                player.world.spawnEntity(new EntityItem(player.world, x, y, z, itemstack));
            }
        }

    }
}
