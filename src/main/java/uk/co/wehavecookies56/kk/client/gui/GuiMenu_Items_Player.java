package uk.co.wehavecookies56.kk.client.gui;

import java.io.IOException;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.util.EnumHand;
import uk.co.wehavecookies56.kk.client.core.helper.GuiHelper;
import uk.co.wehavecookies56.kk.common.capability.ModCapabilities;
import uk.co.wehavecookies56.kk.common.lib.GuiIDs;
import uk.co.wehavecookies56.kk.common.lib.Strings;
import uk.co.wehavecookies56.kk.common.util.Utils;

public class GuiMenu_Items_Player extends GuiMenu_Bars {

    final int KEYCHAIN = 1, POTIONS = 2, SPELLS = 3, DRIVE = 4, BACK = 5;
    GuiButton keychain, potions, spells, driveforms, back;

    public GuiMenu_Items_Player (String name) {
        super(Minecraft.getMinecraft().player.getDisplayName().getFormattedText());
    }

    @Override
    protected void actionPerformed (GuiButton button) throws IOException {
        switch (button.id) {
            case KEYCHAIN:
                if (mc.player.getCapability(ModCapabilities.ORGANIZATION_XIII, null).getMember() == Utils.OrgMember.NONE)
                    GuiHelper.openInv(GuiIDs.GUI_KEYCHAIN_INV);
                else
                    Minecraft.getMinecraft().displayGuiScreen(new GuiOrgWeapon());
                break;
            case POTIONS:
                GuiHelper.openInv(GuiIDs.GUI_POTIONS_INV);
                break;
            case SPELLS:
                GuiHelper.openInv(GuiIDs.GUI_SPELLS_INV);
                break;
            case DRIVE:
                GuiHelper.openInv(GuiIDs.GUI_DRIVE_INV);
                break;
            case BACK:
                GuiHelper.openMenu_Items();
                break;
        }
        updateButtons();
    }

    private void updateButtons () {
        if (mc.player.getCapability(ModCapabilities.ORGANIZATION_XIII, null).getMember() == Utils.OrgMember.NONE){
            if(mc.player.getCapability(ModCapabilities.SUMMON_KEYBLADE,null).getIsKeybladeSummoned(EnumHand.MAIN_HAND) || mc.player.getCapability(ModCapabilities.SUMMON_KEYBLADE,null).getIsKeybladeSummoned(EnumHand.OFF_HAND)){
                keychain.enabled = false;
            }
        }else{
            if(mc.player.getCapability(ModCapabilities.ORGANIZATION_XIII,null).summonedWeapon(EnumHand.MAIN_HAND) || mc.player.getCapability(ModCapabilities.ORGANIZATION_XIII,null).summonedWeapon(EnumHand.OFF_HAND)){
                keychain.enabled = false;
            }
        }
        updateScreen();
    }

    @Override
    public void initGui () {
        super.initGui();
        int button_itemsY = (-140 / 16) + 75;

        int button_items_keybladeY = button_itemsY;
        int button_items_potionsY = button_items_keybladeY + 22;
        int button_items_spellsY = button_items_potionsY + 22;
        int button_items_driveY = button_items_spellsY + 22;
        int button_items_backY = button_items_driveY + 22;

        String weapon;
        if (mc.player.getCapability(ModCapabilities.ORGANIZATION_XIII, null).getMember() == Utils.OrgMember.NONE)
            weapon = Strings.Gui_Menu_Items_Button_Keychain;
        else
            weapon = Strings.Gui_Menu_Items_Button_OrgWeapon;

        buttonList.add(keychain = new GuiButton(KEYCHAIN, 5, button_items_keybladeY, 100, 20, Utils.translateToLocal(weapon)));
        buttonList.add(potions = new GuiButton(POTIONS, 5, button_items_potionsY, 100, 20, Utils.translateToLocal(Strings.Gui_Menu_Items_Button_Potions)));
        buttonList.add(spells = new GuiButton(SPELLS, 5, button_items_spellsY, 100, 20, Utils.translateToLocal(Strings.Gui_Menu_Items_Button_Spells)));
        buttonList.add(driveforms = new GuiButton(DRIVE, 5, button_items_driveY, 100, 20, Utils.translateToLocal(Strings.Gui_Menu_Items_Button_Drive)));
        buttonList.add(back = new GuiButton(BACK, 5, button_items_backY, 100, 20, Utils.translateToLocal(Strings.Gui_Menu_Items_Button_Back)));
        updateButtons();
    }

}
