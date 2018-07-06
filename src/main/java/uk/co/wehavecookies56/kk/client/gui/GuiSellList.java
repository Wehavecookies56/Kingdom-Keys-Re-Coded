package uk.co.wehavecookies56.kk.client.gui;

import java.util.ArrayList;
import java.util.List;

import org.lwjgl.opengl.GL11;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.renderer.RenderItem;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.client.GuiScrollingList;
import uk.co.wehavecookies56.kk.api.munny.MunnyRegistry;
import uk.co.wehavecookies56.kk.common.core.handler.event.ItemEvents;
import uk.co.wehavecookies56.kk.common.item.base.ItemSynthesisMaterial;
import uk.co.wehavecookies56.kk.common.lib.Strings;
import uk.co.wehavecookies56.kk.common.util.Utils;

public class GuiSellList extends GuiScrollingList {

    private GuiShop parent;

    FontRenderer f = Minecraft.getMinecraft().fontRenderer;
    RenderItem ir = Minecraft.getMinecraft().getRenderItem();
    static ScaledResolution sr = new ScaledResolution(Minecraft.getMinecraft());
    static int width = sr.getScaledWidth();
    static int height = sr.getScaledHeight();
    static int sizeX = 150;
    static int posX = 5;
    static int posY = (height - 200) / 2;

    public static List<ItemStack> sellableItems = new ArrayList<ItemStack>();
    public static List<Integer> stackSizes = new ArrayList<Integer>();

    public GuiSellList(GuiShop parent) {
        super(parent.mc, 190, 300, 60, parent.height - ((parent.height / 8) + 70 / 16), 8, 35, parent.width, parent.height);
        this.parent = parent;
        occupyList();
    }

    public void occupyList() {
        sellableItems.clear();
        stackSizes.clear();
        for (ItemStack invStack : Minecraft.getMinecraft().player.inventory.mainInventory) {
            for (ItemStack stack : MunnyRegistry.munnyValues.keySet()) {
                if (ItemEvents.areItemStacksEqual(stack, invStack)) {
                    sellableItems.add(invStack);
                    stackSizes.add(invStack.getCount());
                }
            }
        }
    }

    @Override
    protected int getSize () {
		return parent.sellFilter().size();
    }

    @Override
    protected void elementClicked (int index, boolean doubleClick) {
        parent.sellSelected = index;
        parent.updateButtons();
    }

    @Override
    protected boolean isSelected (int index) {
        if (index == parent.sellSelected) return true;
        return false;
    }

    @Override
    protected void drawBackground () {

    }

    @Override
    protected void drawSlot (int slotIdx, int entryRight, int slotTop, int slotBuffer, Tessellator tess) {    	
    	List<ItemStack> items = parent.sellFilter();

        if (!items.isEmpty() && slotIdx < items.size()) {

            String name = items.get(slotIdx).getDisplayName() + " x" + stackSizes.get(slotIdx);

            if (items.get(slotIdx).hasTagCompound()) {
                if (items.get(slotIdx).getTagCompound().hasKey("material")) {
                    name = Utils.translateToLocal(items.get(slotIdx).getTagCompound().getString("material") + ".name") + " x" + stackSizes.get(slotIdx);
                }
            }
            Minecraft.getMinecraft().fontRenderer.drawString(name, this.left + 3, slotTop, 0xFFFFFF);
            for (ItemStack stack : MunnyRegistry.munnyValues.keySet()) {
                if (ItemEvents.areItemStacksEqual(stack, items.get(slotIdx))) {
                    Minecraft.getMinecraft().fontRenderer.drawString((MunnyRegistry.munnyValues.get(stack) / 2) + "", this.left + 3, slotTop + 12, 0xFFFF55);
                }
            }
        }
    }

    public void drawSellSelected() {
    	List<ItemStack> items = parent.sellFilter();

        int posX = 220;
        if (parent.sellSelected != -1) {
            Minecraft.getMinecraft().renderEngine.bindTexture(parent.optionsBackground);
            drawGradientRect(posX - 10, 60, 700, parent.height - ((parent.height / 8) + 70 / 16), -1072689136, -804253680);
        }
        
        GL11.glPushMatrix(); 
        {
            GL11.glTranslatef(posX, 70, 0);
            GL11.glScalef(2, 2, 2);
            String name;
            if(items.get(parent.sellSelected) != null) {
	            if(items.get(parent.sellSelected).getItem() instanceof ItemSynthesisMaterial) {
	            	name = Utils.translateToLocal(items.get(parent.sellSelected).getTagCompound().getString("material")+".name");
	            } else {
	            	name = items.get(parent.sellSelected).getDisplayName();
	            }
	            parent.drawString(Minecraft.getMinecraft().fontRenderer, name + " x" + stackSizes.get(parent.sellSelected), 0, 0, 0xFFFFFF);
            }
        }
        GL11.glPopMatrix();
        
        parent.drawString(Minecraft.getMinecraft().fontRenderer, Utils.translateToLocal(Strings.Gui_Shop_Buy_Quantity), 220, parent.height - ((parent.height / 8) + 70 / 16) - 60, 0xFFFFFF);

        GL11.glPushMatrix(); 
        {
            GL11.glTranslatef(posX, 90, 0);
            for (ItemStack stack : MunnyRegistry.munnyValues.keySet()) {
                if (ItemEvents.areItemStacksEqual(stack, sellableItems.get(parent.sellSelected))) {
                	int price = MunnyRegistry.munnyValues.get(stack) / 2 * Utils.getInt(parent.quantity.getText());
                    Minecraft.getMinecraft().fontRenderer.drawString(Utils.translateToLocal(Strings.Gui_Shop_Sell_Price) + ": " + price, 0, 0, 0xFFFF55);
                }
            }
        }
        GL11.glPopMatrix();
    }

}