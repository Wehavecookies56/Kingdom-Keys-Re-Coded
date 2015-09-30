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

public class CommandRemoveKeychain implements ICommand {

	private List aliases;
	public CommandRemoveKeychain() {
		this.aliases = new ArrayList();
		this.aliases.add("kkremovechain");
	}

	@Override
	public int compareTo(Object arg0) {
		return 0;
	}

	@Override
	public String getName() {
		return "removechain";
	}

	@Override
	public String getCommandUsage(ICommandSender sender) {
		return "/removechain";
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
			if(args.length != 2)
			{
				TextHelper.sendFormattedChatMessage("Invalid arguments! Usage: /removechain <player> <boolean (true/false)>", EnumChatFormatting.RED, (EntityPlayer) sender.getCommandSenderEntity());
			}
			else
			{
				if(args[1].toString().equals("true"))
				{
					System.out.println(ExtendedPlayer.get((EntityPlayer)sender.getCommandSenderEntity()).keybladeSummoned);
					if(ExtendedPlayer.get((EntityPlayer)sender.getCommandSenderEntity()).isKeybladeSummoned())
					{
//TODO What's missing
					}
					TextHelper.sendFormattedChatMessage(args[0]+"'s keychain has been removed!", EnumChatFormatting.YELLOW, (EntityPlayer) sender.getCommandSenderEntity());
				}
				else if(args[1].toString().equals("false"))
				{
					TextHelper.sendFormattedChatMessage(args[0]+"'s keychain has been stored in his normal inventory!", EnumChatFormatting.YELLOW, (EntityPlayer) sender.getCommandSenderEntity());
				}
				else
				{
					TextHelper.sendFormattedChatMessage("Second argument must be a boolean (true/false)", EnumChatFormatting.RED, (EntityPlayer) sender.getCommandSenderEntity());
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
