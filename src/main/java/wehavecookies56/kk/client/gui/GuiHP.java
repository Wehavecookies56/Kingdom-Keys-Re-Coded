package wehavecookies56.kk.client.gui;

import org.lwjgl.opengl.GL11;


import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import wehavecookies56.kk.lib.Reference;
import wehavecookies56.kk.lib.Constants;

public class GuiHP extends GuiScreen {

	int guiWidth = 173;
	int guiHeight = 12;
	int noborderguiwidth = 171;

	@SubscribeEvent
	public void onRenderOverlayPost(RenderGameOverlayEvent event){
		if(event.type == RenderGameOverlayEvent.ElementType.TEXT){

			Minecraft mc = Minecraft.getMinecraft();
			EntityPlayer player = mc.thePlayer;

			mc.renderEngine.bindTexture(new ResourceLocation(Reference.MODID, "textures/gui/hpbar.png"));

			int screenWidth = event.resolution.getScaledWidth();
			int screenHeight = event.resolution.getScaledHeight();

			float oneHeart = (noborderguiwidth / player.getMaxHealth());
			int currHealth = noborderguiwidth - (int) (oneHeart * player.getHealth());
			float scale = 0.65f;
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

			GL11.glPushMatrix();
			GL11.glTranslatef((screenWidth - guiWidth*scale) - 10*scale, (screenHeight - guiHeight*scale) - 4*scale, 0);
			GL11.glScalef(scale, scale, scale);
			this.drawTexturedModalRect(6, 6, 0, 0, guiWidth, guiHeight);
			GL11.glPopMatrix();
			if (player.getHealth() >= 6){
				GL11.glPushMatrix();
				GL11.glTranslatef((screenWidth - noborderguiwidth*scale) + (currHealth * scale) - 10*scale, (screenHeight - guiHeight*scale) - 8*scale, 0);
				//GL11.glTranslatef(2, 0, 0);
				GL11.glScalef(scale, scale, scale);
				this.drawTexturedModalRect(6, 6, 0, 12, (noborderguiwidth - currHealth) - 2, guiHeight);
				GL11.glPopMatrix();
			}
			else{
				GL11.glPushMatrix();
				GL11.glTranslatef((screenWidth - noborderguiwidth*scale) + (currHealth * scale) - 10*scale, (screenHeight - guiHeight*scale) - 6*scale, 0);
				//GL11.glTranslatef(2, 0, 0);
				GL11.glScalef(scale, scale, scale);
				this.drawTexturedModalRect(6, 6, 0, 24, (noborderguiwidth - currHealth) - 2, guiHeight);
				GL11.glPopMatrix();
			}
		}
	}
}
