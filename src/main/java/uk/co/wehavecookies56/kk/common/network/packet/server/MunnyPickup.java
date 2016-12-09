package uk.co.wehavecookies56.kk.common.network.packet.server;

import java.io.IOException;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.network.PacketBuffer;
import net.minecraftforge.fml.relauncher.Side;
import uk.co.wehavecookies56.kk.common.capability.ModCapabilities;
import uk.co.wehavecookies56.kk.common.capability.MunnyCapability.IMunny;
import uk.co.wehavecookies56.kk.common.network.packet.AbstractMessage.AbstractServerMessage;

public class MunnyPickup extends AbstractServerMessage<MunnyPickup> {

	public MunnyPickup () {}

	ItemStack toRemove;

	public MunnyPickup (ItemStack toRemove) {
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
		toRemove.stackSize--;
		IMunny munny = player.getCapability(ModCapabilities.MUNNY, null);
		munny.addMunny(toRemove.getTagCompound().getInteger("amount"));
	}

}
