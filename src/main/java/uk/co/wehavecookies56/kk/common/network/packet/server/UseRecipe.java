package uk.co.wehavecookies56.kk.common.network.packet.server;

import java.io.IOException;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.network.PacketBuffer;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.util.text.TextFormatting;
import net.minecraftforge.fml.relauncher.Side;
import uk.co.wehavecookies56.kk.api.recipes.RecipeRegistry;
import uk.co.wehavecookies56.kk.common.capability.ModCapabilities;
import uk.co.wehavecookies56.kk.common.capability.SynthesisRecipeCapability;
import uk.co.wehavecookies56.kk.common.core.helper.TextHelper;
import uk.co.wehavecookies56.kk.common.lib.Strings;
import uk.co.wehavecookies56.kk.common.network.packet.AbstractMessage;
import uk.co.wehavecookies56.kk.common.util.Utils;

public class UseRecipe extends AbstractMessage.AbstractServerMessage<UseRecipe> {

    String recipe1, recipe2, recipe3;

    public UseRecipe () {}

    public UseRecipe (String recipe1) {
        this.recipe1 = recipe1;
    }

    public UseRecipe (String recipe1, String recipe2, String recipe3) {
        this.recipe1 = recipe1;
        this.recipe2 = recipe2;
        this.recipe3 = recipe3;
    }

    @Override
    protected void read (PacketBuffer buffer) throws IOException {
        recipe1 = buffer.readString(40);
        recipe2 = buffer.readString(40);
        recipe3 = buffer.readString(40);
    }

    @Override
    protected void write (PacketBuffer buffer) throws IOException {
        buffer.writeString(recipe1);
        buffer.writeString(recipe2);
        buffer.writeString(recipe3);
    }

    @Override
    public void process (EntityPlayer player, Side side) {
        boolean consume = false;
        SynthesisRecipeCapability.ISynthesisRecipe RECIPES = player.getCapability(ModCapabilities.SYNTHESIS_RECIPES, null);
        String[] recipes = new String[] {recipe1,recipe2,recipe3};
        
        //Loop through all the recipes in the recipe item
        for(String recipe : recipes) {
        	if (RecipeRegistry.get(recipe) == null) { //If recipe is not valid
                String message = "ERROR: Recipe for " + Utils.translateToLocal(recipe + ".name") + " was not learnt because it is not a valid recipe, Report this to a dev";
                TextHelper.sendFormattedChatMessage(message, TextFormatting.RED, player);
            } else if (RecipeRegistry.isRecipeKnown(RECIPES.getKnownRecipes(), recipe)) { //If recipe already known
                TextComponentTranslation repeatMessage = new TextComponentTranslation(Strings.Chat_Recipe_Repeat, new TextComponentTranslation(recipe+".name"));
                repeatMessage.getStyle().setColor(TextFormatting.YELLOW);
                player.sendMessage(repeatMessage);
                //TextHelper.sendFormattedChatMessage(message, TextFormatting.YELLOW, player);
            } else { //If recipe is not known, learn it
                RecipeRegistry.learnRecipe(RECIPES.getKnownRecipes(), player, recipe);
                TextComponentTranslation learnMessage = new TextComponentTranslation(Strings.Chat_Recipe_Learn, new TextComponentTranslation(recipe+".name"));
                learnMessage.getStyle().setColor(TextFormatting.GREEN);
                player.sendMessage(learnMessage);
                consume = true;
            }
        }

        if (consume)
            if(!player.capabilities.isCreativeMode)
                player.inventory.setInventorySlotContents(player.inventory.currentItem, ItemStack.EMPTY);
        if(RECIPES.getKnownRecipes().size() == 120) { }
    }

}