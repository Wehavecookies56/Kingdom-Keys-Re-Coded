package uk.co.wehavecookies56.kk.common.network.packet.client;

import java.io.IOException;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.PacketBuffer;
import net.minecraftforge.fml.relauncher.Side;
import uk.co.wehavecookies56.kk.common.capability.DriveStateCapability.IDriveState;
import uk.co.wehavecookies56.kk.common.capability.ModCapabilities;
import uk.co.wehavecookies56.kk.common.container.inventory.InventoryDriveForms;
import uk.co.wehavecookies56.kk.common.network.packet.AbstractMessage.AbstractClientMessage;

public class SyncDriveInventory extends AbstractClientMessage<SyncDriveInventory> {

    private NBTTagCompound data;

    public SyncDriveInventory() {}

    public SyncDriveInventory(IDriveState stats) {
        data = new NBTTagCompound();
        data.setTag(InventoryDriveForms.SAVE_KEY, stats.getInventoryDriveForms().serializeNBT());
    }

    @Override
    protected void read(PacketBuffer buffer) throws IOException {
        data = buffer.readCompoundTag();
    }

    @Override
    protected void write(PacketBuffer buffer) throws IOException {
        buffer.writeCompoundTag(data);
    }

    @Override
    public void process(EntityPlayer player, Side side) {
        player.getCapability(ModCapabilities.DRIVE_STATE, null).getInventoryDriveForms().deserializeNBT(data.getCompoundTag(InventoryDriveForms.SAVE_KEY));
    }


}
