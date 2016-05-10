package uk.co.wehavecookies56.kk.common.network.packet.server;

import java.io.IOException;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.network.PacketBuffer;
import net.minecraft.util.SoundCategory;
import net.minecraftforge.fml.relauncher.Side;
import uk.co.wehavecookies56.kk.client.sound.ModSounds;
import uk.co.wehavecookies56.kk.common.capability.ModCapabilities;
import uk.co.wehavecookies56.kk.common.container.inventory.InventoryKeychain;
import uk.co.wehavecookies56.kk.common.container.inventory.InventoryPotionsMenu;
import uk.co.wehavecookies56.kk.common.network.packet.AbstractMessage;

public class RemoveItemInSlot extends AbstractMessage.AbstractServerMessage<RemoveItemInSlot> {
	String inv;
	int slot;
	InventoryPotionsMenu potions;
	InventoryKeychain keychain;
	boolean sound;

	public RemoveItemInSlot () {}

	public RemoveItemInSlot (String inventory, int slot) {
		this.inv = inventory;
		this.slot = slot;
		this.sound = false;
	}

	public RemoveItemInSlot (String inventory, int slot, boolean sound) {
		this.inv = inventory;
		this.slot = slot;
		this.sound = sound;
	}

	@Override
	protected void read (PacketBuffer buffer) throws IOException {
		inv = buffer.readStringFromBuffer(100);
		slot = buffer.readInt();
		sound = buffer.readBoolean();
	}

	@Override
	protected void write (PacketBuffer buffer) throws IOException {
		buffer.writeString(inv);
		buffer.writeInt(slot);
		buffer.writeBoolean(sound);
	}

	@Override
	public void process (EntityPlayer player, Side side) {
		if (inv.equals("keychain")) {
			keychain = player.getCapability(ModCapabilities.SUMMON_KEYBLADE, null).getInventoryKeychain();
			keychain.setInventorySlotContents(slot, null);
		}

		if (inv.equals("potion")) {
			potions = player.getCapability(ModCapabilities.PLAYER_STATS, null).getInventoryPotionsMenu();
			potions.setInventorySlotContents(slot, null);
			if (sound) player.worldObj.playSound(null, player.getPosition(), ModSounds.potion, SoundCategory.MASTER, 0.5f, 1);
		}
	}
}
