package uk.co.wehavecookies56.kk.common.network.packet.server;

import java.io.IOException;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.network.PacketBuffer;
import net.minecraftforge.fml.relauncher.Side;
import uk.co.wehavecookies56.kk.common.core.helper.TextHelper;
import uk.co.wehavecookies56.kk.common.lib.Lists;
import uk.co.wehavecookies56.kk.common.network.packet.AbstractMessage;

public class ManifestKnowledgePacket extends AbstractMessage.AbstractServerMessage<ManifestKnowledgePacket> {

	public ManifestKnowledgePacket () {}

	@Override
	protected void read (PacketBuffer buffer) throws IOException {

	}

	@Override
	protected void write (PacketBuffer buffer) throws IOException {

	}

	@Override
	public void process (EntityPlayer player, Side side) {
		player.inventory.setInventorySlotContents(player.inventory.currentItem, null);
		int rand = randomWithRange(0, Lists.orgWeapons.size() - 1);
		player.inventory.addItemStackToInventory(new ItemStack(Lists.orgWeapons.get(rand)));
		TextHelper.sendChatMessage("The knowledge manifested the " + TextHelper.localize(Lists.orgWeapons.get(rand).getUnlocalizedName() + ".name"), player);
	}

	/**
	 * Method for generating random ints between the 2 parameters, The order of
	 * min and max do not matter.
	 *
	 * @param min
	 * @param max
	 * @return
	 */
	public static int randomWithRange (int min, int max) {
		int range = Math.abs(max - min) + 1;
		return (int) (Math.random() * range) + (min <= max ? min : max);
	}

}
