package uk.co.wehavecookies56.kk.common.lib;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumHand;
import net.minecraftforge.event.entity.living.LivingDropsEvent;
import uk.co.wehavecookies56.kk.common.item.base.ItemKeyblade;

public class KeybladeDropEntry extends EntityDropEntry {

    public KeybladeDropEntry(Class<? extends Entity> droppedFrom, ItemStack item, int dropChance) {
        super(droppedFrom, item, dropChance);
    }

    @Override
    public boolean dropConditions(LivingDropsEvent event) {
        if (event.getSource().getTrueSource() instanceof EntityPlayer) {
            EntityPlayer player = (EntityPlayer) event.getSource().getTrueSource();
            if (player.getHeldItem(EnumHand.MAIN_HAND).getItem() instanceof ItemKeyblade || player.getHeldItem(EnumHand.OFF_HAND).getItem() instanceof ItemKeyblade) {
                return true;
            }
        }
        return false;
    }
}
