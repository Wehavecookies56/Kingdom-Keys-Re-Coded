package wehavecookies56.kk.client.gui;

import ibxm.Player;

import java.io.IOException;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.GL11;

import wehavecookies56.kk.entities.ExtendedPlayer;
import wehavecookies56.kk.lib.Reference;
import wehavecookies56.kk.lib.Strings;
import wehavecookies56.kk.magic.Magic;
import wehavecookies56.kk.util.TextHelper;

@SideOnly(Side.CLIENT)
public class GuiCommandMenu extends GuiScreen {
	Minecraft mc = Minecraft.getMinecraft();

	public static final int TOP = 5, ATTACK = 4, MAGIC = 3, ITEMS = 2, DRIVE = 1;

	public static final int MAGIC_TOP = 8, FIRE = 7, BLIZZARD = 6, THUNDER = 5, CURE = 4, GRAVITY = 3, AERO = 2, STOP = 1;
	public static final int DRIVE_TOP = 6, VALOR = 5, WISDOM = 4, LIMIT = 3, MASTER = 2, FINAL = 1;
	//int selected = ATTACK;

	final int TOP_WIDTH = 70;
	final int TOP_HEIGHT = 15;

	final int MENU_WIDTH = 71;
	final int MENU_HEIGHT = 15;

	public static final int SUB_MAIN = 0, SUB_MAGIC = 1, SUB_ITEMS = 2, SUB_DRIVE = 3;

	public static final int NONE = 0;
	public static int selected = ATTACK;
	public static int submenu = 0;
	public static int magicselected = 0;
	public static int itemselected = -1;
	public static int driveselected = 0;
	public static boolean FireUnlocked = true, BlizzardUnlocked, ThunderUnlocked, CureUnlocked, GravityUnlocked, AeroUnlocked, StopUnlocked, ValorUnlocked, WisdomUnlocked, LimitUnlocked, MasterUnlocked, FinalUnlocked;

	ResourceLocation texture = new ResourceLocation(Reference.MODID, "textures/gui/commandmenu.png");

	@SubscribeEvent(priority = EventPriority.NORMAL)
	public void onRenderOverlayPost(RenderGameOverlayEvent event){
		if(event.type == RenderGameOverlayEvent.ElementType.TEXT && !mc.ingameGUI.getChatGUI().getChatOpen()) {
			GL11.glPushMatrix();{
				//drawTexturedModalRect(0, mc.displayHeight/2 - MENU_HEIGHT, TOP_WIDTH, 0, TOP_WIDTH + MENU_WIDTH, MENU_HEIGHT);
				drawCommandMenu(event.resolution.getScaledWidth(), event.resolution.getScaledHeight());
			}
			GL11.glPopMatrix();
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

	public void drawCommandMenu(int width, int height){

		//float height = mc.displayHeight/2*1.75f;
		float scale = 1.05f;
		int colour;
		//DRIVE
		GL11.glPushMatrix();{
			int u;
			int v;
			int x;
			if(selected == DRIVE){
				v=MENU_HEIGHT;
				x=5;
			}else{
				v=0;
				x=0;
			}
			mc.renderEngine.bindTexture(texture);
			GL11.glTranslatef(x, (height - MENU_HEIGHT*scale*DRIVE), 0);
			GL11.glScalef(scale, scale, scale);
			drawTexturedModalRect(0, 0, TOP_WIDTH, v, TOP_WIDTH + MENU_WIDTH, v + MENU_HEIGHT);
			if(ExtendedPlayer.get(mc.thePlayer).getInDrive())
			{
				if(ExtendedPlayer.get(mc.thePlayer).getDriveInUse().equals("anti"))
				{
					drawString(mc.fontRendererObj,	"Revert", 6, 4, 0x555555);
				}
				else
				{
					drawString(mc.fontRendererObj,	"Revert", 6, 4, 0xFFFFFF);
				}
				GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
			}
			else
			{
				drawString(mc.fontRendererObj, 	TextHelper.localize(Strings.Gui_CommandMenu_Drive), 6, 4, 0xFFFFFF);
			}
		}GL11.glPopMatrix();
		//ITEMS
		GL11.glPushMatrix();{
			int u;
			int v;
			int x;
			if(selected == ITEMS){
				v=MENU_HEIGHT;
				x=5;
			}else{
				v=0;
				x=0;
			}
			mc.renderEngine.bindTexture(texture);
			GL11.glTranslatef(x, (height - MENU_HEIGHT*scale*ITEMS), 0);
			GL11.glScalef(scale, scale, scale);
			drawTexturedModalRect(0, 0, TOP_WIDTH, v, TOP_WIDTH + MENU_WIDTH, v + MENU_HEIGHT);
			drawString(mc.fontRendererObj, TextHelper.localize(Strings.Gui_CommandMenu_Items), 6, 4, 0xFFFFFF);
		}GL11.glPopMatrix();
		//MAGIC
		GL11.glPushMatrix();{
			int u;
			int v;
			int x;
			if(selected == MAGIC){
				v=MENU_HEIGHT;
				x=5;
			}else{
				v=0;
				x=0;
			}
			mc.renderEngine.bindTexture(texture);
			GL11.glTranslatef(x, (height - MENU_HEIGHT*scale*MAGIC), 0);
			GL11.glScalef(scale, scale, scale);
			drawTexturedModalRect(0, 0, TOP_WIDTH, v, TOP_WIDTH + MENU_WIDTH, v + MENU_HEIGHT);
			drawString(mc.fontRendererObj, TextHelper.localize(Strings.Gui_CommandMenu_Magic), 6, 4, 0xFFFFFF);
		}GL11.glPopMatrix();
		//ATTACK
		GL11.glPushMatrix();{
			int u;
			int v;
			int x;
			if(selected == ATTACK){
				v=MENU_HEIGHT;
				x=5;
			}else{
				v=0;
				x=0;
			}
			mc.renderEngine.bindTexture(texture);
			GL11.glTranslatef(x, (height - MENU_HEIGHT*scale*ATTACK), 0);
			GL11.glScalef(scale, scale, scale);
			drawTexturedModalRect(0, 0, TOP_WIDTH, v, TOP_WIDTH + MENU_WIDTH, v + MENU_HEIGHT);
			drawString(mc.fontRendererObj, TextHelper.localize(Strings.Gui_CommandMenu_Attack), 6, 4, 0xFFFFFF);
		}GL11.glPopMatrix();
		//TOP
		GL11.glPushMatrix();{
			mc.renderEngine.bindTexture(texture);
			GL11.glTranslatef(0, (height - MENU_HEIGHT*scale*TOP), 0);
			GL11.glScalef(scale, scale, scale);
			drawTexturedModalRect(0, 0, 0, 0, TOP_WIDTH, TOP_HEIGHT);
			drawString(mc.fontRendererObj, TextHelper.localize(Strings.Gui_CommandMenu_Command), 6, 4, 0xFFFFFF);
		}GL11.glPopMatrix();
		//MAGIC TOP
		GL11.glPushMatrix();{
			mc.renderEngine.bindTexture(texture);
			GL11.glTranslatef(5, (height - MENU_HEIGHT*scale*MAGIC_TOP), 0);
			GL11.glScalef(scale, scale, scale);
			if(submenu == SUB_MAGIC){
				drawTexturedModalRect(0, 0, 0, 0, TOP_WIDTH, TOP_HEIGHT);
				drawString(mc.fontRendererObj, TextHelper.localize(Strings.Gui_CommandMenu_Magic_Title), 6, 4, 0xFFFFFF);
			}
		}GL11.glPopMatrix();
		//FIRE
		GL11.glPushMatrix();{
			int u;
			int v;
			int x;
			if(magicselected == FIRE){
				v=MENU_HEIGHT;
				x=10;
			}else{
				v=0;
				x=5;
			}
			mc.renderEngine.bindTexture(texture);
			GL11.glTranslatef(x, (height - MENU_HEIGHT*scale*FIRE), 0);
			GL11.glScalef(scale, scale, scale);
			if(submenu == SUB_MAGIC){
				drawTexturedModalRect(0, 0, TOP_WIDTH, v, TOP_WIDTH + MENU_WIDTH, v + MENU_HEIGHT);
				colour = Magic.getMagicCost("fire") < ExtendedPlayer.get(Minecraft.getMinecraft().thePlayer).getMp() ? 0xFFFFFF : 0xFF9900;
				colour = ExtendedPlayer.get(Minecraft.getMinecraft().thePlayer).getMp() < 1 ? 0x555555 : colour;
				drawString(mc.fontRendererObj, TextHelper.localize(Strings.Gui_CommandMenu_Magic_Fire), 6, 4, colour);
				GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
			}
		}GL11.glPopMatrix();
		//BLIZZARD
		GL11.glPushMatrix();{
			int u;
			int v;
			int x;
			if(magicselected == BLIZZARD){
				v=MENU_HEIGHT;
				x=10;
			}else{
				v=0;
				x=5;
			}
			mc.renderEngine.bindTexture(texture);
			GL11.glTranslatef(x, (height - MENU_HEIGHT*scale*BLIZZARD), 0);
			GL11.glScalef(scale, scale, scale);
			if(submenu == SUB_MAGIC){
				drawTexturedModalRect(0, 0, TOP_WIDTH, v, TOP_WIDTH + MENU_WIDTH, v + MENU_HEIGHT);
				colour = Magic.getMagicCost("blizzard") < ExtendedPlayer.get(Minecraft.getMinecraft().thePlayer).getMp() ? 0xFFFFFF : 0xFF9900;
				colour = ExtendedPlayer.get(Minecraft.getMinecraft().thePlayer).getMp() < 1 ? 0x555555 : colour;
				drawString(mc.fontRendererObj, TextHelper.localize(Strings.Gui_CommandMenu_Magic_Blizzard), 6, 4, colour);
				GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
			}
		}GL11.glPopMatrix();
		//THUNDER
		GL11.glPushMatrix();{
			int u;
			int v;
			int x;
			if(magicselected == THUNDER){
				v=MENU_HEIGHT;
				x=10;
			}else{
				v=0;
				x=5;
			}
			mc.renderEngine.bindTexture(texture);
			GL11.glTranslatef(x, (height - MENU_HEIGHT*scale*THUNDER), 0);
			GL11.glScalef(scale, scale, scale);
			if(submenu == SUB_MAGIC){
				drawTexturedModalRect(0, 0, TOP_WIDTH, v, TOP_WIDTH + MENU_WIDTH, v + MENU_HEIGHT);
				colour = Magic.getMagicCost("thunder") < ExtendedPlayer.get(Minecraft.getMinecraft().thePlayer).getMp() ? 0xFFFFFF : 0xFF9900;
				colour = ExtendedPlayer.get(Minecraft.getMinecraft().thePlayer).getMp() < 1 ? 0x555555 : colour;
				drawString(mc.fontRendererObj, TextHelper.localize(Strings.Gui_CommandMenu_Magic_Thunder), 6, 4, colour);
				GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
			}
		}GL11.glPopMatrix();
		//CURE
		GL11.glPushMatrix();{
			int u;
			int v;
			int x;
			if(magicselected == CURE){
				v=MENU_HEIGHT;
				x=10;
			}else{
				v=0;
				x=5;
			}
			mc.renderEngine.bindTexture(texture);
			GL11.glTranslatef(x, (height - MENU_HEIGHT*scale*CURE), 0);
			GL11.glScalef(scale, scale, scale);
			if(submenu == SUB_MAGIC){
				drawTexturedModalRect(0, 0, TOP_WIDTH, v, TOP_WIDTH + MENU_WIDTH, v + MENU_HEIGHT);
				colour = Magic.getMagicCost("cure") < ExtendedPlayer.get(Minecraft.getMinecraft().thePlayer).getMp() ? 0xFFFFFF : 0xFF9900;
				colour = ExtendedPlayer.get(Minecraft.getMinecraft().thePlayer).getMp() < 1 ? 0x555555 : colour;
				drawString(mc.fontRendererObj, TextHelper.localize(Strings.Gui_CommandMenu_Magic_Cure), 6, 4, colour);
				GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
			}
		}GL11.glPopMatrix();
		//GRAVITY
		GL11.glPushMatrix();{
			int u;
			int v;
			int x;
			if(magicselected == GRAVITY){
				v=MENU_HEIGHT;
				x=10;
			}else{
				v=0;
				x=5;
			}
			mc.renderEngine.bindTexture(texture);
			GL11.glTranslatef(x, (height - MENU_HEIGHT*scale*GRAVITY), 0);
			GL11.glScalef(scale, scale, scale);
			if(submenu == SUB_MAGIC){
				drawTexturedModalRect(0, 0, TOP_WIDTH, v, TOP_WIDTH + MENU_WIDTH, v + MENU_HEIGHT);
				colour = Magic.getMagicCost("gravity") < ExtendedPlayer.get(Minecraft.getMinecraft().thePlayer).getMp() ? 0xFFFFFF : 0xFF9900;
				colour = ExtendedPlayer.get(Minecraft.getMinecraft().thePlayer).getMp() < 1 ? 0x555555 : colour;
				drawString(mc.fontRendererObj, TextHelper.localize(Strings.Gui_CommandMenu_Magic_Gravity), 6, 4, colour);
				GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
			}
		}GL11.glPopMatrix();
		//AERO
		GL11.glPushMatrix();{
			int u;
			int v;
			int x;
			if(magicselected == AERO){
				v=MENU_HEIGHT;
				x=10;
			}else{
				v=0;
				x=5;
			}
			mc.renderEngine.bindTexture(texture);
			GL11.glTranslatef(x, (height - MENU_HEIGHT*scale*AERO), 0);
			GL11.glScalef(scale, scale, scale);
			if(submenu == SUB_MAGIC){
				drawTexturedModalRect(0, 0, TOP_WIDTH, v, TOP_WIDTH + MENU_WIDTH, v + MENU_HEIGHT);
				colour = Magic.getMagicCost("aero") < ExtendedPlayer.get(Minecraft.getMinecraft().thePlayer).getMp() ? 0xFFFFFF : 0xFF9900;
				colour = ExtendedPlayer.get(Minecraft.getMinecraft().thePlayer).getMp() < 1 ? 0x555555 : colour;
				drawString(mc.fontRendererObj, TextHelper.localize(Strings.Gui_CommandMenu_Magic_Aero), 6, 4, colour);
				GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
			}
		}GL11.glPopMatrix();
		//STOP
		GL11.glPushMatrix();{
			int u;
			int v;
			int x;
			if(magicselected == STOP){
				v=MENU_HEIGHT;
				x=10;
			}else{
				v=0;
				x=5;
			}
			mc.renderEngine.bindTexture(texture);
			GL11.glTranslatef(x, (height - MENU_HEIGHT*scale*STOP), 0);
			GL11.glScalef(scale, scale, scale);
			if(submenu == SUB_MAGIC){
				drawTexturedModalRect(0, 0, TOP_WIDTH, v, TOP_WIDTH + MENU_WIDTH, v + MENU_HEIGHT);
				colour = Magic.getMagicCost("stop") < ExtendedPlayer.get(Minecraft.getMinecraft().thePlayer).getMp() ? 0xFFFFFF : 0xFF9900;
				colour = ExtendedPlayer.get(Minecraft.getMinecraft().thePlayer).getMp() < 1 ? 0x555555 : colour;
				drawString(mc.fontRendererObj, TextHelper.localize(Strings.Gui_CommandMenu_Magic_Stop), 6, 4, colour);
				GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
			}
		}GL11.glPopMatrix();
		//DRIVE TOP
		GL11.glPushMatrix();{
			mc.renderEngine.bindTexture(texture);
			GL11.glTranslatef(5, (height - MENU_HEIGHT*scale*DRIVE_TOP), 0);
			GL11.glScalef(1.25f, scale, scale);
			if(submenu == SUB_DRIVE){
				drawTexturedModalRect(0, 0, 0, 0, TOP_WIDTH, TOP_HEIGHT);
			}
		}GL11.glPopMatrix();

		GL11.glPushMatrix();{
			GL11.glTranslatef(5, (height - MENU_HEIGHT*scale*DRIVE_TOP), 0);
			GL11.glScalef(scale, scale, scale);
			if(submenu == SUB_DRIVE){
				drawString(mc.fontRendererObj, TextHelper.localize(Strings.Gui_CommandMenu_Drive_Title), 6, 4, 0xFFFFFF);
			}
		}GL11.glPopMatrix();
		//VALOR
		GL11.glPushMatrix();{
			int u;
			int v;
			int x;
			if(driveselected == VALOR){
				v=MENU_HEIGHT;
				x=10;
			}else{
				v=0;
				x=5;
			}
			mc.renderEngine.bindTexture(texture);
			GL11.glTranslatef(x, (height - MENU_HEIGHT*scale*VALOR), 0);
			GL11.glScalef(1.25f, scale, scale);
			if(submenu == SUB_DRIVE){
				drawTexturedModalRect(0, 0, TOP_WIDTH, v, TOP_WIDTH + MENU_WIDTH, v + MENU_HEIGHT);
			}
		}GL11.glPopMatrix();

		GL11.glPushMatrix();{
			int x;
			if(driveselected == VALOR){
				x=10;
			}else{
				x=5;
			}
			GL11.glTranslatef(x, (height - MENU_HEIGHT*scale*VALOR), 0);
			GL11.glScalef(scale, scale, scale);
			if(submenu == SUB_DRIVE){
				drawString(mc.fontRendererObj, TextHelper.localize(Strings.Gui_CommandMenu_Drive_Valor), 6, 4, 0xFFFFFF);
			}
		}GL11.glPopMatrix();
		//WISDOM
		GL11.glPushMatrix();{
			int u;
			int v;
			int x;
			if(driveselected == WISDOM){
				v=MENU_HEIGHT;
				x=10;
			}else{
				v=0;
				x=5;
			}
			mc.renderEngine.bindTexture(texture);
			GL11.glTranslatef(x, (height - MENU_HEIGHT*scale*WISDOM), 0);
			GL11.glScalef(1.25f, scale, scale);
			if(submenu == SUB_DRIVE){
				drawTexturedModalRect(0, 0, TOP_WIDTH, v, TOP_WIDTH + MENU_WIDTH, v + MENU_HEIGHT);
			}
		}GL11.glPopMatrix();
		GL11.glPushMatrix();{
			int x;
			if(driveselected == WISDOM){
				x=10;
			}else{
				x=5;
			}
			GL11.glTranslatef(x, (height - MENU_HEIGHT*scale*WISDOM), 0);
			GL11.glScalef(scale, scale, scale);
			if(submenu == SUB_DRIVE){
				drawString(mc.fontRendererObj, TextHelper.localize(Strings.Gui_CommandMenu_Drive_Wisdom), 6, 4, 0xFFFFFF);
			}
		}GL11.glPopMatrix();
		//LIMIT
		GL11.glPushMatrix();{
			int u;
			int v;
			int x;
			if(driveselected == LIMIT){
				v=MENU_HEIGHT;
				x=10;
			}else{
				v=0;
				x=5;
			}
			mc.renderEngine.bindTexture(texture);
			GL11.glTranslatef(x, (height - MENU_HEIGHT*scale*LIMIT), 0);
			GL11.glScalef(1.25f, scale, scale);
			if(submenu == SUB_DRIVE){
				drawTexturedModalRect(0, 0, TOP_WIDTH, v, TOP_WIDTH + MENU_WIDTH, v + MENU_HEIGHT);
			}
		}GL11.glPopMatrix();
		GL11.glPushMatrix();{
			int x;
			if(driveselected == LIMIT){
				x=10;
			}else{
				x=5;
			}
			GL11.glTranslatef(x, (height - MENU_HEIGHT*scale*LIMIT), 0);
			GL11.glScalef(scale, scale, scale);
			if(submenu == SUB_DRIVE){
				drawString(mc.fontRendererObj, TextHelper.localize(Strings.Gui_CommandMenu_Drive_Limit), 6, 4, 0xFFFFFF);
			}
		}GL11.glPopMatrix();
		//MASTER
		GL11.glPushMatrix();{
			int u;
			int v;
			int x;
			if(driveselected == MASTER){
				v=MENU_HEIGHT;
				x=10;
			}else{
				v=0;
				x=5;
			}
			mc.renderEngine.bindTexture(texture);
			GL11.glTranslatef(x, (height - MENU_HEIGHT*scale*MASTER), 0);
			GL11.glScalef(1.25f, scale, scale);
			if(submenu == SUB_DRIVE){
				drawTexturedModalRect(0, 0, TOP_WIDTH, v, TOP_WIDTH + MENU_WIDTH, v + MENU_HEIGHT);
			}
		}GL11.glPopMatrix();
		GL11.glPushMatrix();{
			int x;
			if(driveselected == MASTER){
				x=10;
			}else{
				x=5;
			}
			GL11.glTranslatef(x, (height - MENU_HEIGHT*scale*MASTER), 0);
			GL11.glScalef(scale, scale, scale);
			if(submenu == SUB_DRIVE){
				drawString(mc.fontRendererObj, TextHelper.localize(Strings.Gui_CommandMenu_Drive_Master), 6, 4, 0xFFFFFF);
			}
		}GL11.glPopMatrix();
		//FINAL
		GL11.glPushMatrix();{
			int u;
			int v;
			int x;
			if(driveselected == FINAL){
				v=MENU_HEIGHT;
				x=10;
			}else{
				v=0;
				x=5;
			}
			x = driveselected == FINAL ? 10 : 5;
			mc.renderEngine.bindTexture(texture);
			GL11.glTranslatef(x, (height - MENU_HEIGHT*scale*FINAL), 0);
			GL11.glScalef(1.25f, scale, scale);
			if(submenu == SUB_DRIVE){
				drawTexturedModalRect(0, 0, TOP_WIDTH, v, TOP_WIDTH + MENU_WIDTH, v + MENU_HEIGHT);
			}
		}GL11.glPopMatrix();
		GL11.glPushMatrix();{
			int x;
			if(driveselected == FINAL){
				x=10;
			}else{
				x=5;
			}
			GL11.glTranslatef(x, (height - MENU_HEIGHT*scale*FINAL), 0);
			GL11.glScalef(scale, scale, scale);
			if(submenu == SUB_DRIVE){
				drawString(mc.fontRendererObj, TextHelper.localize(Strings.Gui_CommandMenu_Drive_Final), 6, 4, 0xFFFFFF);
			}
		}GL11.glPopMatrix();
	}

}
