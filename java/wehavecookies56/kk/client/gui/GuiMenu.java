package wehavecookies56.kk.client.gui;

import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL12;
import org.omg.CORBA.REBIND;

import wehavecookies56.kk.lib.Reference;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.AbstractClientPlayer;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.chunk.Chunk;

public class GuiMenu extends GuiScreen {

	public GuiMenu() {
	
	}
	
	//ResourceLocation skin = ((AbstractClientPlayer) mc.thePlayer).getLocationSkin();
	@Override
	public void drawScreen(int mouseX, int mouseY, float partialTicks) {
		/*
		GL11.glEnable(GL11.GL_COLOR_MATERIAL);
		GL11.glPushMatrix();
		GL11.glTranslatef((float)35, (float)120, 50.0F);
		GL11.glScalef((float)(-30), (float)30, (float)30);
		//GL11.glRotatef(135.0F, 0.0F, 1.0F, 0.0F);
		//RenderHelper.disableStandardItemLighting();
		GL11.glTranslatef(0.0F, mc.thePlayer.renderOffsetY, 0.0F);
		//mc.getRenderManager().playerViewY = 180.0F;
		GL11.glPushMatrix();
		GL11.glRotatef(180, 0, 0, 1);
		//GL11.glRotatef(rotate, 0, 1, 0);
		RenderHelper.disableStandardItemLighting();
		GL11.glDisable(GL11.GL_LIGHTING);
		mc.getRenderManager().renderEntityWithPosYaw(mc.thePlayer, 0.0D, 0.0D, 0.0D, 0.0F, 0.0F);
		GL11.glPopMatrix();
		GL11.glPopMatrix();
		*/
		RenderHelper.disableStandardItemLighting();
		drawBackground(width, height);

		
	}

	public static final ResourceLocation optionsBackground = new ResourceLocation(Reference.MODID, "textures/gui/menubg.png");

    
    @Override
    public void initGui() {
    	//System.out.println(mc.displayHeight + "/" + height);
    	System.out.println(height - ((height/8)+70/16));
    }
	protected void drawBackground(int screenWidth, int screenHeight) {
		Minecraft.getMinecraft().renderEngine.bindTexture(optionsBackground);
        GL11.glPushMatrix();
        {
		GL11.glColor4f(0.3F, 0.3F, 0.3F, 1.0F);
        //GL11.glScalef(2f, 2f, 2f);
        drawDefaultBackground();
        drawModalRectWithCustomSizedTexture(0, -140/16, 0, 0, screenWidth, 70, 32, 32);
        drawModalRectWithCustomSizedTexture(0, screenHeight - ((screenHeight/8)+70/16), 0, 0, screenWidth, 70, 32, 32);
        }
        GL11.glPopMatrix();
        GL11.glPushMatrix();
        {
        GL11.glScalef(2, 2, 2);
        drawString(fontRendererObj, "Menu", 5, 5, 0xFFFFFF);
        }
        GL11.glPopMatrix();
        GL11.glPushMatrix();
        {
        	drawString(fontRendererObj, mc.thePlayer.worldObj.provider.getDimensionName(), screenWidth - 60, 5, 0xFFFFFF);
            drawString(fontRendererObj, mc.thePlayer.worldObj.getBiomeGenForCoords(mc.thePlayer.getPosition()).biomeName, screenWidth - 60, 20, 0xFFFFFF);
        }
        GL11.glPopMatrix();
	}
	
}
