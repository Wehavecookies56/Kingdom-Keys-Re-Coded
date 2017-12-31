package uk.co.wehavecookies56.kk.common.item.org;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import uk.co.wehavecookies56.kk.common.entity.projectiles.EntityShockwave;
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
	        	EntityShockwave shockwave = new EntityShockwave(world,player,player.posX,player.posY,player.posZ);
	        	world.spawnEntity(shockwave);
	        }
    	}
		return super.onItemRightClick(world, player, hand);
    }

    @Override
    public OrgMember getMember() {
        return Utils.OrgMember.LEXAEUS;
    }
}
