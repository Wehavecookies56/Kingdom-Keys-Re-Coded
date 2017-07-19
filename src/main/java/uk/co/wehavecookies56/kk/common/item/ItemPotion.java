package uk.co.wehavecookies56.kk.common.item;

import java.util.List;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.TextFormatting;
import uk.co.wehavecookies56.kk.common.item.base.ItemKKPotion;
import uk.co.wehavecookies56.kk.common.lib.Strings;

public class ItemPotion extends ItemKKPotion {

    String potionType;

    public ItemPotion (int food, boolean wolf, String type) {
        super(food, wolf, type, Strings.Potion);
        setAlwaysEdible();
        this.potionType = type;
    }

    @Override
    public void potionEffect (EntityPlayer player) {
        player.heal(player.getMaxHealth() / 3);
    }

    @Override
    public void addInformation(ItemStack stack, EntityPlayer playerIn, List<String> tooltip, boolean advanced) {
        tooltip.add(TextFormatting.GREEN + "Restores a third of your max HP (" + (int)(playerIn.getMaxHealth() / 3) + ")");
        super.addInformation(stack, playerIn, tooltip, advanced);
    }

}