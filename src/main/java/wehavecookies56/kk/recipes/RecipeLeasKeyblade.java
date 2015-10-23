package wehavecookies56.kk.recipes;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.item.Item;
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
	public List<String> getRequirements() {
		List<String> reqs = new ArrayList<String>();
		reqs.add(Strings.SM_BlazingShard + ".x.4");
		reqs.add(Strings.SM_PowerStone + ".x.3");
		reqs.add(Strings.SM_BlazingCrystal + ".x.4");
		reqs.add(Strings.SM_BlazingStone + ".x.1");
		reqs.add(Strings.SM_BlazingGem + ".x.2");
		return reqs;
	}

}
