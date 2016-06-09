package uk.co.wehavecookies56.kk.client.gui;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.renderer.RenderItem;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.GuiScrollingList;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import uk.co.wehavecookies56.kk.common.capability.ModCapabilities;
import uk.co.wehavecookies56.kk.common.capability.SynthesisRecipeCapability;
import uk.co.wehavecookies56.kk.common.core.helper.TextHelper;
import uk.co.wehavecookies56.kk.common.item.ModItems;
import uk.co.wehavecookies56.kk.common.item.base.ItemKeyblade;
import uk.co.wehavecookies56.kk.common.lib.Reference;

public class GuiRecipeList extends GuiScrollingList {

	private GuiSynthesis parent;

	FontRenderer f = Minecraft.getMinecraft().fontRendererObj;
	RenderItem ir = Minecraft.getMinecraft().getRenderItem();
	static ScaledResolution sr = new ScaledResolution(Minecraft.getMinecraft());
	static int width = sr.getScaledWidth();
	static int height = sr.getScaledHeight();
	static int sizeX = 150;
	static int posX = 5;
	static int posY = (height - 200) / 2;

	public GuiRecipeList (GuiSynthesis parent) {
		super(parent.mc, 190, 300, 60, parent.height - ((parent.height / 8) + 70 / 16), 8, 35, parent.width, parent.height);
		this.parent = parent;
	}

	@Override
	protected int getSize () {
		return Minecraft.getMinecraft().thePlayer.getCapability(ModCapabilities.SYNTHESIS_RECIPES, null).getKnownRecipes().size();
	}

	@Override
	protected void elementClicked (int index, boolean doubleClick) {
		parent.selected = index;
	}

	@Override
	protected boolean isSelected (int index) {
		if (index == parent.selected) return true;
		return false;
	}

	@Override
	protected void drawBackground () {}

	@Override
	protected void drawSlot (int var1, int var2, int var3, int var4, Tessellator var5) {
		SynthesisRecipeCapability.ISynthesisRecipe RECIPES = Minecraft.getMinecraft().thePlayer.getCapability(ModCapabilities.SYNTHESIS_RECIPES, null);

		this.f.drawString(f.trimStringToWidth(TextHelper.localize(RECIPES.getKnownRecipes().get(var1).toString() + ".name"), listWidth - 1), this.left + 3, var3 + 2, 0xFFFFFF);
		this.ir.renderItemAndEffectIntoGUI(getItemStackFromName(RECIPES.getKnownRecipes().get(var1).toString()), this.left + 3, var3 + 12);
		this.f.drawString("Str: +"+((ItemKeyblade)ForgeRegistries.ITEMS.getValue(new ResourceLocation(Reference.MODID, RECIPES.getKnownRecipes().get(var1).substring(5)))).getStrength(),this.left + 25, var3 + 12, 0xFF0000);
		this.f.drawString("Mag: +"+((ItemKeyblade)ForgeRegistries.ITEMS.getValue(new ResourceLocation(Reference.MODID, RECIPES.getKnownRecipes().get(var1).substring(5)))).getMagic(),this.left + 25, var3 + 20, 0x4444FF);
		}

	public ItemStack getItemStackFromName (String name) {
		if (name.equals(ModItems.AbaddonPlasma.getUnlocalizedName())) return new ItemStack(ModItems.AbaddonPlasma, 1);
		if (name.equals(ModItems.AbyssalTide.getUnlocalizedName())) return new ItemStack(ModItems.AbyssalTide, 1);
		if (name.equals(ModItems.AllforOne.getUnlocalizedName())) return new ItemStack(ModItems.AllforOne, 1);
		if (name.equals(ModItems.AnguisForetellersKeyblade.getUnlocalizedName())) return new ItemStack(ModItems.AnguisForetellersKeyblade, 1);
		if (name.equals(ModItems.AstralBlast.getUnlocalizedName())) return new ItemStack(ModItems.AstralBlast, 1);
		if (name.equals(ModItems.Aubade.getUnlocalizedName())) return new ItemStack(ModItems.Aubade, 1);
		if (name.equals(ModItems.BondofFlame.getUnlocalizedName())) return new ItemStack(ModItems.BondofFlame, 1);
		if (name.equals(ModItems.Brightcrest.getUnlocalizedName())) return new ItemStack(ModItems.Brightcrest, 1);
		if (name.equals(ModItems.ChaosRipper.getUnlocalizedName())) return new ItemStack(ModItems.ChaosRipper, 1);
		if (name.equals(ModItems.CircleofLife.getUnlocalizedName())) return new ItemStack(ModItems.CircleofLife, 1);
		if (name.equals(ModItems.NightmaresEndandMirageSplit.getUnlocalizedName())) return new ItemStack(ModItems.NightmaresEndandMirageSplit, 1);
		if (name.equals(ModItems.Counterpoint.getUnlocalizedName())) return new ItemStack(ModItems.Counterpoint, 1);
		if (name.equals(ModItems.Crabclaw.getUnlocalizedName())) return new ItemStack(ModItems.Crabclaw, 1);
		if (name.equals(ModItems.CrownofGuilt.getUnlocalizedName())) return new ItemStack(ModItems.CrownofGuilt, 1);
		if (name.equals(ModItems.DarkerThanDark.getUnlocalizedName())) return new ItemStack(ModItems.DarkerThanDark, 1);
		if (name.equals(ModItems.Darkgnaw.getUnlocalizedName())) return new ItemStack(ModItems.Darkgnaw, 1);
		if (name.equals(ModItems.DecisivePumpkin.getUnlocalizedName())) return new ItemStack(ModItems.DecisivePumpkin, 1);
		if (name.equals(ModItems.DestinysEmbrace.getUnlocalizedName())) return new ItemStack(ModItems.DestinysEmbrace, 1);
		if (name.equals(ModItems.DiamondDust.getUnlocalizedName())) return new ItemStack(ModItems.DiamondDust, 1);
		if (name.equals(ModItems.Divewing.getUnlocalizedName())) return new ItemStack(ModItems.Divewing, 1);
		if (name.equals(ModItems.DivineRose.getUnlocalizedName())) return new ItemStack(ModItems.DivineRose, 1);
		if (name.equals(ModItems.DreamSword.getUnlocalizedName())) return new ItemStack(ModItems.DreamSword, 1);
		if (name.equals(ModItems.DualDisc.getUnlocalizedName())) return new ItemStack(ModItems.DualDisc, 1);
		if (name.equals(ModItems.Earthshaker.getUnlocalizedName())) return new ItemStack(ModItems.Earthshaker, 1);
		if (name.equals(ModItems.EndofPain.getUnlocalizedName())) return new ItemStack(ModItems.EndofPain, 1);
		if (name.equals(ModItems.EndsoftheEarth.getUnlocalizedName())) return new ItemStack(ModItems.EndsoftheEarth, 1);
		if (name.equals(ModItems.FairyHarp.getUnlocalizedName())) return new ItemStack(ModItems.FairyHarp, 1);
		if (name.equals(ModItems.FairyStars.getUnlocalizedName())) return new ItemStack(ModItems.FairyStars, 1);
		if (name.equals(ModItems.FatalCrest.getUnlocalizedName())) return new ItemStack(ModItems.FatalCrest, 1);
		if (name.equals(ModItems.Fenrir.getUnlocalizedName())) return new ItemStack(ModItems.Fenrir, 1);
		if (name.equals(ModItems.FerrisGear.getUnlocalizedName())) return new ItemStack(ModItems.FerrisGear, 1);
		if (name.equals(ModItems.FollowtheWind.getUnlocalizedName())) return new ItemStack(ModItems.FollowtheWind, 1);
		if (name.equals(ModItems.FrolicFlame.getUnlocalizedName())) return new ItemStack(ModItems.FrolicFlame, 1);
		if (name.equals(ModItems.GlimpseofDarkness.getUnlocalizedName())) return new ItemStack(ModItems.GlimpseofDarkness, 1);
		if (name.equals(ModItems.GuardianBell.getUnlocalizedName())) return new ItemStack(ModItems.GuardianBell, 1);
		if (name.equals(ModItems.GuardianSoul.getUnlocalizedName())) return new ItemStack(ModItems.GuardianSoul, 1);
		if (name.equals(ModItems.GullWing.getUnlocalizedName())) return new ItemStack(ModItems.GullWing, 1);
		if (name.equals(ModItems.HerosCrest.getUnlocalizedName())) return new ItemStack(ModItems.HerosCrest, 1);
		if (name.equals(ModItems.HiddenDragon.getUnlocalizedName())) return new ItemStack(ModItems.HiddenDragon, 1);
		if (name.equals(ModItems.Hyperdrive.getUnlocalizedName())) return new ItemStack(ModItems.Hyperdrive, 1);
		if (name.equals(ModItems.IncompleteKiblade.getUnlocalizedName())) return new ItemStack(ModItems.IncompleteKiblade, 1);
		if (name.equals(ModItems.JungleKing.getUnlocalizedName())) return new ItemStack(ModItems.JungleKing, 1);
		if (name.equals(ModItems.KeybladeofPeoplesHearts.getUnlocalizedName())) return new ItemStack(ModItems.KeybladeofPeoplesHearts, 1);
		if (name.equals(ModItems.Kiblade.getUnlocalizedName())) return new ItemStack(ModItems.Kiblade, 1);
		if (name.equals(ModItems.KingdomKey.getUnlocalizedName())) return new ItemStack(ModItems.KingdomKey, 1);
		if (name.equals(ModItems.KingdomKeyD.getUnlocalizedName())) return new ItemStack(ModItems.KingdomKeyD, 1);
		if (name.equals(ModItems.KnockoutPunch.getUnlocalizedName())) return new ItemStack(ModItems.KnockoutPunch, 1);
		if (name.equals(ModItems.LadyLuck.getUnlocalizedName())) return new ItemStack(ModItems.LadyLuck, 1);
		if (name.equals(ModItems.LeasKeyblade.getUnlocalizedName())) return new ItemStack(ModItems.LeasKeyblade, 1);
		if (name.equals(ModItems.LeopardosForetellersKeyblade.getUnlocalizedName())) return new ItemStack(ModItems.LeopardosForetellersKeyblade, 1);
		if (name.equals(ModItems.Leviathan.getUnlocalizedName())) return new ItemStack(ModItems.Leviathan, 1);
		if (name.equals(ModItems.Lionheart.getUnlocalizedName())) return new ItemStack(ModItems.Lionheart, 1);
		if (name.equals(ModItems.LostMemory.getUnlocalizedName())) return new ItemStack(ModItems.LostMemory, 1);
		if (name.equals(ModItems.LunarEclipse.getUnlocalizedName())) return new ItemStack(ModItems.LunarEclipse, 1);
		if (name.equals(ModItems.MarkofaHero.getUnlocalizedName())) return new ItemStack(ModItems.MarkofaHero, 1);
		if (name.equals(ModItems.MasterXehanortsKeyblade.getUnlocalizedName())) return new ItemStack(ModItems.MasterXehanortsKeyblade, 1);
		if (name.equals(ModItems.MastersDefender.getUnlocalizedName())) return new ItemStack(ModItems.MastersDefender, 1);
		if (name.equals(ModItems.MaverickFlare.getUnlocalizedName())) return new ItemStack(ModItems.MaverickFlare, 1);
		if (name.equals(ModItems.MetalChocobo.getUnlocalizedName())) return new ItemStack(ModItems.MetalChocobo, 1);
		if (name.equals(ModItems.MidnightRoar.getUnlocalizedName())) return new ItemStack(ModItems.MidnightRoar, 1);
		if (name.equals(ModItems.MirageSplit.getUnlocalizedName())) return new ItemStack(ModItems.MirageSplit, 1);
		if (name.equals(ModItems.MissingAche.getUnlocalizedName())) return new ItemStack(ModItems.MissingAche, 1);
		if (name.equals(ModItems.Monochrome.getUnlocalizedName())) return new ItemStack(ModItems.Monochrome, 1);
		if (name.equals(ModItems.MysteriousAbyss.getUnlocalizedName())) return new ItemStack(ModItems.MysteriousAbyss, 1);
		if (name.equals(ModItems.NightmaresEnd.getUnlocalizedName())) return new ItemStack(ModItems.NightmaresEnd, 1);
		if (name.equals(ModItems.NoName.getUnlocalizedName())) return new ItemStack(ModItems.NoName, 1);
		if (name.equals(ModItems.Oathkeeper.getUnlocalizedName())) return new ItemStack(ModItems.Oathkeeper, 1);
		if (name.equals(ModItems.Oblivion.getUnlocalizedName())) return new ItemStack(ModItems.Oblivion, 1);
		if (name.equals(ModItems.OceansRage.getUnlocalizedName())) return new ItemStack(ModItems.OceansRage, 1);
		if (name.equals(ModItems.Olympia.getUnlocalizedName())) return new ItemStack(ModItems.Olympia, 1);
		if (name.equals(ModItems.OmegaWeapon.getUnlocalizedName())) return new ItemStack(ModItems.OmegaWeapon, 1);
		if (name.equals(ModItems.OminousBlight.getUnlocalizedName())) return new ItemStack(ModItems.OminousBlight, 1);
		if (name.equals(ModItems.OneWingedAngel.getUnlocalizedName())) return new ItemStack(ModItems.OneWingedAngel, 1);
		if (name.equals(ModItems.PainofSolitude.getUnlocalizedName())) return new ItemStack(ModItems.PainofSolitude, 1);
		if (name.equals(ModItems.PhotonDebugger.getUnlocalizedName())) return new ItemStack(ModItems.PhotonDebugger, 1);
		if (name.equals(ModItems.PixiePetal.getUnlocalizedName())) return new ItemStack(ModItems.PixiePetal, 1);
		if (name.equals(ModItems.Pumpkinhead.getUnlocalizedName())) return new ItemStack(ModItems.Pumpkinhead, 1);
		if (name.equals(ModItems.Rainfell.getUnlocalizedName())) return new ItemStack(ModItems.Rainfell, 1);
		if (name.equals(ModItems.RejectionofFate.getUnlocalizedName())) return new ItemStack(ModItems.RejectionofFate, 1);
		if (name.equals(ModItems.RoyalRadiance.getUnlocalizedName())) return new ItemStack(ModItems.RoyalRadiance, 1);
		if (name.equals(ModItems.RumblingRose.getUnlocalizedName())) return new ItemStack(ModItems.RumblingRose, 1);
		if (name.equals(ModItems.SignofInnocence.getUnlocalizedName())) return new ItemStack(ModItems.SignofInnocence, 1);
		if (name.equals(ModItems.SilentDirge.getUnlocalizedName())) return new ItemStack(ModItems.SilentDirge, 1);
		if (name.equals(ModItems.SkullNoise.getUnlocalizedName())) return new ItemStack(ModItems.SkullNoise, 1);
		if (name.equals(ModItems.SleepingLion.getUnlocalizedName())) return new ItemStack(ModItems.SleepingLion, 1);
		if (name.equals(ModItems.SoulEater.getUnlocalizedName())) return new ItemStack(ModItems.SoulEater, 1);
		if (name.equals(ModItems.Spellbinder.getUnlocalizedName())) return new ItemStack(ModItems.Spellbinder, 1);
		if (name.equals(ModItems.StarSeeker.getUnlocalizedName())) return new ItemStack(ModItems.StarSeeker, 1);
		if (name.equals(ModItems.Starlight.getUnlocalizedName())) return new ItemStack(ModItems.Starlight, 1);
		if (name.equals(ModItems.Stormfall.getUnlocalizedName())) return new ItemStack(ModItems.Stormfall, 1);
		if (name.equals(ModItems.StrokeofMidnight.getUnlocalizedName())) return new ItemStack(ModItems.StrokeofMidnight, 1);
		if (name.equals(ModItems.SweetDreams.getUnlocalizedName())) return new ItemStack(ModItems.SweetDreams, 1);
		if (name.equals(ModItems.SweetMemories.getUnlocalizedName())) return new ItemStack(ModItems.SweetMemories, 1);
		if (name.equals(ModItems.Sweetstack.getUnlocalizedName())) return new ItemStack(ModItems.Sweetstack, 1);
		if (name.equals(ModItems.ThreeWishes.getUnlocalizedName())) return new ItemStack(ModItems.ThreeWishes, 1);
		if (name.equals(ModItems.TotalEclipse.getUnlocalizedName())) return new ItemStack(ModItems.TotalEclipse, 1);
		if (name.equals(ModItems.TreasureTrove.getUnlocalizedName())) return new ItemStack(ModItems.TreasureTrove, 1);
		if (name.equals(ModItems.TrueLightsFlight.getUnlocalizedName())) return new ItemStack(ModItems.TrueLightsFlight, 1);
		if (name.equals(ModItems.TwilightBlaze.getUnlocalizedName())) return new ItemStack(ModItems.TwilightBlaze, 1);
		if (name.equals(ModItems.TwoBecomeOne.getUnlocalizedName())) return new ItemStack(ModItems.TwoBecomeOne, 1);
		if (name.equals(ModItems.UltimaWeaponKH1.getUnlocalizedName())) return new ItemStack(ModItems.UltimaWeaponKH1, 1);
		if (name.equals(ModItems.UltimaWeaponKH2.getUnlocalizedName())) return new ItemStack(ModItems.UltimaWeaponKH2, 1);
		if (name.equals(ModItems.UltimaWeaponBBS.getUnlocalizedName())) return new ItemStack(ModItems.UltimaWeaponBBS, 1);
		if (name.equals(ModItems.UltimaWeaponDDD.getUnlocalizedName())) return new ItemStack(ModItems.UltimaWeaponDDD, 1);
		if (name.equals(ModItems.Umbrella.getUnlocalizedName())) return new ItemStack(ModItems.Umbrella, 1);
		if (name.equals(ModItems.Unbound.getUnlocalizedName())) return new ItemStack(ModItems.Unbound, 1);
		if (name.equals(ModItems.UnicornisForetellersKeyblade.getUnlocalizedName())) return new ItemStack(ModItems.UnicornisForetellersKeyblade, 1);
		if (name.equals(ModItems.UrsusForetellersKeyblade.getUnlocalizedName())) return new ItemStack(ModItems.UrsusForetellersKeyblade, 1);
		if (name.equals(ModItems.VictoryLine.getUnlocalizedName())) return new ItemStack(ModItems.VictoryLine, 1);
		if (name.equals(ModItems.VoidGear.getUnlocalizedName())) return new ItemStack(ModItems.VoidGear, 1);
		if (name.equals(ModItems.VulpeusForetellersKeyblade.getUnlocalizedName())) return new ItemStack(ModItems.VulpeusForetellersKeyblade, 1);
		if (name.equals(ModItems.WaytotheDawn.getUnlocalizedName())) return new ItemStack(ModItems.WaytotheDawn, 1);
		if (name.equals(ModItems.WaywardWind.getUnlocalizedName())) return new ItemStack(ModItems.WaywardWind, 1);
		if (name.equals(ModItems.WinnersProof.getUnlocalizedName())) return new ItemStack(ModItems.WinnersProof, 1);
		if (name.equals(ModItems.WishingLamp.getUnlocalizedName())) return new ItemStack(ModItems.WishingLamp, 1);
		if (name.equals(ModItems.WishingStar.getUnlocalizedName())) return new ItemStack(ModItems.WishingStar, 1);
		if (name.equals(ModItems.WoodenKeyblade.getUnlocalizedName())) return new ItemStack(ModItems.WoodenKeyblade, 1);
		if (name.equals(ModItems.WoodenStick.getUnlocalizedName())) return new ItemStack(ModItems.WoodenStick, 1);
		if (name.equals(ModItems.YoungXehanortsKeyblade.getUnlocalizedName())) return new ItemStack(ModItems.YoungXehanortsKeyblade, 1);
		if (name.equals(ModItems.ZeroOne.getUnlocalizedName())) return new ItemStack(ModItems.ZeroOne, 1);
		return null;

	}
}