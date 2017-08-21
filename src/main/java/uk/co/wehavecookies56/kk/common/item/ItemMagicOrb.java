package uk.co.wehavecookies56.kk.common.item;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.NonNullList;
import net.minecraft.world.World;
import uk.co.wehavecookies56.kk.common.item.base.ItemKKBase;

import javax.annotation.Nullable;
import java.util.List;

public class ItemMagicOrb extends ItemKKBase {

    public ItemMagicOrb (String name) {
        super(name);
        setMaxStackSize(1);
    }

    @Override
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> tooltip, ITooltipFlag flagIn) {
        if (stack.hasTagCompound()) {
            int amount = stack.getTagCompound().getInteger("amount");
            tooltip.add("" + amount);
        }
    }

    @Override
    public void getSubItems(CreativeTabs tab, NonNullList<ItemStack> items) {
        if (isInCreativeTab(tab)) {
            ItemStack magicOrb = new ItemStack(ModItems.MagicOrb, 1);
            magicOrb.setTagCompound(new NBTTagCompound());
            magicOrb.getTagCompound().setInteger("amount", 100);
            items.add(magicOrb);
        }
    }

}
