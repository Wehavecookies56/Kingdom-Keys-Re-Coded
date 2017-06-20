package uk.co.wehavecookies56.kk.common.network.packet.server;

import java.io.IOException;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.network.PacketBuffer;
import net.minecraftforge.fml.relauncher.Side;
import uk.co.wehavecookies56.kk.common.capability.ModCapabilities;
import uk.co.wehavecookies56.kk.common.network.packet.AbstractMessage.AbstractServerMessage;

public class MagicOrbPickup extends AbstractServerMessage<MagicOrbPickup> {

	public MagicOrbPickup () {}

	ItemStack toRemove;

	public MagicOrbPickup (ItemStack toRemove) {
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
		//player.inventory.consumeInventoryItem(toRemove.getItem());
		toRemove.setCount(toRemove.getCount()-1);
		player.getCapability(ModCapabilities.PLAYER_STATS, null).addMP(toRemove.getTagCompound().getInteger("amount"));
	}

}
