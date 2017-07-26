package uk.co.wehavecookies56.kk.client.gui.pages;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.ScaledResolution;

/**
 * Created by NStel on 1/21/2017.
 */
public class PageKeybladeCreation extends Page{
    String text = "\"Keyblades\" can be created when you have all the need synthesis materials and the keyblade you have obtained from a synthesis recipe" +
            " to see what synthesis materials a keyblade rquires, right click a moogle click item synthesis and click the Recies tab" +
            " (see recipes in the Synthesistab for how to obtain them) ";

    public PageKeybladeCreation (int xPos, int yPos) {
        super("Keyblade_Creation", xPos, yPos);
        setxPos(xPos);
        setyPos(yPos);
    }

    @Override
    public void drawPageForeground (int width, int height) {
        super.drawPageForeground(width, height);
        FontRenderer fontRendererObj = Minecraft.getMinecraft().fontRenderer;
        String[] count = text.split("\n");
        fontRendererObj.drawSplitString(text, getxPos(), getyPos() + (fontRendererObj.FONT_HEIGHT * 2), (new ScaledResolution(Minecraft.getMinecraft())).getScaledWidth() - getxPos() - (fontRendererObj.FONT_HEIGHT * 2), 0xFFFFFF);
        //int length = fontRendererObj.splitStringWidth(text, (new ScaledResolution(Minecraft.getMinecraft())).getScaledWidth() - getxPos() - (fontRendererObj.FONT_HEIGHT * 2));
        // fontRendererObj.drawString("TESTING SO THAT THIS IS ALWAYS AT THE
        // BOTTOM.", this.getxPos(), (this.getyPos() +
        // (fontRendererObj.FONT_HEIGHT * 2)) + length, 0xFFFFFF);
    }
}
