package uk.co.wehavecookies56.kk.common.network.packet.client;

import java.io.IOException;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.PacketBuffer;
import net.minecraftforge.fml.relauncher.Side;
import uk.co.wehavecookies56.kk.common.capability.MagicStateCapability.IMagicState;
import uk.co.wehavecookies56.kk.common.capability.ModCapabilities;
import uk.co.wehavecookies56.kk.common.container.inventory.InventorySpells;
import uk.co.wehavecookies56.kk.common.network.packet.AbstractMessage.AbstractClientMessage;

public class SyncMagicInventory extends AbstractClientMessage<SyncMagicInventory> {

	private NBTTagCompound data;
	
	public SyncMagicInventory() {}
	
	public SyncMagicInventory(IMagicState stats) {
		data = new NBTTagCompound();
		data.setTag(InventorySpells.SAVE_KEY, stats.getInventorySpells().serializeNBT());
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
		player.getCapability(ModCapabilities.MAGIC_STATE, null).getInventorySpells().deserializeNBT(data.getCompoundTag(InventorySpells.SAVE_KEY));
	}


}
