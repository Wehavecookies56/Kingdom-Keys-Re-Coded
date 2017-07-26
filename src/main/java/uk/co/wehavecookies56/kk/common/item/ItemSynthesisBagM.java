package uk.co.wehavecookies56.kk.common.item;

import java.util.List;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import uk.co.wehavecookies56.kk.common.container.inventory.InventorySynthesisBagM;
import uk.co.wehavecookies56.kk.common.item.base.ItemKKBase;
import uk.co.wehavecookies56.kk.common.lib.GuiIDs;
import uk.co.wehavecookies56.kk.common.lib.Strings;
import uk.co.wehavecookies56.kk.common.network.packet.PacketDispatcher;
import uk.co.wehavecookies56.kk.common.network.packet.server.OpenGui;
import uk.co.wehavecookies56.kk.common.util.Utils;

import javax.annotation.Nullable;

public class ItemSynthesisBagM extends ItemKKBase {

    public ItemSynthesisBagM(String name) {
        super(name);
        setMaxStackSize(1);
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World world, EntityPlayer player, EnumHand hand) {
        if (world.isRemote) PacketDispatcher.sendToServer(new OpenGui(GuiIDs.GUI_SYNTHESISBAGM_INV));
        return super.onItemRightClick(world, player, hand);
    }

    @Override
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> tooltip, ITooltipFlag flagIn) {
        tooltip.add(Utils.translateToLocal(Strings.SynthesisBagDesc));
        super.addInformation(stack, worldIn, tooltip, flagIn);
    }

    @Nullable
    @Override
    public ICapabilityProvider initCapabilities(ItemStack stack, @Nullable NBTTagCompound nbt) {
        return new InventorySynthesisBagM();
    }
}
