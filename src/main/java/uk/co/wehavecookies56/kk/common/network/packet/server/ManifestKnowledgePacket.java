package uk.co.wehavecookies56.kk.common.network.packet.server;

import java.io.IOException;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.network.PacketBuffer;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.util.text.TextFormatting;
import net.minecraftforge.fml.relauncher.Side;
import uk.co.wehavecookies56.kk.common.achievement.ModAchievements;
import uk.co.wehavecookies56.kk.common.core.helper.AchievementHelper;
import uk.co.wehavecookies56.kk.common.lib.Lists;
import uk.co.wehavecookies56.kk.common.lib.Strings;
import uk.co.wehavecookies56.kk.common.network.packet.AbstractMessage;
import uk.co.wehavecookies56.kk.common.util.Utils;

public class ManifestKnowledgePacket extends AbstractMessage.AbstractServerMessage<ManifestKnowledgePacket> {

	public ManifestKnowledgePacket () {}

	@Override
	protected void read (PacketBuffer buffer) throws IOException {

	}

	@Override
	protected void write (PacketBuffer buffer) throws IOException {

	}

	@Override
	public void process (EntityPlayer player, Side side) {
		player.inventory.setInventorySlotContents(player.inventory.currentItem, ItemStack.EMPTY);
		int rand = Utils.randomWithRange(0, Lists.orgWeapons.size() - 1);
		player.inventory.addItemStackToInventory(new ItemStack(Lists.orgWeapons.get(rand)));
		TextComponentTranslation manifestMessage = new TextComponentTranslation(Strings.Chat_Manifest, new TextComponentTranslation(Lists.orgWeapons.get(rand).getUnlocalizedName() + ".name"));
		manifestMessage.getStyle().setColor(TextFormatting.YELLOW);
		player.sendMessage(manifestMessage);
    	AchievementHelper.addAchievement(player, ModAchievements.getOrgWeapon);
	}

}
