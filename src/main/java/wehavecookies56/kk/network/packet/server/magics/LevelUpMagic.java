package wehavecookies56.kk.network.packet.server.magics;

import java.io.IOException;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.network.PacketBuffer;
import net.minecraft.util.EnumChatFormatting;
import net.minecraftforge.fml.relauncher.Side;
import wehavecookies56.kk.entities.ExtendedPlayer;
import wehavecookies56.kk.inventory.InventorySpells;
import wehavecookies56.kk.item.ModItems;
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
		if (player.getHeldItem().getItem() == ModItems.LevelUpMagicFire)
			magic = "Fire";
		else if (player.getHeldItem().getItem() == ModItems.LevelUpMagicBlizzard)
			magic = "Blizzard";
		else if (player.getHeldItem().getItem() == ModItems.LevelUpMagicThunder)
			magic = "Thunder";
		else if (player.getHeldItem().getItem() == ModItems.LevelUpMagicCure)
			magic = "Cure";
		else if (player.getHeldItem().getItem() == ModItems.LevelUpMagicAero)
			magic = "Aero";
		else if (player.getHeldItem().getItem() == ModItems.LevelUpMagicStop)
			magic = "Stop";
		else
			return;

		ExtendedPlayer ep = ExtendedPlayer.get(player);
		int fireLevel = ExtendedPlayer.get(player).getMagicLevel("Fire");
		int blizzardLevel = ExtendedPlayer.get(player).getMagicLevel("Blizzard");
		int thunderLevel = ExtendedPlayer.get(player).getMagicLevel("Thunder");
		int cureLevel = ExtendedPlayer.get(player).getMagicLevel("Cure");
		int aeroLevel = ExtendedPlayer.get(player).getMagicLevel("Aero");
		int stopLevel = ExtendedPlayer.get(player).getMagicLevel("Stop");

		int hasMagicInSlot = -1, nullSlot = -1;

		for (int i = 0; i < InventorySpells.INV_SIZE; i++) {
			if (ExtendedPlayer.get(player).inventorySpells.getStackInSlot(i) != null) {
				if (ExtendedPlayer.get(player).inventorySpells.getStackInSlot(i).getItem() == player.getHeldItem().getItem()) {
					hasMagicInSlot = i;
				}
			} else {
				nullSlot = i;
				break;
			}
		}

		if (hasMagicInSlot == -1) {
			ExtendedPlayer.get(player).inventorySpells.setInventorySlotContents(nullSlot, player.getHeldItem());
			player.inventory.setInventorySlotContents(player.inventory.currentItem, null);
			TextHelper.sendFormattedChatMessage("Succesfully learnt " + magic, EnumChatFormatting.YELLOW, player);
		}

		if (magic.equals("Fire")) {
			if (hasMagicInSlot != -1) {
				if (fireLevel == 0 || fireLevel == 1 || fireLevel == 2) {
					ep.setMagicLevel("Fire", fireLevel + 1);
					player.inventory.setInventorySlotContents(player.inventory.currentItem, null);
					TextHelper.sendFormattedChatMessage("Leveled up " + magic + ", Actual level: " + (fireLevel + 1), EnumChatFormatting.YELLOW, player);

				} else {
					TextHelper.sendFormattedChatMessage("Can't level up " + magic + ", Actual level: " + fireLevel, EnumChatFormatting.YELLOW, player);
				}
			}
			hasMagicInSlot = -1;
			nullSlot = -1;
		} else if (magic.equals("Blizzard")) {
			if (hasMagicInSlot != -1) {
				if (blizzardLevel == 0 || blizzardLevel == 1 || blizzardLevel == 2) {
					ep.setMagicLevel("Blizzard", blizzardLevel + 1);
					player.inventory.setInventorySlotContents(player.inventory.currentItem, null);
					TextHelper.sendFormattedChatMessage("Leveled up " + magic + ", Actual level: " + (blizzardLevel + 1), EnumChatFormatting.YELLOW, player);

				} else {
					TextHelper.sendFormattedChatMessage("Can't level up " + magic + ", Actual level: " + blizzardLevel, EnumChatFormatting.YELLOW, player);
				}
			}
			hasMagicInSlot = -1;
			nullSlot = -1;
		} else if (magic.equals("Thunder")) {
			if (hasMagicInSlot != -1) {
				if (thunderLevel == 0 || thunderLevel == 1 || thunderLevel == 2) {
					ep.setMagicLevel("Thunder", thunderLevel + 1);
					player.inventory.setInventorySlotContents(player.inventory.currentItem, null);
					TextHelper.sendFormattedChatMessage("Leveled up " + magic + ", Actual level: " + (thunderLevel + 1), EnumChatFormatting.YELLOW, player);

				} else {
					TextHelper.sendFormattedChatMessage("Can't level up " + magic + ", Actual level: " + thunderLevel, EnumChatFormatting.YELLOW, player);
				}
			}
			hasMagicInSlot = -1;
			nullSlot = -1;
		} else if (magic.equals("Cure")) {
			if (hasMagicInSlot != -1) {
				if (cureLevel == 0 || cureLevel == 1 || cureLevel == 2) {
					ep.setMagicLevel("Cure", cureLevel + 1);
					player.inventory.setInventorySlotContents(player.inventory.currentItem, null);
					TextHelper.sendFormattedChatMessage("Leveled up " + magic + ", Actual level: " + (cureLevel + 1), EnumChatFormatting.YELLOW, player);

				} else {
					TextHelper.sendFormattedChatMessage("Can't level up " + magic + ", Actual level: " + cureLevel, EnumChatFormatting.YELLOW, player);
				}
			}
			hasMagicInSlot = -1;
			nullSlot = -1;
		} else if (magic.equals("Aero")) {
			if (hasMagicInSlot != -1) {
				if (aeroLevel == 0 || aeroLevel == 1 || aeroLevel == 2) {
					ep.setMagicLevel("Aero", aeroLevel + 1);
					player.inventory.setInventorySlotContents(player.inventory.currentItem, null);
					TextHelper.sendFormattedChatMessage("Leveled up " + magic + ", Actual level: " + (aeroLevel + 1), EnumChatFormatting.YELLOW, player);

				} else {
					TextHelper.sendFormattedChatMessage("Can't level up " + magic + ", Actual level: " + aeroLevel, EnumChatFormatting.YELLOW, player);
				}
			}
			hasMagicInSlot = -1;
			nullSlot = -1;
		} else if (magic.equals("Stop")) {
			if (hasMagicInSlot != -1) {
				if (stopLevel == 0 || stopLevel == 1 || stopLevel == 2) {
					ep.setMagicLevel("Stop", stopLevel + 1);
					player.inventory.setInventorySlotContents(player.inventory.currentItem, null);
					TextHelper.sendFormattedChatMessage("Leveled up " + magic + ", Actual level: " + (stopLevel + 1), EnumChatFormatting.YELLOW, player);

				} else {
					TextHelper.sendFormattedChatMessage("Can't level up " + magic + ", Actual level: " + stopLevel, EnumChatFormatting.YELLOW, player);
				}
			}
			hasMagicInSlot = -1;
			nullSlot = -1;
		}
	}
}
