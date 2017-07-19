package uk.co.wehavecookies56.kk.common.item;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;
import uk.co.wehavecookies56.kk.common.KingdomKeys;
import uk.co.wehavecookies56.kk.common.capability.ModCapabilities;
import uk.co.wehavecookies56.kk.common.lib.GuiIDs;
import uk.co.wehavecookies56.kk.common.network.packet.PacketDispatcher;
import uk.co.wehavecookies56.kk.common.network.packet.client.SyncOrgXIIIData;
import uk.co.wehavecookies56.kk.common.util.Utils;

/**
 * Created by NStel on 2/6/2017.
 */
public class ItemAbandonedKnowledge extends Item {
    public ItemAbandonedKnowledge() {
        setMaxStackSize(1);
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World world, EntityPlayer player, EnumHand hand) {
        if (world.isRemote && player.getCapability(ModCapabilities.ORGANIZATION_XIII, null).getMember() != Utils.OrgMember.NONE) {
            player.openGui(KingdomKeys.instance, GuiIDs.GUI_ORG_UNLOCK, world, (int) player.posX, (int) player.posX, (int) player.posZ);
        } else {
            PacketDispatcher.sendTo(new SyncOrgXIIIData(player.getCapability(ModCapabilities.ORGANIZATION_XIII, null)), (EntityPlayerMP) player);
        }
        return super.onItemRightClick(world, player, hand);
    }
}
