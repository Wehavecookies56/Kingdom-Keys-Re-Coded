package uk.co.wehavecookies56.kk.client.gui;

import java.io.IOException;

import org.lwjgl.opengl.GL11;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import uk.co.wehavecookies56.kk.api.munny.MunnyRegistry;
import uk.co.wehavecookies56.kk.common.capability.ModCapabilities;
import uk.co.wehavecookies56.kk.common.capability.MunnyCapability;
import uk.co.wehavecookies56.kk.common.core.handler.MainConfig;
import uk.co.wehavecookies56.kk.common.core.handler.event.ItemEvents;
import uk.co.wehavecookies56.kk.common.lib.Reference;
import uk.co.wehavecookies56.kk.common.lib.Strings;
import uk.co.wehavecookies56.kk.common.network.packet.PacketDispatcher;
import uk.co.wehavecookies56.kk.common.network.packet.server.GiveBoughtItem;
import uk.co.wehavecookies56.kk.common.network.packet.server.OpenSynthesis;
import uk.co.wehavecookies56.kk.common.network.packet.server.TakeSoldItem;
import uk.co.wehavecookies56.kk.common.util.Utils;

/**
 * Created by Toby on 19/07/2016.
 */
public class GuiShop extends GuiScreen {

    public int buySelected = -1;
    public int sellSelected = -1;
    private final GuiScreen parent;
    final int HOME = -1, BUY = 0, SELL = 1, BACK = 2, BUYCONFIRM = 3, PLUS = 4, MINUS = 5, SYNTHESIS = 6, SELLCONFIRM = 4;
    final int QUANTITY = 0;
    int submenu = HOME;
    private GuiBuyList buyList;
    private GuiSellList sellList;

    protected String title = Utils.translateToLocal(Strings.Gui_Shop_Main_Title);

    GuiButton buy, sell, back, buyConfirm, plus, minus, synthesis, sellConfirm;
    GuiNumberTextField quantity;

    public GuiShop(GuiScreen parent) {
        this.parent = parent;
    }

    public int getPriceFromSelected(int index, boolean selling, int amount) {
        if (index != -1 && !(index > GuiBuyList.itemsForSale.size())) {
            for (ItemStack stack : MunnyRegistry.munnyValues.keySet()) {
                if (!selling) {
                    if (ItemEvents.areItemStacksEqual(stack, GuiBuyList.itemsForSale.get(index))) {
                        return MunnyRegistry.munnyValues.get(stack) * amount;
                    }
                } else {
                    if (ItemEvents.areItemStacksEqual(stack, GuiSellList.sellableItems.get(index))) {
                        return MunnyRegistry.munnyValues.get(stack) * amount;
                    }
                }

            }
        } else {
            return 0;
        }
        return 0;
    }

    @Override
    public boolean doesGuiPauseGame() {
        return false;
    }

    public boolean canAffordSelected() {
       if (buySelected != -1) {
            if (Minecraft.getMinecraft().player.getCapability(ModCapabilities.MUNNY, null).getMunny() >= getPriceFromSelected(buySelected, false, Integer.parseInt(quantity.getText()))) {
                return true;
            } else {
                return false;
            }
        }
        return false;
    }

    private boolean isInventoryFull () {
        EntityPlayer player = Minecraft.getMinecraft().player;
        boolean full = false;
        for (ItemStack element : player.inventory.mainInventory) {
            if (element != ItemStack.EMPTY && element.getItem() != Items.AIR)
            	full = true;
            if (element == ItemStack.EMPTY || element.getItem() == Items.AIR) 
            	return false;
        }
        if (full)
        	return true;
        return false;
    }

    @Override
    public void initGui() {
        this.buyList = new GuiBuyList(this);
        this.buyList.registerScrollButtons(this.buttonList, 7, 8);
        this.sellList = new GuiSellList(this);
        this.sellList.registerScrollButtons(this.buttonList, 7, 8);
        this.buttonList.add(back = new GuiButton(BACK, width - 105, height - ((height / 8) + 70 / 16), 100, 20, Utils.translateToLocal(Strings.Gui_Menu_Items_Button_Back)));
        this.buttonList.add(buy = new GuiButton(BUY, 5, 65, 100, 20, Utils.translateToLocal(Strings.Gui_Shop_Main_Buy)));
        this.buttonList.add(sell = new GuiButton(SELL, 5, 65 + 25, 100, 20, Utils.translateToLocal(Strings.Gui_Shop_Main_Sell)));
        this.buttonList.add(buyConfirm = new GuiButton(BUYCONFIRM, 220, height - ((height / 8) + 70 / 16) - 25, 100, 20, Utils.translateToLocal(Strings.Gui_Shop_Main_Buy)));
        this.buttonList.add(sellConfirm = new GuiButton(SELLCONFIRM, 220, height - ((height / 8) + 70 / 16) - 25, 100, 20, Utils.translateToLocal(Strings.Gui_Shop_Main_Sell)));
        //this.buttonList.add(plus = new GuiButton(PLUS, 100, 120, 10, 10, "+"));
        //this.buttonList.add(minus = new GuiButton(MINUS, 110, 120, 10, 10, "-"));
        this.buttonList.add(synthesis = new GuiButton(SYNTHESIS, 5, 90 + 25, 100, 20, Utils.translateToLocal(Strings.Gui_Synthesis_Main_Title)));
        quantity = new GuiNumberTextField(QUANTITY, Minecraft.getMinecraft().fontRenderer, 222, height - ((height / 8) + 70 / 16) - 45, 20, 15, 64);
        quantity.setText("0");
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
        } else if (submenu == SELL) {
            this.sellList.drawScreen(mouseX, mouseY, partialTicks);
            if (sellSelected != -1) {
                sellList.drawSellSelected();
            }
        }
        quantity.drawTextBox();
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
                if (buySelected != -1) {
                    if (canAffordSelected()) {
                        ItemStack stack = GuiBuyList.itemsForSale.get(buySelected);
                        if (!quantity.getText().isEmpty())
                            stack.setCount(Integer.parseInt(quantity.getText()));
                        PacketDispatcher.sendToServer(new GiveBoughtItem(getPriceFromSelected(buySelected, false, Integer.parseInt(quantity.getText())), stack.getCount(), stack));
                        buySelected = -1;
                        quantity.setText("0");
                    }
                }
                break;
            case SELLCONFIRM:
                if (sellSelected != -1) {
                    int amount = 0;
                    if (!quantity.getText().isEmpty())
                        amount = Integer.parseInt(quantity.getText());
                    PacketDispatcher.sendToServer(new TakeSoldItem(getPriceFromSelected(sellSelected, true, Integer.parseInt(quantity.getText())) / 2, amount, GuiSellList.sellableItems.get(sellSelected)));
                    sellSelected = -1;
                    quantity.setText("0");
                }
                sellList.occupyList();
                break;
            case SYNTHESIS:
                PacketDispatcher.sendToServer(new OpenSynthesis());
                Minecraft.getMinecraft().displayGuiScreen(new GuiSynthesis(this));
                break;
        }
        updateButtons();
    }

    @Override
    protected void keyTyped(char typedChar, int keyCode) throws IOException {
        quantity.textboxKeyTyped(typedChar, keyCode);
        updateButtons();
        super.keyTyped(typedChar, keyCode);
    }

    @Override
    protected void mouseClicked(int mouseX, int mouseY, int mouseButton) throws IOException {
        quantity.mouseClicked(mouseX, mouseY, mouseButton);
        super.mouseClicked(mouseX, mouseY, mouseButton);
    }

    @Override
    public void updateScreen() {
        quantity.updateCursorCounter();
        if (submenu == SELL)
            sellList.occupyList();
        super.updateScreen();
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
            sellConfirm.visible = false;
            sellConfirm.enabled = false;
            //plus.visible = false;
            //minus.visible = false;
            synthesis.visible = true;
            synthesis.enabled = true;
            quantity.setVisible(false);
        } else if (submenu == BUY) {
            int munny = Minecraft.getMinecraft().player.getCapability(ModCapabilities.MUNNY, null).getMunny();
            if (getPriceFromSelected(buySelected, false, 1) == 0) {
                quantity.setMaxValue(64);
            } else {
                int numberAffordable = munny / getPriceFromSelected(buySelected, false, 1);
                if (numberAffordable > 64) {
                    quantity.setMaxValue(64);
                } else {
                    quantity.setMaxValue(numberAffordable);
                }
            }
            back.enabled = true;
            back.visible = true;
            buy.visible = false;
            buy.enabled = false;
            sell.enabled = false;
            sell.visible = false;
            synthesis.visible = false;
            synthesis.enabled = false;
            sellConfirm.visible = false;
            sellConfirm.enabled = false;
            if (buySelected != -1) {
                buyConfirm.visible = true;
                //plus.visible = true;
                //minus.visible = true;
                quantity.setVisible(true);
                if (!isInventoryFull()) {
                    if (!quantity.getText().isEmpty()) {
                        if (Integer.parseInt(quantity.getText()) > 0) {
                            if (canAffordSelected()) {
                                buyConfirm.enabled = true;
                            } else {
                                buyConfirm.enabled = false;
                            }
                        } else {
                            buyConfirm.enabled = false;
                        }
                    } else {
                        buyConfirm.enabled = false;
                    }
                } else {
                    buyConfirm.enabled = false;
                }
            } else {
                quantity.setVisible(false);
                buyConfirm.visible = false;
                //plus.visible = false;
                //minus.visible = false;
            }
        } else if (submenu == SELL) {
            if (sellSelected != -1) {
                if (!quantity.getText().isEmpty()) {
                    sellList.occupyList();
                    quantity.setMaxValue(sellList.stackSizes.get(sellSelected));
                    sellConfirm.visible = true;
                    quantity.setVisible(true);
                    if (Integer.parseInt(quantity.getText()) > 0) {
                        sellConfirm.enabled = true;
                    } else {
                        sellConfirm.enabled = false;
                    }
                } else {
                    sellConfirm.enabled = false;
                }
            } else {
                quantity.setVisible(false);
                sellConfirm.visible = false;
                //plus.visible = false;
                //minus.visible = false;
            }
            back.enabled = true;
            back.visible = true;
            buy.visible = false;
            buy.enabled = false;
            sell.enabled = false;
            sell.visible = false;
            synthesis.visible = false;
            synthesis.enabled = false;
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
            GL11.glColor3ub((byte) MainConfig.client.hud.interfaceColour[0], (byte) MainConfig.client.hud.interfaceColour[1], (byte) MainConfig.client.hud.interfaceColour[2]);
            drawModalRectWithCustomSizedTexture(0, 0, 0, 0, screenWidth, 60, 32, 32);
            drawModalRectWithCustomSizedTexture(0, screenHeight - ((screenHeight / 8) + 70 / 16), 0, 0, screenWidth, 70, 32, 32);
        }
        GL11.glPopMatrix();
        GL11.glPushMatrix();
        {
            GL11.glScalef(2, 2, 2);
            drawString(fontRenderer, title, 5, 5, 0xFFFFFF);
        }
        GL11.glPopMatrix();
        if (submenu == HOME) drawString(fontRenderer, Utils.translateToLocal(Strings.Gui_Shop_Main), 15, 30, 0xFFFFFF);
        if (submenu == BUY) drawString(fontRenderer, Utils.translateToLocal(Strings.Gui_Shop_Main_Buy), 15, 30, 0xFFFFFF);
        if (submenu == SELL) drawString(fontRenderer, Utils.translateToLocal(Strings.Gui_Shop_Main_Sell), 15, 30, 0xFFFFFF);
        GL11.glPushMatrix();
        {
            drawString(fontRenderer, mc.player.world.provider.getDimensionType().getName(), screenWidth - fontRenderer.getStringWidth(mc.player.world.provider.getDimensionType().getName()) - 5, 5, 0xFFFFFF);
            drawString(fontRenderer, mc.player.world.getBiome(mc.player.getPosition()).getBiomeName(), screenWidth - fontRenderer.getStringWidth(mc.player.world.getBiome(mc.player.getPosition()).getBiomeName()) - 5, 20, 0xFFFFFF);
            drawString(fontRenderer, Utils.translateToLocal(Strings.Gui_Menu_Main_Time) + ": " + getWorldHours(mc.world) + ":" + getWorldMinutes(mc.world), 5, screenHeight - ((screenHeight / 8) - 300 / 16), 0xFFFFFF);
            MunnyCapability.IMunny MUNNY = mc.player.getCapability(ModCapabilities.MUNNY, null);
            drawString(fontRenderer, Utils.translateToLocal(Strings.Gui_Menu_Main_Munny) + ": " + MUNNY.getMunny(), 5, screenHeight - ((screenHeight / 8) - 100 / 16), 0xFFD000);
        }
        GL11.glPopMatrix();

    }

}
