package uk.co.wehavecookies56.kk.client.gui.redesign;

import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import uk.co.wehavecookies56.kk.client.gui.GuiMenu_Bars;

import java.io.IOException;

public class GuiCustomize extends GuiScreen {

    GuiMenu_Bars background;

    public GuiCustomize() {
        this.background = new GuiMenu_Bars("Customize");
    }

    @Override
    public void drawScreen(int mouseX, int mouseY, float partialTicks) {
        background.drawBars();
        background.drawBiomeDim();
        background.drawMunnyTime();
        super.drawScreen(mouseX, mouseY, partialTicks);
    }

    @Override
    public void initGui() {
        background.width = width;
        background.height = height;
        background.init();
        super.initGui();
    }

    @Override
    protected void actionPerformed(GuiButton button) throws IOException {
        super.actionPerformed(button);
    }
}
