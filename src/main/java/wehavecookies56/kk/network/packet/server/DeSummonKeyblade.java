package wehavecookies56.kk.network.packet.server;

import java.io.IOException;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.network.PacketBuffer;
import net.minecraftforge.fml.relauncher.Side;
import wehavecookies56.kk.entities.ExtendedPlayer;
import wehavecookies56.kk.network.packet.AbstractMessage.AbstractServerMessage;
import wehavecookies56.kk.util.SoundHelper;

public class DeSummonKeyblade extends AbstractServerMessage<DeSummonKeyblade> {

	public DeSummonKeyblade() {
	}

	ItemStack toRemove;

	public DeSummonKeyblade(ItemStack toRemove) {
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
		SoundHelper.playSoundAtEntity(player.worldObj, player, SoundHelper.UnSummon, 0.5f, 1);
		ExtendedPlayer.get(player).setKeybladeSummoned(false);
	}

}
