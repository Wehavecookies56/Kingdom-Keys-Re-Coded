package uk.co.wehavecookies56.kk.client.gui;

import java.io.IOException;

import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.GL11;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.TextFormatting;
import uk.co.wehavecookies56.kk.client.gui.pages.PageCommandMenuAbout;
import uk.co.wehavecookies56.kk.client.gui.pages.PageCommandMenuAttack;
import uk.co.wehavecookies56.kk.client.gui.pages.PageCommandMenuDrive;
import uk.co.wehavecookies56.kk.client.gui.pages.PageCommandMenuItems;
import uk.co.wehavecookies56.kk.client.gui.pages.PageCommandMenuMagic;
import uk.co.wehavecookies56.kk.common.lib.Reference;

public class GuiJournal extends GuiScreen {

	public static ResourceLocation texture = new ResourceLocation(Reference.MODID, "textures/gui/journal.png");

	final int COLLAPSE_COMMANDMENU = 0, COLLAPSE_KEYBLADES = 1, COLLAPSE_BUGBLOX = 2, COLLAPSE_SYNTHESIS = 3, COLLAPSE_ARMOUR = 4, COLLAPSE_MAGIC = 5, COLLAPSE_DRIVEFORMS = 6, COLLAPSE_MISC = 7;

	final int TOPIC_COMMANDMENU_ABOUT = 200, TOPIC_COMMANDMENU_ATTACK = 201, TOPIC_COMMANDMENU_MAGIC = 202, TOPIC_COMMANDMENU_ITEMS = 203, TOPIC_COMMANDMENU_DRIVE = 204;
	final int TOPIC_KEYBLADES_ABOUT = 205, TOPIC_KEYBLADES_LIST = 206, TOPIC_KEYBLADES_SUMMONING = 207, TOPIC_KEYBLADES_CREATION = 208;
	final int TOPIC_BUGBLOX_ABOUT = 209, TOPIC_BUGBLOX_STANDARDBLOX = 210, TOPIC_BUGBLOX_SPECIALBLOX = 211;
	final int TOPIC_SYNTHESIS_ABOUT = 212, TOPIC_SYNTHESIS_MATERIALS = 213, TOPIC_SYNTHESIS_RECIPES = 214;
	final int TOPIC_ARMOUR_KEYBLADE = 216, TOPIC_ARMOUR_ORGANIZATION = 217;
	final int TOPIC_MAGIC_ABOUT = 218, TOPIC_MAGIC_MP = 219, TOPIC_MAGIC_MAGICS = 220;
	final int TOPIC_DRIVEFORMS_ABOUT = 221, TOPIC_DRIVEFORMS_DP = 222, TOPIC_DRIVEFORMS_FORMS = 223;
	final int TOPIC_MISC_HEARTS = 224, TOPIC_MISC_MUNNY = 225, TOPIC_MISC_MENU = 226, TOPIC_MISC_CRAFTINGMATERIALS = 227, TOPIC_MISC_ORGANIZATIONWEAPONS = 228, TOPIC_MISC_MUSICDISCS = 229, TOPIC_MISC_COMMANDS = 230;

	final int SCROLL_COLLAPSE = 100, SCROLL_PAGE = 101;

	GuiButtonCollapse collapse_commandmenu, collapse_keyblades, collapse_bugblox, collapse_synthesis, collapse_armour, collapse_magic, collapse_driveforms, collapse_misc;

	GuiButtonScroll scroll_collapse, scroll_page;

	GuiButtonLink topic_commandmenu_about, topic_commandmenu_attack, topic_commandmenu_magic, topic_commandmenu_items, topic_commandmenu_drive, topic_keyblades_about, topic_keyblades_list, topic_keyblades_summoning, topic_keyblades_creation, topic_bugblox_about, topic_bugblox_standardblox, topic_bugblox_specialblox, topic_synthesis_about, topic_synthesis_materials, topic_synthesis_recipes, topic_armour_keyblade, topic_armour_organization, topic_magic_about, topic_magic_mp, topic_magic_magics, topic_driveforms_about, topic_driveforms_dp, topic_driveforms_forms, topic_misc_hearts, topic_misc_munny, topic_misc_menu, topic_misc_craftingmaterials, topic_misc_organizationweapons, topic_misc_musicdiscs, topic_misc_commands;

	static ScaledResolution res;

	static float scrollPos = 0;
	static float scrollPos_page = 0;
	static float offset;
	static float offset_page;

	static int centreX;
	static int centreY;

	static int xPos_coll_commandMenu;
	static int yPos_coll_commandMenu;

	int xPos_coll_keyblades;
	int yPos_coll_keyblades;

	int xPos_coll_bugblox;
	int yPos_coll_bugblox;

	int xPos_coll_synthesis;
	int yPos_coll_synthesis;

	int xPos_coll_armour;
	int yPos_coll_armour;

	int xPos_coll_magic;
	int yPos_coll_magic;

	int xPos_coll_driveforms;
	int yPos_coll_driveforms;

	int xPos_coll_misc;
	int yPos_coll_misc;

	float collapseListLength;

	int commandmenu_topics;
	int commandmenu_height;

	int keyblades_topics;
	int keyblades_height;

	int bugblox_topics;
	int bugblox_height;

	int synthesis_topics;
	int synthesis_height;

	int armour_topics;
	int armour_height;

	int magic_topics;
	int magic_height;

	int driveforms_topics;
	int driveforms_height;

	int misc_topics;
	int misc_height;

	String currentPage;

	PageCommandMenuAbout page_commandmenu_about;
	PageCommandMenuAttack page_commandmenu_attack;
	PageCommandMenuMagic page_commandmenu_magic;
	PageCommandMenuItems page_commandmenu_items;
	PageCommandMenuDrive page_commandmenu_drive;

	public GuiJournal () {
		page_commandmenu_about = new PageCommandMenuAbout(0, 0);
		page_commandmenu_attack = new PageCommandMenuAttack(0, 0);
		page_commandmenu_magic = new PageCommandMenuMagic(0, 0);
		page_commandmenu_items = new PageCommandMenuItems(0, 0);
		page_commandmenu_drive = new PageCommandMenuDrive(0, 0);

		collapse_commandmenu = new GuiButtonCollapse(COLLAPSE_COMMANDMENU, 0, 0);
		collapse_keyblades = new GuiButtonCollapse(COLLAPSE_KEYBLADES, 0, 0);
		collapse_bugblox = new GuiButtonCollapse(COLLAPSE_BUGBLOX, 0, 0);
		collapse_synthesis = new GuiButtonCollapse(COLLAPSE_SYNTHESIS, 0, 0);
		collapse_armour = new GuiButtonCollapse(COLLAPSE_ARMOUR, 0, 0);
		collapse_magic = new GuiButtonCollapse(COLLAPSE_MAGIC, 0, 0);
		collapse_driveforms = new GuiButtonCollapse(COLLAPSE_DRIVEFORMS, 0, 0);
		collapse_misc = new GuiButtonCollapse(COLLAPSE_MISC, 0, 0);

		scroll_collapse = new GuiButtonScroll(SCROLL_COLLAPSE, 0, 0);
		scroll_page = new GuiButtonScroll(SCROLL_PAGE, 0, 0);

		// COMMAND MENU
		topic_commandmenu_about = new GuiButtonLink(TOPIC_COMMANDMENU_ABOUT, 0, 0, 0, 0, "About", 0x0645AD);
		topic_commandmenu_attack = new GuiButtonLink(TOPIC_COMMANDMENU_ATTACK, 0, 0, 0, 0, "Attack", 0x0645AD);
		topic_commandmenu_magic = new GuiButtonLink(TOPIC_COMMANDMENU_MAGIC, 0, 0, 0, 0, "Magic", 0x0645AD);
		topic_commandmenu_items = new GuiButtonLink(TOPIC_COMMANDMENU_ITEMS, 0, 0, 0, 0, "Items", 0x0645AD);
		topic_commandmenu_drive = new GuiButtonLink(TOPIC_COMMANDMENU_DRIVE, 0, 0, 0, 0, "Drive", 0x0645AD);

		// KEYBLADES
		topic_keyblades_about = new GuiButtonLink(TOPIC_KEYBLADES_ABOUT, 0, 0, 0, 0, "About", 0x0645AD);
		topic_keyblades_list = new GuiButtonLink(TOPIC_KEYBLADES_LIST, 0, 0, 0, 0, "List", 0x0645AD);
		topic_keyblades_summoning = new GuiButtonLink(TOPIC_KEYBLADES_SUMMONING, 0, 0, 0, 0, "Summoning", 0x0645AD);
		topic_keyblades_creation = new GuiButtonLink(TOPIC_KEYBLADES_CREATION, 0, 0, 0, 0, "Creation", 0x0645AD);

		// BUG BLOX
		topic_bugblox_about = new GuiButtonLink(TOPIC_BUGBLOX_ABOUT, 0, 0, 0, 0, "About", 0x0645AD);
		topic_bugblox_standardblox = new GuiButtonLink(TOPIC_BUGBLOX_STANDARDBLOX, 0, 0, 0, 0, "Standard Blox", 0x0645AD);
		topic_bugblox_specialblox = new GuiButtonLink(TOPIC_BUGBLOX_SPECIALBLOX, 0, 0, 0, 0, "Special Blox", 0x0645AD);

		// SYNTHESIS
		topic_synthesis_about = new GuiButtonLink(TOPIC_SYNTHESIS_ABOUT, 0, 0, 0, 0, "About", 0x0645AD);
		topic_synthesis_materials = new GuiButtonLink(TOPIC_SYNTHESIS_MATERIALS, 0, 0, 0, 0, "Materials", 0x0645AD);
		topic_synthesis_recipes = new GuiButtonLink(TOPIC_SYNTHESIS_RECIPES, 0, 0, 0, 0, "Recipes", 0x0645AD);

		// ARMOUR
		topic_armour_keyblade = new GuiButtonLink(TOPIC_ARMOUR_KEYBLADE, 0, 0, 0, 0, "Keyblade", 0x0645AD);
		topic_armour_organization = new GuiButtonLink(TOPIC_ARMOUR_ORGANIZATION, 0, 0, 0, 0, "Organization", 0x0645AD);

		// MAGIC
		topic_magic_about = new GuiButtonLink(TOPIC_MAGIC_ABOUT, 0, 0, 0, 0, "About", 0x0645AD);
		topic_magic_mp = new GuiButtonLink(TOPIC_MAGIC_MP, 0, 0, 0, 0, "MP", 0x0645AD);
		topic_magic_magics = new GuiButtonLink(TOPIC_MAGIC_MAGICS, 0, 0, 0, 0, "Magics", 0x0645AD);

		// DRIVE FORMS
		topic_driveforms_about = new GuiButtonLink(TOPIC_DRIVEFORMS_ABOUT, 0, 0, 0, 0, "About", 0x0645AD);
		topic_driveforms_dp = new GuiButtonLink(TOPIC_DRIVEFORMS_DP, 0, 0, 0, 0, "DP", 0x0645AD);
		topic_driveforms_forms = new GuiButtonLink(TOPIC_DRIVEFORMS_FORMS, 0, 0, 0, 0, "Forms", 0x0645AD);

		// MISC
		topic_misc_hearts = new GuiButtonLink(TOPIC_MISC_HEARTS, 0, 0, 0, 0, "Hearts", 0x0645AD);
		topic_misc_munny = new GuiButtonLink(TOPIC_MISC_MUNNY, 0, 0, 0, 0, "Munny", 0x0645AD);
		topic_misc_menu = new GuiButtonLink(TOPIC_MISC_MENU, 0, 0, 0, 0, "Menu", 0x0645AD);
		topic_misc_craftingmaterials = new GuiButtonLink(TOPIC_MISC_CRAFTINGMATERIALS, 0, 0, 0, 0, "Crafting Materials", 0x0645AD);
		topic_misc_organizationweapons = new GuiButtonLink(TOPIC_MISC_ORGANIZATIONWEAPONS, 0, 0, 0, 0, "Organization Weapons", 0x0645AD);
		topic_misc_musicdiscs = new GuiButtonLink(TOPIC_MISC_MUSICDISCS, 0, 0, 0, 0, "Music Discs", 0x0645AD);
		topic_misc_commands = new GuiButtonLink(TOPIC_MISC_COMMANDS, 0, 0, 0, 0, "Commands", 0x0645AD);

	}

	@Override
	public void drawScreen (int mouseX, int mouseY, float partialTicks) {

		drawDefaultBackground();

		if (currentPage != null) {
			if (currentPage.equals(page_commandmenu_about.getName())) page_commandmenu_about.drawScreen(mouseX, mouseY, partialTicks);
			if (currentPage.equals(page_commandmenu_attack.getName())) page_commandmenu_attack.drawScreen(mouseX, mouseY, partialTicks);
			if (currentPage.equals(page_commandmenu_magic.getName())) page_commandmenu_magic.drawScreen(mouseX, mouseY, partialTicks);
			if (currentPage.equals(page_commandmenu_items.getName())) page_commandmenu_items.drawScreen(mouseX, mouseY, partialTicks);
			if (currentPage.equals(page_commandmenu_drive.getName())) page_commandmenu_drive.drawScreen(mouseX, mouseY, partialTicks);
		}

		int distToBottomFromMisc = (this.height / 4) - 7;
		int listHeight = (((this.height / 4) + 7) + (this.height / 2)) - yPos_coll_commandMenu + 2;

		drawDarkBG(texture, xPos_coll_commandMenu - 1, yPos_coll_commandMenu - 1, 102, (this.height / 2) + 8, 1F);
		drawDarkBG(texture, xPos_coll_commandMenu + 103, yPos_coll_commandMenu - 1, 8, (this.height / 2) + 8, 1F);
		if (currentPage != null) {
			if (currentPage.equals(page_commandmenu_about.getName()))
				topic_commandmenu_about.colour = 0xFFFFFF;
			else
				topic_commandmenu_about.colour = 0x0645AD;
			if (currentPage.equals(page_commandmenu_attack.getName()))
				topic_commandmenu_attack.colour = 0xFFFFFF;
			else
				topic_commandmenu_attack.colour = 0x0645AD;
			if (currentPage.equals(page_commandmenu_magic.getName()))
				topic_commandmenu_magic.colour = 0xFFFFFF;
			else
				topic_commandmenu_magic.colour = 0x0645AD;
			if (currentPage.equals(page_commandmenu_items.getName()))
				topic_commandmenu_items.colour = 0xFFFFFF;
			else
				topic_commandmenu_items.colour = 0x0645AD;
			if (currentPage.equals(page_commandmenu_drive.getName()))
				topic_commandmenu_drive.colour = 0xFFFFFF;
			else
				topic_commandmenu_drive.colour = 0x0645AD;
		} else {
			topic_commandmenu_about.colour = 0x0645AD;
			topic_commandmenu_attack.colour = 0x0645AD;
			topic_commandmenu_magic.colour = 0x0645AD;
			topic_commandmenu_items.colour = 0x0645AD;
			topic_commandmenu_drive.colour = 0x0645AD;
		}

		GL11.glScissor(xPos_coll_commandMenu, (distToBottomFromMisc) * 2 - 2, this.width, listHeight * 2 - 1);

		GL11.glEnable(GL11.GL_SCISSOR_TEST);

		if (collapse_commandmenu.collapsed) {
			// drawGradientRect(xPos_coll_commandMenu + (xPos_coll_commandMenu /
			// 4), (int) (yPos_coll_commandMenu + offset), 140, 200,
			// -1072689136, -804253680);
		}

		drawTitle(collapse_commandmenu, xPos_coll_commandMenu, yPos_coll_commandMenu + (int) offset, 100, 12, "Command Menu", 1F);

		// Topics

		if (collapse_commandmenu.collapsed) {
			topic_commandmenu_about.visible = true;
			topic_commandmenu_attack.visible = true;
			topic_commandmenu_magic.visible = true;
			topic_commandmenu_items.visible = true;
			topic_commandmenu_drive.visible = true;

			topic_commandmenu_about.xPosition = xPos_coll_commandMenu + 10;
			topic_commandmenu_attack.xPosition = xPos_coll_commandMenu + 10;
			topic_commandmenu_magic.xPosition = xPos_coll_commandMenu + 10;
			topic_commandmenu_items.xPosition = xPos_coll_commandMenu + 10;
			topic_commandmenu_drive.xPosition = xPos_coll_commandMenu + 10;

			topic_commandmenu_about.yPosition = yPos_coll_commandMenu + 17 + (int) offset;
			topic_commandmenu_attack.yPosition = yPos_coll_commandMenu + 27 + (int) offset;
			topic_commandmenu_magic.yPosition = yPos_coll_commandMenu + 37 + (int) offset;
			topic_commandmenu_items.yPosition = yPos_coll_commandMenu + 47 + (int) offset;
			topic_commandmenu_drive.yPosition = yPos_coll_commandMenu + 57 + (int) offset;
		} else {
			topic_commandmenu_about.visible = false;
			topic_commandmenu_attack.visible = false;
			topic_commandmenu_magic.visible = false;
			topic_commandmenu_items.visible = false;
			topic_commandmenu_drive.visible = false;
		}

		drawTitle(collapse_keyblades, xPos_coll_keyblades, yPos_coll_keyblades + (int) offset, 100, 12, "Keyblades", 1F);

		// Topics

		if (collapse_keyblades.collapsed) {
			topic_keyblades_about.visible = true;
			topic_keyblades_list.visible = true;
			topic_keyblades_summoning.visible = true;
			topic_keyblades_creation.visible = true;

			topic_keyblades_about.xPosition = xPos_coll_keyblades + 10;
			topic_keyblades_list.xPosition = xPos_coll_keyblades + 10;
			topic_keyblades_summoning.xPosition = xPos_coll_keyblades + 10;
			topic_keyblades_creation.xPosition = xPos_coll_keyblades + 10;

			topic_keyblades_about.yPosition = yPos_coll_keyblades + 17 + (int) offset;
			topic_keyblades_list.yPosition = yPos_coll_keyblades + 27 + (int) offset;
			topic_keyblades_summoning.yPosition = yPos_coll_keyblades + 37 + (int) offset;
			topic_keyblades_creation.yPosition = yPos_coll_keyblades + 47 + (int) offset;

		} else {
			topic_keyblades_about.visible = false;
			topic_keyblades_list.visible = false;
			topic_keyblades_summoning.visible = false;
			topic_keyblades_creation.visible = false;
		}

		drawTitle(collapse_bugblox, xPos_coll_bugblox, yPos_coll_bugblox + (int) offset, 100, 12, "Bug Blox", 1F);
		// Topics

		if (collapse_bugblox.collapsed) {
			topic_bugblox_about.visible = true;
			topic_bugblox_standardblox.visible = true;
			topic_bugblox_specialblox.visible = true;

			topic_bugblox_about.xPosition = xPos_coll_bugblox + 10;
			topic_bugblox_standardblox.xPosition = xPos_coll_bugblox + 10;
			topic_bugblox_specialblox.xPosition = xPos_coll_bugblox + 10;

			topic_bugblox_about.yPosition = yPos_coll_bugblox + 17 + (int) offset;
			topic_bugblox_standardblox.yPosition = yPos_coll_bugblox + 27 + (int) offset;
			topic_bugblox_specialblox.yPosition = yPos_coll_bugblox + 37 + (int) offset;
		} else {
			topic_bugblox_about.visible = false;
			topic_bugblox_standardblox.visible = false;
			topic_bugblox_specialblox.visible = false;
		}

		drawTitle(collapse_synthesis, xPos_coll_synthesis, yPos_coll_synthesis + (int) offset, 100, 12, "Synthesis", 1F);

		// Topics

		if (collapse_synthesis.collapsed) {
			topic_synthesis_about.visible = true;
			topic_synthesis_materials.visible = true;
			topic_synthesis_recipes.visible = true;

			topic_synthesis_about.xPosition = xPos_coll_synthesis + 10;
			topic_synthesis_materials.xPosition = xPos_coll_synthesis + 10;
			topic_synthesis_recipes.xPosition = xPos_coll_synthesis + 10;

			topic_synthesis_about.yPosition = yPos_coll_synthesis + 17 + (int) offset;
			topic_synthesis_materials.yPosition = yPos_coll_synthesis + 27 + (int) offset;
			topic_synthesis_recipes.yPosition = yPos_coll_synthesis + 37 + (int) offset;
		} else {
			topic_synthesis_about.visible = false;
			topic_synthesis_materials.visible = false;
			topic_synthesis_recipes.visible = false;
		}

		drawTitle(collapse_armour, xPos_coll_armour, yPos_coll_armour + (int) offset, 100, 12, "Armour", 1F);

		// Topics

		if (collapse_armour.collapsed) {
			topic_armour_keyblade.visible = true;
			topic_armour_organization.visible = true;

			topic_armour_keyblade.xPosition = xPos_coll_armour + 10;
			topic_armour_organization.xPosition = xPos_coll_armour + 10;

			topic_armour_keyblade.yPosition = yPos_coll_armour + 17 + (int) offset;
			topic_armour_organization.yPosition = yPos_coll_armour + 27 + (int) offset;
		} else {
			topic_armour_keyblade.visible = false;
			topic_armour_organization.visible = false;
		}

		drawTitle(collapse_magic, xPos_coll_magic, yPos_coll_magic + (int) offset, 100, 12, "Magic", 1F);

		// Topics

		if (collapse_magic.collapsed) {
			topic_magic_about.visible = true;
			topic_magic_mp.visible = true;
			topic_magic_magics.visible = true;

			topic_magic_about.xPosition = xPos_coll_magic + 10;
			topic_magic_mp.xPosition = xPos_coll_magic + 10;
			topic_magic_magics.xPosition = xPos_coll_magic + 10;

			topic_magic_about.yPosition = yPos_coll_magic + 17 + (int) offset;
			topic_magic_mp.yPosition = yPos_coll_magic + 27 + (int) offset;
			topic_magic_magics.yPosition = yPos_coll_magic + 37 + (int) offset;
		} else {
			topic_magic_about.visible = false;
			topic_magic_mp.visible = false;
			topic_magic_magics.visible = false;
		}

		drawTitle(collapse_driveforms, xPos_coll_driveforms, yPos_coll_driveforms + (int) offset, 100, 12, "Drive Forms", 1F);

		// Topics

		if (collapse_driveforms.collapsed) {
			topic_driveforms_about.visible = true;
			topic_driveforms_dp.visible = true;
			topic_driveforms_forms.visible = true;

			topic_driveforms_about.xPosition = xPos_coll_driveforms + 10;
			topic_driveforms_dp.xPosition = xPos_coll_driveforms + 10;
			topic_driveforms_forms.xPosition = xPos_coll_driveforms + 10;

			topic_driveforms_about.yPosition = yPos_coll_driveforms + 17 + (int) offset;
			topic_driveforms_dp.yPosition = yPos_coll_driveforms + 27 + (int) offset;
			topic_driveforms_forms.yPosition = yPos_coll_driveforms + 37 + (int) offset;
		} else {
			topic_driveforms_about.visible = false;
			topic_driveforms_dp.visible = false;
			topic_driveforms_forms.visible = false;
		}

		drawTitle(collapse_misc, xPos_coll_misc, yPos_coll_misc + (int) offset, 100, 12, "Miscellaneous", 1F);

		// Topics

		if (collapse_misc.collapsed) {
			topic_misc_hearts.visible = true;
			topic_misc_munny.visible = true;
			topic_misc_menu.visible = true;
			topic_misc_craftingmaterials.visible = true;
			topic_misc_organizationweapons.visible = true;
			topic_misc_musicdiscs.visible = true;
			topic_misc_commands.visible = true;

			topic_misc_hearts.xPosition = xPos_coll_misc + 10;
			topic_misc_munny.xPosition = xPos_coll_misc + 10;
			topic_misc_menu.xPosition = xPos_coll_misc + 10;
			topic_misc_craftingmaterials.xPosition = xPos_coll_misc + 10;
			topic_misc_organizationweapons.xPosition = xPos_coll_misc + 10;
			topic_misc_musicdiscs.xPosition = xPos_coll_misc + 10;
			topic_misc_commands.xPosition = xPos_coll_misc + 10;

			topic_misc_hearts.yPosition = yPos_coll_misc + 17 + (int) offset;
			topic_misc_munny.yPosition = yPos_coll_misc + 27 + (int) offset;
			topic_misc_menu.yPosition = yPos_coll_misc + 37 + (int) offset;
			topic_misc_craftingmaterials.yPosition = yPos_coll_misc + 47 + (int) offset;
			topic_misc_organizationweapons.yPosition = yPos_coll_misc + 57 + (int) offset;
			topic_misc_musicdiscs.yPosition = yPos_coll_misc + 67 + (int) offset;
			topic_misc_commands.yPosition = yPos_coll_misc + 77 + (int) offset;
		} else {
			topic_misc_hearts.visible = false;
			topic_misc_munny.visible = false;
			topic_misc_menu.visible = false;
			topic_misc_craftingmaterials.visible = false;
			topic_misc_organizationweapons.visible = false;
			topic_misc_musicdiscs.visible = false;
			topic_misc_commands.visible = false;
		}

		GL11.glDisable(GL11.GL_SCISSOR_TEST);

		super.drawScreen(mouseX, mouseY, partialTicks);

	}

	public void drawDarkBG (ResourceLocation res, int posX, int posY, int width, int height, float scale) {
		mc.renderEngine.bindTexture(res);
		GL11.glPushMatrix();
		{
			GL11.glPushMatrix();
			{
				GL11.glTranslatef(posX * scale, posY * scale, 0);
				GL11.glScalef(scale, height + 2, 0);
				drawTexturedModalRect(0, 0, 0, 8, 1, 1);
			}
			GL11.glPopMatrix();

			GL11.glPushMatrix();
			{
				GL11.glTranslatef((posX + 1) * scale, (posY + 1) * scale, 0);
				GL11.glScalef(width, height, 0);
				drawTexturedModalRect(0, 0, 1, 9, 1, 1);
			}
			GL11.glPopMatrix();

			GL11.glPushMatrix();
			{
				GL11.glTranslatef((posX + 1) * scale, posY * scale, 0);
				GL11.glScalef(width, scale, 0);
				drawTexturedModalRect(0, 0, 1, 8, 1, 1);
			}
			GL11.glPopMatrix();

			GL11.glPushMatrix();
			{
				GL11.glTranslatef((posX + 1) * scale, height + scale + posY, 0);
				GL11.glScalef(width, scale, 0);
				drawTexturedModalRect(0, 0, 1, 15, 1, 1);
			}
			GL11.glPopMatrix();

			GL11.glPushMatrix();
			{
				GL11.glTranslatef(width + scale + posX, posY * scale, 0);
				GL11.glScalef(scale, height + 2, 0);
				drawTexturedModalRect(0, 0, 2, 8, 1, 1);
			}
			GL11.glPopMatrix();
		}
		GL11.glPopMatrix();
	}

	public void drawBG (ResourceLocation res, int posX, int posY, int width, int height, float scale) {
		mc.renderEngine.bindTexture(res);
		GL11.glPushMatrix();
		{
			GL11.glPushMatrix();
			{
				GL11.glTranslatef(posX * scale, posY * scale, 0);
				GL11.glScalef(scale, height + 2, 0);
				drawTexturedModalRect(0, 0, 0, 0, 1, 1);
			}
			GL11.glPopMatrix();

			GL11.glPushMatrix();
			{
				GL11.glTranslatef((posX + 1) * scale, (posY + 1) * scale, 0);
				GL11.glScalef(width, height, 0);
				drawTexturedModalRect(0, 0, 1, 1, 1, 1);
			}
			GL11.glPopMatrix();

			GL11.glPushMatrix();
			{
				GL11.glTranslatef((posX + 1) * scale, posY * scale, 0);
				GL11.glScalef(width, scale, 0);
				drawTexturedModalRect(0, 0, 1, 0, 1, 1);
			}
			GL11.glPopMatrix();

			GL11.glPushMatrix();
			{
				GL11.glTranslatef((posX + 1) * scale, height + scale + posY, 0);
				GL11.glScalef(width, scale, 0);
				drawTexturedModalRect(0, 0, 1, 7, 1, 1);
			}
			GL11.glPopMatrix();

			GL11.glPushMatrix();
			{
				GL11.glTranslatef(width + scale + posX, posY * scale, 0);
				GL11.glScalef(scale, height + 2, 0);
				drawTexturedModalRect(0, 0, 2, 0, 1, 1);
			}
			GL11.glPopMatrix();
		}
		GL11.glPopMatrix();
	}

	public void drawTitle (GuiButtonCollapse button, int posX, int posY, int width, int height, String text, float scale) {
		mc.renderEngine.bindTexture(texture);
		GL11.glPushMatrix();
		{
			GL11.glPushMatrix();
			{
				GL11.glTranslatef(posX * scale, posY * scale, 0);
				GL11.glScalef(scale, height + 2, 0);
				drawTexturedModalRect(0, 0, 0, 0, 1, 1);
			}
			GL11.glPopMatrix();

			GL11.glPushMatrix();
			{
				GL11.glTranslatef((posX + 1) * scale, (posY + 1) * scale, 0);
				GL11.glScalef(width, height, 0);
				drawTexturedModalRect(0, 0, 1, 1, 1, 1);
			}
			GL11.glPopMatrix();

			GL11.glPushMatrix();
			{
				GL11.glTranslatef((posX + 1) * scale, posY * scale, 0);
				GL11.glScalef(width, scale, 0);
				drawTexturedModalRect(0, 0, 1, 0, 1, 1);
			}
			GL11.glPopMatrix();

			GL11.glPushMatrix();
			{
				GL11.glTranslatef((posX + 1) * scale, height + scale + posY, 0);
				GL11.glScalef(width, scale, 0);
				drawTexturedModalRect(0, 0, 1, 7, 1, 1);
			}
			GL11.glPopMatrix();

			GL11.glPushMatrix();
			{
				GL11.glTranslatef(width + scale + posX, posY * scale, 0);
				GL11.glScalef(scale, height + 2, 0);
				drawTexturedModalRect(0, 0, 2, 0, 1, 1);
			}
			GL11.glPopMatrix();
			button.xPosition = posX + width - 10;
			button.yPosition = posY + height / 2 - 3;
			drawCenteredString(fontRendererObj, text, posX + width / 2, posY + height / 2 - 3, 0xFFFFFF);

		}
		GL11.glPopMatrix();
	}

	@Override
	public void initGui () {
		super.initGui();

		currentPage = null;

		commandmenu_topics = 5;
		commandmenu_height = (10 * commandmenu_topics) + 10;

		keyblades_topics = 4;
		keyblades_height = (10 * keyblades_topics) + 10;

		bugblox_topics = 3;
		bugblox_height = (10 * bugblox_topics) + 10;

		synthesis_topics = 3;
		synthesis_height = (10 * synthesis_topics) + 10;

		armour_topics = 2;
		armour_height = (10 * armour_topics) + 10;

		magic_topics = 3;
		magic_height = (10 * magic_topics) + 10;

		driveforms_topics = 3;
		driveforms_height = (10 * driveforms_topics) + 10;

		misc_topics = 7;
		misc_height = (10 * misc_topics) + 10;

		centreX = this.width / 2;
		centreY = this.height / 2;

		xPos_coll_commandMenu = centreX - (this.width - 100) / 2;
		yPos_coll_commandMenu = this.height / 4;

		xPos_coll_keyblades = xPos_coll_commandMenu;
		yPos_coll_keyblades = yPos_coll_commandMenu + 15;

		xPos_coll_bugblox = xPos_coll_keyblades;
		yPos_coll_bugblox = yPos_coll_keyblades + 15;

		xPos_coll_synthesis = xPos_coll_bugblox;
		yPos_coll_synthesis = yPos_coll_bugblox + 15;

		xPos_coll_armour = xPos_coll_synthesis;
		yPos_coll_armour = yPos_coll_synthesis + 15;

		xPos_coll_magic = xPos_coll_armour;
		yPos_coll_magic = yPos_coll_armour + 15;

		xPos_coll_driveforms = xPos_coll_magic;
		yPos_coll_driveforms = yPos_coll_magic + 15;

		xPos_coll_misc = xPos_coll_driveforms;
		yPos_coll_misc = yPos_coll_driveforms + 15;

		collapseListLength = yPos_coll_misc - yPos_coll_commandMenu;

		// TITLES
		buttonList.add(collapse_commandmenu);
		buttonList.add(collapse_keyblades);
		buttonList.add(collapse_bugblox);
		buttonList.add(collapse_synthesis);
		buttonList.add(collapse_armour);
		buttonList.add(collapse_magic);
		buttonList.add(collapse_driveforms);
		buttonList.add(collapse_misc);

		// SCROLL BARS
		buttonList.add(scroll_collapse);
		buttonList.add(scroll_page);

		// TOPICS
		buttonList.add(topic_commandmenu_about);
		buttonList.add(topic_commandmenu_attack);
		buttonList.add(topic_commandmenu_magic);
		buttonList.add(topic_commandmenu_items);
		buttonList.add(topic_commandmenu_drive);

		buttonList.add(topic_keyblades_about);
		buttonList.add(topic_keyblades_list);
		buttonList.add(topic_keyblades_summoning);
		buttonList.add(topic_keyblades_creation);

		buttonList.add(topic_bugblox_about);
		buttonList.add(topic_bugblox_standardblox);
		buttonList.add(topic_bugblox_specialblox);

		buttonList.add(topic_synthesis_about);
		buttonList.add(topic_synthesis_materials);
		buttonList.add(topic_synthesis_recipes);

		buttonList.add(topic_armour_keyblade);
		buttonList.add(topic_armour_organization);

		buttonList.add(topic_magic_about);
		buttonList.add(topic_magic_mp);
		buttonList.add(topic_magic_magics);

		buttonList.add(topic_driveforms_about);
		buttonList.add(topic_driveforms_dp);
		buttonList.add(topic_driveforms_forms);

		buttonList.add(topic_misc_hearts);
		buttonList.add(topic_misc_munny);
		buttonList.add(topic_misc_menu);
		buttonList.add(topic_misc_craftingmaterials);
		buttonList.add(topic_misc_organizationweapons);
		buttonList.add(topic_misc_musicdiscs);
		buttonList.add(topic_misc_commands);

		scroll_collapse.width = (int) (7 * 1.5f);
		scroll_collapse.height = (int) (7 * 1.5f);
		scroll_collapse.xPosition = xPos_coll_commandMenu + 102;
		scroll_collapse.yPosition = yPos_coll_commandMenu;

		scroll_page.width = (int) (7 * 1.5f);
		scroll_page.height = (int) (7 * 1.5f);

		collapse_commandmenu.collapsed = false;
		collapse_keyblades.collapsed = false;
		collapse_bugblox.collapsed = false;
		collapse_synthesis.collapsed = false;
		collapse_armour.collapsed = false;
		collapse_magic.collapsed = false;
		collapse_driveforms.collapsed = false;
		collapse_misc.collapsed = false;

		page_commandmenu_about.setxPos(xPos_coll_commandMenu + 120);
		page_commandmenu_about.setyPos(this.height / 8);

		page_commandmenu_attack.setxPos(xPos_coll_commandMenu + 120);
		page_commandmenu_attack.setyPos(this.height / 8);

		page_commandmenu_magic.setxPos(xPos_coll_commandMenu + 120);
		page_commandmenu_magic.setyPos(this.height / 8);

		page_commandmenu_items.setxPos(xPos_coll_commandMenu + 120);
		page_commandmenu_items.setyPos(this.height / 8);

		page_commandmenu_drive.setxPos(xPos_coll_commandMenu + 120);
		page_commandmenu_drive.setyPos(this.height / 8);

	}

	@Override
	protected void mouseClickMove (int x, int y, int clickedMouseButton, long timeSinceLastClick) {
		int scrollPosMax = 100;
		if (collapse_commandmenu.collapsed) scrollPosMax += commandmenu_height;
		if (collapse_keyblades.collapsed) scrollPosMax += keyblades_height;
		if (collapse_bugblox.collapsed) scrollPosMax += bugblox_height;
		if (collapse_synthesis.collapsed) scrollPosMax += synthesis_height;
		if (collapse_armour.collapsed) scrollPosMax += armour_height;
		if (collapse_magic.collapsed) scrollPosMax += magic_height;
		if (collapse_driveforms.collapsed) scrollPosMax += driveforms_height;
		if (collapse_misc.collapsed) scrollPosMax += misc_height;
		int scrollPosMin = 0;
		int scrollGuiPosMin = this.height / 4;
		int scrollGuiPosMax = scrollGuiPosMin + (this.height / 2);
		int scrollGuiHeight = scrollGuiPosMax - scrollGuiPosMin;
		float step = scrollPosMax / (float) scrollGuiHeight;

		if (x <= xPos_coll_commandMenu + 100 + (scroll_collapse.width) && x >= xPos_coll_commandMenu) if (clickedMouseButton == 0) {
			offset = (-scrollPos);
			if (y <= scrollGuiPosMin) {
				scroll_collapse.yPosition = scrollGuiPosMin;
				scrollPos = 0;
			} else if (y >= scrollGuiPosMax) {
				scroll_collapse.yPosition = scrollGuiPosMax;
				scrollPos = scrollPosMax;
			} else {
				scroll_collapse.yPosition = y;
				scrollPos = (y - (float) scrollGuiPosMin) * step;
			}

		}
	}

	@Override
	public void handleMouseInput () throws IOException {
		// if(Mouse.getEventX() <= xPos_coll_commandMenu + 100 +
		// (scroll_collapse.width) && Mouse.getEventX() >=
		// xPos_coll_commandMenu){
		int scrollPosMax = 100;
		if (collapse_commandmenu.collapsed) scrollPosMax += commandmenu_height;
		if (collapse_keyblades.collapsed) scrollPosMax += keyblades_height;
		if (collapse_bugblox.collapsed) scrollPosMax += bugblox_height;
		if (collapse_synthesis.collapsed) scrollPosMax += synthesis_height;
		if (collapse_armour.collapsed) scrollPosMax += armour_height;
		if (collapse_magic.collapsed) scrollPosMax += magic_height;
		if (collapse_driveforms.collapsed) scrollPosMax += driveforms_height;
		if (collapse_misc.collapsed) scrollPosMax += misc_height;
		if (Mouse.getEventDWheel() > 1 && Mouse.getEventDWheel() != 0) if (Mouse.getEventX() <= (xPos_coll_commandMenu * 2) + 200 + (scroll_collapse.width * 2) && Mouse.getEventX() >= xPos_coll_commandMenu * 2) if (scrollPos > 0) {
			scrollPos -= 5;
			offset = (-scrollPos);
		} else if (scrollPos < 0) {
			scrollPos = 0;
			offset = (-scrollPos);
		}
		if (Mouse.getEventDWheel() < 1 && Mouse.getEventDWheel() != 0) if (Mouse.getEventX() <= (xPos_coll_commandMenu * 2) + 200 + (scroll_collapse.width * 2) && Mouse.getEventX() >= xPos_coll_commandMenu * 2) if (scrollPos < scrollPosMax) {
			scrollPos += 5;
			offset = (-scrollPos);
		} else if (scrollPos > scrollPosMax) {
			scrollPos = scrollPosMax;
			offset = (-scrollPos);
		}
		super.handleMouseInput();
	}

	@Override
	protected void actionPerformed (GuiButton button) throws IOException {
		switch (button.id) {
			case COLLAPSE_COMMANDMENU:
				if (!collapse_commandmenu.collapsed) {
					collapse_commandmenu.collapsed = true;
					yPos_coll_keyblades += commandmenu_height;
					yPos_coll_bugblox += commandmenu_height;
					yPos_coll_synthesis += commandmenu_height;
					yPos_coll_armour += commandmenu_height;
					yPos_coll_magic += commandmenu_height;
					yPos_coll_driveforms += commandmenu_height;
					yPos_coll_misc += commandmenu_height;
					collapseListLength += commandmenu_height;
				} else if (collapse_commandmenu.collapsed) {
					collapse_commandmenu.collapsed = false;
					yPos_coll_keyblades -= commandmenu_height;
					yPos_coll_bugblox -= commandmenu_height;
					yPos_coll_synthesis -= commandmenu_height;
					yPos_coll_armour -= commandmenu_height;
					yPos_coll_magic -= commandmenu_height;
					yPos_coll_driveforms -= commandmenu_height;
					yPos_coll_misc -= commandmenu_height;
					collapseListLength -= commandmenu_height;
				}
				break;

			case COLLAPSE_KEYBLADES:
				if (!collapse_keyblades.collapsed) {
					collapse_keyblades.collapsed = true;
					yPos_coll_bugblox += keyblades_height;
					yPos_coll_synthesis += keyblades_height;
					yPos_coll_armour += keyblades_height;
					yPos_coll_magic += keyblades_height;
					yPos_coll_driveforms += keyblades_height;
					yPos_coll_misc += keyblades_height;
					collapseListLength += keyblades_height;

				} else if (collapse_keyblades.collapsed) {
					collapse_keyblades.collapsed = false;
					yPos_coll_bugblox -= keyblades_height;
					yPos_coll_synthesis -= keyblades_height;
					yPos_coll_armour -= keyblades_height;
					yPos_coll_magic -= keyblades_height;
					yPos_coll_driveforms -= keyblades_height;
					yPos_coll_misc -= keyblades_height;
					collapseListLength -= keyblades_height;
				}
				break;

			case COLLAPSE_BUGBLOX:
				if (!collapse_bugblox.collapsed) {
					collapse_bugblox.collapsed = true;
					yPos_coll_synthesis += bugblox_height;
					yPos_coll_armour += bugblox_height;
					yPos_coll_magic += bugblox_height;
					yPos_coll_driveforms += bugblox_height;
					yPos_coll_misc += bugblox_height;
					collapseListLength += bugblox_height;
				} else if (collapse_bugblox.collapsed) {
					collapse_bugblox.collapsed = false;
					yPos_coll_synthesis -= bugblox_height;
					yPos_coll_armour -= bugblox_height;
					yPos_coll_magic -= bugblox_height;
					yPos_coll_driveforms -= bugblox_height;
					yPos_coll_misc -= bugblox_height;
					collapseListLength -= bugblox_height;
				}
				break;

			case COLLAPSE_SYNTHESIS:
				if (!collapse_synthesis.collapsed) {
					collapse_synthesis.collapsed = true;
					yPos_coll_armour += synthesis_height;
					yPos_coll_magic += synthesis_height;
					yPos_coll_driveforms += synthesis_height;
					yPos_coll_misc += synthesis_height;
					collapseListLength += synthesis_height;
				} else if (collapse_synthesis.collapsed) {
					collapse_synthesis.collapsed = false;
					yPos_coll_armour -= synthesis_height;
					yPos_coll_magic -= synthesis_height;
					yPos_coll_driveforms -= synthesis_height;
					yPos_coll_misc -= synthesis_height;
					collapseListLength -= synthesis_height;
				}
				break;

			case COLLAPSE_ARMOUR:
				if (!collapse_armour.collapsed) {
					collapse_armour.collapsed = true;
					yPos_coll_magic += armour_height;
					yPos_coll_driveforms += armour_height;
					yPos_coll_misc += armour_height;
					collapseListLength += armour_height;
				} else if (collapse_armour.collapsed) {
					collapse_armour.collapsed = false;
					yPos_coll_magic -= armour_height;
					yPos_coll_driveforms -= armour_height;
					yPos_coll_misc -= armour_height;
					collapseListLength -= armour_height;
				}
				break;

			case COLLAPSE_MAGIC:
				if (!collapse_magic.collapsed) {
					collapse_magic.collapsed = true;
					yPos_coll_driveforms += magic_height;
					yPos_coll_misc += magic_height;
					collapseListLength += magic_height;
				} else if (collapse_magic.collapsed) {
					collapse_magic.collapsed = false;
					yPos_coll_driveforms -= magic_height;
					yPos_coll_misc -= magic_height;
					collapseListLength -= magic_height;
				}
				break;

			case COLLAPSE_DRIVEFORMS:
				if (!collapse_driveforms.collapsed) {
					collapse_driveforms.collapsed = true;
					yPos_coll_misc += driveforms_height;
					collapseListLength += driveforms_height;
				} else if (collapse_driveforms.collapsed) {
					collapse_driveforms.collapsed = false;
					yPos_coll_misc -= magic_height;
					collapseListLength -= driveforms_height;
				}
				break;

			case COLLAPSE_MISC:
				if (!collapse_misc.collapsed) {
					collapse_misc.collapsed = true;
					collapseListLength += misc_height;
				} else if (collapse_misc.collapsed) {
					collapse_misc.collapsed = false;
					collapseListLength -= misc_height;
				}
				break;
			case TOPIC_COMMANDMENU_ABOUT:
				currentPage = page_commandmenu_about.getName();
				break;
			case TOPIC_COMMANDMENU_ATTACK:
				currentPage = page_commandmenu_attack.getName();
				break;
			case TOPIC_COMMANDMENU_MAGIC:
				currentPage = page_commandmenu_magic.getName();
				break;
			case TOPIC_COMMANDMENU_ITEMS:
				currentPage = page_commandmenu_items.getName();
				break;
			case TOPIC_COMMANDMENU_DRIVE:
				currentPage = page_commandmenu_drive.getName();
				break;
		}

	}

	@Override
	public void updateScreen () {
		super.updateScreen();
	}

	public static class GuiButtonCollapse extends GuiButton {
		public boolean collapsed = false;

		public GuiButtonCollapse (int id, int posX, int posY) {
			super(id, posX, posY, 5, 5, "");
		}

		@Override
		public void drawButton (Minecraft mc, int mouseX, int mouseY) {
			if (visible) {
				int u = 3;
				int v = 0;
				int w = 5;
				int h = 5;

				mc.renderEngine.bindTexture(texture);
				if (collapsed) {
					u = 3;
					v = 5;
					w = 5;
					h = 5;
				} else {
					u = 3;
					v = 0;
					w = 5;
					h = 5;
				}
				GL11.glPushMatrix();
				res = new ScaledResolution(mc);
				int distToBottomFromMisc = (res.getScaledHeight() / 4) - 7;
				int listHeight = (((res.getScaledHeight() / 4) + 7) + (res.getScaledHeight() / 2)) - yPos_coll_commandMenu + 2;

				GL11.glScissor(xPos_coll_commandMenu, (distToBottomFromMisc) * 2 - 2, res.getScaledWidth(), listHeight * 2 - 1);
				GL11.glEnable(GL11.GL_SCISSOR_TEST);
				GL11.glTranslatef(this.xPosition, this.yPosition, 0);
				GL11.glScalef(1.1f, 1.1f, 0);
				drawTexturedModalRect(0, 0, u, v, w, h);
				GL11.glDisable(GL11.GL_SCISSOR_TEST);
				GL11.glPopMatrix();
			}
		}
	}

	public static class GuiButtonScroll extends GuiButton {

		public GuiButtonScroll (int id, int posX, int posY) {
			super(id, posX, posY, 7, 7, "");
		}

		@Override
		protected void mouseDragged (Minecraft mc, int mouseX, int mouseY) {
			yPosition = mouseY;
		}

		@Override
		public void drawButton (Minecraft mc, int mouseX, int mouseY) {
			mc.renderEngine.bindTexture(texture);
			GL11.glPushMatrix();
			GL11.glTranslatef(xPosition, yPosition, 0);
			GL11.glScalef(1.5f, 1.5f, 0);
			drawTexturedModalRect(0, 0, 8, 0, 7, 7);
			GL11.glPopMatrix();
		}
	}

	public static class GuiButtonLink extends GuiButton {

		int colour;

		public GuiButtonLink (int id, int posX, int posY, int width, int height, String text, int colour) {
			super(id, posX, posY, Minecraft.getMinecraft().fontRendererObj.getStringWidth(text), 8, text);
			this.colour = colour;
		}

		@Override
		protected void mouseDragged (Minecraft mc, int mouseX, int mouseY) {
			yPosition = mouseY;
		}

		@Override
		public void drawButton (Minecraft mc, int mouseX, int mouseY) {
			if (visible) {
				GL11.glPushMatrix();
				GL11.glTranslatef(this.xPosition, this.yPosition + 2, 0);
				GL11.glScalef(0.75f, 0.75f, 0);
				res = new ScaledResolution(mc);
				int distToBottomFromMisc = (res.getScaledHeight() / 4) - 7;
				int listHeight = (((res.getScaledHeight() / 4) + 7) + (res.getScaledHeight() / 2)) - yPos_coll_commandMenu + 2;

				GL11.glScissor(xPos_coll_commandMenu, (distToBottomFromMisc) * 2 - 2, res.getScaledWidth(), listHeight * 2 - 1);
				GL11.glEnable(GL11.GL_SCISSOR_TEST);
				drawString(mc.fontRendererObj, this.displayString + TextFormatting.UNDERLINE, 0, 0, this.colour);
				GL11.glDisable(GL11.GL_SCISSOR_TEST);
				GL11.glPopMatrix();
			}
		}
	}

}
