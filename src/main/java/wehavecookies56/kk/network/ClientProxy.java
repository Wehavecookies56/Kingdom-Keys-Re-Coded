package wehavecookies56.kk.network;

import com.jadarstudios.developercapes.DevCapes;

import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.util.IThreadListener;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.client.model.b3d.B3DLoader;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;
import wehavecookies56.kk.achievements.ModAchievements;
import wehavecookies56.kk.block.ModBlocks;
import wehavecookies56.kk.client.gui.GuiCommandMenu;
import wehavecookies56.kk.client.gui.GuiDrive;
import wehavecookies56.kk.client.gui.GuiHP;
import wehavecookies56.kk.client.gui.GuiMP;
import wehavecookies56.kk.client.gui.GuiOverlay;
import wehavecookies56.kk.client.gui.GuiPlayerPortrait;
import wehavecookies56.kk.client.input.InputHandler;
import wehavecookies56.kk.client.input.Keybinds;
import wehavecookies56.kk.client.render.RenderBlastBlox;
import wehavecookies56.kk.client.render.RenderEntityBlizzard;
import wehavecookies56.kk.client.render.RenderEntityEternalFlames;
import wehavecookies56.kk.client.render.RenderEntityItemKeyblade;
import wehavecookies56.kk.entities.EntityItemMetalChocobo;
import wehavecookies56.kk.entities.block.EntityBlastBlox;
import wehavecookies56.kk.entities.magic.EntityBlizzard;
import wehavecookies56.kk.entities.magic.EntityOldFire;
import wehavecookies56.kk.entities.projectiles.EntityEternalFlamesProjectile;
import wehavecookies56.kk.item.ModItems;
import wehavecookies56.kk.lib.Reference;
import wehavecookies56.kk.lib.Strings;
import wehavecookies56.kk.util.LogHelper;

public class ClientProxy extends CommonProxy {

	@Override
	public void preInit(){
		B3DLoader.instance.addDomain(Reference.MODID);
		ModelLoader.setCustomModelResourceLocation(ModItems.Arpeggio, 0, new ModelResourceLocation(Reference.MODID + ":" + Strings.Arpeggio, "inventory"));
		ModelLoader.setCustomModelResourceLocation(ModItems.BlazeofGlory, 0, new ModelResourceLocation(Reference.MODID + ":" + Strings.BlazeofGlory, "inventory"));
		ModelLoader.setCustomModelResourceLocation(ModItems.BondofFlame, 0, new ModelResourceLocation(Reference.MODID + ":" + Strings.BondofFlame, "inventory"));
		ModelLoader.setCustomModelResourceLocation(ModItems.CircleofLife, 0, new ModelResourceLocation(Reference.MODID + ":" + Strings.CircleofLife, "inventory"));
		ModelLoader.setCustomModelResourceLocation(ModItems.Crabclaw, 0, new ModelResourceLocation(Reference.MODID + ":" + Strings.Crabclaw, "inventory"));
		ModelLoader.setCustomModelResourceLocation(ModItems.DecisivePumpkin, 0, new ModelResourceLocation(Reference.MODID + ":" + Strings.DecisivePumpkin, "inventory"));
		ModelLoader.setCustomModelResourceLocation(ModItems.DestinysEmbrace, 0, new ModelResourceLocation(Reference.MODID + ":" + Strings.DestinysEmbrace, "inventory"));
		ModelLoader.setCustomModelResourceLocation(ModItems.DiamondDust, 0, new ModelResourceLocation(Reference.MODID + ":" + Strings.DiamondDust, "inventory"));
		ModelLoader.setCustomModelResourceLocation(ModItems.DivineRose, 0, new ModelResourceLocation(Reference.MODID + ":" + Strings.DivineRose, "inventory"));
		ModelLoader.setCustomModelResourceLocation(ModItems.DreamSword, 0, new ModelResourceLocation(Reference.MODID + ":" + Strings.DreamSword, "inventory"));
		ModelLoader.setCustomModelResourceLocation(ModItems.EternalFlames, 0, new ModelResourceLocation(Reference.MODID + ":" + Strings.EternalFlames, "inventory"));
		ModelLoader.setCustomModelResourceLocation(ModItems.FairyHarp, 0, new ModelResourceLocation(Reference.MODID + ":" + Strings.FairyHarp, "inventory"));
		ModelLoader.setCustomModelResourceLocation(ModItems.FatalCrest, 0, new ModelResourceLocation(Reference.MODID + ":" + Strings.FatalCrest, "inventory"));
		ModelLoader.setCustomModelResourceLocation(ModItems.Fenrir, 0, new ModelResourceLocation(Reference.MODID + ":" + Strings.Fenrir, "inventory"));
		ModelLoader.setCustomModelResourceLocation(ModItems.FollowtheWind, 0, new ModelResourceLocation(Reference.MODID + ":" + Strings.FollowtheWind, "inventory"));
		ModelLoader.setCustomModelResourceLocation(ModItems.GuardianSoul, 0, new ModelResourceLocation(Reference.MODID + ":" + Strings.GuardianSoul, "inventory"));
		ModelLoader.setCustomModelResourceLocation(ModItems.GullWing, 0, new ModelResourceLocation(Reference.MODID + ":" + Strings.GullWing, "inventory"));
		ModelLoader.setCustomModelResourceLocation(ModItems.HerosCrest, 0, new ModelResourceLocation(Reference.MODID + ":" + Strings.HerosCrest, "inventory"));
		ModelLoader.setCustomModelResourceLocation(ModItems.HiddenDragon, 0, new ModelResourceLocation(Reference.MODID + ":" + Strings.HiddenDragon, "inventory"));
		ModelLoader.setCustomModelResourceLocation(ModItems.IncompleteKiblade, 0, new ModelResourceLocation(Reference.MODID + ":" + Strings.IncompleteKiblade, "inventory"));
		ModelLoader.setCustomModelResourceLocation(ModItems.JungleKing, 0, new ModelResourceLocation(Reference.MODID + ":" + Strings.JungleKing, "inventory"));
		ModelLoader.setCustomModelResourceLocation(ModItems.KeybladeofPeoplesHearts, 0, new ModelResourceLocation(Reference.MODID + ":" + Strings.KeybladeofPeoplesHearts, "inventory"));
		ModelLoader.setCustomModelResourceLocation(ModItems.Kiblade, 0, new ModelResourceLocation(Reference.MODID + ":" + Strings.Kiblade, "inventory"));
		ModelLoader.setCustomModelResourceLocation(ModItems.KingdomKey, 0, new ModelResourceLocation(Reference.MODID + ":" + Strings.KingdomKey, "inventory"));
		ModelLoader.setCustomModelResourceLocation(ModItems.KingdomKeyD, 0, new ModelResourceLocation(Reference.MODID + ":" + Strings.KingdomKeyD, "inventory"));
		ModelLoader.setCustomModelResourceLocation(ModItems.LadyLuck, 0, new ModelResourceLocation(Reference.MODID + ":" + Strings.LadyLuck, "inventory"));
		ModelLoader.setCustomModelResourceLocation(ModItems.Lionheart, 0, new ModelResourceLocation(Reference.MODID + ":" + Strings.Lionheart, "inventory"));
		ModelLoader.setCustomModelResourceLocation(ModItems.MastersDefender, 0, new ModelResourceLocation(Reference.MODID + ":" + Strings.MastersDefender, "inventory"));
		ModelLoader.setCustomModelResourceLocation(ModItems.MasterXehanortsKeyblade, 0, new ModelResourceLocation(Reference.MODID + ":" + Strings.MasterXehanortsKeyblade, "inventory"));
		ModelLoader.setCustomModelResourceLocation(ModItems.MetalChocobo, 0, new ModelResourceLocation(Reference.MODID + ":" + Strings.MetalChocobo, "inventory"));
		ModelLoader.setCustomModelResourceLocation(ModItems.Monochrome, 0, new ModelResourceLocation(Reference.MODID + ":" + Strings.Monochrome, "inventory"));
		ModelLoader.setCustomModelResourceLocation(ModItems.MysteriousAbyss, 0, new ModelResourceLocation(Reference.MODID + ":" + Strings.MysteriousAbyss, "inventory"));
		ModelLoader.setCustomModelResourceLocation(ModItems.Oathkeeper, 0, new ModelResourceLocation(Reference.MODID + ":" + Strings.Oathkeeper, "inventory"));
		ModelLoader.setCustomModelResourceLocation(ModItems.Oblivion, 0, new ModelResourceLocation(Reference.MODID + ":" + Strings.Oblivion, "inventory"));
		ModelLoader.setCustomModelResourceLocation(ModItems.Olympia, 0, new ModelResourceLocation(Reference.MODID + ":" + Strings.Olympia, "inventory"));
		ModelLoader.setCustomModelResourceLocation(ModItems.OneWingedAngel, 0, new ModelResourceLocation(Reference.MODID + ":" + Strings.OneWingedAngel, "inventory"));
		ModelLoader.setCustomModelResourceLocation(ModItems.PhotonDebugger, 0, new ModelResourceLocation(Reference.MODID + ":" + Strings.PhotonDebugger, "inventory"));
		ModelLoader.setCustomModelResourceLocation(ModItems.Pumpkinhead, 0, new ModelResourceLocation(Reference.MODID + ":" + Strings.Pumpkinhead, "inventory"));
		ModelLoader.setCustomModelResourceLocation(ModItems.Rainfell, 0, new ModelResourceLocation(Reference.MODID + ":" + Strings.Rainfell, "inventory"));
		ModelLoader.setCustomModelResourceLocation(ModItems.RumblingRose, 0, new ModelResourceLocation(Reference.MODID + ":" + Strings.RumblingRose, "inventory"));
		ModelLoader.setCustomModelResourceLocation(ModItems.SleepingLion, 0, new ModelResourceLocation(Reference.MODID + ":" + Strings.SleepingLion, "inventory"));
		ModelLoader.setCustomModelResourceLocation(ModItems.SoulEater, 0, new ModelResourceLocation(Reference.MODID + ":" + Strings.SoulEater, "inventory"));
		ModelLoader.setCustomModelResourceLocation(ModItems.Spellbinder, 0, new ModelResourceLocation(Reference.MODID + ":" + Strings.Spellbinder, "inventory"));
		ModelLoader.setCustomModelResourceLocation(ModItems.StarSeeker, 0, new ModelResourceLocation(Reference.MODID + ":" + Strings.StarSeeker, "inventory"));
		ModelLoader.setCustomModelResourceLocation(ModItems.SweetMemories, 0, new ModelResourceLocation(Reference.MODID + ":" + Strings.SweetMemories, "inventory"));
		ModelLoader.setCustomModelResourceLocation(ModItems.ThreeWishes, 0, new ModelResourceLocation(Reference.MODID + ":" + Strings.ThreeWishes, "inventory"));
		ModelLoader.setCustomModelResourceLocation(ModItems.TwoBecomeOne, 0, new ModelResourceLocation(Reference.MODID + ":" + Strings.TwoBecomeOne, "inventory"));
		ModelLoader.setCustomModelResourceLocation(ModItems.UltimaWeaponKH1, 0, new ModelResourceLocation(Reference.MODID + ":" + Strings.UltimaWeaponKH1, "inventory"));
		ModelLoader.setCustomModelResourceLocation(ModItems.UltimaWeaponKH2, 0, new ModelResourceLocation(Reference.MODID + ":" + Strings.UltimaWeaponKH2, "inventory"));
		ModelLoader.setCustomModelResourceLocation(ModItems.WaytotheDawn, 0, new ModelResourceLocation(Reference.MODID + ":" + Strings.WaytotheDawn, "inventory"));
		ModelLoader.setCustomModelResourceLocation(ModItems.WinnersProof, 0, new ModelResourceLocation(Reference.MODID + ":" + Strings.WinnersProof, "inventory"));
		ModelLoader.setCustomModelResourceLocation(ModItems.WishingLamp, 0, new ModelResourceLocation(Reference.MODID + ":" + Strings.WishingLamp, "inventory"));
		ModelLoader.setCustomModelResourceLocation(ModItems.WishingStar, 0, new ModelResourceLocation(Reference.MODID + ":" + Strings.WishingStar, "inventory"));
		ModelLoader.setCustomModelResourceLocation(ModItems.WoodenKeyblade, 0, new ModelResourceLocation(Reference.MODID + ":" + Strings.WoodenKeyblade, "inventory"));
		ModelLoader.setCustomModelResourceLocation(ModItems.WoodenStick, 0, new ModelResourceLocation(Reference.MODID + ":" + Strings.WoodenStick, "inventory"));

		ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(ModBlocks.KKChest), 0, new ModelResourceLocation(Reference.MODID + ":" + Strings.KKChest, "inventory"));

	}

	@Override
	public void init(){
		registerRenders();
		registerKeyBindings();
		registerAchievements();
	}

	private void registerRenders(){
		MinecraftForge.EVENT_BUS.register(new GuiPlayerPortrait());
		MinecraftForge.EVENT_BUS.register(new GuiCommandMenu());
		MinecraftForge.EVENT_BUS.register(new GuiHP());
		MinecraftForge.EVENT_BUS.register(new GuiMP());
		MinecraftForge.EVENT_BUS.register(new GuiOverlay());
		MinecraftForge.EVENT_BUS.register(new GuiDrive());
		ModItems.registerRenders();
		ModBlocks.registerRenders();
		DevCapes.getInstance().registerConfig("https://www.dropbox.com/s/hb0wg5ky5wblz9g/Capes.json?raw=1");
		RenderingRegistry.registerEntityRenderingHandler(EntityBlastBlox.class, new RenderBlastBlox(Minecraft.getMinecraft().getRenderManager()));
		RenderingRegistry.registerEntityRenderingHandler(EntityOldFire.class, null);
		RenderingRegistry.registerEntityRenderingHandler(EntityItemMetalChocobo.class, new RenderEntityItemKeyblade());
		RenderingRegistry.registerEntityRenderingHandler(EntityBlizzard.class, new RenderEntityBlizzard());
		RenderingRegistry.registerEntityRenderingHandler(EntityEternalFlamesProjectile.class, new RenderEntityEternalFlames(Minecraft.getMinecraft().getRenderManager()));
	}

	private void registerKeyBindings(){
		FMLCommonHandler.instance().bus().register(new InputHandler());
		MinecraftForge.EVENT_BUS.register(new InputHandler());
		for(Keybinds key : Keybinds.values()){
			ClientRegistry.registerKeyBinding(key.getKeybind());
		}
	}

	private void registerAchievements(){
		//Achievements
		ModAchievements.init();
		ModAchievements.register();
		LogHelper.info("Achievements loaded");
	}

	@Override
	public EntityPlayer getPlayerEntity(MessageContext ctx) {
		return (ctx.side.isClient() ? Minecraft.getMinecraft().thePlayer : super.getPlayerEntity(ctx));
	}

	@Override
	public IThreadListener getThreadFromContext(MessageContext ctx) {
		return (ctx.side.isClient() ? Minecraft.getMinecraft() : super.getThreadFromContext(ctx));
	}

}
