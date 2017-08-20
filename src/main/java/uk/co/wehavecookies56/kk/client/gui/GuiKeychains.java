package uk.co.wehavecookies56.kk.client.gui;

import java.io.IOException;

import org.lwjgl.opengl.GL11;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.items.ItemStackHandler;
import uk.co.wehavecookies56.kk.client.core.handler.InputHandler;
import uk.co.wehavecookies56.kk.client.core.helper.GuiHelper;
import uk.co.wehavecookies56.kk.common.capability.ModCapabilities;
import uk.co.wehavecookies56.kk.common.capability.MunnyCapability.IMunny;
import uk.co.wehavecookies56.kk.common.container.ContainerKeychain;
import uk.co.wehavecookies56.kk.common.container.inventory.InventoryKeychain;
import uk.co.wehavecookies56.kk.common.core.handler.MainConfig;
import uk.co.wehavecookies56.kk.common.lib.Reference;
import uk.co.wehavecookies56.kk.common.lib.Strings;
import uk.co.wehavecookies56.kk.common.util.Utils;

public class GuiKeychains extends GuiContainer {

    final int CLEARENCH = 1;
    GuiButton clearench;

    private float xSize_lo;

    private float ySize_lo;

    private static final ResourceLocation iconLocation = new ResourceLocation("kk", "textures/gui/keychain_inv.png");

    private final ItemStackHandler inventory;

    public GuiKeychains (EntityPlayer player, InventoryPlayer inventoryPlayer) {
        super(new ContainerKeychain(player, inventoryPlayer));
        this.inventory = player.getCapability(ModCapabilities.SUMMON_KEYBLADE, null).getInventoryKeychain();
    }

    @Override
    protected void keyTyped (char c, int keyCode) throws IOException {
        super.keyTyped(c, keyCode);
        if (keyCode == InputHandler.Keybinds.OPENMENU.getKeybind().getKeyCode()) GuiHelper.openMenu_Items();
    }

    @Override
    public void drawScreen (int mouseX, int mouseY, float f) {
        xSize_lo = mouseX;
        ySize_lo = mouseY;
        drawBackground(width, height);
        super.drawScreen(mouseX, mouseY, f);
        renderHoveredToolTip(mouseX, mouseY);
    }

    public static final ResourceLocation optionsBackground = new ResourceLocation(Reference.MODID, "textures/gui/menubg.png");

    public static String getWorldMinutes (World world) {
        int time = (int) Math.abs((world.getWorldTime() + 6000) % 24000);
        if ((time % 1000) * 6 / 100 < 10)
            return "0" + (time % 1000) * 6 / 100;
        else
            return Integer.toString((time % 1000) * 6 / 100);
    }

    @Override
    public boolean doesGuiPauseGame () {
        return false;
    }

    public static int getWorldHours (World world) {
        int time = (int) Math.abs((world.getWorldTime() + 6000) % 24000);
        return (int) (time / 1000F);
    }

    protected void drawBackground (int screenWidth, int screenHeight) {
        Minecraft.getMinecraft().renderEngine.bindTexture(optionsBackground);
        GL11.glPushMatrix();
        {
            GL11.glColor4ub((byte) MainConfig.client.hud.interfaceColour[0], (byte) MainConfig.client.hud.interfaceColour[1], (byte) MainConfig.client.hud.interfaceColour[2], (byte) 255);
            drawDefaultBackground();
            drawModalRectWithCustomSizedTexture(0, -140 / 16, 0, 0, screenWidth, 70, 32, 32);
            drawModalRectWithCustomSizedTexture(0, screenHeight - ((screenHeight / 8) + 70 / 16), 0, 0, screenWidth, 70, 32, 32);
        }
        GL11.glPopMatrix();
        GL11.glPushMatrix();
        {
            GL11.glScalef(2, 2, 2);
            String title = mc.player.getDisplayNameString().toString();
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
        }
        GL11.glPopMatrix();
    }

    @Override
    protected void drawGuiContainerForegroundLayer (int mouseX, int mouseY) {
        String s = Strings.Form_Valor;
        fontRenderer.drawString(Utils.translateToLocal(Strings.MainKeychain), 30, 11, 4210752);
        fontRenderer.drawString(Utils.translateToLocal(Strings.Form_Valor), 30, 30, 4210752);
        fontRenderer.drawString(Utils.translateToLocal(Strings.Form_Master), 30, 49, 4210752);
        fontRenderer.drawString(Utils.translateToLocal(Strings.Form_Final), 30, 68, 4210752);
    }

    @Override
    protected void drawGuiContainerBackgroundLayer (float f, int mouseX, int mouseY) {
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        mc.getTextureManager().bindTexture(iconLocation);
        drawTexturedModalRect(guiLeft, guiTop, 0, 0, xSize, ySize);
    }

}
