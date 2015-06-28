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

public class GuiMenu_Items extends GuiMenu_Bars {

	final int ITEMS_PLAYER = 1, ITEMS_STOCK = 2, ITEMS_BACK = 3;	

	GuiButton items_player, items_stock, items_back;
	
	public GuiMenu_Items(String name) {
		super(Strings.Gui_Menu_Items_Title);
	}
	
    @Override
	protected void actionPerformed(GuiButton button) throws IOException {
		switch(button.id){
		case ITEMS_PLAYER:
			GuiHelper.openInv(KingdomKeys.GUI_KEYCHAIN_INV);
			break;
		case ITEMS_BACK:
			GuiHelper.openMenu();
			break;
		case ITEMS_STOCK:
			GuiHelper.openPlayerInventory(mc.thePlayer);
			break;
		}
		updateButtons();
	}
	
    private void updateButtons() {
		items_player.enabled = ExtendedPlayer.get(mc.thePlayer).getSummonedKeyblade() == 0;
		this.updateScreen();
	}
    
	
	

	@Override
    public void initGui() {
    	super.initGui();
    	int button_itemsY = (-140/16) + 75;
    	
    	int button_items_playerY = button_itemsY;
    	int button_items_stockY = button_items_playerY + 22;
    	int button_items_backY = button_items_stockY + 22;
    	
    	buttonList.add(items_player = new GuiButton(ITEMS_PLAYER, 5, button_items_playerY, 100, 20, mc.thePlayer.getDisplayNameString()));
    	buttonList.add(items_stock = new GuiButton(ITEMS_STOCK, 5, button_items_stockY, 100, 20, TextHelper.localize(Strings.Gui_Menu_Items_Button_Stock)));
    	buttonList.add(items_back = new GuiButton(ITEMS_BACK, 5, button_items_backY, 100, 20, TextHelper.localize(Strings.Gui_Menu_Items_Button_Back)));

    	updateButtons();
    }
	
}
