package wehavecookies56.kk.network.packet.server;

import java.io.IOException;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.network.PacketBuffer;
import net.minecraftforge.fml.relauncher.Side;
import wehavecookies56.kk.entities.ExtendedPlayer;
import wehavecookies56.kk.item.ItemKKPotion;
import wehavecookies56.kk.item.ModItems;
import wehavecookies56.kk.network.packet.PacketDispatcher;
import wehavecookies56.kk.network.packet.AbstractMessage.AbstractServerMessage;
import wehavecookies56.kk.util.SoundHelper;

public class PotionConsume extends AbstractServerMessage<PotionConsume> {

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
			ExtendedPlayer.get(player).addMp(33);
			break;
		case "elixir":
			((ItemKKPotion) ModItems.Elixir).getPotionEffect(player);
			player.heal(10);
			ExtendedPlayer.get(player).addMp(33);
			break;
		default:
			break;
	}
	}
}
