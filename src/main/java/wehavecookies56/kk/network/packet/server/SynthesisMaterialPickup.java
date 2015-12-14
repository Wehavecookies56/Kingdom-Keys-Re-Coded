package wehavecookies56.kk.network.packet.server;

import java.io.IOException;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.network.PacketBuffer;
import net.minecraftforge.fml.relauncher.Side;
import wehavecookies56.kk.achievements.ModAchievements;
import wehavecookies56.kk.entities.ExtendedPlayer;
import wehavecookies56.kk.inventory.InventorySynthesisBagL;
import wehavecookies56.kk.item.ModItems;
import wehavecookies56.kk.network.packet.AbstractMessage;
import wehavecookies56.kk.network.packet.AbstractMessage.AbstractClientMessage;
import wehavecookies56.kk.network.packet.AbstractMessage.AbstractServerMessage;
import wehavecookies56.kk.util.AchievementHelper;

public class SynthesisMaterialPickup extends AbstractServerMessage<SynthesisMaterialPickup> {

	public SynthesisMaterialPickup() {}

	ItemStack toRemove;
	ItemStack bag;
	int slot;

	public SynthesisMaterialPickup(ItemStack toRemove, ItemStack bag, int slot){
		this.toRemove = toRemove;
		this.bag = bag;
		this.slot = slot;
	}

	@Override
	protected void read(PacketBuffer buffer) throws IOException {
		toRemove = buffer.readItemStackFromBuffer();
		bag = buffer.readItemStackFromBuffer();
		slot = buffer.readInt();
	}

	@Override
	protected void write(PacketBuffer buffer) throws IOException {
		buffer.writeItemStackToBuffer(toRemove);
		buffer.writeItemStackToBuffer(bag);
		buffer.writeInt(slot);
	}

	@Override
	public void process(EntityPlayer player, Side side) {
		System.out.println("Ok");
		player.inventory.consumeInventoryItem(toRemove.getItem());
		if(bag.getItem().equals(ModItems.SynthesisBagL)){
			InventorySynthesisBagL bagL = new InventorySynthesisBagL(bag);
			for (int i = 0; i < bagL.getSizeInventory(); i++){
				if(bagL.getStackInSlot(i) == null){
					System.out.println(i);
					bagL.setInventorySlotContents(0, toRemove);
					System.out.println(bagL.getStackInSlot(0));
					bagL.markDirty();
					break;
				}
			}
		}
		
	}

}
