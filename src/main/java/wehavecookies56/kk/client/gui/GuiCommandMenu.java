package wehavecookies56.kk.client.gui;


import java.io.IOException;

import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.GL11;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import wehavecookies56.kk.entities.ExtendedPlayer;
import wehavecookies56.kk.lib.Constants;
import wehavecookies56.kk.lib.Reference;
import wehavecookies56.kk.lib.Strings;
import wehavecookies56.kk.magic.Magic;
import wehavecookies56.kk.util.EventHandler;
import wehavecookies56.kk.util.TextHelper;

@SideOnly(Side.CLIENT)
public class GuiCommandMenu extends GuiScreen {
	Minecraft mc = Minecraft.getMinecraft();

	public static final int TOP = 5, ATTACK = 4, MAGIC = 3, ITEMS = 2, DRIVE = 1;

	public static final int MAGIC_TOP = 8, FIRE = 7, BLIZZARD = 6, THUNDER = 5, CURE = 4, GRAVITY = 3, AERO = 2, STOP = 1;
	public static final int POTION_TOP = 6, POTION1 = 5, POTION2 = 4, POTION3 = 3, POTION4 = 2, POTION5 = 1;
	public static final int DRIVE_TOP = 6, VALOR = 5, WISDOM = 4, LIMIT = 3, MASTER = 2, FINAL = 1;
	//int selected = ATTACK;

	int TOP_WIDTH = 70;
	int TOP_HEIGHT = 15;

	int MENU_WIDTH = 71;
	int MENU_HEIGHT = 15;
	
	int textX = 0;
	

	public static final int SUB_MAIN = 0, SUB_MAGIC = 1, SUB_ITEMS = 2, SUB_DRIVE = 3;

	public static final int NONE = 0;
	public static int selected = ATTACK;
	public static int submenu = 0;
	public static int magicselected = 0;
	public static int potionselected = 0;
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
		//System.out.println("Submenu: "+submenu+" Selected:"+selected+" Magic:"+magicselected+" Drive:"+driveselected);
		//float height = mc.displayHeight/2*1.75f;
		float scale = 1.05f;
		int colour;
		//DRIVE
		GL11.glPushMatrix();{
			int u;
			int v=0;
			int x=0;
						
			mc.renderEngine.bindTexture(texture);
			GL11.glTranslatef(x, (height - MENU_HEIGHT*scale*DRIVE), 0);
			GL11.glScalef(scale, scale, scale);
			
			if(selected == DRIVE){ //Selected
				textX=5;
				if(EventHandler.isHostiles) //Selected with hostile
				{
					drawTexturedModalRect(5, 0, TOP_WIDTH, 30, TOP_WIDTH + MENU_WIDTH, v + MENU_HEIGHT);
				}
				else //Selected peaceful
				{
					drawTexturedModalRect(5, 0, TOP_WIDTH, MENU_HEIGHT, TOP_WIDTH + MENU_WIDTH, v + MENU_HEIGHT);
				}

			}else{ //Not selected
				textX=0;

				if(EventHandler.isHostiles) //Not selected with hostile
				{
					drawTexturedModalRect(0, 0, 0, 30, TOP_WIDTH, v + MENU_HEIGHT);
				}
				else //Not selected peaceful
				{
					drawTexturedModalRect(0, 0, TOP_WIDTH, 0, TOP_WIDTH + MENU_WIDTH, v + MENU_HEIGHT);
				}
			}
			
			if(ExtendedPlayer.get(mc.thePlayer).getInDrive())
			{
				if(ExtendedPlayer.get(mc.thePlayer).getDriveInUse().equals("Anti"))
				{
					drawString(mc.fontRendererObj,	"Revert", 6+textX, 4, 0x888888);
				}
				else
				{
					drawString(mc.fontRendererObj,	"Revert", 6+textX, 4, 0xFFFFFF);
				}
				GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
			}
			else
			{
				drawString(mc.fontRendererObj, 	TextHelper.localize(Strings.Gui_CommandMenu_Drive), 6+textX, 4, 0xFFFFFF);
			}

		}GL11.glPopMatrix();
		//ITEMS
		GL11.glPushMatrix();{
			int u;
			int v=0;
			int x=0;
			
			mc.renderEngine.bindTexture(texture);
			GL11.glTranslatef(x, (height - MENU_HEIGHT*scale*ITEMS), 0);
			GL11.glScalef(scale, scale, scale);
			
			if(selected == ITEMS){ //Selected
				textX=5;
				if(EventHandler.isHostiles) //Selected with hostile
				{
					drawTexturedModalRect(5, 0, TOP_WIDTH, 30, TOP_WIDTH + MENU_WIDTH, v + MENU_HEIGHT);
				}
				else //Selected peaceful
				{
					drawTexturedModalRect(5, 0, TOP_WIDTH, MENU_HEIGHT, TOP_WIDTH + MENU_WIDTH, v + MENU_HEIGHT);
				}

			}else{ //Not selected
				textX=0;

				if(EventHandler.isHostiles) //Not selected with hostile
				{
					drawTexturedModalRect(0, 0, 0, 30, TOP_WIDTH, v + MENU_HEIGHT);
				}
				else //Not selected peaceful
				{
					drawTexturedModalRect(0, 0, TOP_WIDTH, 0, TOP_WIDTH + MENU_WIDTH, v + MENU_HEIGHT);
				}
			}			
			drawString(mc.fontRendererObj, TextHelper.localize(Strings.Gui_CommandMenu_Items), 6+textX, 4, 0xFFFFFF);
			
			GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		}GL11.glPopMatrix();
		//MAGIC
		GL11.glPushMatrix();{
			int u;
			int v=0;
			int x=0;			
			mc.renderEngine.bindTexture(texture);
			GL11.glTranslatef(x, (height - MENU_HEIGHT*scale*MAGIC), 0);
			GL11.glScalef(scale, scale, scale);
			
			if(selected == MAGIC){ //Selected
				textX=5;
				if(EventHandler.isHostiles) //Selected with hostile
				{
					drawTexturedModalRect(5, 0, TOP_WIDTH, 30, TOP_WIDTH + MENU_WIDTH, v + MENU_HEIGHT);
				}
				else //Selected peaceful
				{
					drawTexturedModalRect(5, 0, TOP_WIDTH, MENU_HEIGHT, TOP_WIDTH + MENU_WIDTH, v + MENU_HEIGHT);
				}

			}else{ //Not selected
				textX=0;

				if(EventHandler.isHostiles) //Not selected with hostile
				{
					drawTexturedModalRect(0, 0, 0, 30, TOP_WIDTH, v + MENU_HEIGHT);
				}
				else //Not selected peaceful
				{
					drawTexturedModalRect(0, 0, TOP_WIDTH, 0, TOP_WIDTH + MENU_WIDTH, v + MENU_HEIGHT);
				}
			}
			
			if(ExtendedPlayer.get(mc.thePlayer).getRecharge() == false &&
			(ExtendedPlayer.get(mc.thePlayer).getMagicLevel("Fire") > 0 || 
			ExtendedPlayer.get(mc.thePlayer).getMagicLevel("Blizzard") > 0 || 
			ExtendedPlayer.get(mc.thePlayer).getMagicLevel("Thunder") > 0 || 
			ExtendedPlayer.get(mc.thePlayer).getMagicLevel("Cure") > 0 || 
			ExtendedPlayer.get(mc.thePlayer).getMagicLevel("Gravity") > 0 ||
			ExtendedPlayer.get(mc.thePlayer).getMagicLevel("Aero") > 0 ||
			ExtendedPlayer.get(mc.thePlayer).getMagicLevel("Stop") > 0) &&
			!ExtendedPlayer.get(mc.thePlayer).getDriveInUse().equals("Valor"))
			{
				drawString(mc.fontRendererObj, TextHelper.localize(Strings.Gui_CommandMenu_Magic), 6+textX, 4, 0xFFFFFF);
			}
			else
			{
				drawString(mc.fontRendererObj, TextHelper.localize(Strings.Gui_CommandMenu_Magic), 6+textX, 4, 0x888888);
			}
			GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		}GL11.glPopMatrix();
		//ATTACK
		GL11.glPushMatrix();{
			int u;
			int v = 0;
			int x = 0;
			mc.renderEngine.bindTexture(texture);
			GL11.glTranslatef(x, (height - MENU_HEIGHT*scale*ATTACK), 0);
			GL11.glScalef(scale, scale, scale);

			if(selected == ATTACK){ //Selected
				textX=5;
				if(EventHandler.isHostiles) //Selected with hostile
				{
					drawTexturedModalRect(5, 0, TOP_WIDTH, 30, TOP_WIDTH + MENU_WIDTH, v + MENU_HEIGHT);
				}
				else //Selected peaceful
				{
					drawTexturedModalRect(5, 0, TOP_WIDTH, MENU_HEIGHT, TOP_WIDTH + MENU_WIDTH, v + MENU_HEIGHT);
				}

			}else{ //Not selected
				textX=0;

				if(EventHandler.isHostiles) //Not selected with hostile
				{
					drawTexturedModalRect(0, 0, 0, 30, TOP_WIDTH, v + MENU_HEIGHT);
				}
				else //Not selected peaceful
				{
					drawTexturedModalRect(0, 0, TOP_WIDTH, 0, TOP_WIDTH + MENU_WIDTH, v + MENU_HEIGHT);
				}
			}
			drawString(mc.fontRendererObj, TextHelper.localize(Strings.Gui_CommandMenu_Attack), 6+textX, 4, 0xFFFFFF);

		}GL11.glPopMatrix();
		//TOP
		GL11.glPushMatrix();{
			mc.renderEngine.bindTexture(texture);				
			GL11.glTranslatef(0, (height - MENU_HEIGHT*scale*TOP), 0);
			GL11.glScalef(scale, scale, scale);
			if(EventHandler.isHostiles)
				drawTexturedModalRect(0, 0, 0, 15, TOP_WIDTH, TOP_HEIGHT);
			else
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
			x = (magicselected == FIRE) ? 10 : 5;
			
			mc.renderEngine.bindTexture(texture);
			GL11.glTranslatef(x, (height - MENU_HEIGHT*scale*FIRE), 0);
			GL11.glScalef(scale, scale, scale);
			if(submenu == SUB_MAGIC){
				v=0;
				if(magicselected == FIRE){
					drawTexturedModalRect(0, 0, TOP_WIDTH, 15, TOP_WIDTH + MENU_WIDTH, v + MENU_HEIGHT);				
				}else{
					drawTexturedModalRect(0, 0, TOP_WIDTH, 0, TOP_WIDTH + MENU_WIDTH, v + MENU_HEIGHT);				
				}
				colour = Constants.FIRE_COST < ExtendedPlayer.get(Minecraft.getMinecraft().thePlayer).getMp() ? 0xFFFFFF : 0xFF9900;
				colour = ExtendedPlayer.get(Minecraft.getMinecraft().thePlayer).getMp() < 1 ? 0x888888 : colour;
				switch(ExtendedPlayer.get(mc.thePlayer).getMagicLevel("Fire"))
				{
				case 1:
					drawString(mc.fontRendererObj, TextHelper.localize(Strings.Gui_CommandMenu_Magic_Fire), 6, 4, colour);
					break;
				case 2:
					drawString(mc.fontRendererObj, TextHelper.localize(Strings.Gui_CommandMenu_Magic_Fira), 6, 4, colour);
					break;
				case 3:
					drawString(mc.fontRendererObj, TextHelper.localize(Strings.Gui_CommandMenu_Magic_Firaga), 6, 4, colour);

					break;
				}
				GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
			}
		}GL11.glPopMatrix();
		//BLIZZARD
		GL11.glPushMatrix();{
			int u;
			int v;
			int x;
			x = (magicselected == BLIZZARD) ? 10 : 5;
			
			mc.renderEngine.bindTexture(texture);
			GL11.glTranslatef(x, (height - MENU_HEIGHT*scale*BLIZZARD), 0);
			GL11.glScalef(scale, scale, scale);
			if(submenu == SUB_MAGIC){
				v=0;
				if(magicselected == BLIZZARD){
					drawTexturedModalRect(0, 0, TOP_WIDTH, 15, TOP_WIDTH + MENU_WIDTH, v + MENU_HEIGHT);				
				}else{
					drawTexturedModalRect(0, 0, TOP_WIDTH, 0, TOP_WIDTH + MENU_WIDTH, v + MENU_HEIGHT);				
				}
				colour = Constants.BLIZZARD_COST < ExtendedPlayer.get(Minecraft.getMinecraft().thePlayer).getMp() ? 0xFFFFFF : 0xFF9900;
				colour = ExtendedPlayer.get(Minecraft.getMinecraft().thePlayer).getMp() < 1 ? 0x888888 : colour;
				switch(ExtendedPlayer.get(mc.thePlayer).getMagicLevel("Blizzard"))
				{
				case 1:
					drawString(mc.fontRendererObj, TextHelper.localize(Strings.Gui_CommandMenu_Magic_Blizzard), 6, 4, colour);
					break;
				case 2:
					drawString(mc.fontRendererObj, TextHelper.localize(Strings.Gui_CommandMenu_Magic_Blizzara), 6, 4, colour);
					break;
				case 3:
					drawString(mc.fontRendererObj, TextHelper.localize(Strings.Gui_CommandMenu_Magic_Blizzaga), 6, 4, colour);
					break;
				}
				GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
			}
		}GL11.glPopMatrix();
		//THUNDER
		GL11.glPushMatrix();{
			int u;
			int v;
			int x;
			x = (magicselected == THUNDER) ? 10 : 5;
			
			mc.renderEngine.bindTexture(texture);
			GL11.glTranslatef(x, (height - MENU_HEIGHT*scale*THUNDER), 0);
			GL11.glScalef(scale, scale, scale);
			if(submenu == SUB_MAGIC){
				v=0;
				if(magicselected == THUNDER){
					drawTexturedModalRect(0, 0, TOP_WIDTH, 15, TOP_WIDTH + MENU_WIDTH, v + MENU_HEIGHT);				
				}else{
					drawTexturedModalRect(0, 0, TOP_WIDTH, 0, TOP_WIDTH + MENU_WIDTH, v + MENU_HEIGHT);				
				}
				colour = Constants.THUNDER_COST < ExtendedPlayer.get(Minecraft.getMinecraft().thePlayer).getMp() ? 0xFFFFFF : 0xFF9900;
				colour = ExtendedPlayer.get(Minecraft.getMinecraft().thePlayer).getMp() < 1 ? 0x888888 : colour;
				switch(ExtendedPlayer.get(mc.thePlayer).getMagicLevel("Thunder"))
				{
				case 1:
					drawString(mc.fontRendererObj, TextHelper.localize(Strings.Gui_CommandMenu_Magic_Thunder), 6, 4, colour);
					break;
				case 2:
					drawString(mc.fontRendererObj, TextHelper.localize(Strings.Gui_CommandMenu_Magic_Thundara), 6, 4, colour);
					break;
				case 3:
					drawString(mc.fontRendererObj, TextHelper.localize(Strings.Gui_CommandMenu_Magic_Thundaga), 6, 4, colour);
					break;
				}
				GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
			}
		}GL11.glPopMatrix();
		//CURE
		GL11.glPushMatrix();{
			int u;
			int v;
			int x;
			x = (magicselected == CURE) ? 10 : 5;
			
			mc.renderEngine.bindTexture(texture);
			GL11.glTranslatef(x, (height - MENU_HEIGHT*scale*CURE), 0);
			GL11.glScalef(scale, scale, scale);
			if(submenu == SUB_MAGIC){
				v=0;
				if(magicselected == CURE){
					drawTexturedModalRect(0, 0, TOP_WIDTH, 15, TOP_WIDTH + MENU_WIDTH, v + MENU_HEIGHT);				
				}else{
					drawTexturedModalRect(0, 0, TOP_WIDTH, 0, TOP_WIDTH + MENU_WIDTH, v + MENU_HEIGHT);				
				}				colour = 0xFF9900;
				colour = ExtendedPlayer.get(Minecraft.getMinecraft().thePlayer).getMp() < 1 ? 0x888888 : colour;
				switch(ExtendedPlayer.get(mc.thePlayer).getMagicLevel("Cure"))
				{
				case 1:
					drawString(mc.fontRendererObj, TextHelper.localize(Strings.Gui_CommandMenu_Magic_Cure), 6, 4, colour);
					break;
				case 2:
					drawString(mc.fontRendererObj, TextHelper.localize(Strings.Gui_CommandMenu_Magic_Cura), 6, 4, colour);
					break;
				case 3:
					drawString(mc.fontRendererObj, TextHelper.localize(Strings.Gui_CommandMenu_Magic_Curaga), 6, 4, colour);
					break;
				}
				GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
			}
		}GL11.glPopMatrix();
		//GRAVITY
		GL11.glPushMatrix();{
			int u;
			int v;
			int x;
			x = (magicselected == GRAVITY) ? 10 : 5;
			
			mc.renderEngine.bindTexture(texture);
			GL11.glTranslatef(x, (height - MENU_HEIGHT*scale*GRAVITY), 0);
			GL11.glScalef(scale, scale, scale);
			if(submenu == SUB_MAGIC){
				v=0;
				if(magicselected == GRAVITY){
					drawTexturedModalRect(0, 0, TOP_WIDTH, 15, TOP_WIDTH + MENU_WIDTH, v + MENU_HEIGHT);				
				}else{
					drawTexturedModalRect(0, 0, TOP_WIDTH, 0, TOP_WIDTH + MENU_WIDTH, v + MENU_HEIGHT);				
				}
				colour = Constants.GRAVITY_COST < ExtendedPlayer.get(Minecraft.getMinecraft().thePlayer).getMp() ? 0xFFFFFF : 0xFF9900;
				colour = ExtendedPlayer.get(Minecraft.getMinecraft().thePlayer).getMp() < 1 ? 0x888888 : colour;
				colour = 0x888888;
				switch(ExtendedPlayer.get(mc.thePlayer).getMagicLevel("Gravity"))
				{
				case 1:
					drawString(mc.fontRendererObj, TextHelper.localize(Strings.Gui_CommandMenu_Magic_Gravity), 6, 4, colour);
					break;
				case 2:
					drawString(mc.fontRendererObj, TextHelper.localize(Strings.Gui_CommandMenu_Magic_Gravira), 6, 4, colour);
					break;
				case 3:
					drawString(mc.fontRendererObj, TextHelper.localize(Strings.Gui_CommandMenu_Magic_Graviga), 6, 4, colour);
					break;
				}
				GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
			}
		}GL11.glPopMatrix();
		//AERO
		GL11.glPushMatrix();{
			int u;
			int v;
			int x;
			x = (magicselected == AERO) ? 10 : 5;
			
			mc.renderEngine.bindTexture(texture);
			GL11.glTranslatef(x, (height - MENU_HEIGHT*scale*AERO), 0);
			GL11.glScalef(scale, scale, scale);
			if(submenu == SUB_MAGIC){
				v=0;
				if(magicselected == AERO){
					drawTexturedModalRect(0, 0, TOP_WIDTH, 15, TOP_WIDTH + MENU_WIDTH, v + MENU_HEIGHT);				
				}else{
					drawTexturedModalRect(0, 0, TOP_WIDTH, 0, TOP_WIDTH + MENU_WIDTH, v + MENU_HEIGHT);				
				}
				colour = Constants.AERO_COST < ExtendedPlayer.get(Minecraft.getMinecraft().thePlayer).getMp() ? 0xFFFFFF : 0xFF9900;
				colour = ExtendedPlayer.get(Minecraft.getMinecraft().thePlayer).getMp() < 1 ? 0x888888 : colour;
				switch(ExtendedPlayer.get(mc.thePlayer).getMagicLevel("Aero"))
				{
				case 1:
					drawString(mc.fontRendererObj, TextHelper.localize(Strings.Gui_CommandMenu_Magic_Aero), 6, 4, colour);
					break;
				case 2:
					drawString(mc.fontRendererObj, TextHelper.localize(Strings.Gui_CommandMenu_Magic_Aerora), 6, 4, colour);
					break;
				case 3:
					drawString(mc.fontRendererObj, TextHelper.localize(Strings.Gui_CommandMenu_Magic_Aeroga), 6, 4, colour);
					break;
				}
				GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
			}
		}GL11.glPopMatrix();
		//STOP
		GL11.glPushMatrix();{
			int u;
			int v;
			int x;
			x = (magicselected == STOP) ? 10 : 5;
			
			mc.renderEngine.bindTexture(texture);
			GL11.glTranslatef(x, (height - MENU_HEIGHT*scale*STOP), 0);
			GL11.glScalef(scale, scale, scale);
			if(submenu == SUB_MAGIC){
				v=0;
				if(magicselected == STOP){
					drawTexturedModalRect(0, 0, TOP_WIDTH, 15, TOP_WIDTH + MENU_WIDTH, v + MENU_HEIGHT);				
				}else{
					drawTexturedModalRect(0, 0, TOP_WIDTH, 0, TOP_WIDTH + MENU_WIDTH, v + MENU_HEIGHT);				
				}
				colour = Constants.STOP_COST < ExtendedPlayer.get(Minecraft.getMinecraft().thePlayer).getMp() ? 0xFFFFFF : 0xFF9900;
				colour = ExtendedPlayer.get(Minecraft.getMinecraft().thePlayer).getMp() < 1 ? 0x888888 : colour;
				colour = 0x888888;
				switch(ExtendedPlayer.get(mc.thePlayer).getMagicLevel("Stop"))
				{
				case 1:
					drawString(mc.fontRendererObj, TextHelper.localize(Strings.Gui_CommandMenu_Magic_Stop), 6, 4, colour);
					break;
				case 2:
					drawString(mc.fontRendererObj, TextHelper.localize(Strings.Gui_CommandMenu_Magic_Stopra), 6, 4, colour);
					break;
				case 3:
					drawString(mc.fontRendererObj, TextHelper.localize(Strings.Gui_CommandMenu_Magic_Stopga), 6, 4, colour);
					break;
				}
				GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
			}
		}GL11.glPopMatrix();
		
			//Items TOP
		GL11.glPushMatrix();{
			mc.renderEngine.bindTexture(texture);
			GL11.glTranslatef(5, (height - MENU_HEIGHT*scale*POTION_TOP), 0);
			GL11.glScalef(scale, scale, scale);
			if(submenu == SUB_ITEMS){
				drawTexturedModalRect(0, 0, 0, 0, TOP_WIDTH, TOP_HEIGHT);
			}
			
		}GL11.glPopMatrix();

		GL11.glPushMatrix();{
			GL11.glTranslatef(5, (height - MENU_HEIGHT*scale*POTION_TOP), 0);
			GL11.glScalef(scale, scale, scale);
			if(submenu == SUB_ITEMS){
				drawString(mc.fontRendererObj, TextHelper.localize("ITEMS"), 6, 4, 0xFFFFFF);
			}
		}GL11.glPopMatrix();
			//POTION1
		GL11.glPushMatrix();{
			int u;
			int v;
			int x;
			x = (potionselected == POTION1) ? 10 : 5;
			
			mc.renderEngine.bindTexture(texture);
			GL11.glTranslatef(x, (height - MENU_HEIGHT*scale*POTION1), 0);
			GL11.glScalef(scale, scale, scale);
			if(submenu == SUB_ITEMS){
				v=0;
				if(potionselected == POTION1){
					drawTexturedModalRect(0, 0, TOP_WIDTH, 15, TOP_WIDTH + MENU_WIDTH, v + MENU_HEIGHT);				
				}else{
					drawTexturedModalRect(0, 0, TOP_WIDTH, 0, TOP_WIDTH + MENU_WIDTH, v + MENU_HEIGHT);				
				}
				String ItemName = "";
				if(ExtendedPlayer.get(mc.thePlayer).inventory3.getStackInSlot(0) != null)
				{
					ItemName = ExtendedPlayer.get(mc.thePlayer).inventory3.getStackInSlot(0).getDisplayName();
				}
				drawString(mc.fontRendererObj, TextHelper.localize(ItemName), 6, 4, 0xFFFFFF);
				GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
			}
		}GL11.glPopMatrix();
		//POTION2
		GL11.glPushMatrix();{
			int u;
			int v;
			int x;
			x = (potionselected == POTION2) ? 10 : 5;
			
			mc.renderEngine.bindTexture(texture);
			GL11.glTranslatef(x, (height - MENU_HEIGHT*scale*POTION2), 0);
			GL11.glScalef(scale, scale, scale);
			if(submenu == SUB_ITEMS){
				v=0;
				if(potionselected == POTION2){
					drawTexturedModalRect(0, 0, TOP_WIDTH, 15, TOP_WIDTH + MENU_WIDTH, v + MENU_HEIGHT);				
				}else{
					drawTexturedModalRect(0, 0, TOP_WIDTH, 0, TOP_WIDTH + MENU_WIDTH, v + MENU_HEIGHT);				
				}
				String ItemName = "";
				if(ExtendedPlayer.get(mc.thePlayer).inventory3.getStackInSlot(1) != null)
				{
					ItemName = ExtendedPlayer.get(mc.thePlayer).inventory3.getStackInSlot(1).getDisplayName();
				}
				drawString(mc.fontRendererObj, TextHelper.localize(ItemName), 6, 4, 0xFFFFFF);
				GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
			}
		}GL11.glPopMatrix();
		//POTION3
		GL11.glPushMatrix();{
			int u;
			int v;
			int x;
			x = (potionselected == POTION3) ? 10 : 5;
			
			mc.renderEngine.bindTexture(texture);
			GL11.glTranslatef(x, (height - MENU_HEIGHT*scale*POTION3), 0);
			GL11.glScalef(scale, scale, scale);
			if(submenu == SUB_ITEMS){
				v=0;
				if(potionselected == POTION3){
					drawTexturedModalRect(0, 0, TOP_WIDTH, 15, TOP_WIDTH + MENU_WIDTH, v + MENU_HEIGHT);				
				}else{
					drawTexturedModalRect(0, 0, TOP_WIDTH, 0, TOP_WIDTH + MENU_WIDTH, v + MENU_HEIGHT);				
				}
				String ItemName = "";
				if(ExtendedPlayer.get(mc.thePlayer).inventory3.getStackInSlot(2) != null)
				{
					ItemName = ExtendedPlayer.get(mc.thePlayer).inventory3.getStackInSlot(2).getDisplayName();
				}
				drawString(mc.fontRendererObj, TextHelper.localize(ItemName), 6, 4, 0xFFFFFF);
				GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
			}
		}GL11.glPopMatrix();
		//POTION4
		GL11.glPushMatrix();{
			int u;
			int v;
			int x;
			x = (potionselected == POTION4) ? 10 : 5;
			
			mc.renderEngine.bindTexture(texture);
			GL11.glTranslatef(x, (height - MENU_HEIGHT*scale*POTION4), 0);
			GL11.glScalef(scale, scale, scale);
			if(submenu == SUB_ITEMS){
				v=0;
				if(potionselected == POTION4){
					drawTexturedModalRect(0, 0, TOP_WIDTH, 15, TOP_WIDTH + MENU_WIDTH, v + MENU_HEIGHT);				
				}else{
					drawTexturedModalRect(0, 0, TOP_WIDTH, 0, TOP_WIDTH + MENU_WIDTH, v + MENU_HEIGHT);				
				}
				String ItemName = "";
				if(ExtendedPlayer.get(mc.thePlayer).inventory3.getStackInSlot(3) != null)
				{
					ItemName = ExtendedPlayer.get(mc.thePlayer).inventory3.getStackInSlot(3).getDisplayName();
				}
				drawString(mc.fontRendererObj, TextHelper.localize(ItemName), 6, 4, 0xFFFFFF);
				GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
			}
		}GL11.glPopMatrix();
		//POTION5
				GL11.glPushMatrix();{
					int u;
					int v;
					int x;
					x = (potionselected == POTION5) ? 10 : 5;
					
					mc.renderEngine.bindTexture(texture);
					GL11.glTranslatef(x, (height - MENU_HEIGHT*scale*POTION5), 0);
					GL11.glScalef(scale, scale, scale);
					if(submenu == SUB_ITEMS){
						v=0;
						if(potionselected == POTION5){
							drawTexturedModalRect(0, 0, TOP_WIDTH, 15, TOP_WIDTH + MENU_WIDTH, v + MENU_HEIGHT);				
						}else{
							drawTexturedModalRect(0, 0, TOP_WIDTH, 0, TOP_WIDTH + MENU_WIDTH, v + MENU_HEIGHT);				
						}
						String ItemName = "";
						if(ExtendedPlayer.get(mc.thePlayer).inventory3.getStackInSlot(4) != null)
						{
							ItemName = ExtendedPlayer.get(mc.thePlayer).inventory3.getStackInSlot(4).getDisplayName();
						}
						drawString(mc.fontRendererObj, TextHelper.localize(ItemName), 6, 4, 0xFFFFFF);
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
			x = (driveselected == VALOR) ? 10 : 5;
			v = (driveselected == VALOR) ? MENU_HEIGHT : 0;
			
			mc.renderEngine.bindTexture(texture);
			GL11.glTranslatef(x, (height - MENU_HEIGHT*scale*VALOR), 0);
			GL11.glScalef(1.25f, scale, scale);
			if(submenu == SUB_DRIVE){
				v=0;
				if(driveselected == VALOR){
					drawTexturedModalRect(0, 0, TOP_WIDTH, 15, TOP_WIDTH + MENU_WIDTH, v + MENU_HEIGHT);				
				}else{
					drawTexturedModalRect(0, 0, TOP_WIDTH, 0, TOP_WIDTH + MENU_WIDTH, v + MENU_HEIGHT);				
				}
			}
		}GL11.glPopMatrix();

		GL11.glPushMatrix();{
			int x;
			x = (driveselected == VALOR) ? 10 : 5;
			GL11.glTranslatef(x, (height - MENU_HEIGHT*scale*VALOR), 0);
			GL11.glScalef(scale, scale, scale);
			if(submenu == SUB_DRIVE){
				if(ExtendedPlayer.get(mc.thePlayer).getDriveLevel("Valor") == 0)
				{
					
				}
				else if(ExtendedPlayer.get(mc.thePlayer).getDP() >= 300 || ExtendedPlayer.get(mc.thePlayer).cheatMode)
				{
					drawString(mc.fontRendererObj, TextHelper.localize(Strings.Gui_CommandMenu_Drive_Valor), 6, 4, 0xFFFFFF);
				}
				else
				{
					drawString(mc.fontRendererObj, TextHelper.localize(Strings.Gui_CommandMenu_Drive_Valor), 6, 4, 0x888888);
				}
				GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
			}
		}GL11.glPopMatrix();
		//WISDOM
		GL11.glPushMatrix();{
			int u;
			int v;
			int x;
			x = (driveselected == WISDOM) ? 10 : 5;
			v = (driveselected == WISDOM) ? MENU_HEIGHT : 0;
			
			mc.renderEngine.bindTexture(texture);
			GL11.glTranslatef(x, (height - MENU_HEIGHT*scale*WISDOM), 0);
			GL11.glScalef(1.25f, scale, scale);
			if(submenu == SUB_DRIVE){
				v=0;
				if(driveselected == WISDOM){
					drawTexturedModalRect(0, 0, TOP_WIDTH, 15, TOP_WIDTH + MENU_WIDTH, v + MENU_HEIGHT);				
				}else{
					drawTexturedModalRect(0, 0, TOP_WIDTH, 0, TOP_WIDTH + MENU_WIDTH, v + MENU_HEIGHT);				
				}
			}
		}GL11.glPopMatrix();
		GL11.glPushMatrix();{
			int x;
			x = (driveselected == WISDOM) ? 10 : 5;
			GL11.glTranslatef(x, (height - MENU_HEIGHT*scale*WISDOM), 0);
			GL11.glScalef(scale, scale, scale);
			if(submenu == SUB_DRIVE){
				if(ExtendedPlayer.get(mc.thePlayer).getDriveLevel("Wisdom") == 0)
				{
					
				}
				else if(ExtendedPlayer.get(mc.thePlayer).getDP() >= 300 || ExtendedPlayer.get(mc.thePlayer).cheatMode)
				{
					drawString(mc.fontRendererObj, TextHelper.localize(Strings.Gui_CommandMenu_Drive_Wisdom), 6, 4, 0xFFFFFF);
				}
				else
				{
					drawString(mc.fontRendererObj, TextHelper.localize(Strings.Gui_CommandMenu_Drive_Wisdom), 6, 4, 0x888888);
				}
				GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
			}
		}GL11.glPopMatrix();
		//LIMIT
		GL11.glPushMatrix();{
			int u;
			int v;
			int x;
			x = (driveselected == LIMIT) ? 10 : 5;
			v = (driveselected == LIMIT) ? MENU_HEIGHT : 0;
			
			mc.renderEngine.bindTexture(texture);
			GL11.glTranslatef(x, (height - MENU_HEIGHT*scale*LIMIT), 0);
			GL11.glScalef(1.25f, scale, scale);
			if(submenu == SUB_DRIVE){
				v=0;
				if(driveselected == LIMIT){
					drawTexturedModalRect(0, 0, TOP_WIDTH, 15, TOP_WIDTH + MENU_WIDTH, v + MENU_HEIGHT);				
				}else{
					drawTexturedModalRect(0, 0, TOP_WIDTH, 0, TOP_WIDTH + MENU_WIDTH, v + MENU_HEIGHT);				
				}
			}
		}GL11.glPopMatrix();
		GL11.glPushMatrix();{
			int x;
			x = (driveselected == LIMIT) ? 10 : 5;
			GL11.glTranslatef(x, (height - MENU_HEIGHT*scale*LIMIT), 0);
			GL11.glScalef(scale, scale, scale);
			if(submenu == SUB_DRIVE){
				if(ExtendedPlayer.get(mc.thePlayer).getDriveLevel("Limit") == 0)
				{
					
				}
				else if(ExtendedPlayer.get(mc.thePlayer).getDP() >= 400 || ExtendedPlayer.get(mc.thePlayer).cheatMode)
				{
					drawString(mc.fontRendererObj, TextHelper.localize(Strings.Gui_CommandMenu_Drive_Limit), 6, 4, 0xFFFFFF);
				}
				else
				{
					drawString(mc.fontRendererObj, TextHelper.localize(Strings.Gui_CommandMenu_Drive_Limit), 6, 4, 0x888888);
				}
				GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
			}
		}GL11.glPopMatrix();
		//MASTER
		GL11.glPushMatrix();{
			int u;
			int v;
			int x;
			x = (driveselected == MASTER) ? 10 : 5;
			v = (driveselected == MASTER) ? MENU_HEIGHT : 0;
			
			mc.renderEngine.bindTexture(texture);
			GL11.glTranslatef(x, (height - MENU_HEIGHT*scale*MASTER), 0);
			GL11.glScalef(1.25f, scale, scale);
			if(submenu == SUB_DRIVE){
				v=0;
				if(driveselected == MASTER){
					drawTexturedModalRect(0, 0, TOP_WIDTH, 15, TOP_WIDTH + MENU_WIDTH, v + MENU_HEIGHT);				
				}else{
					drawTexturedModalRect(0, 0, TOP_WIDTH, 0, TOP_WIDTH + MENU_WIDTH, v + MENU_HEIGHT);				
				}
			}
		}GL11.glPopMatrix();
		GL11.glPushMatrix();{
			int x;
			x = (driveselected == MASTER) ? 10 : 5;
			GL11.glTranslatef(x, (height - MENU_HEIGHT*scale*MASTER), 0);
			GL11.glScalef(scale, scale, scale);
			if(submenu == SUB_DRIVE){
				if(ExtendedPlayer.get(mc.thePlayer).getDriveLevel("Master") == 0)
				{
					
				}
				else if(ExtendedPlayer.get(mc.thePlayer).getDP() >= 400 || ExtendedPlayer.get(mc.thePlayer).cheatMode)
				{
					drawString(mc.fontRendererObj, TextHelper.localize(Strings.Gui_CommandMenu_Drive_Master), 6, 4, 0xFFFFFF);
				}
				else
				{
					drawString(mc.fontRendererObj, TextHelper.localize(Strings.Gui_CommandMenu_Drive_Master), 6, 4, 0x888888);
				}
				GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
			}
		}GL11.glPopMatrix();
		//FINAL
		GL11.glPushMatrix();{
			int u;
			int v;
			int x;
			x = (driveselected == FINAL) ? 10 : 5;
			v = (driveselected == FINAL) ? MENU_HEIGHT : 0;
			
			mc.renderEngine.bindTexture(texture);
			GL11.glTranslatef(x, (height - MENU_HEIGHT*scale*FINAL), 0);
			GL11.glScalef(1.25f, scale, scale);
			if(submenu == SUB_DRIVE){
				v=0;
				if(driveselected == FINAL){
					drawTexturedModalRect(0, 0, TOP_WIDTH, 15, TOP_WIDTH + MENU_WIDTH, v + MENU_HEIGHT);				
				}else{
					drawTexturedModalRect(0, 0, TOP_WIDTH, 0, TOP_WIDTH + MENU_WIDTH, v + MENU_HEIGHT);				
				}
			}
		}GL11.glPopMatrix();
		GL11.glPushMatrix();{
			int x;
			x = (driveselected == FINAL) ? 10 : 5;
			GL11.glTranslatef(x, (height - MENU_HEIGHT*scale*FINAL), 0);
			GL11.glScalef(scale, scale, scale);
			if(submenu == SUB_DRIVE){
				if(ExtendedPlayer.get(mc.thePlayer).getDriveLevel("Final") == 0)
				{
					
				}
				else if(ExtendedPlayer.get(mc.thePlayer).getDP() >= 500 || ExtendedPlayer.get(mc.thePlayer).cheatMode)
				{
					drawString(mc.fontRendererObj, TextHelper.localize(Strings.Gui_CommandMenu_Drive_Final), 6, 4, 0xFFFFFF);
				}
				else
				{
					drawString(mc.fontRendererObj, TextHelper.localize(Strings.Gui_CommandMenu_Drive_Final), 6, 4, 0x888888);
				}
				GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
			}
		}GL11.glPopMatrix();
	}

}
