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
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry;
import wehavecookies56.kk.block.ModBlocks;
import wehavecookies56.kk.block.ModBlocksRecipes;
import wehavecookies56.kk.entities.TileEntitySynthesisTable;
import wehavecookies56.kk.item.ModItemsRecipes;
import wehavecookies56.kk.item.ModItems;
import wehavecookies56.kk.lib.Config;
import wehavecookies56.kk.lib.Reference;
import wehavecookies56.kk.lib.Strings;
import wehavecookies56.kk.network.ClientProxy;
import wehavecookies56.kk.network.CommonProxy;
import wehavecookies56.kk.network.packet.PacketDispatcher;
import wehavecookies56.kk.recipes.RecipeKingdomKey;
import wehavecookies56.kk.recipes.RecipeRegistry;
import wehavecookies56.kk.util.ScrollHandler;
import wehavecookies56.kk.worldgen.WorldGenBlox;

@Mod(name = Reference.MODNAME, modid = Reference.MODID, version = Reference.MODVER)
public class KingdomKeys {
	
	@SidedProxy(clientSide = Reference.CLIENTPROXY, serverSide = Reference.COMMONPROXY)
	public static CommonProxy proxy;
	public static ClientProxy cproxy;
	
	public static Configuration config;
		
	private static int modGuiIndex = 0;
	public static final int GUI_KEYCHAIN_INV = modGuiIndex++;

	@Mod.Instance(Reference.MODID)
	public static KingdomKeys instance;
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent e){
		config = new Configuration(e.getSuggestedConfigurationFile());
		Config.syncConfig();
		GameRegistry.registerWorldGenerator(new WorldGenBlox(), 2);
		PacketDispatcher.registerPackets();

	}
	
	@SubscribeEvent
	public void OnConfigChanged(ConfigChangedEvent.OnConfigChangedEvent event){
		if(event.modID.equals(Reference.MODID)){
			Config.syncConfig();
		}
	}
	
	@EventHandler
    public void init(FMLInitializationEvent e){
		//kkPacketHandler.registerPacket(PacketMunny.class);
		RecipeRegistry.registerRecipe(new RecipeKingdomKey(Strings.KingdomKey));
		WorldGenBlox worldGen = new WorldGenBlox();
		FMLCommonHandler.instance().bus().register(instance);
		MinecraftForge.EVENT_BUS.register(new ScrollHandler());
		ModItems.init();
		ModItems.register();
		ModBlocks.init();
		ModBlocks.register();
		ModItemsRecipes.init();
		ModBlocksRecipes.init();
		proxy.init();
		NetworkRegistry.INSTANCE.registerGuiHandler(this, proxy);
		GameRegistry.registerTileEntity(TileEntitySynthesisTable.class, "synthesistable");
	}
	
	@EventHandler
	public void postInit(FMLPostInitializationEvent e){
		MinecraftForge.EVENT_BUS.register(new wehavecookies56.kk.util.EventHandler());
	}
	
}
