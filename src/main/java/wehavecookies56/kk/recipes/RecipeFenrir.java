package wehavecookies56.kk.recipes;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.item.Item;
import wehavecookies56.kk.api.recipes.Recipe;
import wehavecookies56.kk.item.ModItems;
import wehavecookies56.kk.lib.Strings;

public class RecipeFenrir extends Recipe {

	public String name;

	public RecipeFenrir(String name) {
		this.name = name;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public Item getResult() {
		return ModItems.Chain_Fenrir;
	}

	@Override
	public List<String> getRequirements() {
		List<String> reqs = new ArrayList<String>();
		reqs.add(Strings.SM_PowerStone + ".x.6");
		reqs.add(Strings.SM_DenseShard + ".x.2");
		reqs.add(Strings.SM_TwilightGem + ".x.3");
		reqs.add(Strings.SM_EnergyCrystal + ".x.2");
		return reqs;
	}

}
