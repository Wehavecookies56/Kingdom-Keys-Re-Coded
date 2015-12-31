package wehavecookies56.kk.client.gui;

import org.lwjgl.opengl.GL11;

import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.AbstractClientPlayer;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import wehavecookies56.kk.entities.ExtendedPlayer;
import wehavecookies56.kk.lib.Constants;
import wehavecookies56.kk.lib.Reference;

public class GuiPlayerPortrait extends GuiScreen {

	@SubscribeEvent
	public void onRenderOverlayPost(RenderGameOverlayEvent event){
		Minecraft mc = Minecraft.getMinecraft();
		int screenWidth = event.resolution.getScaledWidth();
		int screenHeight = event.resolution.getScaledHeight();
		if(event.type == RenderGameOverlayEvent.ElementType.TEXT) {
			GL11.glColor3f(1, 1, 1);
			ResourceLocation skin = ((AbstractClientPlayer) mc.thePlayer).getLocationSkin();
			mc.getTextureManager().bindTexture(skin);
			float scale = 0.5f;
			switch(mc.gameSettings.guiScale){
			case Constants.SCALE_AUTO:
				scale = 0.85f;
				break;
			case Constants.SCALE_NORMAL:
				scale = 0.85f;
				break;
			default:
				scale = 0.65f;
				break;
			}

			if(ExtendedPlayer.get(mc.thePlayer).getDriveInUse().equals("Anti"))
			{
				GL11.glColor3ub((byte)30, (byte)30, (byte)30);

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
			GL11.glColor4f(100.0F, 1.0F, 1.0F, 1.0F);

			if(ExtendedPlayer.get(mc.thePlayer).getDriveInUse().equals("Valor"))
			{
				ResourceLocation texture = new ResourceLocation(Reference.MODID, "textures/armour/Valor_A.png");
				mc.renderEngine.bindTexture(texture);

				GL11.glPushMatrix();{
					GL11.glTranslatef((screenWidth - 32*scale) - 16*scale, (screenHeight - 80*scale) - -48*scale, 0);
					GL11.glScalef(2, 1, 1);
					GL11.glScalef(0.5f, 0.5f, 0.5f);
					GL11.glScalef(scale, scale, scale);
					this.drawTexturedModalRect(0, 0, 80, 160, 32, 80);
				}GL11.glPopMatrix();

				GL11.glPushMatrix();{
					GL11.glTranslatef((screenWidth - 16*scale) - 48*scale, (screenHeight - 80*scale) - -48*scale, 0);
					GL11.glScalef(2, 1, 1);
					GL11.glScalef(0.5f, 0.5f, 0.5f);
					GL11.glScalef(scale, scale, scale);
					this.drawTexturedModalRect(0, 0, 64, 160, 16, 80);
				}GL11.glPopMatrix();

				GL11.glPushMatrix();{
					GL11.glTranslatef((screenWidth - 16*scale) - 0*scale, (screenHeight - 80*scale) - -48*scale, 0);
					GL11.glScalef(2, 1, 1);
					GL11.glScalef(0.5f, 0.5f, 0.5f);
					GL11.glScalef(scale, scale, scale);
					this.drawTexturedModalRect(0, 0, 112, 160, 16, 80);
				}GL11.glPopMatrix();

			}
			else if(ExtendedPlayer.get(mc.thePlayer).getDriveInUse().equals("Wisdom"))
			{
				ResourceLocation texture = new ResourceLocation(Reference.MODID, "textures/armour/Wisdom_A.png");
				mc.renderEngine.bindTexture(texture);

				GL11.glPushMatrix();{
					GL11.glTranslatef((screenWidth - 32*scale) - 16*scale, (screenHeight - 80*scale) - -48*scale, 0);
					GL11.glScalef(2, 1, 1);
					GL11.glScalef(0.5f, 0.5f, 0.5f);
					GL11.glScalef(scale, scale, scale);
					this.drawTexturedModalRect(0, 0, 80, 160, 32, 80);
				}GL11.glPopMatrix();

				GL11.glPushMatrix();{
					GL11.glTranslatef((screenWidth - 16*scale) - 48*scale, (screenHeight - 80*scale) - -48*scale, 0);
					GL11.glScalef(2, 1, 1);
					GL11.glScalef(0.5f, 0.5f, 0.5f);
					GL11.glScalef(scale, scale, scale);
					this.drawTexturedModalRect(0, 0, 64, 160, 16, 80);
				}GL11.glPopMatrix();

				GL11.glPushMatrix();{
					GL11.glTranslatef((screenWidth - 16*scale) - 0*scale, (screenHeight - 80*scale) - -48*scale, 0);
					GL11.glScalef(2, 1, 1);
					GL11.glScalef(0.5f, 0.5f, 0.5f);
					GL11.glScalef(scale, scale, scale);
					this.drawTexturedModalRect(0, 0, 112, 160, 16, 80);
				}GL11.glPopMatrix();
			}
			else if(ExtendedPlayer.get(mc.thePlayer).getDriveInUse().equals("Limit"))
			{
				ResourceLocation texture = new ResourceLocation(Reference.MODID, "textures/armour/Limit_A.png");
				mc.renderEngine.bindTexture(texture);

				GL11.glPushMatrix();{
					GL11.glTranslatef((screenWidth - 32*scale) - 16*scale, (screenHeight - 80*scale) - -48*scale, 0);
					GL11.glScalef(2, 1, 1);
					GL11.glScalef(0.5f, 0.5f, 0.5f);
					GL11.glScalef(scale, scale, scale);
					this.drawTexturedModalRect(0, 0, 80, 160, 32, 80);
				}GL11.glPopMatrix();

				GL11.glPushMatrix();{
					GL11.glTranslatef((screenWidth - 16*scale) - 48*scale, (screenHeight - 80*scale) - -48*scale, 0);
					GL11.glScalef(2, 1, 1);
					GL11.glScalef(0.5f, 0.5f, 0.5f);
					GL11.glScalef(scale, scale, scale);
					this.drawTexturedModalRect(0, 0, 64, 160, 16, 80);
				}GL11.glPopMatrix();

				GL11.glPushMatrix();{
					GL11.glTranslatef((screenWidth - 16*scale) - 0*scale, (screenHeight - 80*scale) - -48*scale, 0);
					GL11.glScalef(2, 1, 1);
					GL11.glScalef(0.5f, 0.5f, 0.5f);
					GL11.glScalef(scale, scale, scale);
					this.drawTexturedModalRect(0, 0, 112, 160, 16, 80);
				}GL11.glPopMatrix();
			}
			else if(ExtendedPlayer.get(mc.thePlayer).getDriveInUse().equals("Master"))
			{
				ResourceLocation texture = new ResourceLocation(Reference.MODID, "textures/armour/Master_A.png");
				mc.renderEngine.bindTexture(texture);

				GL11.glPushMatrix();{
					GL11.glTranslatef((screenWidth - 32*scale) - 16*scale, (screenHeight - 80*scale) - -48*scale, 0);
					GL11.glScalef(2, 1, 1);
					GL11.glScalef(0.5f, 0.5f, 0.5f);
					GL11.glScalef(scale, scale, scale);
					this.drawTexturedModalRect(0, 0, 80, 160, 32, 80);
				}GL11.glPopMatrix();

				GL11.glPushMatrix();{
					GL11.glTranslatef((screenWidth - 16*scale) - 48*scale, (screenHeight - 80*scale) - -48*scale, 0);
					GL11.glScalef(2, 1, 1);
					GL11.glScalef(0.5f, 0.5f, 0.5f);
					GL11.glScalef(scale, scale, scale);
					this.drawTexturedModalRect(0, 0, 64, 160, 16, 80);
				}GL11.glPopMatrix();

				GL11.glPushMatrix();{
					GL11.glTranslatef((screenWidth - 16*scale) - 0*scale, (screenHeight - 80*scale) - -48*scale, 0);
					GL11.glScalef(2, 1, 1);
					GL11.glScalef(0.5f, 0.5f, 0.5f);
					GL11.glScalef(scale, scale, scale);
					this.drawTexturedModalRect(0, 0, 112, 160, 16, 80);
				}GL11.glPopMatrix();
			}
			else if(ExtendedPlayer.get(mc.thePlayer).getDriveInUse().equals("Final"))
			{
				ResourceLocation texture = new ResourceLocation(Reference.MODID, "textures/armour/Final_A.png");
				mc.renderEngine.bindTexture(texture);

				GL11.glPushMatrix();{
					GL11.glTranslatef((screenWidth - 32*scale) - 16*scale, (screenHeight - 80*scale) - -48*scale, 0);
					GL11.glScalef(2, 1, 1);
					GL11.glScalef(0.5f, 0.5f, 0.5f);
					GL11.glScalef(scale, scale, scale);
					this.drawTexturedModalRect(0, 0, 80, 160, 32, 80);
				}GL11.glPopMatrix();

				GL11.glPushMatrix();{
					GL11.glTranslatef((screenWidth - 16*scale) - 48*scale, (screenHeight - 80*scale) - -48*scale, 0);
					GL11.glScalef(2, 1, 1);
					GL11.glScalef(0.5f, 0.5f, 0.5f);
					GL11.glScalef(scale, scale, scale);
					this.drawTexturedModalRect(0, 0, 64, 160, 16, 80);
				}GL11.glPopMatrix();

				GL11.glPushMatrix();{
					GL11.glTranslatef((screenWidth - 16*scale) - 0*scale, (screenHeight - 80*scale) - -48*scale, 0);
					GL11.glScalef(2, 1, 1);
					GL11.glScalef(0.5f, 0.5f, 0.5f);
					GL11.glScalef(scale, scale, scale);
					this.drawTexturedModalRect(0, 0, 112, 160, 16, 80);
				}GL11.glPopMatrix();
			}
			
		}
	}
}
