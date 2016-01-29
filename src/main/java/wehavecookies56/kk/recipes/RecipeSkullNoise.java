package wehavecookies56.kk.recipes;

import java.util.HashMap;
import java.util.Map;

import net.minecraft.item.Item;
import wehavecookies56.kk.api.materials.Material;
import wehavecookies56.kk.api.materials.MaterialRegistry;
import wehavecookies56.kk.api.recipes.Recipe;
import wehavecookies56.kk.item.ModItems;
import wehavecookies56.kk.lib.Strings;

public class RecipeSkullNoise extends Recipe {

	public String name;

	public RecipeSkullNoise (String name) {
		this.name = name;
	}

	@Override
	public String getName () {
		return name;
	}

	@Override
	public Item getResult () {
		return ModItems.Chain_SkullNoise;
	}

	@Override
	public Map<Material, Integer> getRequirements () {
		Map<Material, Integer> reqs = new HashMap<Material, Integer>();
		reqs.put(MaterialRegistry.get(Strings.SM_DarkCrystal), 3);
		reqs.put(MaterialRegistry.get(Strings.SM_DarkGem), 2);
		reqs.put(MaterialRegistry.get(Strings.SM_LostIllusion), 1);
		reqs.put(MaterialRegistry.get(Strings.SM_EnergyShard), 3);
		return reqs;
	}

}
