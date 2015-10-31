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

public class RecipeVoidGear extends Recipe {

	public String name;

	public RecipeVoidGear(String name) {
		this.name = name;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public Item getResult() {
		return ModItems.Chain_VoidGear;
	}

	@Override
	public Map<Material, Integer> getRequirements() {
		Map<Material, Integer> reqs = new HashMap<Material, Integer>();
		reqs.put(MaterialRegistry.get(Strings.SM_LucidShard), 1);
		reqs.put(MaterialRegistry.get(Strings.SM_DarkShard), 1);
		reqs.put(MaterialRegistry.get(Strings.SM_PowerShard), 5);
		reqs.put(MaterialRegistry.get(Strings.SM_PowerGem), 2);
		return reqs;
	}

}
