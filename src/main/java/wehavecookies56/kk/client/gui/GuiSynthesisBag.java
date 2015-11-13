package wehavecookies56.kk.client.gui;

import java.awt.Color;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import wehavecookies56.kk.entities.TileEntityKKChest;
import wehavecookies56.kk.entities.TileEntitySynthesisBag;
import wehavecookies56.kk.inventory.ContainerKKChest;
import wehavecookies56.kk.inventory.ContainerSynthesisBag;
import wehavecookies56.kk.inventory.InventorySynthesisBag;
import wehavecookies56.kk.lib.Reference;


public class GuiSynthesisBag extends GuiContainer {
	@SideOnly(Side.CLIENT)
	// This is the resource location for the background image for the GUI
	private static final ResourceLocation texture = new ResourceLocation(Reference.MODID, "textures/gui/SynthesisBag.png");
	private InventorySynthesisBag inventorySynthesisBag;

	/*public GuiSynthesisBag(InventoryPlayer invPlayer, TileEntitySynthesisBag tile) {
		super(new ContainerSynthesisBag(invPlayer, tile));
		inventorySynthesisBag = inv;
		// Set the width and height of the gui.  Should match the size of the texture!
		xSize = 176;
		ySize = 166;
	}*/
	
	public GuiSynthesisBag(InventoryPlayer invPlayer, InventorySynthesisBag invBag)
	{
		super(new ContainerSynthesisBag(invPlayer, invBag));
		this.xSize = 255;
		this.ySize = 230;
	}

	// draw the background for the GUI - rendered first
	@Override
	protected void drawGuiContainerBackgroundLayer(float partialTicks, int x, int y){
		// Bind the image texture of our custom container
		Minecraft.getMinecraft().getTextureManager().bindTexture(texture);
		// Draw the image
		GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
		drawTexturedModalRect(guiLeft, guiTop, 0, 0, xSize, ySize);
	}

	// draw the foreground for the GUI - rendered after the slots, but before the dragged items and tooltips
	// renders relative to the top left corner of the background
	@Override
	protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY) {
		final int LABEL_XPOS = xSize/2-this.fontRendererObj.getStringWidth(inventorySynthesisBag.getDisplayName().getUnformattedText())/2;
		final int LABEL_YPOS = 5;
		fontRendererObj.drawString(inventorySynthesisBag.getDisplayName().getUnformattedText(), LABEL_XPOS, LABEL_YPOS, Color.darkGray.getRGB());
	}
}