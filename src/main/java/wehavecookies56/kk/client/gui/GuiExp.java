package wehavecookies56.kk.client.gui;

import java.util.Arrays;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiScreen;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import wehavecookies56.kk.entities.ExtendedPlayer;
import wehavecookies56.kk.entities.PlayerLevel;

public class GuiExp extends GuiScreen
{
	public static boolean showExp;
	public static long time;
	@SubscribeEvent
	public void RenderGameOverlayEvent(RenderGameOverlayEvent event)
	{		
		int screenWidth = event.resolution.getScaledWidth();
		int screenHeight = event.resolution.getScaledHeight();
		String reqExp = "Next Level: "+ (Arrays.stream(PlayerLevel.expNeeded, 0, ExtendedPlayer.get(Minecraft.getMinecraft().thePlayer).getLevel()).sum() - ExtendedPlayer.get(Minecraft.getMinecraft().thePlayer).getXP());
    	if(showExp)
    	{	
			System.out.println(reqExp.length());
			//TODO Spawn notification background
    		Minecraft.getMinecraft().fontRendererObj.drawString(reqExp, screenWidth - reqExp.length()-60, 1, 0xFFFFFF);
			if(time+4 <= (int)Minecraft.getMinecraft().getSystemTime()/1000)
			{
				System.out.println("hide");
				showExp = false;
			}
    	}
	}
}
