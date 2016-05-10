package uk.co.wehavecookies56.kk.common;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import uk.co.wehavecookies56.kk.common.core.command.CommandCheatMode;
import uk.co.wehavecookies56.kk.common.core.command.CommandDriveLevel;
import uk.co.wehavecookies56.kk.common.core.command.CommandGiveMunny;
import uk.co.wehavecookies56.kk.common.core.command.CommandLearnRecipe;
import uk.co.wehavecookies56.kk.common.core.command.CommandLevelUp;
import uk.co.wehavecookies56.kk.common.core.command.CommandRemoveKeychain;
import uk.co.wehavecookies56.kk.common.core.command.CommandResetLevel;
import uk.co.wehavecookies56.kk.common.core.command.CommandShowHud;
import uk.co.wehavecookies56.kk.common.core.helper.LogHelper;
import uk.co.wehavecookies56.kk.common.core.proxy.CommonProxy;
import uk.co.wehavecookies56.kk.common.lib.Reference;

@Mod (name = Reference.MODNAME, modid = Reference.MODID, version = Reference.MODVER, guiFactory = Reference.GUIFACTORY, modLanguage = "java", updateJSON = "https://raw.githubusercontent.com/Wehavecookies56/Kingdom-Keys-Re-Coded/master/update.json")
public class KingdomKeys {

	@SidedProxy (clientSide = Reference.CLIENTPROXY, serverSide = Reference.COMMONPROXY)
	public static CommonProxy proxy;

	@Mod.Instance (Reference.MODID)
	public static KingdomKeys instance;

	@EventHandler
	public void preInit (FMLPreInitializationEvent e) { proxy.preInit(e);  }

	@EventHandler
	public void init (FMLInitializationEvent e) { proxy.init(e); }

	@EventHandler
	public void postInit (FMLPostInitializationEvent e) { proxy.postInit(e); }

	@EventHandler
	public void serverStart (FMLServerStartingEvent e) {
		e.registerServerCommand(new CommandLearnRecipe());
		e.registerServerCommand(new CommandGiveMunny());
		e.registerServerCommand(new CommandCheatMode());
		e.registerServerCommand(new CommandRemoveKeychain());
		e.registerServerCommand(new CommandResetLevel());
		e.registerServerCommand(new CommandLevelUp());
		e.registerServerCommand(new CommandDriveLevel());
		e.registerServerCommand(new CommandShowHud());

		LogHelper.info("Commands loaded");
	}

}
