package wehavecookies56.kk.client.gui.pages;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.ScaledResolution;

public class PageCommandMenuAbout extends Page {

	public PageCommandMenuAbout(int xPos, int yPos) {
		super("About", xPos, yPos);
		this.setxPos(xPos);
		this.setyPos(yPos);
	}

	@Override
	public void drawPageForeground(int width, int height) {
		super.drawPageForeground(width, height);
		Minecraft.getMinecraft().fontRendererObj.drawSplitString("Test Page, So nothing useful will be displayed here. Don't expect this to display anything of value as it will be a waste of time. This is here just to test the pages and how much can fit depending on the size of the screen.\n\nAlso testing new lines for paragraphs to organize information to be displayed here so people know how to do things in the mod. \n\nSo yeah this is pointless but helpful at the same time. Kinda weird that this is actually helpful in a way when it's so pointless at the same time and will be deleted anyway. With a 1080p screen this barely even takes up much of the space. So the scroll bar may not be that helpful a lot of the time but of course will be needed sometimes. \n\nMaking sure everything is viewable on multiple resolutions is pretty important so that anyone can use the mod and have the same experience even though their screen resolution may not be a standard. \n\nSo finally this text goes off the screen on a small screen size luckily the width is easily handled.", this.getxPos(), this.getyPos() + 10, (new ScaledResolution(Minecraft.getMinecraft(), Minecraft.getMinecraft().displayWidth, Minecraft.getMinecraft().displayHeight)).getScaledWidth() - this.getxPos() - 10, 0xFFFFFF);
	}
}
