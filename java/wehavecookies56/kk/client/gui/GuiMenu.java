package wehavecookies56.kk.client.gui;

import org.lwjgl.opengl.GL11;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.GuiScreen;

public class GuiMenu extends GuiScreen {

	public GuiMenu() {
	}
	
	@Override
	public void drawScreen(int mouseX, int mouseY, float partialTicks) {
		
	}
	
	@Override
	public void drawBackground(int tint) {
		Minecraft.getMinecraft().renderEngine.bindTexture(Gui.optionsBackground);
        GL11.glColor4f(0.3F, 0.3F, 0.3F, 1.0F);
        drawTexturedModalRect(0, 0, 0, 0, 16, 16);
	}
	
}
