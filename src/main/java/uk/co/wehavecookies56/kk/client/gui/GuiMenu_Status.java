package uk.co.wehavecookies56.kk.client.gui;

import net.minecraft.client.gui.GuiButton;
import uk.co.wehavecookies56.kk.api.driveforms.DriveFormRegistry;
import uk.co.wehavecookies56.kk.client.core.helper.GuiHelper;
import uk.co.wehavecookies56.kk.common.capability.DriveStateCapability.IDriveState;
import uk.co.wehavecookies56.kk.common.capability.MagicStateCapability.IMagicState;
import uk.co.wehavecookies56.kk.common.capability.ModCapabilities;
import uk.co.wehavecookies56.kk.common.capability.PlayerStatsCapability;
import uk.co.wehavecookies56.kk.common.lib.Strings;

import java.io.IOException;

public class GuiMenu_Status extends GuiMenu_Bars {

    final int STATS_PLAYER = 0, STATS_VALOR = 1, STATS_WISDOM = 2, STATS_LIMIT = 3, STATS_MASTER = 4, STATS_FINAL = 5, STATS_BACK = 6;

    int selected = 0;

    GuiButton stats_player, stats_valor, stats_wisdom, stats_limit, stats_master, stats_final, stats_back;

    public GuiMenu_Status (String name) {
        super("Status");
        drawPlayerInfo = false;
    }

    @Override
    protected void actionPerformed (GuiButton button) throws IOException {
        switch (button.id) {
            case STATS_PLAYER:
                selected = STATS_PLAYER;
                break;
            case STATS_VALOR:
                selected = STATS_VALOR;
                break;
            case STATS_WISDOM:
                selected = STATS_WISDOM;
                break;
            case STATS_LIMIT:
                selected = STATS_LIMIT;
                break;
            case STATS_MASTER:
                selected = STATS_MASTER;
                break;
            case STATS_FINAL:
                selected = STATS_FINAL;
                break;
            case STATS_BACK:
                GuiHelper.openMenu();
                break;
        }
        updateButtons();
    }

    private void updateButtons () {
        IDriveState DRIVE = mc.player.getCapability(ModCapabilities.DRIVE_STATE, null);

        stats_player.enabled = selected != STATS_PLAYER;
        stats_valor.enabled = selected != STATS_VALOR && DRIVE.getDriveLevel(Strings.Form_Valor) > 0;
        stats_wisdom.enabled = selected != STATS_WISDOM && DRIVE.getDriveLevel(Strings.Form_Wisdom) > 0;
        stats_limit.enabled = selected != STATS_LIMIT && DRIVE.getDriveLevel(Strings.Form_Limit) > 0;
        stats_master.enabled = selected != STATS_MASTER && DRIVE.getDriveLevel(Strings.Form_Master) > 0;
        stats_final.enabled = selected != STATS_FINAL && DRIVE.getDriveLevel(Strings.Form_Final) > 0;
        updateScreen();
    }

    @Override
    public void initGui () {
        // super.initGui();

        selected = 0;

        int button_statsY = (-140 / 16) + 75;
        int button_stats_playerY = button_statsY;
        int button_stats_valorY = button_stats_playerY + 22;
        int button_stats_wisdomY = button_stats_valorY + 22;
        int button_stats_limitY = button_stats_wisdomY + 22;
        int button_stats_masterY = button_stats_limitY + 22;
        int button_stats_finalY = button_stats_masterY + 22;
        int button_stats_backY = button_stats_finalY + 22;

        buttonList.add(stats_player = new GuiButton(STATS_PLAYER, 5, button_stats_playerY, 100, 20, mc.player.getDisplayNameString()));
        buttonList.add(stats_valor = new GuiButton(STATS_VALOR, 15, button_stats_valorY, 100, 20, "Valor"));
        buttonList.add(stats_wisdom = new GuiButton(STATS_WISDOM, 15, button_stats_wisdomY, 100, 20, "Wisdom"));
        buttonList.add(stats_limit = new GuiButton(STATS_LIMIT, 15, button_stats_limitY, 100, 20, "Limit"));
        buttonList.add(stats_master = new GuiButton(STATS_MASTER, 15, button_stats_masterY, 100, 20, "Master"));
        buttonList.add(stats_final = new GuiButton(STATS_FINAL, 15, button_stats_finalY, 100, 20, "Final"));
        buttonList.add(stats_back = new GuiButton(STATS_BACK, 5, button_stats_backY, 100, 20, "Back"));

        updateButtons();

    }

    @Override
    public void drawScreen (int mouseX, int mouseY, float partialTicks) {
        super.drawScreen(mouseX, mouseY, partialTicks);
        final PlayerStatsCapability.IPlayerStats STATS = mc.player.getCapability(ModCapabilities.PLAYER_STATS, null);

        IMagicState MAGIC = mc.player.getCapability(ModCapabilities.MAGIC_STATE, null);
        IDriveState DRIVE = mc.player.getCapability(ModCapabilities.DRIVE_STATE, null);
        //System.out.println(ds.getDriveLevel(Strings.Form_Valor)+" "+ds.getDriveLevel(Strings.Form_Wisdom)+" "+ds.getDriveLevel(Strings.Form_Limit)+" "+ds.getDriveLevel(Strings.Form_Master)+" "+ds.getDriveLevel(Strings.Form_Final));
        int[] valorCosts = DriveFormRegistry.get(Strings.Form_Valor).getExpCosts();
        int[] wisdomCosts = DriveFormRegistry.get(Strings.Form_Wisdom).getExpCosts();
        int[] limitCosts = DriveFormRegistry.get(Strings.Form_Limit).getExpCosts();
        int[] masterCosts = DriveFormRegistry.get(Strings.Form_Master).getExpCosts();
        int[] finalCosts = DriveFormRegistry.get(Strings.Form_Final).getExpCosts();
        int remainingExp;
        switch (selected) {
            case STATS_PLAYER:
                drawRect(125, ((-140 / 16) + 75) + 10, 200, ((-140 / 16) + 75) + 20, 0xFFFFFF);
                drawString(fontRenderer, "Level", 125, ((-140 / 16) + 75) + 10, 0xFFFFFF);
                drawString(fontRenderer, "Total Experience", 125, ((-140 / 16) + 75) + 22, 0xFFFFFF);
                drawString(fontRenderer, "Next Level", 125, ((-140 / 16) + 75) + 34, 0xFFFFFF);
                drawString(fontRenderer, "HP", 125, ((-140 / 16) + 75) + 46, 0xFFFFFF);
                drawString(fontRenderer, "MP", 125, ((-140 / 16) + 75) + 58, 0xFFFFFF);
                drawString(fontRenderer, "AP", 125, ((-140 / 16) + 75) + 70, 0xFFFFFF);
                drawString(fontRenderer, "Drive Gauge", 125, ((-140 / 16) + 75) + 82, 0xFFFFFF);
                drawString(fontRenderer, "Bonus Level", 125, ((-140 / 16) + 75) + 94, 0xFFFFFF);
                drawString(fontRenderer, "Strength", 125, ((-140 / 16) + 75) + 106, 0xFFFFFF);
                drawString(fontRenderer, "Magic", 125, ((-140 / 16) + 75) + 118, 0xFFFFFF);
                drawString(fontRenderer, "Defense", 125, ((-140 / 16) + 75) + 130, 0xFFFFFF);
                drawString(fontRenderer, "Fire Resistance", 125, ((-140 / 16) + 75) + 142, 0xFFFFFF);
                drawString(fontRenderer, "Blizzard Resistance", 125, ((-140 / 16) + 75) + 154, 0xFFFFFF);
                drawString(fontRenderer, "Thunder Resistance", 125, ((-140 / 16) + 75) + 166, 0xFFFFFF);
                drawString(fontRenderer, "Dark Resistance", 125, ((-140 / 16) + 75) + 178, 0xFFFFFF);

                drawString(fontRenderer, "Fire level", 270, ((-140 / 16) + 75) + 10, 0xFFFFFF);
                drawString(fontRenderer, "Blizzard level", 270, ((-140 / 16) + 75) + 22, 0xFFFFFF);
                drawString(fontRenderer, "Thunder level", 270, ((-140 / 16) + 75) + 34, 0xFFFFFF);
                drawString(fontRenderer, "Cure level", 270, ((-140 / 16) + 75) + 46, 0xFFFFFF);
                drawString(fontRenderer, "Gravity level", 270, ((-140 / 16) + 75) + 58, 0xFFFFFF);
                drawString(fontRenderer, "Aero level", 270, ((-140 / 16) + 75) + 70, 0xFFFFFF);
                drawString(fontRenderer, "Stop level", 270, ((-140 / 16) + 75) + 82, 0xFFFFFF);


                drawString(fontRenderer, "" + STATS.getLevel(), 230, ((-140 / 16) + 75) + 10, 0xFFD900);
                drawString(fontRenderer, "" + STATS.getExperience(), 230, ((-140 / 16) + 75) + 22, 0xFFD900);
                drawString(fontRenderer, "" + (STATS.getExpNeeded(STATS.getLevel(), STATS.getExperience())), 230, ((-140 / 16) + 75) + 34, 0xFFD900);
                drawString(fontRenderer, "" + (int) mc.player.getMaxHealth(), 230, ((-140 / 16) + 75) + 46, 0xFFD900);
                drawString(fontRenderer, "" + (int) STATS.getMaxMP(), 230, ((-140 / 16) + 75) + 58, 0xFFD900);
                drawString(fontRenderer, "N/A", 230, ((-140 / 16) + 75) + 70, 0xFFD900);
                drawString(fontRenderer, ""+ DRIVE.getDriveGaugeLevel(), 230, ((-140 / 16) + 75) + 82, 0xFFD900);
                drawString(fontRenderer, "N/A", 230, ((-140 / 16) + 75) + 94, 0xFFD900);
                drawString(fontRenderer, "" + STATS.getStrength(), 230, ((-140 / 16) + 75) + 106, 0xFFD900);
                drawString(fontRenderer, "" + STATS.getMagic(), 230, ((-140 / 16) + 75) + 118, 0xFFD900);
                drawString(fontRenderer, "" + STATS.getDefense(), 230, ((-140 / 16) + 75) + 130, 0xFFD900);
                drawString(fontRenderer, "0%", 230, ((-140 / 16) + 75) + 142, 0xFFD900);
                drawString(fontRenderer, "0%", 230, ((-140 / 16) + 75) + 154, 0xFFD900);
                drawString(fontRenderer, "0%", 230, ((-140 / 16) + 75) + 166, 0xFFD900);
                drawString(fontRenderer, "0%", 230, ((-140 / 16) + 75) + 178, 0xFFD900);

                drawString(fontRenderer, "" + MAGIC.getMagicLevel(Strings.Spell_Fire), 370, ((-140 / 16) + 75) + 10, 0xFFD900);
                drawString(fontRenderer, "" + MAGIC.getMagicLevel(Strings.Spell_Blizzard), 370, ((-140 / 16) + 75) + 22, 0xFFD900);
                drawString(fontRenderer, "" + MAGIC.getMagicLevel(Strings.Spell_Thunder), 370, ((-140 / 16) + 75) + 34, 0xFFD900);
                drawString(fontRenderer, "" + MAGIC.getMagicLevel(Strings.Spell_Cure), 370, ((-140 / 16) + 75) + 46, 0xFFD900);
                drawString(fontRenderer, "" + MAGIC.getMagicLevel(Strings.Spell_Gravity), 370, ((-140 / 16) + 75) + 58, 0xFFD900);
                drawString(fontRenderer, "" + MAGIC.getMagicLevel(Strings.Spell_Aero), 370, ((-140 / 16) + 75) + 70, 0xFFD900);
                drawString(fontRenderer, "" + MAGIC.getMagicLevel(Strings.Spell_Stop), 370, ((-140 / 16) + 75) + 82, 0xFFD900);


                break;
            case STATS_VALOR:
            	remainingExp = DRIVE.getDriveLevel(Strings.Form_Valor) == 7 ? 0 : valorCosts[DRIVE.getDriveLevel(Strings.Form_Valor)]-DRIVE.getDriveExp(Strings.Form_Valor);
                drawRect(125, ((-140 / 16) + 75) + 10, 200, ((-140 / 16) + 75) + 20, 0xFFFFFF);
                drawString(fontRenderer, "Level", 125, ((-140 / 16) + 75) + 10, 0xFFFFFF);
                drawString(fontRenderer, "Experience", 125, ((-140 / 16) + 75) + 22, 0xFFFFFF);
                drawString(fontRenderer, "Next Level", 125, ((-140 / 16) + 75) + 34, 0xFFFFFF);
                drawString(fontRenderer, "Form Gauge", 125, ((-140 / 16) + 75) + 46, 0xFFFFFF);

                drawString(fontRenderer, "" + DRIVE.getDriveLevel(Strings.Form_Valor), 230, ((-140 / 16) + 75) + 10, 0xFFD900);
                drawString(fontRenderer, "" + DRIVE.getDriveExp(Strings.Form_Valor), 230, ((-140 / 16) + 75) + 22, 0xFFD900);
                drawString(fontRenderer, "" + remainingExp, 230, ((-140 / 16) + 75) + 34, 0xFFD900);
                drawString(fontRenderer, "" + DRIVE.getFormGaugeLevel(Strings.Form_Valor), 230, ((-140 / 16) + 75) + 46, 0xFFD900);
                break;
            case STATS_WISDOM:
            	remainingExp = DRIVE.getDriveLevel(Strings.Form_Wisdom) == 7 ? 0 : valorCosts[DRIVE.getDriveLevel(Strings.Form_Wisdom)]-DRIVE.getDriveExp(Strings.Form_Wisdom);
                drawRect(125, ((-140 / 16) + 75) + 10, 200, ((-140 / 16) + 75) + 20, 0xFFFFFF);
                drawString(fontRenderer, "Level", 125, ((-140 / 16) + 75) + 10, 0xFFFFFF);
                drawString(fontRenderer, "Experience", 125, ((-140 / 16) + 75) + 22, 0xFFFFFF);
                drawString(fontRenderer, "Next Level", 125, ((-140 / 16) + 75) + 34, 0xFFFFFF);
                drawString(fontRenderer, "Form Gauge", 125, ((-140 / 16) + 75) + 46, 0xFFFFFF);

                drawString(fontRenderer, "" + DRIVE.getDriveLevel(Strings.Form_Wisdom), 230, ((-140 / 16) + 75) + 10, 0xFFD900);
                drawString(fontRenderer, "" + DRIVE.getDriveExp(Strings.Form_Wisdom), 230, ((-140 / 16) + 75) + 22, 0xFFD900);
                drawString(fontRenderer, "" + remainingExp, 230, ((-140 / 16) + 75) + 34, 0xFFD900);
                drawString(fontRenderer, "" + DRIVE.getFormGaugeLevel(Strings.Form_Wisdom), 230, ((-140 / 16) + 75) + 46, 0xFFD900);
                break;
            case STATS_LIMIT:
            	remainingExp = DRIVE.getDriveLevel(Strings.Form_Limit) == 7 ? 0 : valorCosts[DRIVE.getDriveLevel(Strings.Form_Limit)]-DRIVE.getDriveExp(Strings.Form_Limit);
                drawRect(125, ((-140 / 16) + 75) + 10, 200, ((-140 / 16) + 75) + 20, 0xFFFFFF);
                drawString(fontRenderer, "Level", 125, ((-140 / 16) + 75) + 10, 0xFFFFFF);
                drawString(fontRenderer, "Experience", 125, ((-140 / 16) + 75) + 22, 0xFFFFFF);
                drawString(fontRenderer, "Next Level", 125, ((-140 / 16) + 75) + 34, 0xFFFFFF);
                drawString(fontRenderer, "From Gauge", 125, ((-140 / 16) + 75) + 46, 0xFFFFFF);

                drawString(fontRenderer, "" + DRIVE.getDriveLevel(Strings.Form_Limit), 230, ((-140 / 16) + 75) + 10, 0xFFD900);
                drawString(fontRenderer, "" + DRIVE.getDriveExp(Strings.Form_Limit), 230, ((-140 / 16) + 75) + 22, 0xFFD900);
                drawString(fontRenderer, "" + remainingExp, 230, ((-140 / 16) + 75) + 34, 0xFFD900);
                drawString(fontRenderer, "" + DRIVE.getFormGaugeLevel(Strings.Form_Limit), 230, ((-140 / 16) + 75) + 46, 0xFFD900);
                break;
            case STATS_MASTER:
            	remainingExp = DRIVE.getDriveLevel(Strings.Form_Master) == 7 ? 0 : valorCosts[DRIVE.getDriveLevel(Strings.Form_Master)]-DRIVE.getDriveExp(Strings.Form_Master);
                drawRect(125, ((-140 / 16) + 75) + 10, 200, ((-140 / 16) + 75) + 20, 0xFFFFFF);
                drawString(fontRenderer, "Level", 125, ((-140 / 16) + 75) + 10, 0xFFFFFF);
                drawString(fontRenderer, "Experience", 125, ((-140 / 16) + 75) + 22, 0xFFFFFF);
                drawString(fontRenderer, "Next Level", 125, ((-140 / 16) + 75) + 34, 0xFFFFFF);
                drawString(fontRenderer, "From Gauge", 125, ((-140 / 16) + 75) + 46, 0xFFFFFF);

                drawString(fontRenderer, "" + DRIVE.getDriveLevel(Strings.Form_Master), 230, ((-140 / 16) + 75) + 10, 0xFFD900);
                drawString(fontRenderer, "" + DRIVE.getDriveExp(Strings.Form_Master), 230, ((-140 / 16) + 75) + 22, 0xFFD900);
                drawString(fontRenderer, "" + remainingExp, 230, ((-140 / 16) + 75) + 34, 0xFFD900);
                drawString(fontRenderer, "" + DRIVE.getFormGaugeLevel(Strings.Form_Master), 230, ((-140 / 16) + 75) + 46, 0xFFD900);
                break;
            case STATS_FINAL:
            	remainingExp = DRIVE.getDriveLevel(Strings.Form_Final) == 7 ? 0 : valorCosts[DRIVE.getDriveLevel(Strings.Form_Final)]-DRIVE.getDriveExp(Strings.Form_Final);
                drawRect(125, ((-140 / 16) + 75) + 10, 200, ((-140 / 16) + 75) + 20, 0xFFFFFF);
                drawString(fontRenderer, "Level", 125, ((-140 / 16) + 75) + 10, 0xFFFFFF);
                drawString(fontRenderer, "Experience", 125, ((-140 / 16) + 75) + 22, 0xFFFFFF);
                drawString(fontRenderer, "Next Level", 125, ((-140 / 16) + 75) + 34, 0xFFFFFF);
                drawString(fontRenderer, "From Gauge", 125, ((-140 / 16) + 75) + 46, 0xFFFFFF);

                drawString(fontRenderer, "" + DRIVE.getDriveLevel(Strings.Form_Final), 230, ((-140 / 16) + 75) + 10, 0xFFD900);
                drawString(fontRenderer, "" + DRIVE.getDriveExp(Strings.Form_Final), 230, ((-140 / 16) + 75) + 22, 0xFFD900);
                drawString(fontRenderer, "" + remainingExp, 230, ((-140 / 16) + 75) + 34, 0xFFD900);
                drawString(fontRenderer, "" + DRIVE.getFormGaugeLevel(Strings.Form_Final), 230, ((-140 / 16) + 75) + 46, 0xFFD900);
                break;
        }
    }

}
