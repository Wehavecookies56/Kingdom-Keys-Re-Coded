package wehavecookies56.kk.network.packet.server;

import java.io.IOException;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.network.PacketBuffer;
import net.minecraftforge.fml.relauncher.Side;
import wehavecookies56.kk.achievements.ModAchievements;
import wehavecookies56.kk.entities.ExtendedPlayer;
import wehavecookies56.kk.network.packet.AbstractMessage;
import wehavecookies56.kk.network.packet.AbstractMessage.AbstractClientMessage;
import wehavecookies56.kk.network.packet.AbstractMessage.AbstractServerMessage;
import wehavecookies56.kk.util.AchievementHelper;

public class MunnyPickup extends AbstractServerMessage<MunnyPickup> {

	public MunnyPickup() {}

	ItemStack toRemove;

	public MunnyPickup(ItemStack toRemove){
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
		player.inventory.consumeInventoryItem(toRemove.getItem());
		toRemove.stackSize--;
		ExtendedPlayer.get(player).addMunny(toRemove.getTagCompound().getInteger("amount"));
	}

}
