package uk.co.wehavecookies56.kk.common.network.packet.server;

import java.io.IOException;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.network.PacketBuffer;
import net.minecraftforge.fml.relauncher.Side;
import uk.co.wehavecookies56.kk.common.capability.ModCapabilities;
import uk.co.wehavecookies56.kk.common.item.ModItems;
import uk.co.wehavecookies56.kk.common.item.base.ItemKKPotion;
import uk.co.wehavecookies56.kk.common.network.packet.AbstractMessage;

public class PotionConsume extends AbstractMessage.AbstractServerMessage<PotionConsume> {

	public PotionConsume () {}

	String potion;

	public PotionConsume (String potion) {
		this.potion = potion;
	}

	@Override
	protected void read (PacketBuffer buffer) throws IOException {
		potion = buffer.readStringFromBuffer(100);
	}

	@Override
	protected void write (PacketBuffer buffer) throws IOException {
		buffer.writeString(potion);
	}

	@Override
	public void process (EntityPlayer player, Side side) {
		switch (potion) {
		case "potion":
			((ItemKKPotion) ModItems.Potion).getPotionEffect(player);
			player.heal(10);
			break;
		case "ether":
			((ItemKKPotion) ModItems.Ether).getPotionEffect(player);
			player.getCapability(ModCapabilities.PLAYER_STATS, null).addMP(33);
			break;
		case "elixir":
			((ItemKKPotion) ModItems.Elixir).getPotionEffect(player);
			player.heal(10);
			player.getCapability(ModCapabilities.PLAYER_STATS, null).addMP(33);
			break;
		default:
			break;
	}
	}
}
