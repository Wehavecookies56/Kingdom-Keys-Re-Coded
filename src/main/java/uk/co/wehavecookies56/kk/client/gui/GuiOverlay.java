package uk.co.wehavecookies56.kk.client.gui;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.TextFormatting;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.client.event.RenderGameOverlayEvent.ElementType;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.lwjgl.opengl.GL11;
import uk.co.wehavecookies56.kk.common.capability.ModCapabilities;
import uk.co.wehavecookies56.kk.common.capability.PlayerStatsCapability;
import uk.co.wehavecookies56.kk.common.core.handler.MainConfig;
import uk.co.wehavecookies56.kk.common.lib.Reference;
import uk.co.wehavecookies56.kk.common.lib.Strings;
import uk.co.wehavecookies56.kk.common.util.Utils;

import java.awt.Color;

public class GuiOverlay extends GuiScreen {
    public static boolean showExp;
    public static boolean showMunny;
    public static boolean showLevelUp;
    public static long timeExp;
    public static long timeMunny;
    public static long timeLevelUp;
    public static int munnyGet;
    int levelSeconds = 6;

    @SubscribeEvent
    @SideOnly (Side.CLIENT)
    public void RenderGameOverlayEvent (RenderGameOverlayEvent event) {
        if (event.getType() == ElementType.TEXT) {
            Minecraft mc = Minecraft.getMinecraft();
            int screenWidth = event.getResolution().getScaledWidth();
            int screenHeight = event.getResolution().getScaledHeight();
            PlayerStatsCapability.IPlayerStats STATS = mc.player.getCapability(ModCapabilities.PLAYER_STATS, null);
            if (showExp) {
                String reqExp = String.valueOf(STATS.getExpNeeded(STATS.getLevel(), STATS.getExperience()));
                mc.fontRenderer.drawString("Next LV", 5, 5, 0xFFFFFF);
                mc.fontRenderer.drawString(reqExp, 5, 5 + mc.fontRenderer.FONT_HEIGHT, 0xFFFFFF);
                if (timeExp + 4 <= (int) Minecraft.getSystemTime() / 1000) showExp = false;
            }
            if (showMunny) {
                if (!showExp) {
                    GL11.glPushMatrix();
                    GL11.glTranslatef(1, 1, 0);
                    mc.fontRenderer.drawString("Munny Get!", 5, 5, 0xFFFFFF);
                    mc.fontRenderer.drawString(munnyGet + "", 5, 5 + mc.fontRenderer.FONT_HEIGHT, 0xFFFFFF);
                    GL11.glPopMatrix();
                } else {
                    mc.fontRenderer.drawString("Munny Get!", 5, 5 + mc.fontRenderer.FONT_HEIGHT + 10, 0xFFFFFF);
                    mc.fontRenderer.drawString(munnyGet + "", 5, 5 + (mc.fontRenderer.FONT_HEIGHT * 2) + 10, 0xFFFFFF);
                }
                if (timeMunny + 4 <= (int) Minecraft.getSystemTime() / 1000) showMunny = false;
            }
            if (showLevelUp) {
                ResourceLocation texture = new ResourceLocation(Reference.MODID, "textures/gui/levelup.png");
                GL11.glPushMatrix();
                {
                    int height = (mc.fontRenderer.FONT_HEIGHT - 3) * STATS.getMessages().size();
                    GL11.glEnable(GL11.GL_BLEND);
                    GL11.glColor4ub((byte) MainConfig.client.hud.interfaceColour[0], (byte) MainConfig.client.hud.interfaceColour[1], (byte) MainConfig.client.hud.interfaceColour[2], (byte) 255);
                    GL11.glPushMatrix();
                    {
                        mc.renderEngine.bindTexture(texture);
                        int width = event.getResolution().getScaledWidth();
                        GL11.glPushMatrix();
                        {
                            GL11.glTranslatef((width - 153.6f - 2), 0, 0);
                            GL11.glScalef(0.6f, 0.6f, 1);
                            drawTexturedModalRect(0, 0, 0, 0, 256, 36);
                        }
                        GL11.glPopMatrix();
                        GL11.glPushMatrix();
                        {
                            GL11.glTranslatef(width - ((mc.fontRenderer.getStringWidth("LEVEL UP!")) * 0.75f) - 115, 4, 0);
                            GL11.glScalef(0.75f, 0.75f, 1);
                            drawString(mc.fontRenderer, "LEVEL UP!" + TextFormatting.ITALIC, 0, 0, Color.decode(String.format("#%02x%02x%02x", (byte) MainConfig.client.hud.interfaceColour[0], (byte) MainConfig.client.hud.interfaceColour[1], (byte) MainConfig.client.hud.interfaceColour[2])).hashCode());
                        }
                        GL11.glPopMatrix();
                        GL11.glPushMatrix();
                        {
                            GL11.glPushMatrix();
                            {
                                GL11.glTranslatef(width - ((mc.fontRenderer.getStringWidth("LV. ")) * 0.75f) - 90, 4, 0);
                                GL11.glScalef(0.75f, 0.75f, 1);
                                drawString(mc.fontRenderer, "LV.", 0, 0, 0xE3D000);
                            }
                            GL11.glPopMatrix();
                            GL11.glPushMatrix();
                            {
                                GL11.glTranslatef(width - 256.0f * 0.75f + ((mc.fontRenderer.getStringWidth("999")) * 0.75f) + 88, 4, 0);
                                GL11.glScalef(0.75f, 0.75f, 1);
                                drawString(mc.fontRenderer, "" + STATS.getLevel(), 0, 0, 0xFFFFFF);
                            }
                            GL11.glPopMatrix();
                            GL11.glPushMatrix();
                            {
                                GL11.glTranslatef(width - ((mc.fontRenderer.getStringWidth(mc.player.getDisplayNameString())) * 0.75f) - 7, 4, 0);
                                GL11.glScalef(0.75f, 0.75f, 1);
                                drawString(mc.fontRenderer, mc.player.getDisplayNameString(), 0, 0, 0xFFFFFF);
                            }
                            GL11.glPopMatrix();
                        }
                        GL11.glPopMatrix();
                    }
                    GL11.glPopMatrix();
                    GL11.glColor4ub((byte) MainConfig.client.hud.interfaceColour[0], (byte) MainConfig.client.hud.interfaceColour[1], (byte) MainConfig.client.hud.interfaceColour[2], (byte) 255);
                    GL11.glPushMatrix();
                    {
                        mc.renderEngine.bindTexture(texture);
                        int width = event.getResolution().getScaledWidth();
                        GL11.glTranslatef((width - 256.0f * 0.6f - 2), 36.0f * 0.6f, 0);
                        GL11.glScalef(0.6f, height, 1);
                        drawTexturedModalRect(0, 0, 0, 36, 256, 1);
                    }
                    GL11.glPopMatrix();
                    GL11.glColor4ub((byte) MainConfig.client.hud.interfaceColour[0], (byte) MainConfig.client.hud.interfaceColour[1], (byte) MainConfig.client.hud.interfaceColour[2], (byte) 255);
                    GL11.glPushMatrix();
                    {
                        mc.renderEngine.bindTexture(texture);
                        int width = event.getResolution().getScaledWidth();
                        GL11.glTranslatef((width - 256.0f * 0.6f - 2), height + (36.0f * 0.6f), 0);
                        GL11.glScalef(0.6f, 0.6f, 1);
                        drawTexturedModalRect(0, 0, 0, 37, 256, 14);
                    }
                    GL11.glPopMatrix();
                    GL11.glColor4ub((byte) MainConfig.client.hud.interfaceColour[0], (byte) MainConfig.client.hud.interfaceColour[1], (byte) MainConfig.client.hud.interfaceColour[2], (byte) 255);
                    String message = "";
                    String strMessage = "Strength Increased!";
                    String defMessage = "Defense Increased!";
                    String magMessage = "Magic Increased!";
                    String hpMessage = "Maximum HP Increased!";
                    for (int i = 0; i < STATS.getMessages().size(); i++) {
                        GL11.glPushMatrix();
                        {
                            int width = event.getResolution().getScaledWidth();

                            if (STATS.getMessages().get(i).toString().equals("str"))
                                message = Strings.Stats_LevelUp_Str;
                            else if (STATS.getMessages().get(i).toString().equals("def"))
                                message = Strings.Stats_LevelUp_Def;
                            else if (STATS.getMessages().get(i).toString().equals("mag"))
                                message = Strings.Stats_LevelUp_Magic;
                            else if (STATS.getMessages().get(i).toString().equals("hp"))
                                message = Strings.Stats_LevelUp_HP;
                            GL11.glTranslatef((width - 256.0f * 0.8f + (mc.fontRenderer.getStringWidth("Maximum HP Increased!")) * 0.8f), mc.fontRenderer.FONT_HEIGHT * 0.8f * i + 23, 0);
                            GL11.glTranslatef(-35, 0, 0);
                            GL11.glScalef(0.8f, 0.8f, 1);
                            drawString(mc.fontRenderer, Utils.translateToLocal(message), 0, 0, 0xFFFFFF);

                        }
                        GL11.glPopMatrix();
                    }
                    GL11.glColor4ub((byte) 255, (byte) 255, (byte) 255, (byte) 255);
                }
                GL11.glPopMatrix();
                if (timeLevelUp + levelSeconds <= (int) Minecraft.getSystemTime() / 1000) showLevelUp = false;
            }
        }
    }
}