package wehavecookies56.kk;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemSword;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.fml.client.event.ConfigChangedEvent;
import net.minecraftforge.fml.client.event.ConfigChangedEvent.OnConfigChangedEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import wehavecookies56.kk.item.ModItems;
import wehavecookies56.kk.lib.Config;
import wehavecookies56.kk.lib.Reference;
import wehavecookies56.kk.lib.Strings;
import wehavecookies56.kk.network.ClientProxy;
import wehavecookies56.kk.network.CommonProxy;

@Mod(name = Reference.MODNAME, modid = Reference.MODID, version = Reference.MODVER)
public class KingdomKeys {
	
	@SidedProxy(clientSide = Reference.CLIENTPROXY, serverSide = Reference.COMMONPROXY)
	public static CommonProxy proxy;
	public static ClientProxy cproxy;
	
	public static Configuration config;
		
	@Mod.Instance(Reference.MODID)
	public static KingdomKeys instance;
	
	@EventHandler
	public static void preInit(FMLPreInitializationEvent e){
		config = new Configuration(e.getSuggestedConfigurationFile());
		Config.syncConfig();
	}
	
	@SubscribeEvent
	public void OnConfigChanged(ConfigChangedEvent.OnConfigChangedEvent event){
		if(event.modID.equals(Reference.MODID)){
			Config.syncConfig();
		}
	}
	
	@EventHandler
    public static void init(FMLInitializationEvent e){
		ModItems.init();
		ModItems.register();
		proxy.init();
	}
	
	@EventHandler
	public static void postInit(FMLPostInitializationEvent e){
		
	}
	
}
