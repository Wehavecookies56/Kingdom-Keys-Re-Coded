package uk.co.wehavecookies56.kk.common.core.command;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.command.CommandException;
import net.minecraft.command.ICommand;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextFormatting;
import uk.co.wehavecookies56.kk.common.capability.ModCapabilities;
import uk.co.wehavecookies56.kk.common.capability.MunnyCapability.IMunny;
import uk.co.wehavecookies56.kk.common.core.helper.TextHelper;

import javax.annotation.Nullable;

public class CommandGiveMunny implements ICommand {

	private List<String> aliases;

	public CommandGiveMunny () {
		this.aliases = new ArrayList<String>();
		this.aliases.add("givemunny");
		this.aliases.add("addmunny");
		this.aliases.add("kkgivemunny");
	}

	@Override
	public int compareTo (ICommand arg0) {
		return 0;
	}

	@Override
	public String getName () {
		return "givemunny";
	}

	public int getRequiredPermissionLevel () {
		return 2;
	}

	@Override
	public String getUsage (ICommandSender sender) {
		return "/givemunny <value>";
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
		return false;
	}

	@Override
	public void execute(MinecraftServer server, ICommandSender sender, String[] args) throws CommandException {
		if (sender.getCommandSenderEntity() instanceof EntityPlayer) if (args.length == 0)
			TextHelper.sendFormattedChatMessage("Invalid arguments, usage \"/givemunny <amount>\"", TextFormatting.RED, (EntityPlayer) sender.getCommandSenderEntity());
		else {
			IMunny munny = ((EntityPlayer) sender.getCommandSenderEntity()).getCapability(ModCapabilities.MUNNY, null);
			if (!isInteger(args[0].toString()))
				TextHelper.sendFormattedChatMessage("Invalid arguments, usage \"/givemunny <amount>\"", TextFormatting.RED, (EntityPlayer) sender.getCommandSenderEntity());
			else if (Integer.parseInt(args[0].toString()) > Integer.MAX_VALUE || Integer.parseInt(args[0].toString()) < 0)
				TextHelper.sendFormattedChatMessage("Invalid arguments, enter a value between 0 and " + (Integer.MAX_VALUE - munny.getMunny()), TextFormatting.RED, (EntityPlayer) sender.getCommandSenderEntity());
			else if (Integer.parseInt(args[0].toString()) + munny.getMunny() > Integer.MAX_VALUE)
				TextHelper.sendFormattedChatMessage("Invalid arguments, adding this value would go over the maximum amount", TextFormatting.RED, (EntityPlayer) sender.getCommandSenderEntity());
			else {
				munny.addMunny(Integer.parseInt(args[0].toString()));
				TextHelper.sendFormattedChatMessage("Successfully added " + args[0].toString() + " munny", TextFormatting.GREEN, (EntityPlayer) sender.getCommandSenderEntity());
			}
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
