package uk.co.wehavecookies56.kk.common.core.command;

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

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class CommandResetLevel implements ICommand {

    private List<String> aliases;

    public CommandResetLevel () {
        this.aliases = new ArrayList<String>();
        this.aliases.add("resetlevel");
        this.aliases.add("kkresetlevel");
    }

    @Override
    public int compareTo (ICommand arg0) {
        return 0;
    }

    @Override
    public String getName () {
        return "resetlevel";
    }

    public int getRequiredPermissionLevel () {
        return 2;
    }

    @Override
    public String getUsage (ICommandSender sender) {
        return "/resetlevel [playername]";
    }

    @Override
    public List getAliases () {
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
            if (args.length == 0) {
                player.getCapability(ModCapabilities.PLAYER_STATS, null).setLevel(1);
                player.getCapability(ModCapabilities.PLAYER_STATS, null).setExperience(0);
                player.getCapability(ModCapabilities.PLAYER_STATS, null).setStrength(1);
                player.getCapability(ModCapabilities.PLAYER_STATS, null).setDefense(1);
                player.getCapability(ModCapabilities.PLAYER_STATS, null).setMagic(1);
                player.getCapability(ModCapabilities.PLAYER_STATS, null).setHP(20);
                player.heal(player.getCapability(ModCapabilities.PLAYER_STATS, null).getHP());
                TextHelper.sendFormattedChatMessage("You level has been reset", TextFormatting.YELLOW, (EntityPlayer) sender.getCommandSenderEntity());

            } else if (args.length == 1) {
                EntityPlayerMP entityplayermp = args.length == 1 ? server.getPlayerList().getPlayerByUUID(UUID.fromString(args[0])) : getCommandSenderAsPlayer(sender);
                entityplayermp.getCapability(ModCapabilities.PLAYER_STATS, null).setLevel(1);
                entityplayermp.getCapability(ModCapabilities.PLAYER_STATS, null).setExperience(0);
                entityplayermp.getCapability(ModCapabilities.PLAYER_STATS, null).setStrength(1);
                entityplayermp.getCapability(ModCapabilities.PLAYER_STATS, null).setDefense(1);
                entityplayermp.getCapability(ModCapabilities.PLAYER_STATS, null).setMagic(1);
                entityplayermp.getCapability(ModCapabilities.PLAYER_STATS, null).setHP(20);
                player.heal(entityplayermp.getCapability(ModCapabilities.PLAYER_STATS, null).getHP());
                TextHelper.sendFormattedChatMessage(args[0] + "'s level has been reset", TextFormatting.YELLOW, (EntityPlayer) sender.getCommandSenderEntity());

            } else
                TextHelper.sendFormattedChatMessage("Invalid arguments, usage: " + getUsage(sender), TextFormatting.RED, (EntityPlayer) sender.getCommandSenderEntity());
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
