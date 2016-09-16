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
			getNBMS, getCombined, getIncompleteKiblade, get1milMunny, getKingdomHearts, getMagic,
			getDriveForm, level100, level50, freeDev, getSynthesisBag, getPrizeBlox, playMusicDisc, getUltimaWeapon,
			getStick, getUmbrella, getDreamSword, getGhostBlox;

	public static void init () {

		openMenu = new Achievement(Strings.Achievement_OpenMenu, "openmenu", 0, 0, Items.BOOK, (Achievement) null);

		getBlox = new Achievement(Strings.Achievement_GetBlox, "getblox", 2, -2, ModBlocks.NormalBlox, openMenu);
        getGhostBlox = new Achievement(Strings.Achievement_GetGhostBlox, "getghostblox", 0, -4, ModBlocks.GhostBlox, getBlox);
        getPrizeBlox = new Achievement(Strings.Achievement_GetPrizeBlox, "getprizeblox", 3, -5, ModBlocks.PrizeBlox, getBlox);

		getSynthesisTable = new Achievement(Strings.Achievement_GetSynthesisTable, "getsynthesistable", 6, 0, ModBlocks.SynthesisTable, getBlox);
		getKeyblade = new Achievement(Strings.Achievement_GetKeyblade, "getkeyblade", 8, 2, ModItems.KingdomKey, getSynthesisTable).setSpecial();
		getIncompleteKiblade = new Achievement(Strings.Achievement_GetIncomepleteKiblade, "getincompletekiblade", 10, 2, ModItems.IncompleteKiblade, getKeyblade);
        getKiblade = new Achievement(Strings.Achievement_GetKiblade, "getkiblade", 12, 2, ModItems.Kiblade, getIncompleteKiblade).setSpecial();
        getNBMS = new Achievement(Strings.Achievement_GetNBMS, "getnbms", 10, 6, ModItems.NightmaresEnd, getKeyblade);
        getCombined = new Achievement(Strings.Achievement_GetCombined, "getcombined", 12, 6, ModItems.NightmaresEndandMirageSplit, getNBMS).setSpecial();
        getStick = new Achievement(Strings.Achievement_GetStick, "getstick", 10, 0, ModItems.WoodenStick, getKeyblade);
        getUmbrella = new Achievement(Strings.Umbrella, "getumbrella", 10, -2, ModItems.Umbrella, getKeyblade);
        getUltimaWeapon = new Achievement(Strings.Achievement_GetUltimaWeapon, "getultimaweapon", 10, 8, ModItems.UltimaWeaponKH1, getKeyblade);
        getDreamSword = new Achievement(Strings.Achievement_GetDreamSword, "getdreamsword", 10, 4, ModItems.DreamSword, getKeyblade);
        get1milMunny = new Achievement(Strings.Achievement_Get1milMunny, "get1milmunny", -4, 1, ModItems.Munny, openMenu);
        level50 = new Achievement(Strings.Achievement_Level50, "level50", -3, 5, Items.ROTTEN_FLESH, openMenu);
        level100 = new Achievement(Strings.Achievement_Level100, "level100", -4, 7, Items.ENDER_PEARL, level50);
        getChest = new Achievement(Strings.Achievement_GetChest, "getchest", 3, 2, ModBlocks.KKChest, getBlox);
        getDriveForm = new Achievement(Strings.Achievement_GetDriveForm, "getdriveform", -9, 1, ModItems.LevelUpValor, (Achievement) null);
        getMagic = new Achievement(Strings.Achievement_GetMagic, "getmagic", -9, 3, ModItems.MagicOrb, (Achievement) null);
        getKeybladeArmor = new Achievement(Strings.Achievement_GetKeybladeArmor, "getkeybladearmor", -5, -5, ModItems.Eraqus_Helmet, (Achievement) null);
        freeDev = new Achievement(Strings.Achievement_FreeDev, "freedev", 5, -3, ModItems.Potion, getSynthesisTable);
        getSynthesisBag = new Achievement(Strings.Achievement_GetSynthesisBag, "getsynthesisbag", -2, -2, ModItems.SynthesisBagL, openMenu);
        playMusicDisc = new Achievement(Strings.Achievement_PlayMusicDisc, "playmusicdisc", -7, 7, ModItems.Disc_Organization_XIII, (Achievement) null);
        getKingdomHearts = new Achievement(Strings.Achievement_GetKingdomHearts, "getkingdomhearts", 8, 5, ModItems.KingdomHearts, getKeyblade);

		getWehavecookies56Skull = new Achievement(Strings.Achievement_GetWehavecookies56Skull, "getwehavecookies56skull", 5, 3, Items.COOKIE, (Achievement) null).setSpecial();
		getAbelatoxSkull = new Achievement(Strings.Achievement_GetAbelatoxSkull, "getabelatoxskull", 5, 5, ModItems.EternalFlames, (Achievement) null).setSpecial();

		getRecipe = new Achievement(Strings.Achievement_GetRecipe, "getrecipe", -1, 3, ModItems.Recipe, getSynthesisTable);
        allRecipes = new Achievement(Strings.Achievement_AllRecipes, "allrecipes", 0, 6, ModItems.Recipe, getRecipe);

        getOrgRobe = new Achievement(Strings.Achievement_GetOrgRobe, "getorgrobe", -7, -5, ModItems.OrganizationRobe_Helmet, (Achievement) null);
        getOrgWeapon = new Achievement(Strings.Achievement_GetOrgWeapon, "getorgweapon", -7, -1, ModItems.BookofRetribution, (Achievement) null);

		kkAchievements.add(openMenu);
		kkAchievements.add(getWehavecookies56Skull);
		kkAchievements.add(getAbelatoxSkull);
		kkAchievements.add(getBlox);
		kkAchievements.add(getSynthesisTable);
		kkAchievements.add(getKeyblade);
		kkAchievements.add(getRecipe);
        kkAchievements.add(get1milMunny);
        kkAchievements.add(getChest);
        kkAchievements.add(getCombined);
        kkAchievements.add(getDreamSword);
        kkAchievements.add(getDriveForm);
        kkAchievements.add(getGhostBlox);
        kkAchievements.add(getIncompleteKiblade);
        kkAchievements.add(getKeybladeArmor);
        kkAchievements.add(getKiblade);
        kkAchievements.add(getKingdomHearts);
        kkAchievements.add(getMagic);
        kkAchievements.add(getNBMS);
        kkAchievements.add(getOrgRobe);
        kkAchievements.add(getOrgWeapon);
        kkAchievements.add(getPrizeBlox);
        kkAchievements.add(getStick);
        kkAchievements.add(getUmbrella);
        kkAchievements.add(getUltimaWeapon);
        kkAchievements.add(getSynthesisBag);
        kkAchievements.add(playMusicDisc);
        kkAchievements.add(allRecipes);
        kkAchievements.add(freeDev);
        kkAchievements.add(level50);
        kkAchievements.add(level100);

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
        freeDev.registerStat();
        level100.registerStat();
        level50.registerStat();
        getGhostBlox.registerStat();
        getSynthesisBag.registerStat();
        getOrgRobe.registerStat();
        getOrgWeapon.registerStat();
        getUmbrella.registerStat();
        getStick.registerStat();
        getUltimaWeapon.registerStat();
        getIncompleteKiblade.registerStat();
        getKeybladeArmor.registerStat();
        getNBMS.registerStat();
        getCombined.registerStat();
        playMusicDisc.registerStat();
        getDriveForm.registerStat();
        getMagic.registerStat();
        get1milMunny.registerStat();
        getDreamSword.registerStat();
        getKingdomHearts.registerStat();
        getPrizeBlox.registerStat();
        allRecipes.registerStat();
        getChest.registerStat();
        getKiblade.registerStat();

	}

}
