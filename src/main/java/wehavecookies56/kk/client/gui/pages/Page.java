package wehavecookies56.kk.client.gui.pages;

import org.lwjgl.opengl.GL11;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.ResourceLocation;
import wehavecookies56.kk.lib.Reference;

public class Page extends GuiScreen {

	String name;
	int xPos, yPos;

	ScaledResolution res;

	public Page(String name, int xPos, int yPos) {
		this.name = name;
		this.xPos = xPos;
		this.yPos = yPos;
		res = new ScaledResolution(Minecraft.getMinecraft());
	}

	@Override
	public void drawScreen(int mouseX, int mouseY, float partialTicks) {
		this.drawPageBackground(res.getScaledWidth(), res.getScaledHeight());
		this.drawPageForeground(res.getScaledWidth(), res.getScaledHeight());
		super.drawScreen(mouseX, mouseY, partialTicks);
	}

	@Override
	public void initGui() {
		res = new ScaledResolution(Minecraft.getMinecraft());
		super.initGui();
	}

	public void drawPageForeground(int width, int height){
		this.drawString(Minecraft.getMinecraft().fontRendererObj, name.substring(name.lastIndexOf("_") + 1) + EnumChatFormatting.UNDERLINE + EnumChatFormatting.BOLD, xPos, yPos, 0xFFFFFF);
	}

	public void drawPageBackground(int width, int height){
		FontRenderer fontRendererObj = Minecraft.getMinecraft().fontRendererObj;
		drawBG(new ResourceLocation(Reference.MODID, "textures/gui/journal.png"), this.getxPos() - 5, this.getyPos() - 5, (new ScaledResolution(Minecraft.getMinecraft())).getScaledWidth() - this.getxPos() - (fontRendererObj.FONT_HEIGHT * 2) + 5, (new ScaledResolution(Minecraft.getMinecraft())).getScaledHeight() - this.getyPos() - (fontRendererObj.FONT_HEIGHT * 2) + 5, 1F);
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getxPos() {
		return xPos;
	}

	public void setxPos(int xPos) {
		this.xPos = xPos;
	}

	public int getyPos() {
		return yPos;
	}

	public void setyPos(int yPos) {
		this.yPos = yPos;
	}

	public int getWidth() {
		return res.getScaledWidth();
	}

	public int getHeight() {
		return res.getScaledHeight();
	}

}
