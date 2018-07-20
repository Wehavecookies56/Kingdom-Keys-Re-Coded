package uk.co.wehavecookies56.kk.common.item;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.SoundEvents;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import uk.co.wehavecookies56.kk.client.sound.ModSounds;
import uk.co.wehavecookies56.kk.common.ability.ModAbilities;
import uk.co.wehavecookies56.kk.common.core.handler.BalanceConfig;
import uk.co.wehavecookies56.kk.common.item.base.ItemKKArmor;
import uk.co.wehavecookies56.kk.common.item.base.ItemKKBase;
import uk.co.wehavecookies56.kk.common.item.base.ItemKKRecord;
import uk.co.wehavecookies56.kk.common.item.base.ItemKeyblade;
import uk.co.wehavecookies56.kk.common.item.base.ItemKeychain;
import uk.co.wehavecookies56.kk.common.item.base.ItemRealKeyblade;
import uk.co.wehavecookies56.kk.common.item.base.ItemRecipe;
import uk.co.wehavecookies56.kk.common.item.base.ItemSynthesisMaterial;
import uk.co.wehavecookies56.kk.common.item.org.ItemArrowguns;
import uk.co.wehavecookies56.kk.common.item.org.ItemAxeSword;
import uk.co.wehavecookies56.kk.common.item.org.ItemCard;
import uk.co.wehavecookies56.kk.common.item.org.ItemChakram;
import uk.co.wehavecookies56.kk.common.item.org.ItemClaymore;
import uk.co.wehavecookies56.kk.common.item.org.ItemEtherealBlade;
import uk.co.wehavecookies56.kk.common.item.org.ItemKnife;
import uk.co.wehavecookies56.kk.common.item.org.ItemLances;
import uk.co.wehavecookies56.kk.common.item.org.ItemLexicon;
import uk.co.wehavecookies56.kk.common.item.org.ItemOrgShield;
import uk.co.wehavecookies56.kk.common.item.org.ItemScythe;
import uk.co.wehavecookies56.kk.common.item.org.ItemSitar;
import uk.co.wehavecookies56.kk.common.lib.Reference;
import uk.co.wehavecookies56.kk.common.lib.Strings;
import uk.co.wehavecookies56.kk.common.lib.SynthesisStack;

public class ModItems {
    public static Item Malice, Sanction, Overlord, Veneration, Autocracy, Conquest, Terminus, Judgement, Discipline,
            Aristocracy, Superiority, Aggression, Fury, Despair, Triumph, Ruination, Domination, Annihilation, Tyrant,
            Magnificence, Infinity, Interdiction, RoundFan, Absolute, Standalone, Killerbee, Stingray, Counterweight,
            Precision, DualHead, Bahamut, Gullwing, BlueFrame, StarShell, Sunrise, Ignition, Armstrong, HardBoiledHeat,
            DiabloEye, DoubleTap, Stardust, EnergyMuzzle, CrimeAndPunishment, CupidsArrow, FinalWeapon, Sharpshooter,
            Dryer, Trumpet, Zephyr, Moonglade, Aer, Nescience, Brume, Asura, Crux, Paladin, Fellking, Nightcloud,
            Shimmer, Vortex, Scission, Heavenfall, Aether, Mazzaroth, Hegemon, Foxfire, Yaksha, Cynosura, Dragonreign,
            Lindworm, Broom, Wyvern, TesterZero, ProductOne, DeepFreeze, CryoliteShield, FalseTheory, Glacier,
            AbsoluteZero, Gunz, Mindel, Snowslide, Iceberg, Inquisition, Scrutiny, Empiricism, Edification, Contrivance,
            Wurm, Subzero, ColdBlood, DiamondShield, Aegis, FrozenPride, PotLid, Snowman, Reticence, Goliath, CopperRed,
            Daybreak, Colossus, UrsaMajor, Megacosm, Terrene, Fuligin, HardWinter, Firefly, Harbinger, Redwood, Sequoia,
            IronBlack, Earthshine, Octiron, Hyperion, Clarity, OneThousandAndOneNights, CardinalVirtue, Skysplitter,
            BleepBloopBop, Monolith, BlackPrimer, WhiteTome, IllicitResearch, BuriedSecrets, ArcaneCompendium,
            DissentersNotes, NefariousCodex, MysticAlbum, CursedManual, TabooText, EldritchEsoterica, FreakishBestiary,
            MadmansVita, UntitledWritings, AbandonedDogma, AtlasOfOmens, RevoltingScrapbook, LostHeterodoxy,
            OtherworldlyTales, IndescribableLore, RadicalTreatise, BookofRetribution, MidnightSnack, DearDiary,
            NewMoon, Werewolf, Artemis, Luminary, Selene, Moonrise, Astrologia, Crater, LunarPhase, Crescent, Gibbous,
            Berserker, Twilight, QueenOfTheNight, BalsamicMoon, Orbit, LightYear, KingOfTheNight, Moonset, Horoscope,
            Dichotomy, Lunatic, JustDesserts, Bunnymoon, Ashes, Doldrums, DelayedAction, DiveBombers, Combustion,
            MoulinRouge, BlazeofGlory, Prometheus, Ifrit, MagmaOcean, Volcanics, Inferno, SizzlingEdge, Corona,
            FerrisWheel, Burnout, OmegaTrinity, Outbreak, DoubleEdge, Wildfire, Prominence, EternalFlames, PizzaCut,
            Conformers, BasicModel, TuneUp, Quartet, Quintet, Overture, OldHand, DaCapo, PowerChord, Fermata, Interlude,
            Serenade, Songbird, RiseToFame, RockStar, EightFinger, Concerto, Harmonics, MillionBucks, Fortissimo,
            UpToEleven, Sanctuary, Arpeggio, PrinceOfAwesome, AfterSchool, TheFool, TheMagician, TheStar, TheMoon,
            Justice, TheHierophant, TheWorld, Temperance, TheHighPriestess, TheTower, TheHangedMan, Death, TheHermit,
            Strength, TheLovers, TheChariot, TheSun, TheDevil, TheEmpress, TheEmperor, TheJoker, FairGame,
            FinestFantasy13, HighRollersSecret, FickleErica, JiltedAnemone, ProudAmaryllis, MadSafflower, PoorMelissa,
            TragicAllium, MournfulCineria, PseudoSilene, FaithlessDigitalis, GrimMuscari, DocileVallota,
            QuietBelladonna, PartingIpheion, LoftyGerbera, GallantAchillea, NoblePeony, FearsomeAnise,
            VindictiveThistle, FairHelianthus, SolemnMagnolia, HallowedLotus, GracefulDahlia, StirringLadle,
            DaintyBellflowers, Trancheuse, Orage, Tourbillon, Tempete, Carmin, Meteore, Etoile, Irregulier, Dissonance,
            Eruption, SoleilCouchant, Indigo, Vague, Deluge, Rafale, Typhon, Extirpeur, CroixDuSud, Lumineuse,
            ClairdeLune, VoldeNuit, Foudre, Demoiselle, Ampoule, BlazingInfusedCoal, FrostInfusedSnowBall,
            StormyInfusedIron, MythrilInfusedDiamond, LightningInfusedGold, BrightInfusedGlowStone, DarkInfusedIron,
            AbandonedKnowledge, DreamShield, DreamStaff, DreamSword, AbaddonPlasma, AbyssalTide, AllforOne,
            AnguisForetellersKeyblade, AstralBlast, Aubade, BondofFlame, Brightcrest, ChaosRipper, CircleofLife,
            Counterpoint, Crabclaw, CrownofGuilt, DarkerThanDark, Darkgnaw, DecisivePumpkin, DestinysEmbrace,
            DiamondDust, Divewing, DivineRose, DualDisc, Earthshaker, EndofPain, EndsoftheEarth, FairyHarp, FairyStars,
            FatalCrest, Fenrir, FerrisGear, FollowtheWind, FrolicFlame, GlimpseofDarkness, GuardianBell, GuardianSoul,
            GullWing, HerosCrest, HiddenDragon, Hyperdrive, IncompleteKiblade, JungleKing, KeybladeofPeoplesHearts,
            Kiblade, KingdomKey, KingdomKeyD, KnockoutPunch, LadyLuck, LeasKeyblade, LeopardosForetellersKeyblade,
            Leviathan, Lionheart, LostMemory, LunarEclipse, MarkofaHero, MasterXehanortsKeyblade, MastersDefender,
            MaverickFlare, MetalChocobo, MidnightRoar, MirageSplit, MissingAche, Monochrome, MysteriousAbyss,
            NightmaresEnd, NightmaresEndandMirageSplit, NoName, Oathkeeper, Oblivion, OceansRage, Olympia, OmegaWeapon,
            OminousBlight, OneWingedAngel, PainofSolitude, PhotonDebugger, PixiePetal, Pumpkinhead, Rainfell,
            RejectionofFate, RoyalRadiance, RumblingRose, SignofInnocence, SilentDirge, SkullNoise, SleepingLion,
            SoulEater, Spellbinder, StarSeeker, Starlight, Stormfall, StrokeofMidnight, SweetDreams, SweetMemories,
            Sweetstack, ThreeWishes, TotalEclipse, TreasureTrove, TrueLightsFlight, TwilightBlaze, TwoBecomeOne,
            UltimaWeaponKH1, UltimaWeaponKH2, UltimaWeaponBBS, UltimaWeaponDDD, Umbrella, Unbound,
            UnicornisForetellersKeyblade, UrsusForetellersKeyblade, VictoryLine, VoidGear, VulpeusForetellersKeyblade,
            WaytotheDawn, WaywardWind, WinnersProof, WishingLamp, WishingStar, WoodenKeyblade, WoodenStick,
            YoungXehanortsKeyblade, ZeroOne, Chain_AbaddonPlasma, Chain_AbyssalTide, Chain_AllforOne,
            Chain_AnguisForetellersKeyblade, Chain_AstralBlast, Chain_Aubade, Chain_BondofFlame, Chain_Brightcrest,
            Chain_ChaosRipper, Chain_CircleofLife, Chain_Counterpoint, Chain_Crabclaw, Chain_CrownofGuilt,
            Chain_DarkerThanDark, Chain_Darkgnaw, Chain_DecisivePumpkin, Chain_DestinysEmbrace, Chain_DiamondDust,
            Chain_Divewing, Chain_DivineRose, Chain_DualDisc, Chain_Earthshaker, Chain_EndofPain, Chain_EndsoftheEarth,
            Chain_FairyHarp, Chain_FairyStars, Chain_FatalCrest, Chain_Fenrir, Chain_FerrisGear, Chain_FollowtheWind,
            Chain_FrolicFlame, Chain_GlimpseofDarkness, Chain_GuardianBell, Chain_GuardianSoul, Chain_GullWing,
            Chain_HerosCrest, Chain_HiddenDragon, Chain_Hyperdrive, Chain_IncompleteKiblade, Chain_JungleKing,
            Chain_KeybladeofPeoplesHearts, Chain_Kiblade, Chain_KingdomKey, Chain_KingdomKeyD, Chain_KnockoutPunch,
            Chain_LadyLuck, Chain_LeasKeyblade, Chain_LeopardosForetellersKeyblade, Chain_Leviathan, Chain_Lionheart,
            Chain_LostMemory, Chain_LunarEclipse, Chain_MarkofaHero, Chain_MasterXehanortsKeyblade,
            Chain_MastersDefender, Chain_MaverickFlare, Chain_MetalChocobo, Chain_MidnightRoar, Chain_MirageSplit,
            Chain_MissingAche, Chain_Monochrome, Chain_MysteriousAbyss, Chain_NightmaresEnd,
            Chain_NightmaresEndandMirageSplit, Chain_NoName, Chain_Oathkeeper, Chain_Oblivion, Chain_OceansRage,
            Chain_Olympia, Chain_OmegaWeapon, Chain_OminousBlight, Chain_OneWingedAngel, Chain_PainofSolitude,
            Chain_PhotonDebugger, Chain_PixiePetal, Chain_Pumpkinhead, Chain_Rainfell, Chain_RejectionofFate,
            Chain_RoyalRadiance, Chain_RumblingRose, Chain_SignofInnocence, Chain_SilentDirge, Chain_SkullNoise,
            Chain_SleepingLion, Chain_SoulEater, Chain_Spellbinder, Chain_StarSeeker, Chain_Starlight, Chain_Stormfall,
            Chain_StrokeofMidnight, Chain_SweetDreams, Chain_SweetMemories, Chain_Sweetstack, Chain_ThreeWishes,
            Chain_TotalEclipse, Chain_TreasureTrove, Chain_TrueLightsFlight, Chain_TwilightBlaze, Chain_TwoBecomeOne,
            Chain_UltimaWeaponKH1, Chain_UltimaWeaponKH2, Chain_UltimaWeaponBBS, Chain_UltimaWeaponDDD, Chain_Umbrella,
            Chain_Unbound, Chain_UnicornisForetellersKeyblade, Chain_UrsusForetellersKeyblade, Chain_VictoryLine,
            Chain_VoidGear, Chain_VulpeusForetellersKeyblade, Chain_WaytotheDawn, Chain_WaywardWind, Chain_WinnersProof,
            Chain_WishingLamp, Chain_WishingStar, Chain_YoungXehanortsKeyblade, Chain_ZeroOne, GummiShip, Panacaea,
            DefenseBoost, MagicBoost, PowerBoost, APBoost, DriveRecovery, HighDriveRecovery, Munny, EmptyBottle, Potion,
            HiPotion, MegaPotion, Ether, MegaEther, Elixir, Megalixir, HpOrb, DriveOrb, MagicOrb, Heart, DarkHeart,
            PureHeart, KingdomHearts, DarkLeather, SynthesisMaterial, Recipe, IceCream, WinnerStick, LevelUpMagicFire,
            LevelUpMagicBlizzard, LevelUpMagicThunder, LevelUpMagicCure, LevelUpMagicAero, LevelUpMagicStop,
            LevelUpValor, LevelUpWisdom, LevelUpLimit, LevelUpMaster, LevelUpFinal, SynthesisBagS, SynthesisBagM,
            SynthesisBagL, Disc_Birth_by_Sleep_A_Link_to_the_Future, Disc_Darkness_of_the_Unknown,
            Disc_Dearly_Beloved_Symphony_Version, Disc_Dream_Drop_Distance_The_Next_Awakening,
            Disc_Hikari_KINGDOM_Instrumental_Version, Disc_L_Oscurita_Dell_Ignoto,
            Disc_Musique_pour_la_tristesse_de_Xion, Disc_No_More_Bugs_Bug_Version, Disc_Organization_XIII,
            Disc_Sanctuary, Disc_Simple_And_Clean_PLANITb_Remix, Disc_Sinister_Sundown, Disc_The_13th_Anthology,
            OrganizationRobe_Helmet, OrganizationRobe_Chestplate, OrganizationRobe_Leggings,
            OrganizationRobe_Boots, Xemnas_Helmet, Xemnas_Chestplate, Xemnas_Leggings, Xemnas_Boots, Terra_Helmet,
            Terra_Chestplate, Terra_Leggings, Terra_Boots, Aqua_Helmet, Aqua_Chestplate, Aqua_Leggings, Aqua_Boots,
            Ventus_Helmet, Ventus_Chestplate, Ventus_Leggings, Ventus_Boots, Eraqus_Helmet, Eraqus_Chestplate,
            Eraqus_Leggings, Eraqus_Boots, NightmareVentus_Helmet, NightmareVentus_Chestplate, NightmareVentus_Leggings, NightmareVentus_Boots,
            AntiCoat_Helmet, AntiCoat_Chestplate, AntiCoat_Leggings, AntiCoat_Boots,Vanitas_Helmet, Vanitas_Chestplate, Vanitas_Leggings, Vanitas_Boots
    ;

    // Armour materials
    private static ArmorMaterial ORGANIZATIONROBE = EnumHelper.addArmorMaterial("ORGANIZATIONROBE", Reference.MODID + ":organizationrobe", -1, new int[] { 3, 4, 5, 4 }, 15, SoundEvents.ITEM_ARMOR_EQUIP_LEATHER, 5);
    private static ArmorMaterial XEMNASROBE = EnumHelper.addArmorMaterial("XEMNASROBE", Reference.MODID + ":xemnasrobe", -1, new int[] { 3, 4, 5, 4 }, 15, SoundEvents.ITEM_ARMOR_EQUIP_LEATHER, 5);
    private static ArmorMaterial ANTIROBE = EnumHelper.addArmorMaterial("ANTIROBE", Reference.MODID + ":antirobe", -1, new int[] { 3, 4, 5, 4 }, 15, SoundEvents.ITEM_ARMOR_EQUIP_LEATHER, 5);

    private static ArmorMaterial TERRA = EnumHelper.addArmorMaterial("TERRA", Reference.MODID + ":terra", -1, new int[] { 4, 7, 8, 4 }, 15, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 4);
    private static ArmorMaterial AQUA = EnumHelper.addArmorMaterial("AQUA", Reference.MODID + ":aqua", -1, new int[] { 4, 7, 8, 4 }, 15, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 2);
    private static ArmorMaterial VENTUS = EnumHelper.addArmorMaterial("VENTUS", Reference.MODID + ":ventus", -1, new int[] { 4, 7, 8, 4 }, 15, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 3);
    private static ArmorMaterial ERAQUS = EnumHelper.addArmorMaterial("ERAQUS", Reference.MODID + ":eraqus", -1, new int[] { 4, 7, 8, 4 }, 15, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 5);
    private static ArmorMaterial NIGHTMAREVENTUS = EnumHelper.addArmorMaterial("NIGHTMAREVENTUSVENTUS", Reference.MODID + ":nightmareventus", -1, new int[] { 4, 7, 8, 4 }, 15, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 3);
    private static ArmorMaterial VANITAS = EnumHelper.addArmorMaterial("VANITAS", Reference.MODID + ":vanitas", -1, new int[] { 3, 4, 5, 4 }, 15, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 5);

    // Tool materials
    public static ToolMaterial KEYCHAIN = EnumHelper.addToolMaterial("KEYCHAIN", 0, 1, 0, -4, 30);

    public static CreativeTabs tabKingdomKeys = new TabKingdomKeys(CreativeTabs.getNextID(), Strings.tabKingdomKeys);

    public static final Item[] ITEMS = {
            Malice = new ItemEtherealBlade(Strings.Malice, BalanceConfig.orgweapons.malice),
            Sanction = new ItemEtherealBlade(Strings.Sanction, BalanceConfig.orgweapons.sanction),
            Overlord = new ItemEtherealBlade(Strings.Overlord, BalanceConfig.orgweapons.overlord),
            Veneration = new ItemEtherealBlade(Strings.Veneration, BalanceConfig.orgweapons.veneration),
            Autocracy = new ItemEtherealBlade(Strings.Autocracy, BalanceConfig.orgweapons.autocracy),
            Conquest = new ItemEtherealBlade(Strings.Conquest, BalanceConfig.orgweapons.conquest),
            Terminus = new ItemEtherealBlade(Strings.Terminus, BalanceConfig.orgweapons.terminus),
            Judgement = new ItemEtherealBlade(Strings.Judgement, BalanceConfig.orgweapons.judment),
            Discipline = new ItemEtherealBlade(Strings.Discipline, BalanceConfig.orgweapons.discipline),
            Aristocracy = new ItemEtherealBlade(Strings.Aristocracy, BalanceConfig.orgweapons.aristocracy),
            Superiority = new ItemEtherealBlade(Strings.Superiority, BalanceConfig.orgweapons.superiority),
            Aggression = new ItemEtherealBlade(Strings.Aggression, BalanceConfig.orgweapons.aggression),
            Fury = new ItemEtherealBlade(Strings.Fury, BalanceConfig.orgweapons.fury),
            Despair = new ItemEtherealBlade(Strings.Despair, BalanceConfig.orgweapons.despair),
            Triumph = new ItemEtherealBlade(Strings.Triumph, BalanceConfig.orgweapons.triumph),
            Ruination = new ItemEtherealBlade(Strings.Ruination, BalanceConfig.orgweapons.ruination),
            Domination = new ItemEtherealBlade(Strings.Domination, BalanceConfig.orgweapons.domination),
            Annihilation = new ItemEtherealBlade(Strings.Annihilation, BalanceConfig.orgweapons.annihilation),
            Tyrant = new ItemEtherealBlade(Strings.Tyrant, BalanceConfig.orgweapons.tyrant),
            Magnificence = new ItemEtherealBlade(Strings.Magnificence, BalanceConfig.orgweapons.magnificence),
            Infinity = new ItemEtherealBlade(Strings.Infinity, BalanceConfig.orgweapons.infinity),
            Interdiction = new ItemEtherealBlade(Strings.Interdiction, BalanceConfig.orgweapons.interdiction),
            RoundFan = new ItemEtherealBlade(Strings.RoundFan, BalanceConfig.orgweapons.roundfan),
            Absolute = new ItemEtherealBlade(Strings.Absolute, BalanceConfig.orgweapons.absolute),
            Standalone = new ItemArrowguns(Strings.Standalone, BalanceConfig.orgweapons.standalone),
            Killerbee = new ItemArrowguns(Strings.Killerbee, BalanceConfig.orgweapons.killerbee),
            Stingray = new ItemArrowguns(Strings.Stingray, BalanceConfig.orgweapons.stingray),
            Counterweight = new ItemArrowguns(Strings.Counterweight, BalanceConfig.orgweapons.counterweight),
            Precision = new ItemArrowguns(Strings.Precision, BalanceConfig.orgweapons.precision),
            DualHead = new ItemArrowguns(Strings.DualHead, BalanceConfig.orgweapons.dualhead),
            Bahamut = new ItemArrowguns(Strings.Bahamut, BalanceConfig.orgweapons.bahamut),
            Gullwing = new ItemArrowguns(Strings.Gullwing, BalanceConfig.orgweapons.gullwing),
            BlueFrame = new ItemArrowguns(Strings.BlueFrame, BalanceConfig.orgweapons.blueframe),
            StarShell = new ItemArrowguns(Strings.StarShell, BalanceConfig.orgweapons.starshell),
            Sunrise = new ItemArrowguns(Strings.Sunrise, BalanceConfig.orgweapons.sunrise),
            Ignition = new ItemArrowguns(Strings.Ignition, BalanceConfig.orgweapons.ignition),
            Armstrong = new ItemArrowguns(Strings.Armstrong, BalanceConfig.orgweapons.armstrong),
            HardBoiledHeat = new ItemArrowguns(Strings.HardBoiledHeat, BalanceConfig.orgweapons.hardboiledheat),
            DiabloEye = new ItemArrowguns(Strings.DiabloEye, BalanceConfig.orgweapons.diabloeye),
            DoubleTap = new ItemArrowguns(Strings.DoubleTap, BalanceConfig.orgweapons.doubletrap),
            Stardust = new ItemArrowguns(Strings.Stardust, BalanceConfig.orgweapons.stardust),
            EnergyMuzzle = new ItemArrowguns(Strings.EnergyMuzzle, BalanceConfig.orgweapons.energymuzzle),
            CrimeAndPunishment = new ItemArrowguns(Strings.CrimeAndPunishment, BalanceConfig.orgweapons.crimeandpunishment),
            CupidsArrow = new ItemArrowguns(Strings.CupidsArrow, BalanceConfig.orgweapons.cupidsarrow),
            FinalWeapon = new ItemArrowguns(Strings.FinalWeapon, BalanceConfig.orgweapons.finalweapon),
            Sharpshooter = new ItemArrowguns(Strings.Sharpshooter, BalanceConfig.orgweapons.sharpshooter),
            Dryer = new ItemArrowguns(Strings.Dryer, BalanceConfig.orgweapons.dryer),
            Trumpet = new ItemArrowguns(Strings.Trumpet, BalanceConfig.orgweapons.trumpet),
            Zephyr = new ItemLances(Strings.Zephyr, BalanceConfig.orgweapons.zephyr),
            Moonglade = new ItemLances(Strings.Moonglade, BalanceConfig.orgweapons.moonglade),
            Aer = new ItemLances(Strings.Aer, BalanceConfig.orgweapons.aer),
            Nescience = new ItemLances(Strings.Nescience, BalanceConfig.orgweapons.nescience),
            Brume = new ItemLances(Strings.Brume, BalanceConfig.orgweapons.brume),
            Asura = new ItemLances(Strings.Asura, BalanceConfig.orgweapons.asura),
            Crux = new ItemLances(Strings.Crux, BalanceConfig.orgweapons.crux),
            Paladin = new ItemLances(Strings.Paladin, BalanceConfig.orgweapons.paladin),
            Fellking = new  ItemLances(Strings.Fellking, BalanceConfig.orgweapons.fellking),
            Nightcloud = new ItemLances(Strings.Nightcloud, BalanceConfig.orgweapons.nightcloud),
            Shimmer = new ItemLances(Strings.Shimmer, BalanceConfig.orgweapons.shimmer),
            Vortex = new ItemLances(Strings.Vortex, BalanceConfig.orgweapons.vortex),
            Scission = new ItemLances(Strings.Scission, BalanceConfig.orgweapons.scission),
            Heavenfall = new  ItemLances(Strings.Heavenfall, BalanceConfig.orgweapons.heavenfall),
            Aether = new ItemLances(Strings.Aether, BalanceConfig.orgweapons.aether),
            Mazzaroth = new ItemLances(Strings.Mazzaroth, BalanceConfig.orgweapons.mazzaroth),
            Hegemon = new ItemLances(Strings.Hegemon, BalanceConfig.orgweapons.hegemon),
            Foxfire = new ItemLances(Strings.Foxfire, BalanceConfig.orgweapons.foxfire),
            Yaksha = new ItemLances(Strings.Yaksha, BalanceConfig.orgweapons.yaksha),
            Cynosura = new ItemLances(Strings.Cynosura, BalanceConfig.orgweapons.cynosura),
            Dragonreign = new ItemLances(Strings.Dragonreign, BalanceConfig.orgweapons.dragonreign),
            Lindworm = new ItemLances(Strings.Lindworm, BalanceConfig.orgweapons.lindworm),
            Broom = new ItemLances(Strings.Broom, BalanceConfig.orgweapons.broom),
            Wyvern = new ItemLances(Strings.Wyvern, BalanceConfig.orgweapons.wyvern),
            TesterZero = new ItemOrgShield(Strings.TesterZero, BalanceConfig.orgweapons.testerzero),
            ProductOne = new ItemOrgShield(Strings.ProductOne, BalanceConfig.orgweapons.productone),
            DeepFreeze = new ItemOrgShield(Strings.DeepFreeze, BalanceConfig.orgweapons.deepfreeze),
            CryoliteShield = new ItemOrgShield(Strings.CryoliteShield, BalanceConfig.orgweapons.cryoliteshield),
            FalseTheory = new ItemOrgShield(Strings.FalseTheory, BalanceConfig.orgweapons.falsetheory),
            Glacier = new ItemOrgShield(Strings.Glacier, BalanceConfig.orgweapons.glacier),
            AbsoluteZero = new ItemOrgShield(Strings.AbsoluteZero, BalanceConfig.orgweapons.absolutezero),
            Gunz = new ItemOrgShield(Strings.Gunz, BalanceConfig.orgweapons.gunz),
            Mindel = new ItemOrgShield(Strings.Mindel, BalanceConfig.orgweapons.mindel),
            Snowslide = new ItemOrgShield(Strings.Snowslide, BalanceConfig.orgweapons.snowslide),
            Iceberg = new ItemOrgShield(Strings.Iceberg, BalanceConfig.orgweapons.iceberg),
            Inquisition = new ItemOrgShield(Strings.Inquisition, BalanceConfig.orgweapons.inquisition),
            Scrutiny = new ItemOrgShield(Strings.Scrutiny, BalanceConfig.orgweapons.scrutiny),
            Empiricism = new ItemOrgShield(Strings.Empiricism, BalanceConfig.orgweapons.empiricism),
            Edification = new ItemOrgShield(Strings.Edification, BalanceConfig.orgweapons.edification),
            Contrivance = new ItemOrgShield(Strings.Contrivance, BalanceConfig.orgweapons.contrivance),
            Wurm = new ItemOrgShield(Strings.Wurm, BalanceConfig.orgweapons.wurm),
            Subzero = new ItemOrgShield(Strings.Subzero, BalanceConfig.orgweapons.subzero),
            ColdBlood = new ItemOrgShield(Strings.ColdBlood, BalanceConfig.orgweapons.coldblood),
            DiamondShield = new ItemOrgShield(Strings.DiamondShield, BalanceConfig.orgweapons.diamondshield),
            Aegis = new ItemOrgShield(Strings.Aegis, BalanceConfig.orgweapons.aegis),
            FrozenPride = new ItemOrgShield(Strings.FrozenPride, BalanceConfig.orgweapons.frozenpride),
            PotLid = new ItemOrgShield(Strings.PotLid, BalanceConfig.orgweapons.potlid),
            Snowman = new ItemOrgShield(Strings.Snowman, BalanceConfig.orgweapons.snowman),
            Reticence = new ItemAxeSword(Strings.Reticence, BalanceConfig.orgweapons.reticence),
            Goliath = new ItemAxeSword(Strings.Goliath, BalanceConfig.orgweapons.goliath),
            CopperRed = new ItemAxeSword(Strings.CopperRed, BalanceConfig.orgweapons.copperred),
            Daybreak = new ItemAxeSword(Strings.Daybreak, BalanceConfig.orgweapons.daybreak),
            Colossus = new ItemAxeSword(Strings.Colossus, BalanceConfig.orgweapons.colossus),
            UrsaMajor = new ItemAxeSword(Strings.UrsaMajor, BalanceConfig.orgweapons.ursamajor),
            Megacosm = new ItemAxeSword(Strings.Megacosm, BalanceConfig.orgweapons.megacosm),
            Terrene = new ItemAxeSword(Strings.Terrene, BalanceConfig.orgweapons.terrene),
            Fuligin = new ItemAxeSword(Strings.Fuligin, BalanceConfig.orgweapons.fuligin),
            HardWinter = new ItemAxeSword(Strings.HardWinter, BalanceConfig.orgweapons.hardwinter),
            Firefly = new ItemAxeSword(Strings.Firefly, BalanceConfig.orgweapons.firefly),
            Harbinger = new ItemAxeSword(Strings.Harbinger, BalanceConfig.orgweapons.harbinger),
            Redwood = new ItemAxeSword(Strings.Redwood, BalanceConfig.orgweapons.redwood),
            Sequoia = new ItemAxeSword(Strings.Sequoia, BalanceConfig.orgweapons.sequoia),
            IronBlack = new ItemAxeSword(Strings.IronBlack, BalanceConfig.orgweapons.ironblack),
            Earthshine = new ItemAxeSword(Strings.Earthshine, BalanceConfig.orgweapons.earthshine),
            Octiron = new ItemAxeSword(Strings.Octiron, BalanceConfig.orgweapons.octiron),
            Hyperion = new ItemAxeSword(Strings.Hyperion, BalanceConfig.orgweapons.hyperion),
            Clarity = new ItemAxeSword(Strings.Clarity ,BalanceConfig.orgweapons.clarity),
            OneThousandAndOneNights = new ItemAxeSword(Strings.OneThousandAndOneNights, BalanceConfig.orgweapons.onethousandandonenights),
            CardinalVirtue = new ItemAxeSword(Strings.CardinalVirtue, BalanceConfig.orgweapons.cardinalvirtue),
            Skysplitter = new ItemAxeSword(Strings.Skysplitter, BalanceConfig.orgweapons.skysplitter),
            BleepBloopBop = new ItemAxeSword(Strings.BleepBloopBop, BalanceConfig.orgweapons.bleepbloopbop),
            Monolith = new ItemAxeSword(Strings.Monolith, BalanceConfig.orgweapons.monolith),
            BlackPrimer = new ItemLexicon(Strings.BlackPrimer, BalanceConfig.orgweapons.blackprimer),
            WhiteTome = new ItemLexicon(Strings.WhiteTome, BalanceConfig.orgweapons.whitetome),
            IllicitResearch = new ItemLexicon(Strings.IllicitResearch, BalanceConfig.orgweapons.illicitresearch),
            BuriedSecrets = new ItemLexicon(Strings.BuriedSecrets, BalanceConfig.orgweapons.buriedsecrets),
            ArcaneCompendium = new ItemLexicon(Strings.ArcaneCompendium, BalanceConfig.orgweapons.arcanecompendium),
            DissentersNotes = new ItemLexicon(Strings.DissentersNotes, BalanceConfig.orgweapons.dissentersnotes),
            NefariousCodex = new ItemLexicon(Strings.NefariousCodex, BalanceConfig.orgweapons.nefariouscodex),
            MysticAlbum = new ItemLexicon(Strings.MysticAlbum, BalanceConfig.orgweapons.mysticalbum),
            CursedManual = new ItemLexicon(Strings.CursedManual, BalanceConfig.orgweapons.cursedmanual),
            TabooText = new ItemLexicon(Strings.TabooText, BalanceConfig.orgweapons.tabootext),
            EldritchEsoterica = new ItemLexicon(Strings.EldritchEsoterica, BalanceConfig.orgweapons.eldritchesoterica),
            FreakishBestiary = new ItemLexicon(Strings.FreakishBestiary, BalanceConfig.orgweapons.freakishbestiary),
            MadmansVita = new ItemLexicon(Strings.MadmansVita, BalanceConfig.orgweapons.madmansvita),
            UntitledWritings = new ItemLexicon(Strings.UntitledWritings, BalanceConfig.orgweapons.untitledwritings),
            AbandonedDogma = new ItemLexicon(Strings.AbandonedDogma, BalanceConfig.orgweapons.abandoneddogma),
            AtlasOfOmens = new ItemLexicon(Strings.AtlasOfOmens, BalanceConfig.orgweapons.atlasofomens),
            RevoltingScrapbook = new ItemLexicon(Strings.RevoltingScrapbook, BalanceConfig.orgweapons.revoltingscrapbook),
            LostHeterodoxy = new ItemLexicon(Strings.LostHeterodoxy, BalanceConfig.orgweapons.lostheterodoxy),
            OtherworldlyTales = new ItemLexicon(Strings.OtherworldlyTales, BalanceConfig.orgweapons.otherworldlytales),
            IndescribableLore = new ItemLexicon(Strings.IndescribableLore, BalanceConfig.orgweapons.indescribablelore),
            RadicalTreatise = new ItemLexicon(Strings.RadicalTreatise, BalanceConfig.orgweapons.radicaltreatise),
            BookofRetribution = new ItemLexicon(Strings.BookofRetribution, BalanceConfig.orgweapons.bookofretribution),
            MidnightSnack = new ItemLexicon(Strings.MidnightSnack, BalanceConfig.orgweapons.midnightsnack),
            DearDiary = new ItemLexicon(Strings.DearDiary, BalanceConfig.orgweapons.deardiary),
            NewMoon = new ItemClaymore(Strings.NewMoon, BalanceConfig.orgweapons.newmoon),
            Werewolf = new ItemClaymore(Strings.Werewolf, BalanceConfig.orgweapons.werewolf),
            Artemis = new ItemClaymore(Strings.Artemis, BalanceConfig.orgweapons.artemis),
            Luminary = new ItemClaymore(Strings.Luminary, BalanceConfig.orgweapons.luminary),
            Selene = new ItemClaymore(Strings.Selene, BalanceConfig.orgweapons.selene),
            Moonrise = new ItemClaymore(Strings.Moonrise, BalanceConfig.orgweapons.moonrise),
            Astrologia = new ItemClaymore(Strings.Astrologia, BalanceConfig.orgweapons.astrologia),
            Crater = new ItemClaymore(Strings.Crater, BalanceConfig.orgweapons.crater),
            LunarPhase = new ItemClaymore(Strings.LunarPhase, BalanceConfig.orgweapons.lunarphase),
            Crescent = new ItemClaymore(Strings.Crescent, BalanceConfig.orgweapons.crescent),
            Gibbous = new ItemClaymore(Strings.Gibbous, BalanceConfig.orgweapons.gibbous),
            Berserker = new ItemClaymore(Strings.Berserker, BalanceConfig.orgweapons.berseker),
            Twilight = new ItemClaymore(Strings.Twilight, BalanceConfig.orgweapons.twilight),
            QueenOfTheNight = new ItemClaymore(Strings.QueenOfTheNight, BalanceConfig.orgweapons.queenofthenight),
            BalsamicMoon = new ItemClaymore(Strings.BalsamicMoon, BalanceConfig.orgweapons.balsamicmoon),
            Orbit = new ItemClaymore(Strings.Orbit, BalanceConfig.orgweapons.orbit),
            LightYear = new ItemClaymore(Strings.LightYear, BalanceConfig.orgweapons.lightyear),
            KingOfTheNight = new ItemClaymore(Strings.KingOfTheNight, BalanceConfig.orgweapons.kingofthenight),
            Moonset = new ItemClaymore(Strings.Moonset, BalanceConfig.orgweapons.moonset),
            Horoscope = new ItemClaymore(Strings.Horoscope, BalanceConfig.orgweapons.horoscope),
            Dichotomy = new ItemClaymore(Strings.Dichotomy, BalanceConfig.orgweapons.dichotomy),
            Lunatic = new ItemClaymore(Strings.Lunatic, BalanceConfig.orgweapons.lunatic),
            JustDesserts = new ItemClaymore(Strings.JustDesserts, BalanceConfig.orgweapons.justdesserts),
            Bunnymoon = new ItemClaymore(Strings.Bunnymoon, BalanceConfig.orgweapons.bunnymoon),
            Ashes = new ItemChakram(Strings.Ashes, BalanceConfig.orgweapons.ashes),
            Doldrums = new ItemChakram(Strings.Doldrums, BalanceConfig.orgweapons.doldrums),
            DelayedAction = new ItemChakram(Strings.DelayedAction, BalanceConfig.orgweapons.delayedaction),
            DiveBombers = new ItemChakram(Strings.DiveBombers, BalanceConfig.orgweapons.divebombers),
            Combustion = new ItemChakram(Strings.Combustion, BalanceConfig.orgweapons.combustion),
            MoulinRouge = new ItemChakram(Strings.MoulinRouge, BalanceConfig.orgweapons.moulinrouge),
            BlazeofGlory = new ItemChakram(Strings.BlazeofGlory, BalanceConfig.orgweapons.blazeofglory),
            Prometheus = new ItemChakram(Strings.Prometheus, BalanceConfig.orgweapons.prometheus),
            Ifrit = new ItemChakram(Strings.Ifrit, BalanceConfig.orgweapons.ifrit),
            MagmaOcean = new ItemChakram(Strings.MagmaOcean, BalanceConfig.orgweapons.magmaocean),
            Volcanics = new ItemChakram(Strings.Volcanics, BalanceConfig.orgweapons.volcanics),
            Inferno = new ItemChakram(Strings.Inferno, BalanceConfig.orgweapons.inferno),
            SizzlingEdge = new ItemChakram(Strings.SizzlingEdge, BalanceConfig.orgweapons.sizzlingedge),
            Corona = new ItemChakram(Strings.Corona, BalanceConfig.orgweapons.corona),
            FerrisWheel = new ItemChakram(Strings.FerrisWheel, BalanceConfig.orgweapons.ferriswheel),
            Burnout = new ItemChakram(Strings.Burnout, BalanceConfig.orgweapons.burnout),
            OmegaTrinity = new ItemChakram(Strings.OmegaTrinity, BalanceConfig.orgweapons.omegatrinity),
            Outbreak = new ItemChakram(Strings.Outbreak, BalanceConfig.orgweapons.outbreak),
            DoubleEdge = new ItemChakram(Strings.DoubleEdge, BalanceConfig.orgweapons.doubleedge),
            Wildfire = new ItemChakram(Strings.Wildfire,BalanceConfig.orgweapons.wildfire),
            Prominence = new ItemChakram(Strings.Prominence, BalanceConfig.orgweapons.prominence),
            EternalFlames = new ItemChakram(Strings.EternalFlames, BalanceConfig.orgweapons.eternalflames),
            PizzaCut = new ItemChakram(Strings.PizzaCut, BalanceConfig.orgweapons.pizzacut),
            Conformers = new ItemChakram(Strings.Conformers, BalanceConfig.orgweapons.conformers),
            BasicModel = new ItemSitar(Strings.BasicModel, BalanceConfig.orgweapons.basicmodel),
            TuneUp = new ItemSitar(Strings.TuneUp, BalanceConfig.orgweapons.tuneup),
            Quartet = new ItemSitar(Strings.Quartet, BalanceConfig.orgweapons.quartet),
            Quintet = new ItemSitar(Strings.Quintet, BalanceConfig.orgweapons.quintet),
            Overture = new ItemSitar(Strings.Overture, BalanceConfig.orgweapons.overture),
            OldHand = new ItemSitar(Strings.OldHand, BalanceConfig.orgweapons.oldhand),
            DaCapo = new ItemSitar(Strings.DaCapo, BalanceConfig.orgweapons.dacapo),
            PowerChord = new ItemSitar(Strings.PowerChord, BalanceConfig.orgweapons.powerchord),
            Fermata = new ItemSitar(Strings.Fermata, BalanceConfig.orgweapons.fermata),
            Interlude = new ItemSitar(Strings.Interlude, BalanceConfig.orgweapons.interlude),
            Serenade = new ItemSitar(Strings.Serenade, BalanceConfig.orgweapons.serenade),
            Songbird = new ItemSitar(Strings.Songbird, BalanceConfig.orgweapons.songbird),
            RiseToFame = new ItemSitar(Strings.RiseToFame, BalanceConfig.orgweapons.risetofame),
            RockStar = new ItemSitar(Strings.RockStar, BalanceConfig.orgweapons.rockstar),
            EightFinger = new ItemSitar(Strings.EightFinger, BalanceConfig.orgweapons.eightfinger),
            Concerto = new ItemSitar(Strings.Concerto, BalanceConfig.orgweapons.concierto),
            Harmonics = new ItemSitar(Strings.Harmonics, BalanceConfig.orgweapons.harmonics),
            MillionBucks = new ItemSitar(Strings.MillionBucks, BalanceConfig.orgweapons.millionbucks),
            Fortissimo = new ItemSitar(Strings.Fortissimo, BalanceConfig.orgweapons.fortissimo),
            UpToEleven = new ItemSitar(Strings.UpToEleven, BalanceConfig.orgweapons.uptoeleven),
            Sanctuary = new ItemSitar(Strings.Sanctuary, BalanceConfig.orgweapons.sanctuary),
            Arpeggio = new ItemSitar(Strings.Arpeggio, BalanceConfig.orgweapons.arpeggio),
            PrinceOfAwesome = new ItemSitar(Strings.PrinceOfAwesome, BalanceConfig.orgweapons.princeofawesome),
            AfterSchool = new ItemSitar(Strings.AfterSchool, BalanceConfig.orgweapons.afterschool),
            TheFool = new ItemCard(Strings.TheFool, BalanceConfig.orgweapons.thefool),
            TheMagician = new ItemCard(Strings.TheMagician, BalanceConfig.orgweapons.themagician),
            TheStar = new ItemCard(Strings.TheStar, BalanceConfig.orgweapons.thestar),
            TheMoon = new ItemCard(Strings.TheMoon, BalanceConfig.orgweapons.themoon),
            Justice = new ItemCard(Strings.Justice, BalanceConfig.orgweapons.justice),
            TheHierophant = new ItemCard(Strings.TheHierophant, BalanceConfig.orgweapons.thehierophant),
            TheWorld = new ItemCard(Strings.TheWorld, BalanceConfig.orgweapons.theworld),
            Temperance = new ItemCard(Strings.Temperance, BalanceConfig.orgweapons.temperance),
            TheHighPriestess = new ItemCard(Strings.TheHighPriestess, BalanceConfig.orgweapons.thehighpriestess),
            TheTower = new ItemCard(Strings.TheTower, BalanceConfig.orgweapons.thetower),
            TheHangedMan = new ItemCard(Strings.TheHangedMan, BalanceConfig.orgweapons.thehangedman),
            Death = new ItemCard(Strings.Death, BalanceConfig.orgweapons.death),
            TheHermit = new ItemCard(Strings.TheHermit, BalanceConfig.orgweapons.thehermit),
            Strength = new ItemCard(Strings.Strength, BalanceConfig.orgweapons.strength),
            TheLovers = new ItemCard(Strings.TheLovers, BalanceConfig.orgweapons.thelovers),
            TheChariot = new ItemCard(Strings.TheChariot, BalanceConfig.orgweapons.thechariot),
            TheSun = new ItemCard(Strings.TheSun, BalanceConfig.orgweapons.thesun),
            TheDevil = new ItemCard(Strings.TheDevil, BalanceConfig.orgweapons.themoon),
            TheEmpress = new ItemCard(Strings.TheEmpress, BalanceConfig.orgweapons.theempress),
            TheEmperor = new ItemCard(Strings.TheEmperor, BalanceConfig.orgweapons.theemperor),
            TheJoker = new ItemCard(Strings.TheJoker, BalanceConfig.orgweapons.thejoker),
            FairGame = new ItemCard(Strings.FairGame, BalanceConfig.orgweapons.fairgame),
            FinestFantasy13 = new ItemCard(Strings.FinestFantasy13, BalanceConfig.orgweapons.finestfantasy13),
            HighRollersSecret = new ItemCard(Strings.HighRollersSecret, BalanceConfig.orgweapons.highrollerssecret),
            FickleErica = new ItemScythe(Strings.FickleErica, BalanceConfig.orgweapons.fickleerica),
            JiltedAnemone = new ItemScythe(Strings.JiltedAnemone, BalanceConfig.orgweapons.jiltedanemone),
            ProudAmaryllis = new ItemScythe(Strings.ProudAmaryllis, BalanceConfig.orgweapons.proudamaryllis),
            MadSafflower = new ItemScythe(Strings.MadSafflower, BalanceConfig.orgweapons.madsafflower),
            PoorMelissa = new ItemScythe(Strings.PoorMelissa, BalanceConfig.orgweapons.poormelissa),
            TragicAllium = new ItemScythe(Strings.TragicAllium, BalanceConfig.orgweapons.tragicallium),
            MournfulCineria = new ItemScythe(Strings.MournfulCineria, BalanceConfig.orgweapons.mournfulcineria),
            PseudoSilene = new ItemScythe(Strings.PseudoSilene, BalanceConfig.orgweapons.pseudosilene),
            FaithlessDigitalis = new ItemScythe(Strings.FaithlessDigitalis, BalanceConfig.orgweapons.faithlessdigitalis),
            GrimMuscari = new ItemScythe(Strings.GrimMuscari, BalanceConfig.orgweapons.grimmuscari),
            DocileVallota = new ItemScythe(Strings.DocileVallota, BalanceConfig.orgweapons.docilevallota),
            QuietBelladonna = new ItemScythe(Strings.QuietBelladonna, BalanceConfig.orgweapons.quietbelladonna),
            PartingIpheion = new ItemScythe(Strings.PartingIpheion, BalanceConfig.orgweapons.partingipheion),
            LoftyGerbera = new ItemScythe(Strings.LoftyGerbera, BalanceConfig.orgweapons.loftygerbera),
            GallantAchillea = new ItemScythe(Strings.GallantAchillea, BalanceConfig.orgweapons.gallantachillea),
            NoblePeony = new ItemScythe(Strings.NoblePeony, BalanceConfig.orgweapons.noblepeony),
            FearsomeAnise = new ItemScythe(Strings.FearsomeAnise, BalanceConfig.orgweapons.fearsomeanise),
            VindictiveThistle = new ItemScythe(Strings.VindictiveThistle, BalanceConfig.orgweapons.vindictivethistle),
            FairHelianthus = new ItemScythe(Strings.FairHelianthus, BalanceConfig.orgweapons.fairhelianthus),
            SolemnMagnolia = new ItemScythe(Strings.SolemnMagnolia, BalanceConfig.orgweapons.solemnmagnolia),
            HallowedLotus = new ItemScythe(Strings.HallowedLotus, BalanceConfig.orgweapons.hallowedlotus),
            GracefulDahlia = new ItemScythe(Strings.GracefulDahlia, BalanceConfig.orgweapons.gracefuldahlia),
            StirringLadle = new ItemScythe(Strings.StirringLadle, BalanceConfig.orgweapons.stirringladle),
            DaintyBellflowers = new ItemScythe(Strings.DaintyBellflowers, BalanceConfig.orgweapons.daintybellflowers),
            Trancheuse = new ItemKnife(Strings.Trancheuse, BalanceConfig.orgweapons.trancheuse),
            Orage = new ItemKnife(Strings.Orage, BalanceConfig.orgweapons.orage),
            Tourbillon = new ItemKnife(Strings.Tourbillon, BalanceConfig.orgweapons.tourbillon),
            Tempete = new ItemKnife(Strings.Tempete, BalanceConfig.orgweapons.tempete),
            Carmin = new ItemKnife(Strings.Carmin, BalanceConfig.orgweapons.carmin),
            Meteore = new ItemKnife(Strings.Meteore, BalanceConfig.orgweapons.meteore),
            Etoile = new ItemKnife(Strings.Etoile, BalanceConfig.orgweapons.etoile),
            Irregulier = new ItemKnife(Strings.Irregulier, BalanceConfig.orgweapons.irregulier),
            Dissonance = new ItemKnife(Strings.Dissonance, BalanceConfig.orgweapons.dissonance),
            Eruption = new ItemKnife(Strings.Eruption, BalanceConfig.orgweapons.eruption),
            SoleilCouchant = new ItemKnife(Strings.SoleilCouchant, BalanceConfig.orgweapons.soleilcouchant),
            Indigo = new ItemKnife(Strings.Indigo, BalanceConfig.orgweapons.indigo),
            Vague = new ItemKnife(Strings.Vague, BalanceConfig.orgweapons.vague),
            Deluge = new ItemKnife(Strings.Deluge, BalanceConfig.orgweapons.deluge),
            Rafale = new ItemKnife(Strings.Rafale, BalanceConfig.orgweapons.rafale),
            Typhon = new ItemKnife(Strings.Typhon, BalanceConfig.orgweapons.typhon),
            Extirpeur = new ItemKnife(Strings.Extirpeur, BalanceConfig.orgweapons.extirpeur),
            CroixDuSud = new ItemKnife(Strings.CroixDuSud, BalanceConfig.orgweapons.croixdusud),
            Lumineuse = new ItemKnife(Strings.Lumineuse, BalanceConfig.orgweapons.lumineuse),
            ClairdeLune = new ItemKnife(Strings.ClairdeLune, BalanceConfig.orgweapons.clairdelune),
            VoldeNuit = new ItemKnife(Strings.VoldeNuit, BalanceConfig.orgweapons.voldenuit),
            Foudre = new ItemKnife(Strings.Foudre, BalanceConfig.orgweapons.foudre),
            Demoiselle = new ItemKnife(Strings.Demoiselle, BalanceConfig.orgweapons.demoiselle),
            Ampoule = new ItemKnife(Strings.Ampoule, BalanceConfig.orgweapons.ampoule),
            DreamShield = new ItemOrgShield(Strings.DreamShield, BalanceConfig.other.dreamShield),
            
            AbaddonPlasma = new ItemRealKeyblade(Strings.AbaddonPlasma, BalanceConfig.keyblades.abaddonPlasma[0], BalanceConfig.keyblades.abaddonPlasma[1]),
            AbyssalTide = new ItemRealKeyblade(Strings.AbyssalTide, BalanceConfig.keyblades.abyssalTide[0], BalanceConfig.keyblades.abyssalTide[1]),
            AllforOne = new ItemRealKeyblade(Strings.AllforOne, BalanceConfig.keyblades.allForOne[0], BalanceConfig.keyblades.allForOne[1]),
            AnguisForetellersKeyblade = new ItemRealKeyblade(Strings.AnguisForetellersKeyblade, BalanceConfig.keyblades.anguisForetellersKeyblade[0], BalanceConfig.keyblades.anguisForetellersKeyblade[1]),
            AstralBlast = new ItemRealKeyblade(Strings.AstralBlast, BalanceConfig.keyblades.astralBlast[0], BalanceConfig.keyblades.astralBlast[1]),
            Aubade = new ItemRealKeyblade(Strings.Aubade, BalanceConfig.keyblades.aubade[0], BalanceConfig.keyblades.aubade[1]),
            BondofFlame = new ItemRealKeyblade(Strings.BondofFlame, BalanceConfig.keyblades.bondofFlame[0], BalanceConfig.keyblades.bondofFlame[1], ModAbilities.fireBoost),
            Brightcrest = new ItemRealKeyblade(Strings.Brightcrest, BalanceConfig.keyblades.brightcrest[0], BalanceConfig.keyblades.brightcrest[1]),
            ChaosRipper = new ItemRealKeyblade(Strings.ChaosRipper, BalanceConfig.keyblades.chaosRipper[0], BalanceConfig.keyblades.chaosRipper[1]),
            CircleofLife = new ItemRealKeyblade(Strings.CircleofLife, BalanceConfig.keyblades.circleofLife[0], BalanceConfig.keyblades.circleofLife[1], ModAbilities.mpHaste),
            Counterpoint = new ItemRealKeyblade(Strings.Counterpoint, BalanceConfig.keyblades.counterpoint[0], BalanceConfig.keyblades.counterpoint[1]),
            Crabclaw = new ItemRealKeyblade(Strings.Crabclaw, BalanceConfig.keyblades.crabclaw[0], BalanceConfig.keyblades.crabclaw[1]),
            CrownofGuilt = new ItemRealKeyblade(Strings.CrownofGuilt, BalanceConfig.keyblades.crownofGuilt[0], BalanceConfig.keyblades.crownofGuilt[1]),
            DarkerThanDark = new ItemRealKeyblade(Strings.DarkerThanDark, BalanceConfig.keyblades.darkerthanDark[0], BalanceConfig.keyblades.darkerthanDark[1]),
            Darkgnaw = new ItemRealKeyblade(Strings.Darkgnaw, BalanceConfig.keyblades.darkgnaw[0], BalanceConfig.keyblades.darkgnaw[1]),
            DecisivePumpkin = new ItemRealKeyblade(Strings.DecisivePumpkin, BalanceConfig.keyblades.decisivePumpkin[0], BalanceConfig.keyblades.decisivePumpkin[1], ModAbilities.comboBoost),
            DestinysEmbrace = new ItemRealKeyblade(Strings.DestinysEmbrace, BalanceConfig.keyblades.destinysEmbrace[0], BalanceConfig.keyblades.destinysEmbrace[1]),
            DiamondDust = new ItemRealKeyblade(Strings.DiamondDust, BalanceConfig.keyblades.diamondDust[0], BalanceConfig.keyblades.diamondDust[1]),
            Divewing = new ItemRealKeyblade(Strings.Divewing, BalanceConfig.keyblades.divewing[0], BalanceConfig.keyblades.divewing[1]),
            DivineRose = new ItemRealKeyblade(Strings.DivineRose, BalanceConfig.keyblades.divineRose[0], BalanceConfig.keyblades.divineRose[1]),
            DreamStaff = new ItemKeyblade(Strings.DreamStaff, BalanceConfig.other.dreamStaff[0], BalanceConfig.other.dreamStaff[1]),
            DreamSword = new ItemKeyblade(Strings.DreamSword, BalanceConfig.other.dreamSword[0], BalanceConfig.other.dreamSword[1]),
            DualDisc = new ItemRealKeyblade(Strings.DualDisc, BalanceConfig.keyblades.dualDisc[0], BalanceConfig.keyblades.dualDisc[1]),
            Earthshaker = new ItemRealKeyblade(Strings.Earthshaker, BalanceConfig.keyblades.earthshaker[0], BalanceConfig.keyblades.earthshaker[1]),
            EndofPain = new ItemRealKeyblade(Strings.EndofPain, BalanceConfig.keyblades.endofPain[0], BalanceConfig.keyblades.endofPain[1]),
            EndsoftheEarth = new ItemRealKeyblade(Strings.EndsoftheEarth, BalanceConfig.keyblades.endsoftheEarth[0], BalanceConfig.keyblades.endsoftheEarth[1]),
            FairyHarp = new ItemRealKeyblade(Strings.FairyHarp, BalanceConfig.keyblades.fairyHarp[0], BalanceConfig.keyblades.fairyHarp[1]),
            FairyStars = new ItemRealKeyblade(Strings.FairyStars, BalanceConfig.keyblades.fairyStars[0], BalanceConfig.keyblades.fairyStars[1]),
            FatalCrest = new ItemRealKeyblade(Strings.FatalCrest, BalanceConfig.keyblades.fatalCrest[0], BalanceConfig.keyblades.fatalCrest[1], ModAbilities.berserkCharge),
            Fenrir = new ItemRealKeyblade(Strings.Fenrir, BalanceConfig.keyblades.fenrir[0], BalanceConfig.keyblades.fenrir[1], ModAbilities.negativeCombo),
            FerrisGear = new ItemRealKeyblade(Strings.FerrisGear, BalanceConfig.keyblades.ferrisGear[0], BalanceConfig.keyblades.ferrisGear[1]),
            FollowtheWind = new ItemRealKeyblade(Strings.FollowtheWind, BalanceConfig.keyblades.followtheWind[0], BalanceConfig.keyblades.followtheWind[1], ModAbilities.draw),
            FrolicFlame = new ItemRealKeyblade(Strings.FrolicFlame, BalanceConfig.keyblades.frolicFlame[0], BalanceConfig.keyblades.frolicFlame[1]),
            GlimpseofDarkness = new ItemRealKeyblade(Strings.GlimpseofDarkness, BalanceConfig.keyblades.glimpseofDarkness[0], BalanceConfig.keyblades.glimpseofDarkness[1]),
            GuardianBell = new ItemRealKeyblade(Strings.GuardianBell, BalanceConfig.keyblades.guardianBell[0], BalanceConfig.keyblades.guardianBell[1]),
            GuardianSoul = new ItemRealKeyblade(Strings.GuardianSoul, BalanceConfig.keyblades.guardianSoul[0], BalanceConfig.keyblades.guardianSoul[1], ModAbilities.reactionBoost),
            GullWing = new ItemRealKeyblade(Strings.GullWing, BalanceConfig.keyblades.gullWing[0], BalanceConfig.keyblades.gullWing[1], ModAbilities.experienceBoost),
            HerosCrest = new ItemRealKeyblade(Strings.HerosCrest, BalanceConfig.keyblades.herosCrest[0], BalanceConfig.keyblades.herosCrest[1], ModAbilities.airComboBoost),
            HiddenDragon = new ItemRealKeyblade(Strings.HiddenDragon, BalanceConfig.keyblades.hiddenDragon[0], BalanceConfig.keyblades.hiddenDragon[1], ModAbilities.mpRage),
            Hyperdrive = new ItemRealKeyblade(Strings.Hyperdrive, BalanceConfig.keyblades.hyperdrive[0], BalanceConfig.keyblades.hyperdrive[1]),
            IncompleteKiblade = new ItemRealKeyblade(Strings.IncompleteKiblade, BalanceConfig.keyblades.incompletexblade[0], BalanceConfig.keyblades.incompletexblade[1]),
            JungleKing = new ItemRealKeyblade(Strings.JungleKing, BalanceConfig.keyblades.jungleKing[0], BalanceConfig.keyblades.jungleKing[1]),
            KeybladeofPeoplesHearts = new ItemRealKeyblade(Strings.KeybladeofPeoplesHearts, BalanceConfig.keyblades.keybladeofPeoplesHearts[0], BalanceConfig.keyblades.keybladeofPeoplesHearts[1]),
            Kiblade = new ItemRealKeyblade(Strings.Kiblade, BalanceConfig.keyblades.xblade[0], BalanceConfig.keyblades.xblade[1]),
            KingdomKey = new ItemRealKeyblade(Strings.KingdomKey, BalanceConfig.keyblades.kingdomKey[0], BalanceConfig.keyblades.kingdomKey[1], ModAbilities.damageControl),
            KingdomKeyD = new ItemRealKeyblade(Strings.KingdomKeyD, BalanceConfig.keyblades.kingdomKeyD[0], BalanceConfig.keyblades.kingdomKeyD[1]),
            KnockoutPunch = new ItemRealKeyblade(Strings.KnockoutPunch, BalanceConfig.keyblades.knockoutPunch[0], BalanceConfig.keyblades.knockoutPunch[1]),
            LadyLuck = new ItemRealKeyblade(Strings.LadyLuck, BalanceConfig.keyblades.ladyLuck[0], BalanceConfig.keyblades.ladyLuck[1]),
            LeasKeyblade = new ItemRealKeyblade(Strings.LeasKeyblade, BalanceConfig.keyblades.leasKeyblade[0], BalanceConfig.keyblades.leasKeyblade[1]),
            LeopardosForetellersKeyblade = new ItemRealKeyblade(Strings.LeopardosForetellersKeyblade, BalanceConfig.keyblades.leopardosForetellersKeyblade[0], BalanceConfig.keyblades.leopardosForetellersKeyblade[1]),
            Leviathan = new ItemRealKeyblade(Strings.Leviathan, BalanceConfig.keyblades.leviathan[0], BalanceConfig.keyblades.leviathan[1]),
            Lionheart = new ItemRealKeyblade(Strings.Lionheart, BalanceConfig.keyblades.lionheart[0], BalanceConfig.keyblades.lionheart[1]),
            LostMemory = new ItemRealKeyblade(Strings.LostMemory, BalanceConfig.keyblades.lostMemory[0], BalanceConfig.keyblades.lostMemory[1]),
            LunarEclipse = new ItemRealKeyblade(Strings.LunarEclipse, BalanceConfig.keyblades.lunarEclipse[0], BalanceConfig.keyblades.lunarEclipse[1]),
            MarkofaHero = new ItemRealKeyblade(Strings.MarkofaHero, BalanceConfig.keyblades.markofaHero[0], BalanceConfig.keyblades.markofaHero[1]),
            MasterXehanortsKeyblade = new ItemRealKeyblade(Strings.MasterXehanortsKeyblade, BalanceConfig.keyblades.masterXehanortsKeyblade[0], BalanceConfig.keyblades.masterXehanortsKeyblade[1]),
            MastersDefender = new ItemRealKeyblade(Strings.MastersDefender, BalanceConfig.keyblades.mastersDefender[0], BalanceConfig.keyblades.mastersDefender[1]),
            MaverickFlare = new ItemRealKeyblade(Strings.MaverickFlare, BalanceConfig.keyblades.maverickFlare[0], BalanceConfig.keyblades.maverickFlare[1]),
            MetalChocobo = new ItemRealKeyblade(Strings.MetalChocobo, BalanceConfig.keyblades.metalChocobo[0], BalanceConfig.keyblades.metalChocobo[1]),
            MidnightRoar = new ItemRealKeyblade(Strings.MidnightRoar, BalanceConfig.keyblades.midnightRoar[0], BalanceConfig.keyblades.midnightRoar[1]),
            MirageSplit = new ItemRealKeyblade(Strings.MirageSplit, BalanceConfig.keyblades.mirageSplit[0], BalanceConfig.keyblades.mirageSplit[1]),
            MissingAche = new ItemRealKeyblade(Strings.MissingAche, BalanceConfig.keyblades.missingAche[0], BalanceConfig.keyblades.missingAche[1]),
            Monochrome = new ItemRealKeyblade(Strings.Monochrome, BalanceConfig.keyblades.monochrome[0], BalanceConfig.keyblades.monochrome[1], ModAbilities.itemBoost),
            MysteriousAbyss = new ItemRealKeyblade(Strings.MysteriousAbyss, BalanceConfig.keyblades.mysteriousAbyss[0], BalanceConfig.keyblades.mysteriousAbyss[1], ModAbilities.blizzardBoost),
            NightmaresEnd = new ItemRealKeyblade(Strings.NightmaresEnd, BalanceConfig.keyblades.nightmaresEnd[0], BalanceConfig.keyblades.nightmaresEnd[1]),
            NightmaresEndandMirageSplit = new ItemRealKeyblade(Strings.NightmaresEndandMirageSplit, BalanceConfig.keyblades.combinedKeyblade[0], BalanceConfig.keyblades.combinedKeyblade[1]),
            NoName = new ItemRealKeyblade(Strings.NoName, BalanceConfig.keyblades.noName[0], BalanceConfig.keyblades.noName[1]),
            Oathkeeper = new ItemRealKeyblade(Strings.Oathkeeper, BalanceConfig.keyblades.oathkeeper[0], BalanceConfig.keyblades.oathkeeper[1], ModAbilities.formBoost),
            Oblivion = new ItemRealKeyblade(Strings.Oblivion, BalanceConfig.keyblades.oblivion[0], BalanceConfig.keyblades.oblivion[1], ModAbilities.driveBoost),
            OceansRage = new ItemRealKeyblade(Strings.OceansRage, BalanceConfig.keyblades.oceansRage[0], BalanceConfig.keyblades.oceansRage[1]),
            Olympia = new ItemRealKeyblade(Strings.Olympia, BalanceConfig.keyblades.olympia[0], BalanceConfig.keyblades.olympia[1]),
            OmegaWeapon = new ItemRealKeyblade(Strings.OmegaWeapon, BalanceConfig.keyblades.omegaWeapon[0], BalanceConfig.keyblades.omegaWeapon[1]),
            OminousBlight = new ItemRealKeyblade(Strings.OminousBlight, BalanceConfig.keyblades.ominousBlight[0], BalanceConfig.keyblades.ominousBlight[1]),
            OneWingedAngel = new ItemRealKeyblade(Strings.OneWingedAngel, BalanceConfig.keyblades.oneWingedAngel[0], BalanceConfig.keyblades.oneWingedAngel[1]),
            PainofSolitude = new ItemRealKeyblade(Strings.PainofSolitude, BalanceConfig.keyblades.painofSolitude[0], BalanceConfig.keyblades.painofSolitude[1]),
            PhotonDebugger = new ItemRealKeyblade(Strings.PhotonDebugger, BalanceConfig.keyblades.photonDebugger[0], BalanceConfig.keyblades.photonDebugger[1], ModAbilities.thunderBoost),
            PixiePetal = new ItemRealKeyblade(Strings.PixiePetal, BalanceConfig.keyblades.pixiePetal[0], BalanceConfig.keyblades.pixiePetal[1]),
            Pumpkinhead = new ItemRealKeyblade(Strings.Pumpkinhead, BalanceConfig.keyblades.pumpkinhead[0], BalanceConfig.keyblades.pumpkinhead[1]),
            Rainfell = new ItemRealKeyblade(Strings.Rainfell, BalanceConfig.keyblades.rainfell[0], BalanceConfig.keyblades.rainfell[1]),
            RejectionofFate = new ItemRealKeyblade(Strings.RejectionofFate, BalanceConfig.keyblades.rejectionofFate[0], BalanceConfig.keyblades.rejectionofFate[1]),
            RoyalRadiance = new ItemRealKeyblade(Strings.RoyalRadiance, BalanceConfig.keyblades.royalRadiance[0], BalanceConfig.keyblades.royalRadiance[1]),
            RumblingRose = new ItemRealKeyblade(Strings.RumblingRose, BalanceConfig.keyblades.rumblingRose[0], BalanceConfig.keyblades.rumblingRose[1], ModAbilities.finishingPlus),
            SignofInnocence = new ItemRealKeyblade(Strings.SignofInnocence, BalanceConfig.keyblades.signofInnocence[0], BalanceConfig.keyblades.signofInnocence[1]),
            SilentDirge = new ItemRealKeyblade(Strings.SilentDirge, BalanceConfig.keyblades.silentDirge[0], BalanceConfig.keyblades.silentDirge[1]),
            SkullNoise = new ItemRealKeyblade(Strings.SkullNoise, BalanceConfig.keyblades.skullNoise[0], BalanceConfig.keyblades.skullNoise[1]),
            SleepingLion = new ItemRealKeyblade(Strings.SleepingLion, BalanceConfig.keyblades.sleepingLion[0], BalanceConfig.keyblades.sleepingLion[1], ModAbilities.comboPlus),
            SoulEater = new ItemRealKeyblade(Strings.SoulEater, BalanceConfig.keyblades.soulEater[0], BalanceConfig.keyblades.soulEater[1]),
            Spellbinder = new ItemRealKeyblade(Strings.Spellbinder, BalanceConfig.keyblades.spellbinder[0], BalanceConfig.keyblades.spellbinder[1]),
            Starlight = new ItemRealKeyblade(Strings.Starlight, BalanceConfig.keyblades.starlight[0], BalanceConfig.keyblades.starlight[1]),
            StarSeeker = new ItemRealKeyblade(Strings.StarSeeker, BalanceConfig.keyblades.starSeeker[0], BalanceConfig.keyblades.starSeeker[1], ModAbilities.airComboPlus),
            Stormfall = new ItemRealKeyblade(Strings.Stormfall, BalanceConfig.keyblades.stormfall[0], BalanceConfig.keyblades.stormfall[1]),
            StrokeofMidnight = new ItemRealKeyblade(Strings.StrokeofMidnight, BalanceConfig.keyblades.strokeofMidnight[0], BalanceConfig.keyblades.strokeofMidnight[1]),
            SweetDreams = new ItemRealKeyblade(Strings.SweetDreams, BalanceConfig.keyblades.sweetDreams[0], BalanceConfig.keyblades.sweetDreams[1]),
            SweetMemories = new ItemRealKeyblade(Strings.SweetMemories, BalanceConfig.keyblades.sweetMemories[0], BalanceConfig.keyblades.sweetMemories[1], ModAbilities.driveConverter),
            Sweetstack = new ItemRealKeyblade(Strings.Sweetstack, BalanceConfig.keyblades.sweetstack[0], BalanceConfig.keyblades.sweetstack[1]),
            ThreeWishes = new ItemRealKeyblade(Strings.ThreeWishes, BalanceConfig.keyblades.threeWishes[0], BalanceConfig.keyblades.threeWishes[1]),
            TotalEclipse = new ItemRealKeyblade(Strings.TotalEclipse, BalanceConfig.keyblades.totalEclipse[0], BalanceConfig.keyblades.totalEclipse[1]),
            TreasureTrove = new ItemRealKeyblade(Strings.TreasureTrove, BalanceConfig.keyblades.treasureTrove[0], BalanceConfig.keyblades.treasureTrove[1]),
            TrueLightsFlight = new ItemRealKeyblade(Strings.TrueLightsFlight, BalanceConfig.keyblades.trueLightsFlight[0], BalanceConfig.keyblades.trueLightsFlight[1]),
            TwilightBlaze = new ItemRealKeyblade(Strings.TwilightBlaze, BalanceConfig.keyblades.twilightBlaze[0], BalanceConfig.keyblades.twilightBlaze[1]),
            TwoBecomeOne = new ItemRealKeyblade(Strings.TwoBecomeOne, BalanceConfig.keyblades.twoBecomeOne[0], BalanceConfig.keyblades.twoBecomeOne[1], ModAbilities.lightAndDark),
            UltimaWeaponKH1 = new ItemRealKeyblade(Strings.UltimaWeaponKH1, BalanceConfig.keyblades.ultimaWeaponKH1[0], BalanceConfig.keyblades.ultimaWeaponKH1[1]),
            UltimaWeaponKH2 = new ItemRealKeyblade(Strings.UltimaWeaponKH2, BalanceConfig.keyblades.ultimaWeaponKH2[0], BalanceConfig.keyblades.ultimaWeaponKH2[1], ModAbilities.mpHastega),
            UltimaWeaponBBS = new ItemRealKeyblade(Strings.UltimaWeaponBBS, BalanceConfig.keyblades.ultimaWeaponBBS[0], BalanceConfig.keyblades.ultimaWeaponBBS[1]),
            UltimaWeaponDDD = new ItemRealKeyblade(Strings.UltimaWeaponDDD, BalanceConfig.keyblades.ultimaWeaponDDD[0], BalanceConfig.keyblades.ultimaWeaponDDD[1]),
            Umbrella = new ItemKeyblade(Strings.Umbrella, BalanceConfig.keyblades.umbrella[0], BalanceConfig.keyblades.umbrella[1]),
            Unbound = new ItemRealKeyblade(Strings.Unbound, BalanceConfig.keyblades.unbound[0], BalanceConfig.keyblades.unbound[1]),
            UnicornisForetellersKeyblade = new ItemRealKeyblade(Strings.UnicornisForetellersKeyblade, BalanceConfig.keyblades.unicornisForetellersKeyblade[0], BalanceConfig.keyblades.unicornisForetellersKeyblade[1]),
            UrsusForetellersKeyblade = new ItemRealKeyblade(Strings.UrsusForetellersKeyblade, BalanceConfig.keyblades.ursusForetellersKeyblade[0], BalanceConfig.keyblades.ursusForetellersKeyblade[1]),
            VictoryLine = new ItemRealKeyblade(Strings.VictoryLine, BalanceConfig.keyblades.victoryLine[0], BalanceConfig.keyblades.victoryLine[1]),
            VoidGear = new ItemRealKeyblade(Strings.VoidGear, BalanceConfig.keyblades.voidGear[0], BalanceConfig.keyblades.voidGear[1]),
            VulpeusForetellersKeyblade = new ItemRealKeyblade(Strings.VulpeusForetellersKeyblade, BalanceConfig.keyblades.vulpeusForetellersKeyblade[0], BalanceConfig.keyblades.vulpeusForetellersKeyblade[1]),
            WaytotheDawn = new ItemRealKeyblade(Strings.WaytotheDawn, BalanceConfig.keyblades.waytotheDawn[0], BalanceConfig.keyblades.waytotheDawn[1]),
            WaywardWind = new ItemRealKeyblade(Strings.WaywardWind, BalanceConfig.keyblades.waywardWind[0], BalanceConfig.keyblades.waywardWind[1]),
            WinnersProof = new ItemRealKeyblade(Strings.WinnersProof, BalanceConfig.keyblades.winnersProof[0], BalanceConfig.keyblades.winnersProof[1], ModAbilities.zeroEXP),
            WishingLamp = new ItemRealKeyblade(Strings.WishingLamp, BalanceConfig.keyblades.wishingLamp[0], BalanceConfig.keyblades.wishingLamp[1], ModAbilities.jackpot),
            WishingStar = new ItemRealKeyblade(Strings.WishingStar, BalanceConfig.keyblades.wishingStar[0], BalanceConfig.keyblades.wishingStar[1]),
            WoodenKeyblade = new ItemKeyblade(Strings.WoodenKeyblade, BalanceConfig.keyblades.woodenKeyblade[0], BalanceConfig.keyblades.woodenKeyblade[1]),
            WoodenStick = new ItemKeyblade(Strings.WoodenStick, BalanceConfig.keyblades.woodenStick[0], BalanceConfig.keyblades.woodenStick[1]),
            YoungXehanortsKeyblade = new ItemRealKeyblade(Strings.YoungXehanortsKeyblade, BalanceConfig.keyblades.youngXehanortsKeyblade[0], BalanceConfig.keyblades.youngXehanortsKeyblade[1]),
            ZeroOne = new ItemRealKeyblade(Strings.ZeroOne, BalanceConfig.keyblades.zeroOne[0], BalanceConfig.keyblades.zeroOne[1]),
           
            Chain_AbaddonPlasma = new ItemKeychain(Strings.Chain_AbaddonPlasma),
            Chain_AbyssalTide = new ItemKeychain(Strings.Chain_AbyssalTide),
            Chain_AllforOne = new ItemKeychain(Strings.Chain_AllforOne),
            Chain_AnguisForetellersKeyblade = new ItemKeychain(Strings.Chain_AnguisForetellersKeyblade),
            Chain_AstralBlast = new ItemKeychain(Strings.Chain_AstralBlast),
            Chain_Aubade = new ItemKeychain(Strings.Chain_Aubade),
            Chain_BondofFlame = new ItemKeychain(Strings.Chain_BondofFlame),
            Chain_Brightcrest = new ItemKeychain(Strings.Chain_Brightcrest),
            Chain_ChaosRipper = new ItemKeychain(Strings.Chain_ChaosRipper),
            Chain_CircleofLife = new ItemKeychain(Strings.Chain_CircleofLife),
            Chain_Counterpoint = new ItemKeychain(Strings.Chain_Counterpoint),
            Chain_Crabclaw = new ItemKeychain(Strings.Chain_Crabclaw),
            Chain_CrownofGuilt = new ItemKeychain(Strings.Chain_CrownofGuilt),
            Chain_DarkerThanDark = new ItemKeychain(Strings.Chain_DarkerThanDark),
            Chain_Darkgnaw = new ItemKeychain(Strings.Chain_Darkgnaw),
            Chain_DecisivePumpkin = new ItemKeychain(Strings.Chain_DecisivePumpkin),
            Chain_DestinysEmbrace = new ItemKeychain(Strings.Chain_DestinysEmbrace),
            Chain_DiamondDust = new ItemKeychain(Strings.Chain_DiamondDust),
            Chain_Divewing = new ItemKeychain(Strings.Chain_Divewing),
            Chain_DivineRose = new ItemKeychain(Strings.Chain_DivineRose),
            Chain_DualDisc = new ItemKeychain(Strings.Chain_DualDisc),
            Chain_Earthshaker = new ItemKeychain(Strings.Chain_Earthshaker),
            Chain_EndofPain = new ItemKeychain(Strings.Chain_EndofPain),
            Chain_EndsoftheEarth = new ItemKeychain(Strings.Chain_EndsoftheEarth),
            Chain_FairyHarp = new ItemKeychain(Strings.Chain_FairyHarp),
            Chain_FairyStars = new ItemKeychain(Strings.Chain_FairyStars),
            Chain_FatalCrest = new ItemKeychain(Strings.Chain_FatalCrest),
            Chain_Fenrir = new ItemKeychain(Strings.Chain_Fenrir),
            Chain_FerrisGear = new ItemKeychain(Strings.Chain_FerrisGear),
            Chain_FollowtheWind = new ItemKeychain(Strings.Chain_FollowtheWind),
            Chain_FrolicFlame = new ItemKeychain(Strings.Chain_FrolicFlame),
            Chain_GlimpseofDarkness = new ItemKeychain(Strings.Chain_GlimpseofDarkness),
            Chain_GuardianBell = new ItemKeychain(Strings.Chain_GuardianBell),
            Chain_GuardianSoul = new ItemKeychain(Strings.Chain_GuardianSoul),
            Chain_GullWing = new ItemKeychain(Strings.Chain_GullWing),
            Chain_HerosCrest = new ItemKeychain(Strings.Chain_HerosCrest),
            Chain_HiddenDragon = new ItemKeychain(Strings.Chain_HiddenDragon),
            Chain_Hyperdrive = new ItemKeychain(Strings.Chain_Hyperdrive),
            Chain_IncompleteKiblade = new ItemKeychain(Strings.Chain_IncompleteKiblade),
            Chain_JungleKing = new ItemKeychain(Strings.Chain_JungleKing),
            Chain_KeybladeofPeoplesHearts = new ItemKeychain(Strings.Chain_KeybladeofPeoplesHearts),
            Chain_Kiblade = new ItemKeychain(Strings.Chain_Kiblade),
            Chain_KingdomKey = new ItemKeychain(Strings.Chain_KingdomKey),
            Chain_KingdomKeyD = new ItemKeychain(Strings.Chain_KingdomKeyD),
            Chain_KnockoutPunch = new ItemKeychain(Strings.Chain_KnockoutPunch),
            Chain_LadyLuck = new ItemKeychain(Strings.Chain_LadyLuck),
            Chain_LeasKeyblade = new ItemKeychain(Strings.Chain_LeasKeyblade),
            Chain_LeopardosForetellersKeyblade = new ItemKeychain(Strings.Chain_LeopardosForetellersKeyblade),
            Chain_Leviathan = new ItemKeychain(Strings.Chain_Leviathan),
            Chain_Lionheart = new ItemKeychain(Strings.Chain_Lionheart),
            Chain_LostMemory = new ItemKeychain(Strings.Chain_LostMemory),
            Chain_LunarEclipse = new ItemKeychain(Strings.Chain_LunarEclipse),
            Chain_MarkofaHero = new ItemKeychain(Strings.Chain_MarkofaHero),
            Chain_MasterXehanortsKeyblade = new ItemKeychain(Strings.Chain_MasterXehanortsKeyblade),
            Chain_MastersDefender = new ItemKeychain(Strings.Chain_MastersDefender),
            Chain_MaverickFlare = new ItemKeychain(Strings.Chain_MaverickFlare),
            Chain_MetalChocobo = new ItemKeychain(Strings.Chain_MetalChocobo),
            Chain_MidnightRoar = new ItemKeychain(Strings.Chain_MidnightRoar),
            Chain_MirageSplit = new ItemKeychain(Strings.Chain_MirageSplit),
            Chain_MissingAche = new ItemKeychain(Strings.Chain_MissingAche),
            Chain_Monochrome = new ItemKeychain(Strings.Chain_Monochrome),
            Chain_MysteriousAbyss = new ItemKeychain(Strings.Chain_MysteriousAbyss),
            Chain_NightmaresEnd = new ItemKeychain(Strings.Chain_NightmaresEnd),
            Chain_NightmaresEndandMirageSplit = new ItemKeychain(Strings.Chain_NightmaresEndandMirageSplit),
            Chain_NoName = new ItemKeychain(Strings.Chain_NoName),
            Chain_Oathkeeper = new ItemKeychain(Strings.Chain_Oathkeeper),
            Chain_Oblivion = new ItemKeychain(Strings.Chain_Oblivion),
            Chain_OceansRage = new ItemKeychain(Strings.Chain_OceansRage),
            Chain_Olympia = new ItemKeychain(Strings.Chain_Olympia),
            Chain_OmegaWeapon = new ItemKeychain(Strings.Chain_OmegaWeapon),
            Chain_OminousBlight = new ItemKeychain(Strings.Chain_OminousBlight),
            Chain_OneWingedAngel = new ItemKeychain(Strings.Chain_OneWingedAngel),
            Chain_PainofSolitude = new ItemKeychain(Strings.Chain_PainofSolitude),
            Chain_PhotonDebugger = new ItemKeychain(Strings.Chain_PhotonDebugger),
            Chain_PixiePetal = new ItemKeychain(Strings.Chain_PixiePetal),
            Chain_Pumpkinhead = new ItemKeychain(Strings.Chain_Pumpkinhead),
            Chain_Rainfell = new ItemKeychain(Strings.Chain_Rainfell),
            Chain_RejectionofFate = new ItemKeychain(Strings.Chain_RejectionofFate),
            Chain_RoyalRadiance = new ItemKeychain(Strings.Chain_RoyalRadiance),
            Chain_RumblingRose = new ItemKeychain(Strings.Chain_RumblingRose),
            Chain_SignofInnocence = new ItemKeychain(Strings.Chain_SignofInnocence),
            Chain_SilentDirge = new ItemKeychain(Strings.Chain_SilentDirge),
            Chain_SkullNoise = new ItemKeychain(Strings.Chain_SkullNoise),
            Chain_SleepingLion = new ItemKeychain(Strings.Chain_SleepingLion),
            Chain_SoulEater = new ItemKeychain(Strings.Chain_SoulEater),
            Chain_Spellbinder = new ItemKeychain(Strings.Chain_Spellbinder),
            Chain_StarSeeker = new ItemKeychain(Strings.Chain_StarSeeker),
            Chain_Starlight = new ItemKeychain(Strings.Chain_Starlight),
            Chain_Stormfall = new ItemKeychain(Strings.Chain_Stormfall),
            Chain_StrokeofMidnight = new ItemKeychain(Strings.Chain_StrokeofMidnight),
            Chain_SweetDreams = new ItemKeychain(Strings.Chain_SweetDreams),
            Chain_SweetMemories = new ItemKeychain(Strings.Chain_SweetMemories),
            Chain_Sweetstack = new ItemKeychain(Strings.Chain_Sweetstack),
            Chain_ThreeWishes = new ItemKeychain(Strings.Chain_ThreeWishes),
            Chain_TotalEclipse = new ItemKeychain(Strings.Chain_TotalEclipse),
            Chain_TreasureTrove = new ItemKeychain(Strings.Chain_TreasureTrove),
            Chain_TrueLightsFlight = new ItemKeychain(Strings.Chain_TrueLightsFlight),
            Chain_TwilightBlaze = new ItemKeychain(Strings.Chain_TwilightBlaze),
            Chain_TwoBecomeOne = new ItemKeychain(Strings.Chain_TwoBecomeOne),
            Chain_UltimaWeaponKH1 = new ItemKeychain(Strings.Chain_UltimaWeaponKH1),
            Chain_UltimaWeaponKH2 = new ItemKeychain(Strings.Chain_UltimaWeaponKH2),
            Chain_UltimaWeaponBBS = new ItemKeychain(Strings.Chain_UltimaWeaponBBS),
            Chain_UltimaWeaponDDD = new ItemKeychain(Strings.Chain_UltimaWeaponDDD),
            Chain_Umbrella = new ItemKeychain(Strings.Chain_Umbrella),
            Chain_Unbound = new ItemKeychain(Strings.Chain_Unbound),
            Chain_UnicornisForetellersKeyblade = new ItemKeychain(Strings.Chain_UnicornisForetellersKeyblade),
            Chain_UrsusForetellersKeyblade = new ItemKeychain(Strings.Chain_UrsusForetellersKeyblade),
            Chain_VictoryLine = new ItemKeychain(Strings.Chain_VictoryLine),
            Chain_VoidGear = new ItemKeychain(Strings.Chain_VoidGear),
            Chain_VulpeusForetellersKeyblade = new ItemKeychain(Strings.Chain_VulpeusForetellersKeyblade),
            Chain_WaytotheDawn = new ItemKeychain(Strings.Chain_WaytotheDawn),
            Chain_WaywardWind = new ItemKeychain(Strings.Chain_WaywardWind),
            Chain_WinnersProof = new ItemKeychain(Strings.Chain_WinnersProof),
            Chain_WishingLamp = new ItemKeychain(Strings.Chain_WishingLamp),
            Chain_WishingStar = new ItemKeychain(Strings.Chain_WishingStar),
            Chain_YoungXehanortsKeyblade = new ItemKeychain(Strings.Chain_YoungXehanortsKeyblade),
            Chain_ZeroOne = new ItemKeychain(Strings.Chain_ZeroOne),
            BlazingInfusedCoal = new ItemBlazingInfusedCoal(Strings.BlazingInfusedCoal),
            FrostInfusedSnowBall = new ItemKKBase(Strings.FrostInfusedSnowBall),
            StormyInfusedIron = new ItemKKBase(Strings.StormyInfusedIron),
            MythrilInfusedDiamond = new ItemKKBase(Strings.MythrilInfusedDiamond),
            LightningInfusedGold = new ItemKKBase(Strings.LightningInfusedGold),
            BrightInfusedGlowStone = new ItemKKBase(Strings.BrightInfusedGlowStone),
            DarkInfusedIron = new ItemKKBase(Strings.DarkInfusedIron),
            AbandonedKnowledge = new ItemAbandonedKnowledge(Strings.AbandonedKnowledge),
            OrganizationRobe_Helmet = new ItemOrganizationRobe(ORGANIZATIONROBE, 1, EntityEquipmentSlot.HEAD, 0, Strings.OrganizationRobe_Helmet),
            OrganizationRobe_Chestplate = new ItemOrganizationRobe(ORGANIZATIONROBE, 1, EntityEquipmentSlot.CHEST, 1, Strings.OrganizationRobe_Chestplate),
            OrganizationRobe_Leggings = new ItemOrganizationRobe(ORGANIZATIONROBE, 2, EntityEquipmentSlot.LEGS, 2, Strings.OrganizationRobe_Leggings),
            OrganizationRobe_Boots = new ItemOrganizationRobe(ORGANIZATIONROBE, 1, EntityEquipmentSlot.FEET, 3, Strings.OrganizationRobe_Boots),
            Xemnas_Helmet = new ItemOrganizationRobe(XEMNASROBE, 1, EntityEquipmentSlot.HEAD, 0, Strings.Xemnas_Helmet),
            Xemnas_Chestplate = new ItemOrganizationRobe(XEMNASROBE, 1, EntityEquipmentSlot.CHEST, 1, Strings.Xemnas_Chestplate),
            Xemnas_Leggings = new ItemOrganizationRobe(XEMNASROBE, 2, EntityEquipmentSlot.LEGS, 2, Strings.Xemnas_Leggings),
            Xemnas_Boots = new ItemOrganizationRobe(XEMNASROBE, 1, EntityEquipmentSlot.FEET, 3, Strings.Xemnas_Boots),
			AntiCoat_Helmet = new ItemOrganizationRobe(ANTIROBE, 1, EntityEquipmentSlot.HEAD, 0, Strings.AntiCoat_Helmet),
			AntiCoat_Chestplate = new ItemOrganizationRobe(ANTIROBE, 1, EntityEquipmentSlot.CHEST, 1, Strings.AntiCoat_Chestplate),
			AntiCoat_Leggings = new ItemOrganizationRobe(ANTIROBE, 2, EntityEquipmentSlot.LEGS, 2, Strings.AntiCoat_Leggings),
			AntiCoat_Boots = new ItemOrganizationRobe(ANTIROBE, 1, EntityEquipmentSlot.FEET, 3, Strings.AntiCoat_Boots),
            Terra_Helmet = new ItemKKArmor(TERRA, 1, EntityEquipmentSlot.HEAD, 0, Strings.Terra_Helmet),
            Terra_Chestplate = new ItemKKArmor(TERRA, 1, EntityEquipmentSlot.CHEST, 1, Strings.Terra_Chestplate),
            Terra_Leggings = new ItemKKArmor(TERRA, 2, EntityEquipmentSlot.LEGS, 2, Strings.Terra_Leggings),
            Terra_Boots = new ItemKKArmor(TERRA, 1, EntityEquipmentSlot.FEET, 3,Strings.Terra_Boots),
            Aqua_Helmet = new ItemKKArmor(AQUA, 1, EntityEquipmentSlot.HEAD, 0, Strings.Aqua_Helmet),
            Aqua_Chestplate = new ItemKKArmor(AQUA, 1, EntityEquipmentSlot.CHEST, 1, Strings.Aqua_Chestplate),
            Aqua_Leggings = new ItemKKArmor(AQUA, 2, EntityEquipmentSlot.LEGS, 2, Strings.Aqua_Leggings),
            Aqua_Boots = new ItemKKArmor(AQUA, 1, EntityEquipmentSlot.FEET, 3, Strings.Aqua_Boots),
            Ventus_Helmet = new ItemKKArmor(VENTUS, 1, EntityEquipmentSlot.HEAD, 0, Strings.Ventus_Helmet),
            Ventus_Chestplate = new ItemKKArmor(VENTUS, 1, EntityEquipmentSlot.CHEST, 1, Strings.Ventus_Chestplate),
            Ventus_Leggings = new ItemKKArmor(VENTUS, 2, EntityEquipmentSlot.LEGS, 2, Strings.Ventus_Leggings),
            Ventus_Boots = new ItemKKArmor(VENTUS, 1, EntityEquipmentSlot.FEET, 3, Strings.Ventus_Boots),
            NightmareVentus_Helmet = new ItemKKArmor(NIGHTMAREVENTUS, 1, EntityEquipmentSlot.HEAD, 0, Strings.NightmareVentus_Helmet),
            NightmareVentus_Chestplate = new ItemKKArmor(NIGHTMAREVENTUS, 1, EntityEquipmentSlot.CHEST, 1, Strings.NightmareVentus_Chestplate),
            NightmareVentus_Leggings = new ItemKKArmor(NIGHTMAREVENTUS, 2, EntityEquipmentSlot.LEGS, 2, Strings.NightmareVentus_Leggings),
            NightmareVentus_Boots = new ItemKKArmor(NIGHTMAREVENTUS, 1, EntityEquipmentSlot.FEET, 3, Strings.NightmareVentus_Boots),
            Eraqus_Helmet = new ItemKKArmor(ERAQUS, 1, EntityEquipmentSlot.HEAD, 0, Strings.Eraqus_Helmet),
            Eraqus_Chestplate = new ItemKKArmor(ERAQUS, 1, EntityEquipmentSlot.CHEST, 1, Strings.Eraqus_Chestplate),
            Eraqus_Leggings = new ItemKKArmor(ERAQUS, 2, EntityEquipmentSlot.LEGS, 2, Strings.Eraqus_Leggings),
            Eraqus_Boots = new ItemKKArmor(ERAQUS, 1, EntityEquipmentSlot.FEET, 3, Strings.Eraqus_Boots),
    		Vanitas_Helmet = new ItemKKArmor(VANITAS, 1, EntityEquipmentSlot.HEAD, 0, Strings.Vanitas_Helmet),
            Vanitas_Chestplate = new ItemKKArmor(VANITAS, 1, EntityEquipmentSlot.CHEST, 1, Strings.Vanitas_Chestplate),
            Vanitas_Leggings = new ItemKKArmor(VANITAS, 2, EntityEquipmentSlot.LEGS, 2, Strings.Vanitas_Leggings),
            Vanitas_Boots = new ItemKKArmor(VANITAS, 1, EntityEquipmentSlot.FEET, 3, Strings.Vanitas_Boots),
            Munny = new ItemMunny(Strings.Munny),
            EmptyBottle = new ItemKKBase(Strings.EmptyBottle).setMaxStackSize(1),
            Potion = new ItemPotion(0, true, "hp"),
            HiPotion = new ItemHiPotion(0, true, "hp"),
            MegaPotion = new ItemMegaPotion(0, true, "hp"),
            Ether = new ItemEther(0, true, "mp"),
            MegaEther = new ItemMegaEther(0, true, "mp"),
            Elixir = new ItemElixir(0, true, "elixir"),
            Megalixir = new ItemMegalixir(0, true, "elixir"),
            DriveRecovery = new ItemDriveRecovery(0, true, "dp"),
            HighDriveRecovery = new ItemHighDriveRecovery(0, true, "dp"),
            DefenseBoost = new ItemBooster(Strings.DefenseBoost),
            MagicBoost = new ItemBooster(Strings.MagicBoost),
            PowerBoost = new ItemBooster(Strings.PowerBoost),
            APBoost = new ItemBooster(Strings.APBoost),
            Panacaea = new ItemPanacea(0, true, "panacea"),
            HpOrb = new ItemHpOrb(Strings.HpOrb),
            DriveOrb = new ItemDriveOrb(Strings.DriveOrb),
            MagicOrb = new ItemMagicOrb(Strings.MagicOrb),
            Heart = new ItemKKBase(Strings.Heart),
            DarkHeart = new ItemKKBase(Strings.DarkHeart),
            PureHeart = new ItemKKBase(Strings.PureHeart),
            KingdomHearts = new ItemKKBase(Strings.KingdomHearts),
            DarkLeather = new ItemKKBase(Strings.DarkLeather),
            SynthesisMaterial = new ItemSynthesisMaterial(Strings.SynthesisMaterial),
            IceCream = new ItemIceCream(Strings.IceCream, 5, true),
            WinnerStick = new ItemKKBase(Strings.WinnerStick),
            GummiShip = new ItemHandHeldGummiShip("gummiship"),
            LevelUpMagicFire = new ItemUpgradeFire(Strings.LevelUpMagicFire, Strings.Spell_Fire),
            LevelUpMagicBlizzard = new ItemUpgradeBlizzard(Strings.LevelUpMagicBlizzard, Strings.Spell_Blizzard),
            LevelUpMagicThunder = new ItemUpgradeThunder(Strings.LevelUpMagicThunder, Strings.Spell_Thunder),
            LevelUpMagicCure = new ItemUpgradeCure(Strings.LevelUpMagicCure, Strings.Spell_Cure),
            LevelUpMagicAero = new ItemUpgradeAero(Strings.LevelUpMagicAero, Strings.Spell_Aero),
            LevelUpMagicStop = new ItemUpgradeStop(Strings.LevelUpMagicStop, Strings.Spell_Stop),
            LevelUpValor = new ItemUpgradeValor(Strings.LevelUpValor, Strings.Form_Valor),
            LevelUpWisdom = new ItemUpgradeWisdom(Strings.LevelUpWisdom, Strings.Form_Wisdom),
            LevelUpLimit = new ItemUpgradeLimit(Strings.LevelUpLimit, Strings.Form_Limit),
            LevelUpMaster = new ItemUpgradeMaster(Strings.LevelUpMaster, Strings.Form_Master),
            LevelUpFinal = new ItemUpgradeFinal(Strings.LevelUpFinal, Strings.Form_Final),
            SynthesisBagS = new ItemSynthesisBagS(Strings.SynthesisBagS),
            SynthesisBagM = new ItemSynthesisBagM(Strings.SynthesisBagM),
            SynthesisBagL = new ItemSynthesisBagL(Strings.SynthesisBagL),
            Disc_Birth_by_Sleep_A_Link_to_the_Future = new ItemKKRecord(ModSounds.Record_Birth_by_Sleep_A_Link_to_the_Future, Strings.Disc_Birth_by_Sleep_A_Link_to_the_Future, 7.29F),
            Disc_Darkness_of_the_Unknown = new ItemKKRecord(ModSounds.Record_Darkness_of_the_Unknown, Strings.Disc_Darkness_of_the_Unknown, 7.50F),
            Disc_Dearly_Beloved_Symphony_Version = new ItemKKRecord(ModSounds.Record_Dearly_Beloved_Symphony_Version, Strings.Disc_Dearly_Beloved_Symphony_Version, 2.33F),
            Disc_Dream_Drop_Distance_The_Next_Awakening = new ItemKKRecord(ModSounds.Record_Dream_Drop_Distance_The_Next_Awakening, Strings.Disc_Dream_Drop_Distance_The_Next_Awakening, 8.56F),
            Disc_Hikari_KINGDOM_Instrumental_Version = new ItemKKRecord(ModSounds.Record_Hikari_KINGDOM_Instrumental_Version, Strings.Disc_Hikari_KINGDOM_Instrumental_Version, 3.42F),
            Disc_L_Oscurita_Dell_Ignoto = new ItemKKRecord(ModSounds.Record_L_Oscurita_Dell_Ignoto, Strings.Disc_L_Oscurita_Dell_Ignoto, 4.33F),
            Disc_Musique_pour_la_tristesse_de_Xion = new ItemKKRecord(ModSounds.Record_Musique_pour_la_tristesse_de_Xion, Strings.Disc_Musique_pour_la_tristesse_de_Xion, 3.57F),
            Disc_No_More_Bugs_Bug_Version = new ItemKKRecord(ModSounds.Record_No_More_Bugs_Bug_Version, Strings.Disc_No_More_Bugs_Bug_Version, 3.17F),
            Disc_Organization_XIII = new ItemKKRecord(ModSounds.Record_Organization_XIII, Strings.Disc_Organization_XIII, 2.32F),
            Disc_Sanctuary = new ItemKKRecord(ModSounds.Record_Sanctuary, Strings.Disc_Sanctuary, 4.25F),
            Disc_Simple_And_Clean_PLANITb_Remix = new ItemKKRecord(ModSounds.Record_Simple_And_Clean_PLANITb_Remix, Strings.Disc_Simple_And_Clean_PLANITb_Remix, 2.37F),
            Disc_Sinister_Sundown = new ItemKKRecord(ModSounds.Record_Sinister_Sundown, Strings.Disc_Sinister_Sundown, 2.13F),
            Disc_The_13th_Anthology = new ItemKKRecord(ModSounds.Record_The_13th_Anthology, Strings.Disc_The_13th_Anthology, 6.38F),
            Recipe = new ItemRecipe(Strings.Recipe)
    };

    public static SynthesisStack blazingShard = new SynthesisStack(Strings.SM_BlazingShard, Strings.SM_Rank_C);
    public static SynthesisStack blazingStone = new SynthesisStack(Strings.SM_BlazingStone, Strings.SM_Rank_B);
    public static SynthesisStack blazingGem = new SynthesisStack(Strings.SM_BlazingGem, Strings.SM_Rank_A);
    public static SynthesisStack blazingCrystal = new SynthesisStack(Strings.SM_BlazingCrystal, Strings.SM_Rank_S);
    public static SynthesisStack brightShard = new SynthesisStack(Strings.SM_BrightShard, Strings.SM_Rank_C);
    public static SynthesisStack brightStone = new SynthesisStack(Strings.SM_BrightStone, Strings.SM_Rank_B);
    public static SynthesisStack brightGem = new SynthesisStack(Strings.SM_BrightGem, Strings.SM_Rank_A);
    public static SynthesisStack brightCrystal = new SynthesisStack(Strings.SM_BrightCrystal, Strings.SM_Rank_S);
    public static SynthesisStack frostShard = new SynthesisStack(Strings.SM_FrostShard, Strings.SM_Rank_C);
    public static SynthesisStack frostStone = new SynthesisStack(Strings.SM_FrostStone, Strings.SM_Rank_B);
    public static SynthesisStack frostGem = new SynthesisStack(Strings.SM_FrostGem, Strings.SM_Rank_A);
    public static SynthesisStack frostCrystal = new SynthesisStack(Strings.SM_FrostCrystal, Strings.SM_Rank_S);
    public static SynthesisStack lightningShard = new SynthesisStack(Strings.SM_LightningShard, Strings.SM_Rank_C);
    public static SynthesisStack lightningStone = new SynthesisStack(Strings.SM_LightningStone, Strings.SM_Rank_B);
    public static SynthesisStack lightningGem = new SynthesisStack(Strings.SM_LightningGem, Strings.SM_Rank_A);
    public static SynthesisStack lightningCrystal = new SynthesisStack(Strings.SM_LightningCrystal, Strings.SM_Rank_S);
    public static SynthesisStack lucidShard = new SynthesisStack(Strings.SM_LucidShard, Strings.SM_Rank_C);
    public static SynthesisStack lucidStone = new SynthesisStack(Strings.SM_LucidStone, Strings.SM_Rank_B);
    public static SynthesisStack lucidGem = new SynthesisStack(Strings.SM_LucidGem, Strings.SM_Rank_A);
    public static SynthesisStack lucidCrystal = new SynthesisStack(Strings.SM_LucidCrystal, Strings.SM_Rank_S);
    public static SynthesisStack powerShard = new SynthesisStack(Strings.SM_PowerShard, Strings.SM_Rank_C);
    public static SynthesisStack powerStone = new SynthesisStack(Strings.SM_PowerStone, Strings.SM_Rank_B);
    public static SynthesisStack powerGem = new SynthesisStack(Strings.SM_PowerGem, Strings.SM_Rank_A);
    public static SynthesisStack powerCrystal = new SynthesisStack(Strings.SM_PowerCrystal, Strings.SM_Rank_S);
    public static SynthesisStack darkShard = new SynthesisStack(Strings.SM_DarkShard, Strings.SM_Rank_C);
    public static SynthesisStack darkStone = new SynthesisStack(Strings.SM_DarkStone, Strings.SM_Rank_B);
    public static SynthesisStack darkGem = new SynthesisStack(Strings.SM_DarkGem, Strings.SM_Rank_A);
    public static SynthesisStack darkCrystal = new SynthesisStack(Strings.SM_DarkCrystal, Strings.SM_Rank_S);
    public static SynthesisStack denseShard = new SynthesisStack(Strings.SM_DenseShard, Strings.SM_Rank_C);
    public static SynthesisStack denseStone = new SynthesisStack(Strings.SM_DenseStone, Strings.SM_Rank_B);
    public static SynthesisStack denseGem = new SynthesisStack(Strings.SM_DenseGem, Strings.SM_Rank_A);
    public static SynthesisStack denseCrystal = new SynthesisStack(Strings.SM_DenseCrystal, Strings.SM_Rank_S);
    public static SynthesisStack twilightShard = new SynthesisStack(Strings.SM_TwilightShard, Strings.SM_Rank_C);
    public static SynthesisStack twilightStone = new SynthesisStack(Strings.SM_TwilightStone, Strings.SM_Rank_B);
    public static SynthesisStack twilightGem = new SynthesisStack(Strings.SM_TwilightGem, Strings.SM_Rank_A);
    public static SynthesisStack twilightCrystal = new SynthesisStack(Strings.SM_TwilightCrystal, Strings.SM_Rank_S);
    public static SynthesisStack mythrilShard = new SynthesisStack(Strings.SM_MythrilShard, Strings.SM_Rank_C);
    public static SynthesisStack mythrilStone = new SynthesisStack(Strings.SM_MythrilStone, Strings.SM_Rank_B);
    public static SynthesisStack mythrilGem = new SynthesisStack(Strings.SM_MythrilGem, Strings.SM_Rank_A);
    public static SynthesisStack mythrilCrystal = new SynthesisStack(Strings.SM_MythrilCrystal, Strings.SM_Rank_S);
    public static SynthesisStack stormyShard = new SynthesisStack(Strings.SM_StormyShard, Strings.SM_Rank_C);
    public static SynthesisStack stormyStone = new SynthesisStack(Strings.SM_StormyStone, Strings.SM_Rank_B);
    public static SynthesisStack stormyGem = new SynthesisStack(Strings.SM_StormyGem, Strings.SM_Rank_A);
    public static SynthesisStack stormyCrystal = new SynthesisStack(Strings.SM_StormyCrystal, Strings.SM_Rank_S);
    public static SynthesisStack remembranceShard = new SynthesisStack(Strings.SM_RemembranceShard, Strings.SM_Rank_C);
    public static SynthesisStack remembranceStone = new SynthesisStack(Strings.SM_RemembranceStone, Strings.SM_Rank_B);
    public static SynthesisStack remembranceGem = new SynthesisStack(Strings.SM_RemembranceGem, Strings.SM_Rank_A);
    public static SynthesisStack remembranceCrystal = new SynthesisStack(Strings.SM_RemembranceCrystal, Strings.SM_Rank_S);
    public static SynthesisStack energyShard = new SynthesisStack(Strings.SM_EnergyShard, Strings.SM_Rank_C);
    public static SynthesisStack energyStone = new SynthesisStack(Strings.SM_EnergyStone, Strings.SM_Rank_B);
    public static SynthesisStack energyGem = new SynthesisStack(Strings.SM_EnergyGem, Strings.SM_Rank_A);
    public static SynthesisStack energyCrystal = new SynthesisStack(Strings.SM_EnergyCrystal, Strings.SM_Rank_S);
    public static SynthesisStack serenityShard = new SynthesisStack(Strings.SM_SerenityShard, Strings.SM_Rank_C);
    public static SynthesisStack serenityStone = new SynthesisStack(Strings.SM_SerenityStone, Strings.SM_Rank_B);
    public static SynthesisStack serenityGem = new SynthesisStack(Strings.SM_SerenityGem, Strings.SM_Rank_A);
    public static SynthesisStack serenityCrystal = new SynthesisStack(Strings.SM_SerenityCrystal, Strings.SM_Rank_S);
    public static SynthesisStack orichalcum = new SynthesisStack(Strings.SM_Orichalcum, Strings.SM_Rank_A);
    public static SynthesisStack orichalcumPlus = new SynthesisStack(Strings.SM_OrichalcumPlus, Strings.SM_Rank_S);
    public static SynthesisStack manifestIllusion = new SynthesisStack(Strings.SM_ManifestIllusion, Strings.SM_Rank_A);
    public static SynthesisStack lostIllusion = new SynthesisStack(Strings.SM_LostIllusion, Strings.SM_Rank_S);

    public static void init() {
        ((ItemKeyblade)AbaddonPlasma).setDescription("A weapon that lets you string together faster, incredibly long ground combos.");
        ((ItemKeyblade)AbyssalTide).setDescription("A weapon that performs very well in midair. Excellent for taking on fliers.");
        ((ItemKeyblade)AllforOne).setDescription("A Keyblade that triggers fewer Reality Shifts, but compensates with a boost in Magic and more frequent critical hits.");
        ((ItemKeyblade)AnguisForetellersKeyblade).setDescription("The Keyblade owned by Anguis' Foreteller.");
        ((ItemKeyblade)AstralBlast).setDescription("A weapon that lets you string together longer ground and aerial combos.");
        ((ItemKeyblade)Aubade).setDescription("A weapon that draws forth its wielder's personality.");
        ((ItemKeyblade)BondofFlame).setDescription("Enhances magic to increase damage dealt by fire-based attacks.");
        ((ItemKeyblade)Brightcrest).setDescription("A Keyblade with long reach that provides an outstanding boost in Magic. It also makes it easier to land critical hits, and deals higher damage when you do.");
        ((ItemKeyblade)ChaosRipper).setDescription("A Keyblade with long reach that does little for your Magic, but provides an outstanding boost in Strength.");
        ((ItemKeyblade)CircleofLife).setDescription("Has great strength, increasing MP restoration speed after MP is consumed.");
        ((ItemKeyblade)Counterpoint).setDescription("A Keyblade with long reach that provides an exra boost in Magic and mkes it easier to trigger Reality Shifts.");
        ((ItemKeyblade)Crabclaw).setDescription("Raises max MP by 1, and enhances magic and summon power. Also deals good physical damage.");
        ((ItemKeyblade)CrownofGuilt).setDescription("A weapon that boosts your Magic to give it incredible power.");
        ((ItemKeyblade)DarkerThanDark).setDescription("A weapon that offers high Magic and combo reach.");
        ((ItemKeyblade)Darkgnaw).setDescription("A Keyblade that makes up for its poor reach and low critical hit ratio by providing an extra boost in Strength.");
        ((ItemKeyblade)DecisivePumpkin).setDescription("The greater number of combos landed, the more damage is dealt, leading to a strong finishing move!");
        ((ItemKeyblade)DestinysEmbrace).setDescription("A Keyblade that makes it easier to land critical hits.");
        ((ItemKeyblade)DiamondDust).setDescription("Greatly enhances magic and summon power. Raises max MP by 3.");
        ((ItemKeyblade)Divewing).setDescription("A Keyblade that provides an extra boost in Magic and makes it easier to land critical hits.");
        ((ItemKeyblade)DivineRose).setDescription("A powerful weapon that is difficult to deflect. Capable of dealing a string of critical blows.");
        ((ItemKeyblade)DreamSword).setDescription("A sword whose strength is courage: the will to stand against anything.");
        ((ItemKeyblade)DualDisc).setDescription("A Keyblade that provides an extra boost in Strength and makes it easier to land critical hits.");
        ((ItemKeyblade)Earthshaker).setDescription("The Keyblade Terra started out with. What it lacks in reach it makes up for with a slight boost in Strength.");
        ((ItemKeyblade)EndofPain).setDescription("A Keyblade with high magical power and critical hit rate, but reduces the occurrence of Reality Shift.");
        ((ItemKeyblade)EndsoftheEarth).setDescription("A well-balanced Keyblade that provides an extra boost to all your stats.");
        ((ItemKeyblade)FairyHarp).setDescription("Raises max MP by 1, and enhances magic and summon power. Sometimes deals powerful critical blows.");
        ((ItemKeyblade)FairyStars).setDescription("A Keyblade that provides a balanced boost in Strength and Magic.");
        ((ItemKeyblade)FatalCrest).setDescription("Increases strength during MP Charge and allows unlimited chaining of combos.");
        ((ItemKeyblade)Fenrir).setDescription("Has great range and strength, but maximum ground and midair combos are decreased by 1.");
        ((ItemKeyblade)FerrisGear).setDescription("A Keyblade that triggers fewer Reality Shifts, but compensates with an extra boost in Strength and Magic.");
        ((ItemKeyblade)FollowtheWind).setDescription("Draws in nearby orbs.");
        ((ItemKeyblade)FrolicFlame).setDescription("A well-balanced Keyblade that provides an extra boost to all of your stats.");
        ((ItemKeyblade)GlimpseofDarkness).setDescription("A weapon that possesses very high Strength. Effective against tough enemies.");
        ((ItemKeyblade)GuardianBell).setDescription("A Keyblade with long reach that provides an extra boost in Magic.");
        ((ItemKeyblade)GuardianSoul).setDescription("Has great strength, increasing the amount of damage dealt from Reaction Commands.");
        ((ItemKeyblade)GullWing).setDescription("Greatly increases the amount of experience gained when defeating an enemy at a critical moment.");
        ((ItemKeyblade)HerosCrest).setDescription("Increases the damage of the finishing move in the air relative to the number of hits in the combo.");
        ((ItemKeyblade)HiddenDragon).setDescription("Restores MP relative to the amount of damage taken.");
        ((ItemKeyblade)Hyperdrive).setDescription("A Keyblade with above-average reach that provides a balanced boost in Strength and Magic.");
        ((ItemKeyblade)IncompleteKiblade).setDescription("An incomplete form of the legendary Keyblade, the χ-blade.");
        ((ItemKeyblade)JungleKing).setDescription("Has a long reach, but seldom deals critical blows.");
        ((ItemKeyblade)KeybladeofPeoplesHearts).setDescription("A keyblade with the ability to unlock a person's heart, releasing the darkness within.");
        ((ItemKeyblade)Kiblade).setDescription("A legendary weapon, the original Keyblade which all other are imperfectly modeled after. ");
        ((ItemKeyblade)KingdomKey).setDescription("The key chain attached draws out the Keyblade's true form and power.");
        ((ItemKeyblade)KingdomKeyD).setDescription("A Keyblade which mirrors the Kingdom Key from the Realm of Darkness.");
        ((ItemKeyblade)KnockoutPunch).setDescription("A Keyblade that lands fewer critical hits, but compensates with a Strength boost and more frequent Reality Shifts.");
        ((ItemKeyblade)LadyLuck).setDescription("Raises max MP by 2, and significantly enhances magic and summon power. Also inflicts good physical damage.");
        ((ItemKeyblade)LeasKeyblade).setDescription("The Keyblade wielded by Lea.");
        ((ItemKeyblade)LeopardosForetellersKeyblade).setDescription("The Keyblade owned by Leopardos' Foreteller.");
        ((ItemKeyblade)Leviathan).setDescription("A weapon that performs extremely well in midair. Outstanding for taking on fliers.");
        ((ItemKeyblade)Lionheart).setDescription("Raises max MP by 1, and enhances magic and summon power. Also deals great physical damage.");
        ((ItemKeyblade)LostMemory).setDescription("A Keyblade with long reach that makes it easier to land critical hits, and deals higher damage when you do.");
        ((ItemKeyblade)LunarEclipse).setDescription("A weapon that boosts versatility by greatly boosting both Strength and Magic.");
        ((ItemKeyblade)MarkofaHero).setDescription("A Keyblade that provides an extra boost in Strength and deals higher damage when you land a critical hit.");
        ((ItemKeyblade)MasterXehanortsKeyblade).setDescription("The Keyblade weilded by Master Xehanort.");
        ((ItemKeyblade)MastersDefender).setDescription("Master Eraqus's Keyblade. All of its stats are high.");
        ((ItemKeyblade)MaverickFlare).setDescription("A weapon that offers high Strength and ground combo speed.");
        ((ItemKeyblade)MetalChocobo).setDescription("Possesses incredible power and reach, but reduces max MP by 1. Rarely deals critical blows.");
        ((ItemKeyblade)MidnightRoar).setDescription("A weapon that possesses high Strength. Useful against tough enemies.");
        ((ItemKeyblade)MirageSplit).setDescription("A Keyblade formed from a Reality Shift in The World That Never Was.");
        ((ItemKeyblade)MissingAche).setDescription("A weapon that lets you string together faster, longer ground combos.");
        ((ItemKeyblade)Monochrome).setDescription("Increases the effect of restoration items used on the field.");
        ((ItemKeyblade)MysteriousAbyss).setDescription("Enhances magic to increase damage dealt by blizzard-based attacks.");
        ((ItemKeyblade)NightmaresEnd).setDescription("A Keyblade formed from a Reality Shift in The World That Never Was.");
        ((ItemKeyblade)NightmaresEndandMirageSplit).setDescription("A Keyblade formed by combining both the Mirage Split and Nightmare's End.");
        ((ItemKeyblade)NoName).setDescription("A Keyblade with long reach that provides an outstanding boost in Magic and makes it easier to land critical hits.");
        ((ItemKeyblade)Oathkeeper).setDescription("Enhances magic and increases the duration of a Drive Form.");
        ((ItemKeyblade)Oblivion).setDescription("Has great strength, and allows the Drive Gauge to restore quickly during MP Charge.");
        ((ItemKeyblade)OceansRage).setDescription("A Keyblade that lands fewer critical hits, but compensates with a boost in Magic and more frequent Reality Shifts.");
        ((ItemKeyblade)Olympia).setDescription("A powerful weapon that is difficult to deflect. Capable of inflicting mighty critical blows.");
        ((ItemKeyblade)OmegaWeapon).setDescription("A formidable weapon with exceptional capabilities.");
        ((ItemKeyblade)OminousBlight).setDescription("A weapon that lets you string together faster, much longer ground combos.");
        ((ItemKeyblade)OneWingedAngel).setDescription("Has little power, but sometimes deals extremely powerful critical blows. Reduces max MP by 2.");
        ((ItemKeyblade)PainofSolitude).setDescription("A weapon that boosts your Magic to give it more power.");
        ((ItemKeyblade)PhotonDebugger).setDescription("Increases damage done by thunder-based attacks.");
        ((ItemKeyblade)PixiePetal).setDescription("A Keyblade that makes up for its poor reach with an extra boost in Magic. It also makes it easier to land critical hits, and deals higher damage when you do.");
        ((ItemKeyblade)Pumpkinhead).setDescription("Has a long reach and the ability to deal a string of critical blows.");
        ((ItemKeyblade)Rainfell).setDescription("The Keyblade Aqua started out with. What it lacks in reach it makes up for with a balanced boost to Strength and Magic.");
        ((ItemKeyblade)RejectionofFate).setDescription("A weapon that enables your attacks to reach a wide area and deal immense damage.");
        ((ItemKeyblade)RoyalRadiance).setDescription("A very powerful Keyblade. Hastens the Command Gauge when equipped.");
        ((ItemKeyblade)RumblingRose).setDescription("Has great strength, allowing finishing combo moves to be unleashed successively.");
        ((ItemKeyblade)SignofInnocence).setDescription("A weapon that boosts your Magic to give it a lot more power.");
        ((ItemKeyblade)SilentDirge).setDescription("A weapon that provides versatility by boosting both Strength and Magic.");
        ((ItemKeyblade)SkullNoise).setDescription("A Keyblade that provides a balanced boost in Strength and Magic.");
        ((ItemKeyblade)SleepingLion).setDescription("Well-balanced with strength and magic, increasing maximum ground-based combos by 1.");
        ((ItemKeyblade)SoulEater).setDescription("A sword that swims with darkness. Possesses high Strength.");
        ((ItemKeyblade)Spellbinder).setDescription("Raises max MP by 2, and significantly enhances magic and summon power.");
        ((ItemKeyblade)Starlight).setDescription("A basic Keyblade which is associated with the force of Light.");
        ((ItemKeyblade)StarSeeker).setDescription("Increases maximum combo by 1 when in midair.");
        ((ItemKeyblade)Stormfall).setDescription("A well-balanced Keyblade that provides an extra boost to all your stats.");
        ((ItemKeyblade)StrokeofMidnight).setDescription("A Keyblade that makes it easier to land critical hits.");
        ((ItemKeyblade)SweetDreams).setDescription("A Keyblade with long reach that provides an extra boost in Strength and makes it easier to land critical hits.");
        ((ItemKeyblade)SweetMemories).setDescription("Although it does not enhance attack strength, it increases the drop rate of items.");
        ((ItemKeyblade)Sweetstack).setDescription("A Keyblade that provides an extra boost in Strength and ensures every strike is a critical hit.");
        ((ItemKeyblade)ThreeWishes).setDescription("A powerful weapon that is difficult to deflect.");
        ((ItemKeyblade)TotalEclipse).setDescription("A weapon that possesses extreme Strength. Devastates tough enemies.");
        ((ItemKeyblade)TreasureTrove).setDescription("A Keyblade that makes up for its poor reach with a balanced boost in Strength and Magic.");
        ((ItemKeyblade)TrueLightsFlight).setDescription("A weapon that enables your attacks to reach a wide area and deal heavy damage.");
        ((ItemKeyblade)TwilightBlaze).setDescription("A weapon that boasts superior Strength and ground combo speed.");
        ((ItemKeyblade)TwoBecomeOne).setDescription("A weapon of great strength and magic that has a special effect.");
        ((ItemKeyblade)UltimaWeaponKH1).setDescription("The ultimate Keyblade. Raises max MP by 2, and possesses maximum power and attributes.");
        ((ItemKeyblade)UltimaWeaponKH2).setDescription("The Keyblade above all others, holding all power and will increase MP restoration rate, once all MP has been consumed.");
        ((ItemKeyblade)UltimaWeaponBBS).setDescription("The most powerful of Keyblades.");
        ((ItemKeyblade)UltimaWeaponDDD).setDescription("An outstanding Keyblade that boosts all stats, and makes it easy to both land critical hits and trigger Reality Shifts.");
        ((ItemKeyblade)Umbrella).setDescription("This looks awfully familiar...");
        ((ItemKeyblade)Unbound).setDescription("Keyblade perfection. It boosts all stats, while making it easy to land critical hits and even easier to trigger Reality Shifts.");
        ((ItemKeyblade)UnicornisForetellersKeyblade).setDescription("The Keyblade owned by Unicornis' Foreteller.");
        ((ItemKeyblade)UrsusForetellersKeyblade).setDescription("The Keyblade owned by Ursus' Foreteller.");
        ((ItemKeyblade)VictoryLine).setDescription("A Keyblade with above-average reach that makes it easier to land critical hits.");
        ((ItemKeyblade)VoidGear).setDescription("A Keyblade with long reach that provides an outstanding boost in Strength and deals higher damage when you land a critical hit.");
        ((ItemKeyblade)VulpeusForetellersKeyblade).setDescription("The Keyblade owned by Vulpeus' Foreteller.");
        ((ItemKeyblade)WaytotheDawn).setDescription("Deals various attacks.");
        ((ItemKeyblade)WaywardWind).setDescription("The Keyblade Ventus started out with. What it lacks in reach it makes up for with a slight boost in Strength.");
        ((ItemKeyblade)WinnersProof).setDescription("Has high strength and hold's an excellent magic power. When the enemies are defeated, experience points are not gained.");
        ((ItemKeyblade)WishingLamp).setDescription("Wishes come true by increasing the drop rate of munny, HP and MP orbs.");
        ((ItemKeyblade)WishingStar).setDescription("Has a short reach, but always finishes up a combo attack with a powerful critical blow.");
        ((ItemKeyblade)WoodenKeyblade).setDescription("A toy Keyblade that originally belonged to Terra, which was later bestowed upon Ventus.");
        ((ItemKeyblade)WoodenKeyblade).setDescription("A stick.");
        ((ItemKeyblade)YoungXehanortsKeyblade).setDescription("The Keyblade weilded by Young Xehanort.");
        ((ItemKeyblade)ZeroOne).setDescription("A Keyblade newly wrought within the datascape. Its powers render all opponents helpless.");

        ((ItemKeychain)Chain_AbaddonPlasma).setKeyblade((ItemKeyblade) AbaddonPlasma);
        ((ItemKeychain)Chain_AbyssalTide).setKeyblade((ItemKeyblade) AbyssalTide);
        ((ItemKeychain)Chain_AllforOne).setKeyblade((ItemKeyblade) AllforOne);
        ((ItemKeychain)Chain_AnguisForetellersKeyblade).setKeyblade((ItemKeyblade) AnguisForetellersKeyblade);
        ((ItemKeychain)Chain_AstralBlast).setKeyblade((ItemKeyblade) AstralBlast);
        ((ItemKeychain)Chain_Aubade).setKeyblade((ItemKeyblade) Aubade);
        ((ItemKeychain)Chain_BondofFlame).setKeyblade((ItemKeyblade) BondofFlame);
        ((ItemKeychain)Chain_Brightcrest).setKeyblade((ItemKeyblade) Brightcrest);
        ((ItemKeychain)Chain_ChaosRipper).setKeyblade((ItemKeyblade) ChaosRipper);
        ((ItemKeychain)Chain_CircleofLife).setKeyblade((ItemKeyblade) CircleofLife);
        ((ItemKeychain)Chain_Counterpoint).setKeyblade((ItemKeyblade) Counterpoint);
        ((ItemKeychain)Chain_Crabclaw).setKeyblade((ItemKeyblade) Crabclaw);
        ((ItemKeychain)Chain_CrownofGuilt).setKeyblade((ItemKeyblade) CrownofGuilt);
        ((ItemKeychain)Chain_DarkerThanDark).setKeyblade((ItemKeyblade) DarkerThanDark);
        ((ItemKeychain)Chain_Darkgnaw).setKeyblade((ItemKeyblade) Darkgnaw);
        ((ItemKeychain)Chain_DecisivePumpkin).setKeyblade((ItemKeyblade) DecisivePumpkin);
        ((ItemKeychain)Chain_DestinysEmbrace).setKeyblade((ItemKeyblade) DestinysEmbrace);
        ((ItemKeychain)Chain_DiamondDust).setKeyblade((ItemKeyblade) DiamondDust);
        ((ItemKeychain)Chain_Divewing).setKeyblade((ItemKeyblade) Divewing);
        ((ItemKeychain)Chain_DivineRose).setKeyblade((ItemKeyblade) DivineRose);
        ((ItemKeychain)Chain_DualDisc).setKeyblade((ItemKeyblade) DualDisc);
        ((ItemKeychain)Chain_Earthshaker).setKeyblade((ItemKeyblade) Earthshaker);
        ((ItemKeychain)Chain_EndofPain).setKeyblade((ItemKeyblade) EndofPain);
        ((ItemKeychain)Chain_EndsoftheEarth).setKeyblade((ItemKeyblade) EndsoftheEarth);
        ((ItemKeychain)Chain_FairyHarp).setKeyblade((ItemKeyblade) FairyHarp);
        ((ItemKeychain)Chain_FairyStars).setKeyblade((ItemKeyblade) FairyStars);
        ((ItemKeychain)Chain_FatalCrest).setKeyblade((ItemKeyblade) FatalCrest);
        ((ItemKeychain)Chain_Fenrir).setKeyblade((ItemKeyblade) Fenrir);
        ((ItemKeychain)Chain_FerrisGear).setKeyblade((ItemKeyblade) FerrisGear);
        ((ItemKeychain)Chain_FollowtheWind).setKeyblade((ItemKeyblade) FollowtheWind);
        ((ItemKeychain)Chain_FrolicFlame).setKeyblade((ItemKeyblade) FrolicFlame);
        ((ItemKeychain)Chain_GlimpseofDarkness).setKeyblade((ItemKeyblade) GlimpseofDarkness);
        ((ItemKeychain)Chain_GuardianBell).setKeyblade((ItemKeyblade) GuardianBell);
        ((ItemKeychain)Chain_GuardianSoul).setKeyblade((ItemKeyblade) GuardianSoul);
        ((ItemKeychain)Chain_GullWing).setKeyblade((ItemKeyblade) GullWing);
        ((ItemKeychain)Chain_HerosCrest).setKeyblade((ItemKeyblade) HerosCrest);
        ((ItemKeychain)Chain_HiddenDragon).setKeyblade((ItemKeyblade) HiddenDragon);
        ((ItemKeychain)Chain_Hyperdrive).setKeyblade((ItemKeyblade) Hyperdrive);
        ((ItemKeychain)Chain_IncompleteKiblade).setKeyblade((ItemKeyblade) IncompleteKiblade);
        ((ItemKeychain)Chain_JungleKing).setKeyblade((ItemKeyblade) JungleKing);
        ((ItemKeychain)Chain_KeybladeofPeoplesHearts).setKeyblade((ItemKeyblade) KeybladeofPeoplesHearts);
        ((ItemKeychain)Chain_Kiblade).setKeyblade((ItemKeyblade) Kiblade);
        ((ItemKeychain)Chain_KingdomKey).setKeyblade((ItemKeyblade) KingdomKey);
        ((ItemKeychain)Chain_KingdomKeyD).setKeyblade((ItemKeyblade) KingdomKeyD);
        ((ItemKeychain)Chain_KnockoutPunch).setKeyblade((ItemKeyblade) KnockoutPunch);
        ((ItemKeychain)Chain_LadyLuck).setKeyblade((ItemKeyblade) LadyLuck);
        ((ItemKeychain)Chain_LeasKeyblade).setKeyblade((ItemKeyblade) LeasKeyblade);
        ((ItemKeychain)Chain_LeopardosForetellersKeyblade).setKeyblade((ItemKeyblade) LeopardosForetellersKeyblade);
        ((ItemKeychain)Chain_Leviathan).setKeyblade((ItemKeyblade) Leviathan);
        ((ItemKeychain)Chain_Lionheart).setKeyblade((ItemKeyblade) Lionheart);
        ((ItemKeychain)Chain_LostMemory).setKeyblade((ItemKeyblade) LostMemory);
        ((ItemKeychain)Chain_LunarEclipse).setKeyblade((ItemKeyblade) LunarEclipse);
        ((ItemKeychain)Chain_MarkofaHero).setKeyblade((ItemKeyblade) MarkofaHero);
        ((ItemKeychain)Chain_MasterXehanortsKeyblade).setKeyblade((ItemKeyblade) MasterXehanortsKeyblade);
        ((ItemKeychain)Chain_MastersDefender).setKeyblade((ItemKeyblade) MastersDefender);
        ((ItemKeychain)Chain_MaverickFlare).setKeyblade((ItemKeyblade) MaverickFlare);
        ((ItemKeychain)Chain_MetalChocobo).setKeyblade((ItemKeyblade) MetalChocobo);
        ((ItemKeychain)Chain_MidnightRoar).setKeyblade((ItemKeyblade) MidnightRoar);
        ((ItemKeychain)Chain_MirageSplit).setKeyblade((ItemKeyblade) MirageSplit);
        ((ItemKeychain)Chain_MissingAche).setKeyblade((ItemKeyblade) MissingAche);
        ((ItemKeychain)Chain_Monochrome).setKeyblade((ItemKeyblade) Monochrome);
        ((ItemKeychain)Chain_MysteriousAbyss).setKeyblade((ItemKeyblade) MysteriousAbyss);
        ((ItemKeychain)Chain_NightmaresEnd).setKeyblade((ItemKeyblade) NightmaresEnd);
        ((ItemKeychain)Chain_NightmaresEndandMirageSplit).setKeyblade((ItemKeyblade) NightmaresEndandMirageSplit);
        ((ItemKeychain)Chain_NoName).setKeyblade((ItemKeyblade) NoName);
        ((ItemKeychain)Chain_Oathkeeper).setKeyblade((ItemKeyblade) Oathkeeper);
        ((ItemKeychain)Chain_Oblivion).setKeyblade((ItemKeyblade) Oblivion);
        ((ItemKeychain)Chain_OceansRage).setKeyblade((ItemKeyblade) OceansRage);
        ((ItemKeychain)Chain_Olympia).setKeyblade((ItemKeyblade) Olympia);
        ((ItemKeychain)Chain_OmegaWeapon).setKeyblade((ItemKeyblade) OmegaWeapon);
        ((ItemKeychain)Chain_OminousBlight).setKeyblade((ItemKeyblade) OminousBlight);
        ((ItemKeychain)Chain_OneWingedAngel).setKeyblade((ItemKeyblade) OneWingedAngel);
        ((ItemKeychain)Chain_PainofSolitude).setKeyblade((ItemKeyblade) PainofSolitude);
        ((ItemKeychain)Chain_PhotonDebugger).setKeyblade((ItemKeyblade) PhotonDebugger);
        ((ItemKeychain)Chain_PixiePetal).setKeyblade((ItemKeyblade) PixiePetal);
        ((ItemKeychain)Chain_Pumpkinhead).setKeyblade((ItemKeyblade) Pumpkinhead);
        ((ItemKeychain)Chain_Rainfell).setKeyblade((ItemKeyblade) Rainfell);
        ((ItemKeychain)Chain_RejectionofFate).setKeyblade((ItemKeyblade) RejectionofFate);
        ((ItemKeychain)Chain_RoyalRadiance).setKeyblade((ItemKeyblade) RoyalRadiance);
        ((ItemKeychain)Chain_RumblingRose).setKeyblade((ItemKeyblade) RumblingRose);
        ((ItemKeychain)Chain_SignofInnocence).setKeyblade((ItemKeyblade) SignofInnocence);
        ((ItemKeychain)Chain_SilentDirge).setKeyblade((ItemKeyblade) SilentDirge);
        ((ItemKeychain)Chain_SkullNoise).setKeyblade((ItemKeyblade) SkullNoise);
        ((ItemKeychain)Chain_SleepingLion).setKeyblade((ItemKeyblade) SleepingLion);
        ((ItemKeychain)Chain_SoulEater).setKeyblade((ItemKeyblade) SoulEater);
        ((ItemKeychain)Chain_Spellbinder).setKeyblade((ItemKeyblade) Spellbinder);
        ((ItemKeychain)Chain_StarSeeker).setKeyblade((ItemKeyblade) StarSeeker);
        ((ItemKeychain)Chain_Starlight).setKeyblade((ItemKeyblade) Starlight);
        ((ItemKeychain)Chain_Stormfall).setKeyblade((ItemKeyblade) Stormfall);
        ((ItemKeychain)Chain_StrokeofMidnight).setKeyblade((ItemKeyblade) StrokeofMidnight);
        ((ItemKeychain)Chain_SweetDreams).setKeyblade((ItemKeyblade) SweetDreams);
        ((ItemKeychain)Chain_SweetMemories).setKeyblade((ItemKeyblade) SweetMemories);
        ((ItemKeychain)Chain_Sweetstack).setKeyblade((ItemKeyblade) Sweetstack);
        ((ItemKeychain)Chain_ThreeWishes).setKeyblade((ItemKeyblade) ThreeWishes);
        ((ItemKeychain)Chain_TotalEclipse).setKeyblade((ItemKeyblade) TotalEclipse);
        ((ItemKeychain)Chain_TreasureTrove).setKeyblade((ItemKeyblade) TreasureTrove);
        ((ItemKeychain)Chain_TrueLightsFlight).setKeyblade((ItemKeyblade) TrueLightsFlight);
        ((ItemKeychain)Chain_TwilightBlaze).setKeyblade((ItemKeyblade) TwilightBlaze);
        ((ItemKeychain)Chain_TwoBecomeOne).setKeyblade((ItemKeyblade) TwoBecomeOne);
        ((ItemKeychain)Chain_UltimaWeaponKH1).setKeyblade((ItemKeyblade) UltimaWeaponKH1);
        ((ItemKeychain)Chain_UltimaWeaponKH2).setKeyblade((ItemKeyblade) UltimaWeaponKH2);
        ((ItemKeychain)Chain_UltimaWeaponBBS).setKeyblade((ItemKeyblade) UltimaWeaponBBS);
        ((ItemKeychain)Chain_UltimaWeaponDDD).setKeyblade((ItemKeyblade) UltimaWeaponDDD);
        ((ItemKeychain)Chain_Umbrella).setKeyblade((ItemKeyblade) Umbrella);
        ((ItemKeychain)Chain_Unbound).setKeyblade((ItemKeyblade) Unbound);
        ((ItemKeychain)Chain_UnicornisForetellersKeyblade).setKeyblade((ItemKeyblade) UnicornisForetellersKeyblade);
        ((ItemKeychain)Chain_UrsusForetellersKeyblade).setKeyblade((ItemKeyblade) UrsusForetellersKeyblade);
        ((ItemKeychain)Chain_VictoryLine).setKeyblade((ItemKeyblade) VictoryLine);
        ((ItemKeychain)Chain_VoidGear).setKeyblade((ItemKeyblade) VoidGear);
        ((ItemKeychain)Chain_VulpeusForetellersKeyblade).setKeyblade((ItemKeyblade) VulpeusForetellersKeyblade);
        ((ItemKeychain)Chain_WaytotheDawn).setKeyblade((ItemKeyblade) WaytotheDawn);
        ((ItemKeychain)Chain_WaywardWind).setKeyblade((ItemKeyblade) WaywardWind);
        ((ItemKeychain)Chain_WinnersProof).setKeyblade((ItemKeyblade) WinnersProof);
        ((ItemKeychain)Chain_WishingLamp).setKeyblade((ItemKeyblade) WishingLamp);
        ((ItemKeychain)Chain_WishingStar).setKeyblade((ItemKeyblade) WishingStar);
        ((ItemKeychain)Chain_YoungXehanortsKeyblade).setKeyblade((ItemKeyblade) YoungXehanortsKeyblade);
        ((ItemKeychain)Chain_ZeroOne).setKeyblade((ItemKeyblade) ZeroOne);
    }

    @Mod.EventBusSubscriber(modid = Reference.MODID)
    public static class register {
        @SubscribeEvent
        public static void registerItems(RegistryEvent.Register<Item> event) {
            for (Item i : ModItems.ITEMS) {
                event.getRegistry().register(i);
            }
        }
    }
}
