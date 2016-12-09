package uk.co.wehavecookies56.kk.common.network.packet.server;

import java.io.IOException;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.ItemStack;
import net.minecraft.network.PacketBuffer;
import net.minecraftforge.fml.relauncher.Side;
import uk.co.wehavecookies56.kk.common.capability.ModCapabilities;
import uk.co.wehavecookies56.kk.common.network.packet.AbstractMessage;
import uk.co.wehavecookies56.kk.common.network.packet.PacketDispatcher;
import uk.co.wehavecookies56.kk.common.network.packet.client.SyncMunnyData;

public class GiveBoughtItem extends AbstractMessage.AbstractServerMessage<GiveBoughtItem> {

	public GiveBoughtItem() {}

	int spentMunny;
	int quantity;
	ItemStack boughtItem;

	public GiveBoughtItem(int spentMunny, int quantity, ItemStack boughtItem) {
		this.spentMunny = spentMunny;
		this.quantity = quantity;
		this.boughtItem = boughtItem;
	}

	@Override
	protected void read (PacketBuffer buffer) throws IOException {
		this.spentMunny = buffer.readInt();
		this.quantity = buffer.readInt();
		this.boughtItem = buffer.readItemStack();
	}

	@Override
	protected void write (PacketBuffer buffer) throws IOException {
		buffer.writeInt(spentMunny);
		buffer.writeInt(quantity);
		buffer.writeItemStack(boughtItem);
	}

	@Override
	public void process (EntityPlayer player, Side side) {
		player.inventory.addItemStackToInventory(this.boughtItem);
		player.getCapability(ModCapabilities.MUNNY, null).remMunny(spentMunny * quantity);
		PacketDispatcher.sendTo(new SyncMunnyData(player.getCapability(ModCapabilities.MUNNY, null)), (EntityPlayerMP) player);
	}

}
