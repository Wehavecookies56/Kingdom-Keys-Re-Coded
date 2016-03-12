package wehavecookies56.kk.network.packet.server;

import java.io.IOException;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.network.PacketBuffer;
import net.minecraft.util.EnumChatFormatting;
import net.minecraftforge.fml.relauncher.Side;
import wehavecookies56.kk.entities.ExtendedPlayer;
import wehavecookies56.kk.inventory.InventoryDriveForms;
import wehavecookies56.kk.lib.Strings;
import wehavecookies56.kk.network.packet.AbstractMessage.AbstractServerMessage;
import wehavecookies56.kk.util.TextHelper;

public class LevelUpDrive extends AbstractServerMessage<LevelUpDrive> {

	String form;
	boolean isLevelUp = false;

	public LevelUpDrive () {}

	public LevelUpDrive (String form) {
		this.form = form;
	}
	
	public LevelUpDrive (String form, boolean levelup) {
		this.form = form;
		this.isLevelUp = levelup;
	}
	
	@Override
	protected void read (PacketBuffer buffer) throws IOException {
		form = buffer.readStringFromBuffer(40);
		isLevelUp = buffer.readBoolean();
	}

	@Override
	protected void write (PacketBuffer buffer) throws IOException {
		buffer.writeString(form);
		buffer.writeBoolean(isLevelUp);
	}

	@Override
	public void process (EntityPlayer player, Side side) {
		ExtendedPlayer ep = ExtendedPlayer.get(player);
		int valorLevel = ExtendedPlayer.get(player).getDriveLevel(Strings.Form_Valor);
		int wisdomLevel = ExtendedPlayer.get(player).getDriveLevel(Strings.Form_Wisdom);
		int limitLevel = ExtendedPlayer.get(player).getDriveLevel(Strings.Form_Limit);
		int masterLevel = ExtendedPlayer.get(player).getDriveLevel(Strings.Form_Master);
		int finalLevel = ExtendedPlayer.get(player).getDriveLevel(Strings.Form_Final);

		int hasDriveInSlot = -1, nullSlot = -1;
		
		int formLevel = 0;
		switch(form)
		{
			case Strings.Form_Valor:
				formLevel = valorLevel;
				break;
			case Strings.Form_Wisdom:
				formLevel = wisdomLevel;
				break;
			case Strings.Form_Limit:
				formLevel = limitLevel;
				break;
			case Strings.Form_Master:
				formLevel = masterLevel;
				break;
			case Strings.Form_Final:
				formLevel = finalLevel;
				break;
			default:
			break;
		}
		if(isLevelUp)
		{//TODO
			ExtendedPlayer.get(player).setDriveLevel(form, finalLevel+1);
			System.out.println(form+" level: "+(formLevel+1));
		}
		else
		{
			for (int i = 0; i < InventoryDriveForms.INV_SIZE; i++) {
				if (ExtendedPlayer.get(player).inventoryDrive.getStackInSlot(i) != null) {
					if (ExtendedPlayer.get(player).inventoryDrive.getStackInSlot(i).getItem() == player.getHeldItem().getItem()) {
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
				TextHelper.sendFormattedChatMessage("Succesfully learnt " + form + " Form!", EnumChatFormatting.YELLOW, player);
			} else {
				TextHelper.sendFormattedChatMessage("Already learnt " + form + " Form!", EnumChatFormatting.YELLOW, player);
	
			}
		}
	}
}