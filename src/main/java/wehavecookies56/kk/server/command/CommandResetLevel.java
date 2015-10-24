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

	public int getRequiredPermissionLevel()
    {
        return 2;
    }
	
	@Override
	public String getCommandUsage(ICommandSender sender) {
		return "/resetlevel [playername]";
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
				TextHelper.sendFormattedChatMessage("You level has been reset", EnumChatFormatting.YELLOW, (EntityPlayer) sender.getCommandSenderEntity());

			}
			else if(args.length == 1)
			{
	            EntityPlayerMP entityplayermp = args.length == 1 ? getPlayer(sender, args[0]) : getCommandSenderAsPlayer(sender);
	            ExtendedPlayer.get(entityplayermp).level = 1;
				ExtendedPlayer.get(entityplayermp).experience = 0;
				ExtendedPlayer.get(entityplayermp).setStrength(1);
				ExtendedPlayer.get(entityplayermp).setDefense(1);
				ExtendedPlayer.get(entityplayermp).setMagic(1);
				ExtendedPlayer.get(entityplayermp).setHP(20);
				player.heal(ExtendedPlayer.get(entityplayermp).getHP());
				TextHelper.sendFormattedChatMessage(args[0]+"'s level has been reset", EnumChatFormatting.YELLOW, (EntityPlayer) sender.getCommandSenderEntity());

			}
			else
			{
				TextHelper.sendFormattedChatMessage("Invalid arguments, usage: /resetlevel [player]", EnumChatFormatting.RED, (EntityPlayer) sender.getCommandSenderEntity());
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
