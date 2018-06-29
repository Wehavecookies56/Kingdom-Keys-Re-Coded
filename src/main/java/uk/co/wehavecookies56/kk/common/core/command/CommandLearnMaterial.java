package uk.co.wehavecookies56.kk.common.core.command;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Nullable;

import net.minecraft.command.CommandException;
import net.minecraft.command.ICommand;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextFormatting;
import uk.co.wehavecookies56.kk.api.materials.Material;
import uk.co.wehavecookies56.kk.api.materials.MaterialRegistry;
import uk.co.wehavecookies56.kk.api.recipes.Recipe;
import uk.co.wehavecookies56.kk.api.recipes.RecipeRegistry;
import uk.co.wehavecookies56.kk.common.capability.ModCapabilities;
import uk.co.wehavecookies56.kk.common.core.helper.TextHelper;
import uk.co.wehavecookies56.kk.common.util.Utils;

public class CommandLearnMaterial implements ICommand {

	private List<String> aliases;
	private List<String> autoComplete;

	public CommandLearnMaterial() {
		this.aliases = new ArrayList<String>();
		this.aliases.add("givematerial");
		this.aliases.add("kkgivematerial");

		this.autoComplete = new ArrayList<String>();
		this.autoComplete.add("all");
		for (Object value : MaterialRegistry.getMaterialMap().values()) {
			if (value instanceof Material) {
				Material material = (Material) value;
				this.autoComplete.add(material.getName().substring(material.getName().indexOf(".") + 1));
			}
		}
	}

	@Override
	public int compareTo(ICommand arg0) {
		return 0;
	}

	@Override
	public String getName() {
		return "givematerial";
	}

	public int getRequiredPermissionLevel() {
		return 2;
	}

	@Override
	public String getUsage(ICommandSender sender) {
		return "/givematerial <material/all> <amount>";
	}

	@Override
	public List<String> getAliases() {
		return this.aliases;
	}

	@Override
	public boolean isUsernameIndex(String[] args, int index) {
		return false;
	}

	@Override
	public void execute(MinecraftServer server, ICommandSender sender, String[] args) throws CommandException {
		if (sender.getCommandSenderEntity() instanceof EntityPlayer) {
			EntityPlayer player = (EntityPlayer) sender.getCommandSenderEntity();

			if (args.length < 2) {
				TextHelper.sendFormattedChatMessage("Invalid arguments, usage \"" + getUsage(sender) + "\"", TextFormatting.RED, (EntityPlayer) sender.getCommandSenderEntity());

			} else {
				int amount = Integer.parseInt(args[1]);
				Map<String, Integer> materialsMap = player.getCapability(ModCapabilities.SYNTHESIS_MATERIALS, null).getKnownMaterialsMap();
				
				if (MaterialRegistry.isMaterialRegistered("sm." + args[0].toLowerCase())) {	
					Material material = MaterialRegistry.get("sm."+args[0]);
					player.getCapability(ModCapabilities.SYNTHESIS_MATERIALS, null).addMaterial(material, amount);
					TextHelper.sendFormattedChatMessage("Successfully given material " + Utils.translateToLocal("sm." + args[0].toLowerCase() + ".name"), TextFormatting.GREEN, (EntityPlayer) sender.getCommandSenderEntity());

				} else if (MaterialRegistry.isMaterialRegistered("item." + args[0].toLowerCase())) {
					Material material = MaterialRegistry.get("item."+args[0]);
					player.getCapability(ModCapabilities.SYNTHESIS_MATERIALS, null).addMaterial(material, amount);
					TextHelper.sendFormattedChatMessage("Successfully given material " + Utils.translateToLocal("item." + args[0].toLowerCase() + ".name"), TextFormatting.GREEN, (EntityPlayer) sender.getCommandSenderEntity());
				
				} else if (MaterialRegistry.isMaterialRegistered("tile." + args[0].toLowerCase())) {
					Material material = MaterialRegistry.get("tile."+args[0]);
					player.getCapability(ModCapabilities.SYNTHESIS_MATERIALS, null).addMaterial(material, amount);
					TextHelper.sendFormattedChatMessage("Successfully given material " + Utils.translateToLocal("tile." + args[0].toLowerCase() + ".name"), TextFormatting.GREEN, (EntityPlayer) sender.getCommandSenderEntity());
	
				} else if (args[0].equals("all")) {
					for (Object value : MaterialRegistry.getMaterialMap().values()) {
						if (value instanceof Material) {
							if (amount > 0) {
								player.getCapability(ModCapabilities.SYNTHESIS_MATERIALS, null).addMaterial((Material) value, amount);
							} else {
								player.getCapability(ModCapabilities.SYNTHESIS_MATERIALS, null).removeMaterial((Material) value, -amount);
							}
						}
					}
					TextHelper.sendFormattedChatMessage("Successfully given all the materials", TextFormatting.GREEN, (EntityPlayer) sender.getCommandSenderEntity());
				} else {
					TextHelper.sendFormattedChatMessage("This material doesn't exist: " + args[0], TextFormatting.RED, (EntityPlayer) sender.getCommandSenderEntity());
				}
			}	
		}
	}

	@Override
	public boolean checkPermission(MinecraftServer server, ICommandSender sender) {
		return sender.canUseCommand(getRequiredPermissionLevel(), getName());
	}

	@Override
	public List<String> getTabCompletions(MinecraftServer server, ICommandSender sender, String[] args, @Nullable BlockPos pos) {
		return this.autoComplete;
	}
}
