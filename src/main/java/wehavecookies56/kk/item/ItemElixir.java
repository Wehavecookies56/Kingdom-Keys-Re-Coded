package wehavecookies56.kk.item;

import wehavecookies56.kk.lib.Strings;

public class ItemElixir extends ItemKKPotion{

	String potionType;
	
    public ItemElixir(int food, boolean wolf, String type) {
        super(food, wolf, type);       
        this.setUnlocalizedName(Strings.Potion);
        this.setAlwaysEdible();
        this.potionType = type;
    }
}