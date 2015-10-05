package wehavecookies56.kk.magic;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.relauncher.Side;
import wehavecookies56.kk.entities.ExtendedPlayer;
import wehavecookies56.kk.entities.magic.EntityAero;
import wehavecookies56.kk.entities.magic.EntityBlizzard;
import wehavecookies56.kk.entities.magic.EntityCure;
import wehavecookies56.kk.entities.magic.EntityFire2;
import wehavecookies56.kk.entities.magic.EntityStop;
import wehavecookies56.kk.entities.magic.EntityThunder;
import wehavecookies56.kk.network.packet.PacketDispatcher;
import wehavecookies56.kk.network.packet.server.magics.MagicAero;
import wehavecookies56.kk.network.packet.server.magics.MagicBlizzard;
import wehavecookies56.kk.network.packet.server.magics.MagicCure;
import wehavecookies56.kk.network.packet.server.magics.MagicFire;
import wehavecookies56.kk.network.packet.server.magics.MagicStop;
import wehavecookies56.kk.network.packet.server.magics.MagicThunder;

public class Magic {

	public static double getMagicCost(String magic, EntityPlayer player)
	{
		double cost=0;
		if(ExtendedPlayer.get(player).cheatMode)
		{
			cost = 0;
		}
		return cost;
	}//Test to sync

	public static void Fire(EntityPlayer player, World world)
	{
		switch(ExtendedPlayer.get(player).getMagicLevel("Fire"))
		{
			case 1:
				PacketDispatcher.sendToServer(new MagicFire());
				world.spawnEntityInWorld(new EntityFire2(world, player, player.posX, player.posY, player.posZ, 1));
				player.swingItem();
				world.playSoundAtEntity(player, "fire.ignite", 1, 1);
			break;
			
			case 2:
				System.out.println("Fira");
			break;
			case 3:
				System.out.println("Firaga");
			break;
		}
	}

	public static void Blizzard(EntityPlayer player, World world)
	{
		switch(ExtendedPlayer.get(player).getMagicLevel("Blizzard"))
		{
			case 1:
				Vec3 look = player.getLookVec();
				world.spawnEntityInWorld(new EntityBlizzard(world, player));
				PacketDispatcher.sendToServer(new MagicBlizzard());
				if(FMLCommonHandler.instance().getSide() == Side.SERVER){
					PacketDispatcher.sendToDimension(new MagicBlizzard(), world.provider.getDimensionId());
				}
			break;
			
			case 2:
				System.out.println("Fira");
			break;
			case 3:
				System.out.println("Firaga");
			break;
		}	
	}

	public static void Thunder(EntityPlayer player, World world)
	{
		switch(ExtendedPlayer.get(player).getMagicLevel("Thunder"))
		{
			case 1:
				PacketDispatcher.sendToServer(new MagicThunder());
				world.spawnEntityInWorld(new EntityThunder(world, player, player.posX, player.posY, player.posZ));
				player.swingItem();
			break;
			
			case 2:
				System.out.println("Fira");
			break;
			case 3:
				System.out.println("Firaga");
			break;
		}	
	}

	public static void Cure(EntityPlayer player, World world)
	{
		switch(ExtendedPlayer.get(player).getMagicLevel("Cure"))
		{
			case 1:
				world.spawnEntityInWorld(new EntityCure(world, player, player.posX, player.posY, player.posZ));
				player.heal(6);
				PacketDispatcher.sendToServer(new MagicCure());
			break;
			
			case 2:
				System.out.println("Fira");
			break;
			case 3:
				System.out.println("Firaga");
			break;
		}	
	}
	
	public static void Aero(EntityPlayer player, World world)
	{
		switch(ExtendedPlayer.get(player).getMagicLevel("Aero"))
		{
			case 1:
				PacketDispatcher.sendToServer(new MagicAero());
				world.spawnEntityInWorld(new EntityAero(world, player, player.posX, player.posY, player.posZ));
				player.swingItem();
				world.playSoundAtEntity(player, "fire.ignite", 1, 1);
			break;
			
			case 2:
				System.out.println("Fira");
			break;
			case 3:
				System.out.println("Firaga");
			break;
		}	
	}
	
	public static void Stop(EntityPlayer player, World world)
	{
		switch(ExtendedPlayer.get(player).getMagicLevel("Stop"))
		{
			case 1:
				PacketDispatcher.sendToServer(new MagicStop());
				world.spawnEntityInWorld(new EntityStop(world, player, player.posX, player.posY, player.posZ));
				player.swingItem();
				world.playSoundAtEntity(player, "fire.ignite", 1, 1);
			break;
			case 2:
				System.out.println("Fira");
			break;
			case 3:
				System.out.println("Firaga");
			break;
		}	
		
	}
}
