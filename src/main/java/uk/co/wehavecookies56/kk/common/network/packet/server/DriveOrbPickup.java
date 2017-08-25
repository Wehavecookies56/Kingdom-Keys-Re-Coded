package uk.co.wehavecookies56.kk.common.network.packet.server;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.ItemStack;
import net.minecraft.network.PacketBuffer;
import net.minecraftforge.fml.relauncher.Side;
import uk.co.wehavecookies56.kk.common.capability.ModCapabilities;
import uk.co.wehavecookies56.kk.common.network.packet.AbstractMessage;
import uk.co.wehavecookies56.kk.common.network.packet.PacketDispatcher;
import uk.co.wehavecookies56.kk.common.network.packet.client.SyncDriveData;

import java.io.IOException;

public class DriveOrbPickup extends AbstractMessage.AbstractServerMessage<DriveOrbPickup> {

    public DriveOrbPickup () {}

    ItemStack toRemove;

    public DriveOrbPickup (ItemStack toRemove) {
        this.toRemove = toRemove;
    }

    @Override
    protected void read (PacketBuffer buffer) throws IOException {
        toRemove = buffer.readItemStack();
    }

    @Override
    protected void write (PacketBuffer buffer) throws IOException {
        buffer.writeItemStack(toRemove);
    }

    @Override
    public void process (EntityPlayer player, Side side) {
        toRemove.setCount(toRemove.getCount()-1);
        player.getCapability(ModCapabilities.DRIVE_STATE, null).addDP(toRemove.getTagCompound().getInteger("amount"));
        PacketDispatcher.sendTo(new SyncDriveData(player.getCapability(ModCapabilities.DRIVE_STATE, null)), (EntityPlayerMP) player);
    }

}
