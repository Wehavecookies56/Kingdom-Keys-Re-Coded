package uk.co.wehavecookies56.kk.client.gui;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.lwjgl.opengl.GL11;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import uk.co.wehavecookies56.kk.api.materials.Material;
import uk.co.wehavecookies56.kk.api.materials.MaterialRegistry;
import uk.co.wehavecookies56.kk.api.recipes.FreeDevRecipeRegistry;
import uk.co.wehavecookies56.kk.api.recipes.Recipe;
import uk.co.wehavecookies56.kk.api.recipes.RecipeRegistry;
import uk.co.wehavecookies56.kk.client.core.helper.GuiHelper;
import uk.co.wehavecookies56.kk.client.sound.ModSounds;
import uk.co.wehavecookies56.kk.common.capability.ModCapabilities;
import uk.co.wehavecookies56.kk.common.capability.MunnyCapability.IMunny;
import uk.co.wehavecookies56.kk.common.capability.SynthesisMaterialCapability;
import uk.co.wehavecookies56.kk.common.capability.SynthesisRecipeCapability;
import uk.co.wehavecookies56.kk.common.core.handler.MainConfig;
import uk.co.wehavecookies56.kk.common.item.ModItems;
import uk.co.wehavecookies56.kk.common.item.base.ItemKeyblade;
import uk.co.wehavecookies56.kk.common.item.base.ItemOrgWeapon;
import uk.co.wehavecookies56.kk.common.item.org.IOrgWeapon;
import uk.co.wehavecookies56.kk.common.lib.Constants;
import uk.co.wehavecookies56.kk.common.lib.Reference;
import uk.co.wehavecookies56.kk.common.lib.Strings;
import uk.co.wehavecookies56.kk.common.lib.Tutorials;
import uk.co.wehavecookies56.kk.common.network.packet.PacketDispatcher;
import uk.co.wehavecookies56.kk.common.network.packet.server.CreateFromSynthesisRecipe;
import uk.co.wehavecookies56.kk.common.network.packet.server.DepositMaterialsFromBag;
import uk.co.wehavecookies56.kk.common.network.packet.server.DepositMaterials;
import uk.co.wehavecookies56.kk.common.network.packet.server.TakeMaterials;
import uk.co.wehavecookies56.kk.common.util.Utils;

public class GuiSynthesis extends GuiTooltip {

	public int selected = -1;
	public int freeDevSelected = -1;
	public final int MAIN = 0, BACK = 0, RECIPES = 1, FREEDEV = 2, MATERIALS = 3, CREATE = 4, TAKE1 = 5, TAKESTACK = 6, TAKEHALFSTACK = 7, TAKEALL = 8, DEPOSIT = 9, DEPOSITBAG = 10;
	public int submenu;
	private final GuiScreen parentScreen;
	protected String title = Utils.translateToLocal(Strings.Gui_Synthesis_Main_Title);
	private GuiRecipeList recipeList;
	private GuiMaterialList materialList;
	private GuiFreeDevelopmentRecipeList freeDevRecipeList;

	public GuiButton Back, FreeDev, Recipes, Materials, Create, Take1, TakeStack, TakeHalfStack, TakeAll, Deposit, DepositBag;
	public int materialSelected = -1;

	public GuiSynthesis(GuiScreen parentScreen) {
		this.parentScreen = parentScreen;
	}

	@SuppressWarnings("unchecked")
	@Override
	public void initGui() {
		this.recipeList = new GuiRecipeList(this);
		this.recipeList.registerScrollButtons(this.buttonList, 7, 8);
		this.materialList = new GuiMaterialList(this);
		this.materialList.registerScrollButtons(this.buttonList, 7, 8);
		this.freeDevRecipeList = new GuiFreeDevelopmentRecipeList(this);
		this.freeDevRecipeList.registerScrollButtons(this.buttonList, 7, 8);
		this.buttonList.add(Back = new GuiButton(BACK, width - 105, height - ((height / 8) + 70 / 16), 100, 20, Utils.translateToLocal(Strings.Gui_Menu_Items_Button_Back)));
		this.buttonList.add(Create = new GuiButton(CREATE, 270, height - ((height / 8) + 70 / 16) - 25, 100, 20, Utils.translateToLocal(Strings.Gui_Synthesis_Main_Recipes_Create)));
		this.buttonList.add(Recipes = new GuiButton(RECIPES, 5, 65, 100, 20, Utils.translateToLocal(Strings.Gui_Synthesis_Main_Recipes)));
		this.buttonList.add(FreeDev = new GuiButton(FREEDEV, 5, 65 + 25, 100, 20, Utils.translateToLocal(Strings.Gui_Synthesis_Main_FreeDev)));
		this.buttonList.add(Materials = new GuiButton(MATERIALS, 5, 90 + 25, 100, 20, Utils.translateToLocal(Strings.Gui_Synthesis_Main_Materials)));

		this.buttonList.add(Deposit = new GuiButton(DEPOSIT, width - 105, height - ((height / 2) + 90), 100, 20, Utils.translateToLocal(Strings.Gui_Synthesis_Main_Materials_Deposit_Inv)));
		this.buttonList.add(DepositBag = new GuiButton(DEPOSITBAG, width - 105, height - ((height / 2) + 70), 100, 20, Utils.translateToLocal(Strings.Gui_Synthesis_Main_Materials_Deposit_Bag)));

		this.buttonList.add(Take1 = new GuiButton(TAKE1, 195, height - ((height / 8) + 70 / 16) - 25, 75, 20, Utils.translateToLocal(Strings.Gui_Synthesis_Main_Materials_TakeOne)));
		this.buttonList.add(TakeHalfStack = new GuiButton(TAKEHALFSTACK, 270, height - ((height / 8) + 70 / 16) - 25, 75, 20, Utils.translateToLocal(Strings.Gui_Synthesis_Main_Materials_TakeHalfStack)));
		this.buttonList.add(TakeStack = new GuiButton(TAKESTACK, 345, height - ((height / 8) + 70 / 16) - 25, 75, 20, Utils.translateToLocal(Strings.Gui_Synthesis_Main_Materials_TakeStack)));
		this.buttonList.add(TakeAll = new GuiButton(TAKEALL, 420, height - ((height / 8) + 70 / 16) - 25, 75, 20, Utils.translateToLocal(Strings.Gui_Synthesis_Main_Materials_TakeAll)));

		updateButtons();
	}

	@Override
	public void updateScreen() {
		updateButtons();
	}

	protected int getFreeSlots() {
		int emptySlots = 0;
		for (ItemStack element : mc.player.inventory.mainInventory)
			if (ItemStack.areItemStacksEqual(element, ItemStack.EMPTY))
				emptySlots++;
		return emptySlots;
	}

	protected boolean getInventoryMaterial(String material) {
		for (ItemStack element : mc.player.inventory.mainInventory)
			if (!ItemStack.areItemStacksEqual(element, ItemStack.EMPTY))
				if (element.getUnlocalizedName().equals(material))
					return true;
		return false;
	}

	@Override
	protected void actionPerformed(GuiButton button) {
		SynthesisMaterialCapability.ISynthesisMaterial MATS = mc.player.getCapability(ModCapabilities.SYNTHESIS_MATERIALS, null);
		List<String> materials = new ArrayList<String>();
		int freeSlots = 0;
		boolean foundMaterial = false;
		switch (button.id) {
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
			DepositBag.visible = true;
			submenu = MATERIALS;
			break;
		case CREATE:
			if (selected != -1) {
				if (isRecipeUsable(mc.player.getCapability(ModCapabilities.SYNTHESIS_RECIPES, null).getKnownRecipes().get(selected))) {
					PacketDispatcher.sendToServer(new CreateFromSynthesisRecipe(mc.player.getCapability(ModCapabilities.SYNTHESIS_RECIPES, null).getKnownRecipes().get(selected), 1));
					mc.player.world.playSound(mc.player, mc.player.getPosition(), ModSounds.itemget, SoundCategory.MASTER, 1.0f, 1.0f);
					GuiHelper.openTutorial(Tutorials.TUTORIAL_KEYBLADE_1);
				}
			} else if (freeDevSelected != -1) {
				if (isFreeDevRecipeUsable(mc.player.getCapability(ModCapabilities.SYNTHESIS_RECIPES, null).getFreeDevRecipes().get(freeDevSelected))) {
					PacketDispatcher.sendToServer(new CreateFromSynthesisRecipe(mc.player.getCapability(ModCapabilities.SYNTHESIS_RECIPES, null).getFreeDevRecipes().get(freeDevSelected), 1));
					mc.player.world.playSound(mc.player, mc.player.getPosition(), ModSounds.itemget, SoundCategory.MASTER, 1.0f, 1.0f);
				}
			}

			break;
		case TAKE1:
			materials.addAll(MATS.getKnownMaterialsMap().keySet());

			freeSlots = getFreeSlots();
			foundMaterial = getInventoryMaterial(materials.get(materialSelected));
			if (foundMaterial || freeSlots >= 1) {
				if (MATS.getKnownMaterialsMap().get(materials.get(materialSelected)) > 1) {
					PacketDispatcher.sendToServer(new TakeMaterials(1, materials.get(materialSelected)));
				} else {
					PacketDispatcher.sendToServer(new TakeMaterials(1, materials.get(materialSelected)));
					materialSelected = -1;
				}
			}
			break;
		case TAKEHALFSTACK:
			materials.addAll(MATS.getKnownMaterialsMap().keySet());

			freeSlots = getFreeSlots();
			foundMaterial = getInventoryMaterial(materials.get(materialSelected));
			if (foundMaterial || freeSlots >= 1) {
				if (MATS.getKnownMaterialsMap().get(materials.get(materialSelected)) >= 32)
					PacketDispatcher.sendToServer(new TakeMaterials(32, materials.get(materialSelected)));
				else {
					PacketDispatcher.sendToServer(new TakeMaterials(MATS.getKnownMaterialsMap().get(materials.get(materialSelected)), materials.get(materialSelected)));
					materialSelected = -1;
				}
			}

			break;
		case TAKESTACK:
			materials.addAll(MATS.getKnownMaterialsMap().keySet());

			freeSlots = getFreeSlots();
			if (freeSlots >= 1) {
				if (MATS.getKnownMaterialsMap().get(materials.get(materialSelected)) >= 64)
					PacketDispatcher.sendToServer(new TakeMaterials(64, materials.get(materialSelected)));
				else {
					PacketDispatcher.sendToServer(new TakeMaterials(MATS.getKnownMaterialsMap().get(materials.get(materialSelected)), materials.get(materialSelected)));
					materialSelected = -1;
				}
			}
			break;
		case TAKEALL:
			materials.addAll(MATS.getKnownMaterialsMap().keySet());
			freeSlots = getFreeSlots();
			if (freeSlots >= 1)
				PacketDispatcher.sendToServer(new TakeMaterials(freeSlots * 64, materials.get(materialSelected)));
			materialSelected = -1;
			break;
		case DEPOSIT:
			PacketDispatcher.sendToServer(new DepositMaterials());
			break;
		case DEPOSITBAG:
			PacketDispatcher.sendToServer(new DepositMaterialsFromBag());
			break;
		}
		updateButtons();
	}

	public boolean isRecipeUsable(String name) {
		EntityPlayer player = Minecraft.getMinecraft().player;
		SynthesisMaterialCapability.ISynthesisMaterial MATS = player.getCapability(ModCapabilities.SYNTHESIS_MATERIALS, null);
		Recipe r = RecipeRegistry.get(name);
		List<Boolean> hasMaterials = new ArrayList<Boolean>();
		if (isInventoryFull())
			return false;
		Iterator it = r.getRequirements().entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry<Material, Integer> pair = (Map.Entry<Material, Integer>) it.next();
			if (MATS.getKnownMaterialsMap().containsKey(pair.getKey().getName())) {
				if (pair.getValue() != null && MATS.getKnownMaterialsMap().get(pair.getKey().getName()) != null) {
					if (pair.getValue() <= MATS.getKnownMaterialsMap().get(pair.getKey().getName())) {
						hasMaterials.add(true);
					}
				}
			}
		}
		if (r.getRequirements().size() > 0) {
			if (hasMaterials.size() == r.getRequirements().size()) {
				return true;
			}
		}
		return false;
	}

	public boolean isFreeDevRecipeUsable(String name) {
		EntityPlayer player = Minecraft.getMinecraft().player;
		SynthesisMaterialCapability.ISynthesisMaterial MATS = player.getCapability(ModCapabilities.SYNTHESIS_MATERIALS, null);
		Recipe r = FreeDevRecipeRegistry.get(name);
		List<Boolean> hasMaterials = new ArrayList<Boolean>();
		if (isInventoryFull())
			return false;
		Iterator it = r.getRequirements().entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry<Material, Integer> pair = (Map.Entry<Material, Integer>) it.next();
			if (MATS.getKnownMaterialsMap().containsKey(pair.getKey().getName())) {
				if (pair.getValue() != null && MATS.getKnownMaterialsMap().get(pair.getKey().getName()) != null) {
					if (pair.getValue() <= MATS.getKnownMaterialsMap().get(pair.getKey().getName())) {
						hasMaterials.add(true);
					}
				}
			}
		}
		if (r.getRequirements().size() > 0) {
			if (hasMaterials.size() == r.getRequirements().size()) {
				return true;
			}
		}
		return false;
	}

	private void updateButtons() {
		if (submenu == MAIN) {
			Back.visible = false;
			Recipes.visible = true;
			FreeDev.visible = true;
			FreeDev.enabled = true;
			Materials.visible = true;
			Create.visible = false;
		} else {
			Back.visible = true;
			Recipes.visible = false;
			FreeDev.visible = false;
			Materials.visible = false;
		}
		if (submenu != MATERIALS) {
			Take1.visible = false;
			TakeStack.visible = false;
			TakeHalfStack.visible = false;
			TakeAll.visible = false;
			Deposit.visible = false;
			DepositBag.visible = false;

		}
		if (submenu == FREEDEV) {
			if (freeDevSelected != -1) {
				Create.visible = true;
				if (isFreeDevRecipeUsable(mc.player.getCapability(ModCapabilities.SYNTHESIS_RECIPES, null).getFreeDevRecipes().get(freeDevSelected)))
					Create.enabled = true;
				else {
					if (isInventoryFull())
						Create.displayString = "Inventory Full";
					else
						Create.displayString = Utils.translateToLocal(Strings.Gui_Synthesis_Main_Recipes_Create);
					Create.enabled = false;
				}
			} else {
				Create.visible = false;
			}
		}
		if (submenu == MATERIALS) {
			if (materialSelected != -1) {
				Take1.visible = true;
				TakeStack.visible = true;
				TakeHalfStack.visible = true;
				TakeAll.visible = true;
			} else {
				Take1.visible = false;
				TakeStack.visible = false;
				TakeHalfStack.visible = false;
				TakeAll.visible = false;
				Deposit.visible = true;
				DepositBag.visible = true;
			}
			Create.visible = false;
			if (materialSelected != -1 && !isInventoryFull()) {
				Take1.enabled = true;
				TakeStack.enabled = true;
				TakeHalfStack.enabled = true;
				TakeAll.enabled = true;

			} else {
				Take1.enabled = false;
				TakeStack.enabled = false;
				TakeHalfStack.enabled = false;
				TakeAll.enabled = false;
			}
		}

		if (materialSelected != -1) {
			SynthesisMaterialCapability.ISynthesisMaterial MATS = mc.player.getCapability(ModCapabilities.SYNTHESIS_MATERIALS, null);
			List<String> materials = new ArrayList<String>();

			materials.addAll(MATS.getKnownMaterialsMap().keySet());
			if (!MATS.getKnownMaterialsMap().isEmpty()) {
				if (!(MATS.getKnownMaterialsMap().get(materials.get(materialSelected)) < 1)) {
					Take1.enabled = true;
					TakeStack.enabled = true;
					TakeHalfStack.enabled = true;
					TakeAll.enabled = true;

				} else {
					Take1.enabled = false;
					TakeStack.enabled = false;
					TakeHalfStack.enabled = false;
					TakeAll.enabled = false;

				}
			} else {
				materialSelected = -1;
			}
			Take1.visible = true;
			TakeStack.visible = true;
			TakeHalfStack.visible = true;
			TakeAll.visible = true;
		} else {
			Take1.visible = false;
			TakeStack.visible = false;
			TakeHalfStack.visible = false;
			TakeAll.visible = false;

		}

		if (submenu == RECIPES) {
			if (selected != -1) {
				Create.visible = true;
				if (isRecipeUsable(mc.player.getCapability(ModCapabilities.SYNTHESIS_RECIPES, null).getKnownRecipes().get(selected))) {
					Create.enabled = true;
				} else {
					if (isInventoryFull())
						Create.displayString = "Inventory Full";
					else
						Create.displayString = Utils.translateToLocal(Strings.Gui_Synthesis_Main_Recipes_Create);
					Create.enabled = false;
				}
			} else {
				Create.visible = false;
			}
		}

	}

	private boolean isInventoryFull() {
		EntityPlayer player = Minecraft.getMinecraft().player;
		boolean full = false;
		for (ItemStack element : player.inventory.mainInventory) {
			if (element != ItemStack.EMPTY && element.getItem() != Items.AIR)
				full = true;
			if (element == ItemStack.EMPTY || element.getItem() == Items.AIR)
				return false;
		}
		if (full)
			return true;
		return false;
	}

	@Override
	public void drawScreen(int mouseX, int mouseY, float partialTicks) {
		drawDefaultBackground();
		if (submenu == RECIPES)
			this.recipeList.drawScreen(mouseX, mouseY, partialTicks);
		
		else if (submenu == MATERIALS)
			this.materialList.drawScreen(mouseX, mouseY, partialTicks);

		if (submenu == FREEDEV)
			this.freeDevRecipeList.drawScreen(mouseX, mouseY, partialTicks);

		drawBackground(width, height);

		if (submenu != MAIN && submenu == RECIPES)
			drawSelectedRecipe();

		else if (submenu != MAIN && submenu == MATERIALS) {
			drawSelectedMaterial();
			this.drawString(fontRenderer, Utils.translateToLocal(Strings.Gui_Synthesis_Main_Materials_Deposit), width - 107, height - ((height / 2) + 105), 0xFFFFFF);
		}

		else if (submenu != MAIN && submenu == FREEDEV)
			drawSelectedFreeDev();

		else {
			selected = -1;
			materialSelected = -1;
			freeDevSelected = -1;
		}
		super.drawScreen(mouseX, mouseY, partialTicks);
	}

	public void drawSelectedMaterial() {
		SynthesisMaterialCapability.ISynthesisMaterial MATS = mc.player.getCapability(ModCapabilities.SYNTHESIS_MATERIALS, null);
		if (materialSelected != -1) {
			Minecraft.getMinecraft().renderEngine.bindTexture(optionsBackground);
			drawGradientRect(190, 60, 500, height - ((height / 8) + 70 / 16), -1072689136, -804253680);
		}
		List<String> materials = new ArrayList<String>();

		materials.addAll(MATS.getKnownMaterialsMap().keySet());
		for (int i = 0; i < MATS.getKnownMaterialsMap().size(); i++)
			if (materialSelected == i) {
				GL11.glPushMatrix();
				{
					GL11.glTranslatef(200, 70, 0);
					GL11.glScalef(2, 2, 2);
					drawString(fontRenderer, Utils.translateToLocal(materials.get(i).toString() + ".name") + " x" + MATS.getKnownMaterialsMap().get(materials.get(i)), 0, 0, 0xFFF700);
				}
				GL11.glPopMatrix();
				Material m = MaterialRegistry.get(materials.get(i).toString());
				if (m.getTexture() != null) {
					GL11.glPushMatrix();
					{
						GL11.glColor3f(1, 1, 1);
						ResourceLocation texture = m.getTexture();
						Minecraft.getMinecraft().renderEngine.bindTexture(texture);
						GL11.glTranslatef(200, 100, 0);
						GL11.glScalef(0.0625f, 0.0625f, 0.0625f);
						GL11.glScalef(3, 3, 3);
						drawTexturedModalRect(0, 0, 0, 0, 256, 256);
					}
					GL11.glPopMatrix();
				} else {
					GL11.glPushMatrix();
					{
						ItemStack item = m.getItem();
						GL11.glTranslatef(200, 100, 0);
						GL11.glScalef(3, 3, 3);
						mc.getRenderItem().renderItemAndEffectIntoGUI(item, 0, 0);
					}
					GL11.glPopMatrix();

				}
			}
	}

	public void drawSelectedRecipe() {
		SynthesisRecipeCapability.ISynthesisRecipe RECIPES = mc.player.getCapability(ModCapabilities.SYNTHESIS_RECIPES, null);
		int posX = 220;
		if (selected != -1) {
			Minecraft.getMinecraft().renderEngine.bindTexture(optionsBackground);
			drawGradientRect(posX - 10, 60, 700, height - ((height / 8) + 70 / 16), -1072689136, -804253680);
		}
		GL11.glPushMatrix();
		{
			for (int i = 0; i < RECIPES.getKnownRecipes().size(); i++)
				if (selected == i) {
					float scale = 1.0f;
					if (mc.gameSettings.guiScale == Constants.SCALE_LARGE) {
						scale = 0.5f;
					}
					GL11.glPushMatrix();
					{
						GL11.glTranslatef(posX, 70, 0);
						GL11.glScalef(2 * scale, 2 * scale, 2 * scale);
						drawString(fontRenderer, Utils.translateToLocal(RECIPES.getKnownRecipes().get(i).toString() + ".name"), 0, 0, 0xFFF700);
						Item item = ForgeRegistries.ITEMS.getValue(new ResourceLocation(Reference.MODID, RECIPES.getKnownRecipes().get(i).substring(5)));
						if (item instanceof ItemKeyblade) {
							drawString(fontRenderer, "Strength: +" + ((ItemKeyblade) ForgeRegistries.ITEMS.getValue(new ResourceLocation(Reference.MODID, RECIPES.getKnownRecipes().get(i).substring(5)))).getStrength(), 0, 10, 0xFF0000);
							drawString(fontRenderer, "Magic: +" + ((ItemKeyblade) ForgeRegistries.ITEMS.getValue(new ResourceLocation(Reference.MODID, RECIPES.getKnownRecipes().get(i).substring(5)))).getMagic(), 0, 20, 0x4444FF);
						} else if (item instanceof IOrgWeapon) {
							drawString(fontRenderer, "Strength: +" + ((IOrgWeapon) ForgeRegistries.ITEMS.getValue(new ResourceLocation(Reference.MODID, RECIPES.getKnownRecipes().get(i).substring(5)))).getStrength(), 0, 10, 0xFF0000);
							drawString(fontRenderer, "Magic: +" + ((IOrgWeapon) ForgeRegistries.ITEMS.getValue(new ResourceLocation(Reference.MODID, RECIPES.getKnownRecipes().get(i).substring(5)))).getMagic(), 0, 20, 0x4444FF);
						}
					}
					GL11.glPopMatrix();

					drawString(fontRenderer, Utils.translateToLocal(Strings.Gui_Synthesis_Main_Recipes_ReqMaterials) + TextFormatting.ITALIC, posX, 130, 0x00C3FF);

					int row = 0;
					int column = 0;
					int materialLength = 0;
					Iterator it = RecipeRegistry.get(RECIPES.getKnownRecipes().get(i)).getRequirements().entrySet().iterator();
					while (it.hasNext()) {
						Map.Entry<Material, Integer> pair = (Map.Entry<Material, Integer>) it.next();
						int distY = (int) (24 * scale);
						int distX = (int) (100 * scale);
						GL11.glPushMatrix();
						{
							GL11.glColor4f(1, 1, 1, 1);
							ResourceLocation synthMaterial = pair.getKey().getTexture();
							if (synthMaterial == null) {
								GL11.glTranslatef((int) (posX + (materialLength * 1.05f)), 140 + (distY * row), 0);
								GL11.glScalef(scale, scale, 0);
								Minecraft.getMinecraft().getRenderItem().renderItemAndEffectIntoGUI(pair.getKey().getItem(), 0, 0);
							} else {
								mc.renderEngine.bindTexture(synthMaterial);
								GL11.glTranslatef(posX + (materialLength * 1.05f * scale), 140 + (distY * row), 0);
								GL11.glScalef(0.0625f * scale, 0.0625f * scale, 0);
								drawTexturedModalRect(0, 0, 0, 0, 256, 256);
							}
						}
						GL11.glPopMatrix();
						String name = pair.getKey().getName();
						String info = "";
						int colour = 0xFFFFFF;
						SynthesisMaterialCapability.ISynthesisMaterial MATS = mc.player.getCapability(ModCapabilities.SYNTHESIS_MATERIALS, null);
						if (MATS.getKnownMaterialsMap().containsKey(pair.getKey().getName())) {
							info = " - You have " + MATS.getKnownMaterialsMap().get(pair.getKey().getName());
							if (MATS.getKnownMaterialsMap().get(pair.getKey().getName()) >= pair.getValue())
								colour = 0x00CF18;
							else
								colour = 0xB50000;
						} else {
							info = " - You have 0";
							colour = 0xB50000;
						}
						String material = Utils.translateToLocal(name + ".name") + " x" + pair.getValue();

						GL11.glPushMatrix();
						{
							GL11.glTranslatef((int) (posX + 18 + (materialLength * 1.05f * scale)), 144 + (distY * row), 0);
							GL11.glScalef(scale, scale, 0);
							drawString(fontRenderer, material, 0, 0, 0xFFFFFF);
						}
						GL11.glPopMatrix();
						GL11.glPushMatrix();
						{
							GL11.glTranslatef((int) (posX + 18 + (fontRenderer.getStringWidth(material) * scale) + (materialLength * 1.05f * scale)), 144 + (distY * row), 0);
							GL11.glScalef(scale, scale, 0);
							drawString(fontRenderer, info, 0, 0, colour);
						}
						GL11.glPopMatrix();

						if (column == 1) {
							row++;
							column = 0;
							materialLength = 0;
						} else {
							materialLength = (fontRenderer.getStringWidth(Utils.translateToLocal(ModItems.Chain_IncompleteKiblade.getUnlocalizedName() + ".name") + " - You have XXXX")) + 20;
							column = 1;
						}

					}
				}
		}
		GL11.glPopMatrix();
	}

	public void drawSelectedFreeDev() {
		SynthesisRecipeCapability.ISynthesisRecipe RECIPES = mc.player.getCapability(ModCapabilities.SYNTHESIS_RECIPES, null);
		int posX = 220;
		if (freeDevSelected != -1) {
			Minecraft.getMinecraft().renderEngine.bindTexture(optionsBackground);
			drawGradientRect(posX - 10, 60, 700, height - ((height / 8) + 70 / 16), -1072689136, -804253680);
		}
		GL11.glPushMatrix();
		{
			for (int i = 0; i < RECIPES.getFreeDevRecipes().size(); i++)
				if (freeDevSelected == i) {
					float scale = 1.0f;
					if (mc.gameSettings.guiScale == Constants.SCALE_LARGE) {
						scale = 0.5f;
					}
					GL11.glPushMatrix();
					{
						GL11.glTranslatef(posX, 70, 0);
						GL11.glScalef(2 * scale, 2 * scale, 2 * scale);
						drawString(fontRenderer, Utils.translateToLocal(RECIPES.getFreeDevRecipes().get(i).toString() + ".name"), 0, 0, 0xFFF700);
						// drawString(fontRendererObj, "Strength:
						// +"+((ItemKeyblade)ForgeRegistries.ITEMS.getValue(new
						// ResourceLocation(Reference.MODID,
						// RECIPES.getKnownRecipes().get(i).substring(5)))).getStrength(), 0, 10,
						// 0xFF0000);
						// drawString(fontRendererObj, "Magic: +"+
						// ((ItemKeyblade)ForgeRegistries.ITEMS.getValue(new
						// ResourceLocation(Reference.MODID,
						// RECIPES.getKnownRecipes().get(i).substring(5)))).getMagic(), 0, 20,
						// 0x4444FF);
					}
					GL11.glPopMatrix();

					drawString(fontRenderer, Utils.translateToLocal(Strings.Gui_Synthesis_Main_Recipes_ReqMaterials) + TextFormatting.ITALIC, posX, 100, 0x00C3FF);

					int row = 0;
					int column = 0;
					int materialLength = 0;
					Iterator it = FreeDevRecipeRegistry.get(RECIPES.getFreeDevRecipes().get(i)).getRequirements().entrySet().iterator();
					while (it.hasNext()) {
						Map.Entry<Material, Integer> pair = (Map.Entry<Material, Integer>) it.next();
						int distY = (int) (24 * scale);
						int distX = (int) (100 * scale);
						GL11.glPushMatrix();
						{
							GL11.glColor4f(1, 1, 1, 1);
							ResourceLocation synthMaterial = pair.getKey().getTexture();
							if (synthMaterial == null) {
								GL11.glTranslatef((int) (posX + (materialLength * 1.05f)), 110 + (distY * row), 0);
								GL11.glScalef(scale, scale, 0);
								Minecraft.getMinecraft().getRenderItem().renderItemAndEffectIntoGUI(pair.getKey().getItem(), 0, 0);
							} else {
								mc.renderEngine.bindTexture(synthMaterial);
								GL11.glTranslatef(posX + (materialLength * 1.05f * scale), 110 + (distY * row), 0);
								GL11.glScalef(0.0625f * scale, 0.0625f * scale, 0);
								drawTexturedModalRect(0, 0, 0, 0, 256, 256);
							}
						}
						GL11.glPopMatrix();
						String name = pair.getKey().getName();
						String info = "";
						int colour = 0xFFFFFF;
						SynthesisMaterialCapability.ISynthesisMaterial MATS = mc.player.getCapability(ModCapabilities.SYNTHESIS_MATERIALS, null);
						if (MATS.getKnownMaterialsMap().containsKey(pair.getKey().getName())) {
							info = " - You have " + MATS.getKnownMaterialsMap().get(pair.getKey().getName());
							if (MATS.getKnownMaterialsMap().get(pair.getKey().getName()) >= pair.getValue())
								colour = 0x00CF18;
							else
								colour = 0xB50000;
						} else {
							info = " - You have 0";
							colour = 0xB50000;
						}
						String material = Utils.translateToLocal(name + ".name") + " x" + pair.getValue();

						GL11.glPushMatrix();
						{
							GL11.glTranslatef((int) (posX + 18 + (materialLength * 1.05f * scale)), 114 + (distY * row), 0);
							GL11.glScalef(scale, scale, 0);
							drawString(fontRenderer, material, 0, 0, 0xFFFFFF);
						}
						GL11.glPopMatrix();
						GL11.glPushMatrix();
						{
							GL11.glTranslatef((int) (posX + 18 + (fontRenderer.getStringWidth(material) * scale) + (materialLength * 1.05f * scale)), 114 + (distY * row), 0);
							GL11.glScalef(scale, scale, 0);
							drawString(fontRenderer, info, 0, 0, colour);
						}
						GL11.glPopMatrix();

						if (column == 1) {
							row++;
							column = 0;
							materialLength = 0;
						} else {
							materialLength = (fontRenderer.getStringWidth(Utils.translateToLocal(ModItems.Chain_IncompleteKiblade.getUnlocalizedName() + ".name") + " - You have XXXX")) + 20;
							column = 1;
						}

					}
				}
		}
		GL11.glPopMatrix();
	}

	public static final ResourceLocation optionsBackground = new ResourceLocation(Reference.MODID, "textures/gui/menubg.png");

	public static String getWorldMinutes(World world) {
		int time = (int) Math.abs((world.getWorldTime() + 6000) % 24000);
		if ((time % 1000) * 6 / 100 < 10)
			return "0" + (time % 1000) * 6 / 100;
		else
			return Integer.toString((time % 1000) * 6 / 100);
	}

	public static int getWorldHours(World world) {
		int time = (int) Math.abs((world.getWorldTime() + 6000) % 24000);
		return (int) (time / 1000F);
	}

	protected void drawBackground(int screenWidth, int screenHeight) {
		Minecraft.getMinecraft().renderEngine.bindTexture(optionsBackground);
		GL11.glPushMatrix();
		{
			GL11.glColor3ub((byte) MainConfig.client.hud.interfaceColour[0], (byte) MainConfig.client.hud.interfaceColour[1], (byte) MainConfig.client.hud.interfaceColour[2]);
			drawModalRectWithCustomSizedTexture(0, 0, 0, 0, screenWidth, 60, 32, 32);
			drawModalRectWithCustomSizedTexture(0, screenHeight - ((screenHeight / 8) + 70 / 16), 0, 0, screenWidth, 70, 32, 32);
		}
		GL11.glPopMatrix();
		GL11.glPushMatrix();
		{
			GL11.glScalef(2, 2, 2);
			drawString(fontRenderer, title, 5, 5, 0xFFFFFF);
		}
		GL11.glPopMatrix();
		if (submenu == RECIPES)
			drawString(fontRenderer, Utils.translateToLocal(Strings.Gui_Synthesis_Main_Recipes), 15, 30, 0xFFFFFF);
		if (submenu == FREEDEV)
			drawString(fontRenderer, Utils.translateToLocal(Strings.Gui_Synthesis_Main_FreeDev), 15, 30, 0xFFFFFF);
		if (submenu == MATERIALS)
			drawString(fontRenderer, Utils.translateToLocal(Strings.Gui_Synthesis_Main_Materials), 15, 30, 0xFFFFFF);
		GL11.glPushMatrix();
		{
			drawString(fontRenderer, mc.player.world.provider.getDimensionType().getName(), screenWidth - fontRenderer.getStringWidth(mc.player.world.provider.getDimensionType().getName()) - 5, 5, 0xFFFFFF);
			drawString(fontRenderer, mc.player.world.getBiome(mc.player.getPosition()).getBiomeName(), screenWidth - fontRenderer.getStringWidth(mc.player.world.getBiome(mc.player.getPosition()).getBiomeName()) - 5, 20, 0xFFFFFF);
			drawString(fontRenderer, Utils.translateToLocal(Strings.Gui_Menu_Main_Time) + ": " + getWorldHours(mc.world) + ":" + getWorldMinutes(mc.world), 5, screenHeight - ((screenHeight / 8) - 300 / 16), 0xFFFFFF);
			IMunny MUNNY = mc.player.getCapability(ModCapabilities.MUNNY, null);
			drawString(fontRenderer, Utils.translateToLocal(Strings.Gui_Menu_Main_Munny) + ": " + MUNNY.getMunny(), 5, screenHeight - ((screenHeight / 8) - 100 / 16), 0xFFD000);
		}
		GL11.glPopMatrix();

	}

	public void selectedIndex(int index) {

	}

	FontRenderer getFontRenderer() {
		return fontRenderer;
	}

	@Override
	public boolean doesGuiPauseGame() {
		return false;
	}

	@Override
	protected String GetButtonTooltip(int buttonId) {
		return null;
	}

}
