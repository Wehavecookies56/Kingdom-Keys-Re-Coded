package wehavecookies56.kk.entities;

import java.util.Arrays;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.EnumChatFormatting;
import wehavecookies56.kk.network.packet.PacketDispatcher;
import wehavecookies56.kk.network.packet.server.ChangeDefense;
import wehavecookies56.kk.network.packet.server.ChangeStrength;
import wehavecookies56.kk.network.packet.server.ChangeVT;
import wehavecookies56.kk.util.TextHelper;

public class PlayerLevel {

	public static void LevelUp(EntityPlayer player)
	{
		ExtendedPlayer ep = ExtendedPlayer.get(player);

		int[] expNeeded;

		expNeeded = new int[]{
			20, 23, 27, 33, 39, 47, 56, 67, 80,
			94, 109, 127, 146, 167, 191, 216, 244, 274,
			307, 342, 381, 422, 466, 513, 564, 618, 676,
			737, 803, 873, 948, 1027, 1112, 1201, 1297,
			1397, 1504, 1617, 1737, 1864, 1998, 2140,
			2290, 2449, 2616, 2793, 2980, 3177, 3385,
			3604, 3835, 4079, 4336, 4606, 4892, 5192,
			5509, 5842, 6194, 6563, 6952, 7362, 7793,
			8247, 8724, 9226, 9755, 10310, 10895,
			11510, 12156, 12836, 13551, 14302, 15092,
			15923, 16796, 17714, 18679, 19693, 20758,
			21878, 23055, 24292, 25591, 26957, 28392,
			29899, 31483, 33148, 34896, 36733, 36733,
			38662, 40690, 42819, 45056, 47406, 49874,
			52467, 100000
		};

		if(ep.getLevel() < 1){
			ep.levelUp(1);
			return;
		}

		if(ep.getLevel() == 1){
			if(ep.getXP() >= expNeeded[ep.getLevel() - 1]){
				ep.levelUp(2);
				levelUpMessage(player, ep);
			}
		}

		System.out.println("XP:" + ep.getXP());
		System.out.println("Next level: " + (Arrays.stream(expNeeded, 0, ep.getLevel()).sum() - ep.getXP()));
		if(ep.getLevel() > 1){
			if(ep.getLevel() != 100 && ep.getXP() >= Arrays.stream(expNeeded, 0, ep.getLevel()).sum()){
				ep.levelUp(ep.getLevel()+1);
				levelUpMessage(player, ep);
			}
		}

	}

	public static void levelUpMessage(EntityPlayer player, ExtendedPlayer ep){
		TextHelper.sendFormattedChatMessage("You are now level "+ep.getLevel(), EnumChatFormatting.YELLOW, player);
	}
}
