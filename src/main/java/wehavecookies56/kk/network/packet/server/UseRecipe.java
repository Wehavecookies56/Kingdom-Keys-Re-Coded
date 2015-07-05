package wehavecookies56.kk.network.packet.server;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.network.PacketBuffer;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.ChatComponentTranslation;
import net.minecraft.util.ChatStyle;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.IChatComponent;
import net.minecraftforge.fml.relauncher.Side;
import wehavecookies56.kk.network.packet.AbstractMessage.AbstractServerMessage;
import wehavecookies56.kk.recipes.RecipeRegistry;
import wehavecookies56.kk.util.TextHelper;

public class UseRecipe extends AbstractServerMessage<UseRecipe> {

	String recipe1, recipe2, recipe3;

	public UseRecipe() {}

	public UseRecipe(String recipe1, String recipe2, String recipe3){
		this.recipe1 = recipe1;
		this.recipe2 = recipe2;
		this.recipe3 = recipe3;
	}

	@Override
	protected void read(PacketBuffer buffer) throws IOException {
		recipe1 = buffer.readStringFromBuffer(100);
		recipe2 = buffer.readStringFromBuffer(100);
		recipe3 = buffer.readStringFromBuffer(100);
	}

	@Override
	protected void write(PacketBuffer buffer) throws IOException {
		buffer.writeString(recipe1);
		buffer.writeString(recipe2);
		buffer.writeString(recipe3);
	}

	@Override
	public void process(EntityPlayer player, Side side) {
		boolean consume = false;
		if(RecipeRegistry.get(recipe1) == null){
			String message = "ERROR: Recipe for " + TextHelper.localize(recipe1 + ".name") + " was not learnt because it is not a valid recipe, Report this to Wehavecookies56";
			TextHelper.sendFormattedChatMessage(message, EnumChatFormatting.RED, player);
		}
		else if(RecipeRegistry.isRecipeKnown(player, recipe1)){
			String message = "Recipe for " + TextHelper.localize(recipe1 + ".name") + " was not learnt because you have already learnt it";
			TextHelper.sendFormattedChatMessage(message, EnumChatFormatting.YELLOW, player);
		}else {
			RecipeRegistry.learnrecipe(player, recipe1);
			String message = "Successfully learnt the recipe for " + TextHelper.localize(recipe1 + ".name");
			TextHelper.sendFormattedChatMessage(message, EnumChatFormatting.GREEN, player);
			consume = true;
		}
		if(RecipeRegistry.get(recipe2) == null){
			String message = "ERROR: Recipe for " + TextHelper.localize(recipe2 + ".name") + " was not learnt because it is not a valid recipe, Report this to Wehavecookies56";
			TextHelper.sendFormattedChatMessage(message, EnumChatFormatting.RED, player);
		}
		else if(RecipeRegistry.isRecipeKnown(player, recipe2)){
			String message = "Recipe for " + TextHelper.localize(recipe2 + ".name") + " was not learnt because you have already learnt it";
			TextHelper.sendFormattedChatMessage(message, EnumChatFormatting.YELLOW, player);
		}else{
			RecipeRegistry.learnrecipe(player, recipe2);
			String message = "Successfully learnt the recipe for " + TextHelper.localize(recipe2 + ".name");
			TextHelper.sendFormattedChatMessage(message, EnumChatFormatting.GREEN, player);
			consume = true;
		}
		if(RecipeRegistry.get(recipe3) == null){
			String message = "ERROR: Recipe for " + TextHelper.localize(recipe3 + ".name") + " was not learnt because it is not a valid recipe, Report this to Wehavecookies56";
			TextHelper.sendFormattedChatMessage(message, EnumChatFormatting.RED, player);
		}
		else if(RecipeRegistry.isRecipeKnown(player, recipe3)){
			String message = "Recipe for " + TextHelper.localize(recipe3 + ".name") + " was not learnt because you have already learnt it";
			TextHelper.sendFormattedChatMessage(message, EnumChatFormatting.YELLOW, player);
		}else{
			RecipeRegistry.learnrecipe(player, recipe3);
			String message = "Successfully learnt the recipe for " + TextHelper.localize(recipe3 + ".name");
			TextHelper.sendFormattedChatMessage(message, EnumChatFormatting.GREEN, player);
			consume = true;
		}

		if(consume){
			player.inventory.setInventorySlotContents(player.inventory.currentItem, null);
		}
	}

}
