package wehavecookies56.kk.client.gui;

import java.util.ArrayList;
import java.util.List;

import org.lwjgl.opengl.GL11;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import wehavecookies56.kk.api.recipes.Recipe;
import wehavecookies56.kk.api.recipes.RecipeRegistry;
import wehavecookies56.kk.entities.ExtendedPlayer;
import wehavecookies56.kk.entities.ExtendedPlayerMaterials;
import wehavecookies56.kk.entities.ExtendedPlayerRecipes;
import wehavecookies56.kk.lib.Lists;
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
		for(int i = 0; i < r.getRequirements().size(); i++){
			int index = -1;
			if(r.getRequirements().get(i).contains(Strings.SM_BlazingShard)){
				index = Lists.Index_BlazingShard;
			}
			if(r.getRequirements().get(i).contains(Strings.SM_BlazingStone)){
				index = Lists.Index_BlazingStone;
			}
			if(r.getRequirements().get(i).contains(Strings.SM_BlazingGem)){
				index = Lists.Index_BlazingGem;
			}
			if(r.getRequirements().get(i).contains(Strings.SM_BlazingCrystal)){
				index = Lists.Index_BlazingCrystal;
			}

			if(r.getRequirements().get(i).contains(Strings.SM_BrightShard)){
				index = Lists.Index_BrightShard;
			}
			if(r.getRequirements().get(i).contains(Strings.SM_BrightStone)){
				index = Lists.Index_BrightStone;
			}
			if(r.getRequirements().get(i).contains(Strings.SM_BrightGem)){
				index = Lists.Index_BrightGem;
			}
			if(r.getRequirements().get(i).contains(Strings.SM_BrightCrystal)){
				index = Lists.Index_BrightCrystal;
			}

			if(r.getRequirements().get(i).contains(Strings.SM_DarkShard)){
				index = Lists.Index_DarkShard;
			}
			if(r.getRequirements().get(i).contains(Strings.SM_DarkStone)){
				index = Lists.Index_DarkStone;
			}
			if(r.getRequirements().get(i).contains(Strings.SM_DarkGem)){
				index = Lists.Index_DarkGem;
			}
			if(r.getRequirements().get(i).contains(Strings.SM_DarkCrystal)){
				index = Lists.Index_DarkCrystal;
			}

			if(r.getRequirements().get(i).contains(Strings.SM_DenseShard)){
				index = Lists.Index_DenseShard;
			}
			if(r.getRequirements().get(i).contains(Strings.SM_DenseStone)){
				index = Lists.Index_DenseStone;
			}
			if(r.getRequirements().get(i).contains(Strings.SM_DenseGem)){
				index = Lists.Index_DenseGem;
			}
			if(r.getRequirements().get(i).contains(Strings.SM_DenseCrystal)){
				index = Lists.Index_DenseCrystal;
			}

			if(r.getRequirements().get(i).contains(Strings.SM_EnergyShard)){
				index = Lists.Index_EnergyShard;
			}
			if(r.getRequirements().get(i).contains(Strings.SM_EnergyStone)){
				index = Lists.Index_EnergyStone;
			}
			if(r.getRequirements().get(i).contains(Strings.SM_EnergyGem)){
				index = Lists.Index_EnergyGem;
			}
			if(r.getRequirements().get(i).contains(Strings.SM_EnergyCrystal)){
				index = Lists.Index_EnergyCrystal;
			}

			if(r.getRequirements().get(i).contains(Strings.SM_FrostShard)){
				index = Lists.Index_FrostShard;
			}
			if(r.getRequirements().get(i).contains(Strings.SM_FrostStone)){
				index = Lists.Index_FrostStone;
			}
			if(r.getRequirements().get(i).contains(Strings.SM_FrostGem)){
				index = Lists.Index_FrostGem;
			}
			if(r.getRequirements().get(i).contains(Strings.SM_FrostCrystal)){
				index = Lists.Index_FrostCrystal;
			}

			if(r.getRequirements().get(i).contains(Strings.SM_LightningShard)){
				index = Lists.Index_LightningShard;
			}
			if(r.getRequirements().get(i).contains(Strings.SM_LightningStone)){
				index = Lists.Index_LightningStone;
			}
			if(r.getRequirements().get(i).contains(Strings.SM_LightningGem)){
				index = Lists.Index_LightningGem;
			}
			if(r.getRequirements().get(i).contains(Strings.SM_LightningCrystal)){
				index = Lists.Index_LightningCrystal;
			}

			if(r.getRequirements().get(i).contains(Strings.SM_LostIllusion)){
				index = Lists.Index_LostIllusion;
			}

			if(r.getRequirements().get(i).contains(Strings.SM_LucidShard)){
				index = Lists.Index_LucidShard;
			}
			if(r.getRequirements().get(i).contains(Strings.SM_LucidStone)){
				index = Lists.Index_LucidStone;
			}
			if(r.getRequirements().get(i).contains(Strings.SM_LucidGem)){
				index = Lists.Index_LucidGem;
			}
			if(r.getRequirements().get(i).contains(Strings.SM_LucidCrystal)){
				index = Lists.Index_LucidCrystal;
			}

			if(r.getRequirements().get(i).contains(Strings.SM_ManifestIllusion)){
				index = Lists.Index_ManifestIllusion;
			}

			if(r.getRequirements().get(i).contains(Strings.SM_MythrilShard)){
				index = Lists.Index_MythrilShard;
			}
			if(r.getRequirements().get(i).contains(Strings.SM_MythrilStone)){
				index = Lists.Index_MythrilStone;
			}
			if(r.getRequirements().get(i).contains(Strings.SM_MythrilGem)){
				index = Lists.Index_MythrilGem;
			}
			if(r.getRequirements().get(i).contains(Strings.SM_MythrilCrystal)){
				index = Lists.Index_MythrilCrystal;
			}

			if(r.getRequirements().get(i).contains(Strings.SM_Orichalcum)){
				index = Lists.Index_Orichalcum;
			}
			if(r.getRequirements().get(i).contains(Strings.SM_OrichalcumPlus)){
				index = Lists.Index_OrichalcumPlus;
			}

			if(r.getRequirements().get(i).contains(Strings.SM_PowerShard)){
				index = Lists.Index_PowerShard;
			}
			if(r.getRequirements().get(i).contains(Strings.SM_PowerStone)){
				index = Lists.Index_PowerStone;
			}
			if(r.getRequirements().get(i).contains(Strings.SM_PowerGem)){
				index = Lists.Index_PowerGem;
			}
			if(r.getRequirements().get(i).contains(Strings.SM_PowerCrystal)){
				index = Lists.Index_PowerCrystal;
			}

			if(r.getRequirements().get(i).contains(Strings.SM_RemembranceShard)){
				index = Lists.Index_RemembranceShard;
			}
			if(r.getRequirements().get(i).contains(Strings.SM_RemembranceStone)){
				index = Lists.Index_RemembranceStone;
			}
			if(r.getRequirements().get(i).contains(Strings.SM_RemembranceGem)){
				index = Lists.Index_RemembranceGem;
			}
			if(r.getRequirements().get(i).contains(Strings.SM_RemembranceCrystal)){
				index = Lists.Index_RemembranceCrystal;
			}

			if(r.getRequirements().get(i).contains(Strings.SM_SerenityShard)){
				index = Lists.Index_SerenityShard;
			}
			if(r.getRequirements().get(i).contains(Strings.SM_SerenityStone)){
				index = Lists.Index_SerenityStone;
			}
			if(r.getRequirements().get(i).contains(Strings.SM_SerenityGem)){
				index = Lists.Index_SerenityGem;
			}
			if(r.getRequirements().get(i).contains(Strings.SM_SerenityCrystal)){
				index = Lists.Index_SerenityCrystal;
			}

			if(r.getRequirements().get(i).contains(Strings.SM_TranquilShard)){
				index = Lists.Index_TranquilShard;
			}
			if(r.getRequirements().get(i).contains(Strings.SM_TranquilStone)){
				index = Lists.Index_TranquilStone;
			}
			if(r.getRequirements().get(i).contains(Strings.SM_TranquilGem)){
				index = Lists.Index_TranquilGem;
			}
			if(r.getRequirements().get(i).contains(Strings.SM_TranquilCrystal)){
				index = Lists.Index_TranquilCrystal;
			}

			if(r.getRequirements().get(i).contains(Strings.SM_TwilightShard)){
				index = Lists.Index_TwilightShard;
			}
			if(r.getRequirements().get(i).contains(Strings.SM_TwilightStone)){
				index = Lists.Index_TwilightStone;
			}
			if(r.getRequirements().get(i).contains(Strings.SM_TwilightGem)){
				index = Lists.Index_TwilightGem;
			}
			if(r.getRequirements().get(i).contains(Strings.SM_TwilightCrystal)){
				index = Lists.Index_TwilightCrystal;
			}

			if(r.getRequirements().get(i).contains(Strings.SM_StormyShard)){
				index = Lists.Index_StormyShard;
			}
			if(r.getRequirements().get(i).contains(Strings.SM_StormyStone)){
				index = Lists.Index_StormyStone;
			}
			if(r.getRequirements().get(i).contains(Strings.SM_StormyGem)){
				index = Lists.Index_StormyGem;
			}
			if(r.getRequirements().get(i).contains(Strings.SM_StormyCrystal)){
				index = Lists.Index_StormyCrystal;
			}

			if(Integer.parseInt(r.getRequirements().get(i).substring(r.getRequirements().get(i).lastIndexOf(".") + 1)) <= mats.arrayOfAmounts[index]){
				hasMaterials.add(true);
			}
		}
		if(r.getRequirements().size() > 0){
			if(hasMaterials.size() == r.getRequirements().size()){
				return true;
			}
		}
		System.out.println("NO");
		return false;
	}

	private void updateButtons() {
		if(submenu == MAIN){
			Back.visible = false;
			Recipes.visible = true;
			FreeDev.visible = true;
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

					for(int j = 0; j < RecipeRegistry.get(props.knownRecipes.get(i).toString()).getRequirements().size(); j++){
						ResourceLocation synthMaterial = new ResourceLocation(Reference.MODID, "textures/gui/synthesis/" + RecipeRegistry.get(props.knownRecipes.get(i).toString()).getRequirements().get(j).toString().substring(3).replace(".x.", "").replaceAll("[0-9]","") + ".png");
						mc.renderEngine.bindTexture(synthMaterial);
						int distY = 24;
						int distX = 100;
						int column = 0;
						int row = j;
						String amount;
						GL11.glPushMatrix();{
							GL11.glTranslatef(270 + (distX*column), 110 + (distY*row), 0);
							GL11.glScalef(0.0625f, 0.0625f, 0.0625f);
							drawTexturedModalRect(0, 0, 0, 0, 256, 256);
						}GL11.glPopMatrix();
						if(RecipeRegistry.get(props.knownRecipes.get(i).toString()).getRequirements().get(j).toString().contains(".x.")){
							String[] name = RecipeRegistry.get(props.knownRecipes.get(i).toString()).getRequirements().get(j).toString().split(".x.");
							drawString(fontRendererObj, TextHelper.localize(name[0] + ".name") + " x" + name[1], 288 + (distX*column), 114 + (distY*row), 0xFFFFFF);
						}else{
							drawString(fontRendererObj, TextHelper.localize(RecipeRegistry.get(props.knownRecipes.get(i).toString()).getRequirements().get(j).toString() + ".name") + " x" + 1, 288 + (distX*column), 114 + (distY*row), 0xFFFFFF);
						}

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
