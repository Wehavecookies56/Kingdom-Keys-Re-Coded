package uk.co.wehavecookies56.kk.common.network.packet.client;

import java.io.IOException;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.PacketBuffer;
import net.minecraftforge.fml.relauncher.Side;
import uk.co.wehavecookies56.kk.common.capability.ModCapabilities;
import uk.co.wehavecookies56.kk.common.capability.PlayerStatsCapability;
import uk.co.wehavecookies56.kk.common.network.packet.AbstractMessage;

public class SyncItemsInventory extends AbstractMessage.AbstractClientMessage<SyncItemsInventory> {

	private NBTTagCompound data;
	
	public SyncItemsInventory() {}
	
	public SyncItemsInventory(PlayerStatsCapability.IPlayerStats stats) {
		data = new NBTTagCompound();
		stats.getInventoryPotionsMenu().writeToNBT(data);
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
		player.getCapability(ModCapabilities.PLAYER_STATS, null).getInventoryPotionsMenu().readFromNBT(data);
	}


}
