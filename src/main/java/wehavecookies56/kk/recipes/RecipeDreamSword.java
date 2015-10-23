package wehavecookies56.kk.recipes;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.item.Item;
import wehavecookies56.kk.api.recipes.Recipe;
import wehavecookies56.kk.item.ModItems;
import wehavecookies56.kk.lib.Strings;

public class RecipeDreamSword extends Recipe {

	public String name;

	public RecipeDreamSword(String name) {
		this.name = name;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public Item getResult() {
		return ModItems.Chain_DreamSword;
	}

	@Override
	public List<String> getRequirements() {
		List<String> reqs = new ArrayList<String>();
		reqs.add(Strings.SM_PowerGem + ".x.5");
		reqs.add(Strings.SM_BrightStone + ".x.5");
		reqs.add(Strings.SM_TwilightGem + ".x.2");
		return reqs;
	}

}
