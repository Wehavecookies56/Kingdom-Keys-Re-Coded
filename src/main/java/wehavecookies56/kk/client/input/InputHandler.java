package wehavecookies56.kk.client.input;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import net.minecraftforge.client.event.MouseEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.InputEvent;
import wehavecookies56.kk.client.gui.GuiCommandMenu;
import wehavecookies56.kk.driveforms.ModDriveForms;
import wehavecookies56.kk.entities.ExtendedPlayer;
import wehavecookies56.kk.item.ItemKKPotion;
import wehavecookies56.kk.item.ItemKeyblade;
import wehavecookies56.kk.item.ItemKeychain;
import wehavecookies56.kk.lib.Constants;
import wehavecookies56.kk.magic.Magic;
import wehavecookies56.kk.network.packet.PacketDispatcher;
import wehavecookies56.kk.network.packet.client.SyncExtendedPlayer;
import wehavecookies56.kk.network.packet.server.AntiPoints;
import wehavecookies56.kk.network.packet.server.DeSummonKeyblade;
import wehavecookies56.kk.network.packet.server.DriveFormPacket;
import wehavecookies56.kk.network.packet.server.GiveAchievementOpenMenu;
import wehavecookies56.kk.network.packet.server.SummonKeyblade;
import wehavecookies56.kk.util.GuiHelper;
import wehavecookies56.kk.util.KeyboardHelper;
import wehavecookies56.kk.util.SoundHelper;

public class InputHandler {

	private Keybinds getPressedKey () {
		for (Keybinds key : Keybinds.values())
			if (key.isPressed()) return key;
		return null;
	}

	public boolean antiFormCheck () {
		double random = Math.random();
		int ap = ExtendedPlayer.get(Minecraft.getMinecraft().thePlayer).getAntiPoints();
		int prob = 0;
		if (ap > 0 && ap <= 4)
			prob = 10;
		else if (ap > 4 && ap <= 9)
			prob = 25;
		else if (ap >= 10) prob = 40;

		if (random * 100 < prob) {
			PacketDispatcher.sendToServer(new DriveFormPacket("Anti"));
			GuiCommandMenu.selected = GuiCommandMenu.ATTACK;
			GuiCommandMenu.submenu = GuiCommandMenu.SUB_MAIN;
			PacketDispatcher.sendToServer(new AntiPoints(4, "-"));
			Minecraft.getMinecraft().theWorld.playSound(Minecraft.getMinecraft().thePlayer.posX, Minecraft.getMinecraft().thePlayer.posY, Minecraft.getMinecraft().thePlayer.posZ, SoundHelper.Select, 1f, 1f, false);

			return true;
		} else
			return false;
	}

	public void commandUp () {
		// Mainmenu
		if (GuiCommandMenu.submenu == GuiCommandMenu.SUB_MAIN) {
			if (GuiCommandMenu.selected == GuiCommandMenu.ATTACK)
				GuiCommandMenu.selected = GuiCommandMenu.DRIVE;
			else
				GuiCommandMenu.selected++;
		}
		// InsideMagic
		else if (GuiCommandMenu.submenu == GuiCommandMenu.SUB_MAGIC) {
			if (GuiCommandMenu.magicselected > 0) {
				GuiCommandMenu.magicselected--;
				GuiCommandMenu.submenu = GuiCommandMenu.SUB_MAGIC;
			} else if (GuiCommandMenu.magicselected <= 1) GuiCommandMenu.magicselected = ExtendedPlayer.spells.size() - 1;
		}
		// InsideItems
		else if (GuiCommandMenu.submenu == GuiCommandMenu.SUB_ITEMS) {
			if (GuiCommandMenu.potionselected > 0) {
				GuiCommandMenu.potionselected--;
				GuiCommandMenu.submenu = GuiCommandMenu.SUB_ITEMS;
			} else if (GuiCommandMenu.potionselected <= 1) GuiCommandMenu.potionselected = ExtendedPlayer.items.size() - 1;
		}
		// InsideDrive
		else if (GuiCommandMenu.submenu == GuiCommandMenu.SUB_DRIVE) if (GuiCommandMenu.driveselected > 0) {
			GuiCommandMenu.driveselected--;
			GuiCommandMenu.submenu = GuiCommandMenu.SUB_DRIVE;
		} else if (GuiCommandMenu.driveselected <= 1) GuiCommandMenu.driveselected = ExtendedPlayer.driveForms.size() - 1;
	}

	public void commandDown () {
		// Mainmenu
		if (GuiCommandMenu.submenu == GuiCommandMenu.SUB_MAIN) {
			if (GuiCommandMenu.selected == GuiCommandMenu.DRIVE)
				GuiCommandMenu.selected = GuiCommandMenu.ATTACK;
			else
				GuiCommandMenu.selected--;
		}
		// InsideMagic
		else if (GuiCommandMenu.submenu == GuiCommandMenu.SUB_MAGIC) {
			if (GuiCommandMenu.magicselected < ExtendedPlayer.spells.size() - 1) {
				GuiCommandMenu.magicselected++;
				GuiCommandMenu.submenu = GuiCommandMenu.SUB_MAGIC;
			} else if (GuiCommandMenu.magicselected >= ExtendedPlayer.spells.size() - 1) GuiCommandMenu.magicselected = 0;
		}
		// InsideItems
		else if (GuiCommandMenu.submenu == GuiCommandMenu.SUB_ITEMS) {
			ExtendedPlayer.get(Minecraft.getMinecraft().thePlayer);
			if (GuiCommandMenu.potionselected < ExtendedPlayer.items.size() - 1) {
				GuiCommandMenu.potionselected++;
				GuiCommandMenu.submenu = GuiCommandMenu.SUB_ITEMS;
			} else {
				ExtendedPlayer.get(Minecraft.getMinecraft().thePlayer);
				if (GuiCommandMenu.potionselected >= ExtendedPlayer.items.size() - 1) GuiCommandMenu.potionselected = 0;
			}
		}
		// InsideDrive
		else if (GuiCommandMenu.submenu == GuiCommandMenu.SUB_DRIVE) {
			ExtendedPlayer.get(Minecraft.getMinecraft().thePlayer);
			if (GuiCommandMenu.driveselected < ExtendedPlayer.driveForms.size() - 1) {
				GuiCommandMenu.driveselected++;
				GuiCommandMenu.submenu = GuiCommandMenu.SUB_DRIVE;
			} else {
				ExtendedPlayer.get(Minecraft.getMinecraft().thePlayer);
				if (GuiCommandMenu.driveselected >= ExtendedPlayer.driveForms.size() - 1) GuiCommandMenu.driveselected = 0;
			}
		}
	}

	public void commandEnter () {
		Minecraft mc = Minecraft.getMinecraft();
		EntityPlayer player = mc.thePlayer;
		World world = mc.theWorld;

		switch (GuiCommandMenu.selected) {
			case GuiCommandMenu.MAGIC:
				if (GuiCommandMenu.submenu == GuiCommandMenu.SUB_MAIN) {
					if (ExtendedPlayer.get(player).getRecharge() == false && (!ExtendedPlayer.spells.isEmpty() && !ExtendedPlayer.get(player).getDriveInUse().equals("Valor"))) {
						GuiCommandMenu.magicselected = 0;
						GuiCommandMenu.submenu = GuiCommandMenu.SUB_MAGIC;
						world.playSound(player.posX, player.posY, player.posZ, SoundHelper.Select, 1f, 1f, false);
						return;
					} else {
						GuiCommandMenu.selected = GuiCommandMenu.ATTACK;
						world.playSound(player.posX, player.posY, player.posZ, SoundHelper.Error, 2f, 1f, false);
					}
				}
				break;

			case GuiCommandMenu.ITEMS:
				if (GuiCommandMenu.submenu == GuiCommandMenu.SUB_MAIN) {
					if (!ExtendedPlayer.items.isEmpty()) {
						GuiCommandMenu.submenu = GuiCommandMenu.SUB_ITEMS;
						GuiCommandMenu.potionselected = 0;
						world.playSound(player.posX, player.posY, player.posZ, SoundHelper.Select, 1f, 1f, false);
					} else {
						GuiCommandMenu.selected = GuiCommandMenu.ATTACK;
						world.playSound(player.posX, player.posY, player.posZ, SoundHelper.Error, 2f, 1f, false);
					}
					return;
				}
				break;

			case GuiCommandMenu.DRIVE:
				if (GuiCommandMenu.submenu == GuiCommandMenu.SUB_MAIN) {
					if (ExtendedPlayer.get(player).getInDrive()) {// Revert
						if (ExtendedPlayer.get(player).getDriveInUse().equals("Anti") && ExtendedPlayer.get(player).cheatMode == false) {
							GuiCommandMenu.selected = GuiCommandMenu.ATTACK;
							world.playSound(player.posX, player.posY, player.posZ, SoundHelper.Error, 2f, 1f, false);
						} else {
							PacketDispatcher.sendToServer(new DriveFormPacket(true));
							GuiCommandMenu.submenu = GuiCommandMenu.SUB_MAIN;
							GuiCommandMenu.selected = GuiCommandMenu.ATTACK;
							world.playSound(player.posX, player.posY, player.posZ, SoundHelper.Select, 1f, 1f, false);
						}
					} else if (ExtendedPlayer.driveForms.isEmpty() || ExtendedPlayer.get(player).getDP() > 0) {
						world.playSound(player.posX, player.posY, player.posZ, SoundHelper.Error, 1f, 1f, false);
						GuiCommandMenu.selected = GuiCommandMenu.ATTACK;
					} else {
						GuiCommandMenu.driveselected = 0;
						GuiCommandMenu.submenu = GuiCommandMenu.SUB_DRIVE;
						world.playSound(player.posX, player.posY, player.posZ, SoundHelper.Select, 1f, 1f, false);
						return;
					}
				}
				break;
		}
		if (GuiCommandMenu.selected == GuiCommandMenu.MAGIC && GuiCommandMenu.submenu == GuiCommandMenu.SUB_MAGIC) {
			if (ExtendedPlayer.spells.isEmpty()) {} else if (!ExtendedPlayer.get(player).getRecharge() || Constants.getCost(ExtendedPlayer.spells.get(GuiCommandMenu.magicselected)) == -1 && ExtendedPlayer.get(player).getMp() > 0) {
				Magic.getMagic(player, world, ExtendedPlayer.spells.get(GuiCommandMenu.magicselected));
				GuiCommandMenu.selected = GuiCommandMenu.ATTACK;
				GuiCommandMenu.submenu = GuiCommandMenu.SUB_MAIN;
				world.playSound(player.posX, player.posY, player.posZ, SoundHelper.Select, 1f, 1f, false);
			}
		}

		if (GuiCommandMenu.selected == GuiCommandMenu.ITEMS && GuiCommandMenu.submenu == GuiCommandMenu.SUB_ITEMS) {
			if (ExtendedPlayer.items.isEmpty()) {} else if (!ExtendedPlayer.items.isEmpty()) {
				ItemKKPotion.getItem(player, world, ExtendedPlayer.items.get(GuiCommandMenu.potionselected), GuiCommandMenu.potionselected);

				GuiCommandMenu.selected = GuiCommandMenu.ATTACK;
				GuiCommandMenu.submenu = GuiCommandMenu.SUB_MAIN;
				world.playSound(player.posX, player.posY, player.posZ, SoundHelper.Select, 1f, 1f, false);
			}
		}

		if (GuiCommandMenu.selected == GuiCommandMenu.DRIVE && GuiCommandMenu.submenu == GuiCommandMenu.SUB_DRIVE) {
			if (ExtendedPlayer.driveForms.isEmpty()) {} else if ((ExtendedPlayer.get(player).getDP() >= Constants.getCost(ExtendedPlayer.driveForms.get(GuiCommandMenu.driveselected))) || ExtendedPlayer.get(player).getDP() > 0) {
				ModDriveForms.getDriveForm(player, world, ExtendedPlayer.driveForms.get(GuiCommandMenu.driveselected));
				GuiCommandMenu.selected = GuiCommandMenu.ATTACK;
				GuiCommandMenu.submenu = GuiCommandMenu.SUB_MAIN;
				world.playSound(player.posX, player.posY, player.posZ, SoundHelper.Select, 1f, 1f, false);
			}
		}
	}

	public void commandBack () {
		if (GuiCommandMenu.submenu == GuiCommandMenu.SUB_MAIN)
			GuiCommandMenu.submenu = GuiCommandMenu.SUB_MAIN;
		else if (GuiCommandMenu.submenu == GuiCommandMenu.SUB_MAGIC) {
			GuiCommandMenu.submenu = GuiCommandMenu.SUB_MAIN;
			Minecraft.getMinecraft().theWorld.playSound(Minecraft.getMinecraft().thePlayer.posX, Minecraft.getMinecraft().thePlayer.posY, Minecraft.getMinecraft().thePlayer.posZ, SoundHelper.Cancel, 1f, 1f, false);
		} else if (GuiCommandMenu.submenu == GuiCommandMenu.SUB_ITEMS) {
			GuiCommandMenu.submenu = GuiCommandMenu.SUB_MAIN;
			Minecraft.getMinecraft().theWorld.playSound(Minecraft.getMinecraft().thePlayer.posX, Minecraft.getMinecraft().thePlayer.posY, Minecraft.getMinecraft().thePlayer.posZ, SoundHelper.Cancel, 1f, 1f, false);
		} else if (GuiCommandMenu.submenu == GuiCommandMenu.SUB_DRIVE) {
			GuiCommandMenu.submenu = GuiCommandMenu.SUB_MAIN;
			Minecraft.getMinecraft().theWorld.playSound(Minecraft.getMinecraft().thePlayer.posX, Minecraft.getMinecraft().thePlayer.posY, Minecraft.getMinecraft().thePlayer.posZ, SoundHelper.Cancel, 1f, 1f, false);
		}
		GuiCommandMenu.magicselected = 0;
		GuiCommandMenu.driveselected = 0;
	}

	@SubscribeEvent
	public void handleKeyInputEvent (InputEvent.KeyInputEvent event) {
		Minecraft mc = Minecraft.getMinecraft();
		EntityPlayer player = mc.thePlayer;
		World world = mc.theWorld;

		Keybinds key = getPressedKey();
		if (key != null) switch (key) {
			case OPENMENU:
				GuiHelper.openMenu();
				PacketDispatcher.sendToServer(new GiveAchievementOpenMenu());
				break;
			case SCROLL_UP:
				commandUp();
				Minecraft.getMinecraft().theWorld.playSound(Minecraft.getMinecraft().thePlayer.posX, Minecraft.getMinecraft().thePlayer.posY, Minecraft.getMinecraft().thePlayer.posZ, SoundHelper.Move, 1f, 1f, false);
				break;

			case SCROLL_DOWN:
				commandDown();
				Minecraft.getMinecraft().theWorld.playSound(Minecraft.getMinecraft().thePlayer.posX, Minecraft.getMinecraft().thePlayer.posY, Minecraft.getMinecraft().thePlayer.posZ, SoundHelper.Move, 1f, 1f, false);
				break;

			case ENTER:
				commandEnter();
				break;

			case BACK:
				commandBack();
				break;
			case SUMMON_KEYBLADE:
				ExtendedPlayer props = ExtendedPlayer.get(mc.thePlayer);
				if (props.inventoryKeychain.getStackInSlot(0) == null) {
					Minecraft.getMinecraft().theWorld.playSound(Minecraft.getMinecraft().thePlayer.posX, Minecraft.getMinecraft().thePlayer.posY, Minecraft.getMinecraft().thePlayer.posZ, SoundHelper.Error, 2f, 1f, false);
					break;
				}
				if (props.isKeybladeSummoned() == false && player.inventory.getCurrentItem() == null && props.inventoryKeychain.getStackInSlot(0).getItem() instanceof ItemKeychain) {
					PacketDispatcher.sendToServer(new SummonKeyblade(((ItemKeychain) props.inventoryKeychain.getStackInSlot(0).getItem()).getKeyblade()));
					PacketDispatcher.sendToServer(new SyncExtendedPlayer(player));
				} else if (player.inventory.getCurrentItem() != null && player.inventory.getCurrentItem().getItem() instanceof ItemKeyblade && props.isKeybladeSummoned() == true) {
					PacketDispatcher.sendToServer(new DeSummonKeyblade(player.inventory.getCurrentItem()));
					PacketDispatcher.sendToServer(new SyncExtendedPlayer(player));
				} else
					break;
				break;
			case SCROLL_ACTIVATOR:
				break;
			default:
				break;
		}
	}

	@SubscribeEvent
	public void OnMouseWheelScroll (MouseEvent event) {
		Minecraft mc = Minecraft.getMinecraft();
		EntityPlayer player = mc.thePlayer;
		World world = mc.theWorld;
		if (!mc.inGameHasFocus && !KeyboardHelper.isScrollActivatorDown()) {
			event.setCanceled(false);
			return;
		}

		if (event.button == Constants.LEFT_MOUSE && KeyboardHelper.isScrollActivatorDown() && event.buttonstate) {
			commandEnter();
			event.setCanceled(true);
		}

		if (event.button == Constants.RIGHT_MOUSE && KeyboardHelper.isScrollActivatorDown() && event.buttonstate) {
			commandBack();
			event.setCanceled(true);
		}

		if (event.dwheel <= Constants.WHEEL_DOWN && KeyboardHelper.isScrollActivatorDown() && event.dwheel != 0) {
			commandDown();
			event.setCanceled(true);
			Minecraft.getMinecraft().theWorld.playSound(Minecraft.getMinecraft().thePlayer.posX, Minecraft.getMinecraft().thePlayer.posY, Minecraft.getMinecraft().thePlayer.posZ, SoundHelper.Move, 1f, 1f, false);
		}
		if (event.dwheel >= Constants.WHEEL_UP && KeyboardHelper.isScrollActivatorDown() && event.dwheel != 0) {
			commandUp();
			event.setCanceled(true);
			Minecraft.getMinecraft().theWorld.playSound(Minecraft.getMinecraft().thePlayer.posX, Minecraft.getMinecraft().thePlayer.posY, Minecraft.getMinecraft().thePlayer.posZ, SoundHelper.Move, 1f, 1f, false);
		}

	}
}
