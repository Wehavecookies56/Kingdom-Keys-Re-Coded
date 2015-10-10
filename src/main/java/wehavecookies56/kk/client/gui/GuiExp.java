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
	public static boolean showMunny;
	public static long time;
	public static int munnyGet;
	@SubscribeEvent
	public void RenderGameOverlayEvent(RenderGameOverlayEvent event)
	{
		int screenWidth = event.resolution.getScaledWidth();
		int screenHeight = event.resolution.getScaledHeight();
		String reqExp = ""+(Arrays.stream(PlayerLevel.expNeeded, 0, ExtendedPlayer.get(Minecraft.getMinecraft().thePlayer).getLevel()).sum() - ExtendedPlayer.get(Minecraft.getMinecraft().thePlayer).getXP());
		if(showExp)
    	{
			//TODO Spawn notification background
    		Minecraft.getMinecraft().fontRendererObj.drawString("Next LV", 5, 5, 0xFFFFFF);
    		Minecraft.getMinecraft().fontRendererObj.drawString(reqExp, 5, 5 + Minecraft.getMinecraft().fontRendererObj.FONT_HEIGHT, 0xFFFFFF);
			if(time+4 <= (int)Minecraft.getMinecraft().getSystemTime()/1000)
			{
				showExp = false;
			}
    	}
		if(showMunny){
			Minecraft.getMinecraft().fontRendererObj.drawString("Munny Get!", 5, 5 + Minecraft.getMinecraft().fontRendererObj.FONT_HEIGHT + 10, 0xFFFFFF);
    		Minecraft.getMinecraft().fontRendererObj.drawString(munnyGet+"", 5, 5 + (Minecraft.getMinecraft().fontRendererObj.FONT_HEIGHT*2) + 10, 0xFFFFFF);
			if(time+4 <= (int)Minecraft.getMinecraft().getSystemTime()/1000)
			{
				showMunny = false;
			}
		}
	}
}
