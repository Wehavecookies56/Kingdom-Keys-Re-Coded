package uk.co.wehavecookies56.kk.common.item;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.NonNullList;
import net.minecraft.util.SoundCategory;
import net.minecraft.world.World;
import uk.co.wehavecookies56.kk.client.sound.ModSounds;
import uk.co.wehavecookies56.kk.common.capability.ModCapabilities;
import uk.co.wehavecookies56.kk.common.item.base.ItemKKBase;
import uk.co.wehavecookies56.kk.common.lib.Strings;
import uk.co.wehavecookies56.kk.common.network.packet.PacketDispatcher;
import uk.co.wehavecookies56.kk.common.network.packet.server.RemoveItemInSlot;

import javax.annotation.Nullable;
import java.util.List;

public class ItemDriveBoost extends ItemKKBase {

    public ItemDriveBoost (String name) {
        super(name);
        setMaxStackSize(1);
    }
    
    public ActionResult<ItemStack> onItemRightClick(World world, EntityPlayer player, EnumHand hand) {
    	if(player.getCapability(ModCapabilities.DRIVE_STATE, null).getDriveGaugeLevel() < 9) {
		    player.getActiveItemStack().setCount(player.getActiveItemStack().getCount()-1);
		    //player.getCapability(ModCapabilities.DRIVE_STATE, null).setDriveGaugeLevel(player.getCapability(ModCapabilities.DRIVE_STATE, null).getDriveGaugeLevel()+1);
		    if (world.isRemote) {
		        PacketDispatcher.sendToServer(new RemoveItemInSlot(Strings.DriveBoost, player.inventory.currentItem));
		    }
		    player.world.playSound(player, player.getPosition(), ModSounds.itemget, SoundCategory.MASTER, 1.0f, 1.0f);
    	}
        return super.onItemRightClick(world, player, hand);
    }

    @Override
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> tooltip, ITooltipFlag flagIn) {
    	tooltip.add("Level up drive gauge by 1");
    }
}
