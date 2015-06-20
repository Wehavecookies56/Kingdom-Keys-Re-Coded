package wehavecookies56.kk.client.gui;

import java.io.IOException;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.StatCollector;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.GL11;

import scala.Console;
import wehavecookies56.kk.client.keys.Keybinds;
import wehavecookies56.kk.lib.Reference;

public class GuiCommandMenu extends GuiScreen {
	Minecraft mc = Minecraft.getMinecraft();
	public static final int TOP = 5, ATTACK = 4, MAGIC = 3, ITEMS = 2, DRIVE = 1;
	
	public static final int FIRE = 7, BLIZZARD = 6, THUNDER = 5, CURE = 4, GRAVITY = 3, AERO = 2, STOP = 1;
	public static final int VALOR=5, WISDOM=4, LIMIT=3, MASTER=2, FINAL=1;
	//int selected = ATTACK;
	
	final int TOP_WIDTH = 70;
	final int TOP_HEIGHT = 15;
	
	final int MENU_WIDTH = 71;
	final int MENU_HEIGHT = 15;
	
	public static int selected = ATTACK;
	public static int submenu = 0;
	public static int magicselected = -1;
	public static int itemselected = -1;
	public static int driveselected = -1;
	
	ResourceLocation texture = new ResourceLocation(Reference.MODID, "textures/gui/commandmenu.png");
	
	ScaledResolution sr = new ScaledResolution(mc, mc.displayWidth, mc.displayHeight);
    int Width = sr.getScaledWidth();
    int Height = sr.getScaledHeight();
	
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
		System.out.println(this.height);
		super.initGui();
	}
	
	@Override
	public void handleMouseInput() throws IOException {
		int i = Mouse.getEventDWheel();
		
		super.handleMouseInput();
	}
		
	public void drawCommandMenu(int width, int height){
		//System.out.println(this.height);

		//float height = mc.displayHeight/2*1.75f;
		float scale = 0.75f;
		//DRIVE
		GL11.glPushMatrix();{
			int u;
			int v;
			if(selected == DRIVE){
				v=MENU_HEIGHT;
			}else{
				v=0;
			}
			mc.renderEngine.bindTexture(texture);
			GL11.glTranslatef(0, (height - MENU_HEIGHT*scale*DRIVE), 0);
			GL11.glScalef(scale, scale, scale);
			drawTexturedModalRect(0, 0, TOP_WIDTH, v, TOP_WIDTH + MENU_WIDTH, v+MENU_HEIGHT);
			drawString(mc.fontRendererObj, "DRIVE", 6, 4, 0xFFFFFF);
		}GL11.glPopMatrix();
		//ITEMS
		GL11.glPushMatrix();{
			int u;
			int v;
			if(selected == ITEMS){
				v=MENU_HEIGHT;
			}else{
				v=0;
			}
			mc.renderEngine.bindTexture(texture);
			GL11.glTranslatef(0, (height - MENU_HEIGHT*scale*ITEMS), 0);
			GL11.glScalef(scale, scale, scale);
			drawTexturedModalRect(0, 0, TOP_WIDTH, v, TOP_WIDTH + MENU_WIDTH, v+MENU_HEIGHT);
			drawString(mc.fontRendererObj, "ITEMS", 6, 4, 0xFFFFFF);
		}GL11.glPopMatrix();
		//MAGIC
		GL11.glPushMatrix();{
			int u;
			int v;
			if(selected == MAGIC){
				v=MENU_HEIGHT;
			}else{
				v=0;
			}
			mc.renderEngine.bindTexture(texture);
			GL11.glTranslatef(0, (height - MENU_HEIGHT*scale*MAGIC), 0);
			GL11.glScalef(scale, scale, scale);
			drawTexturedModalRect(0, 0, TOP_WIDTH, v, TOP_WIDTH + MENU_WIDTH, v+MENU_HEIGHT);
			drawString(mc.fontRendererObj, "MAGIC", 6, 4, 0xFFFFFF);
		}GL11.glPopMatrix();
		//ATTACK
		GL11.glPushMatrix();{
			int u;
			int v;
			if(selected == ATTACK){
				v=MENU_HEIGHT;
			}else{
				v=0;
			}
			mc.renderEngine.bindTexture(texture);
			GL11.glTranslatef(0, (height - MENU_HEIGHT*scale*ATTACK), 0);
			GL11.glScalef(scale, scale, scale);
			drawTexturedModalRect(0, 0, TOP_WIDTH, v, TOP_WIDTH + MENU_WIDTH, v+MENU_HEIGHT);
			drawString(mc.fontRendererObj, "ATTACK", 6, 4, 0xFFFFFF);
		}GL11.glPopMatrix();
		//TOP
		GL11.glPushMatrix();{
			mc.renderEngine.bindTexture(texture);
			GL11.glTranslatef(0, (height - MENU_HEIGHT*scale*TOP), 0);
			GL11.glScalef(scale, scale, scale);
			drawTexturedModalRect(0, 0, 0, 0, TOP_WIDTH, TOP_HEIGHT);
			drawString(mc.fontRendererObj, "COMMAND", 6, 4, 0xFFFFFF);
		}GL11.glPopMatrix();
	}
}
