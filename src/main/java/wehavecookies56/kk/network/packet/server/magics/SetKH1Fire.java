package wehavecookies56.kk.network.packet.server.magics;

import java.io.IOException;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.network.PacketBuffer;
import net.minecraft.util.EnumChatFormatting;
import net.minecraftforge.fml.relauncher.Side;
import wehavecookies56.kk.entities.ExtendedPlayer;
import wehavecookies56.kk.inventory.InventorySpells;
import wehavecookies56.kk.item.ModItems;
import wehavecookies56.kk.lib.Constants;
import wehavecookies56.kk.lib.Strings;
import wehavecookies56.kk.network.packet.AbstractMessage.AbstractServerMessage;
import wehavecookies56.kk.util.TextHelper;

public class SetKH1Fire extends AbstractServerMessage<SetKH1Fire> {

	boolean kh1fire;

	public SetKH1Fire () {}

	public SetKH1Fire (boolean fire) {
		this.kh1fire = fire;
	}

	@Override
	protected void read (PacketBuffer buffer) throws IOException {
		kh1fire = buffer.readBoolean();
	}

	@Override
	protected void write (PacketBuffer buffer) throws IOException {
		buffer.writeBoolean(kh1fire);
	}

	@Override
	public void process (EntityPlayer player, Side side) {
		ExtendedPlayer ep = ExtendedPlayer.get(player);

		ep.setKH1Fire(kh1fire);
	}
}
