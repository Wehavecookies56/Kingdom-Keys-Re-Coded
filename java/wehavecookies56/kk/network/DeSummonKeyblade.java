package wehavecookies56.kk.network;

import java.io.IOException;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.network.PacketBuffer;
import net.minecraftforge.fml.relauncher.Side;
import wehavecookies56.kk.entities.ExtendedPlayer;
import wehavecookies56.kk.item.ItemKeyblade;
import wehavecookies56.kk.item.ItemKeychain;
import wehavecookies56.kk.network.AbstractMessage.AbstractServerMessage;

public class DeSummonKeyblade extends AbstractServerMessage<DeSummonKeyblade> {

	public DeSummonKeyblade() {}

	ItemStack toRemove;

	public DeSummonKeyblade(ItemStack toRemove){
		this.toRemove = toRemove;
	}

	@Override
	protected void read(PacketBuffer buffer) throws IOException {
		toRemove = buffer.readItemStackFromBuffer();
	}

	@Override
	protected void write(PacketBuffer buffer) throws IOException {
		buffer.writeItemStackToBuffer(toRemove);
	}

	@Override
	public void process(EntityPlayer player, Side side) {
		player.inventory.setInventorySlotContents(player.inventory.currentItem, null);
		ExtendedPlayer.get(player).setSummonedKeyblade(0);
	}

}
