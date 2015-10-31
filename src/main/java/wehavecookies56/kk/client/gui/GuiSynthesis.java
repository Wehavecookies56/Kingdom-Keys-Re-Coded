package wehavecookies56.kk.client.gui;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.lwjgl.opengl.GL11;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import wehavecookies56.kk.api.materials.Material;
import wehavecookies56.kk.api.recipes.Recipe;
import wehavecookies56.kk.api.recipes.RecipeRegistry;
import wehavecookies56.kk.entities.ExtendedPlayer;
import wehavecookies56.kk.entities.ExtendedPlayerMaterials;
import wehavecookies56.kk.entities.ExtendedPlayerRecipes;
import wehavecookies56.kk.lib.Reference;
import wehavecookies56.kk.lib.Strings;
import wehavecookies56.kk.network.packet.PacketDispatcher;
import wehavecookies56.kk.network.packet.server.CreateFromSynthesisRecipe;
import wehavecookies56.kk.network.packet.server.OpenMaterials;
import wehavecookies56.kk.util.TextHelper;


public class GuiSynthesis extends GuiTooltip{

	public int selected = -1;
	public final int MAIN = 0, BACK = 0, RECIPES = 1, FREEDEV = 2, MATERIALS = 3, CREATE = 4;
	public int submenu;
	private final GuiScreen parentScreen;
	protected String title = TextHelper.localize(Strings.Gui_Synthesis_Main_Title);
	private GuiRecipeList recipeList;
	private GuiMaterialList materialList;

	public GuiButton Back, FreeDev, Recipes, Materials, Create;
	public int materialSelected;

	public GuiSynthesis(GuiScreen parentScreen){
		this.parentScreen = parentScreen;
	}

	@SuppressWarnings("unchecked")
	@Override
	public void initGui(){
		this.recipeList = new GuiRecipeList(this);
		this.recipeList.registerScrollButtons(this.buttonList, 7, 8);
		this.materialList = new GuiMaterialList(this);
		this.materialList.registerScrollButtons(this.buttonList, 7, 8);
		this.buttonList.add(Back = new GuiButton(BACK, width - 105, height - ((height/8)+70/16), 100, 20, TextHelper.localize(Strings.Gui_Menu_Items_Button_Back)));
		this.buttonList.add(Create = new GuiButton(CREATE, 270, height - ((height/8)+70/16) - 25, 100, 20, TextHelper.localize(Strings.Gui_Synthesis_Main_Recipes_Create)));
		this.buttonList.add(Recipes = new GuiButton(RECIPES, 5, 65, 100, 20, TextHelper.localize(Strings.Gui_Synthesis_Main_Recipes)));
		this.buttonList.add(FreeDev = new GuiButton(FREEDEV, 5, 65+25, 100, 20, TextHelper.localize(Strings.Gui_Synthesis_Main_FreeDev)));
		this.buttonList.add(Materials = new GuiButton(MATERIALS, 5, 90+25, 100, 20, TextHelper.localize(Strings.Gui_Synthesis_Main_Materials)));
		updateButtons();
	}

	@Override
	public void updateScreen() {
		updateButtons();
	}

	@Override
	protected void actionPerformed(GuiButton button){
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
			PacketDispatcher.sendToServer(new OpenMaterials());
			submenu = MATERIALS;
			break;
		case CREATE:
			if(isRecipeUsable(ExtendedPlayerRecipes.get(mc.thePlayer).knownRecipes.get(selected), 1)){
				PacketDispatcher.sendToServer(new CreateFromSynthesisRecipe(ExtendedPlayerRecipes.get(mc.thePlayer).knownRecipes.get(selected), 1));
			}
		}
		updateButtons();
	}

	public static boolean isRecipeUsable(String name, int amountToRemove){
		EntityPlayer player = Minecraft.getMinecraft().thePlayer;
		ExtendedPlayerMaterials mats = ExtendedPlayerMaterials.get(player);
		Recipe r = RecipeRegistry.get(name);
		List<Boolean> hasMaterials = new ArrayList<Boolean>();
		boolean full = false;
		for (int i = 0; i < player.inventory.mainInventory.length; i++){
			if(player.inventory.mainInventory[i] != null){
				full = true;
			}
			if(player.inventory.mainInventory[i] == null){
				full = false;
			}
		}
		if(full){
			return false;
		}
		Iterator it = r.getRequirements().entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry<Material, Integer> pair = (Map.Entry<Material, Integer>)it.next();
			if(mats.knownMaterialsMap.containsKey(pair.getKey().getName())){
				if(pair.getValue() != null && mats.knownMaterialsMap.get(pair.getKey().getName()) != null){
					if(pair.getValue() <= mats.knownMaterialsMap.get(pair.getKey().getName())){
						hasMaterials.add(true);
					}
				}
			}
			
		}
		if(r.getRequirements().size() > 0){
			if(hasMaterials.size() == r.getRequirements().size()){
				return true;
			}
		}
		return false;
	}

	private void updateButtons() {
		if(submenu == MAIN){
			Back.visible = false;
			Recipes.visible = true;
			FreeDev.visible = true;
			FreeDev.enabled = false;
			Materials.visible = true;
			Create.visible = false;
		}else{
			Back.visible = true;
			Recipes.visible = false;
			FreeDev.visible = false;
			Materials.visible = false;
		}
		if(selected != -1 && submenu == RECIPES){
			Create.visible = true;
		}
		if(selected == -1){
			Create.visible = false;
		}
		if(selected != -1 && isRecipeUsable(ExtendedPlayerRecipes.get(mc.thePlayer).knownRecipes.get(selected), 1)){
			Create.enabled = true;
		}else{
			Create.enabled = false;
		}
	}

	@Override
	public void drawScreen(int mouseX, int mouseY, float partialTicks){
		this.drawDefaultBackground();
		if(submenu == RECIPES){
			this.recipeList.drawScreen(mouseX, mouseY, partialTicks);
		}else if(submenu == MATERIALS){
			this.materialList.drawScreen(mouseX, mouseY, partialTicks);
		}
		drawBackground(width, height);
		if(submenu != MAIN){
			drawSelected(mouseX, mouseY);
		}else{
			selected = -1;
		}
		super.drawScreen(mouseX, mouseY, partialTicks);
	}

	public void drawSelected(int mouseX, int mouseY){
		ExtendedPlayerRecipes props = ExtendedPlayerRecipes.get(mc.thePlayer);
		if(selected != -1){
			Minecraft.getMinecraft().renderEngine.bindTexture(optionsBackground);
			drawGradientRect(250, 60, 500, height - ((height/8)+70/16), -1072689136, -804253680);
		}
		GL11.glPushMatrix();{
			for(int i = 0; i < props.knownRecipes.size(); i++){
				if(selected == i){
					drawString(fontRendererObj, TextHelper.localize(Strings.Gui_Synthesis_Main_Recipes_ReqMaterials) + TextHelper.ITALIC, 270, 100, 0x00C3FF);
					GL11.glPushMatrix();{
						GL11.glTranslatef(270, 70, 0);
						GL11.glScalef(2, 2, 2);
						drawString(fontRendererObj, TextHelper.localize(props.knownRecipes.get(i).toString() + ".name"), 0, 0, 0xFFF700);
					}GL11.glPopMatrix();

					int row = 0;
					Iterator it = RecipeRegistry.get(props.knownRecipes.get(i)).getRequirements().entrySet().iterator();
					while (it.hasNext()) {
						Map.Entry<Material, Integer> pair = (Map.Entry<Material, Integer>)it.next();
						int distY = 24;
						int distX = 100;
						int column = 0;
						GL11.glPushMatrix();{
							GL11.glColor4f(1, 1, 1, 1);
							ResourceLocation synthMaterial = pair.getKey().getTexture();
							if(synthMaterial == null){
								GL11.glTranslatef(270 + (distX*column), 110 + (distY*row), 0);
								Minecraft.getMinecraft().getRenderItem().renderItemAndEffectIntoGUI(pair.getKey().getItem(), 0, 0);
							}else{
								mc.renderEngine.bindTexture(synthMaterial);
								GL11.glTranslatef(270 + (distX*column), 110 + (distY*row), 0);
								GL11.glScalef(0.0625f, 0.0625f, 0.0625f);
								drawTexturedModalRect(0, 0, 0, 0, 256, 256);
							}
						}GL11.glPopMatrix();
						String name = pair.getKey().getName();
						drawString(fontRendererObj, TextHelper.localize(name + ".name") + " x" + pair.getValue(), 288 + (distX*column), 114 + (distY*row), 0xFFFFFF);
						row++;
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
			drawString(fontRendererObj, TextHelper.localize(Strings.Gui_Synthesis_Main_Recipes), 15, 30, 0xFFFFFF);
		}
		if(submenu == FREEDEV){
			drawString(fontRendererObj, TextHelper.localize(Strings.Gui_Synthesis_Main_FreeDev), 15, 30, 0xFFFFFF);
		}
		if(submenu == MATERIALS){
			drawString(fontRendererObj, TextHelper.localize(Strings.Gui_Synthesis_Main_Materials), 15, 30, 0xFFFFFF);
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
	public boolean doesGuiPauseGame() {
		return false;
	}

	@Override
	protected String GetButtonTooltip(int buttonId) {
		switch(buttonId){

		}
		return null;
	}


}
