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
import uk.co.wehavecookies56.kk.api.recipes.RecipeRegistry;
import uk.co.wehavecookies56.kk.common.capability.ModCapabilities;
import uk.co.wehavecookies56.kk.common.capability.SynthesisRecipeCapability;
import uk.co.wehavecookies56.kk.common.item.base.ItemKeyblade;
import uk.co.wehavecookies56.kk.common.lib.Reference;
import uk.co.wehavecookies56.kk.common.util.Utils;

public class GuiRecipeList extends GuiScrollingList {

    private GuiSynthesis parent;

    FontRenderer f = Minecraft.getMinecraft().fontRenderer;
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
        return Minecraft.getMinecraft().player.getCapability(ModCapabilities.SYNTHESIS_RECIPES, null).getKnownRecipes().size();
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
    protected void drawBackground () {
        SynthesisRecipeCapability.ISynthesisRecipe RECIPES = Minecraft.getMinecraft().player.getCapability(ModCapabilities.SYNTHESIS_RECIPES, null);

        this.f.drawString(RECIPES.getKnownRecipes().size() + "/" + RecipeRegistry.getRecipeMap().size(), this.left + 130, 65, 0xFFFFFF);
    }

    @Override
    protected void drawSlot (int var1, int var2, int var3, int var4, Tessellator var5) {
        SynthesisRecipeCapability.ISynthesisRecipe RECIPES = Minecraft.getMinecraft().player.getCapability(ModCapabilities.SYNTHESIS_RECIPES, null);

        int color = 0xFFFFFF;
        if (parent.isRecipeUsable(RECIPES.getKnownRecipes().get(var1))) {
            color = 0x55FF55;
        }

        ItemKeyblade keyblade = (ItemKeyblade) ForgeRegistries.ITEMS.getValue(new ResourceLocation(Reference.MODID, RECIPES.getKnownRecipes().get(var1).substring(5)));

        this.f.drawString(f.trimStringToWidth(Utils.translateToLocal(RECIPES.getKnownRecipes().get(var1).toString() + ".name"), listWidth - 1), this.left + 3, var3 + 2, color);
        this.ir.renderItemAndEffectIntoGUI(new ItemStack(keyblade), this.left + 3, var3 + 12);
        String plus = keyblade.getStrength() < 0 ? "" : "+";
        this.f.drawString("Str: "+ plus +keyblade.getStrength(),this.left + 25, var3 + 12, 0xFF0000);
        plus = keyblade.getMagic() < 0 ? "" : "+";
        this.f.drawString("Mag: "+ plus +keyblade.getMagic(),this.left + 25, var3 + 20, 0x4444FF);
    }

}