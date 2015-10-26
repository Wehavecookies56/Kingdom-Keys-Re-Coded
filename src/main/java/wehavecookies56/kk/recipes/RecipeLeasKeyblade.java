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

public class RecipeLeasKeyblade extends Recipe {

	public String name;

	public RecipeLeasKeyblade(String name) {
		this.name = name;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public Item getResult() {
		return ModItems.Chain_LeasKeyblade;
	}

	@Override
	public Map<Material, Integer> getRequirements() {
		Map<Material, Integer> reqs = new HashMap<Material, Integer>();
		reqs.put(MaterialRegistry.get(Strings.SM_BlazingShard), 4);
		reqs.put(MaterialRegistry.get(Strings.SM_PowerStone), 3);
		reqs.put(MaterialRegistry.get(Strings.SM_BlazingCrystal), 4);
		reqs.put(MaterialRegistry.get(Strings.SM_BlazingStone), 1);
		reqs.put(MaterialRegistry.get(Strings.SM_BlazingGem), 2);
		return reqs;
	}

}
