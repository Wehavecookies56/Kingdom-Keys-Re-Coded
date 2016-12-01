package uk.co.wehavecookies56.kk.common.core.command;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import net.minecraft.command.CommandException;
import net.minecraft.command.ICommand;
import net.minecraft.command.ICommandSender;
import net.minecraft.command.PlayerNotFoundException;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.ItemStack;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextFormatting;
import uk.co.wehavecookies56.kk.common.capability.ModCapabilities;
import uk.co.wehavecookies56.kk.common.core.helper.TextHelper;
import uk.co.wehavecookies56.kk.common.item.base.ItemKeyblade;
import uk.co.wehavecookies56.kk.common.network.packet.PacketDispatcher;
import uk.co.wehavecookies56.kk.common.network.packet.server.DeSummonKeyblade;
import uk.co.wehavecookies56.kk.common.network.packet.server.RemoveItemInSlot;

import javax.annotation.Nullable;

public class CommandRemoveKeychain implements ICommand {

	private List<String> aliases;

	public CommandRemoveKeychain () {
		this.aliases = new ArrayList<String>();
		this.aliases.add("kkremovechain");
	}

	@Override
	public int compareTo (ICommand arg0) {
		return 0;
	}

	@Override
	public String getName () {
		return "removechain";
	}

	public int getRequiredPermissionLevel () {
		return 2;
	}

	@Override
	public String getUsage (ICommandSender sender) {
		return "/removechain [player]";
	}

	@Override
	public List<String> getAliases () {
		return this.aliases;
	}

	public static boolean isInteger (String s) {
		try {
			Integer.parseInt(s);
		} catch (NumberFormatException e) {
			return false;
		} catch (NullPointerException e) {
			return false;
		}
		return true;
	}

	@Override
	public boolean isUsernameIndex (String[] args, int index) {
		return true;
	}

	public static EntityPlayerMP getCommandSenderAsPlayer (ICommandSender sender) throws PlayerNotFoundException {
		if (sender instanceof EntityPlayerMP)
			return (EntityPlayerMP) sender;
		else
			throw new PlayerNotFoundException("You must specify which player you wish to perform this action on.", new Object[0]);
	}

	@Override
	public void execute(MinecraftServer server, ICommandSender sender, String[] args) throws CommandException {
		if (sender.getCommandSenderEntity() instanceof EntityPlayer) {
			EntityPlayer player = (EntityPlayer) sender.getCommandSenderEntity();
			if (args.length == 0) {
				if (player.getCapability(ModCapabilities.SUMMON_KEYBLADE, null).getInventoryKeychain().getStackInSlot(0) != null) {
					PacketDispatcher.sendToServer(new RemoveItemInSlot("keychain", 0));
					PacketDispatcher.sendToAllAround(new RemoveItemInSlot("keychain", 0), (EntityPlayer) sender.getCommandSenderEntity(), 1);

					if (sender.getCommandSenderEntity().getCapability(ModCapabilities.SUMMON_KEYBLADE, null).getIsKeybladeSummoned()) if (player.getHeldItem(EnumHand.MAIN_HAND) != ItemStack.EMPTY && player.getHeldItem(EnumHand.MAIN_HAND).getItem() instanceof ItemKeyblade) // props.isKeybladeSummoned()
																																											// ==
																																											// true
						PacketDispatcher.sendToServer(new DeSummonKeyblade(player.inventory.getCurrentItem()));
					TextHelper.sendFormattedChatMessage("Your keychain has been removed!", TextFormatting.YELLOW, (EntityPlayer) sender.getCommandSenderEntity());
				} else
					TextHelper.sendFormattedChatMessage("The chain slot has no chain!", TextFormatting.RED, (EntityPlayer) sender.getCommandSenderEntity());
			} else if (args.length == 1) {
				EntityPlayerMP playermp = args.length == 1 ? server.getPlayerList().getPlayerByUUID(UUID.fromString(args[0])) : getCommandSenderAsPlayer(sender);

				if (playermp.getCapability(ModCapabilities.SUMMON_KEYBLADE, null).getInventoryKeychain().getStackInSlot(0) != ItemStack.EMPTY) {
					PacketDispatcher.sendToServer(new RemoveItemInSlot("keychain", 0));
					if (playermp.getCapability(ModCapabilities.SUMMON_KEYBLADE, null).getIsKeybladeSummoned()) if (playermp.getHeldItem(EnumHand.MAIN_HAND) != ItemStack.EMPTY && playermp.getHeldItem(EnumHand.MAIN_HAND).getItem() instanceof ItemKeyblade) PacketDispatcher.sendToServer(new DeSummonKeyblade(playermp.getHeldItem(EnumHand.MAIN_HAND)));
					TextHelper.sendFormattedChatMessage(args[0] + "'s keychain has been removed!", TextFormatting.YELLOW, (EntityPlayer) sender.getCommandSenderEntity());
				} else
					TextHelper.sendFormattedChatMessage("The chain slot has no chain!", TextFormatting.RED, (EntityPlayer) sender.getCommandSenderEntity());
			} else
				TextHelper.sendFormattedChatMessage("Invalid arguments! Usage: /removechain [player]", TextFormatting.RED, (EntityPlayer) sender.getCommandSenderEntity());
		}		
	}

	@Override
	public boolean checkPermission(MinecraftServer server, ICommandSender sender) {
		return sender.canUseCommand(getRequiredPermissionLevel(), getName());

	}

	@Override
	public List<String> getTabCompletions(MinecraftServer server, ICommandSender sender, String[] args, @Nullable BlockPos pos) {
		return null;
	}
}
