package wehavecookies56.kk.lib;

import scala.Console;
import wehavecookies56.kk.KingdomKeys;
import net.minecraft.util.StatCollector;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.common.FMLCommonHandler;
import static wehavecookies56.kk.lib.Strings.*;

public class Config {

	public static Configuration config = KingdomKeys.config;
	
	public static String[] items;
	
	public static boolean
	EnableWorldGen;
	
	public static String
		TM_KingdomKey,
		TM_Oathkeeper,
		TM_Oblivion,
		TM_UltimaWeaponKH1,
		TM_KingdomKeyD,
		TM_KeybladeofPeoplesHearts,
		TM_LadyLuck,
		TM_Olympia,
		TM_JungleKing,
		TM_ThreeWishes,
		TM_Crabclaw,
		TM_FairyHarp,
		TM_DivineRose,
		TM_Spellbinder,
		TM_MetalChocobo,
		TM_Lionheart,
		TM_DiamondDust,
		TM_OneWingedAngel,
		TM_SoulEater,
		TM_Pumpkinhead,
		TM_WishingStar,
		TM_BondofFlame,
		TM_FollowtheWind,
		TM_HiddenDragon,
		TM_Monochrome,
		TM_PhotonDebugger,
		TM_StarSeeker,
		TM_MaverickFlare,
		TM_TotalEclipse,
		TM_MidnightRoar,
		TM_TwoBecomeOne,	
		TM_UltimaWeaponKH2,
		TM_WaytotheDawn,
		TM_DestinysEmbrace,
		TM_Stormfall,
		TM_EndsoftheEarth,
		TM_RumblingRose,
		TM_HerosCrest,
		TM_MysteriousAbyss,
		TM_WishingLamp,
		TM_DecisivePumpkin,
		TM_CircleofLife,
		TM_SweetMemories,
		TM_GullWing,
		TM_GuardianSoul,
		TM_SleepingLion,
		TM_Fenrir,
		TM_FatalCrest,
		TM_WinnersProof,
		TM_MissingAche,
		TM_OminousBlight,
		TM_AbaddonPlasma,
		TM_PainofSolitude,
		TM_SignofInnocence,
		TM_CrownofGuilt,
		TM_AbyssalTide,
		TM_Leviathan,
		TM_TrueLightsFlight,
		TM_RejectionofFate,
		TM_GlimpseofDarkness,
		TM_SilentDirge,
		TM_LunarEclipse,
		TM_DarkerThanDark,
		TM_AstralBlast,
		TM_TwilightBlaze,
		TM_OmegaWeapon,
		TM_Umbrella,
		TM_Aubade,
		TM_WoodenStick,
		TM_DreamSword,
		TM_ZeroOne,
		TM_Earthshaker,
		TM_Darkgnaw,
		TM_ChaosRipper,
		TM_MasterXehanortsKeyblade,
		TM_TreasureTrove,
		TM_StrokeofMidnight,
		TM_FairyStars,
		TM_VictoryLine,
		TM_MarkofaHero,
		TM_Hyperdrive,
		TM_PixiePetal,
		TM_Sweetstack,
		TM_UltimaWeaponBBS,
		TM_VoidGear,
		TM_NoName,
		TM_RoyalRadiance,
		TM_Rainfell,
		TM_Brightcrest,
		TM_MastersDefender,
		TM_WaywardWind,
		TM_FrolicFlame,
		TM_LostMemory,
		TM_Kiblade,
		TM_IncompleteKiblade,
		TM_WoodenKeyblade,
		TM_SkullNoise,
		TM_GuardianBell,
		TM_DualDisc,
		TM_FerrisGear,
	    TM_KnockoutPunch,
		TM_AllforOne,
		TM_Counterpoint,
		TM_Divewing,
		TM_SweetDreams,
		TM_UltimaWeaponDDD,
		TM_Unbound,
		TM_EndofPain,
		TM_OceanRage,
		TM_LeasKeyblade,
		TM_YoungXehanortsKeyblade,
		TM_Starlight,
		TM_AnguisForetellersKeyblade,
		TM_LeopardosForetellersKeyblade,
		TM_UnicornisForetellersKeyblade,
		TM_UrsusForetellersKeyblade,
		TM_VulpeusForetellersKeyblade;
	
	public static String[] 
		A_TM_AbaddonPlasma,
		A_TM_AbyssalTide,
		A_TM_AllforOne,
		A_TM_AnguisForetellersKeyblade,
		A_TM_AstralBlast,
		A_TM_Aubade,
		A_TM_BondofFlame,
		A_TM_Brightcrest,
		A_TM_ChaosRipper,
		A_TM_CircleofLife,
		A_TM_Counterpoint,
		A_TM_Crabclaw,
		A_TM_CrownofGuilt,
		A_TM_DarkerThanDark,
		A_TM_Darkgnaw,
		A_TM_DecisivePumpkin,
		A_TM_DestinysEmbrace,
		A_TM_DiamondDust,
		A_TM_Divewing,
		A_TM_DivineRose,
		A_TM_DreamSword,
		A_TM_DualDisc,
		A_TM_Earthshaker,
		A_TM_EndofPain,
		A_TM_EndsoftheEarth,
		A_TM_FairyHarp,
		A_TM_FairyStars,
		A_TM_FatalCrest,
		A_TM_Fenrir,
		A_TM_FerrisGear,
		A_TM_FollowtheWind,
		A_TM_FrolicFlame,
		A_TM_GlimpseofDarkness,
		A_TM_GuardianBell,
		A_TM_GuardianSoul,
		A_TM_GullWing,
		A_TM_HerosCrest,
		A_TM_HiddenDragon,
		A_TM_Hyperdrive,
		A_TM_IncompleteKiblade,
		A_TM_JungleKing,
		A_TM_KeybladeofPeoplesHearts,
		A_TM_Kiblade,
		A_TM_KingdomKey,
		A_TM_KingdomKeyD,
		A_TM_KnockoutPunch,
		A_TM_LadyLuck,
		A_TM_LeasKeyblade,
		A_TM_LeopardosForetellersKeyblade,
		A_TM_Leviathan,
		A_TM_Lionheart,
		A_TM_LostMemory,
		A_TM_LunarEclipse,
		A_TM_MarkofaHero,
		A_TM_MasterXehanortsKeyblade,
		A_TM_MastersDefender,
		A_TM_MaverickFlare,
		A_TM_MetalChocobo,
		A_TM_MidnightRoar,
		A_TM_MissingAche,
		A_TM_Monochrome,
		A_TM_MysteriousAbyss,
		A_TM_NoName,
		A_TM_Oathkeeper,
		A_TM_Oblivion,
		A_TM_OceanRage,
		A_TM_Olympia,
		A_TM_OmegaWeapon,
		A_TM_OminousBlight,
		A_TM_OneWingedAngel,
		A_TM_PainofSolitude,
		A_TM_PhotonDebugger,
		A_TM_PixiePetal,
		A_TM_Pumpkinhead,
		A_TM_Rainfell,
		A_TM_RejectionofFate,
		A_TM_RoyalRadiance,
		A_TM_RumblingRose,
		A_TM_SignofInnocence,
		A_TM_SilentDirge,
		A_TM_SkullNoise,
		A_TM_SleepingLion,
		A_TM_SoulEater,
		A_TM_Spellbinder,
		A_TM_StarSeeker,
		A_TM_Starlight,
		A_TM_Stormfall,
		A_TM_StrokeofMidnight,
		A_TM_SweetDreams,
		A_TM_SweetMemories,
		A_TM_Sweetstack,
		A_TM_ThreeWishes,
		A_TM_TotalEclipse,
		A_TM_TreasureTrove,
		A_TM_TrueLightsFlight,
		A_TM_TwilightBlaze,
		A_TM_TwoBecomeOne,
		A_TM_UltimaWeaponKH1,
		A_TM_UltimaWeaponKH2,
		A_TM_UltimaWeaponBBS,
		A_TM_UltimaWeaponDDD,
		A_TM_Umbrella,
		A_TM_Unbound,
		A_TM_UnicornisForetellersKeyblade,
		A_TM_UrsusForetellersKeyblade,
		A_TM_VictoryLine,
		A_TM_VoidGear,
		A_TM_VulpeusForetellersKeyblade,
		A_TM_WaytotheDawn,
		A_TM_WaywardWind,
		A_TM_WinnersProof,
		A_TM_WishingLamp,
		A_TM_WishingStar,
		A_TM_WoodenKeyblade,
		A_TM_WoodenStick,
		A_TM_YoungXehanortsKeyblade,
		A_TM_ZeroOne;
	
	public static void syncConfig(){
		FMLCommonHandler.instance().bus().register(KingdomKeys.instance);
		config.load();
		/**WORLDGEN******************************/
		final String WORLDGEN = config.CATEGORY_GENERAL + config.CATEGORY_SPLITTER + "Worldgen";
		EnableWorldGen = config.getBoolean("Enable World Gen", WORLDGEN, Booleans.ENABLEWORLDGEN_DEFAULT, "Toggles all world generation performed by this mod");
		
		/**ITEMS*********************************/
		final String ITEMS = config.CATEGORY_GENERAL + config.CATEGORY_SPLITTER + "Items";
		//items = config.get(ITEMS, "", "").getStringList();
		
		/**TOOLMATERIALS*************************/
		final String TM = ITEMS + config.CATEGORY_SPLITTER + "ToolMaterials";
		config.addCustomCategoryComment(TM, "The tool materials for items which use them, A space after commas is required. \nParameters {(String) NAME, (int) HARVESTLEVEL, (int) MAXUSES, (float) EFFICIENCY, (float) DAMAGE, (int) ENCHANTABILITY}");
		TM_AbaddonPlasma = config.get(TM, StatCollector.translateToLocal(Strings.TM_AbaddonPlasma_NAME), TM_AbaddonPlasma_DEFAULT).getString();
		TM_AbyssalTide = config.get(TM, StatCollector.translateToLocal(TM_AbyssalTide_NAME), TM_AbyssalTide_DEFAULT).getString();
		TM_AllforOne = config.get(TM, StatCollector.translateToLocal(TM_AllforOne_NAME), TM_AllforOne_DEFAULT).getString();
		TM_AnguisForetellersKeyblade = config.get(TM, StatCollector.translateToLocal(TM_AnguisForetellersKeyblade_NAME), TM_AnguisForetellersKeyblade_DEFAULT).getString();
		TM_AstralBlast = config.get(TM, StatCollector.translateToLocal(TM_AstralBlast_NAME), TM_AstralBlast_DEFAULT).getString();
		TM_Aubade = config.get(TM, StatCollector.translateToLocal(TM_Aubade_NAME), TM_Aubade_DEFAULT).getString();
		TM_BondofFlame = config.get(TM, StatCollector.translateToLocal(TM_BondofFlame_NAME), TM_BondofFlame_DEFAULT).getString();
		TM_Brightcrest = config.get(TM, StatCollector.translateToLocal(TM_Brightcrest_NAME), TM_Brightcrest_DEFAULT).getString();
		TM_ChaosRipper = config.get(TM, StatCollector.translateToLocal(TM_ChaosRipper_NAME), TM_ChaosRipper_DEFAULT).getString();
		TM_CircleofLife = config.get(TM, StatCollector.translateToLocal(TM_CircleofLife_NAME), TM_CircleofLife_DEFAULT).getString();
		TM_Counterpoint = config.get(TM, StatCollector.translateToLocal(TM_Counterpoint_NAME), TM_Counterpoint_DEFAULT).getString();
		TM_Crabclaw = config.get(TM, StatCollector.translateToLocal(TM_Crabclaw_NAME), TM_Crabclaw_DEFAULT).getString();
		TM_CrownofGuilt = config.get(TM, StatCollector.translateToLocal(TM_CrownofGuilt_NAME), TM_CrownofGuilt_DEFAULT).getString();
		TM_DarkerThanDark = config.get(TM, StatCollector.translateToLocal(TM_DarkerThanDark_NAME), TM_DarkerThanDark_DEFAULT).getString();
		TM_Darkgnaw = config.get(TM, StatCollector.translateToLocal(TM_Darkgnaw_NAME), TM_Darkgnaw_DEFAULT).getString();
		TM_DecisivePumpkin = config.get(TM, StatCollector.translateToLocal(TM_DecisivePumpkin_NAME), TM_DecisivePumpkin_DEFAULT).getString();
		TM_DestinysEmbrace = config.get(TM, StatCollector.translateToLocal(TM_DestinysEmbrace_NAME), TM_DestinysEmbrace_DEFAULT).getString();
		TM_DiamondDust = config.get(TM, StatCollector.translateToLocal(TM_DiamondDust_NAME), TM_DiamondDust_DEFAULT).getString();
		TM_Divewing = config.get(TM, StatCollector.translateToLocal(TM_Divewing_NAME), TM_Divewing_DEFAULT).getString();
		TM_DivineRose = config.get(TM, StatCollector.translateToLocal(TM_DivineRose_NAME), TM_DivineRose_DEFAULT).getString();
		TM_DreamSword = config.get(TM, StatCollector.translateToLocal(TM_DreamSword_NAME), TM_DreamSword_DEFAULT).getString();
		TM_DualDisc = config.get(TM, StatCollector.translateToLocal(TM_DualDisc_NAME), TM_DualDisc_DEFAULT).getString();
		TM_Earthshaker = config.get(TM, StatCollector.translateToLocal(TM_Earthshaker_NAME), TM_Earthshaker_DEFAULT).getString();
		TM_EndofPain = config.get(TM, StatCollector.translateToLocal(TM_EndofPain_NAME), TM_EndofPain_DEFAULT).getString();
		TM_EndsoftheEarth = config.get(TM, StatCollector.translateToLocal(TM_EndsoftheEarth_NAME), TM_EndsoftheEarth_DEFAULT).getString();
		TM_FairyHarp = config.get(TM, StatCollector.translateToLocal(TM_FairyHarp_NAME), TM_FairyHarp_DEFAULT).getString();
		TM_FairyStars = config.get(TM, StatCollector.translateToLocal(TM_FairyStars_NAME), TM_FairyStars_DEFAULT).getString();
		TM_FatalCrest = config.get(TM, StatCollector.translateToLocal(TM_FatalCrest_NAME), TM_FatalCrest_DEFAULT).getString();
		TM_Fenrir = config.get(TM, StatCollector.translateToLocal(TM_Fenrir_NAME), TM_Fenrir_DEFAULT).getString();
		TM_FerrisGear = config.get(TM, StatCollector.translateToLocal(TM_FerrisGear_NAME), TM_FerrisGear_DEFAULT).getString();
		TM_FollowtheWind = config.get(TM, StatCollector.translateToLocal(TM_FollowtheWind_NAME), TM_FollowtheWind_DEFAULT).getString();
		TM_FrolicFlame = config.get(TM, StatCollector.translateToLocal(TM_FrolicFlame_NAME), TM_FrolicFlame_DEFAULT).getString();
		TM_GlimpseofDarkness = config.get(TM, StatCollector.translateToLocal(TM_GlimpseofDarkness_NAME), TM_GlimpseofDarkness_DEFAULT).getString();
		TM_GuardianBell = config.get(TM, StatCollector.translateToLocal(TM_GuardianBell_NAME), TM_GuardianBell_DEFAULT).getString();
		TM_GuardianSoul = config.get(TM, StatCollector.translateToLocal(TM_GuardianSoul_NAME), TM_GuardianSoul_DEFAULT).getString();
		TM_GullWing = config.get(TM, StatCollector.translateToLocal(TM_GullWing_NAME), TM_GullWing_DEFAULT).getString();
		TM_HerosCrest = config.get(TM, StatCollector.translateToLocal(TM_HerosCrest_NAME), TM_HerosCrest_DEFAULT).getString();
		TM_HiddenDragon = config.get(TM, StatCollector.translateToLocal(TM_HiddenDragon_NAME), TM_HiddenDragon_DEFAULT).getString();
		TM_Hyperdrive = config.get(TM, StatCollector.translateToLocal(TM_Hyperdrive_NAME), TM_Hyperdrive_DEFAULT).getString();
		TM_IncompleteKiblade = config.get(TM, StatCollector.translateToLocal(TM_IncompleteKiblade_NAME), TM_IncompleteKiblade_DEFAULT).getString();
		TM_JungleKing = config.get(TM, StatCollector.translateToLocal(TM_JungleKing_NAME), TM_JungleKing_DEFAULT).getString();
		TM_KeybladeofPeoplesHearts = config.get(TM, StatCollector.translateToLocal(TM_KeybladeofPeoplesHearts_NAME), TM_KeybladeofPeoplesHearts_DEFAULT).getString();
		TM_Kiblade = config.get(TM, StatCollector.translateToLocal(TM_Kiblade_NAME), TM_Kiblade_DEFAULT).getString();
		TM_KingdomKey = config.get(TM, StatCollector.translateToLocal(TM_KingdomKey_NAME), TM_KingdomKey_DEFAULT).getString();
		TM_KingdomKeyD = config.get(TM, StatCollector.translateToLocal(TM_KingdomKeyD_NAME), TM_KingdomKeyD_DEFAULT).getString();
		TM_KnockoutPunch = config.get(TM, StatCollector.translateToLocal(TM_KnockoutPunch_NAME), TM_KnockoutPunch_DEFAULT).getString();
		TM_LadyLuck = config.get(TM, StatCollector.translateToLocal(TM_LadyLuck_NAME), TM_LadyLuck_DEFAULT).getString();
		TM_LeasKeyblade = config.get(TM, StatCollector.translateToLocal(TM_LeasKeyblade_NAME), TM_LeasKeyblade_DEFAULT).getString();
		TM_LeopardosForetellersKeyblade = config.get(TM, StatCollector.translateToLocal(TM_LeopardosForetellersKeyblade_NAME), TM_LeopardosForetellersKeyblade_DEFAULT).getString();
		TM_Leviathan = config.get(TM, StatCollector.translateToLocal(TM_Leviathan_NAME), TM_Leviathan_DEFAULT).getString();
		TM_Lionheart = config.get(TM, StatCollector.translateToLocal(TM_Lionheart_NAME), TM_Lionheart_DEFAULT).getString();
		TM_LostMemory = config.get(TM, StatCollector.translateToLocal(TM_LostMemory_NAME), TM_LostMemory_DEFAULT).getString();
		TM_LunarEclipse = config.get(TM, StatCollector.translateToLocal(TM_LunarEclipse_NAME), TM_LunarEclipse_DEFAULT).getString();
		TM_MarkofaHero = config.get(TM, StatCollector.translateToLocal(TM_MarkofaHero_NAME), TM_MarkofaHero_DEFAULT).getString();
		TM_MasterXehanortsKeyblade = config.get(TM, StatCollector.translateToLocal(TM_MasterXehanortsKeyblade_NAME), TM_MasterXehanortsKeyblade_DEFAULT).getString();
		TM_MastersDefender = config.get(TM, StatCollector.translateToLocal(TM_MastersDefender_NAME), TM_MastersDefender_DEFAULT).getString();
		TM_MaverickFlare = config.get(TM, StatCollector.translateToLocal(TM_MaverickFlare_NAME), TM_MaverickFlare_DEFAULT).getString();
		TM_MetalChocobo = config.get(TM, StatCollector.translateToLocal(TM_MetalChocobo_NAME), TM_MetalChocobo_DEFAULT).getString();
		TM_MidnightRoar = config.get(TM, StatCollector.translateToLocal(TM_MidnightRoar_NAME), TM_MidnightRoar_DEFAULT).getString();
		TM_MissingAche = config.get(TM, StatCollector.translateToLocal(TM_MissingAche_NAME), TM_MissingAche_DEFAULT).getString();
		TM_Monochrome = config.get(TM, StatCollector.translateToLocal(TM_Monochrome_NAME), TM_Monochrome_DEFAULT).getString();
		TM_MysteriousAbyss = config.get(TM, StatCollector.translateToLocal(TM_MysteriousAbyss_NAME), TM_MysteriousAbyss_DEFAULT).getString();
		TM_NoName = config.get(TM, StatCollector.translateToLocal(TM_NoName_NAME), TM_NoName_DEFAULT).getString();
		TM_Oathkeeper = config.get(TM, StatCollector.translateToLocal(TM_Oathkeeper_NAME), TM_Oathkeeper_DEFAULT).getString();
		TM_Oblivion = config.get(TM, StatCollector.translateToLocal(TM_Oblivion_NAME), TM_Oblivion_DEFAULT).getString();
		TM_OceanRage = config.get(TM, StatCollector.translateToLocal(TM_OceanRage_NAME), TM_OceanRage_DEFAULT).getString();
		TM_Olympia = config.get(TM, StatCollector.translateToLocal(TM_Olympia_NAME), TM_Olympia_DEFAULT).getString();
		TM_OmegaWeapon = config.get(TM, StatCollector.translateToLocal(TM_OmegaWeapon_NAME), TM_OmegaWeapon_DEFAULT).getString();
		TM_OminousBlight = config.get(TM, StatCollector.translateToLocal(TM_OminousBlight_NAME), TM_OminousBlight_DEFAULT).getString();
		TM_OneWingedAngel = config.get(TM, StatCollector.translateToLocal(TM_OneWingedAngel_NAME), TM_OneWingedAngel_DEFAULT).getString();
		TM_PainofSolitude = config.get(TM, StatCollector.translateToLocal(TM_PainofSolitude_NAME), TM_PainofSolitude_DEFAULT).getString();
		TM_PhotonDebugger = config.get(TM, StatCollector.translateToLocal(TM_PhotonDebugger_NAME), TM_PhotonDebugger_DEFAULT).getString();
		TM_PixiePetal = config.get(TM, StatCollector.translateToLocal(TM_PixiePetal_NAME), TM_PixiePetal_DEFAULT).getString();
		TM_Pumpkinhead = config.get(TM, StatCollector.translateToLocal(TM_Pumpkinhead_NAME), TM_Pumpkinhead_DEFAULT).getString();
		TM_Rainfell = config.get(TM, StatCollector.translateToLocal(TM_Rainfell_NAME), TM_Rainfell_DEFAULT).getString();
		TM_RejectionofFate = config.get(TM, StatCollector.translateToLocal(TM_RejectionofFate_NAME), TM_RejectionofFate_DEFAULT).getString();
		TM_RoyalRadiance = config.get(TM, StatCollector.translateToLocal(TM_RoyalRadiance_NAME), TM_RoyalRadiance_DEFAULT).getString();
		TM_RumblingRose = config.get(TM, StatCollector.translateToLocal(TM_RumblingRose_NAME), TM_RumblingRose_DEFAULT).getString();
		TM_SignofInnocence = config.get(TM, StatCollector.translateToLocal(TM_SignofInnocence_NAME), TM_SignofInnocence_DEFAULT).getString();
		TM_SilentDirge = config.get(TM, StatCollector.translateToLocal(TM_SilentDirge_NAME), TM_SilentDirge_DEFAULT).getString();
		TM_SkullNoise = config.get(TM, StatCollector.translateToLocal(TM_SkullNoise_NAME), TM_SkullNoise_DEFAULT).getString();
		TM_SleepingLion = config.get(TM, StatCollector.translateToLocal(TM_SleepingLion_NAME), TM_SleepingLion_DEFAULT).getString();
		TM_SoulEater = config.get(TM, StatCollector.translateToLocal(TM_SoulEater_NAME), TM_SoulEater_DEFAULT).getString();
		TM_Spellbinder = config.get(TM, StatCollector.translateToLocal(TM_Spellbinder_NAME), TM_Spellbinder_DEFAULT).getString();
		TM_StarSeeker = config.get(TM, StatCollector.translateToLocal(TM_StarSeeker_NAME), TM_StarSeeker_DEFAULT).getString();
		TM_Starlight = config.get(TM, StatCollector.translateToLocal(TM_Starlight_NAME), TM_Starlight_DEFAULT).getString();
		TM_Stormfall = config.get(TM, StatCollector.translateToLocal(TM_Stormfall_NAME), TM_Stormfall_DEFAULT).getString();
		TM_StrokeofMidnight = config.get(TM, StatCollector.translateToLocal(TM_StrokeofMidnight_NAME), TM_StrokeofMidnight_DEFAULT).getString();
		TM_SweetDreams = config.get(TM, StatCollector.translateToLocal(TM_SweetDreams_NAME), TM_SweetDreams_DEFAULT).getString();
		TM_SweetMemories = config.get(TM, StatCollector.translateToLocal(TM_SweetMemories_NAME), TM_SweetMemories_DEFAULT).getString();
		TM_Sweetstack = config.get(TM, StatCollector.translateToLocal(TM_Sweetstack_NAME), TM_Sweetstack_DEFAULT).getString();
		TM_ThreeWishes = config.get(TM, StatCollector.translateToLocal(TM_ThreeWishes_NAME), TM_ThreeWishes_DEFAULT).getString();
		TM_TotalEclipse = config.get(TM, StatCollector.translateToLocal(TM_TotalEclipse_NAME), TM_TotalEclipse_DEFAULT).getString();
		TM_TreasureTrove = config.get(TM, StatCollector.translateToLocal(TM_TreasureTrove_NAME), TM_TreasureTrove_DEFAULT).getString();
		TM_TrueLightsFlight = config.get(TM, StatCollector.translateToLocal(TM_TrueLightsFlight_NAME), TM_TrueLightsFlight_DEFAULT).getString();
		TM_TwilightBlaze = config.get(TM, StatCollector.translateToLocal(TM_TwilightBlaze_NAME), TM_TwilightBlaze_DEFAULT).getString();
		TM_TwoBecomeOne = config.get(TM, StatCollector.translateToLocal(TM_TwoBecomeOne_NAME), TM_TwoBecomeOne_DEFAULT).getString();
		TM_UltimaWeaponKH1 = config.get(TM, StatCollector.translateToLocal(TM_UltimaWeaponKH1_NAME), TM_UltimaWeaponKH1_DEFAULT).getString();
		TM_UltimaWeaponKH2 = config.get(TM, StatCollector.translateToLocal(TM_UltimaWeaponKH2_NAME), TM_UltimaWeaponKH2_DEFAULT).getString();
		TM_UltimaWeaponBBS = config.get(TM, StatCollector.translateToLocal(TM_UltimaWeaponBBS_NAME), TM_UltimaWeaponBBS_DEFAULT).getString();
		TM_UltimaWeaponDDD = config.get(TM, StatCollector.translateToLocal(TM_UltimaWeaponDDD_NAME), TM_UltimaWeaponDDD_DEFAULT).getString();
		TM_Umbrella = config.get(TM, StatCollector.translateToLocal(TM_Umbrella_NAME), TM_Umbrella_DEFAULT).getString();
		TM_Unbound = config.get(TM, StatCollector.translateToLocal(TM_Unbound_NAME), TM_Unbound_DEFAULT).getString();
		TM_UnicornisForetellersKeyblade = config.get(TM, StatCollector.translateToLocal(TM_UnicornisForetellersKeyblade_NAME), TM_UnicornisForetellersKeyblade_DEFAULT).getString();
		TM_UrsusForetellersKeyblade = config.get(TM, StatCollector.translateToLocal(TM_UrsusForetellersKeyblade_NAME), TM_UrsusForetellersKeyblade_DEFAULT).getString();
		TM_VictoryLine = config.get(TM, StatCollector.translateToLocal(TM_VictoryLine_NAME), TM_VictoryLine_DEFAULT).getString();
		TM_VoidGear = config.get(TM, StatCollector.translateToLocal(TM_VoidGear_NAME), TM_VoidGear_DEFAULT).getString();
		TM_VulpeusForetellersKeyblade = config.get(TM, StatCollector.translateToLocal(TM_VulpeusForetellersKeyblade_NAME), TM_VulpeusForetellersKeyblade_DEFAULT).getString();
		TM_WaytotheDawn = config.get(TM, StatCollector.translateToLocal(TM_WaytotheDawn_NAME), TM_WaytotheDawn_DEFAULT).getString();
		TM_WaywardWind = config.get(TM, StatCollector.translateToLocal(TM_WaywardWind_NAME), TM_WaywardWind_DEFAULT).getString();
		TM_WinnersProof = config.get(TM, StatCollector.translateToLocal(TM_WinnersProof_NAME), TM_WinnersProof_DEFAULT).getString();
		TM_WishingLamp = config.get(TM, StatCollector.translateToLocal(TM_WishingLamp_NAME), TM_WishingLamp_DEFAULT).getString();
		TM_WishingStar = config.get(TM, StatCollector.translateToLocal(TM_WishingStar_NAME), TM_WishingStar_DEFAULT).getString();
		TM_WoodenKeyblade = config.get(TM, StatCollector.translateToLocal(TM_WoodenKeyblade_NAME), TM_WoodenKeyblade_DEFAULT).getString();
		TM_WoodenStick = config.get(TM, StatCollector.translateToLocal(TM_WoodenStick_NAME), TM_WoodenStick_DEFAULT).getString();
		TM_YoungXehanortsKeyblade = config.get(TM, StatCollector.translateToLocal(TM_YoungXehanortsKeyblade_NAME), TM_YoungXehanortsKeyblade_DEFAULT).getString();
		TM_ZeroOne = config.get(TM, StatCollector.translateToLocal(TM_ZeroOne_NAME), TM_ZeroOne_DEFAULT).getString();
		
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
		A_TM_MissingAche = TM_MissingAche.split(", ");
		A_TM_Monochrome = TM_Monochrome.split(", ");
		A_TM_MysteriousAbyss = TM_MysteriousAbyss.split(", ");
		A_TM_NoName = TM_NoName.split(", ");
		A_TM_Oathkeeper = TM_Oathkeeper.split(", ");
		A_TM_Oblivion = TM_Oblivion.split(", ");
		A_TM_OceanRage = TM_OceanRage.split(", ");
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
		Console.println(A_TM_KingdomKey);
		if(config.hasChanged()){
			config.save();
		}
		
	}
}
