package uk.co.wehavecookies56.kk.common.item;

import java.util.List;

import net.minecraft.client.Minecraft;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import uk.co.wehavecookies56.kk.common.item.base.ItemKKPotion;
import uk.co.wehavecookies56.kk.common.lib.Strings;

import javax.annotation.Nullable;

/**
 * Created by Toby on 16/07/2016.
 */
public class ItemMegaPotion extends ItemKKPotion {

    public ItemMegaPotion(int food, boolean wolf, String type) {
        super(food, wolf, type, Strings.MegaPotion);
        setAlwaysEdible();
    }

    @Override
    public void potionEffect(EntityPlayer player) {
        player.heal(player.getMaxHealth());
    }

    @SideOnly(Side.CLIENT)
    @Override
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> tooltip, ITooltipFlag flagIn) {
        if (Minecraft.getMinecraft().player != null)
            tooltip.add(TextFormatting.GREEN + "Fully restores your HP (" + Minecraft.getMinecraft().player.getMaxHealth() + ")");
        super.addInformation(stack, worldIn, tooltip, flagIn);
    }
}
