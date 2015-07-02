package wehavecookies56.kk.client.keys;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.InputEvent;
import wehavecookies56.kk.client.gui.GuiCommandMenu;
import wehavecookies56.kk.entities.ExtendedPlayer;
import wehavecookies56.kk.item.ItemKeyblade;
import wehavecookies56.kk.item.ItemKeychain;
import wehavecookies56.kk.lib.Reference;
import wehavecookies56.kk.magic.Magic;
import wehavecookies56.kk.network.CommonProxy;
import wehavecookies56.kk.network.packet.PacketDispatcher;
import wehavecookies56.kk.network.packet.client.SyncExtendedPlayer;
import wehavecookies56.kk.network.packet.server.DeSummonKeyblade;
import wehavecookies56.kk.network.packet.server.PlaySoundAtPlayer;
import wehavecookies56.kk.network.packet.server.SummonKeyblade;
import wehavecookies56.kk.util.GuiHelper;
import wehavecookies56.kk.util.SoundHelper;

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
		World world = mc.theWorld;

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
					if (GuiCommandMenu.magicselected >= 0 && GuiCommandMenu.magicselected <= GuiCommandMenu.FIRE)
					{
						GuiCommandMenu.magicselected++;
						GuiCommandMenu.submenu = 1;

					}
					else if (GuiCommandMenu.magicselected == 8)
					{
						GuiCommandMenu.magicselected = GuiCommandMenu.STOP;
					}
					System.out.println(GuiCommandMenu.magicselected);
				}

				else if(GuiCommandMenu.submenu == GuiCommandMenu.SUB_ITEMS)//InsideItems
				{

				}

				else if(GuiCommandMenu.submenu == GuiCommandMenu.SUB_DRIVE)//InsideDrive
				{
					if (GuiCommandMenu.driveselected >= 0 && GuiCommandMenu.driveselected <= GuiCommandMenu.VALOR)
					{
						GuiCommandMenu.driveselected++;
						GuiCommandMenu.submenu = 3;
					}
					else if (GuiCommandMenu.driveselected == 6)
					{
						GuiCommandMenu.driveselected = GuiCommandMenu.FINAL;
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
					System.out.println(GuiCommandMenu.driveselected);

				}

				else if(GuiCommandMenu.submenu == GuiCommandMenu.SUB_MAGIC)//InsideMagic
				{
					if (GuiCommandMenu.magicselected > 0 && GuiCommandMenu.magicselected <= GuiCommandMenu.FIRE)
					{
						GuiCommandMenu.magicselected--;
						GuiCommandMenu.submenu = 1;

					}
					else if (GuiCommandMenu.magicselected == 0 || GuiCommandMenu.magicselected == 8)
					{
						GuiCommandMenu.magicselected = GuiCommandMenu.FIRE;
					}
					System.out.println(GuiCommandMenu.magicselected);
				}

				else if(GuiCommandMenu.submenu == GuiCommandMenu.SUB_ITEMS)//InsideItems
				{

				}

				else if(GuiCommandMenu.submenu == GuiCommandMenu.SUB_DRIVE)//InsideDrive
				{
					if (GuiCommandMenu.driveselected > 0 && GuiCommandMenu.driveselected <= GuiCommandMenu.VALOR)
					{
						GuiCommandMenu.driveselected--;
						GuiCommandMenu.submenu = 3;

					}
					else if (GuiCommandMenu.driveselected == 0)
					{
						GuiCommandMenu.driveselected = GuiCommandMenu.VALOR;
					}
				}
				break;

			case ENTER:
				switch(GuiCommandMenu.selected)
				{
				case GuiCommandMenu.MAGIC:
					if(GuiCommandMenu.submenu == GuiCommandMenu.SUB_MAIN)
					GuiCommandMenu.magicselected = GuiCommandMenu.NONE;
					GuiCommandMenu.submenu = GuiCommandMenu.SUB_MAGIC;
					break;

				case GuiCommandMenu.ITEMS:
					//GuiCommandMenu.submenu = GuiCommandMenu.SUB_ITEMS;
					break;

				case GuiCommandMenu.DRIVE:
					GuiCommandMenu.driveselected = GuiCommandMenu.NONE;
					GuiCommandMenu.submenu = GuiCommandMenu.SUB_DRIVE;
					break;
				}
				if(GuiCommandMenu.selected == GuiCommandMenu.MAGIC && GuiCommandMenu.submenu == GuiCommandMenu.SUB_MAGIC)
				{
					switch(GuiCommandMenu.magicselected)
					{
						case GuiCommandMenu.FIRE:
							Magic.Fire(player, world);
							GuiCommandMenu.selected = GuiCommandMenu.ATTACK;
							GuiCommandMenu.submenu = GuiCommandMenu.SUB_MAIN;
							break;

						case GuiCommandMenu.BLIZZARD:
							Magic.Ice(player, world);
							GuiCommandMenu.selected = GuiCommandMenu.ATTACK;
							GuiCommandMenu.submenu = GuiCommandMenu.SUB_MAIN;
							break;
						case GuiCommandMenu.THUNDER:
							Magic.Thunder(player, world);
							GuiCommandMenu.selected = GuiCommandMenu.ATTACK;
							GuiCommandMenu.submenu = GuiCommandMenu.SUB_MAIN;
							break;
						case GuiCommandMenu.CURE:
							Magic.Cure(player, world);
							GuiCommandMenu.selected = GuiCommandMenu.ATTACK;
							GuiCommandMenu.submenu = GuiCommandMenu.SUB_MAIN;
							break;
					
					}
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
					PacketDispatcher.sendToServer(new PlaySoundAtPlayer(SoundHelper.Error, 0.5f, 1f));
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
			case SCROLL_ACTIVATOR:
				break;
			default:
				break;
			}
		}
	}
}
