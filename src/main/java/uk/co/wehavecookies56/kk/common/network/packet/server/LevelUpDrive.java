package uk.co.wehavecookies56.kk.common.network.packet.server;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.network.PacketBuffer;
import net.minecraft.util.EnumHand;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.util.text.TextFormatting;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.relauncher.Side;
import uk.co.wehavecookies56.kk.common.capability.ModCapabilities;
import uk.co.wehavecookies56.kk.common.container.inventory.InventoryDriveForms;
import uk.co.wehavecookies56.kk.common.core.helper.TextHelper;
import uk.co.wehavecookies56.kk.common.lib.Constants;
import uk.co.wehavecookies56.kk.common.lib.Strings;
import uk.co.wehavecookies56.kk.common.network.packet.AbstractMessage;
import uk.co.wehavecookies56.kk.common.network.packet.PacketDispatcher;
import uk.co.wehavecookies56.kk.common.network.packet.client.SyncDriveData;
import uk.co.wehavecookies56.kk.common.network.packet.client.SyncDriveInventory;

import java.io.IOException;

public class LevelUpDrive extends AbstractMessage.AbstractServerMessage<LevelUpDrive> {

	String form;
	boolean isLevelUp = false;
	int levels;
	String playername;
	public LevelUpDrive () {}

	public LevelUpDrive (String form) {
		this.form = form;
		this.playername = "test";

	}
	
	public LevelUpDrive (String form, boolean levelup, int level, String player) {
		this.form = form;
		this.isLevelUp = levelup;
		this.levels = level;
		if(player != null)
			this.playername = player;
		else
			this.playername = "test";
			
	}
	
	@Override
	protected void read (PacketBuffer buffer) throws IOException {
		form = buffer.readStringFromBuffer(40);
		isLevelUp = buffer.readBoolean();
		levels = buffer.readInt();
		playername = buffer.readStringFromBuffer(40);
	}

	@Override
	protected void write (PacketBuffer buffer) throws IOException {
		buffer.writeString(form);
		buffer.writeBoolean(isLevelUp);
		buffer.writeInt(levels);
		buffer.writeString(playername);
	}
	public static EntityPlayer getPlayerFromUsername(String username)
    {
        if (FMLCommonHandler.instance().getEffectiveSide() == Side.CLIENT)
            return null;

        return FMLCommonHandler.instance().getMinecraftServerInstance().getPlayerList().getPlayerByUsername(username);
    }
	@Override
	public void process (EntityPlayer player, Side side) {
		if(playername.equals("test"))
			playername = player.getName();
		EntityPlayer entityplayer = getPlayerFromUsername(playername);
		player = entityplayer;
		
		int hasDriveInSlot = -1, nullSlot = -1;
				
		PacketDispatcher.sendTo(new SyncDriveData(player.getCapability(ModCapabilities.DRIVE_STATE, null), player.getCapability(ModCapabilities.PLAYER_STATS, null)), (EntityPlayerMP) player);
		if(isLevelUp)
		{
			player.getCapability(ModCapabilities.DRIVE_STATE, null).setDriveLevel(form, levels);
		}
		else
		{
			for (int i = 0; i < InventoryDriveForms.INV_SIZE; i++) {
				if (player.getCapability(ModCapabilities.DRIVE_STATE, null).getInventoryDriveForms().getStackInSlot(i) != null) {
					if (player.getCapability(ModCapabilities.DRIVE_STATE, null).getInventoryDriveForms().getStackInSlot(i).getItem() == player.getHeldItem(EnumHand.MAIN_HAND).getItem()) {
						hasDriveInSlot = i;
					}
				} else {
					nullSlot = i;
					break;
				}
			}
	
			if (hasDriveInSlot == -1) {
				player.getCapability(ModCapabilities.DRIVE_STATE, null).getInventoryDriveForms().setInventorySlotContents(nullSlot, player.getHeldItem(EnumHand.MAIN_HAND));
				player.inventory.setInventorySlotContents(player.inventory.currentItem, null);
		    //	PacketDispatcher.sendTo(new ShowOverlayPacket("munny", event.getEntityItem().getEntityItem().getTagCompound().getInteger("amount")), (EntityPlayerMP) event.getPlayer());

				TextComponentTranslation learnMessage = new TextComponentTranslation(Strings.Chat_Drive_Learn, new TextComponentTranslation(this.form));
				learnMessage.getStyle().setColor(TextFormatting.YELLOW);
				player.addChatMessage(learnMessage);
			} else {
				TextComponentTranslation errorMessage = new TextComponentTranslation(Strings.Chat_Drive_Error, new TextComponentTranslation(this.form));
				errorMessage.getStyle().setColor(TextFormatting.YELLOW);
				player.addChatMessage(errorMessage);	
			}
		}
		PacketDispatcher.sendTo(new SyncDriveInventory(player.getCapability(ModCapabilities.DRIVE_STATE, null)), (EntityPlayerMP) player);
	}
}