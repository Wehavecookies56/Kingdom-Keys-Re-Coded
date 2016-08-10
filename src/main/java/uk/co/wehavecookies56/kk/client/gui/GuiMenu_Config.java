package uk.co.wehavecookies56.kk.client.gui;

import java.io.IOException;

import org.lwjgl.input.Keyboard;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiTextField;
import uk.co.wehavecookies56.kk.client.core.helper.GuiHelper;
import uk.co.wehavecookies56.kk.common.capability.ModCapabilities;
import uk.co.wehavecookies56.kk.common.core.handler.ConfigHandler;
import uk.co.wehavecookies56.kk.common.core.helper.TextHelper;
import uk.co.wehavecookies56.kk.common.lib.Strings;
import uk.co.wehavecookies56.kk.common.network.packet.PacketDispatcher;
import uk.co.wehavecookies56.kk.common.network.packet.server.magics.SetKH1Fire;
import uk.co.wehavecookies56.kk.common.util.Utils;

public class GuiMenu_Config extends GuiMenu_Bars {

	GuiNumberTextField r, g, b;
	GuiButton back, showHearts, musicToggle, fire;

	final int R = 0, G = 1, B = 2;
	final int BACK = 0, HEARTS = 1, MUSIC = 2, FIRE = 3;

	public GuiMenu_Config (String name) {
		super(Strings.Gui_Menu_Config_Title);
	}

	@Override
	protected void actionPerformed (GuiButton button) throws IOException {
		switch (button.id) {
			case BACK: 
				GuiHelper.openMenu();
				break;
			case HEARTS:
				ConfigHandler.EnableHeartsOnHUD = ConfigHandler.EnableHeartsOnHUD ? false : true ;
				ConfigHandler.EnableHeartsOnHUDProperty.set(ConfigHandler.EnableHeartsOnHUD);
				ConfigHandler.config.save();
				showHearts.displayString = String.valueOf(ConfigHandler.EnableHeartsOnHUD);
				break;
			case MUSIC:
				ConfigHandler.EnableCustomMusic = ConfigHandler.EnableCustomMusic ? false : true ;
				ConfigHandler.EnableCustomMusicProperty.set(ConfigHandler.EnableCustomMusic);
				ConfigHandler.config.save();
				musicToggle.displayString = String.valueOf(ConfigHandler.EnableCustomMusic);
				break;
			case FIRE:
				if(Minecraft.getMinecraft().thePlayer.getCapability(ModCapabilities.MAGIC_STATE, null).getKH1Fire() == true)
					PacketDispatcher.sendToServer(new SetKH1Fire(false));
				else
					PacketDispatcher.sendToServer(new SetKH1Fire(true));
				fire.displayString = String.valueOf(Minecraft.getMinecraft().thePlayer.getCapability(ModCapabilities.MAGIC_STATE, null).getKH1Fire());
				break;
		}
		updateButtons();
	}

	private void updateButtons () {
		updateScreen();
	}

	@Override
	public void initGui () {
		super.initGui();
		this.drawPlayerInfo = false;
		int boxWidth = 30;
		int rPosX = 15;
		int gPosX = rPosX + boxWidth + 15;
		int bPosX = gPosX + boxWidth + 15;
		r = new GuiNumberTextField(R, mc.fontRendererObj, rPosX, 100, boxWidth, 10, 255);
		g = new GuiNumberTextField(G, mc.fontRendererObj, gPosX, 100, boxWidth, 10, 255);
		b = new GuiNumberTextField(B, mc.fontRendererObj, bPosX, 100, boxWidth, 10, 255);
		buttonList.add(showHearts = new GuiButton(HEARTS, mc.fontRendererObj.getStringWidth(Utils.translateToLocal(Strings.Gui_Menu_Config_Hearts)) + 15, 115, 100, 20, String.valueOf(ConfigHandler.EnableHeartsOnHUD)));
		buttonList.add(musicToggle = new GuiButton(MUSIC, mc.fontRendererObj.getStringWidth(Utils.translateToLocal(Strings.Gui_Menu_Config_Music)) + 15, 135, 100, 20, String.valueOf(ConfigHandler.EnableCustomMusic)));
	    buttonList.add(fire = new GuiButton(FIRE, mc.fontRendererObj.getStringWidth(Utils.translateToLocal(Strings.Gui_Menu_Config_Fire)) + 15, 155, 100, 20, String.valueOf(Minecraft.getMinecraft().thePlayer.getCapability(ModCapabilities.MAGIC_STATE, null).getKH1Fire())));
		buttonList.add(back = new GuiButton(BACK, 5, 175, 100, 20, Utils.translateToLocal(Strings.Gui_Menu_Items_Button_Back)));

		this.r.setText(String.valueOf(ConfigHandler.interfaceColour[0]));
		this.g.setText(String.valueOf(ConfigHandler.interfaceColour[1]));
		this.b.setText(String.valueOf(ConfigHandler.interfaceColour[2]));
		updateButtons();
	}

	@Override
	protected void keyTyped (char typedChar, int keyCode) throws IOException {
		this.r.textboxKeyTyped(typedChar, keyCode);
		this.g.textboxKeyTyped(typedChar, keyCode);
		this.b.textboxKeyTyped(typedChar, keyCode);
		try {
			int[] colour = { Integer.parseInt(this.r.getText()), Integer.parseInt(this.g.getText()), Integer.parseInt(this.b.getText()) };
			ConfigHandler.interfaceColour = colour;
			ConfigHandler.interfaceColourProperty.set(ConfigHandler.interfaceColour);
			ConfigHandler.config.save();
		} catch (NumberFormatException e) {

		}
		super.keyTyped(typedChar, keyCode);
	}

	@Override
	public void onGuiClosed () {
		ConfigHandler.config.save();
		super.onGuiClosed();
	}

	@Override
	protected void mouseClicked (int mouseX, int mouseY, int mouseButton) throws IOException {
		this.r.mouseClicked(mouseX, mouseY, mouseButton);
		this.g.mouseClicked(mouseX, mouseY, mouseButton);
		this.b.mouseClicked(mouseX, mouseY, mouseButton);
		super.mouseClicked(mouseX, mouseY, mouseButton);
	}
	
	@Override
	public void drawScreen (int mouseX, int mouseY, float partialTicks) {
		super.drawScreen(mouseX, mouseY, partialTicks);
		this.drawString(mc.fontRendererObj, Utils.translateToLocal(Strings.Gui_Menu_Config_Hearts), 5, 120, 0xFFFFFF);
		this.drawString(mc.fontRendererObj, Utils.translateToLocal(Strings.Gui_Menu_Config_Music), 5, 140, 0xFFFFFF);
		this.drawString(mc.fontRendererObj, Utils.translateToLocal(Strings.Gui_Menu_Config_Fire), 5, 160, 0xFFFFFF);

		this.drawString(mc.fontRendererObj, Utils.translateToLocal(Strings.Gui_Menu_Config_Colour_Desc), 5, 80, 0xFFFFFF);
		this.r.drawTextBox();
		this.drawString(mc.fontRendererObj, "R:", 5, 101, 0xFFFFFF);
		this.g.drawTextBox();
		this.drawString(mc.fontRendererObj, "G:", 50, 101, 0xFFFFFF);
		this.b.drawTextBox();
		this.drawString(mc.fontRendererObj, "B:", 95, 101, 0xFFFFFF);

	}

	@Override
	public void updateScreen () {
		this.r.updateCursorCounter();
		this.g.updateCursorCounter();
		this.b.updateCursorCounter();
		super.updateScreen();
	}

}
