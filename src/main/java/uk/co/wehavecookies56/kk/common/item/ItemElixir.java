package uk.co.wehavecookies56.kk.common.item;

import net.minecraft.client.Minecraft;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import uk.co.wehavecookies56.kk.common.capability.ModCapabilities;
import uk.co.wehavecookies56.kk.common.item.base.ItemKKPotion;
import uk.co.wehavecookies56.kk.common.lib.Strings;

import javax.annotation.Nullable;
import java.util.List;

public class ItemElixir extends ItemKKPotion {

    String potionType;

    public ItemElixir (int food, boolean wolf, String type) {
        super(food, wolf, type, Strings.Elixir);
        setAlwaysEdible();
        this.potionType = type;
    }

    @Override
    public void potionEffect (EntityPlayer player) {
        player.getCapability(ModCapabilities.PLAYER_STATS, null).addMP(player.getCapability(ModCapabilities.PLAYER_STATS, null).getMaxMP() / 3);
        player.heal(player.getMaxHealth() / 3);
    }

    @SideOnly(Side.CLIENT)
    @Override
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> tooltip, ITooltipFlag flagIn) {
        if (Minecraft.getMinecraft().player != null) {
            tooltip.add(TextFormatting.BLUE + "Restores a third of your max MP (" + (int) (Minecraft.getMinecraft().player.getCapability(ModCapabilities.PLAYER_STATS, null).getMaxMP() / 3) + ")");
            tooltip.add(TextFormatting.GREEN + "Restores a third of your max HP (" + (int) (Minecraft.getMinecraft().player.getMaxHealth() / 3) + ")");
        }
        super.addInformation(stack, worldIn, tooltip, flagIn);
    }

}