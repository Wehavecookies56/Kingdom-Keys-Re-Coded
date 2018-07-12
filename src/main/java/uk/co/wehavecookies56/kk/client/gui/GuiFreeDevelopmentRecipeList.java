package uk.co.wehavecookies56.kk.client.gui;

import java.util.List;

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

    FontRenderer f = Minecraft.getMinecraft().fontRenderer;
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
		List<String> freeDev = parent.freeDevFilter();
		return freeDev.size();
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
        SynthesisRecipeCapability.ISynthesisRecipe RECIPES = Minecraft.getMinecraft().player.getCapability(ModCapabilities.SYNTHESIS_RECIPES, null);

        this.f.drawString(RECIPES.getFreeDevRecipes().size() + "/" + FreeDevRecipeRegistry.getFreeDevRecipeMap().size(), this.left + 130, 65, 0xFFFFFF);
    }

    @Override
    protected void drawSlot (int var1, int var2, int var3, int var4, Tessellator var5) {
        List<String> recipes = parent.freeDevFilter();
        
        int colour = 0xFFFFFF;
        if (parent.isFreeDevRecipeUsable(recipes.get(var1))) {
            colour = 0x55FF55;
        }

        this.f.drawString(f.trimStringToWidth(Utils.translateToLocal(recipes.get(var1).toString() + ".name"), listWidth - 1), this.left + 3, var3 + 2, colour);
        this.ir.renderItemAndEffectIntoGUI(new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation(Reference.MODID, recipes.get(var1).substring(5)))), this.left + 3, var3 + 12);
    }
}