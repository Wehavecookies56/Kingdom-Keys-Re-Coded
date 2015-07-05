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
    	if(name.equals(ModItems.KingdomKey.getUnlocalizedName())){
    		return new ItemStack(ModItems.KingdomKey, 1);
    	}
    	if(name.equals(ModItems.KingdomKeyD.getUnlocalizedName())){
    		return new ItemStack(ModItems.KingdomKeyD, 1);
    	}
		return null;

    }


}
