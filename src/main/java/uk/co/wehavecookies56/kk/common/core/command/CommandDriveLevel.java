package uk.co.wehavecookies56.kk.common.core.command;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.command.CommandException;
import net.minecraft.command.ICommand;
import net.minecraft.command.ICommandSender;
import net.minecraft.command.PlayerNotFoundException;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.math.BlockPos;
import uk.co.wehavecookies56.kk.common.lib.Strings;
import uk.co.wehavecookies56.kk.common.network.packet.PacketDispatcher;
import uk.co.wehavecookies56.kk.common.network.packet.server.LevelUpDrive;

public class CommandDriveLevel implements ICommand {

	private List<String> aliases;

	public CommandDriveLevel () {
		this.aliases = new ArrayList<String>();
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
		return "/drivelevel <form> [level (can be negative)]";
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
	public void execute(MinecraftServer server, ICommandSender sender, String[] args) throws CommandException {
		if(sender.getCommandSenderEntity().worldObj.isRemote)
		{
			switch(args[0])
			{
			case "valor":
				PacketDispatcher.sendToServer(new LevelUpDrive(Strings.Form_Valor, true, Integer.parseInt(args[1].toString())));
				break;
			case "wisdom":
				PacketDispatcher.sendToServer(new LevelUpDrive(Strings.Form_Wisdom, true, Integer.parseInt(args[1].toString())));
				break;
			case "limit":
				PacketDispatcher.sendToServer(new LevelUpDrive(Strings.Form_Limit, true, Integer.parseInt(args[1].toString())));
				break;
			case "master":
				PacketDispatcher.sendToServer(new LevelUpDrive(Strings.Form_Master, true, Integer.parseInt(args[1].toString())));
				break;
			case "final":
				PacketDispatcher.sendToServer(new LevelUpDrive(Strings.Form_Final, true, Integer.parseInt(args[1].toString())));
				break;
			}
		}
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