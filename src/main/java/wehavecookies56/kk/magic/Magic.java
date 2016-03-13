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
import wehavecookies56.kk.entities.magic.EntityBlizzaga;
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
import wehavecookies56.kk.network.packet.client.SpawnBlizzardParticles;
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
		PacketDispatcher.sendToServer(new MagicFire());
		player.swingItem();
		Minecraft.getMinecraft().theWorld.playSound(Minecraft.getMinecraft().thePlayer.posX, Minecraft.getMinecraft().thePlayer.posY, Minecraft.getMinecraft().thePlayer.posZ, "fire.fire", 5f, 0.5f, false);
	}

	public static void Blizzard (EntityPlayer player, World world) {
		PacketDispatcher.sendToServer(new MagicBlizzard());
		player.swingItem();
		//if (FMLCommonHandler.instance().getSide() == Side.SERVER) PacketDispatcher.sendToDimension(new MagicBlizzard(), world.provider.getDimensionId());
	}

	public static void Thunder (EntityPlayer player, World world) {
		PacketDispatcher.sendToServer(new MagicThunder());
		player.swingItem();
	}

	public static void Cure (EntityPlayer player, World world) {
		PacketDispatcher.sendToServer(new MagicCure());
		player.swingItem();

	}

	public static void Aero (EntityPlayer player, World world) {
		PacketDispatcher.sendToServer(new MagicAero());
		player.swingItem();
		world.playSoundAtEntity(player, "fire.ignite", 1, 1);
	}

	public static void Stop (EntityPlayer player, World world) {
		PacketDispatcher.sendToServer(new MagicStop());
		player.swingItem();
		world.playSoundAtEntity(player, "fire.ignite", 1, 1);
	}
}
