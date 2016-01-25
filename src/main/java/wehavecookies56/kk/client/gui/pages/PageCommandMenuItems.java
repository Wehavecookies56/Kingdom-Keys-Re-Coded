package wehavecookies56.kk.client.gui.pages;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.ScaledResolution;

public class PageCommandMenuItems extends Page {

	String text = "\"Items\" is an option on the Command Menu which currently has no use. In the future it will act similarly to how it does in Kingdom Hearts 2.";

	public PageCommandMenuItems(int xPos, int yPos) {
		super("CommandMenu_Items", xPos, yPos);
		this.setxPos(xPos);
		this.setyPos(yPos);
	}

	@Override
	public void drawPageForeground(int width, int height) {
		super.drawPageForeground(width, height);
		FontRenderer fontRendererObj = Minecraft.getMinecraft().fontRendererObj;
		String[] count = text.split("\n");
	    fontRendererObj.drawSplitString(text, this.getxPos(), this.getyPos() + (fontRendererObj.FONT_HEIGHT * 2), (new ScaledResolution(Minecraft.getMinecraft())).getScaledWidth() - this.getxPos() - (fontRendererObj.FONT_HEIGHT * 2), 0xFFFFFF);
	    int length = fontRendererObj.splitStringWidth(text, (new ScaledResolution(Minecraft.getMinecraft())).getScaledWidth() - this.getxPos() - (fontRendererObj.FONT_HEIGHT * 2));
	    //fontRendererObj.drawString("TESTING SO THAT THIS IS ALWAYS AT THE BOTTOM.", this.getxPos(), (this.getyPos() + (fontRendererObj.FONT_HEIGHT * 2)) + length, 0xFFFFFF);
	}
}
