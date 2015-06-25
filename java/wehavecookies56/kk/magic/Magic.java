package wehavecookies56.kk.magic;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntitySmallFireball;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;

public class Magic {

	public static void Fire(EntityPlayer par1EntityPlayer, World par2World){
		EntityPlayer player = (EntityPlayer) par1EntityPlayer;
		//Magic execution
		//System.out.println(currMagic);
		//MagicAttack.currMagic = 100;
		//if player's magic (has to be checked form the extended properties)
	//	if(MagicAttack.currMagic >= fireCost && KeyBind.submenu == 1)
		{
			Vec3 look = player.getLookVec();
			EntitySmallFireball fireball = new EntitySmallFireball(MinecraftServer.getServer().getEntityWorld(), player, 0, 0, 0);
			fireball.setPosition(player.posX + look.xCoord * 2, player.posY + look.yCoord, player.posZ + look.zCoord * 2);
			fireball.accelerationX = look.xCoord * 0.1;
			fireball.accelerationY = look.yCoord * 0.1;
			fireball.accelerationZ = look.zCoord * 0.1;
			MinecraftServer.getServer().getEntityWorld().spawnEntityInWorld(fireball);
			//MagicAttack.currMagic = MagicAttack.currMagic - MagicAttack.fireCost;			
		}
	}
}
