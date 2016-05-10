package uk.co.wehavecookies56.kk.common.item;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.common.ISpecialArmor;
import uk.co.wehavecookies56.kk.common.lib.Reference;

public class ItemAquaArmor extends ItemArmor implements ISpecialArmor {

	public ItemAquaArmor (ArmorMaterial material, int renderIndex, EntityEquipmentSlot slot, int armorType, String name) {
		super(material, renderIndex, slot);
		setUnlocalizedName(name);
	}

	@Override
	public ArmorProperties getProperties (EntityLivingBase player, ItemStack armor, DamageSource source, double damage, int slot) {
		if (source == DamageSource.inFire || source == DamageSource.lava || source == DamageSource.onFire) return new ArmorProperties(1, 1, MathHelper.floor_double(damage * .25D));
		return new ArmorProperties(0, 0, 0);
	}

	@Override
	public int getArmorDisplay (EntityPlayer player, ItemStack armor, int slot) {
		return 4;
	}

	@Override
	public void damageArmor (EntityLivingBase entity, ItemStack stack, DamageSource source, int damage, int slot) {
		stack.damageItem(damage * 2, entity);
	}
	
	@Override
	public String getArmorTexture(ItemStack stack, Entity entity, EntityEquipmentSlot slot, String type) {
		if (stack.getItem() == ModItems.Aqua_Leggings)
			return Reference.MODID + ":textures/armour/aqua_2.png";
		else
			return Reference.MODID + ":textures/armour/aqua_1.png";
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
