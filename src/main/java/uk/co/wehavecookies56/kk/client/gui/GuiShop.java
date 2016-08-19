package uk.co.wehavecookies56.kk.client.gui;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.GuiTextField;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.GL11;
import uk.co.wehavecookies56.kk.common.capability.ModCapabilities;
import uk.co.wehavecookies56.kk.common.capability.MunnyCapability;
import uk.co.wehavecookies56.kk.common.core.handler.ConfigHandler;
import uk.co.wehavecookies56.kk.common.lib.Reference;
import uk.co.wehavecookies56.kk.common.lib.Strings;
import uk.co.wehavecookies56.kk.common.util.Utils;

import java.io.IOException;

/**
 * Created by Toby on 19/07/2016.
 */
public class GuiShop extends GuiScreen {

    public int buySelected = -1;
    public int sellSelected = -1;
    private final GuiScreen parent;
    final int HOME = -1, BUY = 0, SELL = 1, BACK = 2, BUYCONFIRM = 3, PLUS = 4, MINUS = 5;
    final int QUANTITY = 0;
    int submenu = HOME;
    private GuiBuyList buyList;

    protected String title = Utils.translateToLocal(Strings.Gui_Shop_Main_Title);

    GuiButton buy, sell, back, buyConfirm, plus, minus;
    GuiNumberTextField quantity;

    public GuiShop(GuiScreen parent) {
        this.parent = parent;
    }


    public boolean canAffordItem(ItemStack stack) {
        //TODO
        return false;
    }

    @Override
    public void initGui() {
        this.buyList = new GuiBuyList(this);
        this.buyList.registerScrollButtons(this.buttonList, 7, 8);
        this.buttonList.add(back = new GuiButton(BACK, width - 105, height - ((height / 8) + 70 / 16), 100, 20, Utils.translateToLocal(Strings.Gui_Menu_Items_Button_Back)));
        this.buttonList.add(buy = new GuiButton(BUY, 5, 65, 100, 20, Utils.translateToLocal(Strings.Gui_Shop_Main_Buy)));
        this.buttonList.add(sell = new GuiButton(SELL, 5, 65 + 25, 100, 20, Utils.translateToLocal(Strings.Gui_Shop_Main_Sell)));
        this.buttonList.add(buyConfirm = new GuiButton(BUYCONFIRM, 100, 100, 100, 20, Utils.translateToLocal(Strings.Gui_Shop_Main_Buy)));
        this.buttonList.add(plus = new GuiButton(PLUS, 100, 120, 10, 10, "+"));
        this.buttonList.add(minus = new GuiButton(MINUS, 110, 120, 10, 10, "-"));
        updateButtons();
    }

    @Override
    public void drawScreen(int mouseX, int mouseY, float partialTicks) {
        drawDefaultBackground();
        drawBackground(width, height);
        if (submenu == BUY) {
            this.buyList.drawScreen(mouseX, mouseY, partialTicks);
            if (buySelected != -1) {
                buyList.drawBuySelected();
            }
        }
        super.drawScreen(mouseX, mouseY, partialTicks);
    }

    @Override
    protected void actionPerformed(GuiButton button) throws IOException {
        switch (button.id) {
            case BUY:
                submenu = BUY;
                break;
            case SELL:
                submenu = SELL;
                break;
            case BACK:
                submenu = HOME;
                buySelected = -1;
                sellSelected = -1;
                break;
            case BUYCONFIRM:

                break;
            case PLUS:

                break;
            case MINUS:

                break;
        }
        updateButtons();
    }

    public void updateButtons() {
        if (submenu == HOME) {
            back.enabled = false;
            back.visible = false;
            buy.visible = true;
            buy.enabled = true;
            sell.enabled = true;
            sell.visible = true;
            buyConfirm.visible = false;
            buyConfirm.enabled = false;
            plus.visible = false;
            minus.visible = false;
        } else if (submenu == BUY) {
            back.enabled = true;
            back.visible = true;
            buy.visible = false;
            buy.enabled = false;
            sell.enabled = false;
            sell.visible = false;
            if (buySelected != -1) {
                buyConfirm.visible = true;
                plus.visible = true;
                minus.visible = true;
            } else {
                buyConfirm.visible = false;
                plus.visible = false;
                minus.visible = false;
            }
        } else if (submenu == SELL) {
            back.enabled = true;
            back.visible = true;
            buy.visible = false;
            buy.enabled = false;
            sell.enabled = false;
            sell.visible = false;
        }
    }

    public static final ResourceLocation optionsBackground = new ResourceLocation(Reference.MODID, "textures/gui/menubg.png");

    public static String getWorldMinutes (World world) {
        int time = (int) Math.abs((world.getWorldTime() + 6000) % 24000);
        if ((time % 1000) * 6 / 100 < 10)
            return "0" + (time % 1000) * 6 / 100;
        else
            return Integer.toString((time % 1000) * 6 / 100);
    }

    public static int getWorldHours (World world) {
        int time = (int) Math.abs((world.getWorldTime() + 6000) % 24000);
        return (int) (time / 1000F);
    }

    protected void drawBackground (int screenWidth, int screenHeight) {
        Minecraft.getMinecraft().renderEngine.bindTexture(optionsBackground);
        GL11.glPushMatrix();
        {
            GL11.glColor3ub((byte) ConfigHandler.interfaceColour[0], (byte) ConfigHandler.interfaceColour[1], (byte) ConfigHandler.interfaceColour[2]);
            drawModalRectWithCustomSizedTexture(0, 0, 0, 0, screenWidth, 60, 32, 32);
            drawModalRectWithCustomSizedTexture(0, screenHeight - ((screenHeight / 8) + 70 / 16), 0, 0, screenWidth, 70, 32, 32);
        }
        GL11.glPopMatrix();
        GL11.glPushMatrix();
        {
            GL11.glScalef(2, 2, 2);
            drawString(fontRendererObj, title, 5, 5, 0xFFFFFF);
        }
        GL11.glPopMatrix();
        if (submenu == HOME) drawString(fontRendererObj, Utils.translateToLocal(Strings.Gui_Shop_Main), 15, 30, 0xFFFFFF);
        if (submenu == BUY) drawString(fontRendererObj, Utils.translateToLocal(Strings.Gui_Shop_Main_Buy), 15, 30, 0xFFFFFF);
        if (submenu == SELL) drawString(fontRendererObj, Utils.translateToLocal(Strings.Gui_Shop_Main_Sell), 15, 30, 0xFFFFFF);
        GL11.glPushMatrix();
        {
            drawString(fontRendererObj, mc.thePlayer.worldObj.provider.getDimensionType().getName(), screenWidth - fontRendererObj.getStringWidth(mc.thePlayer.worldObj.provider.getDimensionType().getName()) - 5, 5, 0xFFFFFF);
            drawString(fontRendererObj, mc.thePlayer.worldObj.getBiome(mc.thePlayer.getPosition()).getBiomeName(), screenWidth - fontRendererObj.getStringWidth(mc.thePlayer.worldObj.getBiome(mc.thePlayer.getPosition()).getBiomeName()) - 5, 20, 0xFFFFFF);
            drawString(fontRendererObj, Utils.translateToLocal(Strings.Gui_Menu_Main_Time) + ": " + getWorldHours(mc.theWorld) + ":" + getWorldMinutes(mc.theWorld), 5, screenHeight - ((screenHeight / 8) - 300 / 16), 0xFFFFFF);
            MunnyCapability.IMunny MUNNY = mc.thePlayer.getCapability(ModCapabilities.MUNNY, null);
            drawString(fontRendererObj, Utils.translateToLocal(Strings.Gui_Menu_Main_Munny) + ": " + MUNNY.getMunny(), 5, screenHeight - ((screenHeight / 8) - 100 / 16), 0xFFD000);
        }
        GL11.glPopMatrix();

    }

}
