package wehavecookies56.kk.recipes;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.item.Item;
import wehavecookies56.kk.api.recipes.Recipe;
import wehavecookies56.kk.item.ModItems;
import wehavecookies56.kk.lib.Strings;

public class RecipeUltimaWeaponKH2 extends Recipe {

	public String name;

	public RecipeUltimaWeaponKH2(String name) {
		this.name = name;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public Item getResult() {
		return ModItems.Chain_UltimaWeaponKH2;
	}

	@Override
	public List<String> getRequirements() {
		List<String> reqs = new ArrayList<String>();
		reqs.add(Strings.SM_OrichalcumPlus + ".x.13");
		reqs.add(Strings.SM_Orichalcum + ".x.1");
		reqs.add(Strings.SM_MythrilCrystal + ".x.1");
		reqs.add(Strings.SM_DenseCrystal + ".x.1");
		reqs.add(Strings.SM_TwilightCrystal + ".x.1");
		reqs.add(Strings.SM_SerenityCrystal + ".x.7");
		return reqs;
	}

}
