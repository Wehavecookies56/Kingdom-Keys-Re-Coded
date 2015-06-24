package wehavecookies56.kk.item;

import net.minecraft.item.Item;

public class ItemKeychain extends Item {

	ItemKeyblade blade;
	
	public ItemKeychain(ItemKeyblade blade) {this.blade = blade;}
	
	public void setKeyblade(ItemKeyblade blade){
		this.blade = blade;
	}
	
	public ItemKeyblade getKeyblade(){
		return this.blade;
	}
}
