package wehavecookies56.kk.network.packet.server;

import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.network.PacketBuffer;
import net.minecraftforge.fml.relauncher.Side;
import wehavecookies56.kk.achievements.ModAchievements;
import wehavecookies56.kk.api.materials.Material;
import wehavecookies56.kk.api.recipes.Recipe;
import wehavecookies56.kk.api.recipes.RecipeRegistry;
import wehavecookies56.kk.entities.ExtendedPlayerMaterials;
import wehavecookies56.kk.item.ItemKeychain;
import wehavecookies56.kk.network.packet.AbstractMessage.AbstractServerMessage;
import wehavecookies56.kk.util.AchievementHelper;

public class CreateFromSynthesisRecipe extends AbstractServerMessage<CreateFromSynthesisRecipe> {

	public CreateFromSynthesisRecipe () {}

	String name;
	int amountToRemove;

	public CreateFromSynthesisRecipe (String name, int amountToRemove) {
		this.name = name;
		this.amountToRemove = amountToRemove;
	}

	@Override
	protected void read (PacketBuffer buffer) throws IOException {
		this.name = buffer.readStringFromBuffer(100);
		this.amountToRemove = buffer.readInt();
	}

	@Override
	protected void write (PacketBuffer buffer) throws IOException {
		buffer.writeString(name);
		buffer.writeInt(amountToRemove);
	}

	@Override
	public void process (EntityPlayer player, Side side) {
		if (RecipeRegistry.get(name).getResult() instanceof ItemKeychain) AchievementHelper.addAchievement(player, ModAchievements.getKeyblade);
		player.inventory.addItemStackToInventory(new ItemStack(RecipeRegistry.get(name).getResult()));
		Recipe r = RecipeRegistry.get(name);
		ExtendedPlayerMaterials mats = ExtendedPlayerMaterials.get(player);
		Iterator it = r.getRequirements().entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry<Material, Integer> pair = (Map.Entry<Material, Integer>) it.next();
			mats.removeMaterial(pair.getKey(), pair.getValue());
		}

	}

}
