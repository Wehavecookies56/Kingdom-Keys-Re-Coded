package wehavecookies56.kk.network.packet.server;

import java.io.IOException;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.network.PacketBuffer;
import net.minecraft.util.EnumChatFormatting;
import net.minecraftforge.fml.relauncher.Side;
import wehavecookies56.kk.entities.ExtendedPlayer;
import wehavecookies56.kk.inventory.InventoryDriveForms;
import wehavecookies56.kk.network.packet.AbstractMessage.AbstractServerMessage;
import wehavecookies56.kk.util.TextHelper;

public class LevelUpDrive extends AbstractServerMessage<LevelUpDrive> {

	String form;

	public LevelUpDrive() {
	}

	public LevelUpDrive(String form) {
		this.form = form;
	}

	@Override
	protected void read(PacketBuffer buffer) throws IOException {
		form = buffer.readStringFromBuffer(40);
	}

	@Override
	protected void write(PacketBuffer buffer) throws IOException {
		buffer.writeString(form);
	}

	@Override
	public void process(EntityPlayer player, Side side) {
		ExtendedPlayer ep = ExtendedPlayer.get(player);
		int valorLevel = ExtendedPlayer.get(player).getDriveLevel("Valor");
		int wisdomLevel = ExtendedPlayer.get(player).getDriveLevel("Wisdom");
		int limitLevel = ExtendedPlayer.get(player).getDriveLevel("Limit");
		int masterLevel = ExtendedPlayer.get(player).getDriveLevel("Master");
		int finalLevel = ExtendedPlayer.get(player).getDriveLevel("Final");

		int hasDriveInSlot = -1, nullSlot = -1;

		for (int i = 0; i < InventoryDriveForms.INV_SIZE; i++) {
			if (ExtendedPlayer.get(player).inventoryDrive.getStackInSlot(i) != null) {
				if (ExtendedPlayer.get(player).inventoryDrive.getStackInSlot(i).getItem() == player.getHeldItem()
						.getItem()) {
					hasDriveInSlot = i;
				}
			} else {
				nullSlot = i;
				break;
			}
		}

		if (hasDriveInSlot == -1) {
			ExtendedPlayer.get(player).inventoryDrive.setInventorySlotContents(nullSlot, player.getHeldItem());
			player.inventory.setInventorySlotContents(player.inventory.currentItem, null);
			TextHelper.sendFormattedChatMessage("Succesfully learnt " + form + " Form!", EnumChatFormatting.YELLOW,
					player);
		} else {
			TextHelper.sendFormattedChatMessage("Already learnt " + form + " Form!", EnumChatFormatting.YELLOW, player);

		}

	}

}
