package wehavecookies56.kk.recipes;

import java.util.HashMap;
import java.util.Map;

import net.minecraft.item.Item;
import wehavecookies56.kk.api.materials.Material;
import wehavecookies56.kk.api.materials.MaterialRegistry;
import wehavecookies56.kk.api.recipes.Recipe;
import wehavecookies56.kk.item.ModItems;
import wehavecookies56.kk.lib.Strings;

public class RecipeMasterXehanortsKeyblade extends Recipe {

	public String name;

	public RecipeMasterXehanortsKeyblade (String name) {
		this.name = name;
	}

	@Override
	public String getName () {
		return name;
	}

	@Override
	public Item getResult () {
		return ModItems.Chain_MasterXehanortsKeyblade;
	}

	@Override
	public Map<Material, Integer> getRequirements () {
		Map<Material, Integer> reqs = new HashMap<Material, Integer>();
		reqs.put(MaterialRegistry.get(Strings.SM_DarkCrystal), 13);
		reqs.put(MaterialRegistry.get(Strings.SM_DarkGem), 11);
		reqs.put(MaterialRegistry.get(Strings.SM_LucidCrystal), 5);
		reqs.put(MaterialRegistry.get(Strings.SM_OrichalcumPlus), 1);
		reqs.put(MaterialRegistry.get(Strings.SM_PowerCrystal), 1);
		return reqs;
	}

}
