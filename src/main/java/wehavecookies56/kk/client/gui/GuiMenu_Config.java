package wehavecookies56.kk.client.gui;

import java.io.IOException;

import net.minecraft.client.gui.GuiButton;
import wehavecookies56.kk.lib.Strings;
import wehavecookies56.kk.util.GuiHelper;
import wehavecookies56.kk.util.TextHelper;

public class GuiMenu_Config extends GuiMenu_Bars {

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

		updateButtons();
	}
	
	

}
