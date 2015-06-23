package wehavecookies56.kk;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.client.event.ConfigChangedEvent;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import wehavecookies56.kk.block.ModBlocks;
import wehavecookies56.kk.event.EventOnJoinWorld;
import wehavecookies56.kk.event.EventOnLivingDeath;
import wehavecookies56.kk.item.ModItems;
import wehavecookies56.kk.lib.Config;
import wehavecookies56.kk.lib.Reference;
import wehavecookies56.kk.network.ClientProxy;
import wehavecookies56.kk.network.CommonProxy;
import wehavecookies56.kk.network.PacketHandler;
import wehavecookies56.kk.network.PacketMunny;
import wehavecookies56.kk.util.ScrollHandler;
import wehavecookies56.kk.worldgen.WorldGenBlox;

@Mod(name = Reference.MODNAME, modid = Reference.MODID, version = Reference.MODVER)
public class KingdomKeys {
	
	@SidedProxy(clientSide = Reference.CLIENTPROXY, serverSide = Reference.COMMONPROXY)
	public static CommonProxy proxy;
	public static ClientProxy cproxy;
	
	public static Configuration config;
		
	@Mod.Instance(Reference.MODID)
	public static KingdomKeys instance;
	
	public static final PacketHandler kkPacketHandler = new PacketHandler("wehavecookies56.kk.network");
	
	@EventHandler
	public static void preInit(FMLPreInitializationEvent e){
		config = new Configuration(e.getSuggestedConfigurationFile());
		Config.syncConfig();
		GameRegistry.registerWorldGenerator(new WorldGenBlox(), 2);

	}
	
	@SubscribeEvent
	public void OnConfigChanged(ConfigChangedEvent.OnConfigChangedEvent event){
		if(event.modID.equals(Reference.MODID)){
			Config.syncConfig();
		}
	}
	
	@EventHandler
    public static void init(FMLInitializationEvent e){
		kkPacketHandler.initialise(Reference.MODCHANNEL);
		kkPacketHandler.registerPacket(PacketMunny.class);
		WorldGenBlox worldGen = new WorldGenBlox();
		FMLCommonHandler.instance().bus().register(instance);
		MinecraftForge.EVENT_BUS.register(new ScrollHandler());
		MinecraftForge.EVENT_BUS.register(new wehavecookies56.kk.util.EventHandler());
		MinecraftForge.EVENT_BUS.register(new EventOnJoinWorld());
		MinecraftForge.EVENT_BUS.register(new EventOnLivingDeath());
		ModItems.init();
		ModItems.register();
		ModBlocks.init();
		ModBlocks.register();
		proxy.init();
	}
	
	@EventHandler
	public static void postInit(FMLPostInitializationEvent e){
		
	}
	
}
