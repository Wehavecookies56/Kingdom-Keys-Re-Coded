package uk.co.wehavecookies56.kk.common.network.packet.server;

import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.ItemStack;
import net.minecraft.network.PacketBuffer;
import net.minecraftforge.fml.relauncher.Side;
import uk.co.wehavecookies56.kk.api.materials.Material;
import uk.co.wehavecookies56.kk.api.recipes.Recipe;
import uk.co.wehavecookies56.kk.api.recipes.RecipeRegistry;
import uk.co.wehavecookies56.kk.common.achievement.ModAchievements;
import uk.co.wehavecookies56.kk.common.capability.ModCapabilities;
import uk.co.wehavecookies56.kk.common.capability.SynthesisMaterialCapability;
import uk.co.wehavecookies56.kk.common.core.helper.AchievementHelper;
import uk.co.wehavecookies56.kk.common.item.base.ItemKeychain;
import uk.co.wehavecookies56.kk.common.network.packet.AbstractMessage;
import uk.co.wehavecookies56.kk.common.network.packet.PacketDispatcher;
import uk.co.wehavecookies56.kk.common.network.packet.client.SyncMaterialData;

public class CreateFromSynthesisRecipe extends AbstractMessage.AbstractServerMessage<CreateFromSynthesisRecipe> {

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
		SynthesisMaterialCapability.ISynthesisMaterial MATS = player.getCapability(ModCapabilities.SYNTHESIS_MATERIALS, null);
		Iterator it = r.getRequirements().entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry<Material, Integer> pair = (Map.Entry<Material, Integer>) it.next();
			MATS.removeMaterial(pair.getKey(), pair.getValue());
		}
		PacketDispatcher.sendTo(new SyncMaterialData(player.getCapability(ModCapabilities.SYNTHESIS_MATERIALS, null)), (EntityPlayerMP) player);

	}

}
