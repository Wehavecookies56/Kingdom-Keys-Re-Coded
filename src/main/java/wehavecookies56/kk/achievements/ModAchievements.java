package wehavecookies56.kk.achievements;

import java.util.ArrayList;

import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagString;
import net.minecraft.stats.Achievement;
import net.minecraftforge.common.AchievementPage;
import wehavecookies56.kk.item.ModItems;
import wehavecookies56.kk.lib.Reference;
import wehavecookies56.kk.lib.Strings;

public class ModAchievements {

	public static ArrayList kkAchievements = new ArrayList<Achievement>();
	public static AchievementPage kkPage;

	public static Achievement openMenu;
	public static Achievement getKeyblade;

	public static Achievement getWehavecookies56Skull;
	public static Achievement getAbelatoxSkull;

	public static void init(){

		openMenu = new Achievement(Strings.Achievement_OpenMenu, "openMenu", 0, 0, Items.book, (Achievement)null);

		getWehavecookies56Skull = new Achievement(Strings.Achievement_GetWehavecookies56Skull, "getWehavecookies56Skull", 5, 5, Items.cookie, (Achievement)null).setSpecial();
		getAbelatoxSkull = new Achievement(Strings.Achievement_GetAbelatoxSkull, "getAbelatoxSkull", 7, 5, ModItems.EternalFlames, (Achievement)null).setSpecial();

		kkAchievements.add(openMenu);
		kkAchievements.add(getWehavecookies56Skull);
		kkAchievements.add(getAbelatoxSkull);

		Achievement[] pageAchievements = new Achievement[kkAchievements.size()];
		AchievementPage.registerAchievementPage(kkPage = new AchievementPage(Reference.MODNAME, (Achievement[]) kkAchievements.toArray(pageAchievements)));
	}

	public static void register(){
		openMenu.registerStat();
		getWehavecookies56Skull.registerStat();
		getAbelatoxSkull.registerStat();
	}

}
