package uk.co.wehavecookies56.kk.client.gui.pages;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.ScaledResolution;

/**
 * Created by NStel on 1/22/2017.
 */
public class PageMiscOrganizationWeapons extends Page{
    String text = "The organization can be obtained by right clicking with a " +
            "manifest knowledge. The knowledge can obtained by by the other knowledge books. The recipies are as in order from top to bottom as they will be crafting" +
            "\n  Void Knowledge = book + 8 dark leather surrounding the book" +
            "\n  Abandoned Knowledge = Void Knowledge + 1 Lost Illusion" +
            "\n  Dark Knowledge = Void Knowledge + 1 Lost Illusion"+
            "\n  Eclipsed Knowledge = Dark Knowledge + + 1 Lost Illusion"+
            "\n  Forgotten Knowledge = Eclipsed Knowledge + + 1 Lost Illusion"+
            "\n  Illuded Knowledge  = Forgotten Knowledge + 1 Lost Illusion"+
            "\n  Lost Knowledge = Illuded Knowledge + 1 Lost Illusion"+
            "\n  Obscured Knowledge = Lost Knowledge + 1 Lost Illusion"+
            "\n  Unknown Knowledge = Obscured Knowledge + 1 Lost Illusion"+
            "\n  Manifest Knowledge = Unknown Knowledge + 1 Lost Illusion";

    public PageMiscOrganizationWeapons (int xPos, int yPos) {
        super("Misc_OrganizationWeapons", xPos, yPos);
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
