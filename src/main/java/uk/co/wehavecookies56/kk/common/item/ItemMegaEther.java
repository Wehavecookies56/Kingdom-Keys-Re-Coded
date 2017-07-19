package uk.co.wehavecookies56.kk.common.item;

import java.util.List;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.TextFormatting;
import uk.co.wehavecookies56.kk.common.capability.ModCapabilities;
import uk.co.wehavecookies56.kk.common.item.base.ItemKKPotion;
import uk.co.wehavecookies56.kk.common.lib.Strings;

public class ItemMegaEther extends ItemKKPotion {

    String potionType;

    public ItemMegaEther(int food, boolean wolf, String type) {
        super(food, wolf, type, Strings.MegaEther);
        setAlwaysEdible();
        this.potionType = type;
    }

    @Override
    public void potionEffect (EntityPlayer player) {
        player.getCapability(ModCapabilities.PLAYER_STATS, null).addMP(player.getCapability(ModCapabilities.PLAYER_STATS, null).getMaxMP());
    }

    @Override
    public void addInformation(ItemStack stack, EntityPlayer playerIn, List<String> tooltip, boolean advanced) {
        tooltip.add(TextFormatting.BLUE + "Fully restores your MP (" + playerIn.getCapability(ModCapabilities.PLAYER_STATS, null).getMaxMP() + ")");
        super.addInformation(stack, playerIn, tooltip, advanced);
    }

}