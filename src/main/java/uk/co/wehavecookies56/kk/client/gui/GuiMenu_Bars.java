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
import uk.co.wehavecookies56.kk.common.core.handler.ConfigHandler;
import uk.co.wehavecookies56.kk.common.core.helper.TextHelper;
import uk.co.wehavecookies56.kk.common.lib.Reference;
import uk.co.wehavecookies56.kk.common.lib.Strings;

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
				PlayerStatsCapability.IPlayerStats STATS = mc.thePlayer.getCapability(ModCapabilities.PLAYER_STATS, null);
				drawCenteredString(fontRendererObj, mc.thePlayer.getDisplayNameString().toString(), this.width / 2, this.height / 2 + 80, 0xFFFFFF);
				drawString(fontRendererObj, "Lv: " + STATS.getLevel(), this.width / 2 - 40, this.height / 2 + 90, 0xFFD900);
				drawString(fontRendererObj, "HP: " + (int) mc.thePlayer.getHealth() + "/" + (int) mc.thePlayer.getMaxHealth(), this.width / 2 - 40, this.height / 2 + 100, 0x00FF00);
				drawString(fontRendererObj, "MP: " + (int) STATS.getMP() + "/" + (int) STATS.getMaxMP(), this.width / 2 - 40, this.height / 2 + 110, 0x4444FF);

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
			GL11.glColor4ub((byte) ConfigHandler.interfaceColour[0], (byte) ConfigHandler.interfaceColour[1], (byte) ConfigHandler.interfaceColour[2], (byte) 255);
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
			String title = TextHelper.localize(name);
			drawString(fontRendererObj, title, 5, 5, 0xFFFFFF);
		}
		GL11.glPopMatrix();
		GL11.glPushMatrix();
		{
			drawString(fontRendererObj, mc.thePlayer.worldObj.provider.getDimensionType().getName(), screenWidth - fontRendererObj.getStringWidth(mc.thePlayer.worldObj.provider.getDimensionType().getName()) - 5, 5, 0xFFFFFF);
			drawString(fontRendererObj, mc.thePlayer.worldObj.getBiome(mc.thePlayer.getPosition()).getBiomeName(), screenWidth - fontRendererObj.getStringWidth(mc.thePlayer.worldObj.getBiome(mc.thePlayer.getPosition()).getBiomeName()) - 5, 20, 0xFFFFFF);
			drawString(fontRendererObj, TextHelper.localize(Strings.Gui_Menu_Main_Time) + ": " + getWorldHours(mc.theWorld) + ":" + getWorldMinutes(mc.theWorld), 5, screenHeight - ((screenHeight / 8) - 300 / 16), 0xFFFFFF);
			IMunny MUNNY = mc.thePlayer.getCapability(ModCapabilities.MUNNY, null);
			drawString(fontRendererObj, TextHelper.localize(Strings.Gui_Menu_Main_Munny) + ": " + MUNNY.getMunny(), 5, screenHeight - ((screenHeight / 8) - 100 / 16), 0xFFD000);
		}
		GL11.glPopMatrix();
		if (drawPlayer) {
			GL11.glPushMatrix();
			{
				GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
				GuiInventory.drawEntityOnScreen(this.width / 2, this.height / 2 + 75, 70, 0, 0, mc.thePlayer);
				// GL11.glColor4f(1.0F, 1.0F, 1.0F, 0.75F);
			}
			GL11.glPopMatrix();
		}

	}

}
