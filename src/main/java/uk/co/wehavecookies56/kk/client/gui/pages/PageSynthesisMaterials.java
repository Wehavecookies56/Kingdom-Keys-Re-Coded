package uk.co.wehavecookies56.kk.client.gui.pages;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.ScaledResolution;

/**
 * Created by NStel on 1/22/2017.
 */
public class PageSynthesisMaterials extends Page
{
    String text = "\"Materials\" are what you obtain through ores or finding them in the generated chests. " +
            "You use them to make the keyblades, organization XIII weapons, or the crafting materials for the keyblade armor" +
            " to deposit them use the material tab within the moogle's gui\n"
            +"(for more info on the crafting materials see Crafting materials in the MISC tab)" +
            "\n(for more info on how to obtain the organization XIII weapons see organization weapoms in the MISC tab";

    public PageSynthesisMaterials (int xPos, int yPos) {
        super("Synthesis_Materials", xPos, yPos);
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
} // end PageSynthesisMaterials
