package wehavecookies56.kk.item;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraftforge.common.ISpecialArmor;
import wehavecookies56.kk.lib.Reference;

public class ItemTerraArmor extends ItemArmor implements ISpecialArmor {

	public ItemTerraArmor (ArmorMaterial material, int renderIndex, int armorType, String name) {
		super(material, renderIndex, armorType);
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
	public String getArmorTexture (ItemStack armor, Entity entity, int slot, String type) {
		if (armor.getItem() == ModItems.Terra_Leggings)
			return Reference.MODID + ":textures/armour/terra_2.png";
		else
			return Reference.MODID + ":textures/armour/terra_1.png";
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
