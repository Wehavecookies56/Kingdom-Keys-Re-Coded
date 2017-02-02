package uk.co.wehavecookies56.kk.client.gui.pages;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.ScaledResolution;

/**
 * Created by NStel on 1/22/2017.
 */
public class PageMiscCraftingMaterials extends Page{
    String text = "\"Crafting Materials\" are what you use to make the Organization XIII armour, Keyblade armour, and the Knowledge books which are used to obtain the Organization XIII weapons." +
            "\n Dark-Infused Iron Ingot = Dark Crystal + Iron Ingot" +
            "\n Bright-Infused Glowstone Dust = Bright Crystal + Glowstone Dust" +
            "\n Stormy-Infused Iron Ingot = Stormy Crystal + Iron Ingot" +
            "\n Mythril-Infused Diamond = Mythril Crystal + Diamond" +
            "\n Lightig-Infused Gold Infused = Lighting Crystal + Gold Ingot" +
            "\n Frost-Infusted Snowball = Frost Crystal + Snowball" +
            "\n Blazing-Infused Coal = Blazing Crystal + Coal";

    public PageMiscCraftingMaterials (int xPos, int yPos) {
        super("Misc_CraftingMaterials", xPos, yPos);
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
