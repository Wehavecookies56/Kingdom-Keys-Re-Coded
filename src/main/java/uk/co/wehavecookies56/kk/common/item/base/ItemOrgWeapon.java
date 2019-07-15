package uk.co.wehavecookies56.kk.common.item.base;

import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import uk.co.wehavecookies56.kk.api.menu.IItemCategory;
import uk.co.wehavecookies56.kk.api.menu.ItemCategory;
import uk.co.wehavecookies56.kk.common.item.ModItems;
import uk.co.wehavecookies56.kk.common.item.org.IOrgWeapon;
import uk.co.wehavecookies56.kk.common.util.Utils;

public class ItemOrgWeapon extends ItemSword implements IOrgWeapon, IItemCategory {
    double magic, strength;
    public String description;
    double speed = 1.0;

    public ItemOrgWeapon (String name, double[] stats) {
        super(EnumHelper.addToolMaterial("ORGWEAPON", -4, -1, 0, 0, 20));
        setRegistryName(name);
        setTranslationKey(name);
        setCreativeTab(ModItems.tabKingdomKeys);
        this.strength = stats[0];
        this.magic = stats[1];
        setMaxStackSize(1);
    }

    @Override
    public double getStrength() {
        return this.strength;
    }

    @Override
    public double getMagic() {
        return this.magic;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public void setMagic(int magic) {
        this.magic = magic;
    }

    @Override
    public void setDescription(String description) {
        this.description = description;
    }

    @Override
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

    @Override
    public Utils.OrgMember getMember() {
        return Utils.OrgMember.NONE;
    }

    @Override
    public Item getItem() {
        return this;
    }

	@Override
	public ItemCategory getCategory() {
		return ItemCategory.TOOL;
	}
}
