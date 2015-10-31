package wehavecookies56.kk.item;

import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraft.item.ItemFood;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.fml.common.registry.GameRegistry;
import wehavecookies56.kk.item.org.ItemArpeggio;
import wehavecookies56.kk.item.org.ItemBlazeofGlory;
import wehavecookies56.kk.item.org.ItemBookofRetribution;
import wehavecookies56.kk.item.org.ItemEternalFlames;
import wehavecookies56.kk.item.org.ItemFairGame;
import wehavecookies56.kk.item.org.ItemFoudre;
import wehavecookies56.kk.item.org.ItemFrozenPride;
import wehavecookies56.kk.item.org.ItemGracefulDahlia;
import wehavecookies56.kk.item.org.ItemInterdiction;
import wehavecookies56.kk.item.org.ItemLindworm;
import wehavecookies56.kk.item.org.ItemLunatic;
import wehavecookies56.kk.item.org.ItemSharpshooter;
import wehavecookies56.kk.item.org.ItemSkysplitter;
import wehavecookies56.kk.lib.Config;
import wehavecookies56.kk.lib.Reference;
import wehavecookies56.kk.lib.Strings;

public class ModItems {
	//Organization
	public static Item
	Interdiction,
	Sharpshooter,
	Lindworm,
	FrozenPride,
	Skysplitter,
	BookofRetribution,
	Lunatic,
	EternalFlames,
	Arpeggio,
	FairGame,
	GracefulDahlia,
	Foudre,

	BlazeofGlory
	;

	public static Item
	BlazingInfusedCoal,
	FrostInfusedSnowBall,
	StormyInfusedIron,
	MythrilInfusedDiamond,
	LightningInfusedGold,
	BrightInfusedGlowStone,
	DarkInfusedIron,

	AbandonedKnowledge,
	DarkKnowledge,
	EclipsedKnowledge,
	ForgottenKnowledge,
	IlludedKnowledge,
	LostKnowledge,
	ManifestKnowledge,
	ObscuredKnowledge,
	UnknownKnowledge,
	VoidKnowledge
	;

	//Keyblades
	public static Item
	AbaddonPlasma,
	AbyssalTide,
	AllforOne,
	AnguisForetellersKeyblade,
	AstralBlast,
	Aubade,
	BondofFlame,
	Brightcrest,
	ChaosRipper,
	CircleofLife,
	Counterpoint,
	Crabclaw,
	CrownofGuilt,
	DarkerThanDark,
	Darkgnaw,
	DecisivePumpkin,
	DestinysEmbrace,
	DiamondDust,
	Divewing,
	DivineRose,
	DreamSword,
	DualDisc,
	Earthshaker,
	EndofPain,
	EndsoftheEarth,
	FairyHarp,
	FairyStars,
	FatalCrest,
	Fenrir,
	FerrisGear,
	FollowtheWind,
	FrolicFlame,
	GlimpseofDarkness,
	GuardianBell,
	GuardianSoul,
	GullWing,
	HerosCrest,
	HiddenDragon,
	Hyperdrive,
	IncompleteKiblade,
	JungleKing,
	KeybladeofPeoplesHearts,
	Kiblade,
	KingdomKey,
	KingdomKeyD,
	KnockoutPunch,
	LadyLuck,
	LeasKeyblade,
	LeopardosForetellersKeyblade,
	Leviathan,
	Lionheart,
	LostMemory,
	LunarEclipse,
	MarkofaHero,
	MasterXehanortsKeyblade,
	MastersDefender,
	MaverickFlare,
	MetalChocobo,
	MidnightRoar,
	MissingAche,
	Monochrome,
	MysteriousAbyss,
	NoName,
	Oathkeeper,
	Oblivion,
	OceanRage,
	Olympia,
	OmegaWeapon,
	OminousBlight,
	OneWingedAngel,
	PainofSolitude,
	PhotonDebugger,
	PixiePetal,
	Pumpkinhead,
	Rainfell,
	RejectionofFate,
	RoyalRadiance,
	RumblingRose,
	SignofInnocence,
	SilentDirge,
	SkullNoise,
	SleepingLion,
	SoulEater,
	Spellbinder,
	StarSeeker,
	Starlight,
	Stormfall,
	StrokeofMidnight,
	SweetDreams,
	SweetMemories,
	Sweetstack,
	ThreeWishes,
	TotalEclipse,
	TreasureTrove,
	TrueLightsFlight,
	TwilightBlaze,
	TwoBecomeOne,
	UltimaWeaponKH1,
	UltimaWeaponKH2,
	UltimaWeaponBBS,
	UltimaWeaponDDD,
	Umbrella,
	Unbound,
	UnicornisForetellersKeyblade,
	UrsusForetellersKeyblade,
	VictoryLine,
	VoidGear,
	VulpeusForetellersKeyblade,
	WaytotheDawn,
	WaywardWind,
	WinnersProof,
	WishingLamp,
	WishingStar,
	WoodenKeyblade,
	WoodenStick,
	YoungXehanortsKeyblade,
	ZeroOne
	;

	//Chains
	public static Item
	Chain_AbaddonPlasma,
	Chain_AbyssalTide,
	Chain_AllforOne,
	Chain_AnguisForetellersKeyblade,
	Chain_AstralBlast,
	Chain_Aubade,
	Chain_BondofFlame,
	Chain_Brightcrest,
	Chain_ChaosRipper,
	Chain_CircleofLife,
	Chain_Counterpoint,
	Chain_Crabclaw,
	Chain_CrownofGuilt,
	Chain_DarkerThanDark,
	Chain_Darkgnaw,
	Chain_DecisivePumpkin,
	Chain_DestinysEmbrace,
	Chain_DiamondDust,
	Chain_Divewing,
	Chain_DivineRose,
	Chain_DreamSword,
	Chain_DualDisc,
	Chain_Earthshaker,
	Chain_EndofPain,
	Chain_EndsoftheEarth,
	Chain_FairyHarp,
	Chain_FairyStars,
	Chain_FatalCrest,
	Chain_Fenrir,
	Chain_FerrisGear,
	Chain_FollowtheWind,
	Chain_FrolicFlame,
	Chain_GlimpseofDarkness,
	Chain_GuardianBell,
	Chain_GuardianSoul,
	Chain_GullWing,
	Chain_HerosCrest,
	Chain_HiddenDragon,
	Chain_Hyperdrive,
	Chain_IncompleteKiblade,
	Chain_JungleKing,
	Chain_KeybladeofPeoplesHearts,
	Chain_Kiblade,
	Chain_KingdomKey,
	Chain_KingdomKeyD,
	Chain_KnockoutPunch,
	Chain_LadyLuck,
	Chain_LeasKeyblade,
	Chain_LeopardosForetellersKeyblade,
	Chain_Leviathan,
	Chain_Lionheart,
	Chain_LostMemory,
	Chain_LunarEclipse,
	Chain_MarkofaHero,
	Chain_MasterXehanortsKeyblade,
	Chain_MastersDefender,
	Chain_MaverickFlare,
	Chain_MetalChocobo,
	Chain_MidnightRoar,
	Chain_MissingAche,
	Chain_Monochrome,
	Chain_MysteriousAbyss,
	Chain_NoName,
	Chain_Oathkeeper,
	Chain_Oblivion,
	Chain_OceanRage,
	Chain_Olympia,
	Chain_OmegaWeapon,
	Chain_OminousBlight,
	Chain_OneWingedAngel,
	Chain_PainofSolitude,
	Chain_PhotonDebugger,
	Chain_PixiePetal,
	Chain_Pumpkinhead,
	Chain_Rainfell,
	Chain_RejectionofFate,
	Chain_RoyalRadiance,
	Chain_RumblingRose,
	Chain_SignofInnocence,
	Chain_SilentDirge,
	Chain_SkullNoise,
	Chain_SleepingLion,
	Chain_SoulEater,
	Chain_Spellbinder,
	Chain_StarSeeker,
	Chain_Starlight,
	Chain_Stormfall,
	Chain_StrokeofMidnight,
	Chain_SweetDreams,
	Chain_SweetMemories,
	Chain_Sweetstack,
	Chain_ThreeWishes,
	Chain_TotalEclipse,
	Chain_TreasureTrove,
	Chain_TrueLightsFlight,
	Chain_TwilightBlaze,
	Chain_TwoBecomeOne,
	Chain_UltimaWeaponKH1,
	Chain_UltimaWeaponKH2,
	Chain_UltimaWeaponBBS,
	Chain_UltimaWeaponDDD,
	Chain_Umbrella,
	Chain_Unbound,
	Chain_UnicornisForetellersKeyblade,
	Chain_UrsusForetellersKeyblade,
	Chain_VictoryLine,
	Chain_VoidGear,
	Chain_VulpeusForetellersKeyblade,
	Chain_WaytotheDawn,
	Chain_WaywardWind,
	Chain_WinnersProof,
	Chain_WishingLamp,
	Chain_WishingStar,
	Chain_YoungXehanortsKeyblade,
	Chain_ZeroOne
	;

	//Misc
	public static Item
	Munny,
	EmptyBottle,
	Potion,
	Ether,
	Elixir,
	HpOrb,
	DriveOrb,
	MagicOrb,
	Heart,
	DarkHeart,
	PureHeart,
	KingdomHearts,
	DarkLeather,
	SynthesisMaterial,
	Recipe,
	IceCream,
	WinnerStick,
	LevelUpMagicFire,
	LevelUpMagicBlizzard,
	LevelUpMagicThunder,
	LevelUpMagicCure,
	LevelUpMagicAero,
	LevelUpMagicStop
	;

	//Music Discs
	public static Item
	Disc_Birth_by_Sleep_A_Link_to_the_Future,
	Disc_Darkness_of_the_Unknown,
	Disc_Dearly_Beloved_Symphony_Version,
	Disc_Dream_Drop_Distance_The_Next_Awakening,
	Disc_Hikari_KINGDOM_Instrumental_Version,
	Disc_L_Oscurita_Dell_Ignoto,
	Disc_Musique_pour_la_tristesse_de_Xion,
	Disc_No_More_Bugs_Bug_Version,
	Disc_Organization_XIII,
	Disc_Sanctuary,
	Disc_Simple_And_Clean_PLANITb_Remix,
	Disc_Sinister_Sundown,
	Disc_The_13th_Anthology
	;

	//Armour
	public static Item
	OrganizationRobe_Helmet,
	OrganizationRobe_Chestplate,
	OrganizationRobe_Leggings,
	OrganizationRobe_Boots,

	Terra_Helmet,
	Terra_Chestplate,
	Terra_Leggings,
	Terra_Boots,

	Aqua_Helmet,
	Aqua_Chestplate,
	Aqua_Leggings,
	Aqua_Boots,

	Ventus_Helmet,
	Ventus_Chestplate,
	Ventus_Leggings,
	Ventus_Boots,

	Eraqus_Helmet,
	Eraqus_Chestplate,
	Eraqus_Leggings,
	Eraqus_Boots
	;

	//Armour materials
	public static ArmorMaterial ORGANIZATIONROBE = EnumHelper.addArmorMaterial("ORGANIZATIONROBE", Reference.MODID + ":organizationrobe", 35, new int[]{4, 8, 5, 3}, 15);
	public static ArmorMaterial TERRA = EnumHelper.addArmorMaterial("TERRA", Reference.MODID + ":terra", 35, new int[]{5, 9, 6, 5}, 15);
	public static ArmorMaterial AQUA = EnumHelper.addArmorMaterial("AQUA", Reference.MODID + ":aqua", 35, new int[]{5, 9, 6, 5}, 15);
	public static ArmorMaterial VENTUS = EnumHelper.addArmorMaterial("VENTUS", Reference.MODID + ":ventus", 35, new int[]{5, 9, 6, 5}, 15);
	public static ArmorMaterial ERAQUS = EnumHelper.addArmorMaterial("ERAQUS", Reference.MODID + ":eraqus", 35, new int[]{5, 9, 6, 5}, 15);

	public static CreativeTabs tabKingdomKeys;

	public static void init(){
		tabKingdomKeys = new TabKingdomKeys(CreativeTabs.getNextID(), Strings.tabKingdomKeys);

		BlazingInfusedCoal = new Item().setUnlocalizedName(Strings.BlazingInfusedCoal).setCreativeTab(tabKingdomKeys);
		FrostInfusedSnowBall = new Item().setUnlocalizedName(Strings.FrostInfusedSnowBall).setCreativeTab(tabKingdomKeys);
		StormyInfusedIron = new Item().setUnlocalizedName(Strings.StormyInfusedIron).setCreativeTab(tabKingdomKeys);
		MythrilInfusedDiamond = new Item().setUnlocalizedName(Strings.MythrilInfusedDiamond).setCreativeTab(tabKingdomKeys);
		LightningInfusedGold = new Item().setUnlocalizedName(Strings.LightningInfusedGold).setCreativeTab(tabKingdomKeys);
		BrightInfusedGlowStone = new Item().setUnlocalizedName(Strings.BrightInfusedGlowStone).setCreativeTab(tabKingdomKeys);
		DarkInfusedIron = new Item().setUnlocalizedName(Strings.DarkInfusedIron).setCreativeTab(tabKingdomKeys);

		AbandonedKnowledge = new Item().setUnlocalizedName(Strings.AbandonedKnowledge).setCreativeTab(tabKingdomKeys);
		DarkKnowledge = new Item().setUnlocalizedName(Strings.DarkKnowledge).setCreativeTab(tabKingdomKeys);
		EclipsedKnowledge = new Item().setUnlocalizedName(Strings.EclipsedKnowledge).setCreativeTab(tabKingdomKeys);
		ForgottenKnowledge = new Item().setUnlocalizedName(Strings.ForgottenKnowledge).setCreativeTab(tabKingdomKeys);
		IlludedKnowledge = new Item().setUnlocalizedName(Strings.IlludedKnowledge).setCreativeTab(tabKingdomKeys);
		LostKnowledge = new Item().setUnlocalizedName(Strings.LostKnowledge).setCreativeTab(tabKingdomKeys);
		ManifestKnowledge = new ItemManifestKnowledge().setUnlocalizedName(Strings.ManifestKnowledge).setCreativeTab(tabKingdomKeys);
		ObscuredKnowledge = new Item().setUnlocalizedName(Strings.ObscuredKnowledge).setCreativeTab(tabKingdomKeys);
		UnknownKnowledge = new Item().setUnlocalizedName(Strings.UnknownKnowledge).setCreativeTab(tabKingdomKeys);
		VoidKnowledge = new Item().setUnlocalizedName(Strings.VoidKnowledge).setCreativeTab(tabKingdomKeys);

		Interdiction = new ItemInterdiction(EnumHelper.addToolMaterial(Config.A_TM_Interdiction[0], Integer.parseInt(Config.A_TM_Interdiction[1]), Integer.parseInt(Config.A_TM_Interdiction[2]), Float.parseFloat(Config.A_TM_Interdiction[3]), Float.parseFloat(Config.A_TM_Interdiction[4]), Integer.parseInt(Config.A_TM_Interdiction[5]))).setCreativeTab(tabKingdomKeys).setUnlocalizedName(Strings.Interdiction);
		Sharpshooter = new ItemSharpshooter(EnumHelper.addToolMaterial(Config.A_TM_Sharpshooter[0], Integer.parseInt(Config.A_TM_Sharpshooter[1]), Integer.parseInt(Config.A_TM_Sharpshooter[2]), Float.parseFloat(Config.A_TM_Sharpshooter[3]), Float.parseFloat(Config.A_TM_Sharpshooter[4]), Integer.parseInt(Config.A_TM_Sharpshooter[5]))).setCreativeTab(tabKingdomKeys).setUnlocalizedName(Strings.Sharpshooter);
		Lindworm = new ItemLindworm(EnumHelper.addToolMaterial(Config.A_TM_Lindworm[0], Integer.parseInt(Config.A_TM_Lindworm[1]), Integer.parseInt(Config.A_TM_Lindworm[2]), Float.parseFloat(Config.A_TM_Lindworm[3]), Float.parseFloat(Config.A_TM_Lindworm[4]), Integer.parseInt(Config.A_TM_Lindworm[5]))).setCreativeTab(tabKingdomKeys).setUnlocalizedName(Strings.Lindworm);
		FrozenPride = new ItemFrozenPride(EnumHelper.addToolMaterial(Config.A_TM_FrozenPride[0], Integer.parseInt(Config.A_TM_FrozenPride[1]), Integer.parseInt(Config.A_TM_FrozenPride[2]), Float.parseFloat(Config.A_TM_FrozenPride[3]), Float.parseFloat(Config.A_TM_FrozenPride[4]), Integer.parseInt(Config.A_TM_FrozenPride[5]))).setCreativeTab(tabKingdomKeys).setUnlocalizedName(Strings.FrozenPride);
		Skysplitter = new ItemSkysplitter(EnumHelper.addToolMaterial(Config.A_TM_Skysplitter[0], Integer.parseInt(Config.A_TM_Skysplitter[1]), Integer.parseInt(Config.A_TM_Skysplitter[2]), Float.parseFloat(Config.A_TM_Skysplitter[3]), Float.parseFloat(Config.A_TM_Skysplitter[4]), Integer.parseInt(Config.A_TM_Skysplitter[5]))).setCreativeTab(tabKingdomKeys).setUnlocalizedName(Strings.Skysplitter);
		BookofRetribution = new ItemBookofRetribution(EnumHelper.addToolMaterial(Config.A_TM_BookofRetribution[0], Integer.parseInt(Config.A_TM_BookofRetribution[1]), Integer.parseInt(Config.A_TM_BookofRetribution[2]), Float.parseFloat(Config.A_TM_BookofRetribution[3]), Float.parseFloat(Config.A_TM_BookofRetribution[4]), Integer.parseInt(Config.A_TM_BookofRetribution[5]))).setCreativeTab(tabKingdomKeys).setUnlocalizedName(Strings.BookofRetribution);
		Lunatic = new ItemLunatic(EnumHelper.addToolMaterial(Config.A_TM_Lunatic[0], Integer.parseInt(Config.A_TM_Lunatic[1]), Integer.parseInt(Config.A_TM_Lunatic[2]), Float.parseFloat(Config.A_TM_Lunatic[3]), Float.parseFloat(Config.A_TM_Lunatic[4]), Integer.parseInt(Config.A_TM_Lunatic[5]))).setCreativeTab(tabKingdomKeys).setUnlocalizedName(Strings.Lunatic);
		EternalFlames = new ItemEternalFlames(EnumHelper.addToolMaterial(Config.A_TM_EternalFlames[0], Integer.parseInt(Config.A_TM_EternalFlames[1]), Integer.parseInt(Config.A_TM_EternalFlames[2]), Float.parseFloat(Config.A_TM_EternalFlames[3]), Float.parseFloat(Config.A_TM_EternalFlames[4]), Integer.parseInt(Config.A_TM_EternalFlames[5]))).setCreativeTab(tabKingdomKeys).setUnlocalizedName(Strings.EternalFlames);
		Arpeggio = new ItemArpeggio(EnumHelper.addToolMaterial(Config.A_TM_Arpeggio[0], Integer.parseInt(Config.A_TM_Arpeggio[1]), Integer.parseInt(Config.A_TM_Arpeggio[2]), Float.parseFloat(Config.A_TM_Arpeggio[3]), Float.parseFloat(Config.A_TM_Arpeggio[4]), Integer.parseInt(Config.A_TM_Arpeggio[5]))).setCreativeTab(tabKingdomKeys).setUnlocalizedName(Strings.Arpeggio);
		FairGame = new ItemFairGame(EnumHelper.addToolMaterial(Config.A_TM_FairGame[0], Integer.parseInt(Config.A_TM_FairGame[1]), Integer.parseInt(Config.A_TM_FairGame[2]), Float.parseFloat(Config.A_TM_FairGame[3]), Float.parseFloat(Config.A_TM_FairGame[4]), Integer.parseInt(Config.A_TM_FairGame[5]))).setCreativeTab(tabKingdomKeys).setUnlocalizedName(Strings.FairGame);
		GracefulDahlia = new ItemGracefulDahlia(EnumHelper.addToolMaterial(Config.A_TM_GracefulDahlia[0], Integer.parseInt(Config.A_TM_GracefulDahlia[1]), Integer.parseInt(Config.A_TM_GracefulDahlia[2]), Float.parseFloat(Config.A_TM_GracefulDahlia[3]), Float.parseFloat(Config.A_TM_GracefulDahlia[4]), Integer.parseInt(Config.A_TM_GracefulDahlia[5]))).setCreativeTab(tabKingdomKeys).setUnlocalizedName(Strings.GracefulDahlia);
		Foudre = new ItemFoudre(EnumHelper.addToolMaterial(Config.A_TM_Foudre[0], Integer.parseInt(Config.A_TM_Foudre[1]), Integer.parseInt(Config.A_TM_Foudre[2]), Float.parseFloat(Config.A_TM_Foudre[3]), Float.parseFloat(Config.A_TM_Foudre[4]), Integer.parseInt(Config.A_TM_Foudre[5]))).setCreativeTab(tabKingdomKeys).setUnlocalizedName(Strings.Foudre);
		BlazeofGlory = new ItemBlazeofGlory(EnumHelper.addToolMaterial(Config.A_TM_BlazeofGlory[0], Integer.parseInt(Config.A_TM_BlazeofGlory[1]), Integer.parseInt(Config.A_TM_BlazeofGlory[2]), Float.parseFloat(Config.A_TM_BlazeofGlory[3]), Float.parseFloat(Config.A_TM_BlazeofGlory[4]), Integer.parseInt(Config.A_TM_BlazeofGlory[5]))).setCreativeTab(tabKingdomKeys).setUnlocalizedName(Strings.BlazeofGlory);

		AbaddonPlasma = new ItemKeyblade(EnumHelper.addToolMaterial(Config.A_TM_AbaddonPlasma[0], Integer.parseInt(Config.A_TM_AbaddonPlasma[1]), Integer.parseInt(Config.A_TM_AbaddonPlasma[2]), Float.parseFloat(Config.A_TM_AbaddonPlasma[3]), Float.parseFloat(Config.A_TM_AbaddonPlasma[4]), Integer.parseInt(Config.A_TM_AbaddonPlasma[5]))).setCreativeTab(tabKingdomKeys).setUnlocalizedName(Strings.AbaddonPlasma);
		AbyssalTide = new ItemKeyblade(EnumHelper.addToolMaterial(Config.A_TM_AbyssalTide[0], Integer.parseInt(Config.A_TM_AbyssalTide[1]), Integer.parseInt(Config.A_TM_AbyssalTide[2]), Float.parseFloat(Config.A_TM_AbyssalTide[3]), Float.parseFloat(Config.A_TM_AbyssalTide[4]), Integer.parseInt(Config.A_TM_AbyssalTide[5]))).setCreativeTab(tabKingdomKeys).setUnlocalizedName(Strings.AbyssalTide);
		AllforOne = new ItemKeyblade(EnumHelper.addToolMaterial(Config.A_TM_AllforOne[0], Integer.parseInt(Config.A_TM_AllforOne[1]), Integer.parseInt(Config.A_TM_AllforOne[2]), Float.parseFloat(Config.A_TM_AllforOne[3]), Float.parseFloat(Config.A_TM_AllforOne[4]), Integer.parseInt(Config.A_TM_AllforOne[5]))).setCreativeTab(tabKingdomKeys).setUnlocalizedName(Strings.AllforOne);
		AnguisForetellersKeyblade = new ItemKeyblade(EnumHelper.addToolMaterial(Config.A_TM_AnguisForetellersKeyblade[0], Integer.parseInt(Config.A_TM_AnguisForetellersKeyblade[1]), Integer.parseInt(Config.A_TM_AnguisForetellersKeyblade[2]), Float.parseFloat(Config.A_TM_AnguisForetellersKeyblade[3]), Float.parseFloat(Config.A_TM_AnguisForetellersKeyblade[4]), Integer.parseInt(Config.A_TM_AnguisForetellersKeyblade[5]))).setCreativeTab(tabKingdomKeys).setUnlocalizedName(Strings.AnguisForetellersKeyblade);
		AstralBlast = new ItemKeyblade(EnumHelper.addToolMaterial(Config.A_TM_AstralBlast[0], Integer.parseInt(Config.A_TM_AstralBlast[1]), Integer.parseInt(Config.A_TM_AstralBlast[2]), Float.parseFloat(Config.A_TM_AstralBlast[3]), Float.parseFloat(Config.A_TM_AstralBlast[4]), Integer.parseInt(Config.A_TM_AstralBlast[5]))).setCreativeTab(tabKingdomKeys).setUnlocalizedName(Strings.AstralBlast);
		Aubade = new ItemKeyblade(EnumHelper.addToolMaterial(Config.A_TM_Aubade[0], Integer.parseInt(Config.A_TM_Aubade[1]), Integer.parseInt(Config.A_TM_Aubade[2]), Float.parseFloat(Config.A_TM_Aubade[3]), Float.parseFloat(Config.A_TM_Aubade[4]), Integer.parseInt(Config.A_TM_Aubade[5]))).setCreativeTab(tabKingdomKeys).setUnlocalizedName(Strings.Aubade);
		BondofFlame = new ItemKeyblade(EnumHelper.addToolMaterial(Config.A_TM_BondofFlame[0], Integer.parseInt(Config.A_TM_BondofFlame[1]), Integer.parseInt(Config.A_TM_BondofFlame[2]), Float.parseFloat(Config.A_TM_BondofFlame[3]), Float.parseFloat(Config.A_TM_BondofFlame[4]), Integer.parseInt(Config.A_TM_BondofFlame[5]))).setCreativeTab(tabKingdomKeys).setUnlocalizedName(Strings.BondofFlame);
		Brightcrest = new ItemKeyblade(EnumHelper.addToolMaterial(Config.A_TM_Brightcrest[0], Integer.parseInt(Config.A_TM_Brightcrest[1]), Integer.parseInt(Config.A_TM_Brightcrest[2]), Float.parseFloat(Config.A_TM_Brightcrest[3]), Float.parseFloat(Config.A_TM_Brightcrest[4]), Integer.parseInt(Config.A_TM_Brightcrest[5]))).setCreativeTab(tabKingdomKeys).setUnlocalizedName(Strings.Brightcrest);
		ChaosRipper = new ItemKeyblade(EnumHelper.addToolMaterial(Config.A_TM_ChaosRipper[0], Integer.parseInt(Config.A_TM_ChaosRipper[1]), Integer.parseInt(Config.A_TM_ChaosRipper[2]), Float.parseFloat(Config.A_TM_ChaosRipper[3]), Float.parseFloat(Config.A_TM_ChaosRipper[4]), Integer.parseInt(Config.A_TM_ChaosRipper[5]))).setCreativeTab(tabKingdomKeys).setUnlocalizedName(Strings.ChaosRipper);
		CircleofLife = new ItemKeyblade(EnumHelper.addToolMaterial(Config.A_TM_CircleofLife[0], Integer.parseInt(Config.A_TM_CircleofLife[1]), Integer.parseInt(Config.A_TM_CircleofLife[2]), Float.parseFloat(Config.A_TM_CircleofLife[3]), Float.parseFloat(Config.A_TM_CircleofLife[4]), Integer.parseInt(Config.A_TM_CircleofLife[5]))).setCreativeTab(tabKingdomKeys).setUnlocalizedName(Strings.CircleofLife);
		Counterpoint = new ItemKeyblade(EnumHelper.addToolMaterial(Config.A_TM_Counterpoint[0], Integer.parseInt(Config.A_TM_Counterpoint[1]), Integer.parseInt(Config.A_TM_Counterpoint[2]), Float.parseFloat(Config.A_TM_Counterpoint[3]), Float.parseFloat(Config.A_TM_Counterpoint[4]), Integer.parseInt(Config.A_TM_Counterpoint[5]))).setCreativeTab(tabKingdomKeys).setUnlocalizedName(Strings.Counterpoint);
		Crabclaw = new ItemCrabclaw(EnumHelper.addToolMaterial(Config.A_TM_Crabclaw[0], Integer.parseInt(Config.A_TM_Crabclaw[1]), Integer.parseInt(Config.A_TM_Crabclaw[2]), Float.parseFloat(Config.A_TM_Crabclaw[3]), Float.parseFloat(Config.A_TM_Crabclaw[4]), Integer.parseInt(Config.A_TM_Crabclaw[5]))).setCreativeTab(tabKingdomKeys).setUnlocalizedName(Strings.Crabclaw);
		CrownofGuilt = new ItemKeyblade(EnumHelper.addToolMaterial(Config.A_TM_CrownofGuilt[0], Integer.parseInt(Config.A_TM_CrownofGuilt[1]), Integer.parseInt(Config.A_TM_CrownofGuilt[2]), Float.parseFloat(Config.A_TM_CrownofGuilt[3]), Float.parseFloat(Config.A_TM_CrownofGuilt[4]), Integer.parseInt(Config.A_TM_CrownofGuilt[5]))).setCreativeTab(tabKingdomKeys).setUnlocalizedName(Strings.CrownofGuilt);
		DarkerThanDark = new ItemKeyblade(EnumHelper.addToolMaterial(Config.A_TM_DarkerThanDark[0], Integer.parseInt(Config.A_TM_DarkerThanDark[1]), Integer.parseInt(Config.A_TM_DarkerThanDark[2]), Float.parseFloat(Config.A_TM_DarkerThanDark[3]), Float.parseFloat(Config.A_TM_DarkerThanDark[4]), Integer.parseInt(Config.A_TM_DarkerThanDark[5]))).setCreativeTab(tabKingdomKeys).setUnlocalizedName(Strings.DarkerThanDark);
		Darkgnaw = new ItemKeyblade(EnumHelper.addToolMaterial(Config.A_TM_Darkgnaw[0], Integer.parseInt(Config.A_TM_Darkgnaw[1]), Integer.parseInt(Config.A_TM_Darkgnaw[2]), Float.parseFloat(Config.A_TM_Darkgnaw[3]), Float.parseFloat(Config.A_TM_Darkgnaw[4]), Integer.parseInt(Config.A_TM_Darkgnaw[5]))).setCreativeTab(tabKingdomKeys).setUnlocalizedName(Strings.Darkgnaw);
		DecisivePumpkin = new ItemKeyblade(EnumHelper.addToolMaterial(Config.A_TM_DecisivePumpkin[0], Integer.parseInt(Config.A_TM_DecisivePumpkin[1]), Integer.parseInt(Config.A_TM_DecisivePumpkin[2]), Float.parseFloat(Config.A_TM_DecisivePumpkin[3]), Float.parseFloat(Config.A_TM_DecisivePumpkin[4]), Integer.parseInt(Config.A_TM_DecisivePumpkin[5]))).setCreativeTab(tabKingdomKeys).setUnlocalizedName(Strings.DecisivePumpkin);
		DestinysEmbrace = new ItemKeyblade(EnumHelper.addToolMaterial(Config.A_TM_DestinysEmbrace[0], Integer.parseInt(Config.A_TM_DestinysEmbrace[1]), Integer.parseInt(Config.A_TM_DestinysEmbrace[2]), Float.parseFloat(Config.A_TM_DestinysEmbrace[3]), Float.parseFloat(Config.A_TM_DestinysEmbrace[4]), Integer.parseInt(Config.A_TM_DestinysEmbrace[5]))).setCreativeTab(tabKingdomKeys).setUnlocalizedName(Strings.DestinysEmbrace);
		DiamondDust = new ItemDiamondDust(EnumHelper.addToolMaterial(Config.A_TM_DiamondDust[0], Integer.parseInt(Config.A_TM_DiamondDust[1]), Integer.parseInt(Config.A_TM_DiamondDust[2]), Float.parseFloat(Config.A_TM_DiamondDust[3]), Float.parseFloat(Config.A_TM_DiamondDust[4]), Integer.parseInt(Config.A_TM_DiamondDust[5]))).setCreativeTab(tabKingdomKeys).setUnlocalizedName(Strings.DiamondDust);
		Divewing = new ItemKeyblade(EnumHelper.addToolMaterial(Config.A_TM_Divewing[0], Integer.parseInt(Config.A_TM_Divewing[1]), Integer.parseInt(Config.A_TM_Divewing[2]), Float.parseFloat(Config.A_TM_Divewing[3]), Float.parseFloat(Config.A_TM_Divewing[4]), Integer.parseInt(Config.A_TM_Divewing[5]))).setCreativeTab(tabKingdomKeys).setUnlocalizedName(Strings.Divewing);
		DivineRose = new ItemDivineRose(EnumHelper.addToolMaterial(Config.A_TM_DivineRose[0], Integer.parseInt(Config.A_TM_DivineRose[1]), Integer.parseInt(Config.A_TM_DivineRose[2]), Float.parseFloat(Config.A_TM_DivineRose[3]), Float.parseFloat(Config.A_TM_DivineRose[4]), Integer.parseInt(Config.A_TM_DivineRose[5]))).setCreativeTab(tabKingdomKeys).setUnlocalizedName(Strings.DivineRose);
		DreamSword = new ItemKeyblade(EnumHelper.addToolMaterial(Config.A_TM_DreamSword[0], Integer.parseInt(Config.A_TM_DreamSword[1]), Integer.parseInt(Config.A_TM_DreamSword[2]), Float.parseFloat(Config.A_TM_DreamSword[3]), Float.parseFloat(Config.A_TM_DreamSword[4]), Integer.parseInt(Config.A_TM_DreamSword[5]))).setCreativeTab(tabKingdomKeys).setUnlocalizedName(Strings.DreamSword);
		DualDisc = new ItemKeyblade(EnumHelper.addToolMaterial(Config.A_TM_DualDisc[0], Integer.parseInt(Config.A_TM_DualDisc[1]), Integer.parseInt(Config.A_TM_DualDisc[2]), Float.parseFloat(Config.A_TM_DualDisc[3]), Float.parseFloat(Config.A_TM_DualDisc[4]), Integer.parseInt(Config.A_TM_DualDisc[5]))).setCreativeTab(tabKingdomKeys).setUnlocalizedName(Strings.DualDisc);
		Earthshaker = new ItemKeyblade(EnumHelper.addToolMaterial(Config.A_TM_Earthshaker[0], Integer.parseInt(Config.A_TM_Earthshaker[1]), Integer.parseInt(Config.A_TM_Earthshaker[2]), Float.parseFloat(Config.A_TM_Earthshaker[3]), Float.parseFloat(Config.A_TM_Earthshaker[4]), Integer.parseInt(Config.A_TM_Earthshaker[5]))).setCreativeTab(tabKingdomKeys).setUnlocalizedName(Strings.Earthshaker);
		EndofPain = new ItemKeyblade(EnumHelper.addToolMaterial(Config.A_TM_EndofPain[0], Integer.parseInt(Config.A_TM_EndofPain[1]), Integer.parseInt(Config.A_TM_EndofPain[2]), Float.parseFloat(Config.A_TM_EndofPain[3]), Float.parseFloat(Config.A_TM_EndofPain[4]), Integer.parseInt(Config.A_TM_EndofPain[5]))).setCreativeTab(tabKingdomKeys).setUnlocalizedName(Strings.EndofPain);
		EndsoftheEarth = new ItemKeyblade(EnumHelper.addToolMaterial(Config.A_TM_EndsoftheEarth[0], Integer.parseInt(Config.A_TM_EndsoftheEarth[1]), Integer.parseInt(Config.A_TM_EndsoftheEarth[2]), Float.parseFloat(Config.A_TM_EndsoftheEarth[3]), Float.parseFloat(Config.A_TM_EndsoftheEarth[4]), Integer.parseInt(Config.A_TM_EndsoftheEarth[5]))).setCreativeTab(tabKingdomKeys).setUnlocalizedName(Strings.EndsoftheEarth);
		FairyHarp = new ItemFairyHarp(EnumHelper.addToolMaterial(Config.A_TM_FairyHarp[0], Integer.parseInt(Config.A_TM_FairyHarp[1]), Integer.parseInt(Config.A_TM_FairyHarp[2]), Float.parseFloat(Config.A_TM_FairyHarp[3]), Float.parseFloat(Config.A_TM_FairyHarp[4]), Integer.parseInt(Config.A_TM_FairyHarp[5]))).setCreativeTab(tabKingdomKeys).setUnlocalizedName(Strings.FairyHarp);
		FairyStars = new ItemKeyblade(EnumHelper.addToolMaterial(Config.A_TM_FairyStars[0], Integer.parseInt(Config.A_TM_FairyStars[1]), Integer.parseInt(Config.A_TM_FairyStars[2]), Float.parseFloat(Config.A_TM_FairyStars[3]), Float.parseFloat(Config.A_TM_FairyStars[4]), Integer.parseInt(Config.A_TM_FairyStars[5]))).setCreativeTab(tabKingdomKeys).setUnlocalizedName(Strings.FairyStars);
		FatalCrest = new ItemKeyblade(EnumHelper.addToolMaterial(Config.A_TM_FatalCrest[0], Integer.parseInt(Config.A_TM_FatalCrest[1]), Integer.parseInt(Config.A_TM_FatalCrest[2]), Float.parseFloat(Config.A_TM_FatalCrest[3]), Float.parseFloat(Config.A_TM_FatalCrest[4]), Integer.parseInt(Config.A_TM_FatalCrest[5]))).setCreativeTab(tabKingdomKeys).setUnlocalizedName(Strings.FatalCrest);
		Fenrir = new ItemKeyblade(EnumHelper.addToolMaterial(Config.A_TM_Fenrir[0], Integer.parseInt(Config.A_TM_Fenrir[1]), Integer.parseInt(Config.A_TM_Fenrir[2]), Float.parseFloat(Config.A_TM_Fenrir[3]), Float.parseFloat(Config.A_TM_Fenrir[4]), Integer.parseInt(Config.A_TM_Fenrir[5]))).setCreativeTab(tabKingdomKeys).setUnlocalizedName(Strings.Fenrir);
		FerrisGear = new ItemKeyblade(EnumHelper.addToolMaterial(Config.A_TM_FerrisGear[0], Integer.parseInt(Config.A_TM_FerrisGear[1]), Integer.parseInt(Config.A_TM_FerrisGear[2]), Float.parseFloat(Config.A_TM_FerrisGear[3]), Float.parseFloat(Config.A_TM_FerrisGear[4]), Integer.parseInt(Config.A_TM_FerrisGear[5]))).setCreativeTab(tabKingdomKeys).setUnlocalizedName(Strings.FerrisGear);
		FollowtheWind = new ItemKeyblade(EnumHelper.addToolMaterial(Config.A_TM_FollowtheWind[0], Integer.parseInt(Config.A_TM_FollowtheWind[1]), Integer.parseInt(Config.A_TM_FollowtheWind[2]), Float.parseFloat(Config.A_TM_FollowtheWind[3]), Float.parseFloat(Config.A_TM_FollowtheWind[4]), Integer.parseInt(Config.A_TM_FollowtheWind[5]))).setCreativeTab(tabKingdomKeys).setUnlocalizedName(Strings.FollowtheWind);
		FrolicFlame = new ItemKeyblade(EnumHelper.addToolMaterial(Config.A_TM_FrolicFlame[0], Integer.parseInt(Config.A_TM_FrolicFlame[1]), Integer.parseInt(Config.A_TM_FrolicFlame[2]), Float.parseFloat(Config.A_TM_FrolicFlame[3]), Float.parseFloat(Config.A_TM_FrolicFlame[4]), Integer.parseInt(Config.A_TM_FrolicFlame[5]))).setCreativeTab(tabKingdomKeys).setUnlocalizedName(Strings.FrolicFlame);
		GlimpseofDarkness = new ItemKeyblade(EnumHelper.addToolMaterial(Config.A_TM_GlimpseofDarkness[0], Integer.parseInt(Config.A_TM_GlimpseofDarkness[1]), Integer.parseInt(Config.A_TM_GlimpseofDarkness[2]), Float.parseFloat(Config.A_TM_GlimpseofDarkness[3]), Float.parseFloat(Config.A_TM_GlimpseofDarkness[4]), Integer.parseInt(Config.A_TM_GlimpseofDarkness[5]))).setCreativeTab(tabKingdomKeys).setUnlocalizedName(Strings.GlimpseofDarkness);
		GuardianBell = new ItemKeyblade(EnumHelper.addToolMaterial(Config.A_TM_GuardianBell[0], Integer.parseInt(Config.A_TM_GuardianBell[1]), Integer.parseInt(Config.A_TM_GuardianBell[2]), Float.parseFloat(Config.A_TM_GuardianBell[3]), Float.parseFloat(Config.A_TM_GuardianBell[4]), Integer.parseInt(Config.A_TM_GuardianBell[5]))).setCreativeTab(tabKingdomKeys).setUnlocalizedName(Strings.GuardianBell);
		GuardianSoul = new ItemKeyblade(EnumHelper.addToolMaterial(Config.A_TM_GuardianSoul[0], Integer.parseInt(Config.A_TM_GuardianSoul[1]), Integer.parseInt(Config.A_TM_GuardianSoul[2]), Float.parseFloat(Config.A_TM_GuardianSoul[3]), Float.parseFloat(Config.A_TM_GuardianSoul[4]), Integer.parseInt(Config.A_TM_GuardianSoul[5]))).setCreativeTab(tabKingdomKeys).setUnlocalizedName(Strings.GuardianSoul);
		GullWing = new ItemKeyblade(EnumHelper.addToolMaterial(Config.A_TM_GullWing[0], Integer.parseInt(Config.A_TM_GullWing[1]), Integer.parseInt(Config.A_TM_GullWing[2]), Float.parseFloat(Config.A_TM_GullWing[3]), Float.parseFloat(Config.A_TM_GullWing[4]), Integer.parseInt(Config.A_TM_GullWing[5]))).setCreativeTab(tabKingdomKeys).setUnlocalizedName(Strings.GullWing);
		HerosCrest = new ItemKeyblade(EnumHelper.addToolMaterial(Config.A_TM_HerosCrest[0], Integer.parseInt(Config.A_TM_HerosCrest[1]), Integer.parseInt(Config.A_TM_HerosCrest[2]), Float.parseFloat(Config.A_TM_HerosCrest[3]), Float.parseFloat(Config.A_TM_HerosCrest[4]), Integer.parseInt(Config.A_TM_HerosCrest[5]))).setCreativeTab(tabKingdomKeys).setUnlocalizedName(Strings.HerosCrest);
		HiddenDragon = new ItemKeyblade(EnumHelper.addToolMaterial(Config.A_TM_HiddenDragon[0], Integer.parseInt(Config.A_TM_HiddenDragon[1]), Integer.parseInt(Config.A_TM_HiddenDragon[2]), Float.parseFloat(Config.A_TM_HiddenDragon[3]), Float.parseFloat(Config.A_TM_HiddenDragon[4]), Integer.parseInt(Config.A_TM_HiddenDragon[5]))).setCreativeTab(tabKingdomKeys).setUnlocalizedName(Strings.HiddenDragon);
		Hyperdrive = new ItemKeyblade(EnumHelper.addToolMaterial(Config.A_TM_Hyperdrive[0], Integer.parseInt(Config.A_TM_Hyperdrive[1]), Integer.parseInt(Config.A_TM_Hyperdrive[2]), Float.parseFloat(Config.A_TM_Hyperdrive[3]), Float.parseFloat(Config.A_TM_Hyperdrive[4]), Integer.parseInt(Config.A_TM_Hyperdrive[5]))).setCreativeTab(tabKingdomKeys).setUnlocalizedName(Strings.Hyperdrive);
		IncompleteKiblade = new ItemKeyblade(EnumHelper.addToolMaterial(Config.A_TM_IncompleteKiblade[0], Integer.parseInt(Config.A_TM_IncompleteKiblade[1]), Integer.parseInt(Config.A_TM_IncompleteKiblade[2]), Float.parseFloat(Config.A_TM_IncompleteKiblade[3]), Float.parseFloat(Config.A_TM_IncompleteKiblade[4]), Integer.parseInt(Config.A_TM_IncompleteKiblade[5]))).setCreativeTab(tabKingdomKeys).setUnlocalizedName(Strings.IncompleteKiblade);
		JungleKing = new ItemJungleKing(EnumHelper.addToolMaterial(Config.A_TM_JungleKing[0], Integer.parseInt(Config.A_TM_JungleKing[1]), Integer.parseInt(Config.A_TM_JungleKing[2]), Float.parseFloat(Config.A_TM_JungleKing[3]), Float.parseFloat(Config.A_TM_JungleKing[4]), Integer.parseInt(Config.A_TM_JungleKing[5]))).setCreativeTab(tabKingdomKeys).setUnlocalizedName(Strings.JungleKing);
		KeybladeofPeoplesHearts = new ItemKeybladeofPeoplesHearts(EnumHelper.addToolMaterial(Config.A_TM_KeybladeofPeoplesHearts[0], Integer.parseInt(Config.A_TM_KeybladeofPeoplesHearts[1]), Integer.parseInt(Config.A_TM_KeybladeofPeoplesHearts[2]), Float.parseFloat(Config.A_TM_KeybladeofPeoplesHearts[3]), Float.parseFloat(Config.A_TM_KeybladeofPeoplesHearts[4]), Integer.parseInt(Config.A_TM_KeybladeofPeoplesHearts[5]))).setCreativeTab(tabKingdomKeys).setUnlocalizedName(Strings.KeybladeofPeoplesHearts);
		Kiblade = new ItemKeyblade(EnumHelper.addToolMaterial(Config.A_TM_Kiblade[0], Integer.parseInt(Config.A_TM_Kiblade[1]), Integer.parseInt(Config.A_TM_Kiblade[2]), Float.parseFloat(Config.A_TM_Kiblade[3]), Float.parseFloat(Config.A_TM_Kiblade[4]), Integer.parseInt(Config.A_TM_Kiblade[5]))).setCreativeTab(tabKingdomKeys).setUnlocalizedName(Strings.Kiblade);
		KingdomKey = new ItemKingdomKey(EnumHelper.addToolMaterial(Config.A_TM_KingdomKey[0], Integer.parseInt(Config.A_TM_KingdomKey[1]), Integer.parseInt(Config.A_TM_KingdomKey[2]), Float.parseFloat(Config.A_TM_KingdomKey[3]), Float.parseFloat(Config.A_TM_KingdomKey[4]), Integer.parseInt(Config.A_TM_KingdomKey[5]))).setCreativeTab(tabKingdomKeys).setUnlocalizedName(Strings.KingdomKey);
		KingdomKeyD = new ItemKingdomKeyD(EnumHelper.addToolMaterial(Config.A_TM_KingdomKeyD[0], Integer.parseInt(Config.A_TM_KingdomKeyD[1]), Integer.parseInt(Config.A_TM_KingdomKeyD[2]), Float.parseFloat(Config.A_TM_KingdomKeyD[3]), Float.parseFloat(Config.A_TM_KingdomKeyD[4]), Integer.parseInt(Config.A_TM_KingdomKeyD[5]))).setCreativeTab(tabKingdomKeys).setUnlocalizedName(Strings.KingdomKeyD);
		KnockoutPunch = new ItemKeyblade(EnumHelper.addToolMaterial(Config.A_TM_KnockoutPunch[0], Integer.parseInt(Config.A_TM_KnockoutPunch[1]), Integer.parseInt(Config.A_TM_KnockoutPunch[2]), Float.parseFloat(Config.A_TM_KnockoutPunch[3]), Float.parseFloat(Config.A_TM_KnockoutPunch[4]), Integer.parseInt(Config.A_TM_KnockoutPunch[5]))).setCreativeTab(tabKingdomKeys).setUnlocalizedName(Strings.KnockoutPunch);
		LadyLuck = new ItemLadyLuck(EnumHelper.addToolMaterial(Config.A_TM_LadyLuck[0], Integer.parseInt(Config.A_TM_LadyLuck[1]), Integer.parseInt(Config.A_TM_LadyLuck[2]), Float.parseFloat(Config.A_TM_LadyLuck[3]), Float.parseFloat(Config.A_TM_LadyLuck[4]), Integer.parseInt(Config.A_TM_LadyLuck[5]))).setCreativeTab(tabKingdomKeys).setUnlocalizedName(Strings.LadyLuck);
		LeasKeyblade = new ItemKeyblade(EnumHelper.addToolMaterial(Config.A_TM_LeasKeyblade[0], Integer.parseInt(Config.A_TM_LeasKeyblade[1]), Integer.parseInt(Config.A_TM_LeasKeyblade[2]), Float.parseFloat(Config.A_TM_LeasKeyblade[3]), Float.parseFloat(Config.A_TM_LeasKeyblade[4]), Integer.parseInt(Config.A_TM_LeasKeyblade[5]))).setCreativeTab(tabKingdomKeys).setUnlocalizedName(Strings.LeasKeyblade);
		LeopardosForetellersKeyblade = new ItemKeyblade(EnumHelper.addToolMaterial(Config.A_TM_LeopardosForetellersKeyblade[0], Integer.parseInt(Config.A_TM_LeopardosForetellersKeyblade[1]), Integer.parseInt(Config.A_TM_LeopardosForetellersKeyblade[2]), Float.parseFloat(Config.A_TM_LeopardosForetellersKeyblade[3]), Float.parseFloat(Config.A_TM_LeopardosForetellersKeyblade[4]), Integer.parseInt(Config.A_TM_LeopardosForetellersKeyblade[5]))).setCreativeTab(tabKingdomKeys).setUnlocalizedName(Strings.LeopardosForetellersKeyblade);
		Leviathan = new ItemKeyblade(EnumHelper.addToolMaterial(Config.A_TM_Leviathan[0], Integer.parseInt(Config.A_TM_Leviathan[1]), Integer.parseInt(Config.A_TM_Leviathan[2]), Float.parseFloat(Config.A_TM_Leviathan[3]), Float.parseFloat(Config.A_TM_Leviathan[4]), Integer.parseInt(Config.A_TM_Leviathan[5]))).setCreativeTab(tabKingdomKeys).setUnlocalizedName(Strings.Leviathan);
		Lionheart = new ItemLionheart(EnumHelper.addToolMaterial(Config.A_TM_Lionheart[0], Integer.parseInt(Config.A_TM_Lionheart[1]), Integer.parseInt(Config.A_TM_Lionheart[2]), Float.parseFloat(Config.A_TM_Lionheart[3]), Float.parseFloat(Config.A_TM_Lionheart[4]), Integer.parseInt(Config.A_TM_Lionheart[5]))).setCreativeTab(tabKingdomKeys).setUnlocalizedName(Strings.Lionheart);
		LostMemory = new ItemKeyblade(EnumHelper.addToolMaterial(Config.A_TM_LostMemory[0], Integer.parseInt(Config.A_TM_LostMemory[1]), Integer.parseInt(Config.A_TM_LostMemory[2]), Float.parseFloat(Config.A_TM_LostMemory[3]), Float.parseFloat(Config.A_TM_LostMemory[4]), Integer.parseInt(Config.A_TM_LostMemory[5]))).setCreativeTab(tabKingdomKeys).setUnlocalizedName(Strings.LostMemory);
		LunarEclipse = new ItemKeyblade(EnumHelper.addToolMaterial(Config.A_TM_LunarEclipse[0], Integer.parseInt(Config.A_TM_LunarEclipse[1]), Integer.parseInt(Config.A_TM_LunarEclipse[2]), Float.parseFloat(Config.A_TM_LunarEclipse[3]), Float.parseFloat(Config.A_TM_LunarEclipse[4]), Integer.parseInt(Config.A_TM_LunarEclipse[5]))).setCreativeTab(tabKingdomKeys).setUnlocalizedName(Strings.LunarEclipse);
		MarkofaHero = new ItemKeyblade(EnumHelper.addToolMaterial(Config.A_TM_MarkofaHero[0], Integer.parseInt(Config.A_TM_MarkofaHero[1]), Integer.parseInt(Config.A_TM_MarkofaHero[2]), Float.parseFloat(Config.A_TM_MarkofaHero[3]), Float.parseFloat(Config.A_TM_MarkofaHero[4]), Integer.parseInt(Config.A_TM_MarkofaHero[5]))).setCreativeTab(tabKingdomKeys).setUnlocalizedName(Strings.MarkofaHero);
		MasterXehanortsKeyblade = new ItemKeyblade(EnumHelper.addToolMaterial(Config.A_TM_MasterXehanortsKeyblade[0], Integer.parseInt(Config.A_TM_MasterXehanortsKeyblade[1]), Integer.parseInt(Config.A_TM_MasterXehanortsKeyblade[2]), Float.parseFloat(Config.A_TM_MasterXehanortsKeyblade[3]), Float.parseFloat(Config.A_TM_MasterXehanortsKeyblade[4]), Integer.parseInt(Config.A_TM_MasterXehanortsKeyblade[5]))).setCreativeTab(tabKingdomKeys).setUnlocalizedName(Strings.MasterXehanortsKeyblade);
		MastersDefender = new ItemKeyblade(EnumHelper.addToolMaterial(Config.A_TM_MastersDefender[0], Integer.parseInt(Config.A_TM_MastersDefender[1]), Integer.parseInt(Config.A_TM_MastersDefender[2]), Float.parseFloat(Config.A_TM_MastersDefender[3]), Float.parseFloat(Config.A_TM_MastersDefender[4]), Integer.parseInt(Config.A_TM_MastersDefender[5]))).setCreativeTab(tabKingdomKeys).setUnlocalizedName(Strings.MastersDefender);
		MaverickFlare = new ItemKeyblade(EnumHelper.addToolMaterial(Config.A_TM_MaverickFlare[0], Integer.parseInt(Config.A_TM_MaverickFlare[1]), Integer.parseInt(Config.A_TM_MaverickFlare[2]), Float.parseFloat(Config.A_TM_MaverickFlare[3]), Float.parseFloat(Config.A_TM_MaverickFlare[4]), Integer.parseInt(Config.A_TM_MaverickFlare[5]))).setCreativeTab(tabKingdomKeys).setUnlocalizedName(Strings.MaverickFlare);
		MetalChocobo = new ItemMetalChocobo(EnumHelper.addToolMaterial(Config.A_TM_MetalChocobo[0], Integer.parseInt(Config.A_TM_MetalChocobo[1]), Integer.parseInt(Config.A_TM_MetalChocobo[2]), Float.parseFloat(Config.A_TM_MetalChocobo[3]), Float.parseFloat(Config.A_TM_MetalChocobo[4]), Integer.parseInt(Config.A_TM_MetalChocobo[5]))).setCreativeTab(tabKingdomKeys).setUnlocalizedName(Strings.MetalChocobo);
		MidnightRoar = new ItemKeyblade(EnumHelper.addToolMaterial(Config.A_TM_MidnightRoar[0], Integer.parseInt(Config.A_TM_MidnightRoar[1]), Integer.parseInt(Config.A_TM_MidnightRoar[2]), Float.parseFloat(Config.A_TM_MidnightRoar[3]), Float.parseFloat(Config.A_TM_MidnightRoar[4]), Integer.parseInt(Config.A_TM_MidnightRoar[5]))).setCreativeTab(tabKingdomKeys).setUnlocalizedName(Strings.MidnightRoar);
		MissingAche = new ItemKeyblade(EnumHelper.addToolMaterial(Config.A_TM_MissingAche[0], Integer.parseInt(Config.A_TM_MissingAche[1]), Integer.parseInt(Config.A_TM_MissingAche[2]), Float.parseFloat(Config.A_TM_MissingAche[3]), Float.parseFloat(Config.A_TM_MissingAche[4]), Integer.parseInt(Config.A_TM_MissingAche[5]))).setCreativeTab(tabKingdomKeys).setUnlocalizedName(Strings.MissingAche);
		Monochrome = new ItemKeyblade(EnumHelper.addToolMaterial(Config.A_TM_Monochrome[0], Integer.parseInt(Config.A_TM_Monochrome[1]), Integer.parseInt(Config.A_TM_Monochrome[2]), Float.parseFloat(Config.A_TM_Monochrome[3]), Float.parseFloat(Config.A_TM_Monochrome[4]), Integer.parseInt(Config.A_TM_Monochrome[5]))).setCreativeTab(tabKingdomKeys).setUnlocalizedName(Strings.Monochrome);
		MysteriousAbyss = new ItemKeyblade(EnumHelper.addToolMaterial(Config.A_TM_MysteriousAbyss[0], Integer.parseInt(Config.A_TM_MysteriousAbyss[1]), Integer.parseInt(Config.A_TM_MysteriousAbyss[2]), Float.parseFloat(Config.A_TM_MysteriousAbyss[3]), Float.parseFloat(Config.A_TM_MysteriousAbyss[4]), Integer.parseInt(Config.A_TM_MysteriousAbyss[5]))).setCreativeTab(tabKingdomKeys).setUnlocalizedName(Strings.MysteriousAbyss);
		NoName = new ItemKeyblade(EnumHelper.addToolMaterial(Config.A_TM_NoName[0], Integer.parseInt(Config.A_TM_NoName[1]), Integer.parseInt(Config.A_TM_NoName[2]), Float.parseFloat(Config.A_TM_NoName[3]), Float.parseFloat(Config.A_TM_NoName[4]), Integer.parseInt(Config.A_TM_NoName[5]))).setCreativeTab(tabKingdomKeys).setUnlocalizedName(Strings.NoName);
		Oathkeeper = new ItemOathkeeper(EnumHelper.addToolMaterial(Config.A_TM_Oathkeeper[0], Integer.parseInt(Config.A_TM_Oathkeeper[1]), Integer.parseInt(Config.A_TM_Oathkeeper[2]), Float.parseFloat(Config.A_TM_Oathkeeper[3]), Float.parseFloat(Config.A_TM_Oathkeeper[4]), Integer.parseInt(Config.A_TM_Oathkeeper[5]))).setCreativeTab(tabKingdomKeys).setUnlocalizedName(Strings.Oathkeeper);
		Oblivion = new ItemOblivion(EnumHelper.addToolMaterial(Config.A_TM_Oblivion[0], Integer.parseInt(Config.A_TM_Oblivion[1]), Integer.parseInt(Config.A_TM_Oblivion[2]), Float.parseFloat(Config.A_TM_Oblivion[3]), Float.parseFloat(Config.A_TM_Oblivion[4]), Integer.parseInt(Config.A_TM_Oblivion[5]))).setCreativeTab(tabKingdomKeys).setUnlocalizedName(Strings.Oblivion);
		OceanRage = new ItemKeyblade(EnumHelper.addToolMaterial(Config.A_TM_OceanRage[0], Integer.parseInt(Config.A_TM_OceanRage[1]), Integer.parseInt(Config.A_TM_OceanRage[2]), Float.parseFloat(Config.A_TM_OceanRage[3]), Float.parseFloat(Config.A_TM_OceanRage[4]), Integer.parseInt(Config.A_TM_OceanRage[5]))).setCreativeTab(tabKingdomKeys).setUnlocalizedName(Strings.OceanRage);
		Olympia = new ItemOlympia(EnumHelper.addToolMaterial(Config.A_TM_Olympia[0], Integer.parseInt(Config.A_TM_Olympia[1]), Integer.parseInt(Config.A_TM_Olympia[2]), Float.parseFloat(Config.A_TM_Olympia[3]), Float.parseFloat(Config.A_TM_Olympia[4]), Integer.parseInt(Config.A_TM_Olympia[5]))).setCreativeTab(tabKingdomKeys).setUnlocalizedName(Strings.Olympia);
		OmegaWeapon = new ItemKeyblade(EnumHelper.addToolMaterial(Config.A_TM_OmegaWeapon[0], Integer.parseInt(Config.A_TM_OmegaWeapon[1]), Integer.parseInt(Config.A_TM_OmegaWeapon[2]), Float.parseFloat(Config.A_TM_OmegaWeapon[3]), Float.parseFloat(Config.A_TM_OmegaWeapon[4]), Integer.parseInt(Config.A_TM_OmegaWeapon[5]))).setCreativeTab(tabKingdomKeys).setUnlocalizedName(Strings.OmegaWeapon);
		OminousBlight = new ItemKeyblade(EnumHelper.addToolMaterial(Config.A_TM_OminousBlight[0], Integer.parseInt(Config.A_TM_OminousBlight[1]), Integer.parseInt(Config.A_TM_OminousBlight[2]), Float.parseFloat(Config.A_TM_OminousBlight[3]), Float.parseFloat(Config.A_TM_OminousBlight[4]), Integer.parseInt(Config.A_TM_OminousBlight[5]))).setCreativeTab(tabKingdomKeys).setUnlocalizedName(Strings.OminousBlight);
		OneWingedAngel = new ItemOneWingedAngel(EnumHelper.addToolMaterial(Config.A_TM_OneWingedAngel[0], Integer.parseInt(Config.A_TM_OneWingedAngel[1]), Integer.parseInt(Config.A_TM_OneWingedAngel[2]), Float.parseFloat(Config.A_TM_OneWingedAngel[3]), Float.parseFloat(Config.A_TM_OneWingedAngel[4]), Integer.parseInt(Config.A_TM_OneWingedAngel[5]))).setCreativeTab(tabKingdomKeys).setUnlocalizedName(Strings.OneWingedAngel);
		PainofSolitude = new ItemKeyblade(EnumHelper.addToolMaterial(Config.A_TM_PainofSolitude[0], Integer.parseInt(Config.A_TM_PainofSolitude[1]), Integer.parseInt(Config.A_TM_PainofSolitude[2]), Float.parseFloat(Config.A_TM_PainofSolitude[3]), Float.parseFloat(Config.A_TM_PainofSolitude[4]), Integer.parseInt(Config.A_TM_PainofSolitude[5]))).setCreativeTab(tabKingdomKeys).setUnlocalizedName(Strings.PainofSolitude);
		PhotonDebugger = new ItemKeyblade(EnumHelper.addToolMaterial(Config.A_TM_PhotonDebugger[0], Integer.parseInt(Config.A_TM_PhotonDebugger[1]), Integer.parseInt(Config.A_TM_PhotonDebugger[2]), Float.parseFloat(Config.A_TM_PhotonDebugger[3]), Float.parseFloat(Config.A_TM_PhotonDebugger[4]), Integer.parseInt(Config.A_TM_PhotonDebugger[5]))).setCreativeTab(tabKingdomKeys).setUnlocalizedName(Strings.PhotonDebugger);
		PixiePetal = new ItemKeyblade(EnumHelper.addToolMaterial(Config.A_TM_PixiePetal[0], Integer.parseInt(Config.A_TM_PixiePetal[1]), Integer.parseInt(Config.A_TM_PixiePetal[2]), Float.parseFloat(Config.A_TM_PixiePetal[3]), Float.parseFloat(Config.A_TM_PixiePetal[4]), Integer.parseInt(Config.A_TM_PixiePetal[5]))).setCreativeTab(tabKingdomKeys).setUnlocalizedName(Strings.PixiePetal);
		Pumpkinhead = new ItemPumpkinHead(EnumHelper.addToolMaterial(Config.A_TM_Pumpkinhead[0], Integer.parseInt(Config.A_TM_Pumpkinhead[1]), Integer.parseInt(Config.A_TM_Pumpkinhead[2]), Float.parseFloat(Config.A_TM_Pumpkinhead[3]), Float.parseFloat(Config.A_TM_Pumpkinhead[4]), Integer.parseInt(Config.A_TM_Pumpkinhead[5]))).setCreativeTab(tabKingdomKeys).setUnlocalizedName(Strings.Pumpkinhead);
		Rainfell = new ItemKeyblade(EnumHelper.addToolMaterial(Config.A_TM_Rainfell[0], Integer.parseInt(Config.A_TM_Rainfell[1]), Integer.parseInt(Config.A_TM_Rainfell[2]), Float.parseFloat(Config.A_TM_Rainfell[3]), Float.parseFloat(Config.A_TM_Rainfell[4]), Integer.parseInt(Config.A_TM_Rainfell[5]))).setCreativeTab(tabKingdomKeys).setUnlocalizedName(Strings.Rainfell);
		RejectionofFate = new ItemKeyblade(EnumHelper.addToolMaterial(Config.A_TM_RejectionofFate[0], Integer.parseInt(Config.A_TM_RejectionofFate[1]), Integer.parseInt(Config.A_TM_RejectionofFate[2]), Float.parseFloat(Config.A_TM_RejectionofFate[3]), Float.parseFloat(Config.A_TM_RejectionofFate[4]), Integer.parseInt(Config.A_TM_RejectionofFate[5]))).setCreativeTab(tabKingdomKeys).setUnlocalizedName(Strings.RejectionofFate);
		RoyalRadiance = new ItemKeyblade(EnumHelper.addToolMaterial(Config.A_TM_RoyalRadiance[0], Integer.parseInt(Config.A_TM_RoyalRadiance[1]), Integer.parseInt(Config.A_TM_RoyalRadiance[2]), Float.parseFloat(Config.A_TM_RoyalRadiance[3]), Float.parseFloat(Config.A_TM_RoyalRadiance[4]), Integer.parseInt(Config.A_TM_RoyalRadiance[5]))).setCreativeTab(tabKingdomKeys).setUnlocalizedName(Strings.RoyalRadiance);
		RumblingRose = new ItemKeyblade(EnumHelper.addToolMaterial(Config.A_TM_RumblingRose[0], Integer.parseInt(Config.A_TM_RumblingRose[1]), Integer.parseInt(Config.A_TM_RumblingRose[2]), Float.parseFloat(Config.A_TM_RumblingRose[3]), Float.parseFloat(Config.A_TM_RumblingRose[4]), Integer.parseInt(Config.A_TM_RumblingRose[5]))).setCreativeTab(tabKingdomKeys).setUnlocalizedName(Strings.RumblingRose);
		SignofInnocence = new ItemKeyblade(EnumHelper.addToolMaterial(Config.A_TM_SignofInnocence[0], Integer.parseInt(Config.A_TM_SignofInnocence[1]), Integer.parseInt(Config.A_TM_SignofInnocence[2]), Float.parseFloat(Config.A_TM_SignofInnocence[3]), Float.parseFloat(Config.A_TM_SignofInnocence[4]), Integer.parseInt(Config.A_TM_SignofInnocence[5]))).setCreativeTab(tabKingdomKeys).setUnlocalizedName(Strings.SignofInnocence);
		SilentDirge = new ItemKeyblade(EnumHelper.addToolMaterial(Config.A_TM_SilentDirge[0], Integer.parseInt(Config.A_TM_SilentDirge[1]), Integer.parseInt(Config.A_TM_SilentDirge[2]), Float.parseFloat(Config.A_TM_SilentDirge[3]), Float.parseFloat(Config.A_TM_SilentDirge[4]), Integer.parseInt(Config.A_TM_SilentDirge[5]))).setCreativeTab(tabKingdomKeys).setUnlocalizedName(Strings.SilentDirge);
		SkullNoise = new ItemKeyblade(EnumHelper.addToolMaterial(Config.A_TM_SkullNoise[0], Integer.parseInt(Config.A_TM_SkullNoise[1]), Integer.parseInt(Config.A_TM_SkullNoise[2]), Float.parseFloat(Config.A_TM_SkullNoise[3]), Float.parseFloat(Config.A_TM_SkullNoise[4]), Integer.parseInt(Config.A_TM_SkullNoise[5]))).setCreativeTab(tabKingdomKeys).setUnlocalizedName(Strings.SkullNoise);
		SleepingLion = new ItemKeyblade(EnumHelper.addToolMaterial(Config.A_TM_SleepingLion[0], Integer.parseInt(Config.A_TM_SleepingLion[1]), Integer.parseInt(Config.A_TM_SleepingLion[2]), Float.parseFloat(Config.A_TM_SleepingLion[3]), Float.parseFloat(Config.A_TM_SleepingLion[4]), Integer.parseInt(Config.A_TM_SleepingLion[5]))).setCreativeTab(tabKingdomKeys).setUnlocalizedName(Strings.SleepingLion);
		SoulEater = new ItemSoulEater(EnumHelper.addToolMaterial(Config.A_TM_SoulEater[0], Integer.parseInt(Config.A_TM_SoulEater[1]), Integer.parseInt(Config.A_TM_SoulEater[2]), Float.parseFloat(Config.A_TM_SoulEater[3]), Float.parseFloat(Config.A_TM_SoulEater[4]), Integer.parseInt(Config.A_TM_SoulEater[5]))).setCreativeTab(tabKingdomKeys).setUnlocalizedName(Strings.SoulEater);
		Spellbinder = new ItemSpellbinder(EnumHelper.addToolMaterial(Config.A_TM_Spellbinder[0], Integer.parseInt(Config.A_TM_Spellbinder[1]), Integer.parseInt(Config.A_TM_Spellbinder[2]), Float.parseFloat(Config.A_TM_Spellbinder[3]), Float.parseFloat(Config.A_TM_Spellbinder[4]), Integer.parseInt(Config.A_TM_Spellbinder[5]))).setCreativeTab(tabKingdomKeys).setUnlocalizedName(Strings.Spellbinder);
		Starlight = new ItemKeyblade(EnumHelper.addToolMaterial(Config.A_TM_Starlight[0], Integer.parseInt(Config.A_TM_Starlight[1]), Integer.parseInt(Config.A_TM_Starlight[2]), Float.parseFloat(Config.A_TM_Starlight[3]), Float.parseFloat(Config.A_TM_Starlight[4]), Integer.parseInt(Config.A_TM_Starlight[5]))).setCreativeTab(tabKingdomKeys).setUnlocalizedName(Strings.Starlight);
		StarSeeker = new ItemKeyblade(EnumHelper.addToolMaterial(Config.A_TM_StarSeeker[0], Integer.parseInt(Config.A_TM_StarSeeker[1]), Integer.parseInt(Config.A_TM_StarSeeker[2]), Float.parseFloat(Config.A_TM_StarSeeker[3]), Float.parseFloat(Config.A_TM_StarSeeker[4]), Integer.parseInt(Config.A_TM_StarSeeker[5]))).setCreativeTab(tabKingdomKeys).setUnlocalizedName(Strings.StarSeeker);
		Stormfall = new ItemKeyblade(EnumHelper.addToolMaterial(Config.A_TM_Stormfall[0], Integer.parseInt(Config.A_TM_Stormfall[1]), Integer.parseInt(Config.A_TM_Stormfall[2]), Float.parseFloat(Config.A_TM_Stormfall[3]), Float.parseFloat(Config.A_TM_Stormfall[4]), Integer.parseInt(Config.A_TM_Stormfall[5]))).setCreativeTab(tabKingdomKeys).setUnlocalizedName(Strings.Stormfall);
		StrokeofMidnight = new ItemKeyblade(EnumHelper.addToolMaterial(Config.A_TM_StrokeofMidnight[0], Integer.parseInt(Config.A_TM_StrokeofMidnight[1]), Integer.parseInt(Config.A_TM_StrokeofMidnight[2]), Float.parseFloat(Config.A_TM_StrokeofMidnight[3]), Float.parseFloat(Config.A_TM_StrokeofMidnight[4]), Integer.parseInt(Config.A_TM_StrokeofMidnight[5]))).setCreativeTab(tabKingdomKeys).setUnlocalizedName(Strings.StrokeofMidnight);
		SweetDreams = new ItemKeyblade(EnumHelper.addToolMaterial(Config.A_TM_SweetDreams[0], Integer.parseInt(Config.A_TM_SweetDreams[1]), Integer.parseInt(Config.A_TM_SweetDreams[2]), Float.parseFloat(Config.A_TM_SweetDreams[3]), Float.parseFloat(Config.A_TM_SweetDreams[4]), Integer.parseInt(Config.A_TM_SweetDreams[5]))).setCreativeTab(tabKingdomKeys).setUnlocalizedName(Strings.SweetDreams);
		SweetMemories = new ItemKeyblade(EnumHelper.addToolMaterial(Config.A_TM_SweetMemories[0], Integer.parseInt(Config.A_TM_SweetMemories[1]), Integer.parseInt(Config.A_TM_SweetMemories[2]), Float.parseFloat(Config.A_TM_SweetMemories[3]), Float.parseFloat(Config.A_TM_SweetMemories[4]), Integer.parseInt(Config.A_TM_SweetMemories[5]))).setCreativeTab(tabKingdomKeys).setUnlocalizedName(Strings.SweetMemories);
		Sweetstack = new ItemKeyblade(EnumHelper.addToolMaterial(Config.A_TM_Sweetstack[0], Integer.parseInt(Config.A_TM_Sweetstack[1]), Integer.parseInt(Config.A_TM_Sweetstack[2]), Float.parseFloat(Config.A_TM_Sweetstack[3]), Float.parseFloat(Config.A_TM_Sweetstack[4]), Integer.parseInt(Config.A_TM_Sweetstack[5]))).setCreativeTab(tabKingdomKeys).setUnlocalizedName(Strings.Sweetstack);
		ThreeWishes = new ItemThreeWishes(EnumHelper.addToolMaterial(Config.A_TM_ThreeWishes[0], Integer.parseInt(Config.A_TM_ThreeWishes[1]), Integer.parseInt(Config.A_TM_ThreeWishes[2]), Float.parseFloat(Config.A_TM_ThreeWishes[3]), Float.parseFloat(Config.A_TM_ThreeWishes[4]), Integer.parseInt(Config.A_TM_ThreeWishes[5]))).setCreativeTab(tabKingdomKeys).setUnlocalizedName(Strings.ThreeWishes);
		TotalEclipse = new ItemKeyblade(EnumHelper.addToolMaterial(Config.A_TM_TotalEclipse[0], Integer.parseInt(Config.A_TM_TotalEclipse[1]), Integer.parseInt(Config.A_TM_TotalEclipse[2]), Float.parseFloat(Config.A_TM_TotalEclipse[3]), Float.parseFloat(Config.A_TM_TotalEclipse[4]), Integer.parseInt(Config.A_TM_TotalEclipse[5]))).setCreativeTab(tabKingdomKeys).setUnlocalizedName(Strings.TotalEclipse);
		TreasureTrove = new ItemKeyblade(EnumHelper.addToolMaterial(Config.A_TM_TreasureTrove[0], Integer.parseInt(Config.A_TM_TreasureTrove[1]), Integer.parseInt(Config.A_TM_TreasureTrove[2]), Float.parseFloat(Config.A_TM_TreasureTrove[3]), Float.parseFloat(Config.A_TM_TreasureTrove[4]), Integer.parseInt(Config.A_TM_TreasureTrove[5]))).setCreativeTab(tabKingdomKeys).setUnlocalizedName(Strings.TreasureTrove);
		TrueLightsFlight = new ItemKeyblade(EnumHelper.addToolMaterial(Config.A_TM_TrueLightsFlight[0], Integer.parseInt(Config.A_TM_TrueLightsFlight[1]), Integer.parseInt(Config.A_TM_TrueLightsFlight[2]), Float.parseFloat(Config.A_TM_TrueLightsFlight[3]), Float.parseFloat(Config.A_TM_TrueLightsFlight[4]), Integer.parseInt(Config.A_TM_TrueLightsFlight[5]))).setCreativeTab(tabKingdomKeys).setUnlocalizedName(Strings.TrueLightsFlight);
		TwilightBlaze = new ItemKeyblade(EnumHelper.addToolMaterial(Config.A_TM_TwilightBlaze[0], Integer.parseInt(Config.A_TM_TwilightBlaze[1]), Integer.parseInt(Config.A_TM_TwilightBlaze[2]), Float.parseFloat(Config.A_TM_TwilightBlaze[3]), Float.parseFloat(Config.A_TM_TwilightBlaze[4]), Integer.parseInt(Config.A_TM_TwilightBlaze[5]))).setCreativeTab(tabKingdomKeys).setUnlocalizedName(Strings.TwilightBlaze);
		TwoBecomeOne = new ItemKeyblade(EnumHelper.addToolMaterial(Config.A_TM_TwoBecomeOne[0], Integer.parseInt(Config.A_TM_TwoBecomeOne[1]), Integer.parseInt(Config.A_TM_TwoBecomeOne[2]), Float.parseFloat(Config.A_TM_TwoBecomeOne[3]), Float.parseFloat(Config.A_TM_TwoBecomeOne[4]), Integer.parseInt(Config.A_TM_TwoBecomeOne[5]))).setCreativeTab(tabKingdomKeys).setUnlocalizedName(Strings.TwoBecomeOne);
		UltimaWeaponKH1 = new ItemUltimaWeaponKH1(EnumHelper.addToolMaterial(Config.A_TM_UltimaWeaponKH1[0], Integer.parseInt(Config.A_TM_UltimaWeaponKH1[1]), Integer.parseInt(Config.A_TM_UltimaWeaponKH1[2]), Float.parseFloat(Config.A_TM_UltimaWeaponKH1[3]), Float.parseFloat(Config.A_TM_UltimaWeaponKH1[4]), Integer.parseInt(Config.A_TM_UltimaWeaponKH1[5]))).setCreativeTab(tabKingdomKeys).setUnlocalizedName(Strings.UltimaWeaponKH1);
		UltimaWeaponKH2 = new ItemKeyblade(EnumHelper.addToolMaterial(Config.A_TM_UltimaWeaponKH2[0], Integer.parseInt(Config.A_TM_UltimaWeaponKH2[1]), Integer.parseInt(Config.A_TM_UltimaWeaponKH2[2]), Float.parseFloat(Config.A_TM_UltimaWeaponKH2[3]), Float.parseFloat(Config.A_TM_UltimaWeaponKH2[4]), Integer.parseInt(Config.A_TM_UltimaWeaponKH2[5]))).setCreativeTab(tabKingdomKeys).setUnlocalizedName(Strings.UltimaWeaponKH2);
		UltimaWeaponBBS = new ItemKeyblade(EnumHelper.addToolMaterial(Config.A_TM_UltimaWeaponBBS[0], Integer.parseInt(Config.A_TM_UltimaWeaponBBS[1]), Integer.parseInt(Config.A_TM_UltimaWeaponBBS[2]), Float.parseFloat(Config.A_TM_UltimaWeaponBBS[3]), Float.parseFloat(Config.A_TM_UltimaWeaponBBS[4]), Integer.parseInt(Config.A_TM_UltimaWeaponBBS[5]))).setCreativeTab(tabKingdomKeys).setUnlocalizedName(Strings.UltimaWeaponBBS);
		UltimaWeaponDDD = new ItemKeyblade(EnumHelper.addToolMaterial(Config.A_TM_UltimaWeaponDDD[0], Integer.parseInt(Config.A_TM_UltimaWeaponDDD[1]), Integer.parseInt(Config.A_TM_UltimaWeaponDDD[2]), Float.parseFloat(Config.A_TM_UltimaWeaponDDD[3]), Float.parseFloat(Config.A_TM_UltimaWeaponDDD[4]), Integer.parseInt(Config.A_TM_UltimaWeaponDDD[5]))).setCreativeTab(tabKingdomKeys).setUnlocalizedName(Strings.UltimaWeaponDDD);
		Umbrella = new ItemKeyblade(EnumHelper.addToolMaterial(Config.A_TM_Umbrella[0], Integer.parseInt(Config.A_TM_Umbrella[1]), Integer.parseInt(Config.A_TM_Umbrella[2]), Float.parseFloat(Config.A_TM_Umbrella[3]), Float.parseFloat(Config.A_TM_Umbrella[4]), Integer.parseInt(Config.A_TM_Umbrella[5]))).setCreativeTab(tabKingdomKeys).setUnlocalizedName(Strings.Umbrella);
		Unbound = new ItemKeyblade(EnumHelper.addToolMaterial(Config.A_TM_Unbound[0], Integer.parseInt(Config.A_TM_Unbound[1]), Integer.parseInt(Config.A_TM_Unbound[2]), Float.parseFloat(Config.A_TM_Unbound[3]), Float.parseFloat(Config.A_TM_Unbound[4]), Integer.parseInt(Config.A_TM_Unbound[5]))).setCreativeTab(tabKingdomKeys).setUnlocalizedName(Strings.Unbound);
		UnicornisForetellersKeyblade = new ItemKeyblade(EnumHelper.addToolMaterial(Config.A_TM_UnicornisForetellersKeyblade[0], Integer.parseInt(Config.A_TM_UnicornisForetellersKeyblade[1]), Integer.parseInt(Config.A_TM_UnicornisForetellersKeyblade[2]), Float.parseFloat(Config.A_TM_UnicornisForetellersKeyblade[3]), Float.parseFloat(Config.A_TM_UnicornisForetellersKeyblade[4]), Integer.parseInt(Config.A_TM_UnicornisForetellersKeyblade[5]))).setCreativeTab(tabKingdomKeys).setUnlocalizedName(Strings.UnicornisForetellersKeyblade);
		UrsusForetellersKeyblade = new ItemKeyblade(EnumHelper.addToolMaterial(Config.A_TM_UrsusForetellersKeyblade[0], Integer.parseInt(Config.A_TM_UrsusForetellersKeyblade[1]), Integer.parseInt(Config.A_TM_UrsusForetellersKeyblade[2]), Float.parseFloat(Config.A_TM_UrsusForetellersKeyblade[3]), Float.parseFloat(Config.A_TM_UrsusForetellersKeyblade[4]), Integer.parseInt(Config.A_TM_UrsusForetellersKeyblade[5]))).setCreativeTab(tabKingdomKeys).setUnlocalizedName(Strings.UrsusForetellersKeyblade);
		VictoryLine = new ItemKeyblade(EnumHelper.addToolMaterial(Config.A_TM_VictoryLine[0], Integer.parseInt(Config.A_TM_VictoryLine[1]), Integer.parseInt(Config.A_TM_VictoryLine[2]), Float.parseFloat(Config.A_TM_VictoryLine[3]), Float.parseFloat(Config.A_TM_VictoryLine[4]), Integer.parseInt(Config.A_TM_VictoryLine[5]))).setCreativeTab(tabKingdomKeys).setUnlocalizedName(Strings.VictoryLine);
		VoidGear = new ItemKeyblade(EnumHelper.addToolMaterial(Config.A_TM_VoidGear[0], Integer.parseInt(Config.A_TM_VoidGear[1]), Integer.parseInt(Config.A_TM_VoidGear[2]), Float.parseFloat(Config.A_TM_VoidGear[3]), Float.parseFloat(Config.A_TM_VoidGear[4]), Integer.parseInt(Config.A_TM_VoidGear[5]))).setCreativeTab(tabKingdomKeys).setUnlocalizedName(Strings.VoidGear);
		VulpeusForetellersKeyblade = new ItemKeyblade(EnumHelper.addToolMaterial(Config.A_TM_VulpeusForetellersKeyblade[0], Integer.parseInt(Config.A_TM_VulpeusForetellersKeyblade[1]), Integer.parseInt(Config.A_TM_VulpeusForetellersKeyblade[2]), Float.parseFloat(Config.A_TM_VulpeusForetellersKeyblade[3]), Float.parseFloat(Config.A_TM_VulpeusForetellersKeyblade[4]), Integer.parseInt(Config.A_TM_VulpeusForetellersKeyblade[5]))).setCreativeTab(tabKingdomKeys).setUnlocalizedName(Strings.VulpeusForetellersKeyblade);
		WaytotheDawn = new ItemKeyblade(EnumHelper.addToolMaterial(Config.A_TM_WaytotheDawn[0], Integer.parseInt(Config.A_TM_WaytotheDawn[1]), Integer.parseInt(Config.A_TM_WaytotheDawn[2]), Float.parseFloat(Config.A_TM_WaytotheDawn[3]), Float.parseFloat(Config.A_TM_WaytotheDawn[4]), Integer.parseInt(Config.A_TM_WaytotheDawn[5]))).setCreativeTab(tabKingdomKeys).setUnlocalizedName(Strings.WaytotheDawn);
		WaywardWind = new ItemKeyblade(EnumHelper.addToolMaterial(Config.A_TM_WaywardWind[0], Integer.parseInt(Config.A_TM_WaywardWind[1]), Integer.parseInt(Config.A_TM_WaywardWind[2]), Float.parseFloat(Config.A_TM_WaywardWind[3]), Float.parseFloat(Config.A_TM_WaywardWind[4]), Integer.parseInt(Config.A_TM_WaywardWind[5]))).setCreativeTab(tabKingdomKeys).setUnlocalizedName(Strings.WaywardWind);
		WinnersProof = new ItemKeyblade(EnumHelper.addToolMaterial(Config.A_TM_WinnersProof[0], Integer.parseInt(Config.A_TM_WinnersProof[1]), Integer.parseInt(Config.A_TM_WinnersProof[2]), Float.parseFloat(Config.A_TM_WinnersProof[3]), Float.parseFloat(Config.A_TM_WinnersProof[4]), Integer.parseInt(Config.A_TM_WinnersProof[5]))).setCreativeTab(tabKingdomKeys).setUnlocalizedName(Strings.WinnersProof);
		WishingLamp = new ItemKeyblade(EnumHelper.addToolMaterial(Config.A_TM_WishingLamp[0], Integer.parseInt(Config.A_TM_WishingLamp[1]), Integer.parseInt(Config.A_TM_WishingLamp[2]), Float.parseFloat(Config.A_TM_WishingLamp[3]), Float.parseFloat(Config.A_TM_WishingLamp[4]), Integer.parseInt(Config.A_TM_WishingLamp[5]))).setCreativeTab(tabKingdomKeys).setUnlocalizedName(Strings.WishingLamp);
		WishingStar = new ItemWishingStar(EnumHelper.addToolMaterial(Config.A_TM_WishingStar[0], Integer.parseInt(Config.A_TM_WishingStar[1]), Integer.parseInt(Config.A_TM_WishingStar[2]), Float.parseFloat(Config.A_TM_WishingStar[3]), Float.parseFloat(Config.A_TM_WishingStar[4]), Integer.parseInt(Config.A_TM_WishingStar[5]))).setCreativeTab(tabKingdomKeys).setUnlocalizedName(Strings.WishingStar);
		WoodenKeyblade = new ItemKeyblade(EnumHelper.addToolMaterial(Config.A_TM_WoodenKeyblade[0], Integer.parseInt(Config.A_TM_WoodenKeyblade[1]), Integer.parseInt(Config.A_TM_WoodenKeyblade[2]), Float.parseFloat(Config.A_TM_WoodenKeyblade[3]), Float.parseFloat(Config.A_TM_WoodenKeyblade[4]), Integer.parseInt(Config.A_TM_WoodenKeyblade[5]))).setCreativeTab(tabKingdomKeys).setUnlocalizedName(Strings.WoodenKeyblade);
		WoodenStick = new ItemKeyblade(EnumHelper.addToolMaterial(Config.A_TM_WoodenStick[0], Integer.parseInt(Config.A_TM_WoodenStick[1]), Integer.parseInt(Config.A_TM_WoodenStick[2]), Float.parseFloat(Config.A_TM_WoodenStick[3]), Float.parseFloat(Config.A_TM_WoodenStick[4]), Integer.parseInt(Config.A_TM_WoodenStick[5]))).setCreativeTab(tabKingdomKeys).setUnlocalizedName(Strings.WoodenStick);
		YoungXehanortsKeyblade = new ItemKeyblade(EnumHelper.addToolMaterial(Config.A_TM_YoungXehanortsKeyblade[0], Integer.parseInt(Config.A_TM_YoungXehanortsKeyblade[1]), Integer.parseInt(Config.A_TM_YoungXehanortsKeyblade[2]), Float.parseFloat(Config.A_TM_YoungXehanortsKeyblade[3]), Float.parseFloat(Config.A_TM_YoungXehanortsKeyblade[4]), Integer.parseInt(Config.A_TM_YoungXehanortsKeyblade[5]))).setCreativeTab(tabKingdomKeys).setUnlocalizedName(Strings.YoungXehanortsKeyblade);
		ZeroOne = new ItemKeyblade(EnumHelper.addToolMaterial(Config.A_TM_ZeroOne[0], Integer.parseInt(Config.A_TM_ZeroOne[1]), Integer.parseInt(Config.A_TM_ZeroOne[2]), Float.parseFloat(Config.A_TM_ZeroOne[3]), Float.parseFloat(Config.A_TM_ZeroOne[4]), Integer.parseInt(Config.A_TM_ZeroOne[5]))).setCreativeTab(tabKingdomKeys).setUnlocalizedName(Strings.ZeroOne);

		//CHAINS
		Chain_AbaddonPlasma = new ItemKeychain((ItemKeyblade) AbaddonPlasma).setUnlocalizedName(Strings.Chain_AbaddonPlasma).setCreativeTab(tabKingdomKeys);
		Chain_AbyssalTide = new ItemKeychain((ItemKeyblade) AbyssalTide).setUnlocalizedName(Strings.Chain_AbyssalTide).setCreativeTab(tabKingdomKeys);
		Chain_AllforOne = new ItemKeychain((ItemKeyblade) AllforOne).setUnlocalizedName(Strings.Chain_AllforOne).setCreativeTab(tabKingdomKeys);
		Chain_AnguisForetellersKeyblade = new ItemKeychain((ItemKeyblade) AnguisForetellersKeyblade).setUnlocalizedName(Strings.Chain_AnguisForetellersKeyblade).setCreativeTab(tabKingdomKeys);
		Chain_AstralBlast = new ItemKeychain((ItemKeyblade) AstralBlast).setUnlocalizedName(Strings.Chain_AstralBlast).setCreativeTab(tabKingdomKeys);
		Chain_Aubade = new ItemKeychain((ItemKeyblade) Aubade).setUnlocalizedName(Strings.Chain_Aubade).setCreativeTab(tabKingdomKeys);
		Chain_BondofFlame = new ItemKeychain((ItemKeyblade) BondofFlame).setUnlocalizedName(Strings.Chain_BondofFlame).setCreativeTab(tabKingdomKeys);
		Chain_Brightcrest = new ItemKeychain((ItemKeyblade) Brightcrest).setUnlocalizedName(Strings.Chain_Brightcrest).setCreativeTab(tabKingdomKeys);
		Chain_ChaosRipper = new ItemKeychain((ItemKeyblade) ChaosRipper).setUnlocalizedName(Strings.Chain_ChaosRipper).setCreativeTab(tabKingdomKeys);
		Chain_CircleofLife = new ItemKeychain((ItemKeyblade) CircleofLife).setUnlocalizedName(Strings.Chain_CircleofLife).setCreativeTab(tabKingdomKeys);
		Chain_Counterpoint = new ItemKeychain((ItemKeyblade) Counterpoint).setUnlocalizedName(Strings.Chain_Counterpoint).setCreativeTab(tabKingdomKeys);
		Chain_Crabclaw = new ItemKeychain((ItemKeyblade) Crabclaw).setUnlocalizedName(Strings.Chain_Crabclaw).setCreativeTab(tabKingdomKeys);
		Chain_CrownofGuilt = new ItemKeychain((ItemKeyblade) CrownofGuilt).setUnlocalizedName(Strings.Chain_CrownofGuilt).setCreativeTab(tabKingdomKeys);
		Chain_DarkerThanDark = new ItemKeychain((ItemKeyblade) DarkerThanDark).setUnlocalizedName(Strings.Chain_DarkerThanDark).setCreativeTab(tabKingdomKeys);
		Chain_Darkgnaw = new ItemKeychain((ItemKeyblade) Darkgnaw).setUnlocalizedName(Strings.Chain_Darkgnaw).setCreativeTab(tabKingdomKeys);
		Chain_DecisivePumpkin = new ItemKeychain((ItemKeyblade) DecisivePumpkin).setUnlocalizedName(Strings.Chain_DecisivePumpkin).setCreativeTab(tabKingdomKeys);
		Chain_DestinysEmbrace = new ItemKeychain((ItemKeyblade) DestinysEmbrace).setUnlocalizedName(Strings.Chain_DestinysEmbrace).setCreativeTab(tabKingdomKeys);
		Chain_DiamondDust = new ItemKeychain((ItemKeyblade) DiamondDust).setUnlocalizedName(Strings.Chain_DiamondDust).setCreativeTab(tabKingdomKeys);
		Chain_Divewing = new ItemKeychain((ItemKeyblade) Divewing).setUnlocalizedName(Strings.Chain_Divewing).setCreativeTab(tabKingdomKeys);
		Chain_DivineRose = new ItemKeychain((ItemKeyblade) DivineRose).setUnlocalizedName(Strings.Chain_DivineRose).setCreativeTab(tabKingdomKeys);
		Chain_DreamSword = new ItemKeychain((ItemKeyblade) DreamSword).setUnlocalizedName(Strings.Chain_DreamSword).setCreativeTab(tabKingdomKeys);
		Chain_DualDisc = new ItemKeychain((ItemKeyblade) DualDisc).setUnlocalizedName(Strings.Chain_DualDisc).setCreativeTab(tabKingdomKeys);
		Chain_Earthshaker = new ItemKeychain((ItemKeyblade) Earthshaker).setUnlocalizedName(Strings.Chain_Earthshaker).setCreativeTab(tabKingdomKeys);
		Chain_EndofPain = new ItemKeychain((ItemKeyblade) EndofPain).setUnlocalizedName(Strings.Chain_EndofPain).setCreativeTab(tabKingdomKeys);
		Chain_EndsoftheEarth = new ItemKeychain((ItemKeyblade) EndsoftheEarth).setUnlocalizedName(Strings.Chain_EndsoftheEarth).setCreativeTab(tabKingdomKeys);
		Chain_FairyHarp = new ItemKeychain((ItemKeyblade) FairyHarp).setUnlocalizedName(Strings.Chain_FairyHarp).setCreativeTab(tabKingdomKeys);
		Chain_FairyStars = new ItemKeychain((ItemKeyblade) FairyStars).setUnlocalizedName(Strings.Chain_FairyStars).setCreativeTab(tabKingdomKeys);
		Chain_FatalCrest = new ItemKeychain((ItemKeyblade) FatalCrest).setUnlocalizedName(Strings.Chain_FatalCrest).setCreativeTab(tabKingdomKeys);
		Chain_Fenrir = new ItemKeychain((ItemKeyblade) Fenrir).setUnlocalizedName(Strings.Chain_Fenrir).setCreativeTab(tabKingdomKeys);
		Chain_FerrisGear = new ItemKeychain((ItemKeyblade) FerrisGear).setUnlocalizedName(Strings.Chain_FerrisGear).setCreativeTab(tabKingdomKeys);
		Chain_FollowtheWind = new ItemKeychain((ItemKeyblade) FollowtheWind).setUnlocalizedName(Strings.Chain_FollowtheWind).setCreativeTab(tabKingdomKeys);
		Chain_FrolicFlame = new ItemKeychain((ItemKeyblade) FrolicFlame).setUnlocalizedName(Strings.Chain_FrolicFlame).setCreativeTab(tabKingdomKeys);
		Chain_GlimpseofDarkness = new ItemKeychain((ItemKeyblade) GlimpseofDarkness).setUnlocalizedName(Strings.Chain_GlimpseofDarkness).setCreativeTab(tabKingdomKeys);
		Chain_GuardianBell = new ItemKeychain((ItemKeyblade) GuardianBell).setUnlocalizedName(Strings.Chain_GuardianBell).setCreativeTab(tabKingdomKeys);
		Chain_GuardianSoul = new ItemKeychain((ItemKeyblade) GuardianSoul).setUnlocalizedName(Strings.Chain_GuardianSoul).setCreativeTab(tabKingdomKeys);
		Chain_GullWing = new ItemKeychain((ItemKeyblade) GullWing).setUnlocalizedName(Strings.Chain_GullWing).setCreativeTab(tabKingdomKeys);
		Chain_HerosCrest = new ItemKeychain((ItemKeyblade) HerosCrest).setUnlocalizedName(Strings.Chain_HerosCrest).setCreativeTab(tabKingdomKeys);
		Chain_HiddenDragon = new ItemKeychain((ItemKeyblade) HiddenDragon).setUnlocalizedName(Strings.Chain_HiddenDragon).setCreativeTab(tabKingdomKeys);
		Chain_Hyperdrive = new ItemKeychain((ItemKeyblade) Hyperdrive).setUnlocalizedName(Strings.Chain_Hyperdrive).setCreativeTab(tabKingdomKeys);
		Chain_IncompleteKiblade = new ItemKeychain((ItemKeyblade) IncompleteKiblade).setUnlocalizedName(Strings.Chain_IncompleteKiblade).setCreativeTab(tabKingdomKeys);
		Chain_JungleKing = new ItemKeychain((ItemKeyblade) JungleKing).setUnlocalizedName(Strings.Chain_JungleKing).setCreativeTab(tabKingdomKeys);
		Chain_KeybladeofPeoplesHearts = new ItemKeychain((ItemKeyblade) KeybladeofPeoplesHearts).setUnlocalizedName(Strings.Chain_KeybladeofPeoplesHearts).setCreativeTab(tabKingdomKeys);
		Chain_Kiblade = new ItemKeychain((ItemKeyblade) Kiblade).setUnlocalizedName(Strings.Chain_Kiblade).setCreativeTab(tabKingdomKeys);
		Chain_KingdomKey = new ItemKeychain((ItemKeyblade) KingdomKey).setUnlocalizedName(Strings.Chain_KingdomKey).setCreativeTab(tabKingdomKeys);
		Chain_KingdomKeyD = new ItemKeychain((ItemKeyblade) KingdomKeyD).setUnlocalizedName(Strings.Chain_KingdomKeyD).setCreativeTab(tabKingdomKeys);
		Chain_KnockoutPunch = new ItemKeychain((ItemKeyblade) KnockoutPunch).setUnlocalizedName(Strings.Chain_KnockoutPunch).setCreativeTab(tabKingdomKeys);
		Chain_LadyLuck = new ItemKeychain((ItemKeyblade) LadyLuck).setUnlocalizedName(Strings.Chain_LadyLuck).setCreativeTab(tabKingdomKeys);
		Chain_LeasKeyblade = new ItemKeychain((ItemKeyblade) LeasKeyblade).setUnlocalizedName(Strings.Chain_LeasKeyblade).setCreativeTab(tabKingdomKeys);
		Chain_LeopardosForetellersKeyblade = new ItemKeychain((ItemKeyblade) LeopardosForetellersKeyblade).setUnlocalizedName(Strings.Chain_LeopardosForetellersKeyblade).setCreativeTab(tabKingdomKeys);
		Chain_Leviathan = new ItemKeychain((ItemKeyblade) Leviathan).setUnlocalizedName(Strings.Chain_Leviathan).setCreativeTab(tabKingdomKeys);
		Chain_Lionheart = new ItemKeychain((ItemKeyblade) Lionheart).setUnlocalizedName(Strings.Chain_Lionheart).setCreativeTab(tabKingdomKeys);
		Chain_LostMemory = new ItemKeychain((ItemKeyblade) LostMemory).setUnlocalizedName(Strings.Chain_LostMemory).setCreativeTab(tabKingdomKeys);
		Chain_LunarEclipse = new ItemKeychain((ItemKeyblade) LunarEclipse).setUnlocalizedName(Strings.Chain_LunarEclipse).setCreativeTab(tabKingdomKeys);
		Chain_MarkofaHero = new ItemKeychain((ItemKeyblade) MarkofaHero).setUnlocalizedName(Strings.Chain_MarkofaHero).setCreativeTab(tabKingdomKeys);
		Chain_MasterXehanortsKeyblade = new ItemKeychain((ItemKeyblade) MasterXehanortsKeyblade).setUnlocalizedName(Strings.Chain_MasterXehanortsKeyblade).setCreativeTab(tabKingdomKeys);
		Chain_MastersDefender = new ItemKeychain((ItemKeyblade) MastersDefender).setUnlocalizedName(Strings.Chain_MastersDefender).setCreativeTab(tabKingdomKeys);
		Chain_MaverickFlare = new ItemKeychain((ItemKeyblade) MaverickFlare).setUnlocalizedName(Strings.Chain_MaverickFlare).setCreativeTab(tabKingdomKeys);
		Chain_MetalChocobo = new ItemKeychain((ItemKeyblade) MetalChocobo).setUnlocalizedName(Strings.Chain_MetalChocobo).setCreativeTab(tabKingdomKeys);
		Chain_MidnightRoar = new ItemKeychain((ItemKeyblade) MidnightRoar).setUnlocalizedName(Strings.Chain_MidnightRoar).setCreativeTab(tabKingdomKeys);
		Chain_MissingAche = new ItemKeychain((ItemKeyblade) MissingAche).setUnlocalizedName(Strings.Chain_MissingAche).setCreativeTab(tabKingdomKeys);
		Chain_Monochrome = new ItemKeychain((ItemKeyblade) Monochrome).setUnlocalizedName(Strings.Chain_Monochrome).setCreativeTab(tabKingdomKeys);
		Chain_MysteriousAbyss = new ItemKeychain((ItemKeyblade) MysteriousAbyss).setUnlocalizedName(Strings.Chain_MysteriousAbyss).setCreativeTab(tabKingdomKeys);
		Chain_NoName = new ItemKeychain((ItemKeyblade) NoName).setUnlocalizedName(Strings.Chain_NoName).setCreativeTab(tabKingdomKeys);
		Chain_Oathkeeper = new ItemKeychain((ItemKeyblade) Oathkeeper).setUnlocalizedName(Strings.Chain_Oathkeeper).setCreativeTab(tabKingdomKeys);
		Chain_Oblivion = new ItemKeychain((ItemKeyblade) Oblivion).setUnlocalizedName(Strings.Chain_Oblivion).setCreativeTab(tabKingdomKeys);
		Chain_OceanRage = new ItemKeychain((ItemKeyblade) OceanRage).setUnlocalizedName(Strings.Chain_OceanRage).setCreativeTab(tabKingdomKeys);
		Chain_Olympia = new ItemKeychain((ItemKeyblade) Olympia).setUnlocalizedName(Strings.Chain_Olympia).setCreativeTab(tabKingdomKeys);
		Chain_OmegaWeapon = new ItemKeychain((ItemKeyblade) OmegaWeapon).setUnlocalizedName(Strings.Chain_OmegaWeapon).setCreativeTab(tabKingdomKeys);
		Chain_OminousBlight = new ItemKeychain((ItemKeyblade) OminousBlight).setUnlocalizedName(Strings.Chain_OminousBlight).setCreativeTab(tabKingdomKeys);
		Chain_OneWingedAngel = new ItemKeychain((ItemKeyblade) OneWingedAngel).setUnlocalizedName(Strings.Chain_OneWingedAngel).setCreativeTab(tabKingdomKeys);
		Chain_PainofSolitude = new ItemKeychain((ItemKeyblade) PainofSolitude).setUnlocalizedName(Strings.Chain_PainofSolitude).setCreativeTab(tabKingdomKeys);
		Chain_PhotonDebugger = new ItemKeychain((ItemKeyblade) PhotonDebugger).setUnlocalizedName(Strings.Chain_PhotonDebugger).setCreativeTab(tabKingdomKeys);
		Chain_PixiePetal = new ItemKeychain((ItemKeyblade) PixiePetal).setUnlocalizedName(Strings.Chain_PixiePetal).setCreativeTab(tabKingdomKeys);
		Chain_Pumpkinhead = new ItemKeychain((ItemKeyblade) Pumpkinhead).setUnlocalizedName(Strings.Chain_Pumpkinhead).setCreativeTab(tabKingdomKeys);
		Chain_Rainfell = new ItemKeychain((ItemKeyblade) Rainfell).setUnlocalizedName(Strings.Chain_Rainfell).setCreativeTab(tabKingdomKeys);
		Chain_RejectionofFate = new ItemKeychain((ItemKeyblade) RejectionofFate).setUnlocalizedName(Strings.Chain_RejectionofFate).setCreativeTab(tabKingdomKeys);
		Chain_RoyalRadiance = new ItemKeychain((ItemKeyblade) RoyalRadiance).setUnlocalizedName(Strings.Chain_RoyalRadiance).setCreativeTab(tabKingdomKeys);
		Chain_RumblingRose = new ItemKeychain((ItemKeyblade) RumblingRose).setUnlocalizedName(Strings.Chain_RumblingRose).setCreativeTab(tabKingdomKeys);
		Chain_SignofInnocence = new ItemKeychain((ItemKeyblade) SignofInnocence).setUnlocalizedName(Strings.Chain_SignofInnocence).setCreativeTab(tabKingdomKeys);
		Chain_SilentDirge = new ItemKeychain((ItemKeyblade) SilentDirge).setUnlocalizedName(Strings.Chain_SilentDirge).setCreativeTab(tabKingdomKeys);
		Chain_SkullNoise = new ItemKeychain((ItemKeyblade) SkullNoise).setUnlocalizedName(Strings.Chain_SkullNoise).setCreativeTab(tabKingdomKeys);
		Chain_SleepingLion = new ItemKeychain((ItemKeyblade) SleepingLion).setUnlocalizedName(Strings.Chain_SleepingLion).setCreativeTab(tabKingdomKeys);
		Chain_SoulEater = new ItemKeychain((ItemKeyblade) SoulEater).setUnlocalizedName(Strings.Chain_SoulEater).setCreativeTab(tabKingdomKeys);
		Chain_Spellbinder = new ItemKeychain((ItemKeyblade) Spellbinder).setUnlocalizedName(Strings.Chain_Spellbinder).setCreativeTab(tabKingdomKeys);
		Chain_StarSeeker = new ItemKeychain((ItemKeyblade) StarSeeker).setUnlocalizedName(Strings.Chain_StarSeeker).setCreativeTab(tabKingdomKeys);
		Chain_Starlight = new ItemKeychain((ItemKeyblade) Starlight).setUnlocalizedName(Strings.Chain_Starlight).setCreativeTab(tabKingdomKeys);
		Chain_Stormfall = new ItemKeychain((ItemKeyblade) Stormfall).setUnlocalizedName(Strings.Chain_Stormfall).setCreativeTab(tabKingdomKeys);
		Chain_StrokeofMidnight = new ItemKeychain((ItemKeyblade) StrokeofMidnight).setUnlocalizedName(Strings.Chain_StrokeofMidnight).setCreativeTab(tabKingdomKeys);
		Chain_SweetDreams = new ItemKeychain((ItemKeyblade) SweetDreams).setUnlocalizedName(Strings.Chain_SweetDreams).setCreativeTab(tabKingdomKeys);
		Chain_SweetMemories = new ItemKeychain((ItemKeyblade) SweetMemories).setUnlocalizedName(Strings.Chain_SweetMemories).setCreativeTab(tabKingdomKeys);
		Chain_Sweetstack = new ItemKeychain((ItemKeyblade) Sweetstack).setUnlocalizedName(Strings.Chain_Sweetstack).setCreativeTab(tabKingdomKeys);
		Chain_ThreeWishes = new ItemKeychain((ItemKeyblade) ThreeWishes).setUnlocalizedName(Strings.Chain_ThreeWishes).setCreativeTab(tabKingdomKeys);
		Chain_TotalEclipse = new ItemKeychain((ItemKeyblade) TotalEclipse).setUnlocalizedName(Strings.Chain_TotalEclipse).setCreativeTab(tabKingdomKeys);
		Chain_TreasureTrove = new ItemKeychain((ItemKeyblade) TreasureTrove).setUnlocalizedName(Strings.Chain_TreasureTrove).setCreativeTab(tabKingdomKeys);
		Chain_TrueLightsFlight = new ItemKeychain((ItemKeyblade) TrueLightsFlight).setUnlocalizedName(Strings.Chain_TrueLightsFlight).setCreativeTab(tabKingdomKeys);
		Chain_TwilightBlaze = new ItemKeychain((ItemKeyblade) TwilightBlaze).setUnlocalizedName(Strings.Chain_TwilightBlaze).setCreativeTab(tabKingdomKeys);
		Chain_TwoBecomeOne = new ItemKeychain((ItemKeyblade) TwoBecomeOne).setUnlocalizedName(Strings.Chain_TwoBecomeOne).setCreativeTab(tabKingdomKeys);
		Chain_UltimaWeaponKH1 = new ItemKeychain((ItemKeyblade) UltimaWeaponKH1).setUnlocalizedName(Strings.Chain_UltimaWeaponKH1).setCreativeTab(tabKingdomKeys);
		Chain_UltimaWeaponKH2 = new ItemKeychain((ItemKeyblade) UltimaWeaponKH2).setUnlocalizedName(Strings.Chain_UltimaWeaponKH2).setCreativeTab(tabKingdomKeys);
		Chain_UltimaWeaponBBS = new ItemKeychain((ItemKeyblade) UltimaWeaponBBS).setUnlocalizedName(Strings.Chain_UltimaWeaponBBS).setCreativeTab(tabKingdomKeys);
		Chain_UltimaWeaponDDD = new ItemKeychain((ItemKeyblade) UltimaWeaponDDD).setUnlocalizedName(Strings.Chain_UltimaWeaponDDD).setCreativeTab(tabKingdomKeys);
		Chain_Umbrella = new ItemKeychain((ItemKeyblade) Umbrella).setUnlocalizedName(Strings.Chain_Umbrella).setCreativeTab(tabKingdomKeys);
		Chain_Unbound = new ItemKeychain((ItemKeyblade) Unbound).setUnlocalizedName(Strings.Chain_Unbound).setCreativeTab(tabKingdomKeys);
		Chain_UnicornisForetellersKeyblade = new ItemKeychain((ItemKeyblade) UnicornisForetellersKeyblade).setUnlocalizedName(Strings.Chain_UnicornisForetellersKeyblade).setCreativeTab(tabKingdomKeys);
		Chain_UrsusForetellersKeyblade = new ItemKeychain((ItemKeyblade) UrsusForetellersKeyblade).setUnlocalizedName(Strings.Chain_UrsusForetellersKeyblade).setCreativeTab(tabKingdomKeys);
		Chain_VictoryLine = new ItemKeychain((ItemKeyblade) VictoryLine).setUnlocalizedName(Strings.Chain_VictoryLine).setCreativeTab(tabKingdomKeys);
		Chain_VoidGear = new ItemKeychain((ItemKeyblade) VoidGear).setUnlocalizedName(Strings.Chain_VoidGear).setCreativeTab(tabKingdomKeys);
		Chain_VulpeusForetellersKeyblade = new ItemKeychain((ItemKeyblade) VulpeusForetellersKeyblade).setUnlocalizedName(Strings.Chain_VulpeusForetellersKeyblade).setCreativeTab(tabKingdomKeys);
		Chain_WaytotheDawn = new ItemKeychain((ItemKeyblade) WaytotheDawn).setUnlocalizedName(Strings.Chain_WaytotheDawn).setCreativeTab(tabKingdomKeys);
		Chain_WaywardWind = new ItemKeychain((ItemKeyblade) WaywardWind).setUnlocalizedName(Strings.Chain_WaywardWind).setCreativeTab(tabKingdomKeys);
		Chain_WinnersProof = new ItemKeychain((ItemKeyblade) WinnersProof).setUnlocalizedName(Strings.Chain_WinnersProof).setCreativeTab(tabKingdomKeys);
		Chain_WishingLamp = new ItemKeychain((ItemKeyblade) WishingLamp).setUnlocalizedName(Strings.Chain_WishingLamp).setCreativeTab(tabKingdomKeys);
		Chain_WishingStar = new ItemKeychain((ItemKeyblade) WishingStar).setUnlocalizedName(Strings.Chain_WishingStar).setCreativeTab(tabKingdomKeys);
		Chain_YoungXehanortsKeyblade = new ItemKeychain((ItemKeyblade) YoungXehanortsKeyblade).setUnlocalizedName(Strings.Chain_YoungXehanortsKeyblade).setCreativeTab(tabKingdomKeys);
		Chain_ZeroOne = new ItemKeychain((ItemKeyblade) ZeroOne).setUnlocalizedName(Strings.Chain_ZeroOne).setCreativeTab(tabKingdomKeys);

		Munny = new ItemMunny().setUnlocalizedName(Strings.Munny).setCreativeTab(tabKingdomKeys);
		EmptyBottle = new Item().setUnlocalizedName(Strings.EmptyBottle).setCreativeTab(tabKingdomKeys).setMaxStackSize(1);
		Potion = new ItemPotion(0, true, "hp").setUnlocalizedName(Strings.Potion).setCreativeTab(tabKingdomKeys).setMaxStackSize(1);
		Ether = new ItemPotion(0, true, "mp").setUnlocalizedName(Strings.Ether).setCreativeTab(tabKingdomKeys).setMaxStackSize(1);
		Elixir = new ItemPotion(0, true, "elixir").setUnlocalizedName(Strings.Elixir).setCreativeTab(tabKingdomKeys).setMaxStackSize(1);

		HpOrb = new ItemHpOrb().setUnlocalizedName(Strings.HpOrb).setCreativeTab(tabKingdomKeys).setMaxStackSize(1);
		DriveOrb = new ItemDriveOrb().setUnlocalizedName(Strings.DriveOrb).setCreativeTab(tabKingdomKeys);
		MagicOrb = new ItemMagicOrb().setUnlocalizedName(Strings.MagicOrb).setCreativeTab(tabKingdomKeys);
		Heart = new Item().setUnlocalizedName(Strings.Heart).setCreativeTab(tabKingdomKeys);
		DarkHeart = new Item().setUnlocalizedName(Strings.DarkHeart).setCreativeTab(tabKingdomKeys);
		PureHeart = new Item().setUnlocalizedName(Strings.PureHeart).setCreativeTab(tabKingdomKeys);
		KingdomHearts = new Item().setUnlocalizedName(Strings.KingdomHearts).setCreativeTab(tabKingdomKeys);
		DarkLeather = new Item().setUnlocalizedName(Strings.DarkLeather).setCreativeTab(tabKingdomKeys);
		SynthesisMaterial = new ItemSynthesisMaterial().setUnlocalizedName(Strings.SynthesisMaterial).setCreativeTab(tabKingdomKeys);
		IceCream = new ItemIceCream(5,true).setUnlocalizedName(Strings.IceCream).setCreativeTab(tabKingdomKeys);
		WinnerStick = new Item().setUnlocalizedName(Strings.WinnerStick).setCreativeTab(tabKingdomKeys);

		LevelUpMagicFire = new ItemUpgradeMagicFire().setUnlocalizedName(Strings.LevelUpMagicFire).setCreativeTab(tabKingdomKeys);
		LevelUpMagicBlizzard = new ItemUpgradeMagicBlizzard().setUnlocalizedName(Strings.LevelUpMagicBlizzard).setCreativeTab(tabKingdomKeys);
		LevelUpMagicThunder = new ItemUpgradeMagicThunder().setUnlocalizedName(Strings.LevelUpMagicThunder).setCreativeTab(tabKingdomKeys);
		LevelUpMagicCure = new ItemUpgradeMagicCure().setUnlocalizedName(Strings.LevelUpMagicCure).setCreativeTab(tabKingdomKeys);
		LevelUpMagicAero = new ItemUpgradeMagicAero().setUnlocalizedName(Strings.LevelUpMagicAero).setCreativeTab(tabKingdomKeys);
		LevelUpMagicStop = new ItemUpgradeMagicStop().setUnlocalizedName(Strings.LevelUpMagicStop).setCreativeTab(tabKingdomKeys);


		Disc_Birth_by_Sleep_A_Link_to_the_Future = new ItemKKRecord(Strings.Disc_Birth_by_Sleep_A_Link_to_the_Future_Name, Strings.Disc_Birth_by_Sleep_A_Link_to_the_Future, tabKingdomKeys, 7.29F);
		Disc_Darkness_of_the_Unknown = new ItemKKRecord(Strings.Disc_Darkness_of_the_Unknown_Name, Strings.Disc_Darkness_of_the_Unknown, tabKingdomKeys, 7.50F);
		Disc_Dearly_Beloved_Symphony_Version = new ItemKKRecord(Strings.Disc_Dearly_Beloved_Symphony_Version_Name, Strings.Disc_Dearly_Beloved_Symphony_Version, tabKingdomKeys, 2.33F);
		Disc_Dream_Drop_Distance_The_Next_Awakening = new ItemKKRecord(Strings.Disc_Dream_Drop_Distance_The_Next_Awakening_Name, Strings.Disc_Dream_Drop_Distance_The_Next_Awakening, tabKingdomKeys, 8.56F);
		Disc_Hikari_KINGDOM_Instrumental_Version = new ItemKKRecord(Strings.Disc_Hikari_KINGDOM_Instrumental_Version_Name, Strings.Disc_Hikari_KINGDOM_Instrumental_Version, tabKingdomKeys, 3.42F);
		Disc_L_Oscurita_Dell_Ignoto = new ItemKKRecord(Strings.Disc_L_Oscurita_Dell_Ignoto_Name, Strings.Disc_L_Oscurita_Dell_Ignoto, tabKingdomKeys, 4.33F);
		Disc_Musique_pour_la_tristesse_de_Xion = new ItemKKRecord(Strings.Disc_Musique_pour_la_tristesse_de_Xion_Name, Strings.Disc_Musique_pour_la_tristesse_de_Xion, tabKingdomKeys, 3.57F);
		Disc_No_More_Bugs_Bug_Version = new ItemKKRecord(Strings.Disc_No_More_Bugs_Bug_Version_Name, Strings.Disc_No_More_Bugs_Bug_Version, tabKingdomKeys, 3.17F);
		Disc_Organization_XIII = new ItemKKRecord(Strings.Disc_Organization_XIII_Name, Strings.Disc_Organization_XIII, tabKingdomKeys, 2.32F);
		Disc_Sanctuary = new ItemKKRecord(Strings.Disc_Sanctuary_Name, Strings.Disc_Sanctuary, tabKingdomKeys, 4.25F);
		Disc_Simple_And_Clean_PLANITb_Remix = new ItemKKRecord(Strings.Disc_Simple_And_Clean_PLANITb_Remix_Name, Strings.Disc_Simple_And_Clean_PLANITb_Remix, tabKingdomKeys, 2.37F);
		Disc_Sinister_Sundown = new ItemKKRecord(Strings.Disc_Sinister_Sundown_Name, Strings.Disc_Sinister_Sundown, tabKingdomKeys, 2.13F);
		Disc_The_13th_Anthology = new ItemKKRecord(Strings.Disc_The_13th_Anthology_Name, Strings.Disc_The_13th_Anthology, tabKingdomKeys, 6.38F);

		Recipe = new ItemRecipe().setUnlocalizedName(Strings.Recipe).setCreativeTab(tabKingdomKeys);
	}

	public static void register(){
		//Materials
		GameRegistry.registerItem(BlazingInfusedCoal, Strings.BlazingInfusedCoal);
		GameRegistry.registerItem(FrostInfusedSnowBall, Strings.FrostInfusedSnowBall);
		GameRegistry.registerItem(StormyInfusedIron, Strings.StormyInfusedIron);
		GameRegistry.registerItem(MythrilInfusedDiamond, Strings.MythrilInfusedDiamond);
		GameRegistry.registerItem(LightningInfusedGold, Strings.LightningInfusedGold);
		GameRegistry.registerItem(BrightInfusedGlowStone, Strings.BrightInfusedGlowStone);
		GameRegistry.registerItem(DarkInfusedIron, Strings.DarkInfusedIron);

		//Armour
		GameRegistry.registerItem(OrganizationRobe_Helmet = new ItemOrganizationRobe(ORGANIZATIONROBE, 1, 0, Strings.OrganizationRobe_Helmet), Strings.OrganizationRobe_Helmet);
		GameRegistry.registerItem(OrganizationRobe_Chestplate = new ItemOrganizationRobe(ORGANIZATIONROBE, 1, 1, Strings.OrganizationRobe_Chestplate), Strings.OrganizationRobe_Chestplate);
		GameRegistry.registerItem(OrganizationRobe_Leggings = new ItemOrganizationRobe(ORGANIZATIONROBE, 2, 2, Strings.OrganizationRobe_Leggings), Strings.OrganizationRobe_Leggings);
		GameRegistry.registerItem(OrganizationRobe_Boots = new ItemOrganizationRobe(ORGANIZATIONROBE, 1, 3, Strings.OrganizationRobe_Boots), Strings.OrganizationRobe_Boots);

		GameRegistry.registerItem(Terra_Helmet = new ItemTerraArmor(TERRA, 1, 0, Strings.Terra_Helmet), Strings.Terra_Helmet);
		GameRegistry.registerItem(Terra_Chestplate = new ItemTerraArmor(TERRA, 1, 1, Strings.Terra_Chestplate), Strings.Terra_Chestplate);
		GameRegistry.registerItem(Terra_Leggings = new ItemTerraArmor(TERRA, 2, 2, Strings.Terra_Leggings), Strings.Terra_Leggings);
		GameRegistry.registerItem(Terra_Boots = new ItemTerraArmor(TERRA, 1, 3, Strings.Terra_Boots), Strings.Terra_Boots);

		GameRegistry.registerItem(Aqua_Helmet = new ItemAquaArmor(AQUA, 1, 0, Strings.Aqua_Helmet), Strings.Aqua_Helmet);
		GameRegistry.registerItem(Aqua_Chestplate = new ItemAquaArmor(AQUA, 1, 1, Strings.Aqua_Chestplate), Strings.Aqua_Chestplate);
		GameRegistry.registerItem(Aqua_Leggings = new ItemAquaArmor(AQUA, 2, 2, Strings.Aqua_Leggings), Strings.Aqua_Leggings);
		GameRegistry.registerItem(Aqua_Boots = new ItemAquaArmor(AQUA, 1, 3, Strings.Aqua_Boots), Strings.Aqua_Boots);

		GameRegistry.registerItem(Ventus_Helmet = new ItemVentusArmor(VENTUS, 1, 0, Strings.Ventus_Helmet), Strings.Ventus_Helmet);
		GameRegistry.registerItem(Ventus_Chestplate = new ItemVentusArmor(VENTUS, 1, 1, Strings.Ventus_Chestplate), Strings.Ventus_Chestplate);
		GameRegistry.registerItem(Ventus_Leggings = new ItemVentusArmor(VENTUS, 2, 2, Strings.Ventus_Leggings), Strings.Ventus_Leggings);
		GameRegistry.registerItem(Ventus_Boots = new ItemVentusArmor(VENTUS, 1, 3, Strings.Ventus_Boots), Strings.Ventus_Boots);

		GameRegistry.registerItem(Eraqus_Helmet = new ItemEraqusArmor(ERAQUS, 1, 0, Strings.Eraqus_Helmet), Strings.Eraqus_Helmet);
		GameRegistry.registerItem(Eraqus_Chestplate = new ItemEraqusArmor(ERAQUS, 1, 1, Strings.Eraqus_Chestplate), Strings.Eraqus_Chestplate);
		GameRegistry.registerItem(Eraqus_Leggings = new ItemEraqusArmor(ERAQUS, 2, 2, Strings.Eraqus_Leggings), Strings.Eraqus_Leggings);
		GameRegistry.registerItem(Eraqus_Boots = new ItemEraqusArmor(ERAQUS, 1, 3, Strings.Eraqus_Boots), Strings.Eraqus_Boots);


		//Organization
		GameRegistry.registerItem(Interdiction, Strings.Interdiction);
		GameRegistry.registerItem(Sharpshooter, Strings.Sharpshooter);
		GameRegistry.registerItem(Lindworm, Strings.Lindworm);
		GameRegistry.registerItem(FrozenPride, Strings.FrozenPride);
		GameRegistry.registerItem(Skysplitter, Strings.Skysplitter);
		GameRegistry.registerItem(BookofRetribution, Strings.BookofRetribution);
		GameRegistry.registerItem(Lunatic, Strings.Lunatic);
		GameRegistry.registerItem(EternalFlames, Strings.EternalFlames);
		GameRegistry.registerItem(Arpeggio, Strings.Arpeggio);
		GameRegistry.registerItem(FairGame, Strings.FairGame);
		GameRegistry.registerItem(GracefulDahlia, Strings.GracefulDahlia);
		GameRegistry.registerItem(Foudre, Strings.Foudre);
		GameRegistry.registerItem(BlazeofGlory, Strings.BlazeofGlory);

		//Knowledge
		GameRegistry.registerItem(AbandonedKnowledge, Strings.AbandonedKnowledge);
		GameRegistry.registerItem(DarkKnowledge, Strings.DarkKnowledge);
		GameRegistry.registerItem(EclipsedKnowledge, Strings.EclipsedKnowledge);
		GameRegistry.registerItem(ForgottenKnowledge, Strings.ForgottenKnowledge);
		GameRegistry.registerItem(IlludedKnowledge, Strings.IlludedKnowledge);
		GameRegistry.registerItem(LostKnowledge, Strings.LostKnowledge);
		GameRegistry.registerItem(ManifestKnowledge, Strings.ManifestKnowledge);
		GameRegistry.registerItem(ObscuredKnowledge, Strings.ObscuredKnowledge);
		GameRegistry.registerItem(UnknownKnowledge, Strings.UnknownKnowledge);
		GameRegistry.registerItem(VoidKnowledge, Strings.VoidKnowledge);

		//Keyblades
		GameRegistry.registerItem(AbaddonPlasma, Strings.AbaddonPlasma);
		GameRegistry.registerItem(AbyssalTide, Strings.AbyssalTide);
		GameRegistry.registerItem(AllforOne, Strings.AllforOne);
		GameRegistry.registerItem(AnguisForetellersKeyblade, Strings.AnguisForetellersKeyblade);
		GameRegistry.registerItem(AstralBlast, Strings.AstralBlast);
		GameRegistry.registerItem(Aubade, Strings.Aubade);
		GameRegistry.registerItem(BondofFlame, Strings.BondofFlame);
		GameRegistry.registerItem(Brightcrest, Strings.Brightcrest);
		GameRegistry.registerItem(ChaosRipper, Strings.ChaosRipper);
		GameRegistry.registerItem(CircleofLife, Strings.CircleofLife);
		GameRegistry.registerItem(Counterpoint, Strings.Counterpoint);
		GameRegistry.registerItem(Crabclaw, Strings.Crabclaw);
		GameRegistry.registerItem(CrownofGuilt, Strings.CrownofGuilt);
		GameRegistry.registerItem(DarkerThanDark, Strings.DarkerThanDark);
		GameRegistry.registerItem(Darkgnaw, Strings.Darkgnaw);
		GameRegistry.registerItem(DecisivePumpkin, Strings.DecisivePumpkin);
		GameRegistry.registerItem(DestinysEmbrace, Strings.DestinysEmbrace);
		GameRegistry.registerItem(DiamondDust, Strings.DiamondDust);
		GameRegistry.registerItem(Divewing, Strings.Divewing);
		GameRegistry.registerItem(DivineRose, Strings.DivineRose);
		GameRegistry.registerItem(DreamSword, Strings.DreamSword);
		GameRegistry.registerItem(DualDisc, Strings.DualDisc);
		GameRegistry.registerItem(Earthshaker, Strings.Earthshaker);
		GameRegistry.registerItem(EndofPain, Strings.EndofPain);
		GameRegistry.registerItem(EndsoftheEarth, Strings.EndsoftheEarth);
		GameRegistry.registerItem(FairyHarp, Strings.FairyHarp);
		GameRegistry.registerItem(FairyStars, Strings.FairyStars);
		GameRegistry.registerItem(FatalCrest, Strings.FatalCrest);
		GameRegistry.registerItem(Fenrir, Strings.Fenrir);
		GameRegistry.registerItem(FerrisGear, Strings.FerrisGear);
		GameRegistry.registerItem(FollowtheWind, Strings.FollowtheWind);
		GameRegistry.registerItem(FrolicFlame, Strings.FrolicFlame);
		GameRegistry.registerItem(GlimpseofDarkness, Strings.GlimpseofDarkness);
		GameRegistry.registerItem(GuardianBell, Strings.GuardianBell);
		GameRegistry.registerItem(GuardianSoul, Strings.GuardianSoul);
		GameRegistry.registerItem(GullWing, Strings.GullWing);
		GameRegistry.registerItem(HerosCrest, Strings.HerosCrest);
		GameRegistry.registerItem(HiddenDragon, Strings.HiddenDragon);
		GameRegistry.registerItem(Hyperdrive, Strings.Hyperdrive);
		GameRegistry.registerItem(IncompleteKiblade, Strings.IncompleteKiblade);
		GameRegistry.registerItem(JungleKing, Strings.JungleKing);
		GameRegistry.registerItem(KeybladeofPeoplesHearts, Strings.KeybladeofPeoplesHearts);
		GameRegistry.registerItem(Kiblade, Strings.Kiblade);
		GameRegistry.registerItem(KingdomKey, Strings.KingdomKey);
		GameRegistry.registerItem(KingdomKeyD, Strings.KingdomKeyD);
		GameRegistry.registerItem(KnockoutPunch, Strings.KnockoutPunch);
		GameRegistry.registerItem(LadyLuck, Strings.LadyLuck);
		GameRegistry.registerItem(LeasKeyblade, Strings.LeasKeyblade);
		GameRegistry.registerItem(LeopardosForetellersKeyblade, Strings.LeopardosForetellersKeyblade);
		GameRegistry.registerItem(Leviathan, Strings.Leviathan);
		GameRegistry.registerItem(Lionheart, Strings.Lionheart);
		GameRegistry.registerItem(LostMemory, Strings.LostMemory);
		GameRegistry.registerItem(LunarEclipse, Strings.LunarEclipse);
		GameRegistry.registerItem(MarkofaHero, Strings.MarkofaHero);
		GameRegistry.registerItem(MasterXehanortsKeyblade, Strings.MasterXehanortsKeyblade);
		GameRegistry.registerItem(MastersDefender, Strings.MastersDefender);
		GameRegistry.registerItem(MaverickFlare, Strings.MaverickFlare);
		GameRegistry.registerItem(MetalChocobo, Strings.MetalChocobo);
		GameRegistry.registerItem(MidnightRoar, Strings.MidnightRoar);
		GameRegistry.registerItem(MissingAche, Strings.MissingAche);
		GameRegistry.registerItem(Monochrome, Strings.Monochrome);
		GameRegistry.registerItem(MysteriousAbyss, Strings.MysteriousAbyss);
		GameRegistry.registerItem(NoName, Strings.NoName);
		GameRegistry.registerItem(Oathkeeper, Strings.Oathkeeper);
		GameRegistry.registerItem(Oblivion, Strings.Oblivion);
		GameRegistry.registerItem(OceanRage, Strings.OceanRage);
		GameRegistry.registerItem(Olympia, Strings.Olympia);
		GameRegistry.registerItem(OmegaWeapon, Strings.OmegaWeapon);
		GameRegistry.registerItem(OminousBlight, Strings.OminousBlight);
		GameRegistry.registerItem(OneWingedAngel, Strings.OneWingedAngel);
		GameRegistry.registerItem(PainofSolitude, Strings.PainofSolitude);
		GameRegistry.registerItem(PhotonDebugger, Strings.PhotonDebugger);
		GameRegistry.registerItem(PixiePetal, Strings.PixiePetal);
		GameRegistry.registerItem(Pumpkinhead, Strings.Pumpkinhead);
		GameRegistry.registerItem(Rainfell, Strings.Rainfell);
		GameRegistry.registerItem(RejectionofFate, Strings.RejectionofFate);
		GameRegistry.registerItem(RoyalRadiance, Strings.RoyalRadiance);
		GameRegistry.registerItem(RumblingRose, Strings.RumblingRose);
		GameRegistry.registerItem(SignofInnocence, Strings.SignofInnocence);
		GameRegistry.registerItem(SilentDirge, Strings.SilentDirge);
		GameRegistry.registerItem(SkullNoise, Strings.SkullNoise);
		GameRegistry.registerItem(SleepingLion, Strings.SleepingLion);
		GameRegistry.registerItem(SoulEater, Strings.SoulEater);
		GameRegistry.registerItem(Spellbinder, Strings.Spellbinder);
		GameRegistry.registerItem(StarSeeker, Strings.StarSeeker);
		GameRegistry.registerItem(Starlight, Strings.Starlight);
		GameRegistry.registerItem(Stormfall, Strings.Stormfall);
		GameRegistry.registerItem(StrokeofMidnight, Strings.StrokeofMidnight);
		GameRegistry.registerItem(SweetDreams, Strings.SweetDreams);
		GameRegistry.registerItem(SweetMemories, Strings.SweetMemories);
		GameRegistry.registerItem(Sweetstack, Strings.Sweetstack);
		GameRegistry.registerItem(ThreeWishes, Strings.ThreeWishes);
		GameRegistry.registerItem(TotalEclipse, Strings.TotalEclipse);
		GameRegistry.registerItem(TreasureTrove, Strings.TreasureTrove);
		GameRegistry.registerItem(TrueLightsFlight, Strings.TrueLightsFlight);
		GameRegistry.registerItem(TwilightBlaze, Strings.TwilightBlaze);
		GameRegistry.registerItem(TwoBecomeOne, Strings.TwoBecomeOne);
		GameRegistry.registerItem(UltimaWeaponKH1, Strings.UltimaWeaponKH1);
		GameRegistry.registerItem(UltimaWeaponKH2, Strings.UltimaWeaponKH2);
		GameRegistry.registerItem(UltimaWeaponBBS, Strings.UltimaWeaponBBS);
		GameRegistry.registerItem(UltimaWeaponDDD, Strings.UltimaWeaponDDD);
		GameRegistry.registerItem(Umbrella, Strings.Umbrella);
		GameRegistry.registerItem(Unbound, Strings.Unbound);
		GameRegistry.registerItem(UnicornisForetellersKeyblade, Strings.UnicornisForetellersKeyblade);
		GameRegistry.registerItem(UrsusForetellersKeyblade, Strings.UrsusForetellersKeyblade);
		GameRegistry.registerItem(VictoryLine, Strings.VictoryLine);
		GameRegistry.registerItem(VoidGear, Strings.VoidGear);
		GameRegistry.registerItem(VulpeusForetellersKeyblade, Strings.VulpeusForetellersKeyblade);
		GameRegistry.registerItem(WaytotheDawn, Strings.WaytotheDawn);
		GameRegistry.registerItem(WaywardWind, Strings.WaywardWind);
		GameRegistry.registerItem(WinnersProof, Strings.WinnersProof);
		GameRegistry.registerItem(WishingLamp, Strings.WishingLamp);
		GameRegistry.registerItem(WishingStar, Strings.WishingStar);
		GameRegistry.registerItem(WoodenKeyblade, Strings.WoodenKeyblade);
		GameRegistry.registerItem(WoodenStick, Strings.WoodenStick);
		GameRegistry.registerItem(YoungXehanortsKeyblade, Strings.YoungXehanortsKeyblade);
		GameRegistry.registerItem(ZeroOne, Strings.ZeroOne);

		//CHAINS
		GameRegistry.registerItem(Chain_AbaddonPlasma, Strings.Chain_AbaddonPlasma);
		GameRegistry.registerItem(Chain_AbyssalTide, Strings.Chain_AbyssalTide);
		GameRegistry.registerItem(Chain_AllforOne, Strings.Chain_AllforOne);
		GameRegistry.registerItem(Chain_AnguisForetellersKeyblade, Strings.Chain_AnguisForetellersKeyblade);
		GameRegistry.registerItem(Chain_AstralBlast, Strings.Chain_AstralBlast);
		GameRegistry.registerItem(Chain_Aubade, Strings.Chain_Aubade);
		GameRegistry.registerItem(Chain_BondofFlame, Strings.Chain_BondofFlame);
		GameRegistry.registerItem(Chain_Brightcrest, Strings.Chain_Brightcrest);
		GameRegistry.registerItem(Chain_ChaosRipper, Strings.Chain_ChaosRipper);
		GameRegistry.registerItem(Chain_CircleofLife, Strings.Chain_CircleofLife);
		GameRegistry.registerItem(Chain_Counterpoint, Strings.Chain_Counterpoint);
		GameRegistry.registerItem(Chain_Crabclaw, Strings.Chain_Crabclaw);
		GameRegistry.registerItem(Chain_CrownofGuilt, Strings.Chain_CrownofGuilt);
		GameRegistry.registerItem(Chain_DarkerThanDark, Strings.Chain_DarkerThanDark);
		GameRegistry.registerItem(Chain_Darkgnaw, Strings.Chain_Darkgnaw);
		GameRegistry.registerItem(Chain_DecisivePumpkin, Strings.Chain_DecisivePumpkin);
		GameRegistry.registerItem(Chain_DestinysEmbrace, Strings.Chain_DestinysEmbrace);
		GameRegistry.registerItem(Chain_DiamondDust, Strings.Chain_DiamondDust);
		GameRegistry.registerItem(Chain_Divewing, Strings.Chain_Divewing);
		GameRegistry.registerItem(Chain_DivineRose, Strings.Chain_DivineRose);
		GameRegistry.registerItem(Chain_DreamSword, Strings.Chain_DreamSword);
		GameRegistry.registerItem(Chain_DualDisc, Strings.Chain_DualDisc);
		GameRegistry.registerItem(Chain_Earthshaker, Strings.Chain_Earthshaker);
		GameRegistry.registerItem(Chain_EndofPain, Strings.Chain_EndofPain);
		GameRegistry.registerItem(Chain_EndsoftheEarth, Strings.Chain_EndsoftheEarth);
		GameRegistry.registerItem(Chain_FairyHarp, Strings.Chain_FairyHarp);
		GameRegistry.registerItem(Chain_FairyStars, Strings.Chain_FairyStars);
		GameRegistry.registerItem(Chain_FatalCrest, Strings.Chain_FatalCrest);
		GameRegistry.registerItem(Chain_Fenrir, Strings.Chain_Fenrir);
		GameRegistry.registerItem(Chain_FerrisGear, Strings.Chain_FerrisGear);
		GameRegistry.registerItem(Chain_FollowtheWind, Strings.Chain_FollowtheWind);
		GameRegistry.registerItem(Chain_FrolicFlame, Strings.Chain_FrolicFlame);
		GameRegistry.registerItem(Chain_GlimpseofDarkness, Strings.Chain_GlimpseofDarkness);
		GameRegistry.registerItem(Chain_GuardianBell, Strings.Chain_GuardianBell);
		GameRegistry.registerItem(Chain_GuardianSoul, Strings.Chain_GuardianSoul);
		GameRegistry.registerItem(Chain_GullWing, Strings.Chain_GullWing);
		GameRegistry.registerItem(Chain_HerosCrest, Strings.Chain_HerosCrest);
		GameRegistry.registerItem(Chain_HiddenDragon, Strings.Chain_HiddenDragon);
		GameRegistry.registerItem(Chain_Hyperdrive, Strings.Chain_Hyperdrive);
		GameRegistry.registerItem(Chain_IncompleteKiblade, Strings.Chain_IncompleteKiblade);
		GameRegistry.registerItem(Chain_JungleKing, Strings.Chain_JungleKing);
		GameRegistry.registerItem(Chain_KeybladeofPeoplesHearts, Strings.Chain_KeybladeofPeoplesHearts);
		GameRegistry.registerItem(Chain_Kiblade, Strings.Chain_Kiblade);
		GameRegistry.registerItem(Chain_KingdomKey, Strings.Chain_KingdomKey);
		GameRegistry.registerItem(Chain_KingdomKeyD, Strings.Chain_KingdomKeyD);
		GameRegistry.registerItem(Chain_KnockoutPunch, Strings.Chain_KnockoutPunch);
		GameRegistry.registerItem(Chain_LadyLuck, Strings.Chain_LadyLuck);
		GameRegistry.registerItem(Chain_LeasKeyblade, Strings.Chain_LeasKeyblade);
		GameRegistry.registerItem(Chain_LeopardosForetellersKeyblade, Strings.Chain_LeopardosForetellersKeyblade);
		GameRegistry.registerItem(Chain_Leviathan, Strings.Chain_Leviathan);
		GameRegistry.registerItem(Chain_Lionheart, Strings.Chain_Lionheart);
		GameRegistry.registerItem(Chain_LostMemory, Strings.Chain_LostMemory);
		GameRegistry.registerItem(Chain_LunarEclipse, Strings.Chain_LunarEclipse);
		GameRegistry.registerItem(Chain_MarkofaHero, Strings.Chain_MarkofaHero);
		GameRegistry.registerItem(Chain_MasterXehanortsKeyblade, Strings.Chain_MasterXehanortsKeyblade);
		GameRegistry.registerItem(Chain_MastersDefender, Strings.Chain_MastersDefender);
		GameRegistry.registerItem(Chain_MaverickFlare, Strings.Chain_MaverickFlare);
		GameRegistry.registerItem(Chain_MetalChocobo, Strings.Chain_MetalChocobo);
		GameRegistry.registerItem(Chain_MidnightRoar, Strings.Chain_MidnightRoar);
		GameRegistry.registerItem(Chain_MissingAche, Strings.Chain_MissingAche);
		GameRegistry.registerItem(Chain_Monochrome, Strings.Chain_Monochrome);
		GameRegistry.registerItem(Chain_MysteriousAbyss, Strings.Chain_MysteriousAbyss);
		GameRegistry.registerItem(Chain_NoName, Strings.Chain_NoName);
		GameRegistry.registerItem(Chain_Oathkeeper, Strings.Chain_Oathkeeper);
		GameRegistry.registerItem(Chain_Oblivion, Strings.Chain_Oblivion);
		GameRegistry.registerItem(Chain_OceanRage, Strings.Chain_OceanRage);
		GameRegistry.registerItem(Chain_Olympia, Strings.Chain_Olympia);
		GameRegistry.registerItem(Chain_OmegaWeapon, Strings.Chain_OmegaWeapon);
		GameRegistry.registerItem(Chain_OminousBlight, Strings.Chain_OminousBlight);
		GameRegistry.registerItem(Chain_OneWingedAngel, Strings.Chain_OneWingedAngel);
		GameRegistry.registerItem(Chain_PainofSolitude, Strings.Chain_PainofSolitude);
		GameRegistry.registerItem(Chain_PhotonDebugger, Strings.Chain_PhotonDebugger);
		GameRegistry.registerItem(Chain_PixiePetal, Strings.Chain_PixiePetal);
		GameRegistry.registerItem(Chain_Pumpkinhead, Strings.Chain_Pumpkinhead);
		GameRegistry.registerItem(Chain_Rainfell, Strings.Chain_Rainfell);
		GameRegistry.registerItem(Chain_RejectionofFate, Strings.Chain_RejectionofFate);
		GameRegistry.registerItem(Chain_RoyalRadiance, Strings.Chain_RoyalRadiance);
		GameRegistry.registerItem(Chain_RumblingRose, Strings.Chain_RumblingRose);
		GameRegistry.registerItem(Chain_SignofInnocence, Strings.Chain_SignofInnocence);
		GameRegistry.registerItem(Chain_SilentDirge, Strings.Chain_SilentDirge);
		GameRegistry.registerItem(Chain_SkullNoise, Strings.Chain_SkullNoise);
		GameRegistry.registerItem(Chain_SleepingLion, Strings.Chain_SleepingLion);
		GameRegistry.registerItem(Chain_SoulEater, Strings.Chain_SoulEater);
		GameRegistry.registerItem(Chain_Spellbinder, Strings.Chain_Spellbinder);
		GameRegistry.registerItem(Chain_StarSeeker, Strings.Chain_StarSeeker);
		GameRegistry.registerItem(Chain_Starlight, Strings.Chain_Starlight);
		GameRegistry.registerItem(Chain_Stormfall, Strings.Chain_Stormfall);
		GameRegistry.registerItem(Chain_StrokeofMidnight, Strings.Chain_StrokeofMidnight);
		GameRegistry.registerItem(Chain_SweetDreams, Strings.Chain_SweetDreams);
		GameRegistry.registerItem(Chain_SweetMemories, Strings.Chain_SweetMemories);
		GameRegistry.registerItem(Chain_Sweetstack, Strings.Chain_Sweetstack);
		GameRegistry.registerItem(Chain_ThreeWishes, Strings.Chain_ThreeWishes);
		GameRegistry.registerItem(Chain_TotalEclipse, Strings.Chain_TotalEclipse);
		GameRegistry.registerItem(Chain_TreasureTrove, Strings.Chain_TreasureTrove);
		GameRegistry.registerItem(Chain_TrueLightsFlight, Strings.Chain_TrueLightsFlight);
		GameRegistry.registerItem(Chain_TwilightBlaze, Strings.Chain_TwilightBlaze);
		GameRegistry.registerItem(Chain_TwoBecomeOne, Strings.Chain_TwoBecomeOne);
		GameRegistry.registerItem(Chain_UltimaWeaponKH1, Strings.Chain_UltimaWeaponKH1);
		GameRegistry.registerItem(Chain_UltimaWeaponKH2, Strings.Chain_UltimaWeaponKH2);
		GameRegistry.registerItem(Chain_UltimaWeaponBBS, Strings.Chain_UltimaWeaponBBS);
		GameRegistry.registerItem(Chain_UltimaWeaponDDD, Strings.Chain_UltimaWeaponDDD);
		GameRegistry.registerItem(Chain_Umbrella, Strings.Chain_Umbrella);
		GameRegistry.registerItem(Chain_Unbound, Strings.Chain_Unbound);
		GameRegistry.registerItem(Chain_UnicornisForetellersKeyblade, Strings.Chain_UnicornisForetellersKeyblade);
		GameRegistry.registerItem(Chain_UrsusForetellersKeyblade, Strings.Chain_UrsusForetellersKeyblade);
		GameRegistry.registerItem(Chain_VictoryLine, Strings.Chain_VictoryLine);
		GameRegistry.registerItem(Chain_VoidGear, Strings.Chain_VoidGear);
		GameRegistry.registerItem(Chain_VulpeusForetellersKeyblade, Strings.Chain_VulpeusForetellersKeyblade);
		GameRegistry.registerItem(Chain_WaytotheDawn, Strings.Chain_WaytotheDawn);
		GameRegistry.registerItem(Chain_WaywardWind, Strings.Chain_WaywardWind);
		GameRegistry.registerItem(Chain_WinnersProof, Strings.Chain_WinnersProof);
		GameRegistry.registerItem(Chain_WishingLamp, Strings.Chain_WishingLamp);
		GameRegistry.registerItem(Chain_WishingStar, Strings.Chain_WishingStar);
		GameRegistry.registerItem(Chain_YoungXehanortsKeyblade, Strings.Chain_YoungXehanortsKeyblade);
		GameRegistry.registerItem(Chain_ZeroOne, Strings.Chain_ZeroOne);

		//ITEMS
		GameRegistry.registerItem(Munny, Strings.Munny);
		GameRegistry.registerItem(EmptyBottle, Strings.EmptyBottle);
		GameRegistry.registerItem(Potion, Strings.Potion);
		GameRegistry.registerItem(Ether, Strings.Ether);
		GameRegistry.registerItem(Elixir, Strings.Elixir);
		GameRegistry.registerItem(HpOrb, Strings.HpOrb);
		GameRegistry.registerItem(DriveOrb, Strings.DriveOrb);
		GameRegistry.registerItem(MagicOrb, Strings.MagicOrb);
		GameRegistry.registerItem(Heart, Strings.Heart);
		GameRegistry.registerItem(DarkHeart, Strings.DarkHeart);
		GameRegistry.registerItem(PureHeart, Strings.PureHeart);
		GameRegistry.registerItem(KingdomHearts, Strings.KingdomHearts);
		GameRegistry.registerItem(DarkLeather, Strings.DarkLeather);
		GameRegistry.registerItem(SynthesisMaterial, Strings.SynthesisMaterial);
		GameRegistry.registerItem(Recipe, Strings.Recipe);
		GameRegistry.registerItem(IceCream, Strings.IceCream);
		GameRegistry.registerItem(WinnerStick, Strings.WinnerStick);
		GameRegistry.registerItem(LevelUpMagicFire, Strings.LevelUpMagicFire);
		GameRegistry.registerItem(LevelUpMagicBlizzard, Strings.LevelUpMagicBlizzard);
		GameRegistry.registerItem(LevelUpMagicThunder, Strings.LevelUpMagicThunder);
		GameRegistry.registerItem(LevelUpMagicCure, Strings.LevelUpMagicCure);
		GameRegistry.registerItem(LevelUpMagicAero, Strings.LevelUpMagicAero);
		GameRegistry.registerItem(LevelUpMagicStop, Strings.LevelUpMagicStop);

		//DISCS
		GameRegistry.registerItem(Disc_Birth_by_Sleep_A_Link_to_the_Future, Strings.Disc_Birth_by_Sleep_A_Link_to_the_Future);
		GameRegistry.registerItem(Disc_Darkness_of_the_Unknown, Strings.Disc_Darkness_of_the_Unknown);
		GameRegistry.registerItem(Disc_Dearly_Beloved_Symphony_Version, Strings.Disc_Dearly_Beloved_Symphony_Version);
		GameRegistry.registerItem(Disc_Dream_Drop_Distance_The_Next_Awakening, Strings.Disc_Dream_Drop_Distance_The_Next_Awakening);
		GameRegistry.registerItem(Disc_Hikari_KINGDOM_Instrumental_Version, Strings.Disc_Hikari_KINGDOM_Instrumental_Version);
		GameRegistry.registerItem(Disc_L_Oscurita_Dell_Ignoto, Strings.Disc_L_Oscurita_Dell_Ignoto);
		GameRegistry.registerItem(Disc_Musique_pour_la_tristesse_de_Xion, Strings.Disc_Musique_pour_la_tristesse_de_Xion);
		GameRegistry.registerItem(Disc_No_More_Bugs_Bug_Version, Strings.Disc_No_More_Bugs_Bug_Version);
		GameRegistry.registerItem(Disc_Organization_XIII, Strings.Disc_Organization_XIII);
		GameRegistry.registerItem(Disc_Sanctuary, Strings.Disc_Sanctuary);
		GameRegistry.registerItem(Disc_Simple_And_Clean_PLANITb_Remix, Strings.Disc_Simple_And_Clean_PLANITb_Remix);
		GameRegistry.registerItem(Disc_Sinister_Sundown, Strings.Disc_Sinister_Sundown);
		GameRegistry.registerItem(Disc_The_13th_Anthology, Strings.Disc_The_13th_Anthology);
	}

	public static void registerRenders(){
		//Materials
		registerRender(BlazingInfusedCoal);
		registerRender(FrostInfusedSnowBall);
		registerRender(StormyInfusedIron);
		registerRender(MythrilInfusedDiamond);
		registerRender(LightningInfusedGold);
		registerRender(BrightInfusedGlowStone);
		registerRender(DarkInfusedIron);

		//Armour
		registerRender(OrganizationRobe_Helmet);
		registerRender(OrganizationRobe_Chestplate);
		registerRender(OrganizationRobe_Leggings);
		registerRender(OrganizationRobe_Boots);

		registerRender(Terra_Helmet);
		registerRender(Terra_Chestplate);
		registerRender(Terra_Leggings);
		registerRender(Terra_Boots);

		registerRender(Aqua_Helmet);
		registerRender(Aqua_Chestplate);
		registerRender(Aqua_Leggings);
		registerRender(Aqua_Boots);

		registerRender(Ventus_Helmet);
		registerRender(Ventus_Chestplate);
		registerRender(Ventus_Leggings);
		registerRender(Ventus_Boots);

		registerRender(Eraqus_Helmet);
		registerRender(Eraqus_Chestplate);
		registerRender(Eraqus_Leggings);
		registerRender(Eraqus_Boots);

		//Organization
		registerRender(Interdiction);
		registerRender(Sharpshooter);
		registerRender(Lindworm);
		registerRender(FrozenPride);
		registerRender(Skysplitter);
		registerRender(BookofRetribution);
		registerRender(Lunatic);
		registerRender(EternalFlames);
		registerRender(Arpeggio);
		registerRender(FairGame);
		registerRender(GracefulDahlia);
		registerRender(Foudre);

		//Knowledge
		registerRender(AbandonedKnowledge);
		registerRender(DarkKnowledge);
		registerRender(EclipsedKnowledge);
		registerRender(ForgottenKnowledge);
		registerRender(IlludedKnowledge);
		registerRender(LostKnowledge);
		registerRender(ManifestKnowledge);
		registerRender(ObscuredKnowledge);
		registerRender(UnknownKnowledge);
		registerRender(VoidKnowledge);

		//Keyblades
		registerRender(AbaddonPlasma);
		registerRender(AbyssalTide);
		registerRender(AllforOne);
		registerRender(AnguisForetellersKeyblade);
		registerRender(AstralBlast);
		registerRender(Aubade);
		registerRender(BondofFlame);
		registerRender(Brightcrest);
		registerRender(ChaosRipper);
		registerRender(CircleofLife);
		registerRender(Counterpoint);
		registerRender(Counterpoint);
		registerRender(Crabclaw);
		registerRender(CrownofGuilt);
		registerRender(DarkerThanDark);
		registerRender(Darkgnaw);
		registerRender(DecisivePumpkin);
		registerRender(DestinysEmbrace);
		registerRender(DiamondDust);
		registerRender(Divewing);
		registerRender(DivineRose);
		registerRender(DreamSword);
		registerRender(DualDisc);
		registerRender(Earthshaker);
		registerRender(EndofPain);
		registerRender(EndsoftheEarth);
		registerRender(FairyHarp);
		registerRender(FairyStars);
		registerRender(FatalCrest);
		registerRender(Fenrir);
		registerRender(FerrisGear);
		registerRender(FollowtheWind);
		registerRender(FrolicFlame);
		registerRender(GlimpseofDarkness);
		registerRender(GuardianBell);
		registerRender(GuardianSoul);
		registerRender(GullWing);
		registerRender(HerosCrest);
		registerRender(HiddenDragon);
		registerRender(Hyperdrive);
		registerRender(IncompleteKiblade);
		registerRender(JungleKing);
		registerRender(KeybladeofPeoplesHearts);
		registerRender(Kiblade);
		registerRender(KingdomKey);
		registerRender(KingdomKeyD);
		registerRender(KnockoutPunch);
		registerRender(LadyLuck);
		registerRender(LeasKeyblade);
		registerRender(LeopardosForetellersKeyblade);
		registerRender(Leviathan);
		registerRender(Lionheart);
		registerRender(LostMemory);
		registerRender(LunarEclipse);
		registerRender(MarkofaHero);
		registerRender(MasterXehanortsKeyblade);
		registerRender(MastersDefender);
		registerRender(MaverickFlare);
		//registerRender(MetalChocobo);
		registerRender(MidnightRoar);
		registerRender(MissingAche);
		registerRender(Monochrome);
		registerRender(MysteriousAbyss);
		registerRender(NoName);
		registerRender(Oathkeeper);
		registerRender(Oblivion);
		registerRender(OceanRage);
		registerRender(Olympia);
		registerRender(OmegaWeapon);
		registerRender(OminousBlight);
		registerRender(OneWingedAngel);
		registerRender(PainofSolitude);
		registerRender(PhotonDebugger);
		registerRender(PixiePetal);
		registerRender(Pumpkinhead);
		registerRender(Rainfell);
		registerRender(RejectionofFate);
		registerRender(RoyalRadiance);
		registerRender(RumblingRose);
		registerRender(SignofInnocence);
		registerRender(SilentDirge);
		registerRender(SkullNoise);
		registerRender(SleepingLion);
		registerRender(SoulEater);
		registerRender(Spellbinder);
		registerRender(StarSeeker);
		registerRender(Starlight);
		registerRender(Stormfall);
		registerRender(StrokeofMidnight);
		registerRender(SweetDreams);
		registerRender(SweetMemories);
		registerRender(Sweetstack);
		registerRender(ThreeWishes);
		registerRender(TotalEclipse);
		registerRender(TreasureTrove);
		registerRender(TrueLightsFlight);
		registerRender(TwilightBlaze);
		registerRender(TwoBecomeOne);
		registerRender(UltimaWeaponKH1);
		registerRender(UltimaWeaponKH2);
		registerRender(UltimaWeaponBBS);
		registerRender(UltimaWeaponDDD);
		registerRender(Umbrella);
		registerRender(Unbound);
		registerRender(UnicornisForetellersKeyblade);
		registerRender(UrsusForetellersKeyblade);
		registerRender(VictoryLine);
		registerRender(VoidGear);
		registerRender(VulpeusForetellersKeyblade);
		registerRender(WaytotheDawn);
		registerRender(WaywardWind);
		registerRender(WinnersProof);
		registerRender(WishingLamp);
		registerRender(WishingStar);
		registerRender(WoodenKeyblade);
		registerRender(WoodenStick);
		registerRender(YoungXehanortsKeyblade);
		registerRender(ZeroOne);

		//CHAINS
		registerRender(Chain_AbaddonPlasma);
		registerRender(Chain_AbyssalTide);
		registerRender(Chain_AllforOne);
		registerRender(Chain_AnguisForetellersKeyblade);
		registerRender(Chain_AstralBlast);
		registerRender(Chain_Aubade);
		registerRender(Chain_BondofFlame);
		registerRender(Chain_Brightcrest);
		registerRender(Chain_ChaosRipper);
		registerRender(Chain_CircleofLife);
		registerRender(Chain_Counterpoint);
		registerRender(Chain_Counterpoint);
		registerRender(Chain_Crabclaw);
		registerRender(Chain_CrownofGuilt);
		registerRender(Chain_DarkerThanDark);
		registerRender(Chain_Darkgnaw);
		registerRender(Chain_DecisivePumpkin);
		registerRender(Chain_DestinysEmbrace);
		registerRender(Chain_DiamondDust);
		registerRender(Chain_Divewing);
		registerRender(Chain_DivineRose);
		registerRender(Chain_DreamSword);
		registerRender(Chain_DualDisc);
		registerRender(Chain_Earthshaker);
		registerRender(Chain_EndofPain);
		registerRender(Chain_EndsoftheEarth);
		registerRender(Chain_FairyHarp);
		registerRender(Chain_FairyStars);
		registerRender(Chain_FatalCrest);
		registerRender(Chain_Fenrir);
		registerRender(Chain_FerrisGear);
		registerRender(Chain_FollowtheWind);
		registerRender(Chain_FrolicFlame);
		registerRender(Chain_GlimpseofDarkness);
		registerRender(Chain_GuardianBell);
		registerRender(Chain_GuardianSoul);
		registerRender(Chain_GullWing);
		registerRender(Chain_HerosCrest);
		registerRender(Chain_HiddenDragon);
		registerRender(Chain_Hyperdrive);
		registerRender(Chain_IncompleteKiblade);
		registerRender(Chain_JungleKing);
		registerRender(Chain_KeybladeofPeoplesHearts);
		registerRender(Chain_Kiblade);
		registerRender(Chain_KingdomKey);
		registerRender(Chain_KingdomKeyD);
		registerRender(Chain_KnockoutPunch);
		registerRender(Chain_LadyLuck);
		registerRender(Chain_LeasKeyblade);
		registerRender(Chain_LeopardosForetellersKeyblade);
		registerRender(Chain_Leviathan);
		registerRender(Chain_Lionheart);
		registerRender(Chain_LostMemory);
		registerRender(Chain_LunarEclipse);
		registerRender(Chain_MarkofaHero);
		registerRender(Chain_MasterXehanortsKeyblade);
		registerRender(Chain_MastersDefender);
		registerRender(Chain_MaverickFlare);
		registerRender(Chain_MetalChocobo);
		registerRender(Chain_MidnightRoar);
		registerRender(Chain_MissingAche);
		registerRender(Chain_Monochrome);
		registerRender(Chain_MysteriousAbyss);
		registerRender(Chain_NoName);
		registerRender(Chain_Oathkeeper);
		registerRender(Chain_Oblivion);
		registerRender(Chain_OceanRage);
		registerRender(Chain_Olympia);
		registerRender(Chain_OmegaWeapon);
		registerRender(Chain_OminousBlight);
		registerRender(Chain_OneWingedAngel);
		registerRender(Chain_PainofSolitude);
		registerRender(Chain_PhotonDebugger);
		registerRender(Chain_PixiePetal);
		registerRender(Chain_Pumpkinhead);
		registerRender(Chain_Rainfell);
		registerRender(Chain_RejectionofFate);
		registerRender(Chain_RoyalRadiance);
		registerRender(Chain_RumblingRose);
		registerRender(Chain_SignofInnocence);
		registerRender(Chain_SilentDirge);
		registerRender(Chain_SkullNoise);
		registerRender(Chain_SleepingLion);
		registerRender(Chain_SoulEater);
		registerRender(Chain_Spellbinder);
		registerRender(Chain_StarSeeker);
		registerRender(Chain_Starlight);
		registerRender(Chain_Stormfall);
		registerRender(Chain_StrokeofMidnight);
		registerRender(Chain_SweetDreams);
		registerRender(Chain_SweetMemories);
		registerRender(Chain_Sweetstack);
		registerRender(Chain_ThreeWishes);
		registerRender(Chain_TotalEclipse);
		registerRender(Chain_TreasureTrove);
		registerRender(Chain_TrueLightsFlight);
		registerRender(Chain_TwilightBlaze);
		registerRender(Chain_TwoBecomeOne);
		registerRender(Chain_UltimaWeaponKH1);
		registerRender(Chain_UltimaWeaponKH2);
		registerRender(Chain_UltimaWeaponBBS);
		registerRender(Chain_UltimaWeaponDDD);
		registerRender(Chain_Umbrella);
		registerRender(Chain_Unbound);
		registerRender(Chain_UnicornisForetellersKeyblade);
		registerRender(Chain_UrsusForetellersKeyblade);
		registerRender(Chain_VictoryLine);
		registerRender(Chain_VoidGear);
		registerRender(Chain_VulpeusForetellersKeyblade);
		registerRender(Chain_WaytotheDawn);
		registerRender(Chain_WaywardWind);
		registerRender(Chain_WinnersProof);
		registerRender(Chain_WishingLamp);
		registerRender(Chain_WishingStar);
		registerRender(Chain_YoungXehanortsKeyblade);
		registerRender(Chain_ZeroOne);

		//Other items
		registerRender(Munny);
		registerRender(EmptyBottle);
		registerRender(Potion);
		registerRender(Ether);
		registerRender(Elixir);
		registerRender(HpOrb);
		registerRender(DriveOrb);
		registerRender(MagicOrb);
		registerRender(Heart);
		registerRender(DarkHeart);
		registerRender(PureHeart);
		registerRender(KingdomHearts);
		registerRender(DarkLeather);
		registerRender(SynthesisMaterial);
		registerRender(Recipe);
		registerRender(IceCream);
		registerRender(WinnerStick);
		registerRender(LevelUpMagicFire);
		registerRender(LevelUpMagicBlizzard);
		registerRender(LevelUpMagicThunder);
		registerRender(LevelUpMagicCure);
		registerRender(LevelUpMagicAero);
		registerRender(LevelUpMagicStop);

		//Discs
		registerRender(Disc_Birth_by_Sleep_A_Link_to_the_Future);
		registerRender(Disc_Darkness_of_the_Unknown);
		registerRender(Disc_Dearly_Beloved_Symphony_Version);
		registerRender(Disc_Dream_Drop_Distance_The_Next_Awakening);
		registerRender(Disc_Hikari_KINGDOM_Instrumental_Version);
		registerRender(Disc_L_Oscurita_Dell_Ignoto);
		registerRender(Disc_Musique_pour_la_tristesse_de_Xion);
		registerRender(Disc_No_More_Bugs_Bug_Version);
		registerRender(Disc_Organization_XIII);
		registerRender(Disc_Sanctuary);
		registerRender(Disc_Simple_And_Clean_PLANITb_Remix);
		registerRender(Disc_Sinister_Sundown);
		registerRender(Disc_The_13th_Anthology);

	}

	public static void registerRender(Item item){
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(item, 0, new ModelResourceLocation(Reference.MODID + ":" + item.getUnlocalizedName().substring(5), "inventory"));
	}
}
