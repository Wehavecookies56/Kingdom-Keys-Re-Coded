package wehavecookies56.kk.client.keys;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
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
		Minecraft mc = Minecraft.getMinecraft();
		EntityPlayer player = mc.thePlayer;

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
				ExtendedPlayer props = ExtendedPlayer.get(mc.thePlayer);
				if(props.inventory.getStackInSlot(0) == null){
					break;
				}
				if(props.getSummonedKeyblade() == 0 && player.inventory.getCurrentItem() == null && props.inventory.getStackInSlot(0).getItem() instanceof ItemKeychain){
					PacketDispatcher.sendToServer(new SummonKeyblade(((ItemKeychain) props.inventory.getStackInSlot(0).getItem()).getKeyblade()));
					PacketDispatcher.sendToServer(new SyncExtendedPlayer(player));
				} else if(player.inventory.getCurrentItem() != null && player.inventory.getCurrentItem().getItem() instanceof ItemKeyblade && props.getSummonedKeyblade() == 1){
					PacketDispatcher.sendToServer(new DeSummonKeyblade(player.inventory.getCurrentItem()));
					PacketDispatcher.sendToServer(new SyncExtendedPlayer(player));
				} else {
					break;
				}
				break;
			}
		}
	}
}
