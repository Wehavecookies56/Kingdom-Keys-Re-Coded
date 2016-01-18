package wehavecookies56.kk.achievements;

import java.util.ArrayList;

import com.sun.javafx.binding.StringFormatter;

import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagString;
import net.minecraft.stats.Achievement;
import net.minecraft.stats.IStatStringFormat;
import net.minecraftforge.common.AchievementPage;
import wehavecookies56.kk.block.ModBlocks;
import wehavecookies56.kk.client.input.Keybinds;
import wehavecookies56.kk.item.ModItems;
import wehavecookies56.kk.lib.Reference;
import wehavecookies56.kk.lib.Strings;
import wehavecookies56.kk.util.StatStringFormatterMenu;

public class ModAchievements {

	public static ArrayList kkAchievements = new ArrayList<Achievement>();
	public static AchievementPage kkPage;

	public static Achievement openMenu;
	public static Achievement getKeyblade;

	public static Achievement getWehavecookies56Skull;
	public static Achievement getAbelatoxSkull;
	
	public static Achievement getSynthesisTable;
	
	public static Achievement getBlox;

	public static void init(){

		openMenu = new Achievement(Strings.Achievement_OpenMenu, "openMenu", 0, 0, Items.book, (Achievement)null);
		
		openMenu.setStatStringFormatter(new StatStringFormatterMenu());
		
		getBlox = new Achievement(Strings.Achievement_GetBlox, "getBlox", 9, -2, ModBlocks.NormalBlox, (Achievement)null);
		getSynthesisTable = new Achievement(Strings.Achievement_GetSynthesisTable, "getSynthesisTable", 8, 0, ModBlocks.SynthesisTable, getBlox);
		getKeyblade = new Achievement(Strings.Achievement_GetKeyblade, "getKeyblade", 11, 2, ModItems.KingdomKey, getSynthesisTable).setSpecial();
		
		getWehavecookies56Skull = new Achievement(Strings.Achievement_GetWehavecookies56Skull, "getWehavecookies56Skull", 5, 5, Items.cookie, (Achievement)null).setSpecial();
		getAbelatoxSkull = new Achievement(Strings.Achievement_GetAbelatoxSkull, "getAbelatoxSkull", 7, 5, ModItems.EternalFlames, (Achievement)null).setSpecial();
		
		kkAchievements.add(openMenu);
		kkAchievements.add(getWehavecookies56Skull);
		kkAchievements.add(getAbelatoxSkull);
		kkAchievements.add(getBlox);
		kkAchievements.add(getSynthesisTable);
		kkAchievements.add(getKeyblade);

		Achievement[] pageAchievements = new Achievement[kkAchievements.size()];
		AchievementPage.registerAchievementPage(kkPage = new AchievementPage(Reference.MODNAME, (Achievement[]) kkAchievements.toArray(pageAchievements)));
	}

	public static void register(){
		openMenu.registerStat();
		getWehavecookies56Skull.registerStat();
		getAbelatoxSkull.registerStat();
		getBlox.registerStat();
		getSynthesisTable.registerStat();
		getKeyblade.registerStat();
	}

}
