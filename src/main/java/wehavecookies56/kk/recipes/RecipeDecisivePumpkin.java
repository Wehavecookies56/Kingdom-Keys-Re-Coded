package wehavecookies56.kk.recipes;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.item.Item;
import wehavecookies56.kk.api.recipes.Recipe;
import wehavecookies56.kk.item.ModItems;
import wehavecookies56.kk.lib.Strings;

public class RecipeDecisivePumpkin extends Recipe {

	public String name;

	public RecipeDecisivePumpkin(String name) {
		this.name = name;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public Item getResult() {
		return ModItems.Chain_DecisivePumpkin;
	}

	@Override
	public List<String> getRequirements() {
		List<String> reqs = new ArrayList<String>();
		reqs.add(Strings.SM_FrostCrystal + ".x.3");
		reqs.add(Strings.SM_Orichalcum + ".x.1");
		reqs.add(Strings.SM_DarkCrystal + ".x.3");
		reqs.add(Strings.SM_DarkGem + ".x.2");
		return reqs;
	}

}
