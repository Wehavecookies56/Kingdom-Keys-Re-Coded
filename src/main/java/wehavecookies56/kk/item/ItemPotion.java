package wehavecookies56.kk.item;

import wehavecookies56.kk.lib.Strings;

public class ItemPotion extends ItemKKPotion{

	String potionType;
	
    public ItemPotion(int food, boolean wolf, String type) {
        super(food, wolf, type, "potion");       
        this.setUnlocalizedName(Strings.Potion);
        this.setAlwaysEdible();
        this.potionType = type;
    }
}