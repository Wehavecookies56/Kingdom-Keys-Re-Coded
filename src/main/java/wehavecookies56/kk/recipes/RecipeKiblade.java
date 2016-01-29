package wehavecookies56.kk.recipes;

import java.util.HashMap;
import java.util.Map;

import net.minecraft.item.Item;
import wehavecookies56.kk.api.materials.Material;
import wehavecookies56.kk.api.materials.MaterialRegistry;
import wehavecookies56.kk.api.recipes.Recipe;
import wehavecookies56.kk.item.ModItems;
import wehavecookies56.kk.lib.Strings;

public class RecipeKiblade extends Recipe {

	public String name;

	public RecipeKiblade (String name) {
		this.name = name;
	}

	@Override
	public String getName () {
		return name;
	}

	@Override
	public Item getResult () {
		return ModItems.Chain_Kiblade;
	}

	@Override
	public Map<Material, Integer> getRequirements () {
		Map<Material, Integer> reqs = new HashMap<Material, Integer>();
		reqs.put(MaterialRegistry.get(ModItems.Chain_IncompleteKiblade.getUnlocalizedName()), 1);
		reqs.put(MaterialRegistry.get(Strings.SM_Orichalcum), 8);
		reqs.put(MaterialRegistry.get(Strings.SM_OrichalcumPlus), 5);
		reqs.put(MaterialRegistry.get(Strings.SM_ManifestIllusion), 1);
		reqs.put(MaterialRegistry.get(Strings.SM_LostIllusion), 1);
		reqs.put(MaterialRegistry.get(Strings.SM_BlazingCrystal), 2);
		reqs.put(MaterialRegistry.get(Strings.SM_BrightCrystal), 2);
		reqs.put(MaterialRegistry.get(Strings.SM_DarkCrystal), 2);
		reqs.put(MaterialRegistry.get(Strings.SM_DenseCrystal), 2);
		reqs.put(MaterialRegistry.get(Strings.SM_EnergyCrystal), 2);
		reqs.put(MaterialRegistry.get(Strings.SM_FrostCrystal), 2);
		reqs.put(MaterialRegistry.get(Strings.SM_LightningCrystal), 2);
		reqs.put(MaterialRegistry.get(Strings.SM_LucidCrystal), 2);
		reqs.put(MaterialRegistry.get(Strings.SM_MythrilCrystal), 2);
		reqs.put(MaterialRegistry.get(Strings.SM_PowerCrystal), 2);
		reqs.put(MaterialRegistry.get(Strings.SM_RemembranceCrystal), 2);
		reqs.put(MaterialRegistry.get(Strings.SM_SerenityCrystal), 2);
		reqs.put(MaterialRegistry.get(Strings.SM_StormyCrystal), 2);
		reqs.put(MaterialRegistry.get(Strings.SM_TranquilCrystal), 2);
		reqs.put(MaterialRegistry.get(Strings.SM_TwilightCrystal), 2);
		return reqs;
	}

}
