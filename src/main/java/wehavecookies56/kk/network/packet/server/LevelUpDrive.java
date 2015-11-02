package wehavecookies56.kk.network.packet.server;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.network.PacketBuffer;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.ChatComponentTranslation;
import net.minecraft.util.ChatStyle;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.IChatComponent;
import net.minecraftforge.fml.relauncher.Side;
import wehavecookies56.kk.api.recipes.RecipeRegistry;
import wehavecookies56.kk.entities.ExtendedPlayer;
import wehavecookies56.kk.network.packet.AbstractMessage.AbstractServerMessage;
import wehavecookies56.kk.util.TextHelper;

public class LevelUpDrive extends AbstractServerMessage<LevelUpDrive> {

	String form;

	public LevelUpDrive() {}

	public LevelUpDrive(String form){
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
	public void process(EntityPlayer player, Side side)
	{
		ExtendedPlayer ep = ExtendedPlayer.get(player);
		int valorLevel = ExtendedPlayer.get(player).getDriveLevel("Valor");
		int wisdomLevel = ExtendedPlayer.get(player).getDriveLevel("Wisdom");
		int limitLevel = ExtendedPlayer.get(player).getDriveLevel("Limit");
		int masterLevel = ExtendedPlayer.get(player).getDriveLevel("Master");
		int finalLevel = ExtendedPlayer.get(player).getDriveLevel("Final");

		if(form.equals("Valor"))
		{
			if(valorLevel == 0)
			{
				ep.setDriveLevel("Valor", valorLevel+1);
				player.inventory.setInventorySlotContents(player.inventory.currentItem, null);
				TextHelper.sendFormattedChatMessage("You unlocked "+form+" form!", EnumChatFormatting.YELLOW, player);

			}
			else
			{
				TextHelper.sendFormattedChatMessage("You already unlocked "+form+" Form", EnumChatFormatting.YELLOW, player);
			}
		}
		else if(form.equals("Wisdom"))
		{
			if(wisdomLevel == 0)
			{
				ep.setDriveLevel("Wisdom", wisdomLevel+1);
				player.inventory.setInventorySlotContents(player.inventory.currentItem, null);
				TextHelper.sendFormattedChatMessage("You unlocked "+form+" form!", EnumChatFormatting.YELLOW, player);

			}
			else
			{
				TextHelper.sendFormattedChatMessage("You already unlocked "+form+" Form", EnumChatFormatting.YELLOW, player);
			}
		}
		else if(form.equals("Limit"))
		{
			if(limitLevel == 0)
			{
				ep.setDriveLevel("Limit", limitLevel+1);
				player.inventory.setInventorySlotContents(player.inventory.currentItem, null);
				TextHelper.sendFormattedChatMessage("You unlocked "+form+" form!", EnumChatFormatting.YELLOW, player);

			}
			else
			{
				TextHelper.sendFormattedChatMessage("You already unlocked "+form+" Form", EnumChatFormatting.YELLOW, player);
			}
		}
		else if(form.equals("Master"))
		{
			if(masterLevel == 0)
			{
				ep.setDriveLevel("Master", masterLevel+1);
				player.inventory.setInventorySlotContents(player.inventory.currentItem, null);
				TextHelper.sendFormattedChatMessage("You unlocked "+form+" form!", EnumChatFormatting.YELLOW, player);

			}
			else
			{
				TextHelper.sendFormattedChatMessage("You already unlocked "+form+" Form", EnumChatFormatting.YELLOW, player);
			}
		}
		else if(form.equals("Final"))
		{
			if(finalLevel == 0)
			{
				ep.setDriveLevel("Final", finalLevel+1);
				player.inventory.setInventorySlotContents(player.inventory.currentItem, null);
				TextHelper.sendFormattedChatMessage("You unlocked "+form+" form!", EnumChatFormatting.YELLOW, player);

			}
			else
			{
				TextHelper.sendFormattedChatMessage("You already unlocked "+form+" Form", EnumChatFormatting.YELLOW, player);
			}
		}
	}

}
