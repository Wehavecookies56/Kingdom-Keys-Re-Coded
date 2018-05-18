package uk.co.wehavecookies56.kk.common.core.proxy;

import java.awt.Color;
import java.net.MalformedURLException;
import java.util.HashMap;
import java.util.Map;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.IThreadListener;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
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
import uk.co.wehavecookies56.kk.common.entity.EntityFlyingHeart;
import uk.co.wehavecookies56.kk.common.entity.EntityGummiShip;
import uk.co.wehavecookies56.kk.common.entity.block.EntityBlastBlox;
import uk.co.wehavecookies56.kk.common.entity.magic.EntityFire;
import uk.co.wehavecookies56.kk.common.entity.magic.EntityOrgPortal;
import uk.co.wehavecookies56.kk.common.entity.magic.EntityThunder;
import uk.co.wehavecookies56.kk.common.entity.mobs.EntityBlueRhapsody;
import uk.co.wehavecookies56.kk.common.entity.mobs.EntityCrimsonJazz;
import uk.co.wehavecookies56.kk.common.entity.mobs.EntityDarkball;
import uk.co.wehavecookies56.kk.common.entity.mobs.EntityDetonator;
import uk.co.wehavecookies56.kk.common.entity.mobs.EntityDirePlant;
import uk.co.wehavecookies56.kk.common.entity.mobs.EntityEmeraldBlues;
import uk.co.wehavecookies56.kk.common.entity.mobs.EntityGigaShadow;
import uk.co.wehavecookies56.kk.common.entity.mobs.EntityGreenRequiem;
import uk.co.wehavecookies56.kk.common.entity.mobs.EntityLargeBody;
import uk.co.wehavecookies56.kk.common.entity.mobs.EntityMegaShadow;
import uk.co.wehavecookies56.kk.common.entity.mobs.EntityMinuteBomb;
import uk.co.wehavecookies56.kk.common.entity.mobs.EntityMoogle;
import uk.co.wehavecookies56.kk.common.entity.mobs.EntityRedNocturne;
import uk.co.wehavecookies56.kk.common.entity.mobs.EntityShadow;
import uk.co.wehavecookies56.kk.common.entity.mobs.EntitySilverRock;
import uk.co.wehavecookies56.kk.common.entity.mobs.EntitySkaterBomb;
import uk.co.wehavecookies56.kk.common.entity.mobs.EntityStormBomb;
import uk.co.wehavecookies56.kk.common.entity.mobs.EntityWhiteMushroom;
import uk.co.wehavecookies56.kk.common.entity.mobs.EntityYellowOpera;
import uk.co.wehavecookies56.kk.common.entity.projectiles.EntitySeedBullet;
import uk.co.wehavecookies56.kk.common.item.ModItems;
import uk.co.wehavecookies56.kk.common.lib.Constants;
import uk.co.wehavecookies56.kk.common.lib.Lists;
import uk.co.wehavecookies56.kk.common.lib.Reference;
import uk.co.wehavecookies56.kk.common.lib.Spawnings;
import uk.co.wehavecookies56.kk.common.lib.Strings;
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

        if(MainConfig.client.hud.chat){
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
        EntityHelper.registerEntity("kkOrgPortalE", EntityOrgPortal.class);
        EntityHelper.registerEntity("kkFlyingHeart", EntityFlyingHeart.class);
        EntityHelper.registerEntity("seedBullet", EntitySeedBullet.class);

        // Heartless registry
        EntityHelper.registerEntity(Strings.Shadow, EntityShadow.class, Color.BLACK.getRGB(), Color.YELLOW.getRGB());
        EntityHelper.registerEntity(Strings.MegaShadow, EntityMegaShadow.class, Color.BLACK.getRGB(), Color.GRAY.getRGB());
        EntityHelper.registerEntity(Strings.GigaShadow, EntityGigaShadow.class, Color.BLACK.getRGB(), Color.BLACK.getRGB());
        EntityHelper.registerEntity(Strings.Darkball, EntityDarkball.class, 0x020030, 0x492263);
        
        EntityHelper.registerEntity(Strings.RedNocturne, EntityRedNocturne.class, Color.RED.getRGB(), Color.PINK.getRGB());
        EntityHelper.registerEntity(Strings.BlueRhapsody, EntityBlueRhapsody.class, Color.BLUE.getRGB(), Color.CYAN.getRGB());
        EntityHelper.registerEntity(Strings.YellowOpera, EntityYellowOpera.class, Color.orange.getRGB(), Color.yellow.getRGB());
        EntityHelper.registerEntity(Strings.GreenRequiem, EntityGreenRequiem.class, Color.LIGHT_GRAY.getRGB(), Color.green.getRGB());
        EntityHelper.registerEntity(Strings.SilverRock, EntitySilverRock.class, Color.LIGHT_GRAY.getRGB(), Color.darkGray.getRGB());
        EntityHelper.registerEntity(Strings.CrimsonJazz, EntityCrimsonJazz.class, Color.black.getRGB(), Color.red.getRGB());
        EntityHelper.registerEntity(Strings.EmeraldBlues, EntityEmeraldBlues.class, Color.green.getRGB(), Color.blue.getRGB());
        EntityHelper.registerEntity(Strings.MinuteBomb, EntityMinuteBomb.class, 0x020030, 0x8B4513);
        EntityHelper.registerEntity(Strings.SkaterBomb, EntitySkaterBomb.class, 0x020030, 0xAAAAFF);
        EntityHelper.registerEntity(Strings.StormBomb, EntityStormBomb.class, 0x020030, Color.CYAN.getRGB());
        EntityHelper.registerEntity(Strings.Detonator, EntityDetonator.class, 0x020030, Color.RED.getRGB());
        EntityHelper.registerEntity(Strings.LargeBody, EntityLargeBody.class, 0x4d177c, 0x29014c);
        EntityHelper.registerEntity(Strings.WhiteMushroom, EntityWhiteMushroom.class, 0xe3e5e8, 0xffffff);
        EntityHelper.registerEntity(Strings.DirePlant, EntityDirePlant.class, 0x4ba04e, 0xedc2c2);
        EntityHelper.registerEntity(Strings.Moogle, EntityMoogle.class, 0xDACAB0, 0xC50033);
        EntityHelper.registerEntity(Strings.GummiShip,EntityGummiShip.class, 0xFF0000, 0x6666AA);

        Spawnings.init();
        
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

    public void spawnDarkSmokeParticle(World world, double posX, double posY, double posZ, double motionX, double motionY, double motionZ, float alpha) {}

}
