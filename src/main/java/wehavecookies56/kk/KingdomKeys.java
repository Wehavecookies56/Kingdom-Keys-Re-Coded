package wehavecookies56.kk;

import net.minecraft.item.ItemStack;
import net.minecraft.util.WeightedRandomChestContent;
import net.minecraftforge.common.ChestGenHooks;
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
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry;
import wehavecookies56.kk.block.ModBlocks;
import wehavecookies56.kk.block.ModBlocksRecipes;
import wehavecookies56.kk.entities.TileEntitySynthesisTable;
import wehavecookies56.kk.item.ModItems;
import wehavecookies56.kk.item.ModItemsRecipes;
import wehavecookies56.kk.lib.Config;
import wehavecookies56.kk.lib.Lists;
import wehavecookies56.kk.lib.Reference;
import wehavecookies56.kk.network.ClientProxy;
import wehavecookies56.kk.network.CommonProxy;
import wehavecookies56.kk.network.UpdateChecker;
import wehavecookies56.kk.network.packet.PacketDispatcher;
import wehavecookies56.kk.recipes.ModRecipes;
import wehavecookies56.kk.recipes.RecipeRegistry;
import wehavecookies56.kk.server.command.CommandGiveMunny;
import wehavecookies56.kk.server.command.CommandLearnRecipe;
import wehavecookies56.kk.util.LogHelper;
import wehavecookies56.kk.util.ScrollHandler;
import wehavecookies56.kk.worldgen.ChestGen;
import wehavecookies56.kk.worldgen.WorldGenBlox;

@Mod(name = Reference.MODNAME, modid = Reference.MODID, version = Reference.MODVER, guiFactory = Reference.GUIFACTORY, modLanguage = "java")
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
		//Display mod info in console
		LogHelper.info("You are running " + Reference.MODNAME + " version " + Reference.MODVER + " for Minecraft 1.8");

		//Config
		config = new Configuration(e.getSuggestedConfigurationFile());
		Config.syncConfig();
		LogHelper.info("Configuration loaded");

		//World generation
		GameRegistry.registerWorldGenerator(new WorldGenBlox(), 2);
		LogHelper.info("World generation loaded");

		//Packets
		PacketDispatcher.registerPackets();
		LogHelper.info("Packets loaded");

	}


	//Sync config when changed
	@SubscribeEvent
	public void OnConfigChanged(ConfigChangedEvent.OnConfigChangedEvent event){
		if(event.modID.equals(Reference.MODID)){
			Config.syncConfig();
		}
	}

	@EventHandler
    public void init(FMLInitializationEvent e){
		//Instance
		FMLCommonHandler.instance().bus().register(instance);

		//Events
		MinecraftForge.EVENT_BUS.register(new ScrollHandler());
		LogHelper.info("Mouse controls loaded");

		//Update checker
		FMLCommonHandler.instance().bus().register(new UpdateChecker());
		LogHelper.info("Update checker loaded");

		//Items
		ModItems.init();
		ModItems.register();
		LogHelper.info("Items loaded");

		//Blocks
		ModBlocks.init();
		ModBlocks.register();
		LogHelper.info("Blocks loaded");

		//Craftin recipes
		ModItemsRecipes.init();
		ModBlocksRecipes.init();
		LogHelper.info("Crafting recipes loaded");

		//Register renders
		proxy.init();
		LogHelper.info("Renders loaded");

		//Proxy used as Gui handler
		NetworkRegistry.INSTANCE.registerGuiHandler(this, proxy);

		//Tile entity registry
		GameRegistry.registerTileEntity(TileEntitySynthesisTable.class, "synthesistable");
		LogHelper.info("Tile entities loaded");

		Lists.init();

		//Synthesis Recipes init
		ModRecipes.init();
		LogHelper.info(RecipeRegistry.getRecipeMap().size() + " Synthesis recipes loaded");

		//Chest loot init
		ChestGen.init();
		LogHelper.info("Chest loot added");
	}

	@EventHandler
	public void postInit(FMLPostInitializationEvent e){

		//Event handler
		MinecraftForge.EVENT_BUS.register(new wehavecookies56.kk.util.EventHandler());
		LogHelper.info("Events loaded");
	}

	@EventHandler
	public void serverStart(FMLServerStartingEvent e){
		e.registerServerCommand(new CommandLearnRecipe());
		e.registerServerCommand(new CommandGiveMunny());
	}

}
