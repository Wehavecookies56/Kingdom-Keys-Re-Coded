package uk.co.wehavecookies56.kk.common.item.org;

import java.util.List;

import javax.annotation.Nullable;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import uk.co.wehavecookies56.kk.common.item.base.ItemOrgWeapon;
import uk.co.wehavecookies56.kk.common.util.Utils;
import uk.co.wehavecookies56.kk.common.world.dimension.ModDimensions;
import uk.co.wehavecookies56.kk.common.world.dimension.TeleporterDiveToTheHeart;
import uk.co.wehavecookies56.kk.common.world.dimension.TeleporterTraverseTown;

public class ItemSitar extends ItemOrgWeapon implements IOrgWeapon {

    public ItemSitar (String name, double strength, double magic)  {
        super(name, strength, magic);
        setMaxStackSize(1);
    }

    @Override
    @SideOnly (Side.CLIENT)
    public EnumRarity getRarity (ItemStack par1ItemStack) {
        return EnumRarity.UNCOMMON;
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn) {
        if (!worldIn.isRemote)
            if (playerIn.dimension != ModDimensions.traverseTownID)
                new TeleporterTraverseTown(worldIn.getMinecraftServer().getServer().getWorld(ModDimensions.traverseTownID)).teleport(((EntityPlayer) playerIn), worldIn);
            else
                new TeleporterDiveToTheHeart(worldIn.getMinecraftServer().getServer().getWorld(ModDimensions.diveToTheHeartID)).teleport(playerIn, worldIn);
        return super.onItemRightClick(worldIn, playerIn, handIn);
    }

    @Override
    public Utils.OrgMember getMember() {
        return Utils.OrgMember.DEMYX;
    }
}
