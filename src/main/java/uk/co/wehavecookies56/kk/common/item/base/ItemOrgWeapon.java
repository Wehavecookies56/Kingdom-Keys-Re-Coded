package uk.co.wehavecookies56.kk.common.item.base;

import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import uk.co.wehavecookies56.kk.common.item.ModItems;

public class ItemOrgWeapon extends ItemSword{
    double magic, strength;
    public String description;
    double speed = 1.0;

    public ItemOrgWeapon (String name, double strength, double magic) {
        super(EnumHelper.addToolMaterial("ORGWEAPON", -4, -1, 0, 0, 20));
        setRegistryName(name);
        setUnlocalizedName(name);
        setCreativeTab(ModItems.tabKingdomKeys);
        this.magic = magic;
        this.strength = strength;
        setMaxStackSize(1);
    }
    public double getStrength() {
        return this.strength;
    }

    public double getMagic() {
        return this.magic;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public void setMagic(int magic) {
        this.magic = magic;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    @Override
    @SideOnly (Side.CLIENT)
    public EnumRarity getRarity (ItemStack par1ItemStack) {
        return EnumRarity.UNCOMMON;
    }

}
