package uk.co.wehavecookies56.kk.client.gui;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.block.model.IBakedModel;
import net.minecraft.client.renderer.block.model.ItemCameraTransforms;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import uk.co.wehavecookies56.kk.common.capability.ModCapabilities;
import uk.co.wehavecookies56.kk.common.lib.Lists;
import uk.co.wehavecookies56.kk.common.lib.Reference;
import uk.co.wehavecookies56.kk.common.network.packet.PacketDispatcher;
import uk.co.wehavecookies56.kk.common.network.packet.server.OrgMemberSelect;
import uk.co.wehavecookies56.kk.common.network.packet.server.OrgWeaponSelect;
import uk.co.wehavecookies56.kk.common.util.Utils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static uk.co.wehavecookies56.kk.common.util.Utils.OrgMember.ROXAS;
import static uk.co.wehavecookies56.kk.common.util.Utils.OrgMember.XEMNAS;

/**
 * Created by Toby on 08/02/2017.
 */
public class GuiOrgWeapon extends GuiScreen {

    GuiButton ok, confirm, cancel, next, prev, select;
    final int OK = 0, CONFIRM = 1, CANCEL = 2, NEXT = 3, PREV = 4, SELECT = 5;

    List<Item> weapons;
    List<Item> unlocked;
    int current = 0;

    boolean showWelcome = true;
    boolean confirmChoice = false;

    private final ResourceLocation GLOW = new ResourceLocation(Reference.MODID, "textures/gui/org/glow.png");

    public GuiOrgWeapon() {
        if (Minecraft.getMinecraft().player.hasCapability(ModCapabilities.ORGANIZATION_XIII, null)) {
            this.weapons = Lists.getListForMember(Minecraft.getMinecraft().player.getCapability(ModCapabilities.ORGANIZATION_XIII, null).getMember());
            this.unlocked = Minecraft.getMinecraft().player.getCapability(ModCapabilities.ORGANIZATION_XIII, null).unlockedWeapons();
        } else {
            this.weapons = new ArrayList<>();
        }
    }

    @Override
    public void drawScreen(int mouseX, int mouseY, float partialTicks) {
        if (!confirmChoice) {
            drawDefaultBackground();
            String name = "";
            String weapon = "";
            int weapon_w = 128;
            int weapon_h = 128;
            drawDefaultBackground();
            GlStateManager.pushMatrix();
            mc.renderEngine.bindTexture(GLOW);
            GlStateManager.enableAlpha();
            GlStateManager.enableBlend();
            drawTexturedModalRect((width / 2) - (256 / 2) - 5, (height / 2) - (256 / 2), 0, 0, 256, 256);
            drawString(fontRendererObj, new ItemStack(weapons.get(current)).getDisplayName(), (width / 2) - (256 / 2) - 5, (height / 2) - 110, 0xFFFFFF);
            GlStateManager.popMatrix();
            GlStateManager.pushMatrix();
            GlStateManager.translate((width / 2) - (256 / 2) - 5 + 94, (height / 2) - (256 / 2) + 88, 0);
            GlStateManager.scale(5, 5, 5);
            if (!unlocked.isEmpty() && !unlocked.contains(weapons.get(current))) {
                System.out.println(unlocked.get(current));
            }
            GlStateManager.enableBlend();
            GlStateManager.color(0, 0, 0);
            OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit, 1.0F, 1.0F);
            mc.getRenderItem().renderItemAndEffectIntoGUI(new ItemStack(weapons.get(current)), 0, 0);
            GlStateManager.popMatrix();
        } else {
            drawDefaultBackground();
            drawCenteredString(fontRendererObj, "Equip " + new ItemStack(weapons.get(current)).getDisplayName() + "?", (width / 2), height / 2, 0xFFFFFF);
        }
        /*mc.renderEngine.bindTexture(icons[current.ordinal()]);
        GlStateManager.enableAlpha();
        GlStateManager.enableBlend();
        drawTexturedModalRect((width / 2) - (weapon_w / 2), (height / 2) - (weapon_h / 2), 56, 0, weapon_w, weapon_h);
        GlStateManager.translate((width / 2) - (8) - 64, (height / 2) - 110, 0);
        GlStateManager.scale(0.5F, 0.5F, 0.5F);
        //drawTexturedModalRect(0, 0, 0, 0, icon_width, icon_height);
        GlStateManager.popMatrix();
        drawString(fontRendererObj, name, ((width / 2) - (8) - 64) + 2 + icon_width / 2, (height / 2) - 110, 0xFFFFFF);
        drawString(fontRendererObj, weapon, ((width / 2) - (8) - 64) + 2 + icon_width / 2, (height / 2) - 110 + fontRendererObj.FONT_HEIGHT * 2, 0xFFFFFF);
        */
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
            case CONFIRM:
                //Send choice to server
                PacketDispatcher.sendToServer(new OrgWeaponSelect(new ItemStack(weapons.get(current))));
                mc.player.getCapability(ModCapabilities.ORGANIZATION_XIII, null).setCurrentWeapon(weapons.get(current));
                mc.displayGuiScreen(null);
                break;
            case CANCEL:
                //Go back
                confirmChoice = false;
                break;
            case NEXT:
                if (current == weapons.size()-1) {
                    current = 0;
                } else {
                    current++;
                }
                //Go to the right
                break;
            case PREV:
                //Go to the left
                if (current == 0) {
                    current = weapons.size()-1;
                } else {
                    current--;
                }
                break;
            case SELECT:
                //Select the current member
                confirmChoice = true;
                break;
        }
        super.actionPerformed(button);
        updateButtons();
    }

    public void updateButtons() {
        ok.visible = false;
        next.visible = true;
        next.xPosition = (width / 2) - (next.width / 2) + 128;
        next.yPosition = (height / 2) - (next.height / 2);
        prev.visible = true;
        prev.xPosition = (width / 2) - (prev.width / 2) - 128;
        prev.yPosition = (height / 2) - (prev.height / 2);
        select.visible = true;
        select.xPosition = (width / 2) - (select.width / 2);
        select.yPosition = (height / 2) - (select.height / 2) + 90;
        confirm.visible = false;
        cancel.visible = false;
        if (unlocked.isEmpty() || !unlocked.contains(weapons.get(current))) {
            System.out.println("Nope");
            select.enabled = true;
        } else {
            System.out.println("Yep");
            select.enabled = true;
        }
        if (confirmChoice) {
            confirm.visible = true;
            cancel.visible = true;
            next.visible = false;
            prev.visible = false;
            select.visible = false;
            confirm.xPosition = (width / 2) - (confirm.width / 2);
            confirm.yPosition = (height / 2) - (confirm.height / 2) + 30;
            cancel.xPosition = (width / 2) - (cancel.width / 2);
            cancel.yPosition = (height / 2) - (cancel.height / 2) + 32 + confirm.height;
        }
    }
}
