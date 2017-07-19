package uk.co.wehavecookies56.kk.common.container.inventory;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentString;
import uk.co.wehavecookies56.kk.common.item.base.ItemKKPotion;
import uk.co.wehavecookies56.kk.common.lib.Strings;
import uk.co.wehavecookies56.kk.common.util.Utils;

public class InventoryPotionsMenu {
    public static final String name = Utils.translateToLocal(Strings.PotionsInventory);
    public static final String SAVE_KEY = "PotionsInvKey";
    public static final int INV_SIZE = 5;
}
