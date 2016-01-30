package wehavecookies56.kk.network.packet.server;

import java.io.IOException;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.network.PacketBuffer;
import net.minecraftforge.fml.relauncher.Side;
import wehavecookies56.kk.entities.ExtendedPlayer;
import wehavecookies56.kk.inventory.InventoryKeychain;
import wehavecookies56.kk.inventory.InventoryPotionsMenu;
import wehavecookies56.kk.network.packet.AbstractMessage.AbstractServerMessage;
import wehavecookies56.kk.util.SoundHelper;

public class RemoveItemInSlot extends AbstractServerMessage<RemoveItemInSlot> {
	String inv;
	int slot;
	InventoryPotionsMenu potions;
	InventoryKeychain keychain;
	boolean sound;

	public RemoveItemInSlot() {
	}

	public RemoveItemInSlot(String inventory, int slot) {
		this.inv = inventory;
		this.slot = slot;
		this.sound = false;
	}

	public RemoveItemInSlot(String inventory, int slot, boolean sound) {
		this.inv = inventory;
		this.slot = slot;
		this.sound = sound;
	}

	@Override
	protected void read(PacketBuffer buffer) throws IOException {
		inv = buffer.readStringFromBuffer(100);
		slot = buffer.readInt();
		sound = buffer.readBoolean();
	}

	@Override
	protected void write(PacketBuffer buffer) throws IOException {
		buffer.writeString(inv);
		buffer.writeInt(slot);
		buffer.writeBoolean(sound);
	}

	@Override
	public void process(EntityPlayer player, Side side) {
		if (inv.equals("keychain")) {
			keychain = ExtendedPlayer.get(player).inventoryKeychain;
			keychain.setInventorySlotContents(slot, null);
		}

		if (inv.equals("potion")) {
			potions = ExtendedPlayer.get(player).inventoryPotions;
			potions.setInventorySlotContents(slot, null);
			if (sound)
				SoundHelper.playSoundAtEntity(player.worldObj, player, SoundHelper.Potion, 0.5f, 1);
		}
	}
}
