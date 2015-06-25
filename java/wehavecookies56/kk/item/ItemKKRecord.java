package wehavecookies56.kk.item;

import java.util.List;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;

import wehavecookies56.kk.lib.Reference;
import net.minecraft.client.Minecraft;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemRecord;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;

public class ItemKKRecord extends ItemRecord {

	float length;
	
	protected ItemKKRecord(String recordName, String name, CreativeTabs tab, float length) {
		super(recordName);
		this.setUnlocalizedName(name);
		this.setCreativeTab(tab);
		this.length = length;
	}
	
	@Override
	public ResourceLocation getRecordResource(String name) {
		return new ResourceLocation(Reference.MODID, name);
	}
	
	@Override
	public void addInformation(ItemStack stack, EntityPlayer playerIn, List tooltip, boolean advanced) {
		super.addInformation(stack, playerIn, tooltip, advanced);
		String length = Float.toString(this.length).replace("f", "").replace("F", "").replace(".", ":");
		tooltip.add("Duration: " + length + " (mins:secs)");
	}

}
