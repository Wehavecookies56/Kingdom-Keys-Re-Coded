package uk.co.wehavecookies56.kk.client.gui;

import java.awt.Color;
import java.io.IOException;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import uk.co.wehavecookies56.kk.common.block.tile.TileEntityPedestal;
import uk.co.wehavecookies56.kk.common.container.ContainerPedestal;
import uk.co.wehavecookies56.kk.common.lib.Reference;
import uk.co.wehavecookies56.kk.common.network.packet.PacketDispatcher;
import uk.co.wehavecookies56.kk.common.network.packet.server.PedestalItem;
import uk.co.wehavecookies56.kk.common.util.Utils;

public class GuiPedestal extends GuiContainer {
	@SideOnly (Side.CLIENT)
	private static final ResourceLocation texture = new ResourceLocation(Reference.MODID, "textures/gui/pedestal.png");
	private TileEntityPedestal tileEntityPedestal;
	final int MINUS=1, PLUS=2;
	GuiButton minus,plus;

	public GuiPedestal (InventoryPlayer invPlayer, TileEntityPedestal tile) {
		super(new ContainerPedestal(invPlayer, tile));
		tileEntityPedestal = tile;
		xSize = 176;
		ySize = 186;
	}

	@Override
	protected void actionPerformed (GuiButton button) throws IOException {
		switch (button.id) {
		case MINUS:
			PacketDispatcher.sendToServer(new PedestalItem(tileEntityPedestal.getPos(), '-'));
			break;
		case PLUS:
			PacketDispatcher.sendToServer(new PedestalItem(tileEntityPedestal.getPos(), '+'));
			break;
		}
	}
	
	private void updateButtons () {
		updateScreen();
	}
	
	@Override
	public void initGui () {
		super.initGui();
		int minusY = mc.currentScreen.height/2-10;
		int minusX= mc.currentScreen.width/2-20;
		int plusY = minusY;
		int plusX= mc.currentScreen.width/2;

		buttonList.add(minus = new GuiButton(MINUS, minusX, minusY, 20, 20, Utils.translateToLocal("-")));
		buttonList.add(plus = new GuiButton(PLUS, plusX, plusY, 20, 20, Utils.translateToLocal("+")));

		updateButtons();
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
		int rotationY = 75;
		int rotationX= 60;
		
		if(tileEntityPedestal.getKeyblade() != null)
			fontRendererObj.drawString(tileEntityPedestal.getName(), LABEL_XPOS, LABEL_YPOS, Color.darkGray.getRGB());
		fontRendererObj.drawString("Rotation: "+tileEntityPedestal.getRotation()*90+"º", rotationX, rotationY, Color.darkGray.getRGB());
		
	}
}