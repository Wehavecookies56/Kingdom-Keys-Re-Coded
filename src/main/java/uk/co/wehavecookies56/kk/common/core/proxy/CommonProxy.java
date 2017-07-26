package uk.co.wehavecookies56.kk.common.core.proxy;

import java.awt.Color;
import java.io.File;
import java.net.MalformedURLException;
import java.util.*;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Biomes;
import net.minecraft.util.IThreadListener;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.common.BiomeDictionary;
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
import uk.co.wehavecookies56.kk.common.block.ModBlocks;
import uk.co.wehavecookies56.kk.common.block.tile.TileEntityKKChest;
import uk.co.wehavecookies56.kk.common.block.tile.TileEntityOrgPortal;
import uk.co.wehavecookies56.kk.common.block.tile.TileEntityPedestal;
import uk.co.wehavecookies56.kk.common.block.tile.TileEntityStationOfAwakening;
import uk.co.wehavecookies56.kk.common.block.tile.TileEntitySynthesisTable;
import uk.co.wehavecookies56.kk.common.capability.ModCapabilities;
import uk.co.wehavecookies56.kk.common.core.handler.*;
import uk.co.wehavecookies56.kk.common.core.handler.event.BlockEvents;
import uk.co.wehavecookies56.kk.common.core.handler.event.CapabilityEvents;
import uk.co.wehavecookies56.kk.common.core.handler.event.EntityEvents;
import uk.co.wehavecookies56.kk.common.core.handler.event.ItemEvents;
import uk.co.wehavecookies56.kk.common.core.handler.event.RenderingEvents;
import uk.co.wehavecookies56.kk.common.core.helper.EntityHelper;
import uk.co.wehavecookies56.kk.common.core.helper.LogHelper;
import uk.co.wehavecookies56.kk.common.crafting.KKOreDictionary;
import uk.co.wehavecookies56.kk.common.crafting.ModItemsRecipes;
import uk.co.wehavecookies56.kk.common.driveform.ModDriveForms;
import uk.co.wehavecookies56.kk.common.entity.block.EntityBlastBlox;
import uk.co.wehavecookies56.kk.common.entity.magic.EntityFire;
import uk.co.wehavecookies56.kk.common.entity.magic.EntityOrgPortal;
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
        LogHelper.info("World generation loaded");

        // Packets
        PacketDispatcher.registerPackets();
        LogHelper.info("Packets loaded");

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

        //    ModSounds.init();
        //LogHelper.info("Sounds loaded");

        // Update checker
        ModItems.init();

        // Register renders

        LogHelper.info("Renders loaded");

        // Tile entity registry
        GameRegistry.registerTileEntity(TileEntitySynthesisTable.class, "synthesistable");
        GameRegistry.registerTileEntity(TileEntityKKChest.class, "kkchest");
        GameRegistry.registerTileEntity(TileEntityStationOfAwakening.class, "stationofawakening");
        GameRegistry.registerTileEntity(TileEntityPedestal.class, "kkpedestal");
        GameRegistry.registerTileEntity(TileEntityOrgPortal.class, "kkorgportal");
        LogHelper.info("Tile entity loaded");

        // Proxy used as Gui handler
        NetworkRegistry.INSTANCE.registerGuiHandler(KingdomKeys.instance, new GuiHandler());

        EntityHelper.registerEntity("blastblox",EntityBlastBlox.class);
        EntityHelper.registerEntity("fire",EntityFire.class);
        EntityHelper.registerEntity("thunder",EntityThunder.class);
        //EntityRegistry.registerModEntity(EntityOrgPortal.class, "kkOrgPortalE", 1004, KingdomKeys.instance, 16, 1, false);
        EntityHelper.registerEntity("kkOrgPortalE", EntityOrgPortal.class);


        // Heartless registry
        EntityHelper.registerEntity("shadow", EntityShadow.class, Color.BLACK.getRGB(), Color.YELLOW.getRGB());
        EntityHelper.registerEntity("gigashadow", EntityGigaShadow.class, Color.BLACK.getRGB(), Color.GRAY.getRGB());
        EntityHelper.registerEntity("rednocturne", EntityRedNocturne.class, Color.RED.getRGB(), Color.PINK.getRGB());
        EntityHelper.registerEntity("bluerhapsody", EntityBlueRhapsody.class, Color.BLUE.getRGB(), Color.CYAN.getRGB());
        EntityHelper.registerEntity("yellowopera", EntityYellowOpera.class, Color.orange.getRGB(), Color.yellow.getRGB());
        EntityHelper.registerEntity("greenrequiem", EntityGreenRequiem.class, Color.LIGHT_GRAY.getRGB(), Color.green.getRGB());
        EntityHelper.registerEntity("moogle", EntityMoogle.class, 0xDACAB0, 0xC50033);

        Iterator<Biome> biomeRegistry = Biome.REGISTRY.iterator();
        List<Biome> biomes = new ArrayList<>();
        while(biomeRegistry.hasNext()) {
            Biome biome = biomeRegistry.next();
            biomes.add(biome);
        }
        Biome[] biomesArray = biomes.toArray(new Biome[biomes.size()]);

        EntityRegistry.addSpawn(EntityShadow.class, MainConfig.entities.shadowRatio, 1, 3, EnumCreatureType.MONSTER, biomesArray);
        EntityRegistry.addSpawn(EntityGigaShadow.class, MainConfig.entities.gigaShadowRatio, 1, 1, EnumCreatureType.MONSTER, biomesArray);
        EntityRegistry.addSpawn(EntityRedNocturne.class, MainConfig.entities.redNocturneRatio, 1, 1, EnumCreatureType.MONSTER, biomesArray);
        EntityRegistry.addSpawn(EntityBlueRhapsody.class, MainConfig.entities.blueRhapsodyRatio, 1, 1, EnumCreatureType.MONSTER, biomesArray);
        EntityRegistry.addSpawn(EntityYellowOpera.class, MainConfig.entities.yellowOperaRatio, 1, 1, EnumCreatureType.MONSTER, biomesArray);
        EntityRegistry.addSpawn(EntityGreenRequiem.class, MainConfig.entities.greenRequiemRatio, 1, 1, EnumCreatureType.MONSTER, biomesArray);

        EntityRegistry.addSpawn(EntityMoogle.class, MainConfig.entities.moogleRatio, 1, 1, EnumCreatureType.CREATURE, biomesArray);

        Lists.init();

        ModItemsRecipes.init();

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
        return ctx.getServerHandler().player;
    }

    public IThreadListener getThreadFromContext (MessageContext ctx) {
        return ctx.getServerHandler().player.getServer();
    }

    public void spawnTestParticle(World world, double posX, double posY, double posZ, double motionX, double motionY, double motionZ, float alpha) {}

}
