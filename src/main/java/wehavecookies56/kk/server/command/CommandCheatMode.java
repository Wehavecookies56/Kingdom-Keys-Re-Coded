package wehavecookies56.kk.server.command;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.command.CommandException;
import net.minecraft.command.ICommand;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumChatFormatting;
import wehavecookies56.kk.entities.ExtendedPlayer;
import wehavecookies56.kk.util.TextHelper;

public class CommandCheatMode implements ICommand {

	private List aliases;
	public CommandCheatMode() {
		this.aliases = new ArrayList();
		this.aliases.add("cheatmode");
		this.aliases.add("kkcheatmode");
	}

	@Override
	public int compareTo(Object arg0) {
		return 0;
	}

	@Override
	public String getName() {
		return "cheatmode";
	}

	@Override
	public String getCommandUsage(ICommandSender sender) {
		return "/cheatmode";
	}

	@Override
	public List getAliases() {
		return this.aliases;
	}

	public static boolean isInteger(String s) {
		try {
			Integer.parseInt(s);
		} catch(NumberFormatException e) {
			return false;
		} catch(NullPointerException e) {
			return false;
		}
		return true;
	}

	@Override
	public void execute(ICommandSender sender, String[] args) throws CommandException {
		if(sender.getCommandSenderEntity() instanceof EntityPlayer){
			if(args.length == 0){
				if(ExtendedPlayer.get((EntityPlayer) sender.getCommandSenderEntity()).cheatMode)
				{
					ExtendedPlayer.get((EntityPlayer) sender.getCommandSenderEntity()).setCheatMode(false);
					TextHelper.sendFormattedChatMessage("You are no longer in Cheat Mode", EnumChatFormatting.RED, (EntityPlayer) sender.getCommandSenderEntity());
				}
				else
				{
					ExtendedPlayer.get((EntityPlayer) sender.getCommandSenderEntity()).setCheatMode(true);
					TextHelper.sendFormattedChatMessage("You are now in Cheat Mode", EnumChatFormatting.GREEN, (EntityPlayer) sender.getCommandSenderEntity());
				}
			}
		}
	}

	@Override
	public boolean canCommandSenderUse(ICommandSender sender) {
		if(sender.getCommandSenderEntity() instanceof EntityPlayer){
			return true;
		}
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
