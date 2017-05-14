package uk.co.wehavecookies56.kk.common.item.base;

import java.util.List;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.world.World;
import uk.co.wehavecookies56.kk.common.capability.ModCapabilities;
import uk.co.wehavecookies56.kk.common.core.handler.ConfigHandler;
import uk.co.wehavecookies56.kk.common.entity.magic.DamageCalculation;

public class ItemRealKeyblade extends ItemKeyblade {

	public ItemRealKeyblade (double strength, double magic) {
		super(strength, magic);
		setMaxStackSize(1);
	}
/*
    @Override
	public ActionResult<ItemStack> onItemRightClick(ItemStack itemStackIn, World worldIn, EntityPlayer player, EnumHand hand)
	{
    	
		if (!(player.getHeldItem(EnumHand.OFF_HAND) != null && player.getHeldItem(EnumHand.OFF_HAND).getItem() instanceof ItemKeyblade)) 
		{

			double posX = player.getPosition().getX();
			double posZ = player.getPosition().getZ();
			double distance = 3.0D;
			//System.out.println(FMLCommonHandler.instance().getEffectiveSide());
			AxisAlignedBB aabb = player.getEntityBoundingBox().expand(2, 2, 2);
			List list = worldIn.getEntitiesWithinAABBExcludingEntity(player, aabb);
			if(player.onGround)
			{
				//System.out.println(player.rotationYaw);
				if (!list.isEmpty()) for (int i = 0; i < list.size(); i++) {
					Entity e = (Entity) list.get(i);
					if (e instanceof EntityLivingBase) {
						player.swingArm(hand);
						e.motionY=1.15;
						e.attackEntityFrom(DamageSource.magic, 1);
						player.motionY = 1.15;	
					}
				}
			}
			else
			{
				if (!list.isEmpty()) for (int i = 0; i < list.size(); i++) {
					Entity e = (Entity) list.get(i);
					if (e instanceof EntityLivingBase) 
					{
						double d = e.posX - posX;
						double d1;
						for (d1 = e.posZ - posZ; d * d + d1 * d1 < 0.0001D; d1 = (Math.random() - Math.random()) * 0.01D)
							d = (Math.random() - Math.random()) * 0.01D;
						((EntityLivingBase) e).knockBack(e, 1, -d, -d1);
						e.motionY*=1.15;
						e.attackEntityFrom(DamageSource.causePlayerDamage(player), (float) DamageCalculation.getStrengthDamage(player, (ItemKeyblade) player.getHeldItem(EnumHand.MAIN_HAND).getItem()));
						System.out.println(DamageCalculation.getStrengthDamage(player, (ItemKeyblade) player.getHeldItem(EnumHand.MAIN_HAND).getItem()));
					}
				}
			}
			aabb.expand(-2, -2, -2);
		}
		return super.onItemRightClick(itemStackIn, worldIn, player, hand);
			
	}
	*/
}
