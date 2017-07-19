package uk.co.wehavecookies56.kk.common.item;

import java.util.List;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.NonNullList;
import net.minecraft.world.World;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.items.IItemHandler;
import uk.co.wehavecookies56.kk.common.container.inventory.InventorySynthesisBagL;
import uk.co.wehavecookies56.kk.common.lib.GuiIDs;
import uk.co.wehavecookies56.kk.common.lib.Strings;
import uk.co.wehavecookies56.kk.common.network.packet.PacketDispatcher;
import uk.co.wehavecookies56.kk.common.network.packet.server.OpenGui;
import uk.co.wehavecookies56.kk.common.util.Utils;

import javax.annotation.Nullable;

public class ItemSynthesisBagL extends Item {

    public ItemSynthesisBagL () {
        setMaxStackSize(1);
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World world, EntityPlayer player, EnumHand hand) {
        if (world.isRemote) PacketDispatcher.sendToServer(new OpenGui(GuiIDs.GUI_SYNTHESISBAGL_INV));
        return super.onItemRightClick(world, player, hand);
    }

    @Override
    public void addInformation (ItemStack stack, EntityPlayer playerIn, List tooltip, boolean advanced) {
        int x = 30;
        String s = Utils.translateToLocal(Strings.SynthesisBagDesc);
        s = s.replaceAll("(.{" + x + ",}?)\\s+", "$1\n");
        String[] splitS = s.split("\n");
        for (String element : splitS)
            tooltip.add(element);
    }

    @Nullable
    @Override
    public ICapabilityProvider initCapabilities(ItemStack stack, @Nullable NBTTagCompound nbt) {
        return new InventorySynthesisBagL();
    }
}
