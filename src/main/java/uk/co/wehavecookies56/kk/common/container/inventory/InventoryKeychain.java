package uk.co.wehavecookies56.kk.common.container.inventory;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentString;
import uk.co.wehavecookies56.kk.common.item.base.ItemKeychain;
import uk.co.wehavecookies56.kk.common.lib.Strings;
import uk.co.wehavecookies56.kk.common.util.Utils;

public class InventoryKeychain {
    public static final String name = Utils.translateToLocal(Strings.KeychainInventory);
    public static final String SAVE_KEY = "KeychainInvKey";
    public static final int INV_SIZE = 1;

}
