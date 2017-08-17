package uk.co.wehavecookies56.kk.client.core.proxy;

import static uk.co.wehavecookies56.kk.common.block.ModBlocks.BlastBlox;
import static uk.co.wehavecookies56.kk.common.block.ModBlocks.BlazingOre;
import static uk.co.wehavecookies56.kk.common.block.ModBlocks.BounceBlox;
import static uk.co.wehavecookies56.kk.common.block.ModBlocks.BrightOre;
import static uk.co.wehavecookies56.kk.common.block.ModBlocks.DangerBlox;
import static uk.co.wehavecookies56.kk.common.block.ModBlocks.DarkOre;
import static uk.co.wehavecookies56.kk.common.block.ModBlocks.DarkOreE;
import static uk.co.wehavecookies56.kk.common.block.ModBlocks.DenseOre;
import static uk.co.wehavecookies56.kk.common.block.ModBlocks.EnergyOre;
import static uk.co.wehavecookies56.kk.common.block.ModBlocks.FrostOre;
import static uk.co.wehavecookies56.kk.common.block.ModBlocks.GhostBlox;
import static uk.co.wehavecookies56.kk.common.block.ModBlocks.HardBlox;
import static uk.co.wehavecookies56.kk.common.block.ModBlocks.KKChest;
import static uk.co.wehavecookies56.kk.common.block.ModBlocks.LightningOre;
import static uk.co.wehavecookies56.kk.common.block.ModBlocks.LucidOre;
import static uk.co.wehavecookies56.kk.common.block.ModBlocks.MagnetBlox;
import static uk.co.wehavecookies56.kk.common.block.ModBlocks.MetalBlox;
import static uk.co.wehavecookies56.kk.common.block.ModBlocks.NormalBlox;
import static uk.co.wehavecookies56.kk.common.block.ModBlocks.OrgPortal;
import static uk.co.wehavecookies56.kk.common.block.ModBlocks.Pedestal;
import static uk.co.wehavecookies56.kk.common.block.ModBlocks.PowerOre;
import static uk.co.wehavecookies56.kk.common.block.ModBlocks.PowerOreE;
import static uk.co.wehavecookies56.kk.common.block.ModBlocks.PrizeBlox;
import static uk.co.wehavecookies56.kk.common.block.ModBlocks.RarePrizeBlox;
import static uk.co.wehavecookies56.kk.common.block.ModBlocks.RemembranceOre;
import static uk.co.wehavecookies56.kk.common.block.ModBlocks.SavePoint;
import static uk.co.wehavecookies56.kk.common.block.ModBlocks.SerenityOre;
import static uk.co.wehavecookies56.kk.common.block.ModBlocks.StationOfAwakening;
import static uk.co.wehavecookies56.kk.common.block.ModBlocks.StationOfAwakeningDoor;
import static uk.co.wehavecookies56.kk.common.block.ModBlocks.StormyOre;
import static uk.co.wehavecookies56.kk.common.block.ModBlocks.SynthesisTable;
import static uk.co.wehavecookies56.kk.common.block.ModBlocks.TranquilOre;
import static uk.co.wehavecookies56.kk.common.block.ModBlocks.TwilightOre;
import static uk.co.wehavecookies56.kk.common.item.ModItems.*;

import com.jadarstudios.developercapes.DevCapes;

import net.minecraft.client.Minecraft;
import net.minecraft.client.particle.Particle;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.client.renderer.entity.RenderLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.util.IThreadListener;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.client.model.b3d.B3DLoader;
import net.minecraftforge.client.model.obj.OBJLoader;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.client.registry.IRenderFactory;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;
import net.minecraftforge.fml.relauncher.Side;
import uk.co.wehavecookies56.kk.client.core.handler.ClientEventHandler;
import uk.co.wehavecookies56.kk.client.core.handler.InputHandler;
import uk.co.wehavecookies56.kk.client.fx.EntityParticleFXTest;
import uk.co.wehavecookies56.kk.client.gui.GuiCommandMenu;
import uk.co.wehavecookies56.kk.client.gui.GuiDrive;
import uk.co.wehavecookies56.kk.client.gui.GuiHP;
import uk.co.wehavecookies56.kk.client.gui.GuiLockOn;
import uk.co.wehavecookies56.kk.client.gui.GuiMP;
import uk.co.wehavecookies56.kk.client.gui.GuiOverlay;
import uk.co.wehavecookies56.kk.client.gui.GuiPlayerPortrait;
import uk.co.wehavecookies56.kk.client.model.mobs.ModelMoogle;
import uk.co.wehavecookies56.kk.client.model.mobs.ModelRedNocturne;
import uk.co.wehavecookies56.kk.client.model.mobs.ModelShadow;
import uk.co.wehavecookies56.kk.client.render.LayerRendererDrive;
import uk.co.wehavecookies56.kk.client.render.RenderEntityAshes;
import uk.co.wehavecookies56.kk.client.render.RenderEntityBlazeofGlory;
import uk.co.wehavecookies56.kk.client.render.RenderEntityBurnout;
import uk.co.wehavecookies56.kk.client.render.RenderEntityCombustion;
import uk.co.wehavecookies56.kk.client.render.RenderEntityDoledrum;
import uk.co.wehavecookies56.kk.client.render.RenderEntityDoubleEdge;
import uk.co.wehavecookies56.kk.client.render.RenderEntityEternalFlames;
import uk.co.wehavecookies56.kk.client.render.RenderEntityFerrisWheel;
import uk.co.wehavecookies56.kk.client.render.RenderEntityIfrit;
import uk.co.wehavecookies56.kk.client.render.RenderEntityInferno;
import uk.co.wehavecookies56.kk.client.render.RenderEntityMoulinRouge;
import uk.co.wehavecookies56.kk.client.render.RenderEntityOmegaTrinity;
import uk.co.wehavecookies56.kk.client.render.RenderEntityOutbreak;
import uk.co.wehavecookies56.kk.client.render.RenderEntityPrometheus;
import uk.co.wehavecookies56.kk.client.render.RenderEntityProminence;
import uk.co.wehavecookies56.kk.client.render.RenderEntitySizzlingEdge;
import uk.co.wehavecookies56.kk.client.render.RenderFactoryBlastBlox;
import uk.co.wehavecookies56.kk.client.render.RenderFactorySharpshooterBullet;
import uk.co.wehavecookies56.kk.client.render.RenderKHMob;
import uk.co.wehavecookies56.kk.client.render.TESRPedestal;
import uk.co.wehavecookies56.kk.common.KingdomKeys;
import uk.co.wehavecookies56.kk.common.block.tile.TileEntityPedestal;
import uk.co.wehavecookies56.kk.common.core.proxy.CommonProxy;
import uk.co.wehavecookies56.kk.common.entity.block.EntityBlastBlox;
import uk.co.wehavecookies56.kk.common.entity.mobs.EntityBlueRhapsody;
import uk.co.wehavecookies56.kk.common.entity.mobs.EntityGigaShadow;
import uk.co.wehavecookies56.kk.common.entity.mobs.EntityGreenRequiem;
import uk.co.wehavecookies56.kk.common.entity.mobs.EntityMoogle;
import uk.co.wehavecookies56.kk.common.entity.mobs.EntityRedNocturne;
import uk.co.wehavecookies56.kk.common.entity.mobs.EntityShadow;
import uk.co.wehavecookies56.kk.common.entity.mobs.EntityYellowOpera;
import uk.co.wehavecookies56.kk.common.entity.projectiles.EntityAshes;
import uk.co.wehavecookies56.kk.common.entity.projectiles.EntityBlazeofGlory;
import uk.co.wehavecookies56.kk.common.entity.projectiles.EntityBurnout;
import uk.co.wehavecookies56.kk.common.entity.projectiles.EntityCombustion;
import uk.co.wehavecookies56.kk.common.entity.projectiles.EntityDoledrum;
import uk.co.wehavecookies56.kk.common.entity.projectiles.EntityDoubleEdge;
import uk.co.wehavecookies56.kk.common.entity.projectiles.EntityEternalFlames;
import uk.co.wehavecookies56.kk.common.entity.projectiles.EntityFerrisWheels;
import uk.co.wehavecookies56.kk.common.entity.projectiles.EntityIfrit;
import uk.co.wehavecookies56.kk.common.entity.projectiles.EntityInferno;
import uk.co.wehavecookies56.kk.common.entity.projectiles.EntityMoulinRouge;
import uk.co.wehavecookies56.kk.common.entity.projectiles.EntityOmegaTrinity;
import uk.co.wehavecookies56.kk.common.entity.projectiles.EntityOutbreak;
import uk.co.wehavecookies56.kk.common.entity.projectiles.EntityPrometheus;
import uk.co.wehavecookies56.kk.common.entity.projectiles.EntityProminence;
import uk.co.wehavecookies56.kk.common.entity.projectiles.EntitySharpshooterBullet;
import uk.co.wehavecookies56.kk.common.entity.projectiles.EntitySizzlingEdge;
import uk.co.wehavecookies56.kk.common.lib.Reference;

@Mod.EventBusSubscriber(value = Side.CLIENT, modid = Reference.MODID)
public class ClientProxy extends CommonProxy {

    @SubscribeEvent
    public static void registerModels(ModelRegistryEvent event) {
        B3DLoader.INSTANCE.addDomain(Reference.MODID);
        OBJLoader.INSTANCE.addDomain(Reference.MODID);

        registerModel(DreamShield);

        //Keyblades
        registerModel(AbaddonPlasma);
        registerModel(AbyssalTide);
        registerModel(AllforOne);
        registerModel(AnguisForetellersKeyblade);
        registerModel(AstralBlast);
        registerModel(Aubade);
        registerModel(BondofFlame);
        registerModel(Brightcrest);
        registerModel(ChaosRipper);
        registerModel(CircleofLife);
        registerModel(Counterpoint);
        registerModel(Crabclaw);
        registerModel(CrownofGuilt);
        registerModel(DarkerThanDark);
        registerModel(Darkgnaw);
        registerModel(DecisivePumpkin);
        registerModel(DestinysEmbrace);
        registerModel(DiamondDust);
        registerModel(Divewing);
        registerModel(DivineRose);
        registerModel(DreamSword);
        registerModel(DualDisc);
        registerModel(Earthshaker);
        registerModel(EndofPain);
        registerModel(EndsoftheEarth);
        registerModel(FairyHarp);
        registerModel(FairyStars);
        registerModel(FatalCrest);
        registerModel(Fenrir);
        registerModel(FerrisGear);
        registerModel(FollowtheWind);
        registerModel(FrolicFlame);
        registerModel(GlimpseofDarkness);
        registerModel(GuardianBell);
        registerModel(GuardianSoul);
        registerModel(GullWing);
        registerModel(HerosCrest);
        registerModel(HiddenDragon);
        registerModel(Hyperdrive);
        registerModel(IncompleteKiblade);
        registerModel(JungleKing);
        registerModel(KeybladeofPeoplesHearts);
        registerModel(Kiblade);
        registerModel(KingdomKey);
        registerModel(KingdomKeyD);
        registerModel(KnockoutPunch);
        registerModel(LadyLuck);
        registerModel(LeasKeyblade);
        registerModel(LeopardosForetellersKeyblade);
        registerModel(Leviathan);
        registerModel(Lionheart);
        registerModel(LostMemory);
        registerModel(LunarEclipse);
        registerModel(MarkofaHero);
        registerModel(MastersDefender);
        registerModel(MasterXehanortsKeyblade);
        registerModel(MaverickFlare);
        registerModel(MetalChocobo);
        registerModel(MidnightRoar);
        registerModel(MirageSplit);
        registerModel(MissingAche);
        registerModel(Monochrome);
        registerModel(MysteriousAbyss);
        registerModel(NightmaresEnd);
        registerModel(NightmaresEndandMirageSplit);
        registerModel(NoName);
        registerModel(Oathkeeper);
        registerModel(Oblivion);
        registerModel(OceansRage);
        registerModel(Olympia);
        registerModel(OmegaWeapon);
        registerModel(OminousBlight);
        registerModel(OneWingedAngel);
        registerModel(PainofSolitude);
        registerModel(PhotonDebugger);
        registerModel(PixiePetal);
        registerModel(Pumpkinhead);
        registerModel(Rainfell);
        registerModel(RejectionofFate);
        registerModel(RoyalRadiance);
        registerModel(RumblingRose);
        registerModel(SignofInnocence);
        registerModel(SilentDirge);
        registerModel(SkullNoise);
        registerModel(SleepingLion);
        registerModel(SoulEater);
        registerModel(Spellbinder);
        registerModel(Starlight);
        registerModel(StarSeeker);
        registerModel(Stormfall);
        registerModel(StrokeofMidnight);
        registerModel(SweetDreams);
        registerModel(SweetMemories);
        registerModel(Sweetstack);
        registerModel(ThreeWishes);
        registerModel(TotalEclipse);
        registerModel(TreasureTrove);
        registerModel(TrueLightsFlight);
        registerModel(TwilightBlaze);
        registerModel(TwoBecomeOne);
        registerModel(UltimaWeaponBBS);
        registerModel(UltimaWeaponDDD);
        registerModel(UltimaWeaponKH1);
        registerModel(UltimaWeaponKH2);
        registerModel(Umbrella);
        registerModel(Unbound);
        registerModel(UnicornisForetellersKeyblade);
        registerModel(UrsusForetellersKeyblade);
        registerModel(VictoryLine);
        registerModel(VoidGear);
        registerModel(VulpeusForetellersKeyblade);
        registerModel(WaytotheDawn);
        registerModel(WaywardWind);
        registerModel(WinnersProof);
        registerModel(WishingLamp);
        registerModel(WishingStar);
        registerModel(WoodenKeyblade);
        registerModel(WoodenStick);
        registerModel(YoungXehanortsKeyblade);
        registerModel(ZeroOne);

        //Keychains
        registerModel(Chain_AbaddonPlasma);
        registerModel(Chain_AbyssalTide);
        registerModel(Chain_AllforOne);
        registerModel(Chain_AnguisForetellersKeyblade);
        registerModel(Chain_AstralBlast);
        registerModel(Chain_Aubade);
        registerModel(Chain_BondofFlame);
        registerModel(Chain_Brightcrest);
        registerModel(Chain_ChaosRipper);
        registerModel(Chain_CircleofLife);
        registerModel(Chain_Counterpoint);
        registerModel(Chain_Crabclaw);
        registerModel(Chain_CrownofGuilt);
        registerModel(Chain_DarkerThanDark);
        registerModel(Chain_Darkgnaw);
        registerModel(Chain_DecisivePumpkin);
        registerModel(Chain_DestinysEmbrace);
        registerModel(Chain_DiamondDust);
        registerModel(Chain_Divewing);
        registerModel(Chain_DivineRose);
        registerModel(Chain_DreamSword);
        registerModel(Chain_DualDisc);
        registerModel(Chain_Earthshaker);
        registerModel(Chain_EndofPain);
        registerModel(Chain_EndsoftheEarth);
        registerModel(Chain_FairyHarp);
        registerModel(Chain_FairyStars);
        registerModel(Chain_FatalCrest);
        registerModel(Chain_Fenrir);
        registerModel(Chain_FerrisGear);
        registerModel(Chain_FollowtheWind);
        registerModel(Chain_FrolicFlame);
        registerModel(Chain_GlimpseofDarkness);
        registerModel(Chain_GuardianBell);
        registerModel(Chain_GuardianSoul);
        registerModel(Chain_GullWing);
        registerModel(Chain_HerosCrest);
        registerModel(Chain_HiddenDragon);
        registerModel(Chain_Hyperdrive);
        registerModel(Chain_IncompleteKiblade);
        registerModel(Chain_JungleKing);
        registerModel(Chain_KeybladeofPeoplesHearts);
        registerModel(Chain_Kiblade);
        registerModel(Chain_KingdomKey);
        registerModel(Chain_KingdomKeyD);
        registerModel(Chain_KnockoutPunch);
        registerModel(Chain_LadyLuck);
        registerModel(Chain_LeasKeyblade);
        registerModel(Chain_LeopardosForetellersKeyblade);
        registerModel(Chain_Leviathan);
        registerModel(Chain_Lionheart);
        registerModel(Chain_LostMemory);
        registerModel(Chain_LunarEclipse);
        registerModel(Chain_MarkofaHero);
        registerModel(Chain_MastersDefender);
        registerModel(Chain_MasterXehanortsKeyblade);
        registerModel(Chain_MaverickFlare);
        registerModel(Chain_MetalChocobo);
        registerModel(Chain_MidnightRoar);
        registerModel(Chain_MirageSplit);
        registerModel(Chain_MissingAche);
        registerModel(Chain_Monochrome);
        registerModel(Chain_MysteriousAbyss);
        registerModel(Chain_NightmaresEnd);
        registerModel(Chain_NightmaresEndandMirageSplit);
        registerModel(Chain_NoName);
        registerModel(Chain_Oathkeeper);
        registerModel(Chain_Oblivion);
        registerModel(Chain_OceansRage);
        registerModel(Chain_Olympia);
        registerModel(Chain_OmegaWeapon);
        registerModel(Chain_OminousBlight);
        registerModel(Chain_OneWingedAngel);
        registerModel(Chain_PainofSolitude);
        registerModel(Chain_PhotonDebugger);
        registerModel(Chain_PixiePetal);
        registerModel(Chain_Pumpkinhead);
        registerModel(Chain_Rainfell);
        registerModel(Chain_RejectionofFate);
        registerModel(Chain_RoyalRadiance);
        registerModel(Chain_RumblingRose);
        registerModel(Chain_SignofInnocence);
        registerModel(Chain_SilentDirge);
        registerModel(Chain_SkullNoise);
        registerModel(Chain_SleepingLion);
        registerModel(Chain_SoulEater);
        registerModel(Chain_Spellbinder);
        registerModel(Chain_Starlight);
        registerModel(Chain_StarSeeker);
        registerModel(Chain_Stormfall);
        registerModel(Chain_StrokeofMidnight);
        registerModel(Chain_SweetDreams);
        registerModel(Chain_SweetMemories);
        registerModel(Chain_Sweetstack);
        registerModel(Chain_ThreeWishes);
        registerModel(Chain_TotalEclipse);
        registerModel(Chain_TreasureTrove);
        registerModel(Chain_TrueLightsFlight);
        registerModel(Chain_TwilightBlaze);
        registerModel(Chain_TwoBecomeOne);
        registerModel(Chain_UltimaWeaponBBS);
        registerModel(Chain_UltimaWeaponDDD);
        registerModel(Chain_UltimaWeaponKH1);
        registerModel(Chain_UltimaWeaponKH2);
        registerModel(Chain_Umbrella);
        registerModel(Chain_Unbound);
        registerModel(Chain_UnicornisForetellersKeyblade);
        registerModel(Chain_UrsusForetellersKeyblade);
        registerModel(Chain_VictoryLine);
        registerModel(Chain_VoidGear);
        registerModel(Chain_VulpeusForetellersKeyblade);
        registerModel(Chain_WaytotheDawn);
        registerModel(Chain_WaywardWind);
        registerModel(Chain_WinnersProof);
        registerModel(Chain_WishingLamp);
        registerModel(Chain_WishingStar);
        registerModel(Chain_YoungXehanortsKeyblade);
        registerModel(Chain_ZeroOne);

        registerModel(BlazingInfusedCoal);
        registerModel(FrostInfusedSnowBall);
        registerModel(StormyInfusedIron);
        registerModel(MythrilInfusedDiamond);
        registerModel(LightningInfusedGold);
        registerModel(BrightInfusedGlowStone);
        registerModel(DarkInfusedIron);

        registerModel(AbandonedKnowledge);

        registerModel(OrganizationRobe_Helmet);
        registerModel(OrganizationRobe_Chestplate);
        registerModel(OrganizationRobe_Leggings);
        registerModel(OrganizationRobe_Boots);

        registerModel(Terra_Helmet);
        registerModel(Terra_Chestplate);
        registerModel(Terra_Leggings);
        registerModel(Terra_Boots);

        registerModel(Aqua_Helmet);
        registerModel(Aqua_Chestplate);
        registerModel(Aqua_Leggings);
        registerModel(Aqua_Boots);

        registerModel(Ventus_Helmet);
        registerModel(Ventus_Chestplate);
        registerModel(Ventus_Leggings);
        registerModel(Ventus_Boots);

        registerModel(Eraqus_Helmet);
        registerModel(Eraqus_Chestplate);
        registerModel(Eraqus_Leggings);
        registerModel(Eraqus_Boots);

        registerModel(Munny);
        registerModel(EmptyBottle);
        registerModel(Potion);
        registerModel(HiPotion);
        registerModel(MegaPotion);
        registerModel(Ether);
        registerModel(MegaEther);
        registerModel(Elixir);
        registerModel(Megalixir);
        registerModel(DriveRecovery);
        registerModel(HighDriveRecovery);
        registerModel(DefenseBoost);
        registerModel(MagicBoost);
        registerModel(PowerBoost);
        registerModel(Panacaea);

        registerModel(HpOrb);
        registerModel(DriveOrb);
        registerModel(MagicOrb);
        registerModel(Heart);
        registerModel(DarkHeart);
        registerModel(PureHeart);
        registerModel(KingdomHearts);
        registerModel(DarkLeather);
        registerModel(SynthesisMaterial);
        registerModel(IceCream);
        registerModel(WinnerStick);

        registerModel(LevelUpMagicFire);
        registerModel(LevelUpMagicBlizzard);
        registerModel(LevelUpMagicThunder);
        registerModel(LevelUpMagicCure);
        registerModel(LevelUpMagicAero);
        registerModel(LevelUpMagicStop);

        registerModel(LevelUpValor);
        registerModel(LevelUpWisdom);
        registerModel(LevelUpLimit);
        registerModel(LevelUpMaster);
        registerModel(LevelUpFinal);

        registerModel(SynthesisBagS);
        registerModel(SynthesisBagM);
        registerModel(SynthesisBagL);

        registerModel(Disc_Birth_by_Sleep_A_Link_to_the_Future);
        registerModel(Disc_Darkness_of_the_Unknown);
        registerModel(Disc_Dearly_Beloved_Symphony_Version);
        registerModel(Disc_Dream_Drop_Distance_The_Next_Awakening);
        registerModel(Disc_Hikari_KINGDOM_Instrumental_Version);
        registerModel(Disc_L_Oscurita_Dell_Ignoto);
        registerModel(Disc_Musique_pour_la_tristesse_de_Xion);
        registerModel(Disc_No_More_Bugs_Bug_Version);
        registerModel(Disc_Organization_XIII);
        registerModel(Disc_Sanctuary);
        registerModel(Disc_Simple_And_Clean_PLANITb_Remix);
        registerModel(Disc_Sinister_Sundown);
        registerModel(Disc_The_13th_Anthology);

        registerModel(Recipe);

        //Organization

        // xemnas
        registerModel(Malice);
        registerModel(Sanction);
        registerModel(Overlord);
        registerModel(Veneration);
        registerModel(Autocracy);
        registerModel(Conquest);
        registerModel(Terminus);
        registerModel(Judgement);
        registerModel(Discipline);
        registerModel(Aristocracy);
        registerModel(Superiority);
        registerModel(Aggression);
        registerModel(Fury);
        registerModel(Despair);
        registerModel(Triumph);
        registerModel(Ruination);
        registerModel(Domination);
        registerModel(Annihilation);
        registerModel(Tyrant);
        registerModel(Magnificence);
        registerModel(Infinity);
        registerModel(Interdiction);
        registerModel(RoundFan);
        registerModel(Absolute);

        // xigbar
        registerModel(Standalone);
        registerModel(Killerbee);
        registerModel(Stingray);
        registerModel(Counterweight);
        registerModel(Precision);
        registerModel(DualHead);
        registerModel(Bahamut);
        registerModel(Gullwing);
        registerModel(BlueFrame);
        registerModel(StarShell);
        registerModel(Sunrise);
        registerModel(Ignition);
        registerModel(Armstrong);
        registerModel(HardBoiledHeat);
        registerModel(DiabloEye);
        registerModel(DoubleTap);
        registerModel(Stardust);
        registerModel(EnergyMuzzle);
        registerModel(CrimeAndPunishment);
        registerModel(CupidsArrow);
        registerModel(FinalWeapon);
        registerModel(Sharpshooter);
        registerModel(Dryer);
        registerModel(Trumpet);

        // xaldin
        registerModel(Zephyr);
        registerModel(Moonglade);
        registerModel(Aer);
        registerModel(Nescience);
        registerModel(Brume);
        registerModel(Asura);
        registerModel(Crux);
        registerModel(Paladin);
        registerModel(Fellking);
        registerModel(Nightcloud);
        registerModel(Shimmer);
        registerModel(Vortex);
        registerModel(Scission);
        registerModel(Heavenfall);
        registerModel(Aether);
        registerModel(Mazzaroth);
        registerModel(Hegemon);
        registerModel(Foxfire);
        registerModel(Yaksha);
        registerModel(Cynosura);
        registerModel(Dragonreign);
        registerModel(Lindworm);
        registerModel(Broom);
        registerModel(Wyvern);

        // vexen
        registerModel(TesterZero);
        registerModel(ProductOne);
        registerModel(DeepFreeze);
        registerModel(CryoliteShield);
        registerModel(FalseTheory);
        registerModel(Glacier);
        registerModel(AbsoluteZero);
        registerModel(Gunz);
        registerModel(Mindel);
        registerModel(Snowslide);
        registerModel(Iceberg);
        registerModel(Inquisition);
        registerModel(Scrutiny);
        registerModel(Empiricism);
        registerModel(Edification);
        registerModel(Contrivance);
        registerModel(Wurm);
        registerModel(Subzero);
        registerModel(ColdBlood);
        registerModel(DiamondShield);
        registerModel(Aegis);
        registerModel(FrozenPride);
        registerModel(PotLid);
        registerModel(Snowman);

        // lexeaus
        registerModel(Reticence);
        registerModel(Goliath);
        registerModel(CopperRed);
        registerModel(Daybreak);
        registerModel(Colossus);
        registerModel(UrsaMajor);
        registerModel(Megacosm);
        registerModel(Terrene);
        registerModel(Fuligin);
        registerModel(HardWinter);
        registerModel(Firefly);
        registerModel(Harbinger);
        registerModel(Redwood);
        registerModel(Sequoia);
        registerModel(IronBlack);
        registerModel(Earthshine);
        registerModel(Octiron);
        registerModel(Hyperion);
        registerModel(Clarity);
        registerModel(OneThousandAndOneNights);
        registerModel(CardinalVirtue);
        registerModel(Skysplitter);
        registerModel(BleepBloopBop);
        registerModel(Monolith);

        // zexion
        registerModel(BlackPrimer);
        registerModel(WhiteTome);
        registerModel(IllicitResearch);
        registerModel(BuriedSecrets);
        registerModel(ArcaneCompendium);
        registerModel(DissentersNotes);
        registerModel(NefariousCodex);
        registerModel(MysticAlbum);
        registerModel(CursedManual);
        registerModel(TabooText);
        registerModel(EldritchEsoterica);
        registerModel(FreakishBestiary);
        registerModel(MadmansVita);
        registerModel(UntitledWritings);
        registerModel(AbandonedDogma);
        registerModel(AtlasOfOmens);
        registerModel(RevoltingScrapbook);
        registerModel(LostHeterodoxy);
        registerModel(OtherworldlyTales);
        registerModel(IndescribableLore);
        registerModel(RadicalTreatise);
        registerModel(BookofRetribution);
        registerModel(MidnightSnack);
        registerModel(DearDiary);

        // saix
        registerModel(NewMoon);
        registerModel(Werewolf);
        registerModel(Artemis);
        registerModel(Luminary);
        registerModel(Selene);
        registerModel(Moonrise);
        registerModel(Astrologia);
        registerModel(Crater);
        registerModel(LunarPhase);
        registerModel(Crescent);
        registerModel(Gibbous);
        registerModel(Berserker);
        registerModel(Twilight);
        registerModel(QueenOfTheNight);
        registerModel(BalsamicMoon);
        registerModel(Orbit);
        registerModel(LightYear);
        registerModel(KingOfTheNight);
        registerModel(Moonset);
        registerModel(Horoscope);
        registerModel(Dichotomy);
        registerModel(Lunatic);
        registerModel(JustDesserts);
        registerModel(Bunnymoon);

        // saix berserk
        registerModel(NewMoon, 1, NewMoon.getRegistryName() + "_b");
        registerModel(Werewolf, 1, Werewolf.getRegistryName() + "_b");
        registerModel(Artemis, 1, Artemis.getRegistryName() + "_b");
        registerModel(Luminary, 1, Luminary.getRegistryName() + "_b");
        registerModel(Selene, 1, Selene.getRegistryName() + "_b");
        registerModel(Moonrise, 1, Moonrise.getRegistryName() + "_b");
        registerModel(Astrologia, 1, Astrologia.getRegistryName() + "_b");
        registerModel(Crater, 1, Crater.getRegistryName() + "_b");
        registerModel(LunarPhase, 1, LunarPhase.getRegistryName() + "_b");
        registerModel(Crescent, 1, Crescent.getRegistryName() + "_b");
        registerModel(Gibbous, 1, Gibbous.getRegistryName() + "_b");
        registerModel(Berserker, 1, Berserker.getRegistryName() + "_b");
        registerModel(Twilight, 1, Twilight.getRegistryName() + "_b");
        registerModel(QueenOfTheNight, 1, QueenOfTheNight.getRegistryName() + "_b");
        registerModel(BalsamicMoon, 1, BalsamicMoon.getRegistryName() + "_b");
        registerModel(Orbit, 1, Orbit.getRegistryName() + "_b");
        registerModel(LightYear, 1, LightYear.getRegistryName() + "_b");
        registerModel(KingOfTheNight, 1, KingOfTheNight.getRegistryName() + "_b");
        registerModel(Moonset, 1, Moonset.getRegistryName() + "_b");
        registerModel(Horoscope, 1, Horoscope.getRegistryName() + "_b");
        registerModel(Dichotomy, 1, Dichotomy.getRegistryName() + "_b");
        registerModel(Lunatic, 1, Lunatic.getRegistryName() + "_b");
        registerModel(JustDesserts, 1, JustDesserts.getRegistryName() + "_b");
        registerModel(Bunnymoon, 1, Bunnymoon.getRegistryName() + "_b");

        // axel
        registerModel(Ashes);
        registerModel(Doldrums);
        registerModel(DelayedAction);
        registerModel(DiveBombers);
        registerModel(Combustion);
        registerModel(MoulinRouge);
        registerModel(BlazeofGlory);
        registerModel(Prometheus);
        registerModel(Ifrit);
        registerModel(MagmaOcean);
        registerModel(Volcanics);
        registerModel(Inferno);
        registerModel(SizzlingEdge);
        registerModel(Corona);
        registerModel(FerrisWheel);
        registerModel(Burnout);
        registerModel(OmegaTrinity);
        registerModel(Outbreak);
        registerModel(DoubleEdge);
        registerModel(Wildfire);
        registerModel(Prominence);
        registerModel(EternalFlames);
        registerModel(PizzaCut);
        registerModel(Conformers);

        // demyx
        registerModel(BasicModel);
        registerModel(TuneUp);
        registerModel(Quartet);
        registerModel(Quintet);
        registerModel(Overture);
        registerModel(OldHand);
        registerModel(DaCapo);
        registerModel(PowerChord);
        registerModel(Fermata);
        registerModel(Interlude);
        registerModel(Serenade);
        registerModel(Songbird);
        registerModel(RiseToFame);
        registerModel(RockStar);
        registerModel(EightFinger);
        registerModel(Concerto);
        registerModel(Harmonics);
        registerModel(MillionBucks);
        registerModel(Fortissimo);
        registerModel(UpToEleven);
        registerModel(Sanctuary);
        registerModel(Arpeggio);
        registerModel(PrinceOfAwesome);
        registerModel(AfterSchool);

        // luxord
        registerModel(TheFool);
        registerModel(TheMagician);
        registerModel(TheStar);
        registerModel(TheMoon);
        registerModel(Justice);
        registerModel(TheHierophant);
        registerModel(TheWorld);
        registerModel(Temperance);
        registerModel(TheHighPriestess);
        registerModel(TheTower);
        registerModel(TheHangedMan);
        registerModel(Death);
        registerModel(TheHermit);
        registerModel(Strength);
        registerModel(TheLovers);
        registerModel(TheChariot);
        registerModel(TheSun);
        registerModel(TheDevil);
        registerModel(TheEmpress);
        registerModel(TheEmperor);
        registerModel(TheJoker);
        registerModel(FairGame);
        registerModel(FinestFantasy13);
        registerModel(HighRollersSecret);

        // marluxia
        registerModel(FickleErica);
        registerModel(JiltedAnemone);
        registerModel(ProudAmaryllis);
        registerModel(MadSafflower);
        registerModel(PoorMelissa);
        registerModel(TragicAllium);
        registerModel(MournfulCineria);
        registerModel(PseudoSilene);
        registerModel(FaithlessDigitalis);
        registerModel(GrimMuscari);
        registerModel(DocileVallota);
        registerModel(QuietBelladonna);
        registerModel(PartingIpheion);
        registerModel(LoftyGerbera);
        registerModel(GallantAchillea);
        registerModel(NoblePeony);
        registerModel(FearsomeAnise);
        registerModel(VindictiveThistle);
        registerModel(FairHelianthus);
        registerModel(SolemnMagnolia);
        registerModel(HallowedLotus);
        registerModel(GracefulDahlia);
        registerModel(StirringLadle);
        registerModel(DaintyBellflowers);

        // larxene
        registerModel(Trancheuse);
        registerModel(Orage);
        registerModel(Tourbillon);
        registerModel(Tempete);
        registerModel(Carmin);
        registerModel(Meteore);
        registerModel(Etoile);
        registerModel(Irregulier);
        registerModel(Dissonance);
        registerModel(Eruption);
        registerModel(SoleilCouchant);
        registerModel(Indigo);
        registerModel(Vague);
        registerModel(Deluge);
        registerModel(Rafale);
        registerModel(Typhon);
        registerModel(Extirpeur);
        registerModel(CroixDuSud);
        registerModel(Lumineuse);
        registerModel(ClairdeLune);
        registerModel(VoldeNuit);
        registerModel(Foudre);
        registerModel(Demoiselle);
        registerModel(Ampoule);

        //Blocks
        registerModel(Item.getItemFromBlock(GhostBlox), 0, Item.getItemFromBlock(GhostBlox).getRegistryName() + "", "visible=0");
        registerModel(Item.getItemFromBlock(GhostBlox), 1, Item.getItemFromBlock(Blocks.GLOWSTONE).getRegistryName() + "", "visible=1");
        registerModel(Item.getItemFromBlock(StationOfAwakening), 0, Item.getItemFromBlock(Blocks.GLOWSTONE).getRegistryName() + "", "variant=0");
        registerModel(Item.getItemFromBlock(StationOfAwakening), 1, Item.getItemFromBlock(Blocks.GLOWSTONE).getRegistryName() + "", "variant=1");
        registerModel(Item.getItemFromBlock(StationOfAwakening), 2, Item.getItemFromBlock(Blocks.GLOWSTONE).getRegistryName() + "", "variant=2");
        registerModel(Item.getItemFromBlock(StationOfAwakening), 3, Item.getItemFromBlock(Blocks.GLOWSTONE).getRegistryName() + "", "variant=3");
        registerModel(Item.getItemFromBlock(StationOfAwakening), 4, Item.getItemFromBlock(Blocks.GLOWSTONE).getRegistryName() + "", "variant=4");
        registerModel(Item.getItemFromBlock(StationOfAwakening), 5, Item.getItemFromBlock(Blocks.GLOWSTONE).getRegistryName() + "", "variant=5");
        registerModel(Item.getItemFromBlock(StationOfAwakening), 6, Item.getItemFromBlock(Blocks.GLOWSTONE).getRegistryName() + "", "variant=6");
        registerModel(Item.getItemFromBlock(StationOfAwakening), 7, Item.getItemFromBlock(Blocks.GLOWSTONE).getRegistryName() + "", "variant=7");
        registerModel(Item.getItemFromBlock(StationOfAwakening), 8, Item.getItemFromBlock(Blocks.GLOWSTONE).getRegistryName() + "", "variant=8");
        registerModel(Item.getItemFromBlock(StationOfAwakening), 9, Item.getItemFromBlock(Blocks.GLOWSTONE).getRegistryName() + "", "variant=9");
        registerModel(Item.getItemFromBlock(StationOfAwakening), 10, Item.getItemFromBlock(Blocks.GLOWSTONE).getRegistryName() + "", "variant=10");
        registerModel(Item.getItemFromBlock(StationOfAwakening), 11, Item.getItemFromBlock(Blocks.GLOWSTONE).getRegistryName() + "", "variant=11");
        registerModel(Item.getItemFromBlock(StationOfAwakening), 12, Item.getItemFromBlock(Blocks.GLOWSTONE).getRegistryName() + "", "variant=12");
        registerModel(Item.getItemFromBlock(StationOfAwakening), 13, Item.getItemFromBlock(Blocks.GLOWSTONE).getRegistryName() + "", "variant=13");
        registerModel(Item.getItemFromBlock(StationOfAwakening), 14, Item.getItemFromBlock(Blocks.GLOWSTONE).getRegistryName() + "", "variant=14");
        registerModel(Item.getItemFromBlock(StationOfAwakening), 15, Item.getItemFromBlock(Blocks.GLOWSTONE).getRegistryName() + "", "variant=15");
        registerModel(Item.getItemFromBlock(StationOfAwakening), 16, Item.getItemFromBlock(Blocks.GLOWSTONE).getRegistryName() + "", "variant=16");
        registerModel(Item.getItemFromBlock(NormalBlox));
        registerModel(Item.getItemFromBlock(HardBlox));
        registerModel(Item.getItemFromBlock(MetalBlox));
        registerModel(Item.getItemFromBlock(DangerBlox));
        registerModel(Item.getItemFromBlock(BounceBlox));
        registerModel(Item.getItemFromBlock(BlastBlox));
        registerModel(Item.getItemFromBlock(PrizeBlox));
        registerModel(Item.getItemFromBlock(RarePrizeBlox));
        registerModel(Item.getItemFromBlock(MagnetBlox));
        registerModel(Item.getItemFromBlock(BlazingOre));
        registerModel(Item.getItemFromBlock(BrightOre));
        registerModel(Item.getItemFromBlock(DarkOre));
        registerModel(Item.getItemFromBlock(DarkOreE));
        registerModel(Item.getItemFromBlock(DenseOre));
        registerModel(Item.getItemFromBlock(EnergyOre));
        registerModel(Item.getItemFromBlock(FrostOre));
        registerModel(Item.getItemFromBlock(LightningOre));
        registerModel(Item.getItemFromBlock(LucidOre));
        registerModel(Item.getItemFromBlock(PowerOre));
        registerModel(Item.getItemFromBlock(PowerOreE));
        registerModel(Item.getItemFromBlock(RemembranceOre));
        registerModel(Item.getItemFromBlock(SerenityOre));
        registerModel(Item.getItemFromBlock(StormyOre));
        registerModel(Item.getItemFromBlock(TranquilOre));
        registerModel(Item.getItemFromBlock(TwilightOre));
        registerModel(Item.getItemFromBlock(SynthesisTable));
        registerModel(Item.getItemFromBlock(KKChest));
        registerModel(Item.getItemFromBlock(SavePoint));
        registerModel(Item.getItemFromBlock(StationOfAwakeningDoor));
        registerModel(Item.getItemFromBlock(Pedestal));
        registerModel(Item.getItemFromBlock(OrgPortal));
    }

    public static void registerModel(Item item) {
        ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(item.getRegistryName() + "", "inventory"));
    }

    public static void registerModel(Item item, int meta) {
        ModelLoader.setCustomModelResourceLocation(item, meta, new ModelResourceLocation(item.getRegistryName() + "", "inventory"));
    }

    public static void registerModel(Item item, int meta, String name) {
        ModelLoader.setCustomModelResourceLocation(item, meta, new ModelResourceLocation(name, "inventory"));
    }

    public static void registerModel(Item item, int meta, String name, String type) {
        ModelLoader.setCustomModelResourceLocation(item, meta, new ModelResourceLocation(name, type));
    }

    @Override
    public void preInit (FMLPreInitializationEvent event) {
        super.preInit(event);
        RenderingRegistry.registerEntityRenderingHandler(EntityBlastBlox.class, new RenderFactoryBlastBlox());
        RenderingRegistry.registerEntityRenderingHandler(EntityMoulinRouge.class, (IRenderFactory) new RenderEntityMoulinRouge(Minecraft.getMinecraft().getRenderManager()));
        RenderingRegistry.registerEntityRenderingHandler(EntityEternalFlames.class, (IRenderFactory) new RenderEntityEternalFlames(Minecraft.getMinecraft().getRenderManager()));
        RenderingRegistry.registerEntityRenderingHandler(EntityIfrit.class, (IRenderFactory) new RenderEntityIfrit(Minecraft.getMinecraft().getRenderManager()));
        RenderingRegistry.registerEntityRenderingHandler(EntityProminence.class, (IRenderFactory) new RenderEntityProminence(Minecraft.getMinecraft().getRenderManager()));
        RenderingRegistry.registerEntityRenderingHandler(EntityPrometheus.class, (IRenderFactory) new RenderEntityPrometheus(Minecraft.getMinecraft().getRenderManager()));
        RenderingRegistry.registerEntityRenderingHandler(EntityBlazeofGlory.class, (IRenderFactory) new RenderEntityBlazeofGlory(Minecraft.getMinecraft().getRenderManager()));
        RenderingRegistry.registerEntityRenderingHandler(EntityAshes.class, (IRenderFactory) new RenderEntityAshes(Minecraft.getMinecraft().getRenderManager()));
        RenderingRegistry.registerEntityRenderingHandler(EntityOmegaTrinity.class, (IRenderFactory) new RenderEntityOmegaTrinity(Minecraft.getMinecraft().getRenderManager()));
        RenderingRegistry.registerEntityRenderingHandler(EntityCombustion.class, (IRenderFactory) new RenderEntityCombustion(Minecraft.getMinecraft().getRenderManager()));
        RenderingRegistry.registerEntityRenderingHandler(EntityFerrisWheels.class, (IRenderFactory) new RenderEntityFerrisWheel(Minecraft.getMinecraft().getRenderManager()));
        RenderingRegistry.registerEntityRenderingHandler(EntityBurnout.class, (IRenderFactory) new RenderEntityBurnout(Minecraft.getMinecraft().getRenderManager()));
        RenderingRegistry.registerEntityRenderingHandler(EntityDoledrum.class, (IRenderFactory) new RenderEntityDoledrum(Minecraft.getMinecraft().getRenderManager()));
        RenderingRegistry.registerEntityRenderingHandler(EntityInferno.class, (IRenderFactory) new RenderEntityInferno(Minecraft.getMinecraft().getRenderManager()));
        RenderingRegistry.registerEntityRenderingHandler(EntityOutbreak.class, (IRenderFactory) new RenderEntityOutbreak(Minecraft.getMinecraft().getRenderManager()));
        RenderingRegistry.registerEntityRenderingHandler(EntitySizzlingEdge.class, (IRenderFactory) new RenderEntitySizzlingEdge(Minecraft.getMinecraft().getRenderManager()));
        RenderingRegistry.registerEntityRenderingHandler(EntityDoubleEdge.class, (IRenderFactory) new RenderEntityDoubleEdge(Minecraft.getMinecraft().getRenderManager()));

        RenderingRegistry.registerEntityRenderingHandler(EntitySharpshooterBullet.class, new RenderFactorySharpshooterBullet());

        RenderingRegistry.registerEntityRenderingHandler(EntityShadow.class, (IRenderFactory) new RenderKHMob(Minecraft.getMinecraft().getRenderManager(), new ModelShadow(), 1, "shadow"));
        RenderingRegistry.registerEntityRenderingHandler(EntityGigaShadow.class, (IRenderFactory) new RenderKHMob(Minecraft.getMinecraft().getRenderManager(), new ModelShadow(), 5, "shadow"));
        RenderingRegistry.registerEntityRenderingHandler(EntityRedNocturne.class, (IRenderFactory) new RenderKHMob(Minecraft.getMinecraft().getRenderManager(), new ModelRedNocturne(), 1, "rednocturne"));
        RenderingRegistry.registerEntityRenderingHandler(EntityBlueRhapsody.class, (IRenderFactory) new RenderKHMob(Minecraft.getMinecraft().getRenderManager(), new ModelRedNocturne(), 1, "bluerhapsody"));
        RenderingRegistry.registerEntityRenderingHandler(EntityYellowOpera.class, (IRenderFactory) new RenderKHMob(Minecraft.getMinecraft().getRenderManager(), new ModelRedNocturne(), 1, "yellowopera"));
        RenderingRegistry.registerEntityRenderingHandler(EntityGreenRequiem.class, (IRenderFactory) new RenderKHMob(Minecraft.getMinecraft().getRenderManager(), new ModelRedNocturne(), 1, "greenrequiem"));
        RenderingRegistry.registerEntityRenderingHandler(EntityMoogle.class, (IRenderFactory) new RenderKHMob(Minecraft.getMinecraft().getRenderManager(), new ModelMoogle(), 1, "moogle"));
    }

    @Override
    public void init (FMLInitializationEvent event) {
        super.init(event);
        registerRenders();
        registerKeyBindings();
        RenderLivingBase renderPlayer = Minecraft.getMinecraft().getRenderManager().getSkinMap().get("default");
        renderPlayer.addLayer(new LayerRendererDrive(renderPlayer));
        renderPlayer = Minecraft.getMinecraft().getRenderManager().getSkinMap().get("slim");
        renderPlayer.addLayer(new LayerRendererDrive(renderPlayer));
        MinecraftForge.EVENT_BUS.register(new ClientEventHandler());
        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityPedestal.class, new TESRPedestal());
    }

    @Override
    public void postInit (FMLPostInitializationEvent e) {
        super.postInit(e);
        KingdomKeys.logger.info("Events loaded");
    }

    private void registerRenders () {
        MinecraftForge.EVENT_BUS.register(new GuiPlayerPortrait());
        MinecraftForge.EVENT_BUS.register(new GuiCommandMenu());
        MinecraftForge.EVENT_BUS.register(new GuiHP());
        MinecraftForge.EVENT_BUS.register(new GuiMP());
        MinecraftForge.EVENT_BUS.register(new GuiLockOn());
        MinecraftForge.EVENT_BUS.register(new GuiOverlay());
        MinecraftForge.EVENT_BUS.register(new GuiDrive());
        DevCapes.getInstance().registerConfig("https://www.dropbox.com/s/bcu19osjxthpnq8/Capes.json?raw=1");
    }

    @Override
    public void spawnTestParticle (World world, double posX, double posY, double posZ, double motionX, double motionY, double motionZ, float alpha) {
        Particle particleTest = new EntityParticleFXTest(new ResourceLocation(Reference.MODID, "textures/fx/flame.png"), world, posX, posY, posZ, motionX, motionY, motionZ, alpha);
        Minecraft.getMinecraft().effectRenderer.addEffect(particleTest);
    }

    private void registerKeyBindings () {
        MinecraftForge.EVENT_BUS.register(new InputHandler());
        for (InputHandler.Keybinds key : InputHandler.Keybinds.values())
            ClientRegistry.registerKeyBinding(key.getKeybind());
    }

    @Override
    public EntityPlayer getPlayerEntity (MessageContext ctx) {
        return (ctx.side.isClient() ? Minecraft.getMinecraft().player : super.getPlayerEntity(ctx));
    }

    @Override
    public IThreadListener getThreadFromContext (MessageContext ctx) {
        return (ctx.side.isClient() ? Minecraft.getMinecraft() : super.getThreadFromContext(ctx));
    }

}
