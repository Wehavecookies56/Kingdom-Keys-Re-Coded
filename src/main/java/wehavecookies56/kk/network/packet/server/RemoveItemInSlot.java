package wehavecookies56.kk.network.packet.server;

import java.io.IOException;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.network.PacketBuffer;
import net.minecraftforge.fml.relauncher.Side;
import wehavecookies56.kk.entities.ExtendedPlayer;
import wehavecookies56.kk.inventory.InventoryKeychain;
import wehavecookies56.kk.inventory.InventoryPotionsMenu;
import wehavecookies56.kk.lib.Strings;
import wehavecookies56.kk.network.packet.AbstractMessage.AbstractServerMessage;
import wehavecookies56.kk.util.TextHelper;

public class RemoveItemInSlot extends AbstractServerMessage<RemoveItemInSlot> {
	String inv;
	int slot;
	InventoryPotionsMenu potions;
	InventoryKeychain keychain;
	public RemoveItemInSlot() {}
	
	public RemoveItemInSlot(String inventory, int slot){
		this.inv = inventory;
		this.slot = slot;
	}
	
	@Override
	protected void read(PacketBuffer buffer) throws IOException {
		inv = buffer.readStringFromBuffer(100);
		slot = buffer.readInt();
	}

	@Override
	protected void write(PacketBuffer buffer) throws IOException {
		buffer.writeString(inv);
		buffer.writeInt(slot);
	}

	@Override
	public void process(EntityPlayer player, Side side) {
		if(inv.equals("keychain"))
		{
			System.out.println("ofihreo");
			keychain = ExtendedPlayer.get(player).inventory;
			keychain.setInventorySlotContents(slot, null);
		}
			
		if(inv.equals("potion"))
		{
			potions = ExtendedPlayer.get(player).inventory3;
			potions.setInventorySlotContents(slot, null);
		}
	}
}
