package uk.co.wehavecookies56.kk.common.container.slot;

import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import uk.co.wehavecookies56.kk.common.item.ItemDriveForm;
import uk.co.wehavecookies56.kk.common.item.ItemSynthesisBagL;
import uk.co.wehavecookies56.kk.common.item.ItemSynthesisBagM;
import uk.co.wehavecookies56.kk.common.item.ItemSynthesisBagS;
import uk.co.wehavecookies56.kk.common.item.base.ItemKKPotion;
import uk.co.wehavecookies56.kk.common.item.base.ItemKeychain;
import uk.co.wehavecookies56.kk.common.item.base.ItemSpellOrb;

public class SlotCustom extends Slot {
	int window;

	public SlotCustom (IInventory inventory, int index, int x, int y, int window) {
		super(inventory, index, x, y);
		this.window = window;
	}

	@Override
	public boolean isItemValid (ItemStack stack) {
		/*
		 * 1- KeyChain 2- SynthBag 3- Potion 4- Spells 5- DriveForms
		 */
		switch (window) {
			case 1:
				if (stack.getItem() instanceof ItemKeychain) return true;
				break;
			case 2:
				if (stack.getItem() instanceof ItemSynthesisBagS || stack.getItem() instanceof ItemSynthesisBagM || stack.getItem() instanceof ItemSynthesisBagL) return true;
				break;
			case 3:
				if (stack.getItem() instanceof ItemKKPotion) return true;
				break;
			case 4:
				if (stack.getItem() instanceof ItemSpellOrb) return true;
				break;
			case 5:
				if (stack.getItem() instanceof ItemDriveForm) return true;
				break;
		}
		return false;
	}
}
