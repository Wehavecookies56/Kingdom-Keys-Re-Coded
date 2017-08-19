package uk.co.wehavecookies56.kk.common.item.org;

import java.util.List;

import javax.annotation.Nullable;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemShield;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import uk.co.wehavecookies56.kk.common.item.ModItems;
import uk.co.wehavecookies56.kk.common.util.Utils;
import uk.co.wehavecookies56.kk.common.util.Utils.OrgMember;

public class ItemOrgShield extends ItemShield implements IOrgWeapon{

    public ItemOrgShield (String name) {
        super();
        setRegistryName(name);
        setUnlocalizedName(name);
        setCreativeTab(ModItems.tabKingdomKeys);
        this.maxStackSize = 1;
        /*this.addPropertyOverride(new ResourceLocation(Reference.MODID, "models/item/blocking"), new IItemPropertyGetter()
        {
            @SideOnly(Side.CLIENT)
            public float apply(ItemStack stack, World worldIn, EntityLivingBase entityIn)
            {
                return entityIn != null && entityIn.isHandActive() && entityIn.getActiveItemStack() == stack ? 1.0F : 0.0F;
            }
        });
        */
    }

    @Override
    public CreativeTabs getCreativeTab() {
        return ModItems.tabKingdomKeys;
    }

    @Override
    public String getItemStackDisplayName(ItemStack stack) {
        return Utils.translateToLocal(this.getUnlocalizedName() + ".name");
    }

    @Override
    public void onUpdate (ItemStack item, World world, Entity entity, int p_77663_4_, boolean p_77663_5_) {
       // EntityPlayer player = (EntityPlayer) entity;
        super.onUpdate(item, world, entity, p_77663_4_, p_77663_5_);
    }

    @Override
    @SideOnly (Side.CLIENT)
    public EnumRarity getRarity (ItemStack par1ItemStack) {
        return EnumRarity.UNCOMMON;
    }

    @Override
    public OrgMember getMember() {
        return Utils.OrgMember.VEXEN;
    }

}
