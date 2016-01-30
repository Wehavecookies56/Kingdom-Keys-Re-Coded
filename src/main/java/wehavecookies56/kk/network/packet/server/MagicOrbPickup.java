package wehavecookies56.kk.network.packet.server;

import java.io.IOException;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.network.PacketBuffer;
import net.minecraftforge.fml.relauncher.Side;
import wehavecookies56.kk.entities.ExtendedPlayer;
import wehavecookies56.kk.network.packet.AbstractMessage.AbstractServerMessage;

public class MagicOrbPickup extends AbstractServerMessage<MagicOrbPickup> {

	public MagicOrbPickup () {}

	ItemStack toRemove;

	public MagicOrbPickup (ItemStack toRemove) {
		this.toRemove = toRemove;
	}

	@Override
	protected void read (PacketBuffer buffer) throws IOException {
		toRemove = buffer.readItemStackFromBuffer();
	}

	@Override
	protected void write (PacketBuffer buffer) throws IOException {
		buffer.writeItemStackToBuffer(toRemove);
	}

	@Override
	public void process (EntityPlayer player, Side side) {
		player.inventory.consumeInventoryItem(toRemove.getItem());
		toRemove.stackSize--;
		ExtendedPlayer.get(player).addMp(toRemove.getTagCompound().getInteger("amount"));
	}

}
