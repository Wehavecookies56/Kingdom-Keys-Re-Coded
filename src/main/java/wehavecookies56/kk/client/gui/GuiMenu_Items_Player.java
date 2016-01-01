package wehavecookies56.kk.client.gui;

import java.io.IOException;

import wehavecookies56.kk.KingdomKeys;
import wehavecookies56.kk.entities.ExtendedPlayer;
import wehavecookies56.kk.lib.Strings;
import wehavecookies56.kk.network.packet.PacketDispatcher;
import wehavecookies56.kk.network.packet.server.OpenGui;
import wehavecookies56.kk.util.GuiHelper;
import wehavecookies56.kk.util.TextHelper;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.inventory.GuiInventory;

public class GuiMenu_Items_Player extends GuiMenu_Bars {

	final int KEYCHAIN = 1, SYNTHBAG = 2, BACK = 3;

	GuiButton keychain, synthbag, back;

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
    	int button_items_backY = button_items_stockY + 22;

    	buttonList.add(keychain = new GuiButton(KEYCHAIN, 5, button_items_playerY, 100, 20, TextHelper.localize(Strings.Gui_Menu_Items_Button_Keychain)));
    	buttonList.add(synthbag = new GuiButton(SYNTHBAG, 5, button_items_stockY, 100, 20, TextHelper.localize(Strings.Gui_Menu_Items_Button_SynthBag)));
    	buttonList.add(back = new GuiButton(BACK, 5, button_items_backY, 100, 20, TextHelper.localize(Strings.Gui_Menu_Items_Button_Back)));
    	synthbag.enabled = false;

    	updateButtons();
    }

}
