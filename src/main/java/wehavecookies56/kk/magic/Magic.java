package wehavecookies56.kk.magic;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntitySnowball;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;
import wehavecookies56.kk.entities.magic.EntityFire;
import wehavecookies56.kk.entities.magic.EntityIce;
import wehavecookies56.kk.entities.magic.EntityThunder;

public class Magic {

	public static void Fire(EntityPlayer par1EntityPlayer, World world)
	{
		EntityPlayer player = (EntityPlayer) par1EntityPlayer;
		//Magic execution
		//if player's magic (has to be checked form the extended properties)
	//	if(MagicAttack.currMagic >= fireCost && KeyBind.submenu == 1)
		{
			world.spawnEntityInWorld(new EntityFire(world, player));
			System.out.println("Fire");
			//MagicAttack.currMagic = MagicAttack.currMagic - MagicAttack.fireCost;			
		}
	}
	
	public static void Ice(EntityPlayer par1EntityPlayer, World world)
	{
		EntityPlayer player = (EntityPlayer) par1EntityPlayer;
		//Magic execution
		//if player's magic (has to be checked form the extended properties)
	//	if(MagicAttack.currMagic >= fireCost && KeyBind.submenu == 1)
		{
			Vec3 look = player.getLookVec();
			world.spawnEntityInWorld(new EntityIce(world, player));		
			//MagicAttack.currMagic = MagicAttack.currMagic - MagicAttack.blizzardCost;			
		}
	}
	
	public static void Thunder(EntityPlayer par1EntityPlayer, World world)
	{
		EntityPlayer player = (EntityPlayer) par1EntityPlayer;
		double posy = player.posY;
		if(!player.onGround)
		{
			//something to figure out the player position
		}
		
		EntityThunder thunder;
		thunder = new EntityThunder(world, player.posX+2, player.posY, player.posZ);
		world.spawnEntityInWorld(thunder);
		thunder = new EntityThunder(world, player.posX, player.posY, player.posZ+2);
		world.spawnEntityInWorld(thunder);
		thunder = new EntityThunder(world, player.posX-2, player.posY, player.posZ);
		world.spawnEntityInWorld(thunder);
		thunder = new EntityThunder(world, player.posX, player.posY, player.posZ-2);
		world.spawnEntityInWorld(thunder);
		
		thunder = new EntityThunder(world, player.posX+2, player.posY, player.posZ+2);
		world.spawnEntityInWorld(thunder);
		thunder = new EntityThunder(world, player.posX+2, player.posY, player.posZ+2);
		world.spawnEntityInWorld(thunder);
		thunder = new EntityThunder(world, player.posX-2, player.posY, player.posZ-2);
		world.spawnEntityInWorld(thunder);
		thunder = new EntityThunder(world, player.posX-2, player.posY, player.posZ-2);
		world.spawnEntityInWorld(thunder);
	}
}
