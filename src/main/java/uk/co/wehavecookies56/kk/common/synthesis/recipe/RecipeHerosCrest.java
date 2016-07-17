package uk.co.wehavecookies56.kk.common.synthesis.recipe;

import java.util.HashMap;
import java.util.Map;

import net.minecraft.item.ItemStack;
import uk.co.wehavecookies56.kk.api.materials.Material;
import uk.co.wehavecookies56.kk.api.materials.MaterialRegistry;
import uk.co.wehavecookies56.kk.api.recipes.Recipe;
import uk.co.wehavecookies56.kk.common.item.ModItems;
import uk.co.wehavecookies56.kk.common.lib.Strings;

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
	public ItemStack getResult () {
		return new ItemStack(ModItems.Chain_HerosCrest);
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
