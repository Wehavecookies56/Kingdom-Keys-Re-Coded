package uk.co.wehavecookies56.kk.client.gui;

import java.io.IOException;

import org.lwjgl.opengl.GL11;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import uk.co.wehavecookies56.kk.client.core.handler.InputHandler;
import uk.co.wehavecookies56.kk.client.core.helper.GuiHelper;
import uk.co.wehavecookies56.kk.common.capability.ModCapabilities;
import uk.co.wehavecookies56.kk.common.capability.MunnyCapability.IMunny;
import uk.co.wehavecookies56.kk.common.container.ContainerPotionsMenu;
import uk.co.wehavecookies56.kk.common.container.inventory.InventoryPotionsMenu;
import uk.co.wehavecookies56.kk.common.core.helper.TextHelper;
import uk.co.wehavecookies56.kk.common.lib.Reference;
import uk.co.wehavecookies56.kk.common.lib.Strings;

public class GuiPotions extends GuiContainer {

	private float xSize_lo;

	private float ySize_lo;

	private static final ResourceLocation iconLocation = new ResourceLocation("kk", "textures/gui/potions_inv.png");

	private final InventoryPotionsMenu inventory;

	public GuiPotions (EntityPlayer player, InventoryPlayer inventoryPlayer, InventoryPotionsMenu inventoryPotionsMenu) {
		super(new ContainerPotionsMenu(player, inventoryPlayer, inventoryPotionsMenu));
		this.inventory = inventoryPotionsMenu;
	}

	@Override
	protected void keyTyped (char c, int keyCode) throws IOException {
		super.keyTyped(c, keyCode);
		if (keyCode == InputHandler.Keybinds.OPENMENU.getKeybind().getKeyCode()) GuiHelper.openMenu_Items();
	}

	@Override
	public void drawScreen (int mouseX, int mouseY, float f) {
		xSize_lo = mouseX;
		ySize_lo = mouseY;
		drawBackground(width, height);
		super.drawScreen(mouseX, mouseY, f);
	}

	public static final ResourceLocation optionsBackground = new ResourceLocation(Reference.MODID, "textures/gui/menubg.png");

	public static String getWorldMinutes (World world) {
		int time = (int) Math.abs((world.getWorldTime() + 6000) % 24000);
		if ((time % 1000) * 6 / 100 < 10)
			return "0" + (time % 1000) * 6 / 100;
		else
			return Integer.toString((time % 1000) * 6 / 100);
	}

	@Override
	public boolean doesGuiPauseGame () {
		return false;
	}

	public static int getWorldHours (World world) {
		int time = (int) Math.abs((world.getWorldTime() + 6000) % 24000);
		return (int) (time / 1000F);
	}

	protected void drawBackground (int screenWidth, int screenHeight) {
		Minecraft.getMinecraft().renderEngine.bindTexture(optionsBackground);
		GL11.glPushMatrix();
		{
			GL11.glColor3ub((byte) 24, (byte) 36, (byte) 214);
			// drawDefaultBackground();
			drawModalRectWithCustomSizedTexture(0, -140 / 16, 0, 0, screenWidth, 70, 32, 32);
			drawModalRectWithCustomSizedTexture(0, screenHeight - ((screenHeight / 8) + 70 / 16), 0, 0, screenWidth, 70, 32, 32);
		}
		GL11.glPopMatrix();
		GL11.glPushMatrix();
		{
			GL11.glScalef(2, 2, 2);
			String title = mc.thePlayer.getDisplayNameString().toString();
			drawString(fontRendererObj, title, 5, 5, 0xFFFFFF);
		}
		GL11.glPopMatrix();
		GL11.glPushMatrix();
		{
			drawString(fontRendererObj, mc.thePlayer.worldObj.provider.getDimensionType().getName(), screenWidth - fontRendererObj.getStringWidth(mc.thePlayer.worldObj.provider.getDimensionType().getName()) - 5, 5, 0xFFFFFF);
			drawString(fontRendererObj, mc.thePlayer.worldObj.getBiomeGenForCoords(mc.thePlayer.getPosition()).getBiomeName(), screenWidth - fontRendererObj.getStringWidth(mc.thePlayer.worldObj.getBiomeGenForCoords(mc.thePlayer.getPosition()).getBiomeName()) - 5, 20, 0xFFFFFF);
			drawString(fontRendererObj, TextHelper.localize(Strings.Gui_Menu_Main_Time) + ": " + getWorldHours(mc.theWorld) + ":" + getWorldMinutes(mc.theWorld), 5, screenHeight - ((screenHeight / 8) - 300 / 16), 0xFFFFFF);
			IMunny MUNNY = mc.thePlayer.getCapability(ModCapabilities.MUNNY, null);
			drawString(fontRendererObj, TextHelper.localize(Strings.Gui_Menu_Main_Munny) + ": " + MUNNY.getMunny(), 5, screenHeight - ((screenHeight / 8) - 100 / 16), 0xFFD000);
		}
		GL11.glPopMatrix();

	}

	@Override
	protected void drawGuiContainerForegroundLayer (int mouseX, int mouseY) {
		String s = inventory.getName();
		fontRendererObj.drawString(s, xSize / 2 - fontRendererObj.getStringWidth(s) / 2, 12, 4210752);
		fontRendererObj.drawString(I18n.format("container.inventory"), xSize / 2 - fontRendererObj.getStringWidth(I18n.format("container.inventory")) / 2, ySize - 96, 4210752);
	}

	@Override
	protected void drawGuiContainerBackgroundLayer (float f, int mouseX, int mouseY) {
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		mc.getTextureManager().bindTexture(iconLocation);
		drawTexturedModalRect(guiLeft, guiTop, 0, 0, xSize, ySize);
	}

}
