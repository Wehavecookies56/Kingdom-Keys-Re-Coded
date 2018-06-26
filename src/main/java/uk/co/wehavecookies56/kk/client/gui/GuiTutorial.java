package uk.co.wehavecookies56.kk.client.gui;

import static uk.co.wehavecookies56.kk.common.util.Utils.OrgMember.ROXAS;
import static uk.co.wehavecookies56.kk.common.util.Utils.OrgMember.XEMNAS;

import java.io.IOException;
import java.util.ArrayList;

import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.util.ResourceLocation;
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

	int maxLength1 = 0, maxLength2 = 0;;

	@Override
	public void drawScreen(int mouseX, int mouseY, float partialTicks) {
		drawDefaultBackground();
		super.drawScreen(mouseX, mouseY, partialTicks);
		drawLines();
		drawImages();
	}

	private void drawLines() {
		int num = tutorial.getTutorialText().length;
		for (int i = 0; i < num; i++) {
			
			for (int j = 0; j < tutorial.getTutorialText()[0].length; j++) {
				String line = tutorial.getTutorialText()[i][j];
				if (line != null) {
					// System.out.println(line);
					
					if (i == 0) {
						maxLength1 = Math.max(maxLength1, fontRenderer.getStringWidth(line));
						drawCenteredString(fontRenderer, line, (width / 2) + maxLength1 / 4, height / 3 - fontRenderer.FONT_HEIGHT * (num - j) - 10, 0xFFFFFF);
					} else if(i == 1) {
						maxLength2 = Math.max(maxLength2, fontRenderer.getStringWidth(line));
						drawCenteredString(fontRenderer, line, (width / 2) + maxLength2 / 4, height / 3 * 2 - fontRenderer.FONT_HEIGHT * (num - j) - 10, 0xFFFFFF);
					}
				}
			}
		}
	}

	private void drawImages() {
		ArrayList<ResourceLocation> images = tutorial.getTutorialImages();
		for (int i = 0; i < images.size(); i++) {
			GlStateManager.pushMatrix();
			{
				mc.renderEngine.bindTexture(images.get(i));
				GlStateManager.enableAlpha();
				GlStateManager.enableBlend();
				GlStateManager.scale(0.4, 0.4, 0.4);
				// drawTexturedModalRect((width / 2) - maxLength /*(256 / 2) - 5*/, (height / 2)
				// - (256 / 2) + 400 * i, 0, 0, 256, 256);
				if (i == 0)
					drawTexturedModalRect((width / 2) - maxLength1 / 2, height / 3 * 2 * i + 50, 0, 0, 256, 256);
				else
					drawTexturedModalRect((width / 2) - maxLength2 / 2, height / 3 * 2 * i + 150, 0, 0, 256, 256);
			}
			GlStateManager.popMatrix();
		}

	}

	@Override
	public void initGui() {
		buttonList.clear();
		buttonList.add(next = new GuiButton(NEXT, (width / 2), height - 60, 50, 20, ">"));
		buttonList.add(prev = new GuiButton(PREV, (width / 2) - 50, height - 60, 50, 20, "<"));
		buttonList.add(ok = new GuiButton(OK, (width / 2) - 50, height - 40, 100, 20, "OK"));

		super.initGui();
		updateButtons();
	}

	@Override
	protected void actionPerformed(GuiButton button) throws IOException {
		switch (button.id) {
		case NEXT:
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
			// mc.player.getCapability(ModCapabilities.ORGANIZATION_XIII,
			// null).setMember(current);

			break;
		}
		super.actionPerformed(button);
		updateButtons();
	}

	public void updateButtons() {
		ok.enabled = !tutorial.hasNext();
		next.enabled = tutorial.hasNext();
		prev.enabled = tutorial.hasPrev();
	}
}
