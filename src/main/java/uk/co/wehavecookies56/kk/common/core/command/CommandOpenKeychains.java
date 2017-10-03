package uk.co.wehavecookies56.kk.common.core.command;

import net.minecraft.command.CommandException;
import net.minecraft.command.ICommand;
import net.minecraft.command.ICommandSender;
import net.minecraft.command.PlayerNotFoundException;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.util.text.TextFormatting;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.relauncher.Side;
import uk.co.wehavecookies56.kk.common.KingdomKeys;
import uk.co.wehavecookies56.kk.common.capability.ModCapabilities;
import uk.co.wehavecookies56.kk.common.core.helper.TextHelper;
import uk.co.wehavecookies56.kk.common.lib.GuiIDs;
import uk.co.wehavecookies56.kk.common.network.packet.PacketDispatcher;
import uk.co.wehavecookies56.kk.common.network.packet.client.SyncCheatModeData;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class CommandOpenKeychains implements ICommand {

    private List<String> aliases;

    public CommandOpenKeychains () {
        this.aliases = new ArrayList<String>();
        this.aliases.add("openkeychains");
    }

    @Override
    public int compareTo (ICommand arg0) {
        return 0;
    }

    @Override
    public String getName () {
        return "openkeychains";
    }

    public int getRequiredPermissionLevel () {
        return 2;
    }

    @Override
    public String getUsage (ICommandSender sender) {
        return "/openkeychains [player]";
    }

    @Override
    public List<String> getAliases () {
        return this.aliases;
    }


    @Override
    public void execute (MinecraftServer server, ICommandSender sender, String[] args) throws CommandException {
        if (args.length == 1) {
            if (getPlayerFromUsername(args[0]) != null) {
                getPlayerFromUsername(args[0]).openGui(KingdomKeys.instance, GuiIDs.GUI_KEYCHAIN_INV, getPlayerFromUsername(args[0]).world, (int)getPlayerFromUsername(args[0]).posX, (int)getPlayerFromUsername(args[0]).posY, (int)getPlayerFromUsername(args[0]).posZ);
            }
        } else {
            sender.sendMessage(new TextComponentTranslation(getUsage(sender)));
        }
    }

    @Override
    public boolean isUsernameIndex (String[] args, int index) {
        if (args.length == 1) {
            if (index == 0) {
                return true;
            }
        }
        return false;
    }

    public static EntityPlayer getPlayerFromUsername(String username) {
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
