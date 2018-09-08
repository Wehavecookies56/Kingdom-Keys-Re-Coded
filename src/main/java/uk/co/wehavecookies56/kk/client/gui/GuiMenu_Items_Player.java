package uk.co.wehavecookies56.kk.client.gui;

import java.io.IOException;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.item.ItemStack;
import net.minecraftforge.items.ItemStackHandler;
import uk.co.wehavecookies56.kk.api.menu.ItemCategory;
import uk.co.wehavecookies56.kk.client.core.helper.GuiHelper;
import uk.co.wehavecookies56.kk.client.gui.redesign.GuiElementBox;
import uk.co.wehavecookies56.kk.client.gui.redesign.GuiEquippedItem;
import uk.co.wehavecookies56.kk.client.gui.redesign.GuiItems;
import uk.co.wehavecookies56.kk.client.gui.redesign.GuiWeapons;
import uk.co.wehavecookies56.kk.common.capability.ModCapabilities;
import uk.co.wehavecookies56.kk.common.capability.OrganizationXIIICapability;
import uk.co.wehavecookies56.kk.common.capability.PlayerStatsCapability;
import uk.co.wehavecookies56.kk.common.lib.Strings;
import uk.co.wehavecookies56.kk.common.util.Utils;

public class GuiMenu_Items_Player extends GuiScreen {

	final int KEYCHAIN = 1, SPELLS = 2, ITEMS = 3, DRIVE = 4, BACK = 5;
	GuiButton keychain, spells, items, driveforms, back;

	GuiMenu_Bars background;
	GuiElementBox listBox;
	GuiElementBox detailsBox;
	GuiEquippedItem weapon, valor, master, Final, helmet, chestplate, leggings, boots;
	GuiEquippedItem equippedAccessories[] = new GuiEquippedItem[4];
	GuiEquippedItem equippedItems[] = new GuiEquippedItem[8];

	public GuiMenu_Items_Player() {
		background = new GuiMenu_Bars(Strings.Gui_Menu_Items_Title);
		mc = Minecraft.getMinecraft();
	}

	@Override
	protected void actionPerformed(GuiButton button) throws IOException {
		switch (button.id) {
		case BACK:
			GuiHelper.openMenu_Items();
			break;
		}
		updateButtons();
	}

	private void updateButtons() {
		updateScreen();
	}

	@Override
	public void initGui() {
		background.width = width;
		background.height = height;
		background.init();
		super.initGui();

		float listBoxX = width * 0.1463F;
		float boxY = height * 0.174F;
		float listBoxWidth = width * 0.452F;
		float boxHeight = height * 0.5972F;
		float detailsWidth = width * 0.2588F;
		float detailsX = listBoxX + listBoxWidth;
		listBox = new GuiElementBox((int) listBoxX, (int) boxY, (int) listBoxWidth, (int) boxHeight, 0x4C4C4C);
		detailsBox = new GuiElementBox((int) detailsX, (int) boxY, (int) detailsWidth, (int) boxHeight, 0x4C4C4C);

		float itemsX = width * 0.2869F;
		float itemsY = height * 0.1907F;

		ItemStackHandler keychains = mc.player.getCapability(ModCapabilities.SUMMON_KEYBLADE, null).getInventoryKeychain();

		int itemHeight = 14;

		OrganizationXIIICapability.IOrganizationXIII org = mc.player.getCapability(ModCapabilities.ORGANIZATION_XIII, null);
		PlayerStatsCapability.IPlayerStats playerStats = mc.player.getCapability(ModCapabilities.PLAYER_STATS, null);

		int offset;
		if (org.getMember() == Utils.OrgMember.NONE) {
			weapon = new GuiEquippedItem(keychains.getStackInSlot(0), (int) itemsX, (int) itemsY, 0x3C0002, new GuiWeapons(0, 0x701F23, 0x3C0000), ItemCategory.TOOL, this, "Weapon", 0xFE8185);
			valor = new GuiEquippedItem(keychains.getStackInSlot(1), (int) itemsX, (int) itemsY + 1 + itemHeight, 0x003231, new GuiWeapons(1, 0x0A1616, 0x032F3C), ItemCategory.TOOL, this, "Valor", 0x069293);
			master = new GuiEquippedItem(keychains.getStackInSlot(2), (int) itemsX, (int) itemsY + 2 + (itemHeight * 2), 0x003231, new GuiWeapons(2, 0x0A1616, 0x032F3C), ItemCategory.TOOL, this, "Master", 0x069293);
			Final = new GuiEquippedItem(keychains.getStackInSlot(3), (int) itemsX, (int) itemsY + 3 + (itemHeight * 3), 0x003231, new GuiWeapons(3, 0x0A1616, 0x032F3C), ItemCategory.TOOL, this, "Final", 0x069293);
			offset = 4;
		} else {
			weapon = new GuiEquippedItem(new ItemStack(org.currentWeapon()), (int) itemsX, (int) itemsY, 0x3C0002, new GuiOrgWeapon(), ItemCategory.TOOL, this, "Weapon", 0xFE8185);
			offset = 1;
		}
		helmet = new GuiEquippedItem(mc.player.inventory.armorInventory.get(3), (int) itemsX, (int) itemsY + offset + (itemHeight * offset++), 0x685800, null, ItemCategory.EQUIPMENT, this, "Armour", 0xFEF461);
		chestplate = new GuiEquippedItem(mc.player.inventory.armorInventory.get(2), (int) itemsX, (int) itemsY + offset + (itemHeight * offset++), 0x685800, null, ItemCategory.EQUIPMENT, this);
		leggings = new GuiEquippedItem(mc.player.inventory.armorInventory.get(1), (int) itemsX, (int) itemsY + offset + (itemHeight * offset++), 0x685800, null, ItemCategory.EQUIPMENT, this);
		boots = new GuiEquippedItem(mc.player.inventory.armorInventory.get(0), (int) itemsX, (int) itemsY + offset + (itemHeight * offset++), 0x685800, null, ItemCategory.EQUIPMENT, this);

		// First one has a label so different constructor
		equippedAccessories[0] = new GuiEquippedItem(playerStats.getInventoryPotionsMenu().getStackInSlot(0), (int) itemsX, (int) itemsY + offset + (itemHeight * offset++), 0x041E68, new GuiItems(0, 0x0000AA, 0x041E68), ItemCategory.CONSUMABLE, this, "Accessories", 0x58B2E5);
		for (int i = 1; i < equippedAccessories.length; i++) {
			equippedAccessories[i] = new GuiEquippedItem(playerStats.getInventoryPotionsMenu().getStackInSlot(i), (int) itemsX, (int) itemsY + offset + (itemHeight * offset++), 0x041E68, new GuiItems(i, 0x0000AA, 0x041E68), ItemCategory.CONSUMABLE, this);
		}

		// First one has a label so different constructor
		equippedItems[0] = new GuiEquippedItem(playerStats.getInventoryPotionsMenu().getStackInSlot(0), (int) itemsX, (int) itemsY + offset + (itemHeight * offset++), 0x003213, new GuiItems(0, 0x1B633A, 0x003214), ItemCategory.CONSUMABLE, this, "Items", 0x41F031);
		for (int i = 1; i < equippedItems.length; i++) {
			equippedItems[i] = new GuiEquippedItem(playerStats.getInventoryPotionsMenu().getStackInSlot(i), (int) itemsX, (int) itemsY + offset + (itemHeight * offset++), 0x003213, new GuiItems(i, 0x1B633A, 0x003214), ItemCategory.CONSUMABLE, this);
		}
		updateButtons();
	}

	@Override
	public void drawScreen(int mouseX, int mouseY, float partialTicks) {
		background.drawBars();
		background.drawMunnyTime();
		background.drawBiomeDim();
		listBox.draw();
		detailsBox.draw();
		GlStateManager.pushMatrix();
		{
			RenderHelper.enableStandardItemLighting();
			RenderHelper.enableGUIStandardItemLighting();

			weapon.drawButton(mc, mouseX, mouseY, partialTicks);
			if (mc.player.getCapability(ModCapabilities.ORGANIZATION_XIII, null).getMember() == Utils.OrgMember.NONE) {
				valor.drawButton(mc, mouseX, mouseY, partialTicks);
				master.drawButton(mc, mouseX, mouseY, partialTicks);
				Final.drawButton(mc, mouseX, mouseY, partialTicks);
			}
			helmet.drawButton(mc, mouseX, mouseY, partialTicks);
			chestplate.drawButton(mc, mouseX, mouseY, partialTicks);
			leggings.drawButton(mc, mouseX, mouseY, partialTicks);
			boots.drawButton(mc, mouseX, mouseY, partialTicks);
			
			for (int i = 0; i < equippedAccessories.length; i++) {
				equippedAccessories[i].drawButton(mc, mouseX, mouseY, partialTicks);
			}
			
			for (int i = 0; i < equippedItems.length; i++) {
				equippedItems[i].drawButton(mc, mouseX, mouseY, partialTicks);
			}
		}
		GlStateManager.popMatrix();
		super.drawScreen(mouseX, mouseY, partialTicks);
	}

	@Override
	protected void mouseClicked(int mouseX, int mouseY, int mouseButton) throws IOException {
		if (mouseButton == 0) {
			weapon.mousePressed(mc, mouseX, mouseY);
			if (mc.player.getCapability(ModCapabilities.ORGANIZATION_XIII, null).getMember() == Utils.OrgMember.NONE) {
				valor.mousePressed(mc, mouseX, mouseY);
				master.mousePressed(mc, mouseX, mouseY);
				Final.mousePressed(mc, mouseX, mouseY);
			}

			for (int i = 0; i < equippedItems.length; i++) {
				equippedItems[i].mousePressed(mc, mouseX, mouseY);
			}
		} else {
			GuiHelper.openMenu_Items();
		}

		super.mouseClicked(mouseX, mouseY, mouseButton);
	}
}
