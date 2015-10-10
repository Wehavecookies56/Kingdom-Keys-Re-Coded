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
import wehavecookies56.kk.network.packet.PacketDispatcher;
import wehavecookies56.kk.network.packet.client.SyncExtendedPlayer;
import wehavecookies56.kk.util.TextHelper;

public class CommandResetLevel implements ICommand {

	private List aliases;
	public CommandResetLevel() {
		this.aliases = new ArrayList();
		this.aliases.add("resetlevel");
		this.aliases.add("kkresetlevel");
	}

	@Override
	public int compareTo(Object arg0) {
		return 0;
	}

	@Override
	public String getName() {
		return "resetlevel";
	}

	@Override
	public String getCommandUsage(ICommandSender sender) {
		return "/resetlevel";
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
			EntityPlayer player = (EntityPlayer) sender.getCommandSenderEntity();
			if(args.length == 0){
				ExtendedPlayer.get(player).level = 1;
				ExtendedPlayer.get(player).experience = 0;
				ExtendedPlayer.get(player).setStrength(1);
				ExtendedPlayer.get(player).setDefense(1);
				ExtendedPlayer.get(player).setMagic(1);
				ExtendedPlayer.get(player).setHP(20);
				player.heal(ExtendedPlayer.get(player).getHP());
				PacketDispatcher.sendToServer(new SyncExtendedPlayer(player));
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
