package uk.co.wehavecookies56.kk.common.item;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.TextFormatting;
import uk.co.wehavecookies56.kk.common.capability.ModCapabilities;
import uk.co.wehavecookies56.kk.common.item.base.ItemKKPotion;
import uk.co.wehavecookies56.kk.common.lib.Strings;

import java.util.List;

/**
 * Created by Toby on 16/07/2016.
 */
public class ItemMegaPotion extends ItemKKPotion {

    public ItemMegaPotion(int food, boolean wolf, String type) {
        super(food, wolf, type, Strings.MegaPotion);
        setAlwaysEdible();
    }

    @Override
    public void potionEffect(EntityPlayer player) {
        player.heal(player.getMaxHealth());
    }

    @Override
    public void addInformation(ItemStack stack, EntityPlayer playerIn, List<String> tooltip, boolean advanced) {
        tooltip.add(TextFormatting.GREEN + "Fully restores your HP (" + playerIn.getMaxHealth() + ")");
        super.addInformation(stack, playerIn, tooltip, advanced);
    }
}
