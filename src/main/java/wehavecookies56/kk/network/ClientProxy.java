package wehavecookies56.kk.network;

import com.jadarstudios.developercapes.DevCapes;

import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelCow;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.IThreadListener;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;
import wehavecookies56.kk.block.ModBlocks;
import wehavecookies56.kk.client.gui.GuiCommandMenu;
import wehavecookies56.kk.client.gui.GuiDrive;
import wehavecookies56.kk.client.gui.GuiHP;
import wehavecookies56.kk.client.gui.GuiHead;
import wehavecookies56.kk.client.gui.GuiMP;
import wehavecookies56.kk.client.keys.InputHandler;
import wehavecookies56.kk.client.keys.Keybinds;
import wehavecookies56.kk.client.render.RenderBlastBlox;
import wehavecookies56.kk.entities.block.EntityBlastBlox;
import wehavecookies56.kk.item.ModItems;

public class ClientProxy extends CommonProxy {

	@Override
	public void init(){
		registerRenders();
		registerKeyBindings();
	}

	private void registerRenders(){
		MinecraftForge.EVENT_BUS.register(new GuiCommandMenu());
		MinecraftForge.EVENT_BUS.register(new GuiHP());
		//MinecraftForge.EVENT_BUS.register(new GuiMP());
		MinecraftForge.EVENT_BUS.register(new GuiDrive());
		MinecraftForge.EVENT_BUS.register(new GuiHead());
		ModItems.registerRenders();
		ModBlocks.registerRenders();
		DevCapes.getInstance().registerConfig("https://www.dropbox.com/s/hb0wg5ky5wblz9g/Capes.json?raw=1");
		RenderingRegistry.registerEntityRenderingHandler(EntityBlastBlox.class, new RenderBlastBlox(Minecraft.getMinecraft().getRenderManager()));
		}

	private void registerKeyBindings(){
		FMLCommonHandler.instance().bus().register(new InputHandler());
		MinecraftForge.EVENT_BUS.register(new InputHandler());
		for(Keybinds key : Keybinds.values()){
			ClientRegistry.registerKeyBinding(key.getKeybind());
		}
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
