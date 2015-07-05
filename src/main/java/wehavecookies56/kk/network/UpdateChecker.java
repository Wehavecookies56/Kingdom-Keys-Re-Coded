package wehavecookies56.kk.network;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

import net.minecraft.util.ChatComponentText;
import net.minecraft.util.EnumChatFormatting;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent;
import wehavecookies56.kk.lib.Config;
import wehavecookies56.kk.lib.Reference;
import wehavecookies56.kk.util.LogHelper;

public class UpdateChecker {

	public static String modName;
	public static String currentVersion;
	public static String url;
	public static boolean ableToCheck;

	@SubscribeEvent
	public void onPlayerLogin(PlayerEvent.PlayerLoggedInEvent event) throws MalformedURLException, IOException
	{
		if(Config.EnableUpdateCheck && isUpdateAvailable() && ableToCheck == true){
			BufferedReader versionFile = new BufferedReader(new InputStreamReader(new URL("https://raw.github.com/Wehavecookies56/Kingdom-Keys-Re-Coded-/master/VERSION.txt").openStream()));
			String curVersion = versionFile.readLine();
			String mcVersion = versionFile.readLine();
			event.player.addChatMessage(new ChatComponentText("["+EnumChatFormatting.RED + Reference.MODNAME +EnumChatFormatting.RESET+"] An Update is available for this mod. Version " + curVersion + "for Minecraft " + mcVersion + " Check http://goo.gl/40N4TP for more info."));
		}

		else if(Config.EnableUpdateCheck && !isUpdateAvailable() && ableToCheck)
		{
			LogHelper.info(Reference.MODNAME + " is update");
			event.player.addChatMessage(new ChatComponentText("["+EnumChatFormatting.RED + Reference.MODNAME +EnumChatFormatting.RESET+"] This mod is up to date"));
		}

		else if(!Config.EnableUpdateCheck)
		{
			LogHelper.info("The update checker is disabled");
			event.player.addChatMessage(new ChatComponentText("["+EnumChatFormatting.RED + Reference.MODNAME +EnumChatFormatting.RESET+"] The update checker is not enabled"));
		}
		else if(!ableToCheck){
			LogHelper.info("The update checker was unable to check for an update");
			event.player.addChatMessage(new ChatComponentText("["+EnumChatFormatting.RED + Reference.MODNAME +EnumChatFormatting.RESET+"] The update checker was unable to check for an update"));
		}
	}

	public static boolean isUpdateAvailable() throws IOException, MalformedURLException {
		try{
			BufferedReader versionFile = new BufferedReader(new InputStreamReader(new URL("https://raw.github.com/Wehavecookies56/Kingdom-Keys-Re-Coded-/master/VERSION.txt").openStream()));
			String curVersion = versionFile.readLine();
			String mcVersion = versionFile.readLine();
			ableToCheck = true;
			LogHelper.info("The update checker was able to check for an update");
			versionFile.close();
			currentVersion = Reference.MODVER;
			if (!curVersion.contains(currentVersion)) {
				return true;
			}else{
				return false;
			}

		}catch(IOException e){
			ableToCheck = false;
			LogHelper.info("The update checker was unable to check for an update");
			return false;
		}
	}

	public static String getNewVersion(String address)
	{
		String newVersion = null;
		try
		{
			URL url = new URL(address);
			Scanner scanner = new Scanner(url.openStream());
			while (scanner.hasNextLine())
			{
				newVersion = scanner.nextLine();
			}
			scanner.close();
		}
		catch (IOException ex)
		{
			ex.printStackTrace();
		}
		return newVersion;
	}
}
