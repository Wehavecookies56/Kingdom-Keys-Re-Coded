package uk.co.wehavecookies56.kk.client.gui;

import org.lwjgl.opengl.GL11;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;
import uk.co.wehavecookies56.kk.common.container.ContainerSynthesisBagM;
import uk.co.wehavecookies56.kk.common.container.inventory.InventorySynthesisBagM;
import uk.co.wehavecookies56.kk.common.lib.Reference;

public class GuiSynthesisBagM extends GuiContainer {

	private float xSize_lo;
	private float ySize_lo;

	private int xSize = 176;
	private int ySize = 176;

	private static final ResourceLocation texture = new ResourceLocation(Reference.MODID, "textures/gui/SynthesisBagM.png");
	private InventorySynthesisBagM inventory;

	public GuiSynthesisBagM (EntityPlayer player, InventoryPlayer inv1, InventorySynthesisBagM inv2) {
		super(new ContainerSynthesisBagM(player, inv1, inv2));
		this.inventory = inv2;
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
		String s = inventory.getName();
		GL11.glPushMatrix();
		{
			GL11.glScalef(0.9f, 0.9f, 1);
			fontRendererObj.drawString(s, xSize / 2 - fontRendererObj.getStringWidth(s) / 2 + 10, 6, 4210752);
		}
		GL11.glPopMatrix();
		// fontRendererObj.drawString(I18n.format("container.inventory"),
		// xSize/2 -
		// fontRendererObj.getStringWidth(I18n.format("container.inventory"))/2,
		// ySize - 96, 4210752);
	}
}