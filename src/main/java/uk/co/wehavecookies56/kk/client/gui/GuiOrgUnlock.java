package uk.co.wehavecookies56.kk.client.gui;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.VertexBuffer;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;
import uk.co.wehavecookies56.kk.common.capability.ModCapabilities;
import uk.co.wehavecookies56.kk.common.capability.OrganizationXIIICapability;
import uk.co.wehavecookies56.kk.common.item.ModItems;
import uk.co.wehavecookies56.kk.common.lib.Reference;
import uk.co.wehavecookies56.kk.common.network.packet.PacketDispatcher;
import uk.co.wehavecookies56.kk.common.network.packet.client.SyncOrgXIIIData;
import uk.co.wehavecookies56.kk.common.util.Utils;

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
        Utils.OrgMember member = Minecraft.getMinecraft().player.getCapability(ModCapabilities.ORGANIZATION_XIII, null).getMember();
        unlocks = new GuiNodeButton[50];
        if (member != null && member != Utils.OrgMember.NONE) {
            switch (member) {
                case AXEL:
                    //TIER 0
                    /*Ashes*/unlocks[0] = new GuiNodeButton(1, 0, 0, new UnlockNode(0, 0, ModItems.Ashes, null), this);
                    //TIER 1
                    /*Doldrums*/unlocks[1] = new GuiNodeButton(2, 0, 0, new UnlockNode(-2, -2, ModItems.Doldrums, new UnlockNode[]{unlocks[0].getNode()}), this);
                    /*Delayed Action*/unlocks[2] = new GuiNodeButton(3, 0, 0, new UnlockNode(0, -2, ModItems.DelayedAction, new UnlockNode[]{unlocks[0].getNode()}), this);
                    /*Dive-Bombers*/unlocks[3] = new GuiNodeButton(4, 0, 0, new UnlockNode(2, -2, ModItems.DiveBombers, new UnlockNode[]{unlocks[0].getNode()}), this);
                    //TIER 2
                    /*Combustion*/unlocks[4] = new GuiNodeButton(5, 0, 0, new UnlockNode(-3, -4, ModItems.Combustion, new UnlockNode[]{unlocks[1].getNode()}), this);
                    /*Moulin Rouge*/unlocks[5] = new GuiNodeButton(6, 0, 0, new UnlockNode(-1, -4, ModItems.MoulinRouge, new UnlockNode[]{unlocks[1].getNode(), unlocks[2].getNode()}), this);
                    /*Blaze of Glory*/unlocks[6] = new GuiNodeButton(7, 0, 0, new UnlockNode(1, -4, ModItems.BlazeofGlory, new UnlockNode[]{unlocks[2].getNode(), unlocks[3].getNode()}), this);
                    /*Prometheus*/unlocks[7] = new GuiNodeButton(8, 0, 0, new UnlockNode(3, -4, ModItems.Prometheus, new UnlockNode[]{unlocks[3].getNode()}), this);
                    //TIER 3
                    /*Ifrit*/unlocks[8] = new GuiNodeButton(9, 0, 0, new UnlockNode(-2, -6, ModItems.Ifrit, new UnlockNode[]{unlocks[4].getNode(), unlocks[5].getNode()}), this);
                    /*Magma Ocean*/unlocks[9] = new GuiNodeButton(10, 0, 0, new UnlockNode(0, -6, ModItems.MagmaOcean, new UnlockNode[]{unlocks[5].getNode(), unlocks[6].getNode()}), this);
                    /*Volcanis*/unlocks[10] = new GuiNodeButton(11, 0, 0, new UnlockNode(2, -6, ModItems.Volcanis, new UnlockNode[]{unlocks[6].getNode(), unlocks[7].getNode()}), this);
                    //TIER 4
                    /*Inferno*/unlocks[11] = new GuiNodeButton(12, 0, 0, new UnlockNode(-1, -8, ModItems.Inferno, new UnlockNode[]{unlocks[8].getNode(), unlocks[9].getNode()}), this);
                    /*Sizzling Edge*/unlocks[12] = new GuiNodeButton(13, 0, 0, new UnlockNode(1, -8, ModItems.SizzlingEdge, new UnlockNode[]{unlocks[9].getNode(), unlocks[10].getNode()}), this);
                    //TIER 5
                    /*Corona*/unlocks[13] = new GuiNodeButton(14, 0, 0, new UnlockNode(-3, -10, ModItems.Combustion, new UnlockNode[]{unlocks[11].getNode()}), this);
                    /*Ferris Wheels*/unlocks[14] = new GuiNodeButton(15, 0, 0, new UnlockNode(-1, -10, ModItems.MoulinRouge, new UnlockNode[]{unlocks[11].getNode()}), this);
                    /*Burnout*/unlocks[15] = new GuiNodeButton(16, 0, 0, new UnlockNode(1, -10, ModItems.BlazeofGlory, new UnlockNode[]{unlocks[12].getNode()}), this);
                    /*Omega Trinity*/unlocks[16] = new GuiNodeButton(17, 0, 0, new UnlockNode(3, -10, ModItems.Prometheus, new UnlockNode[]{unlocks[12].getNode()}), this);
                    //TIER 6
                    /*Outbreak*/unlocks[17] = new GuiNodeButton(18, 0, 0, new UnlockNode(-2, -12, ModItems.Outbreak, new UnlockNode[]{unlocks[13].getNode(), unlocks[14].getNode()}), this);
                    /*Double Edge*/unlocks[18] = new GuiNodeButton(19, 0, 0, new UnlockNode(0, -12, ModItems.FerrisWheel, new UnlockNode[]{unlocks[14].getNode(), unlocks[15].getNode()}), this);
                    /*Wildfire*/unlocks[19] = new GuiNodeButton(20, 0, 0, new UnlockNode(2, -12, ModItems.Wildfire, new UnlockNode[]{unlocks[15].getNode(), unlocks[16].getNode()}), this);
                    //TIER 7
                    /*Double Edge*/unlocks[20] = new GuiNodeButton(20, 0, 0, new UnlockNode(0, -14, ModItems.Prominence, new UnlockNode[]{unlocks[17].getNode(), unlocks[18].getNode(), unlocks[19].getNode()}), this);
                    //TIER 8
                    /*Eternal Flames*/unlocks[21] = new GuiNodeButton(22, 0, 0, new UnlockNode(0, -16, ModItems.EternalFlames, new UnlockNode[]{unlocks[20].getNode()}), this);
                    //TIER 9
                    /*Pizza Cut*/unlocks[22] = new GuiNodeButton(23, 0, 0, new UnlockNode(-1, -18, ModItems.PizzaCut, new UnlockNode[]{unlocks[21].getNode()}), this);
                    /*Conformers*/unlocks[23] = new GuiNodeButton(24, 0, 0, new UnlockNode(1, -18, ModItems.Conformers, new UnlockNode[]{unlocks[21].getNode()}), this);
                    break;
            }
        }
    }

    public Dimension convertToGUICoords(UnlockNode node) {
        double zeroX = (double) width / 2.0D;
        double zeroY = (double) height / 2.0D;
        int scale = 32;
        return new Dimension((int)zeroX + (node.getxPos()*scale),(int)zeroY + (node.getyPos()*scale));
    }

    public void drawNodes(int mouseX, int mouseY, GuiNodeButton[] nodes) {
        GlStateManager.color(1, 1, 1, 1);
        for(GuiNodeButton n : nodes) {
            if (n != null) {
                Dimension d = convertToGUICoords(n.getNode());
                if (n.getNode().getParents() != null) {
                    UnlockNode[] parents = n.getNode().getParents();
                    for (UnlockNode p : parents) {
                        if (p != null) {
                            Dimension pd = convertToGUICoords(p);
                            GlStateManager.pushMatrix();
                            GlStateManager.disableTexture2D();
                            GlStateManager.blendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
                            GlStateManager.color(1, 1, 1);
                            GL11.glLineWidth(3F);
                            GlStateManager.glBegin(GL11.GL_LINES);
                            GlStateManager.glVertex3f((float) d.getWidth() + dispX, (float) d.getHeight() + dispY, 0);
                            GlStateManager.glVertex3f((float) pd.getWidth() + dispX, (float) pd.getHeight() + dispY, 0);
                            GlStateManager.glEnd();
                            GlStateManager.enableTexture2D();
                            GlStateManager.popMatrix();
                        }
                    }
                }
            }
        }
        for(GuiNodeButton n : nodes) {
            if (n != null) {
                Dimension d = convertToGUICoords(n.getNode());
                n.xPosition = (int) d.getWidth();
                n.yPosition = (int) d.getHeight();
                n.drawButton(Minecraft.getMinecraft(), mouseX, mouseY);
            }
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
            if (n != null)
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
