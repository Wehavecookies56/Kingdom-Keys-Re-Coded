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
import uk.co.wehavecookies56.kk.common.capability.ModCapabilities;
import uk.co.wehavecookies56.kk.common.capability.TutorialsCapability.ITutorials;
import uk.co.wehavecookies56.kk.common.core.helper.TextHelper;
import uk.co.wehavecookies56.kk.common.lib.Tutorial;
import uk.co.wehavecookies56.kk.common.network.packet.PacketDispatcher;
import uk.co.wehavecookies56.kk.common.network.packet.client.SyncTutorials;

public class CommandRemoveTutorial implements ICommand {

    private List<String> aliases;

    public CommandRemoveTutorial () {
        this.aliases = new ArrayList<String>();
        this.aliases.add("kkremovetutorial");
    }

    @Override
    public int compareTo (ICommand arg0) {
        return 0;
    }

    @Override
    public String getName () {
        return "removetutorial";
    }

    public int getRequiredPermissionLevel () {
        return 2;
    }

    @Override
    public String getUsage (ICommandSender sender) {
        return "/"+getName();
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
        return true;
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
            if (args.length != 1) {
                TextHelper.sendFormattedChatMessage("Invalid arguments, usage: " + getUsage(sender), TextFormatting.RED, (EntityPlayer) sender.getCommandSenderEntity());
            }else{                     
                EntityPlayer player = (EntityPlayer) sender.getCommandSenderEntity();
            	ITutorials TUTORIALS = player.getCapability(ModCapabilities.TUTORIALS, null);

                if(isInteger(args[0])) {
                	int id = Integer.parseInt(args[0]);
                	
                	if(TUTORIALS.getKnownTutorial(id)) {
                		TUTORIALS.setKnownTutorial(id, false);
                		PacketDispatcher.sendTo(new SyncTutorials(TUTORIALS), (EntityPlayerMP) player);
                	}
                } else {
                	if(args[0].equals("all")) {
                		for(int i=0;i<TUTORIALS.getKnownTutorials().size();i++) {
                			TUTORIALS.setKnownTutorial(TUTORIALS.getKnownTutorials().get(i), false);
                		}
                		/*
                		TUTORIALS.setKnownTutorials(new ArrayList<Integer>());*/
                		PacketDispatcher.sendTo(new SyncTutorials(TUTORIALS), (EntityPlayerMP) player);
                	}
                }
            }
        }
    }

    public static EntityPlayer getPlayerFromUsername(String username) {
        if (FMLCommonHandler.instance().getEffectiveSide() == Side.CLIENT)
            return null;

        return FMLCommonHandler.instance().getMinecraftServerInstance().getPlayerList().getPlayerByUsername(username);
    }
    
    public static boolean isNumber(String num) {
    	try {
        	//Parse the given level
            int number = Integer.parseInt(num);
            return true;
        } catch (Exception e) {
            return false;
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
