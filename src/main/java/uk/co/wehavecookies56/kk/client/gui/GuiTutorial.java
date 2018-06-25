package uk.co.wehavecookies56.kk.client.gui;

import static uk.co.wehavecookies56.kk.common.util.Utils.OrgMember.ROXAS;
import static uk.co.wehavecookies56.kk.common.util.Utils.OrgMember.XEMNAS;

import java.io.IOException;

import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import uk.co.wehavecookies56.kk.common.capability.ModCapabilities;
import uk.co.wehavecookies56.kk.common.lib.Tutorial;
import uk.co.wehavecookies56.kk.common.lib.Tutorials;
import uk.co.wehavecookies56.kk.common.network.packet.PacketDispatcher;
import uk.co.wehavecookies56.kk.common.network.packet.server.OrgMemberSelect;
import uk.co.wehavecookies56.kk.common.util.Utils;

/**
 * Created by Toby on 08/02/2017.
 */
public class GuiTutorial extends GuiScreen {

	Tutorial tutorial;

	public GuiTutorial(int num) {
		tutorial = Tutorials.getTutorialById(num);
	}

	GuiButton next, prev, ok;
	final int NEXT = 0, PREV = 1, OK = 2;

	@Override
	public void drawScreen(int mouseX, int mouseY, float partialTicks) {
		drawDefaultBackground();
		super.drawScreen(mouseX, mouseY, partialTicks);

		for (int i = 0; i < tutorial.getTutorialText().size(); i++) {
			String line = tutorial.getTutorialText().get(i);
			drawCenteredString(fontRenderer, line, (width / 2), height / 2 - fontRenderer.FONT_HEIGHT * (tutorial.getTutorialText().size() - i), 0xFFFFFF);
		}

	}

	@Override
	public void initGui() {
		buttonList.clear();
		buttonList.add(next = new GuiButton(NEXT, (width / 2), height / 2 * 3 / 2, 50, 20, ">"));
		buttonList.add(prev = new GuiButton(PREV, (width / 2) - 50, height / 2 * 3 / 2, 50, 20, "<"));
		buttonList.add(ok = new GuiButton(OK, (width / 2) - 50, height / 2 * 3 / 2+20, 100, 20, "OK"));

		super.initGui();
		updateButtons();
	}

	@Override
	protected void actionPerformed(GuiButton button) throws IOException {
		switch (button.id) {
		case NEXT:
			System.out.println(tutorial);
			if (tutorial.hasNext()) {
				this.tutorial = tutorial.getNext();
			}
			break;
		case PREV:
			if (tutorial.hasPrev()) {
				this.tutorial = tutorial.getPrev();
			}
			break;
		case OK:

			mc.displayGuiScreen(null);
			// PacketDispatcher.sendToServer(new OrgMemberSelect(current));
			// mc.player.getCapability(ModCapabilities.ORGANIZATION_XIII, null).setMember(current);

			break;
		}
		super.actionPerformed(button);
		updateButtons();
	}

	public void updateButtons() {
		ok.visible = !tutorial.hasNext();
	}
}
