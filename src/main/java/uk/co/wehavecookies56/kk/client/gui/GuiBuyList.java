package uk.co.wehavecookies56.kk.client.gui;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.renderer.RenderItem;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.GuiScrollingList;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import org.lwjgl.opengl.GL11;
import uk.co.wehavecookies56.kk.api.materials.Material;
import uk.co.wehavecookies56.kk.api.materials.MaterialRegistry;
import uk.co.wehavecookies56.kk.api.recipes.RecipeRegistry;
import uk.co.wehavecookies56.kk.common.capability.ModCapabilities;
import uk.co.wehavecookies56.kk.common.capability.SynthesisRecipeCapability;
import uk.co.wehavecookies56.kk.common.item.base.ItemKeyblade;
import uk.co.wehavecookies56.kk.common.lib.Reference;
import uk.co.wehavecookies56.kk.common.util.Utils;

import java.util.ArrayList;
import java.util.List;

public class GuiBuyList extends GuiScrollingList {

	private GuiShop parent;

	FontRenderer f = Minecraft.getMinecraft().fontRendererObj;
	RenderItem ir = Minecraft.getMinecraft().getRenderItem();
	static ScaledResolution sr = new ScaledResolution(Minecraft.getMinecraft());
	static int width = sr.getScaledWidth();
	static int height = sr.getScaledHeight();
	static int sizeX = 150;
	static int posX = 5;
	static int posY = (height - 200) / 2;

	List<ItemStack> stack = new ArrayList<ItemStack>();

	public GuiBuyList(GuiShop parent) {
		super(parent.mc, 190, 300, 60, parent.height - ((parent.height / 8) + 70 / 16), 8, 35, parent.width, parent.height);
		this.parent = parent;
	}

	@Override
	protected int getSize () {
		return Minecraft.getMinecraft().thePlayer.getCapability(ModCapabilities.SYNTHESIS_RECIPES, null).getKnownRecipes().size();
	}

	@Override
	protected void elementClicked (int index, boolean doubleClick) {
		parent.buySelected = index;
	}

	@Override
	protected boolean isSelected (int index) {
		if (index == parent.buySelected) return true;
		return false;
	}

	@Override
	protected void drawBackground () {

	}

	@Override
	protected void drawSlot (int var1, int var2, int var3, int var4, Tessellator var5) {
		//TODO Draw list items
	}

}