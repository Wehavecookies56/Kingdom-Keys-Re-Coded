package wehavecookies56.kk.client.keys;

import net.minecraft.client.Minecraft;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.InputEvent;
import wehavecookies56.kk.client.gui.GuiCommandMenu;
import wehavecookies56.kk.entities.ExtendedPlayer;
import wehavecookies56.kk.item.ItemKeyblade;
import wehavecookies56.kk.item.ItemKeychain;
import wehavecookies56.kk.network.CommonProxy;
import wehavecookies56.kk.network.DeSummonKeyblade;
import wehavecookies56.kk.network.SummonKeyblade;
import wehavecookies56.kk.network.PacketDispatcher;
import wehavecookies56.kk.network.SyncExtendedPlayer;
import wehavecookies56.kk.util.GuiHelper;

public class KeybindHandler {

	private Keybinds getPressedKey(){
		for(Keybinds key : Keybinds.values()){
			if(key.isPressed()) return key;
		}
		return null;
	}
	
	@SubscribeEvent
	public void handleKeyInputEvent(InputEvent.KeyInputEvent event){
		System.out.println(ExtendedPlayer.get(Minecraft.getMinecraft().thePlayer).getSummonedKeyblade());

		Keybinds key = getPressedKey();
		if(key != null){
			switch(key){
				case OPENMENU:
					GuiHelper.openMenu();
					break;
				case SCROLL_UP:
					if(GuiCommandMenu.submenu == GuiCommandMenu.SUB_MAIN) //Mainmenu
					{
						if(GuiCommandMenu.selected == GuiCommandMenu.ATTACK){
							GuiCommandMenu.selected = GuiCommandMenu.DRIVE;
						}else{
							GuiCommandMenu.selected++;
						}
					}

					else if(GuiCommandMenu.submenu == GuiCommandMenu.SUB_MAGIC)//InsideMagic
					{
						if(GuiCommandMenu.magicselected == GuiCommandMenu.FIRE){
							GuiCommandMenu.magicselected = GuiCommandMenu.STOP;
						}else{
							GuiCommandMenu.magicselected++;
						}
					}
					
					else if(GuiCommandMenu.submenu == GuiCommandMenu.SUB_ITEMS)//InsideItems
					{
						
					}
					
					else if(GuiCommandMenu.submenu == GuiCommandMenu.SUB_DRIVE)//InsideDrive
					{
						if(GuiCommandMenu.driveselected == GuiCommandMenu.VALOR){
							GuiCommandMenu.driveselected = GuiCommandMenu.FINAL;
						}else{
							GuiCommandMenu.driveselected++;
						}
					}
					
					break;
				case SCROLL_DOWN:
					if(GuiCommandMenu.submenu == GuiCommandMenu.SUB_MAIN) //Mainmenu
					{
						if(GuiCommandMenu.selected == GuiCommandMenu.DRIVE){
							GuiCommandMenu.selected = GuiCommandMenu.ATTACK;
						}else{
							GuiCommandMenu.selected--;
						}
					}

					else if(GuiCommandMenu.submenu == GuiCommandMenu.SUB_MAGIC)//InsideMagic
					{
						if(GuiCommandMenu.magicselected == GuiCommandMenu.STOP){
							GuiCommandMenu.magicselected = GuiCommandMenu.FIRE;
						}else{
							GuiCommandMenu.magicselected--;
						}
					}
					
					else if(GuiCommandMenu.submenu == GuiCommandMenu.SUB_ITEMS)//InsideItems
					{
						
					}
					
					else if(GuiCommandMenu.submenu == GuiCommandMenu.SUB_DRIVE)//InsideDrive
					{
						if(GuiCommandMenu.driveselected == GuiCommandMenu.FINAL){
							GuiCommandMenu.driveselected = GuiCommandMenu.VALOR;
						}else{
							GuiCommandMenu.driveselected--;
						}
					}
					break;
				
				case ENTER:
					switch(GuiCommandMenu.selected)
					{
					case GuiCommandMenu.MAGIC:
						GuiCommandMenu.magicselected = GuiCommandMenu.FIRE;
						GuiCommandMenu.submenu = GuiCommandMenu.SUB_MAGIC;
						break;
					
					case GuiCommandMenu.ITEMS:
						//GuiCommandMenu.submenu = GuiCommandMenu.SUB_ITEMS;
						break;
					
					case GuiCommandMenu.DRIVE:
						GuiCommandMenu.driveselected = GuiCommandMenu.VALOR;
						GuiCommandMenu.submenu = GuiCommandMenu.SUB_DRIVE;
						break;
					}
					break;
				
				case BACK:
					if (GuiCommandMenu.submenu == GuiCommandMenu.SUB_MAIN)
					{
						GuiCommandMenu.submenu = GuiCommandMenu.SUB_MAIN;
					}
					else if (GuiCommandMenu.submenu == GuiCommandMenu.SUB_MAGIC)
					{
						GuiCommandMenu.submenu = GuiCommandMenu.SUB_MAIN;
					}
					else if (GuiCommandMenu.submenu == GuiCommandMenu.SUB_ITEMS)
					{
						GuiCommandMenu.submenu = GuiCommandMenu.SUB_MAIN;
					}
					else if (GuiCommandMenu.submenu == GuiCommandMenu.SUB_DRIVE)
					{
						GuiCommandMenu.submenu = GuiCommandMenu.SUB_MAIN;
					}
					GuiCommandMenu.magicselected = GuiCommandMenu.MAGIC;
					GuiCommandMenu.driveselected = GuiCommandMenu.DRIVE;
					break;
				case SUMMON_KEYBLADE:
					if(Minecraft.getMinecraft().thePlayer.inventory.getCurrentItem() == null && ExtendedPlayer.get(Minecraft.getMinecraft().thePlayer).inventory.getStackInSlot(0).getItem() instanceof ItemKeychain && ExtendedPlayer.get(Minecraft.getMinecraft().thePlayer).getSummonedKeyblade() == 0){
						PacketDispatcher.sendToServer(new SyncExtendedPlayer(Minecraft.getMinecraft().thePlayer));
						PacketDispatcher.sendToServer(new SummonKeyblade(((ItemKeychain) ExtendedPlayer.get(Minecraft.getMinecraft().thePlayer).inventory.getStackInSlot(0).getItem()).getKeyblade()));
						System.out.println(ExtendedPlayer.get(Minecraft.getMinecraft().thePlayer).getSummonedKeyblade());
					} else if(Minecraft.getMinecraft().thePlayer.inventory.getCurrentItem() != null){
						if(Minecraft.getMinecraft().thePlayer.inventory.getCurrentItem().getItem() instanceof ItemKeyblade && ExtendedPlayer.get(Minecraft.getMinecraft().thePlayer).getSummonedKeyblade() == 1){
							PacketDispatcher.sendToServer(new SyncExtendedPlayer(Minecraft.getMinecraft().thePlayer));

							PacketDispatcher.sendToServer(new DeSummonKeyblade(Minecraft.getMinecraft().thePlayer.inventory.getCurrentItem()));
							System.out.println(ExtendedPlayer.get(Minecraft.getMinecraft().thePlayer).getSummonedKeyblade());
						}
					} else {
						break;
					}
					break;
			}
		}
	}
}
