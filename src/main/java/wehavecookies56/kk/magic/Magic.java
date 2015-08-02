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
import wehavecookies56.kk.network.packet.server.MagicAero;
import wehavecookies56.kk.network.packet.server.MagicBlizzard;
import wehavecookies56.kk.network.packet.server.MagicCure;
import wehavecookies56.kk.network.packet.server.MagicFire;
import wehavecookies56.kk.network.packet.server.MagicStop;
import wehavecookies56.kk.network.packet.server.MagicThunder;

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
		PacketDispatcher.sendToServer(new MagicStop());
		world.spawnEntityInWorld(new EntityStop(world, player, player.posX, player.posY, player.posZ));
		player.swingItem();
		world.playSoundAtEntity(player, "fire.ignite", 1, 1);
	}

	public static void Thunder(EntityPlayer player, World world)
	{
		PacketDispatcher.sendToServer(new MagicThunder());
		world.spawnEntityInWorld(new EntityThunder(world, player, player.posX, player.posY, player.posZ));
		player.swingItem();
	}

	public static void Cure(EntityPlayer player, World world)
	{
		world.spawnEntityInWorld(new EntityCure(world, player, player.posX, player.posY, player.posZ));
		player.heal(6);
		PacketDispatcher.sendToServer(new MagicCure());
	}
}
