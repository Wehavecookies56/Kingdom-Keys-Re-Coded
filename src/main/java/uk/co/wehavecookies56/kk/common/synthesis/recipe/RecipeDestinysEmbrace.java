package uk.co.wehavecookies56.kk.common.synthesis.recipe;

import java.util.HashMap;
import java.util.Map;

import net.minecraft.item.Item;
import uk.co.wehavecookies56.kk.api.materials.Material;
import uk.co.wehavecookies56.kk.api.materials.MaterialRegistry;
import uk.co.wehavecookies56.kk.api.recipes.Recipe;
import uk.co.wehavecookies56.kk.common.item.ModItems;
import uk.co.wehavecookies56.kk.common.lib.Strings;

public class RecipeDestinysEmbrace extends Recipe {

	public String name;

	public RecipeDestinysEmbrace (String name) {
		this.name = name;
	}

	@Override
	public String getName () {
		return name;
	}

	@Override
	public Item getResult () {
		return ModItems.Chain_DestinysEmbrace;
	}

	@Override
	public Map<Material, Integer> getRequirements () {
		Map<Material, Integer> reqs = new HashMap<Material, Integer>();
		reqs.put(MaterialRegistry.get(Strings.SM_LightningStone), 5);
		reqs.put(MaterialRegistry.get(Strings.SM_LightningGem), 5);
		reqs.put(MaterialRegistry.get(Strings.SM_BrightCrystal), 5);
		reqs.put(MaterialRegistry.get(Strings.SM_PowerStone), 3);
		return reqs;
	}

}
