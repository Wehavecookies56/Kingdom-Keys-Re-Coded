package wehavecookies56.kk.client.gui.pages;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.ScaledResolution;

public class Page extends GuiScreen {

	String name;
	int xPos, yPos;

	ScaledResolution res;

	public Page(String name, int xPos, int yPos) {
		this.name = name;
		this.xPos = xPos;
		this.yPos = yPos;
		res = new ScaledResolution(Minecraft.getMinecraft(), Minecraft.getMinecraft().displayWidth, Minecraft.getMinecraft().displayHeight);
	}

	@Override
	public void drawScreen(int mouseX, int mouseY, float partialTicks) {
		this.drawPageBackground(res.getScaledWidth(), res.getScaledHeight());
		this.drawPageForeground(res.getScaledWidth(), res.getScaledHeight());
		super.drawScreen(mouseX, mouseY, partialTicks);
	}

	@Override
	public void initGui() {
		res = new ScaledResolution(Minecraft.getMinecraft(), Minecraft.getMinecraft().displayWidth, Minecraft.getMinecraft().displayHeight);
		super.initGui();
	}

	public void drawPageForeground(int width, int height){
		this.drawString(Minecraft.getMinecraft().fontRendererObj, name, xPos, yPos, 0xFFFFFF);
	}

	public void drawPageBackground(int width, int height){

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
