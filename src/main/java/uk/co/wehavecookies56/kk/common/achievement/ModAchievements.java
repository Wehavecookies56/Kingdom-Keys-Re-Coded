package uk.co.wehavecookies56.kk.common.achievement;

import java.util.ArrayList;

import net.minecraft.init.Items;
import net.minecraft.stats.Achievement;
import net.minecraftforge.common.AchievementPage;
import uk.co.wehavecookies56.kk.common.block.ModBlocks;
import uk.co.wehavecookies56.kk.common.item.ModItems;
import uk.co.wehavecookies56.kk.common.lib.Reference;
import uk.co.wehavecookies56.kk.common.lib.Strings;

public class ModAchievements {

	public static ArrayList kkAchievements = new ArrayList<Achievement>();
	public static AchievementPage kkPage;

	public static Achievement openMenu, getKeyblade, getWehavecookies56Skull, getAbelatoxSkull, getSynthesisTable,
			getBlox, getRecipe, allRecipes, getChest, getKeybladeArmor, getOrgWeapon, getOrgRobe, getKiblade,
			getNightmareBreakOrMirageSplit, getCombined, getIncompleteKiblade, get1milMunny, getKingdomHearts, getMagic,
			getDriveForm, level100, level50, freeDev, getSynthesisBag, breakPrizeBlox, playMusicDisc, getUltimaWeapon,
			getStick, getUmbrella, getDreamSword, getGhostBlox;

	public static void init () {

		openMenu = new Achievement(Strings.Achievement_OpenMenu, "openMenu", 0, 0, Items.BOOK, (Achievement) null);

		getBlox = new Achievement(Strings.Achievement_GetBlox, "getBlox", 2, -2, ModBlocks.NormalBlox, (Achievement) null);
		getSynthesisTable = new Achievement(Strings.Achievement_GetSynthesisTable, "getSynthesisTable", 6, 0, ModBlocks.SynthesisTable, getBlox);
		getKeyblade = new Achievement(Strings.Achievement_GetKeyblade, "getKeyblade", 8, 2, ModItems.Chain_KingdomKey, getSynthesisTable).setSpecial();

		getWehavecookies56Skull = new Achievement(Strings.Achievement_GetWehavecookies56Skull, "getWehavecookies56Skull", 5, 3, Items.COOKIE, (Achievement) null).setSpecial();
		getAbelatoxSkull = new Achievement(Strings.Achievement_GetAbelatoxSkull, "getAbelatoxSkull", 7, 3, ModItems.EternalFlames, (Achievement) null).setSpecial();

		getRecipe = new Achievement(Strings.Achievement_GetRecipe, "getRecipe", 4, 3, ModItems.Recipe, (Achievement) null);

		kkAchievements.add(openMenu);
		kkAchievements.add(getWehavecookies56Skull);
		kkAchievements.add(getAbelatoxSkull);
		kkAchievements.add(getBlox);
		kkAchievements.add(getSynthesisTable);
		kkAchievements.add(getKeyblade);
		kkAchievements.add(getRecipe);

		Achievement[] pageAchievements = new Achievement[kkAchievements.size()];
		AchievementPage.registerAchievementPage(kkPage = new AchievementPage(Reference.MODNAME, (Achievement[]) kkAchievements.toArray(pageAchievements)));
	}

	public static void register () {
		openMenu.registerStat();
		getWehavecookies56Skull.registerStat();
		getAbelatoxSkull.registerStat();
		getBlox.registerStat();
		getSynthesisTable.registerStat();
		getKeyblade.registerStat();
		getRecipe.registerStat();
	}

}
