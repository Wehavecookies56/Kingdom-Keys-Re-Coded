package uk.co.wehavecookies56.kk.client.gui;

import org.lwjgl.opengl.GL11;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import uk.co.wehavecookies56.kk.common.capability.DriveStateCapability;
import uk.co.wehavecookies56.kk.common.capability.ModCapabilities;
import uk.co.wehavecookies56.kk.common.capability.PlayerStatsCapability;
import uk.co.wehavecookies56.kk.common.core.handler.MainConfig;
import uk.co.wehavecookies56.kk.common.lib.Constants;
import uk.co.wehavecookies56.kk.common.lib.Reference;
import uk.co.wehavecookies56.kk.common.lib.Strings;

@SideOnly(Side.CLIENT)
public class GuiDrive extends GuiScreen {
	Minecraft mc = Minecraft.getMinecraft();

	ResourceLocation texture = new ResourceLocation(Reference.MODID, "textures/gui/drivebar.png");

	int maxDrive = 1000;
	int maxLength = 100;
	int maxBars = 9;
	double guiLength = 47D;
	double oneValue = (guiLength / 100D);
	double currDrive;
	double currForm;

	int r = 255, g = 255, b = 255;
	String nextColor = "r";
	static final int CONS = 5;

	public GuiDrive() {

	}

	public int getMaxBars(int level) {
		return level * 100;
	}

	public int getCurrBar(double dp, int level) {
		int bar = (int) dp / 100;
		if (bar > level)
			bar = level;
		return bar;
	}

	long counter = Minecraft.getSystemTime();

	private boolean doChange = false;

	private int timeLastChange = (int) Minecraft.getSystemTime();

	@SubscribeEvent
	public void onRenderOverlayPost(RenderGameOverlayEvent event) {
		if (!MainConfig.displayGUI())
			return;
		if (!mc.player.getCapability(ModCapabilities.PLAYER_STATS, null).getHudMode())
			return;

		PlayerStatsCapability.IPlayerStats STATS = mc.player.getCapability(ModCapabilities.PLAYER_STATS, null);
		DriveStateCapability.IDriveState STATE = mc.player.getCapability(ModCapabilities.DRIVE_STATE, null);
		double dp = STATE.getDP();
		double fp = STATE.getFP();

		currDrive = (float) ((oneValue * dp) - getCurrBar(dp, STATE.getDriveGaugeLevel()) * guiLength);
		if (STATE.getInDrive())
			currForm = (float) ((oneValue * fp) - getCurrBar(fp, STATE.getFormGaugeLevel(STATE.getActiveDriveName())) * guiLength);

		if (dp == getMaxBars(STATE.getDriveGaugeLevel())) {
			currDrive = guiLength;
		}
		if (event.getType() == RenderGameOverlayEvent.ElementType.HOTBAR) {
			if (!STATE.getActiveDriveName().equals("none") && !STATE.getActiveDriveName().equals(Strings.Form_Anti)) {
				event.setCanceled(true);
			}
		}
		if (event.getType() == RenderGameOverlayEvent.ElementType.TEXT) {
			int guiWidth = 95;
			int guiBarWidth = 83;
			int guiHeight = 18;
			int screenWidth = event.getResolution().getScaledWidth();
			int screenHeight = event.getResolution().getScaledHeight();
			EntityPlayer player = mc.player;

			mc.renderEngine.bindTexture(texture);

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
			float posX = 52 * scale;
			float posY = 20 * scale;
			// System.out.println(STATS.getMaxDP());
			GL11.glPushMatrix();
			GL11.glTranslatef((screenWidth - guiWidth * scale) - posX, (screenHeight - guiHeight * scale) - posY, 0);
			GL11.glScalef(scale, scale, scale);

			// Background
			if (STATE.getActiveDriveName().equals("none")) {
				this.drawTexturedModalRect(15, 6, 0, 0, guiWidth, guiHeight);
			} else {
				this.drawTexturedModalRect(15, 6, 98, 0, guiWidth, guiHeight);
			}
			GL11.glPopMatrix();

			// Yellow meter
			GL11.glPushMatrix();
			GL11.glTranslatef((screenWidth - guiWidth * scale) + (guiWidth - guiBarWidth) * scale + (24 * scale) - posX, (screenHeight - guiHeight * scale) - (2 * scale) - posY, 0);
			GL11.glScalef(scale, scale, scale);
			if (STATE.getActiveDriveName().equals("none")) {
				this.drawTexturedModalRect(14, 6, 0, 18, (int) currDrive, guiHeight);
			} else {
				this.drawTexturedModalRect(16, 6, 98, 18, (int) currForm, guiHeight);
			}
			GL11.glPopMatrix();

			// Level
			GL11.glPushMatrix();
			GL11.glTranslatef((screenWidth - guiWidth * scale) + (85 * scale) - posX, (screenHeight - guiHeight * scale) - (2 * scale) - posY, 0);
			GL11.glScalef(scale, scale, scale);

			int numPos = STATE.getActiveDriveName().equals("none") ? getCurrBar(dp, STATE.getDriveGaugeLevel()) * 10 : 97 + (getCurrBar(fp, STATE.getFormGaugeLevel(STATE.getActiveDriveName())) * 10);
			/*
			 * if (STATE.getActiveDriveName().equals("none")) { int numPos = getCurrBar(dp,
			 * STATE.getDriveGaugeLevel()) * 10; } else { int numPos = 98 + (getCurrBar(fp,
			 * STATE.getFormGaugeLevel(STATE.getActiveDriveName())) * 10); }
			 */
			this.drawTexturedModalRect(14, 6, numPos, 38, 9, guiHeight);

			GL11.glPopMatrix();

			if (STATE.getDP() >= getMaxBars(STATE.getDriveGaugeLevel()) && !STATE.getInDrive()) {
				GL11.glPushMatrix();
				{
				//	System.out.println(Minecraft.getSystemTime()+" : "+timeLastChange);
					if (doChange) {
						//counter += 100;
						// System.out.println(nextColor);
						// r=255; g=255;b=255;
						switch (nextColor) {
						case "r":
							if (r <= 255 - CONS) {
								r += CONS;
							}
							if (g - CONS >= 0) {
								g -= CONS;
							}

							if (b - CONS >= 0) {
								b -= CONS;
							}

							if (r >= 255 && g <= 0 && b <= 0) {
								nextColor = "g";
							}
							break;
						case "g":
							if (r - CONS >= 0) {
								r -= CONS;
							}
							if (g <= 255 - CONS) {
								g += CONS;
							}

							if (b - CONS >= 0) {
								b -= CONS;
							}

							if (r <= 0 && g >= 255 && b <= 0) {
								nextColor = "b";
							}
							break;
						case "b":
							if (r - CONS >= 0) {
								r -= CONS;
							}
							if (g - CONS >= 0) {
								g -= CONS;
							}

							if (b <= 255 - CONS) {
								b += CONS;
							}

							if (r <= 0 && g <= 0 && b >= 255) {
								nextColor = "w";
							}
							break;
						case "w":
							if (r <= 255 - CONS) {
								r += CONS;
							}
							if (g <= 255 - CONS) {
								g += CONS;
							}

							if (b <= 255 - CONS) {
								b += CONS;
							}

							if (r >= 255 && g >= 255 && b >= 255) {
								nextColor = "r";
							}
							break;
						}

						// System.out.println(r+" "+g+" "+b);

						GL11.glColor3ub((byte) r, (byte) g, (byte) b);

						timeLastChange = (int) Minecraft.getSystemTime();
						doChange = false;
						
						
					} else {
						if (timeLastChange + 1 < (int) Minecraft.getSystemTime()) {
							doChange = true;
						}
					}

					GL11.glTranslatef(((screenWidth - guiWidth * scale) + (10 * scale)), ((screenHeight - guiHeight * scale) - (12 * scale)), 0);
					GL11.glScalef(scale, scale, scale);
					this.drawTexturedModalRect(0, 0, 0, 57, 30, guiHeight);
					GL11.glColor3ub((byte) 255, (byte) 255, (byte) 255);
				}
				GL11.glPopMatrix();
			}
			/*
			 * else { GL11.glPushMatrix(); GL11.glTranslatef((screenWidth - guiWidth*scale),
			 * screenHeight - guiHeight*scale - 17, 0);
			 * this.drawTexturedModalRect((screenWidth - guiWidth - 23), screenHeight -
			 * guiHeight - 20, 0, 100, 30, guiHeight); GL11.glPopMatrix(); }
			 */
		}
	}
}
