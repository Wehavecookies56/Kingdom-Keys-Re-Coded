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
import wehavecookies56.kk.entities.ExtendedPlayer;
import wehavecookies56.kk.entities.ExtendedPlayerMaterials;
import wehavecookies56.kk.entities.ExtendedPlayerRecipes;
import wehavecookies56.kk.lib.Reference;
import wehavecookies56.kk.lib.Strings;
import wehavecookies56.kk.network.packet.PacketDispatcher;
import wehavecookies56.kk.network.packet.server.CreateFromSynthesisRecipe;
import wehavecookies56.kk.network.packet.server.OpenMaterials;
import wehavecookies56.kk.recipes.Recipe;
import wehavecookies56.kk.recipes.RecipeRegistry;
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
			int index;
			if(r.getRequirements().get(i) == Strings.SM_BlazingShard){
				index = GuiMaterialList.Index_BlazingShard;
			}
			if(r.getRequirements().get(i) == Strings.SM_BlazingStone){
				index = GuiMaterialList.Index_BlazingStone;
			}
			if(r.getRequirements().get(i) == Strings.SM_BlazingGem){
				index = GuiMaterialList.Index_BlazingGem;
			}
			if(r.getRequirements().get(i) == Strings.SM_BlazingCrystal){
				index = GuiMaterialList.Index_BlazingCrystal;
			}

			if(r.getRequirements().get(i) == Strings.SM_BrightShard){
				index = GuiMaterialList.Index_BrightShard;
			}
			if(r.getRequirements().get(i) == Strings.SM_BrightStone){
				index = GuiMaterialList.Index_BrightStone;
			}
			if(r.getRequirements().get(i) == Strings.SM_BrightGem){
				index = GuiMaterialList.Index_BrightGem;
			}
			if(r.getRequirements().get(i) == Strings.SM_BrightCrystal){
				index = GuiMaterialList.Index_BrightCrystal;
			}

			if(r.getRequirements().get(i) == Strings.SM_DarkShard){
				index = GuiMaterialList.Index_DarkShard;
			}
			if(r.getRequirements().get(i) == Strings.SM_DarkStone){
				index = GuiMaterialList.Index_DarkStone;
			}
			if(r.getRequirements().get(i) == Strings.SM_DarkGem){
				index = GuiMaterialList.Index_DarkGem;
			}
			if(r.getRequirements().get(i) == Strings.SM_DarkCrystal){
				index = GuiMaterialList.Index_DarkCrystal;
			}

			if(r.getRequirements().get(i) == Strings.SM_DenseShard){
				index = GuiMaterialList.Index_DenseShard;
			}
			if(r.getRequirements().get(i) == Strings.SM_DenseStone){
				index = GuiMaterialList.Index_DenseStone;
			}
			if(r.getRequirements().get(i) == Strings.SM_DenseGem){
				index = GuiMaterialList.Index_DenseGem;
			}
			if(r.getRequirements().get(i) == Strings.SM_DenseCrystal){
				index = GuiMaterialList.Index_DenseCrystal;
			}

			if(r.getRequirements().get(i) == Strings.SM_EnergyShard){
				index = GuiMaterialList.Index_EnergyShard;
			}
			if(r.getRequirements().get(i) == Strings.SM_EnergyStone){
				index = GuiMaterialList.Index_EnergyStone;
			}
			if(r.getRequirements().get(i) == Strings.SM_EnergyGem){
				index = GuiMaterialList.Index_EnergyGem;
			}
			if(r.getRequirements().get(i) == Strings.SM_EnergyCrystal){
				index = GuiMaterialList.Index_EnergyCrystal;
			}

			if(r.getRequirements().get(i) == Strings.SM_FrostShard){
				index = GuiMaterialList.Index_FrostShard;
			}
			if(r.getRequirements().get(i) == Strings.SM_FrostStone){
				index = GuiMaterialList.Index_FrostStone;
			}
			if(r.getRequirements().get(i) == Strings.SM_FrostGem){
				index = GuiMaterialList.Index_FrostGem;
			}
			if(r.getRequirements().get(i) == Strings.SM_FrostCrystal){
				index = GuiMaterialList.Index_FrostCrystal;
			}

			if(r.getRequirements().get(i) == Strings.SM_LightningShard){
				index = GuiMaterialList.Index_LightningShard;
			}
			if(r.getRequirements().get(i) == Strings.SM_LightningStone){
				index = GuiMaterialList.Index_LightningStone;
			}
			if(r.getRequirements().get(i) == Strings.SM_LightningGem){
				index = GuiMaterialList.Index_LightningGem;
			}
			if(r.getRequirements().get(i) == Strings.SM_LightningCrystal){
				index = GuiMaterialList.Index_LightningCrystal;
			}

			if(r.getRequirements().get(i) == Strings.SM_LostIllusion){
				index = GuiMaterialList.Index_LostIllusion;
			}

			if(r.getRequirements().get(i) == Strings.SM_LucidShard){
				index = GuiMaterialList.Index_LucidShard;
			}
			if(r.getRequirements().get(i) == Strings.SM_LucidStone){
				index = GuiMaterialList.Index_LucidStone;
			}
			if(r.getRequirements().get(i) == Strings.SM_LucidGem){
				index = GuiMaterialList.Index_LucidGem;
			}
			if(r.getRequirements().get(i) == Strings.SM_LucidCrystal){
				index = GuiMaterialList.Index_LucidCrystal;
			}

			if(r.getRequirements().get(i) == Strings.SM_ManifestIllusion){
				index = GuiMaterialList.Index_ManifestIllusion;
			}

			if(r.getRequirements().get(i) == Strings.SM_MythrilShard){
				index = GuiMaterialList.Index_MythrilShard;
			}
			if(r.getRequirements().get(i) == Strings.SM_MythrilStone){
				index = GuiMaterialList.Index_MythrilStone;
			}
			if(r.getRequirements().get(i) == Strings.SM_MythrilGem){
				index = GuiMaterialList.Index_MythrilGem;
			}
			if(r.getRequirements().get(i) == Strings.SM_MythrilCrystal){
				index = GuiMaterialList.Index_MythrilCrystal;
			}

			if(r.getRequirements().get(i) == Strings.SM_Orichalcum){
				index = GuiMaterialList.Index_Orichalcum;
			}
			if(r.getRequirements().get(i) == Strings.SM_OrichalcumPlus){
				index = GuiMaterialList.Index_OrichalcumPlus;
			}

			if(r.getRequirements().get(i) == Strings.SM_PowerShard){
				index = GuiMaterialList.Index_PowerShard;
			}
			if(r.getRequirements().get(i) == Strings.SM_PowerStone){
				index = GuiMaterialList.Index_PowerStone;
			}
			if(r.getRequirements().get(i) == Strings.SM_PowerGem){
				index = GuiMaterialList.Index_PowerGem;
			}
			if(r.getRequirements().get(i) == Strings.SM_PowerCrystal){
				index = GuiMaterialList.Index_PowerCrystal;
			}

			if(r.getRequirements().get(i) == Strings.SM_RemembranceShard){
				index = GuiMaterialList.Index_RemembranceShard;
			}
			if(r.getRequirements().get(i) == Strings.SM_RemembranceStone){
				index = GuiMaterialList.Index_RemembranceStone;
			}
			if(r.getRequirements().get(i) == Strings.SM_RemembranceGem){
				index = GuiMaterialList.Index_RemembranceGem;
			}
			if(r.getRequirements().get(i) == Strings.SM_RemembranceCrystal){
				index = GuiMaterialList.Index_RemembranceCrystal;
			}

			if(r.getRequirements().get(i) == Strings.SM_SerenityShard){
				index = GuiMaterialList.Index_SerenityShard;
			}
			if(r.getRequirements().get(i) == Strings.SM_SerenityStone){
				index = GuiMaterialList.Index_SerenityStone;
			}
			if(r.getRequirements().get(i) == Strings.SM_SerenityGem){
				index = GuiMaterialList.Index_SerenityGem;
			}
			if(r.getRequirements().get(i) == Strings.SM_SerenityCrystal){
				index = GuiMaterialList.Index_SerenityCrystal;
			}

			if(r.getRequirements().get(i) == Strings.SM_TranquilShard){
				index = GuiMaterialList.Index_TranquilShard;
			}
			if(r.getRequirements().get(i) == Strings.SM_TranquilStone){
				index = GuiMaterialList.Index_TranquilStone;
			}
			if(r.getRequirements().get(i) == Strings.SM_TranquilGem){
				index = GuiMaterialList.Index_TranquilGem;
			}
			if(r.getRequirements().get(i) == Strings.SM_TranquilCrystal){
				index = GuiMaterialList.Index_TranquilCrystal;
			}

			if(r.getRequirements().get(i) == Strings.SM_TwilightShard){
				index = GuiMaterialList.Index_TwilightShard;
			}
			if(r.getRequirements().get(i) == Strings.SM_TwilightStone){
				index = GuiMaterialList.Index_TwilightStone;
			}
			if(r.getRequirements().get(i) == Strings.SM_TwilightGem){
				index = GuiMaterialList.Index_TwilightGem;
			}
			if(r.getRequirements().get(i) == Strings.SM_TwilightCrystal){
				index = GuiMaterialList.Index_TwilightCrystal;
			}

			if(Integer.parseInt(r.getRequirements().get(i).substring(r.getRequirements().get(i).lastIndexOf(".") + 1)) <= mats.arrayOfAmounts[i]){
				hasMaterials.add(true);
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
