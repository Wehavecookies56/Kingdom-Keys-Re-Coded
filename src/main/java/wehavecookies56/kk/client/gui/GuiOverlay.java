package wehavecookies56.kk.client.gui;

import java.awt.List;
import java.util.ArrayList;
import java.util.Arrays;

import org.lwjgl.opengl.GL11;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.client.event.RenderGameOverlayEvent.ElementType;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import wehavecookies56.kk.entities.ExtendedPlayer;
import wehavecookies56.kk.entities.PlayerLevel;
import wehavecookies56.kk.lib.Reference;

public class GuiOverlay extends GuiScreen
{
	public static boolean showExp;
	public static boolean showMunny;
	public static boolean showLevelUp;
	public static long timeExp;
	public static long timeMunny;
	public static long timeLevelUp;
	public static int munnyGet;
	int levelSeconds = 6;
	@SubscribeEvent
	@SideOnly(Side.CLIENT)
	public void RenderGameOverlayEvent(RenderGameOverlayEvent event)
	{
		if(event.type == ElementType.EXPERIENCE){
			Minecraft mc = Minecraft.getMinecraft();
			int screenWidth = event.resolution.getScaledWidth();
			int screenHeight = event.resolution.getScaledHeight();
			String reqExp = ""+(Arrays.stream(PlayerLevel.expNeeded, 0, ExtendedPlayer.get(mc.thePlayer).getLevel()).sum() - ExtendedPlayer.get(mc.thePlayer).getXP());
			if(showExp)
			{
				mc.fontRendererObj.drawString("Next LV", 5, 5, 0xFFFFFF);
				mc.fontRendererObj.drawString(reqExp, 5, 5 + mc.fontRendererObj.FONT_HEIGHT, 0xFFFFFF);
				if(timeExp+4 <= (int)mc.getSystemTime()/1000)
				{
					showExp = false;
				}
			}
			if(showMunny){
				mc.fontRendererObj.drawString("Munny Get!", 5, 5 + mc.fontRendererObj.FONT_HEIGHT + 10, 0xFFFFFF);
				mc.fontRendererObj.drawString(munnyGet+"", 5, 5 + (mc.fontRendererObj.FONT_HEIGHT*2) + 10, 0xFFFFFF);
				if(timeMunny+4 <= (int)mc.getSystemTime()/1000)
				{
					showMunny = false;
				}
			}
			if(showLevelUp){
				ResourceLocation texture = new ResourceLocation(Reference.MODID, "textures/gui/levelup.png");
				GL11.glPushMatrix();{
					int height = (mc.fontRendererObj.FONT_HEIGHT - 3) * PlayerLevel.messages.size();
					GL11.glEnable(GL11.GL_BLEND);
					GL11.glColor4ub((byte)255, (byte)0, (byte)0, (byte)255);
					GL11.glPushMatrix();{
						mc.renderEngine.bindTexture(texture);
						int width = event.resolution.getScaledWidth();
						GL11.glPushMatrix();{
							GL11.glTranslatef((width - 153.6f - 2), 0, 0);
							GL11.glScalef(0.6f, 0.6f, 1);
							drawTexturedModalRect(0, 0, 0, 0, 256, 36);
						}GL11.glPopMatrix();
						GL11.glPushMatrix();{
							GL11.glTranslatef(width - ((float)(mc.fontRendererObj.getStringWidth("LEVEL UP!"))*0.75f) - 115, 4, 0);
							GL11.glScalef(0.75f, 0.75f, 1);
							drawString(mc.fontRendererObj, "LEVEL UP!" + EnumChatFormatting.ITALIC, 0, 0, 0xC74326);
						}GL11.glPopMatrix();
						GL11.glPushMatrix();{
							GL11.glPushMatrix();{
								GL11.glTranslatef(width - ((float)(mc.fontRendererObj.getStringWidth("LV. "))*0.75f) - 90, 4, 0);
								GL11.glScalef(0.75f, 0.75f, 1);
								drawString(mc.fontRendererObj, "LV.", 0, 0, 0xE3D000);
							}GL11.glPopMatrix();
							GL11.glPushMatrix();{
								GL11.glTranslatef(width - 256.0f*0.75f + ((float)(mc.fontRendererObj.getStringWidth("999"))*0.75f) + 88, 4, 0);
								GL11.glScalef(0.75f, 0.75f, 1);
								drawString(mc.fontRendererObj, ""+ExtendedPlayer.get(mc.thePlayer).getLevel(), 0, 0, 0xFFFFFF);
							}GL11.glPopMatrix();
							GL11.glPushMatrix();{
								GL11.glTranslatef(width - ((float)(mc.fontRendererObj.getStringWidth(mc.thePlayer.getDisplayNameString()))*0.75f) - 7, 4, 0);
								GL11.glScalef(0.75f, 0.75f, 1);
								drawString(mc.fontRendererObj, mc.thePlayer.getDisplayNameString(), 0, 0, 0xFFFFFF);
							}GL11.glPopMatrix();
						}GL11.glPopMatrix();
					}GL11.glPopMatrix();
					GL11.glColor4ub((byte)255, (byte)0, (byte)0, (byte)255);
					GL11.glPushMatrix();{
						mc.renderEngine.bindTexture(texture);
						int width = event.resolution.getScaledWidth();
						GL11.glTranslatef(((float)width - 256.0f*0.6f - 2), 36.0f*0.6f, 0);
						GL11.glScalef(0.6f, height, 1);
						drawTexturedModalRect(0, 0, 0, 36, 256, 1);
					}GL11.glPopMatrix();
					GL11.glColor4ub((byte)255, (byte)0, (byte)0, (byte)255);
					GL11.glPushMatrix();{
						mc.renderEngine.bindTexture(texture);
						int width = event.resolution.getScaledWidth();
						GL11.glTranslatef(((float)width - 256.0f*0.6f - 2), height + (36.0f*0.6f), 0);
						GL11.glScalef(0.6f, 0.6f, 1);
						drawTexturedModalRect(0, 0, 0, 37, 256, 14);
					}GL11.glPopMatrix();
					GL11.glColor4ub((byte)255, (byte)0, (byte)0, (byte)255);
					String message = "";
					String strMessage = "Strength Increased!";
					String defMessage = "Defense Increased!";
					String magMessage = "Magic Increased!";
					String hpMessage = "Maximum HP Increased!";
					for(int i = 0; i < PlayerLevel.messages.size(); i++){
						GL11.glPushMatrix();{
							int width = event.resolution.getScaledWidth();

							if(PlayerLevel.messages.get(i).toString().equals("str"))
							{
								message = strMessage;
							}
							else if(PlayerLevel.messages.get(i).toString().equals("def"))
							{
								message = defMessage;
							}
							else if(PlayerLevel.messages.get(i).toString().equals("mag"))
							{
								message = magMessage;
							}
							else if(PlayerLevel.messages.get(i).toString().equals("hp"))
							{
								message = hpMessage;
							}
							GL11.glTranslatef((width - (float)(256.0f*0.8f) + (float)(mc.fontRendererObj.getStringWidth("Maximum HP Increased!"))*0.8f), (float)(mc.fontRendererObj.FONT_HEIGHT*0.8f)*i + 23, 0);
							GL11.glTranslatef(-35, 0, 0);
							GL11.glScalef(0.8f, 0.8f, 1);
							drawString(mc.fontRendererObj, message, 0, 0, 0xFFFFFF);

						}GL11.glPopMatrix();
					}
					GL11.glColor4ub((byte)255, (byte)255, (byte)255, (byte)255);
				}GL11.glPopMatrix();
				if(timeLevelUp+levelSeconds <= (int)mc.getSystemTime()/1000)
				{
					//showLevelUp = false;
				}
			}
		}
	}
}