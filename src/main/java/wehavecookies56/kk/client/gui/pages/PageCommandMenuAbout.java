package wehavecookies56.kk.client.gui.pages;

import org.lwjgl.opengl.GL11;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.util.ResourceLocation;
import wehavecookies56.kk.client.gui.GuiJournal;
import wehavecookies56.kk.lib.Reference;

public class PageCommandMenuAbout extends Page {

	String text = "Test Page, So nothing useful will be displayed here. Don't expect this to display anything of value as it will be a waste of time. This is here just to test the pages and how much can fit depending on the size of the screen.\n\nAlso testing new lines for paragraphs to organize information to be displayed here so people know how to do things in the mod. \n\nSo yeah this is pointless but helpful at the same time. Kinda weird that this is actually helpful in a way when it's so pointless at the same time and will be deleted anyway. With a 1080p screen this barely even takes up much of the space. So the scroll bar may not be that helpful a lot of the time but of course will be needed sometimes. \n\nMaking sure everything is viewable on multiple resolutions is pretty important so that anyone can use the mod and have the same experience even though their screen resolution may not be a standard. \n\nSo finally this text goes off the screen on a small screen size luckily the width is easily handled.";

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
	    fontRendererObj.drawSplitString(text, this.getxPos(), this.getyPos() + (fontRendererObj.FONT_HEIGHT * 2), (new ScaledResolution(Minecraft.getMinecraft(), Minecraft.getMinecraft().displayWidth, Minecraft.getMinecraft().displayHeight)).getScaledWidth() - this.getxPos() - (fontRendererObj.FONT_HEIGHT * 2), 0xFFFFFF);
	    int length = fontRendererObj.splitStringWidth(text, (new ScaledResolution(Minecraft.getMinecraft(), Minecraft.getMinecraft().displayWidth, Minecraft.getMinecraft().displayHeight)).getScaledWidth() - this.getxPos() - (fontRendererObj.FONT_HEIGHT * 2));
	    fontRendererObj.drawString("TESTING SO THAT THIS IS ALWAYS AT THE BOTTOM.", this.getxPos(), (this.getyPos() + (fontRendererObj.FONT_HEIGHT * 2)) + length, 0xFFFFFF);
	}

	@Override
	public void drawPageBackground(int width, int height) {
		FontRenderer fontRendererObj = Minecraft.getMinecraft().fontRendererObj;
		drawBG(new ResourceLocation(Reference.MODID, "textures/gui/journal.png"), this.getxPos() - 5, this.getyPos() - 5, (new ScaledResolution(Minecraft.getMinecraft(), Minecraft.getMinecraft().displayWidth, Minecraft.getMinecraft().displayHeight)).getScaledWidth() - this.getxPos() - (fontRendererObj.FONT_HEIGHT * 2) + 5, (new ScaledResolution(Minecraft.getMinecraft(), Minecraft.getMinecraft().displayWidth, Minecraft.getMinecraft().displayHeight)).getScaledHeight() - this.getyPos() - (fontRendererObj.FONT_HEIGHT * 2) + 5, 1F);
		super.drawPageBackground(width, height);
	}

	public void drawBG(ResourceLocation res, int posX, int posY, int width, int height, float scale){
		Minecraft.getMinecraft().renderEngine.bindTexture(res);
		GL11.glPushMatrix();{
			GL11.glEnable(GL11.GL_BLEND);
            GL11.glColor4f(1.0F, 1.0F, 1.0F, 0.5F);
			GL11.glDisable(GL11.GL_BLEND);
			GL11.glPushMatrix();{
				GL11.glTranslatef(posX*scale, posY*scale, 0);
				GL11.glScalef(scale, height + 2, 0);
				drawTexturedModalRect(0, 0, 0, 0, 1, 1);
			}GL11.glPopMatrix();

			GL11.glPushMatrix();{
				GL11.glTranslatef((posX + 1)*scale, (posY + 1)*scale, 0);
				GL11.glScalef(width, height, 0);
				drawTexturedModalRect(0, 0, 1, 1, 1, 1);
			}GL11.glPopMatrix();

			GL11.glPushMatrix();{
				GL11.glTranslatef((posX + 1)*scale, posY*scale, 0);
				GL11.glScalef(width, scale, 0);
				drawTexturedModalRect(0, 0, 1, 0, 1, 1);
			}GL11.glPopMatrix();

			GL11.glPushMatrix();{
				GL11.glTranslatef((posX + 1)*scale, height + scale + posY, 0);
				GL11.glScalef(width, scale, 0);
				drawTexturedModalRect(0, 0, 1, 7, 1, 1);
			}GL11.glPopMatrix();

			GL11.glPushMatrix();{
				GL11.glTranslatef(width + scale + posX, posY*scale, 0);
				GL11.glScalef(scale, height + 2, 0);
				drawTexturedModalRect(0, 0, 2, 0, 1, 1);
			}GL11.glPopMatrix();
		}GL11.glPopMatrix();
	}
}
