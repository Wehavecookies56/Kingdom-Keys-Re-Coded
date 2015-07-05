package wehavecookies56.kk.client.gui;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.ItemRenderer;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.WorldRenderer;
import net.minecraft.client.renderer.entity.RenderItem;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.client.resources.model.IBakedModel;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.client.GuiScrollingList;
import wehavecookies56.kk.entities.ExtendedPlayerRecipes;
import wehavecookies56.kk.item.ModItems;
import wehavecookies56.kk.util.TextHelper;

public class GuiRecipeList extends GuiScrollingList {

	private GuiSynthesis parent;

	FontRenderer f = Minecraft.getMinecraft().fontRendererObj;
	RenderItem ir = Minecraft.getMinecraft().getRenderItem();
	static ScaledResolution sr = new ScaledResolution(Minecraft.getMinecraft(), Minecraft.getMinecraft().displayWidth, Minecraft.getMinecraft().displayHeight);
	static int width = sr.getScaledWidth();
	static int height = sr.getScaledHeight();
	//static int sizeY = (int) (parent.height*0.8);
	static int sizeX = 150;
	static int posX = 5;
	static int posY = (height-200)/2;
	//int selected;

    public GuiRecipeList(GuiSynthesis parent)
    {
    	//super(Minecraft minecraft, int width, int height, int top, int bottom, int left, int entryHeight)
        super(parent.mc, 150, 300, 60, parent.height - ((parent.height/8)+70/16), 8, 35);
        this.parent = parent;
        //this.selected = parent.selected;
    }


    @Override
    protected int getSize()
    {
        return ExtendedPlayerRecipes.get(Minecraft.getMinecraft().thePlayer).knownRecipes.size();
    }

    @Override
    protected void elementClicked(int index, boolean doubleClick)
    {
    	parent.selected = index;
    }

    @Override
    protected boolean isSelected(int index)
    {
    	if(index == parent.selected){
    		return true;
    	}
        return false;
    }

    @Override
    protected void drawBackground()
    {
    }

	@Override
    protected void drawSlot(int var1, int var2, int var3, int var4, Tessellator var5)
    {
    	ExtendedPlayerRecipes props = ExtendedPlayerRecipes.get(Minecraft.getMinecraft().thePlayer);

        this.f.drawString(f.trimStringToWidth(TextHelper.localize(props.knownRecipes.get(var1).toString() + ".name"), listWidth - 10), this.left + 3, var3 + 2, 0xFFFFFF);
        this.ir.func_175042_a(getItemStackFromName(props.knownRecipes.get(var1).toString()), this.left + 3, var3 + 12);

    }

    public ItemStack getItemStackFromName(String name){
    	if(name.equals(ModItems.AbaddonPlasma.getUnlocalizedName())){
    		return new ItemStack(ModItems.AbaddonPlasma, 1);
    	}
    	if(name.equals(ModItems.AbyssalTide.getUnlocalizedName())){
    		return new ItemStack(ModItems.AbyssalTide, 1);
    	}
    	if(name.equals(ModItems.AllforOne.getUnlocalizedName())){
    		return new ItemStack(ModItems.AllforOne, 1);
    	}
    	if(name.equals(ModItems.AnguisForetellersKeyblade.getUnlocalizedName())){
    		return new ItemStack(ModItems.AnguisForetellersKeyblade, 1);
    	}
    	if(name.equals(ModItems.AstralBlast.getUnlocalizedName())){
    		return new ItemStack(ModItems.AstralBlast, 1);
    	}
    	if(name.equals(ModItems.Aubade.getUnlocalizedName())){
    		return new ItemStack(ModItems.Aubade, 1);
    	}
    	if(name.equals(ModItems.BondofFlame.getUnlocalizedName())){
    		return new ItemStack(ModItems.BondofFlame, 1);
    	}
    	if(name.equals(ModItems.Brightcrest.getUnlocalizedName())){
    		return new ItemStack(ModItems.Brightcrest, 1);
    	}
    	if(name.equals(ModItems.ChaosRipper.getUnlocalizedName())){
    		return new ItemStack(ModItems.ChaosRipper, 1);
    	}
    	if(name.equals(ModItems.CircleofLife.getUnlocalizedName())){
    		return new ItemStack(ModItems.CircleofLife, 1);
    	}
    	if(name.equals(ModItems.Counterpoint.getUnlocalizedName())){
    		return new ItemStack(ModItems.Counterpoint, 1);
    	}
    	if(name.equals(ModItems.Crabclaw.getUnlocalizedName())){
    		return new ItemStack(ModItems.Crabclaw, 1);
    	}
    	if(name.equals(ModItems.CrownofGuilt.getUnlocalizedName())){
    		return new ItemStack(ModItems.CrownofGuilt, 1);
    	}
    	if(name.equals(ModItems.DarkerThanDark.getUnlocalizedName())){
    		return new ItemStack(ModItems.DarkerThanDark, 1);
    	}
    	if(name.equals(ModItems.Darkgnaw.getUnlocalizedName())){
    		return new ItemStack(ModItems.Darkgnaw, 1);
    	}
    	if(name.equals(ModItems.DecisivePumpkin.getUnlocalizedName())){
    		return new ItemStack(ModItems.DecisivePumpkin, 1);
    	}
    	if(name.equals(ModItems.DestinysEmbrace.getUnlocalizedName())){
    		return new ItemStack(ModItems.DestinysEmbrace, 1);
    	}
    	if(name.equals(ModItems.DiamondDust.getUnlocalizedName())){
    		return new ItemStack(ModItems.DiamondDust, 1);
    	}
    	if(name.equals(ModItems.Divewing.getUnlocalizedName())){
    		return new ItemStack(ModItems.Divewing, 1);
    	}
    	if(name.equals(ModItems.DivineRose.getUnlocalizedName())){
    		return new ItemStack(ModItems.DivineRose, 1);
    	}
    	if(name.equals(ModItems.DreamSword.getUnlocalizedName())){
    		return new ItemStack(ModItems.DreamSword, 1);
    	}
    	if(name.equals(ModItems.DualDisc.getUnlocalizedName())){
    		return new ItemStack(ModItems.DualDisc, 1);
    	}
    	if(name.equals(ModItems.Earthshaker.getUnlocalizedName())){
    		return new ItemStack(ModItems.Earthshaker, 1);
    	}
    	if(name.equals(ModItems.EndofPain.getUnlocalizedName())){
    		return new ItemStack(ModItems.EndofPain, 1);
    	}
    	if(name.equals(ModItems.EndsoftheEarth.getUnlocalizedName())){
    		return new ItemStack(ModItems.EndsoftheEarth, 1);
    	}
    	if(name.equals(ModItems.FairyHarp.getUnlocalizedName())){
    		return new ItemStack(ModItems.FairyHarp, 1);
    	}
    	if(name.equals(ModItems.FairyStars.getUnlocalizedName())){
    		return new ItemStack(ModItems.FairyStars, 1);
    	}
    	if(name.equals(ModItems.FatalCrest.getUnlocalizedName())){
    		return new ItemStack(ModItems.FatalCrest, 1);
    	}
    	if(name.equals(ModItems.Fenrir.getUnlocalizedName())){
    		return new ItemStack(ModItems.Fenrir, 1);
    	}
    	if(name.equals(ModItems.FerrisGear.getUnlocalizedName())){
    		return new ItemStack(ModItems.FerrisGear, 1);
    	}
    	if(name.equals(ModItems.FollowtheWind.getUnlocalizedName())){
    		return new ItemStack(ModItems.FollowtheWind, 1);
    	}
    	if(name.equals(ModItems.FrolicFlame.getUnlocalizedName())){
    		return new ItemStack(ModItems.FrolicFlame, 1);
    	}
    	if(name.equals(ModItems.GlimpseofDarkness.getUnlocalizedName())){
    		return new ItemStack(ModItems.GlimpseofDarkness, 1);
    	}
    	if(name.equals(ModItems.GuardianBell.getUnlocalizedName())){
    		return new ItemStack(ModItems.GuardianBell, 1);
    	}
    	if(name.equals(ModItems.GuardianSoul.getUnlocalizedName())){
    		return new ItemStack(ModItems.GuardianSoul, 1);
    	}
    	if(name.equals(ModItems.GullWing.getUnlocalizedName())){
    		return new ItemStack(ModItems.GullWing, 1);
    	}
    	if(name.equals(ModItems.HerosCrest.getUnlocalizedName())){
    		return new ItemStack(ModItems.HerosCrest, 1);
    	}
    	if(name.equals(ModItems.HiddenDragon.getUnlocalizedName())){
    		return new ItemStack(ModItems.HiddenDragon, 1);
    	}
    	if(name.equals(ModItems.Hyperdrive.getUnlocalizedName())){
    		return new ItemStack(ModItems.Hyperdrive, 1);
    	}
    	if(name.equals(ModItems.IncompleteKiblade.getUnlocalizedName())){
    		return new ItemStack(ModItems.IncompleteKiblade, 1);
    	}
    	if(name.equals(ModItems.JungleKing.getUnlocalizedName())){
    		return new ItemStack(ModItems.JungleKing, 1);
    	}
    	if(name.equals(ModItems.KeybladeofPeoplesHearts.getUnlocalizedName())){
    		return new ItemStack(ModItems.KeybladeofPeoplesHearts, 1);
    	}
    	if(name.equals(ModItems.Kiblade.getUnlocalizedName())){
    		return new ItemStack(ModItems.Kiblade, 1);
    	}
    	if(name.equals(ModItems.KingdomKey.getUnlocalizedName())){
    		return new ItemStack(ModItems.KingdomKey, 1);
    	}
    	if(name.equals(ModItems.KingdomKeyD.getUnlocalizedName())){
    		return new ItemStack(ModItems.KingdomKeyD, 1);
    	}
    	if(name.equals(ModItems.KnockoutPunch.getUnlocalizedName())){
    		return new ItemStack(ModItems.KnockoutPunch, 1);
    	}
    	if(name.equals(ModItems.LadyLuck.getUnlocalizedName())){
    		return new ItemStack(ModItems.LadyLuck, 1);
    	}
    	if(name.equals(ModItems.LeasKeyblade.getUnlocalizedName())){
    		return new ItemStack(ModItems.LeasKeyblade, 1);
    	}
    	if(name.equals(ModItems.LeopardosForetellersKeyblade.getUnlocalizedName())){
    		return new ItemStack(ModItems.LeopardosForetellersKeyblade, 1);
    	}
    	if(name.equals(ModItems.Leviathan.getUnlocalizedName())){
    		return new ItemStack(ModItems.Leviathan, 1);
    	}
    	if(name.equals(ModItems.Lionheart.getUnlocalizedName())){
    		return new ItemStack(ModItems.Lionheart, 1);
    	}
    	if(name.equals(ModItems.LostMemory.getUnlocalizedName())){
    		return new ItemStack(ModItems.LostMemory, 1);
    	}
    	if(name.equals(ModItems.LunarEclipse.getUnlocalizedName())){
    		return new ItemStack(ModItems.LunarEclipse, 1);
    	}
    	if(name.equals(ModItems.KingdomKey.getUnlocalizedName())){
    		return new ItemStack(ModItems.KingdomKey, 1);
    	}
    	if(name.equals(ModItems.KingdomKey.getUnlocalizedName())){
    		return new ItemStack(ModItems.KingdomKey, 1);
    	}
    	if(name.equals(ModItems.KingdomKey.getUnlocalizedName())){
    		return new ItemStack(ModItems.KingdomKey, 1);
    	}
    	if(name.equals(ModItems.KingdomKey.getUnlocalizedName())){
    		return new ItemStack(ModItems.KingdomKey, 1);
    	}
    	if(name.equals(ModItems.KingdomKey.getUnlocalizedName())){
    		return new ItemStack(ModItems.KingdomKey, 1);
    	}
    	if(name.equals(ModItems.KingdomKey.getUnlocalizedName())){
    		return new ItemStack(ModItems.KingdomKey, 1);
    	}
    	if(name.equals(ModItems.KingdomKey.getUnlocalizedName())){
    		return new ItemStack(ModItems.KingdomKey, 1);
    	}
    	if(name.equals(ModItems.KingdomKey.getUnlocalizedName())){
    		return new ItemStack(ModItems.KingdomKey, 1);
    	}
    	if(name.equals(ModItems.KingdomKey.getUnlocalizedName())){
    		return new ItemStack(ModItems.KingdomKey, 1);
    	}
    	if(name.equals(ModItems.KingdomKey.getUnlocalizedName())){
    		return new ItemStack(ModItems.KingdomKey, 1);
    	}
    	if(name.equals(ModItems.KingdomKey.getUnlocalizedName())){
    		return new ItemStack(ModItems.KingdomKey, 1);
    	}
    	if(name.equals(ModItems.KingdomKey.getUnlocalizedName())){
    		return new ItemStack(ModItems.KingdomKey, 1);
    	}
    	if(name.equals(ModItems.KingdomKey.getUnlocalizedName())){
    		return new ItemStack(ModItems.KingdomKey, 1);
    	}
    	if(name.equals(ModItems.KingdomKey.getUnlocalizedName())){
    		return new ItemStack(ModItems.KingdomKey, 1);
    	}
    	if(name.equals(ModItems.KingdomKey.getUnlocalizedName())){
    		return new ItemStack(ModItems.KingdomKey, 1);
    	}
    	if(name.equals(ModItems.KingdomKey.getUnlocalizedName())){
    		return new ItemStack(ModItems.KingdomKey, 1);
    	}
    	if(name.equals(ModItems.KingdomKey.getUnlocalizedName())){
    		return new ItemStack(ModItems.KingdomKey, 1);
    	}
    	
    	if(name.equals(ModItems.KingdomKey.getUnlocalizedName())){
    		return new ItemStack(ModItems.KingdomKey, 1);
    	}
    	if(name.equals(ModItems.KingdomKeyD.getUnlocalizedName())){
    		return new ItemStack(ModItems.KingdomKeyD, 1);
    	}
		return null;

    }


}
