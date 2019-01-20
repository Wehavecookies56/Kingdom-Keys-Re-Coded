package uk.co.wehavecookies56.kk.client.gui;

import java.io.IOException;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.inventory.GuiInventory;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.MoverType;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;
import uk.co.wehavecookies56.kk.client.core.helper.GuiHelper;
import uk.co.wehavecookies56.kk.client.gui.redesign.GuiAbilities;
import uk.co.wehavecookies56.kk.client.gui.redesign.GuiMenuButton;
import uk.co.wehavecookies56.kk.common.capability.ModCapabilities;
import uk.co.wehavecookies56.kk.common.capability.PlayerStatsCapability;
import uk.co.wehavecookies56.kk.common.lib.Reference;
import uk.co.wehavecookies56.kk.common.lib.Strings;
import uk.co.wehavecookies56.kk.common.util.Utils;

public class GuiMenu extends GuiScreen {

    public GuiMenu () {
        background = new GuiMenu_Bars(Strings.Gui_Menu);
        mc = Minecraft.getMinecraft();
    }

    final int ITEMS = 0, ABILITIES = 1, CUSTOMIZE = 2, PARTY = 3, STATUS = 4, JOURNAL = 5, CONFIG = 6;
    final int SUBMENU_MAIN = 0, SUBMENU_ITEMS = 1;

    GuiButton items, abilities, customize, party, status, journal, config;

    GuiMenu_Bars background;

    static int munny;

    int submenuIndex = SUBMENU_MAIN;

    @Override
    protected void actionPerformed (GuiButton button) throws IOException {
    	System.out.println("ASD");

        switch (button.id) {
            case ITEMS:
                mc.displayGuiScreen(new GuiMenu_Items());
                break;
            case CUSTOMIZE:
            	GuiHelper.openCustomize();
            	break;
            case STATUS:
                GuiHelper.openStatus();
                break;
            case JOURNAL:
                GuiHelper.openReports();
                break;
            case CONFIG:
                GuiHelper.openMenu_Config();
                break;
            case ABILITIES:
                mc.displayGuiScreen(new GuiAbilities());
                break;
        }
        updateButtons();
    }

    @Override
    public void initGui () {
        super.initGui();
        background.width = width;
        background.height = height;
        background.init();
        float topBarHeight = (float)height * 0.17F;
        int button_itemsY = (int)topBarHeight+5;
        int button_abilitiesY = button_itemsY + 19;
        int button_customizeY = button_abilitiesY + 19;
        int button_partyY = button_customizeY + 19;
        int button_statusY = button_partyY + 19;
        int button_journalY = button_statusY + 19;
        int button_configY = button_journalY + 19;
        float buttonPosX = (float)width * 0.1526F;
        float buttonWidth = ((float)width * 0.1744F)-22;

        buttonList.add(items = new GuiMenuButton(ITEMS, (int)buttonPosX, button_itemsY, (int)buttonWidth, Utils.translateToLocal(Strings.Gui_Menu_Main_Button_Items)));
        buttonList.add(abilities = new GuiMenuButton(ABILITIES, (int)buttonPosX, button_abilitiesY, (int)buttonWidth, Utils.translateToLocal(Strings.Gui_Menu_Main_Button_Abilities)));
        buttonList.add(customize = new GuiMenuButton(CUSTOMIZE, (int)buttonPosX, button_customizeY, (int)buttonWidth, Utils.translateToLocal(Strings.Gui_Menu_Main_Button_Customize)));
        buttonList.add(party = new GuiMenuButton(PARTY, (int)buttonPosX, button_partyY, (int)buttonWidth, Utils.translateToLocal(Strings.Gui_Menu_Main_Button_Party)));
        buttonList.add(status = new GuiMenuButton(STATUS, (int)buttonPosX, button_statusY, (int)buttonWidth, Utils.translateToLocal(Strings.Gui_Menu_Main_Button_Status)));
        buttonList.add(journal = new GuiMenuButton(JOURNAL, (int)buttonPosX, button_journalY, (int)buttonWidth, Utils.translateToLocal(Strings.Gui_Menu_Main_Button_Journal)));
        buttonList.add(config = new GuiMenuButton(CONFIG, (int)buttonPosX, button_configY, (int)buttonWidth, Utils.translateToLocal(Strings.Gui_Menu_Main_Button_Config)));

        updateButtons();
    }

    private void updateButtons () {
        switch (submenuIndex) {
            case SUBMENU_MAIN:
                this.items.visible = true;
                abilities.visible = true;
                customize.visible = true;
                party.visible = true;
                status.visible = true;
                journal.visible = true;
                config.visible = true;
                this.customize.enabled = true;
                this.party.enabled = false;
                this.journal.enabled = true;
                break;
            case SUBMENU_ITEMS:
                items.visible = false;
                abilities.visible = false;
                customize.visible = false;
                party.visible = false;
                status.visible = false;
                journal.visible = false;
                config.visible = false;
                break;
        }
    }

    @Override
    public void drawScreen(int mouseX, int mouseY, float partialTicks) {
        background.drawBars();
        background.drawMunnyTime();
        background.drawBiomeDim();
        drawPlayer();
        super.drawScreen(mouseX, mouseY, partialTicks);
    }

    public void drawPlayer() {
        float playerWidth = width * 0.1041F;
        float playerHeight = height * 0.4481F;
        float playerPosX = width * 0.5229F;
        float playerPosY = height * 0.7518F;
        GlStateManager.pushMatrix();
        {
            EntityPlayer player = mc.player;
            //player.getSwingProgress(1);
            GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
            GuiInventory.drawEntityOnScreen((int)playerPosX, (int)playerPosY, (int)playerHeight / 2, 0, 0, player);
            // GL11.glColor4f(1.0F, 1.0F, 1.0F, 0.75F);
        }
        GlStateManager.popMatrix();
        GlStateManager.pushMatrix();
        GlStateManager.color(1,1,1);
        GlStateManager.translate(1,1, 100);
        GlStateManager.enableAlpha();
        GlStateManager.enableBlend();
        mc.renderEngine.bindTexture(new ResourceLocation(Reference.MODID, "textures/gui/menu/menu_button.png"));
        float infoBoxWidth = ((float)width * 0.1385F) - 14;
        float infoBoxPosX = (float)width * 0.4354F;
        float infoBoxPosY = (float)height * 0.624F;
        drawTexturedModalRect(infoBoxPosX, infoBoxPosY, 123, 67, 11, 22);
        for (int i = 0; i < infoBoxWidth; i++) {
            drawTexturedModalRect(infoBoxPosX+11+i, infoBoxPosY, 135, 67, 1, 22);
        }
        drawTexturedModalRect(infoBoxPosX+11+infoBoxWidth, infoBoxPosY, 137, 67, 3, 22);
        drawTexturedModalRect(infoBoxPosX, infoBoxPosY+22, 123, 90, 3, 47);
        for (int i = 0; i < infoBoxWidth+8; i++) {
            drawTexturedModalRect(infoBoxPosX+3+i, infoBoxPosY + 22, 127, 90, 1, 47);
        }
        drawTexturedModalRect(infoBoxPosX+3+infoBoxWidth+8, infoBoxPosY+22, 129, 90, 3, 47);
        GlStateManager.popMatrix();
        GlStateManager.pushMatrix();
        {
            GlStateManager.translate(1,1, 100);
            PlayerStatsCapability.IPlayerStats STATS = mc.player.getCapability(ModCapabilities.PLAYER_STATS, null);
            GlStateManager.pushMatrix();
            GlStateManager.translate((int)infoBoxPosX+8, (int)infoBoxPosY + ((22/2) - (mc.fontRenderer.FONT_HEIGHT / 2)), 1);
            //GlStateManager.scale(0.75F, 0.75F, 1);
            drawString(fontRenderer, mc.player.getDisplayNameString().toString(), 0, 0, 0xFFFFFF);
            GlStateManager.popMatrix();
            drawString(fontRenderer, "LV: " + STATS.getLevel(), (int)infoBoxPosX+4, (int)(infoBoxPosY + 26), 0xFFD900);
            drawString(fontRenderer, "HP: " + (int) mc.player.getHealth() + "/" + (int) mc.player.getMaxHealth(), (int)infoBoxPosX+4, (int)(infoBoxPosY + 26)+mc.fontRenderer.FONT_HEIGHT, 0x00FF00);
            drawString(fontRenderer, "MP: " + (int) STATS.getMP() + "/" + (int) STATS.getMaxMP(), (int)infoBoxPosX+4, (int)(infoBoxPosY + 26)+(mc.fontRenderer.FONT_HEIGHT*2), 0x4444FF);

        }
        GlStateManager.popMatrix();
    }

}
