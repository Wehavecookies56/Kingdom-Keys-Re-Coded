package uk.co.wehavecookies56.kk.common.lib;

import static uk.co.wehavecookies56.kk.common.item.ModItems.*;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.client.particle.ParticleSpell;
import net.minecraft.item.Item;

public class Lists {

	public static List<String> recipes = new ArrayList<String>();
	public static List<Item> orgWeapons = new ArrayList<Item>();
	public static List<Item> Xemnas = new ArrayList<Item>();
	public static List<Item> Xigbar = new ArrayList<Item>();
	public static void init () {

		//Xemnas
		Xemnas.add(Interdiction);
		Xemnas.add(Infinity);
		Xemnas.add(Sanction);
		Xemnas.add(Aggression);
		Xemnas.add(Malice);

		//Xigbar
		Xigbar.add(Sharpshooter);
		Xigbar.add(Killerbee);
		Xigbar.add(Standalone);
		Xigbar.add(FinalWeapon);
		Xigbar.add(Precision);
		Xigbar.add(Sunrise);

		//Xaldin
		orgWeapons.add(Crux);
		orgWeapons.add(Dragonreign);
		orgWeapons.add(Lindworm);
		orgWeapons.add(Zephyr);

		//Vexen
		orgWeapons.add(FrozenPride);
		orgWeapons.add(TesterZero);
		orgWeapons.add(ProductOne);
		orgWeapons.add(Inquisition);
		orgWeapons.add(FalseTheory);

		//Lexaeus
		orgWeapons.add(Skysplitter);
		orgWeapons.add(Reticence);

		//Zexion
		orgWeapons.add(BookofRetribution);
		orgWeapons.add(BlackPrimer);
		orgWeapons.add(Whitetime);

		//Saix
		orgWeapons.add(Lunatic);
		orgWeapons.add(Twilight);

		//Axel
		orgWeapons.add(EternalFlames);
		orgWeapons.add(BlazeofGlory);
		orgWeapons.add(Prometheus);
		orgWeapons.add(Ifrit);
		orgWeapons.add(Prominence);
		orgWeapons.add(Ashes);
		orgWeapons.add(Combustion);
		orgWeapons.add(Burnout);
		orgWeapons.add(Outbreak);
		//Demyx
		orgWeapons.add(Arpeggio);

		//luxord
		orgWeapons.add(FairGame);
		orgWeapons.add(TheFool);

		//Marluxia
		orgWeapons.add(GracefulDahlia);
		orgWeapons.add(FickleErica);
		orgWeapons.add(PoorMelissa);
		orgWeapons.add(JiltedAnemone);
		orgWeapons.add(HallowedLotus);
		orgWeapons.add(LoftyGerbera);

		//Laxene
		orgWeapons.add(Foudre);
		orgWeapons.add(Calmant);
		orgWeapons.add(Tranchant);
		orgWeapons.add(Orage);
		orgWeapons.add(Irregulier);
		orgWeapons.add(Eruption);
		orgWeapons.add(Indigo);
		orgWeapons.add(Lumineuse);
		orgWeapons.add(Tourbillon);


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
