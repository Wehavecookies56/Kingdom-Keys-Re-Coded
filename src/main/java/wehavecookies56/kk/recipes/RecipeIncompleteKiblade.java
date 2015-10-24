package wehavecookies56.kk.recipes;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.item.Item;
import wehavecookies56.kk.api.recipes.Recipe;
import wehavecookies56.kk.item.ModItems;
import wehavecookies56.kk.lib.Strings;

public class RecipeIncompleteKiblade extends Recipe {

	public String name;

	public RecipeIncompleteKiblade(String name) {
		this.name = name;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public Item getResult() {
		return ModItems.Chain_IncompleteKiblade;
	}

	@Override
	public List<String> getRequirements() {
		List<String> reqs = new ArrayList<String>();
		reqs.add(Strings.SM_MythrilCrystal + ".x.1");
		reqs.add(Strings.SM_TwilightCrystal + ".x.1");
		reqs.add(Strings.SM_DenseCrystal + ".x.1");
		reqs.add(Strings.SM_DarkCrystal + ".x.1");
		reqs.add(Strings.SM_BlazingCrystal + ".x.1");
		reqs.add(Strings.SM_PowerCrystal + ".x.1");
		return reqs;
	}

}
