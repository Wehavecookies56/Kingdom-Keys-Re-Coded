package wehavecookies56.kk.item.org;

import java.util.List;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import wehavecookies56.kk.entities.projectiles.EntitySharpshooterBullet;

public class ItemSharpshooter extends ItemSword{
	int strength = 6;
	public ItemSharpshooter(ToolMaterial material) {
		super(material);
		this.setMaxStackSize(1);
	}
	@Override
    @SideOnly(Side.CLIENT)
    public EnumRarity getRarity(ItemStack par1ItemStack){
        return EnumRarity.UNCOMMON;
    }
    
	public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player) {
		strength = -(strength)+71999;
		if (!player.isSneaking())
		{
			//TODO set strength
			
			world.playSoundAtEntity(player, "mob.ghast.fireball", 0.5F, 0.4F / (itemRand.nextFloat() * 0.4F + 0.8F));
			//if (!world.isRemote)
			{
				world.spawnEntityInWorld(new EntitySharpshooterBullet(world, player, strength));
				player.swingItem();
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
		dataList.add("II Xigbar");
	}
}
