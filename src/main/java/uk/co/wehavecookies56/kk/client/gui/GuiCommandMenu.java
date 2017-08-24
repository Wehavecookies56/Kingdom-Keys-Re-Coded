package uk.co.wehavecookies56.kk.client.gui;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.GL11;
import uk.co.wehavecookies56.kk.common.capability.DriveStateCapability.IDriveState;
import uk.co.wehavecookies56.kk.common.capability.ModCapabilities;
import uk.co.wehavecookies56.kk.common.capability.PlayerStatsCapability;
import uk.co.wehavecookies56.kk.common.core.handler.MainConfig;
import uk.co.wehavecookies56.kk.common.core.handler.event.EntityEvents;
import uk.co.wehavecookies56.kk.common.item.base.ItemDriveForm;
import uk.co.wehavecookies56.kk.common.item.base.ItemKKPotion;
import uk.co.wehavecookies56.kk.common.item.base.ItemSpellOrb;
import uk.co.wehavecookies56.kk.common.lib.Constants;
import uk.co.wehavecookies56.kk.common.lib.Reference;
import uk.co.wehavecookies56.kk.common.lib.Strings;
import uk.co.wehavecookies56.kk.common.util.Utils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@SideOnly (Side.CLIENT)
public class GuiCommandMenu extends GuiScreen {
    Minecraft mc = Minecraft.getMinecraft();

    public static final int TOP = 5, ATTACK = 4, MAGIC = 3, ITEMS = 2, DRIVE = 1;

    public static final int MAGIC_TOP = 8, FIRE = 7, BLIZZARD = 6, THUNDER = 5, CURE = 4, GRAVITY = 3, AERO = 2, STOP = 1;
    public static final int POTION_TOP = 6, POTION1 = 5, POTION2 = 4, POTION3 = 3, POTION4 = 2, POTION5 = 1;
    // int selected = ATTACK;

    int TOP_WIDTH = 70;
    int TOP_HEIGHT = 15;

    int MENU_WIDTH = 71;
    int MENU_HEIGHT = 15;

    int alpha = 255;

    int textX = 0;

    public static List<String> driveCommands;
    public static List<String> spells;
    public static List<String> items;

    public static final int SUB_MAIN = 0, SUB_MAGIC = 1, SUB_ITEMS = 2, SUB_DRIVE = 3;

    public static final int NONE = 0;
    public static int selected = ATTACK;
    public static int submenu = 0;
    public static int magicselected = 0;
    public static int potionselected = 0;
    public static int driveselected = 0;
    public static boolean FireUnlocked = true, BlizzardUnlocked, ThunderUnlocked, CureUnlocked, GravityUnlocked, AeroUnlocked, StopUnlocked, ValorUnlocked, WisdomUnlocked, LimitUnlocked, MasterUnlocked, FinalUnlocked;

    ResourceLocation texture = new ResourceLocation(Reference.MODID, "textures/gui/commandmenu.png");

    @SubscribeEvent (priority = EventPriority.NORMAL)
    public void onRenderOverlayPost (RenderGameOverlayEvent event) {
        if(mc.player.getCapability(ModCapabilities.PLAYER_STATS, null).getHudMode())
        {
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
    public void initGui () {
        super.initGui();
    }

    @Override
    public void handleMouseInput () throws IOException {
        int i = Mouse.getEventDWheel();

        super.handleMouseInput();
    }

    @Override
    public void updateScreen () {
        super.updateScreen();
    }

    public void drawCommandMenu (int width, int height) {
        IDriveState DS = mc.player.getCapability(ModCapabilities.DRIVE_STATE, null);
        PlayerStatsCapability.IPlayerStats STATS = mc.player.getCapability(ModCapabilities.PLAYER_STATS, null);

        this.spells = new ArrayList<String>();
        this.items = new ArrayList<String>();
        this.driveCommands = new ArrayList<String>();

        this.spells.clear();
        for (int i = 0; i < Minecraft.getMinecraft().player.getCapability(ModCapabilities.MAGIC_STATE, null).getInventorySpells().getSlots(); i++)
            if (!ItemStack.areItemStacksEqual(Minecraft.getMinecraft().player.getCapability(ModCapabilities.MAGIC_STATE, null).getInventorySpells().getStackInSlot(i), ItemStack.EMPTY)) 
            	this.spells.add(((ItemSpellOrb) Minecraft.getMinecraft().player.getCapability(ModCapabilities.MAGIC_STATE, null).getInventorySpells().getStackInSlot(i).getItem()).getMagicName());
       
        this.items.clear();
        for (int i = 0; i < Minecraft.getMinecraft().player.getCapability(ModCapabilities.PLAYER_STATS, null).getInventoryPotionsMenu().getSlots(); i++)
            if (!ItemStack.areItemStacksEqual(Minecraft.getMinecraft().player.getCapability(ModCapabilities.PLAYER_STATS, null).getInventoryPotionsMenu().getStackInSlot(i), ItemStack.EMPTY))
            	this.items.add(((ItemKKPotion) Minecraft.getMinecraft().player.getCapability(ModCapabilities.PLAYER_STATS, null).getInventoryPotionsMenu().getStackInSlot(i).getItem()).getUnlocalizedName().substring(5));
      
        this.driveCommands.clear();
        for (int i = 0; i < Minecraft.getMinecraft().player.getCapability(ModCapabilities.DRIVE_STATE, null).getInventoryDriveForms().getSlots(); i++)
            if (!ItemStack.areItemStacksEqual(Minecraft.getMinecraft().player.getCapability(ModCapabilities.DRIVE_STATE, null).getInventoryDriveForms().getStackInSlot(i), ItemStack.EMPTY)) 
            	this.driveCommands.add(((ItemDriveForm) Minecraft.getMinecraft().player.getCapability(ModCapabilities.DRIVE_STATE, null).getInventoryDriveForms().getStackInSlot(i).getItem()).getDriveFormName());
        
        // Magic:"+magicselected+" Drive:"+driveselected);
        //System.out.println("Is KH1 Fire?: "+ExtendedPlayer.get(Minecraft.getMinecraft().thePlayer).getKH1Fire());
        float scale = 1.05f;
        int colour;
        // DRIVE
        GL11.glPushMatrix();
        {
            GL11.glColor4ub((byte) 255, (byte) 255, (byte) 255, (byte) 255);

            int u;
            int v = 0;
            int x = 0;

            mc.renderEngine.bindTexture(texture);
            GL11.glTranslatef(x, (height - MENU_HEIGHT * scale * DRIVE), 0);
            GL11.glScalef(scale, scale, scale);
            if (submenu != 0) GL11.glColor4ub((byte) 80, (byte) 80, (byte) 80, (byte) this.alpha);

            if (selected == DRIVE) { // Selected
                textX = 5;
                if (EntityEvents.isHostiles)
                    drawTexturedModalRect(5, 0, TOP_WIDTH, 30, TOP_WIDTH + MENU_WIDTH, v + MENU_HEIGHT);
                else
                    drawTexturedModalRect(5, 0, TOP_WIDTH, MENU_HEIGHT, TOP_WIDTH + MENU_WIDTH, v + MENU_HEIGHT);

            } else { // Not selected
                textX = 0;

                if (EntityEvents.isHostiles)
                    drawTexturedModalRect(0, 0, 0, 30, TOP_WIDTH, v + MENU_HEIGHT);
                else
                    drawTexturedModalRect(0, 0, TOP_WIDTH, 0, TOP_WIDTH + MENU_WIDTH, v + MENU_HEIGHT);
            }
            if(this.submenu == 0)
            {
                if (DS.getInDrive()) {

                    if (DS.getActiveDriveName().equals(Strings.Form_Anti))
                        drawString(mc.fontRenderer, Utils.translateToLocal(Strings.Gui_CommandMenu_Drive_Revert), 6 + textX, 4, 0x888888);
                    else
                        drawString(mc.fontRenderer, Utils.translateToLocal(Strings.Gui_CommandMenu_Drive_Revert), 6 + textX, 4, 0xFFFFFF);
                    GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
                } else if (this.driveCommands.isEmpty() || STATS.getDP() <= 0)
                    drawString(mc.fontRenderer, Utils.translateToLocal(Strings.Gui_CommandMenu_Drive), 6 + textX, 4, 0x888888);
                else
                    drawString(mc.fontRenderer, Utils.translateToLocal(Strings.Gui_CommandMenu_Drive), 6 + textX, 4, 0xFFFFFF);
            }

        }
        GL11.glPopMatrix();
        // ITEMS
        GL11.glPushMatrix();
        {
            GL11.glColor4ub((byte) 255, (byte) 255, (byte) 255, (byte) this.alpha);

            int u;
            int v = 0;
            int x = 0;

            mc.renderEngine.bindTexture(texture);
            GL11.glTranslatef(x, (height - MENU_HEIGHT * scale * ITEMS), 0);
            GL11.glScalef(scale, scale, scale);
            if (submenu != 0) GL11.glColor4ub((byte) 80, (byte) 80, (byte) 80, (byte) this.alpha);
            if (selected == ITEMS) { // Selected
                textX = 5;
                if (EntityEvents.isHostiles)
                    drawTexturedModalRect(5, 0, TOP_WIDTH, 30, TOP_WIDTH + MENU_WIDTH, v + MENU_HEIGHT);
                else
                    drawTexturedModalRect(5, 0, TOP_WIDTH, MENU_HEIGHT, TOP_WIDTH + MENU_WIDTH, v + MENU_HEIGHT);

            } else { // Not selected
                textX = 0;

                if (EntityEvents.isHostiles)
                    drawTexturedModalRect(0, 0, 0, 30, TOP_WIDTH, v + MENU_HEIGHT);
                else
                    drawTexturedModalRect(0, 0, TOP_WIDTH, 0, TOP_WIDTH + MENU_WIDTH, v + MENU_HEIGHT);
            }
            if(this.submenu == 0)
            {
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
            GL11.glColor4ub((byte) 255, (byte) 255, (byte) 255, (byte) this.alpha);

            int u;
            int v = 0;
            int x = 0;
            mc.renderEngine.bindTexture(texture);
            GL11.glTranslatef(x, (height - MENU_HEIGHT * scale * MAGIC), 0);
            GL11.glScalef(scale, scale, scale);
            if (submenu != 0) GL11.glColor4ub((byte) 80, (byte) 80, (byte) 80, (byte) this.alpha);
            if (selected == MAGIC) { // Selected
                textX = 5;
                if (EntityEvents.isHostiles)
                    drawTexturedModalRect(5, 0, TOP_WIDTH, 30, TOP_WIDTH + MENU_WIDTH, v + MENU_HEIGHT);
                else
                    drawTexturedModalRect(5, 0, TOP_WIDTH, MENU_HEIGHT, TOP_WIDTH + MENU_WIDTH, v + MENU_HEIGHT);

            } else { // Not selected
                textX = 0;

                if (EntityEvents.isHostiles)
                    drawTexturedModalRect(0, 0, 0, 30, TOP_WIDTH, v + MENU_HEIGHT);
                else
                    drawTexturedModalRect(0, 0, TOP_WIDTH, 0, TOP_WIDTH + MENU_WIDTH, v + MENU_HEIGHT);
            }
            if(this.submenu == 0)
            {
                if (spells == null) {
                    drawString(mc.fontRenderer, Utils.translateToLocal(Strings.Gui_CommandMenu_Magic), 6 + textX, 4, 0x888888);
                } else {
                    //if (!ExtendedPlayer.get(mc.thePlayer).getRecharge() && !spells.isEmpty() && !ExtendedPlayer.get(mc.thePlayer).getDriveInUse().equals("Valor"))
                    if (!STATS.getRecharge() && (!this.spells.isEmpty() && !DS.getActiveDriveName().equals(Strings.Form_Valor)))

                        drawString(mc.fontRenderer, Utils.translateToLocal(Strings.Gui_CommandMenu_Magic), 6 + textX, 4, 0xFFFFFF);
                    else
                        drawString(mc.fontRenderer, Utils.translateToLocal(Strings.Gui_CommandMenu_Magic), 6 + textX, 4, 0x888888);
                    GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
                }
            }
        }
        GL11.glPopMatrix();
        // ATTACK
        GL11.glPushMatrix();
        {
            GL11.glColor4ub((byte) 255, (byte) 255, (byte) 255, (byte) this.alpha);

            int u;
            int v = 0;
            int x = 0;
            mc.renderEngine.bindTexture(texture);
            GL11.glTranslatef(x, (height - MENU_HEIGHT * scale * ATTACK), 0);
            GL11.glScalef(scale, scale, scale);

            if (submenu != 0)     GL11.glColor4ub((byte) 80, (byte) 80, (byte) 80, (byte) this.alpha);

            if (selected == ATTACK) { // Selected

                textX = 5;
                if (EntityEvents.isHostiles)
                    drawTexturedModalRect(5, 0, TOP_WIDTH, 30, TOP_WIDTH + MENU_WIDTH, v + MENU_HEIGHT);
                else
                    drawTexturedModalRect(5, 0, TOP_WIDTH, MENU_HEIGHT, TOP_WIDTH + MENU_WIDTH, v + MENU_HEIGHT);

            } else { // Not selected
                textX = 0;

                if (EntityEvents.isHostiles)
                    drawTexturedModalRect(0, 0, 0, 30, TOP_WIDTH, v + MENU_HEIGHT);
                else
                    drawTexturedModalRect(0, 0, TOP_WIDTH, 0, TOP_WIDTH + MENU_WIDTH, v + MENU_HEIGHT);
            }
            if(this.submenu == 0)
            {
            drawString(mc.fontRenderer, Utils.translateToLocal(Strings.Gui_CommandMenu_Attack), 6 + textX, 4, 0xFFFFFF);
            }

        }
        GL11.glPopMatrix();
        // TOP
        GL11.glPushMatrix();
        {
            GL11.glColor4ub((byte) 255, (byte) 255, (byte) 255, (byte) this.alpha);

            mc.renderEngine.bindTexture(texture);
            GL11.glTranslatef(0, (height - MENU_HEIGHT * scale * TOP), 0);
            GL11.glScalef(scale, scale, scale);
            if (submenu != 0) GL11.glColor4ub((byte) 80, (byte) 80, (byte) 80, (byte) this.alpha);

            if (EntityEvents.isHostiles)
                drawTexturedModalRect(0, 0, 0, 15, TOP_WIDTH, TOP_HEIGHT);
            else
                drawTexturedModalRect(0, 0, 0, 0, TOP_WIDTH, TOP_HEIGHT);
            if(this.submenu == 0)
            {
                drawString(mc.fontRenderer, Utils.translateToLocal(Strings.Gui_CommandMenu_Command), 6, 4, 0xFFFFFF);
            }
        }
        GL11.glPopMatrix();
        // Magic submenu //
        if (spells == null) {} else if (!spells.isEmpty()) {
            // MAGIC TOP
            GL11.glPushMatrix();
            {
                GL11.glColor4ub((byte) 255, (byte) 255, (byte) 255, (byte) this.alpha);
                mc.renderEngine.bindTexture(texture);
                GL11.glTranslatef(5, (height - MENU_HEIGHT * scale * (spells.size() + 1)), 0);
                GL11.glScalef(scale, scale, scale);
                if (submenu == SUB_MAGIC) {
                    drawTexturedModalRect(0, 0, 0, 0, TOP_WIDTH, TOP_HEIGHT);
                    drawString(mc.fontRenderer, Utils.translateToLocal(Strings.Gui_CommandMenu_Magic_Title), 6, 4, 0xFFFFFF);
                }
            }
            GL11.glPopMatrix();
            for (int i = 0; i < spells.size(); i++) {
                GL11.glPushMatrix();
                {
                    GL11.glColor4ub((byte) 255, (byte) 255, (byte) 255, (byte) this.alpha);
                    int u;
                    int v;
                    int x;
                    x = (magicselected == i) ? 10 : 5;

                    mc.renderEngine.bindTexture(texture);
                    GL11.glTranslatef(x, (height - MENU_HEIGHT * scale * (spells.size() - i)), 0);
                    GL11.glScalef(scale, scale, scale);
                    if (submenu == SUB_MAGIC) {
                        v = 0;
                        if (magicselected == i)
                            drawTexturedModalRect(0, 0, TOP_WIDTH, 15, TOP_WIDTH + MENU_WIDTH, v + MENU_HEIGHT);
                        else
                            drawTexturedModalRect(0, 0, TOP_WIDTH, 0, TOP_WIDTH + MENU_WIDTH, v + MENU_HEIGHT);
                        colour = Constants.getCost(spells.get(i)) < STATS.getMP() ? 0xFFFFFF : 0xFF9900;
                        if (spells.get(i).equals(Strings.Spell_Cure)) colour = 0xFF9900;
                        colour = STATS.getMP() < 1 ? 0x888888 : colour;

                        String magic = spells.get(i);
                        int level = mc.player.getCapability(ModCapabilities.MAGIC_STATE, null).getMagicLevel(magic);
                        String magicName = Constants.getMagicName(magic, level);
                        drawString(mc.fontRenderer, Utils.translateToLocal(magicName), 6, 4, colour);
                        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
                    }
                }
                GL11.glPopMatrix();
            }
        }
        // Items submenu //
        if (items == null) {} else if (!items.isEmpty()) {
            // Items TOP
            GL11.glPushMatrix();
            {
                GL11.glColor4ub((byte) 255, (byte) 255, (byte) 255, (byte) this.alpha);
                mc.renderEngine.bindTexture(texture);
                GL11.glTranslatef(5, (height - MENU_HEIGHT * scale * (items.size() + 1)), 0);
                GL11.glScalef(scale, scale, scale);
                if (submenu == SUB_ITEMS) {
                    drawTexturedModalRect(0, 0, 0, 0, TOP_WIDTH, TOP_HEIGHT);
                    drawString(mc.fontRenderer, Utils.translateToLocal("ITEMS"), 6, 4, 0xFFFFFF);
                }

            }
            GL11.glPopMatrix();
            for (int i = 0; i < items.size(); i++) {
                GL11.glPushMatrix();
                {
                    GL11.glColor4ub((byte) 255, (byte) 255, (byte) 255, (byte) this.alpha);
                    int u;
                    int v;
                    int x;
                    x = (potionselected == i) ? 10 : 5;

                    mc.renderEngine.bindTexture(texture);
                    GL11.glTranslatef(x, (height - MENU_HEIGHT * scale * (items.size() - i)), 0);
                    GL11.glScalef(scale, scale, scale);
                    if (submenu == SUB_ITEMS) {
                        v = 0;
                        if (potionselected == i)
                            drawTexturedModalRect(0, 0, TOP_WIDTH, 15, TOP_WIDTH + MENU_WIDTH, v + MENU_HEIGHT);
                        else
                            drawTexturedModalRect(0, 0, TOP_WIDTH, 0, TOP_WIDTH + MENU_WIDTH, v + MENU_HEIGHT);
                        drawString(mc.fontRenderer, Utils.translateToLocal("item." + items.get(i) + ".name"), 6, 4, 0xFFFFFF);

                        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
                    }
                }
                GL11.glPopMatrix();
            }
        }

        // Drive form submenu //
        if (driveCommands == null) {} else if (!driveCommands.isEmpty()) {
            // DRIVE TOP
            GL11.glPushMatrix();
            {
                GL11.glColor4ub((byte) 255, (byte) 255, (byte) 255, (byte) this.alpha);
                mc.renderEngine.bindTexture(texture);
                GL11.glTranslatef(5, (height - MENU_HEIGHT * scale * (driveCommands.size() + 1)), 0);
                GL11.glScalef(1.25f, scale, scale);
                if (submenu == SUB_DRIVE) drawTexturedModalRect(0, 0, 0, 0, TOP_WIDTH, TOP_HEIGHT);
            }
            GL11.glPopMatrix();

            GL11.glPushMatrix();
            {
                GL11.glColor4ub((byte) 255, (byte) 255, (byte) 255, (byte) this.alpha);
                GL11.glTranslatef(5, (height - MENU_HEIGHT * scale * (driveCommands.size() + 1)), 0);
                GL11.glScalef(scale, scale, scale);
                if (submenu == SUB_DRIVE) drawString(mc.fontRenderer, Utils.translateToLocal(Strings.Gui_CommandMenu_Drive_Title), 6, 4, 0xFFFFFF);
            }
            GL11.glPopMatrix();
            for (int i = 0; i < driveCommands.size(); i++) {
                GL11.glPushMatrix();
                {
                    GL11.glColor4ub((byte) 255, (byte) 255, (byte) 255, (byte) this.alpha);
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
                        if (driveselected == i)
                            drawTexturedModalRect(0, 0, TOP_WIDTH, 15, TOP_WIDTH + MENU_WIDTH, v + MENU_HEIGHT);
                        else
                            drawTexturedModalRect(0, 0, TOP_WIDTH, 0, TOP_WIDTH + MENU_WIDTH, v + MENU_HEIGHT);
                    }
                }
                GL11.glPopMatrix();

                GL11.glPushMatrix();
                {
                    GL11.glColor4ub((byte) 80, (byte) 80, (byte) 80, (byte) this.alpha);
                    int x;
                    x = (driveselected == i) ? 10 : 5;
                    GL11.glTranslatef(x, (height - MENU_HEIGHT * scale * (driveCommands.size() - i)), 0);
                    GL11.glScalef(scale, scale, scale);
                    if (submenu == SUB_DRIVE) {
                        if (STATS.getDP() >= Constants.getCost(driveCommands.get(i)) || mc.player.getCapability(ModCapabilities.CHEAT_MODE, null).getCheatMode())
                            drawString(mc.fontRenderer, Utils.translateToLocal(driveCommands.get(i)), 6, 4, 0xFFFFFF);
                        else
                            drawString(mc.fontRenderer, Utils.translateToLocal(driveCommands.get(i)), 6, 4, 0x888888);
                    }
                    GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);

                }
                GL11.glPopMatrix();
            }
        }
    }
}
