package wehavecookies56.kk.client.gui;

import org.lwjgl.opengl.GL11;

import wehavecookies56.kk.entities.ExtendedPlayer;
import wehavecookies56.kk.lib.Reference;
import wehavecookies56.kk.lib.Strings;
import wehavecookies56.kk.util.TextHelper;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.inventory.GuiInventory;
import net.minecraft.client.resources.I18n;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;


public class GuiSynthesis extends GuiScreen {
	
	public int selected = -1;
	private final GuiScreen parentScreen;
    protected String title = "Item Synthesiss";
    private GuiRecipeList recipeList;

    public GuiSynthesis(GuiScreen parentScreen)
    {
        this.parentScreen = parentScreen;
    }

    /**
     * Adds the buttons (and other controls) to the screen in question.
     */
    @SuppressWarnings("unchecked")
    @Override
    public void initGui()
    {
        this.recipeList=new GuiRecipeList(this);
        this.recipeList.registerScrollButtons(this.buttonList, 7, 8);
        //this.buttonList.add(new GuiButton(200, this.width / 2 - 100, this.height / 6 + 168, I18n.format("gui.done", new Object[0])));
    }
    
    @Override
    protected void actionPerformed(GuiButton button)
    {
        if (button.enabled)
        {
            if (button.id == 200)
            {
                this.mc.gameSettings.saveOptions();
                this.mc.displayGuiScreen(this.parentScreen);
            }
        }
    }

    /**
     * Draws the screen and all the components in it. Args : mouseX, mouseY, renderPartialTicks
     */
    @Override
    public void drawScreen(int mouseX, int mouseY, float partialTicks)
    {
        // force a non-transparent background
        this.drawDefaultBackground();
        this.recipeList.drawScreen(mouseX, mouseY, partialTicks);
		drawBackground(width, height);
		
        //this.drawCenteredString(this.fontRendererObj, this.title, this.width / 2, 15, 0xFFFFFF);
        super.drawScreen(mouseX, mouseY, partialTicks);
    }

    public static final ResourceLocation optionsBackground = new ResourceLocation(Reference.MODID, "textures/gui/menubg.png");

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
			GL11.glColor4f(0.3F, 0.3F, 0.3F, 1.0F);
			//GL11.glScalef(2f, 2f, 2f);
			//drawDefaultBackground();
			drawModalRectWithCustomSizedTexture(0, -140/16, 0, 0, screenWidth, 70, 32, 32);
			drawModalRectWithCustomSizedTexture(0, screenHeight - ((screenHeight/8)+70/16), 0, 0, screenWidth, 70, 32, 32);
		}
		GL11.glPopMatrix();
		GL11.glPushMatrix();
		{
			GL11.glScalef(2, 2, 2);
			drawString(fontRendererObj, title, 5, 5, 0xFFFFFF);
		}
		GL11.glPopMatrix();
		GL11.glPushMatrix();
		{
			drawString(fontRendererObj, mc.thePlayer.worldObj.provider.getDimensionName(), screenWidth - fontRendererObj.getStringWidth(mc.thePlayer.worldObj.provider.getDimensionName()) - 5, 5, 0xFFFFFF);
			drawString(fontRendererObj, mc.thePlayer.worldObj.getBiomeGenForCoords(mc.thePlayer.getPosition()).biomeName, screenWidth - fontRendererObj.getStringWidth(mc.thePlayer.worldObj.getBiomeGenForCoords(mc.thePlayer.getPosition()).biomeName) - 5, 20, 0xFFFFFF);
			drawString(fontRendererObj, TextHelper.localize(Strings.Gui_Menu_Main_Time) +": " + getWorldHours(mc.theWorld) + ":" + getWorldMinutes(mc.theWorld), 5, screenHeight - ((screenHeight/8)-300/16), 0xFFFFFF);
			ExtendedPlayer props = ExtendedPlayer.get(mc.thePlayer);
			drawString(fontRendererObj, TextHelper.localize(Strings.Gui_Menu_Main_Munny) + ": " + props.getMunny(), 5, screenHeight - ((screenHeight/8)-100/16), 0xFFD000);
		}
		GL11.glPopMatrix();
		GL11.glPushMatrix();{
			GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
			//GuiInventory.drawEntityOnScreen(this.width/2, (int)(this.height/2f + 75), 70, 0, 0, mc.thePlayer);
			//GL11.glColor4f(1.0F, 1.0F, 1.0F, 0.75F);
		}GL11.glPopMatrix();
		
	}
	
	public void selectedIndex(int index){
		
	}
    
    FontRenderer getFontRenderer() {
        return fontRendererObj;
    }

	
}
