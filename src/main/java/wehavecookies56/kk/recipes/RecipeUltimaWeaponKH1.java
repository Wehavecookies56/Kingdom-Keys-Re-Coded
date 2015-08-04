package wehavecookies56.kk.recipes;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.item.Item;
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
	public List<String> getRequirements() {
		List<String> reqs = new ArrayList<String>();
		reqs.add(Strings.SM_LightningGem + ".x.5");
		reqs.add(Strings.SM_SerenityStone + ".x.5");
		reqs.add(Strings.SM_SerenityCrystal + ".x.5");
		reqs.add(Strings.SM_StormyStone + ".x.3");
		reqs.add(Strings.SM_LostIllusion + ".x.1");
		return reqs;
	}

}
