package uk.co.wehavecookies56.kk.common.network.packet.server;

import java.io.IOException;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.network.PacketBuffer;
import net.minecraftforge.fml.relauncher.Side;
import uk.co.wehavecookies56.kk.common.container.inventory.InventorySynthesisBagL;
import uk.co.wehavecookies56.kk.common.item.ModItems;
import uk.co.wehavecookies56.kk.common.network.packet.AbstractMessage.AbstractServerMessage;

public class SynthesisMaterialPickup extends AbstractServerMessage<SynthesisMaterialPickup> {

	public SynthesisMaterialPickup () {}

	ItemStack toRemove;
	ItemStack bag;
	int slot;

	public SynthesisMaterialPickup (ItemStack toRemove, ItemStack bag, int slot) {
		this.toRemove = toRemove;
		this.bag = bag;
		this.slot = slot;
	}

	@Override
	protected void read (PacketBuffer buffer) throws IOException {
		toRemove = buffer.readItemStackFromBuffer();
		bag = buffer.readItemStackFromBuffer();
		slot = buffer.readInt();
	}

	@Override
	protected void write (PacketBuffer buffer) throws IOException {
		buffer.writeItemStackToBuffer(toRemove);
		buffer.writeItemStackToBuffer(bag);
		buffer.writeInt(slot);
	}

	@Override
	public void process (EntityPlayer player, Side side) {
		//player.inventory.consumeInventoryItem(toRemove.getItem());
		toRemove.stackSize--;
		if (bag.getItem().equals(ModItems.SynthesisBagL)) {
			InventorySynthesisBagL bagL = new InventorySynthesisBagL(bag);
			for (int i = 0; i < bagL.getSizeInventory(); i++)
				if (bagL.getStackInSlot(i) == null) {
					bagL.setInventorySlotContents(0, toRemove);
					bagL.markDirty();
					break;
				}
		}

	}

}
