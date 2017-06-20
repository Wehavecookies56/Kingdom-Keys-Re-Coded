package uk.co.wehavecookies56.kk.common.item.base;

import java.util.List;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.NonNullList;
import uk.co.wehavecookies56.kk.common.item.ModItems;
import uk.co.wehavecookies56.kk.common.lib.Strings;
import uk.co.wehavecookies56.kk.common.util.Utils;

public class ItemSynthesisMaterial extends Item {

	public ItemSynthesisMaterial () {}

	@Override
	public void addInformation (ItemStack stack, EntityPlayer playerIn, List tooltip, boolean advanced) {
		if (stack.hasTagCompound()) {
			String material = stack.getTagCompound().getString("material");
			String rank = stack.getTagCompound().getString("rank");
			tooltip.add(Utils.translateToLocal(Strings.SM_Rank) + " " + Utils.translateToLocal(rank) + ": " + Utils.translateToLocal(material + ".name"));
		}
	}

	@Override
	public void getSubItems (Item itemIn, CreativeTabs tab, NonNullList subItems) {
		ItemStack BlazingShard = new ItemStack(ModItems.SynthesisMaterial, 1);
		ItemStack BlazingStone = new ItemStack(ModItems.SynthesisMaterial, 1);
		ItemStack BlazingGem = new ItemStack(ModItems.SynthesisMaterial, 1);
		ItemStack BlazingCrystal = new ItemStack(ModItems.SynthesisMaterial, 1);

		ItemStack FrostShard = new ItemStack(ModItems.SynthesisMaterial, 1);
		ItemStack FrostStone = new ItemStack(ModItems.SynthesisMaterial, 1);
		ItemStack FrostGem = new ItemStack(ModItems.SynthesisMaterial, 1);
		ItemStack FrostCrystal = new ItemStack(ModItems.SynthesisMaterial, 1);

		ItemStack LightningShard = new ItemStack(ModItems.SynthesisMaterial, 1);
		ItemStack LightningStone = new ItemStack(ModItems.SynthesisMaterial, 1);
		ItemStack LightningGem = new ItemStack(ModItems.SynthesisMaterial, 1);
		ItemStack LightningCrystal = new ItemStack(ModItems.SynthesisMaterial, 1);

		ItemStack LucidShard = new ItemStack(ModItems.SynthesisMaterial, 1);
		ItemStack LucidStone = new ItemStack(ModItems.SynthesisMaterial, 1);
		ItemStack LucidGem = new ItemStack(ModItems.SynthesisMaterial, 1);
		ItemStack LucidCrystal = new ItemStack(ModItems.SynthesisMaterial, 1);

		ItemStack PowerShard = new ItemStack(ModItems.SynthesisMaterial, 1);
		ItemStack PowerStone = new ItemStack(ModItems.SynthesisMaterial, 1);
		ItemStack PowerGem = new ItemStack(ModItems.SynthesisMaterial, 1);
		ItemStack PowerCrystal = new ItemStack(ModItems.SynthesisMaterial, 1);

		ItemStack DarkShard = new ItemStack(ModItems.SynthesisMaterial, 1);
		ItemStack DarkStone = new ItemStack(ModItems.SynthesisMaterial, 1);
		ItemStack DarkGem = new ItemStack(ModItems.SynthesisMaterial, 1);
		ItemStack DarkCrystal = new ItemStack(ModItems.SynthesisMaterial, 1);

		ItemStack DenseShard = new ItemStack(ModItems.SynthesisMaterial, 1);
		ItemStack DenseStone = new ItemStack(ModItems.SynthesisMaterial, 1);
		ItemStack DenseGem = new ItemStack(ModItems.SynthesisMaterial, 1);
		ItemStack DenseCrystal = new ItemStack(ModItems.SynthesisMaterial, 1);

		ItemStack TwilightShard = new ItemStack(ModItems.SynthesisMaterial, 1);
		ItemStack TwilightStone = new ItemStack(ModItems.SynthesisMaterial, 1);
		ItemStack TwilightGem = new ItemStack(ModItems.SynthesisMaterial, 1);
		ItemStack TwilightCrystal = new ItemStack(ModItems.SynthesisMaterial, 1);

		ItemStack MythrilShard = new ItemStack(ModItems.SynthesisMaterial, 1);
		ItemStack MythrilStone = new ItemStack(ModItems.SynthesisMaterial, 1);
		ItemStack MythrilGem = new ItemStack(ModItems.SynthesisMaterial, 1);
		ItemStack MythrilCrystal = new ItemStack(ModItems.SynthesisMaterial, 1);

		ItemStack BrightShard = new ItemStack(ModItems.SynthesisMaterial, 1);
		ItemStack BrightStone = new ItemStack(ModItems.SynthesisMaterial, 1);
		ItemStack BrightGem = new ItemStack(ModItems.SynthesisMaterial, 1);
		ItemStack BrightCrystal = new ItemStack(ModItems.SynthesisMaterial, 1);

		ItemStack EnergyShard = new ItemStack(ModItems.SynthesisMaterial, 1);
		ItemStack EnergyStone = new ItemStack(ModItems.SynthesisMaterial, 1);
		ItemStack EnergyGem = new ItemStack(ModItems.SynthesisMaterial, 1);
		ItemStack EnergyCrystal = new ItemStack(ModItems.SynthesisMaterial, 1);

		ItemStack SerenityShard = new ItemStack(ModItems.SynthesisMaterial, 1);
		ItemStack SerenityStone = new ItemStack(ModItems.SynthesisMaterial, 1);
		ItemStack SerenityGem = new ItemStack(ModItems.SynthesisMaterial, 1);
		ItemStack SerenityCrystal = new ItemStack(ModItems.SynthesisMaterial, 1);

		ItemStack Orichalcum = new ItemStack(ModItems.SynthesisMaterial, 1);
		ItemStack OrichalcumPlus = new ItemStack(ModItems.SynthesisMaterial, 1);

		ItemStack RemembranceShard = new ItemStack(ModItems.SynthesisMaterial, 1);
		ItemStack RemembranceStone = new ItemStack(ModItems.SynthesisMaterial, 1);
		ItemStack RemembranceGem = new ItemStack(ModItems.SynthesisMaterial, 1);
		ItemStack RemembranceCrystal = new ItemStack(ModItems.SynthesisMaterial, 1);

		ItemStack TranquilShard = new ItemStack(ModItems.SynthesisMaterial, 1);
		ItemStack TranquilStone = new ItemStack(ModItems.SynthesisMaterial, 1);
		ItemStack TranquilGem = new ItemStack(ModItems.SynthesisMaterial, 1);
		ItemStack TranquilCrystal = new ItemStack(ModItems.SynthesisMaterial, 1);

		ItemStack ManifestIllusion = new ItemStack(ModItems.SynthesisMaterial, 1);
		ItemStack LostIllusion = new ItemStack(ModItems.SynthesisMaterial, 1);

		ItemStack StormyShard = new ItemStack(ModItems.SynthesisMaterial, 1);
		ItemStack StormyStone = new ItemStack(ModItems.SynthesisMaterial, 1);
		ItemStack StormyGem = new ItemStack(ModItems.SynthesisMaterial, 1);
		ItemStack StormyCrystal = new ItemStack(ModItems.SynthesisMaterial, 1);

		createSynthesisItem(BlazingShard, Strings.SM_BlazingShard, Strings.SM_Rank_C, subItems);
		createSynthesisItem(BlazingStone, Strings.SM_BlazingStone, Strings.SM_Rank_B, subItems);
		createSynthesisItem(BlazingGem, Strings.SM_BlazingGem, Strings.SM_Rank_A, subItems);
		createSynthesisItem(BlazingCrystal, Strings.SM_BlazingCrystal, Strings.SM_Rank_S, subItems);

		createSynthesisItem(FrostShard, Strings.SM_FrostShard, Strings.SM_Rank_C, subItems);
		createSynthesisItem(FrostStone, Strings.SM_FrostStone, Strings.SM_Rank_B, subItems);
		createSynthesisItem(FrostGem, Strings.SM_FrostGem, Strings.SM_Rank_A, subItems);
		createSynthesisItem(FrostCrystal, Strings.SM_FrostCrystal, Strings.SM_Rank_S, subItems);

		createSynthesisItem(LightningShard, Strings.SM_LightningShard, Strings.SM_Rank_C, subItems);
		createSynthesisItem(LightningStone, Strings.SM_LightningStone, Strings.SM_Rank_B, subItems);
		createSynthesisItem(LightningGem, Strings.SM_LightningGem, Strings.SM_Rank_A, subItems);
		createSynthesisItem(LightningCrystal, Strings.SM_LightningCrystal, Strings.SM_Rank_S, subItems);

		createSynthesisItem(LucidShard, Strings.SM_LucidShard, Strings.SM_Rank_C, subItems);
		createSynthesisItem(LucidStone, Strings.SM_LucidStone, Strings.SM_Rank_B, subItems);
		createSynthesisItem(LucidGem, Strings.SM_LucidGem, Strings.SM_Rank_A, subItems);
		createSynthesisItem(LucidCrystal, Strings.SM_LucidCrystal, Strings.SM_Rank_S, subItems);

		createSynthesisItem(PowerShard, Strings.SM_PowerShard, Strings.SM_Rank_C, subItems);
		createSynthesisItem(PowerStone, Strings.SM_PowerStone, Strings.SM_Rank_B, subItems);
		createSynthesisItem(PowerGem, Strings.SM_PowerGem, Strings.SM_Rank_A, subItems);
		createSynthesisItem(PowerCrystal, Strings.SM_PowerCrystal, Strings.SM_Rank_S, subItems);

		createSynthesisItem(DarkShard, Strings.SM_DarkShard, Strings.SM_Rank_C, subItems);
		createSynthesisItem(DarkStone, Strings.SM_DarkStone, Strings.SM_Rank_B, subItems);
		createSynthesisItem(DarkGem, Strings.SM_DarkGem, Strings.SM_Rank_A, subItems);
		createSynthesisItem(DarkCrystal, Strings.SM_DarkCrystal, Strings.SM_Rank_S, subItems);

		createSynthesisItem(DenseShard, Strings.SM_DenseShard, Strings.SM_Rank_C, subItems);
		createSynthesisItem(DenseStone, Strings.SM_DenseStone, Strings.SM_Rank_B, subItems);
		createSynthesisItem(DenseGem, Strings.SM_DenseGem, Strings.SM_Rank_A, subItems);
		createSynthesisItem(DenseCrystal, Strings.SM_DenseCrystal, Strings.SM_Rank_S, subItems);

		createSynthesisItem(TwilightShard, Strings.SM_TwilightShard, Strings.SM_Rank_C, subItems);
		createSynthesisItem(TwilightStone, Strings.SM_TwilightStone, Strings.SM_Rank_B, subItems);
		createSynthesisItem(TwilightGem, Strings.SM_TwilightGem, Strings.SM_Rank_A, subItems);
		createSynthesisItem(TwilightCrystal, Strings.SM_TwilightCrystal, Strings.SM_Rank_S, subItems);

		createSynthesisItem(MythrilShard, Strings.SM_MythrilShard, Strings.SM_Rank_C, subItems);
		createSynthesisItem(MythrilStone, Strings.SM_MythrilStone, Strings.SM_Rank_B, subItems);
		createSynthesisItem(MythrilGem, Strings.SM_MythrilGem, Strings.SM_Rank_A, subItems);
		createSynthesisItem(MythrilCrystal, Strings.SM_MythrilCrystal, Strings.SM_Rank_S, subItems);

		createSynthesisItem(BrightShard, Strings.SM_BrightShard, Strings.SM_Rank_C, subItems);
		createSynthesisItem(BrightStone, Strings.SM_BrightStone, Strings.SM_Rank_B, subItems);
		createSynthesisItem(BrightGem, Strings.SM_BrightGem, Strings.SM_Rank_A, subItems);
		createSynthesisItem(BrightCrystal, Strings.SM_BrightCrystal, Strings.SM_Rank_S, subItems);

		createSynthesisItem(EnergyShard, Strings.SM_EnergyShard, Strings.SM_Rank_C, subItems);
		createSynthesisItem(EnergyStone, Strings.SM_EnergyStone, Strings.SM_Rank_B, subItems);
		createSynthesisItem(EnergyGem, Strings.SM_EnergyGem, Strings.SM_Rank_A, subItems);
		createSynthesisItem(EnergyCrystal, Strings.SM_EnergyCrystal, Strings.SM_Rank_S, subItems);

		createSynthesisItem(SerenityShard, Strings.SM_SerenityShard, Strings.SM_Rank_C, subItems);
		createSynthesisItem(SerenityStone, Strings.SM_SerenityStone, Strings.SM_Rank_B, subItems);
		createSynthesisItem(SerenityGem, Strings.SM_SerenityGem, Strings.SM_Rank_A, subItems);
		createSynthesisItem(SerenityCrystal, Strings.SM_SerenityCrystal, Strings.SM_Rank_S, subItems);

		createSynthesisItem(RemembranceShard, Strings.SM_RemembranceShard, Strings.SM_Rank_C, subItems);
		createSynthesisItem(RemembranceStone, Strings.SM_RemembranceStone, Strings.SM_Rank_B, subItems);
		createSynthesisItem(RemembranceGem, Strings.SM_RemembranceGem, Strings.SM_Rank_A, subItems);
		createSynthesisItem(RemembranceCrystal, Strings.SM_RemembranceCrystal, Strings.SM_Rank_S, subItems);

		createSynthesisItem(TranquilShard, Strings.SM_TranquilShard, Strings.SM_Rank_C, subItems);
		createSynthesisItem(TranquilStone, Strings.SM_TranquilStone, Strings.SM_Rank_B, subItems);
		createSynthesisItem(TranquilGem, Strings.SM_TranquilGem, Strings.SM_Rank_A, subItems);
		createSynthesisItem(TranquilCrystal, Strings.SM_TranquilCrystal, Strings.SM_Rank_S, subItems);

		createSynthesisItem(Orichalcum, Strings.SM_Orichalcum, Strings.SM_Rank_A, subItems);
		createSynthesisItem(OrichalcumPlus, Strings.SM_OrichalcumPlus, Strings.SM_Rank_S, subItems);
		createSynthesisItem(ManifestIllusion, Strings.SM_ManifestIllusion, Strings.SM_Rank_A, subItems);
		createSynthesisItem(LostIllusion, Strings.SM_LostIllusion, Strings.SM_Rank_S, subItems);

		createSynthesisItem(StormyShard, Strings.SM_StormyShard, Strings.SM_Rank_C, subItems);
		createSynthesisItem(StormyStone, Strings.SM_StormyStone, Strings.SM_Rank_B, subItems);
		createSynthesisItem(StormyGem, Strings.SM_StormyGem, Strings.SM_Rank_A, subItems);
		createSynthesisItem(StormyCrystal, Strings.SM_StormyCrystal, Strings.SM_Rank_S, subItems);
	}

	public void createSynthesisItem (ItemStack stack, String material, String rank, List list) {
		stack.setTagCompound(new NBTTagCompound());
		stack.getTagCompound().setString("material", material);
		stack.getTagCompound().setString("rank", rank);
		list.add(stack);
	}
	
	@Override
	public EnumRarity getRarity (ItemStack stack) {
		if(stack.hasTagCompound()){
			if(stack.getTagCompound().hasKey("material")){
				switch(stack.getTagCompound().getString("material")){
					case Strings.SM_BlazingShard:
						return EnumRarity.COMMON;
					case Strings.SM_BlazingStone:
						return EnumRarity.UNCOMMON;
					case Strings.SM_BlazingGem:
						return EnumRarity.RARE;
					case Strings.SM_BlazingCrystal:
						return EnumRarity.EPIC;
					case Strings.SM_FrostShard:
						return EnumRarity.COMMON;
					case Strings.SM_FrostStone:
						return EnumRarity.UNCOMMON;
					case Strings.SM_FrostGem:
						return EnumRarity.RARE;
					case Strings.SM_FrostCrystal:
						return EnumRarity.EPIC;
					case Strings.SM_LightningShard:
						return EnumRarity.COMMON;
					case Strings.SM_LightningStone:
						return EnumRarity.UNCOMMON;
					case Strings.SM_LightningGem:
						return EnumRarity.RARE;
					case Strings.SM_LightningCrystal:
						return EnumRarity.EPIC;
					case Strings.SM_LucidShard:
						return EnumRarity.COMMON;
					case Strings.SM_LucidStone:
						return EnumRarity.UNCOMMON;
					case Strings.SM_LucidGem:
						return EnumRarity.RARE;
					case Strings.SM_LucidCrystal:
						return EnumRarity.EPIC;
					case Strings.SM_PowerShard:
						return EnumRarity.COMMON;
					case Strings.SM_PowerStone:
						return EnumRarity.UNCOMMON;
					case Strings.SM_PowerGem:
						return EnumRarity.RARE;
					case Strings.SM_PowerCrystal:
						return EnumRarity.EPIC;
					case Strings.SM_DarkShard:
						return EnumRarity.COMMON;
					case Strings.SM_DarkStone:
						return EnumRarity.UNCOMMON;
					case Strings.SM_DarkGem:
						return EnumRarity.RARE;
					case Strings.SM_DarkCrystal:
						return EnumRarity.EPIC;
					case Strings.SM_DenseShard:
						return EnumRarity.COMMON;
					case Strings.SM_DenseStone:
						return EnumRarity.UNCOMMON;
					case Strings.SM_DenseGem:
						return EnumRarity.RARE;
					case Strings.SM_DenseCrystal:
						return EnumRarity.EPIC;
					case Strings.SM_TwilightShard:
						return EnumRarity.COMMON;
					case Strings.SM_TwilightStone:
						return EnumRarity.UNCOMMON;
					case Strings.SM_TwilightGem:
						return EnumRarity.RARE;
					case Strings.SM_TwilightCrystal:
						return EnumRarity.EPIC;
					case Strings.SM_MythrilShard:
						return EnumRarity.COMMON;
					case Strings.SM_MythrilStone:
						return EnumRarity.UNCOMMON;
					case Strings.SM_MythrilGem:
						return EnumRarity.RARE;
					case Strings.SM_MythrilCrystal:
						return EnumRarity.EPIC;
					case Strings.SM_BrightShard:
						return EnumRarity.COMMON;
					case Strings.SM_BrightStone:
						return EnumRarity.UNCOMMON;
					case Strings.SM_BrightGem:
						return EnumRarity.RARE;
					case Strings.SM_BrightCrystal:
						return EnumRarity.EPIC;
					case Strings.SM_EnergyShard:
						return EnumRarity.COMMON;
					case Strings.SM_EnergyStone:
						return EnumRarity.UNCOMMON;
					case Strings.SM_EnergyGem:
						return EnumRarity.RARE;
					case Strings.SM_EnergyCrystal:
						return EnumRarity.EPIC;
					case Strings.SM_SerenityShard:
						return EnumRarity.COMMON;
					case Strings.SM_SerenityStone:
						return EnumRarity.UNCOMMON;
					case Strings.SM_SerenityGem:
						return EnumRarity.RARE;
					case Strings.SM_SerenityCrystal:
						return EnumRarity.EPIC;
					case Strings.SM_Orichalcum:
						return EnumRarity.RARE;
					case Strings.SM_OrichalcumPlus:
						return EnumRarity.EPIC;
					case Strings.SM_RemembranceShard:
						return EnumRarity.COMMON;
					case Strings.SM_RemembranceStone:
						return EnumRarity.UNCOMMON;
					case Strings.SM_RemembranceGem:
						return EnumRarity.RARE;
					case Strings.SM_RemembranceCrystal:
						return EnumRarity.EPIC;
					case Strings.SM_TranquilShard:
						return EnumRarity.COMMON;
					case Strings.SM_TranquilStone:
						return EnumRarity.UNCOMMON;
					case Strings.SM_TranquilGem:
						return EnumRarity.RARE;
					case Strings.SM_TranquilCrystal:
						return EnumRarity.EPIC;
					case Strings.SM_ManifestIllusion:
						return EnumRarity.RARE;
					case Strings.SM_LostIllusion:
						return EnumRarity.EPIC;
					case Strings.SM_StormyShard:
						return EnumRarity.COMMON;
					case Strings.SM_StormyStone:
						return EnumRarity.UNCOMMON;
					case Strings.SM_StormyGem:
						return EnumRarity.RARE;
					case Strings.SM_StormyCrystal:
						return EnumRarity.EPIC;
				}
			}
		}
		return EnumRarity.COMMON;
	}

}
