package uk.co.wehavecookies56.kk.common.core.command;

import net.minecraft.command.CommandException;
import net.minecraft.command.ICommand;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextFormatting;
import uk.co.wehavecookies56.kk.api.recipes.Recipe;
import uk.co.wehavecookies56.kk.api.recipes.RecipeRegistry;
import uk.co.wehavecookies56.kk.common.capability.ModCapabilities;
import uk.co.wehavecookies56.kk.common.core.helper.TextHelper;
import uk.co.wehavecookies56.kk.common.util.Utils;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;

public class CommandLearnRecipe implements ICommand {

    private List<String> aliases;
    private List<String> autoComplete;

    public CommandLearnRecipe () {
        this.aliases = new ArrayList<String>();
        this.aliases.add("learnrecipe");
        this.aliases.add("addrecipe");
        this.aliases.add("giverecipe");
        this.aliases.add("kklearnrecipe");

        this.autoComplete = new ArrayList<String>();
        this.autoComplete.add("all");
        for (Object value : RecipeRegistry.getRecipeMap().values())
            if (value instanceof Recipe) this.autoComplete.add(((Recipe) value).getName().substring(5));
    }

    @Override
    public int compareTo (ICommand arg0) {
        return 0;
    }

    @Override
    public String getName () {
        return "learnrecipe";
    }

    public int getRequiredPermissionLevel () {
        return 2;
    }

    @Override
    public String getUsage (ICommandSender sender) {
        return "/learnrecipe <value>";
    }

    @Override
    public List<String> getAliases () {
        return this.aliases;
    }

    @Override
    public boolean isUsernameIndex (String[] args, int index) {
        return false;
    }

    @Override
    public void execute(MinecraftServer server, ICommandSender sender, String[] args) throws CommandException {
        if (sender.getCommandSenderEntity() instanceof EntityPlayer) if (args.length == 0)
            TextHelper.sendFormattedChatMessage("Invalid arguments, usage \"/learnrecipe <name>\"", TextFormatting.RED, (EntityPlayer) sender.getCommandSenderEntity());
        else if (RecipeRegistry.isRecipeKnown(((EntityPlayer) sender.getCommandSenderEntity()).getCapability(ModCapabilities.SYNTHESIS_RECIPES, null).getKnownRecipes(), "item." + args[0].toLowerCase()))
            TextHelper.sendFormattedChatMessage("You already know this recipe", TextFormatting.YELLOW, (EntityPlayer) sender.getCommandSenderEntity());
        else if (RecipeRegistry.isRecipeRegistered("item." + args[0].toLowerCase())) {
            RecipeRegistry.learnrecipe(((EntityPlayer) sender.getCommandSenderEntity()).getCapability(ModCapabilities.SYNTHESIS_RECIPES, null).getKnownRecipes(), (EntityPlayer) sender.getCommandSenderEntity(), "item." + args[0].toLowerCase());
            TextHelper.sendFormattedChatMessage("Successfully learnt recipe for " + Utils.translateToLocal("item." + args[0].toLowerCase() + ".name"), TextFormatting.GREEN, (EntityPlayer) sender.getCommandSenderEntity());
        } else if (args[0].equals("all")) {
            for (Object value : RecipeRegistry.getRecipeMap().values())
                if (value instanceof Recipe) if (!RecipeRegistry.isRecipeKnown(((EntityPlayer) sender.getCommandSenderEntity()).getCapability(ModCapabilities.SYNTHESIS_RECIPES, null).getKnownRecipes(), ((Recipe) value).getName())) RecipeRegistry.learnrecipe(((EntityPlayer) sender.getCommandSenderEntity()).getCapability(ModCapabilities.SYNTHESIS_RECIPES, null).getKnownRecipes(), (EntityPlayer) sender.getCommandSenderEntity(), ((Recipe) value).getName());
            TextHelper.sendFormattedChatMessage("Successfully learnt all the recipe", TextFormatting.GREEN, (EntityPlayer) sender.getCommandSenderEntity());
        } else
            TextHelper.sendFormattedChatMessage("This recipe doesn't exist", TextFormatting.RED, (EntityPlayer) sender.getCommandSenderEntity());

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
