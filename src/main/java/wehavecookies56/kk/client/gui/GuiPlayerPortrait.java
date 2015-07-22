package wehavecookies56.kk.client.gui;

import org.lwjgl.opengl.GL11;

import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.AbstractClientPlayer;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class GuiPlayerPortrait extends GuiScreen {

	@SubscribeEvent
	public void onRenderOverlayPost(RenderGameOverlayEvent event){
		Minecraft mc = Minecraft.getMinecraft();
		int screenWidth = event.resolution.getScaledWidth();
		int screenHeight = event.resolution.getScaledHeight();
		if(event.type == RenderGameOverlayEvent.ElementType.TEXT) {
			ResourceLocation skin = ((AbstractClientPlayer) mc.thePlayer).getLocationSkin();
			mc.getTextureManager().bindTexture(skin);
			float scale = 0.5f;
			if(mc.gameSettings.guiScale == 1)
			{
				//scale = 1f;
			}
			else
			{
				scale = 0.65f;
			}

			//HEAD
			int headWidth = 32;
			int headHeight = 32;
			float headPosX = 16;
			float headPosY = 32;
			float scaledHeadPosX = headPosX*scale;
			float scaledHeadPosY = headPosY*scale;

			GL11.glPushMatrix();{
				GL11.glTranslatef((screenWidth - headWidth*scale) - scaledHeadPosX, (screenHeight - headHeight*scale) - scaledHeadPosY, 0);
				GL11.glScalef(scale, scale, scale);
				this.drawTexturedModalRect(0, 0, 32, 32, headWidth, headHeight);
			}GL11.glPopMatrix();

			//HAT
			int hatWidth = 32;
			int hatHeight = 32;
			float hatPosX = 16;
			float hatPosY = 32;
			float scaledHatPosX = hatPosX*scale;
			float scaledHatPosY = hatPosY*scale;

			GL11.glPushMatrix();{
				GL11.glTranslatef((screenWidth - hatWidth*scale) - scaledHatPosX, (screenHeight - hatHeight*scale) - scaledHatPosY, 0);
				GL11.glScalef(scale, scale, scale);
				this.drawTexturedModalRect(0, 0, 160, 32, hatWidth, hatHeight);
			}GL11.glPopMatrix();

			//BODY
			int bodyWidth = 32;
			int bodyHeight = 64;
			float bodyPosX = 16;
			float bodyPosY = -32;
			float scaledBodyPosX = bodyPosX*scale;
			float scaledBodyPosY = bodyPosY*scale;

			GL11.glPushMatrix();{
				GL11.glTranslatef((screenWidth - bodyWidth*scale) - scaledBodyPosX, (screenHeight - bodyHeight*scale) - scaledBodyPosY, 0);
				GL11.glScalef(scale, scale, scale);
				this.drawTexturedModalRect(0, 0, 80, 80, bodyWidth, bodyHeight);
			}GL11.glPopMatrix();

			//ARMS
			int armWidth = 16;
			int armHeight = 64;
			float armRPosX = 48;
			float armRPosY = -32;
			float scaledArmRPosX = armRPosX*scale;
			float scaledArmRPosY = armRPosY*scale;
			float armLPosX = 0;
			float armLPosY = -32;
			float scaledArmLPosX = armLPosX*scale;
			float scaledArmLPosY = armLPosY*scale;

			GL11.glPushMatrix();{
				GL11.glTranslatef((screenWidth - armWidth*scale) - scaledArmRPosX, (screenHeight - armHeight*scale) - scaledArmRPosY, 0);
				GL11.glScalef(scale, scale, scale);
				this.drawTexturedModalRect(0, 0, 176, 80, armWidth, armHeight);
			}GL11.glPopMatrix();

			GL11.glPushMatrix();{
				GL11.glTranslatef((screenWidth - armWidth*scale) - scaledArmLPosX, (screenHeight - armHeight*scale) - scaledArmLPosY, 0);
				GL11.glScalef(scale, scale, scale);
				this.drawTexturedModalRect(0, 0, 176, 80, armWidth, armHeight);
			}GL11.glPopMatrix();

		}
	}
}
