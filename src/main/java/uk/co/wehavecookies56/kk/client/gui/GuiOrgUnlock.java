package uk.co.wehavecookies56.kk.client.gui;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;
import uk.co.wehavecookies56.kk.common.capability.ModCapabilities;
import uk.co.wehavecookies56.kk.common.capability.OrganizationXIIICapability;
import uk.co.wehavecookies56.kk.common.item.ModItems;
import uk.co.wehavecookies56.kk.common.lib.Reference;
import uk.co.wehavecookies56.kk.common.network.packet.PacketDispatcher;
import uk.co.wehavecookies56.kk.common.network.packet.client.SyncOrgXIIIData;

import java.awt.*;
import java.io.IOException;

/**
 * Created by Toby on 27/04/2017.
 */
public class GuiOrgUnlock extends GuiScreen {

    ResourceLocation texture = new ResourceLocation(Reference.MODID, "textures/gui/org/org_unlock.png");

    int texWidth = 256;
    int texHeight = 202;

    int dispX = 0;
    int dispY = 0;
    int startDispX = 0;
    int startDispY = 0;

    int mouseStartX = 0;
    int mouseStartY = 0;

    GuiButton unlock;
    final int UNLOCK = 0;

    UnlockNode selected;

    GuiNodeButton[] unlocks;

    public GuiOrgUnlock() {
        unlocks = new GuiNodeButton[2];
        unlocks[0] = new GuiNodeButton(1, 0, 0, new UnlockNode(0, 0, ModItems.Ashes, null), this);
        unlocks[1] = new GuiNodeButton(2, 0, 0,  new UnlockNode(1, 1, ModItems.EternalFlames, null), this);
    }

    public Dimension convertToGUICoords(UnlockNode node) {
        int zeroX = width / 2;
        int zeroY = height/  2;
        int scale = 64;
        return new Dimension(zeroX + (node.getxPos()*scale),zeroY + (node.getyPos()*scale));
    }

    public void drawNodes(int mouseX, int mouseY, GuiNodeButton[] nodes) {
        GlStateManager.color(1, 1, 1, 1);
        for(GuiNodeButton n : nodes) {
            Dimension d = convertToGUICoords(n.getNode());
            n.xPosition = (int)d.getWidth();
            n.yPosition = (int)d.getHeight();
            n.drawButton(Minecraft.getMinecraft(), mouseX, mouseY);
        }
    }

    @Override
    public void drawScreen(int mouseX, int mouseY, float partialTicks) {
        drawDefaultBackground();
        GL11.glPushMatrix();
        GL11.glEnable(GL11.GL_SCISSOR_TEST);
        GL11.glScissor(((width / 2) - (texWidth / 2)) * 2, ((height / 2) - (texHeight / 2)) * 2, 510, 390);
        drawNodes(mouseX, mouseY, unlocks);
        GL11.glDisable(GL11.GL_SCISSOR_TEST);
        GL11.glPopMatrix();
        Minecraft.getMinecraft().renderEngine.bindTexture(texture);
        int posX = (width / 2) - (texWidth / 2);
        int posY = (height / 2) - (texHeight / 2);
        drawTexturedModalRect(posX, posY, 0, 0, texWidth, texHeight);
        fontRendererObj.drawString("Weapon unlocks", posX + 5, posY + 5, 0x2B2B2B);
        super.drawScreen(mouseX, mouseY, partialTicks);
        if (selected != null)
            fontRendererObj.drawString(new ItemStack(selected.unlock).getDisplayName() + " selected", (width / 2) - (texWidth / 2) + 5, (height / 2) - (texHeight / 2) + 180, 0x2B2B2B);
    }

    @Override
    protected void actionPerformed(GuiButton button) throws IOException {
        switch (button.id) {
            case UNLOCK:
                if (selected != null) {
                    OrganizationXIIICapability.IOrganizationXIII weapons = Minecraft.getMinecraft().player.getCapability(ModCapabilities.ORGANIZATION_XIII, null);
                    weapons.addUnlockedWeapon(selected.getUnlock());
                    PacketDispatcher.sendToServer(new SyncOrgXIIIData(weapons));
                }
                break;
        }
        updateButtons();
        super.actionPerformed(button);
    }

    @Override
    public void initGui() {
        buttonList.add(unlock = new GuiButton(UNLOCK, (width / 2) - (texWidth / 2) + 180, (height / 2) - (texWidth / 2) + 202, "Unlock"));
        unlock.width = 60;
        updateButtons();
        super.initGui();
    }

    public void updateButtons() {
        if (selected != null) {
            unlock.enabled = true;
        } else {
            unlock.enabled = false;
        }
    }

    @Override
    protected void mouseClicked(int mouseX, int mouseY, int mouseButton) throws IOException {
        //mouseButton 0 == M1, 1 == M2, 2 == M3, 3 == M4, 4 == M5
        for(GuiNodeButton n : unlocks) {
            n.mousePressed(Minecraft.getMinecraft(), mouseX, mouseY);
        }
        if (mouseButton == 0) {
            mouseStartX = mouseX;
            mouseStartY = mouseY;
            startDispX = dispX;
            startDispY = dispY;
        }
        super.mouseClicked(mouseX, mouseY, mouseButton);
    }

    @Override
    protected void mouseReleased(int mouseX, int mouseY, int state) {
        super.mouseReleased(mouseX, mouseY, state);
    }

    @Override
    protected void mouseClickMove(int mouseX, int mouseY, int clickedMouseButton, long timeSinceLastClick) {
        if (clickedMouseButton == 0) {
            dispX = startDispX - ((mouseX - mouseStartX));
            dispY = startDispY - ((mouseY - mouseStartY));
        }
        super.mouseClickMove(mouseX, mouseY, clickedMouseButton, timeSinceLastClick);
    }
}
