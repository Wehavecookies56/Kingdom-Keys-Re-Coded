package wehavecookies56.kk.inventory;

import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import wehavecookies56.kk.item.ItemKeychain;
import wehavecookies56.kk.item.KKPotion;
import wehavecookies56.kk.item.ItemSynthesisBagL;
import wehavecookies56.kk.item.ItemSynthesisBagM;
import wehavecookies56.kk.item.ItemSynthesisBagS;

public class SlotCustom extends Slot {
	int window;
	public SlotCustom(IInventory inventory, int index, int x, int y, int window) {
		super(inventory, index, x, y);
		this.window = window;
	}
	
	@Override
	public boolean isItemValid(ItemStack stack) {
		/*
		 * 1- KeyChain
		 * 2- SynthBag 
		 * 3- Potion
		 */
		switch(window)
		{
		case 1:
			if(stack.getItem() instanceof ItemKeychain)
				return true;
			break;
		case 2:
			if(stack.getItem() instanceof ItemSynthesisBagS || stack.getItem() instanceof ItemSynthesisBagM || stack.getItem() instanceof ItemSynthesisBagL)
				return true;
			break;
		case 3:
			if(stack.getItem() instanceof KKPotion)
				return true;
			break;
		}
		return false;
	}
}
