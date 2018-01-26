package uk.co.wehavecookies56.kk.common.lib;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.event.entity.living.LivingDropsEvent;
import uk.co.wehavecookies56.kk.common.util.Utils;

public class EntityDropEntry {

    ItemStack item;
    int dropChance;
    Class<? extends Entity> droppedFrom;

    public EntityDropEntry(Class<? extends Entity> droppedFrom, ItemStack item, int dropChance) {
        this.droppedFrom = droppedFrom;
        this.item = item;
        this.dropChance = dropChance;
    }

    public Class<? extends Entity> getDroppedFrom() {
        return droppedFrom;
    }

    public int getDropChance() {
        return dropChance;
    }

    public ItemStack getItem() {
        return item;
    }

    /**
     * Method for checking whether the item should drop, override for conditions like needing a certain item or to remove the drop chance.
     * @param event the living drops event to get the entity, player, etc.
     * @return true if the condition is met and it should drop false if the condition isn't met and it shouldn't drop
     */
    public boolean dropConditions(LivingDropsEvent event) {
        int rand = Utils.randomWithRange(1, 100);
        if (rand > 100 - dropChance) {
            return true;
        } else {
            return false;
        }
    }


}
