package uk.co.wehavecookies56.kk.common.item;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import uk.co.wehavecookies56.kk.common.lib.Reference;

public class ItemOrganizationRobe extends ItemArmor /*implements ISpecialArmor*/ {

    public ItemOrganizationRobe (ArmorMaterial material, int renderIndex, EntityEquipmentSlot slot, int armorType, String name) {
        super(material, renderIndex, slot);
        setUnlocalizedName(name);
    }

    /*
    @Override
    public ArmorProperties getProperties (EntityLivingBase player, ItemStack armor, DamageSource source, double damage, int slot) {
        //if (source == DamageSource.inFire || source == DamageSource.lava || source == DamageSource.onFire) return new ArmorProperties(1, 1, MathHelper.floor_double(damage * .25D));
        if (armor.getItem() == ModItems.OrganizationRobe_Helmet) {
            return new ArmorProperties(0, 0.05, 1);
        } else if (armor.getItem() == ModItems.OrganizationRobe_Chestplate) {
            return new ArmorProperties(0, 0.1, 1);
        } else if (armor.getItem() == ModItems.OrganizationRobe_Leggings) {
            return new ArmorProperties(0, 0.1, 1);
        } else if (armor.getItem() == ModItems.OrganizationRobe_Boots) {
            return new ArmorProperties(0, 0.05, 1);
        } else {
            return new ArmorProperties(0, 0, 0);
        }
    }

    @Override
    public int getArmorDisplay (EntityPlayer player, ItemStack armor, int slot) {
        return 4;
    }

    @Override
    public void damageArmor (EntityLivingBase entity, ItemStack stack, DamageSource source, int damage, int slot) {
        stack.damageItem(damage, entity);
    }
    */

    @Override
    public String getArmorTexture(ItemStack stack, Entity entity, EntityEquipmentSlot slot, String type) {
        if (stack.getItem() == ModItems.OrganizationRobe_Leggings)
            return Reference.MODID + ":textures/armour/organizationrobe_2.png";
        else
            return Reference.MODID + ":textures/armour/organizationrobe_1.png";
    }

    @Override
    public CreativeTabs[] getCreativeTabs () {
        return new CreativeTabs[] { ModItems.tabKingdomKeys };
    }

    @Override
    public boolean getIsRepairable (ItemStack armor, ItemStack stack) {
        return stack.getItem() == ModItems.DarkLeather;
    }

}
