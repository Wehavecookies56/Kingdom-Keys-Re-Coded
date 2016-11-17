package uk.co.wehavecookies56.kk.client.gui;

import java.awt.Color;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import uk.co.wehavecookies56.kk.common.block.tile.TileEntityPedestal;
import uk.co.wehavecookies56.kk.common.container.ContainerPedestal;
import uk.co.wehavecookies56.kk.common.lib.Reference;

public class GuiPedestal extends GuiContainer {
	@SideOnly (Side.CLIENT)
	private static final ResourceLocation texture = new ResourceLocation(Reference.MODID, "textures/gui/KKChest.png");
	private TileEntityPedestal tileEntityPedestal;

	public GuiPedestal (InventoryPlayer invPlayer, TileEntityPedestal tile) {
		super(new ContainerPedestal(invPlayer, tile));
		tileEntityPedestal = tile;
		xSize = 176;
		ySize = 186;
	}

	@Override
	protected void drawGuiContainerBackgroundLayer (float partialTicks, int x, int y) {
		Minecraft.getMinecraft().getTextureManager().bindTexture(texture);
		GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
		drawTexturedModalRect(guiLeft, guiTop, 0, 0, xSize, ySize);
	}

	@Override
	protected void drawGuiContainerForegroundLayer (int mouseX, int mouseY) {
		final int LABEL_XPOS = 5;
		final int LABEL_YPOS = 5;
		fontRendererObj.drawString(tileEntityPedestal.getName(), LABEL_XPOS, LABEL_YPOS, Color.darkGray.getRGB());
	}
}