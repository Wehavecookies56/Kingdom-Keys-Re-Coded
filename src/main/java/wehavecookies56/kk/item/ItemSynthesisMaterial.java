package wehavecookies56.kk.item;

import java.util.List;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import wehavecookies56.kk.lib.Strings;
import wehavecookies56.kk.util.TextHelper;

public class ItemSynthesisMaterial extends Item {

	public ItemSynthesisMaterial () {}

	@Override
	public void addInformation (ItemStack stack, EntityPlayer playerIn, List tooltip, boolean advanced) {
		if (stack.hasTagCompound()) {
			String material = stack.getTagCompound().getString("material");
			String rank = stack.getTagCompound().getString("rank");
			tooltip.add(TextHelper.localize(Strings.SM_Rank) + " " + TextHelper.localize(rank) + ": " + TextHelper.localize(material + ".name"));
		}
	}

	@Override
	public void getSubItems (Item itemIn, CreativeTabs tab, List subItems) {
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

		createSynthesisItem(BlazingShard, Strings.SM_BlazingShard, "C", subItems);
		createSynthesisItem(BlazingStone, Strings.SM_BlazingStone, "B", subItems);
		createSynthesisItem(BlazingGem, Strings.SM_BlazingGem, "A", subItems);
		createSynthesisItem(BlazingCrystal, Strings.SM_BlazingCrystal, "S", subItems);

		createSynthesisItem(FrostShard, Strings.SM_FrostShard, "C", subItems);
		createSynthesisItem(FrostStone, Strings.SM_FrostStone, "B", subItems);
		createSynthesisItem(FrostGem, Strings.SM_FrostGem, "A", subItems);
		createSynthesisItem(FrostCrystal, Strings.SM_FrostCrystal, "S", subItems);

		createSynthesisItem(LightningShard, Strings.SM_LightningShard, "C", subItems);
		createSynthesisItem(LightningStone, Strings.SM_LightningStone, "B", subItems);
		createSynthesisItem(LightningGem, Strings.SM_LightningGem, "A", subItems);
		createSynthesisItem(LightningCrystal, Strings.SM_LightningCrystal, "S", subItems);

		createSynthesisItem(LucidShard, Strings.SM_LucidShard, "C", subItems);
		createSynthesisItem(LucidStone, Strings.SM_LucidStone, "B", subItems);
		createSynthesisItem(LucidGem, Strings.SM_LucidGem, "A", subItems);
		createSynthesisItem(LucidCrystal, Strings.SM_LucidCrystal, "S", subItems);

		createSynthesisItem(PowerShard, Strings.SM_PowerShard, "C", subItems);
		createSynthesisItem(PowerStone, Strings.SM_PowerStone, "B", subItems);
		createSynthesisItem(PowerGem, Strings.SM_PowerGem, "A", subItems);
		createSynthesisItem(PowerCrystal, Strings.SM_PowerCrystal, "S", subItems);

		createSynthesisItem(DarkShard, Strings.SM_DarkShard, "C", subItems);
		createSynthesisItem(DarkStone, Strings.SM_DarkStone, "B", subItems);
		createSynthesisItem(DarkGem, Strings.SM_DarkGem, "A", subItems);
		createSynthesisItem(DarkCrystal, Strings.SM_DarkCrystal, "S", subItems);

		createSynthesisItem(DenseShard, Strings.SM_DenseShard, "C", subItems);
		createSynthesisItem(DenseStone, Strings.SM_DenseStone, "B", subItems);
		createSynthesisItem(DenseGem, Strings.SM_DenseGem, "A", subItems);
		createSynthesisItem(DenseCrystal, Strings.SM_DenseCrystal, "S", subItems);

		createSynthesisItem(TwilightShard, Strings.SM_TwilightShard, "C", subItems);
		createSynthesisItem(TwilightStone, Strings.SM_TwilightStone, "B", subItems);
		createSynthesisItem(TwilightGem, Strings.SM_TwilightGem, "A", subItems);
		createSynthesisItem(TwilightCrystal, Strings.SM_TwilightCrystal, "S", subItems);

		createSynthesisItem(MythrilShard, Strings.SM_MythrilShard, "C", subItems);
		createSynthesisItem(MythrilStone, Strings.SM_MythrilStone, "B", subItems);
		createSynthesisItem(MythrilGem, Strings.SM_MythrilGem, "A", subItems);
		createSynthesisItem(MythrilCrystal, Strings.SM_MythrilCrystal, "S", subItems);

		createSynthesisItem(BrightShard, Strings.SM_BrightShard, "C", subItems);
		createSynthesisItem(BrightStone, Strings.SM_BrightStone, "B", subItems);
		createSynthesisItem(BrightGem, Strings.SM_BrightGem, "A", subItems);
		createSynthesisItem(BrightCrystal, Strings.SM_BrightCrystal, "S", subItems);

		createSynthesisItem(EnergyShard, Strings.SM_EnergyShard, "C", subItems);
		createSynthesisItem(EnergyStone, Strings.SM_EnergyStone, "B", subItems);
		createSynthesisItem(EnergyGem, Strings.SM_EnergyGem, "A", subItems);
		createSynthesisItem(EnergyCrystal, Strings.SM_EnergyCrystal, "S", subItems);

		createSynthesisItem(SerenityShard, Strings.SM_SerenityShard, "C", subItems);
		createSynthesisItem(SerenityStone, Strings.SM_SerenityStone, "B", subItems);
		createSynthesisItem(SerenityGem, Strings.SM_SerenityGem, "A", subItems);
		createSynthesisItem(SerenityCrystal, Strings.SM_SerenityCrystal, "S", subItems);

		createSynthesisItem(RemembranceShard, Strings.SM_RemembranceShard, "C", subItems);
		createSynthesisItem(RemembranceStone, Strings.SM_RemembranceStone, "B", subItems);
		createSynthesisItem(RemembranceGem, Strings.SM_RemembranceGem, "A", subItems);
		createSynthesisItem(RemembranceCrystal, Strings.SM_RemembranceCrystal, "S", subItems);

		createSynthesisItem(TranquilShard, Strings.SM_TranquilShard, "C", subItems);
		createSynthesisItem(TranquilStone, Strings.SM_TranquilStone, "B", subItems);
		createSynthesisItem(TranquilGem, Strings.SM_TranquilGem, "A", subItems);
		createSynthesisItem(TranquilCrystal, Strings.SM_TranquilCrystal, "S", subItems);

		createSynthesisItem(Orichalcum, Strings.SM_Orichalcum, "A", subItems);
		createSynthesisItem(OrichalcumPlus, Strings.SM_OrichalcumPlus, "S", subItems);
		createSynthesisItem(ManifestIllusion, Strings.SM_ManifestIllusion, "A", subItems);
		createSynthesisItem(LostIllusion, Strings.SM_LostIllusion, "S", subItems);

		createSynthesisItem(StormyShard, Strings.SM_StormyShard, "C", subItems);
		createSynthesisItem(StormyStone, Strings.SM_StormyStone, "B", subItems);
		createSynthesisItem(StormyGem, Strings.SM_StormyGem, "A", subItems);
		createSynthesisItem(StormyCrystal, Strings.SM_StormyCrystal, "S", subItems);
	}

	public void createSynthesisItem (ItemStack stack, String material, String rank, List list) {
		stack.setTagCompound(new NBTTagCompound());
		stack.getTagCompound().setString("material", material);
		stack.getTagCompound().setString("rank", rank);
		list.add(stack);
	}

}
