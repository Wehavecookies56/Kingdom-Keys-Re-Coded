package uk.co.wehavecookies56.kk.common.core.command;

import java.util.ArrayList;
import java.util.List;

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
import uk.co.wehavecookies56.kk.common.network.packet.client.SyncHudData;

import javax.annotation.Nullable;

public class CommandShowHud implements ICommand {

	private List<String> aliases;

	public CommandShowHud () {
		this.aliases = new ArrayList<String>();
		this.aliases.add("kkshowhud");
	}

	@Override
	public int compareTo (ICommand arg0) {
		return 0;
	}

	@Override
	public String getName () {
		return "showhud";
	}
	
	public int getRequiredPermissionLevel()
    {
        return 1;
    }

	@Override
	public String getUsage (ICommandSender sender) {
		return "/showhud";
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
	public void execute (MinecraftServer server, ICommandSender sender, String[] args) throws CommandException {
		if (sender.getCommandSenderEntity() instanceof EntityPlayer) if (args.length == 0) {
			if (sender.getCommandSenderEntity().getCapability(ModCapabilities.PLAYER_STATS, null).getHudMode()) {
				sender.getCommandSenderEntity().getCapability(ModCapabilities.PLAYER_STATS, null).setHudMode(false);
			} else {
				sender.getCommandSenderEntity().getCapability(ModCapabilities.PLAYER_STATS, null).setHudMode(true);
			}
		} else if (args.length == 1) {
			TextHelper.sendFormattedChatMessage("Invalid arguments, usage: " + getUsage(sender), TextFormatting.GREEN, (EntityPlayer) sender.getCommandSenderEntity());
		}
		PacketDispatcher.sendTo(new SyncHudData(sender.getCommandSenderEntity().getCapability(ModCapabilities.PLAYER_STATS, null)), (EntityPlayerMP) sender.getCommandSenderEntity());
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
		return true;
	}

	@Override
	public List<String> getTabCompletions(MinecraftServer server, ICommandSender sender, String[] args, @Nullable BlockPos pos) {
		return null;
	}
}