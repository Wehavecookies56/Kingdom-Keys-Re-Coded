package wehavecookies56.kk.recipes;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.item.Item;
import wehavecookies56.kk.api.recipes.Recipe;
import wehavecookies56.kk.item.ModItems;
import wehavecookies56.kk.lib.Strings;

public class RecipeDivineRose extends Recipe {

	public String name;

	public RecipeDivineRose(String name) {
		this.name = name;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public Item getResult() {
		return ModItems.Chain_DivineRose;
	}

	@Override
	public List<String> getRequirements() {
		List<String> reqs = new ArrayList<String>();
		reqs.add(Strings.SM_PowerStone + ".x.4");
		reqs.add(Strings.SM_BrightGem + ".x.4");
		reqs.add(Strings.SM_EnergyCrystal + ".x.3");
		reqs.add(Strings.SM_LucidShard + ".x.2");
		return reqs;
	}

}
