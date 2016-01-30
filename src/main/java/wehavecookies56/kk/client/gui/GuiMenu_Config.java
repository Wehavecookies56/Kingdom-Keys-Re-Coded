package wehavecookies56.kk.client.gui;

import java.io.IOException;

import org.lwjgl.input.Keyboard;

import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiTextField;
import wehavecookies56.kk.lib.Config;
import wehavecookies56.kk.lib.Strings;

public class GuiMenu_Config extends GuiMenu_Bars {

	GuiColourTextField r, g, b;

	final int R = 0, G = 1, B = 2;

	public GuiMenu_Config (String name) {
		super(Strings.Gui_Menu_Config_Title);
	}

	@Override
	protected void actionPerformed (GuiButton button) throws IOException {
		switch (button.id) {

		}
		updateButtons();
	}

	private void updateButtons () {
		updateScreen();
	}

	@Override
	public void initGui () {
		super.initGui();
		int boxWidth = 30;
		int rPosX = 10;
		int gPosX = rPosX + boxWidth + 10;
		int bPosX = gPosX + boxWidth + 10;
		r = new GuiColourTextField(R, mc.fontRendererObj, rPosX, 100, boxWidth, 10);
		g = new GuiColourTextField(G, mc.fontRendererObj, gPosX, 100, boxWidth, 10);
		b = new GuiColourTextField(B, mc.fontRendererObj, bPosX, 100, boxWidth, 10);
		this.r.setText(String.valueOf(Config.interfaceColour[0]));
		this.g.setText(String.valueOf(Config.interfaceColour[1]));
		this.b.setText(String.valueOf(Config.interfaceColour[2]));
		updateButtons();
	}

	@Override
	protected void keyTyped (char typedChar, int keyCode) throws IOException {
		this.r.textboxKeyTyped(typedChar, keyCode);
		this.g.textboxKeyTyped(typedChar, keyCode);
		this.b.textboxKeyTyped(typedChar, keyCode);
		try {
			int[] colour = { Integer.parseInt(this.r.getText()), Integer.parseInt(this.g.getText()), Integer.parseInt(this.b.getText()) };
			Config.interfaceColour = colour;
			Config.interfaceColourProperty.set(Config.interfaceColour);
			Config.config.save();
		} catch (NumberFormatException e) {

		}
		super.keyTyped(typedChar, keyCode);
	}

	@Override
	public void onGuiClosed () {
		Config.config.save();
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
		this.r.drawTextBox();
		this.g.drawTextBox();
		this.b.drawTextBox();
	}

	@Override
	public void updateScreen () {
		this.r.updateCursorCounter();
		this.g.updateCursorCounter();
		this.b.updateCursorCounter();
		super.updateScreen();
	}

	public class GuiColourTextField extends GuiTextField {

		public GuiColourTextField (int componentId, FontRenderer fontrendererObj, int x, int y, int par5Width, int par6Height) {
			super(componentId, fontrendererObj, x, y, par5Width, par6Height);
			this.setMaxStringLength(3);
		}

		public boolean isNumber (char c) {
			try {
				Integer.parseInt(String.valueOf(c));
				return true;
			} catch (NumberFormatException e) {
				return false;
			}
		}

		@Override
		public boolean textboxKeyTyped (char c, int id) {
			switch (id) {
				case Keyboard.KEY_BACK:
					this.deleteFromCursor(1);
					break;
				case Keyboard.KEY_LEFT:
					this.moveCursorBy(-1);
					break;
				case Keyboard.KEY_RIGHT:
					this.moveCursorBy(1);
					break;
				default:
					if (isNumber(c)) {
						if (Integer.parseInt(this.getText() + c) > 255) {
							return false;
						}
					} else {
						return false;
					}
					break;
			}
			return super.textboxKeyTyped(c, id);
		}
	}

}
