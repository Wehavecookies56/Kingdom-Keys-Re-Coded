package uk.co.wehavecookies56.kk.common.item.base;

import java.text.DecimalFormat;
import java.util.List;

import net.minecraft.block.BlockJukebox;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemRecord;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.StatList;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import uk.co.wehavecookies56.kk.common.achievement.ModAchievements;
import uk.co.wehavecookies56.kk.common.core.helper.AchievementHelper;
import uk.co.wehavecookies56.kk.common.lib.Reference;
import uk.co.wehavecookies56.kk.common.lib.Strings;
import uk.co.wehavecookies56.kk.common.util.Utils;

public class ItemKKRecord extends ItemRecord {

	float length;

	public ItemKKRecord (SoundEvent sound, String name, CreativeTabs tab, float length) {
		super(name, sound);
		setUnlocalizedName(name);
		setCreativeTab(tab);
		this.length = length;
	}

	@Override
	public ResourceLocation getRecordResource (String name) {
		return new ResourceLocation(Reference.MODID, name);
	}

	@Override
	public EnumActionResult onItemUse(EntityPlayer player, World world, BlockPos pos, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ)
	{
		IBlockState iblockstate = world.getBlockState(pos);
        if (iblockstate.getBlock() == Blocks.JUKEBOX && !((Boolean)iblockstate.getValue(BlockJukebox.HAS_RECORD)).booleanValue())
        {
        	if (!world.isRemote) {
                ((BlockJukebox)Blocks.JUKEBOX).insertRecord(world, pos, iblockstate, player.getActiveItemStack());
                world.playEvent((EntityPlayer)null, 1010, pos, Item.getIdFromItem(this));
                player.getActiveItemStack().shrink(1);
                player.addStat(StatList.RECORD_PLAYED);
                AchievementHelper.addAchievement(player, ModAchievements.playMusicDisc);
            }
            return EnumActionResult.SUCCESS;
        }
        else
        	return EnumActionResult.PASS;
	}

	@Override
	public void addInformation (ItemStack stack, EntityPlayer playerIn, List<String> tooltip, boolean advanced) {
		super.addInformation(stack, playerIn, tooltip, advanced);
		DecimalFormat df = new DecimalFormat();
		df.setMaximumFractionDigits(2);
		String length = String.format("%.02f", this.length).replace("f", "").replace("F", "").replace(".", ":");
		tooltip.add(Utils.translateToLocal(Strings.Disc_Duration_Desc) + ": " + length + " " + Utils.translateToLocal(Strings.Disc_DurationUnits_Desc));
	}
}
