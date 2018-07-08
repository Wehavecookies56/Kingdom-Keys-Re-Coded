package uk.co.wehavecookies56.kk.client.gui;

import java.awt.Color;

import javax.annotation.Nonnull;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.util.ResourceLocation;
import uk.co.wehavecookies56.kk.common.lib.Reference;

class GuiButtonCheckBox extends GuiButton {

    private boolean checked;

    GuiButtonCheckBox(int buttonId, int x, int y, String buttonText) {
        super(buttonId, x, y, 10, 10, buttonText);
    }

    @Override
    public void drawButton(@Nonnull Minecraft mc, int mouseX, int mouseY, float partialTicks) {
        if (visible) {
            mc.renderEngine.bindTexture(new ResourceLocation(Reference.MODID, "textures/gui/checkbox.png"));
            drawTexturedModalRect(x, y, 0, 0, 10, 10);
            if (checked) {
                drawTexturedModalRect(x, y, 10, 0, 10, 10);
            }
            drawString(mc.fontRenderer, displayString, x + width + 3, y + 2, new Color(255, 255, 255).hashCode());
        }
    }

    @Override
    public int getButtonWidth() {
        return super.getButtonWidth() + 3 + Minecraft.getMinecraft().fontRenderer.getStringWidth(displayString);
    }

    boolean isChecked() {
        return checked;
    }
    
    void setChecked(boolean check) {
    	this.checked = check;
    }

    @Override
    public boolean mousePressed(Minecraft mc, int mouseX, int mouseY) {
        if (enabled && visible) {
            if (mouseX >= this.x && mouseY >= this.y && mouseX < this.x + this.getButtonWidth() && mouseY < this.y + this.height) {
                checked = !checked;
            }
            return mouseX >= this.x && mouseY >= this.y && mouseX < this.x + this.getButtonWidth() && mouseY < this.y + this.height;
        }
        return false;
    }
}