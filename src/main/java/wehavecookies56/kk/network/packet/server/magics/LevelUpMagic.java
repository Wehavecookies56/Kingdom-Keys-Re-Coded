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

public class LevelUpMagic extends AbstractServerMessage<LevelUpMagic> {

	String magic;

	public LevelUpMagic () {}

	public LevelUpMagic (String magic) {
		this.magic = magic;
	}

	@Override
	protected void read (PacketBuffer buffer) throws IOException {
		magic = buffer.readStringFromBuffer(40);
	}

	@Override
	protected void write (PacketBuffer buffer) throws IOException {
		buffer.writeString(magic);
	}

	@Override
	public void process (EntityPlayer player, Side side) {

		ExtendedPlayer ep = ExtendedPlayer.get(player);

		int firstEmptySlot = -1;

		boolean hasMagicInSlot = false;
				
		for (int i = 0; i < InventorySpells.INV_SIZE; i++) {
			if (ExtendedPlayer.get(player).inventorySpells.getStackInSlot(i) != null) {
				if (ExtendedPlayer.get(player).inventorySpells.getStackInSlot(i).getItem() == player.getHeldItem().getItem()) {
					hasMagicInSlot = true;
				}
			} else {
				firstEmptySlot = i;
				break;
			}
		}

		if (!hasMagicInSlot) {
			ExtendedPlayer.get(player).inventorySpells.setInventorySlotContents(firstEmptySlot, player.getHeldItem());
			player.inventory.setInventorySlotContents(player.inventory.currentItem, null);
			String magicName = TextHelper.localize(Constants.getMagicName(magic, ep.getMagicLevel(magic)));
			TextHelper.sendFormattedChatMessage("Succesfully learnt " + magicName + "!", EnumChatFormatting.YELLOW, player);
		} else {
			if (ep.getMagicLevel(magic) < Constants.MAX_MAGIC_LEVEL) {
				ep.setMagicLevel(magic, ep.getMagicLevel(magic) + 1);
				player.inventory.setInventorySlotContents(player.inventory.currentItem, null);
				TextHelper.sendFormattedChatMessage("Leveled up " + TextHelper.localize(Constants.getMagicName(magic, ep.getMagicLevel(magic) - 1)) + ", it is now " + TextHelper.localize(Constants.getMagicName(magic, ep.getMagicLevel(magic))) + "!", EnumChatFormatting.YELLOW, player);

			} else {
				TextHelper.sendFormattedChatMessage("Can't level up " + TextHelper.localize(Constants.getMagicName(magic, ep.getMagicLevel(magic))) + ", it is already at the max level!", EnumChatFormatting.YELLOW, player);
			}
		}		
	}
}
