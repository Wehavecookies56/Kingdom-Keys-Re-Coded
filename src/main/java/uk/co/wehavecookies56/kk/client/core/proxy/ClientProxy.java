package uk.co.wehavecookies56.kk.client.core.proxy;

import org.lwjgl.input.Keyboard;

import com.jadarstudios.developercapes.DevCapes;

import net.minecraft.client.Minecraft;
import net.minecraft.client.particle.Particle;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.client.renderer.entity.RenderLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.stats.IStatStringFormat;
import net.minecraft.util.IThreadListener;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.client.model.b3d.B3DLoader;
import net.minecraftforge.client.model.obj.OBJLoader;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.client.registry.IRenderFactory;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;
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
import uk.co.wehavecookies56.kk.client.render.RenderEntityEternalFlames;
import uk.co.wehavecookies56.kk.client.render.RenderEntityIfrit;
import uk.co.wehavecookies56.kk.client.render.RenderEntityPrometheus;
import uk.co.wehavecookies56.kk.client.render.RenderEntityProminence;
import uk.co.wehavecookies56.kk.client.render.RenderFactoryBlastBlox;
import uk.co.wehavecookies56.kk.client.render.RenderFactorySharpshooterBullet;
import uk.co.wehavecookies56.kk.client.render.RenderKHMob;
import uk.co.wehavecookies56.kk.client.render.TESRPedestal;
import uk.co.wehavecookies56.kk.common.achievement.ModAchievements;
import uk.co.wehavecookies56.kk.common.block.ModBlocks;
import uk.co.wehavecookies56.kk.common.block.tile.TileEntityPedestal;
import uk.co.wehavecookies56.kk.common.core.helper.LogHelper;
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
import uk.co.wehavecookies56.kk.common.entity.projectiles.EntityEternalFlames;
import uk.co.wehavecookies56.kk.common.entity.projectiles.EntityIfrit;
import uk.co.wehavecookies56.kk.common.entity.projectiles.EntityPrometheus;
import uk.co.wehavecookies56.kk.common.entity.projectiles.EntityProminence;
import uk.co.wehavecookies56.kk.common.entity.projectiles.EntitySharpshooterBullet;
import uk.co.wehavecookies56.kk.common.item.ModItems;
import uk.co.wehavecookies56.kk.common.lib.Reference;
import uk.co.wehavecookies56.kk.common.lib.Strings;

public class ClientProxy extends CommonProxy
{

	@Override
	public void preInit (FMLPreInitializationEvent event) {
		super.preInit(event);
		B3DLoader.INSTANCE.addDomain(Reference.MODID);
		OBJLoader.INSTANCE.addDomain(Reference.MODID);
		ModelLoader.setCustomModelResourceLocation(ModItems.AllforOne, 0, new ModelResourceLocation(Reference.MODID + ":" + Strings.AllforOne, "inventory"));
		ModelLoader.setCustomModelResourceLocation(ModItems.Arpeggio, 0, new ModelResourceLocation(Reference.MODID + ":" + Strings.Arpeggio, "inventory"));
		ModelLoader.setCustomModelResourceLocation(ModItems.BlazeofGlory, 0, new ModelResourceLocation(Reference.MODID + ":" + Strings.BlazeofGlory, "inventory"));
		ModelLoader.setCustomModelResourceLocation(ModItems.BondofFlame, 0, new ModelResourceLocation(Reference.MODID + ":" + Strings.BondofFlame, "inventory"));
		ModelLoader.setCustomModelResourceLocation(ModItems.Brightcrest, 0, new ModelResourceLocation(Reference.MODID + ":" + Strings.Brightcrest, "inventory"));
		ModelLoader.setCustomModelResourceLocation(ModItems.ChaosRipper, 0, new ModelResourceLocation(Reference.MODID + ":" + Strings.ChaosRipper, "inventory"));
		ModelLoader.setCustomModelResourceLocation(ModItems.CircleofLife, 0, new ModelResourceLocation(Reference.MODID + ":" + Strings.CircleofLife, "inventory"));
		ModelLoader.setCustomModelResourceLocation(ModItems.Counterpoint, 0, new ModelResourceLocation(Reference.MODID + ":" + Strings.Counterpoint, "inventory"));
		ModelLoader.setCustomModelResourceLocation(ModItems.Crabclaw, 0, new ModelResourceLocation(Reference.MODID + ":" + Strings.Crabclaw, "inventory"));
		ModelLoader.setCustomModelResourceLocation(ModItems.Darkgnaw, 0, new ModelResourceLocation(Reference.MODID + ":" + Strings.Darkgnaw, "inventory"));
		ModelLoader.setCustomModelResourceLocation(ModItems.DecisivePumpkin, 0, new ModelResourceLocation(Reference.MODID + ":" + Strings.DecisivePumpkin, "inventory"));
		ModelLoader.setCustomModelResourceLocation(ModItems.DestinysEmbrace, 0, new ModelResourceLocation(Reference.MODID + ":" + Strings.DestinysEmbrace, "inventory"));
		ModelLoader.setCustomModelResourceLocation(ModItems.DiamondDust, 0, new ModelResourceLocation(Reference.MODID + ":" + Strings.DiamondDust, "inventory"));
		ModelLoader.setCustomModelResourceLocation(ModItems.Divewing, 0, new ModelResourceLocation(Reference.MODID + ":" + Strings.Divewing, "inventory"));
		ModelLoader.setCustomModelResourceLocation(ModItems.DivineRose, 0, new ModelResourceLocation(Reference.MODID + ":" + Strings.DivineRose, "inventory"));
		ModelLoader.setCustomModelResourceLocation(ModItems.DreamSword, 0, new ModelResourceLocation(Reference.MODID + ":" + Strings.DreamSword, "inventory"));
		ModelLoader.setCustomModelResourceLocation(ModItems.DreamShield, 0, new ModelResourceLocation(Reference.MODID + ":" + Strings.DreamShield, "inventory"));
		ModelLoader.setCustomModelResourceLocation(ModItems.DualDisc, 0, new ModelResourceLocation(Reference.MODID + ":" + Strings.DualDisc, "inventory"));
		ModelLoader.setCustomModelResourceLocation(ModItems.Earthshaker, 0, new ModelResourceLocation(Reference.MODID + ":" + Strings.Earthshaker, "inventory"));
		ModelLoader.setCustomModelResourceLocation(ModItems.EndofPain, 0, new ModelResourceLocation(Reference.MODID + ":" + Strings.EndofPain, "inventory"));
		ModelLoader.setCustomModelResourceLocation(ModItems.EndsoftheEarth, 0, new ModelResourceLocation(Reference.MODID + ":" + Strings.EndsoftheEarth, "inventory"));
		ModelLoader.setCustomModelResourceLocation(ModItems.EternalFlames, 0, new ModelResourceLocation(Reference.MODID + ":" + Strings.EternalFlames, "inventory"));
		ModelLoader.setCustomModelResourceLocation(ModItems.FairyHarp, 0, new ModelResourceLocation(Reference.MODID + ":" + Strings.FairyHarp, "inventory"));
		ModelLoader.setCustomModelResourceLocation(ModItems.FairyStars, 0, new ModelResourceLocation(Reference.MODID + ":" + Strings.FairyStars, "inventory"));
		ModelLoader.setCustomModelResourceLocation(ModItems.FatalCrest, 0, new ModelResourceLocation(Reference.MODID + ":" + Strings.FatalCrest, "inventory"));
		ModelLoader.setCustomModelResourceLocation(ModItems.Fenrir, 0, new ModelResourceLocation(Reference.MODID + ":" + Strings.Fenrir, "inventory"));
		ModelLoader.setCustomModelResourceLocation(ModItems.FerrisGear, 0, new ModelResourceLocation(Reference.MODID + ":" + Strings.FerrisGear, "inventory"));
        ModelLoader.setCustomModelResourceLocation(ModItems.FickleErica, 0, new ModelResourceLocation(Reference.MODID + ":" + Strings.FickleErica, "inventory"));
		ModelLoader.setCustomModelResourceLocation(ModItems.FollowtheWind, 0, new ModelResourceLocation(Reference.MODID + ":" + Strings.FollowtheWind, "inventory"));
		ModelLoader.setCustomModelResourceLocation(ModItems.Foudre, 0, new ModelResourceLocation(Reference.MODID + ":" + Strings.Foudre, "inventory"));
		ModelLoader.setCustomModelResourceLocation(ModItems.FrolicFlame, 0, new ModelResourceLocation(Reference.MODID + ":" + Strings.FrolicFlame, "inventory"));
		ModelLoader.setCustomModelResourceLocation(ModItems.FrozenPride, 0, new ModelResourceLocation(Reference.MODID + ":" + Strings.FrozenPride, "inventory"));
        ModelLoader.setCustomModelResourceLocation(ModItems.GracefulDahlia, 0, new ModelResourceLocation(Reference.MODID + ":" + Strings.GracefulDahlia, "inventory"));
        ModelLoader.setCustomModelResourceLocation(ModItems.GuardianBell, 0, new ModelResourceLocation(Reference.MODID + ":" + Strings.GuardianBell, "inventory"));
		ModelLoader.setCustomModelResourceLocation(ModItems.GuardianSoul, 0, new ModelResourceLocation(Reference.MODID + ":" + Strings.GuardianSoul, "inventory"));
		ModelLoader.setCustomModelResourceLocation(ModItems.GullWing, 0, new ModelResourceLocation(Reference.MODID + ":" + Strings.GullWing, "inventory"));
		ModelLoader.setCustomModelResourceLocation(ModItems.HerosCrest, 0, new ModelResourceLocation(Reference.MODID + ":" + Strings.HerosCrest, "inventory"));
		ModelLoader.setCustomModelResourceLocation(ModItems.HiddenDragon, 0, new ModelResourceLocation(Reference.MODID + ":" + Strings.HiddenDragon, "inventory"));
		ModelLoader.setCustomModelResourceLocation(ModItems.Hyperdrive, 0, new ModelResourceLocation(Reference.MODID + ":" + Strings.Hyperdrive, "inventory"));
		ModelLoader.setCustomModelResourceLocation(ModItems.Ifrit, 0, new ModelResourceLocation(Reference.MODID + ":" + Strings.Ifrit, "inventory"));
		ModelLoader.setCustomModelResourceLocation(ModItems.IncompleteKiblade, 0, new ModelResourceLocation(Reference.MODID + ":" + Strings.IncompleteKiblade, "inventory"));
		ModelLoader.setCustomModelResourceLocation(ModItems.JiltedAnemone, 0, new ModelResourceLocation(Reference.MODID + ":" + Strings.JiltedAnemone, "inventory"));
		ModelLoader.setCustomModelResourceLocation(ModItems.JungleKing, 0, new ModelResourceLocation(Reference.MODID + ":" + Strings.JungleKing, "inventory"));
		ModelLoader.setCustomModelResourceLocation(ModItems.KeybladeofPeoplesHearts, 0, new ModelResourceLocation(Reference.MODID + ":" + Strings.KeybladeofPeoplesHearts, "inventory"));
		ModelLoader.setCustomModelResourceLocation(ModItems.Kiblade, 0, new ModelResourceLocation(Reference.MODID + ":" + Strings.Kiblade, "inventory"));
		ModelLoader.setCustomModelResourceLocation(ModItems.KingdomKey, 0, new ModelResourceLocation(Reference.MODID + ":" + Strings.KingdomKey, "inventory"));
		ModelLoader.setCustomModelResourceLocation(ModItems.KingdomKeyD, 0, new ModelResourceLocation(Reference.MODID + ":" + Strings.KingdomKeyD, "inventory"));
		ModelLoader.setCustomModelResourceLocation(ModItems.KnockoutPunch, 0, new ModelResourceLocation(Reference.MODID + ":" + Strings.KnockoutPunch, "inventory"));
		ModelLoader.setCustomModelResourceLocation(ModItems.LadyLuck, 0, new ModelResourceLocation(Reference.MODID + ":" + Strings.LadyLuck, "inventory"));
		ModelLoader.setCustomModelResourceLocation(ModItems.LeasKeyblade, 0, new ModelResourceLocation(Reference.MODID + ":" + Strings.LeasKeyblade, "inventory"));
		ModelLoader.setCustomModelResourceLocation(ModItems.Lionheart, 0, new ModelResourceLocation(Reference.MODID + ":" + Strings.Lionheart, "inventory"));
		ModelLoader.setCustomModelResourceLocation(ModItems.LostMemory, 0, new ModelResourceLocation(Reference.MODID + ":" + Strings.LostMemory, "inventory"));
		ModelLoader.setCustomModelResourceLocation(ModItems.Lunatic, 0, new ModelResourceLocation(Reference.MODID + ":" + Strings.Lunatic, "inventory"));
		ModelLoader.setCustomModelResourceLocation(ModItems.MarkofaHero, 0, new ModelResourceLocation(Reference.MODID + ":" + Strings.MarkofaHero, "inventory"));
		ModelLoader.setCustomModelResourceLocation(ModItems.MastersDefender, 0, new ModelResourceLocation(Reference.MODID + ":" + Strings.MastersDefender, "inventory"));
		ModelLoader.setCustomModelResourceLocation(ModItems.MasterXehanortsKeyblade, 0, new ModelResourceLocation(Reference.MODID + ":" + Strings.MasterXehanortsKeyblade, "inventory"));
		ModelLoader.setCustomModelResourceLocation(ModItems.MetalChocobo, 0, new ModelResourceLocation(Reference.MODID + ":" + Strings.MetalChocobo, "inventory"));
		ModelLoader.setCustomModelResourceLocation(ModItems.MirageSplit, 0, new ModelResourceLocation(Reference.MODID + ":" + Strings.MirageSplit, "inventory"));
		ModelLoader.setCustomModelResourceLocation(ModItems.MissingAche, 0, new ModelResourceLocation(Reference.MODID + ":" + Strings.MissingAche, "inventory"));
		ModelLoader.setCustomModelResourceLocation(ModItems.Monochrome, 0, new ModelResourceLocation(Reference.MODID + ":" + Strings.Monochrome, "inventory"));
		ModelLoader.setCustomModelResourceLocation(ModItems.MysteriousAbyss, 0, new ModelResourceLocation(Reference.MODID + ":" + Strings.MysteriousAbyss, "inventory"));
		ModelLoader.setCustomModelResourceLocation(ModItems.NightmaresEnd, 0, new ModelResourceLocation(Reference.MODID + ":" + Strings.NightmaresEnd, "inventory"));
		ModelLoader.setCustomModelResourceLocation(ModItems.NightmaresEndandMirageSplit, 0, new ModelResourceLocation(Reference.MODID + ":" + Strings.NightmaresEndandMirageSplit, "inventory"));
		ModelLoader.setCustomModelResourceLocation(ModItems.NoName, 0, new ModelResourceLocation(Reference.MODID + ":" + Strings.NoName, "inventory"));
		ModelLoader.setCustomModelResourceLocation(ModItems.Oathkeeper, 0, new ModelResourceLocation(Reference.MODID + ":" + Strings.Oathkeeper, "inventory"));
		ModelLoader.setCustomModelResourceLocation(ModItems.Oblivion, 0, new ModelResourceLocation(Reference.MODID + ":" + Strings.Oblivion, "inventory"));
		ModelLoader.setCustomModelResourceLocation(ModItems.OceansRage, 0, new ModelResourceLocation(Reference.MODID + ":" + Strings.OceansRage, "inventory"));
		ModelLoader.setCustomModelResourceLocation(ModItems.Olympia, 0, new ModelResourceLocation(Reference.MODID + ":" + Strings.Olympia, "inventory"));
		ModelLoader.setCustomModelResourceLocation(ModItems.OneWingedAngel, 0, new ModelResourceLocation(Reference.MODID + ":" + Strings.OneWingedAngel, "inventory"));
		ModelLoader.setCustomModelResourceLocation(ModItems.PhotonDebugger, 0, new ModelResourceLocation(Reference.MODID + ":" + Strings.PhotonDebugger, "inventory"));
		ModelLoader.setCustomModelResourceLocation(ModItems.PixiePetal, 0, new ModelResourceLocation(Reference.MODID + ":" + Strings.PixiePetal, "inventory"));
		ModelLoader.setCustomModelResourceLocation(ModItems.PoorMelissa, 0, new ModelResourceLocation(Reference.MODID + ":" + Strings.PoorMelissa, "inventory"));
		ModelLoader.setCustomModelResourceLocation(ModItems.Prometheus, 0, new ModelResourceLocation(Reference.MODID + ":" + Strings.Prometheus, "inventory"));
		ModelLoader.setCustomModelResourceLocation(ModItems.Prominence, 0, new ModelResourceLocation(Reference.MODID + ":" + Strings.Prominence, "inventory"));
		ModelLoader.setCustomModelResourceLocation(ModItems.Pumpkinhead, 0, new ModelResourceLocation(Reference.MODID + ":" + Strings.Pumpkinhead, "inventory"));
		ModelLoader.setCustomModelResourceLocation(ModItems.Rainfell, 0, new ModelResourceLocation(Reference.MODID + ":" + Strings.Rainfell, "inventory"));
		ModelLoader.setCustomModelResourceLocation(ModItems.RoyalRadiance, 0, new ModelResourceLocation(Reference.MODID + ":" + Strings.RoyalRadiance, "inventory"));
		ModelLoader.setCustomModelResourceLocation(ModItems.RumblingRose, 0, new ModelResourceLocation(Reference.MODID + ":" + Strings.RumblingRose, "inventory"));
		ModelLoader.setCustomModelResourceLocation(ModItems.SkullNoise, 0, new ModelResourceLocation(Reference.MODID + ":" + Strings.SkullNoise, "inventory"));
		ModelLoader.setCustomModelResourceLocation(ModItems.Skysplitter, 0, new ModelResourceLocation(Reference.MODID + ":" + Strings.Skysplitter, "inventory"));
		ModelLoader.setCustomModelResourceLocation(ModItems.SleepingLion, 0, new ModelResourceLocation(Reference.MODID + ":" + Strings.SleepingLion, "inventory"));
		ModelLoader.setCustomModelResourceLocation(ModItems.SoulEater, 0, new ModelResourceLocation(Reference.MODID + ":" + Strings.SoulEater, "inventory"));
		ModelLoader.setCustomModelResourceLocation(ModItems.Spellbinder, 0, new ModelResourceLocation(Reference.MODID + ":" + Strings.Spellbinder, "inventory"));
		ModelLoader.setCustomModelResourceLocation(ModItems.Standalone, 0, new ModelResourceLocation(Reference.MODID + ":" + Strings.Standalone, "inventory"));
		ModelLoader.setCustomModelResourceLocation(ModItems.StarSeeker, 0, new ModelResourceLocation(Reference.MODID + ":" + Strings.StarSeeker, "inventory"));
		ModelLoader.setCustomModelResourceLocation(ModItems.Stormfall, 0, new ModelResourceLocation(Reference.MODID + ":" + Strings.Stormfall, "inventory"));
		ModelLoader.setCustomModelResourceLocation(ModItems.StrokeofMidnight, 0, new ModelResourceLocation(Reference.MODID + ":" + Strings.StrokeofMidnight, "inventory"));
		ModelLoader.setCustomModelResourceLocation(ModItems.SweetDreams, 0, new ModelResourceLocation(Reference.MODID + ":" + Strings.SweetDreams, "inventory"));
		ModelLoader.setCustomModelResourceLocation(ModItems.SweetMemories, 0, new ModelResourceLocation(Reference.MODID + ":" + Strings.SweetMemories, "inventory"));
		ModelLoader.setCustomModelResourceLocation(ModItems.Sweetstack, 0, new ModelResourceLocation(Reference.MODID + ":" + Strings.Sweetstack, "inventory"));
		ModelLoader.setCustomModelResourceLocation(ModItems.ThreeWishes, 0, new ModelResourceLocation(Reference.MODID + ":" + Strings.ThreeWishes, "inventory"));
		ModelLoader.setCustomModelResourceLocation(ModItems.TreasureTrove, 0, new ModelResourceLocation(Reference.MODID + ":" + Strings.TreasureTrove, "inventory"));
		ModelLoader.setCustomModelResourceLocation(ModItems.TwoBecomeOne, 0, new ModelResourceLocation(Reference.MODID + ":" + Strings.TwoBecomeOne, "inventory"));
		ModelLoader.setCustomModelResourceLocation(ModItems.UltimaWeaponBBS, 0, new ModelResourceLocation(Reference.MODID + ":" + Strings.UltimaWeaponBBS, "inventory"));
		ModelLoader.setCustomModelResourceLocation(ModItems.UltimaWeaponDDD, 0, new ModelResourceLocation(Reference.MODID + ":" + Strings.UltimaWeaponDDD, "inventory"));
		ModelLoader.setCustomModelResourceLocation(ModItems.UltimaWeaponKH1, 0, new ModelResourceLocation(Reference.MODID + ":" + Strings.UltimaWeaponKH1, "inventory"));
		ModelLoader.setCustomModelResourceLocation(ModItems.UltimaWeaponKH2, 0, new ModelResourceLocation(Reference.MODID + ":" + Strings.UltimaWeaponKH2, "inventory"));
		ModelLoader.setCustomModelResourceLocation(ModItems.Unbound, 0, new ModelResourceLocation(Reference.MODID + ":" + Strings.Unbound, "inventory"));
		ModelLoader.setCustomModelResourceLocation(ModItems.VictoryLine, 0, new ModelResourceLocation(Reference.MODID + ":" + Strings.VictoryLine, "inventory"));
		ModelLoader.setCustomModelResourceLocation(ModItems.VoidGear, 0, new ModelResourceLocation(Reference.MODID + ":" + Strings.VoidGear, "inventory"));
		ModelLoader.setCustomModelResourceLocation(ModItems.WaytotheDawn, 0, new ModelResourceLocation(Reference.MODID + ":" + Strings.WaytotheDawn, "inventory"));
		ModelLoader.setCustomModelResourceLocation(ModItems.WaywardWind, 0, new ModelResourceLocation(Reference.MODID + ":" + Strings.WaywardWind, "inventory"));
		ModelLoader.setCustomModelResourceLocation(ModItems.WinnersProof, 0, new ModelResourceLocation(Reference.MODID + ":" + Strings.WinnersProof, "inventory"));
		ModelLoader.setCustomModelResourceLocation(ModItems.WishingLamp, 0, new ModelResourceLocation(Reference.MODID + ":" + Strings.WishingLamp, "inventory"));
		ModelLoader.setCustomModelResourceLocation(ModItems.WishingStar, 0, new ModelResourceLocation(Reference.MODID + ":" + Strings.WishingStar, "inventory"));
		ModelLoader.setCustomModelResourceLocation(ModItems.WoodenKeyblade, 0, new ModelResourceLocation(Reference.MODID + ":" + Strings.WoodenKeyblade, "inventory"));
		ModelLoader.setCustomModelResourceLocation(ModItems.WoodenStick, 0, new ModelResourceLocation(Reference.MODID + ":" + Strings.WoodenStick, "inventory"));
		ModelLoader.setCustomModelResourceLocation(ModItems.YoungXehanortsKeyblade, 0, new ModelResourceLocation(Reference.MODID + ":" + Strings.YoungXehanortsKeyblade, "inventory"));
		ModelLoader.setCustomModelResourceLocation(ModItems.PainofSolitude, 0, new ModelResourceLocation(Reference.MODID + ":" + Strings.PainofSolitude, "inventory"));
		ModelLoader.setCustomModelResourceLocation(ModItems.TrueLightsFlight, 0, new ModelResourceLocation(Reference.MODID + ":" + Strings.TrueLightsFlight, "inventory"));
		ModelLoader.setCustomModelResourceLocation(ModItems.RejectionofFate, 0, new ModelResourceLocation(Reference.MODID + ":" + Strings.RejectionofFate, "inventory"));
		ModelLoader.setCustomModelResourceLocation(ModItems.DarkerThanDark, 0, new ModelResourceLocation(Reference.MODID + ":" + Strings.DarkerThanDark, "inventory"));
		ModelLoader.setCustomModelResourceLocation(ModItems.MaverickFlare, 0, new ModelResourceLocation(Reference.MODID + ":" + Strings.MaverickFlare, "inventory"));
		ModelLoader.setCustomModelResourceLocation(ModItems.OminousBlight, 0, new ModelResourceLocation(Reference.MODID + ":" + Strings.OminousBlight, "inventory"));
		ModelLoader.setCustomModelResourceLocation(ModItems.AbyssalTide, 0, new ModelResourceLocation(Reference.MODID + ":" + Strings.AbyssalTide, "inventory"));
		ModelLoader.setCustomModelResourceLocation(ModItems.AstralBlast, 0, new ModelResourceLocation(Reference.MODID + ":" + Strings.AstralBlast, "inventory"));
		ModelLoader.setCustomModelResourceLocation(ModItems.TwilightBlaze, 0, new ModelResourceLocation(Reference.MODID + ":" + Strings.TwilightBlaze, "inventory"));
		ModelLoader.setCustomModelResourceLocation(ModItems.AbaddonPlasma, 0, new ModelResourceLocation(Reference.MODID + ":" + Strings.AbaddonPlasma, "inventory"));
		ModelLoader.setCustomModelResourceLocation(ModItems.TotalEclipse, 0, new ModelResourceLocation(Reference.MODID + ":" + Strings.TotalEclipse, "inventory"));
		ModelLoader.setCustomModelResourceLocation(ModItems.LunarEclipse, 0, new ModelResourceLocation(Reference.MODID + ":" + Strings.LunarEclipse, "inventory"));
		ModelLoader.setCustomModelResourceLocation(ModItems.Aubade, 0, new ModelResourceLocation(Reference.MODID + ":" + Strings.Aubade, "inventory"));
		ModelLoader.setCustomModelResourceLocation(ModItems.SignofInnocence, 0, new ModelResourceLocation(Reference.MODID + ":" + Strings.SignofInnocence, "inventory"));





		//Organization
		ModelLoader.setCustomModelResourceLocation(ModItems.FinalWeapon, 0, new ModelResourceLocation(Reference.MODID + ":" + Strings.FinalWeapon, "inventory"));
		ModelLoader.setCustomModelResourceLocation(ModItems.Reticence, 0, new ModelResourceLocation(Reference.MODID + ":" + Strings.Reticence, "inventory"));
		ModelLoader.setCustomModelResourceLocation(ModItems.Lunatic, 0, new ModelResourceLocation(Reference.MODID + ":" + Strings.Lunatic, "inventory"));
        ModelLoader.setCustomModelResourceLocation(ModItems.Standalone, 0, new ModelResourceLocation(Reference.MODID + ":" + Strings.Standalone, "inventory"));
		ModelLoader.setCustomModelResourceLocation(ModItems.Zephyr, 0, new ModelResourceLocation(Reference.MODID + ":" + Strings.Zephyr, "inventory"));
		ModelLoader.setCustomModelResourceLocation(ModItems.Sharpshooter, 0, new ModelResourceLocation(Reference.MODID + ":" + Strings.Sharpshooter, "inventory"));
		ModelLoader.setCustomModelResourceLocation(ModItems.Trancheuse, 0, new ModelResourceLocation(Reference.MODID + ":" + Strings.Trancheuse, "inventory"));
		ModelLoader.setCustomModelResourceLocation(ModItems.Malice, 0, new ModelResourceLocation(Reference.MODID + ":" + Strings.Malice, "inventory"));
		ModelLoader.setCustomModelResourceLocation(ModItems.Infinity, 0, new ModelResourceLocation(Reference.MODID + ":" + Strings.Infinity, "inventory"));
		ModelLoader.setCustomModelResourceLocation(ModItems.TheFool, 0, new ModelResourceLocation(Reference.MODID + ":" + Strings.TheFool, "inventory"));
		ModelLoader.setCustomModelResourceLocation(ModItems.TesterZero, 0, new ModelResourceLocation(Reference.MODID + ":" + Strings.TesterZero, "inventory"));
		ModelLoader.setCustomModelResourceLocation(ModItems.Carmin, 0, new ModelResourceLocation(Reference.MODID + ":" + Strings.Carmin, "inventory"));
		ModelLoader.setCustomModelResourceLocation(ModItems.Lindworm, 0, new ModelResourceLocation(Reference.MODID + ":" + Strings.Lindworm, "inventory"));
		ModelLoader.setCustomModelResourceLocation(ModItems.Inquisition, 0, new ModelResourceLocation(Reference.MODID + ":" + Strings.Inquisition, "inventory"));
		ModelLoader.setCustomModelResourceLocation(ModItems.ProductOne, 0, new ModelResourceLocation(Reference.MODID + ":" + Strings.ProductOne, "inventory"));
		ModelLoader.setCustomModelResourceLocation(ModItems.Burnout, 0, new ModelResourceLocation(Reference.MODID + ":" + Strings.Burnout, "inventory"));
		ModelLoader.setCustomModelResourceLocation(ModItems.Outbreak, 0, new ModelResourceLocation(Reference.MODID + ":" + Strings.Outbreak, "inventory"));
		ModelLoader.setCustomModelResourceLocation(ModItems.Precision, 0, new ModelResourceLocation(Reference.MODID + ":" + Strings.Precision, "inventory"));
		ModelLoader.setCustomModelResourceLocation(ModItems.Sunrise, 0, new ModelResourceLocation(Reference.MODID + ":" + Strings.Sunrise, "inventory"));
		ModelLoader.setCustomModelResourceLocation(ModItems.FalseTheory, 0, new ModelResourceLocation(Reference.MODID + ":" + Strings.FalseTheory, "inventory"));
		ModelLoader.setCustomModelResourceLocation(ModItems.Dragonreign, 0, new ModelResourceLocation(Reference.MODID + ":" + Strings.Dragonreign, "inventory"));
		ModelLoader.setCustomModelResourceLocation(ModItems.Crux, 0, new ModelResourceLocation(Reference.MODID + ":" + Strings.Crux, "inventory"));
		ModelLoader.setCustomModelResourceLocation(ModItems.Killerbee, 0, new ModelResourceLocation(Reference.MODID + ":" + Strings.Killerbee, "inventory"));
		ModelLoader.setCustomModelResourceLocation(ModItems.Orage, 0, new ModelResourceLocation(Reference.MODID + ":" + Strings.Orage, "inventory"));
		ModelLoader.setCustomModelResourceLocation(ModItems.Eruption, 0, new ModelResourceLocation(Reference.MODID + ":" + Strings.Eruption, "inventory"));
		ModelLoader.setCustomModelResourceLocation(ModItems.Irregulier, 0, new ModelResourceLocation(Reference.MODID + ":" + Strings.Irregulier, "inventory"));
		ModelLoader.setCustomModelResourceLocation(ModItems.Aggression, 0, new ModelResourceLocation(Reference.MODID + ":" + Strings.Aggression, "inventory"));
		ModelLoader.setCustomModelResourceLocation(ModItems.Sanction, 0, new ModelResourceLocation(Reference.MODID + ":" + Strings.Sanction, "inventory"));
		ModelLoader.setCustomModelResourceLocation(ModItems.Ashes, 0, new ModelResourceLocation(Reference.MODID + ":" + Strings.Ashes, "inventory"));
		ModelLoader.setCustomModelResourceLocation(ModItems.Combustion, 0, new ModelResourceLocation(Reference.MODID + ":" + Strings.Combustion, "inventory"));
		ModelLoader.setCustomModelResourceLocation(ModItems.Twilight, 0, new ModelResourceLocation(Reference.MODID + ":" + Strings.Twilight, "inventory"));
		ModelLoader.setCustomModelResourceLocation(ModItems.LoftyGerbera, 0, new ModelResourceLocation(Reference.MODID + ":" + Strings.LoftyGerbera, "inventory"));
		ModelLoader.setCustomModelResourceLocation(ModItems.HallowedLotus, 0, new ModelResourceLocation(Reference.MODID + ":" + Strings.HallowedLotus, "inventory"));
		ModelLoader.setCustomModelResourceLocation(ModItems.Interdiction, 0, new ModelResourceLocation(Reference.MODID + ":" + Strings.Interdiction, "inventory"));
		ModelLoader.setCustomModelResourceLocation(ModItems.BlackPrimer, 0, new ModelResourceLocation(Reference.MODID + ":" + Strings.BlackPrimer, "inventory"));
		ModelLoader.setCustomModelResourceLocation(ModItems.Indigo, 0, new ModelResourceLocation(Reference.MODID + ":" + Strings.Indigo, "inventory"));
		ModelLoader.setCustomModelResourceLocation(ModItems.Lumineuse, 0, new ModelResourceLocation(Reference.MODID + ":" + Strings.Lumineuse, "inventory"));
		ModelLoader.setCustomModelResourceLocation(ModItems.WhiteTome, 0, new ModelResourceLocation(Reference.MODID + ":" + Strings.WhiteTome, "inventory"));
		ModelLoader.setCustomModelResourceLocation(ModItems.Tourbillon, 0, new ModelResourceLocation(Reference.MODID + ":" + Strings.Tourbillon, "inventory"));
		ModelLoader.setCustomModelResourceLocation(ModItems.Aegis, 0, new ModelResourceLocation(Reference.MODID + ":" + Strings.Aegis, "inventory"));
		ModelLoader.setCustomModelResourceLocation(ModItems.Hyperion, 0, new ModelResourceLocation(Reference.MODID + ":" + Strings.Hyperion, "inventory"));
		ModelLoader.setCustomModelResourceLocation(ModItems.BookofRetribution, 0, new ModelResourceLocation(Reference.MODID + ":" + Strings.BookofRetribution, "inventory"));
		ModelLoader.setCustomModelResourceLocation(ModItems.QuietBelladonna, 0, new ModelResourceLocation(Reference.MODID + ":" + Strings.QuietBelladonna, "inventory"));
		ModelLoader.setCustomModelResourceLocation(ModItems.Empiricism, 0, new ModelResourceLocation(Reference.MODID + ":" + Strings.Empiricism, "inventory"));
		ModelLoader.setCustomModelResourceLocation(ModItems.Contrivance, 0, new ModelResourceLocation(Reference.MODID + ":" + Strings.Contrivance, "inventory"));
		ModelLoader.setCustomModelResourceLocation(ModItems.DiamondShield, 0, new ModelResourceLocation(Reference.MODID + ":" + Strings.DiamondShield, "inventory"));
		ModelLoader.setCustomModelResourceLocation(ModItems.CryoliteShield, 0, new ModelResourceLocation(Reference.MODID + ":" + Strings.CryoliteShield, "inventory"));
		ModelLoader.setCustomModelResourceLocation(ModItems.OmegaTrinity, 0, new ModelResourceLocation(Reference.MODID + ":" + Strings.OmegaTrinity, "inventory"));
		ModelLoader.setCustomModelResourceLocation(ModItems.TheMagician, 0, new ModelResourceLocation(Reference.MODID + ":" + Strings.TheMagician, "inventory"));
		ModelLoader.setCustomModelResourceLocation(ModItems.Ignition , 0, new ModelResourceLocation(Reference.MODID + ":" + Strings.Ignition, "inventory"));
		ModelLoader.setCustomModelResourceLocation(ModItems.FerrisWheel , 0, new ModelResourceLocation(Reference.MODID + ":" + Strings.FerrisWheel, "inventory"));
		ModelLoader.setCustomModelResourceLocation(ModItems.MoulinRouge , 0, new ModelResourceLocation(Reference.MODID + ":" + Strings.MoulinRouge, "inventory"));
		ModelLoader.setCustomModelResourceLocation(ModItems.Doldrums , 0, new ModelResourceLocation(Reference.MODID + ":" + Strings.Doldrums, "inventory"));
		ModelLoader.setCustomModelResourceLocation(ModItems.Inferno , 0, new ModelResourceLocation(Reference.MODID + ":" + Strings.Inferno, "inventory"));
		ModelLoader.setCustomModelResourceLocation(ModItems.FinestFantasy13 , 0, new ModelResourceLocation(Reference.MODID + ":" + Strings.FinestFantasy13, "inventory"));
		ModelLoader.setCustomModelResourceLocation(ModItems.Colossus, 0, new ModelResourceLocation(Reference.MODID + ":" + Strings.Colossus, "inventory"));
		ModelLoader.setCustomModelResourceLocation(ModItems.Sequoia , 0, new ModelResourceLocation(Reference.MODID + ":" + Strings.Sequoia, "inventory"));
		ModelLoader.setCustomModelResourceLocation(ModItems.Rafale , 0, new ModelResourceLocation(Reference.MODID + ":" + Strings.Rafale, "inventory"));
		ModelLoader.setCustomModelResourceLocation(ModItems.Cynosura , 0, new ModelResourceLocation(Reference.MODID + ":" + Strings.Cynosura, "inventory"));


		//Blocks
		ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(ModBlocks.KKChest), 0, new ModelResourceLocation(Reference.MODID + ":" + Strings.KKChest, "inventory"));
		ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(ModBlocks.StationOfAwakeningDoor), 0, new ModelResourceLocation(Reference.MODID + ":" + Strings.StationOfAwakeningDoor, "inventory"));
        ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(ModBlocks.Pedestal), 0, new ModelResourceLocation(Reference.MODID + ":" + Strings.Pedestal, "inventory"));

		RenderingRegistry.registerEntityRenderingHandler(EntityBlastBlox.class, new RenderFactoryBlastBlox());
		RenderingRegistry.registerEntityRenderingHandler(EntityEternalFlames.class, (IRenderFactory) new RenderEntityEternalFlames(Minecraft.getMinecraft().getRenderManager()));
		RenderingRegistry.registerEntityRenderingHandler(EntityIfrit.class, (IRenderFactory) new RenderEntityIfrit(Minecraft.getMinecraft().getRenderManager()));
        RenderingRegistry.registerEntityRenderingHandler(EntityProminence.class, (IRenderFactory) new RenderEntityProminence(Minecraft.getMinecraft().getRenderManager()));
        RenderingRegistry.registerEntityRenderingHandler(EntityPrometheus.class, (IRenderFactory) new RenderEntityPrometheus(Minecraft.getMinecraft().getRenderManager()));
		RenderingRegistry.registerEntityRenderingHandler(EntityBlazeofGlory.class, (IRenderFactory) new RenderEntityBlazeofGlory(Minecraft.getMinecraft().getRenderManager()));
		RenderingRegistry.registerEntityRenderingHandler(EntityAshes.class, (IRenderFactory) new RenderEntityAshes(Minecraft.getMinecraft().getRenderManager()));
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
		ModAchievements.openMenu.setStatStringFormatter(new IStatStringFormat() {
		@Override
		public String formatString(String s) {
			try {
				return String.format(s, Keyboard.getKeyName(InputHandler.Keybinds.OPENMENU.getKeybind().getKeyCode()));
			} catch (Exception e) {
				return s;
			}
		}
		});
		 ClientRegistry.bindTileEntitySpecialRenderer(TileEntityPedestal.class, new TESRPedestal());
		//ModelPlayerAPI.register(Reference.MODID, ModelPlayerDrive.class);
		//RenderPlayerAPI.register(Reference.MODID, RenderPlayerDrive.class);
	}

	@Override
	public void postInit (FMLPostInitializationEvent e) {
		super.postInit(e);
		MinecraftForge.EVENT_BUS.register(new ClientEventHandler());
		LogHelper.info("Events loaded");
	}

	private void registerRenders () {
		MinecraftForge.EVENT_BUS.register(new GuiPlayerPortrait());
		MinecraftForge.EVENT_BUS.register(new GuiCommandMenu());
		MinecraftForge.EVENT_BUS.register(new GuiHP());
		MinecraftForge.EVENT_BUS.register(new GuiMP());
		MinecraftForge.EVENT_BUS.register(new GuiLockOn());
		MinecraftForge.EVENT_BUS.register(new GuiOverlay());
		MinecraftForge.EVENT_BUS.register(new GuiDrive());
		ModItems.registerRenders();
		ModBlocks.registerRenders();
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
