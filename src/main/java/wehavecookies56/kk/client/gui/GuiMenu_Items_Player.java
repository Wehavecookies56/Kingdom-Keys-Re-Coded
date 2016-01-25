package wehavecookies56.kk.client.gui;

import java.io.IOException;

import net.minecraft.client.gui.GuiButton;
import wehavecookies56.kk.KingdomKeys;
import wehavecookies56.kk.entities.ExtendedPlayer;
import wehavecookies56.kk.lib.Strings;
import wehavecookies56.kk.util.GuiHelper;
import wehavecookies56.kk.util.TextHelper;

public class GuiMenu_Items_Player extends GuiMenu_Bars {

	final int KEYCHAIN = 1, SYNTHBAG = 2, POTIONS = 3, SPELLS = 4, BACK = 5;

	GuiButton keychain, synthbag, potions, spells, back;

	public GuiMenu_Items_Player(String name) {
		super(Strings.Gui_Menu_Items_Player);
	}

    @Override
	protected void actionPerformed(GuiButton button) throws IOException {
		switch(button.id){
		case KEYCHAIN:
			GuiHelper.openInv(KingdomKeys.GUI_KEYCHAIN_INV);
			break;
		case SYNTHBAG:
			GuiHelper.openInv(KingdomKeys.GUI_SYNTHBAG_INV);
			break;
		case POTIONS:
			GuiHelper.openInv(KingdomKeys.GUI_POTIONS_INV);
			break;
		case SPELLS:
			GuiHelper.openInv(KingdomKeys.GUI_SPELLS_INV);
			break;
		case BACK:
			GuiHelper.openMenu();
			break;
		}
		updateButtons();
	}

    private void updateButtons() {
    	keychain.enabled = ExtendedPlayer.get(mc.thePlayer).isKeybladeSummoned() == false;
		this.updateScreen();
	}

	@Override
    public void initGui() {
    	super.initGui();
    	int button_itemsY = (-140/16) + 75;

    	int button_items_playerY = button_itemsY;
    	int button_items_stockY = button_items_playerY + 22;
    	int button_items_potionsY = button_items_stockY + 22;
    	int button_items_spellsY = button_items_potionsY + 22;
    	int button_items_backY = button_items_spellsY + 22;

    	buttonList.add(keychain = new GuiButton(KEYCHAIN, 5, button_items_playerY, 100, 20, TextHelper.localize(Strings.Gui_Menu_Items_Button_Keychain)));
    	buttonList.add(synthbag = new GuiButton(SYNTHBAG, 5, button_items_stockY, 100, 20, TextHelper.localize(Strings.Gui_Menu_Items_Button_SynthBag)));
    	buttonList.add(potions = new GuiButton(POTIONS, 5, button_items_potionsY, 100, 20, TextHelper.localize("Potions")));
    	buttonList.add(spells = new GuiButton(SPELLS, 5, button_items_spellsY, 100, 20, TextHelper.localize("Spells")));
    	buttonList.add(back = new GuiButton(BACK, 5, button_items_backY, 100, 20, TextHelper.localize(Strings.Gui_Menu_Items_Button_Back)));
    	synthbag.enabled = true;

    	updateButtons();
    }

}
