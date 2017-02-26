package uk.co.wehavecookies56.kk.common.item;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;
import uk.co.wehavecookies56.kk.client.gui.GuiOrgWeapon;
import uk.co.wehavecookies56.kk.common.capability.ModCapabilities;
import uk.co.wehavecookies56.kk.common.util.Utils;

/**
 * Created by NStel on 2/6/2017.
 */
public class ItemAbandonedKnowledge extends Item
{
    public ItemAbandonedKnowledge() {
        setMaxStackSize(1);
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(ItemStack itemStackIn, World worldIn, EntityPlayer playerIn, EnumHand hand) {
        if (worldIn.isRemote && playerIn.getCapability(ModCapabilities.ORGANIZATION_XIII, null).getMember() != Utils.OrgMember.NONE) {
            Minecraft.getMinecraft().displayGuiScreen(new GuiOrgWeapon());
        }
        return super.onItemRightClick(itemStackIn, worldIn, playerIn, hand);
    }


}
