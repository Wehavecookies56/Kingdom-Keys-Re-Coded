package uk.co.wehavecookies56.kk.common.item;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import uk.co.wehavecookies56.kk.common.lib.Reference;

public class ItemOrganizationRobe extends ItemArmor /*implements ISpecialArmor*/ {

	String armorName;
    public ItemOrganizationRobe (ArmorMaterial material, int renderIndex, EntityEquipmentSlot slot, int armorType, String name) {
        super(material, renderIndex, slot);
        this.armorName = name.substring(0,name.indexOf("_"));
        setRegistryName(name);
        setUnlocalizedName(name);
        setCreativeTab(ModItems.tabKingdomKeys);
    }

    @Override
    public String getArmorTexture(ItemStack stack, Entity entity, EntityEquipmentSlot slot, String type) {
    	//System.out.println(armorName);
        if (slot == EntityEquipmentSlot.LEGS)
            return Reference.MODID + ":textures/armour/"+armorName+"_2.png";
        else
            return Reference.MODID + ":textures/armour/"+armorName+"_1.png";
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
