package wehavecookies56.kk.server.command;

import java.util.List;

import net.minecraft.command.CommandException;
import net.minecraft.command.ICommand;
import net.minecraft.command.ICommandSender;
import net.minecraft.util.BlockPos;

public class CommandLearnRecipe implements ICommand {

	@Override
	public int compareTo(Object arg0) {
		return 0;
	}

	@Override
	public String getCommandName() {
		return null;
	}

	@Override
	public String getCommandUsage(ICommandSender sender) {
		return null;
	}

	@Override
	public List getCommandAliases() {
		return null;
	}

	@Override
	public void processCommand(ICommandSender sender, String[] args) throws CommandException {

	}

	@Override
	public boolean canCommandSenderUseCommand(ICommandSender sender) {
		return false;
	}

	@Override
	public List addTabCompletionOptions(ICommandSender sender, String[] args, BlockPos pos) {
		return null;
	}

	@Override
	public boolean isUsernameIndex(String[] args, int index) {
		return false;
	}

}
