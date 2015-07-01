package wehavecookies56.kk.entities;

import java.util.ArrayList;
import java.util.List;

import wehavecookies56.kk.item.ItemStacks;
import wehavecookies56.kk.item.ModItems;

import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.util.Constants;

public class TileEntitySynthesisTable extends TileEntity {

	public List<String> materials = new ArrayList<String>();
	public List<Integer> amount = new ArrayList<Integer>();
	
	public TileEntitySynthesisTable() {
		ItemStack BlazingShard = new ItemStack(ModItems.SynthesisMaterial, 1);
		ItemStacks.createSynthesisItem(BlazingShard, "Blazing Shard", "C");
		materials.add(BlazingShard.getTagCompound().getString("material"));
		amount.add(BlazingShard.stackSize);
		ItemStack BlazingStone = new ItemStack(ModItems.SynthesisMaterial, 3);
		ItemStacks.createSynthesisItem(BlazingStone, "Blazing Shard", "C");
		materials.add(BlazingStone.getTagCompound().getString("material"));
		amount.add(BlazingStone.stackSize);
	}
	
	@Override
	public void writeToNBT(NBTTagCompound compound) {
		super.writeToNBT(compound);
		NBTTagList tagList = new NBTTagList();
		for(int i = 0; i < materials.size(); i++){
			String s = materials.get(i);
			Integer j = amount.get(i);
			if(s != null && j != null){
				NBTTagCompound tag = new NBTTagCompound();
				tag.setString("Material" + i, s);
				tag.setInteger("Amount" + i, j);
				tagList.appendTag(tag);
			}
		}
		compound.setTag("MaterialsList", tagList);
	}

	@Override
	public void readFromNBT(NBTTagCompound compound) {
		super.readFromNBT(compound);
		NBTTagList tagList = compound.getTagList("MaterialsList", Constants.NBT.TAG_COMPOUND);
		for(int i = 0; i < tagList.tagCount(); i++){
			NBTTagCompound tag = tagList.getCompoundTagAt(i);
			String s = tag.getString("Materials" + i);
			Integer j = tag.getInteger("Amount" + i);
			materials.add(i, s);
			amount.add(i, j);
			System.out.println("Loaded String from NBT: " + tag.getString("Materials" + i) + "x" + tag.getInteger("Amount" + i));
		}
	}
}
