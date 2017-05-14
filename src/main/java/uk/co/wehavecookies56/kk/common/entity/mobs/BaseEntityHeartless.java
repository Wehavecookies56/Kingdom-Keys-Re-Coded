package uk.co.wehavecookies56.kk.common.entity.mobs;

import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EntityDamageSource;
import net.minecraft.world.World;
import uk.co.wehavecookies56.kk.common.item.base.ItemOrgWeapon;
import uk.co.wehavecookies56.kk.common.item.base.ItemRealKeyblade;

public class BaseEntityHeartless extends EntityMob{

	public BaseEntityHeartless(World worldIn) {
		super(worldIn);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public boolean attackEntityFrom(DamageSource source, float amount){
		if (source instanceof EntityDamageSource){
			EntityDamageSource eds = (EntityDamageSource) source;
			if (eds.getDamageType().equals("player") && eds.getEntity() instanceof EntityPlayer){
				EntityPlayer player = (EntityPlayer) eds.getEntity();
				
				if(player.getHeldItemMainhand() != null){
					
					if(!(player.getHeldItemMainhand().getItem() instanceof ItemRealKeyblade) && !(player.getHeldItemMainhand().getItem() instanceof ItemOrgWeapon)){
						return false;
					}else{
						return super.attackEntityFrom(source, amount);
					}
				}
			}
			
		}
		return super.attackEntityFrom(source, amount);
	}

}
