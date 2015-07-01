package wehavecookies56.kk.item;

import java.util.List;
import java.util.Stack;

import wehavecookies56.kk.lib.Strings;
import wehavecookies56.kk.util.TextHelper;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;

public class ItemSynthesisMaterial extends Item {
		
	public ItemSynthesisMaterial() {}
	
	@Override
	public void addInformation(ItemStack stack, EntityPlayer playerIn, List tooltip, boolean advanced) {
		if(stack.hasTagCompound())
		{
			String material = stack.getTagCompound().getString("material");
			String rank = stack.getTagCompound().getString("rank");
			tooltip.add(TextHelper.localize(rank) + ": " + TextHelper.localize(material));
		}
	}
	
	@Override
	public void getSubItems(Item itemIn, CreativeTabs tab, List subItems) {
		ItemStack BlazingShard = ItemStacks.BlazingShard;
		ItemStack BlazingStone = ItemStacks.BlazingStone;
		ItemStack BlazingGem = ItemStacks.BlazingGem;
		ItemStack BlazingCrystal = ItemStacks.BlazingCrystal;
		
		ItemStack FrostShard = ItemStacks.FrostShard;
		ItemStack FrostStone = ItemStacks.FrostStone;
		ItemStack FrostGem = ItemStacks.FrostGem;
		ItemStack FrostCrystal = ItemStacks.FrostCrystal;
		
		ItemStack LightningShard = ItemStacks.LightningShard;
		ItemStack LightningStone = ItemStacks.LightningStone;
		ItemStack LightningGem = ItemStacks.LightningGem;
		ItemStack LightningCrystal = ItemStacks.LightningCrystal;
		
		ItemStack LucidShard = ItemStacks.LucidShard;
		ItemStack LucidStone = ItemStacks.LucidStone;
		ItemStack LucidGem = ItemStacks.LucidGem;
		ItemStack LucidCrystal = ItemStacks.LucidCrystal;
		
		ItemStack PowerShard = ItemStacks.PowerShard;
		ItemStack PowerStone = ItemStacks.PowerStone;
		ItemStack PowerGem = ItemStacks.PowerGem;
		ItemStack PowerCrystal = ItemStacks.PowerCrystal;
		
		ItemStack DarkShard = ItemStacks.DarkShard;
		ItemStack DarkStone = ItemStacks.DarkStone;
		ItemStack DarkGem = ItemStacks.DarkGem;
		ItemStack DarkCrystal = ItemStacks.DarkCrystal;
		
		ItemStack DenseShard = ItemStacks.DenseShard;
		ItemStack DenseStone = ItemStacks.DenseStone;
		ItemStack DenseGem = ItemStacks.DenseGem;
		ItemStack DenseCrystal = ItemStacks.DenseCrystal;
		
		ItemStack TwilightShard = ItemStacks.TwilightShard;
		ItemStack TwilightStone = ItemStacks.TwilightStone;
		ItemStack TwilightGem = ItemStacks.TwilightGem;
		ItemStack TwilightCrystal = ItemStacks.TwilightCrystal;
		
		ItemStack MythrilShard = ItemStacks.MythrilShard;
		ItemStack MythrilStone = ItemStacks.MythrilStone;
		ItemStack MythrilGem = ItemStacks.MythrilGem;
		ItemStack MythrilCrystal = ItemStacks.MythrilCrystal;
		
		ItemStack BrightShard = ItemStacks.BrightShard;
		ItemStack BrightStone = ItemStacks.BrightStone;
		ItemStack BrightGem = ItemStacks.BrightGem;
		ItemStack BrightCrystal = ItemStacks.BrightCrystal;
		
		ItemStack EnergyShard = ItemStacks.EnergyShard;
		ItemStack EnergyStone = ItemStacks.EnergyStone;
		ItemStack EnergyGem = ItemStacks.EnergyGem;
		ItemStack EnergyCrystal = ItemStacks.EnergyCrystal;
		
		ItemStack SerenityShard = ItemStacks.SerenityShard;
		ItemStack SerenityStone = ItemStacks.SerenityStone;
		ItemStack SerenityGem = ItemStacks.SerenityGem;
		ItemStack SerenityCrystal = ItemStacks.SerenityCrystal;
		
		ItemStack Orichalcum = ItemStacks.Oricalcum;
		ItemStack OrichalcumPlus = ItemStacks.OricalcumPlus;

		ItemStack RemembranceShard = ItemStacks.RemembranceShard;
		ItemStack RemembranceStone = ItemStacks.RemembranceStone;
		ItemStack RemembranceGem = ItemStacks.RemembranceGem;
		ItemStack RemembranceCrystal = ItemStacks.RemembranceCrystal;
		
		ItemStack TranquilShard = ItemStacks.TranquilShard;
		ItemStack TranquilStone = ItemStacks.TranquilStone;
		ItemStack TranquilGem = ItemStacks.TranquilGem;
		ItemStack TranquilCrystal = ItemStacks.TranquilCrystal;
		
		ItemStack ManifestIllusion = ItemStacks.ManifestIllusion;
		ItemStack LostIllusion = ItemStacks.LostIllusion;
		
		createSynthesisItem(BlazingShard, "Blazing Shard", "Rank C", subItems);
		createSynthesisItem(BlazingStone, "Blazing Stone", "Rank B", subItems);
		createSynthesisItem(BlazingGem, "Blazing Gem", "Rank A", subItems);
		createSynthesisItem(BlazingCrystal, "Blazing Crystal", "Rank S", subItems);
		
		createSynthesisItem(FrostShard, "Frost Shard", "Rank C", subItems);
		createSynthesisItem(FrostStone, "Frost Stone", "Rank B", subItems);
		createSynthesisItem(FrostGem, "Frost Gem", "Rank A", subItems);
		createSynthesisItem(FrostCrystal, "Frost Crystal", "Rank S", subItems);
		
		createSynthesisItem(LightningShard, "Lightning Shard", "Rank C", subItems);
		createSynthesisItem(LightningStone, "Lightning Stone", "Rank B", subItems);
		createSynthesisItem(LightningGem, "Lightning Gem", "Rank A", subItems);
		createSynthesisItem(LightningCrystal, "Lightning Crystal", "Rank S", subItems);
		
		createSynthesisItem(LucidShard, "Lucid Shard", "Rank C", subItems);
		createSynthesisItem(LucidStone, "Lucid Stone", "Rank B", subItems);
		createSynthesisItem(LucidGem, "Lucid Gem", "Rank A", subItems);
		createSynthesisItem(LucidCrystal, "Lucid Crystal", "Rank S", subItems);

		createSynthesisItem(PowerShard, "Power Shard", "Rank C", subItems);
		createSynthesisItem(PowerStone, "Power Stone", "Rank B", subItems);
		createSynthesisItem(PowerGem, "Power Gem", "Rank A", subItems);
		createSynthesisItem(PowerCrystal, "Power Crystal", "Rank S", subItems);

		createSynthesisItem(DarkShard, "Dark Shard", "Rank C", subItems);
		createSynthesisItem(DarkStone, "Dark Stone", "Rank B", subItems);
		createSynthesisItem(DarkGem, "Dark Gem", "Rank A", subItems);
		createSynthesisItem(DarkCrystal, "Dark Crystal", "Rank S", subItems);

		createSynthesisItem(DenseShard, "Dense Shard", "Rank C", subItems);
		createSynthesisItem(DenseStone, "Dense Stone", "Rank B", subItems);
		createSynthesisItem(DenseGem, "Dense Gem", "Rank A", subItems);
		createSynthesisItem(DenseCrystal, "Dense Crystal", "Rank S", subItems);

		createSynthesisItem(TwilightShard, "Twilight Shard", "Rank C", subItems);
		createSynthesisItem(TwilightStone, "Twilight Stone", "Rank B", subItems);
		createSynthesisItem(TwilightGem, "Twilight Gem", "Rank A", subItems);
		createSynthesisItem(TwilightCrystal, "Twilight Crystal", "Rank S", subItems);

		createSynthesisItem(MythrilShard, "Mythril Shard", "Rank C", subItems);
		createSynthesisItem(MythrilStone, "Mythril Stone", "Rank B", subItems);
		createSynthesisItem(MythrilGem, "Mythril Gem", "Rank A", subItems);
		createSynthesisItem(MythrilCrystal, "Mythril Crystal", "Rank S", subItems);
		
		createSynthesisItem(BrightShard, "Bright Shard", "Rank C", subItems);
		createSynthesisItem(BrightStone, "Bright Stone", "Rank B", subItems);
		createSynthesisItem(BrightGem, "Bright Gem", "Rank A", subItems);
		createSynthesisItem(BrightCrystal, "Bright Crystal", "Rank S", subItems);
		
		createSynthesisItem(EnergyShard, "Energy Shard", "Rank C", subItems);
		createSynthesisItem(EnergyStone, "Energy Stone", "Rank B", subItems);
		createSynthesisItem(EnergyGem, "Energy Gem", "Rank A", subItems);
		createSynthesisItem(EnergyCrystal, "Energy Crystal", "Rank S", subItems);
		
		createSynthesisItem(SerenityShard, "Serenity Shard", "Rank C", subItems);
		createSynthesisItem(SerenityStone, "Serenity Stone", "Rank B", subItems);
		createSynthesisItem(SerenityGem, "Serenity Gem", "Rank A", subItems);
		createSynthesisItem(SerenityCrystal, "Serenity Crystal", "Rank S", subItems);
		
		createSynthesisItem(RemembranceShard, "Remembrance Shard", "Rank C", subItems);
		createSynthesisItem(RemembranceStone, "Remembrance Stone", "Rank B", subItems);
		createSynthesisItem(RemembranceGem, "Remembrance Gem", "Rank A", subItems);
		createSynthesisItem(RemembranceCrystal, "Remembrance Crystal", "Rank S", subItems);
		
		createSynthesisItem(TranquilShard, "Tranquil Shard", "Rank C", subItems);
		createSynthesisItem(TranquilStone, "Tranquil Stone", "Rank B", subItems);
		createSynthesisItem(TranquilGem, "Tranquil Gem", "Rank A", subItems);
		createSynthesisItem(TranquilCrystal, "Tranquil Crystal", "Rank S", subItems);
		
		createSynthesisItem(Orichalcum, "Orichalcum", "Rank A", subItems);
		createSynthesisItem(OrichalcumPlus, "Orichalcum +", "Rank S", subItems);
		createSynthesisItem(ManifestIllusion, "ManifestIllusion", "Rank A", subItems);
		createSynthesisItem(LostIllusion, "Lost Illusion", "Rank S", subItems);
	}
	
	public void createSynthesisItem(ItemStack stack, String material, String rank, List list){
		stack.setTagCompound(new NBTTagCompound());
		stack.getTagCompound().setString("material", material);
		stack.getTagCompound().setString("rank", rank);
		list.add(stack);
	}

}
