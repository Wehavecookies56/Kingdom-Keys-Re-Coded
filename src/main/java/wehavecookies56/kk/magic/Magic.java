package wehavecookies56.kk.magic;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.relauncher.Side;
import wehavecookies56.kk.entities.magic.EntityAero;
import wehavecookies56.kk.entities.magic.EntityFire2;
import wehavecookies56.kk.entities.magic.EntityIce;
import wehavecookies56.kk.entities.magic.EntityThunder;
import wehavecookies56.kk.network.packet.PacketDispatcher;
import wehavecookies56.kk.network.packet.server.MagicAero;
import wehavecookies56.kk.network.packet.server.MagicBlizzard;
import wehavecookies56.kk.network.packet.server.MagicCure;
import wehavecookies56.kk.network.packet.server.MagicFire;
import wehavecookies56.kk.network.packet.server.MagicThunder;

public class Magic {

	public static void Fire(EntityPlayer player, World world)
	{
		PacketDispatcher.sendToServer(new MagicFire());
		world.spawnEntityInWorld(new EntityFire2(world, player, player.posX, player.posY, player.posZ));
		player.swingItem();
		world.playSoundAtEntity(player, "fire.ignite", 1, 1);
	}

	public static void Aero(EntityPlayer player, World world)
	{
		PacketDispatcher.sendToServer(new MagicAero());
		world.spawnEntityInWorld(new EntityAero(world, player, player.posX, player.posY, player.posZ));
		player.swingItem();
		world.playSoundAtEntity(player, "fire.ignite", 1, 1);
	}

	public static void Ice(EntityPlayer player, World world)
	{
		//Magic execution
		//if player's magic (has to be checked form the extended properties)
	//	if(MagicAttack.currMagic >= fireCost && KeyBind.submenu == 1)
		{
			Vec3 look = player.getLookVec();
			world.spawnEntityInWorld(new EntityIce(world, player));
			PacketDispatcher.sendToServer(new MagicBlizzard());
			if(FMLCommonHandler.instance().getSide() == Side.SERVER){
				PacketDispatcher.sendToDimension(new MagicBlizzard(), world.provider.getDimensionId());
			}
			//MagicAttack.currMagic = MagicAttack.currMagic - MagicAttack.blizzardCost;
		}
	}

	public static void Thunder(EntityPlayer player, World world)
	{
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
		PacketDispatcher.sendToServer(new MagicThunder());
	}

	public static void Cure(EntityPlayer player, World world)
	{
		player.heal(6);
		PacketDispatcher.sendToServer(new MagicCure());
	}
}
