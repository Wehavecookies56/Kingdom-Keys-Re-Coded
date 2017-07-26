package uk.co.wehavecookies56.kk.common.item;

import net.minecraft.item.ItemStack;
import uk.co.wehavecookies56.kk.common.item.base.ItemKKBase;

public class ItemBlazingInfusedCoal extends ItemKKBase {

    public ItemBlazingInfusedCoal(String name) {
        super(name);
    }

    @Override
    public int getItemBurnTime(ItemStack itemStack) {
        return 120;
    }
}
