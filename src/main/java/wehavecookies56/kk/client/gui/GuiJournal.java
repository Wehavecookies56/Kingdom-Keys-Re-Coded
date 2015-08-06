package wehavecookies56.kk.client.gui;

import java.io.IOException;
import java.util.List;

import org.lwjgl.opengl.GL11;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.util.ResourceLocation;
import wehavecookies56.kk.lib.Reference;

public class GuiJournal extends GuiScreen {

	public static ResourceLocation texture = new ResourceLocation(Reference.MODID, "textures/gui/journal.png");

	final int COLLAPSE_COMMANDMENU = 0, COLLAPSE_KEYBLADES = 1, COLLAPSE_BUGBLOX = 2, COLLAPSE_SYNTHESIS = 3, COLLAPSE_ARMOUR = 4, COLLAPSE_MAGIC = 5, COLLAPSE_DRIVEFORMS = 6, COLLAPSE_MISC = 7;

	GuiButtonCollapse collapse_commandmenu, collapse_keyblades, collapse_bugblox, collapse_synthesis, collapse_armour, collapse_magic, collapse_driveforms, collapse_misc;

  	ScaledResolution res = new ScaledResolution(Minecraft.getMinecraft(), Minecraft.getMinecraft().displayWidth, Minecraft.getMinecraft().displayHeight);

  	int centreX = res.getScaledWidth() / 2;
	int centreY = res.getScaledHeight() / 2;

	int xPos_coll_commandMenu = centreX - 100 / 2;
	int yPos_coll_commandMenu = centreY - 12 / 2;

	int xPos_coll_keyblades = xPos_coll_commandMenu;
	int yPos_coll_keyblades = yPos_coll_commandMenu + 15;

	int xPos_coll_bugblox = xPos_coll_keyblades;
	int yPos_coll_bugblox = yPos_coll_keyblades + 15;

	int xPos_coll_synthesis = xPos_coll_bugblox;
	int yPos_coll_synthesis = yPos_coll_bugblox + 15;

	int xPos_coll_armour = xPos_coll_synthesis;
	int yPos_coll_armour = yPos_coll_synthesis + 15;

	int xPos_coll_magic = xPos_coll_armour;
	int yPos_coll_magic = yPos_coll_armour + 15;

	int xPos_coll_driveforms = xPos_coll_magic;
	int yPos_coll_driveforms = yPos_coll_magic + 15;

	int xPos_coll_misc = xPos_coll_driveforms;
	int yPos_coll_misc = yPos_coll_driveforms + 15;

	public GuiJournal() {
		collapse_commandmenu = new GuiButtonCollapse(COLLAPSE_COMMANDMENU, 0, 0);
		collapse_keyblades = new GuiButtonCollapse(COLLAPSE_KEYBLADES, 0, 0);
		collapse_bugblox = new GuiButtonCollapse(COLLAPSE_BUGBLOX, 0, 0);
		collapse_synthesis = new GuiButtonCollapse(COLLAPSE_SYNTHESIS, 0, 0);
		collapse_armour = new GuiButtonCollapse(COLLAPSE_ARMOUR, 0, 0);
		collapse_magic = new GuiButtonCollapse(COLLAPSE_MAGIC, 0, 0);
		collapse_driveforms = new GuiButtonCollapse(COLLAPSE_DRIVEFORMS, 0, 0);
		collapse_misc = new GuiButtonCollapse(COLLAPSE_MISC, 0, 0);
	}

	@Override
	public void drawScreen(int mouseX, int mouseY, float partialTicks) {

		drawDefaultBackground();

		GL11.glEnable(GL11.GL_SCISSOR_TEST);

		drawTitle(collapse_commandmenu, xPos_coll_commandMenu, yPos_coll_commandMenu, 100, 12, "Command Menu", 1F);
		drawTitle(collapse_keyblades, xPos_coll_keyblades, yPos_coll_keyblades, 100, 12, "Keyblades", 1F);
		drawTitle(collapse_bugblox, xPos_coll_bugblox, yPos_coll_bugblox, 100, 12, "Bug Blox", 1F);
		drawTitle(collapse_synthesis, xPos_coll_synthesis, yPos_coll_synthesis, 100, 12, "Synthesis", 1F);
		drawTitle(collapse_armour, xPos_coll_armour, yPos_coll_armour, 100, 12, "Armour", 1F);
		drawTitle(collapse_magic, xPos_coll_magic, yPos_coll_magic, 100, 12, "Magic", 1F);
		drawTitle(collapse_driveforms, xPos_coll_driveforms, yPos_coll_driveforms, 100, 12, "Drive Forms", 1F);
		drawTitle(collapse_misc, xPos_coll_misc, yPos_coll_misc, 100, 12, "Miscellaneous", 1F);

		//drawTexturedModalRect(centreX, centreY, U_Plus_Minus, V_Plus, W_Plus_Minus, H_Plus);

		GL11.glScissor((xPos_coll_commandMenu * 2), 50, 102 * 2, height * 2);
		GL11.glDisable(GL11.GL_SCISSOR_TEST);

		GL11.glPushMatrix();{
			drawCenteredString(fontRendererObj, "Journal", centreX, centreY - 20, 0xFFFFFF);
		}GL11.glPopMatrix();

		super.drawScreen(mouseX, mouseY, partialTicks);

	}

	public void drawTitle(GuiButtonCollapse button, int posX, int posY, int width, int height, String text, float scale){
		mc.renderEngine.bindTexture(texture);
		GL11.glPushMatrix();{
			GL11.glPushMatrix();{
				GL11.glTranslatef(posX*scale, posY*scale, 0);
				GL11.glScalef(scale, height + 2, 0);
				drawTexturedModalRect(0, 0, 0, 0, 1, 1);
			}GL11.glPopMatrix();

			GL11.glPushMatrix();{
				GL11.glTranslatef((posX + 1)*scale, (posY + 1)*scale, 0);
				GL11.glScalef(width, height, 0);
				drawTexturedModalRect(0, 0, 1, 1, 1, 1);
			}GL11.glPopMatrix();

			GL11.glPushMatrix();{
				GL11.glTranslatef((posX + 1)*scale, posY*scale, 0);
				GL11.glScalef(width, scale, 0);
				drawTexturedModalRect(0, 0, 1, 0, 1, 1);
			}GL11.glPopMatrix();

			GL11.glPushMatrix();{
				GL11.glTranslatef((posX + 1)*scale, height + scale + posY, 0);
				GL11.glScalef(width, scale, 0);
				drawTexturedModalRect(0, 0, 1, 7, 1, 1);
			}GL11.glPopMatrix();

			GL11.glPushMatrix();{
				GL11.glTranslatef(width + scale + posX, posY*scale, 0);
				GL11.glScalef(scale, height + 2, 0);
				drawTexturedModalRect(0, 0, 2, 0, 1, 1);
			}GL11.glPopMatrix();
			button.xPosition = posX + width - 10;
			button.yPosition = posY + height /2 - 3;
			drawCenteredString(fontRendererObj, text, posX + width / 2, posY + height / 2 - 3, 0xFFFFFF);

		}GL11.glPopMatrix();
	}

	@Override
	public void initGui() {
        super.initGui();
		buttonList.add(collapse_commandmenu);
		buttonList.add(collapse_keyblades);
		buttonList.add(collapse_bugblox);
		buttonList.add(collapse_synthesis);
		buttonList.add(collapse_armour);
		buttonList.add(collapse_magic);
		buttonList.add(collapse_driveforms);
		buttonList.add(collapse_misc);

		collapse_commandmenu.collapsed = false;
		collapse_keyblades.collapsed = false;
		collapse_bugblox.collapsed = false;
		collapse_synthesis.collapsed = false;
		collapse_armour.collapsed = false;
		collapse_magic.collapsed = false;
		collapse_driveforms.collapsed = false;
		collapse_misc.collapsed = false;
	}

	@Override
	protected void actionPerformed(GuiButton button) throws IOException {
		switch(button.id){
		case COLLAPSE_COMMANDMENU:
			if(!collapse_commandmenu.collapsed){
				collapse_commandmenu.collapsed = true;
				yPos_coll_keyblades += 80;
			}
			else if (collapse_commandmenu.collapsed){
				collapse_commandmenu.collapsed = false;
				yPos_coll_keyblades -= 80;
			}
			break;

		case COLLAPSE_KEYBLADES:
			if(!collapse_keyblades.collapsed){
				collapse_keyblades.collapsed = true;
			}
			else if (collapse_keyblades.collapsed)
				collapse_keyblades.collapsed = false;
			break;

		case COLLAPSE_BUGBLOX:
			if(!collapse_bugblox.collapsed){
				collapse_bugblox.collapsed = true;
			}
			else if (collapse_bugblox.collapsed)
				collapse_bugblox.collapsed = false;
			break;

		case COLLAPSE_SYNTHESIS:
			if(!collapse_synthesis.collapsed){
				collapse_synthesis.collapsed = true;
			}
			else if (collapse_synthesis.collapsed)
				collapse_synthesis.collapsed = false;
			break;

		case COLLAPSE_ARMOUR:
			if(!collapse_armour.collapsed){
				collapse_armour.collapsed = true;
			}
			else if (collapse_armour.collapsed)
				collapse_armour.collapsed = false;
			break;

		case COLLAPSE_MAGIC:
			if(!collapse_magic.collapsed){
				collapse_magic.collapsed = true;
			}
			else if (collapse_magic.collapsed)
				collapse_magic.collapsed = false;
			break;

		case COLLAPSE_DRIVEFORMS:
			if(!collapse_driveforms.collapsed){
				collapse_driveforms.collapsed = true;
			}
			else if (collapse_driveforms.collapsed)
				collapse_driveforms.collapsed = false;
			break;

		case COLLAPSE_MISC:
			if(!collapse_misc.collapsed){
				collapse_misc.collapsed = true;
			}
			else if (collapse_misc.collapsed)
				collapse_misc.collapsed = false;
			break;
		}

	}

	@Override
	public void updateScreen() {
		super.updateScreen();
	}

	public static class GuiButtonCollapse extends GuiButton {
		public boolean collapsed = false;
		public GuiButtonCollapse(int id, int posX, int posY) {
			super(id, posX, posY, 5, 5, "");
		}

		@Override
		public void drawButton(Minecraft mc, int mouseX, int mouseY) {
			if(visible){
				int u = 3;
				int v = 0;
				int w = 5;
				int h = 5;

				mc.renderEngine.bindTexture(texture);
				if(collapsed){
					u = 3;
					v = 5;
					w = 5;
					h = 5;
				}else{
					u = 3;
					v = 0;
					w = 5;
					h = 5;
				}
				GL11.glPushMatrix();
				GL11.glTranslatef(this.xPosition, this.yPosition, 0);
				GL11.glScalef(1.1f, 1.1f, 0);
				drawTexturedModalRect(0, 0, u, v, w, h);
				GL11.glPopMatrix();
			}
		}
	}

}
