package uk.co.wehavecookies56.kk.common.item.org;

import java.util.List;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import uk.co.wehavecookies56.kk.common.item.base.ItemOrgWeapon;
import uk.co.wehavecookies56.kk.common.util.Utils;
import uk.co.wehavecookies56.kk.common.util.Utils.OrgMember;

import javax.annotation.Nullable;

public class ItemCard extends ItemOrgWeapon implements IOrgWeapon{

    public ItemCard (String name, double strength, double magic)  {
        super(name, strength,magic);
        setMaxStackSize(1);
    }

    @Override
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> tooltip, ITooltipFlag flagIn) {
        tooltip.add("X Luxord");
    }

    @Override
    public OrgMember getMember() {
        return Utils.OrgMember.LUXORD;
    }
}
