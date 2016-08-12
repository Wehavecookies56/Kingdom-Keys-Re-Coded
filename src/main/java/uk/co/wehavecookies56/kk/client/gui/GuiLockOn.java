package uk.co.wehavecookies56.kk.client.gui;

import org.lwjgl.opengl.GL11;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import uk.co.wehavecookies56.kk.client.core.handler.InputHandler;
import uk.co.wehavecookies56.kk.common.capability.ModCapabilities;
import uk.co.wehavecookies56.kk.common.capability.PlayerStatsCapability;
import uk.co.wehavecookies56.kk.common.lib.Constants;
import uk.co.wehavecookies56.kk.common.lib.Reference;

public class GuiLockOn extends GuiScreen {

	int guiWidth = 256;
	int guiHeight = 256;

	@SubscribeEvent
	public void onRenderOverlayPost (RenderGameOverlayEvent event) {
		if(!Minecraft.getMinecraft().thePlayer.getCapability(ModCapabilities.PLAYER_STATS, null).getHudMode()) return;
		if (event.getType() == RenderGameOverlayEvent.ElementType.TEXT) {
			Entity target = InputHandler.lockOn;
			if(target == null)
				return;
			Minecraft mc = Minecraft.getMinecraft();
			EntityPlayer player = mc.thePlayer;
			float reduction = 4;
			//mc.renderEngine.bindTexture(new ResourceLocation(Reference.MODID, "textures/gui/lockon/lock on frame"+i+".png"));

			int screenWidth = event.getResolution().getScaledWidth();
			int screenHeight = event.getResolution().getScaledHeight();

			float scale = 0.65f;
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
			GL11.glTranslatef((screenWidth/2)-(guiWidth/2) * scale/reduction, (screenHeight/2)-(guiHeight/2) * scale/reduction, 0);
			GL11.glScalef(scale/reduction, scale/reduction, scale/reduction);
			// BG
			if(target != null)
			{
				for(int i = 1; i<2;i++)
				{
					mc.renderEngine.bindTexture(new ResourceLocation(Reference.MODID, "textures/gui/lockon/lock on frame"+i+".png"));
					this.drawTexturedModalRect(0, 0, 0, 0, guiWidth, guiHeight);
					
				}
			}

			GL11.glPopMatrix();
			GL11.glPushMatrix();
			GL11.glScalef(scale, scale, scale);
			GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
			GL11.glPopMatrix();
		}
	}
}
