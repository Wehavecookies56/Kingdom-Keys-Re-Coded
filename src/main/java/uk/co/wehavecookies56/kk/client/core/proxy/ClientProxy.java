package uk.co.wehavecookies56.kk.client.core.proxy;

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
import org.lwjgl.input.Keyboard;
import uk.co.wehavecookies56.kk.client.core.handler.ClientEventHandler;
import uk.co.wehavecookies56.kk.client.core.handler.InputHandler;
import uk.co.wehavecookies56.kk.client.fx.EntityParticleFXTest;
import uk.co.wehavecookies56.kk.client.gui.*;
import uk.co.wehavecookies56.kk.client.model.mobs.ModelMoogle;
import uk.co.wehavecookies56.kk.client.model.mobs.ModelRedNocturne;
import uk.co.wehavecookies56.kk.client.model.mobs.ModelShadow;
import uk.co.wehavecookies56.kk.client.render.*;
import uk.co.wehavecookies56.kk.common.achievement.ModAchievements;
import uk.co.wehavecookies56.kk.common.block.ModBlocks;
import uk.co.wehavecookies56.kk.common.block.tile.TileEntityPedestal;
import uk.co.wehavecookies56.kk.common.core.helper.LogHelper;
import uk.co.wehavecookies56.kk.common.core.proxy.CommonProxy;
import uk.co.wehavecookies56.kk.common.entity.block.EntityBlastBlox;
import uk.co.wehavecookies56.kk.common.entity.mobs.*;
import uk.co.wehavecookies56.kk.common.entity.projectiles.*;
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
        ModelLoader.setCustomModelResourceLocation(ModItems.FairyHarp, 0, new ModelResourceLocation(Reference.MODID + ":" + Strings.FairyHarp, "inventory"));
        ModelLoader.setCustomModelResourceLocation(ModItems.FairyStars, 0, new ModelResourceLocation(Reference.MODID + ":" + Strings.FairyStars, "inventory"));
        ModelLoader.setCustomModelResourceLocation(ModItems.FatalCrest, 0, new ModelResourceLocation(Reference.MODID + ":" + Strings.FatalCrest, "inventory"));
        ModelLoader.setCustomModelResourceLocation(ModItems.Fenrir, 0, new ModelResourceLocation(Reference.MODID + ":" + Strings.Fenrir, "inventory"));
        ModelLoader.setCustomModelResourceLocation(ModItems.FerrisGear, 0, new ModelResourceLocation(Reference.MODID + ":" + Strings.FerrisGear, "inventory"));
        ModelLoader.setCustomModelResourceLocation(ModItems.FollowtheWind, 0, new ModelResourceLocation(Reference.MODID + ":" + Strings.FollowtheWind, "inventory"));
        ModelLoader.setCustomModelResourceLocation(ModItems.FrolicFlame, 0, new ModelResourceLocation(Reference.MODID + ":" + Strings.FrolicFlame, "inventory"));
        ModelLoader.setCustomModelResourceLocation(ModItems.GuardianBell, 0, new ModelResourceLocation(Reference.MODID + ":" + Strings.GuardianBell, "inventory"));
        ModelLoader.setCustomModelResourceLocation(ModItems.GuardianSoul, 0, new ModelResourceLocation(Reference.MODID + ":" + Strings.GuardianSoul, "inventory"));
        ModelLoader.setCustomModelResourceLocation(ModItems.GullWing, 0, new ModelResourceLocation(Reference.MODID + ":" + Strings.GullWing, "inventory"));
        ModelLoader.setCustomModelResourceLocation(ModItems.HerosCrest, 0, new ModelResourceLocation(Reference.MODID + ":" + Strings.HerosCrest, "inventory"));
        ModelLoader.setCustomModelResourceLocation(ModItems.HiddenDragon, 0, new ModelResourceLocation(Reference.MODID + ":" + Strings.HiddenDragon, "inventory"));
        ModelLoader.setCustomModelResourceLocation(ModItems.Hyperdrive, 0, new ModelResourceLocation(Reference.MODID + ":" + Strings.Hyperdrive, "inventory"));
        ModelLoader.setCustomModelResourceLocation(ModItems.IncompleteKiblade, 0, new ModelResourceLocation(Reference.MODID + ":" + Strings.IncompleteKiblade, "inventory"));
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
        ModelLoader.setCustomModelResourceLocation(ModItems.Pumpkinhead, 0, new ModelResourceLocation(Reference.MODID + ":" + Strings.Pumpkinhead, "inventory"));
        ModelLoader.setCustomModelResourceLocation(ModItems.Rainfell, 0, new ModelResourceLocation(Reference.MODID + ":" + Strings.Rainfell, "inventory"));
        ModelLoader.setCustomModelResourceLocation(ModItems.RoyalRadiance, 0, new ModelResourceLocation(Reference.MODID + ":" + Strings.RoyalRadiance, "inventory"));
        ModelLoader.setCustomModelResourceLocation(ModItems.RumblingRose, 0, new ModelResourceLocation(Reference.MODID + ":" + Strings.RumblingRose, "inventory"));
        ModelLoader.setCustomModelResourceLocation(ModItems.SkullNoise, 0, new ModelResourceLocation(Reference.MODID + ":" + Strings.SkullNoise, "inventory"));
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

        // xemnas
        ModelLoader.setCustomModelResourceLocation(ModItems.Malice, 0, new ModelResourceLocation(Reference.MODID + ":" + Strings.Malice, "inventory"));
        ModelLoader.setCustomModelResourceLocation(ModItems.Sanction, 0, new ModelResourceLocation(Reference.MODID + ":" + Strings.Sanction, "inventory"));
        ModelLoader.setCustomModelResourceLocation(ModItems.Overlord, 0, new ModelResourceLocation(Reference.MODID + ":" + Strings.Overlord, "inventory"));
        ModelLoader.setCustomModelResourceLocation(ModItems.Veneration, 0, new ModelResourceLocation(Reference.MODID + ":" + Strings.Veneration, "inventory"));
        ModelLoader.setCustomModelResourceLocation(ModItems.Autocracy, 0, new ModelResourceLocation(Reference.MODID + ":" + Strings.Autocracy, "inventory"));
        ModelLoader.setCustomModelResourceLocation(ModItems.Conquest, 0, new ModelResourceLocation(Reference.MODID + ":" + Strings.Conquest, "inventory"));
        ModelLoader.setCustomModelResourceLocation(ModItems.Terminus, 0, new ModelResourceLocation(Reference.MODID + ":" + Strings.Terminus, "inventory"));
        ModelLoader.setCustomModelResourceLocation(ModItems.Judgement, 0, new ModelResourceLocation(Reference.MODID + ":" + Strings.Judgement, "inventory"));
        ModelLoader.setCustomModelResourceLocation(ModItems.Discipline, 0, new ModelResourceLocation(Reference.MODID + ":" + Strings.Discipline, "inventory"));
        ModelLoader.setCustomModelResourceLocation(ModItems.Aristocracy, 0, new ModelResourceLocation(Reference.MODID + ":" + Strings.Aristocracy, "inventory"));
        ModelLoader.setCustomModelResourceLocation(ModItems.Superiority, 0, new ModelResourceLocation(Reference.MODID + ":" + Strings.Superiority, "inventory"));
        ModelLoader.setCustomModelResourceLocation(ModItems.Aggression, 0, new ModelResourceLocation(Reference.MODID + ":" + Strings.Aggression, "inventory"));
        ModelLoader.setCustomModelResourceLocation(ModItems.Fury, 0, new ModelResourceLocation(Reference.MODID + ":" + Strings.Fury, "inventory"));
        ModelLoader.setCustomModelResourceLocation(ModItems.Despair, 0, new ModelResourceLocation(Reference.MODID + ":" + Strings.Despair, "inventory"));
        ModelLoader.setCustomModelResourceLocation(ModItems.Triumph, 0, new ModelResourceLocation(Reference.MODID + ":" + Strings.Triumph, "inventory"));
        ModelLoader.setCustomModelResourceLocation(ModItems.Ruination, 0, new ModelResourceLocation(Reference.MODID + ":" + Strings.Ruination, "inventory"));
        ModelLoader.setCustomModelResourceLocation(ModItems.Domination, 0, new ModelResourceLocation(Reference.MODID + ":" + Strings.Domination, "inventory"));
        ModelLoader.setCustomModelResourceLocation(ModItems.Annihilation, 0, new ModelResourceLocation(Reference.MODID + ":" + Strings.Annihilation, "inventory"));
        ModelLoader.setCustomModelResourceLocation(ModItems.Tyrant, 0, new ModelResourceLocation(Reference.MODID + ":" + Strings.Tyrant, "inventory"));
        ModelLoader.setCustomModelResourceLocation(ModItems.Magnificence, 0, new ModelResourceLocation(Reference.MODID + ":" + Strings.Magnificence, "inventory"));
        ModelLoader.setCustomModelResourceLocation(ModItems.Infinity, 0, new ModelResourceLocation(Reference.MODID + ":" + Strings.Infinity, "inventory"));
        ModelLoader.setCustomModelResourceLocation(ModItems.Interdiction, 0, new ModelResourceLocation(Reference.MODID + ":" + Strings.Interdiction, "inventory"));
        ModelLoader.setCustomModelResourceLocation(ModItems.RoundFan, 0, new ModelResourceLocation(Reference.MODID + ":" + Strings.RoundFan, "inventory"));
        ModelLoader.setCustomModelResourceLocation(ModItems.Absolute, 0, new ModelResourceLocation(Reference.MODID + ":" + Strings.Absolute, "inventory"));

        // xigbar
        ModelLoader.setCustomModelResourceLocation(ModItems.Standalone, 0, new ModelResourceLocation(Reference.MODID + ":" + Strings.Standalone, "inventory"));
        ModelLoader.setCustomModelResourceLocation(ModItems.Killerbee, 0, new ModelResourceLocation(Reference.MODID + ":" + Strings.Killerbee, "inventory"));
        ModelLoader.setCustomModelResourceLocation(ModItems.Stingray, 0, new ModelResourceLocation(Reference.MODID + ":" + Strings.Stingray, "inventory"));
        ModelLoader.setCustomModelResourceLocation(ModItems.Counterweight, 0, new ModelResourceLocation(Reference.MODID + ":" + Strings.Counterweight, "inventory"));
        ModelLoader.setCustomModelResourceLocation(ModItems.Precision, 0, new ModelResourceLocation(Reference.MODID + ":" + Strings.Precision, "inventory"));
        ModelLoader.setCustomModelResourceLocation(ModItems.DualHead, 0, new ModelResourceLocation(Reference.MODID + ":" + Strings.DualHead, "inventory"));
        ModelLoader.setCustomModelResourceLocation(ModItems.Bahamut, 0, new ModelResourceLocation(Reference.MODID + ":" + Strings.Bahamut, "inventory"));
        ModelLoader.setCustomModelResourceLocation(ModItems.Gullwing, 0, new ModelResourceLocation(Reference.MODID + ":" + Strings.Gullwing, "inventory"));
        ModelLoader.setCustomModelResourceLocation(ModItems.BlueFrame, 0, new ModelResourceLocation(Reference.MODID + ":" + Strings.BlueFrame, "inventory"));
        ModelLoader.setCustomModelResourceLocation(ModItems.StarShell, 0, new ModelResourceLocation(Reference.MODID + ":" + Strings.StarShell, "inventory"));
        ModelLoader.setCustomModelResourceLocation(ModItems.Sunrise, 0, new ModelResourceLocation(Reference.MODID + ":" + Strings.Sunrise, "inventory"));
        ModelLoader.setCustomModelResourceLocation(ModItems.Ignition, 0, new ModelResourceLocation(Reference.MODID + ":" + Strings.Ignition, "inventory"));
        ModelLoader.setCustomModelResourceLocation(ModItems.Armstrong, 0, new ModelResourceLocation(Reference.MODID + ":" + Strings.Armstrong, "inventory"));
        ModelLoader.setCustomModelResourceLocation(ModItems.HardBoiledHeat, 0, new ModelResourceLocation(Reference.MODID + ":" + Strings.HardBoiledHeat, "inventory"));
        ModelLoader.setCustomModelResourceLocation(ModItems.DiabloEye, 0, new ModelResourceLocation(Reference.MODID + ":" + Strings.DiabloEye, "inventory"));
        ModelLoader.setCustomModelResourceLocation(ModItems.DoubleTap, 0, new ModelResourceLocation(Reference.MODID + ":" + Strings.DoubleTap, "inventory"));
        ModelLoader.setCustomModelResourceLocation(ModItems.Stardust, 0, new ModelResourceLocation(Reference.MODID + ":" + Strings.Stardust, "inventory"));
        ModelLoader.setCustomModelResourceLocation(ModItems.EnergyMuzzle, 0, new ModelResourceLocation(Reference.MODID + ":" + Strings.EnergyMuzzle, "inventory"));
        ModelLoader.setCustomModelResourceLocation(ModItems.CrimeAndPunishment, 0, new ModelResourceLocation(Reference.MODID + ":" + Strings.CrimeAndPunishment, "inventory"));
        ModelLoader.setCustomModelResourceLocation(ModItems.CupidsArrow, 0, new ModelResourceLocation(Reference.MODID + ":" + Strings.CupidsArrow, "inventory"));
        ModelLoader.setCustomModelResourceLocation(ModItems.FinalWeapon, 0, new ModelResourceLocation(Reference.MODID + ":" + Strings.FinalWeapon, "inventory"));
        ModelLoader.setCustomModelResourceLocation(ModItems.Sharpshooter, 0, new ModelResourceLocation(Reference.MODID + ":" + Strings.Sharpshooter, "inventory"));
        ModelLoader.setCustomModelResourceLocation(ModItems.Dryer, 0, new ModelResourceLocation(Reference.MODID + ":" + Strings.Dryer, "inventory"));
        ModelLoader.setCustomModelResourceLocation(ModItems.Trumpet, 0, new ModelResourceLocation(Reference.MODID + ":" + Strings.Trumpet, "inventory"));

        // xaldin
        ModelLoader.setCustomModelResourceLocation(ModItems.Zephyr, 0, new ModelResourceLocation(Reference.MODID + ":" + Strings.Zephyr, "inventory"));
        ModelLoader.setCustomModelResourceLocation(ModItems.Moonglade, 0, new ModelResourceLocation(Reference.MODID + ":" + Strings.Moonglade, "inventory"));
        ModelLoader.setCustomModelResourceLocation(ModItems.Aer, 0, new ModelResourceLocation(Reference.MODID + ":" + Strings.Aer, "inventory"));
        ModelLoader.setCustomModelResourceLocation(ModItems.Nescience, 0, new ModelResourceLocation(Reference.MODID + ":" + Strings.Nescience, "inventory"));
        ModelLoader.setCustomModelResourceLocation(ModItems.Brume, 0, new ModelResourceLocation(Reference.MODID + ":" + Strings.Brume, "inventory"));
        ModelLoader.setCustomModelResourceLocation(ModItems.Asura, 0, new ModelResourceLocation(Reference.MODID + ":" + Strings.Asura, "inventory"));
        ModelLoader.setCustomModelResourceLocation(ModItems.Crux, 0, new ModelResourceLocation(Reference.MODID + ":" + Strings.Crux, "inventory"));
        ModelLoader.setCustomModelResourceLocation(ModItems.Paladin, 0, new ModelResourceLocation(Reference.MODID + ":" + Strings.Paladin, "inventory"));
        ModelLoader.setCustomModelResourceLocation(ModItems.Fellking, 0, new ModelResourceLocation(Reference.MODID + ":" + Strings.Fellking, "inventory"));
        ModelLoader.setCustomModelResourceLocation(ModItems.Nightcloud, 0, new ModelResourceLocation(Reference.MODID + ":" + Strings.Nightcloud, "inventory"));
        ModelLoader.setCustomModelResourceLocation(ModItems.Shimmer, 0, new ModelResourceLocation(Reference.MODID + ":" + Strings.Shimmer, "inventory"));
        ModelLoader.setCustomModelResourceLocation(ModItems.Vortex, 0, new ModelResourceLocation(Reference.MODID + ":" + Strings.Vortex, "inventory"));
        ModelLoader.setCustomModelResourceLocation(ModItems.Scission, 0, new ModelResourceLocation(Reference.MODID + ":" + Strings.Scission, "inventory"));
        ModelLoader.setCustomModelResourceLocation(ModItems.Heavenfall, 0, new ModelResourceLocation(Reference.MODID + ":" + Strings.Heavenfall, "inventory"));
        ModelLoader.setCustomModelResourceLocation(ModItems.Aether, 0, new ModelResourceLocation(Reference.MODID + ":" + Strings.Aether, "inventory"));
        ModelLoader.setCustomModelResourceLocation(ModItems.Mazzaroth, 0, new ModelResourceLocation(Reference.MODID + ":" + Strings.Mazzaroth, "inventory"));
        ModelLoader.setCustomModelResourceLocation(ModItems.Hegemon, 0, new ModelResourceLocation(Reference.MODID + ":" + Strings.Hegemon, "inventory"));
        ModelLoader.setCustomModelResourceLocation(ModItems.Foxfire, 0, new ModelResourceLocation(Reference.MODID + ":" + Strings.Foxfire, "inventory"));
        ModelLoader.setCustomModelResourceLocation(ModItems.Yaksha, 0, new ModelResourceLocation(Reference.MODID + ":" + Strings.Yaksha, "inventory"));
        ModelLoader.setCustomModelResourceLocation(ModItems.Cynosura, 0, new ModelResourceLocation(Reference.MODID + ":" + Strings.Cynosura, "inventory"));
        ModelLoader.setCustomModelResourceLocation(ModItems.Dragonreign, 0, new ModelResourceLocation(Reference.MODID + ":" + Strings.Dragonreign, "inventory"));
        ModelLoader.setCustomModelResourceLocation(ModItems.Lindworm, 0, new ModelResourceLocation(Reference.MODID + ":" + Strings.Lindworm, "inventory"));
        ModelLoader.setCustomModelResourceLocation(ModItems.Broom, 0, new ModelResourceLocation(Reference.MODID + ":" + Strings.Broom, "inventory"));
        ModelLoader.setCustomModelResourceLocation(ModItems.Wyvern, 0, new ModelResourceLocation(Reference.MODID + ":" + Strings.Wyvern, "inventory"));

        // vexen
        ModelLoader.setCustomModelResourceLocation(ModItems.TesterZero, 0, new ModelResourceLocation(Reference.MODID + ":" + Strings.TesterZero, "inventory"));
        ModelLoader.setCustomModelResourceLocation(ModItems.ProductOne, 0, new ModelResourceLocation(Reference.MODID + ":" + Strings.ProductOne, "inventory"));
        ModelLoader.setCustomModelResourceLocation(ModItems.CryoliteShield, 0, new ModelResourceLocation(Reference.MODID + ":" + Strings.CryoliteShield, "inventory"));
        ModelLoader.setCustomModelResourceLocation(ModItems.FalseTheory, 0, new ModelResourceLocation(Reference.MODID + ":" + Strings.FalseTheory, "inventory"));
        ModelLoader.setCustomModelResourceLocation(ModItems.Glacier, 0, new ModelResourceLocation(Reference.MODID + ":" + Strings.Glacier, "inventory"));
        ModelLoader.setCustomModelResourceLocation(ModItems.AbsoluteZero, 0, new ModelResourceLocation(Reference.MODID + ":" + Strings.AbsoluteZero, "inventory"));
        ModelLoader.setCustomModelResourceLocation(ModItems.Gunz, 0, new ModelResourceLocation(Reference.MODID + ":" + Strings.Gunz, "inventory"));
        ModelLoader.setCustomModelResourceLocation(ModItems.Mindel, 0, new ModelResourceLocation(Reference.MODID + ":" + Strings.Mindel, "inventory"));
        ModelLoader.setCustomModelResourceLocation(ModItems.Snowslide, 0, new ModelResourceLocation(Reference.MODID + ":" + Strings.Snowslide, "inventory"));
        ModelLoader.setCustomModelResourceLocation(ModItems.Iceberg, 0, new ModelResourceLocation(Reference.MODID + ":" + Strings.Iceberg, "inventory"));
        ModelLoader.setCustomModelResourceLocation(ModItems.Inquisition, 0, new ModelResourceLocation(Reference.MODID + ":" + Strings.Inquisition, "inventory"));
        ModelLoader.setCustomModelResourceLocation(ModItems.Scrutiny, 0, new ModelResourceLocation(Reference.MODID + ":" + Strings.Scrutiny, "inventory"));
        ModelLoader.setCustomModelResourceLocation(ModItems.Empiricism, 0, new ModelResourceLocation(Reference.MODID + ":" + Strings.Empiricism, "inventory"));
        ModelLoader.setCustomModelResourceLocation(ModItems.Edification, 0, new ModelResourceLocation(Reference.MODID + ":" + Strings.Edification, "inventory"));
        ModelLoader.setCustomModelResourceLocation(ModItems.Contrivance, 0, new ModelResourceLocation(Reference.MODID + ":" + Strings.Contrivance, "inventory"));
        ModelLoader.setCustomModelResourceLocation(ModItems.Wurm, 0, new ModelResourceLocation(Reference.MODID + ":" + Strings.Wurm, "inventory"));
        ModelLoader.setCustomModelResourceLocation(ModItems.Subzero, 0, new ModelResourceLocation(Reference.MODID + ":" + Strings.Subzero, "inventory"));
        ModelLoader.setCustomModelResourceLocation(ModItems.ColdBlood, 0, new ModelResourceLocation(Reference.MODID + ":" + Strings.ColdBlood, "inventory"));
        ModelLoader.setCustomModelResourceLocation(ModItems.DiamondShield, 0, new ModelResourceLocation(Reference.MODID + ":" + Strings.DiamondShield, "inventory"));
        ModelLoader.setCustomModelResourceLocation(ModItems.Aegis, 0, new ModelResourceLocation(Reference.MODID + ":" + Strings.Aegis, "inventory"));
        ModelLoader.setCustomModelResourceLocation(ModItems.FrozenPride, 0, new ModelResourceLocation(Reference.MODID + ":" + Strings.FrozenPride, "inventory"));
        ModelLoader.setCustomModelResourceLocation(ModItems.PotLid, 0, new ModelResourceLocation(Reference.MODID + ":" + Strings.PotLid, "inventory"));
        ModelLoader.setCustomModelResourceLocation(ModItems.Snowman, 0, new ModelResourceLocation(Reference.MODID + ":" + Strings.Snowman, "inventory"));

        // lexeaus
        ModelLoader.setCustomModelResourceLocation(ModItems.Reticence, 0, new ModelResourceLocation(Reference.MODID + ":" + Strings.Reticence, "inventory"));
        ModelLoader.setCustomModelResourceLocation(ModItems.Goliath, 0, new ModelResourceLocation(Reference.MODID + ":" + Strings.Goliath, "inventory"));
        ModelLoader.setCustomModelResourceLocation(ModItems.CopperRed, 0, new ModelResourceLocation(Reference.MODID + ":" + Strings.CopperRed, "inventory"));
        ModelLoader.setCustomModelResourceLocation(ModItems.Daybreak, 0, new ModelResourceLocation(Reference.MODID + ":" + Strings.Daybreak, "inventory"));
        ModelLoader.setCustomModelResourceLocation(ModItems.Colossus, 0, new ModelResourceLocation(Reference.MODID + ":" + Strings.Colossus, "inventory"));
        ModelLoader.setCustomModelResourceLocation(ModItems.UrsaMajor, 0, new ModelResourceLocation(Reference.MODID + ":" + Strings.UrsaMajor, "inventory"));
        ModelLoader.setCustomModelResourceLocation(ModItems.Megacosm, 0, new ModelResourceLocation(Reference.MODID + ":" + Strings.Megacosm, "inventory"));
        ModelLoader.setCustomModelResourceLocation(ModItems.Terrene, 0, new ModelResourceLocation(Reference.MODID + ":" + Strings.Terrene, "inventory"));
        ModelLoader.setCustomModelResourceLocation(ModItems.Fuligin, 0, new ModelResourceLocation(Reference.MODID + ":" + Strings.Fuligin, "inventory"));
        ModelLoader.setCustomModelResourceLocation(ModItems.HardWinter, 0, new ModelResourceLocation(Reference.MODID + ":" + Strings.HardWinter, "inventory"));
        ModelLoader.setCustomModelResourceLocation(ModItems.Firefly, 0, new ModelResourceLocation(Reference.MODID + ":" + Strings.Firefly, "inventory"));
        ModelLoader.setCustomModelResourceLocation(ModItems.Harbinger, 0, new ModelResourceLocation(Reference.MODID + ":" + Strings.Harbinger, "inventory"));
        ModelLoader.setCustomModelResourceLocation(ModItems.Redwood, 0, new ModelResourceLocation(Reference.MODID + ":" + Strings.Redwood, "inventory"));
        ModelLoader.setCustomModelResourceLocation(ModItems.Sequoia, 0, new ModelResourceLocation(Reference.MODID + ":" + Strings.Sequoia, "inventory"));
        ModelLoader.setCustomModelResourceLocation(ModItems.IronBlack, 0, new ModelResourceLocation(Reference.MODID + ":" + Strings.IronBlack, "inventory"));
        ModelLoader.setCustomModelResourceLocation(ModItems.Earthshine, 0, new ModelResourceLocation(Reference.MODID + ":" + Strings.Earthshine, "inventory"));
        ModelLoader.setCustomModelResourceLocation(ModItems.Octiron, 0, new ModelResourceLocation(Reference.MODID + ":" + Strings.Octiron, "inventory"));
        ModelLoader.setCustomModelResourceLocation(ModItems.Hyperion, 0, new ModelResourceLocation(Reference.MODID + ":" + Strings.Hyperion, "inventory"));
        ModelLoader.setCustomModelResourceLocation(ModItems.Clarity, 0, new ModelResourceLocation(Reference.MODID + ":" + Strings.Clarity, "inventory"));
        ModelLoader.setCustomModelResourceLocation(ModItems.OneThousandAndOneNights, 0, new ModelResourceLocation(Reference.MODID + ":" + Strings.OneThousandAndOneNights, "inventory"));
        ModelLoader.setCustomModelResourceLocation(ModItems.CardinalVirtue, 0, new ModelResourceLocation(Reference.MODID + ":" + Strings.CardinalVirtue, "inventory"));
        ModelLoader.setCustomModelResourceLocation(ModItems.Skysplitter, 0, new ModelResourceLocation(Reference.MODID + ":" + Strings.Skysplitter, "inventory"));
        ModelLoader.setCustomModelResourceLocation(ModItems.BleepBloopBop, 0, new ModelResourceLocation(Reference.MODID + ":" + Strings.BleepBloopBop, "inventory"));
        ModelLoader.setCustomModelResourceLocation(ModItems.Monolith, 0, new ModelResourceLocation(Reference.MODID + ":" + Strings.Monolith, "inventory"));

        // zexion
        ModelLoader.setCustomModelResourceLocation(ModItems.BlackPrimer, 0, new ModelResourceLocation(Reference.MODID + ":" + Strings.BlackPrimer, "inventory"));
        ModelLoader.setCustomModelResourceLocation(ModItems.WhiteTome, 0, new ModelResourceLocation(Reference.MODID + ":" + Strings.WhiteTome, "inventory"));
        ModelLoader.setCustomModelResourceLocation(ModItems.IllicitResearch, 0, new ModelResourceLocation(Reference.MODID + ":" + Strings.IllicitResearch, "inventory"));
        ModelLoader.setCustomModelResourceLocation(ModItems.BuriedSecrets, 0, new ModelResourceLocation(Reference.MODID + ":" + Strings.BuriedSecrets, "inventory"));
        ModelLoader.setCustomModelResourceLocation(ModItems.ArcaneCompendium, 0, new ModelResourceLocation(Reference.MODID + ":" + Strings.ArcaneCompendium, "inventory"));
        ModelLoader.setCustomModelResourceLocation(ModItems.DissentersNotes, 0, new ModelResourceLocation(Reference.MODID + ":" + Strings.DissentersNotes, "inventory"));
        ModelLoader.setCustomModelResourceLocation(ModItems.NefariousCodex, 0, new ModelResourceLocation(Reference.MODID + ":" + Strings.NefariousCodex, "inventory"));
        ModelLoader.setCustomModelResourceLocation(ModItems.MysticAlbum, 0, new ModelResourceLocation(Reference.MODID + ":" + Strings.MysticAlbum, "inventory"));
        ModelLoader.setCustomModelResourceLocation(ModItems.CursedManual, 0, new ModelResourceLocation(Reference.MODID + ":" + Strings.CursedManual, "inventory"));
        ModelLoader.setCustomModelResourceLocation(ModItems.TabooText, 0, new ModelResourceLocation(Reference.MODID + ":" + Strings.TabooText, "inventory"));
        ModelLoader.setCustomModelResourceLocation(ModItems.EldritchEsoterica, 0, new ModelResourceLocation(Reference.MODID + ":" + Strings.EldritchEsoterica, "inventory"));
        ModelLoader.setCustomModelResourceLocation(ModItems.FreakishBestiary, 0, new ModelResourceLocation(Reference.MODID + ":" + Strings.FreakishBestiary, "inventory"));
        ModelLoader.setCustomModelResourceLocation(ModItems.MadmansVita, 0, new ModelResourceLocation(Reference.MODID + ":" + Strings.MadmansVita, "inventory"));
        ModelLoader.setCustomModelResourceLocation(ModItems.UntitledWritings, 0, new ModelResourceLocation(Reference.MODID + ":" + Strings.UntitledWritings, "inventory"));
        ModelLoader.setCustomModelResourceLocation(ModItems.AbandonedDogma, 0, new ModelResourceLocation(Reference.MODID + ":" + Strings.AbandonedDogma, "inventory"));
        ModelLoader.setCustomModelResourceLocation(ModItems.AtlasOfOmens, 0, new ModelResourceLocation(Reference.MODID + ":" + Strings.AtlasOfOmens, "inventory"));
        ModelLoader.setCustomModelResourceLocation(ModItems.RevoltingScrapbook, 0, new ModelResourceLocation(Reference.MODID + ":" + Strings.RevoltingScrapbook, "inventory"));
        ModelLoader.setCustomModelResourceLocation(ModItems.LostHeterodoxy, 0, new ModelResourceLocation(Reference.MODID + ":" + Strings.LostHeterodoxy, "inventory"));
        ModelLoader.setCustomModelResourceLocation(ModItems.OtherworldlyTales, 0, new ModelResourceLocation(Reference.MODID + ":" + Strings.OtherworldlyTales, "inventory"));
        ModelLoader.setCustomModelResourceLocation(ModItems.IndescribableLore, 0, new ModelResourceLocation(Reference.MODID + ":" + Strings.IndescribableLore, "inventory"));
        ModelLoader.setCustomModelResourceLocation(ModItems.RadicalTreatise, 0, new ModelResourceLocation(Reference.MODID + ":" + Strings.RadicalTreatise, "inventory"));
        ModelLoader.setCustomModelResourceLocation(ModItems.BookofRetribution, 0, new ModelResourceLocation(Reference.MODID + ":" + Strings.BookofRetribution, "inventory"));
        ModelLoader.setCustomModelResourceLocation(ModItems.MidnightSnack, 0, new ModelResourceLocation(Reference.MODID + ":" + Strings.MidnightSnack, "inventory"));
        ModelLoader.setCustomModelResourceLocation(ModItems.DearDiary, 0, new ModelResourceLocation(Reference.MODID + ":" + Strings.DearDiary, "inventory"));

        // saix
        ModelLoader.setCustomModelResourceLocation(ModItems.NewMoon, 0, new ModelResourceLocation(Reference.MODID + ":" + Strings.NewMoon, "inventory"));
        ModelLoader.setCustomModelResourceLocation(ModItems.Werewolf, 0, new ModelResourceLocation(Reference.MODID + ":" + Strings.NewMoon, "inventory"));
        ModelLoader.setCustomModelResourceLocation(ModItems.Artemis, 0, new ModelResourceLocation(Reference.MODID + ":" + Strings.NewMoon, "inventory"));
        ModelLoader.setCustomModelResourceLocation(ModItems.Luminary, 0, new ModelResourceLocation(Reference.MODID + ":" + Strings.Luminary, "inventory"));
        ModelLoader.setCustomModelResourceLocation(ModItems.Selene, 0, new ModelResourceLocation(Reference.MODID + ":" + Strings.Selene, "inventory"));
        ModelLoader.setCustomModelResourceLocation(ModItems.Moonrise, 0, new ModelResourceLocation(Reference.MODID + ":" + Strings.Moonrise, "inventory"));
        ModelLoader.setCustomModelResourceLocation(ModItems.Astrologia, 0, new ModelResourceLocation(Reference.MODID + ":" + Strings.Astrologia, "inventory"));
        ModelLoader.setCustomModelResourceLocation(ModItems.Crater, 0, new ModelResourceLocation(Reference.MODID + ":" + Strings.Crater, "inventory"));
        ModelLoader.setCustomModelResourceLocation(ModItems.LunarPhase, 0, new ModelResourceLocation(Reference.MODID + ":" + Strings.LunarPhase, "inventory"));
        ModelLoader.setCustomModelResourceLocation(ModItems.Crescent, 0, new ModelResourceLocation(Reference.MODID + ":" + Strings.Crescent, "inventory"));
        ModelLoader.setCustomModelResourceLocation(ModItems.Gibbous, 0, new ModelResourceLocation(Reference.MODID + ":" + Strings.Gibbous, "inventory"));
        ModelLoader.setCustomModelResourceLocation(ModItems.Berserker, 0, new ModelResourceLocation(Reference.MODID + ":" + Strings.Berserker, "inventory"));
        ModelLoader.setCustomModelResourceLocation(ModItems.Twilight, 0, new ModelResourceLocation(Reference.MODID + ":" + Strings.Twilight, "inventory"));
        ModelLoader.setCustomModelResourceLocation(ModItems.QueenOfTheNight, 0, new ModelResourceLocation(Reference.MODID + ":" + Strings.QueenOfTheNight, "inventory"));
        ModelLoader.setCustomModelResourceLocation(ModItems.BalsamicMoon, 0, new ModelResourceLocation(Reference.MODID + ":" + Strings.BalsamicMoon, "inventory"));
        ModelLoader.setCustomModelResourceLocation(ModItems.Orbit, 0, new ModelResourceLocation(Reference.MODID + ":" + Strings.Orbit, "inventory"));
        ModelLoader.setCustomModelResourceLocation(ModItems.LightYear, 0, new ModelResourceLocation(Reference.MODID + ":" + Strings.LightYear, "inventory"));
        ModelLoader.setCustomModelResourceLocation(ModItems.KingOfTheNight, 0, new ModelResourceLocation(Reference.MODID + ":" + Strings.KingOfTheNight, "inventory"));
        ModelLoader.setCustomModelResourceLocation(ModItems.Moonset, 0, new ModelResourceLocation(Reference.MODID + ":" + Strings.Moonset, "inventory"));
        ModelLoader.setCustomModelResourceLocation(ModItems.Horoscope, 0, new ModelResourceLocation(Reference.MODID + ":" + Strings.Horoscope, "inventory"));
        ModelLoader.setCustomModelResourceLocation(ModItems.Dichotomy, 0, new ModelResourceLocation(Reference.MODID + ":" + Strings.Dichotomy, "inventory"));
        ModelLoader.setCustomModelResourceLocation(ModItems.Lunatic, 0, new ModelResourceLocation(Reference.MODID + ":" + Strings.Lunatic, "inventory"));
        ModelLoader.setCustomModelResourceLocation(ModItems.JustDesserts, 0, new ModelResourceLocation(Reference.MODID + ":" + Strings.JustDesserts, "inventory"));
        ModelLoader.setCustomModelResourceLocation(ModItems.Bunnymoon, 0, new ModelResourceLocation(Reference.MODID + ":" + Strings.Bunnymoon, "inventory"));

        // saix berserk
        ModelLoader.setCustomModelResourceLocation(ModItems.NewMoon, 1, new ModelResourceLocation(Reference.MODID + ":" + Strings.NewMoon + "_b", "inventory"));
        ModelLoader.setCustomModelResourceLocation(ModItems.Werewolf, 1, new ModelResourceLocation(Reference.MODID + ":" + Strings.NewMoon + "_b", "inventory"));
        ModelLoader.setCustomModelResourceLocation(ModItems.Artemis, 1, new ModelResourceLocation(Reference.MODID + ":" + Strings.NewMoon + "_b", "inventory"));
        ModelLoader.setCustomModelResourceLocation(ModItems.Luminary, 1, new ModelResourceLocation(Reference.MODID + ":" + Strings.Luminary + "_b", "inventory"));
        ModelLoader.setCustomModelResourceLocation(ModItems.Selene, 1, new ModelResourceLocation(Reference.MODID + ":" + Strings.Selene + "_b", "inventory"));
        ModelLoader.setCustomModelResourceLocation(ModItems.Moonrise, 1, new ModelResourceLocation(Reference.MODID + ":" + Strings.Moonrise + "_b", "inventory"));
        ModelLoader.setCustomModelResourceLocation(ModItems.Astrologia, 1, new ModelResourceLocation(Reference.MODID + ":" + Strings.Astrologia + "_b", "inventory"));
        ModelLoader.setCustomModelResourceLocation(ModItems.Crater, 1, new ModelResourceLocation(Reference.MODID + ":" + Strings.Crater + "_b", "inventory"));
        ModelLoader.setCustomModelResourceLocation(ModItems.LunarPhase, 1, new ModelResourceLocation(Reference.MODID + ":" + Strings.LunarPhase + "_b", "inventory"));
        ModelLoader.setCustomModelResourceLocation(ModItems.Crescent, 1, new ModelResourceLocation(Reference.MODID + ":" + Strings.Crescent + "_b", "inventory"));
        ModelLoader.setCustomModelResourceLocation(ModItems.Gibbous, 1, new ModelResourceLocation(Reference.MODID + ":" + Strings.Gibbous + "_b", "inventory"));
        ModelLoader.setCustomModelResourceLocation(ModItems.Berserker, 1, new ModelResourceLocation(Reference.MODID + ":" + Strings.Berserker + "_b", "inventory"));
        ModelLoader.setCustomModelResourceLocation(ModItems.Twilight, 1, new ModelResourceLocation(Reference.MODID + ":" + Strings.Twilight + "_b", "inventory"));
        ModelLoader.setCustomModelResourceLocation(ModItems.QueenOfTheNight, 1, new ModelResourceLocation(Reference.MODID + ":" + Strings.QueenOfTheNight + "_b", "inventory"));
        ModelLoader.setCustomModelResourceLocation(ModItems.BalsamicMoon, 1, new ModelResourceLocation(Reference.MODID + ":" + Strings.BalsamicMoon + "_b", "inventory"));
        ModelLoader.setCustomModelResourceLocation(ModItems.Orbit, 1, new ModelResourceLocation(Reference.MODID + ":" + Strings.Orbit + "_b", "inventory"));
        ModelLoader.setCustomModelResourceLocation(ModItems.LightYear, 1, new ModelResourceLocation(Reference.MODID + ":" + Strings.LightYear + "_b", "inventory"));
        ModelLoader.setCustomModelResourceLocation(ModItems.KingOfTheNight, 1, new ModelResourceLocation(Reference.MODID + ":" + Strings.KingOfTheNight + "_b", "inventory"));
        ModelLoader.setCustomModelResourceLocation(ModItems.Moonset, 1, new ModelResourceLocation(Reference.MODID + ":" + Strings.Moonset + "_b", "inventory"));
        ModelLoader.setCustomModelResourceLocation(ModItems.Horoscope, 1, new ModelResourceLocation(Reference.MODID + ":" + Strings.Horoscope + "_b", "inventory"));
        ModelLoader.setCustomModelResourceLocation(ModItems.Dichotomy, 1, new ModelResourceLocation(Reference.MODID + ":" + Strings.Dichotomy + "_b", "inventory"));
        ModelLoader.setCustomModelResourceLocation(ModItems.Lunatic, 1, new ModelResourceLocation(Reference.MODID + ":" + Strings.Lunatic + "_b", "inventory"));
        ModelLoader.setCustomModelResourceLocation(ModItems.JustDesserts, 1, new ModelResourceLocation(Reference.MODID + ":" + Strings.JustDesserts + "_b", "inventory"));
        ModelLoader.setCustomModelResourceLocation(ModItems.Bunnymoon, 1, new ModelResourceLocation(Reference.MODID + ":" + Strings.Bunnymoon + "_b", "inventory"));

        // axel
        ModelLoader.setCustomModelResourceLocation(ModItems.Ashes, 0, new ModelResourceLocation(Reference.MODID + ":" + Strings.Ashes, "inventory"));
        ModelLoader.setCustomModelResourceLocation(ModItems.Doldrums, 0, new ModelResourceLocation(Reference.MODID + ":" + Strings.Doldrums, "inventory"));
        ModelLoader.setCustomModelResourceLocation(ModItems.DelayedAction, 0, new ModelResourceLocation(Reference.MODID + ":" + Strings.DelayedAction, "inventory"));
        ModelLoader.setCustomModelResourceLocation(ModItems.DiveBombers, 0, new ModelResourceLocation(Reference.MODID + ":" + Strings.DiveBombers, "inventory"));
        ModelLoader.setCustomModelResourceLocation(ModItems.Combustion, 0, new ModelResourceLocation(Reference.MODID + ":" + Strings.Combustion, "inventory"));
        ModelLoader.setCustomModelResourceLocation(ModItems.MoulinRouge, 0, new ModelResourceLocation(Reference.MODID + ":" + Strings.MoulinRouge, "inventory"));
        ModelLoader.setCustomModelResourceLocation(ModItems.BlazeofGlory, 0, new ModelResourceLocation(Reference.MODID + ":" + Strings.BlazeofGlory, "inventory"));
        ModelLoader.setCustomModelResourceLocation(ModItems.Prometheus, 0, new ModelResourceLocation(Reference.MODID + ":" + Strings.Prometheus, "inventory"));
        ModelLoader.setCustomModelResourceLocation(ModItems.Ifrit, 0, new ModelResourceLocation(Reference.MODID + ":" + Strings.Ifrit, "inventory"));
        ModelLoader.setCustomModelResourceLocation(ModItems.MagmaOcean, 0, new ModelResourceLocation(Reference.MODID + ":" + Strings.MagmaOcean, "inventory"));
        ModelLoader.setCustomModelResourceLocation(ModItems.Volcanis, 0, new ModelResourceLocation(Reference.MODID + ":" + Strings.Volcanis, "inventory"));
        ModelLoader.setCustomModelResourceLocation(ModItems.Inferno, 0, new ModelResourceLocation(Reference.MODID + ":" + Strings.Inferno, "inventory"));
        ModelLoader.setCustomModelResourceLocation(ModItems.SizzlingEdge, 0, new ModelResourceLocation(Reference.MODID + ":" + Strings.SizzlingEdge, "inventory"));
        ModelLoader.setCustomModelResourceLocation(ModItems.Corona, 0, new ModelResourceLocation(Reference.MODID + ":" + Strings.Corona, "inventory"));
        ModelLoader.setCustomModelResourceLocation(ModItems.FerrisWheel, 0, new ModelResourceLocation(Reference.MODID + ":" + Strings.FerrisWheel, "inventory"));
        ModelLoader.setCustomModelResourceLocation(ModItems.Burnout, 0, new ModelResourceLocation(Reference.MODID + ":" + Strings.Burnout, "inventory"));
        ModelLoader.setCustomModelResourceLocation(ModItems.OmegaTrinity, 0, new ModelResourceLocation(Reference.MODID + ":" + Strings.OmegaTrinity, "inventory"));
        ModelLoader.setCustomModelResourceLocation(ModItems.Outbreak, 0, new ModelResourceLocation(Reference.MODID + ":" + Strings.Outbreak, "inventory"));
        ModelLoader.setCustomModelResourceLocation(ModItems.DoubleEdge, 0, new ModelResourceLocation(Reference.MODID + ":" + Strings.DoubleEdge, "inventory"));
        ModelLoader.setCustomModelResourceLocation(ModItems.Wildfire, 0, new ModelResourceLocation(Reference.MODID + ":" + Strings.Wildfire, "inventory"));
        ModelLoader.setCustomModelResourceLocation(ModItems.Prominence, 0, new ModelResourceLocation(Reference.MODID + ":" + Strings.Prominence, "inventory"));
        ModelLoader.setCustomModelResourceLocation(ModItems.EternalFlames, 0, new ModelResourceLocation(Reference.MODID + ":" + Strings.EternalFlames, "inventory"));
        ModelLoader.setCustomModelResourceLocation(ModItems.PizzaCut, 0, new ModelResourceLocation(Reference.MODID + ":" + Strings.PizzaCut, "inventory"));
        ModelLoader.setCustomModelResourceLocation(ModItems.Conformers, 0, new ModelResourceLocation(Reference.MODID + ":" + Strings.Conformers, "inventory"));

        // demyx
        ModelLoader.setCustomModelResourceLocation(ModItems.BasicModel, 0, new ModelResourceLocation(Reference.MODID + ":" + Strings.BasicModel, "inventory"));
        ModelLoader.setCustomModelResourceLocation(ModItems.TuneUp, 0, new ModelResourceLocation(Reference.MODID + ":" + Strings.TuneUp, "inventory"));
        ModelLoader.setCustomModelResourceLocation(ModItems.Quartet, 0, new ModelResourceLocation(Reference.MODID + ":" + Strings.Quartet, "inventory"));
        ModelLoader.setCustomModelResourceLocation(ModItems.Quintet, 0, new ModelResourceLocation(Reference.MODID + ":" + Strings.Quintet, "inventory"));
        ModelLoader.setCustomModelResourceLocation(ModItems.Overture, 0, new ModelResourceLocation(Reference.MODID + ":" + Strings.Overture, "inventory"));
        ModelLoader.setCustomModelResourceLocation(ModItems.OldHand, 0, new ModelResourceLocation(Reference.MODID + ":" + Strings.OldHand, "inventory"));
        ModelLoader.setCustomModelResourceLocation(ModItems.DaCapo, 0, new ModelResourceLocation(Reference.MODID + ":" + Strings.DaCapo, "inventory"));
        ModelLoader.setCustomModelResourceLocation(ModItems.PowerChord, 0, new ModelResourceLocation(Reference.MODID + ":" + Strings.PowerChord, "inventory"));
        ModelLoader.setCustomModelResourceLocation(ModItems.Fermata, 0, new ModelResourceLocation(Reference.MODID + ":" + Strings.Fermata, "inventory"));
        ModelLoader.setCustomModelResourceLocation(ModItems.Interlude, 0, new ModelResourceLocation(Reference.MODID + ":" + Strings.Interlude, "inventory"));
        ModelLoader.setCustomModelResourceLocation(ModItems.Serenade, 0, new ModelResourceLocation(Reference.MODID + ":" + Strings.Serenade, "inventory"));
        ModelLoader.setCustomModelResourceLocation(ModItems.Songbird, 0, new ModelResourceLocation(Reference.MODID + ":" + Strings.Songbird, "inventory"));
        ModelLoader.setCustomModelResourceLocation(ModItems.RiseToFame, 0, new ModelResourceLocation(Reference.MODID + ":" + Strings.RiseToFame, "inventory"));
        ModelLoader.setCustomModelResourceLocation(ModItems.RockStar, 0, new ModelResourceLocation(Reference.MODID + ":" + Strings.RockStar, "inventory"));
        ModelLoader.setCustomModelResourceLocation(ModItems.EightFinger, 0, new ModelResourceLocation(Reference.MODID + ":" + Strings.EightFinger, "inventory"));
        ModelLoader.setCustomModelResourceLocation(ModItems.Concerto, 0, new ModelResourceLocation(Reference.MODID + ":" + Strings.Concerto, "inventory"));
        ModelLoader.setCustomModelResourceLocation(ModItems.Harmonics, 0, new ModelResourceLocation(Reference.MODID + ":" + Strings.Harmonics, "inventory"));
        ModelLoader.setCustomModelResourceLocation(ModItems.MillionBucks, 0, new ModelResourceLocation(Reference.MODID + ":" + Strings.MillionBucks, "inventory"));
        ModelLoader.setCustomModelResourceLocation(ModItems.Fortissimo, 0, new ModelResourceLocation(Reference.MODID + ":" + Strings.Fortissimo, "inventory"));
        ModelLoader.setCustomModelResourceLocation(ModItems.UpToEleven, 0, new ModelResourceLocation(Reference.MODID + ":" + Strings.UpToEleven, "inventory"));
        ModelLoader.setCustomModelResourceLocation(ModItems.Sanctuary, 0, new ModelResourceLocation(Reference.MODID + ":" + Strings.Sanctuary, "inventory"));
        ModelLoader.setCustomModelResourceLocation(ModItems.Arpeggio, 0, new ModelResourceLocation(Reference.MODID + ":" + Strings.Arpeggio, "inventory"));
        ModelLoader.setCustomModelResourceLocation(ModItems.PrinceOfAwesome, 0, new ModelResourceLocation(Reference.MODID + ":" + Strings.PrinceOfAwesome, "inventory"));
        ModelLoader.setCustomModelResourceLocation(ModItems.AfterSchool, 0, new ModelResourceLocation(Reference.MODID + ":" + Strings.AfterSchool, "inventory"));

        // luxord
        ModelLoader.setCustomModelResourceLocation(ModItems.TheFool, 0, new ModelResourceLocation(Reference.MODID + ":" + Strings.TheFool, "inventory"));
        ModelLoader.setCustomModelResourceLocation(ModItems.TheMagician, 0, new ModelResourceLocation(Reference.MODID + ":" + Strings.TheMagician, "inventory"));
        ModelLoader.setCustomModelResourceLocation(ModItems.TheStar, 0, new ModelResourceLocation(Reference.MODID + ":" + Strings.TheStar, "inventory"));
        ModelLoader.setCustomModelResourceLocation(ModItems.TheMoon, 0, new ModelResourceLocation(Reference.MODID + ":" + Strings.TheMoon, "inventory"));
        ModelLoader.setCustomModelResourceLocation(ModItems.Justice, 0, new ModelResourceLocation(Reference.MODID + ":" + Strings.Justice, "inventory"));
        ModelLoader.setCustomModelResourceLocation(ModItems.TheHierophant, 0, new ModelResourceLocation(Reference.MODID + ":" + Strings.TheHierophant, "inventory"));
        ModelLoader.setCustomModelResourceLocation(ModItems.TheWorld, 0, new ModelResourceLocation(Reference.MODID + ":" + Strings.TheWorld, "inventory"));
        ModelLoader.setCustomModelResourceLocation(ModItems.Temperance, 0, new ModelResourceLocation(Reference.MODID + ":" + Strings.Temperance, "inventory"));
        ModelLoader.setCustomModelResourceLocation(ModItems.TheHighPriestess, 0, new ModelResourceLocation(Reference.MODID + ":" + Strings.TheHighPriestess, "inventory"));
        ModelLoader.setCustomModelResourceLocation(ModItems.TheTower, 0, new ModelResourceLocation(Reference.MODID + ":" + Strings.TheTower, "inventory"));
        ModelLoader.setCustomModelResourceLocation(ModItems.TheHangedMan, 0, new ModelResourceLocation(Reference.MODID + ":" + Strings.TheHangedMan, "inventory"));
        ModelLoader.setCustomModelResourceLocation(ModItems.Death, 0, new ModelResourceLocation(Reference.MODID + ":" + Strings.Death, "inventory"));
        ModelLoader.setCustomModelResourceLocation(ModItems.TheHermit, 0, new ModelResourceLocation(Reference.MODID + ":" + Strings.TheHermit, "inventory"));
        ModelLoader.setCustomModelResourceLocation(ModItems.Strength, 0, new ModelResourceLocation(Reference.MODID + ":" + Strings.Strength, "inventory"));
        ModelLoader.setCustomModelResourceLocation(ModItems.TheLovers, 0, new ModelResourceLocation(Reference.MODID + ":" + Strings.TheLovers, "inventory"));
        ModelLoader.setCustomModelResourceLocation(ModItems.TheChariot, 0, new ModelResourceLocation(Reference.MODID + ":" + Strings.TheChariot, "inventory"));
        ModelLoader.setCustomModelResourceLocation(ModItems.TheSun, 0, new ModelResourceLocation(Reference.MODID + ":" + Strings.TheSun, "inventory"));
        ModelLoader.setCustomModelResourceLocation(ModItems.TheDevil, 0, new ModelResourceLocation(Reference.MODID + ":" + Strings.TheDevil, "inventory"));
        ModelLoader.setCustomModelResourceLocation(ModItems.TheEmpress, 0, new ModelResourceLocation(Reference.MODID + ":" + Strings.TheEmpress, "inventory"));
        ModelLoader.setCustomModelResourceLocation(ModItems.TheEmperor, 0, new ModelResourceLocation(Reference.MODID + ":" + Strings.TheEmperor, "inventory"));
        ModelLoader.setCustomModelResourceLocation(ModItems.TheJoker, 0, new ModelResourceLocation(Reference.MODID + ":" + Strings.TheJoker, "inventory"));
        ModelLoader.setCustomModelResourceLocation(ModItems.FairGame, 0, new ModelResourceLocation(Reference.MODID + ":" + Strings.FairGame, "inventory"));
        ModelLoader.setCustomModelResourceLocation(ModItems.FinestFantasy13, 0, new ModelResourceLocation(Reference.MODID + ":" + Strings.FinestFantasy13, "inventory"));
        ModelLoader.setCustomModelResourceLocation(ModItems.HighRollersSecret, 0, new ModelResourceLocation(Reference.MODID + ":" + Strings.HighRollersSecret, "inventory"));

        // marluxia
        ModelLoader.setCustomModelResourceLocation(ModItems.FickleErica, 0, new ModelResourceLocation(Reference.MODID + ":" + Strings.FickleErica, "inventory"));
        ModelLoader.setCustomModelResourceLocation(ModItems.JiltedAnemone, 0, new ModelResourceLocation(Reference.MODID + ":" + Strings.JiltedAnemone, "inventory"));
        ModelLoader.setCustomModelResourceLocation(ModItems.ProudAmaryllis, 0, new ModelResourceLocation(Reference.MODID + ":" + Strings.ProudAmaryllis, "inventory"));
        ModelLoader.setCustomModelResourceLocation(ModItems.MadSafflower, 0, new ModelResourceLocation(Reference.MODID + ":" + Strings.MadSafflower, "inventory"));
        ModelLoader.setCustomModelResourceLocation(ModItems.PoorMelissa, 0, new ModelResourceLocation(Reference.MODID + ":" + Strings.PoorMelissa, "inventory"));
        ModelLoader.setCustomModelResourceLocation(ModItems.TragicAllium, 0, new ModelResourceLocation(Reference.MODID + ":" + Strings.TragicAllium, "inventory"));
        ModelLoader.setCustomModelResourceLocation(ModItems.MournfalCineria, 0, new ModelResourceLocation(Reference.MODID + ":" + Strings.MournfalCineria, "inventory"));
        ModelLoader.setCustomModelResourceLocation(ModItems.PseudoSilene, 0, new ModelResourceLocation(Reference.MODID + ":" + Strings.PseudoSilene, "inventory"));
        ModelLoader.setCustomModelResourceLocation(ModItems.FaithlessDigitalis, 0, new ModelResourceLocation(Reference.MODID + ":" + Strings.FaithlessDigitalis, "inventory"));
        ModelLoader.setCustomModelResourceLocation(ModItems.GrimMuscari, 0, new ModelResourceLocation(Reference.MODID + ":" + Strings.GrimMuscari, "inventory"));
        ModelLoader.setCustomModelResourceLocation(ModItems.DocileVallota, 0, new ModelResourceLocation(Reference.MODID + ":" + Strings.DocileVallota, "inventory"));
        ModelLoader.setCustomModelResourceLocation(ModItems.QuietBelladonna, 0, new ModelResourceLocation(Reference.MODID + ":" + Strings.QuietBelladonna, "inventory"));
        ModelLoader.setCustomModelResourceLocation(ModItems.PartingIpheion, 0, new ModelResourceLocation(Reference.MODID + ":" + Strings.PartingIpheion, "inventory"));
        ModelLoader.setCustomModelResourceLocation(ModItems.LoftyGerbera, 0, new ModelResourceLocation(Reference.MODID + ":" + Strings.LoftyGerbera, "inventory"));
        ModelLoader.setCustomModelResourceLocation(ModItems.GallantAchillea, 0, new ModelResourceLocation(Reference.MODID + ":" + Strings.GallantAchillea, "inventory"));
        ModelLoader.setCustomModelResourceLocation(ModItems.NoblePeony, 0, new ModelResourceLocation(Reference.MODID + ":" + Strings.NoblePeony, "inventory"));
        ModelLoader.setCustomModelResourceLocation(ModItems.FearsomeAnise, 0, new ModelResourceLocation(Reference.MODID + ":" + Strings.FearsomeAnise, "inventory"));
        ModelLoader.setCustomModelResourceLocation(ModItems.VindictiveThistle, 0, new ModelResourceLocation(Reference.MODID + ":" + Strings.VindictiveThistle, "inventory"));
        ModelLoader.setCustomModelResourceLocation(ModItems.FairHelianthus, 0, new ModelResourceLocation(Reference.MODID + ":" + Strings.FairHelianthus, "inventory"));
        ModelLoader.setCustomModelResourceLocation(ModItems.SolemnMagnolia, 0, new ModelResourceLocation(Reference.MODID + ":" + Strings.SolemnMagnolia, "inventory"));
        ModelLoader.setCustomModelResourceLocation(ModItems.HallowedLotus, 0, new ModelResourceLocation(Reference.MODID + ":" + Strings.HallowedLotus, "inventory"));
        ModelLoader.setCustomModelResourceLocation(ModItems.GracefulDahlia, 0, new ModelResourceLocation(Reference.MODID + ":" + Strings.GracefulDahlia, "inventory"));
        ModelLoader.setCustomModelResourceLocation(ModItems.StirringLadle, 0, new ModelResourceLocation(Reference.MODID + ":" + Strings.StirringLadle, "inventory"));
        ModelLoader.setCustomModelResourceLocation(ModItems.DaintyBellflowers, 0, new ModelResourceLocation(Reference.MODID + ":" + Strings.DaintyBellflowers, "inventory"));

        // larxene
        ModelLoader.setCustomModelResourceLocation(ModItems.Trancheuse, 0, new ModelResourceLocation(Reference.MODID + ":" + Strings.Trancheuse, "inventory"));
        ModelLoader.setCustomModelResourceLocation(ModItems.Orage, 0, new ModelResourceLocation(Reference.MODID + ":" + Strings.Orage, "inventory"));
        ModelLoader.setCustomModelResourceLocation(ModItems.Tourbillon, 0, new ModelResourceLocation(Reference.MODID + ":" + Strings.Tourbillon, "inventory"));
        ModelLoader.setCustomModelResourceLocation(ModItems.Tempete, 0, new ModelResourceLocation(Reference.MODID + ":" + Strings.Tempete, "inventory"));
        ModelLoader.setCustomModelResourceLocation(ModItems.Carmin, 0, new ModelResourceLocation(Reference.MODID + ":" + Strings.Carmin, "inventory"));
        ModelLoader.setCustomModelResourceLocation(ModItems.Meteore, 0, new ModelResourceLocation(Reference.MODID + ":" + Strings.Meteore, "inventory"));
        ModelLoader.setCustomModelResourceLocation(ModItems.Etoile, 0, new ModelResourceLocation(Reference.MODID + ":" + Strings.Etoile, "inventory"));
        ModelLoader.setCustomModelResourceLocation(ModItems.Irregulier, 0, new ModelResourceLocation(Reference.MODID + ":" + Strings.Irregulier, "inventory"));
        ModelLoader.setCustomModelResourceLocation(ModItems.Dissonance, 0, new ModelResourceLocation(Reference.MODID + ":" + Strings.Dissonance, "inventory"));
        ModelLoader.setCustomModelResourceLocation(ModItems.Eruption, 0, new ModelResourceLocation(Reference.MODID + ":" + Strings.Eruption, "inventory"));
        ModelLoader.setCustomModelResourceLocation(ModItems.SoleilCouchant, 0, new ModelResourceLocation(Reference.MODID + ":" + Strings.SoleilCouchant, "inventory"));
        ModelLoader.setCustomModelResourceLocation(ModItems.Indigo, 0, new ModelResourceLocation(Reference.MODID + ":" + Strings.Indigo, "inventory"));
        ModelLoader.setCustomModelResourceLocation(ModItems.Vague, 0, new ModelResourceLocation(Reference.MODID + ":" + Strings.Vague, "inventory"));
        ModelLoader.setCustomModelResourceLocation(ModItems.Deluge, 0, new ModelResourceLocation(Reference.MODID + ":" + Strings.Deluge, "inventory"));
        ModelLoader.setCustomModelResourceLocation(ModItems.Rafale, 0, new ModelResourceLocation(Reference.MODID + ":" + Strings.Rafale, "inventory"));
        ModelLoader.setCustomModelResourceLocation(ModItems.Typhon, 0, new ModelResourceLocation(Reference.MODID + ":" + Strings.Typhon, "inventory"));
        ModelLoader.setCustomModelResourceLocation(ModItems.Extirpeur, 0, new ModelResourceLocation(Reference.MODID + ":" + Strings.Extirpeur, "inventory"));
        ModelLoader.setCustomModelResourceLocation(ModItems.CroixDuSud, 0, new ModelResourceLocation(Reference.MODID + ":" + Strings.CroixDuSud, "inventory"));
        ModelLoader.setCustomModelResourceLocation(ModItems.Lumineuse, 0, new ModelResourceLocation(Reference.MODID + ":" + Strings.Lumineuse, "inventory"));
        ModelLoader.setCustomModelResourceLocation(ModItems.ClairdeLune, 0, new ModelResourceLocation(Reference.MODID + ":" + Strings.ClairdeLune, "inventory"));
        ModelLoader.setCustomModelResourceLocation(ModItems.VoldeNuit, 0, new ModelResourceLocation(Reference.MODID + ":" + Strings.VoldeNuit, "inventory"));
        ModelLoader.setCustomModelResourceLocation(ModItems.Foudre, 0, new ModelResourceLocation(Reference.MODID + ":" + Strings.Foudre, "inventory"));
        ModelLoader.setCustomModelResourceLocation(ModItems.Demoiselle, 0, new ModelResourceLocation(Reference.MODID + ":" + Strings.Demoiselle, "inventory"));
        ModelLoader.setCustomModelResourceLocation(ModItems.Ampoule, 0, new ModelResourceLocation(Reference.MODID + ":" + Strings.Ampoule, "inventory"));

        //Blocks
        ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(ModBlocks.KKChest), 0, new ModelResourceLocation(Reference.MODID + ":" + Strings.KKChest, "inventory"));
        ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(ModBlocks.StationOfAwakeningDoor), 0, new ModelResourceLocation(Reference.MODID + ":" + Strings.StationOfAwakeningDoor, "inventory"));
        ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(ModBlocks.Pedestal), 0, new ModelResourceLocation(Reference.MODID + ":" + Strings.Pedestal, "inventory"));

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
            ModAchievements.openMenu.setStatStringFormatter(new IStatStringFormat() {
                @Override
                public String formatString(String s) {
                    try {
                        return String.format(s, Keyboard.getKeyName(InputHandler.Keybinds.OPENMENU.getKeybind().getKeyCode()));
                    } catch (Exception e) {
                        return s;
                    }
                }
            }
        );
        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityPedestal.class, new TESRPedestal());
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
