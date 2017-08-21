package uk.co.wehavecookies56.kk.client.gui;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.lwjgl.opengl.GL11;
import uk.co.wehavecookies56.kk.common.capability.DriveStateCapability;
import uk.co.wehavecookies56.kk.common.capability.ModCapabilities;
import uk.co.wehavecookies56.kk.common.capability.PlayerStatsCapability;
import uk.co.wehavecookies56.kk.common.core.handler.MainConfig;
import uk.co.wehavecookies56.kk.common.lib.Constants;
import uk.co.wehavecookies56.kk.common.lib.Reference;

@SideOnly (Side.CLIENT)
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

    public GuiDrive () {

    }

    public int getMaxBars(int level) {
        return level * 100;
    }

    public int getCurrBar (double dp, int level) {
        int bar = (int)dp / 100;
        if (bar > level)
            bar = level;
        return bar;
    }

    byte counter = 0;
    @SubscribeEvent
    public void onRenderOverlayPost (RenderGameOverlayEvent event) {
        if (!MainConfig.displayGUI())
            return;
        if(!mc.player.getCapability(ModCapabilities.PLAYER_STATS, null).getHudMode()) return;

        PlayerStatsCapability.IPlayerStats STATS = mc.player.getCapability(ModCapabilities.PLAYER_STATS, null);
        DriveStateCapability.IDriveState STATE = mc.player.getCapability(ModCapabilities.DRIVE_STATE, null);
        double dp = STATS.getDP();
        double fp = STATS.getFP();

        currDrive = (float) ((oneValue * dp) - getCurrBar(dp, STATE.getDriveGaugeLevel()) * guiLength);
        if (STATE.getInDrive())
            currForm = (float) ((oneValue * fp) - getCurrBar(fp, STATE.getFormGaugeLevel(STATE.getActiveDriveName())) * guiLength);
        //if ((dp == 100 || dp == 200 || dp == 300 || dp == 400 || dp == 500 || dp == 600 || dp == 700 || dp == 800 || dp == 900) && dp != getMaxBars(STATE.getDriveGaugeLevel())) currDrive = 0;
        if (dp == getMaxBars(STATE.getDriveGaugeLevel())) {
            currDrive = guiLength;
        }
        if (event.getType() == RenderGameOverlayEvent.ElementType.HOTBAR) {
            if (!STATE.getActiveDriveName().equals("none")) {
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
                this.drawTexturedModalRect(15, 6, 0, 18, (int) currDrive, guiHeight);
            } else {
                this.drawTexturedModalRect(15, 6, 98, 18, (int) currForm, guiHeight);
            }
            GL11.glPopMatrix();
            // Level
            GL11.glPushMatrix();
            GL11.glTranslatef((screenWidth - guiWidth * scale) + (85 * scale) - posX, (screenHeight - guiHeight * scale) - (2 * scale) - posY, 0);
            GL11.glScalef(scale, scale, scale);
            if (STATE.getActiveDriveName().equals("none")) {
                int numPos = getCurrBar(dp, STATE.getDriveGaugeLevel()) * 10;
                this.drawTexturedModalRect(14, 6, numPos, 38, 8, guiHeight);
            } else {
                int numPos = 98 + (getCurrBar(fp, STATE.getFormGaugeLevel(STATE.getActiveDriveName())) * 10);
                this.drawTexturedModalRect(14, 6, numPos, 38, 8, guiHeight);
            }
            GL11.glPopMatrix();
            if (STATS.getDP() >= getMaxBars(STATE.getDriveGaugeLevel()) && !STATE.getInDrive()) {
                GL11.glPushMatrix();
                counter++;
                /*
                switch (counter) {
                    case 1:
                        GL11.glColor3ub((byte) 255, (byte) 50, (byte) 40);
                        break;
                    case 2:
                        GL11.glColor3ub((byte) 35, (byte) 255, (byte) 50);
                        break;
                    case 3:
                        GL11.glColor3ub((byte) 35, (byte) 50, (byte) 255);
                        break;
                }*/
                if(counter > 0 && counter < 50)
                    GL11.glColor3ub((byte) 255, (byte) 50, (byte) 40);
                else if(counter >= 50 && counter < 100)
                    GL11.glColor3ub((byte) 35, (byte) 255, (byte) 50);
                else if(counter >= 100 && counter < 150)
                    GL11.glColor3ub((byte) 35, (byte) 50, (byte) 255);
                else if(counter >= 150 && counter < 200)     
                	GL11.glColor3ub((byte) 255, (byte) 255, (byte) 255);
                else if(counter >= 200)
                     	counter = 0;
                GL11.glTranslatef(((screenWidth - guiWidth * scale) + (10 * scale)), ((screenHeight - guiHeight * scale) - (12 * scale)), 0);
                GL11.glScalef(scale, scale, scale);
                this.drawTexturedModalRect(0, 0, 0, 57, 30, guiHeight);
                GL11.glColor3ub((byte) 255, (byte) 255, (byte) 255);

                GL11.glPopMatrix();
            }
            /*
             * else { GL11.glPushMatrix(); GL11.glTranslatef((screenWidth -
             * guiWidth*scale), screenHeight - guiHeight*scale - 17, 0);
             * this.drawTexturedModalRect((screenWidth - guiWidth - 23),
             * screenHeight - guiHeight - 20, 0, 100, 30, guiHeight);
             * GL11.glPopMatrix(); }
             */
        }
    }
}
