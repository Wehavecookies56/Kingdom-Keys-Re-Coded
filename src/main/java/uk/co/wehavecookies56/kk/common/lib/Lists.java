package uk.co.wehavecookies56.kk.common.lib;

import static uk.co.wehavecookies56.kk.common.item.ModItems.*;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.client.particle.ParticleSpell;
import net.minecraft.item.Item;
import scala.collection.Seq;
import scala.reflect.internal.Trees;
import scala.tools.nsc.typechecker.Infer;
import sun.util.resources.cldr.xog.LocaleNames_xog;
import uk.co.wehavecookies56.kk.common.util.Utils;

public class Lists {

	public static List<String> recipes = new ArrayList<String>();

	public static List<Item> Xemnas = new ArrayList<Item>();
	public static List<Item> Xigbar = new ArrayList<Item>();
	public static List<Item> Xaldin = new ArrayList<Item>();
	public static List<Item> Vexen = new ArrayList<Item>();
	public static List<Item> Lexaeus = new ArrayList<Item>();
	public static List<Item> Zexion = new ArrayList<Item>();
	public static List<Item> Saix = new ArrayList<Item>();
	public static List<Item> Axel = new ArrayList<Item>();
	public static List<Item> Demyx = new ArrayList<Item>();
	public static List<Item> Luxord = new ArrayList<Item>();
	public static List<Item> Marluxia = new ArrayList<Item>();
	public static List<Item> Larxene = new ArrayList<Item>();
	public static List<Item> Roxas = new ArrayList<>();

	public static List<Item> getListForMember(Utils.OrgMember member) {
		switch (member) {
			case AXEL: return Axel;
			case DEMYX: return Demyx;
			case LARXENE: return Larxene;
			case LEXAEUS: return Lexaeus;
			case LUXORD: return Luxord;
			case MARLUXIA: return Marluxia;
			case ROXAS: return Roxas;
			case SAIX: return Saix;
			case VEXEN: return Vexen;
			case XALDIN: return Xaldin;
			case XEMNAS: return Xemnas;
			case XIGBAR: return Xigbar;
			case ZEXION: return Zexion;
			case NONE: return null;
		}
		return null;
	}

	public static void init () {

		//Xemnas
		Xemnas.add(Interdiction);
		Xemnas.add(Infinity);
		Xemnas.add(Sanction);
		Xemnas.add(Aggression);
		Xemnas.add(Malice);
		Xemnas.add(Absolute);

		//Xigbar
		Xigbar.add(Sharpshooter);
		Xigbar.add(Killerbee);
		Xigbar.add(Standalone);
		Xigbar.add(FinalWeapon);
		Xigbar.add(Precision);
		Xigbar.add(Sunrise);

		//Xaldin
		Xaldin.add(Crux);
		Xaldin.add(Dragonreign);
		Xaldin.add(Lindworm);
		Xaldin.add(Zephyr);

		//Vexen
		Vexen.add(FrozenPride);
		Vexen.add(TesterZero);
		Vexen.add(ProductOne);
		Vexen.add(Inquisition);
		Vexen.add(FalseTheory);
		Vexen.add(Aegis);
		Vexen.add(Contrivance);
		Vexen.add(Empiricism);

		//Lexaeus
		Lexaeus.add(Skysplitter);
		Lexaeus.add(Reticence);
		Lexaeus.add(Colossus);
		Lexaeus.add(Hyperion);
		Lexaeus.add(Sequoia);

		//Zexion
		Zexion.add(BookofRetribution);
		Zexion.add(BlackPrimer);
		Zexion.add(WhiteTome);

		//Saix
		Saix.add(Lunatic);
		Saix.add(Twilight);
		Saix.add(NewMoon);

		//Axel
		Axel.add(EternalFlames);
		Axel.add(Ashes);
		Axel.add(Combustion);
		Axel.add(BlazeofGlory);
		Axel.add(Burnout);
		Axel.add(Outbreak);
		Axel.add(Prometheus);
		Axel.add(Ifrit);
		Axel.add(OmegaTrinity);
		Axel.add(Prominence);
		Axel.add(MoulinRouge);
		Axel.add(FerrisWheel);
		Axel.add(Doldrums);
		Axel.add(Inferno);

		//Demyx
		Demyx.add(Arpeggio);

		//Luxord
		Luxord.add(FairGame);
		Luxord.add(TheFool);
		Luxord.add(FinestFantasy13);

		//Marluxia
		Marluxia.add(GracefulDahlia);
		Marluxia.add(FickleErica);
		Marluxia.add(PoorMelissa);
		Marluxia.add(JiltedAnemone);
		Marluxia.add(HallowedLotus);
		Marluxia.add(LoftyGerbera);
		Marluxia.add(QuietBelladonna);

		//Larxene
		Larxene.add(Foudre);
		Larxene.add(Carmin);
		Larxene.add(Trancheuse);
		Larxene.add(Indigo);
		Larxene.add(Orage);
		Larxene.add(Irregulier);
		Larxene.add(Eruption);
		Larxene.add(Lumineuse);
		Larxene.add(Tourbillon);
		Larxene.add(Rafale);
		Larxene.add(Typhon);
		Larxene.add(Tempete);

		Roxas.add(KingdomKey);
		Roxas.add(MissingAche);
		Roxas.add(OminousBlight);
		Roxas.add(AbaddonPlasma);
		Roxas.add(PainofSolitude);
		Roxas.add(SignofInnocence);
		Roxas.add(CrownofGuilt);
		Roxas.add(AbyssalTide);
		Roxas.add(Leviathan);
		Roxas.add(TrueLightsFlight);
		Roxas.add(RejectionofFate);
		Roxas.add(MidnightRoar);
		Roxas.add(GlimpseofDarkness);
		Roxas.add(TotalEclipse);
		Roxas.add(SilentDirge);
		Roxas.add(LunarEclipse);
		Roxas.add(DarkerThanDark);
		Roxas.add(AstralBlast);
		Roxas.add(MaverickFlare);
		Roxas.add(TwilightBlaze);
		Roxas.add(OmegaWeapon);
		Roxas.add(Oathkeeper);
		Roxas.add(TwoBecomeOne);
		Roxas.add(Oblivion);
		Roxas.add(Umbrella);
		Roxas.add(Aubade);
		Roxas.add(WoodenStick);

		//Keyblades
		recipes.add(AbaddonPlasma.getUnlocalizedName());
		recipes.add(AbyssalTide.getUnlocalizedName());
		recipes.add(AllforOne.getUnlocalizedName());
		recipes.add(AnguisForetellersKeyblade.getUnlocalizedName());
		recipes.add(AstralBlast.getUnlocalizedName());
		recipes.add(Aubade.getUnlocalizedName());
		recipes.add(BondofFlame.getUnlocalizedName());
		recipes.add(Brightcrest.getUnlocalizedName());
		recipes.add(ChaosRipper.getUnlocalizedName());
		recipes.add(CircleofLife.getUnlocalizedName());
		recipes.add(Counterpoint.getUnlocalizedName());
		recipes.add(Crabclaw.getUnlocalizedName());
		recipes.add(CrownofGuilt.getUnlocalizedName());
		recipes.add(DarkerThanDark.getUnlocalizedName());
		recipes.add(Darkgnaw.getUnlocalizedName());
		recipes.add(DecisivePumpkin.getUnlocalizedName());
		recipes.add(DestinysEmbrace.getUnlocalizedName());
		recipes.add(DiamondDust.getUnlocalizedName());
		recipes.add(Divewing.getUnlocalizedName());
		recipes.add(DivineRose.getUnlocalizedName());
		recipes.add(DreamSword.getUnlocalizedName());
		recipes.add(DualDisc.getUnlocalizedName());
		recipes.add(Earthshaker.getUnlocalizedName());
		recipes.add(EndofPain.getUnlocalizedName());
		recipes.add(EndsoftheEarth.getUnlocalizedName());
		recipes.add(FairyHarp.getUnlocalizedName());
		recipes.add(FairyStars.getUnlocalizedName());
		recipes.add(FatalCrest.getUnlocalizedName());
		recipes.add(Fenrir.getUnlocalizedName());
		recipes.add(FerrisGear.getUnlocalizedName());
		recipes.add(FollowtheWind.getUnlocalizedName());
		recipes.add(FrolicFlame.getUnlocalizedName());
		recipes.add(GlimpseofDarkness.getUnlocalizedName());
		recipes.add(GuardianBell.getUnlocalizedName());
		recipes.add(GuardianSoul.getUnlocalizedName());
		recipes.add(GullWing.getUnlocalizedName());
		recipes.add(HerosCrest.getUnlocalizedName());
		recipes.add(HiddenDragon.getUnlocalizedName());
		recipes.add(Hyperdrive.getUnlocalizedName());
		recipes.add(IncompleteKiblade.getUnlocalizedName());
		recipes.add(JungleKing.getUnlocalizedName());
		recipes.add(KeybladeofPeoplesHearts.getUnlocalizedName());
		recipes.add(Kiblade.getUnlocalizedName());
		recipes.add(KingdomKey.getUnlocalizedName());
		recipes.add(KingdomKeyD.getUnlocalizedName());
		recipes.add(KnockoutPunch.getUnlocalizedName());
		recipes.add(LadyLuck.getUnlocalizedName());
		recipes.add(LeasKeyblade.getUnlocalizedName());
		recipes.add(LeopardosForetellersKeyblade.getUnlocalizedName());
		recipes.add(Leviathan.getUnlocalizedName());
		recipes.add(Lionheart.getUnlocalizedName());
		recipes.add(LostMemory.getUnlocalizedName());
		recipes.add(LunarEclipse.getUnlocalizedName());
		recipes.add(MarkofaHero.getUnlocalizedName());
		recipes.add(MastersDefender.getUnlocalizedName());
		recipes.add(MasterXehanortsKeyblade.getUnlocalizedName());
		recipes.add(MaverickFlare.getUnlocalizedName());
		recipes.add(MetalChocobo.getUnlocalizedName());
		recipes.add(MidnightRoar.getUnlocalizedName());
		recipes.add(MirageSplit.getUnlocalizedName());
		recipes.add(MissingAche.getUnlocalizedName());
		recipes.add(Monochrome.getUnlocalizedName());
		recipes.add(MysteriousAbyss.getUnlocalizedName());
		recipes.add(NightmaresEnd.getUnlocalizedName());
		recipes.add(NightmaresEndandMirageSplit.getUnlocalizedName());
		recipes.add(NoName.getUnlocalizedName());
		recipes.add(Oathkeeper.getUnlocalizedName());
		recipes.add(Oblivion.getUnlocalizedName());
		recipes.add(OceansRage.getUnlocalizedName());
		recipes.add(Olympia.getUnlocalizedName());
		recipes.add(OmegaWeapon.getUnlocalizedName());
		recipes.add(OminousBlight.getUnlocalizedName());
		recipes.add(OneWingedAngel.getUnlocalizedName());
		recipes.add(PainofSolitude.getUnlocalizedName());
		recipes.add(PhotonDebugger.getUnlocalizedName());
		recipes.add(PixiePetal.getUnlocalizedName());
		recipes.add(Pumpkinhead.getUnlocalizedName());
		recipes.add(Rainfell.getUnlocalizedName());
		recipes.add(RejectionofFate.getUnlocalizedName());
		recipes.add(RoyalRadiance.getUnlocalizedName());
		recipes.add(RumblingRose.getUnlocalizedName());
		recipes.add(SignofInnocence.getUnlocalizedName());
		recipes.add(SilentDirge.getUnlocalizedName());
		recipes.add(SkullNoise.getUnlocalizedName());
		recipes.add(SleepingLion.getUnlocalizedName());
		recipes.add(SoulEater.getUnlocalizedName());
		recipes.add(Spellbinder.getUnlocalizedName());
		recipes.add(Starlight.getUnlocalizedName());
		recipes.add(StarSeeker.getUnlocalizedName());
		recipes.add(Stormfall.getUnlocalizedName());
		recipes.add(StrokeofMidnight.getUnlocalizedName());
		recipes.add(SweetDreams.getUnlocalizedName());
		recipes.add(SweetMemories.getUnlocalizedName());
		recipes.add(Sweetstack.getUnlocalizedName());
		recipes.add(ThreeWishes.getUnlocalizedName());
		recipes.add(TotalEclipse.getUnlocalizedName());
		recipes.add(TreasureTrove.getUnlocalizedName());
		recipes.add(TrueLightsFlight.getUnlocalizedName());
		recipes.add(TwilightBlaze.getUnlocalizedName());
		recipes.add(TwoBecomeOne.getUnlocalizedName());
		recipes.add(UltimaWeaponBBS.getUnlocalizedName());
		recipes.add(UltimaWeaponDDD.getUnlocalizedName());
		recipes.add(UltimaWeaponKH1.getUnlocalizedName());
		recipes.add(UltimaWeaponKH2.getUnlocalizedName());
		recipes.add(Umbrella.getUnlocalizedName());
		recipes.add(Unbound.getUnlocalizedName());
		recipes.add(UnicornisForetellersKeyblade.getUnlocalizedName());
		recipes.add(UrsusForetellersKeyblade.getUnlocalizedName());
		recipes.add(VictoryLine.getUnlocalizedName());
		recipes.add(VoidGear.getUnlocalizedName());
		recipes.add(VulpeusForetellersKeyblade.getUnlocalizedName());
		recipes.add(WaytotheDawn.getUnlocalizedName());
		recipes.add(WaywardWind.getUnlocalizedName());
		recipes.add(WinnersProof.getUnlocalizedName());
		recipes.add(WishingLamp.getUnlocalizedName());
		recipes.add(WishingStar.getUnlocalizedName());
		recipes.add(WoodenKeyblade.getUnlocalizedName());
		recipes.add(WoodenStick.getUnlocalizedName());
		recipes.add(YoungXehanortsKeyblade.getUnlocalizedName());
		recipes.add(ZeroOne.getUnlocalizedName());
	}

}
