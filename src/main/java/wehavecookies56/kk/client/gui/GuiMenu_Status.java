package wehavecookies56.kk.client.gui;

import java.io.IOException;
import java.util.Arrays;

import net.minecraft.client.gui.GuiButton;
import wehavecookies56.kk.entities.ExtendedPlayer;
import wehavecookies56.kk.entities.PlayerLevel;
import wehavecookies56.kk.util.GuiHelper;

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
		stats_player.enabled = selected != STATS_PLAYER;
		stats_valor.enabled = selected != STATS_VALOR;
		stats_wisdom.enabled = selected != STATS_WISDOM;
		stats_limit.enabled = selected != STATS_LIMIT;
		stats_master.enabled = selected != STATS_MASTER;
		stats_final.enabled = selected != STATS_FINAL;
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

		buttonList.add(stats_player = new GuiButton(STATS_PLAYER, 5, button_stats_playerY, 100, 20, mc.thePlayer.getDisplayNameString()));
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
		switch (selected) {
			case STATS_PLAYER:
				drawRect(125, ((-140 / 16) + 75) + 10, 200, ((-140 / 16) + 75) + 20, 0xFFFFFF);
				drawString(fontRendererObj, "Level", 125, ((-140 / 16) + 75) + 10, 0xFFFFFF);
				drawString(fontRendererObj, "Total Experience", 125, ((-140 / 16) + 75) + 22, 0xFFFFFF);
				drawString(fontRendererObj, "Next Level", 125, ((-140 / 16) + 75) + 34, 0xFFFFFF);
				drawString(fontRendererObj, "HP", 125, ((-140 / 16) + 75) + 46, 0xFFFFFF);
				drawString(fontRendererObj, "MP", 125, ((-140 / 16) + 75) + 58, 0xFFFFFF);
				drawString(fontRendererObj, "AP", 125, ((-140 / 16) + 75) + 70, 0xFFFFFF);
				drawString(fontRendererObj, "Drive Guage", 125, ((-140 / 16) + 75) + 82, 0xFFFFFF);
				drawString(fontRendererObj, "Bonus Level", 125, ((-140 / 16) + 75) + 94, 0xFFFFFF);
				drawString(fontRendererObj, "Strength", 125, ((-140 / 16) + 75) + 106, 0xFFFFFF);
				drawString(fontRendererObj, "Magic", 125, ((-140 / 16) + 75) + 118, 0xFFFFFF);
				drawString(fontRendererObj, "Defense", 125, ((-140 / 16) + 75) + 130, 0xFFFFFF);
				drawString(fontRendererObj, "Fire Resistance", 125, ((-140 / 16) + 75) + 142, 0xFFFFFF);
				drawString(fontRendererObj, "Blizzard Resistance", 125, ((-140 / 16) + 75) + 154, 0xFFFFFF);
				drawString(fontRendererObj, "Thunder Resistance", 125, ((-140 / 16) + 75) + 166, 0xFFFFFF);
				drawString(fontRendererObj, "Dark Resistance", 125, ((-140 / 16) + 75) + 178, 0xFFFFFF);

				drawString(fontRendererObj, "Fire level", 270, ((-140 / 16) + 75) + 10, 0xFFFFFF);
				drawString(fontRendererObj, "Blizzard level", 270, ((-140 / 16) + 75) + 22, 0xFFFFFF);
				drawString(fontRendererObj, "Thunder level", 270, ((-140 / 16) + 75) + 34, 0xFFFFFF);
				drawString(fontRendererObj, "Cure level", 270, ((-140 / 16) + 75) + 46, 0xFFFFFF);
				drawString(fontRendererObj, "Gravity level", 270, ((-140 / 16) + 75) + 58, 0xFFFFFF);
				drawString(fontRendererObj, "Aero level", 270, ((-140 / 16) + 75) + 70, 0xFFFFFF);
				drawString(fontRendererObj, "Stop level", 270, ((-140 / 16) + 75) + 82, 0xFFFFFF);

				ExtendedPlayer ep = ExtendedPlayer.get(mc.thePlayer);

				drawString(fontRendererObj, "" + ep.getLevel(), 230, ((-140 / 16) + 75) + 10, 0xFFD900);
				drawString(fontRendererObj, "" + ep.getXP(), 230, ((-140 / 16) + 75) + 22, 0xFFD900);
				drawString(fontRendererObj, "" + ((Arrays.stream(PlayerLevel.expNeeded, 0, ep.getLevel()).sum()) - ep.getXP()), 230, ((-140 / 16) + 75) + 34, 0xFFD900);
				drawString(fontRendererObj, "" + (int) mc.thePlayer.getMaxHealth(), 230, ((-140 / 16) + 75) + 46, 0xFFD900);
				drawString(fontRendererObj, "" + (int) ep.getMaxMp(), 230, ((-140 / 16) + 75) + 58, 0xFFD900);
				drawString(fontRendererObj, "N/A", 230, ((-140 / 16) + 75) + 70, 0xFFD900);
				drawString(fontRendererObj, "9", 230, ((-140 / 16) + 75) + 82, 0xFFD900);
				drawString(fontRendererObj, "N/A", 230, ((-140 / 16) + 75) + 94, 0xFFD900);
				drawString(fontRendererObj, "" + ep.getStrength(), 230, ((-140 / 16) + 75) + 106, 0xFFD900);
				drawString(fontRendererObj, "" + ep.getMagic(), 230, ((-140 / 16) + 75) + 118, 0xFFD900);
				drawString(fontRendererObj, "" + ep.getDefense(), 230, ((-140 / 16) + 75) + 130, 0xFFD900);
				drawString(fontRendererObj, "0%", 230, ((-140 / 16) + 75) + 142, 0xFFD900);
				drawString(fontRendererObj, "0%", 230, ((-140 / 16) + 75) + 154, 0xFFD900);
				drawString(fontRendererObj, "0%", 230, ((-140 / 16) + 75) + 166, 0xFFD900);
				drawString(fontRendererObj, "0%", 230, ((-140 / 16) + 75) + 178, 0xFFD900);

				drawString(fontRendererObj, "" + ep.getMagicLevel("Fire"), 370, ((-140 / 16) + 75) + 10, 0xFFD900);
				drawString(fontRendererObj, "" + ep.getMagicLevel("Blizzard"), 370, ((-140 / 16) + 75) + 22, 0xFFD900);
				drawString(fontRendererObj, "" + ep.getMagicLevel("Thunder"), 370, ((-140 / 16) + 75) + 34, 0xFFD900);
				drawString(fontRendererObj, "" + ep.getMagicLevel("Cure"), 370, ((-140 / 16) + 75) + 46, 0xFFD900);
				drawString(fontRendererObj, "" + ep.getMagicLevel("Gravity"), 370, ((-140 / 16) + 75) + 58, 0xFFD900);
				drawString(fontRendererObj, "" + ep.getMagicLevel("Aero"), 370, ((-140 / 16) + 75) + 70, 0xFFD900);
				drawString(fontRendererObj, "" + ep.getMagicLevel("Stop"), 370, ((-140 / 16) + 75) + 82, 0xFFD900);

				break;
			case STATS_VALOR:

				break;
			case STATS_WISDOM:

				break;
			case STATS_LIMIT:

				break;
			case STATS_MASTER:

				break;
			case STATS_FINAL:

				break;
		}
	}

}
