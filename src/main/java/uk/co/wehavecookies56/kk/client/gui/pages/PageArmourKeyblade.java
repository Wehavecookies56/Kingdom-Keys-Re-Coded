package uk.co.wehavecookies56.kk.client.gui.pages;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.ScaledResolution;

/**
 * Created by NStel on 1/22/2017.
 */
public class PageArmourKeyblade extends Page {
    String text = "Keyblade armour are sets of craftable armour that can be worn. There are Four sets of Keyblade armour, Ventus, Terra, Aqua, and Eraqus." +
            " If you have questions on the crafting materials please refer to the crafting materials in the journal.";

    public PageArmourKeyblade (int xPos, int yPos) {
        super("Armour_Keyblade", xPos, yPos);
        setxPos(xPos);
        setyPos(yPos);
    }

    @Override
    public void drawPageForeground (int width, int height) {
        super.drawPageForeground(width, height);
        FontRenderer fontRendererObj = Minecraft.getMinecraft().fontRendererObj;
        String[] count = text.split("\n");
        fontRendererObj.drawSplitString(text, getxPos(), getyPos() + (fontRendererObj.FONT_HEIGHT * 2), (new ScaledResolution(Minecraft.getMinecraft())).getScaledWidth() - getxPos() - (fontRendererObj.FONT_HEIGHT * 2), 0xFFFFFF);
        int length = fontRendererObj.splitStringWidth(text, (new ScaledResolution(Minecraft.getMinecraft())).getScaledWidth() - getxPos() - (fontRendererObj.FONT_HEIGHT * 2));
        // fontRendererObj.drawString("TESTING SO THAT THIS IS ALWAYS AT THE
        // BOTTOM.", this.getxPos(), (this.getyPos() +
        // (fontRendererObj.FONT_HEIGHT * 2)) + length, 0xFFFFFF);
    }
}
