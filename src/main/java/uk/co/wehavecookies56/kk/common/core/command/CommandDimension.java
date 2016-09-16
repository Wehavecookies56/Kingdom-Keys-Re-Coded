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
import uk.co.wehavecookies56.kk.common.world.dimension.ModDimensions;
import uk.co.wehavecookies56.kk.common.world.dimension.TeleporterDiveToTheHeart;
import uk.co.wehavecookies56.kk.common.world.dimension.TeleporterOverworld;

public class CommandDimension implements ICommand {

	private List<String> aliases;

	public CommandDimension () {
		this.aliases = new ArrayList<String>();
		this.aliases.add("kkdimension");
	}

	@Override
	public int compareTo (ICommand arg0) {
		return 0;
	}

	@Override
	public String getCommandName () {
		return "dimension";
	}
	
	public int getRequiredPermissionLevel()
    {
        return 2;
    }

	@Override
	public String getCommandUsage (ICommandSender sender) {
		return "/dimension";
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
	
	public static EntityPlayer getPlayerFromUsername(String username)
    {
        if (FMLCommonHandler.instance().getEffectiveSide() == Side.CLIENT)
            return null;

        return FMLCommonHandler.instance().getMinecraftServerInstance().getPlayerList().getPlayerByUsername(username);
    }
	
	
	@Override
	public void execute (MinecraftServer server, ICommandSender sender, String[] args) throws CommandException {
		if (sender.getCommandSenderEntity() instanceof EntityPlayer) 
		{
			EntityPlayer player = null;
			if (args.length == 0) {
				player = getCommandSenderAsPlayer(sender);
			} else if (args.length == 1) {
				player = getPlayerFromUsername(args[0]);
			} else if (args.length > 1) {
				TextHelper.sendFormattedChatMessage("Invalid arguments, usage: " + getCommandUsage(sender), TextFormatting.RED, (EntityPlayer) sender.getCommandSenderEntity());
				return;
			}
			if(player != null)
			{
				if (!player.worldObj.isRemote)
				{
					if (player.dimension == ModDimensions.diveToTheHeartID)
					{
    					new TeleporterOverworld(player.worldObj.getMinecraftServer().getServer().worldServerForDimension(0)).teleport((player), player.worldObj);
					}
					else if(player.dimension == 0)
					{
						new TeleporterDiveToTheHeart(player.worldObj.getMinecraftServer().getServer().worldServerForDimension(ModDimensions.diveToTheHeartID)).teleport(player, player.worldObj);
					}
				}
			}
		}
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
	public List<String> getTabCompletionOptions(MinecraftServer server, ICommandSender sender, String[] args, BlockPos pos) {
		return null;
	}
}