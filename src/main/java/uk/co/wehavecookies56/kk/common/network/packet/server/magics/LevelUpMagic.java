package uk.co.wehavecookies56.kk.common.network.packet.server.magics;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.network.PacketBuffer;
import net.minecraft.util.EnumHand;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.util.text.TextFormatting;
import net.minecraftforge.fml.relauncher.Side;
import uk.co.wehavecookies56.kk.common.capability.ModCapabilities;
import uk.co.wehavecookies56.kk.common.container.inventory.InventorySpells;
import uk.co.wehavecookies56.kk.common.lib.Constants;
import uk.co.wehavecookies56.kk.common.lib.Strings;
import uk.co.wehavecookies56.kk.common.network.packet.AbstractMessage.AbstractServerMessage;
import uk.co.wehavecookies56.kk.common.network.packet.PacketDispatcher;
import uk.co.wehavecookies56.kk.common.network.packet.client.SyncMagicData;
import uk.co.wehavecookies56.kk.common.network.packet.client.SyncMagicInventory;

import java.io.IOException;

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

		int firstEmptySlot = -1;

		boolean hasMagicInSlot = false;
				
		for (int i = 0; i < InventorySpells.INV_SIZE; i++) {
			if (player.getCapability(ModCapabilities.MAGIC_STATE, null).getInventorySpells().getStackInSlot(i) != null) {
				if (player.getCapability(ModCapabilities.MAGIC_STATE, null).getInventorySpells().getStackInSlot(i).getItem() == player.getHeldItem(EnumHand.MAIN_HAND).getItem()) {
					hasMagicInSlot = true;
				}
			} else {
				firstEmptySlot = i;
				break;
			}
		}

		if (!hasMagicInSlot) {
			player.getCapability(ModCapabilities.MAGIC_STATE, null).getInventorySpells().setInventorySlotContents(firstEmptySlot, player.getHeldItem(EnumHand.MAIN_HAND));
			player.inventory.setInventorySlotContents(player.inventory.currentItem, null);
			TextComponentTranslation learnMessage = new TextComponentTranslation(Strings.Chat_Magic_Learn, new TextComponentTranslation(Constants.getMagicName(magic, player.getCapability(ModCapabilities.MAGIC_STATE, null).getMagicLevel(magic))));
			learnMessage.getStyle().setColor(TextFormatting.YELLOW);
			player.addChatMessage(learnMessage);
		} else {
			if (player.getCapability(ModCapabilities.MAGIC_STATE, null).getMagicLevel(magic) < Constants.MAX_MAGIC_LEVEL) {
				player.getCapability(ModCapabilities.MAGIC_STATE, null).setMagicLevel(magic, player.getCapability(ModCapabilities.MAGIC_STATE, null).getMagicLevel(magic) + 1);
				player.inventory.setInventorySlotContents(player.inventory.currentItem, null);
				TextComponentTranslation levelupMessage = new TextComponentTranslation(Strings.Chat_Magic_Levelup, new TextComponentTranslation(Constants.getMagicName(magic, player.getCapability(ModCapabilities.MAGIC_STATE, null).getMagicLevel(magic) - 1)), new TextComponentTranslation(Constants.getMagicName(magic, player.getCapability(ModCapabilities.MAGIC_STATE, null).getMagicLevel(magic))));
				levelupMessage.getStyle().setColor(TextFormatting.YELLOW);
				player.addChatMessage(levelupMessage);

			} else {
				TextComponentTranslation errorMessage = new TextComponentTranslation(Strings.Chat_Magic_Error, new TextComponentTranslation(Constants.getMagicName(magic, player.getCapability(ModCapabilities.MAGIC_STATE, null).getMagicLevel(magic))));
				errorMessage.getStyle().setColor(TextFormatting.YELLOW);
				player.addChatMessage(errorMessage);
			}
		}
		PacketDispatcher.sendTo(new SyncMagicData(player.getCapability(ModCapabilities.MAGIC_STATE, null), player.getCapability(ModCapabilities.PLAYER_STATS, null)), (EntityPlayerMP) player);
		PacketDispatcher.sendTo(new SyncMagicInventory(player.getCapability(ModCapabilities.MAGIC_STATE, null)), (EntityPlayerMP) player);
	}
}
