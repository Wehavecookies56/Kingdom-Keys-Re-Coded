package uk.co.wehavecookies56.kk.common.core.proxy;

import java.awt.Color;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Biomes;
import net.minecraft.util.IThreadListener;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeHell;
import net.minecraft.world.gen.structure.MapGenStructureIO;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;
import net.minecraftforge.fml.common.registry.EntityRegistry;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.common.registry.VillagerRegistry;
import uk.co.wehavecookies56.kk.api.driveforms.DriveFormRegistry;
import uk.co.wehavecookies56.kk.api.materials.MaterialRegistry;
import uk.co.wehavecookies56.kk.api.recipes.FreeDevRecipeRegistry;
import uk.co.wehavecookies56.kk.api.recipes.RecipeRegistry;
import uk.co.wehavecookies56.kk.common.KingdomKeys;
import uk.co.wehavecookies56.kk.common.block.tile.TileEntityKKChest;
import uk.co.wehavecookies56.kk.common.block.tile.TileEntityOrgPortal;
import uk.co.wehavecookies56.kk.common.block.tile.TileEntityPedestal;
import uk.co.wehavecookies56.kk.common.block.tile.TileEntityStationOfAwakening;
import uk.co.wehavecookies56.kk.common.block.tile.TileEntitySynthesisTable;
import uk.co.wehavecookies56.kk.common.capability.ModCapabilities;
import uk.co.wehavecookies56.kk.common.core.handler.GuiHandler;
import uk.co.wehavecookies56.kk.common.core.handler.MainConfig;
import uk.co.wehavecookies56.kk.common.core.handler.UsernameHandler;
import uk.co.wehavecookies56.kk.common.core.handler.VillagerTrades;
import uk.co.wehavecookies56.kk.common.core.handler.event.BlockEvents;
import uk.co.wehavecookies56.kk.common.core.handler.event.CapabilityEvents;
import uk.co.wehavecookies56.kk.common.core.handler.event.EntityEvents;
import uk.co.wehavecookies56.kk.common.core.handler.event.ItemEvents;
import uk.co.wehavecookies56.kk.common.core.handler.event.RenderingEvents;
import uk.co.wehavecookies56.kk.common.core.helper.EntityHelper;
import uk.co.wehavecookies56.kk.common.crafting.KKOreDictionary;
import uk.co.wehavecookies56.kk.common.crafting.ModItemsRecipes;
import uk.co.wehavecookies56.kk.common.driveform.ModDriveForms;
import uk.co.wehavecookies56.kk.common.entity.block.EntityBlastBlox;
import uk.co.wehavecookies56.kk.common.entity.magic.EntityFire;
import uk.co.wehavecookies56.kk.common.entity.magic.EntityOrgPortal;
import uk.co.wehavecookies56.kk.common.entity.magic.EntityThunder;
import uk.co.wehavecookies56.kk.common.entity.mobs.*;
import uk.co.wehavecookies56.kk.common.item.ModItems;
import uk.co.wehavecookies56.kk.common.lib.Constants;
import uk.co.wehavecookies56.kk.common.lib.Lists;
import uk.co.wehavecookies56.kk.common.lib.Reference;
import uk.co.wehavecookies56.kk.common.network.packet.PacketDispatcher;
import uk.co.wehavecookies56.kk.common.synthesis.ModSynthesisFreeDevRecipes;
import uk.co.wehavecookies56.kk.common.synthesis.ModSynthesisMaterials;
import uk.co.wehavecookies56.kk.common.synthesis.ModSynthesisRecipes;
import uk.co.wehavecookies56.kk.common.world.ChestGen;
import uk.co.wehavecookies56.kk.common.world.MoogleHouse;
import uk.co.wehavecookies56.kk.common.world.WorldGenBlox;
import uk.co.wehavecookies56.kk.common.world.biome.ModBiomes;
import uk.co.wehavecookies56.kk.common.world.dimension.ModDimensions;

public class CommonProxy {

    public void preInit (FMLPreInitializationEvent event) {
        // Display mod info in console
        KingdomKeys.logger.info("You are running " + Reference.MODNAME + " version " + Reference.MODVER + " for Minecraft " + Reference.MCVER);

        if(MainConfig.client.hud.chat)
        {
            try {
                UsernameHandler.init(event);
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
        }

        // World generation
        GameRegistry.registerWorldGenerator(new WorldGenBlox(), 2);
        KingdomKeys.logger.info("World generation loaded");

        // Packets
        PacketDispatcher.registerPackets();
        KingdomKeys.logger.info("Packets loaded");
        MinecraftForge.EVENT_BUS.register(new ModBiomes());
        ModDimensions.init();

        ModCapabilities.registerCapabilities();
    }

    public static Map<String, Integer> stringtoIDMapping = new HashMap<String, Integer>();
    static int startEntityId = 600;

    @SuppressWarnings("unchecked")
    private static void registerEntityWithEgg(Class<? extends Entity> entity, String name, int modid, int trackingRange, int updateFrequency, boolean sendsVelocityUpdates, int primaryColor, int secondaryColor) {
        int id = 1;
        stringtoIDMapping.put(name, id);
        EntityRegistry.registerModEntity(new ResourceLocation(Reference.MODID, name), entity, name, modid, new KingdomKeys(), trackingRange, updateFrequency, sendsVelocityUpdates, primaryColor, secondaryColor);
    }

    public void init (FMLInitializationEvent event) {
        // Instance
        MinecraftForge.EVENT_BUS.register(KingdomKeys.instance);

        ModBiomes.init();
        //    ModSounds.init();
        //LogHelper.info("Sounds loaded");

        // Update checker
        ModItems.init();

        // Register renders

        KingdomKeys.logger.info("Renders loaded");

        // Tile entity registry
        GameRegistry.registerTileEntity(TileEntitySynthesisTable.class, "synthesistable");
        GameRegistry.registerTileEntity(TileEntityKKChest.class, "kkchest");
        GameRegistry.registerTileEntity(TileEntityStationOfAwakening.class, "stationofawakening");
        GameRegistry.registerTileEntity(TileEntityPedestal.class, "kkpedestal");
        GameRegistry.registerTileEntity(TileEntityOrgPortal.class, "kkorgportal");
        KingdomKeys.logger.info("Tile entity loaded");

        // Proxy used as Gui handler
        NetworkRegistry.INSTANCE.registerGuiHandler(KingdomKeys.instance, new GuiHandler());

        EntityHelper.registerEntity("blastblox",EntityBlastBlox.class);
        EntityHelper.registerEntity("fire",EntityFire.class);
        EntityHelper.registerEntity("thunder",EntityThunder.class);
        //EntityRegistry.registerModEntity(EntityOrgPortal.class, "kkOrgPortalE", 1004, KingdomKeys.instance, 16, 1, false);
        EntityHelper.registerEntity("kkOrgPortalE", EntityOrgPortal.class);


        // Heartless registry
        EntityHelper.registerEntity("shadow", EntityShadow.class, Color.BLACK.getRGB(), Color.YELLOW.getRGB());
        EntityHelper.registerEntity("megashadow", EntityMegaShadow.class, Color.BLACK.getRGB(), Color.GRAY.getRGB());
        EntityHelper.registerEntity("gigashadow", EntityGigaShadow.class, Color.BLACK.getRGB(), Color.BLACK.getRGB());
        EntityHelper.registerEntity("rednocturne", EntityRedNocturne.class, Color.RED.getRGB(), Color.PINK.getRGB());
        EntityHelper.registerEntity("bluerhapsody", EntityBlueRhapsody.class, Color.BLUE.getRGB(), Color.CYAN.getRGB());
        EntityHelper.registerEntity("yellowopera", EntityYellowOpera.class, Color.orange.getRGB(), Color.yellow.getRGB());
        EntityHelper.registerEntity("greenrequiem", EntityGreenRequiem.class, Color.LIGHT_GRAY.getRGB(), Color.green.getRGB());
        EntityHelper.registerEntity("silverrock", EntitySilverRock.class, Color.LIGHT_GRAY.getRGB(), Color.darkGray.getRGB());
        EntityHelper.registerEntity("crimsonjazz", EntityCrimsonJazz.class, Color.black.getRGB(), Color.red.getRGB());
        EntityHelper.registerEntity("emeraldblues", EntityEmeraldBlues.class, Color.green.getRGB(), Color.blue.getRGB());
        EntityHelper.registerEntity("moogle", EntityMoogle.class, 0xDACAB0, 0xC50033);

        Iterator<Biome> biomeRegistry = Biome.REGISTRY.iterator();
        List<Biome> biomes = new ArrayList<>();
        while(biomeRegistry.hasNext()) {
            Biome biome = biomeRegistry.next();
            biomes.add(biome);
        }
        for (String b : MainConfig.entities.mobBiomeExclusion) {
            if (Biome.REGISTRY.containsKey(new ResourceLocation(b))) {
                KingdomKeys.logger.info("Removed mob spawns for biome " + b);
                biomes.remove(Biome.REGISTRY.getObject(new ResourceLocation(b)));
            }
        }
        Biome[] biomesArray = biomes.toArray(new Biome[biomes.size()]);

        if (MainConfig.entities.shadowRatio != 0)
            EntityRegistry.addSpawn(EntityShadow.class, MainConfig.entities.shadowRatio, 3, 5, KingdomKeys.HEARTLESS, biomesArray);
        if (MainConfig.entities.gigaShadowRatio != 0)
            EntityRegistry.addSpawn(EntityGigaShadow.class, MainConfig.entities.gigaShadowRatio, 1, 1, KingdomKeys.HEARTLESS, biomesArray);
        if (MainConfig.entities.redNocturneRatio != 0)
            EntityRegistry.addSpawn(EntityRedNocturne.class, MainConfig.entities.redNocturneRatio, 1, 1, KingdomKeys.HEARTLESS, biomesArray);
        if (MainConfig.entities.blueRhapsodyRatio != 0)
            EntityRegistry.addSpawn(EntityBlueRhapsody.class, MainConfig.entities.blueRhapsodyRatio, 1, 1, KingdomKeys.HEARTLESS, biomesArray);
        if (MainConfig.entities.yellowOperaRatio != 0)
            EntityRegistry.addSpawn(EntityYellowOpera.class, MainConfig.entities.yellowOperaRatio, 1, 1, KingdomKeys.HEARTLESS, biomesArray);
        if (MainConfig.entities.greenRequiemRatio != 0)
            EntityRegistry.addSpawn(EntityGreenRequiem.class, MainConfig.entities.greenRequiemRatio, 1, 1, KingdomKeys.HEARTLESS, biomesArray);
        if (MainConfig.entities.emeraldBluesRatio != 0)
            EntityRegistry.addSpawn(EntityEmeraldBlues.class, MainConfig.entities.emeraldBluesRatio, 1, 1, KingdomKeys.HEARTLESS, biomesArray);
        if (MainConfig.entities.silverRockRatio != 0)
            EntityRegistry.addSpawn(EntitySilverRock.class, MainConfig.entities.silverRockRatio, 1, 1, KingdomKeys.HEARTLESS, Biomes.SKY);
        if (MainConfig.entities.crimsonJazzRatio != 0)
            EntityRegistry.addSpawn(EntityCrimsonJazz.class, MainConfig.entities.crimsonJazzRatio, 1, 1, KingdomKeys.HEARTLESS, Biomes.HELL);
        if (MainConfig.entities.moogleRatio != 0)
            EntityRegistry.addSpawn(EntityMoogle.class, MainConfig.entities.moogleRatio, 1, 1, KingdomKeys.MOOGLE, biomesArray);

        Lists.init();

        ModItemsRecipes.init();

        // Drive forms init
        ModDriveForms.init();
        KingdomKeys.logger.info(DriveFormRegistry.getDriveFormMap().size() + " Drive form(s) loaded");

        // Synthesis Recipes init
        ModSynthesisRecipes.init();
        KingdomKeys.logger.info(RecipeRegistry.getRecipeMap().size() + " Synthesis recipe(s) loaded");

        ModSynthesisFreeDevRecipes.init();
        KingdomKeys.logger.info(FreeDevRecipeRegistry.getFreeDevRecipeMap().size() + " Free Development recipe(s) loaded");

        ModSynthesisMaterials.init();
        KingdomKeys.logger.info(MaterialRegistry.getMaterialMap().size() + " Material(s) loaded");

        Constants.registerCosts();
        Constants.registerMagicLevels();

        if (MainConfig.worldgen.EnableWorldGen) {
            VillagerRegistry.instance().registerVillageCreationHandler(new MoogleHouse.VillageManager());
            MapGenStructureIO.registerStructureComponent(MoogleHouse.class, Reference.MODID + ":moogle_house");
        }

        VillagerRegistry.VillagerProfession librarian = ForgeRegistries.VILLAGER_PROFESSIONS.getValue(new ResourceLocation("minecraft:librarian"));
        librarian.getCareer(1).addTrade(1, new VillagerTrades());

        // Chest loot init
        MinecraftForge.EVENT_BUS.register(new ChestGen());
        KingdomKeys.logger.info("Chest loot loaded");
    }

    public void postInit (FMLPostInitializationEvent event) {

        // Event handler
        MinecraftForge.EVENT_BUS.register(new BlockEvents());
        MinecraftForge.EVENT_BUS.register(new CapabilityEvents());
        MinecraftForge.EVENT_BUS.register(new EntityEvents());
        MinecraftForge.EVENT_BUS.register(new ItemEvents());
        MinecraftForge.EVENT_BUS.register(new RenderingEvents());
        KingdomKeys.logger.info("Events loaded");

        //Ore Dictionary registry
        KKOreDictionary.registerOres();
        KingdomKeys.logger.info("Registered Ores");
    }

    public EntityPlayer getPlayerEntity (MessageContext ctx) {
        return ctx.getServerHandler().player;
    }

    public IThreadListener getThreadFromContext (MessageContext ctx) {
        return ctx.getServerHandler().player.getServer();
    }

    public void spawnTestParticle(World world, double posX, double posY, double posZ, double motionX, double motionY, double motionZ, float alpha) {}

}
