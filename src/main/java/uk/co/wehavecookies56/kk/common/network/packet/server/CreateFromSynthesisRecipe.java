package uk.co.wehavecookies56.kk.common.network.packet.server;

import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.network.PacketBuffer;
import net.minecraftforge.fml.relauncher.Side;
import uk.co.wehavecookies56.kk.api.materials.Material;
import uk.co.wehavecookies56.kk.api.recipes.FreeDevRecipeRegistry;
import uk.co.wehavecookies56.kk.api.recipes.Recipe;
import uk.co.wehavecookies56.kk.api.recipes.RecipeRegistry;
import uk.co.wehavecookies56.kk.common.achievement.ModAchievements;
import uk.co.wehavecookies56.kk.common.capability.ModCapabilities;
import uk.co.wehavecookies56.kk.common.capability.SynthesisMaterialCapability;
import uk.co.wehavecookies56.kk.common.core.helper.AchievementHelper;
import uk.co.wehavecookies56.kk.common.item.base.ItemKeychain;
import uk.co.wehavecookies56.kk.common.lib.Strings;
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
		boolean freeDev = false;
		if (FreeDevRecipeRegistry.isFreeDevRecipeRegistered(name)) {
			freeDev = true;
		}
		if (!freeDev) {
			if (RecipeRegistry.get(name).getResult().getItem() instanceof ItemKeychain)
				AchievementHelper.addAchievement(player, ModAchievements.getKeyblade);
			player.inventory.addItemStackToInventory(RecipeRegistry.get(name).getResult());
			Recipe r = RecipeRegistry.get(name);
			SynthesisMaterialCapability.ISynthesisMaterial MATS = player.getCapability(ModCapabilities.SYNTHESIS_MATERIALS, null);
			Iterator it = r.getRequirements().entrySet().iterator();
			if(r.getName().equals("item."+Strings.Umbrella))
	        	AchievementHelper.addAchievement(player, ModAchievements.getUmbrella);
			else if(r.getName().equals("item."+Strings.UltimaWeaponKH1)||r.getName().equals("item."+Strings.UltimaWeaponKH2)||r.getName().equals("item."+Strings.UltimaWeaponBBS)||r.getName().equals("item."+Strings.UltimaWeaponDDD))
	        	AchievementHelper.addAchievement(player, ModAchievements.getUltimaWeapon);
			else if(r.getName().equals("item."+Strings.WoodenStick))
	        	AchievementHelper.addAchievement(player, ModAchievements.getStick);
			else if(r.getName().equals("item."+Strings.IncompleteKiblade))
	        	AchievementHelper.addAchievement(player, ModAchievements.getIncompleteKiblade);
			else if(r.getName().equals("item."+Strings.Kiblade))
	        	AchievementHelper.addAchievement(player, ModAchievements.getKiblade);
			else if(r.getName().equals("item."+Strings.MirageSplit)||r.getName().equals("item."+Strings.NightmaresEnd))
	        	AchievementHelper.addAchievement(player, ModAchievements.getNBMS);
			else if(r.getName().equals("item."+Strings.NightmaresEndandMirageSplit))
	        	AchievementHelper.addAchievement(player, ModAchievements.getCombined);
			else if(r.getName().equals("item."+Strings.DreamSword))
	        	AchievementHelper.addAchievement(player, ModAchievements.getDreamSword);
			
			while (it.hasNext()) {
				Map.Entry<Material, Integer> pair = (Map.Entry<Material, Integer>) it.next();
				MATS.removeMaterial(pair.getKey(), pair.getValue());
			}
		} else {
            //AchievementHelper.addAchievement(player, ModAchievements.getKeyblade);
            player.inventory.addItemStackToInventory(FreeDevRecipeRegistry.get(name).getResult());
            Recipe r = FreeDevRecipeRegistry.get(name);
            SynthesisMaterialCapability.ISynthesisMaterial MATS = player.getCapability(ModCapabilities.SYNTHESIS_MATERIALS, null);
            Iterator it = r.getRequirements().entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry<Material, Integer> pair = (Map.Entry<Material, Integer>) it.next();
                MATS.removeMaterial(pair.getKey(), pair.getValue());
            }
        }
		AchievementHelper.addAchievement(player, ModAchievements.freeDev);
		PacketDispatcher.sendTo(new SyncMaterialData(player.getCapability(ModCapabilities.SYNTHESIS_MATERIALS, null)), (EntityPlayerMP) player);

	}

}
