package uk.co.wehavecookies56.kk.client.gui;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import uk.co.wehavecookies56.kk.api.menu.ItemCategory;
import uk.co.wehavecookies56.kk.api.menu.ItemCategoryRegistry;
import uk.co.wehavecookies56.kk.client.gui.redesign.*;
import uk.co.wehavecookies56.kk.api.menu.IItemCategory;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GuiStock extends GuiScreen {

    List<GuiInventoryItem> inventory = new ArrayList<>();

    GuiFilterBar filterBar;
    GuiScrollBar scrollBar;
    GuiMenu_Bars background;
    GuiElementBox box;
    public ItemStack selected = ItemStack.EMPTY;
    int itemsX = 100;
    int itemsY = 100;
    int itemWidth = 140;
    int itemHeight = 10;

    public GuiStock() {
        background = new GuiMenu_Bars("Stock");
        mc = Minecraft.getMinecraft();
    }

    @Override
    public void drawScreen(int mouseX, int mouseY, float partialTicks) {
        background.drawBars();
        background.drawBiomeDim();
        box.draw();
        //GlStateManager.disableTexture2D();
        //GlStateManager.disableBlend();

        //GL11.glDisable(GL11.GL_CULL_FACE);

        //Tessellator tessellator = Tessellator.getInstance();
        //BufferBuilder bufferbuilder = tessellator.getBuffer();
        //bufferbuilder.begin( GL11.GL_TRIANGLE_FAN, DefaultVertexFormats.POSITION_COLOR);
        //int angles = 270;
        //int r = 100;
        //for (float i = angles; i > 0; i--)
        //{
        //    double rad = (i - 90) / 180 * Math.PI;
        //    bufferbuilder.pos(100 + Math.cos(rad) * r, 100 + Math.sin(rad) * r, 0).color(0, 1, 0, 1).endVertex();
        //}
        //tessellator.draw();

        /*bufferbuilder.pos(100, 100, 0).color(1.0F,0.0F,0.0F,1.0F).endVertex();
        bufferbuilder.pos(200, 100, 0).color(1.0F,0.0F,0.0F,1.0F).endVertex();
        bufferbuilder.pos(200, 200, 0).color(1.0F,0.0F,0.0F,1.0F).endVertex();
        bufferbuilder.pos(100, 200, 0).color(1.0F,0.0F,0.0F,1.0F).endVertex();
        tessellator.draw();
        */
        //GlStateManager.enableBlend();
        //GlStateManager.enableTexture2D();
        super.drawScreen(mouseX, mouseY, partialTicks);
        filterBar.drawScreen(this, mouseX, mouseY, partialTicks);
        scrollBar.drawButton(mc, mouseX, mouseY, partialTicks);

        float tooltipPosX = width * 0.3333F;
        float tooltipPosY = height * 0.8F;

        float iconPosX = width * 0.163F;
        float iconPosY = height * 0.8083F;
        float iconWidth = width * 0.1015F;
        float iconHeight = height * 0.1537F;

        if (!ItemStack.areItemStacksEqual(ItemStack.EMPTY, selected)) {
            RenderHelper.disableStandardItemLighting();
            RenderHelper.enableGUIStandardItemLighting();
            GlStateManager.pushMatrix();
            GlStateManager.translate(iconPosX, tooltipPosY, 0);
            GlStateManager.scale((float) (0.0625F*iconHeight), (float) (0.0625F*iconHeight), 1);
            Minecraft.getMinecraft().getRenderItem().renderItemAndEffectIntoGUI(selected, 0, 0);
            GlStateManager.popMatrix();
            List<String> tooltip =  selected.getTooltip(mc.player, ITooltipFlag.TooltipFlags.NORMAL);
            for (int i = 1; i < tooltip.size(); i++) {
                drawString(mc.fontRenderer, tooltip.get(i), (int)tooltipPosX+5, (int)tooltipPosY+(mc.fontRenderer.FONT_HEIGHT*i), 0xFFFFFF);
            }
        }
        for (int i = 0; i < inventory.size(); i++) {
            inventory.get(i).drawButton(mc, mouseX, mouseY, partialTicks);
        }
    }

    @Override
    protected void actionPerformed(GuiButton button) throws IOException {
        filterBar.actionPerformed(button);
        super.actionPerformed(button);
    }

    public boolean filterItem(ItemStack item) {
        if (ItemStack.areItemStacksEqual(item, ItemStack.EMPTY)) {
            return false;
        } else {
            if (filterBar.currentFilter == null) {
                return true;
            } else {
                if (item.getItem() instanceof IItemCategory) {
                    if (filterBar.currentFilter == ((IItemCategory)(item.getItem())).getCategory()) {
                        return true;
                    } else {
                        return false;
                    }
                } else if (ItemCategoryRegistry.hasCategory(item.getItem())) {
                    if (filterBar.currentFilter == ItemCategoryRegistry.getCategory(item.getItem())) {
                        return true;
                    } else {
                        return false;
                    }
                } else if (filterBar.currentFilter == ItemCategory.MISC) {
                    return true;
                } else {
                    return false;
                }
            }
        }
    }

    public void initItems() {
        float boxPosX = (float)width * 0.1437F;
        float topBarHeight = (float)height * 0.17F;
        float invPosX = (float)width * 0.1494F;
        float invPosY = (float)height * 0.1851F;
        inventory.clear();
        List<ItemStack> items = new ArrayList<>();
        for (int i = 0; i < mc.player.inventory.getSizeInventory(); i++) {
            if (filterItem(mc.player.inventory.getStackInSlot(i))) {
                items.add(mc.player.inventory.getStackInSlot(i));
            }
        }
        for (int i = 0; i < items.size(); i+=2) {
            inventory.add(new GuiInventoryItem(this, items.get(i), (int) invPosX, (int)invPosY+(i*7)));
            if (i + 1 < items.size()) {
                inventory.add(new GuiInventoryItem(this, items.get(i+1), (int) invPosX+inventory.get(i).width, (int)invPosY+(i*7)));
            }
        }
    }

    @Override
    public void initGui() {
        background.width = width;
        background.height = height;
        background.init();
        float boxPosX = (float)width * 0.1437F;
        float boxWidth = (float)width * 0.7135F;
        float topBarHeight = (float)height * 0.17F;
        float middleHeight = (float)height * 0.6F;
        box = new GuiElementBox((int)boxPosX, (int)topBarHeight, (int)boxWidth, (int)middleHeight, 0x040444);
        float filterPosX = width * 0.3525F;
        float filterPosY = height * 0.023F;
        filterBar = new GuiFilterBar((int)filterPosX, (int)filterPosY, this);
        filterBar.initGui();
        initItems();
        buttonList.addAll(filterBar.buttons);
        buttonList.add(scrollBar = new GuiScrollBar(10, 0, 0, 0, 100));
        super.initGui();
    }

    @Override
    protected void mouseClicked(int mouseX, int mouseY, int mouseButton) throws IOException {
        scrollBar.mousePressed(mc, mouseX, mouseY);
        for (GuiInventoryItem i : inventory) {
            i.mousePressed(mc, mouseX, mouseY);
        }
        super.mouseClicked(mouseX, mouseY, mouseButton);

    }

    @Override
    protected void mouseClickMove(int mouseX, int mouseY, int clickedMouseButton, long timeSinceLastClick) {
        scrollBar.mouseDragged(mc, mouseX, mouseY);
    }
}
