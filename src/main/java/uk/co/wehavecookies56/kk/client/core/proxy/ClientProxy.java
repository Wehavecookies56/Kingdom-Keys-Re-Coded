package uk.co.wehavecookies56.kk.client.core.proxy;

import com.jadarstudios.developercapes.DevCapes;
import net.minecraft.client.Minecraft;
import net.minecraft.client.particle.Particle;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.client.renderer.entity.RenderLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.util.IThreadListener;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.client.model.b3d.B3DLoader;
import net.minecraftforge.client.model.obj.OBJLoader;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.client.registry.IRenderFactory;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;
import net.minecraftforge.fml.relauncher.Side;
import uk.co.wehavecookies56.kk.client.core.handler.ClientEventHandler;
import uk.co.wehavecookies56.kk.client.core.handler.InputHandler;
import uk.co.wehavecookies56.kk.client.fx.EntityParticleFXTest;
import uk.co.wehavecookies56.kk.client.gui.*;
import uk.co.wehavecookies56.kk.client.model.mobs.*;
import uk.co.wehavecookies56.kk.client.render.*;
import uk.co.wehavecookies56.kk.client.render.chakrams.RenderEntityChakram;
import uk.co.wehavecookies56.kk.client.render.lances.RenderEntityLance;
import uk.co.wehavecookies56.kk.common.KingdomKeys;
import uk.co.wehavecookies56.kk.common.block.tile.TileEntityPedestal;
import uk.co.wehavecookies56.kk.common.core.proxy.CommonProxy;
import uk.co.wehavecookies56.kk.common.entity.*;
import uk.co.wehavecookies56.kk.common.entity.block.EntityBlastBlox;
import uk.co.wehavecookies56.kk.common.entity.magic.EntityOrgPortal;
import uk.co.wehavecookies56.kk.common.entity.mobs.*;
import uk.co.wehavecookies56.kk.common.entity.projectiles.EntityRock;
import uk.co.wehavecookies56.kk.common.entity.projectiles.EntitySeedBullet;
import uk.co.wehavecookies56.kk.common.entity.projectiles.EntitySharpshooterBullet;
import uk.co.wehavecookies56.kk.common.entity.projectiles.EntitySlash;
import uk.co.wehavecookies56.kk.common.entity.projectiles.chakrams.*;
import uk.co.wehavecookies56.kk.common.entity.projectiles.lances.EntityZephyr;
import uk.co.wehavecookies56.kk.common.item.ModItems;
import uk.co.wehavecookies56.kk.common.lib.Reference;
import uk.co.wehavecookies56.kk.common.lib.Strings;
import uk.co.wehavecookies56.kk.common.lib.Tutorials;

import static uk.co.wehavecookies56.kk.common.block.ModBlocks.*;
import static uk.co.wehavecookies56.kk.common.item.ModItems.*;

@Mod.EventBusSubscriber(value = Side.CLIENT, modid = Reference.MODID)
public class ClientProxy extends CommonProxy {

	@SubscribeEvent
	public static void registerModels(ModelRegistryEvent event) {
		B3DLoader.INSTANCE.addDomain(Reference.MODID);
		OBJLoader.INSTANCE.addDomain(Reference.MODID);

		for (Item i : ModItems.ITEMS) {
			registerModel(i);
		}

		// Berserk
		registerModel(NewMoon, 1, NewMoon.getRegistryName() + "_b");
		registerModel(Werewolf, 1, Werewolf.getRegistryName() + "_b");
		registerModel(Artemis, 1, Artemis.getRegistryName() + "_b");
		registerModel(Luminary, 1, Luminary.getRegistryName() + "_b");
		registerModel(Selene, 1, Selene.getRegistryName() + "_b");
		registerModel(Moonrise, 1, Moonrise.getRegistryName() + "_b");
		registerModel(Astrologia, 1, Astrologia.getRegistryName() + "_b");
		registerModel(Crater, 1, Crater.getRegistryName() + "_b");
		registerModel(LunarPhase, 1, LunarPhase.getRegistryName() + "_b");
		registerModel(Crescent, 1, Crescent.getRegistryName() + "_b");
		registerModel(Gibbous, 1, Gibbous.getRegistryName() + "_b");
		registerModel(Berserker, 1, Berserker.getRegistryName() + "_b");
		registerModel(Twilight, 1, Twilight.getRegistryName() + "_b");
		registerModel(QueenOfTheNight, 1, QueenOfTheNight.getRegistryName() + "_b");
		registerModel(BalsamicMoon, 1, BalsamicMoon.getRegistryName() + "_b");
		registerModel(Orbit, 1, Orbit.getRegistryName() + "_b");
		registerModel(LightYear, 1, LightYear.getRegistryName() + "_b");
		registerModel(KingOfTheNight, 1, KingOfTheNight.getRegistryName() + "_b");
		registerModel(Moonset, 1, Moonset.getRegistryName() + "_b");
		registerModel(Horoscope, 1, Horoscope.getRegistryName() + "_b");
		registerModel(Dichotomy, 1, Dichotomy.getRegistryName() + "_b");
		registerModel(Lunatic, 1, Lunatic.getRegistryName() + "_b");
		registerModel(JustDesserts, 1, JustDesserts.getRegistryName() + "_b");
		registerModel(Bunnymoon, 1, Bunnymoon.getRegistryName() + "_b");

		// Sniper
		registerModel(Standalone, 1, Standalone.getRegistryName() + "_s");
		registerModel(Killerbee, 1, Killerbee.getRegistryName() + "_s");
		registerModel(Stingray, 1, Stingray.getRegistryName() + "_s");
		registerModel(Counterweight, 1, Counterweight.getRegistryName() + "_s");
		registerModel(Precision, 1, Precision.getRegistryName() + "_s");
		registerModel(DualHead, 1, DualHead.getRegistryName() + "_s");
		registerModel(Bahamut, 1, Bahamut.getRegistryName() + "_s");
		registerModel(Gullwing, 1, Gullwing.getRegistryName() + "_s");
		registerModel(BlueFrame, 1, BlueFrame.getRegistryName() + "_s");
		registerModel(Sunrise, 1, Sunrise.getRegistryName() + "_s");
		registerModel(Ignition, 1, Ignition.getRegistryName() + "_s");
		registerModel(Armstrong, 1, Armstrong.getRegistryName() + "_s");
		registerModel(HardBoiledHeat, 1, HardBoiledHeat.getRegistryName() + "_s");
		registerModel(DiabloEye, 1, DiabloEye.getRegistryName() + "_s");
		registerModel(DoubleTap, 1, DoubleTap.getRegistryName() + "_s");
		registerModel(Stardust, 1, Stardust.getRegistryName() + "_s");
		registerModel(EnergyMuzzle, 1, EnergyMuzzle.getRegistryName() + "_s");
		registerModel(CrimeAndPunishment, 1, CrimeAndPunishment.getRegistryName() + "_s");
		registerModel(CupidsArrow, 1, CupidsArrow.getRegistryName() + "_s");
		registerModel(FinalWeapon, 1, FinalWeapon.getRegistryName() + "_s");
		registerModel(Sharpshooter, 1, Sharpshooter.getRegistryName() + "_s");
		registerModel(Dryer, 1, Dryer.getRegistryName() + "_s");
		registerModel(Trumpet, 1, Trumpet.getRegistryName() + "_s");




		// Blocks
		registerModel(Item.getItemFromBlock(GhostBlox), 0, Item.getItemFromBlock(GhostBlox).getRegistryName() + "", "visible=0");
		registerModel(Item.getItemFromBlock(GhostBlox), 1, Item.getItemFromBlock(Blocks.GLOWSTONE).getRegistryName() + "", "visible=1");
		registerModel(Item.getItemFromBlock(StationOfAwakening), 0, Item.getItemFromBlock(Blocks.GLOWSTONE).getRegistryName() + "", "variant=0");
		registerModel(Item.getItemFromBlock(StationOfAwakening), 1, Item.getItemFromBlock(Blocks.GLOWSTONE).getRegistryName() + "", "variant=1");
		registerModel(Item.getItemFromBlock(StationOfAwakening), 2, Item.getItemFromBlock(Blocks.GLOWSTONE).getRegistryName() + "", "variant=2");
		registerModel(Item.getItemFromBlock(StationOfAwakening), 3, Item.getItemFromBlock(Blocks.GLOWSTONE).getRegistryName() + "", "variant=3");
		registerModel(Item.getItemFromBlock(StationOfAwakening), 4, Item.getItemFromBlock(Blocks.GLOWSTONE).getRegistryName() + "", "variant=4");
		registerModel(Item.getItemFromBlock(StationOfAwakening), 5, Item.getItemFromBlock(Blocks.GLOWSTONE).getRegistryName() + "", "variant=5");
		registerModel(Item.getItemFromBlock(StationOfAwakening), 6, Item.getItemFromBlock(Blocks.GLOWSTONE).getRegistryName() + "", "variant=6");
		registerModel(Item.getItemFromBlock(StationOfAwakening), 7, Item.getItemFromBlock(Blocks.GLOWSTONE).getRegistryName() + "", "variant=7");
		registerModel(Item.getItemFromBlock(StationOfAwakening), 8, Item.getItemFromBlock(Blocks.GLOWSTONE).getRegistryName() + "", "variant=8");
		registerModel(Item.getItemFromBlock(StationOfAwakening), 9, Item.getItemFromBlock(Blocks.GLOWSTONE).getRegistryName() + "", "variant=9");
		registerModel(Item.getItemFromBlock(StationOfAwakening), 10, Item.getItemFromBlock(Blocks.GLOWSTONE).getRegistryName() + "", "variant=10");
		registerModel(Item.getItemFromBlock(StationOfAwakening), 11, Item.getItemFromBlock(Blocks.GLOWSTONE).getRegistryName() + "", "variant=11");
		registerModel(Item.getItemFromBlock(StationOfAwakening), 12, Item.getItemFromBlock(Blocks.GLOWSTONE).getRegistryName() + "", "variant=12");
		registerModel(Item.getItemFromBlock(StationOfAwakening), 13, Item.getItemFromBlock(Blocks.GLOWSTONE).getRegistryName() + "", "variant=13");
		registerModel(Item.getItemFromBlock(StationOfAwakening), 14, Item.getItemFromBlock(Blocks.GLOWSTONE).getRegistryName() + "", "variant=14");
		registerModel(Item.getItemFromBlock(StationOfAwakening), 15, Item.getItemFromBlock(Blocks.GLOWSTONE).getRegistryName() + "", "variant=15");
		registerModel(Item.getItemFromBlock(StationOfAwakening), 16, Item.getItemFromBlock(Blocks.GLOWSTONE).getRegistryName() + "", "variant=16");
		registerModel(Item.getItemFromBlock(NormalBlox));
		registerModel(Item.getItemFromBlock(HardBlox));
		registerModel(Item.getItemFromBlock(MetalBlox));
		registerModel(Item.getItemFromBlock(DangerBlox));
		registerModel(Item.getItemFromBlock(BounceBlox));
		registerModel(Item.getItemFromBlock(BlastBlox));
		registerModel(Item.getItemFromBlock(PrizeBlox));
		registerModel(Item.getItemFromBlock(RarePrizeBlox));
		registerModel(Item.getItemFromBlock(MagnetBlox));
		registerModel(Item.getItemFromBlock(BlazingOre));
		registerModel(Item.getItemFromBlock(BlazingOreN));
		registerModel(Item.getItemFromBlock(BrightOre));
		registerModel(Item.getItemFromBlock(DarkOre));
		registerModel(Item.getItemFromBlock(DarkOreE));
		registerModel(Item.getItemFromBlock(DarkOreN));
		registerModel(Item.getItemFromBlock(DenseOre));
		registerModel(Item.getItemFromBlock(EnergyOre));
		registerModel(Item.getItemFromBlock(EnergyOreN));
		registerModel(Item.getItemFromBlock(FrostOre));
		registerModel(Item.getItemFromBlock(LightningOre));
		registerModel(Item.getItemFromBlock(LucidOre));
		registerModel(Item.getItemFromBlock(PowerOre));
		registerModel(Item.getItemFromBlock(PowerOreE));
		registerModel(Item.getItemFromBlock(RemembranceOre));
		registerModel(Item.getItemFromBlock(SerenityOre));
		registerModel(Item.getItemFromBlock(StormyOre));
		registerModel(Item.getItemFromBlock(TranquilOre));
		registerModel(Item.getItemFromBlock(TwilightOre));
		registerModel(Item.getItemFromBlock(TwilightOreN));
		registerModel(Item.getItemFromBlock(SynthesisTable));
		registerModel(Item.getItemFromBlock(KKChest));
		registerModel(Item.getItemFromBlock(SavePoint));
		registerModel(Item.getItemFromBlock(StationOfAwakeningDoor));
		registerModel(Item.getItemFromBlock(Pedestal));
		registerModel(Item.getItemFromBlock(OrgPortal));
	}

	public static void registerModel(Item item) {
		ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(item.getRegistryName() + "", "inventory"));
	}

	public static void registerModel(Item item, int meta) {
		ModelLoader.setCustomModelResourceLocation(item, meta, new ModelResourceLocation(item.getRegistryName() + "", "inventory"));
	}

	public static void registerModel(Item item, int meta, String name) {
		ModelLoader.setCustomModelResourceLocation(item, meta, new ModelResourceLocation(name, "inventory"));
	}

	public static void registerModel(Item item, int meta, String name, String type) {
		ModelLoader.setCustomModelResourceLocation(item, meta, new ModelResourceLocation(name, type));
	}

	@Override
	public void preInit(FMLPreInitializationEvent event) {
		super.preInit(event);
		RenderingRegistry.registerEntityRenderingHandler(EntityOrgPortal.class, (IRenderFactory) new RenderPortal(Minecraft.getMinecraft().getRenderManager()));
		RenderingRegistry.registerEntityRenderingHandler(EntityBlastBlox.class, new RenderFactoryBlastBlox());

		// Lances
		RenderingRegistry.registerEntityRenderingHandler(EntityZephyr.class, (IRenderFactory) new RenderEntityLance(Minecraft.getMinecraft().getRenderManager(), Strings.Zephyr));

		// Chakrams
		RenderingRegistry.registerEntityRenderingHandler(EntityAshes.class, (IRenderFactory) new RenderEntityChakram(Minecraft.getMinecraft().getRenderManager(),Strings.Ashes));
		RenderingRegistry.registerEntityRenderingHandler(EntityBlazeofGlory.class, (IRenderFactory) new RenderEntityChakram(Minecraft.getMinecraft().getRenderManager(), Strings.BlazeofGlory));
		RenderingRegistry.registerEntityRenderingHandler(EntityBurnout.class, (IRenderFactory) new RenderEntityChakram(Minecraft.getMinecraft().getRenderManager(),Strings.Burnout));
		RenderingRegistry.registerEntityRenderingHandler(EntityCombustion.class, (IRenderFactory) new RenderEntityChakram(Minecraft.getMinecraft().getRenderManager(), Strings.Combustion));
		RenderingRegistry.registerEntityRenderingHandler(EntityDoledrum.class, (IRenderFactory) new RenderEntityChakram(Minecraft.getMinecraft().getRenderManager(), Strings.Doldrums));
		RenderingRegistry.registerEntityRenderingHandler(EntityDoubleEdge.class, (IRenderFactory) new RenderEntityChakram(Minecraft.getMinecraft().getRenderManager(), Strings.DoubleEdge));
		RenderingRegistry.registerEntityRenderingHandler(EntityEternalFlames.class, (IRenderFactory) new RenderEntityChakram(Minecraft.getMinecraft().getRenderManager(), Strings.EternalFlames));
		RenderingRegistry.registerEntityRenderingHandler(EntityFerrisWheels.class, (IRenderFactory) new RenderEntityChakram(Minecraft.getMinecraft().getRenderManager(), Strings.FerrisWheel));
		RenderingRegistry.registerEntityRenderingHandler(EntityIfrit.class, (IRenderFactory) new RenderEntityChakram(Minecraft.getMinecraft().getRenderManager(), Strings.Ifrit));
		RenderingRegistry.registerEntityRenderingHandler(EntityInferno.class, (IRenderFactory) new RenderEntityChakram(Minecraft.getMinecraft().getRenderManager(), Strings.Inferno));
		RenderingRegistry.registerEntityRenderingHandler(EntityMagmaOcean.class, (IRenderFactory) new RenderEntityChakram(Minecraft.getMinecraft().getRenderManager(), Strings.MagmaOcean));
		RenderingRegistry.registerEntityRenderingHandler(EntityMoulinRouge.class, (IRenderFactory) new RenderEntityChakram(Minecraft.getMinecraft().getRenderManager(), Strings.MoulinRouge));
		RenderingRegistry.registerEntityRenderingHandler(EntityProminence.class, (IRenderFactory) new RenderEntityChakram(Minecraft.getMinecraft().getRenderManager(), Strings.Prominence));
		RenderingRegistry.registerEntityRenderingHandler(EntityPrometheus.class, (IRenderFactory) new RenderEntityChakram(Minecraft.getMinecraft().getRenderManager(), Strings.Prometheus));
		RenderingRegistry.registerEntityRenderingHandler(EntityOmegaTrinity.class, (IRenderFactory) new RenderEntityChakram(Minecraft.getMinecraft().getRenderManager(), Strings.OmegaTrinity));
		RenderingRegistry.registerEntityRenderingHandler(EntityOutbreak.class, (IRenderFactory) new RenderEntityChakram(Minecraft.getMinecraft().getRenderManager(), Strings.Outbreak));
		RenderingRegistry.registerEntityRenderingHandler(EntitySizzlingEdge.class, (IRenderFactory) new RenderEntityChakram(Minecraft.getMinecraft().getRenderManager(), Strings.SizzlingEdge));
		RenderingRegistry.registerEntityRenderingHandler(EntityVolcanics.class, (IRenderFactory) new RenderEntityChakram(Minecraft.getMinecraft().getRenderManager(), Strings.Volcanics));
		RenderingRegistry.registerEntityRenderingHandler(EntityCorona.class, (IRenderFactory) new RenderEntityChakram(Minecraft.getMinecraft().getRenderManager(), Strings.Corona));
		RenderingRegistry.registerEntityRenderingHandler(EntityWildfire.class, (IRenderFactory) new RenderEntityChakram(Minecraft.getMinecraft().getRenderManager(), Strings.Wildfire));
		RenderingRegistry.registerEntityRenderingHandler(EntityConformer.class, (IRenderFactory) new RenderEntityChakram(Minecraft.getMinecraft().getRenderManager(), Strings.Conformers));
		RenderingRegistry.registerEntityRenderingHandler(EntityDelayedAction.class, (IRenderFactory) new RenderEntityChakram(Minecraft.getMinecraft().getRenderManager(), Strings.DelayedAction));
		RenderingRegistry.registerEntityRenderingHandler(EntityDiveBombers.class, (IRenderFactory) new RenderEntityChakram(Minecraft.getMinecraft().getRenderManager(), Strings.DiveBombers));




		// Others
		RenderingRegistry.registerEntityRenderingHandler(EntitySharpshooterBullet.class, new RenderFactorySharpshooterBullet());
		RenderingRegistry.registerEntityRenderingHandler(EntityGummiShip.class, (IRenderFactory) new RenderEntityGummiShip(Minecraft.getMinecraft().getRenderManager()));
		RenderingRegistry.registerEntityRenderingHandler(EntityGliderTerra.class, (IRenderFactory) new RenderEntityGliderTerra(Minecraft.getMinecraft().getRenderManager()));
		RenderingRegistry.registerEntityRenderingHandler(EntityGliderAqua.class, (IRenderFactory) new RenderEntityGliderAqua(Minecraft.getMinecraft().getRenderManager()));
		RenderingRegistry.registerEntityRenderingHandler(EntityGliderVentus.class, (IRenderFactory) new RenderEntityGliderVentus(Minecraft.getMinecraft().getRenderManager()));
		RenderingRegistry.registerEntityRenderingHandler(EntityFlyingHeart.class, (IRenderFactory) new RenderEntityFlyingHeart(Minecraft.getMinecraft().getRenderManager()));
		RenderingRegistry.registerEntityRenderingHandler(EntityXPGet.class, (IRenderFactory) new RenderXPGet(Minecraft.getMinecraft().getRenderManager()));
		RenderingRegistry.registerEntityRenderingHandler(EntitySeedBullet.class, (IRenderFactory) new RenderSeedBullet(Minecraft.getMinecraft().getRenderManager()));
		RenderingRegistry.registerEntityRenderingHandler(EntityRock.class, (IRenderFactory) new RenderEntityRock(Minecraft.getMinecraft().getRenderManager()));
		RenderingRegistry.registerEntityRenderingHandler(EntitySlash.class, (IRenderFactory) new RenderEntitySlash(Minecraft.getMinecraft().getRenderManager()));

		// PUREBLOOD
		RenderingRegistry.registerEntityRenderingHandler(EntityShadow.class, (IRenderFactory) new RenderKHMob(Minecraft.getMinecraft().getRenderManager(), new ModelShadow(1D), 1, Strings.Shadow));
		RenderingRegistry.registerEntityRenderingHandler(EntityMegaShadow.class, (IRenderFactory) new RenderKHMob(Minecraft.getMinecraft().getRenderManager(), new ModelShadow(0.5D), 3, Strings.Shadow));
		RenderingRegistry.registerEntityRenderingHandler(EntityGigaShadow.class, (IRenderFactory) new RenderKHMob(Minecraft.getMinecraft().getRenderManager(), new ModelShadow(0.3D), 5, Strings.Shadow));
		RenderingRegistry.registerEntityRenderingHandler(EntityDarkball.class, (IRenderFactory) new RenderKHMob(Minecraft.getMinecraft().getRenderManager(), new ModelDarkball(), 1, Strings.Darkball));
		RenderingRegistry.registerEntityRenderingHandler(EntityShadowGlob.class, (IRenderFactory) new RenderKHMob(Minecraft.getMinecraft().getRenderManager(), new ModelShadowGlob(), 1, Strings.ShadowGlob));
		
		// EMBLEM
		RenderingRegistry.registerEntityRenderingHandler(EntityRedNocturne.class, (IRenderFactory) new RenderKHMob(Minecraft.getMinecraft().getRenderManager(), new ModelRedNocturne(), 1, Strings.RedNocturne));
		RenderingRegistry.registerEntityRenderingHandler(EntityBlueRhapsody.class, (IRenderFactory) new RenderKHMob(Minecraft.getMinecraft().getRenderManager(), new ModelRedNocturne(), 1, Strings.BlueRhapsody));
		RenderingRegistry.registerEntityRenderingHandler(EntityYellowOpera.class, (IRenderFactory) new RenderKHMob(Minecraft.getMinecraft().getRenderManager(), new ModelRedNocturne(), 1, Strings.YellowOpera));
		RenderingRegistry.registerEntityRenderingHandler(EntityGreenRequiem.class, (IRenderFactory) new RenderKHMob(Minecraft.getMinecraft().getRenderManager(), new ModelRedNocturne(), 1, Strings.GreenRequiem));
		RenderingRegistry.registerEntityRenderingHandler(EntitySilverRock.class, (IRenderFactory) new RenderKHMob(Minecraft.getMinecraft().getRenderManager(), new ModelRedNocturne(), 1, Strings.SilverRock));
		RenderingRegistry.registerEntityRenderingHandler(EntityCrimsonJazz.class, (IRenderFactory) new RenderKHMob(Minecraft.getMinecraft().getRenderManager(), new ModelCrimsonJazz(), 1.1F, Strings.CrimsonJazz));
		RenderingRegistry.registerEntityRenderingHandler(EntityEmeraldBlues.class, (IRenderFactory) new RenderKHMob(Minecraft.getMinecraft().getRenderManager(), new ModelCrimsonJazz(), 1.1F, Strings.EmeraldBlues));
		RenderingRegistry.registerEntityRenderingHandler(EntityMinuteBomb.class, (IRenderFactory) new RenderBomb(Minecraft.getMinecraft().getRenderManager(), new ModelMinuteBomb(), 1, Strings.MinuteBomb));
		RenderingRegistry.registerEntityRenderingHandler(EntitySkaterBomb.class, (IRenderFactory) new RenderBomb(Minecraft.getMinecraft().getRenderManager(), new ModelMinuteBomb(), 1.1f, Strings.SkaterBomb));
		RenderingRegistry.registerEntityRenderingHandler(EntityStormBomb.class, (IRenderFactory) new RenderBomb(Minecraft.getMinecraft().getRenderManager(), new ModelMinuteBomb(), 1.1f, Strings.StormBomb));
		RenderingRegistry.registerEntityRenderingHandler(EntityDetonator.class, (IRenderFactory) new RenderBomb(Minecraft.getMinecraft().getRenderManager(), new ModelMinuteBomb(), 1.2f, Strings.Detonator));
		RenderingRegistry.registerEntityRenderingHandler(EntityLargeBody.class, (IRenderFactory) new RenderKHMob(Minecraft.getMinecraft().getRenderManager(), new ModelLargeBody(), 1.4f, Strings.LargeBody));
		RenderingRegistry.registerEntityRenderingHandler(EntityWhiteMushroom.class, (IRenderFactory) new RenderKHMob(Minecraft.getMinecraft().getRenderManager(), new ModelWhiteMushroom(), 1, Strings.WhiteMushroom));
		RenderingRegistry.registerEntityRenderingHandler(EntityDirePlant.class, (IRenderFactory) new RenderKHMob(Minecraft.getMinecraft().getRenderManager(), new ModelDirePlant(), 1, Strings.DirePlant));

		// NOBODIES
		RenderingRegistry.registerEntityRenderingHandler(EntityDusk.class, (IRenderFactory) new RenderKHMob(Minecraft.getMinecraft().getRenderManager(), new ModelDusk(), 1.3F, Strings.Dusk));
		RenderingRegistry.registerEntityRenderingHandler(EntityCreeper.class, (IRenderFactory) new RenderKHCreeper(Minecraft.getMinecraft().getRenderManager(), new ModelCreeper(), 0.8F));

		RenderingRegistry.registerEntityRenderingHandler(EntityMoogle.class, (IRenderFactory) new RenderKHMob(Minecraft.getMinecraft().getRenderManager(), new ModelMoogle(), 1, Strings.Moogle));
		RenderingRegistry.registerEntityRenderingHandler(EntityOrgMoogle.class, (IRenderFactory) new RenderKHMob(Minecraft.getMinecraft().getRenderManager(), new ModelOrgMoogle(), 1, Strings.OrgMoogle));

	}

	@Override
	public void init(FMLInitializationEvent event) {
		super.init(event);
		registerRenders();
		registerKeyBindings();
		RenderLivingBase renderPlayer = Minecraft.getMinecraft().getRenderManager().getSkinMap().get("default");
		renderPlayer.addLayer(new LayerRendererDrive(renderPlayer));
		renderPlayer = Minecraft.getMinecraft().getRenderManager().getSkinMap().get("slim");
		renderPlayer.addLayer(new LayerRendererDrive(renderPlayer));
		MinecraftForge.EVENT_BUS.register(new ClientEventHandler());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityPedestal.class, new TESRPedestal());
	}

	@Override
	public void postInit(FMLPostInitializationEvent e) {
		super.postInit(e);
		Tutorials.initTutorials();
		KingdomKeys.logger.info("Events loaded");
	}

	private void registerRenders() {
		MinecraftForge.EVENT_BUS.register(new GuiPlayerPortrait());
		MinecraftForge.EVENT_BUS.register(new GuiCommandMenu());
		MinecraftForge.EVENT_BUS.register(new GuiHP());
		MinecraftForge.EVENT_BUS.register(new GuiMP());
		MinecraftForge.EVENT_BUS.register(new GuiLockOn());
		MinecraftForge.EVENT_BUS.register(new GuiOverlay());
		MinecraftForge.EVENT_BUS.register(new GuiDrive());
		DevCapes.getInstance().registerConfig("https://www.dropbox.com/s/bcu19osjxthpnq8/Capes.json?raw=1");
	}

	@Override
	public void spawnTestParticle(World world, double posX, double posY, double posZ, double motionX, double motionY, double motionZ, float alpha) {
		Particle particleTest = new EntityParticleFXTest(new ResourceLocation(Reference.MODID, "textures/fx/flame.png"), world, posX, posY, posZ, motionX, motionY, motionZ, alpha);
		Minecraft.getMinecraft().effectRenderer.addEffect(particleTest);
	}

	public void spawnDarkSmokeParticle(World world, double posX, double posY, double posZ, double motionX, double motionY, double motionZ, float alpha) {
		Particle particleTest = new EntityParticleFXTest(new ResourceLocation(Reference.MODID, "textures/fx/darksmoke.png"), world, posX, posY, posZ, motionX, motionY, motionZ, alpha);
		Minecraft.getMinecraft().effectRenderer.addEffect(particleTest);
	}

	private void registerKeyBindings() {
		MinecraftForge.EVENT_BUS.register(new InputHandler());
		for (InputHandler.Keybinds key : InputHandler.Keybinds.values())
			ClientRegistry.registerKeyBinding(key.getKeybind());
	}

	@Override
	public EntityPlayer getPlayerEntity(MessageContext ctx) {
		return (ctx.side.isClient() ? Minecraft.getMinecraft().player : super.getPlayerEntity(ctx));
	}

	@Override
	public IThreadListener getThreadFromContext(MessageContext ctx) {
		return (ctx.side.isClient() ? Minecraft.getMinecraft() : super.getThreadFromContext(ctx));
	}

	@Override
	public boolean isDedicatedServer() {
		return false;
	}
}
