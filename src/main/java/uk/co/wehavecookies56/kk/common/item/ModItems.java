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
import net.minecraftforge.fml.common.registry.GameRegistry;
import uk.co.wehavecookies56.kk.client.sound.ModSounds;
import uk.co.wehavecookies56.kk.common.core.handler.BalanceConfig;
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

public class ModItems {

    // Organization

    //Xemnas
    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.Malice)
    public static Item Malice;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.Sanction)
    public static Item Sanction;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.Overlord)
    public static Item Overlord;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.Veneration)
    public static Item Veneration;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.Autocracy)
    public static Item Autocracy;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.Conquest)
    public static Item Conquest;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.Terminus)
    public static Item Terminus;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.Judgement)
    public static Item Judgement;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.Discipline)
    public static Item Discipline;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.Aristocracy)
    public static Item Aristocracy;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.Superiority)
    public static Item Superiority;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.Aggression)
    public static Item Aggression;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.Fury)
    public static Item Fury;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.Despair)
    public static Item Despair;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.Triumph)
    public static Item Triumph;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.Ruination)
    public static Item Ruination;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.Domination)
    public static Item Domination;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.Annihilation)
    public static Item Annihilation;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.Tyrant)
    public static Item Tyrant;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.Magnificence)
    public static Item Magnificence;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.Infinity)
    public static Item Infinity;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.Interdiction)
    public static Item Interdiction;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.RoundFan)
    public static Item RoundFan;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.Absolute)
    public static Item Absolute;

    //Xigbar
    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.Standalone)
    public static Item Standalone;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.Killerbee)
    public static Item Killerbee;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.Stingray)
    public static Item Stingray;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.Counterweight)
    public static Item Counterweight;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.Precision)
    public static Item Precision;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.DualHead)
    public static Item DualHead;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.Bahamut)
    public static Item Bahamut;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.Gullwing)
    public static Item Gullwing;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.BlueFrame)
    public static Item BlueFrame;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.StarShell)
    public static Item StarShell;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.Sunrise)
    public static Item Sunrise;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.Ignition)
    public static Item Ignition;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.Armstrong)
    public static Item Armstrong;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.HardBoiledHeat)
    public static Item HardBoiledHeat;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.DiabloEye)
    public static Item DiabloEye;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.DoubleTap)
    public static Item DoubleTap;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.Stardust)
    public static Item Stardust;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.EnergyMuzzle)
    public static Item EnergyMuzzle;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.CrimeAndPunishment)
    public static Item CrimeAndPunishment;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.CupidsArrow)
    public static Item CupidsArrow;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.FinalWeapon)
    public static Item FinalWeapon;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.Sharpshooter)
    public static Item Sharpshooter;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.Dryer)
    public static Item Dryer;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.Trumpet)
    public static Item Trumpet;

    //Xaldin
    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.Zephyr)
    public static Item Zephyr;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.Moonglade)
    public static Item Moonglade;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.Aer)
    public static Item Aer;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.Nescience)
    public static Item Nescience;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.Brume)
    public static Item Brume;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.Asura)
    public static Item Asura;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.Crux)
    public static Item Crux;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.Paladin)
    public static Item Paladin;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.Fellking)
    public static Item Fellking;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.Nightcloud)
    public static Item Nightcloud;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.Shimmer)
    public static Item Shimmer;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.Vortex)
    public static Item Vortex;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.Scission)
    public static Item Scission;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.Heavenfall)
    public static Item Heavenfall;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.Aether)
    public static Item Aether;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.Mazzaroth)
    public static Item Mazzaroth;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.Hegemon)
    public static Item Hegemon;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.Foxfire)
    public static Item Foxfire;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.Yaksha)
    public static Item Yaksha;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.Cynosura)
    public static Item Cynosura;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.Dragonreign)
    public static Item Dragonreign;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.Lindworm)
    public static Item Lindworm;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.Broom)
    public static Item Broom;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.Wyvern)
    public static Item Wyvern;

    //Vexen
    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.TesterZero)
    public static Item TesterZero;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.ProductOne)
    public static Item ProductOne;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.DeepFreeze)
    public static Item DeepFreeze;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.CryoliteShield)
    public static Item CryoliteShield;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.FalseTheory)
    public static Item FalseTheory;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.Glacier)
    public static Item Glacier;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.AbsoluteZero)
    public static Item AbsoluteZero;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.Gunz)
    public static Item Gunz;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.Mindel)
    public static Item Mindel;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.Snowslide)
    public static Item Snowslide;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.Iceberg)
    public static Item Iceberg;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.Inquisition)
    public static Item Inquisition;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.Scrutiny)
    public static Item Scrutiny;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.Empiricism)
    public static Item Empiricism;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.Edification)
    public static Item Edification;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.Contrivance)
    public static Item Contrivance;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.Wurm)
    public static Item Wurm;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.Subzero)
    public static Item Subzero;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.ColdBlood)
    public static Item ColdBlood;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.DiamondShield)
    public static Item DiamondShield;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.Aegis)
    public static Item Aegis;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.FrozenPride)
    public static Item FrozenPride;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.PotLid)
    public static Item PotLid;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.Snowman)
    public static Item Snowman;

    //Lexaeus
    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.Reticence)
    public static Item Reticence;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.Goliath)
    public static Item Goliath;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.CopperRed)
    public static Item CopperRed;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.Daybreak)
    public static Item Daybreak;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.Colossus)
    public static Item Colossus;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.UrsaMajor)
    public static Item UrsaMajor;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.Megacosm)
    public static Item Megacosm;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.Terrene)
    public static Item Terrene;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.Fuligin)
    public static Item Fuligin;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.HardWinter)
    public static Item HardWinter;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.Firefly)
    public static Item Firefly;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.Harbinger)
    public static Item Harbinger;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.Redwood)
    public static Item Redwood;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.Sequoia)
    public static Item Sequoia;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.IronBlack)
    public static Item IronBlack;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.Earthshine)
    public static Item Earthshine;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.Octiron)
    public static Item Octiron;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.Hyperion)
    public static Item Hyperion;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.Clarity)
    public static Item Clarity;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.OneThousandAndOneNights)
    public static Item OneThousandAndOneNights;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.CardinalVirtue)
    public static Item CardinalVirtue;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.Skysplitter)
    public static Item Skysplitter;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.BleepBloopBop)
    public static Item BleepBloopBop;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.Monolith)
    public static Item Monolith;

    //Zexion
    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.BlackPrimer)
    public static Item BlackPrimer;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.WhiteTome)
    public static Item WhiteTome;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.IllicitResearch)
    public static Item IllicitResearch;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.BuriedSecrets)
    public static Item BuriedSecrets;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.ArcaneCompendium)
    public static Item ArcaneCompendium;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.DissentersNotes)
    public static Item DissentersNotes;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.NefariousCodex)
    public static Item NefariousCodex;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.MysticAlbum)
    public static Item MysticAlbum;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.CursedManual)
    public static Item CursedManual;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.TabooText)
    public static Item TabooText;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.EldritchEsoterica)
    public static Item EldritchEsoterica;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.FreakishBestiary)
    public static Item FreakishBestiary;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.MadmansVita)
    public static Item MadmansVita;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.UntitledWritings)
    public static Item UntitledWritings;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.AbandonedDogma)
    public static Item AbandonedDogma;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.AtlasOfOmens)
    public static Item AtlasOfOmens;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.RevoltingScrapbook)
    public static Item RevoltingScrapbook;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.LostHeterodoxy)
    public static Item LostHeterodoxy;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.OtherworldlyTales)
    public static Item OtherworldlyTales;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.IndescribableLore)
    public static Item IndescribableLore;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.RadicalTreatise)
    public static Item RadicalTreatise;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.BookofRetribution)
    public static Item BookofRetribution;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.MidnightSnack)
    public static Item MidnightSnack;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.DearDiary)
    public static Item DearDiary;

    //Saix
    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.NewMoon)
    public static Item NewMoon;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.Werewolf)
    public static Item Werewolf;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.Artemis)
    public static Item Artemis;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.Luminary)
    public static Item Luminary;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.Selene)
    public static Item Selene;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.Moonrise)
    public static Item Moonrise;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.Astrologia)
    public static Item Astrologia;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.Crater)
    public static Item Crater;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.LunarPhase)
    public static Item LunarPhase;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.Crescent)
    public static Item Crescent;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.Gibbous)
    public static Item Gibbous;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.Berserker)
    public static Item Berserker;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.Twilight)
    public static Item Twilight;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.QueenOfTheNight)
    public static Item QueenOfTheNight;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.BalsamicMoon)
    public static Item BalsamicMoon;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.Orbit)
    public static Item Orbit;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.LightYear)
    public static Item LightYear;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.KingOfTheNight)
    public static Item KingOfTheNight;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.Moonset)
    public static Item Moonset;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.Horoscope)
    public static Item Horoscope;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.Dichotomy)
    public static Item Dichotomy;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.Lunatic)
    public static Item Lunatic;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.JustDesserts)
    public static Item JustDesserts;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.Bunnymoon)
    public static Item Bunnymoon;

    //Axel
    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.Ashes)
    public static Item Ashes;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.Doldrums)
    public static Item Doldrums;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.DelayedAction)
    public static Item DelayedAction;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.DiveBombers)
    public static Item DiveBombers;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.Combustion)
    public static Item Combustion;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.MoulinRouge)
    public static Item MoulinRouge;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.BlazeofGlory)
    public static Item BlazeofGlory;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.Prometheus)
    public static Item Prometheus;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.Ifrit)
    public static Item Ifrit;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.MagmaOcean)
    public static Item MagmaOcean;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.Volcanics)
    public static Item Volcanics;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.Inferno)
    public static Item Inferno;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.SizzlingEdge)
    public static Item SizzlingEdge;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.Corona)
    public static Item Corona;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.FerrisWheel)
    public static Item FerrisWheel;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.Burnout)
    public static Item Burnout;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.OmegaTrinity)
    public static Item OmegaTrinity;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.Outbreak)
    public static Item Outbreak;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.DoubleEdge)
    public static Item DoubleEdge;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.Wildfire)
    public static Item Wildfire;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.Prominence)
    public static Item Prominence;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.EternalFlames)
    public static Item EternalFlames;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.PizzaCut)
    public static Item PizzaCut;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.Conformers)
    public static Item Conformers;

    //Demyx
    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.BasicModel)
    public static Item BasicModel;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.TuneUp)
    public static Item TuneUp;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.Quartet)
    public static Item Quartet;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.Quintet)
    public static Item Quintet;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.Overture)
    public static Item Overture;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.OldHand)
    public static Item OldHand;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.DaCapo)
    public static Item DaCapo;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.PowerChord)
    public static Item PowerChord;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.Fermata)
    public static Item Fermata;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.Interlude)
    public static Item Interlude;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.Serenade)
    public static Item Serenade;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.Songbird)
    public static Item Songbird;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.RiseToFame)
    public static Item RiseToFame;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.RockStar)
    public static Item RockStar;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.EightFinger)
    public static Item EightFinger;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.Concerto)
    public static Item Concerto;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.Harmonics)
    public static Item Harmonics;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.MillionBucks)
    public static Item MillionBucks;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.Fortissimo)
    public static Item Fortissimo;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.UpToEleven)
    public static Item UpToEleven;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.Sanctuary)
    public static Item Sanctuary;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.Arpeggio)
    public static Item Arpeggio;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.PrinceOfAwesome)
    public static Item PrinceOfAwesome;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.AfterSchool)
    public static Item AfterSchool;

    //Luxord
    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.TheFool)
    public static Item TheFool;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.TheMagician)
    public static Item TheMagician;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.TheStar)
    public static Item TheStar;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.TheMoon)
    public static Item TheMoon;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.Justice)
    public static Item Justice;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.TheHierophant)
    public static Item TheHierophant;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.TheWorld)
    public static Item TheWorld;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.Temperance)
    public static Item Temperance;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.TheHighPriestess)
    public static Item TheHighPriestess;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.TheTower)
    public static Item TheTower;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.TheHangedMan)
    public static Item TheHangedMan;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.Death)
    public static Item Death;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.TheHermit)
    public static Item TheHermit;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.Strength)
    public static Item Strength;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.TheLovers)
    public static Item TheLovers;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.TheChariot)
    public static Item TheChariot;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.TheSun)
    public static Item TheSun;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.TheDevil)
    public static Item TheDevil;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.TheEmpress)
    public static Item TheEmpress;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.TheEmperor)
    public static Item TheEmperor;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.TheJoker)
    public static Item TheJoker;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.FairGame)
    public static Item FairGame;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.FinestFantasy13)
    public static Item FinestFantasy13;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.HighRollersSecret)
    public static Item HighRollersSecret;

    //Marluxia
    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.FickleErica)
    public static Item FickleErica;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.JiltedAnemone)
    public static Item JiltedAnemone;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.ProudAmaryllis)
    public static Item ProudAmaryllis;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.MadSafflower)
    public static Item MadSafflower;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.PoorMelissa)
    public static Item PoorMelissa;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.TragicAllium)
    public static Item TragicAllium;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.MournfulCineria)
    public static Item MournfulCineria;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.PseudoSilene)
    public static Item PseudoSilene;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.FaithlessDigitalis)
    public static Item FaithlessDigitalis;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.GrimMuscari)
    public static Item GrimMuscari;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.DocileVallota)
    public static Item DocileVallota;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.QuietBelladonna)
    public static Item QuietBelladonna;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.PartingIpheion)
    public static Item PartingIpheion;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.LoftyGerbera)
    public static Item LoftyGerbera;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.GallantAchillea)
    public static Item GallantAchillea;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.NoblePeony)
    public static Item NoblePeony;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.FearsomeAnise)
    public static Item FearsomeAnise;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.VindictiveThistle)
    public static Item VindictiveThistle;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.FairHelianthus)
    public static Item FairHelianthus;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.SolemnMagnolia)
    public static Item SolemnMagnolia;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.HallowedLotus)
    public static Item HallowedLotus;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.GracefulDahlia)
    public static Item GracefulDahlia;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.StirringLadle)
    public static Item StirringLadle;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.DaintyBellflowers)
    public static Item DaintyBellflowers;

    //Larxene
    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.Trancheuse)
    public static Item Trancheuse;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.Orage)
    public static Item Orage;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.Tourbillon)
    public static Item Tourbillon;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.Tempete)
    public static Item Tempete;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.Carmin)
    public static Item Carmin;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.Meteore)
    public static Item Meteore;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.Etoile)
    public static Item Etoile;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.Irregulier)
    public static Item Irregulier;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.Dissonance)
    public static Item Dissonance;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.Eruption)
    public static Item Eruption;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.SoleilCouchant)
    public static Item SoleilCouchant;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.Indigo)
    public static Item Indigo;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.Vague)
    public static Item Vague;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.Deluge)
    public static Item Deluge;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.Rafale)
    public static Item Rafale;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.Typhon)
    public static Item Typhon;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.Extirpeur)
    public static Item Extirpeur;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.CroixDuSud)
    public static Item CroixDuSud;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.Lumineuse)
    public static Item Lumineuse;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.ClairdeLune)
    public static Item ClairdeLune;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.VoldeNuit)
    public static Item VoldeNuit;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.Foudre)
    public static Item Foudre;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.Demoiselle)
    public static Item Demoiselle;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.Ampoule)
    public static Item Ampoule;

    // Crafting Martierials & knowledges
    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.BlazingInfusedCoal)
    public static Item BlazingInfusedCoal;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.FrostInfusedSnowBall)
    public static Item FrostInfusedSnowBall;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.StormyInfusedIron)
    public static Item StormyInfusedIron;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.MythrilInfusedDiamond)
    public static Item MythrilInfusedDiamond;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.LightningInfusedGold)
    public static Item LightningInfusedGold;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.BrightInfusedGlowStone)
    public static Item BrightInfusedGlowStone;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.DarkInfusedIron)
    public static Item DarkInfusedIron;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.AbandonedKnowledge)
    public static Item AbandonedKnowledge;

    //Other weapons
    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.DreamShield)
    public static Item DreamShield;
    
    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.DreamStaff)
    public static Item DreamStaff;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.DreamSword)
    public static Item DreamSword;

    // Keyblades
    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.AbaddonPlasma)
    public static Item AbaddonPlasma;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.AbyssalTide)
    public static Item AbyssalTide;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.AllforOne)
    public static Item AllforOne;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.AnguisForetellersKeyblade)
    public static Item AnguisForetellersKeyblade;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.AstralBlast)
    public static Item AstralBlast;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.Aubade)
    public static Item Aubade;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.BondofFlame)
    public static Item BondofFlame;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.Brightcrest)
    public static Item Brightcrest;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.ChaosRipper)
    public static Item ChaosRipper;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.CircleofLife)
    public static Item CircleofLife;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.Counterpoint)
    public static Item Counterpoint;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.Crabclaw)
    public static Item Crabclaw;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.CrownofGuilt)
    public static Item CrownofGuilt;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.DarkerThanDark)
    public static Item DarkerThanDark;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.Darkgnaw)
    public static Item Darkgnaw;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.DecisivePumpkin)
    public static Item DecisivePumpkin;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.DestinysEmbrace)
    public static Item DestinysEmbrace;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.DiamondDust)
    public static Item DiamondDust;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.Divewing)
    public static Item Divewing;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.DivineRose)
    public static Item DivineRose;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.DualDisc)
    public static Item DualDisc;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.Earthshaker)
    public static Item Earthshaker;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.EndofPain)
    public static Item EndofPain;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.EndsoftheEarth)
    public static Item EndsoftheEarth;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.FairyHarp)
    public static Item FairyHarp;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.FairyStars)
    public static Item FairyStars;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.FatalCrest)
    public static Item FatalCrest;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.Fenrir)
    public static Item Fenrir;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.FerrisGear)
    public static Item FerrisGear;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.FollowtheWind)
    public static Item FollowtheWind;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.FrolicFlame)
    public static Item FrolicFlame;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.GlimpseofDarkness)
    public static Item GlimpseofDarkness;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.GuardianBell)
    public static Item GuardianBell;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.GuardianSoul)
    public static Item GuardianSoul;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.GullWing)
    public static Item GullWing;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.HerosCrest)
    public static Item HerosCrest;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.HiddenDragon)
    public static Item HiddenDragon;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.Hyperdrive)
    public static Item Hyperdrive;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.IncompleteKiblade)
    public static Item IncompleteKiblade;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.JungleKing)
    public static Item JungleKing;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.KeybladeofPeoplesHearts)
    public static Item KeybladeofPeoplesHearts;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.Kiblade)
    public static Item Kiblade;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.KingdomKey)
    public static Item KingdomKey;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.KingdomKeyD)
    public static Item KingdomKeyD;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.KnockoutPunch)
    public static Item KnockoutPunch;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.LadyLuck)
    public static Item LadyLuck;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.LeasKeyblade)
    public static Item LeasKeyblade;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.LeopardosForetellersKeyblade)
    public static Item LeopardosForetellersKeyblade;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.Leviathan)
    public static Item Leviathan;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.Lionheart)
    public static Item Lionheart;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.LostMemory)
    public static Item LostMemory;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.LunarEclipse)
    public static Item LunarEclipse;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.MarkofaHero)
    public static Item MarkofaHero;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.MasterXehanortsKeyblade)
    public static Item MasterXehanortsKeyblade;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.MastersDefender)
    public static Item MastersDefender;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.MaverickFlare)
    public static Item MaverickFlare;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.MetalChocobo)
    public static Item MetalChocobo;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.MidnightRoar)
    public static Item MidnightRoar;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.MirageSplit)
    public static Item MirageSplit;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.MissingAche)
    public static Item MissingAche;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.Monochrome)
    public static Item Monochrome;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.MysteriousAbyss)
    public static Item MysteriousAbyss;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.NightmaresEnd)
    public static Item NightmaresEnd;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.NightmaresEndandMirageSplit)
    public static Item NightmaresEndandMirageSplit;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.NoName)
    public static Item NoName;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.Oathkeeper)
    public static Item Oathkeeper;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.Oblivion)
    public static Item Oblivion;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.OceansRage)
    public static Item OceansRage;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.Olympia)
    public static Item Olympia;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.OmegaWeapon)
    public static Item OmegaWeapon;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.OminousBlight)
    public static Item OminousBlight;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.OneWingedAngel)
    public static Item OneWingedAngel;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.PainofSolitude)
    public static Item PainofSolitude;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.PhotonDebugger)
    public static Item PhotonDebugger;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.PixiePetal)
    public static Item PixiePetal;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.Pumpkinhead)
    public static Item Pumpkinhead;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.Rainfell)
    public static Item Rainfell;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.RejectionofFate)
    public static Item RejectionofFate;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.RoyalRadiance)
    public static Item RoyalRadiance;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.RumblingRose)
    public static Item RumblingRose;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.SignofInnocence)
    public static Item SignofInnocence;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.SilentDirge)
    public static Item SilentDirge;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.SkullNoise)
    public static Item SkullNoise;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.SleepingLion)
    public static Item SleepingLion;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.SoulEater)
    public static Item SoulEater;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.Spellbinder)
    public static Item Spellbinder;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.StarSeeker)
    public static Item StarSeeker;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.Starlight)
    public static Item Starlight;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.Stormfall)
    public static Item Stormfall;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.StrokeofMidnight)
    public static Item StrokeofMidnight;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.SweetDreams)
    public static Item SweetDreams;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.SweetMemories)
    public static Item SweetMemories;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.Sweetstack)
    public static Item Sweetstack;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.ThreeWishes)
    public static Item ThreeWishes;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.TotalEclipse)
    public static Item TotalEclipse;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.TreasureTrove)
    public static Item TreasureTrove;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.TrueLightsFlight)
    public static Item TrueLightsFlight;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.TwilightBlaze)
    public static Item TwilightBlaze;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.TwoBecomeOne)
    public static Item TwoBecomeOne;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.UltimaWeaponKH1)
    public static Item UltimaWeaponKH1;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.UltimaWeaponKH2)
    public static Item UltimaWeaponKH2;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.UltimaWeaponBBS)
    public static Item UltimaWeaponBBS;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.UltimaWeaponDDD)
    public static Item UltimaWeaponDDD;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.Umbrella)
    public static Item Umbrella;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.Unbound)
    public static Item Unbound;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.UnicornisForetellersKeyblade)
    public static Item UnicornisForetellersKeyblade;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.UrsusForetellersKeyblade)
    public static Item UrsusForetellersKeyblade;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.VictoryLine)
    public static Item VictoryLine;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.VoidGear)
    public static Item VoidGear;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.VulpeusForetellersKeyblade)
    public static Item VulpeusForetellersKeyblade;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.WaytotheDawn)
    public static Item WaytotheDawn;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.WaywardWind)
    public static Item WaywardWind;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.WinnersProof)
    public static Item WinnersProof;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.WishingLamp)
    public static Item WishingLamp;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.WishingStar)
    public static Item WishingStar;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.WoodenKeyblade)
    public static Item WoodenKeyblade;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.WoodenStick)
    public static Item WoodenStick;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.YoungXehanortsKeyblade)
    public static Item YoungXehanortsKeyblade;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.ZeroOne)
    public static Item ZeroOne;

    // Chains
    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.Chain_AbaddonPlasma)
    public static Item Chain_AbaddonPlasma;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.Chain_AbyssalTide)
    public static Item Chain_AbyssalTide;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.Chain_AllforOne)
    public static Item Chain_AllforOne;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.Chain_AnguisForetellersKeyblade)
    public static Item Chain_AnguisForetellersKeyblade;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.Chain_AstralBlast)
    public static Item Chain_AstralBlast;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.Chain_Aubade)
    public static Item Chain_Aubade;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.Chain_BondofFlame)
    public static Item Chain_BondofFlame;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.Chain_Brightcrest)
    public static Item Chain_Brightcrest;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.Chain_ChaosRipper)
    public static Item Chain_ChaosRipper;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.Chain_CircleofLife)
    public static Item Chain_CircleofLife;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.Chain_Counterpoint)
    public static Item Chain_Counterpoint;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.Chain_Crabclaw)
    public static Item Chain_Crabclaw;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.Chain_CrownofGuilt)
    public static Item Chain_CrownofGuilt;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.Chain_DarkerThanDark)
    public static Item Chain_DarkerThanDark;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.Chain_Darkgnaw)
    public static Item Chain_Darkgnaw;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.Chain_DecisivePumpkin)
    public static Item Chain_DecisivePumpkin;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.Chain_DestinysEmbrace)
    public static Item Chain_DestinysEmbrace;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.Chain_DiamondDust)
    public static Item Chain_DiamondDust;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.Chain_Divewing)
    public static Item Chain_Divewing;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.Chain_DivineRose)
    public static Item Chain_DivineRose;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.Chain_DualDisc)
    public static Item Chain_DualDisc;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.Chain_Earthshaker)
    public static Item Chain_Earthshaker;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.Chain_EndofPain)
    public static Item Chain_EndofPain;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.Chain_EndsoftheEarth)
    public static Item Chain_EndsoftheEarth;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.Chain_FairyHarp)
    public static Item Chain_FairyHarp;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.Chain_FairyStars)
    public static Item Chain_FairyStars;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.Chain_FatalCrest)
    public static Item Chain_FatalCrest;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.Chain_Fenrir)
    public static Item Chain_Fenrir;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.Chain_FerrisGear)
    public static Item Chain_FerrisGear;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.Chain_FollowtheWind)
    public static Item Chain_FollowtheWind;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.Chain_FrolicFlame)
    public static Item Chain_FrolicFlame;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.Chain_GlimpseofDarkness)
    public static Item Chain_GlimpseofDarkness;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.Chain_GuardianBell)
    public static Item Chain_GuardianBell;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.Chain_GuardianSoul)
    public static Item Chain_GuardianSoul;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.Chain_GullWing)
    public static Item Chain_GullWing;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.Chain_HerosCrest)
    public static Item Chain_HerosCrest;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.Chain_HiddenDragon)
    public static Item Chain_HiddenDragon;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.Chain_Hyperdrive)
    public static Item Chain_Hyperdrive;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.Chain_IncompleteKiblade)
    public static Item Chain_IncompleteKiblade;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.Chain_JungleKing)
    public static Item Chain_JungleKing;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.Chain_KeybladeofPeoplesHearts)
    public static Item Chain_KeybladeofPeoplesHearts;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.Chain_Kiblade)
    public static Item Chain_Kiblade;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.Chain_KingdomKey)
    public static Item Chain_KingdomKey;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.Chain_KingdomKeyD)
    public static Item Chain_KingdomKeyD;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.Chain_KnockoutPunch)
    public static Item Chain_KnockoutPunch;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.Chain_LadyLuck)
    public static Item Chain_LadyLuck;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.Chain_LeasKeyblade)
    public static Item Chain_LeasKeyblade;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.Chain_LeopardosForetellersKeyblade)
    public static Item Chain_LeopardosForetellersKeyblade;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.Chain_Leviathan)
    public static Item Chain_Leviathan;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.Chain_Lionheart)
    public static Item Chain_Lionheart;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.Chain_LostMemory)
    public static Item Chain_LostMemory;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.Chain_LunarEclipse)
    public static Item Chain_LunarEclipse;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.Chain_MarkofaHero)
    public static Item Chain_MarkofaHero;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.Chain_MasterXehanortsKeyblade)
    public static Item Chain_MasterXehanortsKeyblade;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.Chain_MastersDefender)
    public static Item Chain_MastersDefender;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.Chain_MaverickFlare)
    public static Item Chain_MaverickFlare;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.Chain_MetalChocobo)
    public static Item Chain_MetalChocobo;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.Chain_MidnightRoar)
    public static Item Chain_MidnightRoar;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.Chain_MirageSplit)
    public static Item Chain_MirageSplit;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.Chain_MissingAche)
    public static Item Chain_MissingAche;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.Chain_Monochrome)
    public static Item Chain_Monochrome;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.Chain_MysteriousAbyss)
    public static Item Chain_MysteriousAbyss;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.Chain_NightmaresEnd)
    public static Item Chain_NightmaresEnd;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.Chain_NightmaresEndandMirageSplit)
    public static Item Chain_NightmaresEndandMirageSplit;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.Chain_NoName)
    public static Item Chain_NoName;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.Chain_Oathkeeper)
    public static Item Chain_Oathkeeper;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.Chain_Oblivion)
    public static Item Chain_Oblivion;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.Chain_OceansRage)
    public static Item Chain_OceansRage;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.Chain_Olympia)
    public static Item Chain_Olympia;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.Chain_OmegaWeapon)
    public static Item Chain_OmegaWeapon;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.Chain_OminousBlight)
    public static Item Chain_OminousBlight;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.Chain_OneWingedAngel)
    public static Item Chain_OneWingedAngel;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.Chain_PainofSolitude)
    public static Item Chain_PainofSolitude;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.Chain_PhotonDebugger)
    public static Item Chain_PhotonDebugger;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.Chain_PixiePetal)
    public static Item Chain_PixiePetal;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.Chain_Pumpkinhead)
    public static Item Chain_Pumpkinhead;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.Chain_Rainfell)
    public static Item Chain_Rainfell;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.Chain_RejectionofFate)
    public static Item Chain_RejectionofFate;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.Chain_RoyalRadiance)
    public static Item Chain_RoyalRadiance;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.Chain_RumblingRose)
    public static Item Chain_RumblingRose;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.Chain_SignofInnocence)
    public static Item Chain_SignofInnocence;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.Chain_SilentDirge)
    public static Item Chain_SilentDirge;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.Chain_SkullNoise)
    public static Item Chain_SkullNoise;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.Chain_SleepingLion)
    public static Item Chain_SleepingLion;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.Chain_SoulEater)
    public static Item Chain_SoulEater;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.Chain_Spellbinder)
    public static Item Chain_Spellbinder;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.Chain_StarSeeker)
    public static Item Chain_StarSeeker;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.Chain_Starlight)
    public static Item Chain_Starlight;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.Chain_Stormfall)
    public static Item Chain_Stormfall;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.Chain_StrokeofMidnight)
    public static Item Chain_StrokeofMidnight;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.Chain_SweetDreams)
    public static Item Chain_SweetDreams;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.Chain_SweetMemories)
    public static Item Chain_SweetMemories;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.Chain_Sweetstack)
    public static Item Chain_Sweetstack;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.Chain_ThreeWishes)
    public static Item Chain_ThreeWishes;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.Chain_TotalEclipse)
    public static Item Chain_TotalEclipse;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.Chain_TreasureTrove)
    public static Item Chain_TreasureTrove;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.Chain_TrueLightsFlight)
    public static Item Chain_TrueLightsFlight;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.Chain_TwilightBlaze)
    public static Item Chain_TwilightBlaze;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.Chain_TwoBecomeOne)
    public static Item Chain_TwoBecomeOne;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.Chain_UltimaWeaponKH1)
    public static Item Chain_UltimaWeaponKH1;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.Chain_UltimaWeaponKH2)
    public static Item Chain_UltimaWeaponKH2;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.Chain_UltimaWeaponBBS)
    public static Item Chain_UltimaWeaponBBS;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.Chain_UltimaWeaponDDD)
    public static Item Chain_UltimaWeaponDDD;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.Chain_Umbrella)
    public static Item Chain_Umbrella;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.Chain_Unbound)
    public static Item Chain_Unbound;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.Chain_UnicornisForetellersKeyblade)
    public static Item Chain_UnicornisForetellersKeyblade;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.Chain_UrsusForetellersKeyblade)
    public static Item Chain_UrsusForetellersKeyblade;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.Chain_VictoryLine)
    public static Item Chain_VictoryLine;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.Chain_VoidGear)
    public static Item Chain_VoidGear;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.Chain_VulpeusForetellersKeyblade)
    public static Item Chain_VulpeusForetellersKeyblade;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.Chain_WaytotheDawn)
    public static Item Chain_WaytotheDawn;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.Chain_WaywardWind)
    public static Item Chain_WaywardWind;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.Chain_WinnersProof)
    public static Item Chain_WinnersProof;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.Chain_WishingLamp)
    public static Item Chain_WishingLamp;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.Chain_WishingStar)
    public static Item Chain_WishingStar;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.Chain_YoungXehanortsKeyblade)
    public static Item Chain_YoungXehanortsKeyblade;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.Chain_ZeroOne)
    public static Item Chain_ZeroOne;

    // Misc
    @GameRegistry.ObjectHolder(Reference.MODID + ":" + "gummiship")
    public static Item GummiShip;
    
    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.Panacea)
    public static Item Panacaea;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.DefenseBoost)
    public static Item DefenseBoost;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.MagicBoost)
    public static Item MagicBoost;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.PowerBoost)
    public static Item PowerBoost;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.DriveBoost)
    public static Item DriveBoost;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.DriveRecovery)
    public static Item DriveRecovery;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.HighDriveRecovery)
    public static Item HighDriveRecovery;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.Munny)
    public static Item Munny;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.EmptyBottle)
    public static Item EmptyBottle;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.Potion)
    public static Item Potion;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.HiPotion)
    public static Item HiPotion;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.MegaPotion)
    public static Item MegaPotion;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.Ether)
    public static Item Ether;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.MegaEther)
    public static Item MegaEther;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.Elixir)
    public static Item Elixir;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.Megalixir)
    public static Item Megalixir;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.HpOrb)
    public static Item HpOrb;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.DriveOrb)
    public static Item DriveOrb;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.MagicOrb)
    public static Item MagicOrb;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.Heart)
    public static Item Heart;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.DarkHeart)
    public static Item DarkHeart;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.PureHeart)
    public static Item PureHeart;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.KingdomHearts)
    public static Item KingdomHearts;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.DarkLeather)
    public static Item DarkLeather;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.SynthesisMaterial)
    public static Item SynthesisMaterial;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.Recipe)
    public static Item Recipe;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.IceCream)
    public static Item IceCream;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.WinnerStick)
    public static Item WinnerStick;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.LevelUpMagicFire)
    public static Item LevelUpMagicFire;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.LevelUpMagicBlizzard)
    public static Item LevelUpMagicBlizzard;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.LevelUpMagicThunder)
    public static Item LevelUpMagicThunder;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.LevelUpMagicCure)
    public static Item LevelUpMagicCure;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.LevelUpMagicAero)
    public static Item LevelUpMagicAero;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.LevelUpMagicStop)
    public static Item LevelUpMagicStop;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.LevelUpValor)
    public static Item LevelUpValor;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.LevelUpWisdom)
    public static Item LevelUpWisdom;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.LevelUpLimit)
    public static Item LevelUpLimit;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.LevelUpMaster)
    public static Item LevelUpMaster;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.LevelUpFinal)
    public static Item LevelUpFinal;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.SynthesisBagS)
    public static Item SynthesisBagS;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.SynthesisBagM)
    public static Item SynthesisBagM;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.SynthesisBagL)
    public static Item SynthesisBagL;

    // Music Discs
    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.Disc_Birth_by_Sleep_A_Link_to_the_Future)
    public static Item Disc_Birth_by_Sleep_A_Link_to_the_Future;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.Disc_Darkness_of_the_Unknown)
    public static Item Disc_Darkness_of_the_Unknown;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.Disc_Dearly_Beloved_Symphony_Version)
    public static Item Disc_Dearly_Beloved_Symphony_Version;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.Disc_Dream_Drop_Distance_The_Next_Awakening)
    public static Item Disc_Dream_Drop_Distance_The_Next_Awakening;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.Disc_Hikari_KINGDOM_Instrumental_Version)
    public static Item Disc_Hikari_KINGDOM_Instrumental_Version;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.Disc_L_Oscurita_Dell_Ignoto)
    public static Item Disc_L_Oscurita_Dell_Ignoto;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.Disc_Musique_pour_la_tristesse_de_Xion)
    public static Item Disc_Musique_pour_la_tristesse_de_Xion;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.Disc_No_More_Bugs_Bug_Version)
    public static Item Disc_No_More_Bugs_Bug_Version;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.Disc_Organization_XIII)
    public static Item Disc_Organization_XIII;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.Disc_Sanctuary)
    public static Item Disc_Sanctuary;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.Disc_Simple_And_Clean_PLANITb_Remix)
    public static Item Disc_Simple_And_Clean_PLANITb_Remix;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.Disc_Sinister_Sundown)
    public static Item Disc_Sinister_Sundown;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.Disc_The_13th_Anthology)
    public static Item Disc_The_13th_Anthology;

    // Armour
    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.OrganizationRobe_Helmet)
    public static Item OrganizationRobe_Helmet;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.OrganizationRobe_Chestplate)
    public static Item OrganizationRobe_Chestplate;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.OrganizationRobe_Leggings)
    public static Item OrganizationRobe_Leggings;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.OrganizationRobe_Boots)
    public static Item OrganizationRobe_Boots;
    
    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.Xemnas_Helmet)
    public static Item Xemnas_Helmet;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.Xemnas_Chestplate)
    public static Item Xemnas_Chestplate;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.Xemnas_Leggings)
    public static Item Xemnas_Leggings;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.Xemnas_Boots)
    public static Item Xemnas_Boots;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.Terra_Helmet)
    public static Item Terra_Helmet;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.Terra_Chestplate)
    public static Item Terra_Chestplate;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.Terra_Leggings)
    public static Item Terra_Leggings;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.Terra_Boots)
    public static Item Terra_Boots;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.Aqua_Helmet)
    public static Item Aqua_Helmet;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.Aqua_Chestplate)
    public static Item Aqua_Chestplate;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.Aqua_Leggings)
    public static Item Aqua_Leggings;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.Aqua_Boots)
    public static Item Aqua_Boots;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.Ventus_Helmet)
    public static Item Ventus_Helmet;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.Ventus_Chestplate)
    public static Item Ventus_Chestplate;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.Ventus_Leggings)
    public static Item Ventus_Leggings;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.Ventus_Boots)
    public static Item Ventus_Boots;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.Eraqus_Helmet)
    public static Item Eraqus_Helmet;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.Eraqus_Chestplate)
    public static Item Eraqus_Chestplate;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.Eraqus_Leggings)
    public static Item Eraqus_Leggings;

    @GameRegistry.ObjectHolder(Reference.MODID + ":" + Strings.Eraqus_Boots)
    public static Item Eraqus_Boots;

    // Armour material
    private static ArmorMaterial ORGANIZATIONROBE = EnumHelper.addArmorMaterial("ORGANIZATIONROBE", Reference.MODID + ":organizationrobe", -1, new int[] { 3, 4, 5, 4 }, 15, SoundEvents.ITEM_ARMOR_EQUIP_LEATHER, 5);
    private static ArmorMaterial XEMNASROBE = EnumHelper.addArmorMaterial("XEMNASROBE", Reference.MODID + ":xemnasrobe", -1, new int[] { 3, 4, 5, 4 }, 15, SoundEvents.ITEM_ARMOR_EQUIP_LEATHER, 5);

    private static ArmorMaterial TERRA = EnumHelper.addArmorMaterial("TERRA", Reference.MODID + ":terra", -1, new int[] { 4, 7, 8, 4 }, 15, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 4);
    private static ArmorMaterial AQUA = EnumHelper.addArmorMaterial("AQUA", Reference.MODID + ":aqua", -1, new int[] { 4, 7, 8, 4 }, 15, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 2);
    private static ArmorMaterial VENTUS = EnumHelper.addArmorMaterial("VENTUS", Reference.MODID + ":ventus", -1, new int[] { 4, 7, 8, 4 }, 15, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 3);
    private static ArmorMaterial ERAQUS = EnumHelper.addArmorMaterial("ERAQUS", Reference.MODID + ":eraqus", -1, new int[] { 4, 7, 8, 4 }, 15, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 5);

    public static ToolMaterial KEYCHAIN = EnumHelper.addToolMaterial("KEYCHAIN", 0, 1, 0, -4, 30);

    public static CreativeTabs tabKingdomKeys = new TabKingdomKeys(CreativeTabs.getNextID(), Strings.tabKingdomKeys);

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
            // Xemnas
            event.getRegistry().register(new ItemEtherealBlade(Strings.Malice, BalanceConfig.orgweapons.malice));
            event.getRegistry().register(new ItemEtherealBlade(Strings.Sanction, BalanceConfig.orgweapons.sanction));
            event.getRegistry().register(new ItemEtherealBlade(Strings.Overlord, BalanceConfig.orgweapons.overlord));
            event.getRegistry().register(new ItemEtherealBlade(Strings.Veneration, BalanceConfig.orgweapons.veneration));
            event.getRegistry().register(new ItemEtherealBlade(Strings.Autocracy, BalanceConfig.orgweapons.autocracy));
            event.getRegistry().register(new ItemEtherealBlade(Strings.Conquest, BalanceConfig.orgweapons.conquest));
            event.getRegistry().register(new ItemEtherealBlade(Strings.Terminus, BalanceConfig.orgweapons.terminus));
            event.getRegistry().register(new ItemEtherealBlade(Strings.Judgement, BalanceConfig.orgweapons.judment));
            event.getRegistry().register(new ItemEtherealBlade(Strings.Discipline, BalanceConfig.orgweapons.discipline));
            event.getRegistry().register(new ItemEtherealBlade(Strings.Aristocracy, BalanceConfig.orgweapons.aristocracy));
            event.getRegistry().register(new ItemEtherealBlade(Strings.Superiority, BalanceConfig.orgweapons.superiority));
            event.getRegistry().register(new ItemEtherealBlade(Strings.Aggression, BalanceConfig.orgweapons.aggression));
            event.getRegistry().register(new ItemEtherealBlade(Strings.Fury, BalanceConfig.orgweapons.fury));
            event.getRegistry().register(new ItemEtherealBlade(Strings.Despair, BalanceConfig.orgweapons.despair));
            event.getRegistry().register(new ItemEtherealBlade(Strings.Triumph, BalanceConfig.orgweapons.triumph));
            event.getRegistry().register(new ItemEtherealBlade(Strings.Ruination, BalanceConfig.orgweapons.ruination));
            event.getRegistry().register(new ItemEtherealBlade(Strings.Domination, BalanceConfig.orgweapons.domination));
            event.getRegistry().register(new ItemEtherealBlade(Strings.Annihilation, BalanceConfig.orgweapons.annihilation));
            event.getRegistry().register(new ItemEtherealBlade(Strings.Tyrant, BalanceConfig.orgweapons.tyrant));
            event.getRegistry().register(new ItemEtherealBlade(Strings.Magnificence, BalanceConfig.orgweapons.magnificence));
            event.getRegistry().register(new ItemEtherealBlade(Strings.Infinity, BalanceConfig.orgweapons.infinity));
            event.getRegistry().register(new ItemEtherealBlade(Strings.Interdiction, BalanceConfig.orgweapons.interdiction));
            event.getRegistry().register(new ItemEtherealBlade(Strings.RoundFan, BalanceConfig.orgweapons.roundfan));
            event.getRegistry().register(new ItemEtherealBlade(Strings.Absolute, BalanceConfig.orgweapons.absolute));

            // Xigbar
            event.getRegistry().register(new ItemArrowguns(Strings.Standalone, BalanceConfig.orgweapons.standalone));
            event.getRegistry().register(new ItemArrowguns(Strings.Killerbee, BalanceConfig.orgweapons.killerbee));
            event.getRegistry().register(new ItemArrowguns(Strings.Stingray, BalanceConfig.orgweapons.stingray));
            event.getRegistry().register(new ItemArrowguns(Strings.Counterweight, BalanceConfig.orgweapons.counterweight));
            event.getRegistry().register(new ItemArrowguns(Strings.Precision, BalanceConfig.orgweapons.precision));
            event.getRegistry().register(new ItemArrowguns(Strings.DualHead, BalanceConfig.orgweapons.dualhead));
            event.getRegistry().register(new ItemArrowguns(Strings.Bahamut, BalanceConfig.orgweapons.bahamut));
            event.getRegistry().register(new ItemArrowguns(Strings.Gullwing, BalanceConfig.orgweapons.gullwing));
            event.getRegistry().register(new ItemArrowguns(Strings.BlueFrame, BalanceConfig.orgweapons.blueframe));
            event.getRegistry().register(new ItemArrowguns(Strings.StarShell, BalanceConfig.orgweapons.starshell));
            event.getRegistry().register(new ItemArrowguns(Strings.Sunrise, BalanceConfig.orgweapons.sunrise));
            event.getRegistry().register(new ItemArrowguns(Strings.Ignition, BalanceConfig.orgweapons.ignition));
            event.getRegistry().register(new ItemArrowguns(Strings.Armstrong, BalanceConfig.orgweapons.armstrong));
            event.getRegistry().register(new ItemArrowguns(Strings.HardBoiledHeat, BalanceConfig.orgweapons.hardboiledheat));
            event.getRegistry().register(new ItemArrowguns(Strings.DiabloEye, BalanceConfig.orgweapons.diabloeye));
            event.getRegistry().register(new ItemArrowguns(Strings.DoubleTap, BalanceConfig.orgweapons.doubletrap));
            event.getRegistry().register(new ItemArrowguns(Strings.Stardust, BalanceConfig.orgweapons.stardust));
            event.getRegistry().register(new ItemArrowguns(Strings.EnergyMuzzle, BalanceConfig.orgweapons.energymuzzle));
            event.getRegistry().register(new ItemArrowguns(Strings.CrimeAndPunishment, BalanceConfig.orgweapons.crimeandpunishment));
            event.getRegistry().register(new ItemArrowguns(Strings.CupidsArrow, BalanceConfig.orgweapons.cupidsarrow));
            event.getRegistry().register(new ItemArrowguns(Strings.FinalWeapon, BalanceConfig.orgweapons.finalweapon));
            event.getRegistry().register(new ItemArrowguns(Strings.Sharpshooter, BalanceConfig.orgweapons.sharpshooter));
            event.getRegistry().register(new ItemArrowguns(Strings.Dryer, BalanceConfig.orgweapons.dryer));
            event.getRegistry().register(new ItemArrowguns(Strings.Trumpet, BalanceConfig.orgweapons.trumpet));

            // Xaldin
            event.getRegistry().register(new ItemLances(Strings.Zephyr, BalanceConfig.orgweapons.zephyr));
            event.getRegistry().register(new ItemLances(Strings.Moonglade, BalanceConfig.orgweapons.moonglade));
            event.getRegistry().register(new ItemLances(Strings.Aer, BalanceConfig.orgweapons.aer));
            event.getRegistry().register(new ItemLances(Strings.Nescience, BalanceConfig.orgweapons.nescience));
            event.getRegistry().register(new ItemLances(Strings.Brume, BalanceConfig.orgweapons.brume));
            event.getRegistry().register(new ItemLances(Strings.Asura, BalanceConfig.orgweapons.asura));
            event.getRegistry().register(new ItemLances(Strings.Crux, BalanceConfig.orgweapons.crux));
            event.getRegistry().register(new ItemLances(Strings.Paladin, BalanceConfig.orgweapons.paladin));
            event.getRegistry().register(new ItemLances(Strings.Fellking, BalanceConfig.orgweapons.fellking));
            event.getRegistry().register(new ItemLances(Strings.Nightcloud, BalanceConfig.orgweapons.nightcloud));
            event.getRegistry().register(new ItemLances(Strings.Shimmer, BalanceConfig.orgweapons.shimmer));
            event.getRegistry().register(new ItemLances(Strings.Vortex, BalanceConfig.orgweapons.vortex));
            event.getRegistry().register(new ItemLances(Strings.Scission, BalanceConfig.orgweapons.scission));
            event.getRegistry().register(new ItemLances(Strings.Heavenfall, BalanceConfig.orgweapons.heavenfall));
            event.getRegistry().register(new ItemLances(Strings.Aether, BalanceConfig.orgweapons.aether));
            event.getRegistry().register(new ItemLances(Strings.Mazzaroth, BalanceConfig.orgweapons.mazzaroth));
            event.getRegistry().register(new ItemLances(Strings.Hegemon, BalanceConfig.orgweapons.hegemon));
            event.getRegistry().register(new ItemLances(Strings.Foxfire, BalanceConfig.orgweapons.foxfire));
            event.getRegistry().register(new ItemLances(Strings.Yaksha, BalanceConfig.orgweapons.yaksha));
            event.getRegistry().register(new ItemLances(Strings.Cynosura, BalanceConfig.orgweapons.cynosura));
            event.getRegistry().register(new ItemLances(Strings.Dragonreign, BalanceConfig.orgweapons.dragonreign));
            event.getRegistry().register(new ItemLances(Strings.Lindworm, BalanceConfig.orgweapons.lindworm));
            event.getRegistry().register(new ItemLances(Strings.Broom, BalanceConfig.orgweapons.broom));
            event.getRegistry().register(new ItemLances(Strings.Wyvern, BalanceConfig.orgweapons.wyvern));

            // Vexen
            event.getRegistry().register(new ItemOrgShield(Strings.TesterZero));
            event.getRegistry().register(new ItemOrgShield(Strings.ProductOne));
            event.getRegistry().register(new ItemOrgShield(Strings.DeepFreeze));
            event.getRegistry().register(new ItemOrgShield(Strings.CryoliteShield));
            event.getRegistry().register(new ItemOrgShield(Strings.FalseTheory));
            event.getRegistry().register(new ItemOrgShield(Strings.Glacier));
            event.getRegistry().register(new ItemOrgShield(Strings.AbsoluteZero));
            event.getRegistry().register(new ItemOrgShield(Strings.Gunz));
            event.getRegistry().register(new ItemOrgShield(Strings.Mindel));
            event.getRegistry().register(new ItemOrgShield(Strings.Snowslide));
            event.getRegistry().register(new ItemOrgShield(Strings.Iceberg));
            event.getRegistry().register(new ItemOrgShield(Strings.Inquisition));
            event.getRegistry().register(new ItemOrgShield(Strings.Scrutiny));
            event.getRegistry().register(new ItemOrgShield(Strings.Empiricism));
            event.getRegistry().register(new ItemOrgShield(Strings.Edification));
            event.getRegistry().register(new ItemOrgShield(Strings.Contrivance));
            event.getRegistry().register(new ItemOrgShield(Strings.Wurm));
            event.getRegistry().register(new ItemOrgShield(Strings.Subzero));
            event.getRegistry().register(new ItemOrgShield(Strings.ColdBlood));
            event.getRegistry().register(new ItemOrgShield(Strings.DiamondShield));
            event.getRegistry().register(new ItemOrgShield(Strings.Aegis));
            event.getRegistry().register(new ItemOrgShield(Strings.FrozenPride));
            event.getRegistry().register(new ItemOrgShield(Strings.PotLid));
            event.getRegistry().register(new ItemOrgShield(Strings.Snowman));

            // Lexaeus
            event.getRegistry().register(new ItemAxeSword(Strings.Reticence, BalanceConfig.orgweapons.reticence));
            event.getRegistry().register(new ItemAxeSword(Strings.Goliath, BalanceConfig.orgweapons.goliath));
            event.getRegistry().register(new ItemAxeSword(Strings.CopperRed, BalanceConfig.orgweapons.copperred));
            event.getRegistry().register(new ItemAxeSword(Strings.Daybreak, BalanceConfig.orgweapons.daybreak));
            event.getRegistry().register(new ItemAxeSword(Strings.Colossus, BalanceConfig.orgweapons.colossus));
            event.getRegistry().register(new ItemAxeSword(Strings.UrsaMajor, BalanceConfig.orgweapons.ursamajor));
            event.getRegistry().register(new ItemAxeSword(Strings.Megacosm, BalanceConfig.orgweapons.megacosm));
            event.getRegistry().register(new ItemAxeSword(Strings.Terrene, BalanceConfig.orgweapons.terrene));
            event.getRegistry().register(new ItemAxeSword(Strings.Fuligin, BalanceConfig.orgweapons.fuligin));
            event.getRegistry().register(new ItemAxeSword(Strings.HardWinter, BalanceConfig.orgweapons.hardwinter));
            event.getRegistry().register(new ItemAxeSword(Strings.Firefly, BalanceConfig.orgweapons.firefly));
            event.getRegistry().register(new ItemAxeSword(Strings.Harbinger, BalanceConfig.orgweapons.harbinger));
            event.getRegistry().register(new ItemAxeSword(Strings.Redwood, BalanceConfig.orgweapons.redwood));
            event.getRegistry().register(new ItemAxeSword(Strings.Sequoia, BalanceConfig.orgweapons.sequoia));
            event.getRegistry().register(new ItemAxeSword(Strings.IronBlack, BalanceConfig.orgweapons.ironblack));
            event.getRegistry().register(new ItemAxeSword(Strings.Earthshine, BalanceConfig.orgweapons.earthshine));
            event.getRegistry().register(new ItemAxeSword(Strings.Octiron, BalanceConfig.orgweapons.octiron));
            event.getRegistry().register(new ItemAxeSword(Strings.Hyperion, BalanceConfig.orgweapons.hyperion));
            event.getRegistry().register(new ItemAxeSword(Strings.Clarity ,BalanceConfig.orgweapons.clarity));
            event.getRegistry().register(new ItemAxeSword(Strings.OneThousandAndOneNights, BalanceConfig.orgweapons.onethousandandonenights));
            event.getRegistry().register(new ItemAxeSword(Strings.CardinalVirtue, BalanceConfig.orgweapons.cardinalvirtue));
            event.getRegistry().register(new ItemAxeSword(Strings.Skysplitter, BalanceConfig.orgweapons.skysplitter));
            event.getRegistry().register(new ItemAxeSword(Strings.BleepBloopBop, BalanceConfig.orgweapons.bleepbloopbop));
            event.getRegistry().register(new ItemAxeSword(Strings.Monolith, BalanceConfig.orgweapons.monolith));

            // Zexion
            event.getRegistry().register(new ItemLexicon(Strings.BlackPrimer, BalanceConfig.orgweapons.blackprimer));
            event.getRegistry().register(new ItemLexicon(Strings.WhiteTome, BalanceConfig.orgweapons.whitetome));
            event.getRegistry().register(new ItemLexicon(Strings.IllicitResearch, BalanceConfig.orgweapons.illicitresearch));
            event.getRegistry().register(new ItemLexicon(Strings.BuriedSecrets, BalanceConfig.orgweapons.buriedsecrets));
            event.getRegistry().register(new ItemLexicon(Strings.ArcaneCompendium, BalanceConfig.orgweapons.arcanecompendium));
            event.getRegistry().register(new ItemLexicon(Strings.DissentersNotes, BalanceConfig.orgweapons.dissentersnotes));
            event.getRegistry().register(new ItemLexicon(Strings.NefariousCodex, BalanceConfig.orgweapons.nefariouscodex));
            event.getRegistry().register(new ItemLexicon(Strings.MysticAlbum, BalanceConfig.orgweapons.mysticalbum));
            event.getRegistry().register(new ItemLexicon(Strings.CursedManual, BalanceConfig.orgweapons.cursedmanual));
            event.getRegistry().register(new ItemLexicon(Strings.TabooText, BalanceConfig.orgweapons.tabootext));
            event.getRegistry().register(new ItemLexicon(Strings.EldritchEsoterica, BalanceConfig.orgweapons.eldritchesoterica));
            event.getRegistry().register(new ItemLexicon(Strings.FreakishBestiary, BalanceConfig.orgweapons.freakishbestiary));
            event.getRegistry().register(new ItemLexicon(Strings.MadmansVita, BalanceConfig.orgweapons.madmansvita));
            event.getRegistry().register(new ItemLexicon(Strings.UntitledWritings, BalanceConfig.orgweapons.untitledwritings));
            event.getRegistry().register(new ItemLexicon(Strings.AbandonedDogma, BalanceConfig.orgweapons.abandoneddogma));
            event.getRegistry().register(new ItemLexicon(Strings.AtlasOfOmens, BalanceConfig.orgweapons.atlasofomens));
            event.getRegistry().register(new ItemLexicon(Strings.RevoltingScrapbook, BalanceConfig.orgweapons.revoltingscrapbook));
            event.getRegistry().register(new ItemLexicon(Strings.LostHeterodoxy, BalanceConfig.orgweapons.lostheterodoxy));
            event.getRegistry().register(new ItemLexicon(Strings.OtherworldlyTales, BalanceConfig.orgweapons.otherworldlytales));
            event.getRegistry().register(new ItemLexicon(Strings.IndescribableLore, BalanceConfig.orgweapons.indescribablelore));
            event.getRegistry().register(new ItemLexicon(Strings.RadicalTreatise, BalanceConfig.orgweapons.radicaltreatise));
            event.getRegistry().register(new ItemLexicon(Strings.BookofRetribution, BalanceConfig.orgweapons.bookofretribution));
            event.getRegistry().register(new ItemLexicon(Strings.MidnightSnack, BalanceConfig.orgweapons.midnightsnack));
            event.getRegistry().register(new ItemLexicon(Strings.DearDiary, BalanceConfig.orgweapons.deardiary));

            // Saix
            event.getRegistry().register(new ItemClaymore(Strings.NewMoon, BalanceConfig.orgweapons.newmoon));
            event.getRegistry().register(new ItemClaymore(Strings.Werewolf, BalanceConfig.orgweapons.werewolf));
            event.getRegistry().register(new ItemClaymore(Strings.Artemis, BalanceConfig.orgweapons.artemis));
            event.getRegistry().register(new ItemClaymore(Strings.Luminary, BalanceConfig.orgweapons.luminary));
            event.getRegistry().register(new ItemClaymore(Strings.Selene, BalanceConfig.orgweapons.selene));
            event.getRegistry().register(new ItemClaymore(Strings.Moonrise, BalanceConfig.orgweapons.moonrise));
            event.getRegistry().register(new ItemClaymore(Strings.Astrologia, BalanceConfig.orgweapons.astrologia));
            event.getRegistry().register(new ItemClaymore(Strings.Crater, BalanceConfig.orgweapons.crater));
            event.getRegistry().register(new ItemClaymore(Strings.LunarPhase, BalanceConfig.orgweapons.lunarphase));
            event.getRegistry().register(new ItemClaymore(Strings.Crescent, BalanceConfig.orgweapons.crescent));
            event.getRegistry().register(new ItemClaymore(Strings.Gibbous, BalanceConfig.orgweapons.gibbous));
            event.getRegistry().register(new ItemClaymore(Strings.Berserker, BalanceConfig.orgweapons.berseker));
            event.getRegistry().register(new ItemClaymore(Strings.Twilight, BalanceConfig.orgweapons.twilight));
            event.getRegistry().register(new ItemClaymore(Strings.QueenOfTheNight, BalanceConfig.orgweapons.queenofthenight));
            event.getRegistry().register(new ItemClaymore(Strings.BalsamicMoon, BalanceConfig.orgweapons.balsamicmoon));
            event.getRegistry().register(new ItemClaymore(Strings.Orbit, BalanceConfig.orgweapons.orbit));
            event.getRegistry().register(new ItemClaymore(Strings.LightYear, BalanceConfig.orgweapons.lightyear));
            event.getRegistry().register(new ItemClaymore(Strings.KingOfTheNight, BalanceConfig.orgweapons.kingofthenight));
            event.getRegistry().register(new ItemClaymore(Strings.Moonset, BalanceConfig.orgweapons.moonset));
            event.getRegistry().register(new ItemClaymore(Strings.Horoscope, BalanceConfig.orgweapons.horoscope));
            event.getRegistry().register(new ItemClaymore(Strings.Dichotomy, BalanceConfig.orgweapons.dichotomy));
            event.getRegistry().register(new ItemClaymore(Strings.Lunatic, BalanceConfig.orgweapons.lunatic));
            event.getRegistry().register(new ItemClaymore(Strings.JustDesserts, BalanceConfig.orgweapons.justdesserts));
            event.getRegistry().register(new ItemClaymore(Strings.Bunnymoon, BalanceConfig.orgweapons.bunnymoon));

            // Axel
            event.getRegistry().register(new ItemChakram(Strings.Ashes, BalanceConfig.orgweapons.ashes));
            event.getRegistry().register(new ItemChakram(Strings.Doldrums, BalanceConfig.orgweapons.doldrums));
            event.getRegistry().register(new ItemChakram(Strings.DelayedAction, BalanceConfig.orgweapons.delayedaction));
            event.getRegistry().register(new ItemChakram(Strings.DiveBombers, BalanceConfig.orgweapons.divebombers));
            event.getRegistry().register(new ItemChakram(Strings.Combustion, BalanceConfig.orgweapons.combustion));
            event.getRegistry().register(new ItemChakram(Strings.MoulinRouge, BalanceConfig.orgweapons.moulinrouge));
            event.getRegistry().register(new ItemChakram(Strings.BlazeofGlory, BalanceConfig.orgweapons.blazeofglory));
            event.getRegistry().register(new ItemChakram(Strings.Prometheus, BalanceConfig.orgweapons.prometheus));
            event.getRegistry().register(new ItemChakram(Strings.Ifrit, BalanceConfig.orgweapons.ifrit));
            event.getRegistry().register(new ItemChakram(Strings.MagmaOcean, BalanceConfig.orgweapons.magmaocean));
            event.getRegistry().register(new ItemChakram(Strings.Volcanics, BalanceConfig.orgweapons.volcanics));
            event.getRegistry().register(new ItemChakram(Strings.Inferno, BalanceConfig.orgweapons.inferno));
            event.getRegistry().register(new ItemChakram(Strings.SizzlingEdge, BalanceConfig.orgweapons.sizzlingedge));
            event.getRegistry().register(new ItemChakram(Strings.Corona, BalanceConfig.orgweapons.corona));
            event.getRegistry().register(new ItemChakram(Strings.FerrisWheel, BalanceConfig.orgweapons.ferriswheel));
            event.getRegistry().register(new ItemChakram(Strings.Burnout, BalanceConfig.orgweapons.burnout));
            event.getRegistry().register(new ItemChakram(Strings.OmegaTrinity, BalanceConfig.orgweapons.omegatrinity));
            event.getRegistry().register(new ItemChakram(Strings.Outbreak, BalanceConfig.orgweapons.outbreak));
            event.getRegistry().register(new ItemChakram(Strings.DoubleEdge, BalanceConfig.orgweapons.doubleedge));
            event.getRegistry().register(new ItemChakram(Strings.Wildfire,BalanceConfig.orgweapons.wildfire));
            event.getRegistry().register(new ItemChakram(Strings.Prominence, BalanceConfig.orgweapons.prominence));
            event.getRegistry().register(new ItemChakram(Strings.EternalFlames, BalanceConfig.orgweapons.eternalflames));
            event.getRegistry().register(new ItemChakram(Strings.PizzaCut, BalanceConfig.orgweapons.pizzacut));
            event.getRegistry().register(new ItemChakram(Strings.Conformers, BalanceConfig.orgweapons.conformers));

            // Demyx
            event.getRegistry().register(new ItemSitar(Strings.BasicModel, BalanceConfig.orgweapons.basicmodel));
            event.getRegistry().register(new ItemSitar(Strings.TuneUp, BalanceConfig.orgweapons.tuneup));
            event.getRegistry().register(new ItemSitar(Strings.Quartet, BalanceConfig.orgweapons.quartet));
            event.getRegistry().register(new ItemSitar(Strings.Quintet, BalanceConfig.orgweapons.quintet));
            event.getRegistry().register(new ItemSitar(Strings.Overture, BalanceConfig.orgweapons.overture));
            event.getRegistry().register(new ItemSitar(Strings.OldHand, BalanceConfig.orgweapons.oldhand));
            event.getRegistry().register(new ItemSitar(Strings.DaCapo, BalanceConfig.orgweapons.dacapo));
            event.getRegistry().register(new ItemSitar(Strings.PowerChord, BalanceConfig.orgweapons.powerchord));
            event.getRegistry().register(new ItemSitar(Strings.Fermata, BalanceConfig.orgweapons.fermata));
            event.getRegistry().register(new ItemSitar(Strings.Interlude, BalanceConfig.orgweapons.interlude));
            event.getRegistry().register(new ItemSitar(Strings.Serenade, BalanceConfig.orgweapons.serenade));
            event.getRegistry().register(new ItemSitar(Strings.Songbird, BalanceConfig.orgweapons.songbird));
            event.getRegistry().register(new ItemSitar(Strings.RiseToFame, BalanceConfig.orgweapons.risetofame));
            event.getRegistry().register(new ItemSitar(Strings.RockStar, BalanceConfig.orgweapons.rockstar));
            event.getRegistry().register(new ItemSitar(Strings.EightFinger, BalanceConfig.orgweapons.eightfinger));
            event.getRegistry().register(new ItemSitar(Strings.Concerto, BalanceConfig.orgweapons.concierto));
            event.getRegistry().register(new ItemSitar(Strings.Harmonics, BalanceConfig.orgweapons.harmonics));
            event.getRegistry().register(new ItemSitar(Strings.MillionBucks, BalanceConfig.orgweapons.millionbucks));
            event.getRegistry().register(new ItemSitar(Strings.Fortissimo, BalanceConfig.orgweapons.fortissimo));
            event.getRegistry().register(new ItemSitar(Strings.UpToEleven, BalanceConfig.orgweapons.uptoeleven));
            event.getRegistry().register(new ItemSitar(Strings.Sanctuary, BalanceConfig.orgweapons.sanctuary));
            event.getRegistry().register(new ItemSitar(Strings.Arpeggio, BalanceConfig.orgweapons.arpeggio));
            event.getRegistry().register(new ItemSitar(Strings.PrinceOfAwesome, BalanceConfig.orgweapons.princeofawesome));
            event.getRegistry().register(new ItemSitar(Strings.AfterSchool, BalanceConfig.orgweapons.afterschool));

            // Luxord
            event.getRegistry().register(new ItemCard(Strings.TheFool, BalanceConfig.orgweapons.thefool));
            event.getRegistry().register(new ItemCard(Strings.TheMagician, BalanceConfig.orgweapons.themagician));
            event.getRegistry().register(new ItemCard(Strings.TheStar, BalanceConfig.orgweapons.thestar));
            event.getRegistry().register(new ItemCard(Strings.TheMoon, BalanceConfig.orgweapons.themoon));
            event.getRegistry().register(new ItemCard(Strings.Justice, BalanceConfig.orgweapons.justice));
            event.getRegistry().register(new ItemCard(Strings.TheHierophant, BalanceConfig.orgweapons.thehierophant));
            event.getRegistry().register(new ItemCard(Strings.TheWorld, BalanceConfig.orgweapons.theworld));
            event.getRegistry().register(new ItemCard(Strings.Temperance, BalanceConfig.orgweapons.temperance));
            event.getRegistry().register(new ItemCard(Strings.TheHighPriestess, BalanceConfig.orgweapons.thehighpriestess));
            event.getRegistry().register(new ItemCard(Strings.TheTower, BalanceConfig.orgweapons.thetower));
            event.getRegistry().register(new ItemCard(Strings.TheHangedMan, BalanceConfig.orgweapons.thehangedman));
            event.getRegistry().register(new ItemCard(Strings.Death, BalanceConfig.orgweapons.death));
            event.getRegistry().register(new ItemCard(Strings.TheHermit, BalanceConfig.orgweapons.thehermit));
            event.getRegistry().register(new ItemCard(Strings.Strength, BalanceConfig.orgweapons.strength));
            event.getRegistry().register(new ItemCard(Strings.TheLovers, BalanceConfig.orgweapons.thelovers));
            event.getRegistry().register(new ItemCard(Strings.TheChariot, BalanceConfig.orgweapons.thechariot));
            event.getRegistry().register(new ItemCard(Strings.TheSun, BalanceConfig.orgweapons.thesun));
            event.getRegistry().register(new ItemCard(Strings.TheDevil, BalanceConfig.orgweapons.themoon));
            event.getRegistry().register(new ItemCard(Strings.TheEmpress, BalanceConfig.orgweapons.theempress));
            event.getRegistry().register(new ItemCard(Strings.TheEmperor, BalanceConfig.orgweapons.theemperor));
            event.getRegistry().register(new ItemCard(Strings.TheJoker, BalanceConfig.orgweapons.thejoker   ));
            event.getRegistry().register(new ItemCard(Strings.FairGame, BalanceConfig.orgweapons.fairgame));
            event.getRegistry().register(new ItemCard(Strings.FinestFantasy13, BalanceConfig.orgweapons.finestfantasy13));
            event.getRegistry().register(new ItemCard(Strings.HighRollersSecret, BalanceConfig.orgweapons.highrollerssecret));

            // Marluxia
            event.getRegistry().register(new ItemScythe(Strings.FickleErica, BalanceConfig.orgweapons.fickleerica));                   
            event.getRegistry().register(new ItemScythe(Strings.JiltedAnemone, BalanceConfig.orgweapons.jiltedanemone));               
            event.getRegistry().register(new ItemScythe(Strings.ProudAmaryllis, BalanceConfig.orgweapons.proudamaryllis));             
            event.getRegistry().register(new ItemScythe(Strings.MadSafflower, BalanceConfig.orgweapons.madsafflower));                 
            event.getRegistry().register(new ItemScythe(Strings.PoorMelissa, BalanceConfig.orgweapons.poormelissa));                   
            event.getRegistry().register(new ItemScythe(Strings.TragicAllium, BalanceConfig.orgweapons.tragicallium));                 
            event.getRegistry().register(new ItemScythe(Strings.MournfulCineria, BalanceConfig.orgweapons.mournfulcineria));           
            event.getRegistry().register(new ItemScythe(Strings.PseudoSilene, BalanceConfig.orgweapons.pseudosilene));                 
            event.getRegistry().register(new ItemScythe(Strings.FaithlessDigitalis, BalanceConfig.orgweapons.faithlessdigitalis));     
            event.getRegistry().register(new ItemScythe(Strings.GrimMuscari, BalanceConfig.orgweapons.grimmuscari));                   
            event.getRegistry().register(new ItemScythe(Strings.DocileVallota, BalanceConfig.orgweapons.docilevallota));               
            event.getRegistry().register(new ItemScythe(Strings.QuietBelladonna, BalanceConfig.orgweapons.quietbelladonna));           
            event.getRegistry().register(new ItemScythe(Strings.PartingIpheion, BalanceConfig.orgweapons.partingipheion));             
            event.getRegistry().register(new ItemScythe(Strings.LoftyGerbera, BalanceConfig.orgweapons.loftygerbera));                 
            event.getRegistry().register(new ItemScythe(Strings.GallantAchillea, BalanceConfig.orgweapons.gallantachillea));           
            event.getRegistry().register(new ItemScythe(Strings.NoblePeony, BalanceConfig.orgweapons.noblepeony));                     
            event.getRegistry().register(new ItemScythe(Strings.FearsomeAnise, BalanceConfig.orgweapons.faithlessdigitalis));          
            event.getRegistry().register(new ItemScythe(Strings.VindictiveThistle, BalanceConfig.orgweapons.vindictivethistle));       
            event.getRegistry().register(new ItemScythe(Strings.FairHelianthus, BalanceConfig.orgweapons.fairhelianthus));             
            event.getRegistry().register(new ItemScythe(Strings.SolemnMagnolia, BalanceConfig.orgweapons.solemnmagnolia));             
            event.getRegistry().register(new ItemScythe(Strings.HallowedLotus, BalanceConfig.orgweapons.hallowedlotus));               
            event.getRegistry().register(new ItemScythe(Strings.GracefulDahlia, BalanceConfig.orgweapons.gracefuldahlia));             
            event.getRegistry().register(new ItemScythe(Strings.StirringLadle, BalanceConfig.orgweapons.stirringladle));               
            event.getRegistry().register(new ItemScythe(Strings.DaintyBellflowers, BalanceConfig.orgweapons.daintybellflowers));       
                                                                                                                                       
            // Larxene
            event.getRegistry().register(new ItemKnife(Strings.Trancheuse, BalanceConfig.orgweapons.trancheuse));
            event.getRegistry().register(new ItemKnife(Strings.Orage, BalanceConfig.orgweapons.orage));
            event.getRegistry().register(new ItemKnife(Strings.Tourbillon, BalanceConfig.orgweapons.tourbillon));
            event.getRegistry().register(new ItemKnife(Strings.Tempete, BalanceConfig.orgweapons.tempete));
            event.getRegistry().register(new ItemKnife(Strings.Carmin, BalanceConfig.orgweapons.carmin));
            event.getRegistry().register(new ItemKnife(Strings.Meteore, BalanceConfig.orgweapons.meteore));
            event.getRegistry().register(new ItemKnife(Strings.Etoile, BalanceConfig.orgweapons.etoile));
            event.getRegistry().register(new ItemKnife(Strings.Irregulier, BalanceConfig.orgweapons.irregulier));
            event.getRegistry().register(new ItemKnife(Strings.Dissonance, BalanceConfig.orgweapons.dissonance));
            event.getRegistry().register(new ItemKnife(Strings.Eruption, BalanceConfig.orgweapons.eruption));
            event.getRegistry().register(new ItemKnife(Strings.SoleilCouchant, BalanceConfig.orgweapons.soleilcouchant));
            event.getRegistry().register(new ItemKnife(Strings.Indigo, BalanceConfig.orgweapons.indigo));
            event.getRegistry().register(new ItemKnife(Strings.Vague, BalanceConfig.orgweapons.vague));
            event.getRegistry().register(new ItemKnife(Strings.Deluge, BalanceConfig.orgweapons.deluge));
            event.getRegistry().register(new ItemKnife(Strings.Rafale, BalanceConfig.orgweapons.rafale));
            event.getRegistry().register(new ItemKnife(Strings.Typhon, BalanceConfig.orgweapons.typhon));
            event.getRegistry().register(new ItemKnife(Strings.Extirpeur, BalanceConfig.orgweapons.extirpeur));
            event.getRegistry().register(new ItemKnife(Strings.CroixDuSud, BalanceConfig.orgweapons.croixdusud));
            event.getRegistry().register(new ItemKnife(Strings.Lumineuse, BalanceConfig.orgweapons.lumineuse));
            event.getRegistry().register(new ItemKnife(Strings.ClairdeLune, BalanceConfig.orgweapons.clairdelune));
            event.getRegistry().register(new ItemKnife(Strings.VoldeNuit, BalanceConfig.orgweapons.voldenuit));
            event.getRegistry().register(new ItemKnife(Strings.Foudre, BalanceConfig.orgweapons.foudre));
            event.getRegistry().register(new ItemKnife(Strings.Demoiselle, BalanceConfig.orgweapons.demoiselle));
            event.getRegistry().register(new ItemKnife(Strings.Ampoule, BalanceConfig.orgweapons.ampoule));

            event.getRegistry().register(new ItemOrgShield(Strings.DreamShield));

            //keyblades
            event.getRegistry().register(new ItemRealKeyblade(Strings.AbaddonPlasma, BalanceConfig.keyblades.abaddonPlasma[0], BalanceConfig.keyblades.abaddonPlasma[1]));
            event.getRegistry().register(new ItemRealKeyblade(Strings.AbyssalTide, BalanceConfig.keyblades.abyssalTide[0], BalanceConfig.keyblades.abyssalTide[1]));
            event.getRegistry().register(new ItemRealKeyblade(Strings.AllforOne, BalanceConfig.keyblades.allForOne[0], BalanceConfig.keyblades.allForOne[1]));
            event.getRegistry().register(new ItemRealKeyblade(Strings.AnguisForetellersKeyblade, BalanceConfig.keyblades.anguisForetellersKeyblade[0], BalanceConfig.keyblades.anguisForetellersKeyblade[1]));
            event.getRegistry().register(new ItemRealKeyblade(Strings.AstralBlast, BalanceConfig.keyblades.astralBlast[0], BalanceConfig.keyblades.astralBlast[1]));
            event.getRegistry().register(new ItemRealKeyblade(Strings.Aubade, BalanceConfig.keyblades.aubade[0], BalanceConfig.keyblades.aubade[1]));
            event.getRegistry().register(new ItemRealKeyblade(Strings.BondofFlame, BalanceConfig.keyblades.bondofFlame[0], BalanceConfig.keyblades.bondofFlame[1]));
            event.getRegistry().register(new ItemRealKeyblade(Strings.Brightcrest, BalanceConfig.keyblades.brightcrest[0], BalanceConfig.keyblades.brightcrest[1]));
            event.getRegistry().register(new ItemRealKeyblade(Strings.ChaosRipper, BalanceConfig.keyblades.chaosRipper[0], BalanceConfig.keyblades.chaosRipper[1]));
            event.getRegistry().register(new ItemRealKeyblade(Strings.CircleofLife, BalanceConfig.keyblades.circleofLife[0], BalanceConfig.keyblades.circleofLife[1]));
            event.getRegistry().register(new ItemRealKeyblade(Strings.Counterpoint, BalanceConfig.keyblades.counterpoint[0], BalanceConfig.keyblades.counterpoint[1]));
            event.getRegistry().register(new ItemRealKeyblade(Strings.Crabclaw, BalanceConfig.keyblades.crabclaw[0], BalanceConfig.keyblades.crabclaw[1]));
            event.getRegistry().register(new ItemRealKeyblade(Strings.CrownofGuilt, BalanceConfig.keyblades.crownofGuilt[0], BalanceConfig.keyblades.crownofGuilt[1]));
            event.getRegistry().register(new ItemRealKeyblade(Strings.DarkerThanDark, BalanceConfig.keyblades.darkerthanDark[0], BalanceConfig.keyblades.darkerthanDark[1]));
            event.getRegistry().register(new ItemRealKeyblade(Strings.Darkgnaw, BalanceConfig.keyblades.darkgnaw[0], BalanceConfig.keyblades.darkgnaw[1]));
            event.getRegistry().register(new ItemRealKeyblade(Strings.DecisivePumpkin, BalanceConfig.keyblades.decisivePumpkin[0], BalanceConfig.keyblades.decisivePumpkin[1]));
            event.getRegistry().register(new ItemRealKeyblade(Strings.DestinysEmbrace, BalanceConfig.keyblades.destinysEmbrace[0], BalanceConfig.keyblades.destinysEmbrace[1]));
            event.getRegistry().register(new ItemRealKeyblade(Strings.DiamondDust, BalanceConfig.keyblades.diamondDust[0], BalanceConfig.keyblades.diamondDust[1]));
            event.getRegistry().register(new ItemRealKeyblade(Strings.Divewing, BalanceConfig.keyblades.divewing[0], BalanceConfig.keyblades.divewing[1]));
            event.getRegistry().register(new ItemRealKeyblade(Strings.DivineRose, BalanceConfig.keyblades.divineRose[0], BalanceConfig.keyblades.divineRose[1]));
            event.getRegistry().register(new ItemKeyblade(Strings.DreamStaff, BalanceConfig.keyblades.dreamStaff[0], BalanceConfig.keyblades.dreamStaff[1]));
            event.getRegistry().register(new ItemKeyblade(Strings.DreamSword, BalanceConfig.keyblades.dreamSword[0], BalanceConfig.keyblades.dreamSword[1]));
            event.getRegistry().register(new ItemRealKeyblade(Strings.DualDisc, BalanceConfig.keyblades.dualDisc[0], BalanceConfig.keyblades.dualDisc[1]));
            event.getRegistry().register(new ItemRealKeyblade(Strings.Earthshaker, BalanceConfig.keyblades.earthshaker[0], BalanceConfig.keyblades.earthshaker[1]));
            event.getRegistry().register(new ItemRealKeyblade(Strings.EndofPain, BalanceConfig.keyblades.endofPain[0], BalanceConfig.keyblades.endofPain[1]));
            event.getRegistry().register(new ItemRealKeyblade(Strings.EndsoftheEarth, BalanceConfig.keyblades.endsoftheEarth[0], BalanceConfig.keyblades.endsoftheEarth[1]));
            event.getRegistry().register(new ItemRealKeyblade(Strings.FairyHarp, BalanceConfig.keyblades.fairyHarp[0], BalanceConfig.keyblades.fairyHarp[1]));
            event.getRegistry().register(new ItemRealKeyblade(Strings.FairyStars, BalanceConfig.keyblades.fairyStars[0], BalanceConfig.keyblades.fairyStars[1]));
            event.getRegistry().register(new ItemRealKeyblade(Strings.FatalCrest, BalanceConfig.keyblades.fatalCrest[0], BalanceConfig.keyblades.fatalCrest[1]));
            event.getRegistry().register(new ItemRealKeyblade(Strings.Fenrir, BalanceConfig.keyblades.fenrir[0], BalanceConfig.keyblades.fenrir[1]));
            event.getRegistry().register(new ItemRealKeyblade(Strings.FerrisGear, BalanceConfig.keyblades.ferrisGear[0], BalanceConfig.keyblades.ferrisGear[1]));
            event.getRegistry().register(new ItemRealKeyblade(Strings.FollowtheWind, BalanceConfig.keyblades.followtheWind[0], BalanceConfig.keyblades.followtheWind[1]));
            event.getRegistry().register(new ItemRealKeyblade(Strings.FrolicFlame, BalanceConfig.keyblades.frolicFlame[0], BalanceConfig.keyblades.frolicFlame[1]));
            event.getRegistry().register(new ItemRealKeyblade(Strings.GlimpseofDarkness, BalanceConfig.keyblades.glimpseofDarkness[0], BalanceConfig.keyblades.glimpseofDarkness[1]));
            event.getRegistry().register(new ItemRealKeyblade(Strings.GuardianBell, BalanceConfig.keyblades.guardianBell[0], BalanceConfig.keyblades.guardianBell[1]));
            event.getRegistry().register(new ItemRealKeyblade(Strings.GuardianSoul, BalanceConfig.keyblades.guardianSoul[0], BalanceConfig.keyblades.guardianSoul[1]));
            event.getRegistry().register(new ItemRealKeyblade(Strings.GullWing, BalanceConfig.keyblades.gullWing[0], BalanceConfig.keyblades.gullWing[1]));
            event.getRegistry().register(new ItemRealKeyblade(Strings.HerosCrest, BalanceConfig.keyblades.herosCrest[0], BalanceConfig.keyblades.herosCrest[1]));
            event.getRegistry().register(new ItemRealKeyblade(Strings.HiddenDragon, BalanceConfig.keyblades.hiddenDragon[0], BalanceConfig.keyblades.hiddenDragon[1]));
            event.getRegistry().register(new ItemRealKeyblade(Strings.Hyperdrive, BalanceConfig.keyblades.hyperdrive[0], BalanceConfig.keyblades.hyperdrive[1]));
            event.getRegistry().register(new ItemRealKeyblade(Strings.IncompleteKiblade, BalanceConfig.keyblades.incompletexblade[0], BalanceConfig.keyblades.incompletexblade[1]));
            event.getRegistry().register(new ItemRealKeyblade(Strings.JungleKing, BalanceConfig.keyblades.jungleKing[0], BalanceConfig.keyblades.jungleKing[1]));
            event.getRegistry().register(new ItemRealKeyblade(Strings.KeybladeofPeoplesHearts, BalanceConfig.keyblades.keybladeofPeoplesHearts[0], BalanceConfig.keyblades.keybladeofPeoplesHearts[1]));
            event.getRegistry().register(new ItemRealKeyblade(Strings.Kiblade, BalanceConfig.keyblades.xblade[0], BalanceConfig.keyblades.xblade[1]));
            event.getRegistry().register(new ItemRealKeyblade(Strings.KingdomKey, BalanceConfig.keyblades.kingdomKey[0], BalanceConfig.keyblades.kingdomKey[1]));
            event.getRegistry().register(new ItemRealKeyblade(Strings.KingdomKeyD, BalanceConfig.keyblades.kingdomKeyD[0], BalanceConfig.keyblades.kingdomKeyD[1]));
            event.getRegistry().register(new ItemRealKeyblade(Strings.KnockoutPunch, BalanceConfig.keyblades.knockoutPunch[0], BalanceConfig.keyblades.knockoutPunch[1]));
            event.getRegistry().register(new ItemRealKeyblade(Strings.LadyLuck, BalanceConfig.keyblades.ladyLuck[0], BalanceConfig.keyblades.ladyLuck[1]));
            event.getRegistry().register(new ItemRealKeyblade(Strings.LeasKeyblade, BalanceConfig.keyblades.leasKeyblade[0], BalanceConfig.keyblades.leasKeyblade[1]));
            event.getRegistry().register(new ItemRealKeyblade(Strings.LeopardosForetellersKeyblade, BalanceConfig.keyblades.leopardosForetellersKeyblade[0], BalanceConfig.keyblades.leopardosForetellersKeyblade[1]));
            event.getRegistry().register(new ItemRealKeyblade(Strings.Leviathan, BalanceConfig.keyblades.leviathan[0], BalanceConfig.keyblades.leviathan[1]));
            event.getRegistry().register(new ItemRealKeyblade(Strings.Lionheart, BalanceConfig.keyblades.lionheart[0], BalanceConfig.keyblades.lionheart[1]));
            event.getRegistry().register(new ItemRealKeyblade(Strings.LostMemory, BalanceConfig.keyblades.lostMemory[0], BalanceConfig.keyblades.lostMemory[1]));
            event.getRegistry().register(new ItemRealKeyblade(Strings.LunarEclipse, BalanceConfig.keyblades.lunarEclipse[0], BalanceConfig.keyblades.lunarEclipse[1]));
            event.getRegistry().register(new ItemRealKeyblade(Strings.MarkofaHero, BalanceConfig.keyblades.markofaHero[0], BalanceConfig.keyblades.markofaHero[1]));
            event.getRegistry().register(new ItemRealKeyblade(Strings.MasterXehanortsKeyblade, BalanceConfig.keyblades.masterXehanortsKeyblade[0], BalanceConfig.keyblades.masterXehanortsKeyblade[1]));
            event.getRegistry().register(new ItemRealKeyblade(Strings.MastersDefender, BalanceConfig.keyblades.mastersDefender[0], BalanceConfig.keyblades.mastersDefender[1]));
            event.getRegistry().register(new ItemRealKeyblade(Strings.MaverickFlare, BalanceConfig.keyblades.maverickFlare[0], BalanceConfig.keyblades.maverickFlare[1]));
            event.getRegistry().register(new ItemRealKeyblade(Strings.MetalChocobo, BalanceConfig.keyblades.metalChocobo[0], BalanceConfig.keyblades.metalChocobo[1]));
            event.getRegistry().register(new ItemRealKeyblade(Strings.MidnightRoar, BalanceConfig.keyblades.midnightRoar[0], BalanceConfig.keyblades.midnightRoar[1]));
            event.getRegistry().register(new ItemRealKeyblade(Strings.MirageSplit, BalanceConfig.keyblades.mirageSplit[0], BalanceConfig.keyblades.mirageSplit[1]));
            event.getRegistry().register(new ItemRealKeyblade(Strings.MissingAche, BalanceConfig.keyblades.missingAche[0], BalanceConfig.keyblades.missingAche[1]));
            event.getRegistry().register(new ItemRealKeyblade(Strings.Monochrome, BalanceConfig.keyblades.monochrome[0], BalanceConfig.keyblades.monochrome[1]));
            event.getRegistry().register(new ItemRealKeyblade(Strings.MysteriousAbyss, BalanceConfig.keyblades.mysteriousAbyss[0], BalanceConfig.keyblades.mysteriousAbyss[1]));
            event.getRegistry().register(new ItemRealKeyblade(Strings.NightmaresEnd, BalanceConfig.keyblades.nightmaresEnd[0], BalanceConfig.keyblades.nightmaresEnd[1]));
            event.getRegistry().register(new ItemRealKeyblade(Strings.NightmaresEndandMirageSplit, BalanceConfig.keyblades.combinedKeyblade[0], BalanceConfig.keyblades.combinedKeyblade[1]));
            event.getRegistry().register(new ItemRealKeyblade(Strings.NoName, BalanceConfig.keyblades.noName[0], BalanceConfig.keyblades.noName[1]));
            event.getRegistry().register(new ItemRealKeyblade(Strings.Oathkeeper, BalanceConfig.keyblades.oathkeeper[0], BalanceConfig.keyblades.oathkeeper[1]));
            event.getRegistry().register(new ItemRealKeyblade(Strings.Oblivion, BalanceConfig.keyblades.oblivion[0], BalanceConfig.keyblades.oblivion[1]));
            event.getRegistry().register(new ItemRealKeyblade(Strings.OceansRage, BalanceConfig.keyblades.oceansRage[0], BalanceConfig.keyblades.oceansRage[1]));
            event.getRegistry().register(new ItemRealKeyblade(Strings.Olympia, BalanceConfig.keyblades.olympia[0], BalanceConfig.keyblades.olympia[1]));
            event.getRegistry().register(new ItemRealKeyblade(Strings.OmegaWeapon, BalanceConfig.keyblades.omegaWeapon[0], BalanceConfig.keyblades.omegaWeapon[1]));
            event.getRegistry().register(new ItemRealKeyblade(Strings.OminousBlight, BalanceConfig.keyblades.ominousBlight[0], BalanceConfig.keyblades.ominousBlight[1]));
            event.getRegistry().register(new ItemRealKeyblade(Strings.OneWingedAngel, BalanceConfig.keyblades.oneWingedAngel[0], BalanceConfig.keyblades.oneWingedAngel[1]));
            event.getRegistry().register(new ItemRealKeyblade(Strings.PainofSolitude, BalanceConfig.keyblades.painofSolitude[0], BalanceConfig.keyblades.painofSolitude[1]));
            event.getRegistry().register(new ItemRealKeyblade(Strings.PhotonDebugger, BalanceConfig.keyblades.photonDebugger[0], BalanceConfig.keyblades.photonDebugger[1]));
            event.getRegistry().register(new ItemRealKeyblade(Strings.PixiePetal, BalanceConfig.keyblades.pixiePetal[0], BalanceConfig.keyblades.pixiePetal[1]));
            event.getRegistry().register(new ItemRealKeyblade(Strings.Pumpkinhead, BalanceConfig.keyblades.pumpkinhead[0], BalanceConfig.keyblades.pumpkinhead[1]));
            event.getRegistry().register(new ItemRealKeyblade(Strings.Rainfell, BalanceConfig.keyblades.rainfell[0], BalanceConfig.keyblades.rainfell[1]));
            event.getRegistry().register(new ItemRealKeyblade(Strings.RejectionofFate, BalanceConfig.keyblades.rejectionofFate[0], BalanceConfig.keyblades.rejectionofFate[1]));
            event.getRegistry().register(new ItemRealKeyblade(Strings.RoyalRadiance, BalanceConfig.keyblades.royalRadiance[0], BalanceConfig.keyblades.royalRadiance[1]));
            event.getRegistry().register(new ItemRealKeyblade(Strings.RumblingRose, BalanceConfig.keyblades.rumblingRose[0], BalanceConfig.keyblades.rumblingRose[1]));
            event.getRegistry().register(new ItemRealKeyblade(Strings.SignofInnocence, BalanceConfig.keyblades.signofInnocence[0], BalanceConfig.keyblades.signofInnocence[1]));
            event.getRegistry().register(new ItemRealKeyblade(Strings.SilentDirge, BalanceConfig.keyblades.silentDirge[0], BalanceConfig.keyblades.silentDirge[1]));
            event.getRegistry().register(new ItemRealKeyblade(Strings.SkullNoise, BalanceConfig.keyblades.skullNoise[0], BalanceConfig.keyblades.skullNoise[1]));
            event.getRegistry().register(new ItemRealKeyblade(Strings.SleepingLion, BalanceConfig.keyblades.sleepingLion[0], BalanceConfig.keyblades.sleepingLion[1]));
            event.getRegistry().register(new ItemRealKeyblade(Strings.SoulEater, BalanceConfig.keyblades.soulEater[0], BalanceConfig.keyblades.soulEater[1]));
            event.getRegistry().register(new ItemRealKeyblade(Strings.Spellbinder, BalanceConfig.keyblades.spellbinder[0], BalanceConfig.keyblades.spellbinder[1]));
            event.getRegistry().register(new ItemRealKeyblade(Strings.Starlight, BalanceConfig.keyblades.starlight[0], BalanceConfig.keyblades.starlight[1]));
            event.getRegistry().register(new ItemRealKeyblade(Strings.StarSeeker, BalanceConfig.keyblades.starSeeker[0], BalanceConfig.keyblades.starSeeker[1]));
            event.getRegistry().register(new ItemRealKeyblade(Strings.Stormfall, BalanceConfig.keyblades.stormfall[0], BalanceConfig.keyblades.stormfall[1]));
            event.getRegistry().register(new ItemRealKeyblade(Strings.StrokeofMidnight, BalanceConfig.keyblades.strokeofMidnight[0], BalanceConfig.keyblades.strokeofMidnight[1]));
            event.getRegistry().register(new ItemRealKeyblade(Strings.SweetDreams, BalanceConfig.keyblades.sweetDreams[0], BalanceConfig.keyblades.sweetDreams[1]));
            event.getRegistry().register(new ItemRealKeyblade(Strings.SweetMemories, BalanceConfig.keyblades.sweetMemories[0], BalanceConfig.keyblades.sweetMemories[1]));
            event.getRegistry().register(new ItemRealKeyblade(Strings.Sweetstack, BalanceConfig.keyblades.sweetstack[0], BalanceConfig.keyblades.sweetstack[1]));
            event.getRegistry().register(new ItemRealKeyblade(Strings.ThreeWishes, BalanceConfig.keyblades.threeWishes[0], BalanceConfig.keyblades.threeWishes[1]));
            event.getRegistry().register(new ItemRealKeyblade(Strings.TotalEclipse, BalanceConfig.keyblades.totalEclipse[0], BalanceConfig.keyblades.totalEclipse[1]));
            event.getRegistry().register(new ItemRealKeyblade(Strings.TreasureTrove, BalanceConfig.keyblades.treasureTrove[0], BalanceConfig.keyblades.treasureTrove[1]));
            event.getRegistry().register(new ItemRealKeyblade(Strings.TrueLightsFlight, BalanceConfig.keyblades.trueLightsFlight[0], BalanceConfig.keyblades.trueLightsFlight[1]));
            event.getRegistry().register(new ItemRealKeyblade(Strings.TwilightBlaze, BalanceConfig.keyblades.twilightBlaze[0], BalanceConfig.keyblades.twilightBlaze[1]));
            event.getRegistry().register(new ItemRealKeyblade(Strings.TwoBecomeOne, BalanceConfig.keyblades.twoBecomeOne[0], BalanceConfig.keyblades.twoBecomeOne[1]));
            event.getRegistry().register(new ItemRealKeyblade(Strings.UltimaWeaponKH1, BalanceConfig.keyblades.ultimaWeaponKH1[0], BalanceConfig.keyblades.ultimaWeaponKH1[1]));
            event.getRegistry().register(new ItemRealKeyblade(Strings.UltimaWeaponKH2, BalanceConfig.keyblades.ultimaWeaponKH2[0], BalanceConfig.keyblades.ultimaWeaponKH2[1]));
            event.getRegistry().register(new ItemRealKeyblade(Strings.UltimaWeaponBBS, BalanceConfig.keyblades.ultimaWeaponBBS[0], BalanceConfig.keyblades.ultimaWeaponBBS[1]));
            event.getRegistry().register(new ItemRealKeyblade(Strings.UltimaWeaponDDD, BalanceConfig.keyblades.ultimaWeaponDDD[0], BalanceConfig.keyblades.ultimaWeaponDDD[1]));
            event.getRegistry().register(new ItemKeyblade(Strings.Umbrella, BalanceConfig.keyblades.umbrella[0], BalanceConfig.keyblades.umbrella[1]));
            event.getRegistry().register(new ItemRealKeyblade(Strings.Unbound, BalanceConfig.keyblades.unbound[0], BalanceConfig.keyblades.unbound[1]));
            event.getRegistry().register(new ItemRealKeyblade(Strings.UnicornisForetellersKeyblade, BalanceConfig.keyblades.unicornisForetellersKeyblade[0], BalanceConfig.keyblades.unicornisForetellersKeyblade[1]));
            event.getRegistry().register(new ItemRealKeyblade(Strings.UrsusForetellersKeyblade, BalanceConfig.keyblades.ursusForetellersKeyblade[0], BalanceConfig.keyblades.ursusForetellersKeyblade[1]));
            event.getRegistry().register(new ItemRealKeyblade(Strings.VictoryLine, BalanceConfig.keyblades.victoryLine[0], BalanceConfig.keyblades.victoryLine[1]));
            event.getRegistry().register(new ItemRealKeyblade(Strings.VoidGear, BalanceConfig.keyblades.voidGear[0], BalanceConfig.keyblades.voidGear[1]));
            event.getRegistry().register(new ItemRealKeyblade(Strings.VulpeusForetellersKeyblade, BalanceConfig.keyblades.vulpeusForetellersKeyblade[0], BalanceConfig.keyblades.vulpeusForetellersKeyblade[1]));
            event.getRegistry().register(new ItemRealKeyblade(Strings.WaytotheDawn, BalanceConfig.keyblades.waytotheDawn[0], BalanceConfig.keyblades.waytotheDawn[1]));
            event.getRegistry().register(new ItemRealKeyblade(Strings.WaywardWind, BalanceConfig.keyblades.waywardWind[0], BalanceConfig.keyblades.waywardWind[1]));
            event.getRegistry().register(new ItemRealKeyblade(Strings.WinnersProof, BalanceConfig.keyblades.winnersProof[0], BalanceConfig.keyblades.winnersProof[1]));
            event.getRegistry().register(new ItemRealKeyblade(Strings.WishingLamp, BalanceConfig.keyblades.wishingLamp[0], BalanceConfig.keyblades.wishingLamp[1]));
            event.getRegistry().register(new ItemRealKeyblade(Strings.WishingStar, BalanceConfig.keyblades.wishingStar[0], BalanceConfig.keyblades.wishingStar[1]));
            event.getRegistry().register(new ItemKeyblade(Strings.WoodenKeyblade, BalanceConfig.keyblades.woodenKeyblade[0], BalanceConfig.keyblades.woodenKeyblade[1]));
            event.getRegistry().register(new ItemKeyblade(Strings.WoodenStick, BalanceConfig.keyblades.woodenStick[0], BalanceConfig.keyblades.woodenStick[1]));
            event.getRegistry().register(new ItemRealKeyblade(Strings.YoungXehanortsKeyblade, BalanceConfig.keyblades.youngXehanortsKeyblade[0], BalanceConfig.keyblades.youngXehanortsKeyblade[1]));
            event.getRegistry().register(new ItemRealKeyblade(Strings.ZeroOne, BalanceConfig.keyblades.zeroOne[0], BalanceConfig.keyblades.zeroOne[1]));

            // CHAINS
            event.getRegistry().register(new ItemKeychain(Strings.Chain_AbaddonPlasma));
            event.getRegistry().register(new ItemKeychain(Strings.Chain_AbyssalTide));
            event.getRegistry().register(new ItemKeychain(Strings.Chain_AllforOne));
            event.getRegistry().register(new ItemKeychain(Strings.Chain_AnguisForetellersKeyblade));
            event.getRegistry().register(new ItemKeychain(Strings.Chain_AstralBlast));
            event.getRegistry().register(new ItemKeychain(Strings.Chain_Aubade));
            event.getRegistry().register(new ItemKeychain(Strings.Chain_BondofFlame));
            event.getRegistry().register(new ItemKeychain(Strings.Chain_Brightcrest));
            event.getRegistry().register(new ItemKeychain(Strings.Chain_ChaosRipper));
            event.getRegistry().register(new ItemKeychain(Strings.Chain_CircleofLife));
            event.getRegistry().register(new ItemKeychain(Strings.Chain_Counterpoint));
            event.getRegistry().register(new ItemKeychain(Strings.Chain_Crabclaw));
            event.getRegistry().register(new ItemKeychain(Strings.Chain_CrownofGuilt));
            event.getRegistry().register(new ItemKeychain(Strings.Chain_DarkerThanDark));
            event.getRegistry().register(new ItemKeychain(Strings.Chain_Darkgnaw));
            event.getRegistry().register(new ItemKeychain(Strings.Chain_DecisivePumpkin));
            event.getRegistry().register(new ItemKeychain(Strings.Chain_DestinysEmbrace));
            event.getRegistry().register(new ItemKeychain(Strings.Chain_DiamondDust));
            event.getRegistry().register(new ItemKeychain(Strings.Chain_Divewing));
            event.getRegistry().register(new ItemKeychain(Strings.Chain_DivineRose));
            event.getRegistry().register(new ItemKeychain(Strings.Chain_DualDisc));
            event.getRegistry().register(new ItemKeychain(Strings.Chain_Earthshaker));
            event.getRegistry().register(new ItemKeychain(Strings.Chain_EndofPain));
            event.getRegistry().register(new ItemKeychain(Strings.Chain_EndsoftheEarth));
            event.getRegistry().register(new ItemKeychain(Strings.Chain_FairyHarp));
            event.getRegistry().register(new ItemKeychain(Strings.Chain_FairyStars));
            event.getRegistry().register(new ItemKeychain(Strings.Chain_FatalCrest));
            event.getRegistry().register(new ItemKeychain(Strings.Chain_Fenrir));
            event.getRegistry().register(new ItemKeychain(Strings.Chain_FerrisGear));
            event.getRegistry().register(new ItemKeychain(Strings.Chain_FollowtheWind));
            event.getRegistry().register(new ItemKeychain(Strings.Chain_FrolicFlame));
            event.getRegistry().register(new ItemKeychain(Strings.Chain_GlimpseofDarkness));
            event.getRegistry().register(new ItemKeychain(Strings.Chain_GuardianBell));
            event.getRegistry().register(new ItemKeychain(Strings.Chain_GuardianSoul));
            event.getRegistry().register(new ItemKeychain(Strings.Chain_GullWing));
            event.getRegistry().register(new ItemKeychain(Strings.Chain_HerosCrest));
            event.getRegistry().register(new ItemKeychain(Strings.Chain_HiddenDragon));
            event.getRegistry().register(new ItemKeychain(Strings.Chain_Hyperdrive));
            event.getRegistry().register(new ItemKeychain(Strings.Chain_IncompleteKiblade));
            event.getRegistry().register(new ItemKeychain(Strings.Chain_JungleKing));
            event.getRegistry().register(new ItemKeychain(Strings.Chain_KeybladeofPeoplesHearts));
            event.getRegistry().register(new ItemKeychain(Strings.Chain_Kiblade));
            event.getRegistry().register(new ItemKeychain(Strings.Chain_KingdomKey));
            event.getRegistry().register(new ItemKeychain(Strings.Chain_KingdomKeyD));
            event.getRegistry().register(new ItemKeychain(Strings.Chain_KnockoutPunch));
            event.getRegistry().register(new ItemKeychain(Strings.Chain_LadyLuck));
            event.getRegistry().register(new ItemKeychain(Strings.Chain_LeasKeyblade));
            event.getRegistry().register(new ItemKeychain(Strings.Chain_LeopardosForetellersKeyblade));
            event.getRegistry().register(new ItemKeychain(Strings.Chain_Leviathan));
            event.getRegistry().register(new ItemKeychain(Strings.Chain_Lionheart));
            event.getRegistry().register(new ItemKeychain(Strings.Chain_LostMemory));
            event.getRegistry().register(new ItemKeychain(Strings.Chain_LunarEclipse));
            event.getRegistry().register(new ItemKeychain(Strings.Chain_MarkofaHero));
            event.getRegistry().register(new ItemKeychain(Strings.Chain_MasterXehanortsKeyblade));
            event.getRegistry().register(new ItemKeychain(Strings.Chain_MastersDefender));
            event.getRegistry().register(new ItemKeychain(Strings.Chain_MaverickFlare));
            event.getRegistry().register(new ItemKeychain(Strings.Chain_MetalChocobo));
            event.getRegistry().register(new ItemKeychain(Strings.Chain_MidnightRoar));
            event.getRegistry().register(new ItemKeychain(Strings.Chain_MirageSplit));
            event.getRegistry().register(new ItemKeychain(Strings.Chain_MissingAche));
            event.getRegistry().register(new ItemKeychain(Strings.Chain_Monochrome));
            event.getRegistry().register(new ItemKeychain(Strings.Chain_MysteriousAbyss));
            event.getRegistry().register(new ItemKeychain(Strings.Chain_NightmaresEnd));
            event.getRegistry().register(new ItemKeychain(Strings.Chain_NightmaresEndandMirageSplit));
            event.getRegistry().register(new ItemKeychain(Strings.Chain_NoName));
            event.getRegistry().register(new ItemKeychain(Strings.Chain_Oathkeeper));
            event.getRegistry().register(new ItemKeychain(Strings.Chain_Oblivion));
            event.getRegistry().register(new ItemKeychain(Strings.Chain_OceansRage));
            event.getRegistry().register(new ItemKeychain(Strings.Chain_Olympia));
            event.getRegistry().register(new ItemKeychain(Strings.Chain_OmegaWeapon));
            event.getRegistry().register(new ItemKeychain(Strings.Chain_OminousBlight));
            event.getRegistry().register(new ItemKeychain(Strings.Chain_OneWingedAngel));
            event.getRegistry().register(new ItemKeychain(Strings.Chain_PainofSolitude));
            event.getRegistry().register(new ItemKeychain(Strings.Chain_PhotonDebugger));
            event.getRegistry().register(new ItemKeychain(Strings.Chain_PixiePetal));
            event.getRegistry().register(new ItemKeychain(Strings.Chain_Pumpkinhead));
            event.getRegistry().register(new ItemKeychain(Strings.Chain_Rainfell));
            event.getRegistry().register(new ItemKeychain(Strings.Chain_RejectionofFate));
            event.getRegistry().register(new ItemKeychain(Strings.Chain_RoyalRadiance));
            event.getRegistry().register(new ItemKeychain(Strings.Chain_RumblingRose));
            event.getRegistry().register(new ItemKeychain(Strings.Chain_SignofInnocence));
            event.getRegistry().register(new ItemKeychain(Strings.Chain_SilentDirge));
            event.getRegistry().register(new ItemKeychain(Strings.Chain_SkullNoise));
            event.getRegistry().register(new ItemKeychain(Strings.Chain_SleepingLion));
            event.getRegistry().register(new ItemKeychain(Strings.Chain_SoulEater));
            event.getRegistry().register(new ItemKeychain(Strings.Chain_Spellbinder));
            event.getRegistry().register(new ItemKeychain(Strings.Chain_StarSeeker));
            event.getRegistry().register(new ItemKeychain(Strings.Chain_Starlight));
            event.getRegistry().register(new ItemKeychain(Strings.Chain_Stormfall));
            event.getRegistry().register(new ItemKeychain(Strings.Chain_StrokeofMidnight));
            event.getRegistry().register(new ItemKeychain(Strings.Chain_SweetDreams));
            event.getRegistry().register(new ItemKeychain(Strings.Chain_SweetMemories));
            event.getRegistry().register(new ItemKeychain(Strings.Chain_Sweetstack));
            event.getRegistry().register(new ItemKeychain(Strings.Chain_ThreeWishes));
            event.getRegistry().register(new ItemKeychain(Strings.Chain_TotalEclipse));
            event.getRegistry().register(new ItemKeychain(Strings.Chain_TreasureTrove));
            event.getRegistry().register(new ItemKeychain(Strings.Chain_TrueLightsFlight));
            event.getRegistry().register(new ItemKeychain(Strings.Chain_TwilightBlaze));
            event.getRegistry().register(new ItemKeychain(Strings.Chain_TwoBecomeOne));
            event.getRegistry().register(new ItemKeychain(Strings.Chain_UltimaWeaponKH1));
            event.getRegistry().register(new ItemKeychain(Strings.Chain_UltimaWeaponKH2));
            event.getRegistry().register(new ItemKeychain(Strings.Chain_UltimaWeaponBBS));
            event.getRegistry().register(new ItemKeychain(Strings.Chain_UltimaWeaponDDD));
            event.getRegistry().register(new ItemKeychain(Strings.Chain_Umbrella));
            event.getRegistry().register(new ItemKeychain(Strings.Chain_Unbound));
            event.getRegistry().register(new ItemKeychain(Strings.Chain_UnicornisForetellersKeyblade));
            event.getRegistry().register(new ItemKeychain(Strings.Chain_UrsusForetellersKeyblade));
            event.getRegistry().register(new ItemKeychain(Strings.Chain_VictoryLine));
            event.getRegistry().register(new ItemKeychain(Strings.Chain_VoidGear));
            event.getRegistry().register(new ItemKeychain(Strings.Chain_VulpeusForetellersKeyblade));
            event.getRegistry().register(new ItemKeychain(Strings.Chain_WaytotheDawn));
            event.getRegistry().register(new ItemKeychain(Strings.Chain_WaywardWind));
            event.getRegistry().register(new ItemKeychain(Strings.Chain_WinnersProof));
            event.getRegistry().register(new ItemKeychain(Strings.Chain_WishingLamp));
            event.getRegistry().register(new ItemKeychain(Strings.Chain_WishingStar));
            event.getRegistry().register(new ItemKeychain(Strings.Chain_YoungXehanortsKeyblade));
            event.getRegistry().register(new ItemKeychain(Strings.Chain_ZeroOne));

            // Materials
            event.getRegistry().register(new ItemBlazingInfusedCoal(Strings.BlazingInfusedCoal));
            event.getRegistry().register(new ItemKKBase(Strings.FrostInfusedSnowBall));
            event.getRegistry().register(new ItemKKBase(Strings.StormyInfusedIron));
            event.getRegistry().register(new ItemKKBase(Strings.MythrilInfusedDiamond));
            event.getRegistry().register(new ItemKKBase(Strings.LightningInfusedGold));
            event.getRegistry().register(new ItemKKBase(Strings.BrightInfusedGlowStone));
            event.getRegistry().register(new ItemKKBase(Strings.DarkInfusedIron));

            event.getRegistry().register(new ItemAbandonedKnowledge(Strings.AbandonedKnowledge));

            // Armour
            event.getRegistry().register(new ItemOrganizationRobe(ORGANIZATIONROBE, 1, EntityEquipmentSlot.HEAD, 0, Strings.OrganizationRobe_Helmet));
            event.getRegistry().register(new ItemOrganizationRobe(ORGANIZATIONROBE, 1, EntityEquipmentSlot.CHEST, 1, Strings.OrganizationRobe_Chestplate));
            event.getRegistry().register(new ItemOrganizationRobe(ORGANIZATIONROBE, 2, EntityEquipmentSlot.LEGS, 2, Strings.OrganizationRobe_Leggings));
            event.getRegistry().register(new ItemOrganizationRobe(ORGANIZATIONROBE, 1, EntityEquipmentSlot.FEET, 3, Strings.OrganizationRobe_Boots));
            
            event.getRegistry().register(new ItemXemnasRobe(XEMNASROBE, 1, EntityEquipmentSlot.HEAD, 0, Strings.Xemnas_Helmet));
            event.getRegistry().register(new ItemXemnasRobe(XEMNASROBE, 1, EntityEquipmentSlot.CHEST, 1, Strings.Xemnas_Chestplate));
            event.getRegistry().register(new ItemXemnasRobe(XEMNASROBE, 2, EntityEquipmentSlot.LEGS, 2, Strings.Xemnas_Leggings));
            event.getRegistry().register(new ItemXemnasRobe(XEMNASROBE, 1, EntityEquipmentSlot.FEET, 3, Strings.Xemnas_Boots));

            event.getRegistry().register(new ItemTerraArmor(TERRA, 1, EntityEquipmentSlot.HEAD, 0, Strings.Terra_Helmet));
            event.getRegistry().register(new ItemTerraArmor(TERRA, 1, EntityEquipmentSlot.CHEST, 1, Strings.Terra_Chestplate));
            event.getRegistry().register(new ItemTerraArmor(TERRA, 2, EntityEquipmentSlot.LEGS, 2, Strings.Terra_Leggings));
            event.getRegistry().register(new ItemTerraArmor(TERRA, 1, EntityEquipmentSlot.FEET, 3,Strings.Terra_Boots));

            event.getRegistry().register(new ItemAquaArmor(AQUA, 1, EntityEquipmentSlot.HEAD, 0, Strings.Aqua_Helmet));
            event.getRegistry().register(new ItemAquaArmor(AQUA, 1, EntityEquipmentSlot.CHEST, 1, Strings.Aqua_Chestplate));
            event.getRegistry().register(new ItemAquaArmor(AQUA, 2, EntityEquipmentSlot.LEGS, 2, Strings.Aqua_Leggings));
            event.getRegistry().register(new ItemAquaArmor(AQUA, 1, EntityEquipmentSlot.FEET, 3, Strings.Aqua_Boots));

            event.getRegistry().register(new ItemVentusArmor(VENTUS, 1, EntityEquipmentSlot.HEAD, 0, Strings.Ventus_Helmet));
            event.getRegistry().register(new ItemVentusArmor(VENTUS, 1, EntityEquipmentSlot.CHEST, 1, Strings.Ventus_Chestplate));
            event.getRegistry().register(new ItemVentusArmor(VENTUS, 2, EntityEquipmentSlot.LEGS, 2, Strings.Ventus_Leggings));
            event.getRegistry().register(new ItemVentusArmor(VENTUS, 1, EntityEquipmentSlot.FEET, 3, Strings.Ventus_Boots));

            event.getRegistry().register(new ItemEraqusArmor(ERAQUS, 1, EntityEquipmentSlot.HEAD, 0, Strings.Eraqus_Helmet));
            event.getRegistry().register(new ItemEraqusArmor(ERAQUS, 1, EntityEquipmentSlot.CHEST, 1, Strings.Eraqus_Chestplate));
            event.getRegistry().register(new ItemEraqusArmor(ERAQUS, 2, EntityEquipmentSlot.LEGS, 2, Strings.Eraqus_Leggings));
            event.getRegistry().register(new ItemEraqusArmor(ERAQUS, 1, EntityEquipmentSlot.FEET, 3, Strings.Eraqus_Boots));

            event.getRegistry().register(new ItemMunny(Strings.Munny));
            event.getRegistry().register(new ItemKKBase(Strings.EmptyBottle).setMaxStackSize(1));
            event.getRegistry().register(new ItemPotion(0, true, "hp"));
            event.getRegistry().register(new ItemHiPotion(0, true, "hp"));
            event.getRegistry().register(new ItemMegaPotion(0, true, "hp"));
            event.getRegistry().register(new ItemEther(0, true, "mp"));
            event.getRegistry().register(new ItemMegaEther(0, true, "mp"));
            event.getRegistry().register(new ItemElixir(0, true, "elixir"));
            event.getRegistry().register(new ItemMegalixir(0, true, "elixir"));
            event.getRegistry().register(new ItemDriveRecovery(0, true, "dp"));
            event.getRegistry().register(new ItemHighDriveRecovery(0, true, "dp"));
            event.getRegistry().register(new ItemDefenseBoost(Strings.DefenseBoost));
            event.getRegistry().register(new ItemMagicBoost(Strings.MagicBoost));
            event.getRegistry().register(new ItemPowerBoost(Strings.PowerBoost));
            event.getRegistry().register(new ItemDriveBoost(Strings.DriveBoost));
            event.getRegistry().register(new ItemPanacea(0, true, "panacea"));

            event.getRegistry().register(new ItemHpOrb(Strings.HpOrb));
            event.getRegistry().register(new ItemDriveOrb(Strings.DriveOrb));
            event.getRegistry().register(new ItemMagicOrb(Strings.MagicOrb));
            event.getRegistry().register(new ItemKKBase(Strings.Heart));
            event.getRegistry().register(new ItemKKBase(Strings.DarkHeart));
            event.getRegistry().register(new ItemKKBase(Strings.PureHeart));
            event.getRegistry().register(new ItemKKBase(Strings.KingdomHearts));
            event.getRegistry().register(new ItemKKBase(Strings.DarkLeather));
            event.getRegistry().register(new ItemSynthesisMaterial(Strings.SynthesisMaterial));
            event.getRegistry().register(new ItemIceCream(Strings.IceCream, 5, true));
            event.getRegistry().register(new ItemKKBase(Strings.WinnerStick));            
            event.getRegistry().register(new ItemHandHeldGummiShip("gummiship"));

            event.getRegistry().register(new ItemUpgradeFire(Strings.LevelUpMagicFire, Strings.Spell_Fire));
            event.getRegistry().register(new ItemUpgradeBlizzard(Strings.LevelUpMagicBlizzard, Strings.Spell_Blizzard));
            event.getRegistry().register(new ItemUpgradeThunder(Strings.LevelUpMagicThunder, Strings.Spell_Thunder));
            event.getRegistry().register(new ItemUpgradeCure(Strings.LevelUpMagicCure, Strings.Spell_Cure));
            event.getRegistry().register(new ItemUpgradeAero(Strings.LevelUpMagicAero, Strings.Spell_Aero));
            event.getRegistry().register(new ItemUpgradeStop(Strings.LevelUpMagicStop, Strings.Spell_Stop));

            event.getRegistry().register(new ItemUpgradeValor(Strings.LevelUpValor, Strings.Form_Valor));
            event.getRegistry().register(new ItemUpgradeWisdom(Strings.LevelUpWisdom, Strings.Form_Wisdom));
            event.getRegistry().register(new ItemUpgradeLimit(Strings.LevelUpLimit, Strings.Form_Limit));
            event.getRegistry().register(new ItemUpgradeMaster(Strings.LevelUpMaster, Strings.Form_Master));
            event.getRegistry().register(new ItemUpgradeFinal(Strings.LevelUpFinal, Strings.Form_Final));

            event.getRegistry().register(new ItemSynthesisBagS(Strings.SynthesisBagS));
            event.getRegistry().register(new ItemSynthesisBagM(Strings.SynthesisBagM));
            event.getRegistry().register(new ItemSynthesisBagL(Strings.SynthesisBagL));

            event.getRegistry().register(new ItemKKRecord(ModSounds.Record_Birth_by_Sleep_A_Link_to_the_Future, Strings.Disc_Birth_by_Sleep_A_Link_to_the_Future, 7.29F));
            event.getRegistry().register(new ItemKKRecord(ModSounds.Record_Darkness_of_the_Unknown, Strings.Disc_Darkness_of_the_Unknown, 7.50F));
            event.getRegistry().register(new ItemKKRecord(ModSounds.Record_Dearly_Beloved_Symphony_Version, Strings.Disc_Dearly_Beloved_Symphony_Version, 2.33F));
            event.getRegistry().register(new ItemKKRecord(ModSounds.Record_Dream_Drop_Distance_The_Next_Awakening, Strings.Disc_Dream_Drop_Distance_The_Next_Awakening, 8.56F));
            event.getRegistry().register(new ItemKKRecord(ModSounds.Record_Hikari_KINGDOM_Instrumental_Version, Strings.Disc_Hikari_KINGDOM_Instrumental_Version, 3.42F));
            event.getRegistry().register(new ItemKKRecord(ModSounds.Record_L_Oscurita_Dell_Ignoto, Strings.Disc_L_Oscurita_Dell_Ignoto, 4.33F));
            event.getRegistry().register(new ItemKKRecord(ModSounds.Record_Musique_pour_la_tristesse_de_Xion, Strings.Disc_Musique_pour_la_tristesse_de_Xion, 3.57F));
            event.getRegistry().register(new ItemKKRecord(ModSounds.Record_No_More_Bugs_Bug_Version, Strings.Disc_No_More_Bugs_Bug_Version, 3.17F));
            event.getRegistry().register(new ItemKKRecord(ModSounds.Record_Organization_XIII, Strings.Disc_Organization_XIII, 2.32F));
            event.getRegistry().register(new ItemKKRecord(ModSounds.Record_Sanctuary, Strings.Disc_Sanctuary, 4.25F));
            event.getRegistry().register(new ItemKKRecord(ModSounds.Record_Simple_And_Clean_PLANITb_Remix, Strings.Disc_Simple_And_Clean_PLANITb_Remix, 2.37F));
            event.getRegistry().register(new ItemKKRecord(ModSounds.Record_Sinister_Sundown, Strings.Disc_Sinister_Sundown, 2.13F));
            event.getRegistry().register(new ItemKKRecord(ModSounds.Record_The_13th_Anthology, Strings.Disc_The_13th_Anthology, 6.38F));

            event.getRegistry().register(new ItemRecipe(Strings.Recipe));
        }
    }
}
