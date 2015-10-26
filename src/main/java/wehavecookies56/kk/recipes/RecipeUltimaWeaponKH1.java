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

public class RecipeUltimaWeaponKH1 extends Recipe {

	public String name;

	public RecipeUltimaWeaponKH1(String name) {
		this.name = name;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public Item getResult() {
		return ModItems.Chain_UltimaWeaponKH1;
	}

	@Override
	public Map<Material, Integer> getRequirements() {
		Map<Material, Integer> reqs = new HashMap<Material, Integer>();
		reqs.put(MaterialRegistry.get(Strings.SM_LightningGem), 5);
		reqs.put(MaterialRegistry.get(Strings.SM_SerenityStone), 5);
		reqs.put(MaterialRegistry.get(Strings.SM_SerenityCrystal), 5);
		reqs.put(MaterialRegistry.get(Strings.SM_StormyStone), 3);
		reqs.put(MaterialRegistry.get(Strings.SM_LostIllusion), 1);
		return reqs;
	}

}
