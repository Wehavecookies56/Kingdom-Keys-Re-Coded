package wehavecookies56.kk.item;

import java.text.DecimalFormat;
import java.util.List;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemRecord;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import wehavecookies56.kk.lib.Reference;
import wehavecookies56.kk.lib.Strings;
import wehavecookies56.kk.util.TextHelper;

public class ItemKKRecord extends ItemRecord {

	float length;

	protected ItemKKRecord (String recordName, String name, CreativeTabs tab, float length) {
		super(recordName);
		setUnlocalizedName(name);
		setCreativeTab(tab);
		this.length = length;
	}

	@Override
	public ResourceLocation getRecordResource (String name) {
		return new ResourceLocation(Reference.MODID, name);
	}

	@Override
	public void addInformation (ItemStack stack, EntityPlayer playerIn, List tooltip, boolean advanced) {
		super.addInformation(stack, playerIn, tooltip, advanced);
		DecimalFormat df = new DecimalFormat();
		df.setMaximumFractionDigits(2);
		String length = String.format("%.02f", this.length).replace("f", "").replace("F", "").replace(".", ":");
		tooltip.add(TextHelper.localize(Strings.Disc_Duration_Desc) + ": " + length + " " + TextHelper.localize(Strings.Disc_DurationUnits_Desc));
	}

}
