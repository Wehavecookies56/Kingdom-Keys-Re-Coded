package uk.co.wehavecookies56.kk.client.gui;

import org.lwjgl.opengl.GL11;

import com.google.common.math.Stats;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.client.event.RenderGameOverlayEvent.ElementType;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import uk.co.wehavecookies56.kk.client.sound.ModSounds;
import uk.co.wehavecookies56.kk.common.capability.ModCapabilities;
import uk.co.wehavecookies56.kk.common.capability.PlayerStatsCapability;
import uk.co.wehavecookies56.kk.common.core.handler.MainConfig;
import uk.co.wehavecookies56.kk.common.lib.Constants;
import uk.co.wehavecookies56.kk.common.lib.Reference;

public class GuiMP extends GuiScreen {

	int guiWidth = 138;
	int guiHeight = 6;
	int noborderguiwidth = 126;
	int noborderguiheight = 4;
	double mpBarWidth;
	
	PlayerStatsCapability.IPlayerStats STATS;

	@SubscribeEvent
	public void onRenderOverlayPost(RenderGameOverlayEvent event) {
		if (!MainConfig.displayGUI())
			return;
		if (!Minecraft.getMinecraft().player.getCapability(ModCapabilities.PLAYER_STATS, null).getHudMode())
			return;
		if (event.getType().equals(ElementType.HEALTH) && event.isCancelable())
			if (!MainConfig.client.hud.EnableHeartsOnHUD)
				event.setCanceled(true);
		if (event.getType() == RenderGameOverlayEvent.ElementType.TEXT) {

			Minecraft mc = Minecraft.getMinecraft();
			EntityPlayer player = mc.player;

			mc.renderEngine.bindTexture(new ResourceLocation(Reference.MODID, "textures/gui/mpBar.png"));

			int screenWidth = event.getResolution().getScaledWidth();
			int screenHeight = event.getResolution().getScaledHeight();
			
			float scale = 0.65f;

			STATS = player.getCapability(ModCapabilities.PLAYER_STATS, null);
			
			mpBarWidth = (int) ((int) STATS.getMP() * 1.5);
			int mpMaxBarWidth = (int) ((int) STATS.getMaxMP() * 1.5);

			switch (mc.gameSettings.guiScale) {
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
			GL11.glTranslatef((screenWidth - mpMaxBarWidth * scale) - 54 * scale, (screenHeight - guiHeight * scale) - 11 * scale, 0);
			GL11.glScalef(scale, scale, scale);
			
			drawMPBarBack(0, 0, mpMaxBarWidth, scale);
			GL11.glPopMatrix();
			{
				GL11.glPushMatrix();
				GL11.glTranslatef((screenWidth - ((int)mpBarWidth) * scale) - 54 * scale, (screenHeight - (guiHeight) * scale) - 11 * scale, 0);
				GL11.glScalef(scale, scale, scale);
				drawMPBarTop(0, 0, (int) Math.ceil(mpBarWidth), scale);
			}
			GL11.glPopMatrix();
		}
	}
	
	public void drawMPBarBack(int posX, int posY, int width, float scale) {
		Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation(Reference.MODID, "textures/gui/mpBar.png"));
		
		GL11.glPushMatrix();
		{
			//Left Margin
			GL11.glPushMatrix();
			{
				GL11.glTranslatef(scale * posX, scale * posY, 0);
				GL11.glScalef(scale, scale, 0);
				drawTexturedModalRect(0, 0, 0, 0, 2, 12);
			}
			GL11.glPopMatrix();

			//Background
			GL11.glPushMatrix();
			{
				GL11.glTranslatef((posX + 2) * scale, posY * scale, 0);
				GL11.glScalef(width, scale, 0);
				
				int v=STATS.getRecharge() ? 8 : 2;
				
				drawTexturedModalRect(0, 0, v, 0, 1, 12);
			}
			GL11.glPopMatrix();

			//Right Margin
			GL11.glPushMatrix();
			{
				GL11.glTranslatef((posX + 2) * scale + width, scale * posY, 0);
				GL11.glScalef(scale, scale, 0);
				drawTexturedModalRect(0, 0, 3, 0, 2, 12);
			}
			GL11.glPopMatrix();
			
			//MP Icon
			GL11.glPushMatrix();
			{
				int v=STATS.getRecharge() ? 45 : 32;

				GL11.glTranslatef((posX + 2) * scale + width+1, scale * posY, 0);
				GL11.glScalef(scale, scale, 0);
				drawTexturedModalRect(0, 0, 0, v, 23, 12);
			}
			GL11.glPopMatrix();
		}
		GL11.glPopMatrix();

	}

	public void drawMPBarTop(int posX, int posY, int width, float scale) {
		Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation(Reference.MODID, "textures/gui/mpbar.png"));
		GL11.glPushMatrix();
		{
			GL11.glTranslatef((posX + 2) * scale, (posY + 2) * scale, 0);
			GL11.glScalef(width, scale, 0);
			int v = STATS.getRecharge() ? 22 : 12;
			int h = STATS.getRecharge() ? 8 : 7;
			drawTexturedModalRect(0, 0, 2, v, 1, h);
		}
		GL11.glPopMatrix();

	}
	
	/*@SubscribeEvent
	public void onRenderOverlayPost(RenderGameOverlayEvent event) {
		if (!MainConfig.displayGUI())
			return;
		if (!Minecraft.getMinecraft().player.getCapability(ModCapabilities.PLAYER_STATS, null).getHudMode())
			return;
		if (event.getType() == RenderGameOverlayEvent.ElementType.TEXT) {

			Minecraft mc = Minecraft.getMinecraft();
			EntityPlayer player = mc.player;

			mc.renderEngine.bindTexture(new ResourceLocation(Reference.MODID, "textures/gui/mpbar.png"));

			int screenWidth = event.getResolution().getScaledWidth();
			int screenHeight = event.getResolution().getScaledHeight();

			PlayerStatsCapability.IPlayerStats STATS = player.getCapability(ModCapabilities.PLAYER_STATS, null);
			float oneMP = (noborderguiwidth / (float) STATS.getMaxMP());
			//System.out.println(STATS.getMaxMP());
			float currMP = noborderguiwidth - (float) (oneMP * STATS.getMP());
			float scale = 0.65f;
			switch (mc.gameSettings.guiScale) {
			case Constants.SCALE_AUTO:
				scale = 0.85f;
				break;
			case Constants.SCALE_NORMAL:
				scale = 0.85f;
				break;
			
			}
			
			float barProg = currMP;

			GL11.glPushMatrix();
			{
				GL11.glTranslatef((screenWidth - guiWidth * scale) - 13 * scale, (screenHeight - guiHeight * scale) - 12 * scale, 0);
				GL11.glScalef(scale, scale, scale);
				// BG
				int v = 0;
				if (!STATS.getRecharge())
					v = 0;
				else
					v = 10;
				this.drawTexturedModalRect(-25, 4, 0, v, guiWidth, guiHeight);

			}
			GL11.glPopMatrix();
			GL11.glPushMatrix();
			{
				GL11.glTranslatef((screenWidth - noborderguiwidth * scale) + (barProg * scale) - 23 * scale, (screenHeight - guiHeight * scale) - 12 * scale, 0);
				GL11.glScalef(scale, scale, scale);
				// FG
				int v2 = 0;
				float barProg2 = currMP;
				if (!STATS.getRecharge())
					v2 = 6;
				else
					v2 = 16;
				this.drawTexturedModalRect(-25, 5, 0, v2, (int) (noborderguiwidth - barProg2) - 2, noborderguiheight);
				GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
			}
			GL11.glPopMatrix();
		}
	}*/
}
