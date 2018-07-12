package uk.co.wehavecookies56.kk.common.item.org;

import java.util.List;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import uk.co.wehavecookies56.kk.common.entity.projectiles.EntityRock;
import uk.co.wehavecookies56.kk.common.item.base.ItemOrgWeapon;
import uk.co.wehavecookies56.kk.common.util.Utils;
import uk.co.wehavecookies56.kk.common.util.Utils.OrgMember;

public class ItemAxeSword extends ItemOrgWeapon implements IOrgWeapon{

    public ItemAxeSword (String name, double[] stats)  {
        super(name, stats);
        setMaxStackSize(1);
    }

    @Override
    @SideOnly (Side.CLIENT)
    public EnumRarity getRarity (ItemStack par1ItemStack) {
        return EnumRarity.UNCOMMON;
    }
    
    @Override
    public ActionResult<ItemStack> onItemRightClick(World world, EntityPlayer player, EnumHand hand) {
    	if(!world.isRemote) {
	        if (!player.isSneaking()) {
	        	//EntityShockwave shockwave = new EntityShockwave(world,player,player.posX,player.posY,player.posZ);
	        	//world.spawnEntity(shockwave);
	        	
	        	byte radius = 2; 
	            AxisAlignedBB originalAABB = player.getEntityBoundingBox();
	            AxisAlignedBB aabb = originalAABB.grow(radius, radius, radius);
	            List list = world.getEntitiesWithinAABBExcludingEntity(player, aabb);
	            if (!list.isEmpty())
	            	for (int i = 0; i < list.size(); i++) {
	                Entity e = (Entity) list.get(i);
	                if (e instanceof EntityLivingBase) {
	                	EntityRock rock = new EntityRock(world, player, (EntityLivingBase) e, e.posX,e.posY-1,e.posZ);
	                	world.spawnEntity(rock);
	                	//System.out.println(e);
	                	/*if(player.getHeldItemMainhand() != null)
	                		e.attackEntityFrom(DamageSource.causePlayerDamage(player), DamageCalculation.getOrgStrengthDamage(player,player.getHeldItemMainhand())/2);//*DamageCalculation.aeroMultiplier);
	                    double d = e.posX - posX;
	                    double d1;
	                    for (d1 = e.posZ - posZ; d * d + d1 * d1 < 0.0001D; d1 = (Math.random() - Math.random()) * 0.01D)
	                        d = (Math.random() - Math.random()) * 0.01D;
	                    ((EntityLivingBase) e).knockBack(e, 2, -d, -d1);
	                    e.motionY*=1.2;*/
	                }
	            }
	        }
    	}
		return super.onItemRightClick(world, player, hand);
    }

    @Override
    public OrgMember getMember() {
        return Utils.OrgMember.LEXAEUS;
    }
}
