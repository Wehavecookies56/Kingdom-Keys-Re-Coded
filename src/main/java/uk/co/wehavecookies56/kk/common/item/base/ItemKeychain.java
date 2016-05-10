package uk.co.wehavecookies56.kk.common.item.base;

import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;

public class ItemKeychain extends ItemSword {

	public ItemKeychain(ItemKeyblade blade, ToolMaterial material) {
		super(material);
		this.blade = blade;
		setMaxStackSize(1);	
	}
	ItemKeyblade blade;
	
	public void setKeyblade (ItemKeyblade blade) {
		this.blade = blade;
	}

	public ItemKeyblade getKeyblade () {
		return this.blade;
	}
	@Override
    public boolean isBookEnchantable(ItemStack stack, ItemStack book){
		return true;
	}
}
