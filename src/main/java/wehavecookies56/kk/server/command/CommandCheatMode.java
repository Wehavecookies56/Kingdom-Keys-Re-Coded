package wehavecookies56.kk.server.command;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import net.minecraft.command.CommandException;
import net.minecraft.command.ICommand;
import net.minecraft.command.ICommandSender;
import net.minecraft.command.PlayerNotFoundException;
import net.minecraft.command.PlayerSelector;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.server.MinecraftServer;
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

	public int getRequiredPermissionLevel()
    {
        return 2;
    }
	
	@Override
	public String getCommandUsage(ICommandSender sender) {
		return "/cheatmode [player]";
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
			else if(args.length == 1)
			{
	            EntityPlayerMP entityplayermp = args.length == 1 ? getPlayer(sender, args[0]) : getCommandSenderAsPlayer(sender);
	            if(ExtendedPlayer.get((EntityPlayer) entityplayermp).cheatMode)
				{
					ExtendedPlayer.get((EntityPlayer) entityplayermp).setCheatMode(false);
					TextHelper.sendFormattedChatMessage(args[1]+" is no longer in Cheat Mode", EnumChatFormatting.RED, (EntityPlayer) sender.getCommandSenderEntity());
				}
				else
				{
					ExtendedPlayer.get((EntityPlayer) entityplayermp).setCheatMode(true);
					TextHelper.sendFormattedChatMessage(args[1]+" is now in Cheat Mode", EnumChatFormatting.GREEN, (EntityPlayer) sender.getCommandSenderEntity());
				}
			}
			else
			{
				TextHelper.sendFormattedChatMessage("Invalid arguments, usage: "+getCommandUsage(sender), EnumChatFormatting.GREEN, (EntityPlayer) sender.getCommandSenderEntity());
			}
		}
	}

	@Override
	public boolean canCommandSenderUse(ICommandSender sender)
    {
        return sender.canUseCommand(this.getRequiredPermissionLevel(), this.getName());
    }

	@Override
	public List addTabCompletionOptions(ICommandSender sender, String[] args, BlockPos pos) {
		return null;
	}

	@Override
	public boolean isUsernameIndex(String[] args, int index) {
		return false;
	}
	
	public static EntityPlayerMP getCommandSenderAsPlayer(ICommandSender sender) throws PlayerNotFoundException
	{
	    if (sender instanceof EntityPlayerMP)
	    {
	        return (EntityPlayerMP)sender;
	    }
	    else
	    {
	        throw new PlayerNotFoundException("You must specify which player you wish to perform this action on.", new Object[0]);
	    }
	}
	public static EntityPlayerMP getPlayer(ICommandSender sender, String username) throws PlayerNotFoundException
    {
        EntityPlayerMP entityplayermp = PlayerSelector.matchOnePlayer(sender, username);

        if (entityplayermp == null)
        {
            try
            {
                entityplayermp = MinecraftServer.getServer().getConfigurationManager().getPlayerByUUID(UUID.fromString(username));
            }
            catch (IllegalArgumentException illegalargumentexception)
            {
                ;
            }
        }

        if (entityplayermp == null)
        {
            entityplayermp = MinecraftServer.getServer().getConfigurationManager().getPlayerByUsername(username);
        }

        if (entityplayermp == null)
        {
            throw new PlayerNotFoundException();
        }
        else
        {
            return entityplayermp;
        }
    }
}