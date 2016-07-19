package uk.co.wehavecookies56.kk.client.gui;

import java.io.IOException;

import net.minecraft.client.gui.GuiButton;
import uk.co.wehavecookies56.kk.client.core.helper.GuiHelper;
import uk.co.wehavecookies56.kk.common.core.helper.TextHelper;
import uk.co.wehavecookies56.kk.common.lib.Strings;
import uk.co.wehavecookies56.kk.common.util.Utils;

public class GuiMenu extends GuiMenu_Bars {

	public GuiMenu (String name) {
		super(Strings.Gui_Menu_Main_Title);
	}

	final int ITEMS = 0, ABILITIES = 1, CUSTOMIZE = 2, PARTY = 3, STATUS = 4, JOURNAL = 5, CONFIG = 6;
	final int SUBMENU_MAIN = 0, SUBMENU_ITEMS = 1;

	GuiButton items, abilities, customize, party, status, journal, config;

	static int munny;

	int submenuIndex = SUBMENU_MAIN;

	@Override
	protected void actionPerformed (GuiButton button) throws IOException {
		switch (button.id) {
			case ITEMS:
				GuiHelper.openMenu_Items();
				break;
			case STATUS:
				GuiHelper.openStatus();
				break;
			case JOURNAL:
				GuiHelper.openReports();
				break;
			case CONFIG:
				GuiHelper.openMenu_Config();
				break;
		}
		updateButtons();
	}

	@Override
	public void initGui () {
		super.initGui();
		int button_itemsY = (-140 / 16) + 75;
		int button_abilitiesY = button_itemsY + 22;
		int button_customizeY = button_abilitiesY + 22;
		int button_partyY = button_customizeY + 22;
		int button_statusY = button_partyY + 22;
		int button_journalY = button_statusY + 22;
		int button_configY = button_journalY + 22;

		buttonList.add(items = new GuiButton(ITEMS, 5, button_itemsY, 100, 20, Utils.translateToLocal(Strings.Gui_Menu_Main_Button_Items)));
		buttonList.add(abilities = new GuiButton(ABILITIES, 5, button_abilitiesY, 100, 20, Utils.translateToLocal(Strings.Gui_Menu_Main_Button_Abilities)));
		buttonList.add(customize = new GuiButton(CUSTOMIZE, 5, button_customizeY, 100, 20, Utils.translateToLocal(Strings.Gui_Menu_Main_Button_Customize)));
		buttonList.add(party = new GuiButton(PARTY, 5, button_partyY, 100, 20, Utils.translateToLocal(Strings.Gui_Menu_Main_Button_Party)));
		buttonList.add(status = new GuiButton(STATUS, 5, button_statusY, 100, 20, Utils.translateToLocal(Strings.Gui_Menu_Main_Button_Status)));
		buttonList.add(journal = new GuiButton(JOURNAL, 5, button_journalY, 100, 20, Utils.translateToLocal(Strings.Gui_Menu_Main_Button_Journal)));
		buttonList.add(config = new GuiButton(CONFIG, 5, button_configY, 100, 20, Utils.translateToLocal(Strings.Gui_Menu_Main_Button_Config)));

		updateButtons();
	}

	private void updateButtons () {
		switch (submenuIndex) {
			case SUBMENU_MAIN:
				this.items.visible = true;
				abilities.visible = true;
				customize.visible = true;
				party.visible = true;
				status.visible = true;
				journal.visible = true;
				config.visible = true;
				this.abilities.enabled = false;
				this.customize.enabled = false;
				this.party.enabled = false;
				this.journal.enabled = false;
				break;
			case SUBMENU_ITEMS:
				items.visible = false;
				abilities.visible = false;
				customize.visible = false;
				party.visible = false;
				status.visible = false;
				journal.visible = false;
				config.visible = false;
				break;
		}
	}

}
