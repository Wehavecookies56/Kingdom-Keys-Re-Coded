package uk.co.wehavecookies56.kk.client.core.proxy;

import static uk.co.wehavecookies56.kk.common.block.ModBlocks.BlastBlox;
import static uk.co.wehavecookies56.kk.common.block.ModBlocks.BlazingOre;
import static uk.co.wehavecookies56.kk.common.block.ModBlocks.BlazingOreN;
import static uk.co.wehavecookies56.kk.common.block.ModBlocks.BounceBlox;
import static uk.co.wehavecookies56.kk.common.block.ModBlocks.BrightOre;
import static uk.co.wehavecookies56.kk.common.block.ModBlocks.DangerBlox;
import static uk.co.wehavecookies56.kk.common.block.ModBlocks.DarkOre;
import static uk.co.wehavecookies56.kk.common.block.ModBlocks.DarkOreE;
import static uk.co.wehavecookies56.kk.common.block.ModBlocks.DarkOreN;
import static uk.co.wehavecookies56.kk.common.block.ModBlocks.DenseOre;
import static uk.co.wehavecookies56.kk.common.block.ModBlocks.EnergyOre;
import static uk.co.wehavecookies56.kk.common.block.ModBlocks.EnergyOreN;
import static uk.co.wehavecookies56.kk.common.block.ModBlocks.FrostOre;
import static uk.co.wehavecookies56.kk.common.block.ModBlocks.GhostBlox;
import static uk.co.wehavecookies56.kk.common.block.ModBlocks.HardBlox;
import static uk.co.wehavecookies56.kk.common.block.ModBlocks.KKChest;
import static uk.co.wehavecookies56.kk.common.block.ModBlocks.LightningOre;
import static uk.co.wehavecookies56.kk.common.block.ModBlocks.LucidOre;
import static uk.co.wehavecookies56.kk.common.block.ModBlocks.MagnetBlox;
import static uk.co.wehavecookies56.kk.common.block.ModBlocks.MetalBlox;
import static uk.co.wehavecookies56.kk.common.block.ModBlocks.NormalBlox;
import static uk.co.wehavecookies56.kk.common.block.ModBlocks.OrgPortal;
import static uk.co.wehavecookies56.kk.common.block.ModBlocks.Pedestal;
import static uk.co.wehavecookies56.kk.common.block.ModBlocks.PowerOre;
import static uk.co.wehavecookies56.kk.common.block.ModBlocks.PowerOreE;
import static uk.co.wehavecookies56.kk.common.block.ModBlocks.PrizeBlox;
import static uk.co.wehavecookies56.kk.common.block.ModBlocks.RarePrizeBlox;
import static uk.co.wehavecookies56.kk.common.block.ModBlocks.RemembranceOre;
import static uk.co.wehavecookies56.kk.common.block.ModBlocks.SavePoint;
import static uk.co.wehavecookies56.kk.common.block.ModBlocks.SerenityOre;
import static uk.co.wehavecookies56.kk.common.block.ModBlocks.StationOfAwakening;
import static uk.co.wehavecookies56.kk.common.block.ModBlocks.StationOfAwakeningDoor;
import static uk.co.wehavecookies56.kk.common.block.ModBlocks.StormyOre;
import static uk.co.wehavecookies56.kk.common.block.ModBlocks.SynthesisTable;
import static uk.co.wehavecookies56.kk.common.block.ModBlocks.TranquilOre;
import static uk.co.wehavecookies56.kk.common.block.ModBlocks.TwilightOre;
import static uk.co.wehavecookies56.kk.common.block.ModBlocks.TwilightOreN;
import static uk.co.wehavecookies56.kk.common.item.ModItems.*;

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
import uk.co.wehavecookies56.kk.client.gui.GuiCommandMenu;
import uk.co.wehavecookies56.kk.client.gui.GuiDrive;
import uk.co.wehavecookies56.kk.client.gui.GuiHP;
import uk.co.wehavecookies56.kk.client.gui.GuiLockOn;
import uk.co.wehavecookies56.kk.client.gui.GuiMP;
import uk.co.wehavecookies56.kk.client.gui.GuiOverlay;
import uk.co.wehavecookies56.kk.client.gui.GuiPlayerPortrait;
import uk.co.wehavecookies56.kk.client.model.mobs.*;
import uk.co.wehavecookies56.kk.client.render.*;
import uk.co.wehavecookies56.kk.client.render.chakrams.RenderEntityAshes;
import uk.co.wehavecookies56.kk.client.render.chakrams.RenderEntityBlazeofGlory;
import uk.co.wehavecookies56.kk.client.render.chakrams.RenderEntityBurnout;
import uk.co.wehavecookies56.kk.client.render.chakrams.RenderEntityCombustion;
import uk.co.wehavecookies56.kk.client.render.chakrams.RenderEntityDoledrum;
import uk.co.wehavecookies56.kk.client.render.chakrams.RenderEntityDoubleEdge;
import uk.co.wehavecookies56.kk.client.render.chakrams.RenderEntityEternalFlames;
import uk.co.wehavecookies56.kk.client.render.chakrams.RenderEntityFerrisWheel;
import uk.co.wehavecookies56.kk.client.render.chakrams.RenderEntityIfrit;
import uk.co.wehavecookies56.kk.client.render.chakrams.RenderEntityInferno;
import uk.co.wehavecookies56.kk.client.render.chakrams.RenderEntityMoulinRouge;
import uk.co.wehavecookies56.kk.client.render.chakrams.RenderEntityOmegaTrinity;
import uk.co.wehavecookies56.kk.client.render.chakrams.RenderEntityOutbreak;
import uk.co.wehavecookies56.kk.client.render.chakrams.RenderEntityPrometheus;
import uk.co.wehavecookies56.kk.client.render.chakrams.RenderEntityProminence;
import uk.co.wehavecookies56.kk.client.render.chakrams.RenderEntitySizzlingEdge;
import uk.co.wehavecookies56.kk.client.render.lances.RenderEntityZephyr;
import uk.co.wehavecookies56.kk.common.KingdomKeys;
import uk.co.wehavecookies56.kk.common.block.tile.TileEntityPedestal;
import uk.co.wehavecookies56.kk.common.core.proxy.CommonProxy;
import uk.co.wehavecookies56.kk.common.entity.EntityGummiShip;
import uk.co.wehavecookies56.kk.common.entity.block.EntityBlastBlox;
import uk.co.wehavecookies56.kk.common.entity.magic.EntityOrgPortal;
import uk.co.wehavecookies56.kk.common.entity.mobs.*;
import uk.co.wehavecookies56.kk.common.entity.projectiles.EntitySharpshooterBullet;
import uk.co.wehavecookies56.kk.common.entity.projectiles.chakrams.EntityAshes;
import uk.co.wehavecookies56.kk.common.entity.projectiles.chakrams.EntityBlazeofGlory;
import uk.co.wehavecookies56.kk.common.entity.projectiles.chakrams.EntityBurnout;
import uk.co.wehavecookies56.kk.common.entity.projectiles.chakrams.EntityCombustion;
import uk.co.wehavecookies56.kk.common.entity.projectiles.chakrams.EntityDoledrum;
import uk.co.wehavecookies56.kk.common.entity.projectiles.chakrams.EntityDoubleEdge;
import uk.co.wehavecookies56.kk.common.entity.projectiles.chakrams.EntityEternalFlames;
import uk.co.wehavecookies56.kk.common.entity.projectiles.chakrams.EntityFerrisWheels;
import uk.co.wehavecookies56.kk.common.entity.projectiles.chakrams.EntityIfrit;
import uk.co.wehavecookies56.kk.common.entity.projectiles.chakrams.EntityInferno;
import uk.co.wehavecookies56.kk.common.entity.projectiles.chakrams.EntityMoulinRouge;
import uk.co.wehavecookies56.kk.common.entity.projectiles.chakrams.EntityOmegaTrinity;
import uk.co.wehavecookies56.kk.common.entity.projectiles.chakrams.EntityOutbreak;
import uk.co.wehavecookies56.kk.common.entity.projectiles.chakrams.EntityPrometheus;
import uk.co.wehavecookies56.kk.common.entity.projectiles.chakrams.EntityProminence;
import uk.co.wehavecookies56.kk.common.entity.projectiles.chakrams.EntitySizzlingEdge;
import uk.co.wehavecookies56.kk.common.entity.projectiles.lances.EntityZephyr;
import uk.co.wehavecookies56.kk.common.item.ModItems;
import uk.co.wehavecookies56.kk.common.lib.Reference;

@Mod.EventBusSubscriber(value = Side.CLIENT, modid = Reference.MODID)
public class ClientProxy extends CommonProxy {

    @SubscribeEvent
    public static void registerModels(ModelRegistryEvent event) {
        B3DLoader.INSTANCE.addDomain(Reference.MODID);
        OBJLoader.INSTANCE.addDomain(Reference.MODID);

        for (Item i : ModItems.ITEMS) {
            registerModel(i);
        }
        //Berserk
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

        //Blocks
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
    public void preInit (FMLPreInitializationEvent event) {
        super.preInit(event);
        RenderingRegistry.registerEntityRenderingHandler(EntityOrgPortal.class, (IRenderFactory) new RenderPortal(Minecraft.getMinecraft().getRenderManager()));
        RenderingRegistry.registerEntityRenderingHandler(EntityBlastBlox.class, new RenderFactoryBlastBlox());
        
        //Lances
        RenderingRegistry.registerEntityRenderingHandler(EntityZephyr.class, (IRenderFactory) new RenderEntityZephyr(Minecraft.getMinecraft().getRenderManager()));
        
        //Chakrams
        RenderingRegistry.registerEntityRenderingHandler(EntityMoulinRouge.class, (IRenderFactory) new RenderEntityMoulinRouge(Minecraft.getMinecraft().getRenderManager()));
        RenderingRegistry.registerEntityRenderingHandler(EntityEternalFlames.class, (IRenderFactory) new RenderEntityEternalFlames(Minecraft.getMinecraft().getRenderManager()));
        RenderingRegistry.registerEntityRenderingHandler(EntityIfrit.class, (IRenderFactory) new RenderEntityIfrit(Minecraft.getMinecraft().getRenderManager()));
        RenderingRegistry.registerEntityRenderingHandler(EntityProminence.class, (IRenderFactory) new RenderEntityProminence(Minecraft.getMinecraft().getRenderManager()));
        RenderingRegistry.registerEntityRenderingHandler(EntityPrometheus.class, (IRenderFactory) new RenderEntityPrometheus(Minecraft.getMinecraft().getRenderManager()));
        RenderingRegistry.registerEntityRenderingHandler(EntityBlazeofGlory.class, (IRenderFactory) new RenderEntityBlazeofGlory(Minecraft.getMinecraft().getRenderManager()));
        RenderingRegistry.registerEntityRenderingHandler(EntityAshes.class, (IRenderFactory) new RenderEntityAshes(Minecraft.getMinecraft().getRenderManager()));
        RenderingRegistry.registerEntityRenderingHandler(EntityOmegaTrinity.class, (IRenderFactory) new RenderEntityOmegaTrinity(Minecraft.getMinecraft().getRenderManager()));
        RenderingRegistry.registerEntityRenderingHandler(EntityCombustion.class, (IRenderFactory) new RenderEntityCombustion(Minecraft.getMinecraft().getRenderManager()));
        RenderingRegistry.registerEntityRenderingHandler(EntityFerrisWheels.class, (IRenderFactory) new RenderEntityFerrisWheel(Minecraft.getMinecraft().getRenderManager()));
        RenderingRegistry.registerEntityRenderingHandler(EntityBurnout.class, (IRenderFactory) new RenderEntityBurnout(Minecraft.getMinecraft().getRenderManager()));
        RenderingRegistry.registerEntityRenderingHandler(EntityDoledrum.class, (IRenderFactory) new RenderEntityDoledrum(Minecraft.getMinecraft().getRenderManager()));
        RenderingRegistry.registerEntityRenderingHandler(EntityInferno.class, (IRenderFactory) new RenderEntityInferno(Minecraft.getMinecraft().getRenderManager()));
        RenderingRegistry.registerEntityRenderingHandler(EntityOutbreak.class, (IRenderFactory) new RenderEntityOutbreak(Minecraft.getMinecraft().getRenderManager()));
        RenderingRegistry.registerEntityRenderingHandler(EntitySizzlingEdge.class, (IRenderFactory) new RenderEntitySizzlingEdge(Minecraft.getMinecraft().getRenderManager()));
        RenderingRegistry.registerEntityRenderingHandler(EntityDoubleEdge.class, (IRenderFactory) new RenderEntityDoubleEdge(Minecraft.getMinecraft().getRenderManager()));

        RenderingRegistry.registerEntityRenderingHandler(EntitySharpshooterBullet.class, new RenderFactorySharpshooterBullet());
        RenderingRegistry.registerEntityRenderingHandler(EntityGummiShip.class, (IRenderFactory) new RenderEntityGummiShip(Minecraft.getMinecraft().getRenderManager()));

        
        RenderingRegistry.registerEntityRenderingHandler(EntityShadow.class, (IRenderFactory) new RenderKHMob(Minecraft.getMinecraft().getRenderManager(), new ModelShadow(1D), 1, "shadow"));
        RenderingRegistry.registerEntityRenderingHandler(EntityMegaShadow.class, (IRenderFactory) new RenderKHMob(Minecraft.getMinecraft().getRenderManager(), new ModelShadow(0.5D), 3, "shadow"));
        RenderingRegistry.registerEntityRenderingHandler(EntityGigaShadow.class, (IRenderFactory) new RenderKHMob(Minecraft.getMinecraft().getRenderManager(), new ModelShadow(0.3D), 5, "shadow"));
        RenderingRegistry.registerEntityRenderingHandler(EntityRedNocturne.class, (IRenderFactory) new RenderKHMob(Minecraft.getMinecraft().getRenderManager(), new ModelRedNocturne(), 1, "rednocturne"));
        RenderingRegistry.registerEntityRenderingHandler(EntityBlueRhapsody.class, (IRenderFactory) new RenderKHMob(Minecraft.getMinecraft().getRenderManager(), new ModelRedNocturne(), 1, "bluerhapsody"));
        RenderingRegistry.registerEntityRenderingHandler(EntityYellowOpera.class, (IRenderFactory) new RenderKHMob(Minecraft.getMinecraft().getRenderManager(), new ModelRedNocturne(), 1, "yellowopera"));
        RenderingRegistry.registerEntityRenderingHandler(EntityGreenRequiem.class, (IRenderFactory) new RenderKHMob(Minecraft.getMinecraft().getRenderManager(), new ModelRedNocturne(), 1, "greenrequiem"));
        RenderingRegistry.registerEntityRenderingHandler(EntitySilverRock.class, (IRenderFactory) new RenderKHMob(Minecraft.getMinecraft().getRenderManager(), new ModelRedNocturne(), 1, "silverrock"));
        RenderingRegistry.registerEntityRenderingHandler(EntityCrimsonJazz.class, (IRenderFactory) new RenderKHMob(Minecraft.getMinecraft().getRenderManager(), new ModelCrimsonJazz(), 1.1F, "crimsonjazz"));
        RenderingRegistry.registerEntityRenderingHandler(EntityEmeraldBlues.class, (IRenderFactory) new RenderKHMob(Minecraft.getMinecraft().getRenderManager(), new ModelCrimsonJazz(), 1.1F, "emeraldblues"));
        RenderingRegistry.registerEntityRenderingHandler(EntityMoogle.class, (IRenderFactory) new RenderKHMob(Minecraft.getMinecraft().getRenderManager(), new ModelMoogle(), 1, "moogle"));
        RenderingRegistry.registerEntityRenderingHandler(EntityDarkball.class, (IRenderFactory) new RenderKHMob(Minecraft.getMinecraft().getRenderManager(), new ModelDarkball(), 1, "darkball"));
        RenderingRegistry.registerEntityRenderingHandler(EntityMinuteBomb.class, (IRenderFactory) new RenderKHMob(Minecraft.getMinecraft().getRenderManager(), new ModelMinuteBomb(), 1, "minutebomb"));
        RenderingRegistry.registerEntityRenderingHandler(EntitySkaterBomb.class, (IRenderFactory) new RenderKHMob(Minecraft.getMinecraft().getRenderManager(), new ModelMinuteBomb(), 1.1f, "skaterbomb"));
        RenderingRegistry.registerEntityRenderingHandler(EntityStormBomb.class, (IRenderFactory) new RenderKHMob(Minecraft.getMinecraft().getRenderManager(), new ModelMinuteBomb(), 1.1f, "stormbomb"));
        RenderingRegistry.registerEntityRenderingHandler(EntityDetonator.class, (IRenderFactory) new RenderKHMob(Minecraft.getMinecraft().getRenderManager(), new ModelMinuteBomb(), 1.2f, "detonator"));
    }

    @Override
    public void init (FMLInitializationEvent event) {
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
    public void postInit (FMLPostInitializationEvent e) {
        super.postInit(e);
        KingdomKeys.logger.info("Events loaded");
    }

    private void registerRenders () {
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
    public void spawnTestParticle (World world, double posX, double posY, double posZ, double motionX, double motionY, double motionZ, float alpha) {
        Particle particleTest = new EntityParticleFXTest(new ResourceLocation(Reference.MODID, "textures/fx/flame.png"), world, posX, posY, posZ, motionX, motionY, motionZ, alpha);
        Minecraft.getMinecraft().effectRenderer.addEffect(particleTest);
    }

    public void spawnDarkSmokeParticle(World world, double posX, double posY, double posZ, double motionX, double motionY, double motionZ, float alpha) 
    {
        Particle particleTest = new EntityParticleFXTest(new ResourceLocation(Reference.MODID, "textures/fx/darksmoke.png"), world, posX, posY, posZ, motionX, motionY, motionZ, alpha);
        Minecraft.getMinecraft().effectRenderer.addEffect(particleTest);
    }
    
    private void registerKeyBindings () {
        MinecraftForge.EVENT_BUS.register(new InputHandler());
        for (InputHandler.Keybinds key : InputHandler.Keybinds.values())
            ClientRegistry.registerKeyBinding(key.getKeybind());
    }

    @Override
    public EntityPlayer getPlayerEntity (MessageContext ctx) {
        return (ctx.side.isClient() ? Minecraft.getMinecraft().player : super.getPlayerEntity(ctx));
    }

    @Override
    public IThreadListener getThreadFromContext (MessageContext ctx) {
        return (ctx.side.isClient() ? Minecraft.getMinecraft() : super.getThreadFromContext(ctx));
    }

}
