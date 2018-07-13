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
import uk.co.wehavecookies56.kk.common.capability.AbilitiesCapability.IAbilities;
import uk.co.wehavecookies56.kk.common.capability.ModCapabilities;
import uk.co.wehavecookies56.kk.common.capability.PlayerStatsCapability;
import uk.co.wehavecookies56.kk.common.core.helper.TextHelper;
import uk.co.wehavecookies56.kk.common.lib.Strings;
import uk.co.wehavecookies56.kk.common.network.packet.PacketDispatcher;
import uk.co.wehavecookies56.kk.common.network.packet.client.SyncAbilities;
import uk.co.wehavecookies56.kk.common.network.packet.client.SyncLevelData;

public class CommandLevelUp implements ICommand {

    private List<String> aliases;

    public CommandLevelUp () {
        this.aliases = new ArrayList<String>();
        this.aliases.add("levelup");
        this.aliases.add("kklevelup");
    }

    @Override
    public int compareTo (ICommand arg0) {
        return 0;
    }

    @Override
    public String getName () {
        return "levelup";
    }

    public int getRequiredPermissionLevel () {
        return 2;
    }

    @Override
    public String getUsage (ICommandSender sender) {
        return "/levelup <level> [player] (level has to be between 1-100)";
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
    public static EntityPlayer getPlayerFromUsername(String username) {
        if (FMLCommonHandler.instance().getEffectiveSide() == Side.CLIENT)
            return null;

        return FMLCommonHandler.instance().getMinecraftServerInstance().getPlayerList().getPlayerByUsername(username);
    }
    @Override
    public void execute(MinecraftServer server, ICommandSender sender, String[] args) throws CommandException {
        if (sender.getCommandSenderEntity() instanceof EntityPlayer) {
            EntityPlayer player = (EntityPlayer) sender.getCommandSenderEntity();
            if (args.length == 0 || args.length > 2)
                TextHelper.sendFormattedChatMessage("Invalid arguments, usage: " + getUsage(sender), TextFormatting.RED, (EntityPlayer) sender.getCommandSenderEntity());
            else if (args.length == 1) {
                int level = 1;
                try {
                    if (Integer.parseInt(args[0]) < 1 || Integer.parseInt(args[0]) > 100) {
                        TextHelper.sendFormattedChatMessage("Invalid level, it must be a number between 1 - 100", TextFormatting.RED, (EntityPlayer) sender.getCommandSenderEntity());
                        return;
                    } else
                        level = Integer.parseInt(args[0]);
                } catch (Exception e) {
                    TextHelper.sendFormattedChatMessage("Invalid level, it must be a number between 1 - 100", TextFormatting.RED, (EntityPlayer) sender.getCommandSenderEntity());
                    return;
                }
                PlayerStatsCapability.IPlayerStats STATS = player.getCapability(ModCapabilities.PLAYER_STATS, null);
                IAbilities ABILITIES = player.getCapability(ModCapabilities.ABILITIES, null);

                STATS.setLevel(1);
                STATS.setExperience(0);
				if(STATS.getChoice1().equals(Strings.Choice_Sword)) 
					STATS.setStrength(3);
                else
                	STATS.setStrength(1);
				
				if(STATS.getChoice1().equals(Strings.Choice_Shield)) 
					STATS.setDefense(3);
                else
                	STATS.setDefense(1);
				
				if(STATS.getChoice1().equals(Strings.Choice_Staff))
					STATS.setMagic(3);
                else 
                	STATS.setMagic(1);
				
                STATS.setHP(20);
                player.setHealth(20);
                STATS.setMaxMP(20);
                STATS.setMP(STATS.getMaxMP());
                ABILITIES.clearUnlockedAbilities();


                while (STATS.getLevel() < level)
                    STATS.addExperience(player, STATS.getExpNeeded(level - 1, STATS.getExperience()));
                player.heal(STATS.getHP());
                TextHelper.sendFormattedChatMessage("Your level is now " + args[0], TextFormatting.YELLOW, (EntityPlayer) sender.getCommandSenderEntity());
                PacketDispatcher.sendTo(new SyncLevelData(player.getCapability(ModCapabilities.PLAYER_STATS, null)), (EntityPlayerMP) player);
                PacketDispatcher.sendTo(new SyncAbilities(ABILITIES), (EntityPlayerMP) player);

            } else if (args.length == 2) {
                int level = 1;
                try {
                    if (Integer.parseInt(args[0]) < 1 || Integer.parseInt(args[0]) > 100) {
                        TextHelper.sendFormattedChatMessage("Invalid level, it must be a number between 1 - 100", TextFormatting.RED, (EntityPlayer) sender.getCommandSenderEntity());
                        return;
                    } else
                        level = Integer.parseInt(args[0]);
                } catch (Exception e) {
                    TextHelper.sendFormattedChatMessage("Invalid level, it must be a number between 1 - 100", TextFormatting.RED, (EntityPlayer) sender.getCommandSenderEntity());
                    return;
                }
                EntityPlayerMP entityplayermp = args.length == 2 ?  (EntityPlayerMP) getPlayerFromUsername(args[1]) : getCommandSenderAsPlayer(sender);
                PlayerStatsCapability.IPlayerStats STATS = entityplayermp.getCapability(ModCapabilities.PLAYER_STATS, null);
                IAbilities ABILITIES = entityplayermp.getCapability(ModCapabilities.ABILITIES, null);

                STATS.setLevel(1);
                STATS.setExperience(0);
				if(STATS.getChoice1().equals(Strings.Choice_Sword)) STATS.setStrength(3);
                else STATS.setStrength(1);
				if(STATS.getChoice1().equals(Strings.Choice_Shield)) STATS.setDefense(3);
                else STATS.setDefense(1);
				if(STATS.getChoice1().equals(Strings.Choice_Staff)) STATS.setMagic(3);
                else STATS.setMagic(1);
                STATS.setHP(20);
                entityplayermp.setHealth(20);
                ABILITIES.clearUnlockedAbilities();

                while (STATS.getLevel() < level)
                    STATS.addExperience(entityplayermp, STATS.getExpNeeded(level - 1, STATS.getExperience()));
                entityplayermp.heal(STATS.getHP());
                TextHelper.sendFormattedChatMessage(args[1] + "'s level is now " + args[0], TextFormatting.YELLOW, (EntityPlayer) sender.getCommandSenderEntity());
                TextHelper.sendFormattedChatMessage("Your level is now " + args[0], TextFormatting.YELLOW, (EntityPlayer) entityplayermp);

                PacketDispatcher.sendTo(new SyncLevelData(entityplayermp.getCapability(ModCapabilities.PLAYER_STATS, null)), (EntityPlayerMP) entityplayermp);
                PacketDispatcher.sendTo(new SyncAbilities(ABILITIES), (EntityPlayerMP) entityplayermp);

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
