package uk.co.wehavecookies56.kk.client.gui.pages;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.ScaledResolution;
import uk.co.wehavecookies56.kk.common.lib.Strings;
import uk.co.wehavecookies56.kk.common.util.Utils;

public class PageCommandMenuAbout extends Page {

	String text = Utils.translateToLocal(Strings.CommandMenuAbout);

	public PageCommandMenuAbout (int xPos, int yPos) {
		super("CommandMenu_About", xPos, yPos);
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
