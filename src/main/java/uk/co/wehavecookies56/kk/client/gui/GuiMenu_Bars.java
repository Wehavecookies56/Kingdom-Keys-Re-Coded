package uk.co.wehavecookies56.kk.client.gui;

import org.lwjgl.opengl.GL11;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.inventory.GuiInventory;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import uk.co.wehavecookies56.kk.common.capability.ModCapabilities;
import uk.co.wehavecookies56.kk.common.capability.MunnyCapability.IMunny;
import uk.co.wehavecookies56.kk.common.capability.PlayerStatsCapability;
import uk.co.wehavecookies56.kk.common.core.handler.MainConfig;
import uk.co.wehavecookies56.kk.common.lib.Reference;
import uk.co.wehavecookies56.kk.common.lib.Strings;
import uk.co.wehavecookies56.kk.common.util.Utils;

public class GuiMenu_Bars extends GuiScreen {

	String name;

	public GuiMenu_Bars (String name) {
		this.name = name;
	}

	public boolean drawPlayerInfo;

	@Override
	public void drawScreen (int mouseX, int mouseY, float partialTicks) {
		RenderHelper.disableStandardItemLighting();
		drawBackground(width, height, drawPlayerInfo);
		if (drawPlayerInfo) {
			GL11.glPushMatrix();
			{
				PlayerStatsCapability.IPlayerStats STATS = mc.player.getCapability(ModCapabilities.PLAYER_STATS, null);
				drawCenteredString(fontRenderer, mc.player.getDisplayNameString().toString(), this.width / 2, this.height / 2 + 80, 0xFFFFFF);
				drawString(fontRenderer, "Lv: " + STATS.getLevel(), this.width / 2 - 40, this.height / 2 + 90, 0xFFD900);
				drawString(fontRenderer, "HP: " + (int) mc.player.getHealth() + "/" + (int) mc.player.getMaxHealth(), this.width / 2 - 40, this.height / 2 + 100, 0x00FF00);
				drawString(fontRenderer, "MP: " + (int) STATS.getMP() + "/" + (int) STATS.getMaxMP(), this.width / 2 - 40, this.height / 2 + 110, 0x4444FF);

			}
			GL11.glPopMatrix();
		}

		super.drawScreen(mouseX, mouseY, partialTicks);
	}

	public static final ResourceLocation optionsBackground = new ResourceLocation(Reference.MODID, "textures/gui/menubg.png");

	public static String getWorldMinutes (World world) {
		int time = (int) Math.abs((world.getWorldTime() + 6000) % 24000);
		if ((time % 1000) * 6 / 100 < 10)
			return "0" + (time % 1000) * 6 / 100;
		else
			return Integer.toString((time % 1000) * 6 / 100);
	}

	public static int getWorldHours (World world) {
		int time = (int) Math.abs((world.getWorldTime() + 6000) % 24000);
		return (int) (time / 1000F);
	}

	@Override
	public void initGui () {
		super.initGui();
		drawPlayerInfo = true;
	}

	protected void drawBackground (int screenWidth, int screenHeight, boolean drawPlayer) {
		Minecraft.getMinecraft().renderEngine.bindTexture(optionsBackground);
		GL11.glPushMatrix();
		{
			GL11.glColor4ub((byte) MainConfig.client.hud.interfaceColour[0], (byte) MainConfig.client.hud.interfaceColour[1], (byte) MainConfig.client.hud.interfaceColour[2], (byte) 255);
			// GL11.glColor4f(0.3F, 0.3F, 0.3F, 1.0F);
			// GL11.glScalef(2f, 2f, 2f);
			drawDefaultBackground();
			drawModalRectWithCustomSizedTexture(0, 0, 0, 0, screenWidth, 60, 32, 32);
			drawModalRectWithCustomSizedTexture(0, screenHeight - ((screenHeight / 8) + 70 / 16), 0, 0, screenWidth, 70, 32, 32);
		}
		GL11.glPopMatrix();
		GL11.glPushMatrix();
		{
			GL11.glScalef(2, 2, 2);
			String title = Utils.translateToLocal(name);
			drawString(fontRenderer, title, 5, 5, 0xFFFFFF);
		}
		GL11.glPopMatrix();
		GL11.glPushMatrix();
		{
			drawString(fontRenderer, mc.player.world.provider.getDimensionType().getName(), screenWidth - fontRenderer.getStringWidth(mc.player.world.provider.getDimensionType().getName()) - 5, 5, 0xFFFFFF);
			drawString(fontRenderer, mc.player.world.getBiome(mc.player.getPosition()).getBiomeName(), screenWidth - fontRenderer.getStringWidth(mc.player.world.getBiome(mc.player.getPosition()).getBiomeName()) - 5, 20, 0xFFFFFF);
			drawString(fontRenderer, Utils.translateToLocal(Strings.Gui_Menu_Main_Time) + ": " + getWorldHours(mc.world) + ":" + getWorldMinutes(mc.world), 5, screenHeight - ((screenHeight / 8) - 300 / 16), 0xFFFFFF);
			IMunny MUNNY = mc.player.getCapability(ModCapabilities.MUNNY, null);
			drawString(fontRenderer, Utils.translateToLocal(Strings.Gui_Menu_Main_Munny) + ": " + MUNNY.getMunny(), 5, screenHeight - ((screenHeight / 8) - 100 / 16), 0xFFD000);
			long seconds = mc.world.getTotalWorldTime()/20;
			long h = seconds/3600;
			long m = seconds%3600/60;
			long s = seconds%3600%60;
			
			String sec=s<10?0+""+s:s+"";
			String min=m<10?0+""+m:m+"";
			String hou=h<10?0+""+h:h+"";
			String time = hou+":"+min+":"+sec;
			drawString(fontRenderer, Utils.translateToLocal(Strings.Gui_Menu_Main_Time_Spent) + ": " + time, 5, screenHeight - ((screenHeight / 8) - 500 / 16), 0x42ceff);

		}
		GL11.glPopMatrix();
		if (drawPlayer) {
			GL11.glPushMatrix();
			{
				GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
				GuiInventory.drawEntityOnScreen(this.width / 2, this.height / 2 + 75, 70, 0, 0, mc.player);
				// GL11.glColor4f(1.0F, 1.0F, 1.0F, 0.75F);
			}
			GL11.glPopMatrix();
		}

	}

}
