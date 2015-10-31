package wehavecookies56.kk.recipes;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.minecraft.item.Item;
import wehavecookies56.kk.api.materials.Material;
import wehavecookies56.kk.api.materials.MaterialRegistry;
import wehavecookies56.kk.api.recipes.Recipe;
import wehavecookies56.kk.item.ModItems;
import wehavecookies56.kk.lib.Strings;

public class RecipeUnbound extends Recipe {

	public String name;

	public RecipeUnbound(String name) {
		this.name = name;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public Item getResult() {
		return ModItems.Chain_Unbound;
	}

	@Override
	public Map<Material, Integer> getRequirements() {
		Map<Material, Integer> reqs = new HashMap<Material, Integer>();
		reqs.put(MaterialRegistry.get(Strings.SM_MythrilCrystal), 3);
		reqs.put(MaterialRegistry.get(Strings.SM_TwilightGem), 5);
		reqs.put(MaterialRegistry.get(Strings.SM_PowerCrystal), 3);
		reqs.put(MaterialRegistry.get(Strings.SM_DenseGem), 5);
		return reqs;
	}

}
