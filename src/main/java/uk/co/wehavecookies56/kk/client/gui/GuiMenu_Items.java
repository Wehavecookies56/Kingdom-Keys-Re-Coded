package uk.co.wehavecookies56.kk.client.gui;

import java.io.IOException;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import uk.co.wehavecookies56.kk.client.core.helper.GuiHelper;
import uk.co.wehavecookies56.kk.client.gui.redesign.GuiMenuButton;
import uk.co.wehavecookies56.kk.common.lib.Strings;
import uk.co.wehavecookies56.kk.common.util.Utils;

public class GuiMenu_Items extends GuiScreen {

    final int ITEMS_PLAYER = 1, ITEMS_STOCK = 2, ITEMS_BACK = 3;

    GuiButton items_player, items_stock, items_back;

    GuiMenu_Bars background;

    public GuiMenu_Items () {
        background = new GuiMenu_Bars(Strings.Gui_Menu_Items_Title);
        mc = Minecraft.getMinecraft();
    }

    @Override
    protected void actionPerformed (GuiButton button) throws IOException {
        switch (button.id) {
            case ITEMS_PLAYER:
                GuiHelper.openMenu_Items_Player();
                break;
            case ITEMS_BACK:
                GuiHelper.openMenu();
                break;
            case ITEMS_STOCK:
                mc.displayGuiScreen(new GuiStock());
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
        background.width = width;
        background.height = height;
        background.init();
        float topBarHeight = (float)height * 0.17F;
        int button_itemsY = (int)topBarHeight+5;
        float buttonPosX = (float)width * 0.1526F;
        float buttonWidth = ((float)width * 0.1744F)-22;

        int button_items_playerY = button_itemsY;
        int button_items_stockY = button_items_playerY + 22;
        int button_items_backY = button_items_stockY + 22;

        buttonList.add(items_player = new GuiMenuButton(ITEMS_PLAYER, (int)buttonPosX, button_items_playerY, (int)buttonWidth, mc.player.getDisplayNameString()));
        buttonList.add(items_stock = new GuiMenuButton(ITEMS_STOCK, (int)buttonPosX, button_items_stockY, (int)buttonWidth, Utils.translateToLocal(Strings.Gui_Menu_Items_Button_Stock)));
        buttonList.add(items_back = new GuiMenuButton(ITEMS_BACK, (int)buttonPosX, button_items_backY, (int)buttonWidth, Utils.translateToLocal(Strings.Gui_Menu_Items_Button_Back)));

        updateButtons();
    }

    @Override
    public void drawScreen(int mouseX, int mouseY, float partialTicks) {
        background.drawBars();
        background.drawMunnyTime();
        background.drawBiomeDim();
        super.drawScreen(mouseX, mouseY, partialTicks);
    }
    
    @Override
	protected void mouseClicked(int mouseX, int mouseY, int mouseButton) throws IOException {
		if (mouseButton == 1) {
			GuiHelper.openMenu();
		}
		super.mouseClicked(mouseX, mouseY, mouseButton);
	}
}
