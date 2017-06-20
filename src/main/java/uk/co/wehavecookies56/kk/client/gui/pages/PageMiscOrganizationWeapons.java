package uk.co.wehavecookies56.kk.client.gui.pages;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.ScaledResolution;

/**
 * Created by NStel on 1/22/2017.
 */
public class PageMiscOrganizationWeapons extends Page{
    String text = "The organization weapons can be obtained by wearing the full organization armour once you craft it put it on. \nThen the mod will prompt you to choose the member you want to be." +
            " \nThen to bring up the gui to obtain a weapon you must craft the knowledge that never was. \nNOTE: You lose your organization status on death." +
            "\nSHAPELESS CRAFTING RECIPE: \nThe Knowledge That Never Was = DarkLeather, FrostCrystal, BlazingCrystal, LightningCrystal, MythrilCrystal, StormyCrystal, DarkCrystal, Book,  LostIllusion.";
    public PageMiscOrganizationWeapons (int xPos, int yPos) {
        super("Misc_OrganizationWeapons", xPos, yPos);
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
