package uk.co.wehavecookies56.kk.common.core.command;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Nullable;

import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommand;
import net.minecraft.command.ICommandSender;
import net.minecraft.command.PlayerNotFoundException;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.relauncher.Side;
import uk.co.wehavecookies56.kk.common.capability.ModCapabilities;
import uk.co.wehavecookies56.kk.common.capability.PlayerStatsCapability;
import uk.co.wehavecookies56.kk.common.core.helper.TextHelper;
import uk.co.wehavecookies56.kk.common.network.packet.PacketDispatcher;
import uk.co.wehavecookies56.kk.common.network.packet.client.SyncLevelData;

public class CommandGiveEXP extends CommandBase {

	private List<String> aliases;

	public CommandGiveEXP() {
		this.aliases = new ArrayList<String>();
		this.aliases.add("kkgiveexp");
	}

	@Override
	public int compareTo(ICommand arg0) {
		return 0;
	}

	@Override
	public String getName() {
		return "giveexp";
	}

	public int getRequiredPermissionLevel() {
		return 2;
	}

	@Override
	public String getUsage(ICommandSender sender) {
		return "/giveexp <num> [player]";
	}

	@Override
	public List<String> getAliases() {
		return this.aliases;
	}

	public static boolean isInteger(String s) {
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
	public boolean isUsernameIndex(String[] args, int index) {
		return false;
	}

	public static EntityPlayerMP getCommandSenderAsPlayer(ICommandSender sender) throws PlayerNotFoundException {
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
			int exp = 1;
			EntityPlayerMP entityplayermp = args.length == 2 ? (EntityPlayerMP) getPlayerFromUsername(args[1]) : getCommandSenderAsPlayer(sender);

			if (args.length == 0 || args.length > 2) {
				TextHelper.sendFormattedChatMessage("Invalid arguments, usage: " + getUsage(sender), TextFormatting.RED, (EntityPlayer) sender.getCommandSenderEntity());
				return;
			}

			try {
				exp = Integer.parseInt(args[0]);
				if (args.length == 1) {
					TextHelper.sendFormattedChatMessage("You got " + exp + "xp ", TextFormatting.YELLOW, (EntityPlayer) sender.getCommandSenderEntity());

				} else if (args.length == 2) {

					TextHelper.sendFormattedChatMessage("You got " + exp + "xp ", TextFormatting.YELLOW, entityplayermp);
					TextHelper.sendFormattedChatMessage(args[1] + " got " + exp + "xp ", TextFormatting.YELLOW, (EntityPlayer) sender.getCommandSenderEntity());

				} else {
					TextHelper.sendFormattedChatMessage("Invalid arguments, usage: " + getUsage(sender), TextFormatting.RED, (EntityPlayer) sender.getCommandSenderEntity());
				}
			} catch (Exception e) {
				TextHelper.sendFormattedChatMessage("Invalid number " + args[0], TextFormatting.RED, (EntityPlayer) sender.getCommandSenderEntity());
				return;
			}

			PlayerStatsCapability.IPlayerStats STATS = entityplayermp.getCapability(ModCapabilities.PLAYER_STATS, null);
			STATS.addExperience(entityplayermp, exp);

			PacketDispatcher.sendTo(new SyncLevelData(entityplayermp.getCapability(ModCapabilities.PLAYER_STATS, null)), entityplayermp);

		} else {
			int exp = 1;
			if (args.length == 2) {
				EntityPlayerMP entityplayermp;
				exp = Integer.parseInt(args[0]);
				if (args[1].equals("@a")) {
					World[] worlds = server.worlds;
					for (int i = 0; i < worlds.length; i++) {
						List<EntityPlayer> players = worlds[i].playerEntities;
						for (EntityPlayer p : players) {
							entityplayermp = (EntityPlayerMP) p;
							PlayerStatsCapability.IPlayerStats STATS = entityplayermp.getCapability(ModCapabilities.PLAYER_STATS, null);
							STATS.addExperience(entityplayermp, exp);
							PacketDispatcher.sendTo(new SyncLevelData(entityplayermp.getCapability(ModCapabilities.PLAYER_STATS, null)), entityplayermp);
							TextHelper.sendFormattedChatMessage("You got " + exp + "xp ", TextFormatting.YELLOW, entityplayermp);

						}
					}
					return;
				}

				entityplayermp = (EntityPlayerMP) getPlayer(server, sender, args[1]);
				try {
					exp = Integer.parseInt(args[0]);

					TextHelper.sendFormattedChatMessage("You got " + exp + "xp ", TextFormatting.YELLOW, entityplayermp);
					sender.sendMessage(new TextComponentString(TextFormatting.YELLOW + args[1] + " got " + exp + "xp "));

				} catch (Exception e) {
					sender.sendMessage(new TextComponentString(TextFormatting.RED + "Invalid number " + args[0]));
					TextHelper.sendFormattedChatMessage("Invalid number " + args[0], TextFormatting.RED, (EntityPlayer) sender.getCommandSenderEntity());
					return;
				}

				PlayerStatsCapability.IPlayerStats STATS = entityplayermp.getCapability(ModCapabilities.PLAYER_STATS, null);
				STATS.addExperience(entityplayermp, exp);

				PacketDispatcher.sendTo(new SyncLevelData(entityplayermp.getCapability(ModCapabilities.PLAYER_STATS, null)), entityplayermp);
			} else {
				sender.sendMessage(new TextComponentString("Invalid argumernts, usage: " + getUsage(sender)));
				return;
			}
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
