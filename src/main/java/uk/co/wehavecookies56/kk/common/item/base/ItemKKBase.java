package uk.co.wehavecookies56.kk.common.item.base;

import net.minecraft.item.Item;
import uk.co.wehavecookies56.kk.common.item.ModItems;

public class ItemKKBase extends Item {

    public ItemKKBase(String name) {
        setRegistryName(name);
        setUnlocalizedName(name);
        setCreativeTab(ModItems.tabKingdomKeys);
    }
}
