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
import wehavecookies56.kk.entities.magic.EntityFire2;
import wehavecookies56.kk.entities.magic.EntityStop;
import wehavecookies56.kk.entities.magic.EntityThunder;
import wehavecookies56.kk.network.packet.PacketDispatcher;
import wehavecookies56.kk.network.packet.server.MagicAero;
import wehavecookies56.kk.network.packet.server.MagicBlizzard;
import wehavecookies56.kk.network.packet.server.MagicCure;
import wehavecookies56.kk.network.packet.server.MagicFire;
import wehavecookies56.kk.network.packet.server.MagicStop;
import wehavecookies56.kk.network.packet.server.MagicThunder;

public class Magic {

	public static int getMagicCost(String magic)
	{
		int cost=0;
		if(ExtendedPlayer.get(Minecraft.getMinecraft().thePlayer).cheatMode == false)
		{
			if(magic == "fire")
				cost = 20;
			if(magic == "blizzard")
				cost = 15;
			if(magic == "thunder")
				cost = 30;
			if(magic == "cure")
				cost = ExtendedPlayer.get(Minecraft.getMinecraft().thePlayer).getMp();
			if(magic == "gravity")
				cost = 25;
			if(magic == "aero")
				cost = 20;
			if(magic == "stop")
				cost = 10;
		}
		else
		{
			cost = 0;
		}
		return cost;
	}

	public static void Fire(EntityPlayer player, World world)
	{
		if(ExtendedPlayer.get(player).getMp() > 0)
		{
			PacketDispatcher.sendToServer(new MagicFire());
			world.spawnEntityInWorld(new EntityFire2(world, player, player.posX, player.posY, player.posZ));
			player.swingItem();
			world.playSoundAtEntity(player, "fire.ignite", 1, 1);
		}
	}

	public static void Aero(EntityPlayer player, World world)
	{
		if(ExtendedPlayer.get(player).getMp() > 0)
		{
			PacketDispatcher.sendToServer(new MagicAero());
			world.spawnEntityInWorld(new EntityAero(world, player, player.posX, player.posY, player.posZ));
			player.swingItem();
			world.playSoundAtEntity(player, "fire.ignite", 1, 1);
		}
	}

	public static void Blizzard(EntityPlayer player, World world){
		if(ExtendedPlayer.get(player).getMp() > 0)
		{
			Vec3 look = player.getLookVec();
			world.spawnEntityInWorld(new EntityBlizzard(world, player));
			PacketDispatcher.sendToServer(new MagicBlizzard());
			if(FMLCommonHandler.instance().getSide() == Side.SERVER){
				PacketDispatcher.sendToDimension(new MagicBlizzard(), world.provider.getDimensionId());
			}
		}
	}
	public static void Stop(EntityPlayer player, World world)
	{
		if(ExtendedPlayer.get(player).getMp() > 0)
		{
			PacketDispatcher.sendToServer(new MagicStop());
			world.spawnEntityInWorld(new EntityStop(world, player, player.posX, player.posY, player.posZ));
			player.swingItem();
			world.playSoundAtEntity(player, "fire.ignite", 1, 1);
		}
	}

	public static void Thunder(EntityPlayer player, World world)
	{
		if(ExtendedPlayer.get(player).getMp() > 0)
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
	}

	public static void Cure(EntityPlayer player, World world)
	{
		if(ExtendedPlayer.get(player).getMp() > 0)
		{
			player.heal(6);
			PacketDispatcher.sendToServer(new MagicCure());
		}
	}
}
