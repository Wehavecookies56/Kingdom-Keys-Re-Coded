package uk.co.wehavecookies56.kk.client.gui.redesign;

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import uk.co.wehavecookies56.kk.client.core.helper.GuiHelper;
import uk.co.wehavecookies56.kk.client.gui.GuiMenu_Bars;
import uk.co.wehavecookies56.kk.common.item.base.ItemKKPotion;
import uk.co.wehavecookies56.kk.common.item.base.ItemKeychain;
import uk.co.wehavecookies56.kk.common.lib.Reference;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GuiItems extends GuiScreen {

	GuiMenu_Bars background;
	GuiElementBox potions, details;

	List<GuiPotionListItem> items = new ArrayList<>();

	int itemSlot, colour, buttonColour;

	public GuiItems(int itemSlot, int colour, int buttonColour) {
		mc = Minecraft.getMinecraft();
		background = new GuiMenu_Bars("Items");
		this.itemSlot = itemSlot;
		this.colour = colour;
		this.buttonColour = buttonColour;
	}

	@Override
	protected void actionPerformed(GuiButton button) throws IOException {
		super.actionPerformed(button);
	}

	@Override
	public void initGui() {
		items.clear();
		background.width = width;
		background.height = height;
		background.init();
		float keybladesX = width * 0.1432F;
		float keybladesY = height * 0.175F;
		float keybladesWidth = width * 0.5317F;
		float keybladesHeight = height * 0.5972F;
		float detailsX = width * 0.675F;
		float detailsWidth = width * 0.1817F;
		float listX = width * 0.1546F;
		float listY = height * 0.2546F;

		int itemHeight = 14;

		BiMap<Integer, ItemStack> potionItems = HashBiMap.create();

		for (int i = 0; i < mc.player.inventory.getSizeInventory(); i++) {
			if (!ItemStack.areItemStacksEqual(mc.player.inventory.getStackInSlot(i), ItemStack.EMPTY)) {
				if (mc.player.inventory.getStackInSlot(i).getItem() instanceof ItemKKPotion) {
					potionItems.put(i, mc.player.inventory.getStackInSlot(i));
				}
			}
		}
		for (int i = 0; i < new ArrayList<>(potionItems.keySet()).size(); i++) {
			items.add(new GuiPotionListItem(new ArrayList<>(potionItems.values()).get(i), new ArrayList<>(potionItems.keySet()).get(i), (int) listX, (int) listY + i + (itemHeight * i), this, buttonColour));
		}
		potions = new GuiElementBox((int) keybladesX, (int) keybladesY, (int) keybladesWidth, (int) keybladesHeight, colour);
		details = new GuiElementBox((int) detailsX, (int) keybladesY, (int) detailsWidth, (int) keybladesHeight, colour);
		super.initGui();
	}

	@Override
	public void drawScreen(int mouseX, int mouseY, float partialTicks) {
		background.drawBars();
		background.drawBiomeDim();
		background.drawMunnyTime();
		potions.draw();
		details.draw();
		for (GuiPotionListItem i : items) {
			i.drawButton(mc, mouseX, mouseY, partialTicks);
		}
		Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation(Reference.MODID, "textures/gui/menu/menu_button.png"));

		super.drawScreen(mouseX, mouseY, partialTicks);
	}

	@Override
	protected void mouseClicked(int mouseX, int mouseY, int mouseButton) throws IOException {
		if (mouseButton == 0) {
			for (GuiPotionListItem i : items) {
				i.mousePressed(mc, mouseX, mouseY);
			}
		} else {
			GuiHelper.openMenu_Items_Player();
		}
		super.mouseClicked(mouseX, mouseY, mouseButton);
	}
}
