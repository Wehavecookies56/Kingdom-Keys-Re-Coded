package uk.co.wehavecookies56.kk.client.gui;

import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.util.ResourceLocation;
import uk.co.wehavecookies56.kk.common.capability.ModCapabilities;
import uk.co.wehavecookies56.kk.common.lib.Reference;
import uk.co.wehavecookies56.kk.common.network.packet.PacketDispatcher;
import uk.co.wehavecookies56.kk.common.network.packet.server.OrgMemberSelect;
import uk.co.wehavecookies56.kk.common.util.Utils;

import java.io.IOException;

import static uk.co.wehavecookies56.kk.common.util.Utils.OrgMember.ROXAS;
import static uk.co.wehavecookies56.kk.common.util.Utils.OrgMember.XEMNAS;

/**
 * Created by Toby on 08/02/2017.
 */
public class GuiOrg extends GuiScreen {

    GuiButton ok, confirm, cancel, next, prev, select;
    final int OK = 0, CONFIRM = 1, CANCEL = 2, NEXT = 3, PREV = 4, SELECT = 5;

    Utils.OrgMember current = Utils.OrgMember.XEMNAS;
    boolean showWelcome = true;
    boolean confirmChoice = false;

    private final int icon_width = 56;
    private final int icon_height = 56;
    private final ResourceLocation[] icons = new ResourceLocation[]{
        new ResourceLocation(Reference.MODID, "textures/gui/org/xemnas_icons.png"),
        new ResourceLocation(Reference.MODID, "textures/gui/org/xigbar_icons.png"),
        new ResourceLocation(Reference.MODID, "textures/gui/org/xaldin_icons.png"),
        new ResourceLocation(Reference.MODID, "textures/gui/org/vexen_icons.png"),
        new ResourceLocation(Reference.MODID, "textures/gui/org/lexaeus_icons.png"),
        new ResourceLocation(Reference.MODID, "textures/gui/org/zexion_icons.png"),
        new ResourceLocation(Reference.MODID, "textures/gui/org/saix_icons.png"),
        new ResourceLocation(Reference.MODID, "textures/gui/org/axel_icons.png"),
        new ResourceLocation(Reference.MODID, "textures/gui/org/demyx_icons.png"),
        new ResourceLocation(Reference.MODID, "textures/gui/org/luxord_icons.png"),
        new ResourceLocation(Reference.MODID, "textures/gui/org/marluxia_icons.png"),
        new ResourceLocation(Reference.MODID, "textures/gui/org/larxene_icons.png"),
        new ResourceLocation(Reference.MODID, "textures/gui/org/roxas_icons.png")
    };
    private final int members = icons.length;

    private final ResourceLocation GLOW = new ResourceLocation(Reference.MODID, "textures/gui/org/glow.png");

    @Override
    public void drawScreen(int mouseX, int mouseY, float partialTicks) {
        drawDefaultBackground();
        String line1 = "By crafting the Organization robe you are now a member of Organization XIII.";
        String line2 = "Choose which member of Organization XIII you align with.";
        String line3 = "Your choice will determine which weapons are available to you.";
        if (showWelcome) {
            drawCenteredString(fontRenderer, line1, (width / 2), height / 2 - fontRenderer.FONT_HEIGHT * 3, 0xFFFFFF);
            drawCenteredString(fontRenderer, line2, (width / 2), height / 2 - fontRenderer.FONT_HEIGHT * 2, 0xFFFFFF);
            drawCenteredString(fontRenderer, line3, (width / 2), height / 2 - fontRenderer.FONT_HEIGHT, 0xFFFFFF);
        } else {
            String name = "";
            String weapon = "";
            int weapon_w = 128;
            int weapon_h = 128;
            switch(current) {
                case XEMNAS:
                    name = "I: Xemnas";
                    weapon = "Ethereal Blades";
                    weapon_w = 99;
                    weapon_h = 112;
                    break;
                case XIGBAR:
                    name = "II: Xigbar";
                    weapon = "Arrowguns";
                    weapon_w = 89;
                    weapon_h = 110;
                    break;
                case XALDIN:
                    name = "III: Xaldin";
                    weapon = "Lances";
                    weapon_w = 86;
                    weapon_h = 109;
                    break;
                case VEXEN:
                    name = "IV: Vexen";
                    weapon = "Shields";
                    weapon_w = 90;
                    weapon_h = 108;
                    break;
                case LEXAEUS:
                    name = "V: Lexaeus";
                    weapon = "Axe Swords";
                    weapon_w = 97;
                    weapon_h = 108;
                    break;
                case ZEXION:
                    name = "VI: Zexion";
                    weapon = "Lexicons";
                    weapon_w = 89;
                    weapon_h = 109;
                    break;
                case SAIX:
                    name = "VII: Saix";
                    weapon = "Claymores";
                    weapon_w = 96;
                    weapon_h = 101;
                    break;
                case AXEL:
                    name = "VIII: Axel";
                    weapon = "Chakrams";
                    weapon_w = 103;
                    weapon_h = 101;
                    break;
                case DEMYX:
                    name = "IX: Demyx";
                    weapon = "Sitars";
                    weapon_w = 85;
                    weapon_h = 104;
                    break;
                case LUXORD:
                    name = "X: Luxord";
                    weapon = "Cards";
                    weapon_w = 104;
                    weapon_h = 89;
                    break;
                case MARLUXIA:
                    name = "XI: Marluxia";
                    weapon = "Scythes";
                    weapon_w = 96;
                    weapon_h = 107;
                    break;
                case LARXENE:
                    name = "XII: Larxene";
                    weapon = "Knives";
                    weapon_w = 106;
                    weapon_h = 68;
                    break;
                case ROXAS:
                    name = "XIII: Roxas";
                    weapon = "Keyblades";
                    weapon_w = 103;
                    weapon_h = 68;
                    break;
            }
            drawDefaultBackground();
            if (confirmChoice) {
                drawCenteredString(fontRenderer, "You wish to align with " + name + "?", (width / 2), height / 2 - fontRenderer.FONT_HEIGHT, 0xFFFFFF);
                drawCenteredString(fontRenderer, "It will cost to change this after you have made your choice.", (width / 2), height / 2, 0xFFFFFF);
            } else {
                GlStateManager.pushMatrix();
                mc.renderEngine.bindTexture(GLOW);
                GlStateManager.enableAlpha();
                GlStateManager.enableBlend();
                drawTexturedModalRect((width / 2) - (256 / 2) - 5, (height / 2) - (256 / 2), 0, 0, 256, 256);
                GlStateManager.popMatrix();
                GlStateManager.pushMatrix();
                mc.renderEngine.bindTexture(icons[current.ordinal()]);
                GlStateManager.enableAlpha();
                GlStateManager.enableBlend();
                drawTexturedModalRect((width / 2) - (weapon_w / 2), (height / 2) - (weapon_h / 2), 56, 0, weapon_w, weapon_h);
                GlStateManager.translate((width / 2) - (8) - 64, (height / 2) - 110, 0);
                GlStateManager.scale(0.5F, 0.5F, 0.5F);
                drawTexturedModalRect(0, 0, 0, 0, icon_width, icon_height);
                GlStateManager.popMatrix();
                drawString(fontRenderer, name, ((width / 2) - (8) - 64) + 2 + icon_width / 2, (height / 2) - 110, 0xFFFFFF);
                drawString(fontRenderer, weapon, ((width / 2) - (8) - 64) + 2 + icon_width / 2, (height / 2) - 110 + fontRenderer.FONT_HEIGHT * 2, 0xFFFFFF);
            }
        }
        super.drawScreen(mouseX, mouseY, partialTicks);
    }

    @Override
    public void initGui() {
        buttonList.clear();
        buttonList.add(ok = new GuiButton(OK, 0, 0, 50, 20, "OK"));
        buttonList.add(confirm = new GuiButton(CONFIRM, 0, 0, 50, 20, "Confirm"));
        buttonList.add(cancel = new GuiButton(CANCEL, 0, 0, 50, 20, "Cancel"));
        buttonList.add(next = new GuiButton(NEXT, 0, 0, 20, 20, ">"));
        buttonList.add(prev = new GuiButton(PREV, 0, 0, 20, 20, "<"));
        buttonList.add(select = new GuiButton(SELECT, 0, 0, 50, 20, "Select"));

        super.initGui();
        updateButtons();
    }

    @Override
    protected void actionPerformed(GuiButton button) throws IOException {
        switch (button.id) {
            case OK:
                //Dismiss welcome message
                showWelcome = false;
                break;
            case NEXT:
                if (current == ROXAS) {
                    current = XEMNAS;
                } else {
                    current = Utils.OrgMember.values()[current.ordinal()+1];
                }
                //Go to the right
                break;
            case PREV:
                //Go to the left
                if (current == XEMNAS) {
                    current = ROXAS;
                } else {
                    current = Utils.OrgMember.values()[current.ordinal()-1];
                }
                break;
            case SELECT:
                //Select the current member
                confirmChoice = true;
                break;
            case CONFIRM:
                //Send choice to server
                PacketDispatcher.sendToServer(new OrgMemberSelect(current));
                mc.player.getCapability(ModCapabilities.ORGANIZATION_XIII, null).setMember(current);
                mc.displayGuiScreen(null);
                break;
            case CANCEL:
                //Go back
                confirmChoice = false;
                break;
           
            
        }
        super.actionPerformed(button);
        updateButtons();
    }

    public void updateButtons() {
        if (showWelcome) {
            ok.visible = true;
            confirm.visible = false;
            cancel.visible = false;
            next.visible = false;
            prev.visible = false;
            select.visible = false;
            ok.x = (width / 2) - (ok.width / 2);
            ok.y = (height / 2) - (ok.height / 2) + fontRenderer.FONT_HEIGHT + 2;
        } else {
            ok.visible = false;
            next.visible = true;
            next.x = (width / 2) - (next.width / 2) + 128;
            next.y = (height / 2) - (next.height / 2);
            prev.visible = true;
            prev.x = (width / 2) - (prev.width / 2) - 128;
            prev.y = (height / 2) - (prev.height / 2);
            select.visible = true;
            select.x = (width / 2) - (select.width / 2);
            select.y= (height / 2) - (select.height / 2) + 90;
            confirm.visible = false;
            cancel.visible = false;
            if (confirmChoice) {
                confirm.visible = true;
                cancel.visible = true;
                next.visible = false;
                prev.visible = false;
                select.visible = false;
                confirm.x = (width / 2) - (confirm.width / 2);
                confirm.y = (height / 2) - (confirm.height / 2) + 30;
                cancel.x = (width / 2) - (cancel.width / 2);
                cancel.y = (height / 2) - (cancel.height / 2) + 32 + confirm.height;
            }
        }
    }
}
