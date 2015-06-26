package wehavecookies56.kk.item;

import java.util.List;

import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;

public class ItemStacks {

	public static ItemStack BlazingShard = new ItemStack(ModItems.SynthesisMaterial, 1);
	public static ItemStack BlazingStone = new ItemStack(ModItems.SynthesisMaterial, 1);
	public static ItemStack BlazingGem = new ItemStack(ModItems.SynthesisMaterial, 1);
	public static ItemStack BlazingCrystal = new ItemStack(ModItems.SynthesisMaterial, 1);
	
	public static ItemStack FrostShard = new ItemStack(ModItems.SynthesisMaterial, 1);
	public static ItemStack FrostStone = new ItemStack(ModItems.SynthesisMaterial, 1);
	public static ItemStack FrostGem = new ItemStack(ModItems.SynthesisMaterial, 1);
	public static ItemStack FrostCrystal = new ItemStack(ModItems.SynthesisMaterial, 1);
	
	public static ItemStack LightningShard = new ItemStack(ModItems.SynthesisMaterial, 1);
	public static ItemStack LightningStone = new ItemStack(ModItems.SynthesisMaterial, 1);
	public static ItemStack LightningGem = new ItemStack(ModItems.SynthesisMaterial, 1);
	public static ItemStack LightningCrystal = new ItemStack(ModItems.SynthesisMaterial, 1);
	
	public static ItemStack LucidShard = new ItemStack(ModItems.SynthesisMaterial, 1);
	public static ItemStack LucidStone = new ItemStack(ModItems.SynthesisMaterial, 1);
	public static ItemStack LucidGem = new ItemStack(ModItems.SynthesisMaterial, 1);
	public static ItemStack LucidCrystal = new ItemStack(ModItems.SynthesisMaterial, 1);
	
	public static ItemStack PowerShard = new ItemStack(ModItems.SynthesisMaterial, 1);
	public static ItemStack PowerStone = new ItemStack(ModItems.SynthesisMaterial, 1);
	public static ItemStack PowerGem = new ItemStack(ModItems.SynthesisMaterial, 1);
	public static ItemStack PowerCrystal = new ItemStack(ModItems.SynthesisMaterial, 1);
	
	public static ItemStack DarkShard = new ItemStack(ModItems.SynthesisMaterial, 1);
	public static ItemStack DarkStone = new ItemStack(ModItems.SynthesisMaterial, 1);
	public static ItemStack DarkGem = new ItemStack(ModItems.SynthesisMaterial, 1);
	public static ItemStack DarkCrystal = new ItemStack(ModItems.SynthesisMaterial, 1);
	
	public static ItemStack DenseShard = new ItemStack(ModItems.SynthesisMaterial, 1);
	public static ItemStack DenseStone = new ItemStack(ModItems.SynthesisMaterial, 1);
	public static ItemStack DenseGem = new ItemStack(ModItems.SynthesisMaterial, 1);
	public static ItemStack DenseCrystal = new ItemStack(ModItems.SynthesisMaterial, 1);
	
	public static ItemStack TwilightShard = new ItemStack(ModItems.SynthesisMaterial, 1);
	public static ItemStack TwilightStone = new ItemStack(ModItems.SynthesisMaterial, 1);
	public static ItemStack TwilightGem = new ItemStack(ModItems.SynthesisMaterial, 1);
	public static ItemStack TwilightCrystal = new ItemStack(ModItems.SynthesisMaterial, 1);
	
	public static ItemStack MythrilShard = new ItemStack(ModItems.SynthesisMaterial, 1);
	public static ItemStack MythrilStone = new ItemStack(ModItems.SynthesisMaterial, 1);
	public static ItemStack MythrilGem = new ItemStack(ModItems.SynthesisMaterial, 1);
	public static ItemStack MythrilCrystal = new ItemStack(ModItems.SynthesisMaterial, 1);
	
	public static ItemStack BrightShard = new ItemStack(ModItems.SynthesisMaterial, 1);
	public static ItemStack BrightStone = new ItemStack(ModItems.SynthesisMaterial, 1);
	public static ItemStack BrightGem = new ItemStack(ModItems.SynthesisMaterial, 1);
	public static ItemStack BrightCrystal = new ItemStack(ModItems.SynthesisMaterial, 1);
	
	public static ItemStack EnergyShard = new ItemStack(ModItems.SynthesisMaterial, 1);
	public static ItemStack EnergyStone = new ItemStack(ModItems.SynthesisMaterial, 1);
	public static ItemStack EnergyGem = new ItemStack(ModItems.SynthesisMaterial, 1);
	public static ItemStack EnergyCrystal = new ItemStack(ModItems.SynthesisMaterial, 1);
	
	public static ItemStack SerenityShard = new ItemStack(ModItems.SynthesisMaterial, 1);
	public static ItemStack SerenityStone = new ItemStack(ModItems.SynthesisMaterial, 1);
	public static ItemStack SerenityGem = new ItemStack(ModItems.SynthesisMaterial, 1);
	public static ItemStack SerenityCrystal = new ItemStack(ModItems.SynthesisMaterial, 1);
	
	public static ItemStack Oricalcum = new ItemStack(ModItems.SynthesisMaterial, 1);
	public static ItemStack OricalcumPlus = new ItemStack(ModItems.SynthesisMaterial, 1);

	public static ItemStack RemembranceShard = new ItemStack(ModItems.SynthesisMaterial, 1);
	public static ItemStack RemembranceStone = new ItemStack(ModItems.SynthesisMaterial, 1);
	public static ItemStack RemembranceGem = new ItemStack(ModItems.SynthesisMaterial, 1);
	public static ItemStack RemembranceCrystal = new ItemStack(ModItems.SynthesisMaterial, 1);
	
	public static ItemStack TranquilShard = new ItemStack(ModItems.SynthesisMaterial, 1);
	public static ItemStack TranquilStone = new ItemStack(ModItems.SynthesisMaterial, 1);
	public static ItemStack TranquilGem = new ItemStack(ModItems.SynthesisMaterial, 1);
	public static ItemStack TranquilCrystal = new ItemStack(ModItems.SynthesisMaterial, 1);
	
	public static ItemStack ManifestIllusion = new ItemStack(ModItems.SynthesisMaterial, 1);
	public static ItemStack LostIllusion = new ItemStack(ModItems.SynthesisMaterial, 1);
	
	public void createSynthesisItem(ItemStack stack, String material, String rank){
		stack.setTagCompound(new NBTTagCompound());
		stack.getTagCompound().setString("material", material);
		stack.getTagCompound().setString("rank", rank);
	}
}
