package wehavecookies56.kk.entities;

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
		//TODO maybe a better way XD
		if(ExtendedPlayer.experience <20)
		{
			ExtendedPlayer.level = 1;
		}
		else if(ExtendedPlayer.experience>=20 && ExtendedPlayer.experience<40)
		{
			if(ExtendedPlayer.getLevel()==1)
			{
				PacketDispatcher.sendToServer(new ChangeStrength(1,"+"));
				TextHelper.sendFormattedChatMessage("You are now level "+ExtendedPlayer.getLevel()+1, EnumChatFormatting.YELLOW, player);
			}
			ExtendedPlayer.level = 2;
		}
		else if(ExtendedPlayer.experience>=40 && ExtendedPlayer.experience<70)
		{
			if(ExtendedPlayer.getLevel()==2)
			{
				PacketDispatcher.sendToServer(new ChangeDefense(1,"+"));
				TextHelper.sendFormattedChatMessage("You are now level "+(ExtendedPlayer.getLevel()+1), EnumChatFormatting.YELLOW, player);
			}
			ExtendedPlayer.level = 3;
		}
		else if(ExtendedPlayer.experience>=70 && ExtendedPlayer.experience<100)
		{
			if(ExtendedPlayer.getLevel()==3)
			{
				PacketDispatcher.sendToServer(new ChangeVT(1,"+"));
				TextHelper.sendFormattedChatMessage("You are now level "+ExtendedPlayer.getLevel()+1, EnumChatFormatting.YELLOW, player);

			}
			ExtendedPlayer.level = 4;
		}
		else if(ExtendedPlayer.experience>=100 && ExtendedPlayer.experience<150)
		{
			if(ExtendedPlayer.getLevel()==4)
			{
				PacketDispatcher.sendToServer(new ChangeStrength(1,"+"));
			}
			ExtendedPlayer.level = 5;
		}
		else if(ExtendedPlayer.experience>=150 && ExtendedPlayer.experience<180)
		{
			if(ExtendedPlayer.getLevel()==5)
			{
				PacketDispatcher.sendToServer(new ChangeVT(1,"+"));
			}
			ExtendedPlayer.level = 6;
		}
		else if(ExtendedPlayer.experience>=180 && ExtendedPlayer.experience<250)
		{
			if(ExtendedPlayer.getLevel()==6)
			{
				PacketDispatcher.sendToServer(new ChangeStrength(1,"+"));
			}
			ExtendedPlayer.level = 7;
		}
		else if(ExtendedPlayer.experience>=250 && ExtendedPlayer.experience<320)
		{
			if(ExtendedPlayer.getLevel()==7)
			{
				PacketDispatcher.sendToServer(new ChangeDefense(1,"+"));
			}
			ExtendedPlayer.level = 8;
		}
		else if(ExtendedPlayer.experience>=320 && ExtendedPlayer.experience<400)
		{
			if(ExtendedPlayer.getLevel()==8)
			{
				PacketDispatcher.sendToServer(new ChangeDefense(1,"+"));
			}
			ExtendedPlayer.level = 9;
		}
		else if(ExtendedPlayer.experience>=400 && ExtendedPlayer.experience<500)
		{
			if(ExtendedPlayer.getLevel()==7)
			{
				PacketDispatcher.sendToServer(new ChangeVT(1,"+"));
			}
			ExtendedPlayer.level = 10;
		}
		
	}
}
