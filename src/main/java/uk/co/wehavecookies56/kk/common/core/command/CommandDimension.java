package uk.co.wehavecookies56.kk.common.core.command;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Nullable;

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
import uk.co.wehavecookies56.kk.common.util.IDAndBlockPos;
import uk.co.wehavecookies56.kk.common.util.Utils;
import uk.co.wehavecookies56.kk.common.world.dimension.DimTeleporter;

public class CommandDimension implements ICommand {

    private List<String> aliases;

    public CommandDimension () {
        this.aliases = new ArrayList<String>();
        this.aliases.add("kkdimension");
        this.aliases.add("kkdim");
    }

    @Override
    public int compareTo (ICommand arg0) {
        return 0;
    }

    @Override
    public String getName () {
        return "dimension";
    }

    public int getRequiredPermissionLevel()
    {
        return 2;
    }

    @Override
    public String getUsage (ICommandSender sender) {
        return "/kkdimension <dimension> [player] (soa, traversetown, destinyislands, overworld)";
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

    public static EntityPlayer getPlayerFromUsername(String username) {
        return FMLCommonHandler.instance().getEffectiveSide() == Side.CLIENT ? null : FMLCommonHandler.instance().getMinecraftServerInstance().getPlayerList().getPlayerByUsername(username);
    }


    @Override
    public void execute (MinecraftServer server, ICommandSender sender, String[] args) throws CommandException {
		EntityPlayer player = null;
		if (args.length == 1) {
			player = getCommandSenderAsPlayer(sender);
		} else if (args.length == 2) {
			player = getPlayerFromUsername(args[1]);
			System.out.println(args[1]);
		} else if (args.length > 2 || args.length < 1) {
			TextHelper.sendFormattedChatMessage("Invalid arguments, usage: " + getUsage(sender), TextFormatting.RED, (EntityPlayer) sender.getCommandSenderEntity());
			return;
		}
		if (player != null) {
			if (!player.world.isRemote) {
				String dimension = args[0].toLowerCase();

				IDAndBlockPos idAndBlockPos = Utils.getDimensionIDAndBlockPos(dimension);
				DimTeleporter tp = new DimTeleporter(idAndBlockPos.pos, idAndBlockPos.id);

				if (player.world.provider.getDimension() != idAndBlockPos.id) {
					player.changeDimension(idAndBlockPos.id, tp);
				} else {
					tp.placeEntity(player.getEntityWorld(), player, player.rotationYaw);
				}
			}
		} else {
			TextHelper.sendFormattedChatMessage("Invalid player, usage: " + getUsage(sender), TextFormatting.RED, (EntityPlayer) sender.getCommandSenderEntity());
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
    public List<String> getTabCompletions(MinecraftServer server, ICommandSender sender, String[] args, @Nullable BlockPos pos) {
        return null;
    }
}