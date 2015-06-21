package wehavecookies56.kk.network;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.common.FMLCommonHandler;
import wehavecookies56.kk.block.ModBlocks;
import wehavecookies56.kk.client.gui.GuiCommandMenu;
import wehavecookies56.kk.client.keys.KeybindHandler;
import wehavecookies56.kk.client.keys.Keybinds;
import wehavecookies56.kk.item.ModItems;

public class ClientProxy extends CommonProxy {

	@Override
	public void init(){
		registerRenders();
		registerKeyBindings();
	}
	
	private void registerRenders(){
		MinecraftForge.EVENT_BUS.register(new GuiCommandMenu());
		ModItems.registerRenders();
		ModBlocks.registerRenders();
	}
	
	private void registerKeyBindings(){
		FMLCommonHandler.instance().bus().register(new KeybindHandler());
		for(Keybinds key : Keybinds.values()){
			ClientRegistry.registerKeyBinding(key.getKeybind());
		}
	}
	
}
