package wehavecookies56.kk.recipes;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.item.Item;
import wehavecookies56.kk.api.recipes.Recipe;
import wehavecookies56.kk.item.ModItems;
import wehavecookies56.kk.lib.Strings;

public class RecipeGullWing extends Recipe {

	public String name;

	public RecipeGullWing(String name) {
		this.name = name;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public Item getResult() {
		return ModItems.Chain_GullWing;
	}

	@Override
	public List<String> getRequirements() {
		List<String> reqs = new ArrayList<String>();
		reqs.add(Strings.SM_PowerShard + ".x.5");
		reqs.add(Strings.SM_BlazingGem + ".x.2");
		reqs.add(Strings.SM_EnergyCrystal + ".x.2");
		return reqs;
	}

}
