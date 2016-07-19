package uk.co.wehavecookies56.kk.client.gui;

import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.GuiTextField;
import org.lwjgl.input.Keyboard;

import java.io.IOException;

/**
 * Created by Toby on 19/07/2016.
 */
public class GuiShop extends GuiScreen {

    final int HOME = -1, BUY = 0, SELL = 1, BACK = 2;
    final int QUANTITY = 0;
    int submenu = HOME;

    GuiButton buy, sell, back;
    GuiNumberTextField quantity;

    public GuiShop() {

    }

    @Override
    public void initGui() {

    }

    @Override
    public void drawScreen(int mouseX, int mouseY, float partialTicks) {

        super.drawScreen(mouseX, mouseY, partialTicks);
    }

    @Override
    protected void actionPerformed(GuiButton button) throws IOException {
        switch (button.id) {
            case BUY:

                break;
            case SELL:

                break;
            case BACK:

                break;
        }
        super.actionPerformed(button);
    }
}
