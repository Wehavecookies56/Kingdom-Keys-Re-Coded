package wehavecookies56.kk.network;

import com.jadarstudios.developercapes.DevCapes;

import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.entity.player.EntityPlayer;
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
import wehavecookies56.kk.client.gui.GuiPlayerPortrait;
import wehavecookies56.kk.client.input.InputHandler;
import wehavecookies56.kk.client.input.Keybinds;
import wehavecookies56.kk.client.render.RenderBlastBlox;
import wehavecookies56.kk.entities.block.EntityBlastBlox;
import wehavecookies56.kk.entities.magic.EntityFire;
import wehavecookies56.kk.item.ModItems;
import wehavecookies56.kk.lib.Reference;
import wehavecookies56.kk.lib.Strings;
import wehavecookies56.kk.util.LogHelper;

public class ClientProxy extends CommonProxy {

	@Override
	public void preInit(){
		B3DLoader.instance.addDomain(Reference.MODID);

		ModelLoader.setCustomModelResourceLocation(ModItems.KingdomKey, 0, new ModelResourceLocation(Reference.MODID + ":" + Strings.KingdomKey, "inventory"));
		ModelLoader.setCustomModelResourceLocation(ModItems.Crabclaw, 0, new ModelResourceLocation(Reference.MODID + ":" + Strings.Crabclaw, "inventory"));
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
		MinecraftForge.EVENT_BUS.register(new GuiDrive());
		ModItems.registerRenders();
		ModBlocks.registerRenders();
		DevCapes.getInstance().registerConfig("https://www.dropbox.com/s/hb0wg5ky5wblz9g/Capes.json?raw=1");
		RenderingRegistry.registerEntityRenderingHandler(EntityBlastBlox.class, new RenderBlastBlox(Minecraft.getMinecraft().getRenderManager()));
		RenderingRegistry.registerEntityRenderingHandler(EntityFire.class, null);
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
