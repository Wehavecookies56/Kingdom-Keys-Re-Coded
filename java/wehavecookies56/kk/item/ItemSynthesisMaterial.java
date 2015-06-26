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
		
		ItemStack Oricalcum = ItemStacks.Oricalcum;
		ItemStack OricalcumPlus = ItemStacks.OricalcumPlus;

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
		//TODO THE REST OF THESE
	}
	
	public void createSynthesisItem(ItemStack stack, String material, String rank, List list){
		stack.setTagCompound(new NBTTagCompound());
		stack.getTagCompound().setString("material", material);
		stack.getTagCompound().setString("rank", rank);
		list.add(stack);
	}

}
