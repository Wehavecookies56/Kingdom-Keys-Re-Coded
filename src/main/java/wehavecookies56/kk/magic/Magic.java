package wehavecookies56.kk.magic;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.relauncher.Side;
import wehavecookies56.kk.entities.ExtendedPlayer;
import wehavecookies56.kk.entities.magic.EntityAero;
import wehavecookies56.kk.entities.magic.EntityAeroga;
import wehavecookies56.kk.entities.magic.EntityAerora;
import wehavecookies56.kk.entities.magic.EntityBlizzard;
import wehavecookies56.kk.entities.magic.EntityCura;
import wehavecookies56.kk.entities.magic.EntityCuraga;
import wehavecookies56.kk.entities.magic.EntityCure;
import wehavecookies56.kk.entities.magic.EntityFira;
import wehavecookies56.kk.entities.magic.EntityFiraga;
import wehavecookies56.kk.entities.magic.EntityFire;
import wehavecookies56.kk.entities.magic.EntityStop;
import wehavecookies56.kk.entities.magic.EntityStopga;
import wehavecookies56.kk.entities.magic.EntityStopra;
import wehavecookies56.kk.entities.magic.EntityThundaga;
import wehavecookies56.kk.entities.magic.EntityThundara;
import wehavecookies56.kk.entities.magic.EntityThunder;
import wehavecookies56.kk.lib.Strings;
import wehavecookies56.kk.network.packet.PacketDispatcher;
import wehavecookies56.kk.network.packet.server.magics.MagicAero;
import wehavecookies56.kk.network.packet.server.magics.MagicBlizzard;
import wehavecookies56.kk.network.packet.server.magics.MagicCure;
import wehavecookies56.kk.network.packet.server.magics.MagicFire;
import wehavecookies56.kk.network.packet.server.magics.MagicStop;
import wehavecookies56.kk.network.packet.server.magics.MagicThunder;

public class Magic {

	public static double getMagicCost (String magic, EntityPlayer player) {
		double cost = 0;
		if (ExtendedPlayer.get(player).cheatMode) cost = 0;
		return cost;
	}

	public static void getMagic (EntityPlayer player, World world, String magic) {
		switch (magic) {
			case Strings.Spell_Fire:
				Fire(player, world);
				break;
			case Strings.Spell_Blizzard:
				Blizzard(player, world);
				break;
			case Strings.Spell_Cure:
				Cure(player, world);
				break;
			case Strings.Spell_Thunder:
				Thunder(player, world);
				break;
			case Strings.Spell_Aero:
				Aero(player, world);
				break;
			case Strings.Spell_Stop:
				Stop(player, world);
				break;
			default:
				break;
		}
	}

	public static void Fire (EntityPlayer player, World world) {
		switch (ExtendedPlayer.get(player).getMagicLevel(Strings.Spell_Fire)) {
			case 1:
				PacketDispatcher.sendToServer(new MagicFire());
				world.spawnEntityInWorld(new EntityFire(world, player, player.posX, player.posY, player.posZ, 1));
				player.swingItem();
				Minecraft.getMinecraft().theWorld.playSound(Minecraft.getMinecraft().thePlayer.posX, Minecraft.getMinecraft().thePlayer.posY, Minecraft.getMinecraft().thePlayer.posZ, "fire.fire", 5f, 0.5f, false);
				break;
			case 2:
				PacketDispatcher.sendToServer(new MagicFire());
				world.spawnEntityInWorld(new EntityFira(world, player, player.posX, player.posY, player.posZ, 1));
				player.swingItem();
				Minecraft.getMinecraft().theWorld.playSound(Minecraft.getMinecraft().thePlayer.posX, Minecraft.getMinecraft().thePlayer.posY, Minecraft.getMinecraft().thePlayer.posZ, "fire.fire", 5f, 0.5f, false);
				break;
			case 3:
				PacketDispatcher.sendToServer(new MagicFire());
				world.spawnEntityInWorld(new EntityFiraga(world, player, player.posX, player.posY, player.posZ, 1));
				player.swingItem();
				Minecraft.getMinecraft().theWorld.playSound(Minecraft.getMinecraft().thePlayer.posX, Minecraft.getMinecraft().thePlayer.posY, Minecraft.getMinecraft().thePlayer.posZ, "fire.fire", 5f, 0.5f, false);
				break;
		}
	}

	public static void Blizzard (EntityPlayer player, World world) {
		Vec3 look;
		switch (ExtendedPlayer.get(player).getMagicLevel(Strings.Spell_Blizzard)) {
			case 1:
				look = player.getLookVec();
				world.spawnEntityInWorld(new EntityBlizzard(world, player));
				PacketDispatcher.sendToServer(new MagicBlizzard());
				if (FMLCommonHandler.instance().getSide() == Side.SERVER) PacketDispatcher.sendToDimension(new MagicBlizzard(), world.provider.getDimensionId());
				break;

			case 2:
				look = player.getLookVec();
				world.spawnEntityInWorld(new EntityBlizzard(world, player));
				PacketDispatcher.sendToServer(new MagicBlizzard());
				if (FMLCommonHandler.instance().getSide() == Side.SERVER) PacketDispatcher.sendToDimension(new MagicBlizzard(), world.provider.getDimensionId());
				break;
			case 3:
				look = player.getLookVec();
				world.spawnEntityInWorld(new EntityBlizzard(world, player));
				PacketDispatcher.sendToServer(new MagicBlizzard());
				if (FMLCommonHandler.instance().getSide() == Side.SERVER) PacketDispatcher.sendToDimension(new MagicBlizzard(), world.provider.getDimensionId());
				break;
		}
	}

	public static void Thunder (EntityPlayer player, World world) {
		switch (ExtendedPlayer.get(player).getMagicLevel(Strings.Spell_Thunder)) {
			case 1:
				PacketDispatcher.sendToServer(new MagicThunder());
				world.spawnEntityInWorld(new EntityThunder(world, player, player.posX, player.posY, player.posZ));
				player.swingItem();
				break;
			case 2:
				PacketDispatcher.sendToServer(new MagicThunder());
				world.spawnEntityInWorld(new EntityThundara(world, player, player.posX, player.posY, player.posZ));
				player.swingItem();
				break;
			case 3:
				PacketDispatcher.sendToServer(new MagicThunder());
				world.spawnEntityInWorld(new EntityThundaga(world, player, player.posX, player.posY, player.posZ));
				player.swingItem();
				break;
		}
	}

	public static void Cure (EntityPlayer player, World world) {
		switch (ExtendedPlayer.get(player).getMagicLevel(Strings.Spell_Cure)) {
			case 1:
				world.spawnEntityInWorld(new EntityCure(world, player, player.posX, player.posY, player.posZ));
				player.heal(6);
				PacketDispatcher.sendToServer(new MagicCure());
				break;
			case 2:
				world.spawnEntityInWorld(new EntityCura(world, player, player.posX, player.posY, player.posZ));
				player.heal(20);
				PacketDispatcher.sendToServer(new MagicCure());
				break;
			case 3:
				world.spawnEntityInWorld(new EntityCuraga(world, player, player.posX, player.posY, player.posZ));
				player.heal(80);
				PacketDispatcher.sendToServer(new MagicCure());
				break;
		}
	}

	public static void Aero (EntityPlayer player, World world) {
		switch (ExtendedPlayer.get(player).getMagicLevel(Strings.Spell_Aero)) {
			case 1:
				PacketDispatcher.sendToServer(new MagicAero());
				world.spawnEntityInWorld(new EntityAero(world, player, player.posX, player.posY, player.posZ));
				player.swingItem();
				world.playSoundAtEntity(player, "fire.ignite", 1, 1);
				break;

			case 2:
				PacketDispatcher.sendToServer(new MagicAero());
				world.spawnEntityInWorld(new EntityAerora(world, player, player.posX, player.posY, player.posZ));
				player.swingItem();
				world.playSoundAtEntity(player, "fire.ignite", 1, 1);
				break;
			case 3:
				PacketDispatcher.sendToServer(new MagicAero());
				world.spawnEntityInWorld(new EntityAeroga(world, player, player.posX, player.posY, player.posZ));
				player.swingItem();
				world.playSoundAtEntity(player, "fire.ignite", 1, 1);
				break;
		}
	}

	public static void Stop (EntityPlayer player, World world) {
		switch (ExtendedPlayer.get(player).getMagicLevel(Strings.Spell_Stop)) {
			case 1:
				PacketDispatcher.sendToServer(new MagicStop());
				world.spawnEntityInWorld(new EntityStop(world, player, player.posX, player.posY, player.posZ));
				player.swingItem();
				world.playSoundAtEntity(player, "fire.ignite", 1, 1);
				break;
			case 2:
				PacketDispatcher.sendToServer(new MagicStop());
				world.spawnEntityInWorld(new EntityStopra(world, player, player.posX, player.posY, player.posZ));
				player.swingItem();
				world.playSoundAtEntity(player, "fire.ignite", 1, 1);
				break;
			case 3:
				PacketDispatcher.sendToServer(new MagicStop());
				world.spawnEntityInWorld(new EntityStopga(world, player, player.posX, player.posY, player.posZ));
				player.swingItem();
				world.playSoundAtEntity(player, "fire.ignite", 1, 1);
				break;
		}

	}
}
