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
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.registry.EntityRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry;
import wehavecookies56.kk.api.driveforms.DriveFormRegistry;
import wehavecookies56.kk.api.materials.MaterialRegistry;
import wehavecookies56.kk.api.recipes.RecipeRegistry;
import wehavecookies56.kk.block.ModBlocks;
import wehavecookies56.kk.block.ModBlocksRecipes;
import wehavecookies56.kk.driveforms.ModDriveForms;
import wehavecookies56.kk.entities.EntityItemMetalChocobo;
import wehavecookies56.kk.entities.PlayerLevel;
import wehavecookies56.kk.entities.TileEntityKKChest;
import wehavecookies56.kk.entities.TileEntitySynthesisTable;
import wehavecookies56.kk.entities.block.EntityBlastBlox;
import wehavecookies56.kk.entities.magic.EntityFire;
import wehavecookies56.kk.entities.magic.EntityThunder;
import wehavecookies56.kk.item.ModItems;
import wehavecookies56.kk.item.ModItemsRecipes;
import wehavecookies56.kk.lib.Config;
import wehavecookies56.kk.lib.Lists;
import wehavecookies56.kk.lib.Reference;
import wehavecookies56.kk.materials.ModMaterials;
import wehavecookies56.kk.network.ClientProxy;
import wehavecookies56.kk.network.CommonProxy;
import wehavecookies56.kk.network.UpdateChecker;
import wehavecookies56.kk.network.packet.PacketDispatcher;
import wehavecookies56.kk.recipes.ModRecipes;
import wehavecookies56.kk.server.command.CommandCheatMode;
import wehavecookies56.kk.server.command.CommandGiveMunny;
import wehavecookies56.kk.server.command.CommandLearnRecipe;
import wehavecookies56.kk.server.command.CommandLevelUp;
import wehavecookies56.kk.server.command.CommandRemoveKeychain;
import wehavecookies56.kk.server.command.CommandResetLevel;
import wehavecookies56.kk.util.FuelHandler;
import wehavecookies56.kk.util.LogHelper;
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
	public static final int GUI_KKCHEST_INV = modGuiIndex++;
	public static final int GUI_SYNTHESISBAGS_INV = modGuiIndex++;
	public static final int GUI_SYNTHESISBAGM_INV = modGuiIndex++;
	public static final int GUI_SYNTHESISBAGL_INV = modGuiIndex++;

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

		//Items
		ModItems.init();
		ModItems.register();
		LogHelper.info("Items loaded");

		//Blocks
		ModBlocks.init();
		ModBlocks.register();
		LogHelper.info("Blocks loaded");
		
		proxy.preInit();

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

		//Update checker
		FMLCommonHandler.instance().bus().register(new UpdateChecker());
		LogHelper.info("Update checker loaded");

		//Crafting recipes
		ModItemsRecipes.init();
		ModBlocksRecipes.init();
		LogHelper.info("Crafting recipes loaded");

		//Fuel Handler
		GameRegistry.registerFuelHandler(new FuelHandler());
		LogHelper.info("Fuel handler loaded");

		//Register renders
		proxy.init();
		LogHelper.info("Renders loaded");

		//Tile entity registry
		GameRegistry.registerTileEntity(TileEntitySynthesisTable.class, "synthesistable");
		GameRegistry.registerTileEntity(TileEntityKKChest.class, "kkchest");
		LogHelper.info("Tile entities loaded");

		//Proxy used as Gui handler
		NetworkRegistry.INSTANCE.registerGuiHandler(this, proxy);

		EntityRegistry.registerModEntity(EntityBlastBlox.class, "blastblox", 0, instance, 16, 1, false);
		EntityRegistry.registerModEntity(EntityFire.class, "fire", 1, instance, 16, 1, false);
		EntityRegistry.registerModEntity(EntityThunder.class, "thunder", 2, instance, 16, 1, false);
		
		//EntityRegistry.registerModEntity(EntityItemMetalChocobo.class, "entityitemmetalchocobo", 2, instance, 16, 1, false);


		Lists.init();

		//Drive forms init
		ModDriveForms.init();
		LogHelper.info(DriveFormRegistry.getDriveFormMap().size() + " Drive form(s) loaded");

		//Synthesis Recipes init
		ModRecipes.init();
		LogHelper.info(RecipeRegistry.getRecipeMap().size() + " Synthesis recipe(s) loaded");

		ModMaterials.init();
		LogHelper.info(MaterialRegistry.getMaterialMap().size() + " Material(s) loaded");
		
		//Chest loot init
		ChestGen.init();
		LogHelper.info("Chest loot loaded");

	}

	@EventHandler
	public void postInit(FMLPostInitializationEvent e){

		new PlayerLevel();
		
		//Event handler
		MinecraftForge.EVENT_BUS.register(new wehavecookies56.kk.util.EventHandler());
		FMLCommonHandler.instance().bus().register(new wehavecookies56.kk.util.EventHandler());

		LogHelper.info("Events loaded");
	}

	@EventHandler
	public void serverStart(FMLServerStartingEvent e){
		e.registerServerCommand(new CommandLearnRecipe());
		e.registerServerCommand(new CommandGiveMunny());
		e.registerServerCommand(new CommandCheatMode());
		e.registerServerCommand(new CommandRemoveKeychain());
		e.registerServerCommand(new CommandResetLevel());
		e.registerServerCommand(new CommandLevelUp());
	}

}
