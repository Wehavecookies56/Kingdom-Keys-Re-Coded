package uk.co.wehavecookies56.kk.common.core.handler;

import java.io.File;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.common.config.Property;
import net.minecraftforge.fml.client.event.ConfigChangedEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import uk.co.wehavecookies56.kk.common.lib.Reference;
import uk.co.wehavecookies56.kk.common.lib.Strings;

public class ConfigHandler {

	public static Configuration config;

	public static String[] items;

	public static boolean
			EnableWorldGen = true,
			EnableUpdateCheck = true,
			EnableHeartsOnHUD = false,
			EnableCustomMusic = true,
			ForceEnableCustomMusic = false;

	public static String TM_Interdiction, TM_Sharpshooter, TM_Lindworm, TM_FrozenPride, TM_Skysplitter, TM_BookofRetribution, TM_Lunatic, TM_EternalFlames, TM_Arpeggio, TM_FairGame, TM_GracefulDahlia, TM_Foudre, TM_BlazeofGlory, TM_Prometheus, TM_Ifrit;

	public static String TM_KingdomKey, TM_Oathkeeper, TM_Oblivion, TM_UltimaWeaponKH1, TM_KingdomKeyD, TM_KeybladeofPeoplesHearts, TM_LadyLuck, TM_Olympia, TM_JungleKing, TM_ThreeWishes, TM_Crabclaw, TM_FairyHarp, TM_DivineRose, TM_Spellbinder, TM_MetalChocobo, TM_Lionheart, TM_DiamondDust, TM_OneWingedAngel, TM_SoulEater, TM_Pumpkinhead, TM_WishingStar, TM_BondofFlame, TM_FollowtheWind, TM_HiddenDragon, TM_Monochrome, TM_PhotonDebugger, TM_StarSeeker, TM_MaverickFlare, TM_TotalEclipse, TM_MidnightRoar, TM_TwoBecomeOne, TM_UltimaWeaponKH2, TM_WaytotheDawn, TM_DestinysEmbrace, TM_Stormfall, TM_EndsoftheEarth, TM_RumblingRose, TM_HerosCrest, TM_MysteriousAbyss, TM_WishingLamp, TM_DecisivePumpkin, TM_CircleofLife, TM_SweetMemories, TM_GullWing, TM_GuardianSoul, TM_SleepingLion, TM_Fenrir, TM_FatalCrest, TM_WinnersProof, TM_MissingAche, TM_OminousBlight, TM_AbaddonPlasma, TM_PainofSolitude, TM_SignofInnocence, TM_CrownofGuilt, TM_AbyssalTide, TM_Leviathan, TM_TrueLightsFlight, TM_RejectionofFate, TM_GlimpseofDarkness, TM_SilentDirge, TM_LunarEclipse, TM_DarkerThanDark, TM_AstralBlast, TM_TwilightBlaze, TM_OmegaWeapon, TM_Umbrella, TM_Aubade, TM_WoodenStick, TM_DreamSword, TM_ZeroOne, TM_Earthshaker, TM_Darkgnaw, TM_ChaosRipper, TM_MasterXehanortsKeyblade, TM_TreasureTrove, TM_StrokeofMidnight, TM_FairyStars, TM_VictoryLine, TM_MarkofaHero, TM_Hyperdrive, TM_PixiePetal, TM_Sweetstack, TM_UltimaWeaponBBS, TM_VoidGear, TM_NoName, TM_RoyalRadiance, TM_Rainfell, TM_Brightcrest, TM_MastersDefender, TM_WaywardWind, TM_FrolicFlame, TM_LostMemory, TM_Kiblade, TM_IncompleteKiblade, TM_WoodenKeyblade, TM_SkullNoise, TM_GuardianBell, TM_DualDisc, TM_FerrisGear, TM_KnockoutPunch, TM_AllforOne, TM_Counterpoint, TM_Divewing, TM_SweetDreams, TM_UltimaWeaponDDD, TM_Unbound, TM_EndofPain, TM_OceansRage, TM_LeasKeyblade, TM_YoungXehanortsKeyblade, TM_MirageSplit, TM_NightmaresEnd, TM_NightmaresEndandMirageSplit, TM_Starlight, TM_AnguisForetellersKeyblade, TM_LeopardosForetellersKeyblade, TM_UnicornisForetellersKeyblade, TM_UrsusForetellersKeyblade, TM_VulpeusForetellersKeyblade;

	public static String[] A_TM_Interdiction, A_TM_Sharpshooter, A_TM_Lindworm, A_TM_FrozenPride, A_TM_Skysplitter, A_TM_BookofRetribution, A_TM_Lunatic, A_TM_EternalFlames, A_TM_Arpeggio, A_TM_FairGame, A_TM_GracefulDahlia, A_TM_Foudre, A_TM_BlazeofGlory, A_TM_Prometheus, A_TM_Ifrit;

	public static String[] A_TM_AbaddonPlasma, A_TM_AbyssalTide, A_TM_AllforOne, A_TM_AnguisForetellersKeyblade, A_TM_AstralBlast, A_TM_Aubade, A_TM_BondofFlame, A_TM_Brightcrest, A_TM_ChaosRipper, A_TM_CircleofLife, A_TM_Counterpoint, A_TM_Crabclaw, A_TM_CrownofGuilt, A_TM_DarkerThanDark, A_TM_Darkgnaw, A_TM_DecisivePumpkin, A_TM_DestinysEmbrace, A_TM_DiamondDust, A_TM_Divewing, A_TM_DivineRose, A_TM_DreamSword, A_TM_DualDisc, A_TM_Earthshaker, A_TM_EndofPain, A_TM_EndsoftheEarth, A_TM_FairyHarp, A_TM_FairyStars, A_TM_FatalCrest, A_TM_Fenrir, A_TM_FerrisGear, A_TM_FollowtheWind, A_TM_FrolicFlame, A_TM_GlimpseofDarkness, A_TM_GuardianBell, A_TM_GuardianSoul, A_TM_GullWing, A_TM_HerosCrest, A_TM_HiddenDragon, A_TM_Hyperdrive, A_TM_IncompleteKiblade, A_TM_JungleKing, A_TM_KeybladeofPeoplesHearts, A_TM_Kiblade, A_TM_KingdomKey, A_TM_KingdomKeyD, A_TM_KnockoutPunch, A_TM_LadyLuck, A_TM_LeasKeyblade, A_TM_LeopardosForetellersKeyblade, A_TM_Leviathan, A_TM_Lionheart, A_TM_LostMemory, A_TM_LunarEclipse, A_TM_MarkofaHero, A_TM_MasterXehanortsKeyblade, A_TM_MastersDefender, A_TM_MaverickFlare, A_TM_MetalChocobo, A_TM_MidnightRoar, A_TM_MirageSplit, A_TM_MissingAche, A_TM_Monochrome, A_TM_MysteriousAbyss, A_TM_NightmaresEnd, A_TM_NightmaresEndandMirageSplit, A_TM_NoName, A_TM_Oathkeeper, A_TM_Oblivion, A_TM_OceansRage, A_TM_Olympia, A_TM_OmegaWeapon, A_TM_OminousBlight, A_TM_OneWingedAngel, A_TM_PainofSolitude, A_TM_PhotonDebugger, A_TM_PixiePetal, A_TM_Pumpkinhead, A_TM_Rainfell, A_TM_RejectionofFate, A_TM_RoyalRadiance, A_TM_RumblingRose, A_TM_SignofInnocence, A_TM_SilentDirge, A_TM_SkullNoise, A_TM_SleepingLion, A_TM_SoulEater, A_TM_Spellbinder, A_TM_StarSeeker, A_TM_Starlight, A_TM_Stormfall, A_TM_StrokeofMidnight, A_TM_SweetDreams, A_TM_SweetMemories, A_TM_Sweetstack, A_TM_ThreeWishes, A_TM_TotalEclipse, A_TM_TreasureTrove, A_TM_TrueLightsFlight, A_TM_TwilightBlaze, A_TM_TwoBecomeOne, A_TM_UltimaWeaponKH1, A_TM_UltimaWeaponKH2, A_TM_UltimaWeaponBBS, A_TM_UltimaWeaponDDD, A_TM_Umbrella, A_TM_Unbound, A_TM_UnicornisForetellersKeyblade, A_TM_UrsusForetellersKeyblade, A_TM_VictoryLine, A_TM_VoidGear, A_TM_VulpeusForetellersKeyblade, A_TM_WaytotheDawn, A_TM_WaywardWind, A_TM_WinnersProof, A_TM_WishingLamp, A_TM_WishingStar, A_TM_WoodenKeyblade, A_TM_WoodenStick, A_TM_YoungXehanortsKeyblade, A_TM_ZeroOne;

	public static int[] interfaceColour = new int[] { 255, 0, 0 };
	
	public static int guiAlpha = 255;
	
	public static boolean chat = true;
	
	public static Property interfaceColourProperty, EnableHeartsOnHUDProperty, EnableCustomMusicProperty;

	public static void init(File file) {
		config = new Configuration(file);
		config.load();
		load();

		MinecraftForge.EVENT_BUS.register(new ConfigHandler());
	}

	public static void load() {

		final String WORLDGEN = propertyCategory("worldgen", Configuration.CATEGORY_GENERAL);
		final String NETWORK = propertyCategory("network", Configuration.CATEGORY_GENERAL);
		final String INTERFACE = propertyCategory("interface", Configuration.CATEGORY_CLIENT);
		final String SOUND = propertyCategory("sound", Configuration.CATEGORY_CLIENT);
		final String ITEMS = propertyCategory("items", Configuration.CATEGORY_GENERAL);
		final String TOOLMATERIALS = propertyCategory("toolmaterials", ITEMS);

		//WORLDGEN
		EnableWorldGen = configProperty("Enable World Gen", "Toggles all world generation performed by this mod", EnableWorldGen, WORLDGEN);

		//NETWORK
		EnableUpdateCheck = configProperty("Enable Update Checking", "Toggles whether the update checker checks for updates", EnableUpdateCheck, NETWORK);

		//INTERFACE
		guiAlpha = configProperty("Gui Alpha (W.I.P.)", "Sets the Command Menu and Bars opacity (0-255)", guiAlpha, INTERFACE);
		chat = configProperty("Enable Custom Chat", "It makes the chat have custom colors for KK helpers", chat, INTERFACE);
		EnableHeartsOnHUDProperty = configBooleanProperty("Enable hearts on HUD", "Toggles rendering of hearts on the HUD", EnableHeartsOnHUD, INTERFACE);
		EnableHeartsOnHUD = EnableHeartsOnHUDProperty.getBoolean();

		interfaceColourProperty = configProperty("Interface colour", "Set the colour of the interface with RGB values", interfaceColour, INTERFACE);
		interfaceColour = interfaceColourProperty.getIntList();

		//SOUND
		EnableCustomMusicProperty = configBooleanProperty("Enable custom music", "Toggles the custom music that plays, requires the music resource pack", EnableCustomMusic, SOUND);
		EnableCustomMusic = EnableCustomMusicProperty.getBoolean();
		ForceEnableCustomMusic = configProperty("Force Enable custom music", "Force toggles the custom music that plays regardless of whether the resource pack is loaded", ForceEnableCustomMusic, SOUND);

		//ITEMS
		//TOOLMATERIALS
		config.addCustomCategoryComment(TOOLMATERIALS, "The tool material for items which use them, A space after commas is required. \nParameters {(String) NAME, (int) HARVESTLEVEL, (int) MAXUSES, (float) EFFICIENCY, (float) DAMAGE, (int) ENCHANTABILITY}");

		TM_Interdiction = configProperty(Strings.TM_Interdiction_NAME, "", Strings.TM_Interdiction_DEFAULT, TOOLMATERIALS);
		TM_Sharpshooter = configProperty(Strings.TM_Sharpshooter_NAME, "", Strings.TM_Sharpshooter_DEFAULT, TOOLMATERIALS);
		TM_Lindworm = configProperty(Strings.TM_Lindworm_NAME, "", Strings.TM_Lindworm_DEFAULT, TOOLMATERIALS);
		TM_FrozenPride = configProperty(Strings.TM_FrozenPride_NAME, "", Strings.TM_FrozenPride_DEFAULT, TOOLMATERIALS);
		TM_Skysplitter = configProperty(Strings.TM_Skysplitter_NAME, "", Strings.TM_Skysplitter_DEFAULT, TOOLMATERIALS);
		TM_BookofRetribution = configProperty(Strings.TM_BookofRetribution_NAME, "", Strings.TM_BookofRetribution_DEFAULT, TOOLMATERIALS);
		TM_Lunatic = configProperty(Strings.TM_Lunatic_NAME, "", Strings.TM_Lunatic_DEFAULT, TOOLMATERIALS);
		TM_EternalFlames = configProperty(Strings.TM_EternalFlames_NAME, "", Strings.TM_EternalFlames_DEFAULT, TOOLMATERIALS);
		TM_Arpeggio = configProperty(Strings.TM_Arpeggio_NAME, "", Strings.TM_Arpeggio_DEFAULT, TOOLMATERIALS);
		TM_FairGame = configProperty(Strings.TM_FairGame_NAME, "", Strings.TM_FairGame_DEFAULT, TOOLMATERIALS);
		TM_GracefulDahlia = configProperty(Strings.TM_GracefulDahlia_NAME, "", Strings.TM_GracefulDahlia_DEFAULT, TOOLMATERIALS);
		TM_Foudre = configProperty(Strings.TM_Foudre_NAME, "", Strings.TM_Foudre_DEFAULT, TOOLMATERIALS);
		TM_BlazeofGlory = configProperty(Strings.TM_BlazeofGlory_NAME, "", Strings.TM_BlazeofGlory_DEFAULT, TOOLMATERIALS);
		TM_Prometheus = configProperty(Strings.TM_Prometheus_NAME, "", Strings.TM_Prometheus_DEFAULT, TOOLMATERIALS);
		TM_Ifrit = configProperty(Strings.TM_Ifrit_NAME, "", Strings.TM_Ifrit_DEFAULT, TOOLMATERIALS);

		TM_AbaddonPlasma = configProperty(Strings.TM_AbaddonPlasma_NAME, "", Strings.TM_AbaddonPlasma_DEFAULT, TOOLMATERIALS);
		TM_AbyssalTide = configProperty(Strings.TM_AbyssalTide_NAME, "", Strings.TM_AbyssalTide_DEFAULT, TOOLMATERIALS);
		TM_AllforOne = configProperty(Strings.TM_AllforOne_NAME, "", Strings.TM_AllforOne_DEFAULT, TOOLMATERIALS);
		TM_AnguisForetellersKeyblade = configProperty(Strings.TM_AnguisForetellersKeyblade_NAME, "", Strings.TM_AnguisForetellersKeyblade_DEFAULT, TOOLMATERIALS);
		TM_AstralBlast = configProperty(Strings.TM_AstralBlast_NAME, "", Strings.TM_AstralBlast_DEFAULT, TOOLMATERIALS);
		TM_Aubade = configProperty(Strings.TM_Aubade_NAME, "", Strings.TM_Aubade_DEFAULT, TOOLMATERIALS);
		TM_BondofFlame = configProperty(Strings.TM_BondofFlame_NAME, "", Strings.TM_BondofFlame_DEFAULT, TOOLMATERIALS);
		TM_Brightcrest = configProperty(Strings.TM_Brightcrest_NAME, "", Strings.TM_Brightcrest_DEFAULT, TOOLMATERIALS);
		TM_ChaosRipper = configProperty(Strings.TM_ChaosRipper_NAME, "", Strings.TM_ChaosRipper_DEFAULT, TOOLMATERIALS);
		TM_CircleofLife = configProperty(Strings.TM_CircleofLife_NAME, "", Strings.TM_CircleofLife_DEFAULT, TOOLMATERIALS);
		TM_Counterpoint = configProperty(Strings.TM_Counterpoint_NAME, "", Strings.TM_Counterpoint_DEFAULT, TOOLMATERIALS);
		TM_Crabclaw = configProperty(Strings.TM_Crabclaw_NAME, "", Strings.TM_Crabclaw_DEFAULT, TOOLMATERIALS);
		TM_CrownofGuilt = configProperty(Strings.TM_CrownofGuilt_NAME, "", Strings.TM_CrownofGuilt_DEFAULT, TOOLMATERIALS);
		TM_DarkerThanDark = configProperty(Strings.TM_DarkerThanDark_NAME, "", Strings.TM_DarkerThanDark_DEFAULT, TOOLMATERIALS);
		TM_Darkgnaw = configProperty(Strings.TM_Darkgnaw_NAME, "", Strings.TM_Darkgnaw_DEFAULT, TOOLMATERIALS);
		TM_DecisivePumpkin = configProperty(Strings.TM_DecisivePumpkin_NAME, "", Strings.TM_DecisivePumpkin_DEFAULT, TOOLMATERIALS);
		TM_DestinysEmbrace = configProperty(Strings.TM_DestinysEmbrace_NAME, "", Strings.TM_DestinysEmbrace_DEFAULT, TOOLMATERIALS);
		TM_DiamondDust = configProperty(Strings.TM_DiamondDust_NAME, "", Strings.TM_DiamondDust_DEFAULT, TOOLMATERIALS);
		TM_Divewing = configProperty(Strings.TM_Divewing_NAME, "", Strings.TM_Divewing_DEFAULT, TOOLMATERIALS);
		TM_DivineRose = configProperty(Strings.TM_DivineRose_NAME, "", Strings.TM_DivineRose_DEFAULT, TOOLMATERIALS);
		TM_DreamSword = configProperty(Strings.TM_DreamSword_NAME, "", Strings.TM_DreamSword_DEFAULT, TOOLMATERIALS);
		TM_DualDisc = configProperty(Strings.TM_DualDisc_NAME, "", Strings.TM_DualDisc_DEFAULT, TOOLMATERIALS);
		TM_Earthshaker = configProperty(Strings.TM_Earthshaker_NAME, "", Strings.TM_Earthshaker_DEFAULT, TOOLMATERIALS);
		TM_EndofPain = configProperty(Strings.TM_EndofPain_NAME, "", Strings.TM_EndofPain_DEFAULT, TOOLMATERIALS);
		TM_EndsoftheEarth = configProperty(Strings.TM_EndsoftheEarth_NAME, "", Strings.TM_EndsoftheEarth_DEFAULT, TOOLMATERIALS);
		TM_FairyHarp = configProperty(Strings.TM_FairyHarp_NAME, "", Strings.TM_FairyHarp_DEFAULT, TOOLMATERIALS);
		TM_FairyStars = configProperty(Strings.TM_FairyStars_NAME, "", Strings.TM_FairyStars_DEFAULT, TOOLMATERIALS);
		TM_FatalCrest = configProperty(Strings.TM_FatalCrest_NAME, "", Strings.TM_FatalCrest_DEFAULT, TOOLMATERIALS);
		TM_Fenrir = configProperty(Strings.TM_Fenrir_NAME, "", Strings.TM_Fenrir_DEFAULT, TOOLMATERIALS);
		TM_FerrisGear = configProperty(Strings.TM_FerrisGear_NAME, "", Strings.TM_FerrisGear_DEFAULT, TOOLMATERIALS);
		TM_FollowtheWind = configProperty(Strings.TM_FollowtheWind_NAME, "", Strings.TM_FollowtheWind_DEFAULT, TOOLMATERIALS);
		TM_FrolicFlame = configProperty(Strings.TM_FrolicFlame_NAME, "", Strings.TM_FrolicFlame_DEFAULT, TOOLMATERIALS);
		TM_GlimpseofDarkness = configProperty(Strings.TM_GlimpseofDarkness_NAME, "", Strings.TM_GlimpseofDarkness_DEFAULT, TOOLMATERIALS);
		TM_GuardianBell = configProperty(Strings.TM_GuardianBell_NAME, "", Strings.TM_GuardianBell_DEFAULT, TOOLMATERIALS);
		TM_GuardianSoul = configProperty(Strings.TM_GuardianSoul_NAME, "", Strings.TM_GuardianSoul_DEFAULT, TOOLMATERIALS);
		TM_GullWing = configProperty(Strings.TM_GullWing_NAME, "", Strings.TM_GullWing_DEFAULT, TOOLMATERIALS);
		TM_HerosCrest = configProperty(Strings.TM_HerosCrest_NAME, "", Strings.TM_HerosCrest_DEFAULT, TOOLMATERIALS);
		TM_HiddenDragon = configProperty(Strings.TM_HiddenDragon_NAME, "", Strings.TM_HiddenDragon_DEFAULT, TOOLMATERIALS);
		TM_Hyperdrive = configProperty(Strings.TM_Hyperdrive_NAME, "", Strings.TM_Hyperdrive_DEFAULT, TOOLMATERIALS);
		TM_IncompleteKiblade = configProperty(Strings.TM_IncompleteKiblade_NAME, "", Strings.TM_IncompleteKiblade_DEFAULT, TOOLMATERIALS);
		TM_JungleKing = configProperty(Strings.TM_JungleKing_NAME, "", Strings.TM_JungleKing_DEFAULT, TOOLMATERIALS);
		TM_KeybladeofPeoplesHearts = configProperty(Strings.TM_KeybladeofPeoplesHearts_NAME, "", Strings.TM_KeybladeofPeoplesHearts_DEFAULT, TOOLMATERIALS);
		TM_Kiblade = configProperty(Strings.TM_Kiblade_NAME, "", Strings.TM_Kiblade_DEFAULT, TOOLMATERIALS);
		TM_KingdomKey = configProperty(Strings.TM_KingdomKey_NAME, "", Strings.TM_KingdomKey_DEFAULT, TOOLMATERIALS);
		TM_KingdomKeyD = configProperty(Strings.TM_KingdomKeyD_NAME, "", Strings.TM_KingdomKeyD_DEFAULT, TOOLMATERIALS);
		TM_KnockoutPunch = configProperty(Strings.TM_KnockoutPunch_NAME, "", Strings.TM_KnockoutPunch_DEFAULT, TOOLMATERIALS);
		TM_LadyLuck = configProperty(Strings.TM_LadyLuck_NAME, "", Strings.TM_LadyLuck_DEFAULT, TOOLMATERIALS);
		TM_LeasKeyblade = configProperty(Strings.TM_LeasKeyblade_NAME, "", Strings.TM_LeasKeyblade_DEFAULT, TOOLMATERIALS);
		TM_LeopardosForetellersKeyblade = configProperty(Strings.TM_LeopardosForetellersKeyblade_NAME, "", Strings.TM_LeopardosForetellersKeyblade_DEFAULT, TOOLMATERIALS);
		TM_Leviathan = configProperty(Strings.TM_Leviathan_NAME, "", Strings.TM_Leviathan_DEFAULT, TOOLMATERIALS);
		TM_Lionheart = configProperty(Strings.TM_Lionheart_NAME, "", Strings.TM_Lionheart_DEFAULT, TOOLMATERIALS);
		TM_LostMemory = configProperty(Strings.TM_LostMemory_NAME, "", Strings.TM_LostMemory_DEFAULT, TOOLMATERIALS);
		TM_LunarEclipse = configProperty(Strings.TM_LunarEclipse_NAME, "", Strings.TM_LunarEclipse_DEFAULT, TOOLMATERIALS);
		TM_MarkofaHero = configProperty(Strings.TM_MarkofaHero_NAME, "", Strings.TM_MarkofaHero_DEFAULT, TOOLMATERIALS);
		TM_MasterXehanortsKeyblade = configProperty(Strings.TM_MasterXehanortsKeyblade_NAME, "", Strings.TM_MasterXehanortsKeyblade_DEFAULT, TOOLMATERIALS);
		TM_MastersDefender = configProperty(Strings.TM_MastersDefender_NAME, "", Strings.TM_MastersDefender_DEFAULT, TOOLMATERIALS);
		TM_MaverickFlare = configProperty(Strings.TM_MaverickFlare_NAME, "", Strings.TM_MaverickFlare_DEFAULT, TOOLMATERIALS);
		TM_MetalChocobo = configProperty(Strings.TM_MetalChocobo_NAME, "", Strings.TM_MetalChocobo_DEFAULT, TOOLMATERIALS);
		TM_MidnightRoar = configProperty(Strings.TM_MidnightRoar_NAME, "", Strings.TM_MidnightRoar_DEFAULT, TOOLMATERIALS);
		TM_MirageSplit = configProperty(Strings.TM_MirageSplit_NAME, "", Strings.TM_MirageSplit_DEFAULT, TOOLMATERIALS);
		TM_MissingAche = configProperty(Strings.TM_MissingAche_NAME, "", Strings.TM_MissingAche_DEFAULT, TOOLMATERIALS);
		TM_Monochrome = configProperty(Strings.TM_Monochrome_NAME, "", Strings.TM_Monochrome_DEFAULT, TOOLMATERIALS);
		TM_MysteriousAbyss = configProperty(Strings.TM_MysteriousAbyss_NAME, "", Strings.TM_MysteriousAbyss_DEFAULT, TOOLMATERIALS);
		TM_NightmaresEnd = configProperty(Strings.TM_NightmaresEnd_NAME, "", Strings.TM_NightmaresEnd_DEFAULT, TOOLMATERIALS);
		TM_NightmaresEndandMirageSplit = configProperty(Strings.TM_NightmaresEndandMirageSplit_NAME, "", Strings.TM_NightmaresEndandMirageSplit_DEFAULT, TOOLMATERIALS);
		TM_NoName = configProperty(Strings.TM_NoName_NAME, "", Strings.TM_NoName_DEFAULT, TOOLMATERIALS);
		TM_Oathkeeper = configProperty(Strings.TM_Oathkeeper_NAME, "", Strings.TM_Oathkeeper_DEFAULT, TOOLMATERIALS);
		TM_Oblivion = configProperty(Strings.TM_Oblivion_NAME, "", Strings.TM_Oblivion_DEFAULT, TOOLMATERIALS);
		TM_OceansRage = configProperty(Strings.TM_OceansRage_NAME, "", Strings.TM_OceansRage_DEFAULT, TOOLMATERIALS);
		TM_Olympia = configProperty(Strings.TM_Olympia_NAME, "", Strings.TM_Olympia_DEFAULT, TOOLMATERIALS);
		TM_OmegaWeapon = configProperty(Strings.TM_OmegaWeapon_NAME, "", Strings.TM_OmegaWeapon_DEFAULT, TOOLMATERIALS);
		TM_OminousBlight = configProperty(Strings.TM_OminousBlight_NAME, "", Strings.TM_OminousBlight_DEFAULT, TOOLMATERIALS);
		TM_OneWingedAngel = configProperty(Strings.TM_OneWingedAngel_NAME, "", Strings.TM_OneWingedAngel_DEFAULT, TOOLMATERIALS);
		TM_PainofSolitude = configProperty(Strings.TM_PainofSolitude_NAME, "", Strings.TM_PainofSolitude_DEFAULT, TOOLMATERIALS);
		TM_PhotonDebugger = configProperty(Strings.TM_PhotonDebugger_NAME, "", Strings.TM_PhotonDebugger_DEFAULT, TOOLMATERIALS);
		TM_PixiePetal = configProperty(Strings.TM_PixiePetal_NAME, "", Strings.TM_PixiePetal_DEFAULT, TOOLMATERIALS);
		TM_Pumpkinhead = configProperty(Strings.TM_Pumpkinhead_NAME, "", Strings.TM_Pumpkinhead_DEFAULT, TOOLMATERIALS);
		TM_Rainfell = configProperty(Strings.TM_Rainfell_NAME, "", Strings.TM_Rainfell_DEFAULT, TOOLMATERIALS);
		TM_RejectionofFate = configProperty(Strings.TM_RejectionofFate_NAME, "", Strings.TM_RejectionofFate_DEFAULT, TOOLMATERIALS);
		TM_RoyalRadiance = configProperty(Strings.TM_RoyalRadiance_NAME, "", Strings.TM_RoyalRadiance_DEFAULT, TOOLMATERIALS);
		TM_RumblingRose = configProperty(Strings.TM_RumblingRose_NAME, "", Strings.TM_RumblingRose_DEFAULT, TOOLMATERIALS);
		TM_SignofInnocence = configProperty(Strings.TM_SignofInnocence_NAME, "", Strings.TM_SignofInnocence_DEFAULT, TOOLMATERIALS);
		TM_SilentDirge = configProperty(Strings.TM_SilentDirge_NAME, "", Strings.TM_SilentDirge_DEFAULT, TOOLMATERIALS);
		TM_SkullNoise = configProperty(Strings.TM_SkullNoise_NAME, "", Strings.TM_SkullNoise_DEFAULT, TOOLMATERIALS);
		TM_SleepingLion = configProperty(Strings.TM_SleepingLion_NAME, "", Strings.TM_SleepingLion_DEFAULT, TOOLMATERIALS);
		TM_SoulEater = configProperty(Strings.TM_SoulEater_NAME, "", Strings.TM_SoulEater_DEFAULT, TOOLMATERIALS);
		TM_Spellbinder = configProperty(Strings.TM_Spellbinder_NAME, "", Strings.TM_Spellbinder_DEFAULT, TOOLMATERIALS);
		TM_StarSeeker = configProperty(Strings.TM_StarSeeker_NAME, "", Strings.TM_StarSeeker_DEFAULT, TOOLMATERIALS);
		TM_Starlight = configProperty(Strings.TM_Starlight_NAME, "", Strings.TM_Starlight_DEFAULT, TOOLMATERIALS);
		TM_Stormfall = configProperty(Strings.TM_Stormfall_NAME, "", Strings.TM_Stormfall_DEFAULT, TOOLMATERIALS);
		TM_StrokeofMidnight = configProperty(Strings.TM_StrokeofMidnight_NAME, "", Strings.TM_StrokeofMidnight_DEFAULT, TOOLMATERIALS);
		TM_SweetDreams = configProperty(Strings.TM_SweetDreams_NAME, "", Strings.TM_SweetDreams_DEFAULT, TOOLMATERIALS);
		TM_SweetMemories = configProperty(Strings.TM_SweetMemories_NAME, "", Strings.TM_SweetMemories_DEFAULT, TOOLMATERIALS);
		TM_Sweetstack = configProperty(Strings.TM_Sweetstack_NAME, "", Strings.TM_Sweetstack_DEFAULT, TOOLMATERIALS);
		TM_ThreeWishes = configProperty(Strings.TM_ThreeWishes_NAME, "", Strings.TM_ThreeWishes_DEFAULT, TOOLMATERIALS);
		TM_TotalEclipse = configProperty(Strings.TM_TotalEclipse_NAME, "", Strings.TM_TotalEclipse_DEFAULT, TOOLMATERIALS);
		TM_TreasureTrove = configProperty(Strings.TM_TreasureTrove_NAME, "", Strings.TM_TreasureTrove_DEFAULT, TOOLMATERIALS);
		TM_TrueLightsFlight = configProperty(Strings.TM_TrueLightsFlight_NAME, "", Strings.TM_TrueLightsFlight_DEFAULT, TOOLMATERIALS);
		TM_TwilightBlaze = configProperty(Strings.TM_TwilightBlaze_NAME, "", Strings.TM_TwilightBlaze_DEFAULT, TOOLMATERIALS);
		TM_TwoBecomeOne = configProperty(Strings.TM_TwoBecomeOne_NAME, "", Strings.TM_TwoBecomeOne_DEFAULT, TOOLMATERIALS);
		TM_UltimaWeaponKH1 = configProperty(Strings.TM_UltimaWeaponKH1_NAME, "", Strings.TM_UltimaWeaponKH1_DEFAULT, TOOLMATERIALS);
		TM_UltimaWeaponKH2 = configProperty(Strings.TM_UltimaWeaponKH2_NAME, "", Strings.TM_UltimaWeaponKH2_DEFAULT, TOOLMATERIALS);
		TM_UltimaWeaponBBS = configProperty(Strings.TM_UltimaWeaponBBS_NAME, "", Strings.TM_UltimaWeaponBBS_DEFAULT, TOOLMATERIALS);
		TM_UltimaWeaponDDD = configProperty(Strings.TM_UltimaWeaponDDD_NAME, "", Strings.TM_UltimaWeaponDDD_DEFAULT, TOOLMATERIALS);
		TM_Umbrella = configProperty(Strings.TM_Umbrella_NAME, "", Strings.TM_Umbrella_DEFAULT, TOOLMATERIALS);
		TM_Unbound = configProperty(Strings.TM_Unbound_NAME, "", Strings.TM_Unbound_DEFAULT, TOOLMATERIALS);
		TM_UnicornisForetellersKeyblade = configProperty(Strings.TM_UnicornisForetellersKeyblade_NAME, "", Strings.TM_UnicornisForetellersKeyblade_DEFAULT, TOOLMATERIALS);
		TM_UrsusForetellersKeyblade = configProperty(Strings.TM_UrsusForetellersKeyblade_NAME, "", Strings.TM_UrsusForetellersKeyblade_DEFAULT, TOOLMATERIALS);
		TM_VictoryLine = configProperty(Strings.TM_VictoryLine_NAME, "", Strings.TM_VictoryLine_DEFAULT, TOOLMATERIALS);
		TM_VoidGear = configProperty(Strings.TM_VoidGear_NAME, "", Strings.TM_VoidGear_DEFAULT, TOOLMATERIALS);
		TM_VulpeusForetellersKeyblade = configProperty(Strings.TM_VulpeusForetellersKeyblade_NAME, "", Strings.TM_VulpeusForetellersKeyblade_DEFAULT, TOOLMATERIALS);
		TM_WaytotheDawn = configProperty(Strings.TM_WaytotheDawn_NAME, "", Strings.TM_WaytotheDawn_DEFAULT, TOOLMATERIALS);
		TM_WaywardWind = configProperty(Strings.TM_WaywardWind_NAME, "", Strings.TM_WaywardWind_DEFAULT, TOOLMATERIALS);
		TM_WinnersProof = configProperty(Strings.TM_WinnersProof_NAME, "", Strings.TM_WinnersProof_DEFAULT, TOOLMATERIALS);
		TM_WishingLamp = configProperty(Strings.TM_WishingLamp_NAME, "", Strings.TM_WishingLamp_DEFAULT, TOOLMATERIALS);
		TM_WishingStar = configProperty(Strings.TM_WishingStar_NAME, "", Strings.TM_WishingStar_DEFAULT, TOOLMATERIALS);
		TM_WoodenKeyblade = configProperty(Strings.TM_WoodenKeyblade_NAME, "", Strings.TM_WoodenKeyblade_DEFAULT, TOOLMATERIALS);
		TM_WoodenStick = configProperty(Strings.TM_WoodenStick_NAME, "", Strings.TM_WoodenStick_DEFAULT, TOOLMATERIALS);
		TM_YoungXehanortsKeyblade = configProperty(Strings.TM_YoungXehanortsKeyblade_NAME, "", Strings.TM_YoungXehanortsKeyblade_DEFAULT, TOOLMATERIALS);
		TM_ZeroOne = configProperty(Strings.TM_ZeroOne_NAME, "", Strings.TM_ZeroOne_DEFAULT, TOOLMATERIALS);

		A_TM_Interdiction = TM_Interdiction.split(", ");
		A_TM_Sharpshooter = TM_Sharpshooter.split(", ");
		A_TM_Lindworm = TM_Lindworm.split(", ");
		A_TM_FrozenPride = TM_FrozenPride.split(", ");
		A_TM_Skysplitter = TM_Skysplitter.split(", ");
		A_TM_BookofRetribution = TM_BookofRetribution.split(", ");
		A_TM_Lunatic = TM_Lunatic.split(", ");
		A_TM_EternalFlames = TM_EternalFlames.split(", ");
		A_TM_Arpeggio = TM_Arpeggio.split(", ");
		A_TM_FairGame = TM_FairGame.split(", ");
		A_TM_GracefulDahlia = TM_GracefulDahlia.split(", ");
		A_TM_Foudre = TM_Foudre.split(", ");
		A_TM_BlazeofGlory = TM_BlazeofGlory.split(", ");
		A_TM_Prometheus = TM_Prometheus.split(", ");
		A_TM_Ifrit = TM_Ifrit.split(", ");

		A_TM_AbaddonPlasma = TM_AbaddonPlasma.split(", ");
		A_TM_AbyssalTide = TM_AbyssalTide.split(", ");
		A_TM_AllforOne = TM_AllforOne.split(", ");
		A_TM_AnguisForetellersKeyblade = TM_AnguisForetellersKeyblade.split(", ");
		A_TM_AstralBlast = TM_AstralBlast.split(", ");
		A_TM_Aubade = TM_Aubade.split(", ");
		A_TM_BondofFlame = TM_BondofFlame.split(", ");
		A_TM_Brightcrest = TM_Brightcrest.split(", ");
		A_TM_ChaosRipper = TM_ChaosRipper.split(", ");
		A_TM_CircleofLife = TM_CircleofLife.split(", ");
		A_TM_Counterpoint = TM_Counterpoint.split(", ");
		A_TM_Crabclaw = TM_Crabclaw.split(", ");
		A_TM_CrownofGuilt = TM_CrownofGuilt.split(", ");
		A_TM_DarkerThanDark = TM_DarkerThanDark.split(", ");
		A_TM_Darkgnaw = TM_Darkgnaw.split(", ");
		A_TM_DecisivePumpkin = TM_DecisivePumpkin.split(", ");
		A_TM_DestinysEmbrace = TM_DestinysEmbrace.split(", ");
		A_TM_DiamondDust = TM_DiamondDust.split(", ");
		A_TM_Divewing = TM_Divewing.split(", ");
		A_TM_DivineRose = TM_DivineRose.split(", ");
		A_TM_DreamSword = TM_DreamSword.split(", ");
		A_TM_DualDisc = TM_DualDisc.split(", ");
		A_TM_Earthshaker = TM_Earthshaker.split(", ");
		A_TM_EndofPain = TM_EndofPain.split(", ");
		A_TM_EndsoftheEarth = TM_EndsoftheEarth.split(", ");
		A_TM_FairyHarp = TM_FairyHarp.split(", ");
		A_TM_FairyStars = TM_FairyStars.split(", ");
		A_TM_FatalCrest = TM_FatalCrest.split(", ");
		A_TM_Fenrir = TM_Fenrir.split(", ");
		A_TM_FerrisGear = TM_FerrisGear.split(", ");
		A_TM_FollowtheWind = TM_FollowtheWind.split(", ");
		A_TM_FrolicFlame = TM_FrolicFlame.split(", ");
		A_TM_GlimpseofDarkness = TM_GlimpseofDarkness.split(", ");
		A_TM_GuardianBell = TM_GuardianBell.split(", ");
		A_TM_GuardianSoul = TM_GuardianSoul.split(", ");
		A_TM_GullWing = TM_GullWing.split(", ");
		A_TM_HerosCrest = TM_HerosCrest.split(", ");
		A_TM_HiddenDragon = TM_HiddenDragon.split(", ");
		A_TM_Hyperdrive = TM_Hyperdrive.split(", ");
		A_TM_IncompleteKiblade = TM_IncompleteKiblade.split(", ");
		A_TM_JungleKing = TM_JungleKing.split(", ");
		A_TM_KeybladeofPeoplesHearts = TM_KeybladeofPeoplesHearts.split(", ");
		A_TM_Kiblade = TM_Kiblade.split(", ");
		A_TM_KingdomKey = TM_KingdomKey.split(", ");
		A_TM_KingdomKeyD = TM_KingdomKeyD.split(", ");
		A_TM_KnockoutPunch = TM_KnockoutPunch.split(", ");
		A_TM_LadyLuck = TM_LadyLuck.split(", ");
		A_TM_LeasKeyblade = TM_LeasKeyblade.split(", ");
		A_TM_LeopardosForetellersKeyblade = TM_LeopardosForetellersKeyblade.split(", ");
		A_TM_Leviathan = TM_Leviathan.split(", ");
		A_TM_Lionheart = TM_Lionheart.split(", ");
		A_TM_LostMemory = TM_LostMemory.split(", ");
		A_TM_LunarEclipse = TM_LunarEclipse.split(", ");
		A_TM_MarkofaHero = TM_MarkofaHero.split(", ");
		A_TM_MasterXehanortsKeyblade = TM_MasterXehanortsKeyblade.split(", ");
		A_TM_MastersDefender = TM_MastersDefender.split(", ");
		A_TM_MaverickFlare = TM_MaverickFlare.split(", ");
		A_TM_MetalChocobo = TM_MetalChocobo.split(", ");
		A_TM_MidnightRoar = TM_MidnightRoar.split(", ");
		A_TM_MirageSplit = TM_MirageSplit.split(", ");
		A_TM_MissingAche = TM_MissingAche.split(", ");
		A_TM_Monochrome = TM_Monochrome.split(", ");
		A_TM_MysteriousAbyss = TM_MysteriousAbyss.split(", ");
		A_TM_NightmaresEnd = TM_NightmaresEnd.split(", ");
		A_TM_NightmaresEndandMirageSplit = TM_NightmaresEndandMirageSplit.split(", ");
		A_TM_NoName = TM_NoName.split(", ");
		A_TM_Oathkeeper = TM_Oathkeeper.split(", ");
		A_TM_Oblivion = TM_Oblivion.split(", ");
		A_TM_OceansRage = TM_OceansRage.split(", ");
		A_TM_Olympia = TM_Olympia.split(", ");
		A_TM_OmegaWeapon = TM_OmegaWeapon.split(", ");
		A_TM_OminousBlight = TM_OminousBlight.split(", ");
		A_TM_OneWingedAngel = TM_OneWingedAngel.split(", ");
		A_TM_PainofSolitude = TM_PainofSolitude.split(", ");
		A_TM_PhotonDebugger = TM_PhotonDebugger.split(", ");
		A_TM_PixiePetal = TM_PixiePetal.split(", ");
		A_TM_Pumpkinhead = TM_Pumpkinhead.split(", ");
		A_TM_Rainfell = TM_Rainfell.split(", ");
		A_TM_RejectionofFate = TM_RejectionofFate.split(", ");
		A_TM_RoyalRadiance = TM_RoyalRadiance.split(", ");
		A_TM_RumblingRose = TM_RumblingRose.split(", ");
		A_TM_SignofInnocence = TM_SignofInnocence.split(", ");
		A_TM_SilentDirge = TM_SilentDirge.split(", ");
		A_TM_SkullNoise = TM_SkullNoise.split(", ");
		A_TM_SleepingLion = TM_SleepingLion.split(", ");
		A_TM_SoulEater = TM_SoulEater.split(", ");
		A_TM_Spellbinder = TM_Spellbinder.split(", ");
		A_TM_StarSeeker = TM_StarSeeker.split(", ");
		A_TM_Starlight = TM_Starlight.split(", ");
		A_TM_Stormfall = TM_Stormfall.split(", ");
		A_TM_StrokeofMidnight = TM_StrokeofMidnight.split(", ");
		A_TM_SweetDreams = TM_SweetDreams.split(", ");
		A_TM_SweetMemories = TM_SweetMemories.split(", ");
		A_TM_Sweetstack = TM_Sweetstack.split(", ");
		A_TM_ThreeWishes = TM_ThreeWishes.split(", ");
		A_TM_TotalEclipse = TM_TotalEclipse.split(", ");
		A_TM_TreasureTrove = TM_TreasureTrove.split(", ");
		A_TM_TrueLightsFlight = TM_TrueLightsFlight.split(", ");
		A_TM_TwilightBlaze = TM_TwilightBlaze.split(", ");
		A_TM_TwoBecomeOne = TM_TwoBecomeOne.split(", ");
		A_TM_UltimaWeaponKH1 = TM_UltimaWeaponKH1.split(", ");
		A_TM_UltimaWeaponKH2 = TM_UltimaWeaponKH2.split(", ");
		A_TM_UltimaWeaponBBS = TM_UltimaWeaponBBS.split(", ");
		A_TM_UltimaWeaponDDD = TM_UltimaWeaponDDD.split(", ");
		A_TM_Umbrella = TM_Umbrella.split(", ");
		A_TM_Unbound = TM_Unbound.split(", ");
		A_TM_UnicornisForetellersKeyblade = TM_UnicornisForetellersKeyblade.split(", ");
		A_TM_UrsusForetellersKeyblade = TM_UrsusForetellersKeyblade.split(", ");
		A_TM_VictoryLine = TM_VictoryLine.split(", ");
		A_TM_VoidGear = TM_VoidGear.split(", ");
		A_TM_VulpeusForetellersKeyblade = TM_VulpeusForetellersKeyblade.split(", ");
		A_TM_WaytotheDawn = TM_WaytotheDawn.split(", ");
		A_TM_WaywardWind = TM_WaywardWind.split(", ");
		A_TM_WinnersProof = TM_WinnersProof.split(", ");
		A_TM_WishingLamp = TM_WishingLamp.split(", ");
		A_TM_WishingStar = TM_WishingStar.split(", ");
		A_TM_WoodenKeyblade = TM_WoodenKeyblade.split(", ");
		A_TM_WoodenStick = TM_WoodenStick.split(", ");
		A_TM_YoungXehanortsKeyblade = TM_YoungXehanortsKeyblade.split(", ");
		A_TM_ZeroOne = TM_ZeroOne.split(", ");

		if (config.hasChanged()) config.save();
	}

	private static boolean configProperty(String name, String description, boolean defaultValue, String category) {
		Property property = config.get(category, name, defaultValue);
		property.setComment(description);
		return property.getBoolean(defaultValue);
	}

	public static int configProperty(String name, String description, int defaultValue, String category) {
		Property property = config.get(category, name, defaultValue);
		property.setComment(description);
		return property.getInt(defaultValue);
	}

	public static double configProperty(String name, String description, double defaultValue, String category) {
		Property property = config.get(category, name, defaultValue);
		property.setComment(description);
		return property.getDouble(defaultValue);
	}

	public static String configProperty(String name, String description, String defaultValue, String category) {
		Property property = config.get(category, name, defaultValue);
		property.setComment(description);
		return property.getString();
	}

	public static Property configProperty(String name, String description, int[] defaultValue, String category) {
		Property property = config.get(category, name, defaultValue);
		property.setComment(description);
		return property;
	}

	public static Property configBooleanProperty(String name, String description, boolean defaultValue, String category) {
		Property property = config.get(category, name, defaultValue);
		property.setComment(description);
		return property;
	}

	public static String propertyCategory(String name, String parent) {
		return parent + Configuration.CATEGORY_SPLITTER + name;
	}

	// Sync config when changed
	@SubscribeEvent
	public void OnConfigChanged (ConfigChangedEvent.OnConfigChangedEvent event) {
		if (event.getModID().equals(Reference.MODID)) load();
	}
}
