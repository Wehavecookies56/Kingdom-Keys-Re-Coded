package wehavecookies56.kk.entities;

import wehavecookies56.kk.network.packet.PacketDispatcher;
import wehavecookies56.kk.network.packet.server.ChangeMagic;
import wehavecookies56.kk.network.packet.server.ChangeStrength;
import wehavecookies56.kk.network.packet.server.ChangeVT;

public class PlayerLevel {

	public static void LevelUp()
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
			}
			ExtendedPlayer.level = 2;
		}
		else if(ExtendedPlayer.experience>=40 && ExtendedPlayer.experience<70)
		{
			if(ExtendedPlayer.getLevel()==2)
			{
				PacketDispatcher.sendToServer(new ChangeVT(1,"+"));
				ExtendedPlayer.level = 3;
			}
		}
		else if(ExtendedPlayer.experience>=70 && ExtendedPlayer.experience<100)
		{
			if(ExtendedPlayer.getLevel()==3)
			{
				PacketDispatcher.sendToServer(new ChangeMagic(1,"+"));
				ExtendedPlayer.level = 4;
			}
			ExtendedPlayer.level = 4;
		}
		else if(ExtendedPlayer.experience>=100 && ExtendedPlayer.experience<150)
		{
			ExtendedPlayer.level = 5;
		}
		else if(ExtendedPlayer.experience>=150 && ExtendedPlayer.experience<180)
		{
			ExtendedPlayer.level = 6;
		}
		else if(ExtendedPlayer.experience>=180 && ExtendedPlayer.experience<250)
		{
			ExtendedPlayer.level = 7;
		}
		else if(ExtendedPlayer.experience>=250 && ExtendedPlayer.experience<320)
		{
			ExtendedPlayer.level = 8;
		}
		else if(ExtendedPlayer.experience>=320 && ExtendedPlayer.experience<400)
		{
			ExtendedPlayer.level = 9;
		}
		else if(ExtendedPlayer.experience>=400 && ExtendedPlayer.experience<500)
		{
			ExtendedPlayer.level = 10;
		}
		
	}
}
