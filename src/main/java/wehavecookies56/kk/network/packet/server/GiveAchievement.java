package wehavecookies56.kk.network.packet.server;

import java.io.IOException;

import io.netty.buffer.ByteBuf;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.network.PacketBuffer;
import net.minecraft.stats.Achievement;
import net.minecraft.util.IChatComponent;
import net.minecraftforge.fml.common.network.ByteBufUtils;
import net.minecraftforge.fml.relauncher.Side;
import wehavecookies56.kk.achievements.ModAchievements;
import wehavecookies56.kk.network.packet.AbstractMessage.AbstractServerMessage;
import wehavecookies56.kk.util.AchievementHelper;

public class GiveAchievement extends AbstractServerMessage<GiveAchievement> {

	IChatComponent achievement;

	public GiveAchievement() {}

	public GiveAchievement(IChatComponent achievement){
		this.achievement = achievement;
	}

	@Override
	protected void read(PacketBuffer buffer) throws IOException {
		achievement = buffer.readChatComponent();

	}

	@Override
	protected void write(PacketBuffer buffer) throws IOException {
		buffer.writeChatComponent(achievement);

	}

	@Override
	public void process(EntityPlayer player, Side side) {
		if(achievement.equals(ModAchievements.openMenu.getStatName())){
			AchievementHelper.addAchievement(player, ModAchievements.openMenu);
		}

	}

}
