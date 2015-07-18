package wehavecookies56.kk.client.gui;

import org.lwjgl.opengl.GL11;

import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.AbstractClientPlayer;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class GuiHead extends GuiScreen {

	@SubscribeEvent
	public void onRenderOverlayPost(RenderGameOverlayEvent event){
		Minecraft mc = Minecraft.getMinecraft();
		int screenWidth = event.resolution.getScaledWidth();
		int screenHeight = event.resolution.getScaledHeight();
		if(event.type == RenderGameOverlayEvent.ElementType.TEXT) {
			ResourceLocation skin = ((AbstractClientPlayer) mc.thePlayer).getLocationSkin();
			mc.getTextureManager().bindTexture(skin);
			float scale = 0.65f;
			if(mc.gameSettings.guiScale == 0){
				scale = 0.65f;
			}else if (mc.gameSettings.guiScale == 3){
				scale = 0.65f;
			}else if (mc.gameSettings.guiScale == 2){
				scale = 0.65f;
			}else{
				scale = 1f;
			}
			float posX = 20*scale;
			float posY = 20*scale;
			GL11.glPushMatrix();
			GL11.glTranslatef((screenWidth - 32*scale) - posX, (screenHeight - 32*scale) - posY, 0);
			GL11.glScalef(scale, scale, scale);
			this.drawTexturedModalRect(0, 0, 32, 32, 32, 32);
			GL11.glPopMatrix();
		}
	}
}
