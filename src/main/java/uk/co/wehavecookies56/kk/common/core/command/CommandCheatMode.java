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
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextFormatting;
import uk.co.wehavecookies56.kk.common.capability.ModCapabilities;
import uk.co.wehavecookies56.kk.common.core.helper.TextHelper;
import uk.co.wehavecookies56.kk.common.network.packet.PacketDispatcher;
import uk.co.wehavecookies56.kk.common.network.packet.client.SyncCheatModeData;

public class CommandCheatMode implements ICommand {

	private List<String> aliases;

	public CommandCheatMode () {
		this.aliases = new ArrayList<String>();
		this.aliases.add("cheatmode");
		this.aliases.add("kkcheatmode");
	}

	@Override
	public int compareTo (ICommand arg0) {
		return 0;
	}

	@Override
	public String getCommandName () {
		return "cheatmode";
	}

	public int getRequiredPermissionLevel () {
		return 2;
	}

	@Override
	public String getCommandUsage (ICommandSender sender) {
		return "/cheatmode [player]";
	}

	@Override
	public List<String> getCommandAliases () {
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
	public void execute (MinecraftServer server, ICommandSender sender, String[] args) throws CommandException {
		if (sender.getCommandSenderEntity() instanceof EntityPlayer) if (args.length == 0) {
			if (sender.getCommandSenderEntity().getCapability(ModCapabilities.CHEAT_MODE, null).getCheatMode()) {
				sender.getCommandSenderEntity().getCapability(ModCapabilities.CHEAT_MODE, null).setCheatMode(false);
				TextHelper.sendFormattedChatMessage("You are no longer in Cheat Mode", TextFormatting.RED, (EntityPlayer) sender.getCommandSenderEntity());
			} else {
				sender.getCommandSenderEntity().getCapability(ModCapabilities.CHEAT_MODE, null).setCheatMode(true);
				TextHelper.sendFormattedChatMessage("You are now in Cheat Mode", TextFormatting.GREEN, (EntityPlayer) sender.getCommandSenderEntity());
			}
		} else if (args.length == 1) {
			EntityPlayerMP entityplayermp = args.length == 1 ? server.getPlayerList().getPlayerByUUID(UUID.fromString(args[0])) : getCommandSenderAsPlayer(sender);
			if (entityplayermp.getCapability(ModCapabilities.CHEAT_MODE, null).getCheatMode()) {
				entityplayermp.getCapability(ModCapabilities.CHEAT_MODE, null).setCheatMode(false);
				TextHelper.sendFormattedChatMessage(args[1] + " is no longer in Cheat Mode", TextFormatting.RED, (EntityPlayer) sender.getCommandSenderEntity());
			} else {
				entityplayermp.getCapability(ModCapabilities.CHEAT_MODE, null).setCheatMode(true);
				TextHelper.sendFormattedChatMessage(args[1] + " is now in Cheat Mode", TextFormatting.GREEN, (EntityPlayer) sender.getCommandSenderEntity());
			}
		} else{
			TextHelper.sendFormattedChatMessage("Invalid arguments, usage: " + getCommandUsage(sender), TextFormatting.GREEN, (EntityPlayer) sender.getCommandSenderEntity());
		}
		PacketDispatcher.sendTo(new SyncCheatModeData(sender.getCommandSenderEntity().getCapability(ModCapabilities.CHEAT_MODE, null), sender.getCommandSenderEntity().getCapability(ModCapabilities.PLAYER_STATS, null)), (EntityPlayerMP) sender.getCommandSenderEntity());
	}
	
	@Override
	public boolean isUsernameIndex (String[] args, int index) {
		return false;
	}

	public static EntityPlayerMP getCommandSenderAsPlayer (ICommandSender sender) throws PlayerNotFoundException {
		if (sender instanceof EntityPlayerMP)
			return (EntityPlayerMP) sender;
		else
			throw new PlayerNotFoundException("You must specify which player you wish to perform this action on.", new Object[0]);
	}

	@Override
	public boolean checkPermission(MinecraftServer server, ICommandSender sender) {
		return sender.canCommandSenderUseCommand(getRequiredPermissionLevel(), getCommandName());
	}

	@Override
	public List<String> getTabCompletionOptions(MinecraftServer server, ICommandSender sender, String[] args, BlockPos pos) {
		return null;
	}
}