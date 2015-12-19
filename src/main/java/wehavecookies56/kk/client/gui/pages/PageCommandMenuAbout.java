package wehavecookies56.kk.client.gui.pages;

import org.lwjgl.opengl.GL11;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.util.ResourceLocation;
import wehavecookies56.kk.client.gui.GuiJournal;
import wehavecookies56.kk.lib.Reference;

public class PageCommandMenuAbout extends Page {

	String text = "The Command Menu is the menu displayed in the bottom left corner of the HUD. It has 4 options, Attack, Magic, Items and Drive, for info on these options refer to their respective pages.\n\nThe menu can be navigated using the Command Menu keybinds (default: Arrow keys) it can also be navigated by holding the hold keybind (default: Alt) and scrolling the mouse wheel, left click to enter, right click to go back.";

	public PageCommandMenuAbout(int xPos, int yPos) {
		super("CommandMenu_About", xPos, yPos);
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
