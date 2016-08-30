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
import uk.co.wehavecookies56.kk.api.recipes.FreeDevRecipeRegistry;
import uk.co.wehavecookies56.kk.common.capability.ModCapabilities;
import uk.co.wehavecookies56.kk.common.capability.SynthesisRecipeCapability;
import uk.co.wehavecookies56.kk.common.lib.Reference;
import uk.co.wehavecookies56.kk.common.util.Utils;

public class GuiFreeDevelopmentRecipeList extends GuiScrollingList {

	private GuiSynthesis parent;

	FontRenderer f = Minecraft.getMinecraft().fontRendererObj;
	RenderItem ir = Minecraft.getMinecraft().getRenderItem();
	static ScaledResolution sr = new ScaledResolution(Minecraft.getMinecraft());
	static int width = sr.getScaledWidth();
	static int height = sr.getScaledHeight();
	static int sizeX = 150;
	static int posX = 5;
	static int posY = (height - 200) / 2;

	public GuiFreeDevelopmentRecipeList(GuiSynthesis parent) {
		super(parent.mc, 190, 300, 60, parent.height - ((parent.height / 8) + 70 / 16), 8, 35, parent.width, parent.height);
		this.parent = parent;
	}

	@Override
	protected int getSize () {
		return Minecraft.getMinecraft().thePlayer.getCapability(ModCapabilities.SYNTHESIS_RECIPES, null).getFreeDevRecipes().size();
	}

	@Override
	protected void elementClicked (int index, boolean doubleClick) {
		parent.freeDevSelected = index;
	}

	@Override
	protected boolean isSelected (int index) {
		if (index == parent.freeDevSelected) return true;
		return false;
	}

	@Override
	protected void drawBackground () {
		SynthesisRecipeCapability.ISynthesisRecipe RECIPES = Minecraft.getMinecraft().thePlayer.getCapability(ModCapabilities.SYNTHESIS_RECIPES, null);

		this.f.drawString(RECIPES.getFreeDevRecipes().size() + "/" + FreeDevRecipeRegistry.getFreeDevRecipeMap().size(), this.left + 130, 65, 0xFFFFFF);
	}

	@Override
	protected void drawSlot (int var1, int var2, int var3, int var4, Tessellator var5) {
		SynthesisRecipeCapability.ISynthesisRecipe RECIPES = Minecraft.getMinecraft().thePlayer.getCapability(ModCapabilities.SYNTHESIS_RECIPES, null);

		this.f.drawString(f.trimStringToWidth(Utils.translateToLocal(RECIPES.getFreeDevRecipes().get(var1).toString() + ".name"), listWidth - 1), this.left + 3, var3 + 2, 0xFFFFFF);
		this.ir.renderItemAndEffectIntoGUI(new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation(Reference.MODID, RECIPES.getFreeDevRecipes().get(var1).substring(5)))), this.left + 3, var3 + 12);
		//this.f.drawString("Str: +"+((ItemKeyblade)ForgeRegistries.ITEMS.getValue(new ResourceLocation(Reference.MODID, RECIPES.getKnownRecipes().get(var1).substring(5)))).getStrength(),this.left + 25, var3 + 12, 0xFF0000);
		//this.f.drawString("Mag: +"+((ItemKeyblade)ForgeRegistries.ITEMS.getValue(new ResourceLocation(Reference.MODID, RECIPES.getKnownRecipes().get(var1).substring(5)))).getMagic(),this.left + 25, var3 + 20, 0x4444FF);
	}
}