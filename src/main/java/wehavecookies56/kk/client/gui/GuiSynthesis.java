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
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import wehavecookies56.kk.api.materials.Material;
import wehavecookies56.kk.api.materials.MaterialRegistry;
import wehavecookies56.kk.api.recipes.Recipe;
import wehavecookies56.kk.api.recipes.RecipeRegistry;
import wehavecookies56.kk.entities.ExtendedPlayer;
import wehavecookies56.kk.entities.ExtendedPlayerMaterials;
import wehavecookies56.kk.entities.ExtendedPlayerRecipes;
import wehavecookies56.kk.item.ModItems;
import wehavecookies56.kk.lib.Reference;
import wehavecookies56.kk.lib.Strings;
import wehavecookies56.kk.network.packet.PacketDispatcher;
import wehavecookies56.kk.network.packet.server.CreateFromSynthesisRecipe;
import wehavecookies56.kk.network.packet.server.OpenMaterials;
import wehavecookies56.kk.network.packet.server.TakeMaterials;
import wehavecookies56.kk.util.TextHelper;


public class GuiSynthesis extends GuiTooltip{

	public int selected = -1;
	public final int MAIN = 0, BACK = 0, RECIPES = 1, FREEDEV = 2, MATERIALS = 3, CREATE = 4, TAKE1 = 5, TAKESTACK = 6, TAKEHALFSTACK = 7, TAKEALL = 8, DEPOSIT = 9;
	public int submenu;
	private final GuiScreen parentScreen;
	protected String title = TextHelper.localize(Strings.Gui_Synthesis_Main_Title);
	private GuiRecipeList recipeList;
	private GuiMaterialList materialList;

	public GuiButton Back, FreeDev, Recipes, Materials, Create, Take1, TakeStack, TakeHalfStack, TakeAll, Deposit;
	public int materialSelected = -1;

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
		
		this.buttonList.add(Deposit = new GuiButton(DEPOSIT, 200, height - ((height/8)+70/16), 100, 20, TextHelper.localize("Deposit Materials")));

		this.buttonList.add(Take1 = new GuiButton(TAKE1, 195, height - ((height/8)+70/16) - 25, 75, 20, TextHelper.localize("Take 1")));
		this.buttonList.add(TakeHalfStack = new GuiButton(TAKEHALFSTACK, 270, height - ((height/8)+70/16) - 25, 75, 20, TextHelper.localize("Take 32")));
		this.buttonList.add(TakeStack = new GuiButton(TAKESTACK, 345, height - ((height/8)+70/16) - 25, 75, 20, TextHelper.localize("Take 64")));
		this.buttonList.add(TakeAll = new GuiButton(TAKEALL, 420, height - ((height/8)+70/16) - 25, 75, 20, TextHelper.localize("Take All")));

		updateButtons();
	}

	@Override
	public void updateScreen() {
		updateButtons();
	}

	protected int getFreeSlots()
	{
		int emptySlots = 0;
		for (int i = 0; i < mc.thePlayer.inventory.mainInventory.length; i++) //Checks the available slots in the inventory
		{
			if(mc.thePlayer.inventory.mainInventory[i] == null)
			{			
				emptySlots++;
			}
		}
		return emptySlots;
	}
	
	protected boolean getInventoryMaterial(String material)
	{
		
		for (int i = 0; i < mc.thePlayer.inventory.mainInventory.length; i++) //Checks the available slots in the inventory
		{
			if(mc.thePlayer.inventory.mainInventory[i] != null){
				if(mc.thePlayer.inventory.mainInventory[i].getUnlocalizedName() == material)
				{			
					return true;
				}
			}
		}
		return false;
	}
	@Override
	protected void actionPerformed(GuiButton button){
		ExtendedPlayerMaterials mats = ExtendedPlayerMaterials.get(mc.thePlayer);
		List<String> materials = new ArrayList<String>();
		int freeSlots = 0;
		boolean foundMaterial = false;
		System.out.println("button.id: "+button.id);
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
			Deposit.visible = true;
			submenu = MATERIALS;
			break;
		case CREATE:
			if(isRecipeUsable(ExtendedPlayerRecipes.get(mc.thePlayer).knownRecipes.get(selected), 1)){
				PacketDispatcher.sendToServer(new CreateFromSynthesisRecipe(ExtendedPlayerRecipes.get(mc.thePlayer).knownRecipes.get(selected), 1));
			}
			break;
		case TAKE1:	
			materials.addAll(mats.getKnownMaterialsMap().keySet());

			freeSlots = getFreeSlots();
			foundMaterial = getInventoryMaterial(materials.get(materialSelected));
			if(foundMaterial || freeSlots >= 1)// || materials.get(materialSelected))
			{
				if(mats.getKnownMaterialsMap().get(materials.get(materialSelected)) >= 1){
					PacketDispatcher.sendToServer(new TakeMaterials(1, materials.get(materialSelected)));
				}
			}
			break;
		case TAKEHALFSTACK:
			materials.addAll(mats.getKnownMaterialsMap().keySet());

			freeSlots = getFreeSlots();
			foundMaterial = getInventoryMaterial(materials.get(materialSelected));
			if(foundMaterial || freeSlots >= 1)
			{
				if(mats.getKnownMaterialsMap().get(materials.get(materialSelected)) >= 32){
					PacketDispatcher.sendToServer(new TakeMaterials(32, materials.get(materialSelected)));
				}else{
					PacketDispatcher.sendToServer(new TakeMaterials(mats.getKnownMaterialsMap().get(materials.get(materialSelected)), materials.get(materialSelected)));
				}
			}
			break;
		case TAKESTACK:
			materials.addAll(mats.getKnownMaterialsMap().keySet());

			freeSlots = getFreeSlots();
			if(freeSlots >= 1)
			{
				if(mats.getKnownMaterialsMap().get(materials.get(materialSelected)) >= 64){
					PacketDispatcher.sendToServer(new TakeMaterials(64, materials.get(materialSelected)));
				}else{
					PacketDispatcher.sendToServer(new TakeMaterials(mats.getKnownMaterialsMap().get(materials.get(materialSelected)), materials.get(materialSelected)));
				}
			}
			break;
		case TAKEALL:
			materials.addAll(mats.getKnownMaterialsMap().keySet());
			freeSlots = getFreeSlots();
			if(freeSlots >= 1){
				PacketDispatcher.sendToServer(new TakeMaterials(freeSlots *64, materials.get(materialSelected)));
			}
			break;
		case DEPOSIT:
			PacketDispatcher.sendToServer(new OpenMaterials());
			break;
		}
		updateButtons();
	}

	public boolean isRecipeUsable(String name, int amountToRemove){
		EntityPlayer player = Minecraft.getMinecraft().thePlayer;
		ExtendedPlayerMaterials mats = ExtendedPlayerMaterials.get(player);
		Recipe r = RecipeRegistry.get(name);
		List<Boolean> hasMaterials = new ArrayList<Boolean>();
		if(isInventoryFull()){
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
		if(submenu != MATERIALS){
			Take1.visible = false;
			TakeStack.visible = false;
			TakeHalfStack.visible = false;
			TakeAll.visible = false;
			Deposit.visible = false;

		}
		if(submenu == MATERIALS){
			if(materialSelected != -1){
				Take1.visible = true;
				TakeStack.visible = true;
				TakeHalfStack.visible = true;
				TakeAll.visible = true;

			}else{
				Take1.visible = false;
				TakeStack.visible = false;
				TakeHalfStack.visible = false;
				TakeAll.visible = false;
				Deposit.visible = true;

			}
			if(materialSelected != -1 && !isInventoryFull()){
				Take1.enabled = true;
				TakeStack.enabled = true;
				TakeHalfStack.enabled = true;
				TakeAll.enabled = true;


			}else{
				Take1.enabled = false;
				TakeStack.enabled = false;
				TakeHalfStack.enabled = false;
				TakeAll.enabled = false;
			}
		}
		if(materialSelected != -1){
			ExtendedPlayerMaterials mats = ExtendedPlayerMaterials.get(mc.thePlayer);
			List<String> materials = new ArrayList<String>();
			
			materials.addAll(mats.getKnownMaterialsMap().keySet());
			if(!(mats.getKnownMaterialsMap().get(materials.get(materialSelected)) < 1)){
				Take1.enabled = true;
				TakeStack.enabled = true;
				TakeHalfStack.enabled = true;
				TakeAll.enabled = true;

			}else{
				Take1.enabled = false;
				TakeStack.enabled = false;
				TakeHalfStack.enabled = false;
				TakeAll.enabled = false;

			}
			Take1.visible = true;
			TakeStack.visible = true;
			TakeHalfStack.visible = true;
			TakeAll.visible = true;



		}else{
			Take1.visible = false;
			TakeStack.visible = false;
			TakeHalfStack.visible = false;
			TakeAll.visible = false;

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
			if(isInventoryFull()){
				Create.displayString = "Inventory Full";
			}
			Create.enabled = false;
		}
	}

	private boolean isInventoryFull() {
		EntityPlayer player = Minecraft.getMinecraft().thePlayer;
		boolean full = false;
		for (int i = 0; i < player.inventory.mainInventory.length; i++){
			if(player.inventory.mainInventory[i] != null){
				full = true;
			}
			if(player.inventory.mainInventory[i] == null){
				return false;
			}
		}
		if(full){
			return true;
		}
		return false;
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
		if(submenu != MAIN && submenu == RECIPES){
			drawSelected(mouseX, mouseY);
		}else if(submenu != MAIN && submenu == MATERIALS){
			drawSelectedMaterial(mouseX, mouseY);
		}else{
			selected = -1;
			materialSelected = -1;
		}
		super.drawScreen(mouseX, mouseY, partialTicks);
	}

	public void drawSelectedMaterial(int mouseX, int mouseY){
		ExtendedPlayerMaterials mats = ExtendedPlayerMaterials.get(mc.thePlayer);
		if(materialSelected != -1){
			Minecraft.getMinecraft().renderEngine.bindTexture(optionsBackground);
			drawGradientRect(190, 60, 500, height - ((height/8)+70/16), -1072689136, -804253680);
		}
		List<String> materials = new ArrayList<String>();
		
		materials.addAll(mats.getKnownMaterialsMap().keySet());
		for(int i = 0; i < mats.getKnownMaterialsMap().size(); i++){
			if(materialSelected == i){
				GL11.glPushMatrix();{
					GL11.glTranslatef(200, 70, 0);
					GL11.glScalef(2, 2, 2);
					drawString(fontRendererObj, TextHelper.localize(materials.get(i).toString() + ".name") + " x" + mats.getKnownMaterialsMap().get(materials.get(i)), 0, 0, 0xFFF700);
				}GL11.glPopMatrix();
				Material m = MaterialRegistry.get(materials.get(i).toString());
		        if(m.getTexture() != null){
		        	GL11.glPushMatrix();{ 
		        		GL11.glColor3f(1, 1, 1);
		        		ResourceLocation texture = m.getTexture();
		            	Minecraft.getMinecraft().renderEngine.bindTexture(texture);
		    			GL11.glTranslatef(200, 100, 0);
		    			GL11.glScalef(0.0625f, 0.0625f, 0.0625f);
			        	GL11.glScalef(3, 3, 3);
		    			drawTexturedModalRect(0, 0, 0, 0, 256, 256);
		        	}GL11.glPopMatrix();
		        }else{
		        	GL11.glPushMatrix();{ 
		        		ItemStack item = m.getItem();
		    			GL11.glTranslatef(200, 100, 0);
			        	GL11.glScalef(3, 3, 3);
			        	mc.getRenderItem().renderItemAndEffectIntoGUI(item, 0, 0);
		        	}GL11.glPopMatrix();
		        	
		        }
			}
		}
	}
	
	public void drawSelected(int mouseX, int mouseY){
		ExtendedPlayerRecipes props = ExtendedPlayerRecipes.get(mc.thePlayer);
		int posX = 220;
		if(selected != -1){
			Minecraft.getMinecraft().renderEngine.bindTexture(optionsBackground);
			drawGradientRect(posX - 10, 60, 700, height - ((height/8)+70/16), -1072689136, -804253680);
		}
		GL11.glPushMatrix();{
			for(int i = 0; i < props.knownRecipes.size(); i++){
				if(selected == i){
					GL11.glPushMatrix();{
						GL11.glTranslatef(posX, 70, 0);
						GL11.glScalef(2, 2, 2);
						drawString(fontRendererObj, TextHelper.localize(props.knownRecipes.get(i).toString() + ".name"), 0, 0, 0xFFF700);
					}GL11.glPopMatrix();
				
					drawString(fontRendererObj, TextHelper.localize(Strings.Gui_Synthesis_Main_Recipes_ReqMaterials) + TextHelper.ITALIC, posX, 100, 0x00C3FF);

					int row = 0;
					int column = 0; 
					int materialLength = 0;
					Iterator it = RecipeRegistry.get(props.knownRecipes.get(i)).getRequirements().entrySet().iterator();
					while (it.hasNext()) {
						Map.Entry<Material, Integer> pair = (Map.Entry<Material, Integer>)it.next();
						int distY = 24;
						int distX = 100;
						GL11.glPushMatrix();{
							GL11.glColor4f(1, 1, 1, 1);
							ResourceLocation synthMaterial = pair.getKey().getTexture();
							if(synthMaterial == null){
								GL11.glTranslatef((int)(posX + (materialLength*1.05f)), 110 + (distY*row), 0);
								Minecraft.getMinecraft().getRenderItem().renderItemAndEffectIntoGUI(pair.getKey().getItem(), 0, 0);
							}else{
								mc.renderEngine.bindTexture(synthMaterial);
								GL11.glTranslatef(posX + (materialLength*1.05f), 110 + (distY*row), 0);
								GL11.glScalef(0.0625f, 0.0625f, 0.0625f);
								drawTexturedModalRect(0, 0, 0, 0, 256, 256);
							}
						}GL11.glPopMatrix();
						String name = pair.getKey().getName();
						String info = "";
						int colour = 0xFFFFFF;
						ExtendedPlayerMaterials mats = ExtendedPlayerMaterials.get(mc.thePlayer);
						if(mats.getKnownMaterialsMap().containsKey(pair.getKey().getName())){
							info = " - You have " + mats.getKnownMaterialsMap().get(pair.getKey().getName());
							if(mats.getKnownMaterialsMap().get(pair.getKey().getName()) >= pair.getValue()){
								colour = 0x00CF18;
							}else{
								colour = 0xB50000;
							}	
						}else{
							info = " - You have 0";
							colour = 0xB50000;
						}
						String material = TextHelper.localize(name + ".name") + " x" + pair.getValue();
						drawString(fontRendererObj, material, (int) (posX + 18 + (materialLength*1.05f)), 114 + (distY*row), 0xFFFFFF);
						drawString(fontRendererObj, info, (int) (posX + 18 + fontRendererObj.getStringWidth(material) + (materialLength*1.05f)), 114 + (distY*row), colour);
						if(column == 1){
							row++;
							column = 0;
							materialLength = 0;
						}else{
							materialLength = (fontRendererObj.getStringWidth(TextHelper.localize(ModItems.Chain_IncompleteKiblade.getUnlocalizedName() + ".name") + " - You have XXXX")) + 20/*fontRendererObj.getStringWidth(material + info) + 16*/;
							column = 1;
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
