package wehavecookies56.kk.item;

import net.minecraft.entity.Entity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.common.util.EnumHelper;
import wehavecookies56.kk.entities.EntityItemMetalChocobo;
import wehavecookies56.kk.lib.Config;
import wehavecookies56.kk.lib.Strings;

public class ItemMetalChocobo extends ItemKeyblade {

	public ItemMetalChocobo(ToolMaterial material) {
		super(material);
	}

	@Override
	public boolean hasCustomEntity(ItemStack stack) {
		return true;
	}

	@Override
	public Entity createEntity(World world, Entity location, ItemStack itemstack) {
		return new EntityItemMetalChocobo(world, location.posX, location.posY, location.posZ, itemstack);
	}

}
