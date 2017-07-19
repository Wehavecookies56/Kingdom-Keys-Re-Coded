package uk.co.wehavecookies56.kk.client.gui;

import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;
import org.lwjgl.opengl.GL11;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;
import uk.co.wehavecookies56.kk.common.container.ContainerSynthesisBagL;
import uk.co.wehavecookies56.kk.common.container.inventory.InventorySynthesisBagL;
import uk.co.wehavecookies56.kk.common.lib.Reference;

public class GuiSynthesisBagL extends GuiContainer {

    private float xSize_lo;
    private float ySize_lo;

    private static final ResourceLocation texture = new ResourceLocation(Reference.MODID, "textures/gui/SynthesisBagL.png");
    private IItemHandler inventory;

    public GuiSynthesisBagL (EntityPlayer player, InventoryPlayer inv1) {
        super(new ContainerSynthesisBagL(player, inv1));
        if (inv1.getCurrentItem().hasCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null)) {
            this.inventory = inv1.getCurrentItem().getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null);
        }
        xSize = 176;
        ySize = 248;
    }

    @Override
    public void drawScreen (int mouseX, int mouseY, float partialTicks) {
        super.drawScreen(mouseX, mouseY, partialTicks);
        this.xSize_lo = mouseX;
        this.ySize_lo = mouseY;
    }

    @Override
    protected void drawGuiContainerBackgroundLayer (float partialTicks, int x, int y) {
        Minecraft.getMinecraft().getTextureManager().bindTexture(texture);
        GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
        drawTexturedModalRect(guiLeft, guiTop, 0, 0, xSize, ySize);
    }

    @Override
    protected void drawGuiContainerForegroundLayer (int mouseX, int mouseY) {
        String s = InventorySynthesisBagL.name;
        GL11.glPushMatrix();
        {
            GL11.glScalef(0.9f, 0.9f, 1);
            fontRenderer.drawString(s, xSize / 2 - fontRenderer.getStringWidth(s) / 2 + 10, 6, 4210752);
        }
        GL11.glPopMatrix();
        // fontRenderer.drawString(I18n.format("container.inventory"),
        // xSize/2 -
        // fontRenderer.getStringWidth(I18n.format("container.inventory"))/2,
        // ySize - 96, 4210752);
    }
}