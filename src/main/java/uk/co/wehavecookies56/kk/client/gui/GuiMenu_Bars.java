package uk.co.wehavecookies56.kk.client.gui;

import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.renderer.GlStateManager;
import org.lwjgl.opengl.GL11;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.inventory.GuiInventory;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import uk.co.wehavecookies56.kk.client.gui.redesign.GuiElementBar;
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
        mc = Minecraft.getMinecraft();
    }

    public boolean drawPlayerInfo;

    GuiElementBar bottomLeftBar, bottomRightBar, topLeftBar, topRightBar;

    float topBarHeight;
    float bottomBarHeight;
    float topLeftBarWidth;
    float topRightBarWidth;
    float topGap;
    float bottomLeftBarWidth;
    float bottomRightBarWidth;
    float bottomGap;
    float middleHeight;

    @Override
    public void drawScreen (int mouseX, int mouseY, float partialTicks) {
        RenderHelper.disableStandardItemLighting();
        drawBackground(width, height, drawPlayerInfo);
        if (drawPlayerInfo) {

        }

        super.drawScreen(mouseX, mouseY, partialTicks);
    }

    public void drawBars() {
        drawDefaultBackground();
        ScaledResolution sr = new ScaledResolution(Minecraft.getMinecraft());
        for (int i = 0; i < sr.getScaledHeight(); i+=3) {
            GlStateManager.pushMatrix();
            GlStateManager.color(1,1,1);
            GlStateManager.enableAlpha();
            GlStateManager.enableBlend();
            mc.renderEngine.bindTexture(menu);
            GlStateManager.translate(0, i, 0);
            GlStateManager.scale(sr.getScaledWidth(), 1,1);
            drawTexturedModalRect(0, 0, 77, 92, 1, 1);
            GlStateManager.popMatrix();
        }
        topLeftBar.draw();
        topRightBar.draw();
        bottomLeftBar.draw();
        bottomRightBar.draw();
    }

    public void drawBiomeDim() {
        GlStateManager.pushMatrix();
        {
            drawString(mc.fontRenderer, mc.player.world.provider.getDimensionType().getName(), width - mc.fontRenderer.getStringWidth(mc.player.world.provider.getDimensionType().getName()) - 5, 5, 0xF58B33);
            drawString(mc.fontRenderer, mc.player.world.getBiome(mc.player.getPosition()).getBiomeName(), width - mc.fontRenderer.getStringWidth(mc.player.world.getBiome(mc.player.getPosition()).getBiomeName()) - 5, 20, 0xF58B33);
        }
        GlStateManager.popMatrix();
    }
        public void drawMunnyTime() {
        GlStateManager.pushMatrix();
        {
            drawString(mc.fontRenderer, Utils.translateToLocal(Strings.Gui_Menu_Main_Time) + ": " + getWorldHours(mc.world) + ":" + getWorldMinutes(mc.world), 5, (int)(topBarHeight + middleHeight) + mc.fontRenderer.FONT_HEIGHT, 0xFFFFFF);
            IMunny MUNNY = mc.player.getCapability(ModCapabilities.MUNNY, null);
            drawString(mc.fontRenderer, Utils.translateToLocal(Strings.Gui_Menu_Main_Munny) + ": " + MUNNY.getMunny(), 5, (int)(topBarHeight + middleHeight), 0xF66627);
            long seconds = mc.world.getTotalWorldTime()/20;
            long h = seconds/3600;
            long m = seconds%3600/60;
            long s = seconds%3600%60;

            String sec=s<10?0+""+s:s+"";
            String min=m<10?0+""+m:m+"";
            String hou=h<10?0+""+h:h+"";
            String time = hou+":"+min+":"+sec;
            drawString(mc.fontRenderer, Utils.translateToLocal(Strings.Gui_Menu_Main_Time_Spent) + ": " + time, 5, (int)(topBarHeight + middleHeight) + (mc.fontRenderer.FONT_HEIGHT*2), 0x42ceff);
        }
        GlStateManager.popMatrix();
    }

    public static final ResourceLocation optionsBackground = new ResourceLocation(Reference.MODID, "textures/gui/menubg.png");
    public static final ResourceLocation menu = new ResourceLocation(Reference.MODID, "textures/gui/menu/menu_button.png");

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

    public void init() {
        ScaledResolution sr = new ScaledResolution(Minecraft.getMinecraft());
        setWorldAndResolution(Minecraft.getMinecraft(), sr.getScaledWidth(), sr.getScaledHeight());
        topBarHeight = (float)height * 0.17F;
        bottomBarHeight = (float)height * 0.23F;
        topLeftBarWidth = (float)width * 0.175F;
        topRightBarWidth = (float)(width) * 0.82F;
        topGap = (float)width * 0.005F;
        bottomLeftBarWidth = (float)width * 0.304F;
        bottomRightBarWidth = (float)width * 0.6875F;
        bottomGap = (float) width * 0.0085F;
        middleHeight = (float)height * 0.6F;
        topLeftBar = new GuiElementBar(-10,-10, (int)topLeftBarWidth+10, (int)topBarHeight+10, true);
        topRightBar = new GuiElementBar((int)(topLeftBarWidth + topGap),-10, (int)topRightBarWidth+10, (int)topBarHeight+10, true);
        bottomLeftBar = new GuiElementBar(-10,(int)(topBarHeight + middleHeight), (int)bottomLeftBarWidth+10, (int)bottomBarHeight+10, false);
        bottomRightBar = new GuiElementBar((int)(bottomLeftBarWidth + bottomGap),(int)(topBarHeight + middleHeight), (int)bottomRightBarWidth+10, (int)bottomBarHeight+10, false);
    }

    protected void drawBackground (int screenWidth, int screenHeight, boolean drawPlayer) {
        Minecraft.getMinecraft().renderEngine.bindTexture(optionsBackground);

        /*
        GlStateManager.pushMatrix();
        {
            GL11.glColor4ub((byte) MainConfig.client.hud.interfaceColour[0], (byte) MainConfig.client.hud.interfaceColour[1], (byte) MainConfig.client.hud.interfaceColour[2], (byte) 255);
            // GL11.glColor4f(0.3F, 0.3F, 0.3F, 1.0F);
            // GL11.glScalef(2f, 2f, 2f);
            drawDefaultBackground();
            drawModalRectWithCustomSizedTexture(0, 0, 0, 0, screenWidth, 60, 32, 32);
            drawModalRectWithCustomSizedTexture(0, screenHeight - ((screenHeight / 8) + 70 / 16), 0, 0, screenWidth, 70, 32, 32);
        }
        GlStateManager.popMatrix();
        GlStateManager.pushMatrix();
        {
            GlStateManager.scale(2, 2, 2);
            String title = Utils.translateToLocal(name);
            drawString(fontRenderer, title, 5, 5, 0xFFFFFF);
        }
        GlStateManager.popMatrix();
        */

        if (drawPlayer) {

        }
    }

}
