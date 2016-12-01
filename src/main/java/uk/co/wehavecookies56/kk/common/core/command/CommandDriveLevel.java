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
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.relauncher.Side;
import uk.co.wehavecookies56.kk.common.core.helper.TextHelper;
import uk.co.wehavecookies56.kk.common.lib.Strings;
import uk.co.wehavecookies56.kk.common.network.packet.PacketDispatcher;
import uk.co.wehavecookies56.kk.common.network.packet.server.LevelUpDrive;
import uk.co.wehavecookies56.kk.common.util.Utils;

import javax.annotation.Nullable;

public class CommandDriveLevel implements ICommand {

	private List<String> aliases;

	public CommandDriveLevel () {
		this.aliases = new ArrayList<String>();
		this.aliases.add("leveldrive");
		this.aliases.add("kkdrivelevel");
	}

	@Override
	public int compareTo (ICommand arg0) {
		return 0;
	}

	@Override
	public String getName () {
		return "leveldrive";
	}

	public int getRequiredPermissionLevel () {
		return 2;
	}

	@Override
	public String getUsage (ICommandSender sender) {
		return "/leveldrive <form> [level (can be negative)]";
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
			if (args.length == 0 || args.length > 3)
				TextHelper.sendFormattedChatMessage("Invalid arguments, usage: " + getUsage(sender), TextFormatting.RED, (EntityPlayer) sender.getCommandSenderEntity());
			else if (args.length == 2) {
					int level = 1;
					try {
						if (Integer.parseInt(args[1]) < 1 || Integer.parseInt(args[1]) > 3) {
							TextHelper.sendFormattedChatMessage("Invalid level, it must be a number between 1 - 3", TextFormatting.RED, (EntityPlayer) sender.getCommandSenderEntity());
							return;
						} else
							level = Integer.parseInt(args[1]);
					} catch (Exception e) {
						TextHelper.sendFormattedChatMessage("Invalid level, it must be a number between 1 - 3", TextFormatting.RED, (EntityPlayer) sender.getCommandSenderEntity());
						return;
					}
					String form = null;
					switch(args[0])
					{
					case "valor":
						PacketDispatcher.sendToServer(new LevelUpDrive(Strings.Form_Valor, true, Integer.parseInt(args[1].toString()),player.getName()));
						form = Utils.translateToLocal(Strings.Form_Valor);
						break;
					case "wisdom":
						PacketDispatcher.sendToServer(new LevelUpDrive(Strings.Form_Wisdom, true, Integer.parseInt(args[1].toString()),player.getName()));
						form = Utils.translateToLocal(Strings.Form_Wisdom);
						break;
					case "limit":
						PacketDispatcher.sendToServer(new LevelUpDrive(Strings.Form_Limit, true, Integer.parseInt(args[1].toString()),player.getName()));
						form = Utils.translateToLocal(Strings.Form_Limit);
						break;
					case "master":
						PacketDispatcher.sendToServer(new LevelUpDrive(Strings.Form_Master, true, Integer.parseInt(args[1].toString()),player.getName()));
						form = Utils.translateToLocal(Strings.Form_Master);
						break;
					case "final":
						PacketDispatcher.sendToServer(new LevelUpDrive(Strings.Form_Final, true, Integer.parseInt(args[1].toString()),player.getName()));
						form = Utils.translateToLocal(Strings.Form_Final);
						break;
					}
					if(form != null)
						TextHelper.sendFormattedChatMessage("Succesfully leveled up "+form+" to level "+args[1], TextFormatting.YELLOW, (EntityPlayer) sender.getCommandSenderEntity());
					else
						TextHelper.sendFormattedChatMessage("Unknown form "+args[0], TextFormatting.RED, (EntityPlayer) sender.getCommandSenderEntity());

			} else if (args.length == 3) {
					if(FMLCommonHandler.instance().getMinecraftServerInstance().getPlayerList().getPlayerByUsername(args[2]) != null)
					{
						int level = 1;
						try {
							if (Integer.parseInt(args[1]) < 1 || Integer.parseInt(args[1]) > 3) {
								TextHelper.sendFormattedChatMessage("Invalid level, it must be a number between 1 - 3", TextFormatting.RED, (EntityPlayer) sender.getCommandSenderEntity());
								return;
							} else
								level = Integer.parseInt(args[1]);
						} catch (Exception e) {
							TextHelper.sendFormattedChatMessage("Invalid level, it must be a number between 1 - 3", TextFormatting.RED, (EntityPlayer) sender.getCommandSenderEntity());
							return;
						}
						String form = null;
						switch(args[0])
						{
						case "valor":
							PacketDispatcher.sendToServer(new LevelUpDrive(Strings.Form_Valor, true, Integer.parseInt(args[1].toString()),args[2]));
							form = Utils.translateToLocal(Strings.Form_Valor);
							break;
						case "wisdom":
							PacketDispatcher.sendToServer(new LevelUpDrive(Strings.Form_Wisdom, true, Integer.parseInt(args[1].toString()),args[2]));
							form = Utils.translateToLocal(Strings.Form_Wisdom);
							break;
						case "limit":
							PacketDispatcher.sendToServer(new LevelUpDrive(Strings.Form_Limit, true, Integer.parseInt(args[1].toString()),args[2]));
							form = Utils.translateToLocal(Strings.Form_Limit);
							break;
						case "master":
							PacketDispatcher.sendToServer(new LevelUpDrive(Strings.Form_Master, true, Integer.parseInt(args[1].toString()),args[2]));
							form = Utils.translateToLocal(Strings.Form_Master);
							break;
						case "final":
							PacketDispatcher.sendToServer(new LevelUpDrive(Strings.Form_Final, true, Integer.parseInt(args[1].toString()),args[2]));
							form = Utils.translateToLocal(Strings.Form_Final);
							break;
						}
						if(form != null)
							TextHelper.sendFormattedChatMessage("Succesfully leveled up "+form+" to level "+args[1]+" for player "+args[2], TextFormatting.YELLOW, (EntityPlayer) sender.getCommandSenderEntity());
						else
							TextHelper.sendFormattedChatMessage("Unknown form "+args[0], TextFormatting.RED, (EntityPlayer) sender.getCommandSenderEntity());
					}else{
						TextHelper.sendFormattedChatMessage("Invalid player" + args[2], TextFormatting.RED, (EntityPlayer) sender.getCommandSenderEntity());

					}
			} else
				TextHelper.sendFormattedChatMessage("Invalid arguments, usage: " + getUsage(sender), TextFormatting.RED, (EntityPlayer) sender.getCommandSenderEntity());
		}
	}

	public static EntityPlayer getPlayerFromUsername(String username)
    {
        if (FMLCommonHandler.instance().getEffectiveSide() == Side.CLIENT)
            return null;

        return FMLCommonHandler.instance().getMinecraftServerInstance().getPlayerList().getPlayerByUsername(username);
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