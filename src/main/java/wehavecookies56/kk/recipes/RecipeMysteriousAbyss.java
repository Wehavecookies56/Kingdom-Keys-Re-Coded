package wehavecookies56.kk.recipes;

import java.util.HashMap;
import java.util.Map;

import net.minecraft.item.Item;
import wehavecookies56.kk.api.materials.Material;
import wehavecookies56.kk.api.materials.MaterialRegistry;
import wehavecookies56.kk.api.recipes.Recipe;
import wehavecookies56.kk.item.ModItems;
import wehavecookies56.kk.lib.Strings;

public class RecipeMysteriousAbyss extends Recipe {

	public String name;

	public RecipeMysteriousAbyss(String name) {
		this.name = name;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public Item getResult() {
		return ModItems.Chain_MysteriousAbyss;
	}

	@Override
	public Map<Material, Integer> getRequirements() {
		Map<Material, Integer> reqs = new HashMap<Material, Integer>();
		reqs.put(MaterialRegistry.get(Strings.SM_FrostShard), 2);
		reqs.put(MaterialRegistry.get(Strings.SM_FrostStone), 5);
		reqs.put(MaterialRegistry.get(Strings.SM_FrostCrystal), 1);
		reqs.put(MaterialRegistry.get(Strings.SM_FrostGem), 2);
		return reqs;
	}

}
