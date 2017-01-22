package uk.co.wehavecookies56.kk.client.gui.pages;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.ScaledResolution;

/**
 * Created by NStel on 1/22/2017.
 */
public class PageDriveFormsDP extends Page{
    String text = "\"Keyblades\" you can summon when you obtain the keychain from the moogle after crafting it." +
            " Inorder to summon it one must put the keychain in the keychain slot within the items tab and then pressing the keybind to summon it.";

    public PageDriveFormsDP (int xPos, int yPos) {
        super("DriveForms_DP", xPos, yPos);
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
