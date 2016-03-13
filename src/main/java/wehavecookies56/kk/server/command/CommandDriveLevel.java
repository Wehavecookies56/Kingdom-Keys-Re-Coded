package wehavecookies56.kk.server.command;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import net.minecraft.command.CommandException;
import net.minecraft.command.ICommand;
import net.minecraft.command.ICommandSender;
import net.minecraft.command.PlayerNotFoundException;
import net.minecraft.command.PlayerSelector;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.BlockPos;
import wehavecookies56.kk.lib.Strings;
import wehavecookies56.kk.network.packet.PacketDispatcher;
import wehavecookies56.kk.network.packet.server.LevelUpDrive;

public class CommandDriveLevel implements ICommand {

	private List aliases;

	public CommandDriveLevel () {
		this.aliases = new ArrayList();
		this.aliases.add("drivelevel");
	}

	@Override
	public int compareTo (ICommand arg0) {
		return 0;
	}

	@Override
	public String getCommandName () {
		return "drivelevel";
	}

	public int getRequiredPermissionLevel () {
		return 2;
	}

	@Override
	public String getCommandUsage (ICommandSender sender) {
		return "/drivelevel <form> [player]";
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
	public void processCommand (ICommandSender sender, String[] args) throws CommandException {
		switch(args[0])
		{
		case "valor":
			PacketDispatcher.sendToServer(new LevelUpDrive(Strings.Form_Valor, true));
			break;
		case "wisdom":
			PacketDispatcher.sendToServer(new LevelUpDrive(Strings.Form_Wisdom, true));
			break;
		case "limit":
			PacketDispatcher.sendToServer(new LevelUpDrive(Strings.Form_Limit, true));
			break;
		case "master":
			PacketDispatcher.sendToServer(new LevelUpDrive(Strings.Form_Master, true));
			break;
		case "final":
			PacketDispatcher.sendToServer(new LevelUpDrive(Strings.Form_Final, true));
			break;
		}
	}

	@Override
	public boolean canCommandSenderUseCommand (ICommandSender sender) {
		return sender.canCommandSenderUseCommand(getRequiredPermissionLevel(), getCommandName());
	}

	@Override
	public List addTabCompletionOptions (ICommandSender sender, String[] args, BlockPos pos) {
		return null;
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

	public static EntityPlayerMP getPlayer (ICommandSender sender, String username) throws PlayerNotFoundException {
		EntityPlayerMP entityplayermp = PlayerSelector.matchOnePlayer(sender, username);

		if (entityplayermp == null) try {
			entityplayermp = MinecraftServer.getServer().getConfigurationManager().getPlayerByUUID(UUID.fromString(username));
		} catch (IllegalArgumentException illegalargumentexception) {
			;
		}

		if (entityplayermp == null) entityplayermp = MinecraftServer.getServer().getConfigurationManager().getPlayerByUsername(username);

		if (entityplayermp == null)
			throw new PlayerNotFoundException();
		else
			return entityplayermp;
	}
}