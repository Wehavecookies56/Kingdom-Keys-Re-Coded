package wehavecookies56.kk.client.gui;

import org.lwjgl.opengl.GL11;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import wehavecookies56.kk.entities.ExtendedPlayer;
import wehavecookies56.kk.lib.Constants;
import wehavecookies56.kk.lib.Reference;

public class GuiMP extends GuiScreen {

	int guiWidth = 138;
	int guiHeight = 6;
	int noborderguiwidth = 126;
	int noborderguiheight = 4;

	@SubscribeEvent
	public void onRenderOverlayPost (RenderGameOverlayEvent event) {
		if (event.type == RenderGameOverlayEvent.ElementType.TEXT) {

			Minecraft mc = Minecraft.getMinecraft();
			EntityPlayer player = mc.thePlayer;

			mc.renderEngine.bindTexture(new ResourceLocation(Reference.MODID, "textures/gui/mpbar.png"));

			int screenWidth = event.resolution.getScaledWidth();
			int screenHeight = event.resolution.getScaledHeight();

			float oneMP = (noborderguiwidth / (float) ExtendedPlayer.get(player).getMaxMp());
			float currMP = noborderguiwidth - (float) (oneMP * ExtendedPlayer.get(player).getMp());
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
			GL11.glTranslatef((screenWidth - guiWidth * scale) - 13 * scale, (screenHeight - guiHeight * scale) - 12 * scale, 0);
			GL11.glScalef(scale, scale, scale);
			// BG
			int v = 0;
			float barProg = currMP;
			if (ExtendedPlayer.get(player).getRecharge() == false)
				v = 0;
			else
				v = 10;
			this.drawTexturedModalRect(-25, 4, 0, v, guiWidth, guiHeight);

			GL11.glPopMatrix();
			GL11.glPushMatrix();

			GL11.glTranslatef((screenWidth - noborderguiwidth * scale) + (barProg * scale) - 23 * scale, (screenHeight - guiHeight * scale) - 12 * scale, 0);
			GL11.glScalef(scale, scale, scale);
			// FG
			int v2 = 0;
			float barProg2 = currMP;
			if (ExtendedPlayer.get(player).getRecharge() == false)
				v2 = 6;
			else
				v2 = 16;
			this.drawTexturedModalRect(-25, 5, 0, v2, (int) (noborderguiwidth - barProg2) - 2, noborderguiheight);
			GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
			GL11.glPopMatrix();
		}
	}
}
