package uk.co.wehavecookies56.kk.common.core.proxy;

import java.awt.Color;
import java.io.File;
import java.net.MalformedURLException;
import java.util.HashMap;
import java.util.Map;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Biomes;
import net.minecraft.util.IThreadListener;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.common.BiomeManager;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;
import net.minecraftforge.fml.common.registry.EntityRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry;
import uk.co.wehavecookies56.kk.api.driveforms.DriveFormRegistry;
import uk.co.wehavecookies56.kk.api.materials.MaterialRegistry;
import uk.co.wehavecookies56.kk.api.recipes.FreeDevRecipeRegistry;
import uk.co.wehavecookies56.kk.api.recipes.RecipeRegistry;
import uk.co.wehavecookies56.kk.common.KingdomKeys;
import uk.co.wehavecookies56.kk.common.achievement.ModAchievements;
import uk.co.wehavecookies56.kk.common.block.ModBlocks;
import uk.co.wehavecookies56.kk.common.block.tile.TileEntityKKChest;
import uk.co.wehavecookies56.kk.common.block.tile.TileEntityStationOfAwakening;
import uk.co.wehavecookies56.kk.common.block.tile.TileEntitySynthesisTable;
import uk.co.wehavecookies56.kk.common.capability.ModCapabilities;
import uk.co.wehavecookies56.kk.common.core.handler.ConfigHandler;
import uk.co.wehavecookies56.kk.common.core.handler.FuelHandler;
import uk.co.wehavecookies56.kk.common.core.handler.GuiHandler;
import uk.co.wehavecookies56.kk.common.core.handler.UsernameHandler;
import uk.co.wehavecookies56.kk.common.core.handler.event.BlockEvents;
import uk.co.wehavecookies56.kk.common.core.handler.event.CapabilityEvents;
import uk.co.wehavecookies56.kk.common.core.handler.event.EntityEvents;
import uk.co.wehavecookies56.kk.common.core.handler.event.ItemEvents;
import uk.co.wehavecookies56.kk.common.core.handler.event.RenderingEvents;
import uk.co.wehavecookies56.kk.common.core.helper.EntityHelper;
import uk.co.wehavecookies56.kk.common.core.helper.LogHelper;
import uk.co.wehavecookies56.kk.common.crafting.KKOreDictionary;
import uk.co.wehavecookies56.kk.common.crafting.ModBlocksRecipes;
import uk.co.wehavecookies56.kk.common.crafting.ModItemsRecipes;
import uk.co.wehavecookies56.kk.common.driveform.ModDriveForms;
import uk.co.wehavecookies56.kk.common.entity.block.EntityBlastBlox;
import uk.co.wehavecookies56.kk.common.entity.magic.EntityFire;
import uk.co.wehavecookies56.kk.common.entity.magic.EntityThunder;
import uk.co.wehavecookies56.kk.common.entity.mobs.EntityBlueRhapsody;
import uk.co.wehavecookies56.kk.common.entity.mobs.EntityGigaShadow;
import uk.co.wehavecookies56.kk.common.entity.mobs.EntityGreenRequiem;
import uk.co.wehavecookies56.kk.common.entity.mobs.EntityMoogle;
import uk.co.wehavecookies56.kk.common.entity.mobs.EntityRedNocturne;
import uk.co.wehavecookies56.kk.common.entity.mobs.EntityShadow;
import uk.co.wehavecookies56.kk.common.entity.mobs.EntityYellowOpera;
import uk.co.wehavecookies56.kk.common.item.ModItems;
import uk.co.wehavecookies56.kk.common.lib.Constants;
import uk.co.wehavecookies56.kk.common.lib.Lists;
import uk.co.wehavecookies56.kk.common.lib.Reference;
import uk.co.wehavecookies56.kk.common.network.packet.PacketDispatcher;
import uk.co.wehavecookies56.kk.common.synthesis.ModSynthesisFreeDevRecipes;
import uk.co.wehavecookies56.kk.common.synthesis.ModSynthesisMaterials;
import uk.co.wehavecookies56.kk.common.synthesis.ModSynthesisRecipes;
import uk.co.wehavecookies56.kk.common.world.ChestGen;
import uk.co.wehavecookies56.kk.common.world.WorldGenBlox;
import uk.co.wehavecookies56.kk.common.world.dimension.ModDimensions;

public class CommonProxy {

	public void preInit (FMLPreInitializationEvent event) {
		// Display mod info in console
		LogHelper.info("You are running " + Reference.MODNAME + " version " + Reference.MODVER + " for Minecraft " + Reference.MCVER);

		// ConfigHandler
		ConfigHandler.init(new File(event.getModConfigurationDirectory().getPath() + File.separator + Reference.MODID + File.separator + "MainConfig.cfg"));
		LogHelper.info("Configuration loaded");
		if(ConfigHandler.chat)
		{
			try {
				UsernameHandler.init(event);
			} catch (MalformedURLException e) {
				e.printStackTrace();
			}
		}

		// World generation
		GameRegistry.registerWorldGenerator(new WorldGenBlox(), 2);
		LogHelper.info("World generation loaded");

		// Packets
		PacketDispatcher.registerPackets();
		LogHelper.info("Packets loaded");

		// Items
		ModItems.init();
		ModItems.register();
		LogHelper.info("Items loaded");

		// Blocks
		ModBlocks.init();
		ModBlocks.register();
		LogHelper.info("Blocks loaded");

		ModDimensions.init();

		ModCapabilities.registerCapabilities();
	}
	
	public static Map<String, Integer> stringtoIDMapping = new HashMap<String, Integer>();
	static int startEntityId = 600;
	
	@SuppressWarnings("unchecked")
	private static void registerEntityWithEgg(Class<? extends Entity> entity, String name, int modid, int trackingRange, int updateFrequency, boolean sendsVelocityUpdates, int primaryColor, int secondaryColor) {
		int id = 1;
		stringtoIDMapping.put(name, id);
		EntityRegistry.registerModEntity(entity, name, modid, new KingdomKeys(), trackingRange, updateFrequency, sendsVelocityUpdates, primaryColor, secondaryColor);
	}

	public void init (FMLInitializationEvent event) {
		// Instance
		MinecraftForge.EVENT_BUS.register(KingdomKeys.instance);

		//	ModSounds.init();
		//LogHelper.info("Sounds loaded");

		// Update checker
		LogHelper.info("Update checker loaded");

		// Crafting recipe
		ModItemsRecipes.init();
		ModBlocksRecipes.init();
		LogHelper.info("Crafting recipe loaded");

		// Fuel Handler
		GameRegistry.registerFuelHandler(new FuelHandler());
		LogHelper.info("Fuel handler loaded");
		registerAchievements();

		// Register renders

		LogHelper.info("Renders loaded");

		// Tile entity registry
		GameRegistry.registerTileEntity(TileEntitySynthesisTable.class, "synthesistable");
		GameRegistry.registerTileEntity(TileEntityKKChest.class, "kkchest");
		GameRegistry.registerTileEntity(TileEntityStationOfAwakening.class, "stationofawakening");
		LogHelper.info("Tile entity loaded");

		// Proxy used as Gui handler
		NetworkRegistry.INSTANCE.registerGuiHandler(KingdomKeys.instance, new GuiHandler());

		EntityRegistry.registerModEntity(EntityBlastBlox.class, "blastblox", 1001, KingdomKeys.instance, 16, 1, false);
		EntityRegistry.registerModEntity(EntityFire.class, "fire", 1002, KingdomKeys.instance, 16, 1, false);
		EntityRegistry.registerModEntity(EntityThunder.class, "thunder", 1003, KingdomKeys.instance, 16, 1, false);

		// Heartless registry
		EntityHelper.registerEntity("Shadow", EntityShadow.class, Color.BLACK.getRGB(), Color.YELLOW.getRGB());
		EntityHelper.registerEntity("GigaShadow", EntityGigaShadow.class, Color.BLACK.getRGB(), Color.GRAY.getRGB());
		EntityHelper.registerEntity("RedNocturne", EntityRedNocturne.class, Color.RED.getRGB(), Color.PINK.getRGB());
		EntityHelper.registerEntity("BlueRhapsody", EntityBlueRhapsody.class, Color.BLUE.getRGB(), Color.CYAN.getRGB());
		EntityHelper.registerEntity("YellowOpera", EntityYellowOpera.class, Color.orange.getRGB(), Color.yellow.getRGB());
		EntityHelper.registerEntity("GreenRequiem", EntityGreenRequiem.class, Color.LIGHT_GRAY.getRGB(), Color.green.getRGB());
		EntityHelper.registerEntity("Moogle", EntityMoogle.class, 0xDACAB0, 0xC50033);

		EntityRegistry.addSpawn(EntityMoogle.class, 5, 1, 1, EnumCreatureType.CREATURE, Biomes.PLAINS, Biomes.DESERT, Biomes.DESERT_HILLS, Biomes.FOREST, Biomes.FOREST_HILLS, Biomes.BIRCH_FOREST, Biomes.BIRCH_FOREST_HILLS, Biomes.ROOFED_FOREST, Biomes.TAIGA, Biomes.TAIGA_HILLS);

		Lists.init();

		// Drive forms init
		ModDriveForms.init();
		LogHelper.info(DriveFormRegistry.getDriveFormMap().size() + " Drive form(s) loaded");

		// Synthesis Recipes init
		ModSynthesisRecipes.init();
		LogHelper.info(RecipeRegistry.getRecipeMap().size() + " Synthesis recipe(s) loaded");

		ModSynthesisFreeDevRecipes.init();
		LogHelper.info(FreeDevRecipeRegistry.getFreeDevRecipeMap().size() + " Free Development recipe(s) loaded");

		ModSynthesisMaterials.init();
		LogHelper.info(MaterialRegistry.getMaterialMap().size() + " Material(s) loaded");

		Constants.registerCosts();
		Constants.registerMagicLevels();

		// Chest loot init
		MinecraftForge.EVENT_BUS.register(new ChestGen());
		LogHelper.info("Chest loot loaded");
	}

	public void postInit (FMLPostInitializationEvent event) {

		// Event handler
		MinecraftForge.EVENT_BUS.register(new BlockEvents());
		MinecraftForge.EVENT_BUS.register(new CapabilityEvents());
		MinecraftForge.EVENT_BUS.register(new EntityEvents());
		MinecraftForge.EVENT_BUS.register(new ItemEvents());
		MinecraftForge.EVENT_BUS.register(new RenderingEvents());
		LogHelper.info("Events loaded");

		//Ore Dictionary registry
		KKOreDictionary.registerOres();
		LogHelper.info("Registered Ores");
	}

	public EntityPlayer getPlayerEntity (MessageContext ctx) {
		return ctx.getServerHandler().playerEntity;
	}

	public IThreadListener getThreadFromContext (MessageContext ctx) {
		return ctx.getServerHandler().playerEntity.getServer();
	}

	public void spawnTestParticle(World world, double posX, double posY, double posZ, double motionX, double motionY, double motionZ, float alpha) {}

	public void registerAchievements () {
		// Achievements
		ModAchievements.init();
		ModAchievements.register();
		LogHelper.info("Achievements loaded");
	}

}
