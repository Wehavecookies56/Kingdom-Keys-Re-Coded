package uk.co.wehavecookies56.kk.common.network.packet.client;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.network.PacketBuffer;
import net.minecraftforge.fml.relauncher.Side;
import uk.co.wehavecookies56.kk.api.recipes.FreeDevRecipeRegistry;
import uk.co.wehavecookies56.kk.api.recipes.RecipeRegistry;
import uk.co.wehavecookies56.kk.common.capability.ModCapabilities;
import uk.co.wehavecookies56.kk.common.capability.SynthesisRecipeCapability;
import uk.co.wehavecookies56.kk.common.network.packet.AbstractMessage;

public class SyncRecipeData extends AbstractMessage.AbstractClientMessage<SyncRecipeData> {

	private List<String> recipes;

	public SyncRecipeData() {}
	
	public SyncRecipeData(SynthesisRecipeCapability.ISynthesisRecipe recipe) {
		this.recipes = recipe.getKnownRecipes();
	}
	
	@Override
	protected void read(PacketBuffer buffer) throws IOException {
		recipes = new ArrayList<String>();
		while(buffer.isReadable()){
			recipes.add(buffer.readStringFromBuffer(100));
		}
	}

	@Override
	protected void write(PacketBuffer buffer) throws IOException {
		for (int i = 0; i < recipes.size(); i++){
			buffer.writeString(recipes.get(i));
		}
	}

	@Override
	public void process(EntityPlayer player, Side side) {
		final SynthesisRecipeCapability.ISynthesisRecipe recipe = player.getCapability(ModCapabilities.SYNTHESIS_RECIPES, null);
		for (int i = 0; i < recipes.size(); i++) {
			recipe.learnRecipe(RecipeRegistry.get(recipes.get(i)));
		}
	}


}
