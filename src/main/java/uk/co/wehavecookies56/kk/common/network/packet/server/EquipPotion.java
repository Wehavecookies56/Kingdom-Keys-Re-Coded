package uk.co.wehavecookies56.kk.common.network.packet.server;

import java.io.IOException;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.ItemStack;
import net.minecraft.network.PacketBuffer;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.items.ItemStackHandler;
import uk.co.wehavecookies56.kk.api.abilities.AbilityEvent;
import uk.co.wehavecookies56.kk.common.capability.ModCapabilities;
import uk.co.wehavecookies56.kk.common.item.base.ItemKKPotion;
import uk.co.wehavecookies56.kk.common.item.base.ItemKeychain;
import uk.co.wehavecookies56.kk.common.item.base.ItemRealKeyblade;
import uk.co.wehavecookies56.kk.common.network.packet.AbstractMessage;
import uk.co.wehavecookies56.kk.common.network.packet.PacketDispatcher;
import uk.co.wehavecookies56.kk.common.network.packet.client.OpenPlayerItemsGUI;
import uk.co.wehavecookies56.kk.common.network.packet.client.SyncItemsInventory;
import uk.co.wehavecookies56.kk.common.network.packet.client.SyncKeybladeData;
import uk.co.wehavecookies56.kk.common.network.packet.client.SyncLevelData;

public class EquipPotion extends AbstractMessage.AbstractServerMessage<EquipPotion> {

	ItemStack potion;
	int slot, potionSlot;

	public EquipPotion() {
	}

	public EquipPotion(ItemStack potion, int slot, int potionSlot) {
		this.potion = potion;
		this.slot = slot;
		this.potionSlot = potionSlot;
	}

	@Override
	protected void read(PacketBuffer buffer) throws IOException {
		potion = buffer.readItemStack();
		slot = buffer.readInt();
		potionSlot = buffer.readInt();
	}

	@Override
	protected void write(PacketBuffer buffer) throws IOException {
		buffer.writeItemStack(potion);
		buffer.writeInt(slot);
		buffer.writeInt(potionSlot);
	}

	@Override
	public void process(EntityPlayer player, Side side) {
		ItemStackHandler potionInv = player.getCapability(ModCapabilities.PLAYER_STATS, null).getInventoryPotionsMenu();
		ItemStack itemToInv = potionInv.getStackInSlot(potionSlot);
		ItemStack currentToInv = itemToInv.copy();
		ItemStack itemToEquip = potion.copy();

		System.out.println("From equipped to inv: " + itemToInv.getCount());
		System.out.println("From inv going to equip: " + itemToEquip.getCount());

		if (itemToInv.getCount() == 0) { // Equipping item in empty slot
			potionInv.setStackInSlot(potionSlot, new ItemStack(itemToEquip.getItem(), 1));
			player.inventory.setInventorySlotContents(slot, new ItemStack(potion.getItem(), potion.getCount() - 1));
		} else if (itemToInv.getCount() > 0) {
			potionInv.setStackInSlot(potionSlot, new ItemStack(itemToEquip.getItem(), 1));
			player.inventory.setInventorySlotContents(slot, new ItemStack(potion.getItem(), potion.getCount() - 1));
			returnItemToInv(player,itemToInv);
		}
		
		PacketDispatcher.sendTo(new SyncItemsInventory(player.getCapability(ModCapabilities.PLAYER_STATS, null)), (EntityPlayerMP) player);
		PacketDispatcher.sendTo(new OpenPlayerItemsGUI(), (EntityPlayerMP) player);
	}

	private void returnItemToInv(EntityPlayer player, ItemStack item) {
		if (player.inventory.hasItemStack(item)) { // Return the slot where the item is
			int itemSlot; //Get the Slot where the item is
			for (itemSlot = 0; itemSlot < player.inventory.getSizeInventory(); itemSlot++) {
				if (ItemStack.areItemsEqual(player.inventory.getStackInSlot(itemSlot), item)) {
					break;
				}
			}
			player.inventory.setInventorySlotContents(itemSlot, new ItemStack(item.getItem(),item.getCount()+1)); //Set a new itemstack with the same item +1 amount
		} else {
			int emptySlot;
			for (emptySlot = 0; emptySlot < player.inventory.getSizeInventory(); emptySlot++) {
				if (ItemStack.areItemsEqual(player.inventory.getStackInSlot(emptySlot), ItemStack.EMPTY)) {
					break;
				}
			}
			player.inventory.setInventorySlotContents(emptySlot, item);

		}
	}

}
