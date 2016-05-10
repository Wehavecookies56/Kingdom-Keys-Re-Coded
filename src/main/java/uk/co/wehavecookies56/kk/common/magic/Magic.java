package uk.co.wehavecookies56.kk.common.magic;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.SoundEvents;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundCategory;
import net.minecraft.world.World;
import uk.co.wehavecookies56.kk.common.capability.ModCapabilities;
import uk.co.wehavecookies56.kk.common.lib.Strings;
import uk.co.wehavecookies56.kk.common.network.packet.PacketDispatcher;
import uk.co.wehavecookies56.kk.common.network.packet.server.magics.MagicAero;
import uk.co.wehavecookies56.kk.common.network.packet.server.magics.MagicBlizzard;
import uk.co.wehavecookies56.kk.common.network.packet.server.magics.MagicCure;
import uk.co.wehavecookies56.kk.common.network.packet.server.magics.MagicFire;
import uk.co.wehavecookies56.kk.common.network.packet.server.magics.MagicStop;
import uk.co.wehavecookies56.kk.common.network.packet.server.magics.MagicThunder;

public class Magic {

	public static double getMagicCost (String magic, EntityPlayer player) {
		double cost = 0;
		if (player.getCapability(ModCapabilities.CHEAT_MODE, null).getCheatMode()) cost = 0;
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
		if(Minecraft.getMinecraft().thePlayer.getCapability(ModCapabilities.MAGIC_STATE, null).getKH1Fire())
			System.out.println("KH1");
		else
		{
			PacketDispatcher.sendToServer(new MagicFire());
			player.swingArm(EnumHand.MAIN_HAND);
			world.playSound(player.posX, player.posY, player.posZ, SoundEvents.ENTITY_GHAST_SHOOT, SoundCategory.PLAYERS, 1, 1, false);
		}
	}

	public static void Blizzard (EntityPlayer player, World world) {
		PacketDispatcher.sendToServer(new MagicBlizzard());
		player.swingArm(EnumHand.MAIN_HAND);
		//if (FMLCommonHandler.instance().getSide() == Side.SERVER) PacketDispatcher.sendToDimension(new MagicBlizzard(), world.provider.getDimensionId());
	}

	public static void Thunder (EntityPlayer player, World world) {
		PacketDispatcher.sendToServer(new MagicThunder());
		player.swingArm(EnumHand.MAIN_HAND);
	}

	public static void Cure (EntityPlayer player, World world) {
		PacketDispatcher.sendToServer(new MagicCure());
		player.swingArm(EnumHand.MAIN_HAND);

	}

	public static void Aero (EntityPlayer player, World world) {
		PacketDispatcher.sendToServer(new MagicAero());
		player.swingArm(EnumHand.MAIN_HAND);
		world.playSound(player.posX, player.posY, player.posZ, SoundEvents.ENTITY_GHAST_SHOOT, SoundCategory.PLAYERS, 1, 1, false);
	}

	public static void Stop (EntityPlayer player, World world) {
		PacketDispatcher.sendToServer(new MagicStop());
		player.swingArm(EnumHand.MAIN_HAND);
		world.playSound(player.posX, player.posY, player.posZ, SoundEvents.ENTITY_GHAST_SHOOT, SoundCategory.PLAYERS, 1, 1, false);
	}
}
