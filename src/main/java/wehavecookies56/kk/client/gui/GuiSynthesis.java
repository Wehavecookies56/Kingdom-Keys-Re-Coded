package wehavecookies56.kk.client.gui;

import java.util.Collections;

import org.lwjgl.opengl.GL11;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import wehavecookies56.kk.entities.ExtendedPlayer;
import wehavecookies56.kk.entities.ExtendedPlayerRecipes;
import wehavecookies56.kk.lib.Reference;
import wehavecookies56.kk.lib.Strings;
import wehavecookies56.kk.recipes.RecipeRegistry;
import wehavecookies56.kk.util.TextHelper;


public class GuiSynthesis extends GuiTooltip{

	public int selected = -1;
	public final int MAIN = 0, BACK = 0, RECIPES = 1, FREEDEV = 2, MATERIALS = 3;
	public int submenu;
	private final GuiScreen parentScreen;
	protected String title = "Item Synthesis";
	private GuiRecipeList recipeList;

	public GuiButton Back, FreeDev, Recipes, Materials;

	public GuiSynthesis(GuiScreen parentScreen)
	{
		this.parentScreen = parentScreen;
	}

	@SuppressWarnings("unchecked")
	@Override
	public void initGui()
	{
		this.recipeList = new GuiRecipeList(this);
		this.recipeList.registerScrollButtons(this.buttonList, 7, 8);
		this.buttonList.add(Back = new GuiButton(BACK, width - 105, height - ((height/8)+70/16), 100, 20, TextHelper.localize(Strings.Gui_Menu_Items_Button_Back)));
		this.buttonList.add(Recipes = new GuiButton(RECIPES, 5, 65, 100, 20, TextHelper.localize(Strings.Gui_Synthesis_Main_Recipes)));
		this.buttonList.add(FreeDev = new GuiButton(FREEDEV, 5, 65+25, 100, 20, TextHelper.localize(Strings.Gui_Synthesis_Main_FreeDev)));
		this.buttonList.add(Materials = new GuiButton(MATERIALS, 5, 90+25, 100, 20, TextHelper.localize(Strings.Gui_Synthesis_Main_Materials)));
		updateButtons();
	}

	@Override
	public void updateScreen() {

	}

	@Override
	protected void actionPerformed(GuiButton button)
	{
		switch(button.id){
		case BACK:
			submenu = MAIN;
			break;
		case RECIPES:
			submenu = RECIPES;
			break;
		case FREEDEV:
			submenu = FREEDEV;
			break;
		case MATERIALS:
			submenu = MATERIALS;
			break;
		}
		updateButtons();
	}
	private void updateButtons() {
		if(submenu == MAIN){
			Back.visible = false;
			Recipes.visible = true;
			FreeDev.visible = true;
			Materials.visible = true;
		}else{
			Back.visible = true;
			Recipes.visible = false;
			FreeDev.visible = false;
			Materials.visible = false;
		}
	}

	@Override
	public void drawScreen(int mouseX, int mouseY, float partialTicks)
	{
		this.drawDefaultBackground();
		if(submenu == RECIPES){
			this.recipeList.drawScreen(mouseX, mouseY, partialTicks);
		}
		drawBackground(width, height);
		super.drawScreen(mouseX, mouseY, partialTicks);
		if(submenu != MAIN){
			drawSelected(mouseX, mouseY);
		}else{
			selected = -1;
		}
	}

	public void drawSelected(int mouseX, int mouseY){
		ExtendedPlayerRecipes props = ExtendedPlayerRecipes.get(mc.thePlayer);
		if(selected != -1){
			//GL11.glColor3ub((byte)24, (byte)36, (byte)214);
			Minecraft.getMinecraft().renderEngine.bindTexture(optionsBackground);
			drawGradientRect(250, 60, 500, height - ((height/8)+70/16), -1072689136, -804253680);
			//drawModalRectWithCustomSizedTexture(0, 60, 0, 0, 300, 200, 32, 32);
		}
		GL11.glPushMatrix();{
			for(int i = 0; i < props.knownRecipes.size(); i++){
				if(selected == i){
					drawString(fontRendererObj, "Required Materials" + TextHelper.ITALIC, 270, 100, 0x00C3FF);
					GL11.glPushMatrix();{
						GL11.glTranslatef(270, 70, 0);
						GL11.glScalef(2, 2, 2);
						drawString(fontRendererObj, TextHelper.localize(props.knownRecipes.get(i).toString() + ".name"), 0, 0, 0xFFF700);
					}GL11.glPopMatrix();

					for(int j = 0; j < RecipeRegistry.get(props.knownRecipes.get(i).toString()).getRequirements().size(); j++){
						ResourceLocation synthMaterial = new ResourceLocation(Reference.MODID, "textures/gui/synthesis/" + RecipeRegistry.get(props.knownRecipes.get(i).toString()).getRequirements().get(j).toString().substring(3) + ".png");
						mc.renderEngine.bindTexture(synthMaterial);
						int distY = 24;
						int distX = 100;
						int column = 0;
						int row = j;
						drawTexturedModalRect(270 + (distX*column), 110 + (distY*row), 0, 0, 16, 16);
						drawString(fontRendererObj, TextHelper.localize(RecipeRegistry.get(props.knownRecipes.get(i).toString()).getRequirements().get(j).toString()) + " x" + Collections.frequency(RecipeRegistry.get(props.knownRecipes.get(i).toString()).getRequirements(), RecipeRegistry.get(props.knownRecipes.get(i).toString()).getRequirements().get(j).toString()), 288 + (distX*column), 114 + (distY*row), 0xFFFFFF);
						//Tooltip not really needed
						/*if(mouseX >= 200 && mouseX <= 216 && mouseY >= 100 + (dist*j) && mouseY <= 116 + (dist*j)){
							RenderHelper.disableStandardItemLighting();
							GL11.glDisable(GL11.GL_LIGHTING);
							drawCreativeTabHoveringText(RecipeRegistry.get(props.knownRecipes.get(i).toString()).getRequirements().get(j).toString(), mouseX, mouseY);
						}*/

					}
				}
			}
		}GL11.glPopMatrix();
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
			drawModalRectWithCustomSizedTexture(0, 0, 0, 0, screenWidth, 60, 32, 32);
			drawModalRectWithCustomSizedTexture(0, screenHeight - ((screenHeight/8)+70/16), 0, 0, screenWidth, 70, 32, 32);
		}
		GL11.glPopMatrix();
		GL11.glPushMatrix();{
			GL11.glScalef(2, 2, 2);
			drawString(fontRendererObj, title, 5, 5, 0xFFFFFF);
		}
		GL11.glPopMatrix();
		if(submenu == RECIPES){
			drawString(fontRendererObj, Strings.Gui_Synthesis_Main_Recipes, 15, 30, 0xFFFFFF);
		}
		if(submenu == FREEDEV){
			drawString(fontRendererObj, Strings.Gui_Synthesis_Main_FreeDev, 15, 30, 0xFFFFFF);
		}
		if(submenu == MATERIALS){
			drawString(fontRendererObj, Strings.Gui_Synthesis_Main_Materials, 15, 30, 0xFFFFFF);
		}
		GL11.glPushMatrix();{
			drawString(fontRendererObj, mc.thePlayer.worldObj.provider.getDimensionName(), screenWidth - fontRendererObj.getStringWidth(mc.thePlayer.worldObj.provider.getDimensionName()) - 5, 5, 0xFFFFFF);
			drawString(fontRendererObj, mc.thePlayer.worldObj.getBiomeGenForCoords(mc.thePlayer.getPosition()).biomeName, screenWidth - fontRendererObj.getStringWidth(mc.thePlayer.worldObj.getBiomeGenForCoords(mc.thePlayer.getPosition()).biomeName) - 5, 20, 0xFFFFFF);
			drawString(fontRendererObj, TextHelper.localize(Strings.Gui_Menu_Main_Time) +": " + getWorldHours(mc.theWorld) + ":" + getWorldMinutes(mc.theWorld), 5, screenHeight - ((screenHeight/8)-300/16), 0xFFFFFF);
			ExtendedPlayer props = ExtendedPlayer.get(mc.thePlayer);
			drawString(fontRendererObj, TextHelper.localize(Strings.Gui_Menu_Main_Munny) + ": " + props.getMunny(), 5, screenHeight - ((screenHeight/8)-100/16), 0xFFD000);
		}
		GL11.glPopMatrix();

	}

	public void selectedIndex(int index){

	}

	FontRenderer getFontRenderer() {
		return fontRendererObj;
	}

	@Override
	protected String GetButtonTooltip(int buttonId) {
		switch(buttonId){

		}
		return null;
	}


}
