package uk.co.wehavecookies56.kk.common.item;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;
import uk.co.wehavecookies56.kk.common.network.packet.PacketDispatcher;
import uk.co.wehavecookies56.kk.common.network.packet.server.UnknownKnowledgePacket;

/**
 * Created by NStel on 2/3/2017.
 */
public class ItemUknownKnowledge  extends Item
{
    public ItemUknownKnowledge () {
        setMaxStackSize(1);
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(ItemStack itemStackIn, World worldIn, EntityPlayer playerIn,
                                                    EnumHand hand)
    {
        if (worldIn.isRemote) PacketDispatcher.sendToServer(new UnknownKnowledgePacket());
        return super.onItemRightClick(itemStackIn, worldIn, playerIn, hand);
    }
}
