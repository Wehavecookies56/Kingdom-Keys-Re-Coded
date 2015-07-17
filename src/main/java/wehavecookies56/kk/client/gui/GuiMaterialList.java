package wehavecookies56.kk.client.gui;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.entity.RenderItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.fml.client.GuiScrollingList;
import wehavecookies56.kk.entities.ExtendedPlayerMaterials;
import wehavecookies56.kk.lib.Strings;
import wehavecookies56.kk.util.TextHelper;

public class GuiMaterialList extends GuiScrollingList {

	private GuiSynthesis parent;

	FontRenderer f = Minecraft.getMinecraft().fontRendererObj;
	RenderItem ir = Minecraft.getMinecraft().getRenderItem();
	static ScaledResolution sr = new ScaledResolution(Minecraft.getMinecraft(), Minecraft.getMinecraft().displayWidth, Minecraft.getMinecraft().displayHeight);
	static int width = sr.getScaledWidth();
	static int height = sr.getScaledHeight();
	static int sizeX = 150;
	static int posX = 5;
	static int posY = (height-200)/2;

	public GuiMaterialList(GuiSynthesis parent){
		super(parent.mc, 150, 300, 60, parent.height - ((parent.height/8)+70/16), 8, 35);
		this.parent = parent;
	}

	public static List<String> materials = new ArrayList<String>();

	//NEVER CHANGE THESE VALUES
	public static final int
	Index_BlazingShard = 0,
	Index_BlazingStone = 1,
	Index_BlazingGem = 2,
	Index_BlazingCrystal = 3,
	Index_BrightShard = 4,
	Index_BrightStone = 5,
	Index_BrightGem = 6,
	Index_BrightCrystal = 7,
	Index_DarkShard = 8,
	Index_DarkStone = 9,
	Index_DarkGem = 10,
	Index_DarkCrystal = 11,
	Index_DenseShard = 12,
	Index_DenseStone = 13,
	Index_DenseGem = 14,
	Index_DenseCrystal = 15,
	Index_EnergyShard = 16,
	Index_EnergyStone = 17,
	Index_EnergyGem = 18,
	Index_EnergyCrystal = 19,
	Index_FrostShard = 20,
	Index_FrostStone = 21,
	Index_FrostGem = 22,
	Index_FrostCrystal = 23,
	Index_LightningShard = 24,
	Index_LightningStone = 25,
	Index_LightningGem = 26,
	Index_LightningCrystal = 27,
	Index_LostIllusion = 28,
	Index_LucidShard = 29,
	Index_LucidStone = 30,
	Index_LucidGem = 31,
	Index_LucidCrystal = 32,
	Index_ManifestIllusion = 33,
	Index_MythrilShard = 34,
	Index_MythrilStone = 35,
	Index_MythrilGem = 36,
	Index_MythrilCrystal = 37,
	Index_Orichalcum = 38,
	Index_OrichalcumPlus = 39,
	Index_PowerShard = 40,
	Index_PowerStone = 41,
	Index_PowerGem = 42,
	Index_PowerCrystal = 43,
	Index_RemembranceShard = 44,
	Index_RemembranceStone = 45,
	Index_RemembranceGem = 46,
	Index_RemembranceCrystal = 47,
	Index_SerenityShard = 48,
	Index_SerenityStone = 49,
	Index_SerenityGem = 50,
	Index_SerenityCrystal = 51,
	Index_TranquilShard = 52,
	Index_TranquilStone = 53,
	Index_TranquilGem = 54,
	Index_TranquilCrystal = 55,
	Index_TwilightShard = 56,
	Index_TwilightStone = 57,
	Index_TwilightGem = 58,
	Index_TwilightCrystal = 59,
	Index_StormyShard = 60,
	Index_StormyStone = 61,
	Index_StormyGem = 62,
	Index_StormyCrystal = 63
	;

	public static void addMaterials(EntityPlayer player){

		ExtendedPlayerMaterials props = ExtendedPlayerMaterials.get(player);

		if(!materials.contains(Strings.SM_BlazingShard)){
			materials.add(Index_BlazingShard, Strings.SM_BlazingShard);
		}
		if(!materials.contains(Strings.SM_BlazingStone)){
			materials.add(Index_BlazingStone, Strings.SM_BlazingStone);
		}
		if(!materials.contains(Strings.SM_BlazingGem)){
			materials.add(Index_BlazingGem, Strings.SM_BlazingGem);
		}
		if(!materials.contains(Strings.SM_BlazingCrystal)){
			materials.add(Index_BlazingCrystal, Strings.SM_BlazingCrystal);
		}

		if(!materials.contains(Strings.SM_BrightShard)){
			materials.add(Index_BrightShard, Strings.SM_BrightShard);
		}
		if(!materials.contains(Strings.SM_BrightStone)){
			materials.add(Index_BrightStone, Strings.SM_BrightStone);
		}
		if(!materials.contains(Strings.SM_BrightGem)){
			materials.add(Index_BrightGem, Strings.SM_BrightGem);
		}
		if(!materials.contains(Strings.SM_BrightCrystal)){
			materials.add(Index_BrightCrystal, Strings.SM_BrightCrystal);
		}

		if(!materials.contains(Strings.SM_DarkShard)){
			materials.add(Index_DarkShard, Strings.SM_DarkShard);
		}
		if(!materials.contains(Strings.SM_DarkStone)){
			materials.add(Index_DarkStone, Strings.SM_DarkStone);
		}
		if(!materials.contains(Strings.SM_DarkGem)){
			materials.add(Index_DarkGem, Strings.SM_DarkGem);
		}
		if(!materials.contains(Strings.SM_DarkCrystal)){
			materials.add(Index_DarkCrystal, Strings.SM_DarkCrystal);
		}

		if(!materials.contains(Strings.SM_DenseShard)){
			materials.add(Index_DenseShard, Strings.SM_DenseShard);
		}
		if(!materials.contains(Strings.SM_DenseStone)){
			materials.add(Index_DenseStone, Strings.SM_DenseStone);
		}
		if(!materials.contains(Strings.SM_DenseGem)){
			materials.add(Index_DenseGem, Strings.SM_DenseGem);
		}
		if(!materials.contains(Strings.SM_DenseCrystal)){
			materials.add(Index_DenseCrystal, Strings.SM_DenseCrystal);
		}

		if(!materials.contains(Strings.SM_EnergyShard)){
			materials.add(Index_EnergyShard, Strings.SM_EnergyShard);
		}
		if(!materials.contains(Strings.SM_EnergyStone)){
			materials.add(Index_EnergyStone, Strings.SM_EnergyStone);
		}
		if(!materials.contains(Strings.SM_EnergyGem)){
			materials.add(Index_EnergyGem, Strings.SM_EnergyGem);
		}
		if(!materials.contains(Strings.SM_EnergyCrystal)){
			materials.add(Index_EnergyCrystal, Strings.SM_EnergyCrystal);
		}

		if(!materials.contains(Strings.SM_FrostShard)){
			materials.add(Index_FrostShard, Strings.SM_FrostShard);
		}
		if(!materials.contains(Strings.SM_FrostStone)){
			materials.add(Index_FrostStone, Strings.SM_FrostStone);
		}
		if(!materials.contains(Strings.SM_FrostGem)){
			materials.add(Index_FrostGem, Strings.SM_FrostGem);
		}
		if(!materials.contains(Strings.SM_FrostCrystal)){
			materials.add(Index_FrostCrystal, Strings.SM_FrostCrystal);
		}

		if(!materials.contains(Strings.SM_LightningShard)){
			materials.add(Index_LightningShard, Strings.SM_LightningShard);
		}
		if(!materials.contains(Strings.SM_LightningStone)){
			materials.add(Index_LightningStone, Strings.SM_LightningStone);
		}
		if(!materials.contains(Strings.SM_LightningGem)){
			materials.add(Index_LightningGem, Strings.SM_LightningGem);
		}
		if(!materials.contains(Strings.SM_LightningCrystal)){
			materials.add(Index_LightningCrystal, Strings.SM_LightningCrystal);
		}

		if(!materials.contains(Strings.SM_LostIllusion)){
			materials.add(Index_LostIllusion, Strings.SM_LostIllusion);
		}

		if(!materials.contains(Strings.SM_LucidShard)){
			materials.add(Index_LucidShard, Strings.SM_LucidShard);
		}
		if(!materials.contains(Strings.SM_LucidStone)){
			materials.add(Index_LucidStone, Strings.SM_LucidStone);
		}
		if(!materials.contains(Strings.SM_LucidGem)){
			materials.add(Index_LucidGem, Strings.SM_LucidGem);
		}
		if(!materials.contains(Strings.SM_LucidCrystal)){
			materials.add(Index_LucidCrystal, Strings.SM_LucidCrystal);
		}

		if(!materials.contains(Strings.SM_ManifestIllusion)){
			materials.add(Index_ManifestIllusion, Strings.SM_ManifestIllusion);
		}

		if(!materials.contains(Strings.SM_MythrilShard)){
			materials.add(Index_MythrilShard, Strings.SM_MythrilShard);
		}
		if(!materials.contains(Strings.SM_MythrilStone)){
			materials.add(Index_MythrilStone, Strings.SM_MythrilStone);
		}
		if(!materials.contains(Strings.SM_MythrilGem)){
			materials.add(Index_MythrilGem, Strings.SM_MythrilGem);
		}
		if(!materials.contains(Strings.SM_MythrilCrystal)){
			materials.add(Index_MythrilCrystal, Strings.SM_MythrilCrystal);
		}

		if(!materials.contains(Strings.SM_Orichalcum)){
			materials.add(Index_Orichalcum, Strings.SM_Orichalcum);
		}
		if(!materials.contains(Strings.SM_OrichalcumPlus)){
			materials.add(Index_OrichalcumPlus, Strings.SM_OrichalcumPlus);
		}

		if(!materials.contains(Strings.SM_PowerShard)){
			materials.add(Index_PowerShard, Strings.SM_PowerShard);
		}
		if(!materials.contains(Strings.SM_PowerStone)){
			materials.add(Index_PowerStone, Strings.SM_PowerStone);
		}
		if(!materials.contains(Strings.SM_PowerGem)){
			materials.add(Index_PowerGem, Strings.SM_PowerGem);
		}
		if(!materials.contains(Strings.SM_PowerCrystal)){
			materials.add(Index_PowerCrystal, Strings.SM_PowerCrystal);
		}

		if(!materials.contains(Strings.SM_RemembranceShard)){
			materials.add(Index_RemembranceShard, Strings.SM_RemembranceShard);
		}
		if(!materials.contains(Strings.SM_RemembranceStone)){
			materials.add(Index_RemembranceStone, Strings.SM_RemembranceStone);
		}
		if(!materials.contains(Strings.SM_RemembranceGem)){
			materials.add(Index_RemembranceGem, Strings.SM_RemembranceGem);
		}
		if(!materials.contains(Strings.SM_RemembranceCrystal)){
			materials.add(Index_RemembranceCrystal, Strings.SM_RemembranceCrystal);
		}

		if(!materials.contains(Strings.SM_SerenityShard)){
			materials.add(Index_SerenityShard, Strings.SM_SerenityShard);
		}
		if(!materials.contains(Strings.SM_SerenityStone)){
			materials.add(Index_SerenityStone, Strings.SM_SerenityStone);
		}
		if(!materials.contains(Strings.SM_SerenityGem)){
			materials.add(Index_SerenityGem, Strings.SM_SerenityGem);
		}
		if(!materials.contains(Strings.SM_SerenityCrystal)){
			materials.add(Index_SerenityCrystal, Strings.SM_SerenityCrystal);
		}

		if(!materials.contains(Strings.SM_TranquilShard)){
			materials.add(Index_TranquilShard, Strings.SM_TranquilShard);
		}
		if(!materials.contains(Strings.SM_TranquilStone)){
			materials.add(Index_TranquilStone, Strings.SM_TranquilStone);
		}
		if(!materials.contains(Strings.SM_TranquilGem)){
			materials.add(Index_TranquilGem, Strings.SM_TranquilGem);
		}
		if(!materials.contains(Strings.SM_TranquilCrystal)){
			materials.add(Index_TranquilCrystal, Strings.SM_TranquilCrystal);
		}

		if(!materials.contains(Strings.SM_TwilightShard)){
			materials.add(Index_TwilightShard, Strings.SM_TwilightShard);
		}
		if(!materials.contains(Strings.SM_TwilightStone)){
			materials.add(Index_TwilightStone, Strings.SM_TwilightStone);
		}
		if(!materials.contains(Strings.SM_TwilightGem)){
			materials.add(Index_TwilightGem, Strings.SM_TwilightGem);
		}
		if(!materials.contains(Strings.SM_TwilightCrystal)){
			materials.add(Index_TwilightCrystal, Strings.SM_TwilightCrystal);
		}

		if(!materials.contains(Strings.SM_StormyShard)){
			materials.add(Index_StormyShard, Strings.SM_StormyShard);
		}
		if(!materials.contains(Strings.SM_StormyStone)){
			materials.add(Index_StormyStone, Strings.SM_StormyStone);
		}
		if(!materials.contains(Strings.SM_StormyGem)){
			materials.add(Index_StormyGem, Strings.SM_StormyGem);
		}
		if(!materials.contains(Strings.SM_StormyCrystal)){
			materials.add(Index_StormyCrystal, Strings.SM_StormyCrystal);
		}

	}

	@Override
	protected int getSize(){
		return materials.size();
	}

	@Override
	protected void elementClicked(int index, boolean doubleClick){}

	@Override
	protected boolean isSelected(int index){
		return false;
	}

	@Override
	protected void drawBackground(){}

	@Override
	protected void drawSlot(int var1, int var2, int var3, int var4, Tessellator var5)
	{
		ExtendedPlayerMaterials props = ExtendedPlayerMaterials.get(Minecraft.getMinecraft().thePlayer);

		this.f.drawString(f.trimStringToWidth(TextHelper.localize(materials.get(var1) + ".name") + " x" + props.arrayOfAmounts[var1], listWidth - 10), this.left + 3, var3 + 2, 0xFFFFFF);

	}
}
