package wehavecookies56.kk.item;

import java.util.List;

import wehavecookies56.kk.entities.projectiles.EntityEternalFlamesProjectile;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemEternalFlames extends ItemSword{
	protected final ToolMaterial material;
	public ItemEternalFlames(ToolMaterial abaddonPlasmaMaterial) {
		super(abaddonPlasmaMaterial);
		this.material = abaddonPlasmaMaterial;
	}

	public ToolMaterial getMaterial() {
		return this.material;
	}
    
    @Override
    @SideOnly(Side.CLIENT)
    public EnumRarity getRarity(ItemStack par1ItemStack){
        return EnumRarity.UNCOMMON;
    }

    @Override
    public boolean hitEntity(ItemStack p_77644_1_, EntityLivingBase p_77644_2_,
    		EntityLivingBase p_77644_3_) {
    	p_77644_2_.setFire(5);
    	return super.hitEntity(p_77644_1_, p_77644_2_, p_77644_3_);
    }
	
	public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player) {
		if (!player.isSneaking())
		{
			world.playSoundAtEntity(player, "mob.ghast.fireball", 0.5F, 0.4F / (itemRand.nextFloat() * 0.4F + 0.8F));
			if (!world.isRemote)
			{
				world.spawnEntityInWorld(new EntityEternalFlamesProjectile(world, player));
			}
		}
		else
		{
			player.setItemInUse(stack, this.getMaxItemUseDuration(stack));
	        return stack;
		}
		
		
	return stack;
	}
	
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack itemStack, EntityPlayer player, List dataList, boolean bool){
		dataList.add("VIII Axel");
	}
}