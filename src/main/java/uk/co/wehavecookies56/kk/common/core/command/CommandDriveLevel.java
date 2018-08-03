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
import uk.co.wehavecookies56.kk.api.abilities.Ability;
import uk.co.wehavecookies56.kk.common.ability.ModAbilities;
import uk.co.wehavecookies56.kk.common.capability.AbilitiesCapability.IAbilities;
import uk.co.wehavecookies56.kk.common.capability.DriveStateCapability.IDriveState;
import uk.co.wehavecookies56.kk.common.capability.ModCapabilities;
import uk.co.wehavecookies56.kk.common.core.helper.TextHelper;
import uk.co.wehavecookies56.kk.common.lib.Strings;
import uk.co.wehavecookies56.kk.common.network.packet.PacketDispatcher;
import uk.co.wehavecookies56.kk.common.network.packet.client.SyncDriveData;
import uk.co.wehavecookies56.kk.common.network.packet.client.SyncUnlockedAbilities;
import uk.co.wehavecookies56.kk.common.util.Utils;

public class CommandDriveLevel implements ICommand {

    private List<String> aliases;

    public CommandDriveLevel () {
        this.aliases = new ArrayList<String>();
        this.aliases.add("kkleveldrive");
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
        return "/leveldrive <form> <level> [player]";
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
            else if (args.length >= 2 && args.length <= 3) {
            	//Get the player
            	
            	if(args.length == 3) {
                    if(getPlayerFromUsername(args[2]) != null) {
                    	player = getPlayerFromUsername(args[2]);
                    }
            	}
            	
                int level = 1;
                try {
                	//Parse the given level
                    if (Integer.parseInt(args[1]) < 1 || Integer.parseInt(args[1]) > 7) {
                        TextHelper.sendFormattedChatMessage("Invalid level, it must be a number between 1 - 7", TextFormatting.RED, (EntityPlayer) sender.getCommandSenderEntity());
                        return;
                    } else
                        level = Integer.parseInt(args[1]);
                    
                } catch (Exception e) {
                    TextHelper.sendFormattedChatMessage("Invalid level, it must be a number between 1 - 7", TextFormatting.RED, (EntityPlayer) sender.getCommandSenderEntity());
                    return;
                }
                
                IDriveState DRIVE = player.getCapability(ModCapabilities.DRIVE_STATE, null);
                String form = null;
                int oldLevel = DRIVE.getDriveLevel("form."+args[0].toLowerCase());
                int newLevel = Integer.parseInt(args[1].toString());
                //System.out.println("Old: "+oldLevel+"\tNew: "+newLevel);
                IAbilities ABILITIES = player.getCapability(ModCapabilities.ABILITIES, null);
                Ability ability = null;
                String name = "";
                switch(args[0].toLowerCase()){
                case "valor":
                	ability = ModAbilities.highJump;
                	name = Strings.Form_Valor;
                    break;
                case "wisdom":
                	ability = ModAbilities.quickRun;
                	name = Strings.Form_Wisdom;
                    break;
                case "limit":
                	ability = ModAbilities.dodgeRoll;
                	name = Strings.Form_Limit;
                	break;
                case "master":
                	ability = ModAbilities.aerialDodge;
                	name = Strings.Form_Master;
                    break;
                case "final":
                	ability = ModAbilities.glide;
                	name = Strings.Form_Final;
                    break;
                }
                
                DRIVE.setDriveLevel(name, newLevel);
            	if(DRIVE.getDriveLevel(name) >= 3) {
            		if(!ABILITIES.getUnlockedAbility(ability))
        				ABILITIES.unlockAbility(ability);
            	}
                form = Utils.translateToLocal(name);
				PacketDispatcher.sendTo(new SyncUnlockedAbilities(player.getCapability(ModCapabilities.ABILITIES, null)), (EntityPlayerMP) player);

                DRIVE.displayLevelUpMessage(player,"form."+args[0].toLowerCase()); 

                if(oldLevel != 7 && newLevel == 7) {
                	//Increase
                	DRIVE.setDriveGaugeLevel(DRIVE.getDriveGaugeLevel()+1);
                	DRIVE.setDP(DRIVE.getMaxDP());
                    PacketDispatcher.sendTo(new SyncDriveData(DRIVE), (EntityPlayerMP) player);

                } else if(oldLevel == 7 && newLevel != 7) {
                	//Decrease
                	DRIVE.setDriveGaugeLevel(DRIVE.getDriveGaugeLevel()-1);
                	DRIVE.setDP(DRIVE.getMaxDP());
                    PacketDispatcher.sendTo(new SyncDriveData(DRIVE), (EntityPlayerMP) player);
                }
                //PacketDispatcher.sendTo(new SyncDriveData(player.getCapability(ModCapabilities.DRIVE_STATE, null)), (EntityPlayerMP) player);

                if(form != null) {
                	if(args.length == 3)
                		TextHelper.sendFormattedChatMessage("Succesfully leveled up "+form+" to level "+args[1]+" for player "+args[2], TextFormatting.YELLOW, (EntityPlayer) sender.getCommandSenderEntity());
                	else
                		TextHelper.sendFormattedChatMessage("Succesfully leveled up "+form+" to level "+args[1], TextFormatting.YELLOW, (EntityPlayer) sender.getCommandSenderEntity());
               }else {
                    TextHelper.sendFormattedChatMessage("Unknown form "+args[0], TextFormatting.RED, (EntityPlayer) sender.getCommandSenderEntity());
               }
            }else{
            	TextHelper.sendFormattedChatMessage("Invalid arguments, usage: " + getUsage(sender), TextFormatting.RED, (EntityPlayer) sender.getCommandSenderEntity());            		
            }
        }
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