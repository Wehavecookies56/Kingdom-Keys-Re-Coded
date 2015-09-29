package wehavecookies56.kk.item.org;

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
	int strength;
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
    public boolean hitEntity(ItemStack item, EntityLivingBase entity,
    		EntityLivingBase p_77644_3_) {
    	entity.setFire(5);
    	return super.hitEntity(item, entity, p_77644_3_);
    }
	
    public void onPlayerStoppedUsing(ItemStack stack, World world, EntityPlayer player, int timeLeft)
    {
    	this.strength = timeLeft;
    	if (!player.isSneaking())
		{
			//TODO set strength
			
			world.playSoundAtEntity(player, "mob.ghast.fireball", 0.5F, 0.4F / (itemRand.nextFloat() * 0.4F + 0.8F));
			//if (!world.isRemote)
			{
				world.spawnEntityInWorld(new EntityEternalFlamesProjectile(world, player, -(strength)+71999));
				player.swingItem();
			}
		}
		else
		{
			player.setItemInUse(stack, this.getMaxItemUseDuration(stack));
		}
    }
    
	public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player) {
		/*if (!player.isSneaking())
		{
			//TODO set strength
			
			world.playSoundAtEntity(player, "mob.ghast.fireball", 0.5F, 0.4F / (itemRand.nextFloat() * 0.4F + 0.8F));
			//if (!world.isRemote)
			{
				world.spawnEntityInWorld(new EntityEternalFlamesProjectile(world, player, strength));
				player.swingItem();
			}
		}
		else
		{
			player.setItemInUse(stack, this.getMaxItemUseDuration(stack));
	        return stack;
		}
		*/
        player.setItemInUse(stack, this.getMaxItemUseDuration(stack));

	return stack;
	}
	
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack itemStack, EntityPlayer player, List dataList, boolean bool){
		dataList.add("VIII Axel");
	}
}