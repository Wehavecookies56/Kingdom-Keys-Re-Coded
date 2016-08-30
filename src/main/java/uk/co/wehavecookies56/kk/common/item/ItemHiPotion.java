package uk.co.wehavecookies56.kk.common.item;

import java.util.List;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.TextFormatting;
import uk.co.wehavecookies56.kk.common.item.base.ItemKKPotion;
import uk.co.wehavecookies56.kk.common.lib.Strings;

/**
 * Created by Toby on 16/07/2016.
 */
public class ItemHiPotion extends ItemKKPotion {

    public ItemHiPotion(int food, boolean wolf, String type) {
        super(food, wolf, type, Strings.HiPotion);
        setAlwaysEdible();
    }

    @Override
    public void potionEffect(EntityPlayer player) {
        player.heal(player.getMaxHealth() / 2);
    }

    @Override
    public void addInformation(ItemStack stack, EntityPlayer playerIn, List<String> tooltip, boolean advanced) {
        tooltip.add(TextFormatting.GREEN + "Restores half of your max HP (" + playerIn.getMaxHealth() / 2 + ")");
        super.addInformation(stack, playerIn, tooltip, advanced);
    }
}
