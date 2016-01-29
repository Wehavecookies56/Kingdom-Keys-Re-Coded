package wehavecookies56.kk.recipes;

import java.util.HashMap;
import java.util.Map;

import net.minecraft.item.Item;
import wehavecookies56.kk.api.materials.Material;
import wehavecookies56.kk.api.materials.MaterialRegistry;
import wehavecookies56.kk.api.recipes.Recipe;
import wehavecookies56.kk.item.ModItems;
import wehavecookies56.kk.lib.Strings;

public class RecipeHerosCrest extends Recipe {

	public String name;

	public RecipeHerosCrest (String name) {
		this.name = name;
	}

	@Override
	public String getName () {
		return name;
	}

	@Override
	public Item getResult () {
		return ModItems.Chain_HerosCrest;
	}

	@Override
	public Map<Material, Integer> getRequirements () {
		Map<Material, Integer> reqs = new HashMap<Material, Integer>();
		reqs.put(MaterialRegistry.get(Strings.SM_LightningCrystal), 2);
		reqs.put(MaterialRegistry.get(Strings.SM_LightningGem), 2);
		reqs.put(MaterialRegistry.get(Strings.SM_PowerShard), 3);
		reqs.put(MaterialRegistry.get(Strings.SM_BrightStone), 2);

		return reqs;
	}

}
