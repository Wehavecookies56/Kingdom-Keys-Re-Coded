package wehavecookies56.kk.client.gui;

import java.io.IOException;

import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL12;
import org.omg.CORBA.REBIND;

import wehavecookies56.kk.lib.Reference;
import wehavecookies56.kk.lib.Strings;
import wehavecookies56.kk.util.TextHelper;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.AbstractClientPlayer;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.inventory.GuiInventory;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraft.world.chunk.Chunk;

public class GuiMenu extends GuiScreen {

	final int ITEMS = 0, ABILITIES = 1, CUSTOMIZE = 2, PARTY = 3, STATUS = 4, JOURNAL = 5, CONFIG = 6, ITEMS_PLAYER = 7, ITEMS_STOCK = 8, ITEMS_BACK = 9;	
	final int SUBMENU_MAIN = 0, SUBMENU_ITEMS = 1;
	
	GuiButton items, abilities, customize, party, status, journal, config, items_player, items_stock, items_back;
	
	int submenuIndex = SUBMENU_MAIN;

	//ResourceLocation skin = ((AbstractClientPlayer) mc.thePlayer).getLocationSkin();
	@Override
	public void drawScreen(int mouseX, int mouseY, float partialTicks) {
		/*
		GL11.glEnable(GL11.GL_COLOR_MATERIAL);
		GL11.glPushMatrix();
		GL11.glTranslatef((float)35, (float)120, 50.0F);
		GL11.glScalef((float)(-30), (float)30, (float)30);
		//GL11.glRotatef(135.0F, 0.0F, 1.0F, 0.0F);
		//RenderHelper.disableStandardItemLighting();
		GL11.glTranslatef(0.0F, mc.thePlayer.renderOffsetY, 0.0F);
		//mc.getRenderManager().playerViewY = 180.0F;
		GL11.glPushMatrix();
		GL11.glRotatef(180, 0, 0, 1);
		//GL11.glRotatef(rotate, 0, 1, 0);
		RenderHelper.disableStandardItemLighting();
		GL11.glDisable(GL11.GL_LIGHTING);
		mc.getRenderManager().renderEntityWithPosYaw(mc.thePlayer, 0.0D, 0.0D, 0.0D, 0.0F, 0.0F);
		GL11.glPopMatrix();
		GL11.glPopMatrix();
		*/
		RenderHelper.disableStandardItemLighting();
		drawBackground(width, height);
		super.drawScreen(mouseX, mouseY, partialTicks);

		
	}

	public static final ResourceLocation optionsBackground = new ResourceLocation(Reference.MODID, "textures/gui/menubg.png");

	@Override
	protected void actionPerformed(GuiButton button) throws IOException {
		switch(button.id){
		case ITEMS:
			submenuIndex = SUBMENU_ITEMS;
			break;
		case ITEMS_BACK:
			submenuIndex = SUBMENU_MAIN;
			break;
		case ITEMS_STOCK:
			mc.displayGuiScreen(new GuiInventory(mc.thePlayer));
			break;
		case JOURNAL:
			mc.displayGuiScreen(new GuiReports());
			break;
		}
		updateButtons();
	}
	
	
	
    @Override
    public void initGui() {
    	super.initGui();
    	int button_itemsY = (-140/16) + 75;
    	int button_abilitiesY = button_itemsY + 22;
    	int button_customizeY = button_abilitiesY + 22;
    	int button_partyY = button_customizeY + 22;
    	int button_statusY = button_partyY + 22;
    	int button_journalY = button_statusY + 22;
    	int button_configY = button_journalY + 22;
    	
    	int button_items_playerY = button_itemsY;
    	int button_items_stockY = button_items_playerY + 22;
    	int button_items_backY = button_items_stockY + 22;
    	
    	buttonList.add(items = new GuiButton(ITEMS, 5, button_itemsY, 100, 20, TextHelper.localize(Strings.Gui_Menu_Main_Button_Items)));
    	buttonList.add(abilities = new GuiButton(ABILITIES, 5, button_abilitiesY, 100, 20, TextHelper.localize(Strings.Gui_Menu_Main_Button_Abilities)));
    	buttonList.add(customize = new GuiButton(CUSTOMIZE, 5, button_customizeY, 100, 20, TextHelper.localize(Strings.Gui_Menu_Main_Button_Customize)));
    	buttonList.add(party = new GuiButton(PARTY, 5, button_partyY, 100, 20, TextHelper.localize(Strings.Gui_Menu_Main_Button_Party)));
    	buttonList.add(status = new GuiButton(STATUS, 5, button_statusY, 100, 20, TextHelper.localize(Strings.Gui_Menu_Main_Button_Status)));
    	buttonList.add(journal = new GuiButton(JOURNAL, 5, button_journalY, 100, 20, TextHelper.localize(Strings.Gui_Menu_Main_Button_Journal)));
    	buttonList.add(config = new GuiButton(CONFIG, 5, button_configY, 100, 20, TextHelper.localize(Strings.Gui_Menu_Main_Button_Config)));
    	buttonList.add(items_player = new GuiButton(ITEMS_PLAYER, 5, button_items_playerY, 100, 20, mc.thePlayer.getDisplayNameString()));
    	buttonList.add(items_stock = new GuiButton(ITEMS_STOCK, 5, button_items_stockY, 100, 20, TextHelper.localize(Strings.Gui_Menu_Items_Button_Stock)));
    	buttonList.add(items_back = new GuiButton(ITEMS_BACK, 5, button_items_backY, 100, 20, TextHelper.localize(Strings.Gui_Menu_Items_Button_Back)));

    	updateButtons();
    }
	private void updateButtons() {
		switch(submenuIndex){
		case SUBMENU_MAIN:
			this.items.visible = true;
			abilities.visible = true;
			customize.visible = true;
			party.visible = true;
			status.visible = true;
			journal.visible = true;
			config.visible = true;
			items_player.visible = false;
			items_stock.visible = false;
			items_back.visible = false;
			break;
		case SUBMENU_ITEMS:
			items.visible = false;
			abilities.visible = false;
			customize.visible = false;
			party.visible = false;
			status.visible = false;
			journal.visible = false;
			config.visible = false;
			items_player.visible = true;
			items_stock.visible = true;
			items_back.visible = true;
			break;
		}
	}

	public static String getWorldMinutes(World world) {
        int time = (int) Math.abs((world.getWorldTime() + 6000) % 24000);
        if((time % 1000) * 6 / 100 < 10){
        	return "0" + (time % 1000) * 6 / 100;
        }else{
        	return Integer.toString((time % 1000) * 6 / 100);
        }
    }

    public static int getWorldHours(World world) {
        int time = (int)Math.abs((world.getWorldTime()+ 6000) % 24000);
        return (int)((float)time / 1000F);
    }

	protected void drawBackground(int screenWidth, int screenHeight) {
		Minecraft.getMinecraft().renderEngine.bindTexture(optionsBackground);
        GL11.glPushMatrix();
        {
    	GL11.glColor3ub((byte)24, (byte)36, (byte)214);
		//GL11.glColor4f(0.3F, 0.3F, 0.3F, 1.0F);
        //GL11.glScalef(2f, 2f, 2f);
        drawDefaultBackground();
        drawModalRectWithCustomSizedTexture(0, -140/16, 0, 0, screenWidth, 70, 32, 32);
        drawModalRectWithCustomSizedTexture(0, screenHeight - ((screenHeight/8)+70/16), 0, 0, screenWidth, 70, 32, 32);
        }
        GL11.glPopMatrix();
        GL11.glPushMatrix();
        {
        GL11.glScalef(2, 2, 2);
        String title = TextHelper.localize(Strings.Gui_Menu_Main_Title);
        if(submenuIndex == SUBMENU_ITEMS){
        	title = TextHelper.localize(Strings.Gui_Menu_Items_Title);
        }else{
        	title = TextHelper.localize(Strings.Gui_Menu_Main_Title);
        }
        drawString(fontRendererObj, title, 5, 5, 0xFFFFFF);
        }
        GL11.glPopMatrix();
        GL11.glPushMatrix();
        {
        	drawString(fontRendererObj, mc.thePlayer.worldObj.provider.getDimensionName(), screenWidth - 60, 5, 0xFFFFFF);
            drawString(fontRendererObj, mc.thePlayer.worldObj.getBiomeGenForCoords(mc.thePlayer.getPosition()).biomeName, screenWidth - 60, 20, 0xFFFFFF);
            drawString(fontRendererObj, TextHelper.localize(Strings.Gui_Menu_Main_Time) +": " + getWorldHours(mc.theWorld) + ":" + getWorldMinutes(mc.theWorld), 5, screenHeight - ((screenHeight/8)-100/16), 0xFFFFFF);
        }
        GL11.glPopMatrix();
	}
	
}
