package wehavecookies56.kk.entities;

import java.util.ArrayList;
import java.util.Arrays;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.EnumChatFormatting;
import wehavecookies56.kk.client.gui.GuiOverlay;
import wehavecookies56.kk.util.TextHelper;

public class PlayerLevel {

	public static int[] expNeeded = new int[]{
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
	
	int neededExp;
	
	public static ArrayList<String> messages = new ArrayList<String>();

	public static void LevelUp(EntityPlayer player)
	{
		ExtendedPlayer ep = ExtendedPlayer.get(player);

		if(ep.getLevel() < 1){
			ep.levelUp(1);
			return;
		}

		if(ep.getLevel() == 1){
			if(ep.getXP() >= expNeeded[ep.getLevel() - 1]){
				ep.levelUp(2);
				levelUpMessage(player, ep);
				ep.addDefense(1);
			}
		}

		if((Arrays.stream(expNeeded, 0, ep.getLevel()).sum() - ep.getXP()) < 0){
			ep.setXP(Arrays.stream(expNeeded, 0, ep.getLevel()).sum());
		}
		if(ep.getLevel() > 1){
			if(ep.getLevel() != 100 && ep.getXP() >= Arrays.stream(expNeeded, 0, ep.getLevel()).sum()){
				ep.levelUp(ep.getLevel()+1);
				levelUpMessage(player, ep);
				switch(ep.getLevel()){
				case 3:
					ep.addStrength(1);					
					break;
				case 4:
					ep.addDefense(1);					
					break;
				case 5:
					ep.addStrength(1);					
					ep.addHP(5);					
					break;
				case 6:
					ep.addMagic(1);					
					ep.addDefense(1);					
					break;
				case 7:
					ep.addStrength(1);					
					break;
				case 8:
					ep.addMagic(1);					
					break;
				case 9:
					ep.addStrength(1);					
					break;
				case 10:
					ep.addMagic(1);
					ep.addDefense(1);					
					ep.addHP(5);					
					break;
				case 11:
					ep.addStrength(1);					
					break;
				case 12:
					ep.addMagic(1);					
					break;
				case 13:
					ep.addStrength(1);					
					break;
				case 14:
					ep.addMagic(1);					
					ep.addDefense(1);					
					break;
				case 15:
					ep.addStrength(1);					
					ep.addHP(5);					
					break;
				case 16:
					ep.addMagic(1);					
					break;
				case 17:
					ep.addStrength(1);
					break;
				case 18:
					ep.addMagic(1);					
					ep.addDefense(1);					
					break;
				case 19:
					ep.addStrength(1);					
					break;
				case 20:
					ep.addMagic(1);					
					ep.addHP(5);
					break;
				case 21:
					ep.addStrength(1);					
					break;
				case 22:
					ep.addMagic(1);					
					ep.addDefense(1);					
					break;
				case 23:
					ep.addStrength(1);					
					break;
				case 24:
					ep.addMagic(1);					
					break;
				case 25:
					ep.addStrength(1);					
					ep.addHP(5);
					break;
				case 26:
					ep.addMagic(1);					
					ep.addDefense(1);					
					break;
				case 27:
					ep.addStrength(1);					
					ep.addMagic(1);					
					break;
				case 28:
					ep.addMagic(1);					
					break;
				case 29:
					ep.addStrength(1);					
					break;
				case 30:
					ep.addMagic(1);					
					ep.addDefense(1);					
					ep.addHP(5);					
					break;
				case 31:
					ep.addStrength(1);					
					break;
				case 32:
					ep.addStrength(1);					
					ep.addMagic(1);					
					break;
				case 33:
					ep.addStrength(1);					
					break;
				case 34:
					ep.addMagic(1);					
					ep.addDefense(1);					
					break;
				case 35:
					ep.addStrength(1);					
					ep.addHP(5);					
					break;
				case 36:
					ep.addMagic(1);					
					break;
				case 37:
					ep.addStrength(1);					
					break;
				case 38:
					ep.addMagic(1);					
					ep.addDefense(1);					
					break;
				case 39:
					ep.addStrength(1);					
					break;
				case 40:
					ep.addMagic(1);					
					ep.addHP(5);					
					break;
				case 41:
					ep.addStrength(1);					
					break;
				case 42:
					ep.addMagic(1);					
					ep.addDefense(1);					
					break;
				case 43:
					ep.addStrength(1);					
					ep.addMagic(1);					
					break;
				case 44:
					ep.addMagic(1);					
					break;
				case 45:
					ep.addStrength(1);					
					ep.addHP(5);					
					break;
				case 46:
					ep.addMagic(1);					
					ep.addDefense(1);					
					break;
				case 47:
					ep.addStrength(1);					
					break;
				case 48:
					ep.addStrength(1);					
					ep.addMagic(1);
					break;
				case 49:
					ep.addStrength(1);					
					break;
				case 50:
					ep.addMagic(1);					
					ep.addDefense(1);					
					ep.addHP(5);					
					break;
				case 51:
					ep.addStrength(1);					
					break;
				case 52:
					ep.addMagic(1);					
					break;
				case 53:
					ep.addStrength(1);					
					break;
				case 54:
					ep.addMagic(1);					
					ep.addDefense(1);
					break;
				case 55:
					ep.addStrength(1);					
					ep.addHP(5);					
					break;
				case 56:
					ep.addMagic(1);					
					break;
				case 57:
					ep.addStrength(1);					
					break;
				case 58:
					ep.addMagic(1);					
					ep.addDefense(1);					
					break;
				case 59:
					ep.addStrength(1);					
					break;
				case 60:
					ep.addMagic(1);					
					ep.addHP(5);					
					break;
				case 61:
					ep.addStrength(1);					
					break;
				case 62:
					ep.addMagic(1);					
					ep.addDefense(1);					
					break;
				case 63:
					ep.addStrength(1);					
					break;
				case 64:
					ep.addMagic(1);					
					break;
				case 65:
					ep.addStrength(1);					
					ep.addHP(5);					
					break;
				case 66:
					ep.addMagic(1);					
					ep.addDefense(1);					
					break;
				case 67:
					ep.addStrength(1);					
					break;
				case 68:
					ep.addMagic(1);					
					break;
				case 69:
					ep.addStrength(1);					
					break;
				case 70:
					ep.addMagic(1);					
					ep.addDefense(1);					
					ep.addHP(5);
					break;
				case 71:
					ep.addStrength(1);					
					break;
				case 72:
					ep.addMagic(1);					
					break;
				case 73:
					ep.addStrength(1);					
					break;
				case 74:
					ep.addMagic(1);					
					ep.addDefense(1);					
					break;
				case 75:
					ep.addStrength(1);					
					ep.addHP(5);					
					break;
				case 76:
					ep.addMagic(1);					
					break;
				case 77:
					ep.addStrength(1);					
					break;
				case 78:
					ep.addMagic(1);					
					ep.addDefense(1);					
					break;
				case 79:
					ep.addStrength(1);					
					break;
				case 80:
					ep.addMagic(1);					
					ep.addHP(5);					
					break;
				case 81:
					ep.addStrength(1);					
					break;
				case 82:
					ep.addMagic(1);					
					ep.addDefense(1);					
					break;
				case 83:
					ep.addStrength(1);					
					break;
				case 84:
					ep.addMagic(1);					
					break;
				case 85:
					ep.addStrength(1);					
					ep.addHP(5);
					break;
				case 86:
					ep.addMagic(1);					
					ep.addDefense(1);					
					break;
				case 87:
					ep.addStrength(1);					
					break;
				case 88:
					ep.addMagic(1);					
					break;
				case 89:
					ep.addStrength(1);					
					break;
				case 90:
					ep.addMagic(1);					
					ep.addDefense(1);					
					ep.addHP(5);					
					break;
				case 91:
					ep.addStrength(1);					
					break;
				case 92:
					ep.addMagic(1);
					break;
				case 93:
					ep.addStrength(1);					
					break;
				case 94:
					ep.addMagic(1);					
					ep.addDefense(1);					
					break;
				case 95:
					ep.addStrength(1);					
					ep.addHP(5);			
					break;
				case 96:
					ep.addMagic(1);
					break;
				case 97:
					ep.addStrength(1);
					break;
				case 98:
					ep.addMagic(1);
					ep.addDefense(1);
					break;
				case 99:
					ep.addStrength(1);
					break;
				case 100:
					ep.addStrength(10);
					ep.addDefense(10);
					ep.addMagic(10);
					ep.addHP(5);
					break;
				}
			}
		}

	}

	public static void levelUpMessage(EntityPlayer player, ExtendedPlayer ep){
		messages.clear();
	}
}
