package wehavecookies56.kk.recipes;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.item.Item;
import wehavecookies56.kk.api.recipes.Recipe;
import wehavecookies56.kk.item.ModItems;
import wehavecookies56.kk.lib.Strings;

public class RecipeSoulEater extends Recipe {

	public String name;

	public RecipeSoulEater(String name) {
		this.name = name;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public Item getResult() {
		return ModItems.Chain_SoulEater;
	}

	@Override
	public List<String> getRequirements() {
		List<String> reqs = new ArrayList<String>();
		reqs.add(Strings.SM_DarkCrystal + ".x.3");
		reqs.add(Strings.SM_DarkGem + ".x.5");
		reqs.add(Strings.SM_PowerCrystal + ".x.3");
		reqs.add(Strings.SM_PowerStone + ".x.5");
		return reqs;
	}

}
