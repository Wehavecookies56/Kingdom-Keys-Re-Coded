package uk.co.wehavecookies56.kk.client.gui;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.GL11;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import uk.co.wehavecookies56.kk.api.abilities.Ability;
import uk.co.wehavecookies56.kk.common.ability.ModAbilities;
import uk.co.wehavecookies56.kk.common.capability.AbilitiesCapability.IAbilities;
import uk.co.wehavecookies56.kk.common.capability.DriveStateCapability.IDriveState;
import uk.co.wehavecookies56.kk.common.capability.ModCapabilities;
import uk.co.wehavecookies56.kk.common.capability.PlayerStatsCapability;
import uk.co.wehavecookies56.kk.common.core.handler.MainConfig;
import uk.co.wehavecookies56.kk.common.core.handler.event.EntityEvents;
import uk.co.wehavecookies56.kk.common.item.base.ItemDriveForm;
import uk.co.wehavecookies56.kk.common.item.base.ItemKKPotion;
import uk.co.wehavecookies56.kk.common.item.base.ItemSpellOrb;
import uk.co.wehavecookies56.kk.common.item.org.ItemArrowguns;
import uk.co.wehavecookies56.kk.common.lib.Constants;
import uk.co.wehavecookies56.kk.common.lib.Reference;
import uk.co.wehavecookies56.kk.common.lib.Strings;
import uk.co.wehavecookies56.kk.common.util.PortalCoords;
import uk.co.wehavecookies56.kk.common.util.Utils;

@SideOnly(Side.CLIENT)
public class GuiCommandMenu extends GuiScreen {
	Minecraft mc = Minecraft.getMinecraft();

	public static final int TOP = 5, ATTACK = 4, MAGIC = 3, ITEMS = 2, DRIVE = 1;

	// int selected = ATTACK;

	int TOP_WIDTH = 70;
	int TOP_HEIGHT = 15;

	int MENU_WIDTH = 71;
	int MENU_HEIGHT = 15;

	int iconWidth = 10;

	int textX = 0;

	public static List<PortalCoords> portalCommands;
	public static List<String> driveCommands, spells, items;
	public static List<Ability> attackCommands;

	public static final int SUB_MAIN = 0, SUB_MAGIC = 1, SUB_ITEMS = 2, SUB_DRIVE = 3, SUB_PORTALS = 4, SUB_ATTACKS = 5;

	public static final int NONE = 0;
	public static int selected = ATTACK;
	public static int submenu = 0, magicselected = 0, potionselected = 0, driveselected = 0, portalSelected = 0, attackSelected = 0;

	ResourceLocation texture = new ResourceLocation(Reference.MODID, "textures/gui/commandmenu.png");

	@SubscribeEvent(priority = EventPriority.NORMAL)
	public void onRenderOverlayPost(RenderGameOverlayEvent event) {
		if (mc.player.getCapability(ModCapabilities.PLAYER_STATS, null).getHudMode()) {
			if (event.getType() == RenderGameOverlayEvent.ElementType.TEXT && !mc.ingameGUI.getChatGUI().getChatOpen() && MainConfig.displayGUI()) {
				GL11.glPushMatrix();
				{
					drawCommandMenu(event.getResolution().getScaledWidth(), event.getResolution().getScaledHeight());
				}
				GL11.glPopMatrix();
			}
		}
	}

	@Override
	public void initGui() {
		super.initGui();
	}

	@Override
	public void handleMouseInput() throws IOException {
		int i = Mouse.getEventDWheel();

		super.handleMouseInput();
	}

	@Override
	public void updateScreen() {
		super.updateScreen();
	}

	byte[] orgColor = { (byte) 200, (byte) 200, (byte) 200 };
	byte[] attackMenuColor = { (byte) 255, (byte) 200, (byte) 60 };
	byte[] portalMenuColor = { (byte) 100, (byte) 100, (byte) 100 };
	byte[] combatModeColor = { (byte) 255, (byte) 0, (byte) 0 };
	byte[] normalModeColor = { (byte) 30, (byte) 30, (byte) 255 };
	byte[] magicMenuColor = { (byte) 100, (byte) 0, (byte) 255 };
	byte[] itemsMenuColor = { (byte) 70, (byte) 255, (byte) 80 };
	byte[] driveMenuColor = { (byte) 0, (byte) 255, (byte) 255 };

	public void drawCommandMenu(int width, int height) {
		boolean organization = Minecraft.getMinecraft().player.getCapability(ModCapabilities.ORGANIZATION_XIII, null).getMember() != Utils.OrgMember.NONE ? true : false;

		int alpha = MainConfig.client.hud.guiAlpha;
		EntityPlayer player = Minecraft.getMinecraft().player;
		IDriveState DS = mc.player.getCapability(ModCapabilities.DRIVE_STATE, null);
		PlayerStatsCapability.IPlayerStats STATS = mc.player.getCapability(ModCapabilities.PLAYER_STATS, null);

		this.spells = new ArrayList<String>();
		this.items = new ArrayList<String>();
		this.driveCommands = new ArrayList<String>();
		this.portalCommands = new ArrayList<PortalCoords>();
		this.attackCommands = new ArrayList<Ability>();

		this.spells.clear();
		for (int i = 0; i < player.getCapability(ModCapabilities.MAGIC_STATE, null).getInventorySpells().getSlots(); i++)
			if (!ItemStack.areItemStacksEqual(Minecraft.getMinecraft().player.getCapability(ModCapabilities.MAGIC_STATE, null).getInventorySpells().getStackInSlot(i), ItemStack.EMPTY))
				this.spells.add(((ItemSpellOrb) Minecraft.getMinecraft().player.getCapability(ModCapabilities.MAGIC_STATE, null).getInventorySpells().getStackInSlot(i).getItem()).getMagicName());

		this.items.clear();
		for (int i = 0; i < player.getCapability(ModCapabilities.PLAYER_STATS, null).getInventoryPotionsMenu().getSlots(); i++)
			if (!ItemStack.areItemStacksEqual(Minecraft.getMinecraft().player.getCapability(ModCapabilities.PLAYER_STATS, null).getInventoryPotionsMenu().getStackInSlot(i), ItemStack.EMPTY))
				this.items.add(((ItemKKPotion) Minecraft.getMinecraft().player.getCapability(ModCapabilities.PLAYER_STATS, null).getInventoryPotionsMenu().getStackInSlot(i).getItem()).getUnlocalizedName().substring(5));

		this.driveCommands.clear();
		for (int i = 0; i < player.getCapability(ModCapabilities.DRIVE_STATE, null).getInventoryDriveForms().getSlots(); i++)
			if (!ItemStack.areItemStacksEqual(Minecraft.getMinecraft().player.getCapability(ModCapabilities.DRIVE_STATE, null).getInventoryDriveForms().getStackInSlot(i), ItemStack.EMPTY))
				this.driveCommands.add(((ItemDriveForm) Minecraft.getMinecraft().player.getCapability(ModCapabilities.DRIVE_STATE, null).getInventoryDriveForms().getStackInSlot(i).getItem()).getDriveFormName());

		this.portalCommands.clear();
		for (byte i = 0; i < 3; i++) {
			PortalCoords coords = player.getCapability(ModCapabilities.ORGANIZATION_XIII, null).getPortalCoords(i);
			// System.out.println(i+" "+coords);
			if (coords != null) {
				if (!(coords.getX() == 0 && coords.getY() == 0 && coords.getZ() == 0)) {
					this.portalCommands.add(coords);
				}
			}
		}
		
		this.attackCommands.clear();
        IAbilities ABILITIES = player.getCapability(ModCapabilities.ABILITIES, null);
        //for (int i = 0; i < ABILITIES.getEquippedAbilities().size(); i++) {
        for(Ability ability : ABILITIES.getEquippedAbilities()) {
			if (ability == ModAbilities.sonicBlade || ability == ModAbilities.strikeRaid) {
        		this.attackCommands.add(ability);
        	}
        }

		float scale = 1.05f;
		int colour;

		// DRIVE
		GL11.glPushMatrix();
		{
			GL11.glColor4ub((byte) 255, (byte) 255, (byte) 255, (byte) alpha);

			int u;
			int v = 0;
			int x = 0;

			mc.renderEngine.bindTexture(texture);
			GL11.glTranslatef(x, (height - MENU_HEIGHT * scale * DRIVE), 0);
			GL11.glScalef(scale, scale, scale);
			if (submenu != 0)
				GL11.glColor4ub((byte) 80, (byte) 80, (byte) 80, (byte) alpha);

			if (selected == DRIVE) { // Selected
				textX = 5;
				if (EntityEvents.isHostiles)
					paintWithColorArray(combatModeColor, (byte) alpha);
				else
					paintWithColorArray(normalModeColor, (byte) alpha);

				// Draw slot
				drawTexturedModalRect(5, 0, TOP_WIDTH, MENU_HEIGHT, TOP_WIDTH, v + MENU_HEIGHT);

				GL11.glColor4ub((byte) 255, (byte) 255, (byte) 255, (byte) alpha);

				// Draw Icon
				drawTexturedModalRect(60, 2, 140 + (selected * iconWidth) - iconWidth, 18, iconWidth, iconWidth);

			} else { // Not selected
				textX = 0;
				if (EntityEvents.isHostiles)
					paintWithColorArray(combatModeColor, (byte) alpha);
				else
					paintWithColorArray(normalModeColor, (byte) alpha);
				drawTexturedModalRect(0, 0, TOP_WIDTH, 0, TOP_WIDTH, v + MENU_HEIGHT);
			}

			if (this.submenu == 0) {
				if (DS.getInDrive()) {

					if (DS.getActiveDriveName().equals(Strings.Form_Anti))
						drawString(mc.fontRenderer, Utils.translateToLocal(Strings.Gui_CommandMenu_Drive_Revert), 6 + textX, 4, 0x888888);
					else
						drawString(mc.fontRenderer, Utils.translateToLocal(Strings.Gui_CommandMenu_Drive_Revert), 6 + textX, 4, 0xFFFFFF);
					GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
				} else if (this.driveCommands.isEmpty() || DS.getDP() <= 0) {
					if (organization)
						drawString(mc.fontRenderer, Utils.translateToLocal(Strings.Gui_CommandMenu_Limit), 6 + textX, 4, 0x888888);// 0xFFFFFF
					else
						drawString(mc.fontRenderer, Utils.translateToLocal(Strings.Gui_CommandMenu_Drive), 6 + textX, 4, 0x888888);
				} else {
					if (organization)
						drawString(mc.fontRenderer, Utils.translateToLocal(Strings.Gui_CommandMenu_Limit), 6 + textX, 4, 0x888888);// 0xFFFFFF
					else
						drawString(mc.fontRenderer, Utils.translateToLocal(Strings.Gui_CommandMenu_Drive), 6 + textX, 4, 0xFFFFFF);
				}
			}

		}
		GL11.glPopMatrix();
		// ITEMS
		GL11.glPushMatrix();
		{
			GL11.glColor4ub((byte) 255, (byte) 255, (byte) 255, (byte) alpha);

			int u;
			int v = 0;
			int x = 0;

			mc.renderEngine.bindTexture(texture);
			GL11.glTranslatef(x, (height - MENU_HEIGHT * scale * ITEMS), 0);
			GL11.glScalef(scale, scale, scale);
			if (submenu != 0)
				GL11.glColor4ub((byte) 80, (byte) 80, (byte) 80, (byte) alpha);
			if (selected == ITEMS) { // Selected
				textX = 5;
				if (EntityEvents.isHostiles)
					paintWithColorArray(combatModeColor, (byte) alpha);
				else
					paintWithColorArray(normalModeColor, (byte) alpha);

				// Draw slot
				drawTexturedModalRect(5, 0, TOP_WIDTH, MENU_HEIGHT, TOP_WIDTH, v + MENU_HEIGHT);

				GL11.glColor4ub((byte) 255, (byte) 255, (byte) 255, (byte) alpha);

				// Draw Icon
				drawTexturedModalRect(60, 2, 140 + (selected * iconWidth) - iconWidth, 18, iconWidth, iconWidth);

			} else { // Not selected
				textX = 0;
				if (EntityEvents.isHostiles)
					paintWithColorArray(combatModeColor, (byte) alpha);
				else
					paintWithColorArray(normalModeColor, (byte) alpha);
				drawTexturedModalRect(0, 0, TOP_WIDTH, 0, TOP_WIDTH, v + MENU_HEIGHT);
			}

			if (this.submenu == 0) {
				if (this.items.isEmpty())
					drawString(mc.fontRenderer, Utils.translateToLocal(Strings.Gui_CommandMenu_Items), 6 + textX, 4, 0x888888);
				else
					drawString(mc.fontRenderer, Utils.translateToLocal(Strings.Gui_CommandMenu_Items), 6 + textX, 4, 0xFFFFFF);
			}
			GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		}
		GL11.glPopMatrix();

		// MAGIC
		GL11.glPushMatrix();
		{
			GL11.glColor4ub((byte) 255, (byte) 255, (byte) 255, (byte) alpha);

			int u;
			int v = 0;
			int x = 0;
			mc.renderEngine.bindTexture(texture);
			GL11.glTranslatef(x, (height - MENU_HEIGHT * scale * MAGIC), 0);
			GL11.glScalef(scale, scale, scale);
			if (submenu != 0)
				GL11.glColor4ub((byte) 80, (byte) 80, (byte) 80, (byte) alpha);
			if (selected == MAGIC) { // Selected
				textX = 5;
				if (EntityEvents.isHostiles)
					paintWithColorArray(combatModeColor, (byte) alpha);
				else
					paintWithColorArray(normalModeColor, (byte) alpha);

				// Draw slot
				drawTexturedModalRect(5, 0, TOP_WIDTH, MENU_HEIGHT, TOP_WIDTH, v + MENU_HEIGHT);

				GL11.glColor4ub((byte) 255, (byte) 255, (byte) 255, (byte) alpha);

				// Draw Icon
				drawTexturedModalRect(60, 2, 140 + (selected * iconWidth) - iconWidth, 18, iconWidth, iconWidth);

			} else { // Not selected
				textX = 0;
				if (EntityEvents.isHostiles)
					paintWithColorArray(combatModeColor, (byte) alpha);
				else
					paintWithColorArray(normalModeColor, (byte) alpha);
				drawTexturedModalRect(0, 0, TOP_WIDTH, 0, TOP_WIDTH, v + MENU_HEIGHT);
			}

			if (this.submenu == 0) {
				int color;
				if (spells == null) {
					color = 0x888888;
				} else {
					if (!STATS.getRecharge() && (!this.spells.isEmpty() && (!DS.getActiveDriveName().equals(Strings.Form_Valor) && !DS.getActiveDriveName().equals(Strings.Form_Anti))))
						color = 0xFFFFFF;
					else
						color = 0x888888;
				}
				drawString(mc.fontRenderer, Utils.translateToLocal(Strings.Gui_CommandMenu_Magic), 6 + textX, 4, color);
				GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
			}
		}
		GL11.glPopMatrix();
		// ATTACK
		GL11.glPushMatrix();
		{
			GL11.glColor4ub((byte) 255, (byte) 255, (byte) 255, (byte) alpha);

			int u;
			int v = 0;
			int x = 0;
			mc.renderEngine.bindTexture(texture);
			GL11.glTranslatef(x, (height - MENU_HEIGHT * scale * ATTACK), 0);
			GL11.glScalef(scale, scale, scale);

			if (submenu != 0)
				GL11.glColor4ub((byte) 80, (byte) 80, (byte) 80, (byte) alpha);

			if (selected == ATTACK) { // Selected
				textX = 5;
				if (EntityEvents.isHostiles)
					paintWithColorArray(combatModeColor, (byte) alpha);
				else
					paintWithColorArray(normalModeColor, (byte) alpha);

				// Draw slot
				drawTexturedModalRect(5, 0, TOP_WIDTH, MENU_HEIGHT, TOP_WIDTH, v + MENU_HEIGHT);

				GL11.glColor4ub((byte) 255, (byte) 255, (byte) 255, (byte) alpha);

				// Draw Icon
				if (organization) {
					drawTexturedModalRect(60, 2, 140 + ((selected + 1) * iconWidth) - iconWidth, 18, iconWidth, iconWidth);
				} else {
					drawTexturedModalRect(60, 2, 140 + (selected * iconWidth) - iconWidth, 18, iconWidth, iconWidth);
				}

			} else { // Not selected
				textX = 0;
				if (EntityEvents.isHostiles)
					paintWithColorArray(combatModeColor, (byte) alpha);
				else
					paintWithColorArray(normalModeColor, (byte) alpha);
				drawTexturedModalRect(0, 0, TOP_WIDTH, 0, TOP_WIDTH, v + MENU_HEIGHT);
			}

			if (this.submenu == 0) {
				int color = this.portalCommands.isEmpty() || STATS.getRecharge() ? 0x888888 : 0xFFFFFF;
				if (organization)
					drawString(mc.fontRenderer, Utils.translateToLocal(Strings.Gui_CommandMenu_Portal), 6 + textX, 4, color);
				else
					drawString(mc.fontRenderer, Utils.translateToLocal(Strings.Gui_CommandMenu_Attack), 6 + textX, 4, 0xFFFFFF);
				
				if(Minecraft.getMinecraft().player.getCapability(ModCapabilities.ORGANIZATION_XIII, null).getMember() == Utils.OrgMember.XIGBAR) {
					if(player.getHeldItemMainhand() != null) {
						if(player.getHeldItemMainhand().getItem() instanceof ItemArrowguns) {
							ItemStack weapon = player.getHeldItemMainhand();
							if(weapon.hasTagCompound()) {
								if(weapon.getTagCompound().hasKey("ammo")) {
									int ammo = weapon.getTagCompound().getInteger("ammo");
									drawString(mc.fontRenderer, ammo+"", textX+TOP_WIDTH, 4, 0xFFFFFF);
								}
							}
							
						}
					}
				}
			}

		}
		GL11.glPopMatrix();
		// TOP
		GL11.glPushMatrix();
		{
			GL11.glColor4ub((byte) 255, (byte) 255, (byte) 255, (byte) alpha);

			mc.renderEngine.bindTexture(texture);
			GL11.glTranslatef(0, (height - MENU_HEIGHT * scale * TOP), 0);
			GL11.glScalef(scale, scale, scale);
			if (submenu != 0)
				GL11.glColor4ub((byte) 80, (byte) 80, (byte) 80, (byte) alpha);

			textX = 0;
			if (EntityEvents.isHostiles)
				paintWithColorArray(combatModeColor, (byte) alpha);
			else
				paintWithColorArray(normalModeColor, (byte) alpha);

			drawTexturedModalRect(0, 0, 0, 0, TOP_WIDTH, TOP_HEIGHT);

			if (this.submenu == 0) {
				drawString(mc.fontRenderer, Utils.translateToLocal(Strings.Gui_CommandMenu_Command), 6, 4, 0xFFFFFF);
			}
		}
		GL11.glPopMatrix();

		// Attacks submenu //
		if (attackCommands != null && !attackCommands.isEmpty()) {
			// ATTACKS TOP
			GL11.glPushMatrix();
			{
				paintWithColorArray(attackMenuColor, (byte) alpha);
				mc.renderEngine.bindTexture(texture);
				GL11.glTranslatef(5, (height - MENU_HEIGHT * scale * (attackCommands.size() + 1)), 0);
				GL11.glScalef(scale, scale, scale);
				if (submenu == SUB_ATTACKS) {
					drawTexturedModalRect(0, 0, 0, 0, TOP_WIDTH, TOP_HEIGHT);
					drawString(mc.fontRenderer, Utils.translateToLocal("ATTACKS"), 6, 4, 0xFFFFFF);
				}
			}
			GL11.glPopMatrix();

			for (int i = 0; i < attackCommands.size(); i++) {
				GL11.glPushMatrix();
				{
					GL11.glColor4ub((byte) 255, (byte) 255, (byte) 255, (byte) alpha);
					int u;
					int v;
					int x;
					x = (attackSelected == i) ? 10 : 5;

					mc.renderEngine.bindTexture(texture);
					GL11.glTranslatef(x, (height - MENU_HEIGHT * scale * (attackCommands.size() - i)), 0);
					GL11.glScalef(scale, scale, scale);
					if (submenu == SUB_ATTACKS) {
						v = 0;
						paintWithColorArray(attackMenuColor, (byte) alpha);

						if (attackSelected == i) {
							textX = 11;

							// Draw slot
							drawTexturedModalRect(5, 0, TOP_WIDTH, MENU_HEIGHT, TOP_WIDTH, v + MENU_HEIGHT);

							GL11.glColor4ub((byte) 255, (byte) 255, (byte) 255, (byte) alpha);

							// Draw Icon
							drawTexturedModalRect(60, 2, 140 + ((selected) * iconWidth) - iconWidth, 18, iconWidth, iconWidth);

						} else { // Not selected
							textX = 6;

							drawTexturedModalRect(0, 0, TOP_WIDTH, 0, TOP_WIDTH, v + MENU_HEIGHT);
						}
						// colour = Constants.getCost(spells.get(i)) < STATS.getMP() ? 0xFFFFFF :
						// 0xFF9900;

						Ability ability = attackCommands.get(i);
						// String magicName = Constants.getMagicName(magic, level);
						drawString(mc.fontRenderer, Utils.translateToLocal(ability.getName()), textX, 4, 0xFFFFFF);
						GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
					}
				}
				GL11.glPopMatrix();
			}
		}

		// Portal submenu //
		if (portalCommands != null && !portalCommands.isEmpty()) {
			// PORTAL TOP
			GL11.glPushMatrix();
			{
				paintWithColorArray(portalMenuColor, (byte) alpha);
				mc.renderEngine.bindTexture(texture);
				GL11.glTranslatef(5, (height - MENU_HEIGHT * scale * (portalCommands.size() + 1)), 0);
				GL11.glScalef(scale, scale, scale);
				if (submenu == SUB_PORTALS) {
					drawTexturedModalRect(0, 0, 0, 0, TOP_WIDTH, TOP_HEIGHT);
					drawString(mc.fontRenderer, Utils.translateToLocal(Strings.Gui_CommandMenu_Portals_Title), 6, 4, 0xFFFFFF);
				}
			}
			GL11.glPopMatrix();

			for (int i = 0; i < portalCommands.size(); i++) {
				GL11.glPushMatrix();
				{
					GL11.glColor4ub((byte) 255, (byte) 255, (byte) 255, (byte) alpha);
					int u;
					int v;
					int x;
					x = (portalSelected == i) ? 10 : 5;

					mc.renderEngine.bindTexture(texture);
					GL11.glTranslatef(x, (height - MENU_HEIGHT * scale * (portalCommands.size() - i)), 0);
					GL11.glScalef(scale, scale, scale);
					if (submenu == SUB_PORTALS) {
						v = 0;
						paintWithColorArray(portalMenuColor, (byte) alpha);

						if (portalSelected == i) {
							textX = 11;

							// Draw slot
							drawTexturedModalRect(5, 0, TOP_WIDTH, MENU_HEIGHT, TOP_WIDTH, v + MENU_HEIGHT);

							GL11.glColor4ub((byte) 255, (byte) 255, (byte) 255, (byte) alpha);

							// Draw Icon
							drawTexturedModalRect(60, 2, 140 + ((selected + 1) * iconWidth) - iconWidth, 18, iconWidth, iconWidth);

						} else { // Not selected
							textX = 6;

							drawTexturedModalRect(0, 0, TOP_WIDTH, 0, TOP_WIDTH, v + MENU_HEIGHT);
						}
						// colour = Constants.getCost(spells.get(i)) < STATS.getMP() ? 0xFFFFFF :
						// 0xFF9900;

						PortalCoords portal = portalCommands.get(i);
						// String magicName = Constants.getMagicName(magic, level);
						drawString(mc.fontRenderer, Utils.translateToLocal(portal.getShortCoords() + ""), textX, 4, 0xFFFFFF);
						GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
					}
				}
				GL11.glPopMatrix();
			}
		}

		// Magic submenu //
		if (spells != null && !spells.isEmpty()) {
			// MAGIC TOP
			GL11.glPushMatrix();
			{
				GL11.glColor4ub((byte) 255, (byte) 255, (byte) 255, (byte) alpha);
				mc.renderEngine.bindTexture(texture);
				GL11.glTranslatef(5, (height - MENU_HEIGHT * scale * (spells.size() + 1)), 0);
				GL11.glScalef(scale, scale, scale);
				int v = 0;
				if (submenu == SUB_MAGIC) {

					GL11.glColor4ub(magicMenuColor[0], magicMenuColor[1], magicMenuColor[2], (byte) alpha);

					drawTexturedModalRect(0, 0, 0, 0, TOP_WIDTH, TOP_HEIGHT);
					// drawTexturedModalRect(0, 0, 0, 0+extraY, TOP_WIDTH, TOP_HEIGHT);
					drawString(mc.fontRenderer, Utils.translateToLocal(Strings.Gui_CommandMenu_Magic_Title), 6, 4, 0xFFFFFF);
				}
			}
			GL11.glPopMatrix();
			for (int i = 0; i < spells.size(); i++) {
				GL11.glPushMatrix();
				{
					GL11.glColor4ub((byte) 255, (byte) 255, (byte) 255, (byte) alpha);
					int u;
					int v;
					int x;
					x = (magicselected == i) ? 10 : 5;

					mc.renderEngine.bindTexture(texture);
					GL11.glTranslatef(x, (height - MENU_HEIGHT * scale * (spells.size() - i)), 0);
					GL11.glScalef(scale, scale, scale);
					if (submenu == SUB_MAGIC) {
						v = 0;

						paintWithColorArray(magicMenuColor, (byte) alpha);
						if (magicselected == i) {
							// drawTexturedModalRect(0, 0, TOP_WIDTH, 15+extraY, TOP_WIDTH + MENU_WIDTH, v +
							// MENU_HEIGHT);
							textX = 11;

							// Draw slot
							drawTexturedModalRect(5, 0, TOP_WIDTH, MENU_HEIGHT, TOP_WIDTH, v + MENU_HEIGHT);

							GL11.glColor4ub((byte) 255, (byte) 255, (byte) 255, (byte) alpha);

							// Draw Icon
							drawTexturedModalRect(60, 2, 140 + selected * iconWidth - iconWidth, 18, iconWidth, iconWidth);

						} else { // Not selected
							textX = 6;
							drawTexturedModalRect(0, 0, TOP_WIDTH, 0, TOP_WIDTH, v + MENU_HEIGHT);
						}

						colour = Constants.getCost(spells.get(i)) < STATS.getMP() ? 0xFFFFFF : 0xFF9900;
						if (spells.get(i).equals(Strings.Spell_Cure))
							colour = 0xFF9900;
						colour = STATS.getMP() < 1 ? 0x888888 : colour;

						String magic = spells.get(i);
						int level = mc.player.getCapability(ModCapabilities.MAGIC_STATE, null).getMagicLevel(magic);
						String magicName = Constants.getMagicName(magic, level);
						drawString(mc.fontRenderer, Utils.translateToLocal(magicName), textX, 4, colour);
						GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
					}
				}
				GL11.glPopMatrix();
			}
		}
		// Items submenu //
		if (items != null && !items.isEmpty()) {
			// Items TOP
			GL11.glPushMatrix();
			{
				GL11.glColor4ub((byte) 255, (byte) 255, (byte) 255, (byte) alpha);
				mc.renderEngine.bindTexture(texture);
				GL11.glTranslatef(5, (height - MENU_HEIGHT * scale * (items.size() + 1)), 0);
				GL11.glScalef(scale, scale, scale);
				if (submenu == SUB_ITEMS) {

					paintWithColorArray(itemsMenuColor, (byte) alpha);

					drawTexturedModalRect(0, 0, 0, 0, TOP_WIDTH, TOP_HEIGHT);
					drawString(mc.fontRenderer, Utils.translateToLocal("ITEMS"), 6, 4, 0xFFFFFF);
				}

			}
			GL11.glPopMatrix();
			for (int i = 0; i < items.size(); i++) {
				GL11.glPushMatrix();
				{
					GL11.glColor4ub((byte) 255, (byte) 255, (byte) 255, (byte) alpha);
					int u;
					int v;
					int x;
					x = (potionselected == i) ? 10 : 5;

					mc.renderEngine.bindTexture(texture);
					GL11.glTranslatef(x, (height - MENU_HEIGHT * scale * (items.size() - i)), 0);
					GL11.glScalef(scale, scale, scale);
					if (submenu == SUB_ITEMS) {
						v = 0;
						paintWithColorArray(itemsMenuColor, (byte) alpha);
						if (potionselected == i) {
							textX = 11;

							// Draw slot
							drawTexturedModalRect(5, 0, TOP_WIDTH, MENU_HEIGHT, TOP_WIDTH, v + MENU_HEIGHT);

							GL11.glColor4ub((byte) 255, (byte) 255, (byte) 255, (byte) alpha);

							// Draw Icon
							drawTexturedModalRect(60, 2, 140 + selected * iconWidth - iconWidth, 18, iconWidth, iconWidth);

						} else { // Not selected
							textX = 6;

							drawTexturedModalRect(0, 0, TOP_WIDTH, 0, TOP_WIDTH, v + MENU_HEIGHT);
						}
						drawString(mc.fontRenderer, Utils.translateToLocal("item." + items.get(i) + ".name"), textX, 4, 0xFFFFFF);

						GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
					}
				}
				GL11.glPopMatrix();
			}
		}

		// Drive form submenu //
		if (driveCommands != null && !driveCommands.isEmpty()) {
			// DRIVE TOP
			GL11.glPushMatrix();
			{
				GL11.glColor4ub((byte) 255, (byte) 255, (byte) 255, (byte) alpha);
				mc.renderEngine.bindTexture(texture);
				GL11.glTranslatef(5, (height - MENU_HEIGHT * scale * (driveCommands.size() + 1)), 0);
				GL11.glScalef(1.25f, scale, scale);
				if (submenu == SUB_DRIVE) {

					GL11.glColor4ub((byte) 0, (byte) 255, (byte) 255, (byte) alpha);

					drawTexturedModalRect(0, 0, 0, 0, TOP_WIDTH, TOP_HEIGHT);
				}
			}
			GL11.glPopMatrix();

			GL11.glPushMatrix();
			{
				GL11.glColor4ub((byte) 255, (byte) 255, (byte) 255, (byte) alpha);
				GL11.glTranslatef(5, (height - MENU_HEIGHT * scale * (driveCommands.size() + 1)), 0);
				GL11.glScalef(scale, scale, scale);
				if (submenu == SUB_DRIVE)
					drawString(mc.fontRenderer, Utils.translateToLocal(Strings.Gui_CommandMenu_Drive_Title), 6, 4, 0xFFFFFF);
			}
			GL11.glPopMatrix();
			for (int i = 0; i < driveCommands.size(); i++) {
				GL11.glPushMatrix();
				{
					GL11.glColor4ub((byte) 255, (byte) 255, (byte) 255, (byte) alpha);
					int u;
					int v;
					int x;
					x = (driveselected == i) ? 10 : 5;
					v = (driveselected == i) ? MENU_HEIGHT : 0;

					mc.renderEngine.bindTexture(texture);
					GL11.glTranslatef(x, (height - MENU_HEIGHT * scale * (driveCommands.size() - i)), 0);
					GL11.glScalef(1.25f, scale, scale);
					if (submenu == SUB_DRIVE) {
						v = 0;
						paintWithColorArray(driveMenuColor, (byte) alpha);
						if (driveselected == i) {
							textX = 11;

							// Draw slot
							drawTexturedModalRect(5, 0, TOP_WIDTH, MENU_HEIGHT, TOP_WIDTH, v + MENU_HEIGHT);

							GL11.glColor4ub((byte) 255, (byte) 255, (byte) 255, (byte) alpha);

							// Draw Icon
							drawTexturedModalRect(60, 2, 140 + selected * iconWidth - iconWidth, 18, iconWidth, iconWidth);

						} else { // Not selected
							textX = 6;
							drawTexturedModalRect(0, 0, TOP_WIDTH, 0, TOP_WIDTH, v + MENU_HEIGHT);
						}
					}
				}
				GL11.glPopMatrix();

				GL11.glPushMatrix();
				{
					GL11.glColor4ub((byte) 80, (byte) 80, (byte) 80, (byte) alpha);
					int x;
					x = (driveselected == i) ? 10 : 5;
					GL11.glTranslatef(x, (height - MENU_HEIGHT * scale * (driveCommands.size() - i)), 0);
					GL11.glScalef(scale, scale, scale);
					if (submenu == SUB_DRIVE) {
						if (DS.getDP() >= Constants.getCost(driveCommands.get(i)) || mc.player.getCapability(ModCapabilities.CHEAT_MODE, null).getCheatMode())
							drawString(mc.fontRenderer, Utils.translateToLocal(driveCommands.get(i)), textX, 4, 0xFFFFFF);
						else
							drawString(mc.fontRenderer, Utils.translateToLocal(driveCommands.get(i)), textX, 4, 0x888888);
					}
					GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);

				}
				GL11.glPopMatrix();
			}
		}
	}

	private void paintWithColorArray(byte[] array, byte alpha) {
		if (Minecraft.getMinecraft().player.getCapability(ModCapabilities.ORGANIZATION_XIII, null).getMember() != Utils.OrgMember.NONE && array == normalModeColor) {
			GL11.glColor4ub(orgColor[0], orgColor[1], orgColor[2], (byte) alpha);
		} else {
			GL11.glColor4ub(array[0], array[1], array[2], (byte) alpha);
		}

	}
}
