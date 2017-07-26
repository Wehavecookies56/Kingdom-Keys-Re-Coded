package uk.co.wehavecookies56.kk.common.item;

import java.util.List;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundCategory;
import net.minecraft.world.World;
import uk.co.wehavecookies56.kk.client.sound.ModSounds;
import uk.co.wehavecookies56.kk.common.item.base.ItemKKBase;
import uk.co.wehavecookies56.kk.common.lib.Strings;
import uk.co.wehavecookies56.kk.common.network.packet.PacketDispatcher;
import uk.co.wehavecookies56.kk.common.network.packet.server.RemoveItemInSlot;

import javax.annotation.Nullable;

public class ItemMagicBoost extends ItemKKBase {
    public ItemMagicBoost(String name) {
        super(name);
        setMaxStackSize(1);
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World world, EntityPlayer player, EnumHand hand) {
        player.getActiveItemStack().setCount(player.getActiveItemStack().getCount()-1);
        if (world.isRemote) {
            PacketDispatcher.sendToServer(new RemoveItemInSlot(Strings.MagicBoost, player.inventory.currentItem));
        }
        player.world.playSound(player, player.getPosition(), ModSounds.itemget, SoundCategory.MASTER, 1.0f, 1.0f);
        return super.onItemRightClick(world, player, hand);
    }

    @Override
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> tooltip, ITooltipFlag flagIn) {
        tooltip.add("Permanently increases Magic by 1");
        super.addInformation(stack, worldIn, tooltip, flagIn);
    }

}
