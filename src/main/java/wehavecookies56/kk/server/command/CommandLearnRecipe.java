package wehavecookies56.kk.server.command;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.command.CommandException;
import net.minecraft.command.ICommand;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.BlockPos;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.EnumChatFormatting;
import wehavecookies56.kk.api.recipes.Recipe;
import wehavecookies56.kk.api.recipes.RecipeRegistry;
import wehavecookies56.kk.util.TextHelper;

public class CommandLearnRecipe implements ICommand {

	private List aliases;
	private List autoComplete;
	public CommandLearnRecipe(){
		this.aliases = new ArrayList();
		this.aliases.add("learnrecipe");
		this.aliases.add("addrecipe");
		this.aliases.add("giverecipe");
		this.aliases.add("kklearnrecipe");


		this.autoComplete = new ArrayList();
		this.autoComplete.add("all");
		for (Object value : RecipeRegistry.getRecipeMap().values()) {
			if(value instanceof Recipe){
				this.autoComplete.add(((Recipe) value).getName().substring(5));
			}
		}
	}

	@Override
	public int compareTo(Object arg0) {
		return 0;
	}

	@Override
	public String getName() {
		return "learnrecipe";
	}

	@Override
	public String getCommandUsage(ICommandSender sender) {
		return "/learnrecipe <value>";
	}

	@Override
	public List getAliases() {
		return this.aliases;
	}

	@Override
	public void execute(ICommandSender sender, String[] args) throws CommandException {
		if(sender.getCommandSenderEntity() instanceof EntityPlayer){
			if(args.length == 0){
				TextHelper.sendFormattedChatMessage("Invalid arguments, usage \"/learnrecipe <name>\"", EnumChatFormatting.RED, (EntityPlayer) sender.getCommandSenderEntity());
			}else{
				if(RecipeRegistry.isRecipeKnown((EntityPlayer) sender.getCommandSenderEntity(), "item." + args[0].toLowerCase())){
					TextHelper.sendFormattedChatMessage("You already know this recipe", EnumChatFormatting.YELLOW, (EntityPlayer) sender.getCommandSenderEntity());
				}else if (RecipeRegistry.isRecipeRegistered("item." + args[0].toLowerCase())){
					RecipeRegistry.learnrecipe((EntityPlayer) sender.getCommandSenderEntity(), "item." + args[0].toLowerCase());
					TextHelper.sendFormattedChatMessage("Successfully learnt recipe for " + TextHelper.localize("item." + args[0].toLowerCase() + ".name"), EnumChatFormatting.GREEN, (EntityPlayer) sender.getCommandSenderEntity());
				}else if (args[0].equals("all")){
					for (Object value : RecipeRegistry.getRecipeMap().values()) {
						if(value instanceof Recipe){
							if(!RecipeRegistry.isRecipeKnown((EntityPlayer) sender.getCommandSenderEntity(), ((Recipe) value).getName())){
								RecipeRegistry.learnrecipe((EntityPlayer) sender.getCommandSenderEntity(), ((Recipe) value).getName());
							}
						}
					}
					TextHelper.sendFormattedChatMessage("Successfully learnt all the recipes", EnumChatFormatting.GREEN, (EntityPlayer) sender.getCommandSenderEntity());
				}else{
					TextHelper.sendFormattedChatMessage("This recipe doesn't exist", EnumChatFormatting.RED, (EntityPlayer) sender.getCommandSenderEntity());
				}
			}
		}
	}

	@Override
	public boolean canCommandSenderUse(ICommandSender sender) {
		if(sender.getCommandSenderEntity() instanceof EntityPlayer){
			return true;
		}
		return false;
	}

	@Override
	public List addTabCompletionOptions(ICommandSender sender, String[] args, BlockPos pos) {
		return this.autoComplete;
	}

	@Override
	public boolean isUsernameIndex(String[] args, int index) {
		return false;
	}

}
