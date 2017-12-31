package uk.co.wehavecookies56.kk.common.item;

import java.util.List;

import javax.annotation.Nullable;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import uk.co.wehavecookies56.kk.common.capability.ModCapabilities;
import uk.co.wehavecookies56.kk.common.item.base.ItemKKPotion;
import uk.co.wehavecookies56.kk.common.lib.Strings;

public class ItemHighDriveRecovery extends ItemKKPotion {

    String potionType;

    public ItemHighDriveRecovery(int food, boolean wolf, String type) {
        super(food, wolf, type, Strings.HighDriveRecovery);
        setAlwaysEdible();
        this.potionType = type;
    }

    @Override
    public void potionEffect (EntityPlayer player) {
        player.getCapability(ModCapabilities.DRIVE_STATE, null).addDP(player.getCapability(ModCapabilities.DRIVE_STATE, null).getMaxDP());
    }

    @Override
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> tooltip, ITooltipFlag flagIn) {
        tooltip.add(TextFormatting.GOLD + "Fully Restores the Drive Gauge");
        super.addInformation(stack, worldIn, tooltip, flagIn);
    }
}