package uk.co.wehavecookies56.kk.common.item;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;
import uk.co.wehavecookies56.kk.common.item.base.ItemKKBase;

public class ItemHpOrb extends ItemKKBase {
    public ItemHpOrb (String name) {
        super(name);
        setMaxStackSize(64);
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World world, EntityPlayer player, EnumHand hand) {
        if (!(player.getHealth() == 20)) {
            player.heal(2);
            player.inventory.decrStackSize(player.inventory.currentItem, 1);
        }
        return new ActionResult<ItemStack>(EnumActionResult.SUCCESS, player.getActiveItemStack());
    }

}
